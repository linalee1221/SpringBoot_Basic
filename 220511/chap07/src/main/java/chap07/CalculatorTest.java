package chap07;

/**
 * packageName : chap07
 * fileName : CalculatorTest
 * author : Eunsong LEE
 * date : 2022-05-11
 * description : 팩토리얼 실행시간 측정 테스트
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-05-11    Eunsong LEE        최초 생성
 */
public class CalculatorTest {
    public static void main(String[] args) {
        ImpeCalculator impeCalculator = new ImpeCalculator();
        impeCalculator.factorial(886512);
    }
}
