package com.example.eunsongsite.service;

import com.example.eunsongsite.dao.CommentDao;
import com.example.eunsongsite.model.CommentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * packageName : com.example.eunsongsite.service
 * fileName : CommentServiceImpl
 * author : Eunsong LEE
 * date : 2022-05-20
 * description : CommentService 인터페이스를 상속한 클래스
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-05-20    Eunsong LEE        최초 생성
 */
// @Service : 스프링에 객체 생성
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao; // 객체정의 (null=>스프링 객체)

    @Override
    public boolean registerComment(CommentDto params) {
        int queryResult = 0;

        // 댓글 새 글 쓰기 : idx(댓글번호)가 null 이면 새 글 쓰기가 됨
        if(params.getIdx() == null) {
            queryResult = commentDao.insertComment(params);
        } else {
        // idx(댓글번호)가 null 이 아니라면 현재 등록된 댓글을 수정함
            queryResult = commentDao.updateComment(params);
        }
        // queryResult == 1이면 쿼리실행 성공, 1이 아니면 실패
        return (queryResult == 1)? true : false;
    }

    // 댓글 삭제 서비스 구현
    @Override
    public boolean deleteComment(Long idx) {
        int queryResult = 0;

        // TB_COMMENT_SSONG 테이블에 IDX(댓글번호) 데이터가 있는지 확인
        CommentDto comment = commentDao.selectCommentDetail(idx);

        // comment가 null이 아니면 댓글번호가 있음을 의미함 + Delete_YN = 'N' 삭제진행
        if (comment != null && "N".equals(comment.getDeleteYn())) {
            queryResult = commentDao.deleteComment(idx);

        }
        // queryResult 는 SQL 문이 정상 수행되면 1, 아니면 1이 아닌값
        return (queryResult == 1)? true : false;
    }

    @Override
    public List<CommentDto> getCommentList(CommentDto params) {

        List<CommentDto> commentList = Collections.emptyList(); // 빈 값으로 초기화

        // 댓글 테이블에 데이터가 있는지 없는지 먼저 확인
        // 조건 : 게시물번호에 댓글이 있어야 함(참조무결성 체크)
        int commentTotalCount = commentDao.selectCommentTotalCount(params);

        if(commentTotalCount > 0) {
            commentList = commentDao.selectCommentList(params);
        }
        return commentList;
    }

    // 댓글 상세조회 서비스 구현
    @Override
    public CommentDto getCommentDetail(Long idx) {

        CommentDto commentDto = commentDao.selectCommentDetail(idx);
        return commentDto;
    }
}
