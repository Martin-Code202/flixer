package o;

import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.servicemgr.NetflixDataRequest;
import com.netflix.mediaclient.servicemgr.PlayLocationType;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import java.util.ArrayList;
import java.util.List;
import o.AB;
/* renamed from: o.ᒋ  reason: contains not printable characters */
public class C0771 extends AbstractRunnableC0373 {

    /* renamed from: ʼ  reason: contains not printable characters */
    private final PlayLocationType f14406;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final VideoType f14407;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final String f14408;

    @Override // o.AbstractRunnableC0373
    /* renamed from: ˏ */
    public /* bridge */ /* synthetic */ void mo14123(NetflixDataRequest netflixDataRequest) {
        super.mo14123(netflixDataRequest);
    }

    public C0771(C0876<?> r1, String str, VideoType videoType, PlayLocationType playLocationType, AbstractC1203 r5) {
        super(r1, r5);
        this.f14408 = str;
        this.f14407 = videoType;
        this.f14406 = playLocationType;
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x001d: APUT  (r0v1 java.lang.Object[]), (2 ??[int, float, short, byte, char]), (r1v4 java.lang.String) */
    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ॱ */
    public void mo14127(List<C0859> list) {
        Object[] objArr = new Object[3];
        objArr[0] = this.f14407.getValue();
        objArr[1] = this.f14408;
        objArr[2] = this.f14407 == VideoType.EPISODE ? "detail" : "summary";
        list.add(C0859.m15528(objArr));
        C0859 r4 = C0859.m15528(this.f14407.getValue(), this.f14408, "postPlayExperience");
        list.add(r4.m15542("experienceData"));
        list.add(r4.m15535(C0859.m15528("playbackVideos", C0859.m15532(0, 4), C0859.m15532(0, 4), C0859.m15523("detail", "summary"))));
        this.f13290.m15254(C0859.m15528(this.f14407.getValue(), this.f14408, "postPlayExperience"));
        this.f13290.m15254(C0859.m15528("postPlayExperiences", this.f14408, "experienceData"));
        this.f13290.m15254(C0859.m15528("postPlayExperiences", this.f14408, "playbackVideos"));
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ˎ */
    public List<AB.If> mo14120() {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(new AB.If("ppNewContext", this.f14406.equals(PlayLocationType.POST_PLAY) ? "false" : "true"));
        return arrayList;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ˊ */
    public void mo14114(AbstractC1203 r6, C0856 r7) {
        r6.mo6199((pO) this.f13290.m15584(C0859.m15528(this.f14407.getValue(), this.f14408, "summary")), AbstractC0367.f13235);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractRunnableC0373
    /* renamed from: ॱ */
    public void mo14128(AbstractC1203 r2, Status status) {
        r2.mo6199((pO) null, status);
    }
}
