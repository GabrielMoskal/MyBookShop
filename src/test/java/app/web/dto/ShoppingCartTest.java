package app.web.dto;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Gabriel on 30.04.2017.
 */
public class ShoppingCartTest {

    private ShoppingCart shoppingCart;
    private ShoppingCartItem item1, item2, item3;

    @Before
    public void setUp() {
        shoppingCart = new ShoppingCart();
        item1 = new ShoppingCartItem(1, "title1", 2);
        item2 = new ShoppingCartItem(2, "title2", 3);
        item3 = new ShoppingCartItem(3, "title3", 4);
        shoppingCart.putItem(item1);
        shoppingCart.putItem(item1);
    }

    @Test
    public void putItemChangesQuantityOfTheSameItem() {
        List<ShoppingCartItem> items = shoppingCart.getShoppingCartItems();
        int index = items.indexOf(item1);
        assertEquals(4, items.get(index).getQuantity());
    }

    @Test
    public void putsCorrectNumberOfItems() {
        shoppingCart.putItem(item2);
        shoppingCart.putItem(item3);
        List<ShoppingCartItem> items = shoppingCart.getShoppingCartItems();
        assertEquals(3, items.size());
    }
}
