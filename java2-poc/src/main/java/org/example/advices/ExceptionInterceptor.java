package org.example.advices;

import org.example.annotations.ExceptionLogger;
import org.example.domain.User;
import org.example.utils.CacheUtils;
import org.example.interfaces.Logger;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.io.Serializable;

@Interceptor
@ExceptionLogger
public class ExceptionInterceptor implements Serializable {

    private static final java.util.logging.Logger LOGGER = java.util.logging.Logger.getLogger(ExceptionInterceptor.class.toString());


    @Inject
    private CacheUtils cacheUtils;

    @Inject
    private Logger loggerKinesis;

    @AroundInvoke
    public Object computeLatency(InvocationContext invocationCtx) throws Exception {
        StringBuilder stringBuilder = new StringBuilder();
        Object proceed = null;
        int i = 1;
        while(i <= 2) {
            //Getting traditional user from cache
            User user = cacheUtils.getUser(i);

            //Type of user
            String userType = user.getUserType() == 4 ? "libranza tradicional": "libranza especial";
            LOGGER.info("Getting traditional user from cache. " + stringBuilder.append(user.getUsername()).append(" es ").append(userType));

            //Sending log to kinesis
            loggerKinesis.sendLog(user);
            LOGGER.info("Sending log to kinesis");
            i++;
            proceed = invocationCtx.proceed();
            stringBuilder.setLength(0);
        }
        return proceed;
    }
}
