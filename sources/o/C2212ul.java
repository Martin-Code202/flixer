package o;

import android.os.Parcelable;
import android.view.View;
import android.widget.TextView;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.util.ViewUtils;
import o.AbstractC2214un;
/* renamed from: o.ul  reason: case insensitive filesystem */
public class C2212ul extends AbstractC2214un {

    /* renamed from: ॱ  reason: contains not printable characters */
    private final TextView f10999;

    public C2212ul(View view, AbstractC0954 r4, AbstractC2214un.Cif ifVar) {
        super(view, r4, R.id.lolomo_row, ifVar);
        this.f10999 = (TextView) view.findViewById(R.id.lomo_title);
        if (r4.mo15089()) {
            ViewUtils.m3022(this.f10999, (int) R.color.kids_text_color);
            ViewUtils.m3012(this.f10999, (int) R.dimen.text_small_medium);
            ViewUtils.m3011(this.f10999);
        }
    }

    @Override // o.AbstractC2214un
    /* renamed from: ˋ */
    public void mo11706(pC pCVar) {
        super.mo11706(pCVar);
        this.f10999.setText(pCVar.getTitle());
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m11712(pC pCVar, AbstractC0837 r4, Parcelable parcelable) {
        m15477(pCVar, r4, parcelable);
        if (r4.getItemCount() != 0 || !r4.mo10904()) {
            this.f10999.setVisibility(0);
        } else {
            this.f10999.setVisibility(8);
        }
    }
}
