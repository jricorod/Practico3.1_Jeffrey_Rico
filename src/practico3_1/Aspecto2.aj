package practico3_1;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.util.StopWatch;

public class FooAspect {
 
    @Around("execution(* practico3_1.estado.*(..))")
    public Object measureMethod(ProceedingJoinPoint pjp) throws Throwable
    {
        StopWatch sw = new StopWatch();
        Object retVal;
        try
        {
            sw.start(pjp.getTarget()+"."+pjp.getSignature());
            retVal = pjp.proceed();
        }
        catch (Throwable e)
        {
            throw e;
        }
        finally
        {
            sw.stop();
            System.out.println(sw.prettyPrint());
        }
        return retVal;
    }
}