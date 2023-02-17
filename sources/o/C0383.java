package o;

import android.content.Context;
import android.graphics.drawable.Drawable;
/* renamed from: o.ɺ  reason: contains not printable characters */
public class C0383 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private String f13332;

    /* renamed from: ˋ  reason: contains not printable characters */
    private Drawable f13333;

    /* renamed from: ˎ  reason: contains not printable characters */
    private boolean f13334 = true;

    /* renamed from: ˏ  reason: contains not printable characters */
    private int f13335;

    /* renamed from: ॱ  reason: contains not printable characters */
    private int f13336;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private boolean f13337 = false;

    public C0383(int i, String str, int i2) {
        this.f13336 = i;
        this.f13332 = str;
        this.f13335 = i2;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public int m14144() {
        return this.f13336;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public String m14147() {
        return this.f13332;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public boolean m14150() {
        return this.f13334;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m14145(boolean z) {
        this.f13334 = z;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public boolean m14146() {
        return this.f13337;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m14148(boolean z) {
        this.f13337 = z;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public Drawable m14149(Context context) {
        if (this.f13333 == null) {
            this.f13333 = context.getDrawable(this.f13335);
        }
        return this.f13333;
    }
}
