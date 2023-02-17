package o;

import java.io.DataInputStream;
import java.io.IOException;
public class mA {

    /* renamed from: ˊ  reason: contains not printable characters */
    protected String f8682;

    /* renamed from: ˋ  reason: contains not printable characters */
    private long f8683;

    /* renamed from: ˎ  reason: contains not printable characters */
    protected long f8684;

    /* renamed from: ˏ  reason: contains not printable characters */
    protected long f8685;

    /* renamed from: ॱ  reason: contains not printable characters */
    protected String f8686;

    public mA(DataInputStream dataInputStream) {
        if (dataInputStream == null) {
            throw new IllegalArgumentException("DIS is null!");
        }
        this.f8683 = mK.m8840(mK.m8845(dataInputStream, 4));
        this.f8682 = mK.m8843(mK.m8845(dataInputStream, 4));
        this.f8684 = 8;
        if (this.f8683 == 0) {
            throw new IOException("mp4-badsize: size can not be 0!");
        }
        if (this.f8683 == 1) {
            this.f8683 = mK.m8841(mK.m8845(dataInputStream, 8));
            this.f8684 += 8;
        }
        if (this.f8683 < 8) {
            throw new IOException("mp4-badsize: size can not be less than 8 bytes!");
        }
        if (m8794(this.f8682)) {
            this.f8686 = mK.m8843(mK.m8845(dataInputStream, 16));
            this.f8684 += 16;
        }
        this.f8685 = this.f8683 - this.f8684;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public long m8795() {
        return this.f8683;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public String m8796() {
        return this.f8686;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public long m8799() {
        return this.f8685;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public boolean m8797() {
        return this.f8686 != null;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public boolean m8798(String str) {
        if (this.f8686 == null) {
            return false;
        }
        return this.f8686.equals(str);
    }

    public String toString() {
        return "BoxHeader{sizeInBytes=" + this.f8683 + ", type='" + this.f8682 + "', userType='" + this.f8686 + "', headerSizeInBytes=" + this.f8684 + ", contentSizeInBytes=" + this.f8685 + '}';
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static boolean m8794(String str) {
        return "uuid".equals(str);
    }
}
