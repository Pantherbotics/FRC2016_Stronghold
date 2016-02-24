package us.jfreedman.src.ns.frc.common.packets;

import java.io.Serializable;

/**
 * Created by Joshua on 2/8/2016.
 * Project: NS-FRC-Impl
 */
public abstract class Packet<T extends Packet> implements Serializable {

    protected Object innerData;
    protected String senderName;
    protected Type dataType;
    protected long timeout = -1;

    public T setDataType(Type dataType) {
        this.dataType = dataType;
        return (T) this;
    }

    public T setTimeout(long timeout) {
        this.timeout = timeout;
        return (T) this;
    }

    public long getTimeout() {
        return timeout;
    }

    public Type getDataType() {
        return dataType;
    }

    public enum Type {
        MESSAGE, JSON, SERIALIZED, UNKNOWN
    }

    public void handle() {

    }
}
