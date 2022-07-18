package behavior.chainofresponse;

/**
 * packageName : behavior.chainofresponse
 * fileName : Chain
 * author : Eunsong LEE
 * date : 2022-05-10
 * description : 핸들러 역할을 하는 인터페이스
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-05-10    Eunsong LEE        최초 생성
 */
public interface Chain {
    // 다음 객체로 이동
    public void setNext(Chain nextInChain);
    // 조건에 따라서 양수인지 0인지 음수인지 판단하는 메소드
    public void process(Number request);
}
