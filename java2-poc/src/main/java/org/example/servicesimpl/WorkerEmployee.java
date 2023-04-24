package org.example.servicesimpl;

import org.example.advices.WorkerBeforeAdvice;
import org.example.annotations.WorkerQualifier;
import org.example.interfaces.Employee;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import java.util.logging.Logger;


@Stateless
public class WorkerEmployee implements Employee {

    private static final Logger LOGGER = Logger.getLogger(WorkerEmployee.class.toString());

    @Override
    @Interceptors(WorkerBeforeAdvice.class)
    public void enterWorkArea() {
        LOGGER.info("here in enterWorkArea");
    }

}
