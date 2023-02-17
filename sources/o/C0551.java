package o;

import android.util.Log;
import com.airbnb.lottie.model.content.MergePaths;
import com.airbnb.lottie.model.content.PolystarShape;
import com.airbnb.lottie.model.content.ShapeStroke;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import o.C0364;
import o.C0410;
import o.C0438;
import o.C0862;
import o.C0984;
import o.C0996;
import o.C1022;
import o.C1287;
import org.json.JSONArray;
import org.json.JSONObject;
/* renamed from: o.ו  reason: contains not printable characters */
public class C0551 implements AbstractC0342 {

    /* renamed from: ˋ  reason: contains not printable characters */
    private final List<AbstractC0342> f13770;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final String f13771;

    /* renamed from: ˊ  reason: contains not printable characters */
    public static AbstractC0342 m14596(JSONObject jSONObject, C0433 r7) {
        String optString = jSONObject.optString("ty");
        char c = 65535;
        switch (optString.hashCode()) {
            case 3239:
                if (optString.equals("el")) {
                    c = 7;
                    break;
                }
                break;
            case 3270:
                if (optString.equals("fl")) {
                    c = 3;
                    break;
                }
                break;
            case 3295:
                if (optString.equals("gf")) {
                    c = 4;
                    break;
                }
                break;
            case 3307:
                if (optString.equals("gr")) {
                    c = 0;
                    break;
                }
                break;
            case 3308:
                if (optString.equals("gs")) {
                    c = 2;
                    break;
                }
                break;
            case 3488:
                if (optString.equals("mm")) {
                    c = 11;
                    break;
                }
                break;
            case 3633:
                if (optString.equals("rc")) {
                    c = '\b';
                    break;
                }
                break;
            case 3646:
                if (optString.equals("rp")) {
                    c = '\f';
                    break;
                }
                break;
            case 3669:
                if (optString.equals("sh")) {
                    c = 6;
                    break;
                }
                break;
            case 3679:
                if (optString.equals("sr")) {
                    c = '\n';
                    break;
                }
                break;
            case 3681:
                if (optString.equals("st")) {
                    c = 1;
                    break;
                }
                break;
            case 3705:
                if (optString.equals("tm")) {
                    c = '\t';
                    break;
                }
                break;
            case 3710:
                if (optString.equals("tr")) {
                    c = 5;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return If.m14600(jSONObject, r7);
            case 1:
                return ShapeStroke.C0000.m52(jSONObject, r7);
            case 2:
                return C1287.iF.m16881(jSONObject, r7);
            case 3:
                return C0410.C0411.m14215(jSONObject, r7);
            case 4:
                return C0996.C0997.m15941(jSONObject, r7);
            case 5:
                return C0984.C0985.m15921(jSONObject, r7);
            case 6:
                return C0364.Cif.m14065(jSONObject, r7);
            case 7:
                return C0862.C0863.m15556(jSONObject, r7);
            case '\b':
                return C1022.Cif.m15992(jSONObject, r7);
            case '\t':
                return ShapeTrimPath.iF.m59(jSONObject, r7);
            case '\n':
                return PolystarShape.Cif.m41(jSONObject, r7);
            case 11:
                return MergePaths.Cif.m30(jSONObject);
            case '\f':
                return C0438.C0439.m14289(jSONObject, r7);
            default:
                Log.w("LOTTIE", "Unknown shape type " + optString);
                return null;
        }
    }

    public C0551(String str, List<AbstractC0342> list) {
        this.f13771 = str;
        this.f13770 = list;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.ו$If */
    public static class If {
        /* access modifiers changed from: private */
        /* renamed from: ॱ  reason: contains not printable characters */
        public static C0551 m14600(JSONObject jSONObject, C0433 r7) {
            JSONArray optJSONArray = jSONObject.optJSONArray("it");
            String optString = jSONObject.optString("nm");
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                AbstractC0342 r5 = C0551.m14596(optJSONArray.optJSONObject(i), r7);
                if (r5 != null) {
                    arrayList.add(r5);
                }
            }
            return new C0551(optString, arrayList);
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public String m14597() {
        return this.f13771;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public List<AbstractC0342> m14598() {
        return this.f13770;
    }

    @Override // o.AbstractC0342
    /* renamed from: ॱ */
    public AbstractC0420 mo27(C1518aux aux, AbstractC0741 r3) {
        return new C1517auX(aux, r3, this);
    }

    public String toString() {
        return "ShapeGroup{name='" + this.f13771 + "' Shapes: " + Arrays.toString(this.f13770.toArray()) + '}';
    }
}
