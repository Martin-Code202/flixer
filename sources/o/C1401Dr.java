package o;

import com.netflix.msl.io.MslEncoderException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* renamed from: o.Dr  reason: case insensitive filesystem */
public class C1401Dr {

    /* renamed from: ॱ  reason: contains not printable characters */
    private final List<Object> f5452 = new ArrayList();

    public C1401Dr() {
    }

    public C1401Dr(Object[] objArr) {
        if (objArr != null) {
            for (Object obj : objArr) {
                mo4734(-1, obj);
            }
        }
    }

    public C1401Dr(Collection<?> collection) {
        if (collection != null) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                mo4734(-1, it.next());
            }
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public Object m4737(int i) {
        if (i < 0 || i >= this.f5452.size()) {
            throw new ArrayIndexOutOfBoundsException("MslArray[" + i + "] is negative or exceeds array length.");
        }
        Object obj = this.f5452.get(i);
        if (obj == null) {
            throw new MslEncoderException("MslArray[" + i + "] is null.");
        } else if (obj instanceof Map) {
            return new C1405Dv((Map) obj);
        } else {
            if (obj instanceof Collection) {
                return new C1401Dr((Collection) obj);
            }
            if (obj instanceof Object[]) {
                return new C1401Dr((Object[]) obj);
            }
            return obj;
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public byte[] mo4731(int i) {
        Object r3 = m4737(i);
        if (r3 instanceof byte[]) {
            return (byte[]) r3;
        }
        throw new MslEncoderException("MslArray[" + i + "] is not binary data.");
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public C1405Dv m4735(int i, AbstractC1400Dq dq) {
        Object r3 = m4737(i);
        if (r3 instanceof C1405Dv) {
            return (C1405Dv) r3;
        }
        if (r3 instanceof Map) {
            return new C1405Dv((Map) r3);
        }
        if (r3 instanceof byte[]) {
            try {
                return dq.mo3176((byte[]) r3);
            } catch (MslEncoderException e) {
                throw new MslEncoderException("MslObject[" + i + "] is not a MslObject.", e);
            }
        } else {
            throw new MslEncoderException("MslArray[" + i + "] is not a MslObject.");
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public String m4736(int i) {
        Object r3 = m4737(i);
        if (r3 instanceof String) {
            return (String) r3;
        }
        throw new MslEncoderException("MslArray[" + i + "] is not a string.");
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public int m4732() {
        return this.f5452.size();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public Object m4733(int i) {
        if (i < 0 || i >= this.f5452.size()) {
            throw new ArrayIndexOutOfBoundsException("MslArray[" + i + "] is negative or exceeds array length.");
        }
        Object obj = this.f5452.get(i);
        if (obj instanceof Map) {
            try {
                return new C1405Dv((Map) obj);
            } catch (IllegalArgumentException e) {
                return null;
            }
        } else if (obj instanceof Collection) {
            return new C1401Dr((Collection) obj);
        } else {
            if (obj instanceof Object[]) {
                return new C1401Dr((Object[]) obj);
            }
            return obj;
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public byte[] mo4738(int i, byte[] bArr) {
        Object r1 = m4733(i);
        if (r1 instanceof byte[]) {
            return (byte[]) r1;
        }
        return bArr;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public C1401Dr mo4734(int i, Object obj) {
        Object obj2;
        if (i < -1) {
            throw new ArrayIndexOutOfBoundsException("MslArray[" + i + "] is negative.");
        }
        if ((obj instanceof Boolean) || (obj instanceof byte[]) || (obj instanceof Number) || (obj instanceof C1405Dv) || (obj instanceof C1401Dr) || (obj instanceof String) || (obj instanceof AbstractC1399Dp)) {
            obj2 = obj;
        } else if (obj instanceof Map) {
            obj2 = new C1405Dv((Map) obj);
        } else if (obj instanceof Collection) {
            obj2 = new C1401Dr((Collection) obj);
        } else if (obj instanceof Object[]) {
            obj2 = new C1401Dr((Object[]) obj);
        } else if (obj instanceof Enum) {
            obj2 = ((Enum) obj).name();
        } else if (obj == null) {
            obj2 = null;
        } else {
            throw new IllegalArgumentException("Value [" + obj.getClass() + "] is an unsupported type.");
        }
        for (int size = this.f5452.size(); size < i; size++) {
            this.f5452.add(null);
        }
        if (i == -1 || i == this.f5452.size()) {
            this.f5452.add(obj2);
            return this;
        }
        this.f5452.set(i, obj2);
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1401Dr)) {
            return false;
        }
        try {
            return C1404Du.m4745(this, (C1401Dr) obj);
        } catch (MslEncoderException e) {
            return false;
        }
    }

    public int hashCode() {
        return C1404Du.m4749(this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        int size = this.f5452.size();
        sb.append('[');
        if (size == 1) {
            sb.append(AbstractC1400Dq.m4724(this.f5452.get(0)));
        } else if (size != 0) {
            for (int i = 0; i < size; i++) {
                if (z) {
                    sb.append(',');
                }
                sb.append(AbstractC1400Dq.m4724(this.f5452.get(i)));
                z = true;
            }
        }
        sb.append(']');
        return sb.toString();
    }
}
