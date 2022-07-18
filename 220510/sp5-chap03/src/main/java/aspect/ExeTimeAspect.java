package aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * packageName : aspect
 * fileName : ExeTimeAspect
 * author : Eunsong LEE
 * date : 2022-05-12
 * description : 스프링 공통 클래스 ()
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-05-12    Eunsong LEE        최초 생성
 */
// @Aspect : 공통 클래스로 등록하는 어노테이션
@Aspect
public class ExeTimeAspect {
    // 내용 없는 메소드
    // @Pointcut : 공통메소드 measure()가 적용될 위치
    // 매개변수 : execution 실행
    // execution(수식어 리턴타입 클래스이름 메소드이름(매개변수이름))
    // .. : 0개이상
    // * : 모든값
    @Pointcut("execution(public * chap07..*(..))")
    private void publicTarget() {
    }

    // 공통 메소드를 언제 호출할지 나타내는 어노테이션(Around)
    // 시작시간 공통함수
    // 업무로직 호출(팩토리얼 메소드 호출)
    // 끝시간 공통함수
    // 스프링 AOP(공통클래스 사용) : 프록시 패턴 사용
    // 프록시 : 진짜를 대신해서 가짜가 진짜 행세를 하는 클래스
    // 프록시를 쓰는 이유
    // 1) 진짜 클래스나 메소드 이름을 노출시키지 않기 위함(=보안)
    // 2) 진짜의 일부 기능을 미리 사용할 필요가 있을 때
    // 스프링 프록시 : ProceedingJoinPoint
    @Around("publicTarget()")
    public Object measure(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.nanoTime(); // 나노시간 측정
        try {
            // proceed() : 진짜 업무 메소드를 찾아서 호출
            // 진짜 업무 메소드 : 팩토리얼 계산 메소드
            Object result = joinPoint.proceed(); // 프록시
            return result;
        } finally {
            // 나노시간 측정 끝
            long end = System.nanoTime();
            System.out.println("스프링 공통함수 실행시간 : " + (end-start));
        }
    }
}
