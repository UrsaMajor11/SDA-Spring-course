package com.sda.SDASpringcourse.controller;

import com.sda.SDASpringcourse.model.CreationStatus;
import com.sda.SDASpringcourse.model.CreationStatusFactory;
import com.sda.SDASpringcourse.model.News;
import com.sda.SDASpringcourse.model.User;
import com.sda.SDASpringcourse.repository.NewsRepository;
import com.sda.SDASpringcourse.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(path = "/users") //to bedzie doklejonez przodku kazdej path przy endpoincie
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private NewsRepository newsRepository;

    @Autowired
    CreationStatusFactory creationStatusFactory;

    //1 - wyswietlenie usera o zadanym id (id pochodzi z listy userow z mocka)
/*
    @RequestMapping(value = "/user/{userId}") //przekazywanie parametru inna metoda
    public ModelAndView userParam(@PathVariable("userId") Integer userId) {
        ModelAndView modelAndView = new ModelAndView("user");

        User user = userRepository.getById(userId);

        System.out.println(userId);
        modelAndView.addObject("user", user);

        return modelAndView;
    }
*/
    //2 - wyswietlenie wszystkich userow

    @GetMapping //dla sciezki "/users"
    public ModelAndView allUsers() {
        ModelAndView modelAndView = new ModelAndView("users");

        List<User> all = userRepository.getAll();

        modelAndView.addObject("allUsers", all);

        return modelAndView;
    }

    //3 - wyswietlenie wszystkich userow o nazwisku rozpoczynajacym sie od przekazanego parametru

    @GetMapping(params = {"lastname"}) //dla sciezki "/users?lastname=cokolwiek"
    public ModelAndView allUsersByLastName(@RequestParam(value = "lastname") String lastname) {
        ModelAndView modelAndView = new ModelAndView("users");

        List<User> allByLastName = userRepository.getAllByLastName(lastname);

        modelAndView.addObject("allUsers", allByLastName);

        return modelAndView;
    }

    //4 - wyswietlenie usera o zadanym id (id pochodzi z listy userow z mocka) - analogiczne do pierwszego

    @GetMapping(value = "/{userId}") //dla sciezki "/users/{userId}"
    public ModelAndView specifiedUser(@PathVariable("userId") Integer userId) {
        ModelAndView modelAndView = new ModelAndView("user");

        User user = userRepository.getById(userId);
        List<News> userNewsList = newsRepository.getbyUserId(userId);

        System.out.println(userId);
        modelAndView.addObject("user", user);
        modelAndView.addObject("allNews", userNewsList);

        return modelAndView;
    }

    //5 - dodawanie nowego newsa z poziomu strony danego usera (metoda POST)

    @PostMapping(value = "/{userId}") //dla sciezki "/users/{userId}"
    public ModelAndView addNewsForUser(@ModelAttribute News news, @PathVariable("userId") Integer userId) {
        ModelAndView modelAndView = new ModelAndView("user");

        //tutaj odbywa sie dodanie newsa
        boolean result = newsRepository.add(news);

        User user = userRepository.getById(userId);
        List<News> userNewsList = newsRepository.getbyUserId(userId);

        CreationStatus status =
                result ? creationStatusFactory.createSuccessStatus("Poprawnie dodano nowy news...")
                        : creationStatusFactory.createFailureStatus("Wystąpił błąd podczas zapisywania newsa...");

        //wyslanie zmiennych na front
        modelAndView.addObject("status", status);
        modelAndView.addObject("user", user);
        modelAndView.addObject("allNews", userNewsList);

        return modelAndView;
    }

    //6 - dodawanie nowego usera z poziomu strony z lista wszystkich userow

    @PostMapping //dla sciezki "/users", tak jak w drugim enpoincie (metoda POST)
    public ModelAndView addNewUser(@ModelAttribute User user) {
        ModelAndView modelAndView = new ModelAndView("users");

        //tutaj odbywa sie dodanie usera
        boolean result = userRepository.add(user);

        CreationStatus status =
                result ? creationStatusFactory.createSuccessStatus("Poprawnie dodano nowego usera...")
                        : creationStatusFactory.createFailureStatus("Wystąpił błąd podczas zapisywania nowego usera...");

        List<User> all = userRepository.getAll();

        //wyslanie zmiennych na front
        modelAndView.addObject("status", status);
        modelAndView.addObject("allUsers", all);

        return modelAndView;
    }

}
