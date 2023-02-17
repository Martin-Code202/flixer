package com.netflix.mediaclient.android.app;

import android.media.MediaDrmException;
import com.android.volley.AuthFailureError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.netflix.mediaclient.StatusCode;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.service.logging.client.model.Error;
import com.netflix.mediaclient.service.msl.client.MslErrorException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.HttpRetryException;
import o.C0510;
import o.C1283;
import org.chromium.net.CronetException;
public abstract class BaseStatus implements Status {

    /* renamed from: ˊ  reason: contains not printable characters */
    private String f847;

    /* renamed from: ˋ  reason: contains not printable characters */
    protected Throwable f848;

    /* renamed from: ॱ  reason: contains not printable characters */
    public StatusCode f849;

    /* renamed from: ʻ  reason: contains not printable characters */
    public abstract Error mo293();

    /* renamed from: ʼ  reason: contains not printable characters */
    public abstract C0510 mo294();

    @Override // com.netflix.mediaclient.android.app.Status
    /* renamed from: ॱ  reason: contains not printable characters */
    public StatusCode mo302() {
        return this.f849;
    }

    @Override // com.netflix.mediaclient.android.app.Status
    /* renamed from: ˎ  reason: contains not printable characters */
    public boolean mo298() {
        return this.f849.m269();
    }

    @Override // com.netflix.mediaclient.android.app.Status
    /* renamed from: ˋ  reason: contains not printable characters */
    public boolean mo297() {
        return this.f849.m270();
    }

    @Override // com.netflix.mediaclient.android.app.Status
    /* renamed from: ˏ  reason: contains not printable characters */
    public boolean mo301() {
        return this.f849.m268();
    }

    @Override // com.netflix.mediaclient.android.app.Status
    /* renamed from: ˊ  reason: contains not printable characters */
    public boolean mo296() {
        return mo301() || mo297();
    }

    @Override // com.netflix.mediaclient.android.app.Status
    /* renamed from: ॱॱ  reason: contains not printable characters */
    public boolean mo304() {
        return StatusCode.m263(this.f849.m271());
    }

    @Override // com.netflix.mediaclient.android.app.Status
    /* renamed from: ᐝ  reason: contains not printable characters */
    public String mo305() {
        return this.f847;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m299(String str) {
        this.f847 = str;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m303(VolleyError volleyError) {
        this.f847 = volleyError.m84();
        this.f848 = volleyError.getCause();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m300(Throwable th) {
        if (th != null) {
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            this.f847 = stringWriter.toString();
            this.f848 = th;
        }
    }

    @Override // com.netflix.mediaclient.android.app.Status
    /* renamed from: ʽ  reason: contains not printable characters */
    public Status.ErrorGroup mo295() {
        if (this.f848 != null) {
            return m289(this.f848, this, this.f847);
        }
        return m291(this);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static Status.ErrorGroup m289(Throwable th, Status status, String str) {
        C1283.m16863("nf_baseStatus", "fromException status=%s", status);
        if ((th instanceof HttpRetryException) || (th instanceof AuthFailureError) || m290(str)) {
            return Status.ErrorGroup.HttpError;
        }
        if ((th instanceof TimeoutError) || (th instanceof CronetException) || (th instanceof IOException) || m288(str)) {
            return Status.ErrorGroup.NetworkError;
        }
        if ((th instanceof MslErrorException) || m292(str)) {
            return Status.ErrorGroup.MslError;
        }
        if (th instanceof MediaDrmException) {
            return Status.ErrorGroup.DrmError;
        }
        return m291(status);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private static Status.ErrorGroup m291(Status status) {
        C1283.m16863("nf_baseStatus", "fromStatusCode status=%s", status);
        if (status.mo302().m273()) {
            return Status.ErrorGroup.HttpError;
        }
        if (status.mo302().m272()) {
            return Status.ErrorGroup.DrmError;
        }
        if (status.mo302().m267()) {
            return Status.ErrorGroup.MslError;
        }
        if (status.mo304()) {
            return Status.ErrorGroup.NetworkError;
        }
        if (status.mo302().m266()) {
            return Status.ErrorGroup.ManifestError;
        }
        return null;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static boolean m290(String str) {
        return str != null && str.contains("500 internal server error");
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private static boolean m288(String str) {
        return str != null && (str.contains("org.chromium.net.impl.NetworkExceptionImpl") || str.contains("com.netflix.mediaclient.service.msl.client.MslUrlHttpURLConnectionImpl"));
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private static boolean m292(String str) {
        return str != null && (str.contains("com.netflix.msl") || str.contains("AndroidMslClient"));
    }
}
