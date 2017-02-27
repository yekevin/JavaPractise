package designPattern.memento;

/**
 * @author Kevin
 * @description 在不破坏封装性的前提下，
 * 捕获一个对象的内部状态，并在该对象之外保存这个状态，
 * 这样就可以将对象恢复到原来保存的状态。
 * @date 2017/2/23
 */
public class Client {

    public static void main(String[] args) {
        FlowMock flowMock = new FlowMock("flowMockTest");
        flowMock.runPhaseOne();

        Memento memento = flowMock.createMemento();
        FlowMockCareTaker taker = new FlowMockCareTaker();
        taker.saveMemento(memento);

        flowMock.schema1();
        flowMock.setMemento(taker.retriveMemento());
        flowMock.schema2();
    }
}
