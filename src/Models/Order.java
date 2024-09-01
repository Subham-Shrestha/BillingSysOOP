package Models;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private int id;
    private List<FoodOrder> foodOrders;

    public Order(int id) {
        this.id = id;
        this.foodOrders = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public List<FoodOrder> getFoodOrders() {
        return foodOrders;
    }

    public void addFoodOrder(FoodOrder foodOrder) {
        foodOrders.add(foodOrder);
    }

    public double calculateBill(double vat) {
        double total = 0;
        for (FoodOrder foodOrder : foodOrders) {
            Food food = foodOrder.getFood();
            double price = food.getPrice() * foodOrder.getQuantity();
            double discount = food.getCategory().getDiscount() * price / 100;
            total += price - discount;
        }
        total += total * vat / 100;
        return total;
    }
    public void printBill() {
        System.out.println("Order ID: " + getId());
        for (FoodOrder foodOrder : foodOrders) {
            Food food = foodOrder.getFood();
            System.out.println(food.getName() + " (" + food.getCategory().getName() + ") x " + foodOrder.getQuantity() + " = " + (food.getPrice() * foodOrder.getQuantity()));
        }
        System.out.println("Total: " + calculateBill(13));
    }
}

