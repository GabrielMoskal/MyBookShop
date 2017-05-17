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
public class CategoriesServiceImpl implements CategoriesService {

    private BooksRepository booksRepository;

    @Autowired
    public CategoriesServiceImpl(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    public Map<String, String> makeBooksCategories() {
        Map<String, String> result = new HashMap<>();
        List<String> booksCategories = booksRepository.retrieveCategoriesNames();
        booksCategories.forEach(bookCategory -> result.put(makeCategoryUrl(bookCategory), bookCategory));
        return result;
    }

    private String makeCategoryUrl(String concreteCategory) {
        String result = makeUrlFromConcreteCategory(concreteCategory);
        try {
            URLEncoder.encode(result, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    private String makeUrlFromConcreteCategory(String concreteCategory) {
        String result = concreteCategory.toLowerCase();
        result = StringUtils.stripAccents(result);

        /* StringUtils.stripAccents doesn't replace 'ł' so it must be done manually,
         * replace space with '-' too */
        return result.replace('ł', 'l')
                .replace(' ', '-');
    }
}
