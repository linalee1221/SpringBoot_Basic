package com.example.eunsi.controller;

import com.example.eunsi.model.Tutorial;
import com.example.eunsi.service.TutorialService;
import com.example.eunsi.service.TutorialServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * packageName : com.example.eunsi.controller
 * fileName : TutorialController
 * author : Eunsong LEE
 * date : 2022-05-25
 * description : 메뉴(URL 정보들)
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-05-25    Eunsong LEE        최초 생성
 */
// @RestController : REST API 호출을 위한 어노테이션(JSON형태로 들어옴)
// @RequestMapping : http://localhost:8000/api
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:8080")
public class TutorialController {
    @Autowired
    TutorialServiceImpl tutorialService; // 객체 정의 기본값:null

    Logger logger = LoggerFactory.getLogger(this.getClass());

    // @ResponseEntity : 프론트엔드에서 요청 시 결과를 전달할 객체
    @PostMapping("/tutorials")
    public ResponseEntity<Tutorial> createTutorial(@RequestBody Tutorial tutorial) {
        logger.info("#########################createTutorial tutorial {} : ", tutorial);
        // insert or update 호출(id 값을 체크)
        boolean bSuccess = tutorialService.save(tutorial);

        try {
            if(bSuccess == true) {
                // 정상 실행 된 경우
                // ResponseEntity<> (매개변수객체, 상태정보)
                return new ResponseEntity<>(tutorial, HttpStatus.CREATED);
            }
            // 정상 실행이 되지 않은 경우 : 프론트엔드로 NOT_FOUND 전송 
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            // DB 에러가 났을 경우 : 프론트엔드로 INTERNAL_SERVER_ERROR 전송
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // @GetMapping : Select 문 실행
    @GetMapping("/tutorials/{id}")
    public ResponseEntity<Tutorial> getTutorialById(@PathVariable("id") long id) {
        // Optional<Tutorial> : Tutorial 이 null 이면 빈 문자열('')로 바꿔준다
        // Tutorial.get() : null.get() => 콘솔에서 'null 포인트 에러'라고 뜬다
        //                  "".get() => 이렇게 바꿔주면 에러가 나지 않는다
        Optional<Tutorial> tutorial = tutorialService.findById(id);

        // Optional 메소드 : 값이 있으면
        if(tutorial.isPresent()) {
            // ResponseEntity<>(객체, 상태정보) => 프론트엔드로 전송
            return new ResponseEntity<>(tutorial.get(), HttpStatus.OK);
        } else {
            // 프론트엔드로 NOT_FOUND 전송
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/tutorials")
    public ResponseEntity<List<Tutorial>> getTitleTutorials(@RequestParam(required=false) String title) {
//        title(제목)을 조회하는 서비스를 호출
        List<Tutorial> tutorials = tutorialService.findByTitleContaining(title);

        try {
            if(tutorials.isEmpty()) {
                // 조회 데이터가 없는 경우
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
                // 조회 데이터가 있는 경우 : tutorial 전송, 상태정보 OK 전송
            return new ResponseEntity<>(tutorials, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    // UPDATE : @PutMapping
    @PutMapping("/tutorials/{id}")
    public ResponseEntity<Tutorial> updateTutorial(@PathVariable ("id") long id
                                                  ,@RequestBody Tutorial tutorial) {
        // id에 해당하는 데이터가 있는지 조회
        // Optional<객체> : 객체가 null 이면 빈 문자열 " " 로 바꿔줌
        //                 -> null 포인트 에러 방지
        Optional<Tutorial> tutorialData = tutorialService.findById(id);

        if(tutorialData.isPresent()) {
            // tutorialData 가 있는 경우 save 를 호출(id가 있으면 update 됨)
            boolean bSuccess = tutorialService.save(tutorial);
            if(bSuccess == true) {
                // save 호출이 성공 한 경우
                return new ResponseEntity<>(tutorial, HttpStatus.CREATED);
            }
            // save 호출이 실패 한 경우
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            // tutorialData가 없는 경우
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // @PutMapping : update 문 실행
    // 아래 delete 메소드 호출은 내부적으로 (컬럼 delete_yn = 'Y')
    @PutMapping("tutorials/deletion/{id}")
    public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
        // update 문 호출(DELETE_YN = 'Y'로 업데이트)
        boolean bSuccess = tutorialService.deleteById(id);

        // 프론트엔드 쪽으로 상태정보를 보내줌
        try {
            if(bSuccess == true) {
                // update 문이 성공 했을 경우
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            // update 문이 실패 했을 경우(=0건 수정이 될 경우)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
        // DB 에러가 날 경우
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // update 문일 경우 : @PutMapping
    // deleteAll : 모두 삭제(내부적으로 모든 데이터를 DELETE_YN = 'Y'로 처리한다)
    @PutMapping("/tutorials")
    public ResponseEntity<HttpStatus> deleteAllTutorials() {
        // update 문 실행 : 모든 데이터를 DELETE_YN = 'Y'로 처리한다
        boolean bSuccess = tutorialService.deleteAll();

        // 프론트엔드쪽으로 응답정보를 보내줌
        try {
            if(bSuccess == true) {
                // 성공 했을 경우 프론트엔드에 NO_CONTENT 전송
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            // 실패 했을 경우(=0건 update 될 경우)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            // DB 에러가 났을 경우
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // @GetMapping : Select 문 호출(여러 건의 결과가 나옴(List<>))
    @GetMapping("/tutorials/published")
    public ResponseEntity<List<Tutorial>> findByPublished() {
        // 테이블 컬럼 중 published 가 'Y'인 데이터만 조회
        List<Tutorial> tutorials = tutorialService.findByPublished("Y");
        // 프론트엔드쪽에 상태 정보를 전송함
        try {
            if(tutorials.isEmpty()) {
                // tutorials 데이터가 없을 경우
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            // tutorials 데이터가 있을 경우 객체정보와 상태정보를 전송
            return new ResponseEntity<>(tutorials, HttpStatus.OK);
        } catch (Exception e) {
            // DB 에러가 났을 경우
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
