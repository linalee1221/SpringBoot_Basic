package com.example.eunsongsite.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * packageName : com.example.eunsongsite.model
 * fileName : BoardDto
 * author : Eunsong LEE
 * date : 2022-05-17
 * description : 개발 순서
 *              1) Model
 *              2) Dao
 *              3) XML
 *              4) Service
 *              5) Controller
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-05-17    Eunsong LEE        최초 생성
 */
@Getter
@Setter
@ToString
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class BoardDto extends CommonDto {
    // 번호(PK : 기본키)
    private Long idx;
    // 제목
    private String title;
    // 내용
    private String content;
    // 작성자
    private String writer;
    // 조회 수
    private int viewCnt;
    // 공지 여부(Y,N)
    private String noticeYn;
    // 비밀 여부(Y,N)
    private String secretYn;
}
