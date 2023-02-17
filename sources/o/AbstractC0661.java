package o;

import com.android.volley.Request;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
/* renamed from: o.প  reason: contains not printable characters */
public interface AbstractC0661 {

    /* renamed from: ˊ  reason: contains not printable characters */
    public static final Executor f14007 = Executors.newFixedThreadPool(4);

    /* renamed from: ˊ */
    int mo14821();

    /* renamed from: ˊ */
    AbstractC0644 mo14822(String str, Request.Priority priority, Map<String, String> map, Object obj);

    @Deprecated
    /* renamed from: ˋ */
    HttpURLConnection mo14823(URL url);

    /* renamed from: ˎ */
    C0482 mo14824(AbstractC1001 v, AbstractC0419 v2, int i, boolean z, String str);

    /* renamed from: ˎ */
    void mo14825(AbstractC0677 v);

    /* renamed from: ˏ */
    void mo14828(AbstractC0677 v);
}
