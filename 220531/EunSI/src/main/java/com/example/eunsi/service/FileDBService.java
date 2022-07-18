package com.example.eunsi.service;


import com.example.eunsi.dao.FileDBDao;
import com.example.eunsi.model.FileDB;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.stream.Stream;

/**
 * packageName : com.example.euneeuploaddb.service
 * fileName : FileStorageService
 * author : Eunsong LEE
 * date : 2022-05-31
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-05-31    Eunsong LEE        최초 생성
 */
// @Service : FileDBService 클래스도 스프링의 객체로 생성됨
@Service
public class FileDBService {

    // @Autowired : 스프링 객체를 받아오는 어노테이션
    @Autowired
    private FileDBDao fileDBDao;

    // 로그 클래스 정의
    Logger logger = LoggerFactory.getLogger(this.getClass());

    // insert 문을 호출하는 서비스(업로드 이미지 DB가 저장됨)
    public int store(MultipartFile file) throws IOException {

        // 매개변수로 들어오는 이미지파일의 경로를 제거해서 순수 파일 이름만 얻기

        // 순수 파일 이름이 얻어짐
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        // 이미지 파일이 생성됨
        FileDB fileDB = new FileDB(fileName, file.getContentType(), file.getBytes());

        // DB에 insert 문 호출
        return fileDBDao.save(fileDB);
    }

    // 이미지 정보 가져오기 서비스(결과 : 한 건)
    public FileDB getFile(String id) {
        return fileDBDao.findById(id);
    }

    // 모든 이미지 목록을 가져오는 서비스(결과 : 여러건)
    public Stream<FileDB> getAllFile() {
        // List, Map, Set => 인터페이스
        // ArrayList, HashMap, HashSet => 구현클래스
        // List, Map, Set => Stream 변환 가능(반대로도 변환 가능)
        // Stream의 편한 함수들을 쓰기 위함(map, foreach, filter 등등..)

        Stream<FileDB> resFileDB = fileDBDao.findAll().stream();

        return resFileDB;
    }

}
