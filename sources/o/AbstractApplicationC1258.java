package o;

import android.app.Application;
import android.content.Context;
/* renamed from: o.ｺ  reason: contains not printable characters */
public abstract class AbstractApplicationC1258 extends Application {

    /* renamed from: ˊ  reason: contains not printable characters */
    protected static AbstractApplicationC1258 f15841;

    /* renamed from: ˏ  reason: contains not printable characters */
    protected static boolean f15842;

    /* renamed from: ʻ */
    public abstract void mo232();

    /* renamed from: ʼ */
    public abstract AbstractC0457 mo234();

    /* renamed from: ʽ */
    public abstract boolean mo236();

    /* renamed from: ˊ */
    public abstract void mo240();

    /* renamed from: ˋ */
    public abstract void mo245();

    /* renamed from: ˋ */
    public abstract void mo246(Context context);

    /* renamed from: ॱ */
    public abstract void mo252(Context context, String str);

    /* renamed from: ॱॱ */
    public abstract long mo256();

    /* renamed from: ᐝ */
    public abstract AbstractC2228v mo258();

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        f15841 = this;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static Context m16692() {
        return f15841;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static Application m16691() {
        return f15841;
    }

    public static AbstractApplicationC1258 getInstance() {
        return f15841;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static boolean m16693() {
        return f15842;
    }
}
