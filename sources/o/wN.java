package o;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.ui.player.IPlayerFragment;
import com.netflix.model.leafs.PostPlayExperience;
import com.netflix.model.leafs.PostPlayItem;
import java.util.List;
import kotlin.TypeCastException;
import o.C1348Bu;
public final class wN extends wK {

    /* renamed from: ʼॱ  reason: contains not printable characters */
    private List<? extends LinearLayout> f11495;

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private LinearLayout f11496;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public wN(IPlayerFragment iPlayerFragment) {
        super(iPlayerFragment);
        C1457Fr.m5025(iPlayerFragment, "context");
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x002c: APUT  
      (r0v4 android.widget.LinearLayout[])
      (1 ??[boolean, int, float, short, byte, char])
      (r1v3 android.widget.LinearLayout)
     */
    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.ui.player.PostPlay
    /* renamed from: ˊ */
    public void mo2561() {
        super.mo2561();
        View findViewById = this.f3616.findViewById(R.id.post_play_items_portrait);
        C1457Fr.m5016((Object) findViewById, "mNetflixActivity.findVie…post_play_items_portrait)");
        this.f11496 = (LinearLayout) findViewById;
        LinearLayout[] linearLayoutArr = new LinearLayout[2];
        LinearLayout linearLayout = this.f3609;
        C1457Fr.m5016((Object) linearLayout, "mItemsContainer");
        linearLayoutArr[0] = linearLayout;
        LinearLayout linearLayout2 = this.f11496;
        if (linearLayout2 == null) {
            C1457Fr.m5017("portraitItemsContainer");
        }
        linearLayoutArr[1] = linearLayout2;
        this.f11495 = EI.m4802(linearLayoutArr);
        this.f3624.addOnLayoutChangeListener(new If(this));
        LinearLayout linearLayout3 = this.f3609;
        C1457Fr.m5016((Object) linearLayout3, "mItemsContainer");
        Context context = linearLayout3.getContext();
        C1457Fr.m5016((Object) context, "mItemsContainer.context");
        Resources resources = context.getResources();
        C1457Fr.m5016((Object) resources, "mItemsContainer.context.resources");
        Configuration configuration = resources.getConfiguration();
        C1457Fr.m5016((Object) configuration, "mItemsContainer.context.resources.configuration");
        m12342(configuration);
    }

    public static final class If implements View.OnLayoutChangeListener {

        /* renamed from: ˊ  reason: contains not printable characters */
        final /* synthetic */ wN f11497;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        If(wN wNVar) {
            this.f11497 = wNVar;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            this.f11497.mo12316();
            this.f11497.m12315();
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.ui.player.PostPlay
    /* renamed from: ˎ */
    public void mo2574(Configuration configuration) {
        C1457Fr.m5025(configuration, "newConfig");
        m12342(configuration);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private final void m12342(Configuration configuration) {
        if (this.f3616 == null) {
            return;
        }
        if (configuration.orientation == 2) {
            LinearLayout linearLayout = this.f3609;
            C1457Fr.m5016((Object) linearLayout, "mItemsContainer");
            linearLayout.setVisibility(0);
            LinearLayout linearLayout2 = this.f11496;
            if (linearLayout2 == null) {
                C1457Fr.m5017("portraitItemsContainer");
            }
            linearLayout2.setVisibility(8);
            return;
        }
        LinearLayout linearLayout3 = this.f3609;
        C1457Fr.m5016((Object) linearLayout3, "mItemsContainer");
        linearLayout3.setVisibility(8);
        LinearLayout linearLayout4 = this.f11496;
        if (linearLayout4 == null) {
            C1457Fr.m5017("portraitItemsContainer");
        }
        linearLayout4.setVisibility(0);
    }

    /* access modifiers changed from: protected */
    @Override // o.wK
    /* renamed from: ˊᐝ */
    public void mo12316() {
        Window window;
        View decorView;
        Resources resources;
        Configuration configuration;
        NetflixActivity netflixActivity = this.f3616;
        boolean z = (netflixActivity == null || (resources = netflixActivity.getResources()) == null || (configuration = resources.getConfiguration()) == null || configuration.orientation != 2) ? false : true;
        NetflixActivity netflixActivity2 = this.f3616;
        if (netflixActivity2 != null && (window = netflixActivity2.getWindow()) != null && (decorView = window.getDecorView()) != null) {
            C1348Bu.If.m4098(new RunnableC0251(decorView.getMeasuredWidth(), this, z));
        }
    }

    /* renamed from: o.wN$ˊ  reason: contains not printable characters */
    public static final class RunnableC0251 implements Runnable {

        /* renamed from: ˊ  reason: contains not printable characters */
        final /* synthetic */ int f11498;

        /* renamed from: ˋ  reason: contains not printable characters */
        final /* synthetic */ boolean f11499;

        /* renamed from: ˎ  reason: contains not printable characters */
        final /* synthetic */ wN f11500;

        RunnableC0251(int i, wN wNVar, boolean z) {
            this.f11498 = i;
            this.f11500 = wNVar;
            this.f11499 = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            float f;
            TextView textView;
            List<PostPlayItem> items;
            int i = this.f11498;
            PostPlayExperience postPlayExperience = this.f11500.f3620;
            int size = i * ((postPlayExperience == null || (items = postPlayExperience.getItems()) == null) ? 1 : items.size());
            LinearLayout linearLayout = this.f11500.f3624;
            C1457Fr.m5016((Object) linearLayout, "mBackgroundContainer");
            if (size != linearLayout.getLayoutParams().width) {
                LinearLayout linearLayout2 = this.f11500.f3624;
                C1457Fr.m5016((Object) linearLayout2, "mBackgroundContainer");
                linearLayout2.getLayoutParams().width = size;
                LinearLayout linearLayout3 = this.f11500.f3624;
                C1457Fr.m5016((Object) linearLayout3, "mBackgroundContainer");
                for (View view : C0549.m14593(linearLayout3)) {
                    view.getLayoutParams().width = this.f11498;
                    TextView textView2 = (TextView) view.findViewById(R.id.post_play_synopsis);
                    if (textView2 != null) {
                        if (this.f11499) {
                            C1281 r10 = C1281.f15992;
                            Resources resources = ((Context) C1281.m16832(Context.class)).getResources();
                            C1457Fr.m5016((Object) resources, "Lookup.get<Context>().resources");
                            int applyDimension = (int) TypedValue.applyDimension(1, 0.0f, resources.getDisplayMetrics());
                            textView = textView2;
                            f = (float) applyDimension;
                        } else {
                            C1281 r102 = C1281.f15992;
                            Resources resources2 = ((Context) C1281.m16832(Context.class)).getResources();
                            C1457Fr.m5016((Object) resources2, "Lookup.get<Context>().resources");
                            int applyDimension2 = (int) TypedValue.applyDimension(1, 6.0f, resources2.getDisplayMetrics());
                            textView = textView2;
                            f = (float) applyDimension2;
                        }
                        textView.setLineSpacing(f, 1.0f);
                    }
                    View findViewById = view.findViewById(R.id.metadata_right_padding_large);
                    if (findViewById != null) {
                        findViewById.setVisibility(this.f11499 ? 0 : 8);
                    }
                    View findViewById2 = view.findViewById(R.id.metadata_right_padding_small);
                    if (findViewById2 != null) {
                        findViewById2.setVisibility(this.f11499 ? 8 : 0);
                    }
                }
                this.f11500.f3624.requestLayout();
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.wK
    /* renamed from: ˏ */
    public void mo12318(LayoutInflater layoutInflater, PostPlayItem postPlayItem, boolean z, boolean z2, boolean z3, wC wCVar, int i) {
        int i2;
        C1457Fr.m5025(layoutInflater, "inflater");
        C1457Fr.m5025(postPlayItem, "postPlayItem");
        C1457Fr.m5025(wCVar, "background");
        List<? extends LinearLayout> list = this.f11495;
        if (list == null) {
            C1457Fr.m5017("itemContainers");
        }
        for (T t : list) {
            if (z) {
                i2 = R.layout.post_play_item_signup;
            } else if (z3) {
                i2 = R.layout.post_play_item_seamless;
            } else if (z2) {
                LinearLayout linearLayout = this.f11496;
                if (linearLayout == null) {
                    C1457Fr.m5017("portraitItemsContainer");
                }
                if (C1457Fr.m5018((Object) t, (Object) linearLayout)) {
                    t.setOrientation(0);
                    ViewGroup.LayoutParams layoutParams = t.getLayoutParams();
                    C1281 r13 = C1281.f15992;
                    Resources resources = ((Context) C1281.m16832(Context.class)).getResources();
                    C1457Fr.m5016((Object) resources, "Lookup.get<Context>().resources");
                    layoutParams.height = (int) TypedValue.applyDimension(1, 154.0f, resources.getDisplayMetrics());
                    t.getLayoutParams().width = -2;
                    i2 = R.layout.post_play_item_poster_portrait;
                } else {
                    i2 = R.layout.post_play_item_poster;
                }
            } else {
                LinearLayout linearLayout2 = this.f11496;
                if (linearLayout2 == null) {
                    C1457Fr.m5017("portraitItemsContainer");
                }
                i2 = C1457Fr.m5018(t, linearLayout2) ? R.layout.post_play_item_metadata_portrait : R.layout.post_play_item_metadata;
            }
            View inflate = layoutInflater.inflate(i2, (ViewGroup) t, false);
            if (inflate == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.netflix.mediaclient.ui.player.PostPlayItemView");
            }
            wR wRVar = (wR) inflate;
            m12319(wRVar, postPlayItem, wCVar, z, z2, i);
            t.addView(wRVar);
            this.f11473.add(wRVar);
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.wK
    /* renamed from: ˎ */
    public int mo12317(int i) {
        NetflixActivity netflixActivity = this.f3616;
        C1457Fr.m5016((Object) netflixActivity, "mNetflixActivity");
        Window window = netflixActivity.getWindow();
        C1457Fr.m5016((Object) window, "mNetflixActivity.window");
        View decorView = window.getDecorView();
        C1457Fr.m5016((Object) decorView, "mNetflixActivity.window.decorView");
        return decorView.getMeasuredWidth() * -1 * i;
    }

    @Override // o.wK, com.netflix.mediaclient.ui.player.PostPlay
    /* renamed from: ˊ */
    public void mo2563(boolean z) {
        super.mo2563(z);
        NetflixActivity netflixActivity = this.f3616;
        if (netflixActivity != null) {
            View findViewById = netflixActivity.findViewById(R.id.no_background_overlay);
            C1457Fr.m5016((Object) findViewById, "activity.findViewById<Vi…id.no_background_overlay)");
            findViewById.setVisibility(z ? 8 : 0);
            View findViewById2 = netflixActivity.findViewById(R.id.bottom_black_background);
            C1457Fr.m5016((Object) findViewById2, "activity.findViewById<Vi….bottom_black_background)");
            findViewById2.setVisibility(z ? 8 : 0);
        }
    }
}
