package com.sda.SDASpringcourse.controller;

import com.sda.SDASpringcourse.service.ReverseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
    private ReverseService reverseWithSwapCaseService;

    //1 - prosty endpoint, wyswietlamy html-a i przesylamy dwie zmienne

    @GetMapping(path = "/home")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("index");
        System.out.println("home method");

        modelAndView.addObject("firstName", "Bartek");
        modelAndView.addObject("phoneNumber", "5085637890");

        return modelAndView;
    }

    //2 - endpoint z parametrem o nazwie "s", po przejsciu w przegladarce pod taka sciezke powinnismy otrzymac odwrocony string

    @GetMapping(path = "/home", params = {"s"})
    public ModelAndView home(@RequestParam(value = "s", required = true) String s) {
        ModelAndView modelAndView = new ModelAndView("index");

        String reversedString = reverseService.reverseString(s);

        System.out.println(reversedString);
        modelAndView.addObject("reversedString", reversedString);

        return modelAndView;
    }

    //2 - endpoint z parametrem o nazwie "s" i dodatkowym parametrem - flagą, po przejsciu w przegladarce pod taka sciezke powinnismy otrzymac odwrocony string z zamieniona wielkoscia liter

    @GetMapping(path = "/home", params = {"s", "swap"})
    //musi przyjsc parametr swap, ale jego wartosc nas nie interesuje, wiec nawet nie przekazujemy go do metody
    public ModelAndView homeSwitchCase(@RequestParam(value = "s", required = true) String s) {
        ModelAndView modelAndView = new ModelAndView("index");

        //teraz do odwrocenia stringa uzywam innego beana, ktory dodatkowo zamieni ielkosc liter
        String reversedString = reverseWithSwapCaseService.reverseString(s);

        System.out.println(reversedString);
        modelAndView.addObject("reversedString", reversedString);

        return modelAndView;
    }

    //3 - przyklad na inny sposob przekazywania parametrow do endpointu, poza tym ten przyklad jest analogiczny do endpointu 2

    @GetMapping(value = "/home/{value}")
    public ModelAndView homeParam(@PathVariable("value") String param) {
        ModelAndView modelAndView = new ModelAndView("index");

        String reversedString = reverseService.reverseString(param);

        System.out.println(reversedString);
        modelAndView.addObject("reversedString", reversedString);

        return modelAndView;
    }


}
