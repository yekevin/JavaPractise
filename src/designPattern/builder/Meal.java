package designPattern.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kevin
 * @description
 * @date 2017/2/11
 */
public class Meal {
    private List<Item> items = new ArrayList<>();

    public float getCost() {
        float cost = 0.0f;
        for (int i = 0; i < items.size(); i++) {
            cost += items.get(i).price();
        }
        return cost;
    }

    public void showItems(){
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            System.out.println(item.packing().pack() + " " + item.name() + " cost " + item.price());
        }
    }

    public List<Item> getItems() {
        return items;
    }

    public void addItem(Item item) {
        items.add(item);
    }

}
