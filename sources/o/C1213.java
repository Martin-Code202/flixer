package o;

import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.servicemgr.NetflixDataRequest;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import java.util.ArrayList;
import java.util.List;
import o.AB;
/* renamed from: o.ﻤ  reason: contains not printable characters */
public class C1213 extends AbstractRunnableC0373 {

    /* renamed from: ʼ  reason: contains not printable characters */
    private final int f15738;

    /* renamed from: ʽ  reason: contains not printable characters */
    private final int f15739;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final String f15740;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final VideoType f15741;

    @Override // o.AbstractRunnableC0373
    /* renamed from: ˏ */
    public /* bridge */ /* synthetic */ void mo14123(NetflixDataRequest netflixDataRequest) {
        super.mo14123(netflixDataRequest);
    }

    public C1213(C0876<?> r1, String str, VideoType videoType, int i, int i2, AbstractC1203 r6) {
        super(r1, r6);
        this.f15740 = str;
        this.f15741 = videoType;
        this.f15739 = i;
        this.f15738 = i2;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ॱ */
    public void mo14127(List<C0859> list) {
        list.add(C0859.m15528(this.f15741.getValue(), this.f15740, "setThumbRating"));
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ˊ */
    public boolean mo14115() {
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ˎ */
    public List<AB.If> mo14120() {
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(new AB.If("param", String.valueOf(this.f15739)));
        arrayList.add(new AB.If("param", String.valueOf(this.f15738)));
        return arrayList;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ˊ */
    public void mo14114(AbstractC1203 r6, C0856 r7) {
        pE pEVar = (pE) this.f13290.m15584(C0859.m15528(this.f15741.getValue(), this.f15740, "summary"));
        r6.mo8540(pEVar, AbstractC0367.f13235);
        m16499(pEVar);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m16499(pE pEVar) {
        if (pEVar == null) {
            C1283.m16854("CmpTask", "null user rating - can't notify listeners");
            return;
        }
        LocalBroadcastManager.getInstance(m14132()).sendBroadcast(new Intent("com.netflix.falkor.ACTION_NOTIFY_OF_RATINGS_CHANGE").putExtra(NetflixActivity.EXTRA_VIDEO_ID, this.f15740).putExtra("extra_user_thumb_rating", pEVar.getUserThumbRating()));
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ॱ */
    public void mo14128(AbstractC1203 r2, Status status) {
        r2.mo8540((pE) null, status);
    }
}
