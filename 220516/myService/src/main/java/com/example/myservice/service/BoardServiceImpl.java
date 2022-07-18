package com.example.myservice.service;

import com.example.myservice.dao.BoardDao;
import com.example.myservice.dao.DeptDao;
import com.example.myservice.model.Board;
import com.example.myservice.model.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * packageName : com.example.myservice.service
 * fileName : BoardServiceImpl
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
public class BoardServiceImpl implements BoardService{

    @Autowired
    BoardDao boardDao;

//    @Override
//    public List<Dept> selectList() {
//        return null;
//    }

//    select 문을 실행하는 서비스
    @Override
    public List<Board> selectAll() {
        return boardDao.selectAll();
    }

    @Override
    public void insertMember(Board board) {
//        DB에 insert문 실행하는 부분
        boardDao.insert(board);
    }
}









