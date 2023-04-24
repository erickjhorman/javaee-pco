package org.example.services;

import org.example.annotations.LatencyLogger;

import javax.ejb.Stateless;
import java.util.logging.Logger;

@Stateless
public class UserService {

    private static final Logger LOGGER = Logger.getLogger(UserService.class.toString());


    @LatencyLogger
    public void getAllPeople() {
        LOGGER.info("here in getAllPeople");
    }
}
