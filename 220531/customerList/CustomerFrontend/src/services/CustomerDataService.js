import http from '../http-common'

// springboot와 연결하기 위한 메소드 정의
class CustomerDataService {
    // 모든 회원 조회
    getAll() {
        return http.get("/customers");
    }
    // id로 회원 조회
    get(id) {
        return http.get(`/customers/${id}`);
    }

    // 회원 데이터를 생성(insert 문 호출)
    create(data) {
        return http.post("/customers", data);
    }

    // 회원 데이터를 수정(update 문 호출)
    update(id, data) {
        return http.put(`/customers/${id}`, data);
    }

    // 회원 데이터를 삭제(update 문 호출)
    delete(id) {
        return http.put(`/customers/deletion/${id}`);
    }
}

export default new CustomerDataService()