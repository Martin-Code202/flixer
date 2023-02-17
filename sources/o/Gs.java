package o;

import android.annotation.TargetApi;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.PersistableBundle;
import android.text.TextUtils;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseBooleanArray;
public final class Gs {

    /* renamed from: ʻ  reason: contains not printable characters */
    public static final Gr<Character> f5707 = new Gr<Character>() { // from class: o.Gs.21
        /* renamed from: ॱ  reason: contains not printable characters */
        public Character mo5072(Parcel parcel) {
            return Character.valueOf((char) parcel.readInt());
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        public void mo5071(Character ch, Parcel parcel, int i) {
            parcel.writeInt(ch.charValue());
        }
    };

    /* renamed from: ʻॱ  reason: contains not printable characters */
    public static final Gr<short[]> f5708 = new Gr<short[]>() { // from class: o.Gs.12
        /* renamed from: ˊ  reason: contains not printable characters */
        public short[] mo5072(Parcel parcel) {
            int readInt = parcel.readInt();
            short[] sArr = new short[readInt];
            for (int i = 0; i < readInt; i++) {
                sArr[i] = (short) parcel.readInt();
            }
            return sArr;
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        public void mo5071(short[] sArr, Parcel parcel, int i) {
            parcel.writeInt(sArr.length);
            for (short s : sArr) {
                parcel.writeInt(s);
            }
        }
    };

    /* renamed from: ʼ  reason: contains not printable characters */
    public static final Gr<boolean[]> f5709 = new Gr<boolean[]>() { // from class: o.Gs.24
        /* renamed from: ॱ  reason: contains not printable characters */
        public boolean[] mo5072(Parcel parcel) {
            return parcel.createBooleanArray();
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public void mo5071(boolean[] zArr, Parcel parcel, int i) {
            parcel.writeBooleanArray(zArr);
        }
    };

    /* renamed from: ʼॱ  reason: contains not printable characters */
    public static Gr<SparseBooleanArray> f5710 = new Gr<SparseBooleanArray>() { // from class: o.Gs.16
        /* renamed from: ˊ  reason: contains not printable characters */
        public SparseBooleanArray mo5072(Parcel parcel) {
            return parcel.readSparseBooleanArray();
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        public void mo5071(SparseBooleanArray sparseBooleanArray, Parcel parcel, int i) {
            parcel.writeSparseBooleanArray(sparseBooleanArray);
        }
    };

    /* renamed from: ʽ  reason: contains not printable characters */
    public static final Gr<Byte> f5711 = new Gr<Byte>() { // from class: o.Gs.25
        /* renamed from: ˏ  reason: contains not printable characters */
        public Byte mo5072(Parcel parcel) {
            return Byte.valueOf(parcel.readByte());
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        public void mo5071(Byte b, Parcel parcel, int i) {
            parcel.writeByte(b.byteValue());
        }
    };

    /* renamed from: ʽॱ  reason: contains not printable characters */
    public static final Gr<String> f5712 = new Gr<String>() { // from class: o.Gs.20
        /* renamed from: ˏ  reason: contains not printable characters */
        public String mo5072(Parcel parcel) {
            return parcel.readString();
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        public void mo5071(String str, Parcel parcel, int i) {
            parcel.writeString(str);
        }
    };

    /* renamed from: ʾ  reason: contains not printable characters */
    public static final Gr<SizeF> f5713 = new Gr<SizeF>() { // from class: o.Gs.15
        @TargetApi(21)
        /* renamed from: ˏ  reason: contains not printable characters */
        public SizeF mo5072(Parcel parcel) {
            return parcel.readSizeF();
        }

        @TargetApi(21)
        /* renamed from: ˏ  reason: contains not printable characters */
        public void mo5071(SizeF sizeF, Parcel parcel, int i) {
            parcel.writeSizeF(sizeF);
        }
    };

    /* renamed from: ˈ  reason: contains not printable characters */
    public static final Gr<Size> f5714 = new Gr<Size>() { // from class: o.Gs.13
        @TargetApi(21)
        /* renamed from: ˊ  reason: contains not printable characters */
        public Size mo5072(Parcel parcel) {
            return parcel.readSize();
        }

        @TargetApi(21)
        /* renamed from: ˋ  reason: contains not printable characters */
        public void mo5071(Size size, Parcel parcel, int i) {
            parcel.writeSize(size);
        }
    };

    /* renamed from: ˊ  reason: contains not printable characters */
    public static final Gr<Long> f5715 = new Gr<Long>() { // from class: o.Gs.19
        /* renamed from: ˏ  reason: contains not printable characters */
        public Long mo5072(Parcel parcel) {
            return Long.valueOf(parcel.readLong());
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        public void mo5071(Long l, Parcel parcel, int i) {
            parcel.writeLong(l.longValue());
        }
    };

    /* renamed from: ˊॱ  reason: contains not printable characters */
    public static final Gr<CharSequence> f5716 = new Gr<CharSequence>() { // from class: o.Gs.2
        /* renamed from: ˋ  reason: contains not printable characters */
        public CharSequence mo5072(Parcel parcel) {
            return (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        public void mo5071(CharSequence charSequence, Parcel parcel, int i) {
            TextUtils.writeToParcel(charSequence, parcel, i);
        }
    };

    /* renamed from: ˋ  reason: contains not printable characters */
    public static final Gr<Float> f5717 = new Gr<Float>() { // from class: o.Gs.18
        /* renamed from: ॱ  reason: contains not printable characters */
        public Float mo5072(Parcel parcel) {
            return Float.valueOf(parcel.readFloat());
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        public void mo5071(Float f, Parcel parcel, int i) {
            parcel.writeFloat(f.floatValue());
        }
    };

    /* renamed from: ˋॱ  reason: contains not printable characters */
    public static final Gr<double[]> f5718 = new Gr<double[]>() { // from class: o.Gs.8
        /* renamed from: ˊ  reason: contains not printable characters */
        public double[] mo5072(Parcel parcel) {
            return parcel.createDoubleArray();
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public void mo5071(double[] dArr, Parcel parcel, int i) {
            parcel.writeDoubleArray(dArr);
        }
    };

    /* renamed from: ˎ  reason: contains not printable characters */
    public static final Gr<Integer> f5719 = new Gr<Integer>() { // from class: o.Gs.4
        /* renamed from: ˊ  reason: contains not printable characters */
        public Integer mo5072(Parcel parcel) {
            return Integer.valueOf(parcel.readInt());
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        public void mo5071(Integer num, Parcel parcel, int i) {
            parcel.writeInt(num.intValue());
        }
    };

    /* renamed from: ˏ  reason: contains not printable characters */
    public static final Gr<Double> f5720 = new Gr<Double>() { // from class: o.Gs.17
        /* renamed from: ˋ  reason: contains not printable characters */
        public Double mo5072(Parcel parcel) {
            return Double.valueOf(parcel.readDouble());
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public void mo5071(Double d, Parcel parcel, int i) {
            parcel.writeDouble(d.doubleValue());
        }
    };

    /* renamed from: ˏॱ  reason: contains not printable characters */
    public static final Gr<byte[]> f5721 = new Gr<byte[]>() { // from class: o.Gs.1
        /* renamed from: ॱ  reason: contains not printable characters */
        public byte[] mo5072(Parcel parcel) {
            return parcel.createByteArray();
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        public void mo5071(byte[] bArr, Parcel parcel, int i) {
            parcel.writeByteArray(bArr);
        }
    };

    /* renamed from: ͺ  reason: contains not printable characters */
    public static final Gr<char[]> f5722 = new Gr<char[]>() { // from class: o.Gs.5
        /* renamed from: ˊ  reason: contains not printable characters */
        public char[] mo5072(Parcel parcel) {
            return parcel.createCharArray();
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public void mo5071(char[] cArr, Parcel parcel, int i) {
            parcel.writeCharArray(cArr);
        }
    };

    /* renamed from: ॱ  reason: contains not printable characters */
    public static final Gr<Boolean> f5723 = new Gr<Boolean>() { // from class: o.Gs.11
        /* renamed from: ॱ  reason: contains not printable characters */
        public Boolean mo5072(Parcel parcel) {
            return Boolean.valueOf(parcel.readInt() == 1);
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public void mo5071(Boolean bool, Parcel parcel, int i) {
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        }
    };

    /* renamed from: ॱˊ  reason: contains not printable characters */
    public static final Gr<float[]> f5724 = new Gr<float[]>() { // from class: o.Gs.7
        /* renamed from: ˏ  reason: contains not printable characters */
        public float[] mo5072(Parcel parcel) {
            return parcel.createFloatArray();
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public void mo5071(float[] fArr, Parcel parcel, int i) {
            parcel.writeFloatArray(fArr);
        }
    };

    /* renamed from: ॱˋ  reason: contains not printable characters */
    public static final Gr<long[]> f5725 = new Gr<long[]>() { // from class: o.Gs.10
        /* renamed from: ˏ  reason: contains not printable characters */
        public long[] mo5072(Parcel parcel) {
            return parcel.createLongArray();
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        public void mo5071(long[] jArr, Parcel parcel, int i) {
            parcel.writeLongArray(jArr);
        }
    };

    /* renamed from: ॱˎ  reason: contains not printable characters */
    public static final Gr<int[]> f5726 = new Gr<int[]>() { // from class: o.Gs.6
        /* renamed from: ॱ  reason: contains not printable characters */
        public int[] mo5072(Parcel parcel) {
            return parcel.createIntArray();
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public void mo5071(int[] iArr, Parcel parcel, int i) {
            parcel.writeIntArray(iArr);
        }
    };

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public static final Gr<Short> f5727 = new Gr<Short>() { // from class: o.Gs.23
        /* renamed from: ˊ  reason: contains not printable characters */
        public Short mo5072(Parcel parcel) {
            return Short.valueOf((short) parcel.readInt());
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        public void mo5071(Short sh, Parcel parcel, int i) {
            parcel.writeInt(sh.intValue());
        }
    };

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    public static final Gr<IBinder> f5728 = new Gr<IBinder>() { // from class: o.Gs.9
        /* renamed from: ˏ  reason: contains not printable characters */
        public IBinder mo5072(Parcel parcel) {
            return parcel.readStrongBinder();
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public void mo5071(IBinder iBinder, Parcel parcel, int i) {
            parcel.writeStrongBinder(iBinder);
        }
    };

    /* renamed from: ᐝ  reason: contains not printable characters */
    public static final Gr<Bundle> f5729 = new Gr<Bundle>() { // from class: o.Gs.3
        /* renamed from: ˏ  reason: contains not printable characters */
        public Bundle mo5072(Parcel parcel) {
            return parcel.readBundle(getClass().getClassLoader());
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public void mo5071(Bundle bundle, Parcel parcel, int i) {
            parcel.writeBundle(bundle);
        }
    };

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    public static final Gr<PersistableBundle> f5730 = new Gr<PersistableBundle>() { // from class: o.Gs.14
        @TargetApi(21)
        /* renamed from: ˊ  reason: contains not printable characters */
        public PersistableBundle mo5072(Parcel parcel) {
            return parcel.readPersistableBundle(getClass().getClassLoader());
        }

        @TargetApi(21)
        /* renamed from: ॱ  reason: contains not printable characters */
        public void mo5071(PersistableBundle persistableBundle, Parcel parcel, int i) {
            parcel.writePersistableBundle(persistableBundle);
        }
    };
}
