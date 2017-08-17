package com.sda.SDASpringcourse.repository;

import com.sda.SDASpringcourse.model.News;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by RENT on 2017-08-17.
 */

@Component
public class MockNewsRepository implements NewsRepository {

    private List<News> allNews;

    public MockNewsRepository() {
        this.allNews = new ArrayList<>();
    }

    @Override
    public List<News> getAll() {
        return allNews;
    }

    @Override
    public News getById(Integer id) {
        return allNews.get(id);
    }

    @PostConstruct
    public void init() {
        News news0 = new News(0, "Zamach w Barcelonie 0", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, " +
                "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. " +
                "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip " +
                "ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse " +
                "cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, " +
                "sunt in culpa qui officia deserunt mollit anim id est laborum.",
                "https://s17.postimg.org/6ecm74v27/barcelona-rutas-turisticas-alternativas.jpg",
                "https://s17.postimg.org/6ecm74v27/barcelona-rutas-turisticas-alternativas.jpg",
                1);
        News news1 = new News(1, "Zamach w Barcelonie 1", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, " +
                "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. " +
                "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip " +
                "ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse " +
                "cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, " +
                "sunt in culpa qui officia deserunt mollit anim id est laborum.",
                "https://s17.postimg.org/6ecm74v27/barcelona-rutas-turisticas-alternativas.jpg",
                "https://s17.postimg.org/6ecm74v27/barcelona-rutas-turisticas-alternativas.jpg",
                3);
        News news2 = new News(2, "Zamach w Barcelonie 2", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, " +
                "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. " +
                "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip " +
                "ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse " +
                "cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, " +
                "sunt in culpa qui officia deserunt mollit anim id est laborum.",
                "https://s17.postimg.org/6ecm74v27/barcelona-rutas-turisticas-alternativas.jpg",
                "https://s17.postimg.org/6ecm74v27/barcelona-rutas-turisticas-alternativas.jpg",
                3);

        allNews.add(news0);
        allNews.add(news1);
        allNews.add(news2);
    }
}
