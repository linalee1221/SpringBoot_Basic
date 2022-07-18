package config;

import aspect.ExeTimeAspect;
import chap07.Calculator;
import chap07.ExeTimeCalculator;
import chap07.ImpeCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import spring.ChangePasswordService;
import spring.MemberDao;
import spring.MemberRegisterService;

/**
 * packageName : config
 * fileName : AppCtx
 * author : Eunsong LEE
 * date : 2022-05-11
 * description : 스프링 환경설정 자바 클래스
 *               과거에는 환경설정을 XML파일에서 했으나 현재는 자바로 함
 *               스프링 : 객체를 생성 및 소멸시키는 작업을 대행해줌
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-05-11    Eunsong LEE        최초 생성
 */
// 환경설정을 위한 어노테이션
@Configuration
@ComponentScan(basePackages = {"spring"})
// 공통클래스가 활성화 : @Aspect가 달린 클래스를 찾아서 Pointcut /Around 설정을 적용
@EnableAspectJAutoProxy
public class AppCtx {

    // @Bean : 스프링에 객체를 등록하는 어노테이션
    // 공통클래스를 객체로 스프링에 등록
    @Bean
    public ExeTimeAspect exeTimeAspect() {
        // 공통 클래스 ExeTimeAspect 객체 생성
        return new ExeTimeAspect();
    }

    // 팩토리얼 계산을 위한 클래스를 객체로 등록록
   @Bean
    public Calculator calculator() {
        return new ImpeCalculator();
    }

    // memberDao 객체 생성
    // @Bean : 스프링에 컴포넌트 객체로 등록

    // @ComponentScan을 통해 자동으로 @Bean으로 스프링에 등록되었기 때문에 주석처리함
//   @Bean
//    public MemberDao memberDao() {
//        return new MemberDao();
//    }

    // memberReSvc : 멤버 등록 서비스 객체를 생성
    // @Bean : 스프링에 컴포넌트 객체로 등록
    // 스프링에 등록될 이름 : memberRegSvc

    // @ComponentScan을 통해 자동으로 @Bean으로 스프링에 등록되었기 때문에 주석처리함
//    @Bean
//    public MemberRegisterService memberRegSvc() {
//       // 매개변수로 memberDao 객체를 전달 : 생성자 DI
//       return new MemberRegisterService(memberDao());
//    }

    // 스프링에 등록될 이름 : changePwdSvc
    // @Autowired가 걸려 있어서 Setter DI (의존성 주입) 코딩을 생략해도 됨
    // 스프링이 알아서 setter DI(의존성 주입)를 해줌

    // @ComponentScan을 통해 자동으로 @Bean으로 스프링에 등록되었기 때문에 주석처리함
//    @Bean
//    public ChangePasswordService changePwdSvc() {
//
//       // 패스워드 변경 서비스 객체 생성
////        ChangePasswordService pwdSvc = new ChangePasswordService();
//       // 패스워드변경 서비스 객체의 setter를 호출하면 정보가 저장됨
//       // setter DI : 의존성 주입
////        pwdSvc.setMemberDao(memberDao());
////
//        return new ChangePasswordService();
    }
