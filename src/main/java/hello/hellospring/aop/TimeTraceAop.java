package hello.hellospring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import javax.persistence.Column;

@Aspect
@Component     //Component Scan 안쓸거면 config에 bean으로 등록할 것
public class TimeTraceAop {
    @Around("execution(* hello.hellospring..*(..))")        // 적용범위 설정 보통 package level로 많이 적용한다.
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        System.out.println("START: " + joinPoint.toString());
        try {
            return joinPoint.proceed();

        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println(("END: " + joinPoint.toString()) + " " + timeMs + "ms");
        }
    }
}
