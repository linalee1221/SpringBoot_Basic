import http from "../http-common";

class UploadFilesService {
    // upload를 위한 메소드
    // springboot 서버로 insert문 호출
    upload(file, onUploadProgress) {
        // 자바스크립트에서 제공하는 클래스
        // <form> 태그로 이미지 전송을 해야 하는데, json형태는 아님.
        // <form> == FormData()
        let formData = new FormData();
        // vue에서 선택한 파일을 form 데이터로 담기
        formData.append("file", file);

        return http.post("/upload", formData, {
            headers: {
                // 이미지 전송 형태 : json이 아님
                "Content-Type" : "multipart/form-data"
            },
            // 이미지 처리 결과를 화면에 프로그래스바 로 보여주기 위해 실행하는 펑션
            onUploadProgress
        });
    }
    // 이미지를 서버에서 다운로드 받음
    // select 문 호출
    getFiles() {
        return http.get("/files");
    }
}

// 외부 파일(js, vue)에서 사용할 수 있게 아래 이름으로 export함.
export default new UploadFilesService();