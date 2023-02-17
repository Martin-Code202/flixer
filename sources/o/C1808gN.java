package o;

import com.netflix.android.org.json.JSONException;
import com.netflix.msl.MslConstants;
import com.netflix.msl.io.MslEncoderException;
import java.io.InputStream;
import java.io.InputStreamReader;
/* renamed from: o.gN  reason: case insensitive filesystem */
public class C1808gN extends AbstractC1406Dw {

    /* renamed from: ˎ  reason: contains not printable characters */
    private final C0608 f6907;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final AbstractC1400Dq f6908;

    public C1808gN(AbstractC1400Dq dq, InputStream inputStream) {
        this.f6908 = dq;
        this.f6907 = new C0608(new InputStreamReader(inputStream, MslConstants.f4100));
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1406Dw
    /* renamed from: ˋ */
    public C1405Dv mo4765(int i) {
        try {
            if (!this.f6907.m14740()) {
                return null;
            }
            Object r3 = this.f6907.m14736();
            if (r3 instanceof C0355) {
                return new C1809gO(this.f6908, (C0355) r3);
            }
            throw new MslEncoderException("JSON value is not a JSON object.");
        } catch (JSONException e) {
            throw new MslEncoderException("JSON syntax error.", e);
        }
    }
}
