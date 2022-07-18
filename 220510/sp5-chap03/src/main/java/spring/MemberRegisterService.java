package spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

// Dao + Service => 웹 개발을 할 때 설계를 위한 이름을 약속함
// xxxService 역할 : 비지니스(업무)로직이 작성되어 있는 클래스
// xxxDao 활용 + Model(Member, RegisterMember 클래스) 두 개를 이용하여 업무로직을 짠다(코딩한다)
@Component
public class MemberRegisterService {

    // 앞서 만든 Dao를 멤버변수로 등록해둠(CRUD를 하기 위해서)
    @Autowired
    private MemberDao memberDao;

    // 생성자 : Dao 객체를 생성(외부에서 매개변수를 통해 생성 : DI(의존성 주입))
    public MemberRegisterService(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    // Regist 메소드 : 새로운 회원 등록 서비스
    public Long regist(RegisterRequest req) {
        // 이메일(키값)을 가지고 검색하는 메소드를 호출
        // 반환값(return) : Member 객체를 반환함
        Member member = memberDao.selectByEmail(req.getEmail());

        // 기존에 회원이 있으면 member의 값이 null이 아님
        if(member !=null) {
            // 기존에 회원이 있으면 에러를 발생시키고 빠져나옴
            throw new DuplicateMemberException("dup email" + req.getEmail());
        }

        // member의 값이 null이면 회원이 없다는 것이므로 멤버를 등록해줘야 한다.
        // member생성자를 호출해서 객체를 생성한다(회원 등록을 위한 객체를 생성함)
        Member newMember = new Member(
                req.getEmail(),req.getPassword(), req.getName(), LocalDateTime.now()
        );

        // 회원등록 메소드를 호출
        memberDao.insert(newMember);
        return newMember.getId();
    }
}
