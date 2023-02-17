package o;

import android.content.Intent;
import android.net.Uri;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import java.util.Map;
/* renamed from: o.ad  reason: case insensitive filesystem */
public final class C1499ad {

    /* renamed from: ʼ  reason: contains not printable characters */
    private C1662da f6011;

    /* renamed from: ʽ  reason: contains not printable characters */
    private C1665dd f6012;

    /* renamed from: ˊ  reason: contains not printable characters */
    private C1603cW f6013;

    /* renamed from: ˋ  reason: contains not printable characters */
    private C1601cU f6014;

    /* renamed from: ˎ  reason: contains not printable characters */
    private C1606cZ f6015;

    /* renamed from: ˏ  reason: contains not printable characters */
    private C1664dc f6016;

    /* renamed from: ॱ  reason: contains not printable characters */
    private K f6017;

    C1499ad(K k) {
        this.f6017 = k;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m5584() {
        C1283.m16854("nf_log_suspend", "Background session start started");
        if (this.f6013 != null) {
            C1283.m16865("nf_log_suspend", "Background session existed before! It should not happen!");
            return;
        }
        this.f6013 = new C1603cW();
        this.f6017.mo4786(this.f6013);
        this.f6017.mo4783(this.f6013.m5841());
        C1283.m16854("nf_log_suspend", "Background session start done.");
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m5585() {
        if (this.f6013 != null) {
            C1283.m16854("nf_log_suspend", "Background session end started");
            this.f6017.mo4785(this.f6013);
            this.f6017.mo4783(this.f6013.m5840());
            this.f6013 = null;
            C1283.m16854("nf_log_suspend", "Background session end done.");
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m5578() {
        C1283.m16854("nf_log_suspend", "Backgrounding session start started");
        if (this.f6014 != null) {
            C1283.m16865("nf_log_suspend", "Backgrounding session existed before! It should not happen!");
            return;
        }
        this.f6014 = new C1601cU();
        this.f6017.mo4786(this.f6014);
        C1283.m16854("nf_log_suspend", "Background session start done.");
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m5583() {
        if (this.f6014 != null) {
            C1283.m16854("nf_log_suspend", "Backgrounding session end started");
            this.f6017.mo4785(this.f6014);
            this.f6017.mo4783(this.f6014.m5839());
            this.f6014 = null;
            C1283.m16854("nf_log_suspend", "Backgrounding session end done.");
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m5581() {
        C1283.m16854("nf_log_suspend", "Resuming session start started");
        if (this.f6016 != null) {
            C1283.m16865("nf_log_suspend", "Resuming session existed before! It should not happen!");
            return;
        }
        this.f6016 = new C1664dc();
        this.f6017.mo4786(this.f6016);
        C1283.m16854("nf_log_suspend", "Resuming session start done.");
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    public void m5587() {
        if (this.f6016 != null) {
            C1283.m16854("nf_log_suspend", "Resuming session end started");
            this.f6017.mo4785(this.f6016);
            this.f6017.mo4783(this.f6016.m6013());
            this.f6016 = null;
            C1283.m16854("nf_log_suspend", "Resuming session end done.");
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m5579(Intent intent) {
        C1283.m16854("nf_log_suspend", "Foreground session start started");
        C1487aS r2 = m5574(intent);
        if (this.f6015 != null) {
            C1283.m16854("nf_log_suspend", "Foreground session existed before");
            if (r2 == null) {
                C1283.m16865("nf_log_suspend", "Not deeplink, ignore.");
                return;
            } else {
                C1283.m16854("nf_log_suspend", "Deeplink found, end existing foreground session...");
                m5576();
            }
        }
        this.f6015 = new C1606cZ();
        this.f6017.mo4786(this.f6015);
        this.f6017.mo4783(this.f6015.m5842(null, r2));
        C1283.m16854("nf_log_suspend", "Foreground session start done.");
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private C1487aS m5574(Intent intent) {
        if (intent == null) {
            return null;
        }
        Uri data = intent.getData();
        String stringExtra = intent.getStringExtra(NetflixActivity.EXTRA_SOURCE);
        if (C1349Bv.m4113(stringExtra)) {
            return null;
        }
        Map<String, String> r3 = C1330Bc.m4009(data);
        r3.put(NetflixActivity.EXTRA_SOURCE, stringExtra);
        return m5573(r3);
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public void m5576() {
        if (this.f6015 != null) {
            C1283.m16854("nf_log_suspend", "Foreground session end started");
            this.f6017.mo4785(this.f6015);
            this.f6017.mo4783(this.f6015.m5843());
            this.f6015 = null;
            C1283.m16854("nf_log_suspend", "Foreground session end done.");
        }
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public void m5577() {
        C1283.m16854("nf_log_suspend", "Suspend session start started");
        if (this.f6012 != null) {
            C1283.m16865("nf_log_suspend", "Suspend session existed before! It should not happen!");
            return;
        }
        this.f6012 = new C1665dd();
        this.f6017.mo4786(this.f6012);
        this.f6017.mo4783(this.f6012.m6015());
        C1283.m16854("nf_log_suspend", "Suspend session start done.");
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public void m5586() {
        if (this.f6012 != null) {
            C1283.m16854("nf_log_suspend", "Suspend session end started");
            this.f6017.mo4785(this.f6012);
            this.f6017.mo4783(this.f6012.m6014());
            this.f6012 = null;
            C1283.m16854("nf_log_suspend", "Suspend session end done.");
        }
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public void m5575() {
        C1283.m16854("nf_log_suspend", "Unfocused session start started");
        if (this.f6011 != null) {
            C1283.m16865("nf_log_suspend", "Unfocused session existed before! It should not happen!");
            return;
        }
        this.f6011 = new C1662da();
        this.f6017.mo4786(this.f6011);
        this.f6011.m6011();
        C1283.m16854("nf_log_suspend", "Unfocused session start done.");
    }

    /* renamed from: ˋॱ  reason: contains not printable characters */
    public void m5582() {
        if (this.f6011 != null) {
            C1283.m16854("nf_log_suspend", "Unfocused session end started");
            this.f6017.mo4785(this.f6011);
            C1675dn r2 = this.f6011.m6010();
            if (!(r2 == null || this.f6011.m6012() == null)) {
                this.f6017.mo4783(this.f6011.m6012());
                this.f6017.mo4783(r2);
            }
            this.f6011 = null;
            C1283.m16854("nf_log_suspend", "Unfocused session end done.");
        }
    }

    /* renamed from: ˊॱ  reason: contains not printable characters */
    public synchronized void m5580() {
        m5583();
        m5585();
        m5587();
        m5576();
        m5586();
        m5582();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private static C1487aS m5573(Map<String, String> map) {
        return C1487aS.m5390(m5572(map), m5571(map));
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static String m5572(Map<String, String> map) {
        String str = map.get(NetflixActivity.EXTRA_SOURCE);
        if (C1349Bv.m4113(str)) {
            str = map.get("s");
            if (C1349Bv.m4113(str)) {
                C1283.m16865("nf_log_suspend", "Source is empty!");
                return "uknown";
            }
        }
        return str;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private static String m5571(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (String str : map.keySet()) {
            String str2 = map.get(str);
            if (C1349Bv.m4107(str2)) {
                if (z) {
                    z = false;
                } else {
                    sb.append('&');
                }
                sb.append(str).append('=').append(str2);
            }
        }
        return sb.toString();
    }
}
