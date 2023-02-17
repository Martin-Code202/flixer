package o;

import android.content.Context;
import android.view.View;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.api.res.AssetType;
import com.netflix.mediaclient.ui.experience.BrowseExperience;
public class qZ extends C2113rb {
    public qZ(Context context, int i) {
        super(context, i);
    }

    /* access modifiers changed from: protected */
    @Override // o.qO
    /* renamed from: ˋ */
    public void mo9936() {
        this.f9818 = (C0522) findViewById(R.id.episode_image);
        View findViewById = findViewById(R.id.episode_image_container);
        int i = getResources().getDisplayMetrics().widthPixels / 3;
        findViewById.getLayoutParams().width = i;
        findViewById.getLayoutParams().height = (int) (((float) i) * 0.5625f);
        findViewById.requestLayout();
        super.mo9936();
    }

    @Override // o.qO, android.widget.Checkable
    public void setChecked(boolean z) {
        this.f9526 = true;
        if (this.f9532 != null) {
            this.f9532.setVisibility(0);
        }
        mo9944();
    }

    /* access modifiers changed from: protected */
    @Override // android.view.View, android.view.ViewGroup
    public void dispatchSetPressed(boolean z) {
    }

    /* access modifiers changed from: protected */
    @Override // o.qO
    /* renamed from: ॱ */
    public CharSequence mo9943(pI pIVar) {
        if (pIVar.isNSRE() || pIVar.isEpisodeNumberHidden()) {
            return pIVar.getTitle();
        }
        return getContext().getString(R.string.label_episode_number_title, Integer.valueOf(pIVar.getEpisodeNumber()), pIVar.getTitle());
    }

    @Override // o.C2113rb
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo10086(pI pIVar, pR pRVar) {
        super.mo10086(pIVar, pRVar);
        if (this.f9531 != null) {
            this.f9531.setVisibility(8);
        }
        if (this.f9527 != null) {
            this.f9527.setText(mo9943(pIVar));
        }
        if (this.f9818 != null) {
            NetflixActivity.getImageLoader(getContext()).mo3063(this.f9818, pIVar.createModifiedSmallStillUrl(), AssetType.bif, m9931(pIVar, getContext()), BrowseExperience.m1769(), true, 1);
        }
    }
}
