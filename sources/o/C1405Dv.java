package o;

import com.netflix.msl.io.MslEncoderException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
/* renamed from: o.Dv  reason: case insensitive filesystem */
public class C1405Dv {

    /* renamed from: ˏ  reason: contains not printable characters */
    private final Map<String, Object> f5466 = new HashMap();

    public C1405Dv() {
    }

    public C1405Dv(Map<?, ?> map) {
        if (map != null) {
            for (Object obj : map.keySet()) {
                if (!(obj instanceof String)) {
                    throw new IllegalArgumentException("Map key is not a string.");
                }
                mo4754((String) obj, map.get(obj));
            }
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public Object m4753(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Null key.");
        }
        Object obj = this.f5466.get(str);
        if (obj == null) {
            throw new MslEncoderException("MslObject[" + AbstractC1400Dq.m4723(str) + "] not found.");
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

    /* renamed from: ˎ  reason: contains not printable characters */
    public boolean m4757(String str) {
        Object r3 = m4753(str);
        if (r3 instanceof Boolean) {
            return ((Boolean) r3).booleanValue();
        }
        throw new MslEncoderException("MslObject[" + AbstractC1400Dq.m4723(str) + "] is not a boolean.");
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public byte[] mo4761(String str) {
        Object r3 = m4753(str);
        if (r3 instanceof byte[]) {
            return (byte[]) r3;
        }
        throw new MslEncoderException("MslObject[" + AbstractC1400Dq.m4723(str) + "] is not binary data.");
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public int m4755(String str) {
        Object r3 = m4753(str);
        if (r3 instanceof Number) {
            return ((Number) r3).intValue();
        }
        throw new MslEncoderException("MslObject[" + AbstractC1400Dq.m4723(str) + "] is not a number.");
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public C1401Dr m4759(String str) {
        Object r3 = m4753(str);
        if (r3 instanceof C1401Dr) {
            return (C1401Dr) r3;
        }
        if (r3 instanceof Object[]) {
            return new C1401Dr((Object[]) r3);
        }
        throw new MslEncoderException("MslObject[" + AbstractC1400Dq.m4723(str) + "] is not a MslArray.");
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public C1405Dv m4756(String str, AbstractC1400Dq dq) {
        Object r3 = m4753(str);
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
                throw new MslEncoderException("MslObject[" + AbstractC1400Dq.m4723(str) + "] is not a MslObject.");
            }
        } else {
            throw new MslEncoderException("MslObject[" + AbstractC1400Dq.m4723(str) + "] is not a MslObject.");
        }
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public long m4763(String str) {
        Object r3 = m4753(str);
        if (r3 instanceof Number) {
            return ((Number) r3).longValue();
        }
        throw new MslEncoderException("MslObject[" + AbstractC1400Dq.m4723(str) + "] is not a number.");
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public String m4752(String str) {
        Object r3 = m4753(str);
        if (r3 instanceof String) {
            return (String) r3;
        }
        throw new MslEncoderException("MslObject[" + AbstractC1400Dq.m4723(str) + "] is not a string.");
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public boolean m4750(String str) {
        if (str != null) {
            return this.f5466.containsKey(str);
        }
        throw new IllegalArgumentException("Null key.");
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public Object m4751(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Null key.");
        }
        Object obj = this.f5466.get(str);
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
    public byte[] mo4762(String str, byte[] bArr) {
        Object r1 = m4751(str);
        if (r1 instanceof byte[]) {
            return (byte[]) r1;
        }
        return bArr;
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    public C1401Dr m4764(String str) {
        Object r2 = m4751(str);
        if (r2 instanceof C1401Dr) {
            return (C1401Dr) r2;
        }
        if (r2 instanceof Collection) {
            try {
                return new C1401Dr((Collection) r2);
            } catch (IllegalArgumentException e) {
                return null;
            }
        } else if (r2 instanceof Object[]) {
            return new C1401Dr((Object[]) r2);
        } else {
            return null;
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public String m4760(String str, String str2) {
        Object r1 = m4751(str);
        if (r1 instanceof String) {
            return (String) r1;
        }
        return str2;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public C1405Dv mo4754(String str, Object obj) {
        if (str == null) {
            throw new IllegalArgumentException("Null key.");
        } else if (obj == null) {
            this.f5466.remove(str);
            return this;
        } else {
            if ((obj instanceof Boolean) || (obj instanceof byte[]) || (obj instanceof Number) || (obj instanceof C1405Dv) || (obj instanceof C1401Dr) || (obj instanceof String) || (obj instanceof AbstractC1399Dp)) {
                this.f5466.put(str, obj);
            } else if (obj instanceof Map) {
                this.f5466.put(str, new C1405Dv((Map) obj));
            } else if (obj instanceof Collection) {
                this.f5466.put(str, new C1401Dr((Collection) obj));
            } else if (obj instanceof Object[]) {
                this.f5466.put(str, new C1401Dr((Object[]) obj));
            } else if (obj instanceof Enum) {
                this.f5466.put(str, ((Enum) obj).name());
            } else {
                throw new IllegalArgumentException("Value [" + obj.getClass() + "] is an unsupported type.");
            }
            return this;
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public Set<String> m4758() {
        return Collections.unmodifiableSet(this.f5466.keySet());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1405Dv)) {
            return false;
        }
        try {
            return C1404Du.m4746(this, (C1405Dv) obj);
        } catch (MslEncoderException e) {
            return false;
        }
    }

    public int hashCode() {
        return C1404Du.m4747(this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        int size = this.f5466.size();
        Iterator<String> it = this.f5466.keySet().iterator();
        sb.append('{');
        if (size == 1) {
            String next = it.next();
            sb.append(AbstractC1400Dq.m4723(next));
            sb.append(':');
            sb.append(AbstractC1400Dq.m4724(this.f5466.get(next)));
        } else if (size != 0) {
            while (it.hasNext()) {
                String next2 = it.next();
                if (z) {
                    sb.append(',');
                }
                sb.append(AbstractC1400Dq.m4723(next2));
                sb.append(':');
                sb.append(AbstractC1400Dq.m4724(this.f5466.get(next2)));
                z = true;
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
