package o;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.LinearLayout;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.service.webclient.model.leafs.UmaAlert;
import java.util.HashMap;
import kotlin.TypeCastException;
public final class zW extends AbstractC0496 {

    /* renamed from: ʼ  reason: contains not printable characters */
    private static final String f12753 = f12753;

    /* renamed from: ˏ  reason: contains not printable characters */
    public static final If f12754 = new If(null);

    /* renamed from: ʻ  reason: contains not printable characters */
    private C1301Ad f12755;

    /* renamed from: ʽ  reason: contains not printable characters */
    private DialogInterface f12756;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private UmaAlert f12757;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private HashMap f12758;

    /* renamed from: ᐝ  reason: contains not printable characters */
    public void m13574() {
        if (this.f12758 != null) {
            this.f12758.clear();
        }
    }

    public static final class If {
        private If() {
        }

        public /* synthetic */ If(C1456Fq fq) {
            this();
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public final zW m13575(Context context, UmaAlert umaAlert) {
            C1457Fr.m5025(context, "context");
            C1457Fr.m5025(umaAlert, "umaAlert");
            zW zWVar = new zW();
            C1276.m16820().mo5728("Uma Modal fragment created");
            zWVar.f12757 = umaAlert;
            zWVar.m13572(new C1301Ad(context, false));
            C1301Ad r0 = zWVar.m13573();
            if (r0 != null) {
                r0.m3566(umaAlert, zWVar);
            }
            return zWVar;
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public final void m13572(C1301Ad ad) {
        this.f12755 = ad;
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public final C1301Ad m13573() {
        return this.f12755;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public final void m13570(DialogInterface dialogInterface) {
        this.f12756 = dialogInterface;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public final void m13571(UmaAlert umaAlert) {
        C1457Fr.m5025(umaAlert, "umaAlert");
        this.f12757 = umaAlert;
        C1301Ad ad = this.f12755;
        if (ad != null) {
            ad.m3572(umaAlert);
        }
        setCancelable(!umaAlert.blocking());
    }

    @Override // o.AbstractC0496, android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        C1457Fr.m5025(layoutInflater, "inflater");
        super.onCreateView(layoutInflater, viewGroup, bundle);
        if (this.f12755 == null) {
            C1276.m16820().mo5727("umaView=null for Uma Modal");
            return null;
        }
        C1276.m16820().mo5728("Uma Modal onCreateView");
        View inflate = layoutInflater.inflate(R.layout.uma_dialog_frag, viewGroup, false);
        if (inflate == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.view.View");
        }
        View findViewById = inflate.findViewById(R.id.uma_fragment_container);
        if (findViewById == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.widget.LinearLayout");
        }
        ((LinearLayout) findViewById).addView(this.f12755);
        UmaAlert umaAlert = this.f12757;
        if (umaAlert != null) {
            setCancelable(!umaAlert.blocking());
        }
        return inflate;
    }

    @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        C1301Ad ad = this.f12755;
        ViewParent parent = ad != null ? ad.getParent() : null;
        if (!(parent instanceof ViewGroup)) {
            parent = null;
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        if (viewGroup != null) {
            viewGroup.removeView(this.f12755);
        }
        C1276.m16820().mo5728("Uma Modal onDestroyView");
        m13574();
    }

    @Override // o.AbstractC0496, android.support.v4.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        C1276.m16820().mo5728("Uma Modal dismissed");
        C1301Ad ad = this.f12755;
        if (ad != null) {
            ad.m3571();
        }
        DialogInterface dialogInterface2 = this.f12756;
        if (dialogInterface2 != null) {
            dialogInterface2.dismiss();
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public final void m13569(NetflixActivity netflixActivity) {
        if (netflixActivity != null && !C1317As.m3750(netflixActivity)) {
            netflixActivity.showDialog(this);
            C1276.m16820().mo5728("Uma Modal displayed");
            C1301Ad ad = this.f12755;
            if (ad != null) {
                ad.m3569();
            }
        }
    }

    @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.uma_dialog_frag_max_width);
            if (AD.m3319(getContext()) > dimensionPixelSize) {
                window.setLayout(dimensionPixelSize, -2);
            } else {
                window.setLayout(-1, -2);
            }
            window.setGravity(17);
        }
    }
}
