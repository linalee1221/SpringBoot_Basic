package structure.proxy;

/**
 * packageName : structure.proxy
 * fileName : ProxyImage
 * author : Eunsong LEE
 * date : 2022-05-10
 * description : RealImage 클래스를 대신하는(대리하는) 클래스
 *               RealImage 클래스 이름을 숨겨 보안상의 의미가 있음
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-05-10    Eunsong LEE        최초 생성
 */
public class ProxyImage implements Image {
    private String fileName;

    private Image image = null;

// 매개변수 fileName을 가지는 생성자
    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void displayImage() {
        if(image == null) {
    // 현재 image 객체가 없으면 실제 RealImage 객체를 생성함
            image = new RealImage(fileName);
        }
    // 현재 image 객체가 있으면 이미지 이름 정보 출력
        image.displayImage();

    }
}
