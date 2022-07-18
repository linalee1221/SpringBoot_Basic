package structure.main;

import structure.proxy.Image;
import structure.proxy.ProxyImage;

import java.net.Proxy;

/**
 * packageName : structure.main
 * fileName : ProxyMain
 * author : Eunsong LEE
 * date : 2022-05-10
 * description : RealImage를 호출하지 않고 ProxyImage가 대신해서
 *               displayImage() 메소드를 호출함
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-05-10    Eunsong LEE        최초 생성
 */
public class ProxyMain {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("test1.jpg");
        Image image2 = new ProxyImage("test2.jpg");

        // RealImage의 일부기능인 image 이름을 출력하는 메소드 호출
        // REalImage를 대신해서 ProxyImage가 호출하고 있음
        image1.displayImage();
        image2.displayImage();
    }
}
