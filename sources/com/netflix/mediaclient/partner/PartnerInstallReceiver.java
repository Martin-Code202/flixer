package com.netflix.mediaclient.partner;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.netflix.mediaclient.NetflixApplication;
import com.netflix.mediaclient.service.job.NetflixJob;
import o.C1283;
import o.C1339Bl;
import o.C1349Bv;
import o.C2014nr;
public class PartnerInstallReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        C1283.m16854("partnerInstallReceiver", "Received an action: " + intent.getAction());
        if ("com.netflix.mediaclient.partner.intent.action.POST_INSTALL_ACTION".equals(intent.getAction())) {
            C1283.m16854("partnerInstallReceiver", "Install intent received");
            m479(context, intent);
            return;
        }
        C1283.m16854("partnerInstallReceiver", "Not supported!");
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m479(Context context, Intent intent) {
        if (intent.hasExtra("installToken")) {
            String stringExtra = intent.getStringExtra("installToken");
            C1283.m16851("partnerInstallReceiver", "received install token %s", stringExtra);
            m478(context, stringExtra);
            m480(context, true);
            new C2014nr(context, NetflixApplication.getInstance().mo258()).mo7115(NetflixJob.NetflixJobId.INSTALL_TOKEN);
            return;
        }
        C1283.m16854("partnerInstallReceiver", "no token present");
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m478(Context context, String str) {
        if (C1349Bv.m4107(str)) {
            C1339Bl.m4039(context, "channelIdValue", str);
            C1283.m16851("partnerInstallReceiver", "stored install token : %s", str);
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m480(Context context, boolean z) {
        C1339Bl.m4048(context, "isPostLoaded", z);
        C1283.m16851("partnerInstallReceiver", "stored isPostLoaded : %b", Boolean.valueOf(z));
    }
}
