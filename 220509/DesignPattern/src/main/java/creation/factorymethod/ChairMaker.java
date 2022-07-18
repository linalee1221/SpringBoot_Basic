package creation.factorymethod;

/**
 * packageName : creation.factorymethod
 * fileName : ChairMaker
 * author : Eunsong LEE
 * date : 2022-05-09
 * description : Chair Maker Class(Interface : Furniture)
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-05-09    Eunsong LEE        최초 생성
 */
public class ChairMaker implements Furniture {
    public ChairMaker() {
        System.out.println("Chair Make Waiting");
    }

    @Override
    public void make() {
        System.out.println("Chair Make");
    }

    @Override
    public void newDesign() {
        System.out.println("Research New Bed");
    }

}
