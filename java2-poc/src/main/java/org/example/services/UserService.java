package org.example.services;

import org.example.annotations.ExceptionLogger;

import javax.ejb.Stateless;
import java.util.logging.Logger;

@Stateless
@ExceptionLogger
public class UserService {

    private static final Logger LOGGER = Logger.getLogger(UserService.class.toString());

    public void getAllPeople(int userId) {
        LOGGER.info("Running normal method logic getAllPeople");
        getOffer();
    }

    public void getOffer() {
        //approvedCredit();
        LOGGER.info("Running normal method logic getOffer in UserService");
        //saveUser();
        approvedCredit();
    }

    public void approvedCredit() {
        LOGGER.info("Running normal method logic approvedCredit in UserService");
        int result = 5 / 0;
    }

    public void callingExternalErrorService() {
        LOGGER.info("Running normal method logic approvedCredit2 in UserService");

    }

   /* public void saveUser() {
        String test = null;
        try {
            test.charAt(0);
        }catch (Exception e) {
            throw new RuntimeException("Error in save user method", e);
        }
    }*/
}
