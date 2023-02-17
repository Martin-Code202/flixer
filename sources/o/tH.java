package o;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.transition.Fade;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.netflix.cl.model.AppView;
import com.netflix.mediaclient.NetflixApplication;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.widget.NetflixActionBar;
import com.netflix.mediaclient.android.widget.NetflixBottomNavBar;
import com.netflix.mediaclient.service.logging.client.model.UIError;
import com.netflix.mediaclient.servicemgr.ApplicationPerformanceMetricsLogging;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.ui.experience.BrowseExperience;
import com.netflix.mediaclient.ui.lolomo.AutoValue_FragmentHelper_BackStackEntry;
import com.netflix.mediaclient.util.log.UIScreen;
import java.util.ArrayList;
import java.util.List;
import o.C1348Bu;
public class tH implements AbstractC2143se {

    /* renamed from: ˏ  reason: contains not printable characters */
    private static int f10333 = -1;

    /* renamed from: ʻ  reason: contains not printable characters */
    private final tJ f10334;

    /* renamed from: ʼ  reason: contains not printable characters */
    private ViewGroup f10335;

    /* renamed from: ʽ  reason: contains not printable characters */
    private ViewGroup f10336;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private IClientLogging.ModalView f10337;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final qY f10338;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private Animator f10339 = null;

    /* renamed from: ˎ  reason: contains not printable characters */
    private List<AbstractC2141sc> f10340 = new ArrayList(3);

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private int f10341;

    /* renamed from: ͺ  reason: contains not printable characters */
    private int f10342;

    /* renamed from: ॱ  reason: contains not printable characters */
    private NetflixActivity f10343;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private int f10344;

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private final ArrayList<AbstractC0211> f10345 = new ArrayList<>();

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private boolean f10346;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private LinearLayout f10347;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private ViewGroup f10348;

    public tH(NetflixActivity netflixActivity, Bundle bundle) {
        Fragment fragment;
        this.f10343 = netflixActivity;
        m10923();
        netflixActivity.setLifeCycleListener(new Application.ActivityLifecycleCallbacks() { // from class: o.tH.4
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle2) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
                if (tH.this.mo10706()) {
                    tH.this.m10938();
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                if (tH.this.mo10706()) {
                    C1362Ch.m4388(tH.this.f10337, IClientLogging.CompletionReason.success, (UIError) null);
                }
                if (activity.isFinishing()) {
                    tH.this.m10941();
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle2) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                tH.this.m10941();
            }
        });
        this.f10338 = new qY(this, this.f10343, bundle, this.f10348, this.f10336);
        this.f10334 = new tJ(this.f10343);
        this.f10340.add(this.f10338);
        this.f10340.add(this.f10334);
        this.f10340.add(new C2148sh());
        this.f10340.add(new C2390zv());
        if (bundle != null) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.f10345.clear();
            ArrayList parcelableArrayList = bundle.getParcelableArrayList("fh_backstack");
            if (parcelableArrayList != null) {
                this.f10345.addAll(parcelableArrayList);
            }
            this.f10346 = bundle.getBoolean("fh_showing_actionbar_initially");
            this.f10337 = (IClientLogging.ModalView) bundle.getSerializable("fh_last_log_view");
            final AbstractC0211 r7 = m10936();
            if (r7 != null) {
                if (m10920() instanceof qY) {
                    fragment = ((qY) m10920()).m10052();
                } else {
                    fragment = this.f10343.getSupportFragmentManager().findFragmentByTag("fh_main_fragment");
                }
                C1276.m16820().mo5728("FH - restored - topFrag: " + (fragment == null ? "none" : fragment.toString()) + " intent: " + r7.mo10885());
                m10934();
                m10918(r7.mo10885(), false);
                C1348Bu.If.m4098(new Runnable() { // from class: o.tH.3
                    @Override // java.lang.Runnable
                    public void run() {
                        AbstractC0517 r3;
                        AbstractC2141sc r1 = tH.this.m10920();
                        if (r1 != null) {
                            NetflixActionBar netflixActionBar = tH.this.f10343.getNetflixActionBar();
                            if (netflixActionBar != null) {
                                netflixActionBar.m356(false);
                            }
                            if (!r1.mo10075(r7.mo10885()) && (r3 = tH.this.m10939()) != null) {
                                r3.af_();
                            }
                        }
                    }
                });
                return;
            }
            return;
        }
        this.f10337 = this.f10343.getUiScreen() == null ? null : this.f10343.getUiScreen().f4084;
    }

    @Override // o.AbstractC2143se
    /* renamed from: ॱ */
    public void mo10708(Bundle bundle) {
        bundle.putBoolean("fh_showing_fragment", mo10706());
        bundle.putBoolean("fh_showing_actionbar_initially", this.f10346);
        bundle.putParcelableArrayList("fh_backstack", this.f10345);
        this.f10338.m10079(bundle);
        if (this.f10337 != null) {
            bundle.putSerializable("fh_last_log_view", this.f10337);
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private AbstractC2141sc m10926(Intent intent) {
        for (AbstractC2141sc scVar : this.f10340) {
            if (scVar.mo10080(intent)) {
                return scVar;
            }
        }
        return null;
    }

    @Override // o.AbstractC2143se
    /* renamed from: ˊ */
    public boolean mo10702(Intent intent) {
        NetflixActionBar netflixActionBar;
        if (!NetflixBottomNavBar.m416() || !m10931() || intent == null) {
            return false;
        }
        C1283.m16853("FragmentHelper", "handleIntent: ", intent);
        boolean z = false;
        View currentFocus = this.f10343.getWindow().getCurrentFocus();
        if (!mo10706()) {
            this.f10346 = this.f10343.getNetflixActionBar() != null && this.f10343.getNetflixActionBar().m346();
        }
        AbstractC2141sc r10 = m10926(intent);
        if (r10 != null) {
            if (currentFocus instanceof EditText) {
                AD.m3310(this.f10343, (EditText) currentFocus);
            }
            if (!mo10706() && (netflixActionBar = this.f10343.getNetflixActionBar()) != null && !netflixActionBar.m346()) {
                this.f10339 = netflixActionBar.m354(1);
            }
            AbstractC2141sc r11 = m10920();
            AbstractC0517 r12 = (AbstractC0517) this.f10343.getSupportFragmentManager().findFragmentByTag("fh_main_fragment");
            AbstractC0211 r13 = m10936();
            AbstractC0517 r14 = null;
            AbstractC0211 r15 = null;
            if (r10 != this.f10338) {
                r14 = r10.mo10061(intent);
                if (r14 != null) {
                    r15 = m10917(intent, r10);
                    z = true;
                }
            } else if (((qY) r10).m10068(intent)) {
                r15 = m10917(intent, r10);
                z = true;
            }
            if (z) {
                m10925(r13, r15, r11, r12, r10, r14, false);
                m10934();
                if (!r10.mo10075(intent) && r14 != null) {
                    r14.af_();
                }
                m10938();
            }
            m10918(intent, false);
            NetflixApplication.getInstance().m242().m4489();
        }
        return z;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private boolean m10925(AbstractC0211 r8, AbstractC0211 r9, AbstractC2141sc scVar, AbstractC0517 r11, AbstractC2141sc scVar2, AbstractC0517 r13, boolean z) {
        String str;
        Object obj;
        if (r13 != null) {
            r13.m14533(this.f10342, this.f10344, this.f10341);
        }
        m10940(r11, r13, z);
        FragmentTransaction beginTransaction = this.f10343.getSupportFragmentManager().beginTransaction();
        boolean z2 = false;
        if (!(scVar == null || r11 == null || r8 == null)) {
            scVar.mo10062(r8.mo10885(), r11, z);
            beginTransaction.remove(r11);
            if (z) {
                NetflixApplication.getInstance().m242().m4491(this.f10343, r8.mo10888(), true);
                scVar.mo10066(r8.mo10885(), r11);
            } else {
                scVar.mo10069(r8.mo10885(), r11);
            }
            z2 = true;
        }
        if (!(scVar2 == null || r13 == null || r9 == null)) {
            scVar2.mo10055(r9.mo10885(), r13, z);
            if (r13 instanceof AbstractC2124rm) {
                ((AbstractC2124rm) r13).mo10452(r9.mo10886());
            }
            beginTransaction.add(R.id.stacked_fragments_container, r13, "fh_main_fragment");
            if (!z) {
                NetflixApplication.getInstance().m242().m4488(this.f10343, scVar2.mo10051(r9.mo10885()), scVar2.mo10050(r9.mo10885()));
            }
            z2 = true;
        }
        if (z2) {
            beginTransaction.commitNow();
        }
        AbstractC0517 r6 = m10920() instanceof qY ? ((qY) m10920()).m10052() : r13;
        AbstractC1236 r0 = C1276.m16820();
        StringBuilder append = new StringBuilder().append("FH-isBack: ").append(z).append(" nextFrag: ");
        if (r6 == null) {
            str = "none";
        } else {
            str = r6.toString();
        }
        StringBuilder append2 = append.append(str).append(" intent: ");
        if (r9 == null) {
            obj = "none";
        } else {
            obj = r9.mo10885();
        }
        r0.mo5728(append2.append(obj).toString());
        return z2;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m10918(Intent intent, boolean z) {
        m10927(intent, z);
        this.f10343.invalidateOptionsMenu();
    }

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private boolean m10931() {
        return !this.f10343.getSupportFragmentManager().isStateSaved();
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private AbstractC2141sc m10916(String str) {
        for (AbstractC2141sc scVar : this.f10340) {
            if (scVar.getClass().getCanonicalName().equals(str)) {
                return scVar;
            }
        }
        return null;
    }

    @Override // o.AbstractC2143se
    /* renamed from: ˎ */
    public boolean mo10705() {
        AbstractC2141sc r1 = m10920();
        if (r1 == null || !r1.mo10074()) {
            return mo10709();
        }
        return true;
    }

    @Override // o.AbstractC2143se
    /* renamed from: ˋ */
    public boolean mo10704() {
        return m10919(true);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private boolean m10919(boolean z) {
        if (!NetflixBottomNavBar.m416() || !m10931()) {
            return false;
        }
        C1283.m16846("FragmentHelper", "Back pressed");
        boolean z2 = false;
        AbstractC0211 r9 = m10935();
        if (r9 != null) {
            AbstractC2141sc r10 = m10916(r9.mo10887());
            AbstractC0211 r11 = m10936();
            AbstractC2141sc scVar = null;
            if (r11 != null) {
                scVar = m10916(r11.mo10887());
            } else {
                NetflixActionBar netflixActionBar = this.f10343.getNetflixActionBar();
                if (netflixActionBar != null && !this.f10346) {
                    this.f10339 = netflixActionBar.m348(1);
                }
            }
            if (r10 == this.f10338 && ((qY) r10).m10067()) {
                z2 = true;
            }
            AbstractC0517 r13 = (AbstractC0517) this.f10343.getSupportFragmentManager().findFragmentByTag("fh_main_fragment");
            AbstractC0517 r14 = scVar == null ? null : scVar.mo10061(r11.mo10885());
            z2 |= m10925(r9, r11, r10, r13, scVar, r14, true);
            if (z2) {
                m10934();
                if (!(scVar == null || r14 == null || scVar.mo10075(r11.mo10885()))) {
                    r14.af_();
                }
                m10918(r9.mo10885(), true);
                m10938();
                if (z) {
                    NetflixApplication.getInstance().m242().m4489();
                }
            }
        }
        return z2;
    }

    @Override // o.AbstractC2143se
    /* renamed from: ʼ */
    public NetflixActionBar.iF.AbstractC0010 mo10699() {
        NetflixActionBar netflixActionBar = this.f10343.getNetflixActionBar();
        if (netflixActionBar == null) {
            return null;
        }
        return netflixActionBar.m345().mo403(true).mo386(NetflixBottomNavBar.m416() ? 1 : 0).mo401(NetflixBottomNavBar.m416() ? NetflixActionBar.LogoType.CENTERED : NetflixActionBar.LogoType.START_ALIGNED);
    }

    @Override // o.AbstractC2143se
    /* renamed from: ॱ */
    public void mo10707(int i, int i2, int i3) {
        this.f10342 = i;
        this.f10344 = i2;
        this.f10341 = i3;
        this.f10338.m10065(i, i2, i3);
        AbstractC0517 r1 = m10939();
        if (r1 != null) {
            r1.m14533(i, i2, i3);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˊॱ  reason: contains not printable characters */
    private AbstractC2141sc m10920() {
        AbstractC0211 r1 = m10936();
        if (r1 == null) {
            return null;
        }
        return m10916(r1.mo10887());
    }

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private void m10923() {
        if (this.f10343.findViewById(R.id.stacked_fragments_container) != null) {
            this.f10335 = (ViewGroup) this.f10343.findViewById(R.id.stacked_fragments_container);
            if (this.f10343.findViewById(R.id.stacked_details_container) != null) {
                this.f10347 = (LinearLayout) this.f10343.findViewById(R.id.stacked_details_container);
                if (this.f10343.findViewById(R.id.stacked_primary_fragment) != null) {
                    this.f10348 = (ViewGroup) this.f10343.findViewById(R.id.stacked_primary_fragment);
                    if (this.f10343.findViewById(R.id.stacked_secondary_fragment) != null) {
                        this.f10336 = (ViewGroup) this.f10343.findViewById(R.id.stacked_secondary_fragment);
                        m10932();
                        return;
                    }
                    throw new IllegalStateException("stacked_secondary_fragment missing");
                }
                throw new IllegalStateException("stacked_primary_fragment missing");
            }
            throw new IllegalStateException("stacked_details_container missing");
        }
        throw new IllegalStateException("stacked_fragments_container missing");
    }

    /* renamed from: ͺ  reason: contains not printable characters */
    private void m10932() {
        this.f10347.setOrientation(AD.m3284(this.f10343) == 2 ? 0 : 1);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f10348.getLayoutParams();
        layoutParams.weight = 0.6f;
        this.f10348.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f10336.getLayoutParams();
        layoutParams2.weight = 1.0f;
        this.f10336.setLayoutParams(layoutParams2);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m10928(final View view, final int i) {
        view.animate().cancel();
        if (i != 8 || view.getVisibility() != 8) {
            if (i != 4 || view.getVisibility() != 4) {
                if (i != 0 || view.getVisibility() != 0 || view.getAlpha() != 1.0f) {
                    long r5 = (long) m10937();
                    view.setTranslationY(0.0f);
                    if (i == 0) {
                        view.setAlpha(view.getAlpha() == 1.0f ? 0.0f : view.getAlpha());
                    } else {
                        view.setAlpha(view.getAlpha() == 0.0f ? 1.0f : view.getAlpha());
                    }
                    ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, View.ALPHA, i == 0 ? 1.0f : 0.0f);
                    ofFloat.setAutoCancel(true);
                    ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, View.TRANSLATION_Y, 0.0f);
                    ofFloat2.setAutoCancel(true);
                    view.setVisibility(0);
                    AnimatorSet animatorSet = new AnimatorSet();
                    animatorSet.play(ofFloat).with(ofFloat2);
                    animatorSet.setDuration(r5);
                    animatorSet.addListener(new AnimatorListenerAdapter() { // from class: o.tH.2

                        /* renamed from: ॱ  reason: contains not printable characters */
                        boolean f10355;

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animator) {
                            this.f10355 = true;
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            if (!this.f10355) {
                                view.setVisibility(i);
                            }
                        }
                    });
                    animatorSet.start();
                }
            }
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private static void m10929(final View view, final int i, long j) {
        view.animate().cancel();
        if (i != 8 || view.getVisibility() != 8) {
            if (i != 4 || view.getVisibility() != 4) {
                ViewPropertyAnimator animate = view.animate();
                animate.alpha(1.0f);
                animate.setDuration(j);
                animate.setListener(new AnimatorListenerAdapter() { // from class: o.tH.1

                    /* renamed from: ˋ  reason: contains not printable characters */
                    boolean f10349;

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        this.f10349 = true;
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (!this.f10349) {
                            view.setVisibility(i);
                        }
                    }
                });
                animate.start();
            }
        }
    }

    @Override // o.AbstractC2143se
    /* renamed from: ˏ */
    public boolean mo10706() {
        return !this.f10345.isEmpty();
    }

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private void m10934() {
        this.f10343.runWhenManagerIsReady(new NetflixActivity.If() { // from class: o.tH.5
            @Override // com.netflix.mediaclient.android.activity.NetflixActivity.If
            public void run(C2059ph phVar) {
                AbstractC0517 r2 = (AbstractC0517) tH.this.f10343.getSupportFragmentManager().findFragmentByTag("fh_main_fragment");
                if (r2 != null) {
                    r2.onManagerReady(phVar, AbstractC0367.f13235);
                }
            }
        });
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public AbstractC0517 m10939() {
        if (m10920() == this.f10338) {
            return this.f10338.m10052();
        }
        return (AbstractC0517) this.f10343.getSupportFragmentManager().findFragmentByTag("fh_main_fragment");
    }

    @Override // o.AbstractC2143se
    /* renamed from: ʽ */
    public boolean mo10700() {
        return this.f10338.m10082();
    }

    @Override // o.AbstractC2143se
    /* renamed from: ॱ */
    public boolean mo10709() {
        boolean z = false;
        while (mo10706() && m10919(false)) {
            z = true;
        }
        if (z) {
            NetflixApplication.getInstance().m242().m4489();
        }
        return z;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m10927(Intent intent, boolean z) {
        AbstractC2141sc r4 = m10920();
        if (r4 == null) {
            boolean z2 = !z && this.f10334.m10957(intent) && this.f10335.getVisibility() == 0;
            m10929(this.f10335, 4, z2 ? BM.f4589 : (long) m10937());
            m10929(this.f10347, 4, (long) m10937());
            this.f10343.setFragmentsHiddenState(false, z2 ? new BM() : new Fade());
            return;
        }
        if (r4 == this.f10338) {
            this.f10347.animate().cancel();
            this.f10347.setVisibility(0);
            m10928(this.f10335, 4);
        } else {
            this.f10335.animate().cancel();
            m10929(this.f10347, 4, (long) m10937());
            if (z) {
                m10928(this.f10335, 0);
            } else {
                this.f10335.setAlpha(1.0f);
                this.f10335.setVisibility(0);
            }
        }
        this.f10343.setFragmentsHiddenState(true, (m10920() != this.f10334 || !this.f10334.m10957(intent)) ? new Fade().setDuration(300) : new BM());
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public void m10941() {
        this.f10338.m10059();
    }

    @Override // o.AbstractC2143se
    /* renamed from: ˊ */
    public oX mo10701() {
        if (this.f10338.m10082()) {
            return this.f10338.mo1635();
        }
        return new oB("FragmentHelper");
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    static int m10937() {
        if (f10333 == -1) {
            f10333 = C1317As.m3768(NetflixApplication.getInstance(), R.integer.activity_transition_anim_time_ms);
        }
        return f10333;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m10940(Fragment fragment, Fragment fragment2, boolean z) {
        BY by = new BY();
        by.m3962(BrowseExperience.m1774(this.f10343, 16842836));
        by.setDuration((long) m10937());
        if (this.f10339 != null) {
            if (z) {
                by.m3964(this.f10339);
                this.f10339 = null;
            } else {
                by.m3963(this.f10339);
                this.f10339 = null;
            }
        }
        if (fragment2 != null) {
            fragment2.setEnterTransition(z ? new Fade() : by);
        }
        if (fragment != null) {
            fragment.setExitTransition(z ? by : new Fade());
        }
    }

    @Override // o.AbstractC2143se
    /* renamed from: ˋ */
    public void mo10703(Menu menu, Menu menu2) {
        if (m10920() == this.f10338) {
            this.f10338.m10070(menu, menu2);
        }
    }

    @Override // o.AbstractC2143se
    /* renamed from: ॱ */
    public boolean mo10710(MenuItem menuItem) {
        return m10920() == this.f10338 && this.f10338.m10063(menuItem);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m10922(UIScreen uIScreen, final C1359Ce ce) {
        if (uIScreen != null) {
            final IClientLogging.ModalView modalView = uIScreen.f4084;
            final boolean r3 = AD.m3306(this.f10343);
            this.f10343.runWhenManagerIsReady(new NetflixActivity.If() { // from class: o.tH.6
                @Override // com.netflix.mediaclient.android.activity.NetflixActivity.If
                public void run(C2059ph phVar) {
                    ApplicationPerformanceMetricsLogging r2 = BW.m3931();
                    if (r2 != null && modalView != null) {
                        IClientLogging r32 = phVar.m9825();
                        if (r32 != null) {
                            r32.mo1507(ce);
                        }
                        r2.mo1497(r3, modalView);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private void m10938() {
        AbstractC2141sc r4;
        AbstractC0211 r3 = m10936();
        if (r3 == null || (r4 = m10916(r3.mo10887())) == null) {
            this.f10343.reportCL1NavigationSessionStart(this.f10343.getUiScreen());
            m10922(this.f10343.getUiScreen(), this.f10343.getDataContext());
            C1362Ch.m4388(this.f10337, IClientLogging.CompletionReason.success, (UIError) null);
            this.f10337 = null;
            return;
        }
        m10930(r4.mo10083());
        AbstractC0574 r5 = r4.mo10050(r3.mo10885());
        if (r5 instanceof C1359Ce) {
            m10922(r4.mo10083(), (C1359Ce) r5);
        } else {
            m10922(r4.mo10083(), (C1359Ce) null);
        }
        C1362Ch.m4388(this.f10337, IClientLogging.CompletionReason.success, (UIError) null);
        this.f10337 = r4.mo10083().f4084;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m10930(UIScreen uIScreen) {
        if (uIScreen == null) {
            C1283.m16850("FragmentHelper", "cl1NavigationActionStart:: view is NULL!");
        } else {
            C1362Ch.m4423(null, uIScreen.f4084);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private AbstractC0211 m10917(Intent intent, AbstractC2141sc scVar) {
        AbstractC0211 r7;
        Fragment findFragmentByTag = this.f10343.getSupportFragmentManager().findFragmentByTag("fh_main_fragment");
        if (!this.f10345.isEmpty() && (findFragmentByTag instanceof AbstractC2124rm) && (r7 = m10935()) != null) {
            this.f10345.add(new AutoValue_FragmentHelper_BackStackEntry(r7.mo10887(), r7.mo10885(), r7.mo10888(), ((AbstractC2124rm) findFragmentByTag).mo10450()));
        }
        AutoValue_FragmentHelper_BackStackEntry autoValue_FragmentHelper_BackStackEntry = new AutoValue_FragmentHelper_BackStackEntry(scVar.getClass().getCanonicalName(), intent, scVar.mo10051(intent), null);
        this.f10345.add(autoValue_FragmentHelper_BackStackEntry);
        return autoValue_FragmentHelper_BackStackEntry;
    }

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private AbstractC0211 m10936() {
        if (this.f10345.isEmpty()) {
            return null;
        }
        return this.f10345.get(this.f10345.size() - 1);
    }

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private AbstractC0211 m10935() {
        if (this.f10345.isEmpty()) {
            return null;
        }
        return this.f10345.remove(this.f10345.size() - 1);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.tH$ˊ  reason: contains not printable characters */
    public static abstract class AbstractC0211 implements Parcelable {
        /* renamed from: ˊ */
        public abstract Intent mo10885();

        /* renamed from: ˋ */
        public abstract Parcelable mo10886();

        /* renamed from: ˎ */
        public abstract String mo10887();

        /* renamed from: ॱ */
        public abstract AppView mo10888();

        AbstractC0211() {
        }
    }
}
