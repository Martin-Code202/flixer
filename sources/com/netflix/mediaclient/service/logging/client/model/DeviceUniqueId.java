package com.netflix.mediaclient.service.logging.client.model;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Random;
public class DeviceUniqueId {
    private long value;

    public DeviceUniqueId(long j) {
        this.value = j;
    }

    public DeviceUniqueId() {
        this.value = (10 * System.currentTimeMillis()) + ((long) Math.abs(getRandom16Bits()));
    }

    public long getValue() {
        return this.value;
    }

    private static int getRandom16Bits() {
        byte[] bArr = new byte[2];
        new Random().nextBytes(bArr);
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        wrap.order(ByteOrder.nativeOrder());
        return wrap.getShort();
    }

    public String toString() {
        return "DeviceUniqueId [value=" + this.value + "]";
    }

    public int hashCode() {
        return ((int) (this.value ^ (this.value >>> 32))) + 31;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass() && this.value == ((DeviceUniqueId) obj).value) {
            return true;
        }
        return false;
    }

    public static DeviceUniqueId parse(long j) {
        DeviceUniqueId deviceUniqueId = new DeviceUniqueId();
        deviceUniqueId.value = j;
        return deviceUniqueId;
    }
}
