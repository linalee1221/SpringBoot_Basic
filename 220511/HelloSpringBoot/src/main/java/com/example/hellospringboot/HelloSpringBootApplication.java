package com.example.hellospringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// @Configuration, @ComponentScan, @EnableAutoConfiguration 3개 묶음
// @Configuration : 스프링에 등록될 객체들을 위한 자바 설정 파일(@Bean)
// @ComponentScan : @Component 가 붙은 클래스들을 검색해서 자동으로 @Bean 으로 등록함
// @EnableAutoConfiguration : 스프링에서 내부 라이브러리들을 등록해줌
@SpringBootApplication
// Controller : RestController, Controller
// 컨트롤러의 역할 : 메뉴만들기, URL 이동처리(Vue 라우터 : 메뉴)
// Rest API 작성을 위한 어노테이션
// 비교 @Controller : 일반 JSP / 타임리프 파일 로딩
@RestController
public class HelloSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloSpringBootApplication.class, args);
    }

    //@GetMapping : Get 방식(요청)에 /hello URL 연결(라우팅, 메뉴달기)
    // 의미 : Get 방식으로 메뉴를 연결하겠다는 뜻
    // Get : Select
    // 예시) http://localhost:8080/hello/myName=tae
    // URL : http://localhost:8080 => 도메인 주소
    // hello => 메뉴
    // tae => myName의 데이터값 tae
    // myName => parameter(매개변수)
    // defaultValue => 웹 매개변수 값이 null이면 디폴트값으로 대체

    @GetMapping("/hello")
    public String sayHello(@RequestParam(value="myName", defaultValue = "World")
                           String name) {
        // String.format : printf 구문과 유사, %s, %d 등에 문자나 숫자를 대입함
        return String.format("Hello %s!", name);

    }
}
