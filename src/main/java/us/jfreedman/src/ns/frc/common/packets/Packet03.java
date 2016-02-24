package us.jfreedman.src.ns.frc.common.packets;

/**
 * Created by Joshua Freedman on 2/9/2016.
 * Project: NS-FRC-Impl
 */
public class Packet03 extends KeyedPacket<Packet03> {

    public Packet03(String string) {
        this(null, string);
    }

    public Packet03(String key, String string) {
        this.key = key;
        this.innerData = string;
    }

    public String getString() {
        return (String) this.innerData;
    }
}
