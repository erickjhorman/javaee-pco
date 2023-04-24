package org.example.services;

import org.example.annotations.ExceptionLogger;

import javax.ejb.Stateless;
import java.util.logging.Logger;

@Stateless
public class UserService {

    private static final Logger LOGGER = Logger.getLogger(UserService.class.toString());
    @ExceptionLogger
    public void getAllPeople() {
        LOGGER.info("here in getAllPeople");
    }
}
