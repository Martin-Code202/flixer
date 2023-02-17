package o;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.support.v4.util.LongSparseArray;
import android.support.v4.util.SparseArrayCompat;
import android.util.Log;
import com.airbnb.lottie.model.layer.Layer;
import com.netflix.mediaclient.acquisition.viewmodels.SignupConstants;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import o.C0413;
import o.C0428;
import o.C0436;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: o.ˋ  reason: contains not printable characters */
public class C0433 {

    /* renamed from: ʻ  reason: contains not printable characters */
    private final long f13436;

    /* renamed from: ʼ  reason: contains not printable characters */
    private final List<Layer> f13437;

    /* renamed from: ʽ  reason: contains not printable characters */
    private final HashSet<String> f13438;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final LongSparseArray<Layer> f13439;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private final float f13440;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final Map<String, C0413> f13441;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private final int f13442;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final Map<String, C0436> f13443;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final Map<String, List<Layer>> f13444;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private final int f13445;

    /* renamed from: ͺ  reason: contains not printable characters */
    private final float f13446;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final SparseArrayCompat<C0428> f13447;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private final long f13448;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final Rect f13449;

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private final int f13450;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final IF f13451;

    private C0433(Rect rect, long j, long j2, float f, float f2, int i, int i2, int i3) {
        this.f13444 = new HashMap();
        this.f13443 = new HashMap();
        this.f13441 = new HashMap();
        this.f13447 = new SparseArrayCompat<>();
        this.f13439 = new LongSparseArray<>();
        this.f13437 = new ArrayList();
        this.f13438 = new HashSet<>();
        this.f13451 = new IF();
        this.f13449 = rect;
        this.f13436 = j;
        this.f13448 = j2;
        this.f13440 = f;
        this.f13446 = f2;
        this.f13442 = i;
        this.f13445 = i2;
        this.f13450 = i3;
        if (!C1026.m16016(this, 4, 5, 0)) {
            m14262("Lottie only supports bodymovin >= 4.5.0");
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m14262(String str) {
        Log.w("LOTTIE", str);
        this.f13438.add(str);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m14259(boolean z) {
        this.f13451.m5162(z);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public IF m14261() {
        return this.f13451;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public Layer m14256(long j) {
        return this.f13439.get(j);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public Rect m14263() {
        return this.f13449;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public long m14267() {
        return (long) ((((float) (this.f13448 - this.f13436)) / this.f13440) * 1000.0f);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public int m14255() {
        return this.f13442;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public int m14258() {
        return this.f13445;
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public int m14254() {
        return this.f13450;
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    public long m14269() {
        return this.f13436;
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public long m14268() {
        return this.f13448;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public List<Layer> m14252() {
        return this.f13437;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public List<Layer> m14264(String str) {
        return this.f13444.get(str);
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public SparseArrayCompat<C0428> m14253() {
        return this.f13447;
    }

    /* renamed from: ˏॱ  reason: contains not printable characters */
    public Map<String, C0413> m14265() {
        return this.f13441;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˋॱ  reason: contains not printable characters */
    public Map<String, C0436> m14260() {
        return this.f13443;
    }

    /* renamed from: ˊॱ  reason: contains not printable characters */
    public float m14257() {
        return (((float) m14267()) * this.f13440) / 1000.0f;
    }

    /* renamed from: ͺ  reason: contains not printable characters */
    public float m14266() {
        return this.f13446;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LottieComposition:\n");
        for (Layer layer : this.f13437) {
            sb.append(layer.m71("\t"));
        }
        return sb.toString();
    }

    /* renamed from: o.ˋ$iF */
    public static class iF {
        /* renamed from: ˎ  reason: contains not printable characters */
        public static AbstractC0432 m14275(Context context, String str, AbstractC0437 r7) {
            try {
                return m14270(context, context.getAssets().open(str), r7);
            } catch (IOException e) {
                throw new IllegalStateException("Unable to find file " + str, e);
            }
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public static AbstractC0432 m14270(Context context, InputStream inputStream, AbstractC0437 r6) {
            AsyncTaskC0412 r3 = new AsyncTaskC0412(context.getResources(), r6);
            r3.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new InputStream[]{inputStream});
            return r3;
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        public static AbstractC0432 m14272(Resources resources, JSONObject jSONObject, AbstractC0437 r6) {
            AsyncTaskC0631 r3 = new AsyncTaskC0631(resources, r6);
            r3.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new JSONObject[]{jSONObject});
            return r3;
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        public static C0433 m14276(Resources resources, InputStream inputStream) {
            try {
                byte[] bArr = new byte[inputStream.available()];
                inputStream.read(bArr);
                return m14278(resources, new JSONObject(new String(bArr, "UTF-8")));
            } catch (IOException e) {
                Log.e("LOTTIE", "Failed to load composition.", new IllegalStateException("Unable to find file.", e));
                return null;
            } catch (JSONException e2) {
                Log.e("LOTTIE", "Failed to load composition.", new IllegalStateException("Unable to load JSON.", e2));
                return null;
            } finally {
                C1026.m16009(inputStream);
            }
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public static C0433 m14278(Resources resources, JSONObject jSONObject) {
            Rect rect = null;
            float f = resources.getDisplayMetrics().density;
            int optInt = jSONObject.optInt("w", -1);
            int optInt2 = jSONObject.optInt("h", -1);
            if (!(optInt == -1 || optInt2 == -1)) {
                rect = new Rect(0, 0, (int) (((float) optInt) * f), (int) (((float) optInt2) * f));
            }
            String[] split = jSONObject.optString("v").split("[.]");
            C0433 r0 = new C0433(rect, jSONObject.optLong("ip", 0), jSONObject.optLong("op", 0), (float) jSONObject.optDouble(SignupConstants.Field.REGION_FR, 0.0d), f, Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]));
            JSONArray optJSONArray = jSONObject.optJSONArray("assets");
            m14277(optJSONArray, r0);
            m14279(optJSONArray, r0);
            m14274(jSONObject.optJSONObject("fonts"), r0);
            m14273(jSONObject.optJSONArray("chars"), r0);
            m14280(jSONObject, r0);
            return r0;
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        private static void m14280(JSONObject jSONObject, C0433 r8) {
            JSONArray optJSONArray = jSONObject.optJSONArray("layers");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                int i = 0;
                for (int i2 = 0; i2 < length; i2++) {
                    Layer r6 = Layer.C0001.m83(optJSONArray.optJSONObject(i2), r8);
                    if (r6.m66() == Layer.LayerType.Image) {
                        i++;
                    }
                    m14271(r8.f13437, r8.f13439, r6);
                }
                if (i > 4) {
                    r8.m14262("You have " + i + " images. Lottie should primarily be used with shapes. If you are using Adobe Illustrator, convert the Illustrator layers to shape layers.");
                }
            }
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        private static void m14279(JSONArray jSONArray, C0433 r11) {
            if (jSONArray != null) {
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    JSONArray optJSONArray = optJSONObject.optJSONArray("layers");
                    if (optJSONArray != null) {
                        ArrayList arrayList = new ArrayList(optJSONArray.length());
                        LongSparseArray longSparseArray = new LongSparseArray();
                        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                            Layer r9 = Layer.C0001.m83(optJSONArray.optJSONObject(i2), r11);
                            longSparseArray.put(r9.m74(), r9);
                            arrayList.add(r9);
                        }
                        r11.f13444.put(optJSONObject.optString("id"), arrayList);
                    }
                }
            }
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        private static void m14277(JSONArray jSONArray, C0433 r7) {
            if (jSONArray != null) {
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    if (optJSONObject.has("p")) {
                        C0436 r5 = C0436.If.m14284(optJSONObject);
                        r7.f13443.put(r5.m14283(), r5);
                    }
                }
            }
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        private static void m14274(JSONObject jSONObject, C0433 r7) {
            JSONArray optJSONArray;
            if (!(jSONObject == null || (optJSONArray = jSONObject.optJSONArray("list")) == null)) {
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    C0413 r5 = C0413.iF.m14221(optJSONArray.optJSONObject(i));
                    r7.f13441.put(r5.m14220(), r5);
                }
            }
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        private static void m14273(JSONArray jSONArray, C0433 r6) {
            if (jSONArray != null) {
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    C0428 r4 = C0428.iF.m14240(jSONArray.optJSONObject(i), r6);
                    r6.f13447.put(r4.hashCode(), r4);
                }
            }
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        private static void m14271(List<Layer> list, LongSparseArray<Layer> longSparseArray, Layer layer) {
            list.add(layer);
            longSparseArray.put(layer.m74(), layer);
        }
    }
}
