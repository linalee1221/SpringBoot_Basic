package com.example.eunsongsite.dao;

import com.example.eunsongsite.model.BoardDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * packageName : com.example.eunsongsite.dao
 * fileName : BoardDao
 * author : Eunsong LEE
 * date : 2022-05-17
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-05-17    Eunsong LEE        최초 생성
 */
// @Mapper : MyBatis 에서 사용하는 어노테이션. xml 에서 interface 를 구현함
@Mapper
public interface BoardDao {
    // insert SQL 문을 위한 메소드
    int insertBoard(BoardDto params);

    // 게시판 목록을 조회하는 메소드(select SQL 문)
    List<BoardDto> selectBoardAllList();

    // 게시판 페이징 처리를 위한 메소드
    List<BoardDto> selectBoardList(BoardDto params);

    // 게시판 상세 목록을 조회하는 메소드(매개변수가 게시판 번호인 select SQL 문)
    BoardDto selectBoardDetail(Long idx);

    // 게시물의 총 건수를 가져오는 메소드(select : 1건)
    int selectBoardTotalCount(BoardDto params);

    // 게시판 글 수정 메소드
    int updateBoard(BoardDto params);

    // 게시판 글 삭제 메소드
    int deleteBoard(Long idx);
}
