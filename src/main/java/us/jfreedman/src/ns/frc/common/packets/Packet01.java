package us.jfreedman.src.ns.frc.common.packets;

/**
 * Created by Joshua Freedman on 2/9/2016.
 * Project: NS-FRC-Impl
 */
public class Packet01 extends Packet<Packet01> {

    private String extra;

    public Packet01() {
        this("From Josh");
    }

    public Packet01(String extra) {
        this.extra = extra;
        setDataType(Type.MESSAGE);
    }

    public String getExtra() {
        return extra;
    }

    @Override
    public void handle() {
        System.out.println(extra);
        super.handle();
    }
}
