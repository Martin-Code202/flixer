package o;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.netflix.mediaclient.service.logging.client.model.SessionEndedEvent;
import java.util.HashMap;
import java.util.Map;
/* renamed from: o.eF  reason: case insensitive filesystem */
public final class C1693eF implements AbstractC1700eM {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final Context f6460;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final Map<String, C1697eJ> f6461 = new HashMap();

    C1693eF(Context context) {
        this.f6460 = context;
        C1283.m16846("nf_mdx", "Creating client notifier");
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m6052(String str) {
        if (!this.f6461.containsKey(str)) {
            this.f6461.put(str, new C1697eJ(str));
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m6059(String str) {
        synchronized (this.f6461) {
            m6052(str);
            this.f6461.get(str).m6091();
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public C1697eJ m6067(String str) {
        C1697eJ eJVar;
        synchronized (this.f6461) {
            eJVar = this.f6461.get(str);
        }
        return eJVar;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m6053() {
        this.f6461.clear();
        this.f6460.sendBroadcast(new Intent("com.netflix.mediaclient.intent.action.MDX_ACTION_UPDATE_NOTREADY").addCategory("com.netflix.mediaclient.intent.category.MDX"));
        C1283.m16846("nf_mdx", "Intent NOTREADY sent");
    }

    @Override // o.AbstractC1700eM
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo6062() {
        this.f6460.sendBroadcast(new Intent("com.netflix.mediaclient.intent.action.MDX_ACTION_UPDATE_TARGETLIST").addCategory("com.netflix.mediaclient.intent.category.MDX"));
        C1283.m16846("nf_mdx", "Intent MDXUPDATE_TARGETLISTY sent");
    }

    @Override // o.AbstractC1700eM
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo6064(String str, String str2) {
        this.f6460.sendBroadcast(new Intent("com.netflix.mediaclient.intent.action.MDX_ACTION_UPDATE_CAPABILITY").addCategory("com.netflix.mediaclient.intent.category.MDX").putExtra("uuid", str).putExtra("stringBlob", str2));
        C1283.m16846("nf_mdx", "Intent MDX_ACTION_UPDATE_CAPABILITY sent");
    }

    @Override // o.AbstractC1700eM
    /* renamed from: ॱ  reason: contains not printable characters */
    public void mo6068(String str, String str2) {
        this.f6460.sendBroadcast(new Intent("com.netflix.mediaclient.intent.action.MDX_ACTION_UPDATE_METADATA").addCategory("com.netflix.mediaclient.intent.category.MDX").putExtra("uuid", str).putExtra("stringBlob", str2));
        C1283.m16846("nf_mdx", "Intent MDX_ACTION_UPDATE_METADATA sent");
    }

    @Override // o.AbstractC1700eM
    /* renamed from: ˊ  reason: contains not printable characters */
    public void mo6054(String str, String str2) {
        this.f6460.sendBroadcast(new Intent("com.netflix.mediaclient.intent.action.MDX_ACTION_UPDATE_AUDIOSUB").addCategory("com.netflix.mediaclient.intent.category.MDX").putExtra("uuid", str).putExtra("stringBlob", str2));
        C1283.m16846("nf_mdx", "Intent MDX_ACTION_UPDATE_AUDIOSUB sent");
    }

    @Override // o.AbstractC1700eM
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo6058(String str, String str2) {
        this.f6460.sendBroadcast(new Intent("com.netflix.mediaclient.intent.action.MDX_ACTION_UPDATE_DIALOGSHOW").addCategory("com.netflix.mediaclient.intent.category.MDX").putExtra("uuid", str).putExtra("stringBlob", str2));
        C1283.m16846("nf_mdx", "Intent MDX_ACTION_UPDATE_DIALOGSHOW sent");
    }

    @Override // o.AbstractC1700eM
    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo6060(String str, String str2) {
        this.f6460.sendBroadcast(new Intent("com.netflix.mediaclient.intent.action.MDX_ACTION_UPDATE_DIALOGCANCEL").addCategory("com.netflix.mediaclient.intent.category.MDX").putExtra("uuid", str).putExtra("stringBlob", str2));
        C1283.m16846("nf_mdx", "Intent MDX_ACTION_UPDATE_DIALOGCANCEL sent");
    }

    @Override // o.AbstractC1700eM
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo6057(String str, int i, String str2) {
        this.f6460.sendBroadcast(new Intent("com.netflix.mediaclient.intent.action.MDX_ACTION_UPDATE_ERROR").addCategory("com.netflix.mediaclient.intent.category.MDX").putExtra("uuid", str).putExtra("errorCode", i).putExtra("errorDesc", str2));
        C1283.m16848("nf_mdx", "Intent MDX_ACTION_UPDATE_ERROR sent %d %s", Integer.valueOf(i), str2);
    }

    @Override // o.AbstractC1700eM
    /* renamed from: ॱ  reason: contains not printable characters */
    public void mo6070(String str, String str2, boolean z) {
        synchronized (this.f6461) {
            if (null != this.f6461.get(str)) {
                this.f6461.get(str).m6089();
            }
        }
        Intent putExtra = new Intent("com.netflix.mediaclient.intent.action.MDX_ACTION_UPDATE_PLAYBACKEND").addCategory("com.netflix.mediaclient.intent.category.MDX").putExtra("uuid", str).putExtra("updateCW", !z);
        if (!TextUtils.isEmpty(str2)) {
            putExtra.putExtra("postplayState", str2);
        }
        this.f6460.sendBroadcast(putExtra);
        C1283.m16846("nf_mdx", "Intent MDX_ACTION_UPDATE_PLAYBACKEND sent");
    }

    @Override // o.AbstractC1700eM
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo6056(String str) {
        synchronized (this.f6461) {
            m6052(str);
            this.f6461.get(str).m6092();
        }
        this.f6460.sendBroadcast(new Intent("com.netflix.mediaclient.intent.action.MDX_ACTION_UPDATE_PLAYBACKSTART").addCategory("com.netflix.mediaclient.intent.category.MDX").putExtra("uuid", str));
        C1283.m16846("nf_mdx", "Intent MDX_ACTION_UPDATE_PLAYBACKSTART sent");
    }

    @Override // o.AbstractC1700eM
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo6065(String str, String str2, String str3, int i) {
        this.f6460.sendBroadcast(new Intent("com.netflix.mediaclient.intent.action.MDXUPDATE_MOVIEMETADA").addCategory("com.netflix.mediaclient.intent.category.MDX").putExtra("uuid", str).putExtra("catalogId", str2).putExtra("episodeId", str3).putExtra(SessionEndedEvent.DURATION, i));
        C1283.m16846("nf_mdx", "Intent MDXUPDATE_MOVIEDATA sent");
    }

    @Override // o.AbstractC1700eM
    /* renamed from: ॱ  reason: contains not printable characters */
    public void mo6069(String str, String str2, int i, int i2, boolean z, String str3) {
        synchronized (this.f6461) {
            if (null != this.f6461.get(str)) {
                this.f6461.get(str).m6093(str2, i, i2);
            }
        }
        this.f6460.sendBroadcast(new Intent("com.netflix.mediaclient.intent.action.MDX_ACTION_UPDATE_STATE").addCategory("com.netflix.mediaclient.intent.category.MDX").putExtra("uuid", str).putExtra("currentState", str2).putExtra("time", i).putExtra("volume", i2).putExtra("isInSkipIntroWindow", z).putExtra("skipIntroText", str3));
        C1283.m16846("nf_mdx", "Intent MDX_ACTION_UPDATE_STATE sent");
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m6063(String str) {
        this.f6460.sendBroadcast(new Intent("com.netflix.mediaclient.intent.action.MDX_ACTION_UPDATE_MOVIEMETADATA_AVAILABLE").addCategory("com.netflix.mediaclient.intent.category.MDX").putExtra("uuid", str));
        C1283.m16846("nf_mdx", "Intent MOVIEMETADATA_AVAILABLE sent");
    }

    @Override // o.AbstractC1700eM
    /* renamed from: ˊ  reason: contains not printable characters */
    public void mo6055(String str, boolean z, boolean z2, boolean z3, String str2, String str3) {
        this.f6460.sendBroadcast(new Intent("com.netflix.mediaclient.intent.action.MDX_ACTION_UPDATE_SIMPLE_PLAYBACKSTATE").addCategory("com.netflix.mediaclient.intent.category.MDX").putExtra("uuid", str).putExtra("paused", z).putExtra("transitioning", z2).putExtra("isInSkipIntroWindow", z3).putExtra("skipIntroText", str2).putExtra("postplayState", str3));
    }

    @Override // o.AbstractC1700eM
    /* renamed from: ᐝ  reason: contains not printable characters */
    public void mo6072(String str, String str2) {
        if (null != this.f6461.get(str)) {
            this.f6461.get(str).m6090(str2);
        }
        this.f6460.sendOrderedBroadcast(new Intent("com.netflix.mediaclient.intent.action.MDX_ACTION_UPDATE_POSTPLAY").addCategory("com.netflix.mediaclient.intent.category.MDX").putExtra("uuid", str).putExtra("postplayState", str2), null);
    }

    @Override // o.AbstractC1700eM
    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo6061(String str, String str2, int i, int i2, String str3) {
        this.f6460.sendBroadcast(new Intent("com.netflix.mediaclient.intent.action.PIN_VERIFICATION_SHOW").addCategory("com.netflix.mediaclient.intent.category.MDX").putExtra("uuid", str).putExtra("title", str2).putExtra("ancestorVideoType", str3).putExtra("videoId", i).putExtra("ancestorVideoId", i2));
    }

    @Override // o.AbstractC1700eM
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo6066(String str, boolean z) {
        this.f6460.sendBroadcast(new Intent("com.netflix.mediaclient.intent.action.MDX_ACTION_PIN_VERIFICATION_NOT_REQUIRED").addCategory("com.netflix.mediaclient.intent.category.MDX").putExtra("uuid", str).putExtra("isPinVerified", z));
    }

    @Override // o.AbstractC1700eM
    /* renamed from: ॱ  reason: contains not printable characters */
    public void mo6071(boolean z) {
        this.f6460.sendBroadcast(new Intent("com.netflix.mediaclient.intent.action.MDX_ACTION__NETWORK_CONNECTIVITY_CHANGE").addCategory("com.netflix.mediaclient.intent.category.MDX").putExtra("networkConnected", z));
    }
}
