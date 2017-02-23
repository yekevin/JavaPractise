package designPattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kevin
 * @description
 * @date 2017/2/15
 */
public class Subject {

    private List<Observer> observerList = new ArrayList<>();

    // 注册观察者对象
    public void attach(Observer observer) {
        observerList.add(observer);
    }

    // 删除观察者对象
    public void detach(Observer observer) {
        observerList.remove(observer);
    }

    protected void notifyObservers() {
        for (Observer observer : observerList) {
            observer.update(this);
        }
    }
}
