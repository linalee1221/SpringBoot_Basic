package com.example.customerspring.controller;

import com.example.customerspring.model.Customer;
import com.example.customerspring.service.CustomerService;
import com.example.customerspring.service.CustomerServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * packageName : com.example.customerspring.controller
 * fileName : CustomerController
 * author : Eunsong LEE
 * date : 2022-06-07
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-06-07    Eunsong LEE        최초 생성
 */
@CrossOrigin(origins = "http://localhost:8080") // 기본 보안 허용
@RestController // json 형태로 통신을 주고 받고 싶을 때 사용함
@RequestMapping("/api")
public class CustomerController {

    // logger 찍기를 위한 객체 생성
    Logger logger = LoggerFactory.getLogger(this.getClass());

    // 객체정의(null => 스프링객체)
    @Autowired
    private CustomerServiceImpl customerService;

    // 모든 회원 조회 메뉴
    @GetMapping("/customers")
    public ResponseEntity<Object> getAllCustomers() {

        // 모든 회원 조회 서비스 호출
        List<Customer> customers = customerService.findAll();
        logger.info("customers {} ", customers);
        
        try {
            // vue에 성공메세지와 객체를 전송
            return new ResponseEntity<Object>(customers, HttpStatus.OK);
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            // vue에 에러메세지를 전송
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }

    // 회원 생성 메뉴
    @PostMapping("/customers")
    public ResponseEntity<Object> createCustomer(@RequestBody Customer customer) {

        logger.info("createCustomer : customer {} ", customer);

        // save 리턴값이 Optional<Customer> => save().get()으로 객체를 꺼냄
        Customer savedCustomer = customerService.save(customer).get();

        try {
            if (savedCustomer != null) {
                // vue에 객체와 성공메세지 전송
                return new ResponseEntity<Object>(customer, HttpStatus.OK);
            }
            // 정상실행 안된 경우
            return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            // vue에 보낼 에러메세지 전송
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }

    // id로 회원을 조회하는 메뉴
    @GetMapping("/customers/{id}")
    public ResponseEntity<Object> getCustomerById(@PathVariable("id") Long id) {
        // id로 회원을 조회하는 서비스 호출(optional 벗겨내기 : get())
        Customer customer = customerService.findById(id).get();
        
        try {
            if(customer != null) {
                // 성공했을 경우 vue에 객체와 성공메세지 전송
                return new ResponseEntity<Object>(customer, HttpStatus.OK);
            } else {
                // 데이터가 없을 경우 vue에 Not found 전송
                return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            // vue에 에러메세지 전송
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }

    // id로 조회한 회원 수정 메뉴
    // vue에서 전송 : url 매개변수 + 객체
    // @PathVariable : url의 매개변수를 받는 어노테이션
    // @RequestBody : 객체를 받는 어노테이션
    @PutMapping("/customers/{id}")
    public ResponseEntity<Object> updateCustomer(@PathVariable("id") Long id,
                                                 @RequestBody Customer customer)
    {
        try {
            // customer에 id값을 저장 후 save 호출 실행
            customer.setId(id);
            // id가 null일 경우 = insert
            // id가 not null일 경우 = update
            // .get() : Optional<Customer> => Customer 객체를 꺼냄
            Customer savedCustomer = customerService.save(customer).get();

            // vue에 DB에 저장된 객체와 상태메세지(OK)를 전송함
            return new ResponseEntity<Object>(savedCustomer, HttpStatus.OK);

        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            // vue에 에러메세지 전송
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }

    // id로 조회한 회원 삭제 메뉴
    // /customers/delection/${id}
    @PutMapping("/customers/deletion/{id}")
    public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable("id") Long id) {
        try {
            // id로 조회한 회원을 삭제하는 서비스를 호출(내부적으로는 실제 삭제가 아닌 updqte문이 실행됨)
            customerService.deleteById(id);
            // vue에 성공메세지 전송
            return new ResponseEntity<HttpStatus>(HttpStatus.OK);

        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            // 웹애플리케이션 개발 : 클라이언트(Vue, React, HTML) <=> 서버(SpringBoot, Node)
            // vue(클라이언트)에 에러메세지를 전송
            return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
        }

    }

}
