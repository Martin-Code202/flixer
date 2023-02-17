package com.netflix.mediaclient.ui.error;

import android.content.Context;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.StatusCode;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.service.user.UserAgentInterface;
import o.AbstractC1268;
import o.AbstractC1635d;
import o.C0355;
import o.C0505;
import o.C1061;
import o.C1283;
import o.C2137rz;
import o.C2321xp;
import o.oD;
import o.rK;
import o.rN;
import o.rP;
public enum ErrorDescriptorFactoryImpl implements AbstractC1635d {
    INSTANCE;

    @Override // o.AbstractC1635d
    /* renamed from: ˋ  reason: contains not printable characters */
    public AbstractC1268 mo1764(Context context, StatusCode statusCode) {
        return C2321xp.m12967(context, statusCode);
    }

    @Override // o.AbstractC1635d
    /* renamed from: ॱ  reason: contains not printable characters */
    public AbstractC1268 mo1765(Context context, StatusCode statusCode, Runnable runnable, int i) {
        return new rP(context, statusCode, runnable, i);
    }

    @Override // o.AbstractC1635d
    /* renamed from: ॱ  reason: contains not printable characters */
    public AbstractC1268 mo1766(Context context, Status status, boolean z) {
        return new rK(context, status, z);
    }

    @Override // o.AbstractC1635d
    /* renamed from: ˊ  reason: contains not printable characters */
    public AbstractC1268 mo1763(Context context, oD oDVar, UserAgentInterface userAgentInterface, C0355 r13) {
        if (!r13.m13991("actionid")) {
            C1283.m16865("AppBootErrorManager", "Error found, but not actionid. Not expected!");
            return null;
        }
        int r5 = r13.m13988("actionid");
        C0355 r7 = r13.m13992("usertextgroup");
        if (r7 == null) {
            C1283.m16855("AppBootErrorManager", "Action ID %d, but missing error text, use default...", Integer.valueOf(r5));
        } else {
            C1283.m16851("AppBootErrorManager", "Action ID %d found message '%s' for language %s", Integer.valueOf(r5), r7.m13972("text"), r7.m13972("bcp47"));
        }
        C1283.m16851("AppBootErrorManager", "ActionID %d ", Integer.valueOf(r5));
        switch (r5) {
            case 13:
                return C2137rz.m10499(context, oDVar, userAgentInterface, null);
            default:
                C1283.m16865("AppBootErrorManager", "default, Not supported actionid");
                return null;
        }
    }

    @Override // o.AbstractC1635d
    /* renamed from: ˊ  reason: contains not printable characters */
    public AbstractC1268 mo1762(final Context context, Runnable runnable) {
        String string = context.getString(R.string.label_cs_call_failed);
        return new rN(new C0505.If(context.getString(R.string.label_cs_call_failed_title), string, context.getString(R.string.label_retry), new Runnable() { // from class: com.netflix.mediaclient.ui.error.ErrorDescriptorFactoryImpl.2
            @Override // java.lang.Runnable
            public void run() {
                C1283.m16854("AppBootErrorManager", "Start Contact us activity!");
                C1061.m16114().mo14172(context);
            }
        }, context.getString(R.string.label_cancel), runnable));
    }
}
