package creation.builder;

/**
 * packageName : creation.builder
 * fileName : Ram
 * author : Eunsong LEE
 * date : 2022-05-09
 * description : Ram 클래스(빌더에서 사용할 클래스)
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-05-09    Eunsong LEE        최초 생성
 */
public class Ram {
    String ram;

    public Ram(String ram) {
        this.ram = ram;
    }

    public String getInfo() {
        return ram;
    }
}
