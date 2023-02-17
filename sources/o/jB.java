package o;

import com.android.volley.VolleyError;
import com.netflix.mediaclient.StatusCode;
import com.netflix.mediaclient.android.app.NetworkErrorStatus;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.media.Subtitle;
import com.netflix.mediaclient.media.SubtitleUrl;
import com.netflix.mediaclient.service.logging.client.model.DeepErrorElement;
import com.netflix.mediaclient.service.logging.client.model.ExceptionClEvent;
import com.netflix.mediaclient.servicemgr.ISubtitleDef;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
public class jB extends AbstractC1542bQ {
    public jB(String str, SubtitleUrl subtitleUrl, ISubtitleDef.SubtitleFailure subtitleFailure, boolean z, Subtitle subtitle, Status status, String[] strArr, boolean z2) {
        m7849(str, subtitleUrl, subtitleFailure, z, subtitle, status, strArr, z2);
    }

    @Override // com.netflix.mediaclient.servicemgr.Logblob
    /* renamed from: ˋ */
    public String mo680() {
        return "subtitleerror";
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m7849(String str, SubtitleUrl subtitleUrl, ISubtitleDef.SubtitleFailure subtitleFailure, boolean z, Subtitle subtitle, Status status, String[] strArr, boolean z2) {
        if (str != null) {
            try {
                this.f6134.put("playbackoffline", !z2);
                JSONObject jSONObject = new JSONObject();
                this.f6134.put("details", jSONObject);
                this.f6134.put("url", str);
                this.f6134.put("retry", z);
                if (subtitleFailure != null) {
                    jSONObject.put("reason", subtitleFailure.name());
                }
                if (subtitleUrl != null) {
                    this.f6134.put("xid", subtitleUrl.getXid());
                    this.f6134.put("cdnid", subtitleUrl.getCdnId());
                    if (subtitleUrl.getDownloadableId() != null) {
                        this.f6134.put("dlid", subtitleUrl.getDownloadableId());
                    }
                    if (subtitleUrl.getProfile() != null) {
                        this.f6134.put("subtitleType", subtitleUrl.getProfile() != ISubtitleDef.SubtitleProfile.IMAGE ? "text" : "image");
                    }
                }
                if (strArr == null || strArr.length <= 0) {
                    C1283.m16850("nf_subtitles_logblob", "No name servers!!!");
                } else {
                    JSONArray jSONArray = new JSONArray();
                    for (String str2 : strArr) {
                        jSONArray.put(str2);
                    }
                    jSONObject.put("nameServers", jSONArray);
                }
                if (subtitle != null) {
                    jSONObject.put("tracktype", subtitle.getTrackType());
                    if (subtitle.getId() != null) {
                        jSONObject.put("subtitleid", subtitle.getId());
                    }
                    if (subtitle.getLanguageDescription() != null) {
                        jSONObject.put("languagedesc", subtitle.getLanguageDescription());
                    }
                    if (subtitle.getLanguageCodeIso639_1() != null) {
                        this.f6134.put("language", subtitle.getLanguageCodeIso639_1());
                    }
                }
                JSONObject r5 = m7854(status);
                if (r5 != null) {
                    jSONObject.put(ExceptionClEvent.CATEGORY_VALUE, r5);
                } else {
                    jSONObject.put(ExceptionClEvent.CATEGORY_VALUE, new JSONObject());
                }
            } catch (JSONException e) {
                C1283.m16847("nf_subtitles_logblob", "Failed to create JSON object", e);
            } catch (Throwable th) {
                C1283.m16847("nf_subtitles_logblob", "Unable to Log failed subtitle ", th);
            }
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private JSONObject m7854(Status status) {
        if (status == null) {
            return null;
        }
        if (status instanceof NetworkErrorStatus) {
            return m7851((NetworkErrorStatus) status);
        }
        return m7852(status);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private JSONObject m7852(Status status) {
        JSONObject jSONObject = new JSONObject();
        if (status.mo302() != null) {
            jSONObject.put("statusCode", status.mo302().m271());
            jSONObject.put("statusCodeDesc", status.mo302().name());
        }
        if (status.mo307() != null) {
            jSONObject.put(DeepErrorElement.Debug.MESSAGE, C1349Bv.m4109(status.mo307(), 1000));
        }
        return jSONObject;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private JSONObject m7851(NetworkErrorStatus networkErrorStatus) {
        if (networkErrorStatus.m313() == null) {
            return m7852((Status) networkErrorStatus);
        }
        return m7848(networkErrorStatus.m313());
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private JSONObject m7848(VolleyError volleyError) {
        if (volleyError.f128 != null) {
            return m7853(volleyError.f128, volleyError);
        }
        return m7850(volleyError);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private JSONObject m7853(C1181 r6, VolleyError volleyError) {
        JSONObject jSONObject = new JSONObject();
        m7855(volleyError, jSONObject);
        jSONObject.put("statusCode", String.valueOf(r6.f15527));
        jSONObject.put("statusCodeDesc", "HTTP_SC");
        if (r6.f15530 != null) {
            jSONObject.put("rawResponse", C1349Bv.m4109(new String(r6.f15530, "UTF-8"), 1000));
        }
        return jSONObject;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private JSONObject m7850(VolleyError volleyError) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("statusCode", StatusCode.NETWORK_ERROR.m271());
        jSONObject.put("statusCodeDesc", StatusCode.NETWORK_ERROR.name());
        m7855(volleyError, jSONObject);
        return jSONObject;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m7855(VolleyError volleyError, JSONObject jSONObject) {
        if (volleyError.getMessage() != null) {
            jSONObject.put(DeepErrorElement.Debug.MESSAGE, C1349Bv.m4109(volleyError.getMessage(), 1000));
        }
        if (volleyError.getStackTrace() != null) {
            String r3 = C1283.m16858(volleyError, 1000);
            if (C1349Bv.m4107(r3)) {
                jSONObject.put(DeepErrorElement.Debug.STACKTRACE, r3);
            }
        }
        if (volleyError.getCause() != null) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject.put("cause", jSONObject2);
            jSONObject2.put("cause", volleyError.getCause().getClass().getSimpleName());
            if (volleyError.getCause().getMessage() != null) {
                jSONObject2.put(DeepErrorElement.Debug.MESSAGE, C1349Bv.m4109(volleyError.getCause().getMessage(), 1000));
            }
            if (volleyError.getCause().getStackTrace() != null) {
                String r4 = C1283.m16858(volleyError.getCause(), 1000);
                if (C1349Bv.m4107(r4)) {
                    jSONObject2.put(DeepErrorElement.Debug.STACKTRACE, r4);
                }
            }
        }
    }
}
