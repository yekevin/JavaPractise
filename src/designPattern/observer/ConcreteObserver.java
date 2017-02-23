package designPattern.observer;

/**
 * @author Kevin
 * @description
 * @date 2017/2/15
 */
public class ConcreteObserver implements Observer {
    private String name;

    public ConcreteObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(Subject subject) {
        String state = ((ConcreteSubject) subject).getSubjectState();
        System.out.println("observer " + name + " state1 chage to = " + state);
    }
}
