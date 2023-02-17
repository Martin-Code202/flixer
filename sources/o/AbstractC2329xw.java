package o;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.ui.player.NetflixVideoView;
import com.netflix.mediaclient.util.ViewUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* access modifiers changed from: package-private */
/* renamed from: o.xw  reason: case insensitive filesystem */
public abstract class AbstractC2329xw implements AbstractC1978mi {

    /* renamed from: ʻ  reason: contains not printable characters */
    protected AbstractC1979mj f12282;

    /* renamed from: ʼ  reason: contains not printable characters */
    protected ViewGroup f12283;

    /* renamed from: ʽ  reason: contains not printable characters */
    protected Integer f12284;

    /* renamed from: ˊ  reason: contains not printable characters */
    protected Handler f12285;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    protected boolean f12286;

    /* renamed from: ˋ  reason: contains not printable characters */
    protected View f12287;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    protected int f12288;

    /* renamed from: ˎ  reason: contains not printable characters */
    protected List<Runnable> f12289 = Collections.synchronizedList(new ArrayList());

    /* renamed from: ˏ  reason: contains not printable characters */
    protected int f12290;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    protected int f12291;

    /* renamed from: ͺ  reason: contains not printable characters */
    protected int f12292;

    /* renamed from: ॱ  reason: contains not printable characters */
    protected oM f12293;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    protected int f12294;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    protected View f12295;

    /* renamed from: ᐝ  reason: contains not printable characters */
    protected int f12296;

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public abstract void mo13026(boolean z);

    /* access modifiers changed from: protected */
    /* renamed from: ॱ  reason: contains not printable characters */
    public abstract Runnable mo13029(AbstractC1976mg mgVar, boolean z);

    AbstractC2329xw(View view) {
        this.f12287 = view;
        C1283.m16846("nf_subtitles_render", "Create handler.");
        this.f12285 = new Handler(Looper.getMainLooper());
        this.f12283 = m13020(view);
        if (this.f12283 == null) {
            C1276.m16820().mo5725("Cannot create subtitle container - parentView type is invalid");
            return;
        }
        if (this.f12283.getWidth() == 0 || this.f12283.getHeight() == 0) {
            C1283.m16865("nf_subtitles_render", "Display area w/h are 0, display area is not visible yet!");
        }
        this.f12296 = C1004.m15954(mo13028(), 5);
        this.f12294 = C1004.m15954(mo13028(), 1);
        this.f12288 = C1004.m15954(mo13028(), mo13028().isTablet() ? 59 : 46);
        this.f12292 = this.f12287.getResources().getDimensionPixelSize(R.dimen.player_bottom_panel_height);
        this.f12291 = C1004.m15954(mo13028(), 5);
        this.f12295 = this.f12287.findViewById(R.id.top_panel_toolbar);
        this.f12286 = true;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public NetflixActivity mo13028() {
        return (NetflixActivity) this.f12287.getContext();
    }

    /* access modifiers changed from: protected */
    /* renamed from: ʽ  reason: contains not printable characters */
    public boolean m13022() {
        if (this.f12283 == null) {
            C1283.m16850("nf_subtitles_render", "Display area NOT found! This should NOT happen!");
            return false;
        } else if (this.f12283.getWidth() != 0 && this.f12283.getHeight() != 0) {
            return true;
        } else {
            C1283.m16865("nf_subtitles_render", "Display area w/h are 0, display area is not visible yet, postpone getting w/h");
            return false;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊ  reason: contains not printable characters */
    public void m13023(List<ViewUtils.C0049> list) {
        Collections.sort(list, ViewUtils.C0049.f4018);
        if (m13027(list)) {
            C1283.m16854("nf_subtitles_render", "Blocks moved appart, but we hit top, reorder blocks and move appart by pushing to bottom");
            Collections.sort(list, ViewUtils.C0049.f4017);
            C1283.m16854("nf_subtitles_render", "Sorted");
            m13025(list);
            return;
        }
        C1283.m16854("nf_subtitles_render", "Blocks moved appart, no issues");
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ  reason: contains not printable characters */
    public boolean m13027(List<ViewUtils.C0049> list) {
        boolean z = false;
        int size = list.size() - 1;
        for (int i = 0; i < size; i++) {
            for (int i2 = i + 1; i2 < list.size(); i2++) {
                if (C1346Bs.m4077(list.get(i2).m3040(), list.get(i).m3040()) == -1) {
                    C1283.m16865("nf_subtitles_render", "We hit top!");
                    z = true;
                }
            }
        }
        return z;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public void m13025(List<ViewUtils.C0049> list) {
        int size = list.size() - 1;
        for (int i = 0; i < size; i++) {
            for (int i2 = i + 1; i2 < list.size(); i2++) {
                C1346Bs.m4078(list.get(i).m3040(), list.get(i2).m3040(), this.f12283.getHeight());
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱ  reason: contains not printable characters */
    public void m13030(List<ViewUtils.C0049> list) {
        for (ViewUtils.C0049 r3 : list) {
            r3.m3040().setTag(null);
            r3.m3040().setVisibility(this.f12286 ? 0 : 8);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊ  reason: contains not printable characters */
    public void m13024(List<AbstractC1976mg> list, boolean z) {
        if (list != null) {
            for (AbstractC1976mg mgVar : list) {
                this.f12285.postDelayed(mo13029(mgVar, z), mgVar.mo8703());
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ʼ  reason: contains not printable characters */
    public int m13021() {
        int r2 = ViewUtils.m3014(mo13028());
        if (this.f12295 != null) {
            return this.f12295.getHeight() + this.f12291 + r2;
        }
        C1283.m16865("nf_subtitles_render", "Top panel is null");
        return this.f12291 + r2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱॱ  reason: contains not printable characters */
    public int m13031() {
        if (AD.m3311() || ViewUtils.m3004(mo13028())) {
            return this.f12292 + this.f12288;
        }
        return ViewUtils.m3032(mo13028()) ? this.f12292 + this.f12288 + ViewUtils.m3015((Context) mo13028(), false) : this.f12292 + this.f12288;
    }

    @Override // o.AbstractC1978mi
    /* renamed from: ˎ */
    public void mo9032(oM oMVar) {
        this.f12293 = oMVar;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private ViewGroup m13020(View view) {
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.displayArea);
        if (relativeLayout != null) {
            return relativeLayout;
        }
        if (view instanceof NetflixVideoView) {
            return ((NetflixVideoView) view).m2348();
        }
        if (view instanceof ViewGroup) {
            return (ViewGroup) view;
        }
        return null;
    }
}
