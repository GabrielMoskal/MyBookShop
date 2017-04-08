package app.web.service;

import app.data.BooksRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Gabriel on 08.04.2017.
 */
@Service
public class CategoriesService {

    private BooksRepository booksRepository;

    @Autowired
    public CategoriesService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    public Map<String, String> makeBooksCategories() {
        List<String> booksCategories = booksRepository.retrieveCategoriesNames();
        Map<String, String> result = new HashMap<>();
        for (String bookCategory : booksCategories) {
            result.put(makeCategoryUrl(bookCategory), bookCategory);
        }
        return result;
    }

    private String makeCategoryUrl(final String concreteCategory) {
        String result = concreteCategory.toLowerCase();
        result = StringUtils.stripAccents(result);
        result = result.replace('ł', 'l')
                .replace(' ', '-');
        try {
            URLEncoder.encode(result, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
