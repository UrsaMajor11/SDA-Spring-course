package com.sda.SDASpringcourse.controller;

import com.sda.SDASpringcourse.model.User;
import com.sda.SDASpringcourse.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(path = "/test/users") //to bedzie doklejonez przodku kazdej path przy endpoincie
public class UserController {

    @Autowired
    private UserRepository userRepository;

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

    @RequestMapping //dla sciezki "/test/users"
    public ModelAndView allUsers() {
        ModelAndView modelAndView = new ModelAndView("users");

        List<User> all = userRepository.getAll();

        modelAndView.addObject("allUsers", all);

        return modelAndView;
    }

    //3 - wyswietlenie wszystkich userow o nazwisku rozpoczynajacym sie od przekazanego parametru

    @RequestMapping(params = {"lastname"}) //dla sciezki "/test/users?lastname=cokolwiek"
    public ModelAndView allUsersByLastName(@RequestParam(value = "lastname") String lastname) {
        ModelAndView modelAndView = new ModelAndView("users");

        List<User> allByLastName = userRepository.getAllByLastName(lastname);

        modelAndView.addObject("allUsers", allByLastName);

        return modelAndView;
    }

    //4 - wyswietlenie usera o zadanym id (id pochodzi z listy userow z mocka) - analogiczne do pierwszego

    @RequestMapping(value = "/{userId}") //dla sciezki "/test/users/{userId}"
    public ModelAndView specifiedUser(@PathVariable("userId") Integer userId) {
        ModelAndView modelAndView = new ModelAndView("user");

        User user = userRepository.getById(userId);

        System.out.println(userId);
        modelAndView.addObject("user", user);

        return modelAndView;
    }



}