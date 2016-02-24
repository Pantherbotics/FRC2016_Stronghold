package us.jfreedman.src.ns.frc.client;

import us.jfreedman.src.ns.frc.common.packets.Packet;

import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.Consumer;

/**
 * Created by Joshua Freedman on 2/23/2016.
 * Project: NS-FRC-Impl
 */
public class NS extends Thread implements Runnable {

    private static Socket serverConnection = null;
    private static BlockingQueue<Node<Packet, Consumer<Object>, Consumer<Object>>> dataQueue = new LinkedBlockingQueue<>();
    private static ObjectOutputStream os = null;

    @Override
    public void run() {
        while (true) {
            fireData(null, System.err::println);
        }
    }

    public synchronized static <T extends Packet> void addQueue(T t, Consumer<Object> success, Consumer<Object> failure) {
        dataQueue.add(new Node(t, success, failure, System.currentTimeMillis()));
    }

    public synchronized static void connect(Consumer<Object> success, Consumer<Object> failure) {
        try {
            serverConnection = new Socket("10.38.2.244", 7093);
            serverConnection.setKeepAlive(true);
            os = new ObjectOutputStream(serverConnection.getOutputStream());
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

    public synchronized static void fireData(Consumer<Object> success, Consumer<Object> failure) {
        try {
            if (!dataQueue.isEmpty()) {
                dataQueue.removeIf(node -> node.packet.getTimeout() != -1 && System.currentTimeMillis() - node.initTime >= node.packet.getTimeout());
                Node<Packet, Consumer<Object>, Consumer<Object>> node = dataQueue.poll();
                try {
                    os.writeObject(node.packet);
                    os.flush();
                    if (node.success != null) {
                        node.success.accept(null);
                    }
                } catch (Exception e) {
                    if (node.failure != null) {
                        node.failure.accept(e);
                    } else {
                        e.printStackTrace();
                    }
                }
            }
        } catch (Exception e) {
            if (failure != null) {
                failure.accept(e);
            } else {
                e.printStackTrace();
            }
            return;
        }
        if (success != null) {
            success.accept(null);
        }
    }

    public synchronized static void close(Consumer<Object> success, Consumer<Object> failure) {
        try {
            serverConnection.getOutputStream().close();
            serverConnection.getInputStream().close();
            serverConnection.close();
        } catch (Exception e) {
            if (failure != null) {
                failure.accept(e);
            } else {
                e.printStackTrace();
            }
            return;
        }
        if (success != null) {
            success.accept(null);
        }
    }

    static class Node<T, S, E> {
        T packet;
        S success;
        E failure;
        long initTime;

        public Node(T packet, S success, E failure, long initTime) {
            this.packet = packet;
            this.success = success;
            this.failure = failure;
            this.initTime = initTime;
        }
    }
}
