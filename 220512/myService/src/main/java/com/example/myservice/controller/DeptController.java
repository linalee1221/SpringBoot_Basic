package com.example.myservice.controller;

import com.example.myservice.dao.DeptDao;
import com.example.myservice.model.Dept;
import com.example.myservice.service.DeptService;
import com.example.myservice.service.DeptServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * packageName : com.example.myservice.controller
 * fileName : DeptController
 * author : ds
 * date : 2022-05-12
 * description : 메뉴 달기 / 반환값 : json 파일
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-05-12         ds          최초 생성
 */

//@RestController : 메뉴 달기 / 반환값 : json 파일
//@Controller : jsp, html, 타임리프 파일 형태
//Rest API : CRUD(Insert:Post , Select:Get , Update:Put , Delete:Delete)
@RestController
public class DeptController {

    //@Autowired객체 자동 의존성 주입(자동Di)
    @Autowired
    DeptDao deptDao;

    //@Autowired : 자동의존성주입(DI) 스프링에 등록된 객체만 대상으로 한다.
    // 스프링에 객체를 등록 : 클래스 위에 @Component, @Service, @Repository가 달려 있어야 함
    @Autowired
    DeptServiceImpl deptService;

    //@GetMapping : 메뉴 달기 : /main, select 실행
    //localhost:8080/main접속 : 새메뉴
    @GetMapping("/dept/all")
    public List<Dept> selectAll() {
//        List<Dept> list = deptDao.selectList();
        List<Dept> list = deptDao.selectAll();
        return list; // json파일 형태로 보임
    }

    // @PostMapping : insert 실행
    // HTML : 헤더(머리말), 본문(BODY)
    // @RequestBody : 본문에 TEXT/JSON 형태로 데이터를 전송하겠음
    @PostMapping("/dept/new")
    public List<Dept> insertMember(@RequestBody Dept dept) {
        // 웹브라우저에서 json 형태로 데이터를 넘겨받아(dept 객체)
        // DB에 INSERT 문을 실행하는 부분
        deptService.insertMember(dept);
        // 데이터가 추가되었는지 결과를 확인(DB Select)
        return deptDao.selectAll();
    }


}
























