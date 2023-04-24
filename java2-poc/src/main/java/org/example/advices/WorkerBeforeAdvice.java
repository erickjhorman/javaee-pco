package org.example.advices;

import org.example.annotations.Entered;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.io.Serializable;
import java.util.logging.Logger;


@Entered
@Interceptor
public class WorkerBeforeAdvice implements Serializable {

    private static final Logger LOGGER = Logger.getLogger(WorkerBeforeAdvice.class.toString());

    @AroundInvoke
    protected Object protocolInvocation(final InvocationContext invocationContext) throws Exception {
        //cache
        //kinessis
        if(invocationContext.getMethod().getName().equals("enterWorkArea")) {
            LOGGER.info("Informing the supervisor that I have arrived");
        }

        return invocationContext.proceed();
    }

}
