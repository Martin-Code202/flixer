package o;

import com.netflix.cstatssamurai.LruCache;
import com.netflix.mediaclient.service.logging.client.model.Event;
import com.netflix.mediaclient.service.logging.client.model.SessionEndedEvent;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: o.Ꭸ  reason: contains not printable characters */
public class C0721 {

    /* renamed from: ॱ  reason: contains not printable characters */
    private static C0721 f14246;

    /* renamed from: ʻ  reason: contains not printable characters */
    private boolean f14247 = true;

    /* renamed from: ʼ  reason: contains not printable characters */
    private LruCache<Long, String> f14248;

    /* renamed from: ʽ  reason: contains not printable characters */
    private final int f14249 = 100;

    /* renamed from: ˊ  reason: contains not printable characters */
    private HashMap<String, Boolean> f14250;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private C0725 f14251;

    /* renamed from: ˋ  reason: contains not printable characters */
    private HashMap<String, Boolean> f14252;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private final Map<String, String> f14253 = m15048();

    /* renamed from: ˎ  reason: contains not printable characters */
    private HashMap<String, HashMap<String, C0692<Integer>>> f14254;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final String[] f14255 = {"RANDOM-13184FEF-8ABF-4BBA-B995-E07DD7533917", "NFANDROIDD-PRV-P-LGE==NEXUS=5X-5911-C0A895E8B085608B2E11E44BB98763AB2395CE32EC6823C9CF3A08560119B593", "NFANDROID1-PRV-P-LGE==NEXUS=5X-5911-F1DFFFD908041FC15D630BBC3598EAF950856E85ADBCD155910CB9BD31EEAC51"};

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private int f14256;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private String f14257 = null;

    /* renamed from: ˊ  reason: contains not printable characters */
    private static HashMap<String, String> m15048() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("mobile", "m");
        hashMap.put("wired", "w");
        hashMap.put("wifi", "w");
        hashMap.put("wimax", "o");
        hashMap.put("cdma", "o");
        hashMap.put("gsm", "o");
        hashMap.put("bluetooth", "o");
        return hashMap;
    }

    private C0721() {
        m15051("[{\"category\":\"drop\",\"description\":\"ignore / don\\u0027t bucket, unless something above recursively resolves here\",\"remark\":\"also include arbitrary netflix + ccTLDs\",\"hostnamepatterns\":[\"netflix\\\\.net\",\"hailmary\\\\.netflix\\\\.com\",\"www\\\\.netflix\\\\.com\",\"nflxso\\\\.net\"]},{\"category\":\"awsapi\",\"description\":\"AWS API Calls\",\"hostnamepatterns\":[\"android\\\\..*\\\\.cloud\\\\.netflix\\\\.com\",\"api-global\\\\.netflix\\\\.com\",\"api-staging\\\\.netflix\\\\.com\",\"apis\\\\.netflix\\\\.com\",\"search\\\\.netflix\\\\.ca\",\"oca-api\\\\.netflix\\\\.com\"]},{\"category\":\"awslog\",\"description\":\"AWS logging requests\",\"hostnamepatterns\":[\"ichnaea\\\\.netflix\\\\.com\",\"customerevents\\\\.netflix\\\\.com\",\"presentationtracking\\\\.netflix\\\\.com\",\"beacon\\\\.netflix\\\\.com\"]},{\"category\":\"awsboot\",\"description\":\"AWS Boot Requests for client startup\",\"hostnamepatterns\":[\"uiboot\\\\.netflix\\\\.com\",\"appboot\\\\.netflix\\\\.com\"]},{\"category\":\"awslicense\",\"description\":\"AWS License Request traffic\",\"hostnamepatterns\":[\".*\\\\.nrd\\\\.netflix\\\\.com\",\"nrdp\\\\.nccp\\\\.netflix\\\\.com\",\"android\\\\.nccp\\\\.netflix\\\\.com\",\"ios\\\\.nccp\\\\.netflix\\\\.com\",\"cbp\\\\.nccp\\\\.netflix\\\\.com\",\".*\\\\.nccp\\\\.netflix\\\\.com\"]},{\"category\":\"aws\",\"description\":\"General AWS traffic\",\"hostnamepatterns\":[\"account\\\\.netflix\\\\.com\",\"signup\\\\.netflix\\\\.com\",\"fast\\\\.netflix\\\\.com\"]},{\"category\":\"akamai\",\"description\":\"Akamai CDN Resources\",\"hostnamepatterns\":[\"secure\\\\.netflix\\\\.com\",\".*\\\\.netflix\\\\.ca\",\".*\\\\.nflximg\\\\.net\",\".*\\\\.nflximg\\\\.com\",\".*\\\\.nflxext\\\\.com\"]},{\"category\":\"ocso\",\"description\":\"Open Connect small objects\",\"hostnamepatterns\":[\".*\\\\.nflxso\\\\.net\"]},{\"category\":\"ocftl\",\"description\":\"Open Connect FTL\",\"hostnamepatterns\":[\".*\\\\.ftl\\\\.netflix\\\\.com\",\"api-ftl\\\\.netflix\\\\.com\"]},{\"category\":\"oc\",\"description\":\"General Open Connect\",\"remark\":\"might catch too much, but don\\u0027t have a definitive list of OC hostnames\",\"hostnamepatterns\":[\".*\\\\.nflxvideo\\\\.net\",\".*\"]},{\"ignore\":true,\"date\":2.0170214E7,\"rev\":1.0}]");
        this.f14252 = new HashMap<>(this.f14255.length);
        for (String str : this.f14255) {
            this.f14252.put(str, Boolean.TRUE);
        }
        this.f14256 = 0;
        this.f14248 = new LruCache<>(100);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private String m15047(String str, String str2) {
        return str + '.' + str2;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m15051(String str) {
        this.f14251 = new C0725(str);
        List asList = Arrays.asList(this.f14251.m15062());
        if (asList.size() < 1) {
            asList.add("drop");
        }
        this.f14250 = new HashMap<>(asList.size());
        for (String str2 : this.f14251.m15062()) {
            this.f14250.put(str2, Boolean.TRUE);
        }
        this.f14254 = new HashMap<>(asList.size());
        String[] r4 = this.f14251.m15062();
        for (String str3 : r4) {
            String[] strArr = C0704.f14224;
            for (String str4 : strArr) {
                HashMap<String, C0692<Integer>> hashMap = new HashMap<>();
                C0692<Integer> r13 = new C0692<>(Integer.class);
                r13.m14981(1, 30000, 48);
                hashMap.put(SessionEndedEvent.DURATION, r13);
                C0692<Integer> r14 = new C0692<>(Integer.class);
                r14.m14981(1, 131072, 32);
                hashMap.put("size", r14);
                this.f14254.put(m15047(str3, str4), hashMap);
            }
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m15058() {
        if (f14246 != null) {
            m15051("[{\"category\":\"drop\",\"description\":\"ignore / don\\u0027t bucket, unless something above recursively resolves here\",\"remark\":\"also include arbitrary netflix + ccTLDs\",\"hostnamepatterns\":[\"netflix\\\\.net\",\"hailmary\\\\.netflix\\\\.com\",\"www\\\\.netflix\\\\.com\",\"nflxso\\\\.net\"]},{\"category\":\"awsapi\",\"description\":\"AWS API Calls\",\"hostnamepatterns\":[\"android\\\\..*\\\\.cloud\\\\.netflix\\\\.com\",\"api-global\\\\.netflix\\\\.com\",\"api-staging\\\\.netflix\\\\.com\",\"apis\\\\.netflix\\\\.com\",\"search\\\\.netflix\\\\.ca\",\"oca-api\\\\.netflix\\\\.com\"]},{\"category\":\"awslog\",\"description\":\"AWS logging requests\",\"hostnamepatterns\":[\"ichnaea\\\\.netflix\\\\.com\",\"customerevents\\\\.netflix\\\\.com\",\"presentationtracking\\\\.netflix\\\\.com\",\"beacon\\\\.netflix\\\\.com\"]},{\"category\":\"awsboot\",\"description\":\"AWS Boot Requests for client startup\",\"hostnamepatterns\":[\"uiboot\\\\.netflix\\\\.com\",\"appboot\\\\.netflix\\\\.com\"]},{\"category\":\"awslicense\",\"description\":\"AWS License Request traffic\",\"hostnamepatterns\":[\".*\\\\.nrd\\\\.netflix\\\\.com\",\"nrdp\\\\.nccp\\\\.netflix\\\\.com\",\"android\\\\.nccp\\\\.netflix\\\\.com\",\"ios\\\\.nccp\\\\.netflix\\\\.com\",\"cbp\\\\.nccp\\\\.netflix\\\\.com\",\".*\\\\.nccp\\\\.netflix\\\\.com\"]},{\"category\":\"aws\",\"description\":\"General AWS traffic\",\"hostnamepatterns\":[\"account\\\\.netflix\\\\.com\",\"signup\\\\.netflix\\\\.com\",\"fast\\\\.netflix\\\\.com\"]},{\"category\":\"akamai\",\"description\":\"Akamai CDN Resources\",\"hostnamepatterns\":[\"secure\\\\.netflix\\\\.com\",\".*\\\\.netflix\\\\.ca\",\".*\\\\.nflximg\\\\.net\",\".*\\\\.nflximg\\\\.com\",\".*\\\\.nflxext\\\\.com\"]},{\"category\":\"ocso\",\"description\":\"Open Connect small objects\",\"hostnamepatterns\":[\".*\\\\.nflxso\\\\.net\"]},{\"category\":\"ocftl\",\"description\":\"Open Connect FTL\",\"hostnamepatterns\":[\".*\\\\.ftl\\\\.netflix\\\\.com\",\"api-ftl\\\\.netflix\\\\.com\"]},{\"category\":\"oc\",\"description\":\"General Open Connect\",\"remark\":\"might catch too much, but don\\u0027t have a definitive list of OC hostnames\",\"hostnamepatterns\":[\".*\\\\.nflxvideo\\\\.net\",\".*\"]},{\"ignore\":true,\"date\":2.0170214E7,\"rev\":1.0}]");
            this.f14256 = 0;
            this.f14248 = new LruCache<>(100);
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static C0721 m15050() {
        if (f14246 == null) {
            f14246 = new C0721();
        }
        return f14246;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m15053(String str, String str2, Integer num, int i) {
        if (this.f14247 && this.f14250.containsKey(str)) {
            String str3 = "o";
            if (this.f14257 != null && this.f14253.containsKey(this.f14257)) {
                str3 = this.f14253.get(this.f14257);
            }
            this.f14254.get(m15047(str, str3)).get(str2).m14977(num, i);
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m15055(boolean z) {
        this.f14247 = z;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private static Map<String, Integer> m15049(Map<String, Integer> map) {
        HashMap hashMap = new HashMap(map.size());
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue().intValue() != 0) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return hashMap;
    }

    public String toString() {
        try {
            JSONObject jSONObject = new JSONObject();
            String[] r6 = this.f14251.m15062();
            for (String str : r6) {
                for (String str2 : C0704.f14224) {
                    String r14 = m15047(str, str2);
                    ArrayList arrayList = new ArrayList();
                    for (Map.Entry<String, C0692<Integer>> entry : this.f14254.get(r14).entrySet()) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("name", entry.getKey());
                        jSONObject2.put("layout", entry.getValue().m14978());
                        Map<String, Integer> r18 = m15049(entry.getValue().m14979());
                        jSONObject2.put(Event.DATA, new JSONObject(r18));
                        if (r18.size() != 0) {
                            arrayList.add(jSONObject2);
                        }
                    }
                    if (arrayList.size() > 0) {
                        jSONObject.put(r14, new JSONArray((Collection) arrayList));
                    }
                }
            }
            return jSONObject.toString();
        } catch (ClassCastException | JSONException e) {
            return "{}";
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m15056() {
        String r3 = toString();
        if (this.f14256 != r3.hashCode()) {
            this.f14248.put(Long.valueOf(System.nanoTime()), r3);
            this.f14256 = r3.hashCode();
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public String m15054() {
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        boolean z = true;
        for (Map.Entry<Long, String> entry : this.f14248.entrySet()) {
            if (z) {
                z = false;
            } else {
                sb.append(", ");
            }
            sb.append("\"" + entry.getKey() + "\":" + entry.getValue());
        }
        sb.append('}');
        return sb.toString();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public String m15057(String str) {
        try {
            URI uri = new URI(str);
            if (uri.getHost() != null) {
                return this.f14251.m15063(uri.getHost());
            }
            return null;
        } catch (NullPointerException | URISyntaxException e) {
            return null;
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m15052(String str) {
        this.f14257 = str;
    }
}
