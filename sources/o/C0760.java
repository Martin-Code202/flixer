package o;

import android.os.SystemClock;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.netflix.mediaclient.service.logging.client.model.SessionEndedEvent;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpRetryException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import o.AbstractC1001;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.RedirectException;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.impl.cookie.DateUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: o.ᑉ  reason: contains not printable characters */
public class C0760 implements AbstractC0419 {

    /* renamed from: ˏ  reason: contains not printable characters */
    private static int f14377 = 3000;

    /* renamed from: ॱ  reason: contains not printable characters */
    private static int f14378 = 4096;

    /* renamed from: ˋ  reason: contains not printable characters */
    protected final AbstractC0894 f14379;

    /* renamed from: ˎ  reason: contains not printable characters */
    protected final C0815 f14380;

    public C0760(AbstractC0894 r3) {
        this(r3, new C0815(f14378));
    }

    public C0760(AbstractC0894 r1, C0815 r2) {
        this.f14379 = r1;
        this.f14380 = r2;
    }

    @Override // o.AbstractC0419
    /* renamed from: ˎ */
    public C1181 mo6603(Request<?> request) {
        C1023 r16;
        byte[] bArr;
        C0509.m14520("invoked: %s", request.getUrl());
        long elapsedRealtime = SystemClock.elapsedRealtime();
        while (true) {
            HttpResponse httpResponse = null;
            TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
            try {
                HashMap hashMap = new HashMap();
                mo6602(request, hashMap);
                m15182(hashMap, request.getCacheEntry());
                request.setConnected();
                C0509.m14520("performRequest", new Object[0]);
                HttpResponse r0 = this.f14379.mo6595(request, hashMap);
                StatusLine statusLine = r0.getStatusLine();
                int statusCode = statusLine.getStatusCode();
                long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
                C0509.m14520("performRequest done. statusCode: %d, inTime: %d ms", Integer.valueOf(statusCode), Long.valueOf(elapsedRealtime2));
                if (statusCode != 200) {
                    C0509.m14520("Http status: %d", Integer.valueOf(statusCode));
                }
                if (statusCode == 500 || statusCode == 503) {
                    throw new HttpRetryException("retry", statusCode);
                } else if (statusCode == 410) {
                    String r162 = m15188(r0);
                    request.changeHostUrl(r162);
                    throw new RedirectException(r162);
                } else {
                    Map<String, String> r02 = m15183(r0.getAllHeaders());
                    if (statusCode == 301 || statusCode == 302 || statusCode == 307) {
                        String str = r02.get("Location");
                        if (str != null) {
                            request.changeToRedirectedUrl(str);
                            throw new RedirectException(str);
                        }
                        throw new IOException();
                    } else if (statusCode == 304) {
                        return new C1181(304, request.getCacheEntry().f15077, r02, true);
                    } else {
                        if (request instanceof AbstractC1055) {
                            r16 = new C1023(statusCode, r0.getEntity(), r02, false);
                            bArr = new byte[0];
                        } else {
                            bArr = m15187(r0.getEntity());
                            request.releaseResources();
                            r16 = new C1181(statusCode, bArr, r02, false);
                        }
                        m15181(elapsedRealtime2, request, r16, statusLine);
                        m15185(request, bArr.length, elapsedRealtime2);
                        if (statusCode == 200 || statusCode == 204 || statusCode == 206 || statusCode == 202) {
                            return r16;
                        }
                        if (r16 instanceof C1023) {
                            ((C1023) r16).m15993().consumeContent();
                        }
                        throw new IOException();
                    }
                }
            } catch (HttpRetryException e) {
                request.releaseResources();
                m15184("Http500", request, new VolleyError(e));
            } catch (SocketTimeoutException e2) {
                request.releaseResources();
                m15184("socket", request, new TimeoutError());
            } catch (ConnectTimeoutException e3) {
                request.releaseResources();
                m15184("connection", request, new TimeoutError());
            } catch (MalformedURLException e4) {
                request.releaseResources();
                throw new RuntimeException("Bad URL " + request.getUrl(), e4);
            } catch (RedirectException e5) {
                request.releaseResources();
                m15184("redirect", request, new VolleyError(e5.getMessage()));
            } catch (IOException e6) {
                request.releaseResources();
                C0509.m14519("ioexception:", e6);
                int i = 0;
                if (0 != 0) {
                    i = httpResponse.getStatusLine().getStatusCode();
                }
                C0509.m14519("Unexpected response code %d for %s", Integer.valueOf(i), request.getUrl());
                if (0 != 0) {
                    C1181 r13 = new C1181(i, null, treeMap, false);
                    if (i == 401 || i == 403) {
                        m15184("auth", request, new AuthFailureError(r13));
                    } else {
                        throw new ServerError(r13);
                    }
                } else {
                    C0509.m14519("retrying", new Object[0]);
                    m15184("IOException", request, new VolleyError(e6));
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋ */
    public void mo6602(Request request, Map<String, String> map) {
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0027: APUT  (r1v1 java.lang.Object[]), (2 ??[int, float, short, byte, char]), (r2v2 java.lang.Object) */
    /* renamed from: ˊ  reason: contains not printable characters */
    private void m15181(long j, Request<?> request, C1181 r8, StatusLine statusLine) {
        if (j > ((long) f14377)) {
            Object[] objArr = new Object[5];
            objArr[0] = request;
            objArr[1] = Long.valueOf(j);
            objArr[2] = (r8 == null || r8.f15530 == null) ? "null" : Integer.valueOf(r8.f15530.length);
            objArr[3] = Integer.valueOf(statusLine.getStatusCode());
            objArr[4] = Integer.valueOf(request.getRetryPolicy().mo14677());
            C0509.m14520("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", objArr);
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private static String m15186(Request<?> request) {
        return C0721.m15050().m15057(request.getUrl());
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static void m15185(Request<?> request, int i, long j) {
        try {
            String r4 = m15186(request);
            if (r4 != null) {
                C0721.m15050().m15053(r4, SessionEndedEvent.DURATION, Integer.valueOf((int) j), 1);
                C0721.m15050().m15053(r4, "size", Integer.valueOf(i), 1);
            }
        } catch (Exception e) {
            C0509.m14522(e, "ClientStats: Exception:", new Object[0]);
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private static void m15184(String str, Request<?> request, VolleyError volleyError) {
        AbstractC0573 retryPolicy = request.getRetryPolicy();
        int timeoutMs = request.getTimeoutMs();
        try {
            retryPolicy.mo14676(volleyError);
            request.addMarker(String.format("%s-retry [timeout=%s]", str, Integer.valueOf(timeoutMs)));
        } catch (VolleyError e) {
            request.addMarker(String.format("%s-timeout-giveup [timeout=%s]", str, Integer.valueOf(timeoutMs)));
            throw e;
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m15182(Map<String, String> map, AbstractC1001.Cif ifVar) {
        if (ifVar != null) {
            if (ifVar.f15078 != null) {
                map.put("If-None-Match", ifVar.f15078);
            }
            if (ifVar.f15079 > 0) {
                map.put("If-Modified-Since", DateUtils.formatDate(new Date(ifVar.f15079)));
            }
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private byte[] m15187(HttpEntity httpEntity) {
        C1060 r3 = new C1060(this.f14380, (int) httpEntity.getContentLength());
        try {
            InputStream content = httpEntity.getContent();
            if (content == null) {
                throw new ServerError();
            }
            byte[] r0 = this.f14380.m15386(1024);
            while (true) {
                int read = content.read(r0);
                if (read == -1) {
                    break;
                }
                r3.write(r0, 0, read);
            }
            byte[] byteArray = r3.toByteArray();
            try {
                httpEntity.consumeContent();
            } catch (IOException e) {
                C0509.m14523("Error occured when calling consumingContent", new Object[0]);
            }
            this.f14380.m15387(r0);
            r3.close();
            return byteArray;
        } catch (Throwable th) {
            try {
                httpEntity.consumeContent();
            } catch (IOException e2) {
                C0509.m14523("Error occured when calling consumingContent", new Object[0]);
            }
            this.f14380.m15387(null);
            r3.close();
            throw th;
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static Map<String, String> m15183(Header[] headerArr) {
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (int i = 0; i < headerArr.length; i++) {
            treeMap.put(headerArr[i].getName(), headerArr[i].getValue());
        }
        return treeMap;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public String m15188(HttpResponse httpResponse) {
        HttpEntity entity = httpResponse.getEntity();
        if (httpResponse.getStatusLine() == null || entity == null) {
            throw new NullPointerException("Status/entity is NULL. It should NOT happen!");
        }
        try {
            try {
                JSONObject jSONObject = new JSONObject(C0885.m15601(entity.getContent()));
                if (jSONObject.has("host")) {
                    return jSONObject.getString("host");
                }
                return null;
            } catch (JSONException e) {
                C0509.m14519("Json exception reading redirect response %s", e);
                return null;
            }
        } catch (IOException e2) {
            C0509.m14519("IO exception reading redirect response %s", e2);
            return null;
        }
    }
}
