package creation.builder;

/**
 * packageName : creation.builder
 * fileName : Builder
 * author : Eunsong LEE
 * date : 2022-05-09
 * description : 생성자를 대신해서 매개변수를 조합하여 객체를 생성
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-05-09    Eunsong LEE        최초 생성
 */
public class Builder {

    // Builder : 아래 대상 객체의 생성자를 대신함
    private Computer computer;

    // 컴퓨터 객체를 생성함
    public Builder() {
        this.computer = new Computer();
    }

    public Computer build() {
        return this.computer;
    }

    public Builder setCpu(Cpu cpu) {
        // 컴퓨터의 setter cpu 호출
        computer.setCpu(cpu);
        return this;
    }
    public Builder setRam(Ram ram) {
        // 컴퓨터의 setter ram 호출
        computer.setRam(ram);
        return this;
    }
    public Builder setGraphics(Graphics graphics) {
        // 컴퓨터의 setter Graphics 호출
        computer.setGraphics(graphics);
        return this;
    }
}
