package com.example.myservice.service;

import com.example.myservice.dao.Dept2Dao;
import com.example.myservice.dao.DeptDao;
import com.example.myservice.model.Dept;
import com.example.myservice.model.Dept2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * packageName : com.example.myservice.service
 * fileName : DeptServiceImpl
 * author : ds
 * date : 2022-05-12
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-05-12         ds          최초 생성
 */
// Service 컴포넌트가 되어서 스프링에 객체로 등록됨
// Why ? @ComponentScan : (대상 : @Component, @Service, @repository )
//        컴포넌트들을 자동으로 검색해서 스프링에 등록해주는 어노테이션
@Service
public class Dept2ServiceImpl implements Dept2Service{

    @Autowired
    Dept2Dao dept2Dao;

//    @Override
//    public List<Dept> selectList() {
//        return null;
//    }

//    select 문을 실행하는 서비스
    @Override
    public List<Dept2> selectAll() {
        return dept2Dao.selectAll();
    }

    @Override
    public void insertMember(Dept2 dept2) {
//        DB에 insert문 실행하는 부분
        dept2Dao.insert(dept2);
    }


    @Override
    public void updateMember(int dno, Dept2 updateDept2) {
//        dno : 부서번호로 먼저 데이터가 테이블에 있는지 확인
        Dept2 dept2 = dept2Dao.selectById(dno);

//        데이터가 있을때만 update함
        if(dept2 != null) {
//            매개변수 updateDept : 수정될 데이터
//            dept : 현재 db에 저장되어 있는 값
//            setter : 데이터 저장
//            getter : 데이터 조회, 검색
            dept2.setDname(updateDept2.getDname());
            dept2.setLoc(updateDept2.getLoc());
//            위에 setter를 통해 수정된 dept를 매개변수로 전달
//            update문을 실행해서 db에 반영(수정반영)
            dept2Dao.update(dept2);
        } else {
//            dept 가 null이면 db에 데이터가 없음(부서번호에 해당하는)
            throw new IllegalStateException("부서가 존재하지 않습니다.");
        }
    }

    //    delete 구현
    @Override
    public void deleteMember(int dno) {
        // dno : 부서번호로 먼저 데이터가 테이블에 있는지 확인
        Dept2 dept2 = dept2Dao.selectById(dno);

        if(dept2 != null) {
//            부서번호가 있으면 삭제 처리
            dept2Dao.delete(dno);

        } else {
//            부서번호가 없으면 에러 처리
            throw new IllegalStateException("부서가 존재하지 않습니다.");
        }
    }
}









