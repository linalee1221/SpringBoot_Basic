package com.example.customerspring.service;

import com.example.customerspring.dao.CustomerDao;
import com.example.customerspring.model.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * packageName : com.example.customerspring.service
 * fileName : CustomerServiceImpl
 * author : Eunsong LEE
 * date : 2022-06-07
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-06-07    Eunsong LEE        최초 생성
 */
@Service // 스프링에 객체 생성

public class CustomerServiceImpl implements CustomerService {
    // 스프링에 customerDao가 이미 생성되어 있다
    // customerDao에 @Mapper를 걸어놓았기 때문에 이미 객체는 생성되어 있음
    @Autowired // 생성된 객체를 받아오는 어노테이션
    private CustomerDao customerDao; // 객체 정의(null), @Autowired를 걸었기 때문에 null -> 스프링객체

    // 나중에 에러 로그 추적을 위해 생성
    Logger logger = LoggerFactory.getLogger(this.getClass());

    // id로 회원을 조회하는 메소드(결과 : 1건)
    @Override
    public Optional<Customer> findById(long id) {
        return customerDao.findById(id);
    }

    // 전체 회원을 조회하는 메소드(결과 : 여러건)
    @Override
    public List<Customer> findAll() {
        return customerDao.findAll();
    }

    // 회원 생성 / 수정 서비스(insert/update)
    @Override
    public Optional<Customer> save(Customer customer) {
        // db 시퀀스 번호 저장을 위한 변수
        long seqId = 0;

        // 매개변수 customer 정보 출력
        logger.info("customer {} : ", customer);

        // customer.getId() 없으면 insert 문 호출(새로운 회원 생성)
        if(customer.getId() == null) {
            customerDao.insertCustomer(customer);
        }
        // customer.getId() 있으면 update 문 호출
        else {
            customerDao.updateCustomer(customer);
        }

        // insert 문 후에는 customer의 id 속성에 값이 저장됨(<selectkey>)
        seqId = customer.getId();
        logger.info("seqId {} : ", seqId);

        return customerDao.findById(seqId);
    }

    // delete / update / insert 문은 결과 실행 후,
    // 정상 실행되면 (삭제/수정/생성) 건수가 표시됨
    @Override
    public boolean deleteById(Long id) {
        int queryResult = 0;

        queryResult = customerDao.deleteCustomer(id);
        return (queryResult >= 1) ? true : false;
    }

    @Override
    public boolean deleteAll() {
        int queryResult = 0;

        queryResult = customerDao.deleteAll();
        return (queryResult >= 1) ? true : false;
    }
}

