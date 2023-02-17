package com.netflix.mediaclient.service.falkor;

import com.netflix.mediaclient.StatusCode;
import com.netflix.mediaclient.android.app.NetflixStatus;
public class FalkorAgentStatus extends NetflixStatus {

    /* renamed from: ʻ  reason: contains not printable characters */
    private final boolean f1110;

    public FalkorAgentStatus(StatusCode statusCode, boolean z) {
        super(statusCode);
        this.f1110 = z;
    }

    /* renamed from: ˋॱ  reason: contains not printable characters */
    public boolean m546() {
        return this.f1110;
    }
}
