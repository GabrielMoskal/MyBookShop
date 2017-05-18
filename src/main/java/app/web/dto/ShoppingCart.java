package app.web.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gabriel on 11.04.2017.
 */
@Getter
@ToString
@EqualsAndHashCode
public class ShoppingCart {

    private List<ShoppingCartItem> shoppingCartItems;

    public ShoppingCart() {
        shoppingCartItems = new ArrayList<>();
    }

    public void putItem(ShoppingCartItem item) {
        ShoppingCartItem itemToAdd = item;
        if (isItemAdded(item)) {
            /* if an item exists, remove it from the list and make a new object with updated quantity */
            ShoppingCartItem previouslyAddedItem = removePreviouslyAddedItem(item);
            itemToAdd = makeNewShoppingCartItem(item, previouslyAddedItem);
        }
        shoppingCartItems.add(itemToAdd);
    }

    private boolean isItemAdded(final ShoppingCartItem item) {
        return shoppingCartItems.contains(item);
    }

    private ShoppingCartItem removePreviouslyAddedItem(ShoppingCartItem item) {
        int index = shoppingCartItems.indexOf(item);
        return shoppingCartItems.remove(index);
    }

    private ShoppingCartItem makeNewShoppingCartItem(ShoppingCartItem toAdd, ShoppingCartItem previouslyAddedItem) {
        int id = previouslyAddedItem.getBookid();
        String title = previouslyAddedItem.getBookTitle();
        int quantity = previouslyAddedItem.getQuantity() + toAdd.getQuantity();
        return new ShoppingCartItem(id, title, quantity);
    }
}
