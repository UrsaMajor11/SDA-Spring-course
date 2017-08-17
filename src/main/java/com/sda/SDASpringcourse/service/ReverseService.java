package com.sda.SDASpringcourse.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

/**
 * Created by RENT on 2017-08-16.
 */

@Component
public class ReverseService {

    private boolean makeSwapCase;

    public void setMakeSwapCase(boolean makeSwapCase) {
        this.makeSwapCase = makeSwapCase;
    }

    public String reverseString(String input) {

        if (makeSwapCase) {
            String reverse = StringUtils.reverse(input);
            return StringUtils.swapCase(reverse);
        } else {
            return StringUtils.reverse(input);
            //return new StringBuilder(input).reverse().toString();
        }
    }

}
