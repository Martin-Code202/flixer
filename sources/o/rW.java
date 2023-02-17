package o;

import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import com.netflix.mediaclient.ui.feeds.TrailersFeedItemModel$clPlayableTrackingInfo$2;
import com.netflix.mediaclient.ui.feeds.TrailersFeedItemModel$playContext$2;
import com.netflix.mediaclient.ui.feeds.TrailersFeedItemModel$tagsTrackingInfo$2;
import com.netflix.model.leafs.TrailersFeedItemSummary;
import com.netflix.model.leafs.originals.ListOfTagSummary;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.PropertyReference1Impl;
import org.json.JSONObject;
public final class rW implements pH {

    /* renamed from: ˋ  reason: contains not printable characters */
    static final /* synthetic */ FQ[] f9708 = {C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(rW.class), "playContext", "getPlayContext()Lcom/netflix/mediaclient/ui/common/PlayContextImp;")), C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(rW.class), "clPlayableTrackingInfo", "getClPlayableTrackingInfo()Lcom/netflix/cl/model/TrackingInfo;")), C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(rW.class), "tagsTrackingInfo", "getTagsTrackingInfo()Lorg/json/JSONObject;"))};

    /* renamed from: ˏ  reason: contains not printable characters */
    public static final Cif f9709 = new Cif(null);

    /* renamed from: ʻ  reason: contains not printable characters */
    private final BehaviorSubject<Integer> f9710;

    /* renamed from: ʼ  reason: contains not printable characters */
    private final AbstractC1433Et f9711 = C1435Ev.m4972(new TrailersFeedItemModel$tagsTrackingInfo$2(this));

    /* renamed from: ʽ  reason: contains not printable characters */
    private final BehaviorSubject<Boolean> f9712;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private final int f9713;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private Integer f9714;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final AbstractC1433Et f9715 = C1435Ev.m4972(new TrailersFeedItemModel$clPlayableTrackingInfo$2(this));

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private final Set<ListOfTagSummary> f9716;

    /* renamed from: ͺ  reason: contains not printable characters */
    private final BehaviorSubject<Integer> f9717;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final AbstractC1433Et f9718 = C1435Ev.m4972(new TrailersFeedItemModel$playContext$2(this));

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private final PublishSubject<EA> f9719;

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private final TrailersFeedItemSummary f9720;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final BehaviorSubject<Boolean> f9721;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final BehaviorSubject<Boolean> f9722;

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private final pH f9723;

    @Override // o.pH
    /* renamed from: ʻ */
    public boolean mo4190() {
        return this.f9723.mo4190();
    }

    /* renamed from: ʻॱ  reason: contains not printable characters */
    public final JSONObject m10212() {
        AbstractC1433Et et = this.f9711;
        FQ fq = f9708[2];
        return (JSONObject) et.mo3220();
    }

    @Override // o.pH
    /* renamed from: ʼ */
    public ListOfTagSummary[] mo4191() {
        return this.f9723.mo4191();
    }

    @Override // o.pH
    /* renamed from: ʽ */
    public pF mo4192() {
        return this.f9723.mo4192();
    }

    @Override // o.pH
    /* renamed from: ˊ */
    public String mo4193() {
        return this.f9723.mo4193();
    }

    @Override // o.pH
    /* renamed from: ˊॱ */
    public boolean mo4194() {
        return this.f9723.mo4194();
    }

    @Override // o.pH
    /* renamed from: ˋ */
    public String mo4195() {
        return this.f9723.mo4195();
    }

    /* renamed from: ˋॱ  reason: contains not printable characters */
    public final AbstractC0574 m10219() {
        AbstractC1433Et et = this.f9715;
        FQ fq = f9708[1];
        return (AbstractC0574) et.mo3220();
    }

    @Override // o.pH
    /* renamed from: ˎ */
    public Date mo4196() {
        return this.f9723.mo4196();
    }

    @Override // o.pH
    /* renamed from: ˎ */
    public void mo4197(boolean z) {
        this.f9723.mo4197(z);
    }

    @Override // o.pH
    /* renamed from: ˏ */
    public CharSequence mo4198() {
        return this.f9723.mo4198();
    }

    /* renamed from: ˏॱ  reason: contains not printable characters */
    public final qN m10222() {
        AbstractC1433Et et = this.f9718;
        FQ fq = f9708[0];
        return (qN) et.mo3220();
    }

    @Override // o.pH
    /* renamed from: ͺ */
    public String mo4199() {
        return this.f9723.mo4199();
    }

    @Override // o.pH
    /* renamed from: ॱ */
    public CharSequence mo4200() {
        return this.f9723.mo4200();
    }

    @Override // o.pH
    /* renamed from: ॱˊ */
    public VideoType mo4201() {
        return this.f9723.mo4201();
    }

    @Override // o.pH
    /* renamed from: ॱॱ */
    public String mo4202() {
        return this.f9723.mo4202();
    }

    @Override // o.pH
    /* renamed from: ᐝ */
    public String mo4203() {
        return this.f9723.mo4203();
    }

    public rW(int i, TrailersFeedItemSummary trailersFeedItemSummary, pH pHVar) {
        C1457Fr.m5025(pHVar, "trailerFeedItem");
        this.f9713 = i;
        this.f9720 = trailersFeedItemSummary;
        this.f9723 = pHVar;
        BehaviorSubject<Boolean> createDefault = BehaviorSubject.createDefault(false);
        C1457Fr.m5016((Object) createDefault, "BehaviorSubject.createDefault(false)");
        this.f9712 = createDefault;
        BehaviorSubject<Boolean> createDefault2 = BehaviorSubject.createDefault(false);
        C1457Fr.m5016((Object) createDefault2, "BehaviorSubject.createDefault(false)");
        this.f9722 = createDefault2;
        BehaviorSubject<Boolean> createDefault3 = BehaviorSubject.createDefault(false);
        C1457Fr.m5016((Object) createDefault3, "BehaviorSubject.createDefault(false)");
        this.f9721 = createDefault3;
        BehaviorSubject<Integer> createDefault4 = BehaviorSubject.createDefault(-1);
        C1457Fr.m5016((Object) createDefault4, "BehaviorSubject.createDefault(NONE)");
        this.f9710 = createDefault4;
        BehaviorSubject<Integer> createDefault5 = BehaviorSubject.createDefault(0);
        C1457Fr.m5016((Object) createDefault5, "BehaviorSubject.createDefault(0)");
        this.f9717 = createDefault5;
        this.f9716 = new LinkedHashSet();
        this.f9719 = null;
    }

    /* renamed from: ʾ  reason: contains not printable characters */
    public final int m10214() {
        return this.f9713;
    }

    /* renamed from: o.rW$if  reason: invalid class name */
    public static final class Cif {
        private Cif() {
        }

        public /* synthetic */ Cif(C1456Fq fq) {
            this();
        }
    }

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    public final BehaviorSubject<Boolean> m10227() {
        return this.f9712;
    }

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    public final BehaviorSubject<Boolean> m10226() {
        return this.f9722;
    }

    /* renamed from: ॱˋ  reason: contains not printable characters */
    public final BehaviorSubject<Integer> m10224() {
        return this.f9710;
    }

    /* renamed from: ॱˎ  reason: contains not printable characters */
    public final BehaviorSubject<Integer> m10225() {
        return this.f9717;
    }

    /* renamed from: ʼॱ  reason: contains not printable characters */
    public final PublishSubject<EA> m10213() {
        return this.f9719;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public final void m10216(boolean z) {
        this.f9712.onNext(Boolean.valueOf(z));
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public final void m10218(boolean z) {
        this.f9722.onNext(Boolean.valueOf(z));
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public final void m10221(boolean z) {
        this.f9721.onNext(Boolean.valueOf(z));
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public final void m10220(int i) {
        this.f9717.onNext(Integer.valueOf(i));
    }

    /* renamed from: ʿ  reason: contains not printable characters */
    public final void m10215() {
        PublishSubject<EA> publishSubject = this.f9719;
        if (publishSubject != null) {
            publishSubject.onNext(EA.f5503);
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public final void m10217(int i) {
        boolean z = i == 31 || i == 30;
        Integer num = this.f9714;
        if (num == null || num.intValue() != 10 || !z) {
            this.f9710.onNext(Integer.valueOf(i));
            this.f9714 = Integer.valueOf(i);
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public final void m10223(int i) {
        ListOfTagSummary[] r6 = mo4191();
        if (r6 != null) {
            ListOfTagSummary listOfTagSummary = r6[i];
            String r9 = mo4199();
            if (!(r9 == null || this.f9720 == null)) {
                listOfTagSummary.setTrackingInfo(r9, this.f9720.getRequestId(), this.f9720.getTrackId(), i, 0);
            }
            Set<ListOfTagSummary> set = this.f9716;
            C1457Fr.m5016((Object) listOfTagSummary, "tag");
            set.add(listOfTagSummary);
        }
    }
}
