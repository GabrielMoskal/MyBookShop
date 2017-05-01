package app.web.dto;

import com.google.common.testing.EqualsTester;
import org.junit.Test;

/**
 * Created by Gabriel on 01.05.2017.
 */
public class ShoppingCartItemTest {
    @Test
    public void equalsAndHashCode() {
        new EqualsTester()
                .addEqualityGroup(
                        new ShoppingCartItem(1, "title", 1),
                        new ShoppingCartItem(1, "title", 4))
                .addEqualityGroup(
                        new ShoppingCartItem(2, "title", 4),
                        new ShoppingCartItem(2, "title", 4))
                .addEqualityGroup(
                        new ShoppingCartItem(4, "other", 3),
                        new ShoppingCartItem(4, "other", 2))
                .testEquals();
    }
}
