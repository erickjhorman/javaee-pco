package org.example.advices;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import java.io.Serializable;
import java.util.logging.Logger;

public class SupervisorBeforeAdvice implements Serializable {
    private static final Logger LOGGER = Logger.getLogger(SupervisorBeforeAdvice.class.toString());

    @AroundInvoke
    protected Object protocolInvocation(final InvocationContext invocationContext) throws Exception {

        if(invocationContext.getMethod().getName().equals("enterWorkArea")) {
            LOGGER.info("Check if everything is ok");
        }
        return invocationContext.proceed();
    }
}
