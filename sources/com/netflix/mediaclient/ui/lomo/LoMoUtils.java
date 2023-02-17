package com.netflix.mediaclient.ui.lomo;

import android.app.Activity;
import android.widget.TextView;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import java.util.List;
import o.uH;
public class LoMoUtils {

    public enum LoMoWidthType {
        STANDARD,
        KIDS_CHARACTER_ROW
    }

    /* access modifiers changed from: package-private */
    public enum SupportedBadge {
        NEW
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static int m2144(Activity activity) {
        return activity.getResources().getDimensionPixelOffset(R.dimen.lomo_list_padding);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static int m2148(NetflixActivity netflixActivity, LoMoWidthType loMoWidthType) {
        switch (loMoWidthType) {
            case KIDS_CHARACTER_ROW:
                return netflixActivity.getResources().getDimensionPixelOffset(R.dimen.kids_character_row_offset_right);
            case STANDARD:
            default:
                return uH.m11415();
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static int m2147(NetflixActivity netflixActivity) {
        return uH.m11417(netflixActivity);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static void m2146(List<String> list, TextView textView) {
        if (textView != null) {
            if (list.size() <= 0 || !list.get(0).equalsIgnoreCase(SupportedBadge.NEW.toString())) {
                textView.setVisibility(8);
                return;
            }
            textView.setText(textView.getResources().getString(R.string.label_episode_badge_new));
            textView.setVisibility(0);
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static void m2145(String str, TextView textView) {
        if (textView != null) {
            if (str == null || !str.equalsIgnoreCase(SupportedBadge.NEW.toString())) {
                textView.setVisibility(8);
                return;
            }
            textView.setText(textView.getResources().getString(R.string.label_episode_badge_new));
            textView.setVisibility(0);
        }
    }
}
