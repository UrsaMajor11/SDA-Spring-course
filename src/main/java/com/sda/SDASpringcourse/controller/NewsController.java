package com.sda.SDASpringcourse.controller;

import com.sda.SDASpringcourse.model.News;
import com.sda.SDASpringcourse.repository.JpaNewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by RENT on 2017-08-17.
 */

@Controller
@RequestMapping(path = "/news")
public class NewsController {

    @Autowired
    JpaNewsRepository newsRepository;


    //1 - wyswietlenie wszystkich newsow

    @GetMapping  //dla sciezki "/news"
    public ModelAndView allNews() {
        ModelAndView modelAndView = new ModelAndView("allNews");

        Iterable<News> all = newsRepository.findAll();

        modelAndView.addObject("allNews", all);

        return modelAndView;
    }

    //2 - wyswietlenie zadanego newsa po parametrze w adresie

    @GetMapping(value = "/{newsId}") //dla sciezki "/news/{id}"
    public ModelAndView newsById(@PathVariable("newsId") String newsId) {
        ModelAndView modelAndView = new ModelAndView("news");

        News byId = newsRepository.findOne(Integer.valueOf(newsId));

        modelAndView.addObject("singleNews", byId);

        return modelAndView;
    }

    //3 - usuniecie zadanego newsa po parametrze w adresie (metoda DELETE)

    @DeleteMapping(value = "/{newsId}")
    public @ResponseBody String deleteNewsByIdByDeleteMethod(@PathVariable("newsId") String newsId) {
        System.out.println("WSZEDLEM TUTAJ");
        newsRepository.delete(Integer.valueOf(newsId));


        System.out.println("PRZED REDIRECT");
        return "redirect:/news/";
    }

    //4 - usuniecie zadanego newsa po parametrze w adresie (metoda POST) (wersja prostrza endpointu 3)

    @PostMapping(value = "/{newsId}/delete")
    public String deleteNewsByIdByPostMethod(@PathVariable("newsId") String newsId) {

        newsRepository.delete(Integer.valueOf(newsId));

        return "redirect:/news/";
    }

}
