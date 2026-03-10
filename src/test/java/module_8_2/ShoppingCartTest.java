package module_8_2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShoppingCartTest {
    @Test
    public void testAddItem() {
        ShoppingCart shoppingCart = new ShoppingCart();

        shoppingCart.addItem("Apple", 1.0);
        shoppingCart.addItem("Banana", 0.5);

        assertEquals(2, shoppingCart.getItemCount());
    }

    @Test
    public void testRemoveItem() {
        ShoppingCart shoppingCart = new ShoppingCart();

        shoppingCart.addItem("Apple", 1.0);
        shoppingCart.addItem("Banana", 0.5);
        shoppingCart.removeItem("Apple");

        assertEquals(1, shoppingCart.getItemCount());
    }

    @Test
    public void testCalculateTotal() {
        ShoppingCart shoppingCart = new ShoppingCart();

        shoppingCart.addItem("Apple", 1.0);
        shoppingCart.addItem("Banana", 0.5);
        shoppingCart.addItem("Orange", 0.75);

        assertEquals(2.25, shoppingCart.calculateTotal(), 0.01);
    }
}