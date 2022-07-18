package com.example.eunsi.dao;

import com.example.eunsi.model.Tutorial;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

/**
 * packageName : com.example.eunsi.dao
 * fileName : TutorialDao
 * author : Eunsong LEE
 * date : 2022-05-25
 * description : DB CRUD를 위한 인터페이스(XML MyBatis 연동)
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-05-25    Eunsong LEE        최초 생성
 */
@Mapper
public interface TutorialDao {

    // 화면에서 publish 버튼을 클릭할 때 적용되는 메소드
    List<Tutorial> findByPublished(String published);

    // 제목 검색을 위한 메소드
    List<Tutorial> findByTitleContaining(String title);

    // 모든 데이터 조회
    List<Tutorial> findAll();

    // id에 해당하는 값을 조회
    // Optional : null을 방지하는 클래스
    Optional<Tutorial> findById(Long id);

    // Tutorial 테이블에 데이터 입력 메소드
    int insertTutorial(Tutorial tutorial);

    // Tutorial 테이블에 데이터 수정 메소드
    int updateTutorial(Tutorial tutorial);

    // Tutorial 테이블에 데이터 삭제 메소드
    int deleteTutorial(Long id);

    // Tutorial 테이블에 데이터 모두 삭제 메소드(deleteYn = 'Y')
    int deleteAll();
}
