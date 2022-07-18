package creation.factorymethod;

/**
 * packageName : creation.factorymethod
 * fileName : IkeaFactory
 * author : Eunsong LEE
 * date : 2022-05-09
 * description : Ikea Factory(Object Creation)
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-05-09    Eunsong LEE        최초 생성
 */
public class IkeaFactory {
    public Furniture order(String type) {

        if(type == "bed") {
            return new BedMaker();
        } else if (type == "chair") {
            return new ChairMaker();
        } else if (type == "desk") {
            return new DeskMaker();
        }
        return null;
    }
}
