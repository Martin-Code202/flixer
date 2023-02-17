package o;

import com.netflix.mediaclient.service.logging.client.model.LoggingRequest;
import org.json.JSONObject;
/* renamed from: o.cp  reason: case insensitive filesystem */
public class C1624cp {

    /* renamed from: ˋ  reason: contains not printable characters */
    private static final String f6336 = C1624cp.class.getSimpleName();

    /* renamed from: ʻ  reason: contains not printable characters */
    private String f6337;

    /* renamed from: ʻॱ  reason: contains not printable characters */
    private String f6338 = "stopDownloadDueToExpiredManifest";

    /* renamed from: ʼ  reason: contains not printable characters */
    private String f6339;

    /* renamed from: ʽ  reason: contains not printable characters */
    private String f6340;

    /* renamed from: ʽॱ  reason: contains not printable characters */
    private boolean f6341;

    /* renamed from: ʿ  reason: contains not printable characters */
    private boolean f6342;

    /* renamed from: ˊ  reason: contains not printable characters */
    private int f6343;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private String f6344 = "resumeDownload";

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private JSONObject f6345;

    /* renamed from: ˎ  reason: contains not printable characters */
    private M f6346;

    /* renamed from: ˏ  reason: contains not printable characters */
    private int f6347;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private String f6348 = "startDownload";

    /* renamed from: ͺ  reason: contains not printable characters */
    private String f6349 = "pauseDownload";

    /* renamed from: ॱ  reason: contains not printable characters */
    private C1618cl f6350;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private String f6351 = "completeDownload";

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private String f6352 = "cancelDownload";

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private String f6353 = "stopDownloadDueToError";

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private String f6354;

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private String f6355 = "reportProgress";

    /* renamed from: ᐝ  reason: contains not printable characters */
    private String f6356;

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private String f6357 = "stopDownloadDueToRejectedLicense";

    public C1624cp(String str, String str2, String str3, String str4, String str5, M m) {
        this.f6339 = str;
        this.f6340 = str2;
        this.f6356 = str3;
        this.f6337 = str4;
        this.f6354 = str5;
        this.f6346 = m;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public String m5931() {
        return this.f6339;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public C1624cp m5927(JSONObject jSONObject) {
        if (jSONObject == null) {
            return this;
        }
        this.f6345 = jSONObject.optJSONObject(LoggingRequest.EVENTS);
        return this;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public C1624cp m5932(C1618cl clVar) {
        this.f6350 = clVar;
        return this;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m5925() {
        m5914(this.f6348);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m5920() {
        m5914(this.f6351);
        this.f6346.mo5180();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m5928() {
        m5914(this.f6349);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m5922() {
        m5914(this.f6344);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m5929(int i) {
        if (this.f6345 != null) {
            this.f6343 = i;
            if (!m5917()) {
                m5916(m5913(this.f6345, this.f6355).m5888());
            }
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m5923(String str, String str2) {
        m5915(this.f6338, str, str2);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m5921(String str, String str2) {
        m5915(this.f6353, str, str2);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m5926(String str, String str2) {
        m5915(this.f6357, str, str2);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m5930(String str, String str2) {
        m5915(this.f6352, str, str2);
    }

    public String toString() {
        return "PdsDownloadSession{mPdsLogging=" + this.f6346 + ", lastNotifiedProgressPercentage=" + this.f6347 + ", mDc=" + this.f6350 + ", mPlayableId='" + this.f6339 + "', mOxId='" + this.f6340 + "', mDxId='" + this.f6356 + "', mAppSessionId='" + this.f6337 + "', mUserSessionId='" + this.f6354 + "', mLinkEvents=" + this.f6345 + ", isManifestFetchInProgress=" + this.f6341 + ", isPaused=" + this.f6342 + '}';
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public boolean m5918() {
        return this.f6341;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m5933(boolean z) {
        this.f6341 = z;
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public boolean m5919() {
        return !m5912() && !m5918();
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    private boolean m5912() {
        return this.f6345 != null;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m5914(String str) {
        if (this.f6345 != null) {
            C1283.m16851(f6336, "sending pds download event: %s", str);
            m5916(m5913(this.f6345, str).m5888());
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private C1620cn m5913(JSONObject jSONObject, String str) {
        return new C1620cn(jSONObject, str, this.f6337, this.f6354).m5890(this.f6343).m5889(this.f6350);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m5916(String str) {
        if (C1349Bv.m4107(str)) {
            this.f6346.mo5179(str);
        }
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private boolean m5917() {
        if (this.f6343 == 0 || this.f6343 >= this.f6347 + 30) {
            this.f6347 = this.f6343;
            return false;
        }
        C1283.m16851(f6336, "rate limited progress message percentage: %d, lastNotifiedProgressPercentage: %d, interval: %d", Integer.valueOf(this.f6343), Integer.valueOf(this.f6347), 30);
        return true;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m5915(String str, String str2, String str3) {
        if (this.f6345 != null) {
            m5924(true);
            m5916(m5913(this.f6345, str).m5891(str2, str3).m5888());
            this.f6346.mo5180();
        }
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    public boolean m5934() {
        return this.f6342;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m5924(boolean z) {
        this.f6342 = z;
    }
}
