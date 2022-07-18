package chap07;

/**
 * packageName : chap07
 * fileName : CommonTest
 * author : Eunsong LEE
 * date : 2022-05-11
 * description : 팩토리얼 공통 클래스 테스트 : 실행 시간이 잘 출력되는지
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-05-11    Eunsong LEE        최초 생성
 */
public class CommonTest {
    public static void main(String[] args) {

        // 객체생성
        ExeTimeCalculator etcalc = new ExeTimeCalculator(new ImpeCalculator());
        // 팩토리얼 화면 출력
        System.out.println(etcalc.factorial(232456));
    }
}
