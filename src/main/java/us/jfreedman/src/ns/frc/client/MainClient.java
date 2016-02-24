package us.jfreedman.src.ns.frc.client;

import us.jfreedman.src.ns.frc.common.packets.Packet;
import us.jfreedman.src.ns.frc.common.packets.Packet01;
import us.jfreedman.src.ns.frc.common.packets.Packet02;
import us.jfreedman.src.ns.frc.common.packets.Packet03;

/**
 * Created by Joshua Freedman on 2/23/2016.
 * Project: NS-FRC-Impl
 */
public class MainClient {

    public MainClient() {
        NS.connect(null, System.err::println);
        new NS().start();
        NS.addQueue(new Packet01("TeST").setDataType(Packet.Type.SERIALIZED), null, null);
        NS.addQueue(new Packet01("Hello").setDataType(Packet.Type.SERIALIZED), o -> System.out.println("SUCCESS"), null);
        NS.addQueue(new Packet01("HI!").setDataType(Packet.Type.SERIALIZED), null, null);
        NS.addQueue(new Packet02(5).setDataType(Packet.Type.SERIALIZED), null, null);
        NS.addQueue(new Packet02(50000).setDataType(Packet.Type.SERIALIZED), null, null);
        NS.addQueue(new Packet03("Josh", "This is MIKE!").setDataType(Packet.Type.SERIALIZED), null, null);
        NS.addQueue(new Packet03("Mike", "This is JOSH!").setDataType(Packet.Type.SERIALIZED), null, null);
    }
}
