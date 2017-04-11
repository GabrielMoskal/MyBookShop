package app.web.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gabriel on 11.04.2017.
 */
public class ShoppingCart {
    private List<ShoppingCartItem> shoppingCartItems;

    public ShoppingCart() {
        shoppingCartItems = new ArrayList<>();
    }

    public void putItem(ShoppingCartItem shoppingCartItem) {
        if (shoppingCartItems.contains(shoppingCartItem)) {
            int index = shoppingCartItems.indexOf(shoppingCartItem);
            ShoppingCartItem previousItem = shoppingCartItems.get(index);
            int quantity = previousItem.getQuantity();
            quantity += shoppingCartItem.getQuantity();
            shoppingCartItem.setQuantity(quantity);
        }
        shoppingCartItems.add(shoppingCartItem);
    }

    public List<ShoppingCartItem> getShoppingCartItems() {
        return this.shoppingCartItems;
    }
}
