package com.netflix.mediaclient.service.user;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import o.C1283;
import o.C1339Bl;
public final class PartnerReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if ("com.netflix.mediaclient.intent.action.USER_STATUS".equals(intent.getAction())) {
            m1249(context, intent);
        } else {
            C1283.m16865("nf_receiver", "Received Unintented action : " + intent.getAction());
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m1249(Context context, Intent intent) {
        C1283.m16854("nf_receiver", "Received user status request");
        m1250(context, C1339Bl.m4051(context, "nf_user_status_loggedin", false));
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    static void m1250(Context context, boolean z) {
        C1283.m16854("nf_receiver", "broadcastUserStatus");
        Intent intent = new Intent("com.netflix.mediaclient.intent.action.USER_STATUS_RESPONSE");
        intent.putExtra("loggedIn", z);
        context.sendBroadcast(intent);
    }
}
