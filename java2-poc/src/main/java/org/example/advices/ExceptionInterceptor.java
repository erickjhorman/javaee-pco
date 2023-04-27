package org.example.advices;

import org.example.annotations.ExceptionLogger;
import org.example.domain.User;
import org.example.exception.ErrorResponseDTO;
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

    private static final long serialVersionUID = 1L;
    private static final java.util.logging.Logger LOGGER = java.util.logging.Logger.getLogger(ExceptionInterceptor.class.toString());

    @Inject
    private CacheUtils cacheUtils;

    @Inject
    private Logger loggerKinesis;

    @AroundInvoke
    public Object loggerException(InvocationContext invocationCtx) throws Exception {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            return invocationCtx.proceed();
        } catch (Exception e) {
            int userId = (Integer) invocationCtx.getParameters()[0];
            //Getting traditional user from cache
            User user = cacheUtils.getUser(userId);
            //Type of user
            LOGGER.info("Running logic in interceptor");
            String userType = user.getUserType() == 4 ? "libranza tradicional" : "libranza especial";
            LOGGER.info("Getting user from cache en el metodo. " + " " + invocationCtx.getMethod().getName() +
                    stringBuilder.append(user.getUsername()).append(" es ").append(userType));
            stringBuilder.setLength(0);

            //Sending log to kinesis
            loggerKinesis.sendLog(user);
            LOGGER.info("Sending log to kinesis from catch block from initial method" + e.getMessage());
            throw new ErrorResponseDTO("Error sent to front", e, user.getUsername(), String.valueOf(user.getUserType()));
        }
    }
}
