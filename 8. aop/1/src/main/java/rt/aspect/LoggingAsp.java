package rt.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import rt.model.Comment;

import java.util.Arrays;
import java.util.logging.Logger;

@Aspect
public class LoggingAsp {
//    private Logger logger = Logger.getLogger(LoggingAsp.class.getName());

    @Around("execution(* rt.service.*.*(..))")
    @Order(1)
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {

        String mthdName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();

        System.out.println("executed: method " + mthdName +
                " with parameters " + Arrays.asList(arguments));

        System.out.println("Msg before");
//        logger.info("Msg before");

        // substitution
        Comment comment = new Comment();
        comment.setAuthor("me");
        comment.setText("daaa");
        Object[] newArgs = {comment};

        //Object result = joinPoint.proceed();
        Object result = joinPoint.proceed(newArgs);

        System.out.println("Msg after");
//        logger.info("Msg after");

        return result;
    }

    @Around("execution(* rt.service.*.*(..))")
    @Order(2)
    public Object calcExecTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long duration = System.currentTimeMillis() - start;
        System.out.println("Method " + joinPoint.getSignature().getName() + " done in " + duration + " ms");
        return result;
    }

    @AfterReturning(value = "@annotation(ToLog)", returning = "returnedValue")
    public void log(Object returnedValue) {
        System.out.println("Method returned: " + returnedValue);
    }
}