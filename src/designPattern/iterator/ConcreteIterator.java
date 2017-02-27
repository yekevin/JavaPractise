package designPattern.iterator;

/**
 * @author Kevin
 * @description
 * @date 2017/2/23
 */
public class ConcreteIterator implements Iterator {
    private ConcreteAggregate concreteAggregate;

    private int index = 0;

    public ConcreteIterator(ConcreteAggregate concreteAggregate) {
        this.concreteAggregate = concreteAggregate;
    }

    @Override
    public boolean hasNext() {
        return index < concreteAggregate.size();
    }

    @Override
    public Object next() {
        return concreteAggregate.get(index++);
    }

    @Override
    public void remove() {

    }
}
