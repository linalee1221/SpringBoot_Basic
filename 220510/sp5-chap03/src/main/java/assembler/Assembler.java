package assembler;

import spring.ChangePasswordService;
import spring.MemberDao;
import spring.MemberRegisterService;

/**
 * packageName : assembler
 * fileName : Assembler
 * author : Eunsong LEE
 * date : 2022-05-11
 * description : 정의된 클래스를 생성해서 조립하는 클래스
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-05-11    Eunsong LEE        최초 생성
 */
public class Assembler {
    // 객체 생성을 위한 멤버 변수 정의
    private MemberDao memberDao; // Dao클래스
    private MemberRegisterService reqSvc; // 회원등록 Service클래스
    private ChangePasswordService pwdSvc; // 패스워드 변경 Service 클래스


    // 기본 생성자
    // 다른 클래스들을 모두 생성함
    public Assembler() {
        // 외부에서 memberDao 객체를 생성
        // MemeberCashedDao() : MemberDao 의 자식 클래스
        // 아래 코드가 매개변수가 있는 메소드 형태가 아니라면
        // 각각의 클래스 코스를 열어서 MemberDao() -> MemberCachedDao()로 수정해야함
        memberDao = new MemberDao();
        // 매개변수가 있는 생성자(다른 클래스 객체를 전달하고 있음) : 생성자 DI
        reqSvc = new MemberRegisterService(memberDao);
        // 매개변수가 있는 setter(다른 클래스 객체를 전달) : Setter DI
        pwdSvc = new ChangePasswordService();
        pwdSvc.setMemberDao(memberDao); // setter DI
    }

    public MemberDao getMemberDao() {
        return memberDao;
    }

    public MemberRegisterService getMemberRegisterService() {
        return reqSvc;
    }

    public ChangePasswordService getChangePasswordService() {
        return pwdSvc;
    }
}
