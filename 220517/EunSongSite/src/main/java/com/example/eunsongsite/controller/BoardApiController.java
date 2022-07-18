package com.example.eunsongsite.controller;

import com.example.eunsongsite.model.BoardDto;
import com.example.eunsongsite.model.CommentDto;
import com.example.eunsongsite.service.BoardService;
import com.example.eunsongsite.service.BoardServiceImpl;
import com.example.eunsongsite.service.CommentService;
import com.example.eunsongsite.service.CommentServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * packageName : com.example.eunsongsite.controller
 * fileName : BoardApiController
 * author : Eunsong LEE
 * date : 2022-05-18
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-05-18    Eunsong LEE        최초 생성
 */
// @RestController : json / text 형태로 프론트엔드에 전송함
// @Controller : html / jsp / 타임리프 파일로 바로 출력
// 예시) http://localhost:8000/api/board/
// @RequestMapping("/api") : 위의 api를 자동으로 설정해줌

@RestController
@RequestMapping("/api")
public class BoardApiController {

    // 로그 정의 : slf4j 로그
    Logger logger = LoggerFactory.getLogger(this.getClass());

    // @Autowired : 스프링에서 객체를 받아서 아래 멤버변수에 넣어준다.
    @Autowired
    BoardServiceImpl boardService; // 정의

    @Autowired
    CommentServiceImpl commentService; // 정의

    @GetMapping("/board/write/{idx}")
    public BoardDto openBoardWrite(@PathVariable("idx") Long idx) {

        // 상세 목록 보기 서비스를 호출(select : 1건)
        BoardDto detail = boardService.getBoardDetail(idx);
        return detail;
    }


    // @PostMapping : insert 할 때 사용하는 어노테이션
    // @RequestBody : 입력테스트 시 json 형태로 데이터를 전송함
    @PostMapping("/board/register")
    public List<BoardDto> registerBoard(@RequestBody BoardDto boardDto) {

        // insert 완료 후 데이터 확인을 위한 전체 조회(select)
        return boardService.getBoardAllList();
    }

    // @PutMapping : update 문 실행
    @PutMapping(value="/board/delete/{idx}")
    public List<BoardDto> deleteBoard(@PathVariable("idx") Long idx) {

        // 삭제 서비스 호출
        boolean isDeleted = boardService.deleteBoard(idx);

        // 삭제 되었는지 전체 조회
        return boardService.getBoardAllList();
    }

    // 페이징 처리를 위한 게시물 검색 메뉴
    @GetMapping("/board/list/cur-page-no/{currentPageNo}/records-per-page/{recordsPerPage}")
    public List<BoardDto> openBoardList(BoardDto params) {
        System.out.println("params:" + params.getCurrentPageNo() + params.getRecordsPerPage());
        return boardService.getBoardList(params);
    }

    // 페이징 처리를 위한 게시물 검색 메뉴2
    @GetMapping("/board/list/cpage/{currentPageNo}/rpage/{recordsPerPage}/sword/{searchKeyword}/stype/{searchType}")
    public List<BoardDto> openBoardList2(BoardDto params) {
        System.out.println("params:" + params.getCurrentPageNo() + params.getRecordsPerPage());
        return boardService.getBoardList(params);
    }


    // 댓글 메뉴들 ------------------------------------------------------------------------------------------------------
    // 댓글 추가
    @PostMapping("/board/comments")
    public List<CommentDto> registerBoard(@RequestBody CommentDto commentDto) {

        // insert : 댓글 추가
        boolean isRegistered = commentService.registerComment(commentDto);

        // 추가 된 댓글 확인
        return commentService.getCommentList(commentDto);
    }

    // 댓글 조회
    // 전통적인 개발방법 : URL(http://localhost:8080/board?name=eunsonglee)
    // REST API 개발방법 : URL(http://localhost:8080/board/{name})
    // board/1/comments => board 게시물 1번의 댓글을 조회하는 메뉴
    // board/comments/1 => board 게시물 1번의 댓글 1번을 조회하는 메뉴
    @GetMapping("board/{boardIdx}/comments")
    public List<CommentDto> openCommentList(CommentDto commentDto) {

        // 콘솔에 로그 찍기
        logger.info(" commentDto :  {} ", commentDto);
        // 게시물 번호를 받아서 댓글을 조회하는 메뉴
        return commentService.getCommentList(commentDto);
    }

    // 댓글 상세 조회
    // @PathVariable : URL {idx} -> 메소드의 매개변수로 전달됨
    // idx : 댓글번호, board_idx : 게시물번호
    @GetMapping("/board/comments/{idx}")
    public CommentDto openCommentdetail(@PathVariable("idx") Long idx) {

        logger.info("openCommentDetail(idx): ", idx);

        return commentService.getCommentDetail(idx);
    }

    // 댓글 삭제
    @PutMapping("/board/comments/{boardIdx}/delection/{idx}")
    public List<CommentDto> deleteComment(CommentDto commentDto) {

        // 삭제 서비스 호출
        boolean isDeleted = commentService.deleteComment(commentDto.getIdx());
        // 삭제가 잘 되었는지 댓글 목록을 조회
        return commentService.getCommentList(commentDto);
    }

}
