package o;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.service.webclient.model.leafs.ABTestConfig;
import com.netflix.mediaclient.util.ViewUtils;
import o.C0697;
public class vT {

    /* renamed from: ˎ  reason: contains not printable characters */
    public static final vT f11250 = new vT(null, null);

    /* renamed from: ˊ  reason: contains not printable characters */
    AbstractC2089qj f11251;

    /* renamed from: ˋ  reason: contains not printable characters */
    Context f11252;

    /* renamed from: ˏ  reason: contains not printable characters */
    C0697 f11253;

    /* renamed from: o.vT$ˋ  reason: contains not printable characters */
    public interface AbstractC0242 {
        /* renamed from: ˏ */
        C0697 mo10390(AbstractC2089qj qjVar);
    }

    public vT(Context context, AbstractC2089qj qjVar) {
        this.f11252 = context;
        this.f11251 = qjVar;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public boolean m12055(C2059ph phVar) {
        return this.f11252 != null && this.f11251 != null && NetflixActivity.isTutorialOn() && m12053(this.f11252) && m12048(phVar) && this.f11252.getSharedPreferences("com.netflix.android.fullscreen_tutorial", 0).getBoolean(m12046("USER_TUTORIAL_FULLSCREEN", this.f11251), true);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m12057(boolean z) {
        if (this.f11252 != null && this.f11251 != null) {
            this.f11252.getSharedPreferences("com.netflix.android.fullscreen_tutorial", 0).edit().putBoolean(m12046("USER_TUTORIAL_FULLSCREEN", this.f11251), !z).apply();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˊ  reason: contains not printable characters */
    private void m12044(final RecyclerView recyclerView, final AbstractC0242 r5) {
        if (recyclerView.getAdapter().getItemCount() > 0) {
            recyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: o.vT.1
                @Override // android.support.v7.widget.RecyclerView.OnScrollListener
                public void onScrollStateChanged(RecyclerView recyclerView2, int i) {
                    if (0 == i) {
                        recyclerView.removeOnScrollListener(this);
                        vT.this.f11253 = null;
                        vT.this.m12049(r5);
                        if (vT.this.f11253 != null) {
                            vT.this.m12043(recyclerView, vT.this.f11253.m15001());
                        }
                    }
                }
            });
            if (!C0697.m14997(recyclerView.getContext(), m12046("USER_TUTORIAL_DOWNLOAD_BUTTON", this.f11251))) {
                recyclerView.smoothScrollToPosition(1);
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˊ  reason: contains not printable characters */
    private void m12043(final RecyclerView recyclerView, View view) {
        int i;
        this.f11253.m15003(new C0697.Cif() { // from class: o.vT.2
            @Override // o.C0697.Cif
            /* renamed from: ˎ  reason: contains not printable characters */
            public void mo12059(C0697 r1) {
            }

            @Override // o.C0697.Cif
            /* renamed from: ˏ  reason: contains not printable characters */
            public void mo12060(C0697 r3) {
                recyclerView.smoothScrollToPosition(0);
            }
        });
        int i2 = ViewUtils.m3007(view).bottom;
        NetflixActivity netflixActivity = (NetflixActivity) C1322Av.m3791(this.f11252, NetflixActivity.class);
        if (netflixActivity != null) {
            i = netflixActivity.findViewById(16908290).getHeight() - netflixActivity.getTabsAndSystemNavHeight();
        } else {
            i = AD.m3280(this.f11252);
        }
        int i3 = i2 - i;
        if (i3 > 0) {
            recyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() { // from class: o.vT.4
                @Override // android.support.v7.widget.RecyclerView.OnScrollListener
                public void onScrollStateChanged(RecyclerView recyclerView2, int i4) {
                    if (0 == i4) {
                        recyclerView.removeOnScrollListener(this);
                        vT.this.f11253.m15000();
                    }
                }
            });
            recyclerView.smoothScrollBy(0, i3 + this.f11252.getResources().getDimensionPixelSize(R.dimen.offline_tutorial_overscroll));
            return;
        }
        this.f11253.m15000();
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m12056(final AbstractC0242 r4, pT pTVar, final RecyclerView recyclerView, C2059ph phVar) {
        if (NetflixActivity.isTutorialOn() && this.f11251 != null && m12051(this.f11252) && pTVar != null && pTVar.getPlayable() != null && pTVar.getPlayable().isAvailableOffline() && m12048(phVar) && !C0697.m14997(recyclerView.getContext(), m12046("USER_TUTORIAL_DOWNLOAD_BUTTON", this.f11251))) {
            recyclerView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: o.vT.3
                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public boolean onPreDraw() {
                    recyclerView.getViewTreeObserver().removeOnPreDrawListener(this);
                    vT.this.m12049(r4);
                    if (vT.this.f11253 == null) {
                        vT.this.m12044(recyclerView, r4);
                        return true;
                    }
                    vT.this.m12043(recyclerView, vT.this.f11253.m15001());
                    return true;
                }
            });
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static boolean m12048(C2059ph phVar) {
        return phVar != null && phVar.m9824();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m12054(AbstractC0242 r2, C2059ph phVar) {
        if (NetflixActivity.isTutorialOn() && m12051(this.f11252) && m12048(phVar)) {
            m12049(r2);
            if (this.f11253 != null) {
                this.f11253.m15000();
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˏ  reason: contains not printable characters */
    private void m12049(AbstractC0242 r3) {
        if (((this.f11253 == null) && (r3 != null)) && this.f11251 != null) {
            this.f11253 = r3.mo10390(this.f11251);
        }
        m12058();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m12058() {
        if (this.f11253 != null) {
            this.f11253.m15005();
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static C0697 m12047(View view, Activity activity, AbstractC2089qj qjVar) {
        FrameLayout frameLayout;
        if (view == null || activity == null || qjVar == null || (frameLayout = (FrameLayout) activity.findViewById(16908290)) == null) {
            return null;
        }
        C0697 r3 = C0697.m14993(activity, frameLayout, view, R.string.offline_tooltip_title, R.string.offline_tooltip_detail_page);
        r3.m15002(m12046("USER_TUTORIAL_DOWNLOAD_BUTTON", qjVar));
        return r3;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static C0697 m12042(View view, Activity activity, AbstractC2089qj qjVar) {
        FrameLayout frameLayout;
        if (view == null || activity == null || qjVar == null || (frameLayout = (FrameLayout) activity.findViewById(16908290)) == null) {
            return null;
        }
        C0697 r3 = C0697.m14993(activity, frameLayout, view, R.string.offline_tooltip_title, R.string.offline_tooltip_my_downloads);
        r3.m15002(m12046("USER_TUTORIAL_MY_DOWNLOADS_BUTTON", qjVar));
        return r3;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static String m12046(String str, AbstractC2089qj qjVar) {
        return str + "_" + qjVar.getProfileGuid();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private static boolean m12053(Context context) {
        ABTestConfig.Cell r1 = C1272.m16797(C1059.class, context);
        return r1 == ABTestConfig.Cell.CELL_1 || r1 == ABTestConfig.Cell.CELL_3 || r1 == ABTestConfig.Cell.CELL_5;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private static boolean m12051(Context context) {
        ABTestConfig.Cell r1 = C1272.m16797(C1059.class, context);
        return r1 == ABTestConfig.Cell.CELL_1 || r1 == ABTestConfig.Cell.CELL_3 || r1 == ABTestConfig.Cell.CELL_4;
    }
}
