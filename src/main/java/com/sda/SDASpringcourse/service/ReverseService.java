package com.sda.SDASpringcourse.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

/**
 * Created by RENT on 2017-08-16.
 */

@Component
public class ReverseService {

    private boolean uppercase;
    private boolean lowercase;

    public void setUppercase(boolean uppercase) {
        this.uppercase = uppercase;
    }

    public void setLowercase(boolean lowercase) {
        this.lowercase = lowercase;
    }

    public String reverseString(String input) {

        if (uppercase) {
            String reverse = StringUtils.reverse(input);
            return StringUtils.swapCase(reverse);
        }

            return StringUtils.reverse(input);
//            return new StringBuilder(input).reverse().toString();
    }

}
