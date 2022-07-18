package com.example.myservice.service;

import com.example.myservice.model.Dept;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * packageName : com.example.myservice.service
 * fileName : DeptService
 * author : ds
 * date : 2022-05-12
 * description : 부서정보를 조회하는 서비스 ( 인터페이스 )
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-05-12         ds          최초 생성
 */
public interface DeptService {
//    public List<Dept> selectList();
      public List<Dept> selectAll(); // 부서정보 select하는 서비스

//    insert의 Dao와 연결된 서비스 메소드
    void insertMember(Dept dept);

//    update 서비스 추가
    void updateMember(int dno, Dept updateDept);

//    delete 서비스 추가
    void deleteMember(int dno);
}









