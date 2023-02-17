package com.netflix.mediaclient;

import android.app.Notification;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import o.AF;
import o.AbstractC2096qp;
import o.C1281;
import o.C1283;
import o.C1317As;
import o.ServiceC0966;
public class InstallReferrerReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if ("com.android.vending.INSTALL_REFERRER".equals(intent.getAction())) {
            C1283.m16854("nf_install", "Installation intent received");
            C1283.m16849("nf_install", intent);
            m216(context, intent);
            return;
        }
        C1283.m16850("nf_install", "Unexpected intent received");
        C1283.m16849("nf_install", intent);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m216(Context context, Intent intent) {
        String r2 = AF.m3323(intent);
        if (r2 != null) {
            Intent intent2 = new Intent("com.netflix.mediaclient.intent.action.USER_AUTOLOGIN");
            intent2.setClass(context, ServiceC0966.class);
            intent2.addCategory("com.netflix.mediaclient.intent.category.USER");
            intent2.putExtra("token", r2);
            if (C1317As.m3774()) {
                C1283.m16854("nf_install", "Android O, start foreground service...");
                intent2.putExtra("start_foreground", true);
                intent2.putExtra("start_requester", 1);
                context.startForegroundService(intent2);
                return;
            }
            C1283.m16854("nf_install", "Pre Android O, start service...");
            context.startService(intent2);
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static Notification m215(Context context) {
        return ((AbstractC2096qp) C1281.m16832(AbstractC2096qp.class)).mo10109(context);
    }
}
