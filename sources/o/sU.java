package o;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.model.leafs.social.multititle.NotificationLandingPage;
import kotlin.TypeCastException;
import org.json.JSONObject;
public final class sU extends sR {

    /* renamed from: ˏ  reason: contains not printable characters */
    public static final If f10118 = new If(null);

    public static final class If {
        private If() {
        }

        public /* synthetic */ If(C1456Fq fq) {
            this();
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        public final Intent m10679(NetflixActivity netflixActivity, NotificationLandingPage notificationLandingPage) {
            C1457Fr.m5025(netflixActivity, "activity");
            C1457Fr.m5025(notificationLandingPage, "landingPage");
            Intent intent = new Intent(netflixActivity, sU.class);
            intent.putExtra("landingPage", notificationLandingPage);
            return intent;
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Window window = getWindow();
        C1457Fr.m5016((Object) window, "window");
        View decorView = window.getDecorView();
        C1457Fr.m5016((Object) decorView, "view");
        ViewGroup.LayoutParams layoutParams = decorView.getLayoutParams();
        if (layoutParams == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.view.WindowManager.LayoutParams");
        }
        WindowManager.LayoutParams layoutParams2 = (WindowManager.LayoutParams) layoutParams;
        layoutParams2.gravity = 17;
        layoutParams2.dimAmount = 0.85f;
        layoutParams2.flags = 2;
    }

    /* access modifiers changed from: protected */
    @Override // o.sR, o.AbstractActivityC0360
    /* renamed from: ॱ */
    public Fragment mo10189() {
        return new sZ();
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public void initToolbar() {
    }

    /* renamed from: o.sU$ˊ  reason: contains not printable characters */
    static final class C0193 implements AbstractC0574 {

        /* renamed from: ˊ  reason: contains not printable characters */
        public static final C0193 f10119 = new C0193();

        C0193() {
        }

        @Override // o.AbstractC0503
        public final JSONObject toJSONObject() {
            return new JSONObject().put("actionType", "dismiss");
        }
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        C1457Fr.m5025(motionEvent, "event");
        if (motionEvent.getAction() != 0) {
            return super.onTouchEvent(motionEvent);
        }
        super.m10659(C0193.f10119);
        finish();
        return true;
    }
}
