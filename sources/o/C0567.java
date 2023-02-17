package o;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.ui.experience.BrowseExperience;
import com.netflix.mediaclient.util.ViewUtils;
/* renamed from: o.צ  reason: contains not printable characters */
public class C0567 {

    /* renamed from: ʻ  reason: contains not printable characters */
    private boolean f13824 = true;

    /* renamed from: ʽ  reason: contains not printable characters */
    private final View.OnClickListener f13825 = new View.OnClickListener() { // from class: o.צ.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C1283.m16846("ErrorWrapper", "Retry requested");
            if (C0567.this.f13830 != null) {
                C0567.this.f13830.N_();
            }
        }
    };

    /* renamed from: ˊ  reason: contains not printable characters */
    private final View f13826;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final C0754 f13827;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final TextView f13828;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final C0754 f13829;

    /* renamed from: ॱ  reason: contains not printable characters */
    private Cif f13830;

    /* renamed from: o.צ$if  reason: invalid class name */
    public interface Cif {
        void N_();
    }

    public C0567(View view, Cif ifVar) {
        this.f13830 = ifVar;
        this.f13826 = view.findViewById(R.id.error_view);
        this.f13826.setVisibility(0);
        this.f13828 = (TextView) view.findViewById(R.id.error_view_label);
        this.f13827 = (C0754) this.f13826.findViewById(R.id.error_view_retry_button);
        this.f13827.setOnClickListener(this.f13825);
        this.f13829 = (C0754) this.f13826.findViewById(R.id.error_view_all_downloads_button);
        if (this.f13829 != null) {
            this.f13829.setOnClickListener(new View.OnClickListener() { // from class: o.צ.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    NetflixActivity netflixActivity = (NetflixActivity) C1317As.m3755(view2.getContext(), NetflixActivity.class);
                    if (!C1317As.m3750(netflixActivity)) {
                        netflixActivity.startActivity(vH.m11936(netflixActivity));
                    }
                }
            });
        }
        NetflixActivity netflixActivity = (NetflixActivity) C1317As.m3755(view.getContext(), NetflixActivity.class);
        if (netflixActivity != null && BrowseExperience.m1780()) {
            m14656(netflixActivity);
        }
        m14658();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m14656(NetflixActivity netflixActivity) {
        Resources resources = netflixActivity.getResources();
        this.f13828.setTextColor(resources.getColor(R.color.dark_grey));
        ViewUtils.m3012(this.f13828, (int) R.dimen.text_small);
        ViewUtils.m3011(this.f13828);
        this.f13827.m15172(R.style.res_2131951864_netflixbutton_kids);
        this.f13827.getLayoutParams().height = resources.getDimensionPixelOffset(R.dimen.kids_btn_height);
        this.f13827.setAllCaps(false);
        ViewUtils.m3012(this.f13827, (int) R.dimen.text_medium);
        Drawable drawable = resources.getDrawable(R.drawable.ic_icn_kids_retry);
        int r6 = C1004.m15954(netflixActivity, 32);
        int r7 = C1004.m15954(netflixActivity, 8);
        drawable.setBounds(r7, 0, r6 + r7, r6);
        this.f13827.setCompoundDrawables(null, null, drawable, null);
        this.f13827.setCompoundDrawablePadding(C1004.m15954(netflixActivity, 8));
        this.f13829.m15172(R.style.res_2131951864_netflixbutton_kids);
        this.f13829.getLayoutParams().height = resources.getDimensionPixelOffset(R.dimen.kids_btn_height);
        this.f13829.setAllCaps(false);
        this.f13829.setText(R.string.offline_action_view_my_downloads);
        ViewUtils.m3012(this.f13829, (int) R.dimen.text_medium);
        this.f13826.setBackgroundColor(-1);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo14663(boolean z) {
        BQ.m3909(this.f13826, z);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo14660(boolean z) {
        BQ.m3914(this.f13826, z);
        m14658();
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo14662(int i, boolean z, boolean z2) {
        this.f13828.setText(i);
        this.f13824 = z;
        BQ.m3914(this.f13826, z2);
        m14658();
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m14661() {
        if (this.f13829 != null) {
            this.f13829.setVisibility(0);
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m14658() {
        this.f13827.setVisibility((this.f13830 == null || !this.f13824) ? 8 : 0);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public View m14664() {
        return this.f13827;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo14659(int i, int i2, int i3, int i4) {
        if (this.f13826 != null) {
            this.f13826.setPadding(i, i2, i3, i4);
        }
    }
}
