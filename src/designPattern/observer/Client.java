package designPattern.observer;

/**
 * @author Kevin
 * @description
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
