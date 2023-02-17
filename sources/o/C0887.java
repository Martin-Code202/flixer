package o;

import android.graphics.Color;
import android.util.Log;
import java.util.List;
import o.AbstractC0923;
import o.C0987;
import org.json.JSONArray;
import org.json.JSONObject;
/* renamed from: o.ᕀ  reason: contains not printable characters */
public class C0887 extends AbstractC0864<C1009, C1009> {
    private C0887(List<C1297AUx<C1009>> list, C1009 r2) {
        super(list, r2);
    }

    @Override // o.AbstractC0923
    /* renamed from: ˎ */
    public AbstractC1622coN<C1009, C1009> mo14241() {
        if (!m15557()) {
            return new C0418(this.f14716);
        }
        return new C0440(this.f14717);
    }

    /* renamed from: o.ᕀ$iF */
    public static final class iF {
        /* renamed from: ˊ  reason: contains not printable characters */
        public static C0887 m15602(JSONObject jSONObject, C0433 r7) {
            C0987.C0988 r4 = C0987.m15927(jSONObject, 1.0f, r7, new Cif(jSONObject.optInt("p", jSONObject.optJSONArray("k").length() / 4))).m15931();
            return new C0887(r4.f15050, r4.f15049);
        }
    }

    /* renamed from: o.ᕀ$if  reason: invalid class name */
    static class Cif implements AbstractC0923.Cif<C1009> {

        /* renamed from: ˏ  reason: contains not printable characters */
        private final int f14765;

        private Cif(int i) {
            this.f14765 = i;
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        public C1009 mo14319(Object obj, float f) {
            JSONArray jSONArray = (JSONArray) obj;
            float[] fArr = new float[this.f14765];
            int[] iArr = new int[this.f14765];
            C1009 r7 = new C1009(fArr, iArr);
            int i = 0;
            int i2 = 0;
            if (jSONArray.length() != this.f14765 * 4) {
                Log.w("LOTTIE", "Unexpected gradient length: " + jSONArray.length() + ". Expected " + (this.f14765 * 4) + ". This may affect the appearance of the gradient. Make sure to save your After Effects file before exporting an animation with gradients.");
            }
            for (int i3 = 0; i3 < this.f14765 * 4; i3++) {
                int i4 = i3 / 4;
                double optDouble = jSONArray.optDouble(i3);
                switch (i3 % 4) {
                    case 0:
                        fArr[i4] = (float) optDouble;
                        break;
                    case 1:
                        i = (int) (255.0d * optDouble);
                        break;
                    case 2:
                        i2 = (int) (255.0d * optDouble);
                        break;
                    case 3:
                        iArr[i4] = Color.argb(255, i, i2, (int) (255.0d * optDouble));
                        break;
                }
            }
            m15604(r7, jSONArray);
            return r7;
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        private void m15604(C1009 r11, JSONArray jSONArray) {
            int i = this.f14765 * 4;
            if (jSONArray.length() > i) {
                int length = (jSONArray.length() - i) / 2;
                double[] dArr = new double[length];
                double[] dArr2 = new double[length];
                int i2 = 0;
                for (int i3 = i; i3 < jSONArray.length(); i3++) {
                    if (i3 % 2 == 0) {
                        dArr[i2] = jSONArray.optDouble(i3);
                    } else {
                        dArr2[i2] = jSONArray.optDouble(i3);
                        i2++;
                    }
                }
                for (int i4 = 0; i4 < r11.m15964(); i4++) {
                    int i5 = r11.m15966()[i4];
                    r11.m15966()[i4] = Color.argb(m15603((double) r11.m15963()[i4], dArr, dArr2), Color.red(i5), Color.green(i5), Color.blue(i5));
                }
            }
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        private int m15603(double d, double[] dArr, double[] dArr2) {
            for (int i = 1; i < dArr.length; i++) {
                double d2 = dArr[i - 1];
                double d3 = dArr[i];
                if (dArr[i] >= d) {
                    return (int) (C1150.m16328(dArr2[i - 1], dArr2[i], (d - d2) / (d3 - d2)) * 255.0d);
                }
            }
            return (int) (dArr2[dArr2.length - 1] * 255.0d);
        }
    }
}
