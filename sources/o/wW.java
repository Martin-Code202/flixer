package o;

import android.app.Activity;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.TextView;
import com.netflix.mediaclient.util.ViewUtils;
public abstract class wW {

    /* renamed from: ʾ  reason: contains not printable characters */
    protected int f11548;

    /* renamed from: ˊˊ  reason: contains not printable characters */
    protected Activity f11549;

    public wW(Activity activity) {
        this.f11548 = activity.getResources().getColor(17170445);
        this.f11549 = activity;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊ  reason: contains not printable characters */
    public void m12382(View view, boolean z) {
        if (ViewUtils.m3023(view)) {
            view.setEnabled(z);
            if (z) {
                view.clearAnimation();
            } else {
                m12381(view);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˎ  reason: contains not printable characters */
    public void m12384(MenuItem menuItem, boolean z) {
        if (menuItem != null) {
            menuItem.setEnabled(z);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊ  reason: contains not printable characters */
    public void m12381(View view) {
        m12385(view, 0.3f, 0.3f);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱ  reason: contains not printable characters */
    public void m12385(View view, float f, float f2) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(f, f2);
        alphaAnimation.setFillAfter(true);
        view.startAnimation(alphaAnimation);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊ  reason: contains not printable characters */
    public void m12383(String str, TextView textView, String str2, String str3) {
        if (textView != null) {
            textView.setText(str3);
        } else {
            C1283.m16865(str, "View is null!");
        }
    }
}
