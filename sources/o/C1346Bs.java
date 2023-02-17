package o;

import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.netflix.mediaclient.media.BaseSubtitle;
import com.netflix.mediaclient.media.NccpSubtitle;
import com.netflix.mediaclient.media.Subtitle;
import com.netflix.mediaclient.service.player.subtitles.text.FontFamilyMapping;
import com.netflix.mediaclient.util.ViewUtils;
import o.mO;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: o.Bs  reason: case insensitive filesystem */
public final class C1346Bs {
    /* renamed from: ॱ  reason: contains not printable characters */
    public static boolean m4085(mP mPVar) {
        return (mPVar == null || mPVar.m8884() == null || !mPVar.m8884().m8860()) ? false : true;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static int m4077(View view, View view2) {
        Rect r4 = ViewUtils.m3008(view, true);
        Point r6 = C1984mo.m9053(r4, ViewUtils.m3008(view2, true));
        if (r6 == null) {
            C1283.m16854("nf_subtitles_render", "===> No intersection found");
            return 0;
        }
        int i = 1;
        int i2 = r6.y;
        int i3 = r4.top - i2;
        if (i3 < 0) {
            C1283.m16865("nf_subtitles_render", "We hit top. Set top to 0");
            i2 += i3;
            i = -1;
        }
        r4.top -= i2;
        r4.bottom -= i2;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        marginLayoutParams.setMargins(r4.left, r4.top, 0, 0);
        view.setLayoutParams(marginLayoutParams);
        return i;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static Typeface m4082(mP mPVar, boolean z) {
        if (mPVar == null) {
            C1283.m16854("nf_subtitles_render", "No styles, use san serif typeface");
            return C1347Bt.m4091();
        }
        Typeface r2 = C1347Bt.m4091();
        if (mPVar.m8866() != null) {
            if (FontFamilyMapping.m1166(mPVar.m8866())) {
                C1283.m16854("nf_subtitles_render", "Apply sans serif");
                r2 = C1347Bt.m4086(mPVar.m8881());
            } else {
                C1283.m16854("nf_subtitles_render", "Apply non sans serif");
                r2 = C1347Bt.m4089(mPVar);
            }
        }
        if (z) {
            return Typeface.create(r2, C1984mo.m9056(mPVar));
        }
        return r2;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static void m4084(TextView textView, mP mPVar, float f) {
        if (textView == null || mPVar == null) {
            C1283.m16850("nf_subtitles_render", "apply style parameters are null, do nothing!");
            return;
        }
        textView.setTextSize(0, f * C1984mo.m9049(mPVar));
        textView.setTypeface(m4082(mPVar, false), C1984mo.m9056(mPVar));
        C1984mo.m9048(textView, mPVar);
        Integer r5 = C1984mo.m9055(mPVar);
        if (r5 != null) {
            textView.setTextColor(r5.intValue());
        } else {
            C1283.m16865("nf_subtitles_render", "Text color unresolved, not setting anything!");
        }
        Integer r52 = C1984mo.m9045(mPVar);
        if (r52 != null) {
            textView.setBackgroundColor(r52.intValue());
        } else {
            C1283.m16865("nf_subtitles_render", "Background color unresolved, not setting anything!");
        }
        C1283.m16854("nf_subtitles_render", "Before apply outline!");
        m4076(textView, mPVar.m8884());
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private static void m4076(TextView textView, mO mOVar) {
        if (mOVar == null) {
            C1283.m16850("nf_subtitles_render", "No outline!");
        } else if (textView instanceof C0832) {
            m4081((C0832) textView, mOVar);
        } else {
            m4080(textView, mOVar);
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private static void m4080(TextView textView, mO mOVar) {
        C1283.m16854("nf_subtitles_render", "Apply edge");
        if (mOVar == null || !mOVar.m8858()) {
            C1283.m16854("nf_subtitles_render", "No outline to be applied");
            return;
        }
        Integer r4 = C1984mo.m9051(mOVar);
        if (r4 == null) {
            C1283.m16865("nf_subtitles_render", "Edge color unresolved, not setting anything!");
            return;
        }
        mO.C0148 r5 = mOVar.m8856();
        if (r5 == null) {
            C1283.m16865("nf_subtitles_render", "Shadow is null, not setting anything!");
        } else {
            textView.setShadowLayer(r5.f8743, (float) r5.f8742, (float) r5.f8744, r4.intValue());
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private static void m4081(C0832 r4, mO mOVar) {
        C1283.m16854("nf_subtitles_render", "Apply stroke");
        Integer r2 = C1984mo.m9051(mOVar);
        int intValue = mOVar.m8854() != null ? mOVar.m8854().intValue() : 1;
        if (r2 != null) {
            r4.setStrokeWidth(intValue);
            r4.setStrokeColor(r2.intValue());
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static boolean m4078(View view, View view2, int i) {
        Rect r4 = ViewUtils.m3008(view, true);
        Rect r5 = ViewUtils.m3008(view2, true);
        Point r6 = C1984mo.m9053(r4, r5);
        if (r6 == null) {
            C1283.m16854("nf_subtitles_render", "===> No intersection found");
            return false;
        }
        int i2 = r6.y;
        int i3 = r5.bottom + i2;
        if (i3 > i) {
            C1283.m16865("nf_subtitles_render", "We hit bottom. Set bottom to " + i);
            i2 = (i2 - i3) + i;
        }
        r5.top += i2;
        r5.bottom += i2;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view2.getLayoutParams();
        marginLayoutParams.setMargins(r5.left, r5.top, 0, 0);
        view2.setLayoutParams(marginLayoutParams);
        return true;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static boolean m4079(LinearLayout linearLayout, mR mRVar) {
        if (linearLayout == null || mRVar == null) {
            throw new IllegalArgumentException("region or block is null!");
        }
        C1283.m16854("nf_subtitles_render", "isPositionDefinedInBlock start");
        if (mRVar.m8901() == null) {
            C1283.m16854("nf_subtitles_render", "isPositionDefinedInBlock no region, no need for wrapper");
            return false;
        } else if (mRVar.m8904().size() < 1) {
            C1283.m16865("nf_subtitles_render", "isPositionDefinedInBlock no text blocks!");
            return false;
        } else {
            mM mMVar = mRVar.m8904().get(0);
            if (mMVar == null || mMVar.m8847() == null) {
                C1283.m16865("nf_subtitles_render", "isPositionDefinedInBlock p missing");
                return false;
            }
            lZ r4 = mRVar.m8900().m8877();
            lZ r5 = mRVar.m8900().m8878();
            if (!lZ.m8741(r4) || !lZ.m8741(r5)) {
                C1283.m16854("nf_subtitles_render", "isPositionDefinedInBlock using region defaults for extent and origin, return false");
                return false;
            }
            C1283.m16854("nf_subtitles_render", "isPositionDefinedInBlock using block extent and origin overrides, return true");
            return true;
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static Subtitle m4083(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        int optInt = jSONObject.optInt(BaseSubtitle.IMPL, -1);
        if (optInt == 2) {
            return uV.m11654(jSONObject, jSONObject.getInt(BaseSubtitle.ATTR_ORDER));
        }
        if (optInt == 1) {
            return NccpSubtitle.newInstance(jSONObject);
        }
        if (optInt == 3) {
            return new C1887io(jSONObject);
        }
        if (optInt == 4) {
            return new C1879ig(jSONObject);
        }
        throw new JSONException("Implementation does not support restore " + optInt);
    }
}
