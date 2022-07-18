package structure.main;

import structure.adapter.Turkey;
import structure.adapter.TurkeyAdapter;
import structure.adapter.WildTurkey;

/**
 * packageName : structure.main
 * fileName : AdapterMain
 * author : Eunsong LEE
 * date : 2022-05-10
 * description : 칠면조 어댑터 테스트
 * 테스트케이스1: 오리 메소드를 호출하면 칠면조 소리가 나는가? O
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-05-10    Eunsong LEE        최초 생성
 */
public class AdapterMain {
    public static void main(String[] args) {
    // 칠면조 객체 생성
    // 다형성 : 부모 Turkey 인터페이스, 클래스 = new 생성자(자식), 느슨한 결합
    // 단형성 : 부모 클래스 = new 부모 생성자()
    //          자식 클래스 = new 자식 생성자(), 단단한 결합

        Turkey turkey = new WildTurkey(); // 다형성

    // 칠면조 어댑터 생성 : 오리 메소드를 통해 칠면조 소리를 내게 하기 위함
        TurkeyAdapter turkeyAdapter = new TurkeyAdapter(turkey);

        turkeyAdapter.quack(); // 오리 메소드지만 칠면조 소리가 난다.
        turkeyAdapter.fly(); // 칠면조지만 다섯번 날아서 오리처럼 날게 한다.
    }
}
