package o;

import android.app.Activity;
import android.os.Bundle;
import android.support.transition.Transition;
import android.support.v4.app.Fragment;
import android.view.View;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.app.Status;
import o.AbstractC0459;
/* renamed from: o.ҫ  reason: contains not printable characters */
public abstract class AbstractC0517 extends Fragment implements AbstractC0459, oV, AbstractC2168sz {

    /* renamed from: ˊ  reason: contains not printable characters */
    protected int f13649;

    /* renamed from: ˋ  reason: contains not printable characters */
    protected int f13650;

    /* renamed from: ˎ  reason: contains not printable characters */
    protected int f13651;

    /* renamed from: ˏ  reason: contains not printable characters */
    private boolean f13652;

    /* renamed from: ॱ  reason: contains not printable characters */
    protected AbstractC0459.AbstractC0460 f13653;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private boolean f13654;

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        mo2213(view);
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (bundle != null && bundle.getBoolean("NetflixFragHidden") && getFragmentManager() != null) {
            getFragmentManager().beginTransaction().hide(this).commitAllowingStateLoss();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("NetflixFragHidden", isHidden());
    }

    @Override // o.oV
    public void onManagerReady(C2059ph phVar, Status status) {
    }

    @Override // o.oV
    public void onManagerUnavailable(C2059ph phVar, Status status) {
    }

    @Override // o.AbstractC2168sz
    public void a_(Status status) {
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f13652 = true;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public NetflixActivity m14534() {
        return (NetflixActivity) getActivity();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public C2059ph m14536() {
        return C2059ph.m9741(m14534());
    }

    /* access modifiers changed from: protected */
    public boolean T_() {
        return this.f13652;
    }

    @Override // o.AbstractC0459
    public void setLoadingStatusCallback(AbstractC0459.AbstractC0460 r2) {
        if (isLoadingData() || r2 == null) {
            this.f13653 = r2;
        } else {
            r2.mo1654(AbstractC0367.f13235);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˎ */
    public void mo9990(Status status) {
        if (this.f13653 != null) {
            this.f13653.mo1654(status);
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public boolean m14535() {
        return isAdded() && !C1317As.m3750(getActivity());
    }

    public boolean af_() {
        return false;
    }

    @Override // android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        C1283.m16854("NetflixFrag", "onHiddenChanged: " + z);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m14533(int i, int i2, int i3) {
        this.f13651 = i;
        this.f13649 = i2;
        this.f13650 = i3;
        m14532();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m14532() {
        View view = getView();
        if (view != null) {
            mo2213(view);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊ */
    public void mo2213(View view) {
    }

    /* access modifiers changed from: protected */
    public void ag_() {
    }

    /* access modifiers changed from: protected */
    public boolean ah_() {
        return this.f13654;
    }

    /* access modifiers changed from: protected */
    public void Z_() {
        ag_();
    }

    @Override // android.support.v4.app.Fragment
    public void setEnterTransition(Object obj) {
        super.setEnterTransition(obj);
        if (obj instanceof Transition) {
            ((Transition) obj).addListener(new BB() { // from class: o.ҫ.3
                @Override // o.BB, android.support.transition.Transition.TransitionListener
                public void onTransitionStart(Transition transition) {
                    AbstractC0517.this.f13654 = true;
                }

                @Override // o.BB, android.support.transition.Transition.TransitionListener
                public void onTransitionEnd(Transition transition) {
                    AbstractC0517.this.f13654 = false;
                    AbstractC0517.this.Z_();
                }
            });
        }
    }

    @Override // android.support.v4.app.Fragment, java.lang.Object
    public String toString() {
        return getClass().getSimpleName() + "(" + Integer.toHexString(System.identityHashCode(getClass())) + ")";
    }
}
