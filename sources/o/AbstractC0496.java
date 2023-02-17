package o;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.transition.Transition;
import android.support.v4.app.DialogFragment;
import android.view.View;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.app.Status;
import o.AbstractC0459;
import o.C1348Bu;
/* renamed from: o.л  reason: contains not printable characters */
public abstract class AbstractC0496 extends DialogFragment implements AbstractC0459, oV {

    /* renamed from: ʼ  reason: contains not printable characters */
    private boolean f13609;

    /* renamed from: ˊ  reason: contains not printable characters */
    protected int f13610;

    /* renamed from: ˋ  reason: contains not printable characters */
    protected int f13611;

    /* renamed from: ˎ  reason: contains not printable characters */
    protected AbstractC0459.AbstractC0460 f13612;

    /* renamed from: ˏ  reason: contains not printable characters */
    private boolean f13613;

    /* renamed from: ॱ  reason: contains not printable characters */
    protected int f13614;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private int f13615;

    /* renamed from: o.л$iF */
    public interface iF {
        /* renamed from: ˋ */
        void mo2537(AbstractC0496 v);
    }

    /* renamed from: o.л$if  reason: invalid class name */
    public interface Cif {
        @Override // com.netflix.mediaclient.ui.player.IPlayerFragment
        iF ab_();
    }

    @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        mo10377(view);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m14471(int i) {
        this.f13615 = i;
    }

    @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        boolean showsDialog = getShowsDialog();
        if (getDialog() == null) {
            C1283.m16865("NetflixDialogFrag", getClass().getSimpleName() + ": Dialog is null upon activity creation! Setting shows dialog to false.");
            setShowsDialog(false);
        } else {
            getDialog().getWindow().getDecorView().setSystemUiVisibility(this.f13615);
        }
        super.onActivityCreated(bundle);
        setShowsDialog(showsDialog);
        C1348Bu.If.m4100(new Runnable() { // from class: o.л.1
            @Override // java.lang.Runnable
            public void run() {
                if (AbstractC0496.this.getDialog() != null) {
                    AbstractC0496.this.getDialog().getWindow().clearFlags(8);
                }
            }
        }, 1);
    }

    @Override // o.oV
    public void onManagerReady(C2059ph phVar, Status status) {
    }

    @Override // o.oV
    public void onManagerUnavailable(C2059ph phVar, Status status) {
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public C2059ph m14474() {
        return C2059ph.m9741(m14476());
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f13613 = true;
    }

    @Override // o.AbstractC0459
    public void setLoadingStatusCallback(AbstractC0459.AbstractC0460 r2) {
        if (isLoadingData() || r2 == null) {
            this.f13612 = r2;
        } else {
            r2.mo1654(AbstractC0367.f13235);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱ */
    public void mo10398(Status status) {
        if (this.f13612 != null) {
            this.f13612.mo1654(status);
        }
    }

    @Override // android.support.v4.app.DialogFragment
    public void dismiss() {
        try {
            super.dismiss();
        } catch (IllegalStateException e) {
            C1283.m16848("NetflixDialogFrag", "Error dismissing dialog", e);
            C1276.m16820().mo5729("Error dismissing dialog", e);
        }
    }

    @Override // o.AbstractC0459
    public boolean isLoadingData() {
        return false;
    }

    @Override // android.support.v4.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        try {
            super.onDismiss(dialogInterface);
            C1283.m16854("NetflixDialogFrag", "NetflixDialogFrag is dismissed");
        } catch (IllegalStateException e) {
            C1283.m16848("NetflixDialogFrag", "Error dismissing dialog", e);
            C1276.m16820().mo5729("Error dismissing dialog", e);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱ  reason: contains not printable characters */
    public NetflixActivity m14476() {
        return (NetflixActivity) getActivity();
    }

    @Override // android.support.v4.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        onCreateDialog.getWindow().addFlags(8);
        return onCreateDialog;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m14475(int i, int i2, int i3) {
        this.f13610 = i;
        this.f13614 = i2;
        this.f13611 = i3;
        m14469();
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    private void m14469() {
        View view = getView();
        if (view != null) {
            mo10377(view);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊ */
    public void mo10377(View view) {
    }

    /* access modifiers changed from: protected */
    public void S_() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊ  reason: contains not printable characters */
    public boolean m14472() {
        return this.f13609;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˎ  reason: contains not printable characters */
    public void m14473() {
        S_();
    }

    @Override // android.support.v4.app.Fragment
    public void setEnterTransition(Object obj) {
        super.setEnterTransition(obj);
        if (obj instanceof Transition) {
            ((Transition) obj).addListener(new BB() { // from class: o.л.2
                @Override // o.BB, android.support.transition.Transition.TransitionListener
                public void onTransitionStart(Transition transition) {
                    AbstractC0496.this.f13609 = true;
                }

                @Override // o.BB, android.support.transition.Transition.TransitionListener
                public void onTransitionEnd(Transition transition) {
                    AbstractC0496.this.f13609 = false;
                    AbstractC0496.this.m14473();
                }
            });
        }
    }
}
