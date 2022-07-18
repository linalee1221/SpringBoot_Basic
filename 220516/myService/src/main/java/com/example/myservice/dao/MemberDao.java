package com.example.myservice.dao;

import com.example.myservice.model.Dept;
import com.example.myservice.model.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * packageName : com.example.myservice.dao
 * fileName : MemberDao
 * author : ds
 * date : 2022-05-12
 * description : 회원테이블에 접근해서 데이터를 처리할 클래스 ( DAO )
 *              ( CRUD : Insert / Select / Update / Delete )
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-05-12         ds          최초 생성
 */
// @Mapper : mybatis 에서 사용하는 어노테이션
//    xml문에서 select문을 작성하게 만들어 줌
@Mapper
public interface MemberDao {
//    select 문 메소드
    List<Member> selectAll(); // 회원정보를 select하는 메소드

    void insert(Member member); // 회원정보를 insert하는 메소드

}
