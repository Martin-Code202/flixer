package o;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.media.AudioManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.netflix.cl.Logger;
import com.netflix.cl.model.AppView;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.service.logging.client.model.DeepErrorElement;
import com.netflix.mediaclient.service.logging.client.model.ExceptionClEvent;
import com.netflix.mediaclient.ui.feeds.TrailersFeedFragment$onCreateView$controller$1;
import com.netflix.mediaclient.ui.feeds.TrailersFeedFragment$trailersFeedViewModel$2;
import com.netflix.mediaclient.ui.feeds.TrailersFeedViewController;
import com.netflix.mediaclient.ui.feeds.TrailersFeedViewModel;
import com.netflix.model.leafs.TrailersFeedItemSummary;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.jvm.internal.PropertyReference1Impl;
import org.json.JSONObject;
public final class rR extends AbstractC0517 {

    /* renamed from: ˏ  reason: contains not printable characters */
    static final /* synthetic */ FQ[] f9663 = {C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(rR.class), "trailersFeedViewModel", "getTrailersFeedViewModel()Lcom/netflix/mediaclient/ui/feeds/TrailersFeedViewModel;"))};

    /* renamed from: ᐝ  reason: contains not printable characters */
    public static final Cif f9664 = new Cif(null);

    /* renamed from: ʻ  reason: contains not printable characters */
    private final AbstractC1433Et f9665 = C1435Ev.m4972(new TrailersFeedFragment$trailersFeedViewModel$2(this));

    /* renamed from: ʼ  reason: contains not printable characters */
    private C1224 f9666;

    /* renamed from: ʽ  reason: contains not printable characters */
    private TrailersFeedViewController f9667;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private boolean f9668;

    /* renamed from: ͺ  reason: contains not printable characters */
    private HashMap f9669;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private Integer f9670;

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˏॱ  reason: contains not printable characters */
    private final TrailersFeedViewModel m10166() {
        AbstractC1433Et et = this.f9665;
        FQ fq = f9663[0];
        return (TrailersFeedViewModel) et.mo3220();
    }

    @Override // android.support.v4.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        m10170();
    }

    /* renamed from: ॱˊ  reason: contains not printable characters */
    public void m10170() {
        if (this.f9669 != null) {
            this.f9669.clear();
        }
    }

    /* renamed from: o.rR$if  reason: invalid class name */
    public static final class Cif {
        private Cif() {
        }

        public /* synthetic */ Cif(C1456Fq fq) {
            this();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: ˊॱ  reason: contains not printable characters */
    public final void m10159() {
        TrailersFeedViewController trailersFeedViewController;
        if (!this.f9668 && m10166().m1937()) {
            this.f9668 = true;
            boolean z = m10166().m1928() == 0;
            if (z && (trailersFeedViewController = this.f9667) != null) {
                trailersFeedViewController.m1885();
            }
            m14534().runWhenManagerIsReady(new If(this, z));
        }
    }

    public static final class If extends NetflixActivity.If {

        /* renamed from: ˊ  reason: contains not printable characters */
        final /* synthetic */ rR f9671;

        /* renamed from: ˋ  reason: contains not printable characters */
        final /* synthetic */ boolean f9672;

        If(rR rRVar, boolean z) {
            this.f9671 = rRVar;
            this.f9672 = z;
        }

        public static final class iF extends oP {

            /* renamed from: ˎ  reason: contains not printable characters */
            final /* synthetic */ If f9673;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            iF(If r1, String str) {
                super(str);
                this.f9673 = r1;
            }

            @Override // o.oP, o.oU
            public void onTrailersFetched(TrailersFeedItemSummary trailersFeedItemSummary, List<pH> list, Status status) {
                TrailersFeedViewController trailersFeedViewController;
                super.onTrailersFetched(trailersFeedItemSummary, list, status);
                this.f9673.f9671.f9668 = false;
                if (status == null || status.mo301() || trailersFeedItemSummary == null || list == null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("callback", "onTrailersFetched");
                    if (status != null) {
                        jSONObject.put(DeepErrorElement.Debug.MESSAGE, status.mo307());
                        jSONObject.put("statusCode", status.mo302());
                        jSONObject.put(ExceptionClEvent.CATEGORY_VALUE, status.mo301());
                    }
                    if (trailersFeedItemSummary != null) {
                        jSONObject.put("summary.trackId", trailersFeedItemSummary.getTrackId());
                        jSONObject.put("summary.id", trailersFeedItemSummary.getId());
                        jSONObject.put("summary.length", trailersFeedItemSummary.getLength());
                    }
                    if (list != null) {
                        jSONObject.put("result.size", list.size());
                    }
                    jSONObject.put("ui.size", this.f9673.f9671.m10166().m1928());
                    Logger.INSTANCE.m131(new C0729(jSONObject));
                    if (this.f9673.f9671.m10166().m1928() == 0 && (trailersFeedViewController = this.f9673.f9671.f9667) != null) {
                        trailersFeedViewController.m1881();
                    }
                    if (this.f9673.f9672) {
                        rR.m10163(this.f9673.f9671, 0, 1, null);
                        return;
                    }
                    return;
                }
                this.f9673.f9671.m10166().m1935(trailersFeedItemSummary);
                if (this.f9673.f9672) {
                    this.f9673.f9671.m10162(trailersFeedItemSummary.getTrackId());
                }
                this.f9673.f9671.m10166().m1943(TrailersFeedViewModel.f3143.m1960());
                ArrayList arrayList = new ArrayList(list.size());
                int r5 = this.f9673.f9671.m10166().m1928();
                for (pH pHVar : list) {
                    if (r5 == trailersFeedItemSummary.getLength()) {
                        break;
                    }
                    arrayList.add(new rW(r5, trailersFeedItemSummary, pHVar));
                    r5++;
                }
                boolean z = false;
                if (arrayList.size() > 0) {
                    if (this.f9673.f9672) {
                        C1283.m16854("TrailersFeedFragment", "Initial page loaded with " + arrayList.size());
                        z = true;
                    } else {
                        C1283.m16854("TrailersFeedFragment", "Additional page loaded with " + arrayList.size());
                    }
                }
                TrailersFeedViewController trailersFeedViewController2 = this.f9673.f9671.f9667;
                if (trailersFeedViewController2 != null) {
                    trailersFeedViewController2.m1883(status);
                }
                this.f9673.f9671.m10166().m1936(arrayList);
                if (this.f9673.f9671.m10166().m1937()) {
                    arrayList.add(TrailersFeedViewModel.f3143.m1960());
                }
                if (z) {
                    this.f9673.f9671.m10166().m1934(0);
                    this.f9673.f9671.m10166().m1942(0);
                }
            }
        }

        @Override // com.netflix.mediaclient.android.activity.NetflixActivity.If
        public void run(C2059ph phVar) {
            C1457Fr.m5025(phVar, "manager");
            oF r0 = phVar.m9764();
            TrailersFeedItemSummary r2 = this.f9671.m10166().m1951();
            r0.mo9487(new C0857(r2 != null ? r2.getId() : null, this.f9671.m10166().m1932(), this.f9671.m10166().m1945()), new iF(this, "TrailersFeedFragment"));
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        Integer num = this.f9670;
        if (num != null) {
            m10162(num.intValue());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        C1224 r0 = this.f9666;
        if (r0 != null) {
            m10158(r0);
        }
        super.onPause();
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    static /* bridge */ /* synthetic */ void m10163(rR rRVar, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = -1;
        }
        rRVar.m10162(i);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˎ  reason: contains not printable characters */
    private final void m10162(int i) {
        if (isResumed()) {
            C1224 r3 = this.f9666;
            if (r3 != null) {
                m10158(r3);
            }
            C1283.m16854("TrailersFeedFragment", "Opening session AppView.previews with " + i);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("trackId", i);
            C1224 r4 = new C1224(new C2108iF(jSONObject), AppView.previews);
            Logger.INSTANCE.m142(r4);
            this.f9666 = r4;
        }
        this.f9670 = Integer.valueOf(i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.rR$iF  reason: case insensitive filesystem */
    public static final class C2108iF implements AbstractC0574 {

        /* renamed from: ˎ  reason: contains not printable characters */
        final /* synthetic */ JSONObject f9674;

        C2108iF(JSONObject jSONObject) {
            this.f9674 = jSONObject;
        }

        @Override // o.AbstractC0503
        public final JSONObject toJSONObject() {
            return this.f9674;
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private final void m10158(C1224 r4) {
        C1283.m16854("TrailersFeedFragment", "Closing session AppView.previews");
        Logger.INSTANCE.m140(Long.valueOf(r4.m14625()));
        this.f9666 = null;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        C1457Fr.m5025(layoutInflater, "inflater");
        FragmentActivity activity = getActivity();
        if (activity == null) {
            throw new TypeCastException("null cannot be cast to non-null type com.netflix.mediaclient.ui.feeds.TrailersFeedActivity");
        }
        rU rUVar = (rU) activity;
        View inflate = layoutInflater.inflate(R.layout.trailers_feed_fragment, viewGroup, false);
        C1457Fr.m5016((Object) inflate, "root");
        TrailersFeedViewController trailersFeedViewController = new TrailersFeedViewController(rUVar, inflate, new TrailersFeedFragment$onCreateView$controller$1(this));
        this.f9667 = trailersFeedViewController;
        rUVar.getLifecycle().addObserver(trailersFeedViewController);
        trailersFeedViewController.m458((TrailersFeedViewController) m10166());
        return inflate;
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        C1457Fr.m5025(configuration, "newConfig");
        super.onConfigurationChanged(configuration);
        TrailersFeedViewController trailersFeedViewController = this.f9667;
        if (trailersFeedViewController != null) {
            trailersFeedViewController.m1882(configuration);
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public final void m10168(boolean z) {
        if (z) {
            TrailersFeedViewModel.m1922(m10166(), 0, 1, null);
        } else {
            TrailersFeedViewModel.m1923(m10166(), 0, 1, null);
        }
    }

    @Override // o.AbstractC0459
    public boolean isLoadingData() {
        return false;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public final boolean m10169() {
        FragmentActivity activity;
        Resources resources;
        Configuration configuration;
        if (!m10166().m1938().getValue().booleanValue() && ((activity = getActivity()) == null || (resources = activity.getResources()) == null || (configuration = resources.getConfiguration()) == null || configuration.orientation != 2)) {
            return false;
        }
        C1283.m16854("TrailersFeedFragment", "handleBackPressed notifyFullscreenModeChanged");
        m10166().m1944(false);
        return true;
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public final void m10171() {
        FragmentActivity activity = getActivity();
        AudioManager audioManager = (AudioManager) (activity != null ? activity.getSystemService("audio") : null);
        if (audioManager != null) {
            float streamMaxVolume = (1.0f / ((float) audioManager.getStreamMaxVolume(3))) * ((float) audioManager.getStreamVolume(3));
            C1283.m16854("TrailersFeedFragment", "volume changed to " + streamMaxVolume);
            C0399 r7 = new C0399(streamMaxVolume, streamMaxVolume == 0.0f);
            Logger.INSTANCE.m127(r7);
            Logger.INSTANCE.m131(new C1179());
            Logger.INSTANCE.m132(Long.valueOf(r7.m14625()));
            if (streamMaxVolume != 0.0f && !m10166().m1954()) {
                m10166().m1931(true);
            }
        }
    }

    /* renamed from: ˋॱ  reason: contains not printable characters */
    public final boolean m10167() {
        TrailersFeedViewController trailersFeedViewController = this.f9667;
        if (trailersFeedViewController != null) {
            return trailersFeedViewController.m1884();
        }
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC0517
    /* renamed from: ˊ */
    public void mo2213(View view) {
        C1457Fr.m5025(view, "view");
        C1004.m15952(view, 1, this.f13651);
        C1004.m15952(view, 3, this.f13650);
    }
}
