package designPattern.composite;

/**
 * @author Kevin
 * @description
 * @date 2017/2/15
 */
public class Leaf extends Component {
    /**
     * 叶子对象的名字
     */
    private String name = "";
    /**
     * 构造方法，传入叶子对象的名字
     * @param name 叶子对象的名字
     */
    public Leaf(String name){
        this.name = name;
    }

    @Override
    public void printStruct(String preStr) {
        System.out.println(preStr+"-"+name);
    }
}
