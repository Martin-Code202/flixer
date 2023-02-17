package com.netflix.mediaclient.ui.feeds;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import com.netflix.mediaclient.ui.feeds.TrailersFeedViewModel$Companion$EMPTY_TRACKABLE$2;
import com.netflix.model.leafs.TrailersFeedItemSummary;
import io.reactivex.Observable;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.PropertyReference1Impl;
import o.AbstractC1433Et;
import o.AbstractC2056pe;
import o.AbstractC2087qh;
import o.C0371;
import o.C0396;
import o.C0682;
import o.C1276;
import o.C1435Ev;
import o.C1456Fq;
import o.C1457Fr;
import o.C1461Fv;
import o.C2059ph;
import o.EI;
import o.FQ;
import o.oY;
import o.pH;
import o.rW;
public final class TrailersFeedViewModel extends AndroidViewModel {

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private static final String f3140 = f3140;

    /* renamed from: ˏ  reason: contains not printable characters */
    static final /* synthetic */ FQ[] f3141 = {C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(TrailersFeedViewModel.class), "deviceOrientationDetector", "getDeviceOrientationDetector()Lcom/netflix/mediaclient/common/ui/DeviceOrientationDetector;"))};

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private static final rW f3142;

    /* renamed from: ॱ  reason: contains not printable characters */
    public static final If f3143 = new If(null);

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private static final AbstractC1433Et f3144 = C1435Ev.m4972(TrailersFeedViewModel$Companion$EMPTY_TRACKABLE$2.f3156);

    /* renamed from: ʻ  reason: contains not printable characters */
    private final C0036 f3145 = new C0036();

    /* renamed from: ʼ  reason: contains not printable characters */
    private boolean f3146;

    /* renamed from: ʽ  reason: contains not printable characters */
    private final C0396<Boolean> f3147 = new C0396<>(Boolean.valueOf(C0682.m14922()));

    /* renamed from: ˊ  reason: contains not printable characters */
    private AbstractC2056pe f3148;

    /* renamed from: ˋ  reason: contains not printable characters */
    private oY f3149;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private TrailersFeedItemSummary f3150;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final AbstractC1433Et f3151 = C1435Ev.m4972(new TrailersFeedViewModel$deviceOrientationDetector$2(this));

    /* renamed from: ͺ  reason: contains not printable characters */
    private final Observable<Integer> f3152 = m1921().m14098();

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private MutableLiveData<rW> f3153 = new MutableLiveData<>();

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final C0396<Boolean> f3154 = new C0396<>(false);

    /* renamed from: ᐝ  reason: contains not printable characters */
    private MutableLiveData<rW> f3155 = new MutableLiveData<>();

    /* renamed from: ˈ  reason: contains not printable characters */
    private final C0371 m1921() {
        AbstractC1433Et et = this.f3151;
        FQ fq = f3141[0];
        return (C0371) et.mo3220();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TrailersFeedViewModel(Application application) {
        super(application);
        C1457Fr.m5025(application, "application");
    }

    public static final class If {

        /* renamed from: ˋ  reason: contains not printable characters */
        static final /* synthetic */ FQ[] f3157 = {C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(If.class), "EMPTY_TRACKABLE", "getEMPTY_TRACKABLE()Lcom/netflix/mediaclient/ui/feeds/TrailersFeedViewModel$Companion$EMPTY_TRACKABLE$2$1;"))};

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        /* renamed from: ˊ  reason: contains not printable characters */
        private final TrailersFeedViewModel$Companion$EMPTY_TRACKABLE$2.AnonymousClass5 m1958() {
            AbstractC1433Et et = TrailersFeedViewModel.f3144;
            FQ fq = f3157[0];
            return (TrailersFeedViewModel$Companion$EMPTY_TRACKABLE$2.AnonymousClass5) et.mo3220();
        }

        private If() {
        }

        public /* synthetic */ If(C1456Fq fq) {
            this();
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        public final rW m1960() {
            return TrailersFeedViewModel.f3142;
        }
    }

    static {
        pH pHVar = pH.f9369;
        C1457Fr.m5016((Object) pHVar, "TrailerFeedItem.EMPTY");
        f3142 = new rW(-1, null, pHVar);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public final oY m1941() {
        return this.f3149;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public final C0036 m1933() {
        return this.f3145;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public final C0396<Boolean> m1929() {
        return this.f3147;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public final C0396<Boolean> m1938() {
        return this.f3154;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public final MutableLiveData<rW> m1947() {
        return this.f3155;
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public final MutableLiveData<rW> m1926() {
        return this.f3153;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public final void m1935(TrailersFeedItemSummary trailersFeedItemSummary) {
        this.f3150 = trailersFeedItemSummary;
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public final TrailersFeedItemSummary m1951() {
        return this.f3150;
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    public final Observable<Integer> m1953() {
        return this.f3152;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public final AbstractC2087qh m1925() {
        TrailersFeedItemSummary trailersFeedItemSummary = this.f3150;
        if (trailersFeedItemSummary != null) {
            return trailersFeedItemSummary;
        }
        C1276.m16820().mo5727("trailersFeedItemSummary is null, unable to get a trackId ");
        return f3143.m1958();
    }

    /* renamed from: com.netflix.mediaclient.ui.feeds.TrailersFeedViewModel$ˊ  reason: contains not printable characters */
    public static final class C0036 extends LiveData<List<? extends rW>> {
        /* renamed from: ˏ  reason: contains not printable characters */
        public final void m1963(List<rW> list) {
            List<rW> list2;
            C1457Fr.m5025(list, "items");
            List list3 = (List) getValue();
            if (list3 instanceof List) {
                list2 = EI.m4826((Collection) list3, (Iterable) list);
            } else {
                list2 = list;
            }
            setValue(list2);
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        public final void m1964(rW rWVar) {
            C1457Fr.m5025(rWVar, "item");
            List list = (List) getValue();
            if (list instanceof List) {
                setValue(EI.m4823(list, rWVar));
            }
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        public final int m1962(rW rWVar) {
            List list = (List) getValue();
            if (list != null) {
                return EI.m4824(list, rWVar);
            }
            return -1;
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public final void m1936(List<rW> list) {
        C1457Fr.m5025(list, "items");
        this.f3145.m1963(list);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public final void m1943(rW rWVar) {
        C1457Fr.m5025(rWVar, "item");
        this.f3145.m1964(rWVar);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public final rW m1948(int i) {
        List list = (List) this.f3145.getValue();
        if (list instanceof List) {
            return (rW) list.get(i);
        }
        StringBuilder append = new StringBuilder().append("total = ");
        List list2 = (List) this.f3145.getValue();
        throw new IndexOutOfBoundsException(append.append(list2 != null ? Integer.valueOf(list2.size()) : null).append(", index = ").append(i).toString());
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public final int m1928() {
        List list = (List) this.f3145.getValue();
        if (list instanceof List) {
            return list.size();
        }
        return 0;
    }

    /* renamed from: ʾ  reason: contains not printable characters */
    private final int m1920() {
        int r2 = m1928();
        if (this.f3145.m1962(f3143.m1960()) != -1) {
            return r2 - 1;
        }
        return r2;
    }

    /* renamed from: ˊॱ  reason: contains not printable characters */
    public final int m1932() {
        return m1920();
    }

    /* renamed from: ˏॱ  reason: contains not printable characters */
    public final int m1945() {
        int r2 = (m1920() + 20) - 1;
        TrailersFeedItemSummary trailersFeedItemSummary = this.f3150;
        if (trailersFeedItemSummary != null) {
            return Math.min(r2, trailersFeedItemSummary.getLength() - 1);
        }
        return r2;
    }

    /* renamed from: ˋॱ  reason: contains not printable characters */
    public final boolean m1937() {
        TrailersFeedItemSummary trailersFeedItemSummary = this.f3150;
        return trailersFeedItemSummary == null || m1920() < trailersFeedItemSummary.getLength();
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public final boolean m1940(int i) {
        List list = (List) this.f3145.getValue();
        if (list instanceof List) {
            return this.f3145.m1962(f3143.m1960()) != -1 ? i == list.size() + -2 : i == list.size() + -1;
        }
        return false;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public final void m1934(int i) {
        if (this.f3145.m1962(this.f3155.getValue()) != i) {
            rW value = this.f3155.getValue();
            if (value != null) {
                value.m10216(false);
            }
            if (i != -1) {
                this.f3155.setValue(m1948(i));
                rW value2 = this.f3155.getValue();
                if (value2 != null) {
                    value2.m10216(true);
                }
            }
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public final void m1942(int i) {
        if (this.f3145.m1962(this.f3153.getValue()) != i) {
            rW value = this.f3153.getValue();
            if (value != null) {
                value.m10218(false);
            }
            if (i != -1) {
                this.f3153.setValue(m1948(i));
                rW value2 = this.f3153.getValue();
                if (value2 != null) {
                    value2.m10218(true);
                }
            }
        }
    }

    /* renamed from: ॱˊ  reason: contains not printable characters */
    public final void m1949() {
        m1921().enable();
    }

    /* renamed from: ͺ  reason: contains not printable characters */
    public final void m1946() {
        m1921().disable();
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public final void m1931(boolean z) {
        this.f3147.setValue(Boolean.valueOf(z));
    }

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    public final boolean m1954() {
        return this.f3147.getValue().booleanValue();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public final void m1944(boolean z) {
        this.f3154.setValue(Boolean.valueOf(z));
    }

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    public final boolean m1952() {
        return this.f3154.getValue().booleanValue();
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public final void m1939(C2059ph phVar) {
        C1457Fr.m5025(phVar, "serviceManager");
        AbstractC2056pe r1 = phVar.m9759();
        if (r1 != null) {
            this.f3148 = r1;
            this.f3149 = r1.mo7800();
        }
        m1930(41);
    }

    /* renamed from: ॱˎ  reason: contains not printable characters */
    public final void m1950() {
        AbstractC2056pe peVar;
        m1927(40);
        oY oYVar = this.f3149;
        if (oYVar != null && (peVar = this.f3148) != null) {
            peVar.mo7802(oYVar);
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static /* synthetic */ void m1922(TrailersFeedViewModel trailersFeedViewModel, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 31;
        }
        trailersFeedViewModel.m1930(i);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public final void m1930(int i) {
        if (!this.f3146) {
            this.f3146 = true;
            rW value = this.f3155.getValue();
            if (value != null) {
                value.m10217(i);
            }
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static /* synthetic */ void m1923(TrailersFeedViewModel trailersFeedViewModel, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 30;
        }
        trailersFeedViewModel.m1927(i);
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public final void m1927(int i) {
        if (this.f3146) {
            this.f3146 = false;
            rW value = this.f3155.getValue();
            if (value != null) {
                value.m10217(i);
            }
        }
    }
}
