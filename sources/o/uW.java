package o;

import android.content.Context;
import android.util.Pair;
import com.google.gson.Gson;
import com.netflix.mediaclient.R;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
public final class uW {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final uZ[] f10951;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final String f10952 = "nf_mdx";

    /* renamed from: ॱ  reason: contains not printable characters */
    private uZ f10953;

    public uW(Pair<String, String>[] pairArr, String str, boolean z) {
        pairArr = null == pairArr ? new Pair[0] : pairArr;
        if (z) {
            C1283.m16854("nf_mdx", "Include all targets");
            this.f10951 = m11657(pairArr, str);
        } else {
            C1283.m16854("nf_mdx", "Include ONLY remote targets");
            this.f10951 = m11658(pairArr, str);
        }
        if (this.f10953 == null && this.f10951.length > 0) {
            this.f10953 = this.f10951[0];
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private uZ[] m11658(Pair<String, String>[] pairArr, String str) {
        uZ[] uZVarArr = new uZ[pairArr.length];
        for (int i = 0; i < pairArr.length; i++) {
            uZVarArr[i] = uZ.m11677(pairArr[i]);
            if (uZVarArr[i].m11680().equals(str)) {
                this.f10953 = uZVarArr[i];
            }
        }
        return uZVarArr;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private uZ[] m11657(Pair<String, String>[] pairArr, String str) {
        uZ[] uZVarArr = new uZ[(pairArr.length + 1)];
        uZVarArr[0] = uZ.m11676();
        for (int i = 0; i < pairArr.length; i++) {
            uZVarArr[i + 1] = uZ.m11677(pairArr[i]);
            if (uZVarArr[i + 1].m11680().equals(str)) {
                this.f10953 = uZVarArr[i + 1];
            }
        }
        return uZVarArr;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public uZ m11662(int i) {
        if (this.f10951 == null || this.f10951.length <= i) {
            C1283.m16850("nf_mdx", "Target NOT found! This should NOT happen!");
            return null;
        }
        this.f10953 = this.f10951[i];
        return this.f10953;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public uZ[] m11664() {
        return this.f10951;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public uZ m11665() {
        return this.f10953;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public List<String> m11661(Context context) {
        if (this.f10951 == null) {
            C1283.m16850("nf_mdx", "We should never be here. No targets!");
        }
        return m11656(context, this.f10951);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private static List<String> m11656(Context context, uZ[] uZVarArr) {
        ArrayList arrayList = new ArrayList();
        if (uZVarArr != null) {
            for (uZ uZVar : uZVarArr) {
                if (uZVar.m11679()) {
                    arrayList.add(context.getString(R.string.label_localDeviceFriendlyName));
                } else {
                    arrayList.add(uZVar.m11678());
                }
            }
        }
        return arrayList;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public int m11659() {
        for (int i = 0; i < this.f10951.length; i++) {
            if (this.f10951[i].m11679()) {
                C1283.m16854("nf_mdx", "Local device found on position " + i);
                return i;
            }
        }
        C1283.m16850("nf_mdx", "We do NOT have local device from Mobile UI");
        return 0;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public int m11660(String str) {
        if (str == null) {
            C1283.m16850("nf_mdx", "getDevicePositionByUUID:: Given UUID is null!");
            return 0;
        }
        for (int i = 0; i < this.f10951.length; i++) {
            if (str.equals(this.f10951[i].m11680())) {
                C1283.m16854("nf_mdx", "getDevicePositionByUUID:: given device found on position " + i);
                return i;
            }
        }
        C1283.m16850("nf_mdx", "Selected device not found!");
        return 0;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public JSONObject m11663() {
        if (this.f10951 == null) {
            return null;
        }
        try {
            return new JSONObject().put("castDeviceList", new JSONArray(new Gson().toJson(this.f10951)));
        } catch (JSONException e) {
            return null;
        }
    }
}
