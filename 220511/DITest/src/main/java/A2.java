/**
 * packageName : PACKAGE_NAME
 * fileName : A2
 * author : Eunsong LEE
 * date : 2022-05-11
 * description : DI(의존성 주입)를 써서 코딩한 클래스
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-05-11    Eunsong LEE        최초 생성
 */
public class A2 {
    // B객체 멤버 변수로 등록
    B b;

    // DI : 생성자의 매개변수로 B라는 객체를 전달하는 형태
   public A2(B b) {
       // 핵심 : B클래스 기능이 변경되면 아래 코딩은 고칠 필요가 없음
        this.b = b; // DI를 사용한 코딩
    }
}
