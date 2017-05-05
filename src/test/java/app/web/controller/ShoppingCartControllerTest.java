package app.web.controller;

import app.web.dto.ShoppingCart;
import app.web.service.ShoppingCartService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.security.Principal;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by Gabriel on 05.05.2017.
 */
public class ShoppingCartControllerTest {

    private Principal principal;
    private ShoppingCartService service;
    private ShoppingCart cart;
    private MockMvc mockMvc;

    @Before
    public void setUp() {
        principal = mock(Principal.class);
        when(principal.getName()).thenReturn("username");

        service = mock(ShoppingCartService.class);
        cart = mock(ShoppingCart.class);

        ShoppingCartController controller = new ShoppingCartController(service);
        mockMvc = standaloneSetup(controller).build();
    }

    @Test
    public void getCart() throws Exception {
        when(service.makeShoppingCart("username")).thenReturn(cart);

        mockMvc.perform(get("/cart")
                .principal(principal))
                .andExpect(model().attribute("cart", cart))
                .andExpect(view().name("shoppingCart"));
    }

    @Test
    public void updateCartWithReferer() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = makeRequestBuilder();
        String redirectedUrl = "/urlToRedirect";
        requestBuilder.header("Referer", redirectedUrl);

        mockMvc.perform(requestBuilder)
                .andExpect(redirectedUrl(redirectedUrl));
    }

    @Test
    public void updateCartWithNoReferer() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = makeRequestBuilder();

        mockMvc.perform(requestBuilder)
                .andExpect(view().name("/"));
    }

    private MockHttpServletRequestBuilder makeRequestBuilder() {
        return post("/cart")
                .param("bookid", "123")
                .param("quantity", "50")
                .principal(principal);
    }
}
