package o;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.netflix.android.widgetry.widget.TrackedLinearLayoutManager;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.widget.NetflixBottomNavBar;
import com.netflix.mediaclient.android.widget.StaticImgConfig;
import com.netflix.mediaclient.api.res.AssetType;
import com.netflix.mediaclient.util.ViewUtils;
import o.uD;
/* renamed from: o.up  reason: case insensitive filesystem */
public class C2216up implements uD.AbstractC0227 {

    /* renamed from: ʼ  reason: contains not printable characters */
    private final RecyclerView.OnScrollListener f11014 = new RecyclerView.OnScrollListener() { // from class: o.up.1
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            int computeVerticalScrollOffset = recyclerView.computeVerticalScrollOffset();
            if (C2216up.this.f11019.m11016()) {
                TrackedLinearLayoutManager trackedLinearLayoutManager = (TrackedLinearLayoutManager) recyclerView.getLayoutManager();
                if (i == 0 && trackedLinearLayoutManager.canScrollVertically()) {
                    if (trackedLinearLayoutManager.findFirstVisibleItemPosition() >= 1) {
                        C2216up.this.m11730();
                        return;
                    }
                    C2216up.this.m11732((float) (-computeVerticalScrollOffset));
                    C2216up.this.m11728();
                }
            }
        }
    };

    /* renamed from: ˊ  reason: contains not printable characters */
    private tV f11015;

    /* renamed from: ˋ  reason: contains not printable characters */
    private C1050 f11016;

    /* renamed from: ˎ  reason: contains not printable characters */
    private View f11017;

    /* renamed from: ˏ  reason: contains not printable characters */
    private View f11018;

    /* renamed from: ॱ  reason: contains not printable characters */
    private tQ f11019;

    C2216up(tQ tQVar) {
        this.f11019 = tQVar;
        FrameLayout r1 = tQVar.m11015();
        if (r1 != null) {
            this.f11016 = (C1050) r1.findViewById(R.id.billboard_story_art);
            this.f11018 = r1.findViewById(R.id.billboard_story_art_gradient);
            this.f11017 = r1.findViewById(R.id.billboard_story_art_topgradient);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˋ  reason: contains not printable characters */
    public void m11729(tV tVVar) {
        this.f11015 = tVVar;
        if (this.f11015 != null) {
            this.f11015.addOnScrollListener(this.f11014);
        }
    }

    @Override // o.uD.AbstractC0227
    /* renamed from: ˋ */
    public void mo11355(uD uDVar, String str, String str2, boolean z, int i, int i2) {
        ViewUtils.m3002((View) this.f11016, true);
        String string = uDVar.getResources().getString(R.string.accesibility_play_video, str2);
        if (this.f11016 != null && this.f11018 != null && this.f11017 != null) {
            if (!z) {
                this.f11016.setImageAlpha(20);
            }
            m11726(uDVar.getContext(), i, i2);
            NetflixActivity.getImageLoader(uDVar.getContext()).mo3063(this.f11016, str, AssetType.merchStill, string, StaticImgConfig.DARK, true, 1);
            this.f11018.setBackground(ContextCompat.getDrawable(uDVar.getContext(), R.drawable.billboard_portrait_bottom_gradient));
            this.f11017.setBackground(ContextCompat.getDrawable(uDVar.getContext(), R.drawable.billboard_portrait_top_gradient));
            if (this.f11015.getPaddingTop() > 0) {
                C1004.m15952(this.f11015, 1, 0);
            }
            m11728();
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m11732(float f) {
        if (this.f11016 != null) {
            this.f11016.setTranslationY(f);
        }
        if (this.f11018 != null) {
            this.f11018.setTranslationY(f);
        }
        if (this.f11017 != null) {
            this.f11017.setTranslationY(f);
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m11730() {
        if (this.f11016 != null) {
            this.f11016.setVisibility(4);
        }
        if (this.f11018 != null) {
            this.f11018.setVisibility(4);
        }
        if (this.f11017 != null) {
            this.f11017.setVisibility(4);
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m11728() {
        if (this.f11016 != null) {
            this.f11016.setVisibility(0);
        }
        if (this.f11018 != null) {
            this.f11018.setVisibility(0);
        }
        if (this.f11017 != null) {
            this.f11017.setVisibility(0);
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m11731() {
        if (this.f11016 != null) {
            this.f11016.setVisibility(8);
        }
        if (this.f11018 != null) {
            this.f11018.setVisibility(8);
        }
        if (this.f11017 != null) {
            this.f11017.setVisibility(8);
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m11726(Context context, int i, int i2) {
        ViewGroup.LayoutParams layoutParams = this.f11016.getLayoutParams();
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.f11018.getLayoutParams();
        ViewGroup.LayoutParams layoutParams3 = this.f11017.getLayoutParams();
        layoutParams.height = (AD.m3317(context) * i) / i2;
        layoutParams2.height = (layoutParams.height * 6) / 10;
        layoutParams3.height = layoutParams2.height / 2;
        layoutParams2.topMargin = layoutParams.height - layoutParams2.height;
        if (!NetflixBottomNavBar.m416()) {
            layoutParams2.gravity = 80;
        }
        this.f11018.setLayoutParams(layoutParams2);
        this.f11017.setLayoutParams(layoutParams3);
        this.f11016.setLayoutParams(layoutParams);
    }
}
