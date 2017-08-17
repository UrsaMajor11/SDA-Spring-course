package com.sda.SDASpringcourse.config;

import com.sda.SDASpringcourse.service.ReverseService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Created by RENT on 2017-08-16.
 */

@Configuration
//@Profile("dev")
public class ServiceConfig {

    //klasa do rejestrowania Beanów


    //drugi bean klasy ReverseService - tym razem tak skonfigurowany, zeby dodatkowo zamienial wielkosc liter
    //(pierwszy bean tej klasy zarejestrowalismy przy niej samej, adnotacją @Component)
    @Bean
    public ReverseService reverseWithSwapCaseService() {
        ReverseService reverseService = new ReverseService();
        reverseService.setMakeSwapCase(true);
        return reverseService;
    }

}
