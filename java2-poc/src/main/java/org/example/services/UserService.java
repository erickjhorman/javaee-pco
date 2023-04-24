package org.example.services;

import org.example.annotations.ExceptionLogger;

import javax.ejb.Stateless;
import java.util.logging.Logger;

@Stateless
public class UserService {

    private static final Logger LOGGER = Logger.getLogger(UserService.class.toString());
    @ExceptionLogger
    public void getAllPeople() {
        LOGGER.info("Running normal method logic");
    }

    public void getOffer() {
        LOGGER.info("Running normal method logic getOffer in UserService");
    }

    public void approvedCredit() {
        LOGGER.info("Running normal method logic approvedCredit in UserService");
    }
}
