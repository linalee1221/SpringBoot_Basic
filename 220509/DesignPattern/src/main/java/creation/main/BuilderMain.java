package creation.main;

import creation.builder.*;

/**
 * packageName : creation.main
 * fileName : BuilderMain
 * author : Eunsong LEE
 * date : 2022-05-09
 * description : 빌더를 이용해 컴퓨터 생성자를 대신함(필요한 것만 생성)
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-05-09    Eunsong LEE        최초 생성
 */
public class BuilderMain {

    public static void main(String[] args) {
        Cpu cpu = new Cpu("Intel core i7");
        Ram ram = new Ram("16GB");
        Graphics graphics = new Graphics("RTX-3090");

        // Builder를 이용해서 원하는 구성으로 컴퓨터를 조립
        // Builder 생성자를 호출하면 컴퓨터가 생성됨
        Builder builder = new Builder();
        Computer premiumPC = builder.setCpu(cpu).setRam(ram).setGraphics(graphics)
                .build(); // 값이 설정된 computer 객체 반환함
        // 프리미엄 컴퓨터 정보 보기
        premiumPC.computerInfo();

        // 저가형 컴퓨터 조립
        Cpu cpu2 = new Cpu("Intel core i7");
        Ram ram2 = new Ram("8GB");
        Graphics graphics2 = new Graphics("RTX-3060");

        System.out.println("-------------------- MiddleCostPC --------------------");
        builder = new Builder();
        Computer middleCostPC = builder.setCpu(cpu2).setGraphics(graphics2)
                .build(); // 값이 설정된 computer 객체 반환함
        // 중저가형 PC 정보 출력
        middleCostPC.computerInfo();

        System.out.println("-------------------- LowerCostPC --------------------");
        builder = new Builder();
        Computer LowerCostPC = builder.setCpu(cpu2).setRam(ram2)
                .build(); // 값이 설정된 computer 객체 반환함
        // 저가형 PC 정보 출력
        LowerCostPC.computerInfo();

        System.out.println("-------------------- SupperLowerCostPC --------------------");
        builder = new Builder();
        Computer SupperLowerCostPC = builder.setCpu(cpu2)
                .build(); // 값이 설정된 computer 객체 반환함
        // 최최저가형 PC 정보 출력
       SupperLowerCostPC.computerInfo();

    }
}

