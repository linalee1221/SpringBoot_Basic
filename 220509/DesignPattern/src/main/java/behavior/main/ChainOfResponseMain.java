package behavior.main;

import behavior.chainofresponse.Chain;
import behavior.chainofresponse.NegativeProcessor;
import behavior.chainofresponse.Number;
import behavior.chainofresponse.PositiveProcessor;
import behavior.chainofresponse.ZeroProcessor;

/**
 * packageName : behavior.main
 * fileName : ChainOfResponseMain
 * author : Eunsong LEE
 * date : 2022-05-10
 * description : 체인연쇄 패턴 테스트
 * 테스트케이스1: 조건에 해당하지 않으면 다음 객체로 넘어가는지?
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-05-10    Eunsong LEE        최초 생성
 */
public class ChainOfResponseMain {
    public static void main(String[] args) {
        Chain chain = new NegativeProcessor();
        Chain chain2 = new ZeroProcessor();
        Chain chain3 = new PositiveProcessor();

        // 객체들을 체인으로 연결 : 링크드 리스트로 만들기
        // chain -- chain2 -- chain3
        chain.setNext(chain2);
        chain2.setNext(chain3);

        // 책임연쇄 패턴테스트 : 첫번째 객체만 호출해도 모두 결과를 찾아주는지 테스트
        chain.process(new Number(90));
        chain.process(new Number(-50));
        chain.process(new Number(0));
    }
}
