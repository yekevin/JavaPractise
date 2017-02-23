package designPattern.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kevin
 * @description
 * @date 2017/2/15
 */
public class Composite extends Component {

    /**
     * 用来存储组合对象中包含的子组件对象
     */
    private List<Component> childComponents = null;
    /**
     * 组合对象的名字
     */
    private String name = "";

    /**
     * 构造方法，传入组合对象的名字
     *
     * @param name 组合对象的名字
     */
    public Composite(String name) {
        this.name = name;
    }

    public void addChild(Component child) {
        //延迟初始化
        if (childComponents == null) {
            childComponents = new ArrayList<Component>();
        }
        childComponents.add(child);
    }

    @Override
    public void printStruct(String preStr) {
        //先把自己输出去
        System.out.println(preStr + "+" + this.name);
        //如果还包含有子组件，那么就输出这些子组件对象
        if (this.childComponents != null) {
            //然后添加一个空格，表示向后缩进一个空格
            preStr += " ";
            //输出当前对象的子对象了
            for (Component c : childComponents) {
                //递归输出每个子对象
                c.printStruct(preStr);
            }
        }
    }
}
