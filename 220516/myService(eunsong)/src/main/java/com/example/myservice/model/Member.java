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
public class Member {
    // @JsonPropert : insert 테스트를 json 형식으로 넣을 때 사용함
    // Json의 속성명 : value="userId"
    // { "userId" : "값" }
    @JsonProperty(value="userId")
    private String userId;

    @JsonProperty(value="userName")
    private String userName;

    @JsonProperty(value="userAuth")
    private String userAuth;

    @JsonProperty(value="appendDate")
    private String appendDate;

    @JsonProperty(value="updateDate")
    private String updateDate;
}
