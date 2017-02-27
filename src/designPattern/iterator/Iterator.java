package designPattern.iterator;

/**
 * @author Kevin
 * @description
 * @date 2017/2/23
 */
public interface Iterator<E> {

    boolean hasNext();

    E next();

    void remove();
}
