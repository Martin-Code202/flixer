package o;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
/* renamed from: o.ও  reason: contains not printable characters */
public class C0651 {
    /* renamed from: ˏ  reason: contains not printable characters */
    public static int m14810(Request.Priority priority) {
        switch (priority) {
            case LOW:
                return 1;
            case NORMAL:
                return 2;
            case HIGH:
                return 3;
            case IMMEDIATE:
                return 4;
            default:
                C0509.m14519("unknown Request priority: %s", priority);
                return 1;
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static final String m14809(Request request, byte[] bArr) {
        switch (request.getMethod()) {
            case -1:
                try {
                    return (request.getPostBody() == null && bArr == null) ? "GET" : "POST";
                } catch (AuthFailureError e) {
                    C1283.m16844("nf_cronet", "error parsing POST body: %s", e.getMessage());
                    return "GET";
                }
            case 0:
                return bArr == null ? "GET" : "POST";
            case 1:
                return "POST";
            case 2:
                return "PUT";
            case 3:
                return "DELETE";
            default:
                C0509.m14519("unknown Request priority: %s", request.getPriority());
                return "GET";
        }
    }
}
