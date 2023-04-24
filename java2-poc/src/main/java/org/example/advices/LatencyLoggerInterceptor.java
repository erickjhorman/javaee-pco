package org.example.advices;

import org.example.annotations.LatencyLogger;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.io.Serializable;

@Interceptor
@LatencyLogger
public class LatencyLoggerInterceptor implements Serializable {
    @AroundInvoke
    public Object computeLatency(InvocationContext invocationCtx) throws Exception {
        long startTime = System.currentTimeMillis();
        //execute the intercepted method and store the return value
        Object returnValue = invocationCtx.proceed();
        long endTime = System.currentTimeMillis();
        System.out.println("Latency of " + invocationCtx.getMethod().getName() +": " + (endTime-startTime)+"ms");
        return returnValue;

    }
}
