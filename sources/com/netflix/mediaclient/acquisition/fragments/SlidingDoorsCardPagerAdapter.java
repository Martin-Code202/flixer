package com.netflix.mediaclient.acquisition.fragments;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.acquisition.kotlinx.ContextKt;
import com.netflix.mediaclient.acquisition.kotlinx.TextViewKt;
import com.netflix.mediaclient.acquisition.viewmodels.SignupConstants;
import com.netflix.mediaclient.acquisition.viewmodels.SlidingDoorsTitleCard;
import com.netflix.mediaclient.android.widget.StaticImgConfig;
import com.netflix.mediaclient.api.res.AssetType;
import com.netflix.mediaclient.util.gfx.ImageLoader;
import java.util.List;
import kotlin.TypeCastException;
import o.C0522;
import o.C1456Fq;
import o.C1457Fr;
public final class SlidingDoorsCardPagerAdapter extends PagerAdapter {
    public static final Companion Companion = new Companion(null);
    private final List<SlidingDoorsTitleCard> cards;
    private final Context context;
    private final ImageLoader imageLoader;

    public SlidingDoorsCardPagerAdapter(Context context2, ImageLoader imageLoader2, List<SlidingDoorsTitleCard> list) {
        C1457Fr.m5025(context2, "context");
        C1457Fr.m5025(list, SignupConstants.Field.CARDS);
        this.context = context2;
        this.imageLoader = imageLoader2;
        this.cards = list;
    }

    public final Context getContext() {
        return this.context;
    }

    public final ImageLoader getImageLoader() {
        return this.imageLoader;
    }

    public final List<SlidingDoorsTitleCard> getCards() {
        return this.cards;
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(C1456Fq fq) {
            this();
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private final void bindCard(Context context, ImageLoader imageLoader, View view, SlidingDoorsTitleCard slidingDoorsTitleCard) {
            TextView textView = (TextView) view.findViewById(R.id.titleCardHeadingView);
            String titleStringKey = slidingDoorsTitleCard.getTitleStringKey();
            if (titleStringKey == null) {
                titleStringKey = "";
            }
            if (textView != null) {
                TextViewKt.setTextOrGone(textView, ContextKt.getStringResource(context, titleStringKey));
            }
            TextView textView2 = (TextView) view.findViewById(R.id.titleCardSubheadingView);
            String subtitleStringKey = slidingDoorsTitleCard.getSubtitleStringKey();
            if (subtitleStringKey == null) {
                subtitleStringKey = "";
            }
            if (textView2 != null) {
                TextViewKt.setTextOrGone(textView2, ContextKt.getStringResource(context, subtitleStringKey));
            }
            C0522 r11 = (C0522) view.findViewById(R.id.titleCardImageView);
            if (r11 != null && slidingDoorsTitleCard.getImageUrl() != null && imageLoader != null) {
                imageLoader.mo3057(r11, slidingDoorsTitleCard.getImageUrl(), AssetType.signupAsset, "tinDevicesDownloadImage", StaticImgConfig.DARK, true);
            }
        }
    }

    private final void adjustFormatting(ViewGroup viewGroup, int i) {
        TextView textView;
        if (i == 0 && (textView = (TextView) viewGroup.findViewById(R.id.titleCardHeadingView)) != null) {
            textView.setTextSize(this.context.getResources().getDimension(R.dimen.signup_sliding_doors_welcome_text_size));
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        C1457Fr.m5025(viewGroup, "collection");
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.sliding_doors_title_card_layout, viewGroup, false);
        if (inflate == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
        }
        ViewGroup viewGroup2 = (ViewGroup) inflate;
        Companion.bindCard(this.context, this.imageLoader, viewGroup2, this.cards.get(i));
        adjustFormatting(viewGroup2, i);
        viewGroup.addView(viewGroup2);
        return viewGroup2;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        C1457Fr.m5025(viewGroup, "collection");
        C1457Fr.m5025(obj, "view");
        viewGroup.removeView((View) obj);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.cards.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        C1457Fr.m5025(view, "view");
        C1457Fr.m5025(obj, "obj");
        return view == obj;
    }

    @Override // android.support.v4.view.PagerAdapter
    public CharSequence getPageTitle(int i) {
        return "";
    }
}
