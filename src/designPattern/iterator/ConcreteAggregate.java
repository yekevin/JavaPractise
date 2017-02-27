package designPattern.iterator;

/**
 * @author Kevin
 * @description
 * @date 2017/2/23
 */
public class ConcreteAggregate extends Aggregate {

    private String[] arr;

    public ConcreteAggregate(String[] arr) {
        this.arr = arr;
    }

    @Override
    public Iterator createIterator() {
        return new ConcreteIterator(this);
    }

    public int size() {
        if (arr == null) {
            return 0;
        }
        return arr.length;
    }

    public Object get(int index) {
        return arr[index];
    }
}
