package o;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.netflix.mediaclient.R;
/* renamed from: o.qz  reason: case insensitive filesystem */
public abstract class AbstractC2106qz extends AbstractC0496 {
    /* renamed from: ʼ  reason: contains not printable characters */
    public void mo10128() {
    }

    @Override // o.AbstractC0496, android.support.v4.app.Fragment
    public void onViewCreated(final View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        view.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: o.qz.1
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                AbstractC2106qz.this.m10127(view);
                return true;
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˏ  reason: contains not printable characters */
    private void m10127(View view) {
        if (!(getDialog().getWindow() == null || getDialog().getWindow().getDecorView() == null)) {
            getDialog().getWindow().getDecorView().setLayoutParams(new WindowManager.LayoutParams(-1, -1));
            WindowManager.LayoutParams attributes = getDialog().getWindow().getAttributes();
            attributes.width = -1;
            attributes.height = -1;
            attributes.x = 0;
            attributes.y = 0;
            attributes.gravity = 17;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) (((float) AD.m3317(getActivity())) * getResources().getFraction(R.fraction.tutorial_dialog_screen_width_ratio, 1, 1)), -2);
        layoutParams.gravity = 17;
        view.setLayoutParams(layoutParams);
    }

    @Override // o.AbstractC0496, android.support.v4.app.DialogFragment
    public void dismiss() {
        super.dismiss();
        mo10128();
    }

    @Override // android.support.v4.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        super.onCancel(dialogInterface);
        mo10128();
    }
}
