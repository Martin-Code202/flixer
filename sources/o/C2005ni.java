package o;

import com.netflix.mediaclient.android.app.Status;
/* renamed from: o.ni  reason: case insensitive filesystem */
public class C2005ni implements AbstractC2006nj {
    @Override // o.AbstractC2006nj
    /* renamed from: ˎ */
    public void mo8943(String str, String str2, Status status) {
        if (status.mo301()) {
            C1283.m16855("nf_service_resfetcher_callback", "Resource %s could not be fetched, status %d", str, Integer.valueOf(status.mo302().m271()));
        } else {
            C1283.m16863("nf_service_resfetcher_callback", "Resource %s fetched and saved at %s, status %d", str, str2, Integer.valueOf(status.mo302().m271()));
        }
    }

    @Override // o.AbstractC2006nj
    /* renamed from: ˎ */
    public void mo9311(String str, String str2, long j, long j2, Status status) {
        if (status.mo301()) {
            C1283.m16855("nf_service_resfetcher_callback", "Resource %s could not be fetched or retrieved from cache, status %d", str, Integer.valueOf(status.mo302().m271()));
        } else {
            C1283.m16851("nf_service_resfetcher_callback", "Resource %s fetched and cached, status %d", str, Integer.valueOf(status.mo302().m271()));
        }
    }

    @Override // o.AbstractC2006nj
    /* renamed from: ˎ */
    public void mo7553(String str, byte[] bArr, Status status) {
        if (status.mo301()) {
            C1283.m16855("nf_service_resfetcher_callback", "Resource %s could NOT be fetched, status %d", str, Integer.valueOf(status.mo302().m271()));
        } else {
            C1283.m16863("nf_service_resfetcher_callback", "Resource %s fetched and response returned raw, status %d", str, Integer.valueOf(status.mo302().m271()));
        }
    }
}
