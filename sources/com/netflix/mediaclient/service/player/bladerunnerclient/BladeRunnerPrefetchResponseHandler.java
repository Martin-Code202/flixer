package com.netflix.mediaclient.service.player.bladerunnerclient;

import com.netflix.mediaclient.service.player.bladerunnerclient.volley.FetchLicenseRequest;
import java.util.LinkedHashMap;
import java.util.Map;
import o.C1283;
import o.C1910jk;
public abstract class BladeRunnerPrefetchResponseHandler {

    /* renamed from: ˊ  reason: contains not printable characters */
    public static String f1616 = "nf_bladerunner";

    /* renamed from: ˎ  reason: contains not printable characters */
    private final Map<Long, C1910jk> f1617 = new PrefetchRequestTrackingMap();

    /* renamed from: ॱ  reason: contains not printable characters */
    private final Map<Long, FetchLicenseRequest> f1618 = new PrefetchRequestTrackingMap();

    static class PrefetchRequestTrackingMap<K, V> extends LinkedHashMap<K, V> {
        PrefetchRequestTrackingMap() {
        }

        /* access modifiers changed from: protected */
        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(Map.Entry<K, V> entry) {
            return size() >= 16;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊ  reason: contains not printable characters */
    public void m936(Long l, FetchLicenseRequest fetchLicenseRequest) {
        synchronized (this.f1618) {
            this.f1618.remove(l);
            this.f1618.put(l, fetchLicenseRequest);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public FetchLicenseRequest m938(Long l) {
        FetchLicenseRequest remove;
        synchronized (this.f1618) {
            remove = this.f1618.remove(l);
        }
        return remove;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m941(Long l) {
        C1283.m16851(f1616, "%d receives LDL resposne.", l);
        synchronized (this.f1618) {
            this.f1618.remove(l);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public void m939(Long[] lArr, C1910jk jkVar) {
        synchronized (this.f1617) {
            for (Long l : lArr) {
                this.f1617.put(l, jkVar);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˎ  reason: contains not printable characters */
    public C1910jk m940(Long l) {
        C1910jk remove;
        synchronized (this.f1617) {
            remove = this.f1617.remove(l);
            if (remove != null) {
                m935(remove.m8010());
            }
        }
        return remove;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m937(Long[] lArr) {
        m935(lArr);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m935(Long[] lArr) {
        synchronized (this.f1617) {
            for (Long l : lArr) {
                this.f1617.remove(l);
            }
        }
    }
}
