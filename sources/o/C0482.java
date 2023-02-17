package o;

import android.os.Handler;
import android.os.Looper;
import com.android.volley.Request;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
/* renamed from: o.І  reason: contains not printable characters */
public class C0482 {

    /* renamed from: ʻ  reason: contains not printable characters */
    private C1160 f13548;

    /* renamed from: ʼ  reason: contains not printable characters */
    private final AbstractC0450 f13549;

    /* renamed from: ʽ  reason: contains not printable characters */
    private final AbstractC1001 f13550;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final PriorityBlockingQueue<Request> f13551;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final Map<String, Queue<Request>> f13552;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private final C1172 f13553;

    /* renamed from: ˎ  reason: contains not printable characters */
    private AtomicInteger f13554;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final PriorityBlockingQueue<Request> f13555;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private String f13556;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final Set<Request> f13557;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private AbstractC1215[] f13558;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final AbstractC0419 f13559;

    /* renamed from: o.І$ˊ  reason: contains not printable characters */
    public interface AbstractC0483 {
        /* renamed from: ˎ */
        boolean mo14418(Request<?> request);
    }

    public C0482(AbstractC1001 r8, AbstractC0419 r9, int i, AbstractC0450 r11, String str) {
        this(r8, r9, i, r11, str, new C1172());
    }

    public C0482(AbstractC1001 r2, AbstractC0419 r3, int i, AbstractC0450 r5, String str, C1172 r7) {
        this.f13554 = new AtomicInteger();
        this.f13552 = new HashMap();
        this.f13557 = new HashSet();
        this.f13555 = new PriorityBlockingQueue<>();
        this.f13551 = new PriorityBlockingQueue<>();
        this.f13550 = r2;
        this.f13559 = r3;
        this.f13558 = new AbstractC1215[i];
        this.f13549 = r5;
        this.f13556 = str;
        if (r7 == null) {
            this.f13553 = new C1172();
        } else {
            this.f13553 = r7;
        }
    }

    public C0482(AbstractC1001 r8, AbstractC0419 r9, int i, String str) {
        this(r8, r9, i, new C1165(new Handler(Looper.getMainLooper())), str);
    }

    public C0482(AbstractC1001 r2, AbstractC0419 r3, String str) {
        this(r2, r3, 4, str);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m14410() {
        m14416();
        this.f13548 = new C1160(this.f13555, this.f13551, this.f13550, this.f13549);
        this.f13548.start();
        String str = this.f13556 != null ? this.f13556 + "-" : "";
        for (int i = 0; i < this.f13558.length; i++) {
            AbstractC1215 r8 = this.f13553.mo14859(this.f13551, this.f13559, this.f13550, this.f13549, str + i);
            this.f13558[i] = r8;
            r8.start();
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m14416() {
        if (this.f13548 != null) {
            this.f13548.m16348();
        }
        for (int i = 0; i < this.f13558.length; i++) {
            if (this.f13558[i] != null) {
                this.f13558[i].mo16376();
            }
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public int m14412() {
        return this.f13554.incrementAndGet();
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public AbstractC1001 m14413() {
        return this.f13550;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m14417(AbstractC0483 r9) {
        synchronized (this.f13557) {
            for (Request request : this.f13557) {
                if (r9.mo14418(request)) {
                    C0509.m14523("Cancelling req %s", request.getUrl());
                    request.cancel();
                }
            }
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m14411(final Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Cannot cancelAll with a null tag");
        }
        m14417(new AbstractC0483() { // from class: o.І.2
            @Override // o.C0482.AbstractC0483
            /* renamed from: ˎ  reason: contains not printable characters */
            public boolean mo14418(Request<?> request) {
                return request.getTag() == obj;
            }
        });
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public Request m14415(Request request) {
        request.setRequestQueue(this);
        synchronized (this.f13557) {
            this.f13557.add(request);
        }
        request.setSequence(m14412());
        request.addMarker("add-to-queue");
        if (!request.shouldCache()) {
            this.f13551.add(request);
            return request;
        }
        synchronized (this.f13552) {
            String cacheKey = request.getCacheKey();
            if (this.f13552.containsKey(cacheKey)) {
                Queue<Request> queue = this.f13552.get(cacheKey);
                if (queue == null) {
                    queue = new LinkedList<>();
                }
                queue.add(request);
                this.f13552.put(cacheKey, queue);
            } else {
                this.f13552.put(cacheKey, null);
                this.f13555.add(request);
            }
        }
        return request;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m14414(Request request) {
        synchronized (this.f13557) {
            this.f13557.remove(request);
        }
        if (request.shouldCache()) {
            synchronized (this.f13552) {
                Queue<Request> remove = this.f13552.remove(request.getCacheKey());
                if (remove != null) {
                    this.f13555.addAll(remove);
                }
            }
        }
    }
}
