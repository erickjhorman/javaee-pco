package org.example.domain;

import javax.ejb.Stateless;
import java.util.logging.Logger;

@Stateless
public class Kinesis {
    private static final java.util.logging.Logger LOGGER = Logger.getLogger(Kinesis.class.toString());
    public void sendLog(User user) {
        //here kinesis code here
        //LOGGER.info("Sending log to kinesis" + user);
    }
}
