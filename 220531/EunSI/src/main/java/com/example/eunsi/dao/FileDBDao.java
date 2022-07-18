package com.example.eunsi.dao;


import com.example.eunsi.model.FileDB;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * packageName : com.example.euneeuploaddb.dao
 * fileName : FileDBDao
 * author : Eunsong LEE
 * date : 2022-05-31
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-05-31    Eunsong LEE        최초 생성
 */
// Mybatis를 이용
@Mapper
public interface FileDBDao {
    // id로 찾는 메소드
    FileDB findById(String id);

    // 모든 이미지 목록을 찾는 메소드(여러건)
    List<FileDB> findAll();

    // 업로드 이미지 저장 메소드
    int save(FileDB fileDB);
}
