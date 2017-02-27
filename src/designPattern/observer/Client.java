package designPattern.observer;

/**
 * @author Kevin
 * @description 定义对象间的一种一对多的依赖关系，
 * 当一个对象的状态发生改变时，所有依赖与它的对象都得到通知并自动更新。
 * @date 2017/2/15
 */
public class Client {

    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();
        Observer observer1 = new ConcreteObserver("o1");
        Observer observer2 = new ConcreteObserver("o2");
        subject.attach(observer1);
        subject.attach(observer2);

        subject.setSubjectState("green");
    }
}
