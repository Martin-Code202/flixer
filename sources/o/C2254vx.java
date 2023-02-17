package o;

import android.app.Notification;
import android.graphics.Bitmap;
import android.util.Pair;
/* renamed from: o.vx  reason: case insensitive filesystem */
public final class C2254vx implements AbstractC1778fk {

    /* renamed from: ˋ  reason: contains not printable characters */
    private AbstractC0346 f11371;

    /* renamed from: ॱ  reason: contains not printable characters */
    private AbstractC1778fk f11372;

    public C2254vx(AbstractC1778fk fkVar, AbstractC0346 r2) {
        this.f11371 = r2;
        this.f11372 = fkVar;
    }

    @Override // o.AbstractC1778fk
    /* renamed from: ॱ */
    public boolean mo6406() {
        return this.f11372.mo6406();
    }

    @Override // o.AbstractC1778fk
    /* renamed from: ॱ */
    public void mo6402(Notification notification, oS oSVar, boolean z) {
        if (this.f11371.mo13899()) {
            this.f11372.mo6402(notification, oSVar, z);
        }
    }

    @Override // o.AbstractC1778fk
    /* renamed from: ॱ */
    public void mo6404(oS oSVar) {
        if (this.f11371.mo13899()) {
            this.f11372.mo6404(oSVar);
        }
    }

    @Override // o.AbstractC1778fk
    /* renamed from: ˊ */
    public void mo6396(oS oSVar) {
        if (this.f11371.mo13899()) {
            this.f11372.mo6396(oSVar);
        }
    }

    @Override // o.AbstractC1778fk
    /* renamed from: ॱ */
    public Pair<Integer, Notification> mo6401(boolean z) {
        if (this.f11371.mo13899()) {
            return this.f11372.mo6401(z);
        }
        return new Pair<>(null, null);
    }

    @Override // o.AbstractC1778fk
    /* renamed from: ॱ */
    public void mo6405(boolean z, String str, String str2) {
        if (this.f11371.mo13899()) {
            this.f11372.mo6405(z, str, str2);
        }
    }

    @Override // o.AbstractC1778fk
    /* renamed from: ॱ */
    public void mo6403(Bitmap bitmap) {
        if (this.f11371.mo13899()) {
            this.f11372.mo6403(bitmap);
        }
    }

    @Override // o.AbstractC1778fk
    /* renamed from: ˎ */
    public void mo6398(Bitmap bitmap) {
        if (this.f11371.mo13899()) {
            this.f11372.mo6398(bitmap);
        }
    }

    @Override // o.AbstractC1778fk
    /* renamed from: ˏ */
    public void mo6400(boolean z, boolean z2, boolean z3, String str) {
        if (this.f11371.mo13899()) {
            this.f11372.mo6400(z, z2, z3, str);
        }
    }

    @Override // o.AbstractC1778fk
    /* renamed from: ˎ */
    public void mo6399(boolean z, boolean z2, boolean z3) {
        if (this.f11371.mo13899()) {
            this.f11372.mo6399(z, z2, z3);
        }
    }

    @Override // o.AbstractC1778fk
    /* renamed from: ˋ */
    public void mo6397() {
        if (this.f11371.mo13899()) {
            this.f11372.mo6397();
        }
    }
}
