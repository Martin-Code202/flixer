package o;

import java.io.DataInputStream;
import java.util.BitSet;
/* renamed from: o.my  reason: case insensitive filesystem */
public abstract class AbstractC1994my extends mB {

    /* renamed from: ˏ  reason: contains not printable characters */
    protected short f8979;

    /* renamed from: ॱ  reason: contains not printable characters */
    protected BitSet f8980;

    public AbstractC1994my(mA mAVar, DataInputStream dataInputStream) {
        super(mAVar);
        this.f8979 = mK.m8839(dataInputStream.readByte());
        this.f8980 = BitSet.valueOf(mK.m8845(dataInputStream, 3));
    }

    @Override // o.mB
    public String toString() {
        return "FullBox{version=" + ((int) this.f8979) + ", flags=" + this.f8980 + "} " + super.toString();
    }
}
