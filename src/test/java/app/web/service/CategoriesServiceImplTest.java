package app.web.service;

import app.data.BooksRepository;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Gabriel on 17.05.2017.
 */
public class CategoriesServiceImplTest {

    @Test
    public void makeBooksCategories() {
        Map<String, String> expected = makeExpectedResult();

        BooksRepository repository = mock(BooksRepository.class);
        List<String> categoriesNames = makeCategoriesNames();
        when(repository.retrieveCategoriesNames()).thenReturn(categoriesNames);

        CategoriesService service = new CategoriesServiceImpl(repository);
        Map<String, String> result = service.makeBooksCategories();

        assertEquals(expected, result);
    }

    private Map<String, String> makeExpectedResult() {
        Map<String, String> expected = new HashMap<>();
        expected.put("komiks", "Komiks");
        expected.put("kuchnia-i-diety", "Kuchnia i diety");
        expected.put("zazolc-gesla-jazn", "Zażółć gęślą jaźń");
        return expected;
    }

    private List<String> makeCategoriesNames() {
        List<String> categoriesNames = new ArrayList<>();
        categoriesNames.add("Komiks");
        categoriesNames.add("Kuchnia i diety");
        categoriesNames.add("Zażółć gęślą jaźń");
        return categoriesNames;
    }
}
