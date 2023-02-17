package o;

import android.os.Build;
import com.netflix.cl.model.AllocationMode;
import com.netflix.cl.model.ComputationMode;
import com.netflix.cl.model.InteractionMode;
import com.netflix.cl.model.LoggingSource;
import com.netflix.mediaclient.NetflixApplication;
import java.util.Date;
import java.util.TimeZone;
import o.C0441;
/* renamed from: o.Cp  reason: case insensitive filesystem */
public final class C1373Cp implements C0441.Cif {

    /* renamed from: ˊ  reason: contains not printable characters */
    private NetflixApplication f5184;

    /* renamed from: ˋ  reason: contains not printable characters */
    private C0441.If f5185 = new C0441.If() { // from class: o.Cp.5
        @Override // o.C0441.If
        /* renamed from: ˏ  reason: contains not printable characters */
        public void mo4537(String str) {
            C1276.m16820().mo5725(str);
        }
    };

    /* renamed from: ˎ  reason: contains not printable characters */
    private C0441.AbstractC0442 f5186 = new C0441.AbstractC0442() { // from class: o.Cp.3
        @Override // o.C0441.AbstractC0442
        /* renamed from: ˋ  reason: contains not printable characters */
        public boolean mo4534() {
            return false;
        }

        @Override // o.C0441.AbstractC0442
        /* renamed from: ˋ  reason: contains not printable characters */
        public void mo4533(String str) {
            C1283.m16854("nf_log_clv2", str);
        }

        @Override // o.C0441.AbstractC0442
        /* renamed from: ˊ  reason: contains not printable characters */
        public void mo4532(String str, Object... objArr) {
            C1283.m16851("nf_log_clv2", str, objArr);
        }

        @Override // o.C0441.AbstractC0442
        /* renamed from: ˏ  reason: contains not printable characters */
        public void mo4536(String str) {
            C1283.m16850("nf_log_clv2", str);
        }

        @Override // o.C0441.AbstractC0442
        /* renamed from: ˎ  reason: contains not printable characters */
        public void mo4535(String str, Object... objArr) {
            C1283.m16844("nf_log_clv2", str, objArr);
        }
    };

    public C1373Cp(NetflixApplication netflixApplication) {
        if (netflixApplication == null) {
            throw new IllegalArgumentException("App can not be null!");
        }
        this.f5184 = netflixApplication;
    }

    @Override // o.C0441.Cif
    /* renamed from: ˎ  reason: contains not printable characters */
    public C0441.AbstractC0442 mo4525() {
        return this.f5186;
    }

    @Override // o.C0441.Cif
    /* renamed from: ॱ  reason: contains not printable characters */
    public C0441.If mo4528() {
        return this.f5185;
    }

    @Override // o.C0441.Cif
    /* renamed from: ˏ  reason: contains not printable characters */
    public long mo4526() {
        return System.currentTimeMillis();
    }

    @Override // o.C0441.Cif
    /* renamed from: ˋ  reason: contains not printable characters */
    public LoggingSource mo4523() {
        return LoggingSource.android;
    }

    @Override // o.C0441.Cif
    /* renamed from: ॱॱ  reason: contains not printable characters */
    public AllocationMode mo4530() {
        return AllocationMode.normal;
    }

    @Override // o.C0441.Cif
    /* renamed from: ᐝ  reason: contains not printable characters */
    public ComputationMode mo4531() {
        return ComputationMode.normal;
    }

    @Override // o.C0441.Cif
    /* renamed from: ʻ  reason: contains not printable characters */
    public InteractionMode mo4518() {
        if (this.f5184.m237().mo14205()) {
            return InteractionMode.direct;
        }
        return InteractionMode.indirect;
    }

    @Override // o.C0441.Cif
    /* renamed from: ʽ  reason: contains not printable characters */
    public String mo4520() {
        return "1.1.6-android";
    }

    @Override // o.C0441.Cif
    /* renamed from: ʼ  reason: contains not printable characters */
    public String mo4519() {
        return "2014.1";
    }

    @Override // o.C0441.Cif
    /* renamed from: ˋॱ  reason: contains not printable characters */
    public long mo4524() {
        return (long) TimeZone.getDefault().getOffset(new Date().getTime());
    }

    @Override // o.C0441.Cif
    /* renamed from: ˊ  reason: contains not printable characters */
    public String mo4521() {
        return AD.m3301(this.f5184);
    }

    @Override // o.C0441.Cif
    /* renamed from: ˊॱ  reason: contains not printable characters */
    public String mo4522() {
        return "Android";
    }

    @Override // o.C0441.Cif
    /* renamed from: ˏॱ  reason: contains not printable characters */
    public String mo4527() {
        return String.valueOf(Build.VERSION.SDK_INT);
    }

    @Override // o.C0441.Cif
    /* renamed from: ॱˊ  reason: contains not printable characters */
    public void mo4529() {
        this.f5184.m248();
    }
}
