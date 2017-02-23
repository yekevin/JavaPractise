package designPattern.builder;

/**
 * @author Kevin
 * @description 将复杂的构建过程与表现分离，使得同样的构建过程可以创建不同的表示
 * @date 2017/2/11
 */
public class Client {
    public static void main(String[] args) {
        MealBuilder mealBuilder = new MealBuilder();
        Meal meal = mealBuilder.prepareVegMeal();
        meal.showItems();
        System.out.println(meal.getCost());

        meal = mealBuilder.prepareNoneVegMeal();
        meal.showItems();
        System.out.println(meal.getCost());
    }
}
