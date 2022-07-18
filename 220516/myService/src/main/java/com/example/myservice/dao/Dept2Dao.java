package com.example.myservice.dao;

import com.example.myservice.model.Dept;
import com.example.myservice.model.Dept2;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * packageName : com.example.myservice.dao
 * fileName : DeptDao
 * author : ds
 * date : 2022-05-12
 * description : 부서테이블에 접근해서 데이터를 처리할 클래스 ( DAO )
 *              ( CRUD : Insert / Select / Update / Delete )
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-05-12         ds          최초 생성
 */
// @Mapper : mybatis 에서 사용하는 어노테이션
//    xml문에서 select문을 작성하게 만들어 줌
@Mapper
public interface Dept2Dao {
//    select 문 메소드
//    List<Dept> selectList(); // 부서정보를 select하는 메소드
    List<Dept2> selectAll(); // 부서정보를 select하는 메소드

    Dept2 selectById(int dno); // 부서번호에 해당하는 데이터 조회 메소드

    void insert(Dept2 dept2); // 부서정보를 insert하는 메소드

    void update(Dept2 dept2); // 부서번호에 해당하는 데이터 수정

    void delete(int dno); // 부서번호에 해당하는 데이터

}
