package com.netflix.mediaclient.android.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowInsets;
import com.netflix.android.widgetry.widget.tabs.BadgeView;
import com.netflix.cl.model.AppView;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.ui.experience.BrowseExperience;
import com.netflix.mediaclient.ui.offline.DownloadSummaryListener;
import com.netflix.mediaclient.ui.search.SearchActivity;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import o.AD;
import o.AJ;
import o.AbstractC1100;
import o.ActivityC2153sl;
import o.ActivityC2162st;
import o.C0369;
import o.C0383;
import o.C0520;
import o.C0589;
import o.C0619;
import o.C0682;
import o.C0935;
import o.C0965;
import o.C1004;
import o.C1031;
import o.C1080;
import o.C1226;
import o.C1276;
import o.C1283;
import o.C1285;
import o.C1300Ac;
import o.C1322Av;
import o.C1364Cj;
import o.C2059ph;
import o.rU;
import o.vH;
import o.vI;
public class NetflixBottomNavBar extends C0369 {

    /* renamed from: ˎ  reason: contains not printable characters */
    private static BehaviorSubject<Integer> f919 = BehaviorSubject.createDefault(0);

    /* renamed from: ॱ  reason: contains not printable characters */
    private static LinkedHashSet<Intent> f920 = new LinkedHashSet<>(5);

    /* renamed from: ʻ  reason: contains not printable characters */
    private ObjectAnimator f921;

    /* renamed from: ʼ  reason: contains not printable characters */
    private Set<AbstractC0013> f922 = new CopyOnWriteArraySet();

    /* renamed from: ˊ  reason: contains not printable characters */
    C1031 f923;

    /* renamed from: ˋ  reason: contains not printable characters */
    private NetflixActivity f924;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final BroadcastReceiver f925 = new BroadcastReceiver() { // from class: com.netflix.mediaclient.android.widget.NetflixBottomNavBar.2
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            AJ.C0062 r2 = AJ.m3360(intent, "NetflixBottomNavBar");
            NetflixBottomNavBar.f919.onNext(Integer.valueOf(r2.m3369()));
            NetflixBottomNavBar.this.m429(r2.m3369());
        }
    };

    /* renamed from: ᐝ  reason: contains not printable characters */
    private int f926 = 0;

    /* renamed from: com.netflix.mediaclient.android.widget.NetflixBottomNavBar$ˋ  reason: contains not printable characters */
    public interface AbstractC0013 {
        /* renamed from: ˏ */
        void mo283(boolean z);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static boolean m416() {
        return AD.m3292();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m433() {
        f920.clear();
    }

    public enum NetflixTab {
        HOME(R.id.home, ActivityC2153sl.class, IClientLogging.ModalView.homeTab, AppView.homeTab),
        SEARCH(R.id.search, SearchActivity.class, IClientLogging.ModalView.searchTab, AppView.searchTab),
        TRAILERS(R.id.trailers, rU.class, IClientLogging.ModalView.trailersTab, AppView.trailersTab),
        DOWNLOADS(R.id.downloads, vH.class, IClientLogging.ModalView.downloadsTab, AppView.downloadsTab),
        PROFILE(R.id.profile, ActivityC2162st.class, IClientLogging.ModalView.moreTab, AppView.moreTab);
        

        /* renamed from: ʻ  reason: contains not printable characters */
        AppView f943;

        /* renamed from: ʽ  reason: contains not printable characters */
        IClientLogging.ModalView f944;

        /* renamed from: ॱॱ  reason: contains not printable characters */
        Class<? extends Activity> f945;

        /* renamed from: ᐝ  reason: contains not printable characters */
        int f946;

        private NetflixTab(int i, Class cls, IClientLogging.ModalView modalView, AppView appView) {
            this.f946 = i;
            this.f945 = cls;
            this.f944 = modalView;
            this.f943 = appView;
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        public int m442() {
            return this.f946;
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public IClientLogging.ModalView m439() {
            return this.f944;
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        public AppView m440() {
            return this.f943;
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        public boolean m443(Activity activity) {
            return this.f945.isAssignableFrom(activity.getClass());
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public static Intent m437(NetflixActivity netflixActivity, NetflixTab netflixTab) {
            switch (netflixTab) {
                case HOME:
                    return ActivityC2153sl.m10779(netflixActivity);
                case SEARCH:
                    return SearchActivity.m2775(netflixActivity);
                case TRAILERS:
                    return rU.f9685.m10193(netflixActivity);
                case DOWNLOADS:
                    return vH.m11936(netflixActivity);
                case PROFILE:
                    return new Intent(netflixActivity, ActivityC2162st.class);
                default:
                    return new Intent();
            }
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public static NetflixTab m438(int i) {
            NetflixTab[] values = values();
            for (NetflixTab netflixTab : values) {
                if (netflixTab.m442() == i) {
                    return netflixTab;
                }
            }
            return null;
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        public AbstractC1100 m441() {
            switch (this) {
                case HOME:
                    return new C1226();
                case SEARCH:
                    return new C1285();
                case TRAILERS:
                    return new C0619();
                case DOWNLOADS:
                    return new C0589();
                case PROFILE:
                    return new C0520();
                default:
                    throw new IllegalStateException("Must add a new command here for tab!");
            }
        }
    }

    public NetflixBottomNavBar(Context context) {
        super(context);
        m418(context);
    }

    public NetflixBottomNavBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m418(context);
    }

    public NetflixBottomNavBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m418(context);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m418(Context context) {
        this.f924 = (NetflixActivity) C1322Av.m3791(context, NetflixActivity.class);
        if (this.f924 != null) {
            final ArrayList arrayList = new ArrayList(5);
            arrayList.add(new C0383(R.id.home, context.getString(R.string.tab_home), R.drawable.ic_tab_icon_home));
            arrayList.add(new C0383(R.id.search, context.getString(R.string.tab_search), R.drawable.ic_tab_icon_search));
            if (C0682.m14924() || C0935.m15747()) {
                arrayList.add(m421(context));
            }
            final C0383 r5 = new C0383(R.id.downloads, context.getString(R.string.tab_downloads), R.drawable.ic_download_icon);
            r5.m14145(false);
            arrayList.add(r5);
            arrayList.add(new C0383(R.id.profile, context.getString(R.string.tab_more), R.drawable.ic_tab_icon_menu));
            setTabs(arrayList);
            this.f923 = new C1031(this.f924);
            this.f923.m16036(new C1031.If() { // from class: com.netflix.mediaclient.android.widget.NetflixBottomNavBar.1
                @Override // o.C1031.If
                /* renamed from: ˎ  reason: contains not printable characters */
                public void mo434(boolean z) {
                    if (z) {
                        NetflixBottomNavBar.this.m426(false);
                    } else {
                        NetflixBottomNavBar.this.m431(false);
                    }
                }
            });
            setVisibility(this.f923.m16035() ? 8 : 0);
            m412(this.f924.getIntent());
            m429(f919.getValue().intValue());
            setLabelVisibility(true);
            this.f924.runWhenManagerIsReady(new NetflixActivity.If() { // from class: com.netflix.mediaclient.android.widget.NetflixBottomNavBar.3
                @Override // com.netflix.mediaclient.android.activity.NetflixActivity.If
                public void run(C2059ph phVar) {
                    if (phVar.m9824()) {
                        r5.m14145(true);
                        NetflixBottomNavBar.this.m14094(false);
                        NetflixBottomNavBar.this.m406();
                        return;
                    }
                    arrayList.remove(r5);
                    NetflixBottomNavBar.this.setTabs(arrayList);
                }
            });
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private static C0383 m421(Context context) {
        return new C0383(R.id.trailers, context.getString(R.string.tab_comingsoon), R.drawable.ic_tab_icon_trailers);
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        C1004.m15959(this, 3, windowInsets.getSystemWindowInsetBottom());
        return windowInsets;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m412(Intent intent) {
        setOnTabSelectedListener(new iF(this.f924));
        NetflixTab netflixTab = NetflixTab.HOME;
        if (intent == null || !intent.hasExtra("bottomTab")) {
            NetflixTab[] values = NetflixTab.values();
            int length = values.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                NetflixTab netflixTab2 = values[i];
                if (netflixTab2.m443(this.f924)) {
                    netflixTab = netflixTab2;
                    break;
                }
                i++;
            }
        } else {
            String str = null;
            try {
                str = intent.getStringExtra("bottomTab");
                netflixTab = NetflixTab.valueOf(str);
            } catch (Exception e) {
                C1283.m16851("NetflixBottomNavBar", "Couldn't find specified bottom tab", e);
                C1276.m16820().mo5725("Tab not found: " + intent.getComponent() + " tab: " + str);
            }
        }
        setSelectedTabId(netflixTab.m442(), false);
        m410(netflixTab, this.f924.getIntent());
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m429(int i) {
        BadgeView r5 = m14091(NetflixTab.PROFILE.m442());
        if (r5 == null) {
            return;
        }
        if (i > 0) {
            r5.setVisibility(0);
            r5.setBackgroundColor(getContext().getResources().getColor(R.color.tab_notification_badge));
            r5.setDisplayType(BadgeView.DisplayType.TEXT);
            r5.setText(String.format(Locale.ENGLISH, "%d", Integer.valueOf(i)));
            return;
        }
        r5.setVisibility(8);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˊ  reason: contains not printable characters */
    private void m410(NetflixTab netflixTab, Intent intent) {
        NetflixActivity netflixActivity = this.f924;
        Iterator<Intent> it = f920.iterator();
        while (it.hasNext()) {
            if (it.next().getComponent().getClassName().equals(NetflixTab.m437(netflixActivity, netflixTab).getComponent().getClassName())) {
                it.remove();
            }
        }
        f920.add(intent);
    }

    /* access modifiers changed from: protected */
    @Override // android.view.View, android.view.ViewGroup
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        m423();
    }

    /* access modifiers changed from: protected */
    @Override // android.view.View, android.view.ViewGroup
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m424();
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private void m423() {
        f919.observeOn(AndroidSchedulers.mainThread()).takeUntil(C0965.m15784(this)).subscribe(new Consumer<Integer>() { // from class: com.netflix.mediaclient.android.widget.NetflixBottomNavBar.5
            /* renamed from: ˋ  reason: contains not printable characters */
            public void accept(Integer num) {
                NetflixBottomNavBar.this.m429(num.intValue());
            }
        });
        LocalBroadcastManager.getInstance(getContext()).registerReceiver(this.f925, new IntentFilter("com.netflix.mediaclient.intent.action.BA_IRIS_NOTIFICATION_LIST_UPDATED"));
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    private void m424() {
        LocalBroadcastManager.getInstance(getContext()).unregisterReceiver(this.f925);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ʻ  reason: contains not printable characters */
    private void m406() {
        vI.m11940().takeUntil(C0965.m15784(this)).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<vI>() { // from class: com.netflix.mediaclient.android.widget.NetflixBottomNavBar.4
            /* renamed from: ˏ  reason: contains not printable characters */
            public void accept(vI vIVar) {
                if (vIVar.mo11944() == 0) {
                    BadgeView r3 = NetflixBottomNavBar.this.m14091(NetflixTab.DOWNLOADS.m442());
                    if (r3 != null) {
                        r3.setVisibility(8);
                    }
                } else if (vIVar.mo11946() == vIVar.mo11944()) {
                    NetflixBottomNavBar.this.m414(NetflixTab.DOWNLOADS, (int) R.drawable.ic_download_badge_complete);
                } else if (!vIVar.m11942() && vIVar.mo11943() > 0) {
                    NetflixBottomNavBar.this.m414(NetflixTab.DOWNLOADS, (int) R.drawable.ic_download_badge_error);
                } else if (vIVar.m11942() || vIVar.mo11945() <= 0) {
                    NetflixBottomNavBar.this.m425(vIVar.mo11947());
                } else {
                    NetflixBottomNavBar.this.m414(NetflixTab.DOWNLOADS, (int) R.drawable.ic_download_badge_paused);
                }
            }
        });
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m425(int i) {
        BadgeView r2 = m14091(NetflixTab.DOWNLOADS.m442());
        if (r2 != null) {
            r2.setVisibility(0);
            r2.setDisplayType(BadgeView.DisplayType.PROGRESS);
            r2.setBackgroundColor(getContext().getResources().getColor(R.color.tab_downloads_badge));
            r2.setBackgroundShadowColor(BrowseExperience.m1767((Activity) C1322Av.m3791(getContext(), Activity.class), (int) R.attr.bottomNavBarBackgroundColor));
            r2.setProgress(i);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˎ  reason: contains not printable characters */
    private void m414(NetflixTab netflixTab, int i) {
        BadgeView r1 = m14091(netflixTab.m442());
        if (r1 != null) {
            r1.setVisibility(0);
            r1.setDisplayType(BadgeView.DisplayType.DRAWABLE);
            r1.setDrawable(getContext().getDrawable(i));
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m409(int i, final int i2) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "translationY", (float) i);
        ofFloat.setDuration(150L);
        ofFloat.setAutoCancel(true);
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.netflix.mediaclient.android.widget.NetflixBottomNavBar.8
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (animator == NetflixBottomNavBar.this.f921) {
                    NetflixBottomNavBar.this.f926 = 0;
                    NetflixBottomNavBar.this.setVisibility(i2);
                }
            }
        });
        this.f921 = ofFloat;
        setVisibility(0);
        this.f921.start();
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public boolean m427() {
        switch (this.f926) {
            case 1:
                return true;
            case 2:
                return false;
            default:
                return getVisibility() == 0;
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m426(boolean z) {
        boolean r2 = m427();
        if (!z || this.f926 == 2) {
            m407();
            setVisibility(8);
        } else {
            this.f926 = 2;
            m409(getHeight(), 8);
        }
        if (r2) {
            m422();
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m431(boolean z) {
        if (!this.f923.m16035()) {
            boolean r2 = m427();
            if (!z || this.f926 == 1) {
                m407();
                setVisibility(0);
            } else {
                this.f926 = 1;
                m409(0, 0);
            }
            if (!r2) {
                m422();
            }
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m428(float f) {
        float measuredHeight = ((float) getMeasuredHeight()) * (1.0f - f);
        setTranslationY(measuredHeight);
        if (measuredHeight != 0.0f) {
            this.f926 = 2;
        } else {
            this.f926 = 0;
        }
        if (measuredHeight != ((float) getMeasuredHeight())) {
            setVisibility(0);
        }
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    private void m407() {
        if (this.f921 != null) {
            this.f921.cancel();
            this.f921 = null;
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        View findViewById = findViewById(R.id.bottom_tabs_blocker);
        if (!z && findViewById == null) {
            inflate(getContext(), R.layout.bottom_tabs_blocker, this);
        } else if (z && findViewById != null) {
            removeView(findViewById);
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public boolean m432() {
        if (this.f924 == null) {
            return false;
        }
        int size = f920.size();
        int i = 1;
        boolean z = false;
        Iterator<Intent> it = f920.iterator();
        while (it.hasNext()) {
            Intent next = it.next();
            if (i == size) {
                it.remove();
            } else if (i == size - 1) {
                this.f924.startActivity(next);
                this.f924.overridePendingTransition(0, 0);
                z = true;
            }
            i++;
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    public class iF implements C0369.AbstractC2396iF {

        /* renamed from: ॱ  reason: contains not printable characters */
        private final NetflixActivity f948;

        iF(NetflixActivity netflixActivity) {
            this.f948 = netflixActivity;
        }

        @Override // o.C0369.AbstractC2396iF
        /* renamed from: ˏ  reason: contains not printable characters */
        public boolean mo445(C0383 r6) {
            NetflixTab r3 = NetflixTab.m438(r6.m14144());
            if (r3 == null) {
                C1283.m16854("NetflixBottomNavBar", "No matching tab found for: " + r6);
                return false;
            }
            C1364Cj.m4447(r3.m439(), null);
            C1300Ac.m3531(new C1080(r3.m440(), null), r3.m441(), true);
            if (r3 == NetflixTab.DOWNLOADS) {
                DownloadSummaryListener.INSTANCE.m2183();
            }
            Intent r4 = NetflixTab.m437(this.f948, r3);
            m444(r4, r3);
            NetflixBottomNavBar.this.m410(r3, r4);
            return false;
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        private void m444(Intent intent, NetflixTab netflixTab) {
            intent.putExtra("bottomTab", netflixTab.name());
            intent.putExtra("fromBottomTab", true);
            intent.addFlags(131072);
            this.f948.startActivity(intent);
            this.f948.overridePendingTransition(0, 0);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static boolean m411(Intent intent) {
        return intent != null && intent.hasExtra("fromBottomTab");
    }

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private void m422() {
        for (AbstractC0013 r0 : this.f922) {
            r0.mo283(m427());
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m430(AbstractC0013 r2) {
        this.f922.add(r2);
    }
}
