package com.sda.SDASpringcourse.model;

import org.springframework.stereotype.Component;

/**
 * Created by RENT on 2017-08-21.
 */

@Component
public class CreationStatusFactory {

    public static CreationStatus createSuccessStatus(String message) {
        CreationStatus creationStatus = new CreationStatus();
        creationStatus.setStatus(true);
        creationStatus.setMessage(message);

        return creationStatus;
    }

    public static CreationStatus createFailureStatus(String message) {
        CreationStatus creationStatus = new CreationStatus();
        creationStatus.setStatus(false);
        creationStatus.setMessage(message);

        return creationStatus;
    }

}
