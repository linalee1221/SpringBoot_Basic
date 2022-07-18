package com.example.eunsongsite.service;

import com.example.eunsongsite.model.BoardDto;

import java.util.List;

/**
 * packageName : com.example.eunsongsite.service
 * fileName : BoardService
 * author : Eunsong LEE
 * date : 2022-05-18
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-05-18    Eunsong LEE        최초 생성
 */
public interface BoardService {
    // 게시판에 insert 하는 서비스
    boolean registerBoard(BoardDto params);

    // 상세 목록을 확인하는 서비스 (select)
    BoardDto getBoardDetail(Long idx);

    // 게시판의 전체 글 목록을 가져오는 서비스 (select)
    public List<BoardDto> getBoardAllList();

    // 페이징 처리를 위한 서비스
    public List<BoardDto> getBoardList(BoardDto params);

    // 게시판 글을 삭제하는 서비스 (update) : delete_YN = 'Y'로 수정
    // 실제 데이터를 삭제하지는 않음
    public boolean deleteBoard(Long idx);

}
