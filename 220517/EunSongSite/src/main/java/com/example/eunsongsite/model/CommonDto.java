package com.example.eunsongsite.model;

import com.example.eunsongsite.paging.Criteria;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * packageName : com.example.eunsongsite.model
 * fileName : CommonDto
 * author : Eunsong LEE
 * date : 2022-05-18
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-05-18    Eunsong LEE        최초 생성
 */
// 롬북에서 제공하는 어노테이션
@Getter
@Setter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class CommonDto extends Criteria {
    // 삭제 여부(Y,N)
    private String deleteYn;
    // 등록일
    private LocalDateTime insertTime;
    // 수정일
    private LocalDateTime updateTime;
    // 삭제일
    private LocalDateTime deleteTime;
}
