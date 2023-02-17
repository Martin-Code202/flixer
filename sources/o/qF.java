package o;

import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.media.Language;
import o.qI;
/* access modifiers changed from: package-private */
public class qF extends qI {
    public qF(NetflixActivity netflixActivity, qI.AbstractC0168 r2) {
        super(netflixActivity, r2);
    }

    /* access modifiers changed from: protected */
    @Override // o.qI
    /* renamed from: ˏ */
    public int mo9877() {
        int i;
        C1283.m16854("nf_language_selector", "Tablet calculate height");
        int dimension = (int) this.f9448.getResources().getDimension(R.dimen.language_selector_list_minheight);
        int dimension2 = (int) this.f9448.getResources().getDimension(R.dimen.language_selector_list_maxheight);
        int dimension3 = (int) this.f9448.getResources().getDimension(R.dimen.language_selector_row_height);
        Language r6 = m9895();
        if (r6 == null) {
            i = 0;
        } else {
            i = Math.max(r6.getAltAudios().length, r6.getSubtitles().length + 1) * dimension3;
        }
        if (i <= dimension) {
            return dimension;
        }
        return i < dimension2 ? i : dimension2;
    }

    /* access modifiers changed from: protected */
    @Override // o.qI
    /* renamed from: ॱ */
    public int mo9879() {
        C1283.m16854("nf_language_selector", "R.layout.language_selector_tablet_dialog");
        return R.layout.language_selector_tablet_dialog;
    }
}
