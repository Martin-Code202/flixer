package o;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import com.netflix.cl.Logger;
/* renamed from: o.Cc  reason: case insensitive filesystem */
public class C1357Cc extends AbstractC1358Cd {
    /* renamed from: ˊ  reason: contains not printable characters */
    public static void m4343(Context context, C1785fr frVar) {
        if (!m4349(context, "Context can not be null!")) {
            if (frVar == null) {
                C1283.m16850("nf_log", "Device is null!");
                return;
            }
            Intent intent = new Intent("com.netflix.mediaclient.intent.action.LOG_DIAL_SERVER_DISCOVERED");
            intent.addCategory("com.netflix.mediaclient.intent.category.LOGGING");
            if (C1349Bv.m4107(frVar.f6808)) {
                intent.putExtra("uuid", frVar.f6808);
            }
            intent.putExtra("desc", m4345(frVar.f6809, frVar.f6800, frVar.f6801));
            LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
            Logger.INSTANCE.m131(new C1146(frVar.f6808, m4345(frVar.f6809, frVar.f6800, frVar.f6801), null));
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static void m4344(Context context, String str, String str2, String str3) {
        if (!m4349(context, "Context can not be null!")) {
            C1283.m16851("nf_log", "reportCastDeviceFound:: uuid: %s, location: %s, fn: %s", str, str2, str3);
            Intent intent = new Intent("com.netflix.mediaclient.intent.action.LOG_DIAL_SERVER_DISCOVERED");
            intent.addCategory("com.netflix.mediaclient.intent.category.LOGGING");
            if (C1349Bv.m4107(str)) {
                intent.putExtra("uuid", str);
            }
            intent.putExtra("desc", m4345(null, null, str3));
            LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
            Logger.INSTANCE.m131(new C1146(str, m4345(null, null, str3), null));
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private static String m4345(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\"?>").append("<root xmlns=\"urn:schemas-upnp-org:device-1-0\">").append("<specVersion><major>1</major><minor>1</minor></specVersion>").append("<device>");
        if (C1349Bv.m4107(str)) {
            sb.append("<manufacturer>").append(str).append("</manufacturer>");
        }
        if (C1349Bv.m4107(str3)) {
            sb.append("<friendlyName>").append(str3).append("</friendlyName>");
        }
        if (C1349Bv.m4107(str2)) {
            sb.append("<modelName>").append(str2).append("</modelName>");
        }
        sb.append("</device></root>");
        return sb.toString();
    }
}
