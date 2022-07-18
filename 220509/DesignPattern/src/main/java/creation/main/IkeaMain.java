package creation.main;

import creation.factorymethod.IkeaFactory;

/**
 * packageName : creation.main
 * fileName : IkeaMain
 * author : ds
 * date : 2022-05-09
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-05-09         ds          최초 생성
 */
public class IkeaMain {
    public static void main(String[] args) {
        // 공장 만들기(객체 생성은 공장에서 함)
        IkeaFactory ikeaFactory = new IkeaFactory();

        System.out.println("order 1 : desk");
        ikeaFactory.order("desk").make(); // 책상 만들기

        System.out.println("order 2 : chair");
        ikeaFactory.order("chair").make(); // 의자 만들기

        System.out.println("research : Bed Make");
        ikeaFactory.order("bed"); // 침대 만들기 연구
    }
}
