package kotlin.collections;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import o.AbstractC1463Fx;
import o.C1457Fr;
public final class EmptyMap implements Map, Serializable, AbstractC1463Fx {
    private static final long serialVersionUID = 8246714829545688274L;

    /* renamed from: ˎ  reason: contains not printable characters */
    public static final EmptyMap f4244 = new EmptyMap();

    @Override // java.util.Map
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public /* synthetic */ Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public void putAll(Map map) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public Object remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    private EmptyMap() {
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        if (obj instanceof Void) {
            return m3234((Void) obj);
        }
        return false;
    }

    @Override // java.util.Map
    public final Set<Map.Entry> entrySet() {
        return m3233();
    }

    @Override // java.util.Map
    public final Object get(Object obj) {
        return m3232(obj);
    }

    @Override // java.util.Map
    public final Set<Object> keySet() {
        return m3237();
    }

    @Override // java.util.Map
    public final int size() {
        return m3235();
    }

    @Override // java.util.Map
    public final Collection values() {
        return m3236();
    }

    @Override // java.util.Map, java.lang.Object
    public boolean equals(Object obj) {
        return (obj instanceof Map) && ((Map) obj).isEmpty();
    }

    @Override // java.util.Map, java.lang.Object
    public int hashCode() {
        return 0;
    }

    @Override // java.lang.Object
    public String toString() {
        return "{}";
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public int m3235() {
        return 0;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return true;
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return false;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public boolean m3234(Void r2) {
        C1457Fr.m5025(r2, "value");
        return false;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public Void m3232(Object obj) {
        return null;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public Set<Map.Entry> m3233() {
        return EmptySet.f4245;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public Set<Object> m3237() {
        return EmptySet.f4245;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public Collection m3236() {
        return EmptyList.f4243;
    }

    private final Object readResolve() {
        return f4244;
    }
}
