package com.example.eunsi.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * packageName : com.example.euneeuploaddb.model
 * fileName : FileDB
 * author : Eunsong LEE
 * date : 2022-05-31
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-05-31    Eunsong LEE        최초 생성
 */
@Setter
@Getter
@ToString
// @NoArgsConstructor : lombok 에서 지원하는 매개변수 없는 생성자를 자동으로 만들어주는 어노테이션
@NoArgsConstructor
public class FileDB {
    private String id; // 첨부파일 아이디
    private String name; // 첨부파일 이름
    private String type; // 첨부파일 유형(image, text 등)
    private byte[] data; // oracle 에 이미지를 담는 자료형(blob) : byte[]

    // 매개변수 3개짜리 생성자
    public FileDB(String name, String type, byte[] data) {
        this.name = name;
        this.type = type;
        this.data = data;
    }
}
