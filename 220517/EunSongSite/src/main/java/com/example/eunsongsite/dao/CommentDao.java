package com.example.eunsongsite.dao;

import com.example.eunsongsite.model.CommentDto;
import org.apache.ibatis.annotations.Mapper;

import javax.xml.stream.events.Comment;
import java.util.List;

/**
 * packageName : com.example.eunsongsite.dao
 * fileName : CommentDao
 * author : Eunsong LEE
 * date : 2022-05-20
 * description : CRUD를 위한 인터페이스
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-05-20    Eunsong LEE        최초 생성
 */
// @Mapper : Mybatis를 사용하겠다는 의미로 거는 어노테이션
@Mapper
public interface CommentDao {
    int insertComment(CommentDto params); // 댓글 추가 메소드

    CommentDto selectCommentDetail(Long idx); // 댓글 상세 메소드

    int updateComment(CommentDto params); // 댓글 수정 메소드

    int deleteComment(Long idx); // 댓글 삭제 메소드

    List<CommentDto> selectCommentList(CommentDto params); // 댓글 목록 조회 메소드

    int selectCommentTotalCount(CommentDto params); //Eㅐㅅ글ㅇ테이블 건ㅅ조회
}
