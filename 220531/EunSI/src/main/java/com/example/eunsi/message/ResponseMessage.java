package com.example.eunsi.message;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * packageName : com.example.euneeuploaddb.message
 * fileName : ResponseMessage
 * author : Eunsong LEE
 * date : 2022-06-02
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-06-02    Eunsong LEE        최초 생성
 */
@Setter
@Getter
@ToString
public class ResponseMessage {
    //    메세지를 담을 변수
    private String message;

    public ResponseMessage(String message) {
        this.message = message;
    }
}











