package genericity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Kevin
 * @description
 * @date 2017/3/30
 */
class Food {
}

class Fruit extends Food {
}

class Apple extends Fruit {
}

public class UseSceneTest {

    /**
     * 边界通配符总结
     * 如果你想从一个数据类型里获取数据，使用 ? extends 通配符
     * 如果你想把对象写入一个数据结构里，使用 ? super 通配符
     * 如果你既想存，又想取，那就别用通配符。
     */

    // 使用通配符
    // 1、只能添加null。
    // 2、获取的值只能赋值给Object类型。
    // 因为通配符？表示该集合存储的元素类型未知，可以是任何类型。往集合中加入元素需要是一个未知元素类型的子类型，
    // 正因为该集合存储的元素类型未知，所以我们没法向该集合中添加任何元素。唯一的例外是null，因为null是所有类型的子类型，
    // 所以尽管元素类型不知道，但是null一定是它的子类型。
    public void useWildcard() {
        List<?> list = new ArrayList<Fruit>();
        // 以下三行编译错误
        /*
        list.add(new Apple());
        list.add(new Fruit());
        list.add(new Food());
        */

        list.add(null);

        // 以下三行编译错误
        /*
        Food food = list.get(0);
        Fruit fruit = list.get(0);
        Apple apple = list.get(0);
        */

        Object object = list.get(0);
    }

    // 使用带上界的通配符,一般用于读取场景
    // 1、为泛型指定的类型只能是Fruit类型或者其子类。
    // 2、只能为其列表添加null。
    // 3、get方法获取的值只能赋值给Fruit类或者其超类。
    public void useUpperBoundWildcard() {
        // 超出了上界,编译错误
//        List<? extends Fruit> foods = new ArrayList<Food>();
        List<? extends Fruit> fruits = new ArrayList<Fruit>();
        List<? extends Fruit> apples = new ArrayList<Apple>();

        apples.add(null);
        Food food = apples.get(0);
        Fruit fruit = apples.get(0);

        // 编译错误
//        Apple apple = apples.get(0);

    }

    // 使用带下界的通配符,一般用于写入的场景
    // 1、为泛型指定的类型必须为Fruit，或者其超类。
    // 2、可以为其列表添加任意Fruit类型，或者其子类。
    // 3、get方法获取的类型，只能赋值给Object类型。
    public void useLowerBoundWildcard() {
        List<? super Fruit> foods = new ArrayList<Food>();
        List<? super Fruit> fruits = new ArrayList<Fruit>();
        // 编译错误
//        List<? super Fruit> apples = new ArrayList<Apple>();

        // 编译错误,不能为父类
//        foods.add(new Food());
        foods.add(new Fruit());
        foods.add(new Apple());

        // 编译错误
        /*
        Food food = foods.get(0);
        Fruit fruit = foods.get(0);
        Apple apple = foods.get(0);
        */
        Object o = foods.get(0);
    }

    // 类型擦除
    // 所有泛型类的实例都共享同一个运行时类，类型参数信息会在编译时被擦除。
    // 因此考虑如下代码，虽然ArrayList和ArrayList类型参数不同，但是他们都共享ArrayList类，所以结果会是true
    public void typeWipe() {
        List<String> strings = new ArrayList<>();
        List<Integer> integers = new ArrayList<>();
        // true
        System.out.println(strings.getClass() == integers.getClass());
    }

    // 不能对确切的泛型类型使用instanceOf操作。如下面的操作是非法的，编译时会出错。
    public void instanceOfType() {
        Collection cs = new ArrayList();
        // 编译错误
        /*
        if(cs instanceof Collection<String>){

        }
        */

    }

    // 泛型数组
    public void genericArray() {
        // 不能创建一个确切泛型类型的数组。
//        List<String>[] array = new ArrayList<String>[10];

        // 可以创建一个带通配符的泛型数组
        List<?>[] array = new ArrayList<?>[10];
    }
}

