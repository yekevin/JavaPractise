package designPattern.flyweight;

/**
 * @author Kevin
 * @description
 * @date 2017/2/16
 */
public interface Flyweight {

    /**
     *
     * @param securityEntry 安全实体
     * @param permit 权限
     * @return
     */
    public boolean match(String securityEntry,String permit);
}
