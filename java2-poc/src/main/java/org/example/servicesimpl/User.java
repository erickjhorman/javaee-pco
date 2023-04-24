package org.example.servicesimpl;

import org.example.advices.SupervisorBeforeAdvice;
import org.example.annotations.LatencyLogger;

import javax.ejb.Stateless;
import java.util.logging.Logger;

@Stateless
public class User {

    private static final Logger LOGGER = Logger.getLogger(User.class.toString());


    @LatencyLogger
    public void getAllPeople() {
        LOGGER.info("here in getAllPeople");
    }
}
