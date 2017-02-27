package designPattern.iterator;

/**
 * @author Kevin
 * @description 提供一种方法顺序访问一个聚合对象中各个元素，
 * 而有不需要暴露改对象的内部表示。
 * @date 2017/2/23
 */
public class Client {

    public static void main(String[] args) {
        String[] arr = new String[]{"1", "2", "3"};
        ConcreteAggregate concreteAggregate = new ConcreteAggregate(arr);
        Iterator<String> iterator = concreteAggregate.createIterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
