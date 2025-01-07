package rt.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.dao.DataAccessException;

import java.util.logging.Logger;

@Aspect
public class LoggingAspect {
    private final Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @AfterThrowing(
            pointcut = "execution(* rt.service.*.*(..))",
            throwing = "ex")
    @Order(1)
    public void logExceptions(DataAccessException ex) {
        logger.warning("ERROR: " + ex.getLocalizedMessage());
    }

    @Around("@annotation(ToLog)")
    @Order(2)
    public Object logMethodInvocation(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        long start = System.currentTimeMillis();
        logger.info("method " + methodName + " invoked");
        Object result = joinPoint.proceed();
        long duration = System.currentTimeMillis() - start;
        logger.info(methodName + " finished in " + duration + " ms");
        return result;
    }

    @AfterReturning(
            value = "execution(* rt.service.TransferService.checkMoney(..))",
            returning = "returnedValue")
    public void logResult(Object returnedValue) {
        logger.info("Enough money: " + returnedValue);
    }
}