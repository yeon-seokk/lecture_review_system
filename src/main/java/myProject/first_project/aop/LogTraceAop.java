package myProject.first_project.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect // AOP로 사용하겠다는 선언
@Component // 스프링 빈으로 등록
public class LogTraceAop {

    //myproject.first_project 패키지 하위의 모든 메서드에 적용
    @Around("execution(* myProject.first_project..*(..))")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable{
        // 1. 실행되는 메서드의 이름을 가져온다.
        String methodName = joinPoint.toString();

        try{
            //2. 메서드 실행 전 로그
            System.out.println("---- Start = " + methodName + " ----");

            // 3. 실제 로직 실행
            return joinPoint.proceed();
        } finally {
            // 4. 메서드 실행 후 로그 (에러가 나도 실행됨)
            System.out.println("---- End = " + methodName + " ----");
        }
    }
}
