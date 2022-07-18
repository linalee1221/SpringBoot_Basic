package com.example.myservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * packageName : com.example.myservice.model
 * fileName : Member
 * author : ds
 * date : 2022-05-16
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-05-16         ds          최초 생성
 */
// 라이브러리 Rombok 설치해야 사용할 수 있음
@Setter
@Getter
public class Member {

//    @JsonProperty : insert 테스트 시 json 형식으로 넣을때
//    Json의 속성명 : value="userId"
//    { "userId": "forbob" }
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
