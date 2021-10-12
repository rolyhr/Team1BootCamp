package testPOM;

import POM.Cart;
import org.testng.annotations.Test;

public class TestCart {

    Cart cart;

    @Test
    public void testAddItemToCart() {
        cart = new Cart();
        cart.addItemToCart();
    }
}
