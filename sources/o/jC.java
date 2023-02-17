package o;

import java.io.UnsupportedEncodingException;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;
import org.json.JSONException;
import org.json.JSONObject;
public final class jC extends jH {

    /* renamed from: ˊ  reason: contains not printable characters */
    private static final String f7869 = jC.class.getSimpleName();

    /* renamed from: ʼ  reason: contains not printable characters */
    private int f7870;

    /* renamed from: ॱ  reason: contains not printable characters */
    private byte[] f7871;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private boolean f7872;

    public jC(String str) {
        super(str);
        m7857(str);
    }

    @Override // o.jH
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo7858() {
        C1283.m16851(f7869, "original length %d", Integer.valueOf(this.f7870));
        if (!this.f7872) {
            super.mo7858();
        } else {
            this.f7941 = m7856();
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m7857(String str) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            byte[] bArr = new byte[bytes.length];
            Deflater deflater = new Deflater();
            deflater.setInput(bytes);
            deflater.finish();
            int deflate = deflater.deflate(bArr);
            deflater.end();
            this.f7870 = bytes.length;
            this.f7871 = new byte[deflate];
            System.arraycopy(bArr, 0, this.f7871, 0, deflate);
            this.f7872 = true;
            this.f7955 = null;
        } catch (Throwable th) {
            this.f7871 = null;
            this.f7872 = false;
        }
    }

    /* renamed from: ˋˋ  reason: contains not printable characters */
    private JSONObject m7856() {
        try {
            Inflater inflater = new Inflater();
            inflater.setInput(this.f7871);
            byte[] bArr = new byte[this.f7870];
            int inflate = inflater.inflate(bArr);
            inflater.end();
            return new JSONObject(new String(bArr, 0, inflate, "UTF-8"));
        } catch (DataFormatException e) {
            m7916();
            throw new JSONException("fail to create JSONObject, " + e);
        } catch (UnsupportedEncodingException e2) {
            m7916();
            throw new JSONException("fail to create JSONObject, " + e2);
        } catch (JSONException e3) {
            m7916();
            throw e3;
        }
    }
}
