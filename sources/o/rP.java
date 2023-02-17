package o;

import android.content.Context;
import android.net.Uri;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.StatusCode;
import o.C0505;
public class rP implements AbstractC1268 {

    /* renamed from: ʻ  reason: contains not printable characters */
    private C1278 f9653;

    /* renamed from: ʼ  reason: contains not printable characters */
    private Runnable f9654;

    /* renamed from: ʽ  reason: contains not printable characters */
    private String f9655;

    /* renamed from: ˊ  reason: contains not printable characters */
    private StatusCode f9656;

    /* renamed from: ˋ  reason: contains not printable characters */
    private int f9657;

    /* renamed from: ˎ  reason: contains not printable characters */
    private Runnable f9658;

    /* renamed from: ˏ  reason: contains not printable characters */
    private int f9659;

    /* renamed from: ॱ  reason: contains not printable characters */
    private Throwable f9660;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private Context f9661;

    public rP(Context context, StatusCode statusCode, Runnable runnable, int i) {
        this(context, statusCode, null, Integer.MAX_VALUE, null, i, null, runnable);
    }

    public rP(Context context, StatusCode statusCode, Throwable th, int i, Runnable runnable, int i2, String str, Runnable runnable2) {
        this.f9657 = Integer.MAX_VALUE;
        this.f9661 = context;
        this.f9656 = statusCode;
        this.f9660 = th;
        this.f9657 = i;
        this.f9658 = runnable;
        this.f9659 = i2;
        this.f9655 = str;
        this.f9654 = runnable2;
        m10153();
    }

    @Override // o.AbstractC1268
    /* renamed from: ˏ */
    public int mo10136() {
        return this.f9657;
    }

    @Override // o.AbstractC1268
    /* renamed from: ॱ */
    public Runnable mo10137() {
        return this.f9658;
    }

    @Override // o.AbstractC1268
    /* renamed from: ˎ */
    public C1278 mo10135() {
        return this.f9653;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m10153() {
        if (this.f9656 == null) {
            C1283.m16850("ErrorAgent", "Required to display error dialog without status code!");
        }
        String r7 = m10154(this.f9659, this.f9656);
        Uri r8 = m10152(this.f9655);
        Runnable runnable = this.f9654;
        if (runnable == null) {
            runnable = new Runnable() { // from class: o.rP.2
                @Override // java.lang.Runnable
                public void run() {
                    C1317As.m3756(rP.this.f9661);
                }
            };
        }
        if (r8 != null) {
            this.f9653 = new C0505.If("", r7, null, runnable, this.f9661.getString(R.string.label_dialogButtonMore), new AQ(this.f9661, r8));
            return;
        }
        this.f9653 = new C1278("", r7, null, runnable);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private String m10154(int i, StatusCode statusCode) {
        String str;
        if (i == Integer.MAX_VALUE) {
            return this.f9661.getString(R.string.label_error_default);
        }
        if (statusCode != null) {
            str = this.f9661.getString(i, Integer.valueOf(statusCode.m271()));
        } else {
            str = this.f9661.getString(i);
        }
        if (str == null) {
            return this.f9661.getString(R.string.label_error_default);
        }
        return str;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private Uri m10152(String str) {
        if (C1349Bv.m4113(str)) {
            return null;
        }
        return Uri.parse(str);
    }
}
