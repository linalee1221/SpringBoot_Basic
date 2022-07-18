package creation.builder;

/**
 * packageName : creation.builder
 * fileName : Cpu
 * author : Eunsong LEE
 * date : 2022-05-09
 * description : Cpu 클래스(빌더에서 조합된 클래스)
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-05-09    Eunsong LEE        최초 생성
 */
public class Cpu {
    String cpu;

    public Cpu(String cpu) {
        this.cpu = cpu;
    }

    String getInfo() {
        return cpu;
    }
}
