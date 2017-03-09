package ioc;

import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Kevin
 * @description
 * @date 2017/3/9
 */
public class SimpleContainer implements Container {

    // 保存所有bean对象 calssName : beanObject
    private Map<String, Object> beans;
    // 存储bean和name的关系 beanName : className
    private Map<String, String> beanKeys;

    public SimpleContainer() {
        this.beans = new ConcurrentHashMap();
        this.beanKeys = new ConcurrentHashMap();
    }

    @Override
    public <T> T getBean(Class<T> clazz) {
        String className = clazz.getName();
        Object object = beans.get(className);
        if (object != null) {
            return (T) object;
        }
        return null;
    }

    @Override
    public <T> T getBeanByName(String name) {
        String className = beanKeys.get(name);
        Object object = beans.get(className);
        if (object != null) {
            return (T) object;
        }
        return null;
    }

    @Override
    public Object registBean(Object bean) {
        String className = bean.getClass().getName();
        beanKeys.put(className, className);
        beans.put(className, bean);
        return bean;
    }

    @Override
    public Object registBean(Class<?> clazz) {
        String className = clazz.getName();
        Object bean = ReflectUtil.newInstance(clazz);
        beanKeys.put(className, className);
        beans.put(className, bean);
        return bean;
    }

    @Override
    public Object registBean(String name, Object bean) {
        String className = bean.getClass().getName();
        beanKeys.put(name, className);
        beans.put(className, bean);
        return bean;
    }

    @Override
    public void remove(Class<?> clazz) {
        String className = clazz.getClass().getName();
        if (null != className && !className.equals("")) {
            beanKeys.remove(className);
            beans.remove(className);
        }
    }

    @Override
    public void removeByName(String name) {
        String className = beanKeys.get(name);
        if (null != className && !className.equals("")) {
            beanKeys.remove(name);
            beans.remove(className);
        }
    }

    @Override
    public Set<String> getBeanNames() {
        return beanKeys.keySet();
    }

    @Override
    public void initWired() {
        Iterator<Map.Entry<String, Object>> it = beans.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Object> entry = it.next();
            Object bean = entry.getValue();
            injection(bean);
        }
    }

    /**
     * 注入对象
     *
     * @param bean
     */
    private void injection(Object bean) {
        Field[] fields = bean.getClass().getDeclaredFields();
        for (int i = 0, size = fields.length; i < size; i++) {
            // 有注入注解的field
            Field field = fields[i];
            Autowired autowired = field.getAnnotation(Autowired.class);
            if (autowired != null) {
                Object autowiredBean = null;
                String name = autowired.name();
                if (!"".equals(name)) {
                    String className = beanKeys.get(name);
                    if (null != className && !"".equals(name)) {
                        autowiredBean = beans.get(className);
                    }

                } else {
                    if (autowired.value() == Class.class) {
                        autowiredBean = recursiveAssembly(field.getType());
                    } else {
                        autowiredBean = this.getBean(autowired.value());
                        if (null == autowiredBean) {
                            autowiredBean = recursiveAssembly(autowired.value());
                        }
                    }
                }

                if (null == autowiredBean) {
                    throw new RuntimeException("Unable to load bean " + name);
                }

                try {
                    boolean accessible = field.isAccessible();
                    field.setAccessible(true);
                    field.set(bean, autowiredBean);
                    field.setAccessible(accessible);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private Object recursiveAssembly(Class<?> clazz) {
        if (null != clazz) {
            return this.registBean(clazz);
        }
        return null;
    }
}
