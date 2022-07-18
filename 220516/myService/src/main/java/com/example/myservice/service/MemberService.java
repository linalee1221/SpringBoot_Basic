package com.example.myservice.service;

import com.example.myservice.model.Dept;
import com.example.myservice.model.Member;

import java.util.List;

/**
 * packageName : com.example.myservice.service
 * fileName : MemberService
 * author : ds
 * date : 2022-05-12
 * description : 회원정보를 조회하는 서비스 ( 인터페이스 )
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-05-12         ds          최초 생성
 */
public interface MemberService {
      public List<Member> selectAll(); // 회원정보 select하는 서비스

//    insert의 Dao와 연결된 서비스 메소드
    void insertMember(Member member);
}









