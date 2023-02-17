package o;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
public class AW<K, V> implements AbstractC1329Bb<K, V> {

    /* renamed from: ˎ  reason: contains not printable characters */
    private LinkedHashMap<K, Collection<V>> f4326;

    public AW() {
        this.f4326 = new LinkedHashMap<>();
    }

    public AW(int i) {
        this.f4326 = new LinkedHashMap<>(i);
    }

    @Override // o.AbstractC1329Bb
    /* renamed from: ˋ  reason: contains not printable characters */
    public Collection<V> mo3487(K k) {
        return this.f4326.get(k);
    }

    @Override // java.util.Map
    public void clear() {
        this.f4326.clear();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return this.f4326.containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        for (K k : this.f4326.keySet()) {
            Collection<V> collection = this.f4326.get(k);
            if (collection != null && collection.contains(obj)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Map.Entry<K, Collection<V>> entry : this.f4326.entrySet()) {
            for (V v : entry.getValue()) {
                linkedHashSet.add(new C0063(entry.getKey(), v));
            }
        }
        return linkedHashSet;
    }

    @Override // java.util.Map
    public V get(Object obj) {
        Collection<V> collection = this.f4326.get(obj);
        if (collection == null || collection.size() < 1) {
            return null;
        }
        ArrayList arrayList = (ArrayList) collection;
        return (V) arrayList.get(arrayList.size() - 1);
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.f4326.isEmpty();
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        return this.f4326.keySet();
    }

    @Override // java.util.Map
    public V put(K k, V v) {
        Collection<V> collection = this.f4326.get(k);
        if (collection == null) {
            collection = new ArrayList<>();
            this.f4326.put(k, collection);
        }
        collection.add(v);
        return v;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: o.AW<K, V> */
    /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: o.Bb */
    /* JADX DEBUG: Multi-variable search result rejected for r0v7, resolved type: java.util.LinkedHashMap<K, java.util.Collection<V>> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        if (map instanceof AbstractC1329Bb) {
            AbstractC1329Bb bb = (AbstractC1329Bb) map;
            for (Object obj : map.keySet()) {
                Collection<? extends V> r4 = bb.mo3487(obj);
                Collection<V> collection = this.f4326.get(obj);
                if (collection != null) {
                    collection.addAll(r4);
                } else {
                    this.f4326.put(obj, r4);
                }
            }
            return;
        }
        for (Object obj2 : map.keySet()) {
            put(obj2, map.get(obj2));
        }
    }

    @Override // java.util.Map
    public V remove(Object obj) {
        Collection<V> remove = this.f4326.remove(obj);
        if (remove == null || remove.size() < 1) {
            return null;
        }
        ArrayList arrayList = (ArrayList) remove;
        return (V) arrayList.get(arrayList.size() - 1);
    }

    @Override // java.util.Map
    public int size() {
        return this.f4326.size();
    }

    @Override // java.util.Map
    public Collection<V> values() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<K, Collection<V>> entry : this.f4326.entrySet()) {
            for (V v : entry.getValue()) {
                arrayList.add(v);
            }
        }
        return arrayList;
    }

    /* renamed from: o.AW$ˋ  reason: contains not printable characters */
    static class C0063<K, V> implements Map.Entry<K, V> {

        /* renamed from: ˋ  reason: contains not printable characters */
        private K f4327;

        /* renamed from: ˏ  reason: contains not printable characters */
        private V f4328;

        public C0063(K k, V v) {
            this.f4327 = k;
            this.f4328 = v;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f4327;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f4328;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            this.f4328 = v;
            return this.f4328;
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            C0063 r2 = (C0063) obj;
            if (this.f4327 != null) {
                if (!this.f4327.equals(r2.f4327)) {
                    return false;
                }
            } else if (r2.f4327 != null) {
                return false;
            }
            if (this.f4328 != null) {
                return this.f4328.equals(r2.f4328);
            }
            return r2.f4328 == null;
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public int hashCode() {
            return ((this.f4327 != null ? this.f4327.hashCode() : 0) * 31) + (this.f4328 != null ? this.f4328.hashCode() : 0);
        }
    }
}
