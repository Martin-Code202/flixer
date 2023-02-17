package o;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.View;
/* renamed from: o.tr  reason: case insensitive filesystem */
public class C2188tr extends AbstractC0517 {

    /* renamed from: ˏ  reason: contains not printable characters */
    protected AbstractC2192tv f10615;

    /* renamed from: ᐝ  reason: contains not printable characters */
    protected Context f10616;

    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        m11250(context);
    }

    @Override // o.AbstractC0517, android.support.v4.app.Fragment
    @TargetApi(22)
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (Build.VERSION.SDK_INT < 23) {
            m11250(activity);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ */
    public void mo11236(View view) {
    }

    @Override // o.AbstractC0459
    public boolean isLoadingData() {
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱ  reason: contains not printable characters */
    public void m11250(Context context) {
        this.f10616 = context;
        if (context instanceof AbstractC2192tv) {
            this.f10615 = (AbstractC2192tv) context;
            return;
        }
        throw new RuntimeException(context.toString() + " must implement LoginFragmentListener");
    }
}
