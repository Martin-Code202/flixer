package o;

import android.annotation.SuppressLint;
import android.app.SearchManager;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBar;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SearchView;
import com.netflix.cl.Logger;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.widget.NetflixActionBar;
import com.netflix.mediaclient.service.logging.uiview.model.CommandEndedEvent;
import com.netflix.mediaclient.servicemgr.UIViewLogging;
import com.netflix.mediaclient.util.ViewUtils;
/* renamed from: o.ᒳ  reason: contains not printable characters */
public class C0803 extends NetflixActionBar {

    /* renamed from: ˊॱ  reason: contains not printable characters */
    protected ProgressBar f14530;

    /* renamed from: ˋ  reason: contains not printable characters */
    private boolean f14531;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    protected View f14532;

    /* renamed from: ˎ  reason: contains not printable characters */
    private EditText f14533;

    /* renamed from: ˏ  reason: contains not printable characters */
    private GestureDetector f14534;

    /* renamed from: ॱ  reason: contains not printable characters */
    private ImageView f14535;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    protected SearchView f14536;

    public C0803(NetflixActivity netflixActivity, C0828 r3) {
        super(netflixActivity, r3);
        this.f14531 = zA.m13379(netflixActivity);
        m15340();
        m15336();
        m15343(netflixActivity);
        m15338();
        m15341();
        m15345();
        m15342();
    }

    /* renamed from: ॱˊ  reason: contains not printable characters */
    public ImageView m15356() {
        return this.f14535;
    }

    /* renamed from: ʻॱ  reason: contains not printable characters */
    public final SearchView m15346() {
        return this.f14536;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m15345() {
        this.f14535 = (ImageView) this.f14536.findViewById(m353().getResources().getIdentifier("android:id/search_voice_btn", null, null));
        if (this.f14535 == null) {
            C1283.m16865("SearchActionBar", "SPY-8468 - Voice search not available. SearchView doesn't have view with id search_voice_btn");
            C1276.m16820().mo5727("SPY-8468 - Voice search not available. SearchView doesn't have view with id search_voice_btn");
        } else if (this.f14531) {
            this.f14534 = new GestureDetector(m353(), new ViewUtils.Cif());
            this.f14535.setOnTouchListener(new View.OnTouchListener() { // from class: o.ᒳ.1
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (C0803.this.f14534 == null || !C0803.this.f14534.onTouchEvent(motionEvent)) {
                        return false;
                    }
                    Logger.INSTANCE.m130("SearchCommand");
                    Logger.INSTANCE.m137("VoiceInput");
                    C1364Cj.m4435(UIViewLogging.UIViewCommandName.search, C0803.this.m353().getUiScreen().f4084, CommandEndedEvent.InputMethod.voice, (CommandEndedEvent.InputValue) null, C0803.this.m353().getDataContext());
                    return false;
                }
            });
        } else {
            this.f14535.setEnabled(false);
            this.f14535.setImageDrawable(null);
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m15343(NetflixActivity netflixActivity) {
        this.f14536.setSearchableInfo(((SearchManager) netflixActivity.getSystemService("search")).getSearchableInfo(netflixActivity.getComponentName()));
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ */
    public int mo14560() {
        return R.layout.action_bar_search;
    }

    @SuppressLint({"InflateParams"})
    /* renamed from: ˋ  reason: contains not printable characters */
    private void m15340() {
        this.f14532 = LayoutInflater.from(m353()).inflate(mo14560(), (ViewGroup) null);
        if (this.f14532 != null) {
            this.f14536 = (SearchView) this.f14532.findViewById(R.id.action_bar_search_view);
            this.f14530 = (ProgressBar) this.f14532.findViewById(R.id.action_bar_search_progress_spinner);
            m365(this.f14532, new ActionBar.LayoutParams(-1, -2, 8388611));
        }
    }

    /* renamed from: ॱˎ  reason: contains not printable characters */
    public View m15357() {
        return this.f14532;
    }

    /* renamed from: ˉ  reason: contains not printable characters */
    private void m15336() {
        if (this.f14536 != null) {
            this.f14536.setImeOptions(33554435);
            this.f14536.setQueryHint(m353().getString(R.string.search));
            this.f14536.setInputType(8192);
            this.f14536.setQueryRefinementEnabled(true);
            this.f14536.setSubmitButtonEnabled(false);
            this.f14536.setIconifiedByDefault(false);
            this.f14536.setIconified(false);
        }
    }

    /* renamed from: ˊᐝ  reason: contains not printable characters */
    private void m15338() {
        this.f14533 = (EditText) this.f14536.findViewById(m353().getResources().getIdentifier("android:id/search_src_text", null, null));
        if (this.f14533 != null) {
            int color = this.f14536.getResources().getColor(mo11197());
            int color2 = this.f14536.getResources().getColor(R.color.voice_search_label_text_color);
            this.f14533.setTextSize((float) m353().getResources().getInteger(R.integer.search_view_text_size));
            this.f14533.setHintTextColor(color2);
            this.f14533.setTextColor(color);
            this.f14533.setImeOptions(33554432);
            this.f14533.setCursorVisible(false);
        }
    }

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    public void m15359() {
        if (this.f14533 != null) {
            this.f14533.setCursorVisible(true);
        }
    }

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    public void m15358() {
        if (this.f14533 != null) {
            this.f14533.setCursorVisible(false);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱˋ */
    public int mo11197() {
        return R.color.primary_text_color;
    }

    /* renamed from: ˋˊ  reason: contains not printable characters */
    private void m15341() {
        ImageView imageView = (ImageView) this.f14536.findViewById(m353().getResources().getIdentifier("android:id/search_mag_icon", null, null));
        if (imageView != null) {
            imageView.setImageResource(m15348());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ʽॱ  reason: contains not printable characters */
    public int m15348() {
        return R.drawable.ic_search_active;
    }

    /* renamed from: ˋˋ  reason: contains not printable characters */
    private void m15342() {
        Drawable r3;
        Drawable r2;
        Integer r1 = mo11195();
        if (!(r1 == null || (r2 = m15344("android:id/search_close_btn")) == null)) {
            ViewUtils.m3027(r2, r1.intValue());
        }
        Integer r22 = mo11196();
        if (r22 != null && (r3 = m15344("android:id/search_voice_btn")) != null) {
            ViewUtils.m3027(r3, r22.intValue());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˈ */
    public Integer mo11196() {
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ʿ */
    public Integer mo11195() {
        return null;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private ImageView m15337(String str) {
        return (ImageView) this.f14536.findViewById(this.f14536.getContext().getResources().getIdentifier(str, null, null));
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private Drawable m15344(String str) {
        ImageView r1 = m15337(str);
        if (r1 == null) {
            return null;
        }
        return r1.getDrawable();
    }

    /* renamed from: ʼॱ  reason: contains not printable characters */
    public boolean m15347() {
        if (this.f14536 == null) {
            return false;
        }
        return this.f14536.requestFocus();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m15353(View.OnTouchListener onTouchListener) {
        if (this.f14533 != null) {
            this.f14533.setOnTouchListener(onTouchListener);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m15350(View.OnFocusChangeListener onFocusChangeListener) {
        if (this.f14536 != null) {
            this.f14536.setOnQueryTextFocusChangeListener(onFocusChangeListener);
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m15355(String str, boolean z) {
        this.f14536.setQuery(str, z);
    }

    /* renamed from: ʾ  reason: contains not printable characters */
    public void m15349() {
        this.f14536.clearFocus();
        View findFocus = this.f14536.findFocus();
        if (findFocus != null) {
            findFocus.clearFocus();
        }
    }

    /* renamed from: ˊˋ  reason: contains not printable characters */
    public void m15352() {
        if (this.f14530 != null) {
            this.f14530.setVisibility(4);
        }
    }

    /* renamed from: ˊˊ  reason: contains not printable characters */
    public void m15351() {
        if (this.f14530 != null) {
            this.f14530.setVisibility(0);
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m15354(String str) {
        if (this.f14536 != null) {
            this.f14536.setQueryHint(str);
        }
    }
}
