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
public class Board {
    private int dno; // 숫자 ( 부서번호 )
//    Json 속성명으로 정의하는 어노테이션
//    {  "속성명" : "값" }
    @JsonProperty(value="idx")
    private int idx;
    @JsonProperty(value="title")
    private String title;
    @JsonProperty(value="content")
    private String content;
    @JsonProperty(value="writer")
    private String writer;
    @JsonProperty(value="viewCnt")
    private int viewCnt;
    @JsonProperty(value="noticeYn")
    private String noticeYn;
    @JsonProperty(value="secretYn")
    private String secretYn;
    @JsonProperty(value="deleteYn")
    private String deleteYn;
    @JsonProperty(value="insertTime")
    private String insertTime;
    @JsonProperty(value="updateTime")
    private String updateTime;
    @JsonProperty(value="deleteTime")
    private String deleteTime;

//    setter/ getter 만들기
}










