package o;

import android.content.ComponentName;
import android.content.Intent;
import android.support.v4.app.Fragment;
import com.netflix.cl.model.AppView;
import com.netflix.mediaclient.util.log.UIScreen;
/* renamed from: o.sh  reason: case insensitive filesystem */
public final class C2148sh implements AbstractC2141sc {
    @Override // o.AbstractC2141sc
    /* renamed from: ॱ */
    public boolean mo10080(Intent intent) {
        C1457Fr.m5025(intent, "intent");
        ComponentName component = intent.getComponent();
        return C1457Fr.m5018((Object) (component != null ? component.getClassName() : null), (Object) ActivityC2150sj.f10162.m10742().getCanonicalName());
    }

    @Override // o.AbstractC2141sc
    /* renamed from: ˋ */
    public AbstractC0517 mo10061(Intent intent) {
        C1457Fr.m5025(intent, "intent");
        return new C2145sg();
    }

    @Override // o.AbstractC2141sc
    /* renamed from: ʽ */
    public AppView mo10051(Intent intent) {
        C1457Fr.m5025(intent, "intent");
        return AppView.viewingActivity;
    }

    @Override // o.AbstractC2141sc
    /* renamed from: ᐝ */
    public UIScreen mo10083() {
        return UIScreen.watchHistory;
    }

    @Override // o.AbstractC2141sc
    /* renamed from: ʻ */
    public AbstractC0574 mo10050(Intent intent) {
        C1457Fr.m5025(intent, "intent");
        return null;
    }

    @Override // o.AbstractC2141sc
    /* renamed from: ˊ */
    public void mo10055(Intent intent, AbstractC0517 r3, boolean z) {
        C1457Fr.m5025(intent, "intent");
        C1457Fr.m5025(r3, "fragment");
    }

    @Override // o.AbstractC2141sc
    /* renamed from: ˋ */
    public void mo10062(Intent intent, AbstractC0517 r3, boolean z) {
        C1457Fr.m5025(intent, "intent");
        C1457Fr.m5025(r3, "fragment");
    }

    @Override // o.AbstractC2141sc
    /* renamed from: ˏ */
    public boolean mo10075(Intent intent) {
        C1457Fr.m5025(intent, "intent");
        return false;
    }

    @Override // o.AbstractC2141sc
    /* renamed from: ˏ */
    public boolean mo10074() {
        return false;
    }

    @Override // o.AbstractC2141sc
    /* renamed from: ˏ */
    public void mo10069(Intent intent, Fragment fragment) {
        C1457Fr.m5025(intent, "intent");
        C1457Fr.m5025(fragment, "fragment");
    }

    @Override // o.AbstractC2141sc
    /* renamed from: ˎ */
    public void mo10066(Intent intent, Fragment fragment) {
        C1457Fr.m5025(intent, "intent");
        C1457Fr.m5025(fragment, "fragment");
    }
}
