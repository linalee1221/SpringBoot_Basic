package com.example.hellospringbootjsp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * packageName : com.example.hellospringbootjsp.configuration.controller
 * fileName : TestController
 * author : Eunsong LEE
 * date : 2022-05-10
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-05-10    Eunsong LEE        최초 생성
 */
// 웹 브라우저의 URL과 매핑될 jsp 페이지 파일을 설정할 어노테이션
@Controller
public class TestController {
    // 웹브라우저 URL : /
    // 전체주소 : http://localhost:8080/
    // hello.jsp 페이지 로딩
    // HTTP 프로토콜 전송 방식 : GET, POST, DELETE, PATCH, PUT
    @GetMapping("/")
    public String hello() {
        return "hello";
    }
}
