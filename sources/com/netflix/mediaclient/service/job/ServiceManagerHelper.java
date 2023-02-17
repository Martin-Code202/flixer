package com.netflix.mediaclient.service.job;

import android.content.Context;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.service.job.NetflixJob;
import o.C1283;
import o.C2059ph;
import o.oV;
public class ServiceManagerHelper {

    /* renamed from: ˋ  reason: contains not printable characters */
    private C2059ph f1128;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final oV f1129;

    /* renamed from: ˏ  reason: contains not printable characters */
    private ServiceManagerState f1130;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final AbstractC0016 f1131;

    /* access modifiers changed from: package-private */
    public enum ServiceManagerState {
        WaitingForResult,
        ServiceManagerReady,
        ServiceManagerFailed
    }

    /* renamed from: com.netflix.mediaclient.service.job.ServiceManagerHelper$ˊ  reason: contains not printable characters */
    public interface AbstractC0016 {
        /* renamed from: ˎ  reason: contains not printable characters */
        void mo591();

        /* renamed from: ˏ  reason: contains not printable characters */
        void mo592();
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public boolean m586() {
        return this.f1130 == ServiceManagerState.ServiceManagerReady;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public boolean m588() {
        return this.f1130 == ServiceManagerState.ServiceManagerFailed;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m590() {
        if (this.f1128 != null) {
            this.f1128.m9799();
            this.f1128 = null;
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m589(NetflixJob.NetflixJobId netflixJobId) {
        if (this.f1128 != null) {
            this.f1128.m9800(netflixJobId);
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m587(NetflixJob.NetflixJobId netflixJobId) {
        if (this.f1128 != null) {
            this.f1128.m9767(netflixJobId);
        }
    }

    public ServiceManagerHelper(Context context, AbstractC0016 r4) {
        this.f1130 = ServiceManagerState.WaitingForResult;
        this.f1129 = new oV() { // from class: com.netflix.mediaclient.service.job.ServiceManagerHelper.5
            @Override // o.oV
            public void onManagerReady(C2059ph phVar, Status status) {
                if (ServiceManagerHelper.this.f1128 == null) {
                    C1283.m16862("nf_job_svcmgr_helper", "got a callback even after the mServiceManager release");
                } else if (status.mo298()) {
                    ServiceManagerHelper.this.f1130 = ServiceManagerState.ServiceManagerReady;
                    ServiceManagerHelper.this.f1131.mo592();
                } else {
                    ServiceManagerHelper.this.f1130 = ServiceManagerState.ServiceManagerFailed;
                    ServiceManagerHelper.this.f1131.mo591();
                }
            }

            @Override // o.oV
            public void onManagerUnavailable(C2059ph phVar, Status status) {
                ServiceManagerHelper.this.f1130 = ServiceManagerState.ServiceManagerFailed;
            }
        };
        this.f1130 = ServiceManagerState.WaitingForResult;
        this.f1128 = new C2059ph();
        this.f1128.m9769(this.f1129);
        this.f1131 = r4;
    }
}
