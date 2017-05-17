package app.web.controller;

import app.web.service.BooksService;
import app.web.service.CategoriesServiceImpl;
import app.web.service.NavigationButtonsServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.mock;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by Gabriel on 04.05.2017.
 */
public class CategoriesControllerTest {
    private MockMvc mockMvc;

    @Before
    public void setUp() {
        CategoriesServiceImpl categoriesService = mock(CategoriesServiceImpl.class);
        NavigationButtonsServiceImpl buttonsService = mock(NavigationButtonsServiceImpl.class);
        BooksService booksService = mock(BooksService.class);
        CategoriesController categoriesController =
                new CategoriesController(categoriesService, buttonsService, booksService);
        mockMvc = standaloneSetup(categoriesController)
                .build();
    }

    @Test
    public void categoryRedirect() throws Exception {
        mockMvc.perform(get("/category")
                .param("categoryUrl", "free-book")
                .param("categoryName", "free book"))
                .andExpect(redirectedUrl("/category/free-book?categoryName=free+book"));
    }

    @Test
    public void showCategory() throws Exception {
        mockMvc.perform(get("/category/free-book")
                .param("categoryName", "free book"))
                .andExpect(model().attributeExists("books"))
                .andExpect(model().attributeExists("categories"))
                .andExpect(model().attributeExists("categoryName"))
                .andExpect(model().attributeExists("navigationButtons"))
                .andExpect(view().name("category"));
    }
}
