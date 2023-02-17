package o;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.Window;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.util.log.UIScreen;
public final class yY extends AbstractActivityC0360 {

    /* renamed from: ॱ  reason: contains not printable characters */
    public static final C0308 f12480 = new C0308(null);

    /* renamed from: o.yY$ˊ  reason: contains not printable characters */
    public static final class C0308 {
        private C0308() {
        }

        public /* synthetic */ C0308(C1456Fq fq) {
            this();
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractActivityC0360
    /* renamed from: ॱ */
    public Fragment mo10189() {
        return new C2365za();
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public UIScreen getUiScreen() {
        return UIScreen.previews;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractActivityC0360, com.netflix.mediaclient.android.activity.NetflixActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m13310();
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        m13310();
    }

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private final void m13310() {
        Window window = getWindow();
        C1457Fr.m5016((Object) window, "window");
        View decorView = window.getDecorView();
        C1457Fr.m5016((Object) decorView, "window.decorView");
        decorView.setSystemUiVisibility(4612);
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        android.support.v7.app.ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.hide();
        }
        getWindow().setFlags(512, 512);
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractActivityC0360
    /* renamed from: ˊ */
    public int mo10187() {
        return R.layout.base_fullscreen_activity;
    }
}
