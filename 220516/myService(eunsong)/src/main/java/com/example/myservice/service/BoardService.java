package com.example.myservice.service;

import com.example.myservice.model.Board;
import com.example.myservice.model.Member;

import java.util.List;

/**
 * packageName : com.example.myservice.service
 * fileName : BoardService
 * author : ds
 * date : 2022-05-12
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-05-12         ds          최초 생성
 */
public interface BoardService {
//    public List<Dept> selectList();
      public List<Board> selectAll(); // 부서정보 select하는 서비스

//    insert의 Dao와 연결된 서비스 메소드
      void insertMember(Board board);
}









