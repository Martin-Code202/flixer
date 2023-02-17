package o;

import android.os.Handler;
import android.os.HandlerThread;
import com.google.gson.JsonElement;
import com.netflix.falkor.cache.FalkorCache;
import io.realm.Realm;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* access modifiers changed from: package-private */
/* renamed from: o.ｼ  reason: contains not printable characters */
public class C1259 extends C1248 {

    /* renamed from: ˋ  reason: contains not printable characters */
    private static final AtomicInteger f15843 = new AtomicInteger(0);

    /* renamed from: ˊ  reason: contains not printable characters */
    private final Handler f15844;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final HandlerThread f15845;

    private C1259(HandlerThread handlerThread, Handler handler, Realm realm, AbstractC1261 r4, long j) {
        super(realm, r4, j);
        this.f15845 = handlerThread;
        this.f15844 = handler;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    static AbstractC1096 m16695(AbstractC1261 r13, long j) {
        HandlerThread handlerThread = new HandlerThread("falkorCacheThread-" + f15843.incrementAndGet());
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper());
        final AtomicReference atomicReference = new AtomicReference();
        handler.post(new Runnable() { // from class: o.ｼ.1
            @Override // java.lang.Runnable
            public void run() {
                atomicReference.set(FalkorCache.C0004.m186());
                synchronized (atomicReference) {
                    atomicReference.notify();
                }
            }
        });
        try {
            synchronized (atomicReference) {
                atomicReference.wait();
            }
            return new C1259(handlerThread, handler, (Realm) atomicReference.get(), r13, j);
        } catch (InterruptedException e) {
            throw new RuntimeException("Interrupted while running getRealmAccess task. Should not happen", e);
        }
    }

    @Override // o.C1248, o.AbstractC1096, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f15844.post(new Runnable() { // from class: o.ｼ.2
            @Override // java.lang.Runnable
            public void run() {
                FalkorCache.C0004.m184(C1259.this.m16619());
            }
        });
        this.f15845.quitSafely();
    }

    @Override // o.C1248, o.AbstractC1096
    /* renamed from: ˊ */
    public void mo16192() {
        this.f15844.post(new Runnable() { // from class: o.ｼ.3
            @Override // java.lang.Runnable
            public void run() {
                FalkorCache.C0004.m189(C1259.this.m16619());
            }
        });
    }

    @Override // o.C1248, o.AbstractC1096
    /* renamed from: ˏ */
    public void mo16197() {
        this.f15844.post(new Runnable() { // from class: o.ｼ.5
            @Override // java.lang.Runnable
            public void run() {
                FalkorCache.C0004.m185(C1259.this.m16619());
            }
        });
    }

    @Override // o.C1248, o.AbstractC1096
    /* renamed from: ˎ */
    public void mo16195() {
        this.f15844.post(new Runnable() { // from class: o.ｼ.4
            @Override // java.lang.Runnable
            public void run() {
                FalkorCache.C0004.m187(C1259.this.m16619());
            }
        });
    }

    @Override // o.C1248, o.AbstractC1096
    /* renamed from: ˎ */
    public void mo16196(final ArrayList<String> arrayList, final JsonElement jsonElement, final Date date) {
        this.f15844.post(new Runnable() { // from class: o.ｼ.10
            @Override // java.lang.Runnable
            public void run() {
                C1259.super.mo16196(arrayList, jsonElement, date);
            }
        });
    }

    @Override // o.C1248, o.AbstractC1096
    /* renamed from: ॱ */
    public void mo16198(ArrayList<String> arrayList, JsonElement jsonElement) {
        mo16196(arrayList, jsonElement, null);
    }

    @Override // o.C1248, o.AbstractC1096
    /* renamed from: ˋ */
    public Object mo16193(List<Object> list, int i, String str, AbstractC0730 r6) {
        throw new UnsupportedOperationException("Use RealmFalkorCacheHelperImpl for cache retrieval");
    }

    @Override // o.C1248, o.AbstractC1096
    /* renamed from: ˋ */
    public void mo16194() {
        throw new UnsupportedOperationException("Use RealmFalkorCacheHelperImpl for cache expiration");
    }

    @Override // o.C1248, o.AbstractC1096
    /* renamed from: ॱ */
    public void mo16199(List<Object> list) {
        throw new UnsupportedOperationException("Use RealmFalkorCacheHelperImpl for cache deletes");
    }
}
