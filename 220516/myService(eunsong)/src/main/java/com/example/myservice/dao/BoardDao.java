package com.example.myservice.dao;

import com.example.myservice.model.Board;
import com.example.myservice.model.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * packageName : com.example.myservice.dao
 * fileName : MemberDao
 * author : ds
 * date : 2022-05-12
 * description : 부서테이블에 접근해서 데이터를 처리할 클래스 ( DAO )
 *              ( CRUD : Insert / Select / Update / Delete )
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-05-12         ds          최초 생성
 */

@Mapper
public interface BoardDao {
//    select 문 메소드
    List<Board> selectAll(); // 부서정보를 select하는 메소드

    void insert(Board board); // 부서정보를 insert하는 메소드

}
