package o;

import android.content.Context;
import com.netflix.mediaclient.service.webclient.model.leafs.EogAlert;
public final class zV {
    /* renamed from: ˊ  reason: contains not printable characters */
    public static boolean m13560(int i, EogAlert eogAlert) {
        return i == 1 && !m13567(eogAlert);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static boolean m13562(int i, EogAlert eogAlert) {
        return i > 0 || m13567(eogAlert);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static boolean m13565(EogAlert eogAlert) {
        return C1349Bv.m4107(eogAlert.seeOtherPlansText());
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static boolean m13564(EogAlert eogAlert) {
        return eogAlert.abTestCell() == 5;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static boolean m13567(EogAlert eogAlert) {
        return eogAlert.abTestCell() == 4;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static boolean m13566(C2059ph phVar) {
        return phVar.m9808() != null && !phVar.m9808().isDirty && phVar.m9826() != null && !phVar.m9826().isKidsProfile();
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static boolean m13561(C2059ph phVar) {
        return true;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static boolean m13563(Context context) {
        if (!AD.m3299() || AD.m3290(context) >= 4) {
            return false;
        }
        return true;
    }
}
