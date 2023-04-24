package org.example.servicesimpl;

import org.example.domain.Kinesis;
import org.example.domain.UserDTO;
import org.example.interfaces.Logger;

import javax.inject.Inject;

public class KinesisLogger implements Logger {

    @Inject
    private Kinesis kinesis;
    @Override
    public void sendLog(UserDTO userDTO) {
        kinesis.sendLog(userDTO);
    }
}
