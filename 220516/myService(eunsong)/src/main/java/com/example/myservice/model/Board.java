package com.example.myservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * packageName : com.example.myservice.model
 * fileName : Member
 * author : Eunsong LEE
 * date : 2022-05-16
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-05-16    Eunsong LEE        최초 생성
 */
public class Board {
    // @JsonPropert : insert 테스트를 json 형식으로 넣을 때 사용함
    // Json의 속성명 : value="userId"
    // { "userId" : "값" }

    @JsonProperty(value="idx")
    private int idx;

    @JsonProperty(value="title")
    private String title;

    @JsonProperty(value="content")
    private String content;

    @JsonProperty(value="writer")
    private String writer;

    @JsonProperty(value="viewCnt")
    private String viewCnt;

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
}
