package org.example.servicesimpl;

import org.example.interfaces.Employee;

import javax.interceptor.Interceptors;

public class SupervisorEmployee implements Employee {

    @Interceptors(SupervisorEmployee.class)
    public void enterWorkArea() {

    }

}
