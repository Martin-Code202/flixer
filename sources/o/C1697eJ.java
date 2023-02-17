package o;

import android.annotation.SuppressLint;
import com.netflix.mediaclient.service.mdx.MdxSharedState$1;
import com.netflix.mediaclient.servicemgr.IMdxSharedState;
import java.util.Map;
/* renamed from: o.eJ  reason: case insensitive filesystem */
public class C1697eJ implements IMdxSharedState {
    @SuppressLint({"UseSparseArrays"})

    /* renamed from: ˎ  reason: contains not printable characters */
    private static final Map<IMdxSharedState.MdxPlaybackState, String> f6476 = new MdxSharedState$1();

    /* renamed from: ˏ  reason: contains not printable characters */
    private static final String f6477 = C1697eJ.class.getSimpleName();

    /* renamed from: ʻ  reason: contains not printable characters */
    private long f6478;

    /* renamed from: ʽ  reason: contains not printable characters */
    private long f6479 = -1;

    /* renamed from: ˊ  reason: contains not printable characters */
    private String f6480;

    /* renamed from: ˋ  reason: contains not printable characters */
    private IMdxSharedState.MdxPlaybackState f6481 = IMdxSharedState.MdxPlaybackState.Stopped;

    /* renamed from: ॱ  reason: contains not printable characters */
    private boolean f6482;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private String f6483;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private int f6484 = -1;

    C1697eJ(String str) {
        this.f6480 = str;
    }

    @Override // com.netflix.mediaclient.servicemgr.IMdxSharedState
    /* renamed from: ˏ */
    public synchronized IMdxSharedState.MdxPlaybackState mo1522() {
        return this.f6481;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˎ  reason: contains not printable characters */
    public void m6091() {
        this.f6481 = IMdxSharedState.MdxPlaybackState.Loading;
        C1283.m16854(f6477, "state: " + f6476.get(this.f6481) + ", pos: " + this.f6479 + ", volume: " + this.f6484);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ॱ  reason: contains not printable characters */
    public void m6092() {
        this.f6482 = true;
        this.f6481 = IMdxSharedState.MdxPlaybackState.Playing;
        m6088();
        C1283.m16854(f6477, "state: " + f6476.get(this.f6481) + ", pos: " + this.f6479 + ", volume: " + this.f6484);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˋ  reason: contains not printable characters */
    public void m6089() {
        m6087();
        C1283.m16854(f6477, "state: " + f6476.get(this.f6481) + ", pos: " + this.f6479 + ", volume: " + this.f6484);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ॱ  reason: contains not printable characters */
    public void m6093(String str, int i, int i2) {
        this.f6479 = (long) i;
        this.f6478 = System.currentTimeMillis();
        this.f6484 = i2;
        if ("prepause".equals(str) || "preplay".equals(str) || "preseek".equals(str)) {
            this.f6481 = IMdxSharedState.MdxPlaybackState.Transitioning;
            m6088();
        } else if ("PROGRESS".equals(str)) {
            m6088();
            this.f6481 = IMdxSharedState.MdxPlaybackState.Transitioning;
        } else if ("PLAY".equals(str) || "PLAYING".equals(str)) {
            this.f6481 = IMdxSharedState.MdxPlaybackState.Playing;
            m6088();
        } else if ("PAUSE".equals(str)) {
            this.f6481 = IMdxSharedState.MdxPlaybackState.Paused;
        } else {
            this.f6481 = IMdxSharedState.MdxPlaybackState.Stopped;
        }
        C1283.m16854(f6477, "state: " + f6476.get(this.f6481) + ", pos: " + this.f6479 + ", volume: " + this.f6484);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˋ  reason: contains not printable characters */
    public void m6090(String str) {
        this.f6483 = str;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    private void m6087() {
        this.f6482 = false;
        this.f6481 = IMdxSharedState.MdxPlaybackState.Stopped;
        this.f6479 = -1;
        this.f6484 = -1;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m6088() {
        this.f6483 = null;
    }

    @Override // com.netflix.mediaclient.servicemgr.IMdxSharedState
    /* renamed from: ʽ */
    public String mo1521() {
        return this.f6483;
    }
}
