package designPattern.decorator;

/**
 * @author Kevin
 * @description 动态的给一个对象添加一些额外的职责，就增加功能来说，装饰器模式比生成子类更加灵活
 * @date 2017/2/14
 */
public class Client {

    public static void main(String[] args) {
        Component c = new ConcreteComponent();
        Component component = new GroupPrizeDecorator(new MonthPrizeDecorator(c));
        double money = component.calcPrize("张三", null, null);
        System.out.println("张三应得奖金 " + money);

        money = component.calcPrize("李四", null, null);
        System.out.println("李四应得奖金 " + money);

        money = component.calcPrize("王五", null, null);
        System.out.println("王五应得奖金 " + money);
    }
}
