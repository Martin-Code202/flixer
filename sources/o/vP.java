package o;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.netflix.mediaclient.R;
public class vP extends AbstractC2106qz {
    @Override // o.AbstractC2106qz
    /* renamed from: ʼ */
    public void mo10128() {
        if (m14476() != null) {
            m14476().getTutorialHelper().m12057(true);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(getActivity().getResources().getColor(R.color.translucent_black_50)));
        setStyle(0, 16973840);
        View findViewById = getDialog().findViewById(getActivity().getResources().getIdentifier("android:id/titleDivider", null, null));
        if (findViewById != null) {
            findViewById.setBackgroundColor(getResources().getColor(R.color.transparent));
        }
        return new vR(getActivity()).m12034(viewGroup, this);
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public void m12030() {
        if (getActivity() != null) {
            vO.m12014(m14476());
        }
    }
}
