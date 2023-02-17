package o;

import android.util.LruCache;
/* renamed from: o.γ  reason: contains not printable characters */
public class C0456<K, V> extends LruCache<K, V> {

    /* renamed from: ˏ  reason: contains not printable characters */
    private final String f13504;

    public C0456(String str, int i) {
        super(i);
        this.f13504 = str;
    }

    /* access modifiers changed from: protected */
    @Override // android.util.LruCache
    public void entryRemoved(boolean z, K k, V v, V v2) {
        C1283.m16846(this.f13504, (z ? "- Evicted: " : "- Entry removed: ") + ((Object) k));
        super.entryRemoved(z, k, v, v2);
    }
}
