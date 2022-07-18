package com.example.myservice.service;

import com.example.myservice.dao.DeptDao;
import com.example.myservice.dao.MemberDao;
import com.example.myservice.model.Dept;
import com.example.myservice.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * packageName : com.example.myservice.service
 * fileName : MemberServiceImpl
 * author : ds
 * date : 2022-05-12
 * description : 인터페이스를 상속한 구현클래스
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-05-12         ds          최초 생성
 */
// Service 컴포넌트가 되어서 스프링에 객체로 등록됨
// Why ? @ComponentScan : (대상 : @Component, @Service, @repository )
//        컴포넌트들을 자동으로 검색해서 스프링에 등록해주는 어노테이션
@Service
public class MemberServiceImpl implements MemberService{

    @Autowired
    MemberDao memberDao; // 객체를 생성한게 아니고 정의해둔것.



//    @Override
//    public List<Dept> selectList() {
//        return null;
//    }

//    select 문을 실행하는 서비스
    @Override
    public List<Member> selectAll() {
        return memberDao.selectAll();
    }

    @Override
    public void insertMember(Member member) {
//        DB에 insert문 실행하는 부분
        memberDao.insert(member);
    }
}









