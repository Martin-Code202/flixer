package o;

import android.content.Intent;
import com.netflix.mediaclient.media.Language;
import org.json.JSONArray;
import org.json.JSONObject;
/* renamed from: o.vs  reason: case insensitive filesystem */
public class C2249vs extends AbstractC2242vl {
    C2249vs() {
        super("com.netflix.mediaclient.intent.action.MDX_ACTION_UPDATE_AUDIOSUB");
    }

    @Override // o.AbstractC2245vo
    /* renamed from: ˋ */
    public void mo12131(AbstractC2238vh vhVar, Intent intent) {
        C1283.m16854("mdxui", "Update audio/subtitles...");
        try {
            JSONObject jSONObject = new JSONObject(intent.getStringExtra("stringBlob"));
            JSONArray r8 = AK.m3377(jSONObject, "timed_text_tracks");
            if (r8 == null) {
                r8 = AK.m3377(jSONObject, "timed_text_track");
            }
            JSONArray r9 = AK.m3377(jSONObject, "audio_tracks");
            if (r9 == null) {
                r9 = AK.m3377(jSONObject, "audio_track");
            }
            uV[] r10 = m12174(r8);
            uR[] r11 = m12172(r9);
            vhVar.mo12143(new Language(r11, m12171(r11), r10, m12173(r10), true));
        } catch (Exception e) {
            C1283.m16847("mdxui", "Failed to extract capability data ", e);
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private int m12173(uV[] uVVarArr) {
        for (int i = 0; i < uVVarArr.length; i++) {
            if (uVVarArr[i].m11655()) {
                return i;
            }
        }
        C1283.m16854("mdxui", "None is selected, default to 0");
        return 0;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private int m12171(uR[] uRVarArr) {
        for (int i = 0; i < uRVarArr.length; i++) {
            if (uRVarArr[i].m11650()) {
                return i;
            }
        }
        C1283.m16854("mdxui", "None is selected, default to 0");
        return 0;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private uV[] m12174(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() < 1) {
            C1283.m16865("mdxui", "Empty subtitle list");
            return new uV[0];
        }
        uV[] uVVarArr = new uV[jSONArray.length()];
        for (int i = 0; i < uVVarArr.length; i++) {
            uVVarArr[i] = uV.m11654(jSONArray.getJSONObject(i), i);
        }
        return uVVarArr;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private uR[] m12172(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() < 1) {
            C1283.m16865("mdxui", "Empty audio list");
            return new uR[0];
        }
        uR[] uRVarArr = new uR[jSONArray.length()];
        for (int i = 0; i < uRVarArr.length; i++) {
            uRVarArr[i] = uR.m11649(jSONArray.getJSONObject(i), i);
        }
        return uRVarArr;
    }
}
