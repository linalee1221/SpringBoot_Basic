package com.example.euneeuploaddb.message;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * packageName : com.example.euneeuploaddb.message
 * fileName : ResponseFile
 * author : Eunsong LEE
 * date : 2022-06-02
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-06-02    Eunsong LEE        최초 생성
 */
@Getter
@Setter
// @AllArgsConstructor : Lombok에서 제공하는 모든 매개변수를 가진 생성자
@AllArgsConstructor
public class ResponseFile {
    //    TB_FILES테이블의 컬럼정보를 토대로 만든 클래스
//    이미지 정보
    private String name; // 첨부파일 이름
    private String url;  // 첨부파일 주소 ( C:/work/upload )
    private String type; // 이미지 유형 ( 이미지, 텍스트 등 )
    private long size; // 이미지 크기

}










