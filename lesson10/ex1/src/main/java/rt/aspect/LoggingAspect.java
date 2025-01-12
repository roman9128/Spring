package rt.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.dao.DataAccessException;

import java.util.logging.Logger;

@Aspect
public class LoggingAspect {
    private final Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @AfterThrowing(
            pointcut = "execution(* rt.service.*.*(..))",
            throwing = "ex")
    public void logExceptions(DataAccessException ex) {
        logger.warning("ERROR: " + ex.getLocalizedMessage());
    }

    @Around("@annotation(ToLog)")
    public Object logMethodInvocation(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        long duration = 0L;
        try {
            long start = System.currentTimeMillis();
            logger.info("method " + methodName + " invoked");
            Object result = joinPoint.proceed();
            duration = System.currentTimeMillis() - start;
            return result;
        } catch (Exception e) {
            logger.warning("ERROR: " + e.getLocalizedMessage());
        } finally {
            if (duration == 0L) {
                logger.info(methodName + " finished with ERROR");
            } else {
                logger.info(methodName + "successfully finished in " + duration + " ms");
            }
        }
        return null;
    }

    @AfterReturning(
            value = "execution(* rt.service.TransferService.checkMoney(..))",
            returning = "returnedValue")
    public void logResult(Object returnedValue) {
        logger.info("Enough money: " + returnedValue);
    }
}