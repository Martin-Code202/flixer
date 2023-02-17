package o;

import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.widget.NetflixBottomNavBar;
import com.netflix.mediaclient.service.logging.perf.Sessions;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.ui.details.DetailsActivity;
import com.netflix.mediaclient.util.gfx.ImageLoader;
import java.util.HashSet;
import java.util.Set;
import o.oN;
public abstract class qH implements oN {

    /* renamed from: ˊ  reason: contains not printable characters */
    private oN.AbstractC0161 f9437;

    /* renamed from: ˋ  reason: contains not printable characters */
    private Set<ImageLoader.AbstractC0050> f9438 = new HashSet();

    /* renamed from: ˎ  reason: contains not printable characters */
    private boolean f9439;

    /* renamed from: ॱ  reason: contains not printable characters */
    private boolean f9440;

    @Override // o.oN
    /* renamed from: ˎ */
    public void mo9575(oN.AbstractC0161 r1) {
        m9892();
        this.f9437 = r1;
    }

    @Override // o.oN
    /* renamed from: ˊ */
    public void mo9571() {
        m9892();
        if (!m9893()) {
            m9891(IClientLogging.CompletionReason.canceled);
        }
    }

    @Override // o.oN
    /* renamed from: ˋ */
    public void mo9573() {
        this.f9439 = false;
        this.f9440 = false;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˎ  reason: contains not printable characters */
    private void m9891(IClientLogging.CompletionReason completionReason) {
        if (this.f9437 == null) {
            C1283.m16854("InteractiveTrackerImpl", "... but there was no listener attached so tracking has not completed");
            return;
        }
        this.f9439 = true;
        this.f9440 = true;
        this.f9437.mo1655(completionReason);
        C1283.m16851("InteractiveTrackerImpl", "isNowInteractive() -> %s", mo9577());
    }

    @Override // o.oN
    /* renamed from: ˏ */
    public ImageLoader.AbstractC0050 mo9576(ImageLoader.AbstractC0050 r6, final ImageView imageView) {
        C1283.m16848("InteractiveTrackerImpl", "registerListener -- %d: %s %s", Integer.valueOf(this.f9438.size()), imageView.getContentDescription(), r6.mo3066());
        this.f9438.add(r6);
        imageView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: o.qH.4
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                imageView.getViewTreeObserver().removeOnPreDrawListener(this);
                if (qH.this.m9893() || !qH.this.f9438.isEmpty()) {
                    return true;
                }
                qH.this.m9891(IClientLogging.CompletionReason.success);
                return true;
            }
        });
        return r6;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m9892() {
        this.f9438.clear();
    }

    @Override // o.oN
    /* renamed from: ˊ */
    public void mo9572(BS bs, ImageLoader.AssetLocationType assetLocationType) {
        if (assetLocationType != ImageLoader.AssetLocationType.PLACEHOLDER && this.f9438.remove(bs) && this.f9438.isEmpty() && assetLocationType != ImageLoader.AssetLocationType.MEMCACHE) {
            C1283.m16854("InteractiveTrackerImpl", "onInteractive");
            m9891(IClientLogging.CompletionReason.success);
        }
    }

    @Override // o.oN
    /* renamed from: ˋ */
    public boolean mo9574(View view) {
        NetflixActivity netflixActivity;
        if (this.f9440 || m9893()) {
            return false;
        }
        boolean z = false;
        if (view != null) {
            if (mo9577().equals(C0166.f9444)) {
                z = C1317As.m3755(view.getContext(), DetailsActivity.class) != null;
                if (!z && NetflixBottomNavBar.m416() && (netflixActivity = (NetflixActivity) C1317As.m3755(view.getContext(), NetflixActivity.class)) != null) {
                    z = netflixActivity.getFragmentHelper().mo10700();
                }
            } else {
                z = C1317As.m3755(view.getContext(), ActivityC2153sl.class) != null;
            }
            C1283.m16848("InteractiveTrackerImpl", "Track %s for %s? - %b", view.getContentDescription(), mo9577(), Boolean.valueOf(z));
        }
        return z;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public boolean m9893() {
        return this.f9439;
    }

    public static class iF extends qH {

        /* renamed from: ˋ  reason: contains not printable characters */
        public static final String f9443 = Sessions.TTR.toString();

        @Override // o.oN
        /* renamed from: ˏ */
        public String mo9577() {
            return f9443;
        }
    }

    /* renamed from: o.qH$ˋ  reason: contains not printable characters */
    public static class C0167 extends qH {

        /* renamed from: ˋ  reason: contains not printable characters */
        public static final String f9445 = Sessions.WH_TTR.toString();

        @Override // o.oN
        /* renamed from: ˏ */
        public String mo9577() {
            return f9445;
        }
    }

    /* renamed from: o.qH$ˊ  reason: contains not printable characters */
    public static class C0166 extends qH {

        /* renamed from: ˎ  reason: contains not printable characters */
        public static final String f9444 = Sessions.DP_TTR.toString();

        @Override // o.oN
        /* renamed from: ˏ */
        public String mo9577() {
            return f9444;
        }
    }
}
