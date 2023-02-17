package o;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
public class hG {

    /* renamed from: ˊ  reason: contains not printable characters */
    private long f7114;

    /* renamed from: ˋ  reason: contains not printable characters */
    public final Map<String, hB> f7115 = new HashMap();

    /* renamed from: ˎ  reason: contains not printable characters */
    private long f7116;

    /* renamed from: ˏ  reason: contains not printable characters */
    private int f7117 = 0;

    /* renamed from: ॱ  reason: contains not printable characters */
    private long f7118 = -1;

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m6921() {
        this.f7116 = 0;
        this.f7114 = 0;
        for (Map.Entry<String, hB> entry : this.f7115.entrySet()) {
            hB value = entry.getValue();
            if (value.f7060 > 0) {
                this.f7116 += value.f7061;
                this.f7114 += value.f7060;
            } else {
                C1283.m16850("nf_playableProgress", "mTotalBytesToDownload " + value.f7060 + " is not positive for " + entry.getKey());
            }
        }
        if (this.f7114 > 0) {
            this.f7117 = (int) ((this.f7116 * 100) / this.f7114);
        } else {
            this.f7117 = 0;
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m6922() {
        this.f7117 = 100;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public long m6925(File file) {
        if (this.f7118 == -1) {
            this.f7118 = AH.m3346(file);
        }
        return this.f7118;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public long m6924() {
        return this.f7116;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public long m6923() {
        return this.f7114;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public int m6920() {
        return this.f7117;
    }
}
