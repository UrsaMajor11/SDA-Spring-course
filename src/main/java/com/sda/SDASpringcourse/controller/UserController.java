package com.sda.SDASpringcourse.controller;

import com.sda.SDASpringcourse.model.User;
import com.sda.SDASpringcourse.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/user/{userId}") //przekazywanie parametru inna metoda
    public ModelAndView userParam(@PathVariable("userId") Integer userId) {
        ModelAndView modelAndView = new ModelAndView("user");

        User user = userRepository.getById(userId);

        System.out.println(userId);
        modelAndView.addObject("user", user);

        return modelAndView;
    }

}
