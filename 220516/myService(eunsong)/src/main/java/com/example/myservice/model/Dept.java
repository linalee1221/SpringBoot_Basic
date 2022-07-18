package com.example.myservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * packageName : com.example.myservice.model
 * fileName : Dept
 * author : ds
 * date : 2022-05-12
 * description : 부서 테이블의 데이터를 한건씩 담는 클래스
 *              ( dno (숫자), dname (문자열), loc(문자열) )
 *              Model == Vo == Dto == Entity ( 테이블의 데이터를 담는 그릇 )
 * ======================== ===================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-05-12         ds          최초 생성
 */
// Rombok 의 기능 : setter / getter 를 자동으로 추가해줌
@Setter
@Getter
public class Dept {
    private int dno; // 숫자 ( 부서번호 )
//    Json 속성명으로 정의하는 어노테이션
//    {  "속성명" : "값" }
    @JsonProperty(value="dname")
    private String dname; // 문자열 ( 부서이름 )
    @JsonProperty(value="loc")
    private String loc; // 문자열 ( 지역 )

//    setter/ getter 만들기
}










