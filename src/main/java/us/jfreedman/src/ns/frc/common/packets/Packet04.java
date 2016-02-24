package us.jfreedman.src.ns.frc.common.packets;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Joshua Freedman on 2/23/2016.
 * Project: NS-FRC-Impl
 */
public class Packet04 extends KeyedPacket<Packet04> {

    int width, height;

    public Packet04(int width, int height, byte[] imageByteArray) {
        this(null, width, height, imageByteArray);
    }

    public Packet04(String key, int width, int height, byte[] imageByteArray) {
        this.key = key;
        this.width = width;
        this.height = height;
        this.innerData = imageByteArray;
    }

    public byte[] getImageByteArray() {
        return (byte[]) this.innerData;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Image getImage() {
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        bufferedImage.setRGB(0, 0, width, height, (int[]) this.innerData, 0, 0);
        return bufferedImage;
    }

}
