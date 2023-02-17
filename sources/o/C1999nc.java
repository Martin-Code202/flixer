package o;

import android.content.Intent;
/* renamed from: o.nc  reason: case insensitive filesystem */
public final class C1999nc {

    /* renamed from: ˊ  reason: contains not printable characters */
    private String f9116;

    /* renamed from: ˋ  reason: contains not printable characters */
    private String f9117;

    /* renamed from: ˎ  reason: contains not printable characters */
    private String f9118;

    /* renamed from: ˏ  reason: contains not printable characters */
    private String f9119;

    private C1999nc(String str, String str2, String str3, String str4) {
        this.f9118 = str;
        this.f9119 = str2;
        this.f9117 = str3;
        this.f9116 = str4;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public String m9281() {
        return this.f9119;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public String m9282() {
        return this.f9118;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public String m9279() {
        return this.f9117;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public String m9280() {
        return this.f9116;
    }

    public String toString() {
        return "MessageData [mGuid=" + this.f9118 + ", mMessageGuid=" + this.f9119 + ", mOriginator=" + this.f9117 + ", sound=" + this.f9116 + "]";
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static C1999nc m9278(Intent intent) {
        C1283.m16853("nf_push", "MessageData::", intent);
        String stringExtra = intent.getStringExtra("guid");
        if (C1349Bv.m4113(stringExtra)) {
            C1283.m16865("nf_push", "Guid not found, source is not (proper) push notification");
        }
        String stringExtra2 = intent.getStringExtra("messageGuid");
        if (C1349Bv.m4113(stringExtra2)) {
            C1283.m16854("nf_push", "Message guid not found, source is not (proper) push notification");
        }
        String stringExtra3 = intent.getStringExtra("originator");
        if (C1349Bv.m4113(stringExtra3)) {
            C1283.m16865("nf_push", "Received notification WITHOUT ORIGINATOR! Pass default!");
        }
        String stringExtra4 = intent.getStringExtra("sound");
        if (C1349Bv.m4113(stringExtra4)) {
            C1283.m16865("nf_push", "Received notification WITHOUT Sound! Pass default!");
        }
        return new C1999nc(stringExtra, stringExtra2, stringExtra3, stringExtra4);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static void m9277(Intent intent, C1999nc ncVar) {
        if (intent == null || ncVar == null) {
            C1283.m16865("nf_push", "Intent or msg is null!");
            return;
        }
        if (C1349Bv.m4107(ncVar.m9282())) {
            intent.putExtra("guid", ncVar.m9282());
        }
        if (C1349Bv.m4107(ncVar.m9281())) {
            intent.putExtra("messageGuid", ncVar.m9281());
        }
        if (C1349Bv.m4107(ncVar.m9279())) {
            intent.putExtra("originator", ncVar.m9279());
        }
        if (C1349Bv.m4107(ncVar.m9280())) {
            intent.putExtra("sound", ncVar.m9280());
        }
    }
}
