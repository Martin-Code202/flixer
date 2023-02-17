package o;

import android.app.Activity;
import android.arch.lifecycle.Observer;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.ui.feeds.TrailersFeedActivity$onCreate$3;
import com.netflix.mediaclient.ui.feeds.TrailersFeedActivity$onCreate$4;
import com.netflix.mediaclient.ui.feeds.TrailersFeedActivity$trailersFeedViewModel$2;
import com.netflix.mediaclient.ui.feeds.TrailersFeedViewModel;
import com.netflix.mediaclient.util.log.UIScreen;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Predicate;
import io.reactivex.rxkotlin.SubscribersKt;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.PropertyReference1Impl;
public final class rU extends AbstractActivityC0360 {

    /* renamed from: ˊ  reason: contains not printable characters */
    public static final C0174 f9685 = new C0174(null);

    /* renamed from: ˎ  reason: contains not printable characters */
    static final /* synthetic */ FQ[] f9686 = {C1461Fv.m5038(new PropertyReference1Impl(C1461Fv.m5035(rU.class), "trailersFeedViewModel", "getTrailersFeedViewModel()Lcom/netflix/mediaclient/ui/feeds/TrailersFeedViewModel;"))};

    /* renamed from: ˋ  reason: contains not printable characters */
    private int f9687;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final AbstractC1433Et f9688 = C1435Ev.m4972(new TrailersFeedActivity$trailersFeedViewModel$2(this));

    /* renamed from: ॱ  reason: contains not printable characters */
    private final CompositeDisposable f9689 = new CompositeDisposable();

    /* renamed from: ॱˊ  reason: contains not printable characters */
    public final TrailersFeedViewModel m10190() {
        AbstractC1433Et et = this.f9688;
        FQ fq = f9686[0];
        return (TrailersFeedViewModel) et.mo3220();
    }

    /* renamed from: o.rU$ˊ  reason: contains not printable characters */
    public static final class C0174 {
        private C0174() {
        }

        public /* synthetic */ C0174(C1456Fq fq) {
            this();
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public final Intent m10193(Activity activity) {
            C1457Fr.m5025(activity, "activity");
            return new Intent(activity, rU.class);
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        public final boolean m10192(Activity activity) {
            C1457Fr.m5025(activity, "activity");
            return Settings.System.getInt(activity.getContentResolver(), "accelerometer_rotation", 0) == 1;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ͺ  reason: contains not printable characters */
    private final rR m10186() {
        return (rR) mo10792();
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractActivityC0360, com.netflix.mediaclient.android.activity.NetflixActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        C1457Fr.m5016((Object) window, "window");
        View decorView = window.getDecorView();
        C1457Fr.m5016((Object) decorView, "window.decorView");
        this.f9687 = decorView.getSystemUiVisibility();
        m10190().m1938().observe(this, new C0175(this));
        CompositeDisposable compositeDisposable = this.f9689;
        Observable<Integer> filter = m10190().m1953().filter(new Cif(this));
        C1457Fr.m5016((Object) filter, "trailersFeedViewModel.de….ORIENTATION_LANDSCAPE })");
        C1220.m16501(compositeDisposable, SubscribersKt.subscribeBy$default(filter, TrailersFeedActivity$onCreate$4.f3070, null, new TrailersFeedActivity$onCreate$3(this), 2, null));
        C2139sa.f10131.m10696(this, m10190());
    }

    /* renamed from: o.rU$ˋ  reason: contains not printable characters */
    static final class C0175<T> implements Observer<Boolean> {

        /* renamed from: ॱ  reason: contains not printable characters */
        final /* synthetic */ rU f9694;

        C0175(rU rUVar) {
            this.f9694 = rUVar;
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        public final void onChanged(Boolean bool) {
            C1283.m16854("TrailersFeedActivity", "fullscreen " + bool + " with " + this.f9694.getSupportFragmentManager());
            if (this.f9694.getSupportFragmentManager() == null) {
                return;
            }
            if (bool == null || !bool.booleanValue()) {
                this.f9694.setRequestedOrientation(1);
            } else {
                this.f9694.setRequestedOrientation(6);
            }
        }
    }

    /* renamed from: o.rU$if  reason: invalid class name */
    static final class Cif<T> implements Predicate<Integer> {

        /* renamed from: ˋ  reason: contains not printable characters */
        final /* synthetic */ rU f9693;

        Cif(rU rUVar) {
            this.f9693 = rUVar;
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        public final boolean test(Integer num) {
            C1457Fr.m5025(num, "it");
            return rU.f9685.m10192(this.f9693) && num.intValue() == 2;
        }
    }

    /* renamed from: o.rU$iF  reason: case insensitive filesystem */
    public static final class C2109iF extends NetflixActivity.If {

        /* renamed from: ˊ  reason: contains not printable characters */
        final /* synthetic */ rU f9692;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        C2109iF(rU rUVar) {
            this.f9692 = rUVar;
        }

        @Override // com.netflix.mediaclient.android.activity.NetflixActivity.If
        public void run(C2059ph phVar) {
            C1457Fr.m5025(phVar, "manager");
            C1283.m16854("TrailersFeedActivity", "onActivityResumed");
            this.f9692.m10190().m1939(phVar);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        runWhenManagerIsReady(new C2109iF(this));
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        C1283.m16854("TrailersFeedActivity", "onActivityPaused");
        m10190().m1950();
        super.onPause();
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        this.f9689.clear();
        super.onDestroy();
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        C1457Fr.m5025(configuration, "newConfig");
        super.onConfigurationChanged(configuration);
        switch (configuration.orientation) {
            case 2:
                if (m10190().m1947().getValue() instanceof rW) {
                    Window window = getWindow();
                    C1457Fr.m5016((Object) window, "window");
                    C0391.m14159(window);
                    hideActionAndBottomBars();
                    return;
                }
                return;
            default:
                Window window2 = getWindow();
                C1457Fr.m5016((Object) window2, "window");
                View decorView = window2.getDecorView();
                C1457Fr.m5016((Object) decorView, "window.decorView");
                decorView.setSystemUiVisibility(this.f9687);
                showActionAndBottomBars();
                return;
        }
    }

    static final class If implements Action {

        /* renamed from: ˎ  reason: contains not printable characters */
        final /* synthetic */ boolean f9690;

        /* renamed from: ˏ  reason: contains not printable characters */
        final /* synthetic */ rU f9691;

        If(rU rUVar, boolean z) {
            this.f9691 = rUVar;
            this.f9690 = z;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            C1283.m16854("TrailersFeedActivity", "onWindowFocusChanged " + this.f9690);
            rR r0 = this.f9691.m10186();
            if (r0 != null) {
                r0.m10168(this.f9690);
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        Completable.complete().delay(100, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).doOnComplete(new If(this, z)).subscribe();
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractActivityC0360
    /* renamed from: ˊ  reason: contains not printable characters */
    public int mo10187() {
        return R.layout.base_tabs_activity;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractActivityC0360
    /* renamed from: ॱ  reason: contains not printable characters */
    public Fragment mo10189() {
        return new rR();
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public UIScreen getUiScreen() {
        return UIScreen.trailersFeed;
    }

    @Override // o.AbstractActivityC0360, o.AbstractC0459
    public boolean isLoadingData() {
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public boolean shouldAttachToolbar() {
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractActivityC0360
    /* renamed from: ˎ  reason: contains not printable characters */
    public boolean mo10188() {
        return false;
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public boolean shouldApplyPaddingToSlidingPanel() {
        return false;
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public boolean hasBottomNavBar() {
        return true;
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public void performUpAction() {
        rR r1 = m10186();
        if (!(r1 instanceof rR) || !r1.m10167()) {
            super.performUpAction();
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public boolean canApplyBrowseExperience() {
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public boolean handleBackPressed() {
        rR r1 = m10186();
        if (r1 instanceof rR) {
            return r1.m10169();
        }
        return super.handleBackPressed();
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity, android.support.v7.app.AppCompatActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        C1457Fr.m5025(keyEvent, "event");
        rR r1 = m10186();
        if (r1 != null) {
            switch (keyEvent.getKeyCode()) {
                case 24:
                case 25:
                    r1.m10171();
                    break;
            }
        }
        return super.dispatchKeyEvent(keyEvent);
    }
}
