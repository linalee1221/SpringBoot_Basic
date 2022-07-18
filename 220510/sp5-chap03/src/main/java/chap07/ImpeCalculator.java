package chap07;

/**
 * packageName : chap07
 * fileName : ImpeCalculator
 * author : Eunsong LEE
 * date : 2022-05-11
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-05-11    Eunsong LEE        최초 생성
 */
public class ImpeCalculator implements Calculator {
    @Override
    public long factorial(long num) {
        
        // 팩토리얼 결과를 저장할 변수
        // 팩토리얼 : 지정된 숫자만큼 계속 곱셈을 하는것

        // 1) 개발자 팩토리얼 계산에 필요한 실행시간을 측정하고자 함
        // 2) 실행 전에 미리 시간 축정 : a
        // 3) 실행 종료 후 시간 측정 : b
        // 4) b - a = 실행시간

        // 실행 전 시간 측정
        long start = System.currentTimeMillis(); // 밀리초(ms) 계산
        long result = 1;

        // 매개변수 num까지 반복해서 곱셈연산
        for(long i=1; i<=num; i++) {
            // 누적곱
            result += i;
        }

        // 실행 후 종료 시간 측정
        long end = System.currentTimeMillis(); // 밀리초(ms)

        // 실행시간 화면 출력
        System.out.println("ImpeCalculator 팩토리얼 계산 실행 시간 : " + (end - start));

        // 결과 result 반환
        return result;
    }
}
