package com.netflix.mediaclient.service.logging.client.model;

import com.google.gson.annotations.SerializedName;
import com.google.gson.annotations.Since;
import com.netflix.mediaclient.service.webclient.model.leafs.SubtitleDownloadRetryPolicy;
import o.AK;
import o.C1349Bv;
import org.json.JSONObject;
public class HttpResponse {
    public static final String API_SCRIPT_EXECUTION_TIME = "apiScriptExecutionTime";
    public static final String CONTENT_LENGTH = "contentLength";
    public static final String DNS_TIME = "dnsTime";
    public static final String ENDPOINT_REVISION = "apiScriptRevision";
    public static final String MIME_TYPE = "mimeType";
    public static final String PARSE_TIME = "parseTime";
    public static final String RESPONSE_TIME = "responseTime";
    public static final String SERVER_EXECUTION_TIME = "serverExecutionTime";
    public static final String SSL_TIME = "sslTime";
    public static final String TRANSFER_TIME = "transferTime";
    @SerializedName(API_SCRIPT_EXECUTION_TIME)
    @Since(SubtitleDownloadRetryPolicy.DEFAULT_MULTIPLIER)
    private Integer apiScriptExecutionTime;
    @SerializedName(CONTENT_LENGTH)
    @Since(1.0d)
    private Integer contentLength;
    @SerializedName(DNS_TIME)
    @Since(1.0d)
    private Integer dnsTime;
    @SerializedName("endpointRevision")
    @Since(SubtitleDownloadRetryPolicy.DEFAULT_MULTIPLIER)
    private String endpointRevision;
    @SerializedName(MIME_TYPE)
    @Since(1.0d)
    private String mimeType;
    @SerializedName(PARSE_TIME)
    @Since(1.0d)
    private Integer parseTime;
    @SerializedName(RESPONSE_TIME)
    @Since(1.0d)
    private Integer responseTime;
    @SerializedName(SERVER_EXECUTION_TIME)
    @Since(1.0d)
    private Integer serverExecutionTime;
    @SerializedName(SSL_TIME)
    @Since(1.0d)
    private Integer sslTime;
    @SerializedName(TRANSFER_TIME)
    @Since(1.0d)
    private Integer transferTime;

    public Integer getDnsTime() {
        return this.dnsTime;
    }

    public void setDnsTime(Integer num) {
        this.dnsTime = num;
    }

    public Integer getSslTime() {
        return this.sslTime;
    }

    public void setSslTime(Integer num) {
        this.sslTime = num;
    }

    public Integer getResponseTime() {
        return this.responseTime;
    }

    public void setResponseTime(Integer num) {
        this.responseTime = num;
    }

    public Integer getTransferTime() {
        return this.transferTime;
    }

    public void setTransferTime(Integer num) {
        this.transferTime = num;
    }

    public Integer getServerExecutionTime() {
        return this.serverExecutionTime;
    }

    public void setServerExecutionTime(Integer num) {
        this.serverExecutionTime = num;
    }

    public Integer getParseTime() {
        return this.parseTime;
    }

    public void setParseTime(Integer num) {
        this.parseTime = num;
    }

    public Integer getContentLength() {
        return this.contentLength;
    }

    public void setContentLength(Integer num) {
        this.contentLength = num;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public void setMimeType(String str) {
        this.mimeType = str;
    }

    public Integer getApiScriptExecutionTime() {
        return this.apiScriptExecutionTime;
    }

    public void setApiScriptExecutionTime(Integer num) {
        this.apiScriptExecutionTime = num;
    }

    public String getEndpointRevision() {
        return this.endpointRevision;
    }

    public void setEndpointRevision(String str) {
        this.endpointRevision = str;
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        if (this.dnsTime != null) {
            jSONObject.put(DNS_TIME, this.dnsTime);
        }
        if (this.sslTime != null) {
            jSONObject.put(SSL_TIME, this.sslTime);
        }
        if (this.responseTime != null) {
            jSONObject.put(RESPONSE_TIME, this.responseTime);
        }
        if (this.transferTime != null) {
            jSONObject.put(TRANSFER_TIME, this.transferTime);
        }
        if (this.serverExecutionTime != null) {
            jSONObject.put(SERVER_EXECUTION_TIME, this.serverExecutionTime);
        }
        if (this.parseTime != null) {
            jSONObject.put(PARSE_TIME, this.parseTime);
        }
        if (this.contentLength != null) {
            jSONObject.put(CONTENT_LENGTH, this.contentLength);
        }
        if (this.mimeType != null) {
            jSONObject.put(MIME_TYPE, this.mimeType);
        }
        if (!(this.apiScriptExecutionTime == null && this.endpointRevision == null)) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject.put(Event.CUSTOM, jSONObject2);
            if (this.apiScriptExecutionTime != null) {
                jSONObject2.put(API_SCRIPT_EXECUTION_TIME, this.apiScriptExecutionTime);
            }
            if (this.endpointRevision != null) {
                jSONObject2.put(ENDPOINT_REVISION, this.endpointRevision);
            }
        }
        return jSONObject;
    }

    public static HttpResponse createInstance(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        HttpResponse httpResponse = new HttpResponse();
        httpResponse.contentLength = AK.m3374(jSONObject, CONTENT_LENGTH, (Integer) null);
        httpResponse.dnsTime = AK.m3374(jSONObject, DNS_TIME, (Integer) null);
        httpResponse.sslTime = AK.m3374(jSONObject, SSL_TIME, (Integer) null);
        httpResponse.responseTime = AK.m3374(jSONObject, RESPONSE_TIME, (Integer) null);
        httpResponse.transferTime = AK.m3374(jSONObject, TRANSFER_TIME, (Integer) null);
        httpResponse.serverExecutionTime = AK.m3374(jSONObject, SERVER_EXECUTION_TIME, (Integer) null);
        httpResponse.parseTime = AK.m3374(jSONObject, PARSE_TIME, (Integer) null);
        httpResponse.mimeType = AK.m3376(jSONObject, MIME_TYPE, (String) null);
        JSONObject optJSONObject = jSONObject.optJSONObject(Event.CUSTOM);
        if (optJSONObject != null) {
            httpResponse.apiScriptExecutionTime = AK.m3374(optJSONObject, API_SCRIPT_EXECUTION_TIME, (Integer) null);
            httpResponse.endpointRevision = AK.m3376(optJSONObject, ENDPOINT_REVISION, (String) null);
        }
        return httpResponse;
    }

    public static HttpResponse createInstance(String str) {
        if (C1349Bv.m4113(str)) {
            return null;
        }
        return createInstance(new JSONObject(str));
    }

    public String toString() {
        return "HttpResponse [dnsTime=" + this.dnsTime + ", sslTime=" + this.sslTime + ", responseTime=" + this.responseTime + ", transferTime=" + this.transferTime + ", serverExecutionTime=" + this.serverExecutionTime + ", parseTime=" + this.parseTime + ", contentLength=" + this.contentLength + ", mimeType=" + this.mimeType + ", apiScriptExecutionTime=" + this.apiScriptExecutionTime + ", endpointRevision=" + this.endpointRevision + "]";
    }
}
