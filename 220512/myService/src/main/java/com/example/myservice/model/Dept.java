package com.example.myservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * packageName : com.example.myservice.model
 * fileName : Dept
 * author : ds
 * date : 2022-05-12
 * description : 부서테이블의 데이터를 한 건씩 담는 클래스
 *               (dno(숫자) dname(문자) loc(문자))
 *               Model == Vo == Dto == Entity(테이블의 데이터를 담는 그릇)
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-05-12         ds          최초 생성
 */

//Rombok의 기능 : setter와 getter 자동 추가
@Setter
@Getter
public class Dept {
    private int dno; // 부서번호(숫자)
    // Json 속성명응로 정의하는 어노테이션
    // { "속성명" : "값" }
    @JsonProperty(value = "dname")
    private String dname; // 부서이름(문자)
    @JsonProperty(value = "loc")
    private String loc; // 지역명(문자)

    //setter / getter만들기

}
