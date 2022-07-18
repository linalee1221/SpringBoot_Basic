package com.example.eunsi.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * packageName : model
 * fileName : Tutorial
 * author : Eunsong LEE
 * date : 2022-05-25
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-05-25    Eunsong LEE        최초 생성
 */
@Getter
@Setter
@ToString
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Tutorial {

    private Long id;
    private String title;
    private String description;
    private String published;
    private String deleteYn;
    private String insertTime;
    private String updateTime;
    private String deleteTime;

}
