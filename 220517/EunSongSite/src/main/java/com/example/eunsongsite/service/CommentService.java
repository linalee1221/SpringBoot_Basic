package com.example.eunsongsite.service;

import com.example.eunsongsite.model.CommentDto;

import java.util.List;

/**
 * packageName : com.example.eunsongsite.service
 * fileName : cOMMENTsERVICE
 * author : Eunsong LEE
 * date : 2022-05-20
 * description : Dao, Model 을 이용해서 업무로직을 작성하는 인터페이스
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-05-20    Eunsong LEE        최초 생성
 */
public interface CommentService {
    // 댓글 등록 서비스
    public boolean registerComment(CommentDto params);

    // 댓글 삭제 서비스
    public boolean deleteComment(Long idx);

    // 댓글 목록 조회 서비스 - 여러 건 select
    public List<CommentDto> getCommentList(CommentDto params);

    // 댓글 상세 조회 서비스 - 1건 select
    public CommentDto getCommentDetail(Long idx);
}
