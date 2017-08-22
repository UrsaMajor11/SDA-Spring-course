package com.sda.SDASpringcourse.controller;

import com.sda.SDASpringcourse.repository.JpaUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by RENT on 2017-08-22.
 */

@Controller
public class TestController {

    @Autowired
    private JpaUserRepository repository;

    @GetMapping("/test")
    public ModelAndView getAll() {
        ModelAndView modelAndView = new ModelAndView("users");

        modelAndView.addObject("allUsers", repository.findAll());

        return modelAndView;
    }

}
