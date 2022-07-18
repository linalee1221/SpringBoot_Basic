package main;

import assembler.Assembler;
import config.AppCtx;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * packageName : assembler
 * fileName : MainForAssembler
 * author : TaeGyung
 * date : 2022-04-30
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-04-30    Eunsong LEE        최초 생성
 */
public class MainForAssembler {
    // 객체를 생성 : Member 객체, 패스워드 변경 서비스 객체, 회원등록 객체 생성
    //    private static Assembler assembler = new Assembler();
    // 스프링 객체
    // assembler가 했던 객체 생성 일을 이제 스프링이 대신함
private static AnnotationConfigApplicationContext ctx = null;
    private static void processNewCommand(String[] arg) {
        if(arg.length != 5) {
            printHelp();
            return;
        }

//        Assembler 클래스에 정의된 메소드를 호출해서 객체를 구함(MemberRegisterService 객체)
//        MemberRegisterService reqSvc = assembler.getMemberRegisterService();
        // 스프링에 객체를 요청 : MemberRegisterService라는 객체를 요청함
        MemberRegisterService reqSvc = ctx.getBean(MemberRegisterService.class);
        RegisterRequest req = new RegisterRequest();
        req.setEmail(arg[1]);
        req.setName(arg[2]);
        req.setPassword(arg[3]);
        req.setConfirmPassword(arg[4]);

        if(!req.isPasswordEqualToConfiremPassword()) {
            System.out.println("암호와 암호확인이 일치하지 않습니다.\n");
        }

        try {
            reqSvc.regist(req);
            System.out.println("등록했습니다.");
        } catch(DuplicateMemberException e) {
            System.out.println("이미 존재하는 이메일입니다\n");
        }

    }

    private static void processChangeCommand(String[] arg) {
        if(arg.length != 4) {
            printHelp();
            return;
        }

//        Assembler 클래스에 정의된 메소드를 호출해서 객체를 구함(ChangePasswordService 객체)
//        ChangePasswordService changePwdSvc = assembler.getChangePasswordService();
        // 스프링에 객체를 요청 : ChangePasswordService라는 객체를 요청함
        ChangePasswordService changePwdSvc = ctx.getBean(ChangePasswordService.class);
        try {
            changePwdSvc.changePassword(arg[1], arg[2], arg[3]);
            System.out.println("암호를 변경했습니다.\n");
        } catch(MemberNotFoundException e) {
            System.out.println("존재하지 않는 이메일입니다.\n");
        } catch(WrongIdPasswordException e) {
            System.out.println("이메일과 암호가 일치하지 않습니다.\n");
        }
    }

    private static void printHelp() {
        System.out.println();
        System.out.println("잘못된 명령어입니다. 아래 명령어 사용법을 확인하세요");
        System.out.println("명령어 사용법");
        System.out.println("new 이메일 이름 암호 암호확인");
        System.out.println("change 이메일 현재비번 변경비번");
        System.out.println();
    }
    
    public static void main(String[] args) throws IOException {

        // 스프링 생성하는 로직 실행
        // 생성시 환경설정파일을 매개변수로 넘김김
       ctx = new AnnotationConfigApplicationContext(AppCtx.class);

        BufferedReader reader = 
                new BufferedReader(new InputStreamReader(System.in));
        
        while(true) {
            System.out.println("명령어를 입력하세요");
//            콘솔에서 입력을 한줄 받음
            String command = reader.readLine();

//            exit 이면 종료
            if(command.equalsIgnoreCase("exit")) {
                System.out.println("종료합니다.");
                break;
            }
//            new + " " 이면 processNewCommand 실행
            if(command.startsWith("new ")) {
                processNewCommand(command.split(" "));
                continue;
//                change + " " 이면 processNewCommand 실행
            } else if(command.startsWith("change ")) {
                processChangeCommand(command.split(" "));
                continue;
            }
        }
        printHelp();
    }
}
