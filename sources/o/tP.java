package o;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import com.netflix.mediaclient.NetflixApplication;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.servicemgr.interface_.LoMoType;
import com.netflix.mediaclient.ui.experience.BrowseExperience;
import com.netflix.mediaclient.ui.lomo.LoMoUtils;
import o.AbstractC0954;
public interface tP {

    /* renamed from: o.tP$ˋ  reason: contains not printable characters */
    public static class C0215 {
        /* renamed from: ˋ  reason: contains not printable characters */
        public static AbstractC0954 m10994(Context context, int i) {
            int r3 = uH.m11416(AD.m3284(context), AD.m3290(context));
            return AbstractC0954.m15771(i).mo15104(true).mo15097(0.25f).mo15103(m10993(context)).mo15102(r3).mo15095(1.43f).mo15106(uH.m11415()).mo15100(context.getResources().getDimensionPixelSize(R.dimen.lomo_item_padding)).mo15101(BrowseExperience.m1780()).mo15105();
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        static AbstractC0954 m10995(Context context, int i, int i2) {
            return AbstractC0954.m15771(i).mo15104(true).mo15097(0.0f).mo15103(m10993(context)).mo15102(i2).mo15095(1.43f).mo15106(context.getResources().getDimensionPixelSize(R.dimen.lomo_item_padding)).mo15100(context.getResources().getDimensionPixelSize(R.dimen.lomo_item_padding)).mo15101(BrowseExperience.m1780()).mo15092(i2).mo15105();
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        private static RecyclerView.RecycledViewPool m10993(Context context) {
            int r3 = AD.m3290(context);
            RecyclerView.RecycledViewPool recycledViewPool = new RecyclerView.RecycledViewPool();
            recycledViewPool.setMaxRecycledViews(0, (uH.m11416(1, r3) + 2) * (uH.m11416(2, r3) + 2));
            recycledViewPool.setMaxRecycledViews(1, 0);
            return recycledViewPool;
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public static AbstractC0954 m10997(NetflixActivity netflixActivity, int i) {
            int r3 = uH.m11417(netflixActivity);
            AbstractC0954.Cif r6 = AbstractC0954.m15771(i).mo15103(new RecyclerView.RecycledViewPool()).mo15102(r3).mo15095(1.7f).mo15106(uH.m11415()).mo15101(BrowseExperience.m1780()).mo15100(netflixActivity.getResources().getDimensionPixelSize(R.dimen.lomo_item_padding));
            if (r3 > 1) {
                AbstractC0954 r7 = m10994(netflixActivity, i);
                r6.mo15097(r7.mo15090());
                r6.mo15096(r7.mo15088());
                r6.mo15104(r7.mo15087());
            }
            return r6.mo15105();
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        public static AbstractC0954 m10996(NetflixActivity netflixActivity, int i) {
            if (!If.m10987()) {
                return m10994(netflixActivity, i);
            }
            AbstractC0954.Cif r4 = AbstractC0954.m15771(i).mo15103(new RecyclerView.RecycledViewPool()).mo15102(2).mo15095(2.0f).mo15106(uH.m11415()).mo15093(1).mo15101(BrowseExperience.m1780()).mo15100(netflixActivity.getResources().getDimensionPixelSize(R.dimen.lomo_item_padding));
            AbstractC0954 r5 = m10994(netflixActivity, i);
            r4.mo15097((2.0f * r5.mo15090()) / 3.0f);
            r4.mo15096(r5.mo15088());
            r4.mo15104(r5.mo15087());
            return r4.mo15105();
        }
    }

    /* renamed from: o.tP$if  reason: invalid class name */
    public static class Cif {
        /* renamed from: ˎ  reason: contains not printable characters */
        public static boolean m10990() {
            return AD.m3292();
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        public static int m10989(NetflixActivity netflixActivity, boolean z) {
            return m10988(netflixActivity, z, LoMoUtils.LoMoWidthType.STANDARD);
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        private static int m10988(NetflixActivity netflixActivity, boolean z, LoMoUtils.LoMoWidthType loMoWidthType) {
            if (z) {
                return (AD.m3317(netflixActivity) - LoMoUtils.m2144(netflixActivity)) - LoMoUtils.m2148(netflixActivity, loMoWidthType);
            }
            return AD.m3317(netflixActivity);
        }
    }

    /* renamed from: o.tP$ˊ  reason: contains not printable characters */
    public static class C0214 {
        /* renamed from: ˊ  reason: contains not printable characters */
        static int m10991(int i, AbstractC0954 r3) {
            return (i % r3.mo15083()) + r3.mo15083() + 1;
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        static int m10992(Context context, int i) {
            return (i + uH.m11414(context, LoMoType.FLAT_GENRE)) - 1;
        }
    }

    public static class If {
        /* renamed from: ˋ  reason: contains not printable characters */
        public static boolean m10987() {
            return AD.m3292() && !C1339Bl.m4051(NetflixApplication.getInstance(), "disable_roar", true);
        }
    }
}
