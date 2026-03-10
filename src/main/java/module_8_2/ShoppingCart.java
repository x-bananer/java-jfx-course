package module_8_2;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private Map<String, Double> items = new HashMap<>();

    public void addItem(String name, double price) {
        items.put(name, price);
    }

    public void removeItem(String name) {
        items.remove(name);
    }

    public int getItemCount() {
        return items.size();
    }

    public double calculateTotal() {
        double total = 0.0;

        for (double price : items.values()) {
            total += price;
        }

        return total;
    }
}
