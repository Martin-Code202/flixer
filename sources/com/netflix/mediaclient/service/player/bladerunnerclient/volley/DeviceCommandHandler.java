package com.netflix.mediaclient.service.player.bladerunnerclient.volley;

import android.content.Context;
import o.AbstractApplicationC1258;
import o.C1330Bc;
import o.C1349Bv;
import org.json.JSONObject;
public class DeviceCommandHandler {
    /* renamed from: ˋ  reason: contains not printable characters */
    public static boolean m974(JSONObject jSONObject) {
        if (jSONObject == null || !jSONObject.has("deviceCommand")) {
            return false;
        }
        return DeviceCommand.m978(jSONObject.optString("deviceCommand")).m977();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static void m975(Context context, JSONObject jSONObject) {
        m976(context, jSONObject.optString("deviceCommand"));
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static void m976(Context context, String str) {
        if (!C1349Bv.m4113(str)) {
            DeviceCommand r2 = DeviceCommand.m978(str);
            if (r2.m977()) {
                switch (r2) {
                    case RESET:
                        C1330Bc.m4007(context, "deviceCommand");
                        return;
                    case REBOOT:
                        AbstractApplicationC1258.getInstance().mo252(context, "deviceCommand");
                        return;
                    case EXIT:
                        AbstractApplicationC1258.getInstance().mo246(context);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public enum DeviceCommand {
        RESET("reset"),
        REBOOT("reboot"),
        EXIT("exit"),
        UNKNOWN("");
        

        /* renamed from: ˊ  reason: contains not printable characters */
        private final String f1724;

        private DeviceCommand(String str) {
            this.f1724 = str;
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        private String m980() {
            return this.f1724;
        }

        /* access modifiers changed from: private */
        /* renamed from: ˎ  reason: contains not printable characters */
        public static DeviceCommand m978(String str) {
            DeviceCommand[] values = values();
            for (DeviceCommand deviceCommand : values) {
                if (C1349Bv.m4126(deviceCommand.m980(), str)) {
                    return deviceCommand;
                }
            }
            return UNKNOWN;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        /* renamed from: ˊ  reason: contains not printable characters */
        private boolean m977() {
            return !C1349Bv.m4126(this.f1724, UNKNOWN.m980());
        }
    }
}
