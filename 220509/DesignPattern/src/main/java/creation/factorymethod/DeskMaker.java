package creation.factorymethod;

/**
 * packageName : creation.factorymethod
 * fileName : DeskMaker
 * author : Eunsong LEE
 * date : 2022-05-09
 * description : Desk Maker ClasS(Interface : Furniture)
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-05-09    Eunsong LEE        최초 생성
 */
public class DeskMaker implements Furniture {
    public DeskMaker() {
        System.out.println("Desk Make Waiting");
    }

    @Override
    public void make() {
        System.out.println("Desk Maker");
    }

    @Override
    public void newDesign() {
        System.out.println("Research New Design");
    }
}
