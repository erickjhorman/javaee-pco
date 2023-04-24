package org.example.advices;

import org.example.annotations.ExceptionLogger;
import org.example.domain.UserDTO;
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

    @Inject
    private CacheUtils cacheUtils;

    @Inject
    private Logger loggerKinesis;

    @AroundInvoke
    public Object computeLatency(InvocationContext invocationCtx) throws Exception {

        //Getting traditional user from cache
        UserDTO user = cacheUtils.getUser(1);

        //Type of user
        user.getUserType();

        //Sending log to kinesis
        loggerKinesis.sendLog(user);

        return invocationCtx.proceed();
    }
}
