package com.example.myservice.controller;

import com.example.myservice.dao.Dept2Dao;
import com.example.myservice.dao.DeptDao;
import com.example.myservice.model.Board;
import com.example.myservice.model.Dept;
import com.example.myservice.model.Dept2;
import com.example.myservice.model.Member;
import com.example.myservice.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * packageName : com.example.myservice.controller
 * fileName : DeptController
 * author : ds
 * date : 2022-05-12
 * description : 메뉴달기 , 반환값 : json파일형태
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-05-12         ds          최초 생성
 */
// @RestController : 메뉴달기 , 반환값 : json파일형태 ( Vue 연동 )
// @Controller : jsp, html , 타임리프 파일 형태
//    Rest API :
//        CRUD ( Insert : Post, Select : Get, Update : Put, Delete : Delete )
@RestController
public class DeptController {

//    @Autowired : 객체를 자동 의존성 주입( 자동 DI )
    @Autowired
    DeptDao deptDao;
    @Autowired
    Dept2Dao dept2Dao;

//    @Autowired : 자동 의존성 주입(DI) , 대상 : 스프링에 등록된 객체만
//    스프링에 객체로 등록 : 클래스 위에 @Component, @Service, @repository
    @Autowired
    DeptServiceImpl deptService;
    @Autowired
    Dept2ServiceImpl dept2Service;

 // @Service, @Component, @Bean 등등 : 스프링에 객체를 생성하는 어노테이션
//    @Autowired : 스프링에 생성된 객체를 전달받아 아래 멤버변수에 할당
    @Autowired
    MemberServiceImpl memberService; // 회원서비스 정의, 객체생성 필요없음

    @Autowired
    BoardServiceImpl boardService; // 게시판 정의, 객체생성 필요없음

//    @GetMapping : 메뉴 달기 : /main, select 실행
//    localhost:8000/main 접속 : 새메뉴
    @GetMapping("/dept/all")
    public List<Dept> selectAll() {
//        List<Dept> list = deptDao.selectList();
        List<Dept> list = deptDao.selectAll();
        return list; // json파일 형태로 보임
    }

//    @PostMapping : insert 실행
//    HTML : 헤더(머리말), 본문(BODY)
//    @RequestBody : 본문에 TEXT/ JSON 형태로 데이터를 전송하겠음
    @PostMapping("/dept/new")
    public List<Dept> insertMember(@RequestBody Dept dept) {
//        웹브라우저에서 json형태로 데이터를 넘겨받아( dept 객체 )
//        DB 에 INSERT 문을 실행하는 부분
        deptService.insertMember(dept);
//        데이터 추가되었는지 결과 확인( DB Select )
        return deptDao.selectAll();
    }

//   @PutMapping : update 어노테이션
//    @PathVariable : URL 메뉴 /dept/{dno} 중에서 dno를 의미함
//    웹브라우저 URL 매개변수{dno}를 메소드 updateMember의 매개변수 dno로 연결
//    웹 애플리케이션 개발 : 웹 URL 형태
//    형태 1( 전통 ) : http://127.0.0.1/read?no=1 : html, JSP, 타임리프 개발
//    @GetMapping("read")
//    메소드의 매개변수 : @RequestParam("no") int no
//    형태 2( REST API ) : http://127.0.0.1/read/1
//                      : Rest API , axios 이용, 데이터(json), Vue, react
//    @GetMapping("read/{no}")
//    메소드의 매개변수 : @PathVariable("no") int no
    @PutMapping("/dept/{dno}")
    public List<Dept> updateMember(@PathVariable int dno
                                    ,@RequestBody Dept dept) {
//        update 문 실행
        deptService.updateMember(dno, dept);
//        데이터 수정되었는지 전체 데이터 다시 조회
        return deptService.selectAll();
    }

//    Delete sql문 실행
//    @DeleteMapping : 데이터 삭제에 해당하는 웹 브라우저 URL 어노테이션
    @DeleteMapping("/dept/{dno}")
    public List<Dept> deleteMember(@PathVariable int dno) {

//        데이터 삭제 메소드 호출
        deptService.deleteMember(dno);
        //        데이터 삭제되었는지 전체 데이터 다시 조회
        return deptService.selectAll();
    }


    @GetMapping("/dept2/all")
    public List<Dept2> selectAll2() {
//        List<Dept> list = deptDao.selectList();
        List<Dept2> list = dept2Dao.selectAll();
        return list; // json파일 형태로 보임
    }

//    @PostMapping : insert 실행
//    HTML : 헤더(머리말), 본문(BODY)
//    @RequestBody : 본문에 TEXT/ JSON 형태로 데이터를 전송하겠음
    @PostMapping("/dept2/new")
    public List<Dept2> insertMember2(@RequestBody Dept2 dept2) {
//        웹브라우저에서 json형태로 데이터를 넘겨받아( dept 객체 )
//        DB 에 INSERT 문을 실행하는 부분
        dept2Service.insertMember(dept2);
//        데이터 추가되었는지 결과 확인( DB Select )
        return dept2Dao.selectAll();
    }

    //    @GetMapping("read/{no}")
//    메소드의 매개변수 : @PathVariable("no") int no
    @PutMapping("/dept2/{dno}")
    public List<Dept2> updateMember3(@PathVariable int dno
            ,@RequestBody Dept2 dept2) {
//        update 문 실행
        dept2Service.updateMember(dno, dept2);
//        데이터 수정되었는지 전체 데이터 다시 조회
        return dept2Service.selectAll();
    }

    //    Delete sql문 실행
//    @DeleteMapping : 데이터 삭제에 해당하는 웹 브라우저 URL 어노테이션
    @DeleteMapping("/dept2/{dno}")
    public List<Dept2> deleteMember3(@PathVariable int dno) {

//        데이터 삭제 메소드 호출
        dept2Service.deleteMember(dno);
        //        데이터 삭제되었는지 전체 데이터 다시 조회
        return dept2Service.selectAll();
    }



//    @GetMapping : 아래 URL 메뉴를 Get 방식을 이용해서 만듬
//    URL Get 방식 : Select 쿼리에 해당하는 방법( 검색, 조회 )
    @GetMapping("/member/all")
    public List<Member> selectAll3() {
        List<Member> list = memberService.selectAll();
        return list; // json파일 형태로 보임
    }

    //    @PostMapping : 아래 URL 메뉴를 Post 방식으로 insert 실행
//    HTML : 헤더(머리말), 본문(BODY)
//    @RequestBody : 본문에 TEXT/ JSON 형태로 데이터를 전송하겠음
    @PostMapping("/member/new")
    public List<Member> insertMember3(@RequestBody Member member) {
//        웹브라우저에서 json형태로 데이터를 넘겨받아( dept 객체 )
//        DB 에 INSERT 문을 실행하는 부분
        memberService.insertMember(member);
//        데이터 추가되었는지 결과 확인( DB Select )
        return memberService.selectAll();
    }

    //    @GetMapping : 아래 URL 메뉴를 Get 방식을 이용해서 만듬
//    URL Get 방식 : Select 쿼리에 해당하는 방법( 검색, 조회 )
    @GetMapping("/board/all")
    public List<Board> selectAll4() {
        List<Board> list = boardService.selectAll();
        return list; // json파일 형태로 보임
    }

    //    @PostMapping : 아래 URL 메뉴를 Post 방식으로 insert 실행
//    HTML : 헤더(머리말), 본문(BODY)
//    @RequestBody : 본문에 TEXT/ JSON 형태로 데이터를 전송하겠음
    @PostMapping("/board/new")
    public List<Board> insertMember4(@RequestBody Board board) {
//        웹브라우저에서 json형태로 데이터를 넘겨받아( dept 객체 )
//        DB 에 INSERT 문을 실행하는 부분
        boardService.insertMember(board);
//        데이터 추가되었는지 결과 확인( DB Select )
        return boardService.selectAll();
    }
}









