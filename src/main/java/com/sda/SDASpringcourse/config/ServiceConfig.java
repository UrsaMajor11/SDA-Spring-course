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

    @Bean
    public ReverseService reverseServiceUppercaseOnly() {
        ReverseService reverseService = new ReverseService();
        reverseService.setUppercase(true);
        reverseService.setLowercase(false);
        return reverseService;
    }

}
