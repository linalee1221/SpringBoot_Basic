package chap07;

/**
 * packageName : chap07
 * fileName : ExeTimeCalculator
 * author : Eunsong LEE
 * date : 2022-05-11
 * description : 팩토리얼을 측정할 때 시간(나노 시간으로 측정함), 공통클래스
 *               클래스목적 : 시간측정
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-05-11    Eunsong LEE        최초 생성
 */
public class ExeTimeCalculator implements Calculator {
    private Calculator delegate; // 인터페이스

    // @Autowired : 자동주입(AutoDI)
    // 1) 생성자(Autowired 걸어주는 위치 : 메소드 바로 위)
    // 2) setter
    // 3) 멤버변수(멤버변수 바로 위)
    // 객체 생성은 외부에서 해서 아래 생성자 매개변수로 전달함 = DI
    // 생성자의 매개변수를 통해 전달(의존성주입 형태 : DI)
    public ExeTimeCalculator(Calculator delegate) {
        this.delegate = delegate;
    }

    @Override
    public long factorial(long num) {

        // 실행 전 시간 : 나노시간 측정
//        long start = System.nanoTime(); // 나노시간 측정

        // 팩토리얼 실행 : 자식클래스의 진짜 팩토리얼 함수 실행 부분)
        long result = delegate.factorial(num);

        // 실행 후 시간 : 나노시간 측정
//        long end = System.nanoTime();

        // 실행 시간 출력
//        System.out.println("(공통함수)factorial 실행 시간 : " + (end-start));


        return 0;
    }
}
