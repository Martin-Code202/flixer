package o;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.FrameLayout;
import com.netflix.mediaclient.R;
import java.util.HashMap;
public final class sZ extends sV {

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public static final C0195 f10129 = new C0195(null);

    /* renamed from: ᐝ  reason: contains not printable characters */
    private HashMap f10130;

    @Override // o.sV, android.support.v4.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        mo10687();
    }

    @Override // o.sV
    /* renamed from: ˊ */
    public View mo10682(int i) {
        if (this.f10130 == null) {
            this.f10130 = new HashMap();
        }
        View view = (View) this.f10130.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i);
        this.f10130.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    @Override // o.sV
    /* renamed from: ˏॱ */
    public void mo10687() {
        if (this.f10130 != null) {
            this.f10130.clear();
        }
    }

    /* renamed from: o.sZ$ˋ  reason: contains not printable characters */
    public static final class C0195 {
        private C0195() {
        }

        public /* synthetic */ C0195(C1456Fq fq) {
            this();
        }
    }

    @Override // o.sV
    /* renamed from: ॱ */
    public sQ mo10688(int i, int i2) {
        return new sY(i, i2);
    }

    @Override // o.sV
    /* renamed from: ˏ */
    public boolean mo10686() {
        return false;
    }

    @Override // o.sV
    /* renamed from: ˊॱ */
    public void mo10684() {
        super.mo10684();
        m10691();
    }

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private final void m10691() {
        FrameLayout frameLayout;
        FragmentActivity activity = getActivity();
        if (activity != null && (frameLayout = (FrameLayout) activity.findViewById(R.id.multi_title_notifications_container)) != null) {
            frameLayout.getLayoutParams().width = (int) (((double) frameLayout.getMeasuredWidth()) / 1.3d);
        }
    }
}
