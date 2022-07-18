package spring;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

// xxxDao 역할(Dao로 끝나는 파일)
// 기능 : 데이터베이스(DB)에 연결해서 CRUD(Insert, Select, Update, Delete)를 하기 위한 클래스
// DB역할을 대신하는 자료구조 : HashMap(->부모Map(키,값) 자료구조), ArrayList, LinkedList
// 배열 vs Map 차이점 : 배열 arr[0] = "a", HashMap arr["1번키값"] = "a"
@Component
public class MemberDao {
    private static long nextId = 0;
    private Map<String, Member> map = new HashMap<>();

    // 해쉬맵에 자료가 뭐가 있는지 확인하는 메소드(Select)
    // 기능 : email을 검색하는 메소드
    public Member selectByEmail(String email) {
        return map.get(email);
    }

    // 해쉬맵에 자료를 생성하는 메소드(Insert)
    // 회원정보를 해쉬맵에 저장하는 메소드(id + 1 증가시켜서 저장)
    public void insert(Member member) {
        // ID를 1 증가시키는 로직
        member.setId(++nextId);
        // 해쉬맵에 회원정보 저장(키,값) = (이메일, 회원정보객체)
        map.put(member.getEmail(), member);
    }

    // 해쉬맵에 자료를 수정하는 메소드(Update)
    public void update(Member member) {
        map.put(member.getEmail(), member);
    }
}
