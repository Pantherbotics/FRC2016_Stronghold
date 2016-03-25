package org.usfirst.frc.team3863;

import com.ni.vision.NIVision;
import edu.wpi.first.wpilibj.vision.USBCamera;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.function.Consumer;

/**
 * Created by Joshua Freedman on 3/11/2016.
 * Project: 2016Robot
 */
public class CameraServerModded extends Thread implements Runnable {

    private static Socket serverConnection = null;
    private static DataOutputStream os = null;
    private static DataInputStream is = null;

    public synchronized static void connect(String host, Consumer<Object> success, Consumer<Object> failure) {
        System.out.println("Connecting.... ");
        try {
            serverConnection = new Socket();
            serverConnection.setKeepAlive(true);
            serverConnection.connect(new InetSocketAddress(host, 7095));
            System.out.println("Connected.... ");

            os = new DataOutputStream(serverConnection.getOutputStream());
            is = new DataInputStream(serverConnection.getInputStream());
        } catch (Exception e) {
            if (failure != null) {
                failure.accept(e.getMessage());
            } else {
                e.printStackTrace();
            }
            return;
        }
        if (success != null) {
            success.accept(null);
        }
    }

    @Override
    public void run() {
        connect("169.254.158.0", null, System.err::println);
        USBCamera webcam = new USBCamera("cam0");
        webcam.openCamera();
        System.out.println("Camera Opened!");
        try {
            while (isAlive()) {
                if (!serverConnection.isConnected()) connect("169.254.158.0", null, System.err::println);
                if (is.readInt() == 0xffffff) { // TODO: Change to 0xFFFFFFFF
                    System.out.println("Reading data...");
                    NIVision.Image frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);
                    webcam.getImage(frame);
                    NIVision.RawData data = NIVision.imaqFlatten(frame, NIVision.FlattenType.FLATTEN_IMAGE, NIVision.CompressionType.COMPRESSION_JPEG, 10 * 5);
                    byte[] buffer = new byte[data.getBuffer().remaining() + 1];
                    for (int i = 0; i < data.getBuffer().remaining(); i++) {
                        buffer[i] = data.getBuffer().get(i);
                    }
                    os.writeInt(buffer.length);
                    os.write(buffer);
                    os.flush();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (os != null) {
                    os.flush();
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            webcam.closeCamera();
        }
    }
}

