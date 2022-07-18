package com.example.eunsongsite.service;

import com.example.eunsongsite.dao.BoardDao;
import com.example.eunsongsite.model.BoardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * packageName : com.example.eunsongsite.service
 * fileName : BoardServiceImpl
 * author : Eunsong LEE
 * date : 2022-05-18
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-05-18    Eunsong LEE        최초 생성
 */
// @Service : 스프링에 객체로 생성되는 어노테이션
@Service
public class BoardServiceImpl implements BoardService {

    // 아래 멤버변수에 스프링의 객체를 넣어줌
    @Autowired
    private BoardDao boardDao; // 객체생성이 실제로 되는것은 아니고 정의만 해둠

    // 게시판에 Idx(글번호)가 없으면 insert 문 실행(사용자가 새글쓰기 버튼을 클릭한 경우)
    // 있으면 update 문 실행(사용자가 글목록 버튼을 클릭+수정버튼을 클릭한 경우)
    @Override
    public boolean registerBoard(BoardDto params) {
        // insert 또는 update 결과를 저장하는 변수
        // 위의 SQL 문이 정상 실행되면 1, 아니면 다른 값
        int queryResult = 0;


        if(params.getIdx() == null) {
            // 새 글 쓰기(insert 문 실행)
            queryResult = boardDao.insertBoard(params);
        } else {
            // 상세 목록에서 글 수정(update 문 실행)
            queryResult = boardDao.updateBoard(params);
        }
        return (queryResult == 1) ? true : false;
    }

    @Override
    public BoardDto getBoardDetail(Long idx) {
        // 글번호(idx)에 해당하는 상세 목록 보기(select 문 실행 : 1건)
        return boardDao.selectBoardDetail(idx);
    }

    @Override
    public List<BoardDto> getBoardAllList() {
        List<BoardDto> boardList = Collections.emptyList();

        // select (전체 게시물) 문 실행
        boardList = boardDao.selectBoardAllList();

        return boardList;
    }


    // 게시판 번호를 받아서 게시물을 삭제하는 서비스
    @Override
    public boolean deleteBoard(Long idx) {

        int queryResult = 0;

        // 게시물이 있는지 확인하는 절차(select : 1건)
        // 게시물이 있으면 board가 null이 아님
        BoardDto board = boardDao.selectBoardDetail(idx);

        // Delete_YN이 "N"일 경우, board != null 일 경우 삭제를 진행
        if(board != null && "N".equals(board.getDeleteYn())) {
            // 게시물 삭제 서비스(내부적으로 실제 삭제가 진행되는 것은 아님)
            queryResult = boardDao.deleteBoard(idx);
        }

        return (queryResult == 1) ? true : false;
    }

    // 게시판 페이징 처리를 위한 서비스 구현
    @Override
    public List<BoardDto> getBoardList(BoardDto params) {
        List<BoardDto> boardDto = Collections.emptyList();

        // DB params 에 해당하는 데이터가 있는지 먼저 확인함
        int boardTotalCount = boardDao.selectBoardTotalCount(params);
        System.out.println("boardTotalCount : " + boardTotalCount);
        if(boardTotalCount > 0) {
            // 페이징 처리 서비스 호출
            boardDto = boardDao.selectBoardList(params);
            System.out.println("boardDto : " + boardDto);
        }


        return boardDto;
    }
}
