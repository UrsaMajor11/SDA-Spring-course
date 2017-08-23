package com.sda.SDASpringcourse.config;

import com.sda.SDASpringcourse.model.News;
import com.sda.SDASpringcourse.model.User;
import com.sda.SDASpringcourse.repository.JpaNewsRepository;
import com.sda.SDASpringcourse.repository.JpaUserRepository;
import com.sda.SDASpringcourse.service.ReverseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.annotation.PostConstruct;

/**
 * Created by RENT on 2017-08-16.
 */

@Configuration
//@Profile("dev")
public class ServiceConfig {

    //klasa do rejestrowania dodatkowych Beanów oraz do wrzucania do bazy poczatkowych danych

    @Autowired
    private JpaUserRepository userRepository;

    @Autowired
    JpaNewsRepository newsRepository;


    //drugi bean klasy ReverseService - tym razem tak skonfigurowany, zeby dodatkowo zamienial wielkosc liter
    //(pierwszy bean tej klasy zarejestrowalismy przy niej samej, adnotacją @Component)
    @Bean
    public ReverseService reverseWithSwapCaseService() {
        ReverseService reverseService = new ReverseService();
        reverseService.setMakeSwapCase(true);
        return reverseService;
    }

    //wrzucanie poczatkowych danych do bazy
    @PostConstruct
    public void init() {
        userRepository.save(new User("Bartek", "Mytko", "123456789"));
        userRepository.save(new User("Maria", "Mytko", "987654321"));
        userRepository.save(new User("Antek", "Mytko", "147258369"));

        News news0 = new News("Zamach w Barcelonie 0", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, " +
                "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. " +
                "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip " +
                "ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse " +
                "cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, " +
                "sunt in culpa qui officia deserunt mollit anim id est laborum.",
                "https://s17.postimg.org/6ecm74v27/barcelona-rutas-turisticas-alternativas.jpg",
                "https://s17.postimg.org/6ecm74v27/barcelona-rutas-turisticas-alternativas.jpg",
                userRepository.findOne(1));
        News news1 = new News("Zamach w Barcelonie 1", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, " +
                "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. " +
                "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip " +
                "ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse " +
                "cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, " +
                "sunt in culpa qui officia deserunt mollit anim id est laborum.",
                "https://s17.postimg.org/6ecm74v27/barcelona-rutas-turisticas-alternativas.jpg",
                "https://s17.postimg.org/6ecm74v27/barcelona-rutas-turisticas-alternativas.jpg",
                userRepository.findOne(3));
        News news2 = new News("Zamach w Barcelonie 2", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, " +
                "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. " +
                "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip " +
                "ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse " +
                "cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, " +
                "sunt in culpa qui officia deserunt mollit anim id est laborum.",
                "https://s17.postimg.org/6ecm74v27/barcelona-rutas-turisticas-alternativas.jpg",
                "https://s17.postimg.org/6ecm74v27/barcelona-rutas-turisticas-alternativas.jpg",
                userRepository.findOne(3));

        newsRepository.save(news0);
        newsRepository.save(news1);
        newsRepository.save(news2);
    }

}
