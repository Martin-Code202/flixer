package o;

import android.content.Intent;
import android.os.Parcelable;
import com.netflix.cl.model.AppView;
import o.tH;
public abstract class tB extends tH.AbstractC0211 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final Intent f10318;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final Parcelable f10319;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final String f10320;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final AppView f10321;

    protected tB(String str, Intent intent, AppView appView, Parcelable parcelable) {
        if (str == null) {
            throw new NullPointerException("Null hostClassName");
        }
        this.f10320 = str;
        if (intent == null) {
            throw new NullPointerException("Null intent");
        }
        this.f10318 = intent;
        if (appView == null) {
            throw new NullPointerException("Null appView");
        }
        this.f10321 = appView;
        this.f10319 = parcelable;
    }

    @Override // o.tH.AbstractC0211
    /* renamed from: ˎ  reason: contains not printable characters */
    public String mo10887() {
        return this.f10320;
    }

    @Override // o.tH.AbstractC0211
    /* renamed from: ˊ  reason: contains not printable characters */
    public Intent mo10885() {
        return this.f10318;
    }

    @Override // o.tH.AbstractC0211
    /* renamed from: ॱ  reason: contains not printable characters */
    public AppView mo10888() {
        return this.f10321;
    }

    @Override // o.tH.AbstractC0211
    /* renamed from: ˋ  reason: contains not printable characters */
    public Parcelable mo10886() {
        return this.f10319;
    }

    @Override // java.lang.Object
    public String toString() {
        return "BackStackEntry{hostClassName=" + this.f10320 + ", intent=" + this.f10318 + ", appView=" + this.f10321 + ", layoutManagerState=" + this.f10319 + "}";
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof tH.AbstractC0211)) {
            return false;
        }
        tH.AbstractC0211 r2 = (tH.AbstractC0211) obj;
        return this.f10320.equals(r2.mo10887()) && this.f10318.equals(r2.mo10885()) && this.f10321.equals(r2.mo10888()) && (this.f10319 != null ? this.f10319.equals(r2.mo10886()) : r2.mo10886() == null);
    }

    @Override // java.lang.Object
    public int hashCode() {
        return ((((((1000003 ^ this.f10320.hashCode()) * 1000003) ^ this.f10318.hashCode()) * 1000003) ^ this.f10321.hashCode()) * 1000003) ^ (this.f10319 == null ? 0 : this.f10319.hashCode());
    }
}
