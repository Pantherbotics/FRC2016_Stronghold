package org.usfirst.frc.team3863.network;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.Consumer;

/**
 * Created by robotics on 2/8/2016.
 */
public class NS {

    private static Socket serverConnection = null;
    private static BlockingQueue<NSData> dataQueue = new LinkedBlockingQueue<NSData>();

    public static <T extends NSData> void addQueue(T t, NS.Type type, Consumer<Object> success, Consumer<Object> failure) {
        dataQueue.add(t);
    }

    public static void connect(Consumer<Object> success, Consumer<Object> failure) {
        try {
            serverConnection = new Socket("localhost", 7093);
            serverConnection.setKeepAlive(true);
        } catch (IOException e) {
            if (failure != null) {
                failure.accept(e);
            } else {
                e.printStackTrace();
            }
        }
        if (success != null) {
            success.accept(null);
        }
    }

    public synchronized static void fireData(Consumer<Object> success, Consumer<Object> failure) {
        try {
            OutputStream os = serverConnection.getOutputStream();
            if (!dataQueue.isEmpty()) {
                NSData t = dataQueue.poll();
                os.write(t.getData());
            }
        } catch (IOException e) {
            if (failure != null) {
                failure.accept(e);
            } else {
                e.printStackTrace();
            }
        }
        if (success != null) {
            success.accept(null);
        }
    }

    public static void close(Consumer<Object> success, Consumer<Object> failure) {
        try {
            serverConnection.getOutputStream().close();
            serverConnection.getInputStream().close();
            serverConnection.close();
        } catch (IOException e) {
            if (failure != null) {
                failure.accept(e);
            } else {
                e.printStackTrace();
            }
        }
        if (success != null) {
            success.accept(null);
        }

    }

    public enum Type {
        MESSAGE, JSON, SERIALIZED, UNKNOWN
    }
}
