package com.example.eunsongsite.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * packageName : com.example.eunsongsite.model
 * fileName : CommentDto
 * author : Eunsong LEE
 * date : 2022-05-19
 * description : 댓글을 위한 모델 클래스(DB데이터가 저장되는 클래스)
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-05-19    Eunsong LEE        최초 생성
 */

@Getter
@Setter
@ToString
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class CommentDto extends CommonDto {
//
//    IDX NUMBER NOT NULL,      -- 댓글번호
//    BOARD_IDX NUMBER,          -- 게시판번호
//    CONTENT VARCHAR2(1000), -- 댓글내용
//    WRITER VARCHAR2(255),      -- 댓글작성자
//    DELETE_YN CHAR(1) DEFAULT 'N', -- 댓글삭제여부
//    INSERT_DATE DATE,             -- 댓글등록일시
//    UPDATE_DATE DATE,            -- 댓글수정일시
//    DELETE_DATE DATE              -- 댓글삭제일시

    private Long idx; // 댓글 멤버변수
    private Long boardIdx; // 게시판번호
    private String content; // 댓글내용
    private String writer; // 댓글작성자
}
