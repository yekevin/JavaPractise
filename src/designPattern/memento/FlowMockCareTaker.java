package designPattern.memento;

/**
 * @author Kevin
 * @description 负责保存备忘录的对象
 * @date 2017/2/23
 */
public class FlowMockCareTaker {
    private Memento memento;

    public void saveMemento(Memento memento) {
        this.memento = memento;
    }

    public Memento retriveMemento() {
        return this.memento;
    }

}
