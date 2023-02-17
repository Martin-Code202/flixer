package o;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;
import android.widget.TextView;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.media.Language;
import o.qI;
public final class qE extends qI implements TabHost.OnTabChangeListener {

    /* renamed from: ʻ  reason: contains not printable characters */
    protected TextView f9428;

    /* renamed from: ʽ  reason: contains not printable characters */
    protected TabHost f9429;

    /* renamed from: ᐝ  reason: contains not printable characters */
    protected TextView f9430;

    public qE(NetflixActivity netflixActivity, qI.AbstractC0168 r2) {
        super(netflixActivity, r2);
    }

    @Override // android.widget.TabHost.OnTabChangeListener
    public void onTabChanged(String str) {
        if ("ListAudios".equals(str)) {
            if (this.f9430 != null) {
                this.f9430.setTypeface(this.f9430.getTypeface(), 1);
            } else {
                C1283.m16854("nf_language_selector", "audio label is NULL!");
            }
            if (this.f9428 != null) {
                this.f9428.setTypeface(this.f9428.getTypeface(), 0);
            } else {
                C1283.m16854("nf_language_selector", "subtitle label is NULL!");
            }
        } else {
            if (this.f9430 != null) {
                this.f9430.setTypeface(this.f9430.getTypeface(), 0);
            } else {
                C1283.m16854("nf_language_selector", "audio label is NULL!");
            }
            if (this.f9428 != null) {
                this.f9428.setTypeface(this.f9428.getTypeface(), 1);
            } else {
                C1283.m16854("nf_language_selector", "subtitle label is NULL!");
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.qI
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo9878(View view, Language language) {
        super.mo9878(view, language);
        C1283.m16854("nf_language_selector", "Add tabhost");
        this.f9429 = (TabHost) view.findViewById(R.id.tabHost);
        this.f9429.setOnTabChangedListener(this);
        this.f9429.setup();
        m9875(this.f9448, this.f9429, "ListAudios", R.string.label_audio_all_caps, R.id.audios, true);
        m9875(this.f9448, this.f9429, "ListSubtitles", R.string.label_subtitle_all_caps, R.id.subtitles, false);
        this.f9429.setCurrentTab(0);
        this.f9430.setTypeface(this.f9430.getTypeface(), 1);
        this.f9428.setTypeface(this.f9428.getTypeface(), 0);
        C1283.m16854("nf_language_selector", "Done with tabhost");
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private int m9874() {
        Language r2 = m9895();
        if (r2 == null) {
            return 0;
        }
        int length = (r2.getSubtitles() == null ? 0 : r2.getSubtitles().length) + 1;
        if (r2.getAltAudios() == null) {
            if (r2.getSubtitles() == null) {
                return 0;
            }
            return length;
        } else if (r2.getSubtitles() == null) {
            return r2.getAltAudios().length;
        } else {
            C1283.m16854("nf_language_selector", "Calculate maximal item number");
            if (r2.getAltAudios().length >= length) {
                return r2.getAltAudios().length;
            }
            int length2 = r2.getAltAudios().length;
            for (int i = 0; i < r2.getAltAudios().length; i++) {
                int length3 = length - r2.getAltAudios()[i].getDisallowedSubtitles().length;
                if (length3 > length2) {
                    length2 = length3;
                }
            }
            return length2;
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.qI
    /* renamed from: ˏ  reason: contains not printable characters */
    public int mo9877() {
        C1283.m16854("nf_language_selector", "Phone calculate height");
        Resources resources = this.f9448.getResources();
        int dimension = (int) resources.getDimension(R.dimen.language_selector_list_minheight);
        int dimension2 = (int) resources.getDimension(R.dimen.language_selector_list_maxheight);
        int r6 = m9874() * ((int) resources.getDimension(R.dimen.language_selector_row_height));
        if (r6 <= dimension) {
            return dimension;
        }
        if (r6 > dimension2) {
            return dimension2;
        }
        return r6;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m9875(Context context, TabHost tabHost, String str, int i, int i2, boolean z) {
        TabHost.TabSpec newTabSpec = tabHost.newTabSpec(str);
        newTabSpec.setIndicator(m9876(tabHost.getContext(), tabHost, i, z));
        newTabSpec.setContent(i2);
        tabHost.addTab(newTabSpec);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private View m9876(Context context, TabHost tabHost, int i, boolean z) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.language_selector_tab, (ViewGroup) null, false);
        TextView textView = (TextView) inflate.findViewById(R.id.tabLanguageSelectTitle);
        textView.setText(i);
        if (z) {
            C1283.m16854("nf_language_selector", "Set audio tab label");
            this.f9430 = textView;
        } else {
            C1283.m16854("nf_language_selector", "Set subtitle tab label");
            this.f9428 = textView;
        }
        return inflate;
    }

    /* access modifiers changed from: protected */
    @Override // o.qI
    /* renamed from: ॱ  reason: contains not printable characters */
    public int mo9879() {
        C1283.m16854("nf_language_selector", "Phone R.layout.language_selector_dialog");
        return R.layout.language_selector_dialog;
    }
}
