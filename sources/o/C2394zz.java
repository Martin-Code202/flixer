package o;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.netflix.cl.model.AppView;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.api.res.AssetType;
import com.netflix.mediaclient.ui.experience.BrowseExperience;
import com.netflix.mediaclient.ui.search.SearchUtils;
import o.C2387zt;
/* renamed from: o.zz  reason: case insensitive filesystem */
public class C2394zz extends FrameLayout implements qK {

    /* renamed from: ʻ  reason: contains not printable characters */
    private C0522 f13041;

    /* renamed from: ʼ  reason: contains not printable characters */
    private AppView f13042 = AppView.suggestionTitleResults;

    /* renamed from: ʽ  reason: contains not printable characters */
    private int f13043;

    /* renamed from: ˊ  reason: contains not printable characters */
    protected TextView f13044;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private String f13045;

    /* renamed from: ˋ  reason: contains not printable characters */
    protected TextView f13046;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private String f13047;

    /* renamed from: ˎ  reason: contains not printable characters */
    private int f13048 = R.layout.search_result_view;

    /* renamed from: ˏ  reason: contains not printable characters */
    private boolean f13049 = false;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private String f13050;

    /* renamed from: ͺ  reason: contains not printable characters */
    private String f13051;

    /* renamed from: ॱ  reason: contains not printable characters */
    private View$OnClickListenerC1193 f13052;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private oX f13053 = new oB("SearchResultView");

    /* renamed from: ᐝ  reason: contains not printable characters */
    private int f13054;

    /* access modifiers changed from: package-private */
    /* renamed from: o.zz$ˊ  reason: contains not printable characters */
    public class C0341 extends View$OnClickListenerC1193 {
        public C0341(NetflixActivity netflixActivity, qK qKVar) {
            super(netflixActivity, qKVar);
        }

        /* access modifiers changed from: protected */
        @Override // o.View$OnClickListenerC1193
        /* renamed from: ˋ */
        public void mo11180(NetflixActivity netflixActivity, pJ pJVar, oX oXVar) {
            qU.m9974(netflixActivity, pJVar, oXVar, "DeetsClickListener");
            SearchUtils.m2922(pJVar, SearchUtils.SuggestionType.SEARCH_HISTORY, netflixActivity);
        }
    }

    public C2394zz(Context context, int i, oX oXVar, int i2, int i3) {
        super(context);
        this.f13048 = i;
        this.f13053 = oXVar;
        this.f13043 = i2;
        this.f13054 = i3;
        m13885();
    }

    public void setIgnoreClicks() {
        this.f13049 = true;
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private void m13885() {
        NetflixActivity netflixActivity = (NetflixActivity) getContext();
        netflixActivity.getLayoutInflater().inflate(this.f13048, this);
        m13886();
        m13878();
        this.f13052 = new C0341(netflixActivity, this);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public String m13889() {
        return this.f13045;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public String m13891() {
        return this.f13047;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public String m13887() {
        return this.f13051;
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    private void m13878() {
        if (this.f13046 != null) {
            this.f13046.setVisibility(8);
        }
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    private void m13886() {
        this.f13041 = (C0522) findViewById(R.id.search_result_img);
        this.f13044 = (TextView) findViewById(R.id.search_result_title);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m13890(Object obj, oX oXVar, String str, String str2) {
        this.f13053 = oXVar;
        this.f13050 = str2;
        if (obj instanceof AbstractC2084qe) {
            this.f13045 = ((AbstractC2084qe) obj).getId();
            this.f13051 = this.f13045;
            m13880((AbstractC2084qe) obj);
        } else if (obj instanceof AbstractC2083qd) {
            this.f13045 = ((AbstractC2083qd) obj).getTitle();
            this.f13051 = this.f13045;
            this.f13047 = ((AbstractC2083qd) obj).getEntityId();
            m13884((AbstractC2083qd) obj, str);
        } else {
            throw new IllegalStateException("Unknown search result type");
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m13880(AbstractC2084qe qeVar) {
        setContentDescription(qeVar.getTitle());
        setTag("Video");
        this.f13042 = AppView.titleResults;
        if (this.f13044 != null) {
            this.f13044.setVisibility(8);
        }
        if (this.f13041 != null) {
            this.f13041.setVisibility(0);
            NetflixActivity.getImageLoader(getContext()).mo3057(this.f13041, SearchUtils.m2930() ? qeVar.getBoxshotUrl() : qeVar.getHorzDispUrl(), AssetType.boxArt, qeVar.getTitle(), BrowseExperience.m1769(), true);
        }
        this.f13052.m16461(this, qeVar, new C2387zt.C2388iF(this.f13050, null, qeVar.getId(), this.f13053.getTrackId(), this.f13043, this.f13054));
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m13888() {
        if (this.f13044 != null && this.f13051 != null) {
            this.f13044.setText(this.f13051);
            this.f13044.setTypeface(Typeface.DEFAULT);
        }
    }

    @SuppressLint({"DefaultLocale"})
    /* renamed from: ˋ  reason: contains not printable characters */
    private void m13882(String str, String str2) {
        if (this.f13044 != null && str != null && str2 != null) {
            int indexOf = str.toLowerCase().indexOf(str2.toLowerCase());
            if (indexOf < 0) {
                this.f13044.setText(str);
                return;
            }
            int length = indexOf + str2.length();
            if (length > str.length()) {
                length = str.length();
            }
            SpannableString spannableString = new SpannableString(str);
            spannableString.setSpan(new ForegroundColorSpan(m13892()), indexOf, length, 33);
            this.f13044.setText(spannableString);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ॱ  reason: contains not printable characters */
    public int m13892() {
        TypedValue typedValue = new TypedValue();
        this.f13044.getContext().getTheme().resolveAttribute(R.attr.searchTermHighlightTextColor, typedValue, true);
        return typedValue.data;
    }

    public void setTitleTextWithSelectdHighlighting() {
        if (this.f13044 != null && this.f13044.getText() != null) {
            SpannableString spannableString = new SpannableString(this.f13044.getText());
            spannableString.setSpan(new ForegroundColorSpan(m13892()), 0, this.f13044.getText().length(), 33);
            this.f13044.setText(spannableString);
            this.f13044.setTypeface(Typeface.DEFAULT_BOLD);
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m13884(AbstractC2083qd qdVar, String str) {
        String title = qdVar.getTitle();
        setContentDescription(title);
        setTag("Suggestion");
        this.f13042 = AppView.suggestionTitleResults;
        if (title != null) {
            m13882(title, str);
        }
        if (this.f13041 != null) {
            this.f13041.setVisibility(8);
        }
        if (!this.f13049) {
            this.f13052.m16460(this);
            setOnClickListener(new Cif(qdVar.getTitle(), qdVar.getTitle(), qdVar.getEntityId(), str, new C2387zt.C2388iF(this.f13050, qdVar.getEntityId(), null, this.f13053.getTrackId(), this.f13043, this.f13054)));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.zz$if  reason: invalid class name */
    public class Cif implements View.OnClickListener {

        /* renamed from: ʼ  reason: contains not printable characters */
        private final AbstractC0574 f13055;

        /* renamed from: ˋ  reason: contains not printable characters */
        private final String f13057;

        /* renamed from: ˎ  reason: contains not printable characters */
        private final String f13058;

        /* renamed from: ˏ  reason: contains not printable characters */
        private final String f13059;

        /* renamed from: ॱ  reason: contains not printable characters */
        private final String f13060;

        public Cif(String str, String str2, String str3, String str4, AbstractC0574 r6) {
            this.f13060 = str;
            this.f13059 = str2;
            this.f13057 = str4;
            this.f13058 = str3;
            this.f13055 = r6;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent(C2394zz.this.getContext(), ActivityC2392zx.m13837());
            intent.putExtra("EntityId", this.f13058);
            intent.putExtra("Title", this.f13059);
            intent.putExtra("TrackId", C2394zz.this.f13053.getTrackId());
            intent.putExtra("SearchResultType", C2394zz.this.f13042.name());
            intent.putExtra("SearchQuery", this.f13057);
            intent.putExtra("ParentRefId", C2394zz.this.f13050);
            C2394zz.this.getContext().startActivity(intent);
            SearchUtils.m2914(this.f13058, this.f13060, "", this.f13059, SearchUtils.SaveType.SEARCH_RELATED_TO, SearchUtils.SuggestionType.SEARCH_HISTORY, (NetflixActivity) C2394zz.this.getContext());
            C1300Ac.m3531(new C1080(AppView.suggestionResults, this.f13055), new C0344(), true);
        }
    }

    @Override // o.qK
    /* renamed from: ʼ */
    public oX mo1635() {
        return this.f13053;
    }
}
