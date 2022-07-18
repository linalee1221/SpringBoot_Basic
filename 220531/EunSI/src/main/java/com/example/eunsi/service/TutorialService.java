package com.example.eunsi.service;

import com.example.eunsi.model.Tutorial;

import java.util.List;
import java.util.Optional;

/**
 * packageName : com.example.eunsi.service
 * fileName : TutorialService
 * author : Eunsong LEE
 * date : 2022-05-25
 * description : DAO, Model을 이용해서 업무로직을 구성하는 클래스
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-05-25    Eunsong LEE        최초 생성
 */
public interface TutorialService {

    public Optional<Tutorial> findById(long id);
    public List<Tutorial> findByPublished(String published);
    public List<Tutorial> findByTitleContaining(String title);
    public List<Tutorial> findAll();

    // insert와 update가 같이 구성되는 메소드
    public boolean save(Tutorial tutorial);

    public boolean deleteById(Long id);
    public boolean deleteAll();


}
