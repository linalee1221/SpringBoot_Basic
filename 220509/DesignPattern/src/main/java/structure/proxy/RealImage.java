package structure.proxy;

/**
 * packageName : structure.proxy
 * fileName : RealImage
 * author : Eunsong LEE
 * date : 2022-05-10
 * description : 실제 이미지 클래스(Image 상속 받음)
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-05-10    Eunsong LEE        최초 생성
 */
public class RealImage implements Image {
    private String filename;

    // 생성자
    public RealImage(String filename) {
        this.filename = filename;
    }
    // 구현중인 메소드
    public void loadFromDisk(String filename) {
        // 아직 완성 안됨
    }
    @Override
    public void displayImage() {
        System.out.println("보여주기 : " + filename);
    }
}
