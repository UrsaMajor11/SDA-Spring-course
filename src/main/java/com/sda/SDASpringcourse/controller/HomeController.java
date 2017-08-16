package com.sda.SDASpringcourse.controller;

import com.sda.SDASpringcourse.model.User;
import com.sda.SDASpringcourse.repository.UserRepository;
import com.sda.SDASpringcourse.service.ReverseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by RENT on 2017-08-16.
 */

@Controller
public class HomeController {

    @Autowired
    private ReverseService reverseService;

    @Autowired
    private ReverseService reverseServiceUppercaseOnly;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(path = "/home")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("index");
        System.out.println("home method");

        modelAndView.addObject("firstName", "Bartek");
        modelAndView.addObject("phoneNumber", "5085637890");

        return modelAndView;
    }

    @RequestMapping(path = "/home", params = {"s"})
    public ModelAndView home(@RequestParam(value = "s", required = true) String s) {
        ModelAndView modelAndView = new ModelAndView("index");

        String reversedString = reverseService.reverseString(s);

        System.out.println(reversedString);
        modelAndView.addObject("reversedString", reversedString);

        return modelAndView;
    }

    @RequestMapping(path = "/home", params = {"s", "lowercase"})
    //musi przyjscparametr lowercase, ale jego wartosc nas nie interesuje
    public ModelAndView homeLowerCase(@RequestParam(value = "s", required = true) String s) {
        ModelAndView modelAndView = new ModelAndView("index");

        String reversedString = reverseServiceUppercaseOnly.reverseString(s);

        System.out.println(reversedString);
        modelAndView.addObject("reversedString", reversedString);

        return modelAndView;
    }

    @RequestMapping(value = "/home/{value}") //przekazywanie parametru inna metoda
    public ModelAndView homeParam(@PathVariable("value") String param) {
        ModelAndView modelAndView = new ModelAndView("index");

        System.out.println(param);
        modelAndView.addObject("reversedString", param);

        return modelAndView;
    }

    @RequestMapping(value = "/user/{userId}") //przekazywanie parametru inna metoda
    public ModelAndView userParam(@PathVariable("userId") Integer userId) {
        ModelAndView modelAndView = new ModelAndView("index");

        User user = userRepository.getById(userId);

        System.out.println(userId);
        modelAndView.addObject("user", user);

        return modelAndView;
    }
}
