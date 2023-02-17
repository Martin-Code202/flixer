package o;

import android.graphics.Bitmap;
import com.android.volley.Request;
import com.android.volley.VolleyError;
import java.util.LinkedList;
public class BR {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final Request<?> f4614;

    /* renamed from: ˋ  reason: contains not printable characters */
    public Bitmap f4615;

    /* renamed from: ˏ  reason: contains not printable characters */
    private VolleyError f4616;

    /* renamed from: ॱ  reason: contains not printable characters */
    public final LinkedList<BT> f4617 = new LinkedList<>();

    public BR(Request<?> request, BT bt) {
        this.f4614 = request;
        this.f4617.add(bt);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public Request.ResourceLocationType m3920() {
        return this.f4614.getResourceLocationType();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m3919(VolleyError volleyError) {
        this.f4616 = volleyError;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public VolleyError m3917() {
        return this.f4616;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m3918(BT bt) {
        this.f4617.add(bt);
    }
}
