package o;

import android.view.KeyEvent;
public class AO {

    /* renamed from: ˊ  reason: contains not printable characters */
    private int f4288 = Integer.MIN_VALUE;

    /* renamed from: ˋ  reason: contains not printable characters */
    private long f4289 = 250;

    /* renamed from: ॱ  reason: contains not printable characters */
    private long f4290;

    /* renamed from: ˋ  reason: contains not printable characters */
    public boolean m3396(KeyEvent keyEvent) {
        long currentTimeMillis = System.currentTimeMillis();
        long j = (this.f4290 + this.f4289) - currentTimeMillis;
        if (this.f4288 == keyEvent.getKeyCode() && j > 0) {
            return true;
        }
        this.f4288 = keyEvent.getKeyCode();
        this.f4290 = currentTimeMillis;
        return false;
    }
}
