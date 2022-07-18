package com.example.eunsi.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * packageName : com.example.customerspring.model
 * fileName : Customer
 * author : Eunsong LEE
 * date : 2022-06-07
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-06-07    Eunsong LEE        최초 생성
 */
@Getter
@Setter
@ToString

// Long(객체), long(일반자료형)
public class Customer {
    private Long id;            // 회원 아이디
    private String firstName;   // 회원 이름
    private String lastName;    // 회원 성
    private String email;       // 회원 이메일
    private String phone;       // 핸드폰 번호
    private String deleteYn;    // 삭제여부
    private String insertTime;  // 생성날짜
    private String updateTime;  // 수정날짜
    private String deleteTime;  // 삭제날짜
}
