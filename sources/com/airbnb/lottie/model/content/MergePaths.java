package com.airbnb.lottie.model.content;

import android.util.Log;
import o.AbstractC0342;
import o.AbstractC0420;
import o.AbstractC0741;
import o.C0430;
import o.C1518aux;
import org.json.JSONObject;
public class MergePaths implements AbstractC0342 {

    /* renamed from: ˋ  reason: contains not printable characters */
    private final String f36;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final MergePathsMode f37;

    public enum MergePathsMode {
        Merge,
        Add,
        Subtract,
        Intersect,
        ExcludeIntersections;

        /* access modifiers changed from: private */
        /* renamed from: ˏ  reason: contains not printable characters */
        public static MergePathsMode m29(int i) {
            switch (i) {
                case 1:
                    return Merge;
                case 2:
                    return Add;
                case 3:
                    return Subtract;
                case 4:
                    return Intersect;
                case 5:
                    return ExcludeIntersections;
                default:
                    return Merge;
            }
        }
    }

    private MergePaths(String str, MergePathsMode mergePathsMode) {
        this.f36 = str;
        this.f37 = mergePathsMode;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public String m26() {
        return this.f36;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public MergePathsMode m25() {
        return this.f37;
    }

    @Override // o.AbstractC0342
    /* renamed from: ॱ  reason: contains not printable characters */
    public AbstractC0420 mo27(C1518aux aux, AbstractC0741 r4) {
        if (aux.m5691()) {
            return new C0430(this);
        }
        Log.w("LOTTIE", "Animation contains merge paths but they are disabled.");
        return null;
    }

    public String toString() {
        return "MergePaths{mode=" + this.f37 + '}';
    }

    /* renamed from: com.airbnb.lottie.model.content.MergePaths$if  reason: invalid class name */
    public static class Cif {
        /* renamed from: ˋ  reason: contains not printable characters */
        public static MergePaths m30(JSONObject jSONObject) {
            return new MergePaths(jSONObject.optString("nm"), MergePathsMode.m29(jSONObject.optInt("mm", 1)));
        }
    }
}
