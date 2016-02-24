package us.jfreedman.src.ns.frc.common.packets;

/**
 * Created by Joshua Freedman on 2/9/2016.
 * Project: NS-FRC-Impl
 */
public class Packet02 extends KeyedPacket<Packet02> {

    public Packet02(Number number) {
        this(null, number);
    }

    public Packet02(String key, Number number) {
        this.key = key;
        this.innerData = number;
    }

    public Number getNumber() {
        return (Number) this.innerData;
    }
}
