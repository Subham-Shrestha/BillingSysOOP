import Models.Order;
import Models.Category;
import Models.Food;
import Models.FoodOrder;

public class Main {
    public static void main(String[] args) {

        Category foodCategory = new Category("Food", 10);
        Category drinksCategory = new Category("Drinks", 5);

        Food pizza = new Food("Pizza", foodCategory, 1000);
        Food burger = new Food("Burger", foodCategory, 800);
        Food coke = new Food("Coke", drinksCategory, 300);

        FoodOrder First = new FoodOrder(1, pizza, 2);
        FoodOrder Second = new FoodOrder(2, burger, 1);
        FoodOrder Third = new FoodOrder(3, coke, 3);

        Order order1 = new Order(1);
        order1.addFoodOrder(new FoodOrder(1, pizza, 2));
        order1.addFoodOrder(new FoodOrder(2, burger, 1));
        order1.addFoodOrder(new FoodOrder(3, coke, 3));

        order1.printBill();
    }
}