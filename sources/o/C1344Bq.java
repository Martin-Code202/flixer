package o;

import android.content.Context;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.media.AudioSource;
import com.netflix.mediaclient.media.AudioSubtitleDefaultOrderInfo;
import com.netflix.mediaclient.media.Language;
import com.netflix.mediaclient.media.Subtitle;
import com.netflix.mediaclient.servicemgr.IPlayer;
/* renamed from: o.Bq  reason: case insensitive filesystem */
public class C1344Bq {

    /* renamed from: ˊ  reason: contains not printable characters */
    private static final String f4659 = C1344Bq.class.getName();

    /* renamed from: ˏ  reason: contains not printable characters */
    public static AudioSource m4072(Context context, oM oMVar) {
        AudioSource r2 = m4070(context, oMVar).m3394();
        if (r2 == null) {
            C1283.m16854(f4659, "No initial audio source");
        }
        return r2;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static Subtitle m4073(Context context, oM oMVar) {
        Subtitle r2 = m4070(context, oMVar).m3395();
        if (r2 == null) {
            C1283.m16854(f4659, "No initial subtitle");
        }
        return r2;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static AN m4070(Context context, oM oMVar) {
        Subtitle[] r7 = oMVar.mo890();
        AudioSource[] r8 = oMVar.mo7753();
        AudioSubtitleDefaultOrderInfo[] r9 = oMVar.mo894();
        C1283.m16854(f4659, "Create localization manager");
        return new C2266wh(context, r7, r8, r9, oMVar.mo914() == IPlayer.PlaybackType.OfflinePlayback).m12429();
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static Subtitle m4071(Context context, oM oMVar) {
        int lastIndexOf;
        String str = "";
        C2059ph r3 = C2059ph.m9741((NetflixActivity) context);
        if (!(r3 == null || r3.m9826().getLanguages().length == 0 || (lastIndexOf = (str = r3.m9826().getLanguages()[0]).lastIndexOf(45)) <= 0)) {
            str = str.substring(0, lastIndexOf);
        }
        Subtitle[] r4 = oMVar.mo890();
        if (r4 != null) {
            for (Subtitle subtitle : r4) {
                if (!subtitle.isForcedNarrativeOrNone() && subtitle.getLanguageCodeIso639_1().equals(str)) {
                    return subtitle;
                }
            }
        }
        C1283.m16850(f4659, "Cannot find subtitle corresponding to current locale");
        return null;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static Language m4069(Context context, oM oMVar) {
        if (oMVar == null) {
            return null;
        }
        Subtitle[] r6 = oMVar.mo890();
        AudioSource[] r7 = oMVar.mo7753();
        AN r8 = m4070(context, oMVar);
        AudioSource r9 = r8.m3394();
        int i = -1;
        if (r9 != null) {
            i = r9.getNccpOrderNumber();
        }
        boolean z = false;
        Subtitle r12 = r8.m3395();
        int i2 = -1;
        if (r12 != null) {
            i2 = r12.getNccpOrderNumber();
            z = true;
        }
        return new Language(r7, i, r6, i2, z);
    }
}
