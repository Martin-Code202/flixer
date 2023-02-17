package com.netflix.mediaclient.service.logging.client.model;

import android.util.Log;
import com.google.gson.annotations.SerializedName;
import com.google.gson.annotations.Since;
import o.AK;
import org.json.JSONObject;
public class DeepErrorElement {
    public static final String DEBUG = "debug";
    public static final String ERROR_CODE = "errorCode";
    public static final String FATAL = "fatal";
    @SerializedName(DEBUG)
    @Since(1.0d)
    private Debug debug;
    @SerializedName("errorCode")
    @Since(1.0d)
    private String errorCode;
    @SerializedName(FATAL)
    @Since(1.0d)
    private boolean fatal;

    public String getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(String str) {
        this.errorCode = str;
    }

    public boolean isFatal() {
        return this.fatal;
    }

    public void setFatal(boolean z) {
        this.fatal = z;
    }

    public Debug getDebug() {
        return this.debug;
    }

    public void setDebug(Debug debug2) {
        this.debug = debug2;
    }

    public String toString() {
        return "DeepErrorElement [errorCode=" + this.errorCode + ", fatal=" + this.fatal + ", debug=" + this.debug + "]";
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        if (this.debug != null) {
            jSONObject.put(DEBUG, this.debug.toJSONObject());
        }
        if (this.errorCode != null) {
            jSONObject.put("errorCode", this.errorCode);
        }
        jSONObject.put(FATAL, this.fatal);
        return jSONObject;
    }

    public static DeepErrorElement createInstance(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        DeepErrorElement deepErrorElement = new DeepErrorElement();
        deepErrorElement.debug = Debug.createInstance(AK.m3380(jSONObject, DEBUG, (JSONObject) null));
        deepErrorElement.errorCode = AK.m3376(jSONObject, "errorCode", (String) null);
        deepErrorElement.fatal = AK.m3381(jSONObject, FATAL, false);
        return deepErrorElement;
    }

    public static class Debug {
        public static final String CLASSNAME = "className";
        public static final String MESSAGE = "message";
        public static final String STACKTRACE = "stackTrace";
        private static final String STR_MESSAGE = "srtMessage";
        private static final String ST_FILE_NAME = "stackTraceFileName";
        private static final String ST_LINE_NUMBER = "stackTraceLineNumber";
        private static final String ST_METHOD_NAME = "stackTraceMethodName";
        @SerializedName(CLASSNAME)
        private String className;
        @SerializedName(MESSAGE)
        @Since(1.0d)
        private JSONObject message;
        @SerializedName(STACKTRACE)
        @Since(1.0d)
        private String stackTrace;
        @SerializedName(ST_FILE_NAME)
        @Since(1.0d)
        private String stackTraceFileName;
        @SerializedName(ST_LINE_NUMBER)
        @Since(1.0d)
        private Integer stackTraceLineNumber;
        @SerializedName(ST_METHOD_NAME)
        @Since(1.0d)
        private String stackTraceMethodName;
        @SerializedName("strMessage")
        @Since(1.0d)
        private String strMessage;

        public String getStackTrace() {
            return this.stackTrace;
        }

        public void setStackTrace(String str) {
            this.stackTrace = str;
        }

        public void setStackTrace(Throwable th) {
            if (th != null) {
                setStackTrace(Log.getStackTraceString(th));
                if (th.getStackTrace().length > 0 && th.getStackTrace()[0] != null) {
                    setStackTraceFileName(th.getStackTrace()[0].getFileName());
                    setStackTraceLineNumber(th.getStackTrace()[0].getLineNumber());
                    setStackTraceMethodName(th.getStackTrace()[0].getMethodName());
                }
            }
        }

        public JSONObject getMessage() {
            return this.message;
        }

        public void setMessage(JSONObject jSONObject) {
            this.message = jSONObject;
        }

        public String toString() {
            return "Debug [className=" + this.className + ", stackTrace=" + this.stackTrace + ", message=" + this.message + "]";
        }

        public JSONObject toJSONObject() {
            JSONObject jSONObject = new JSONObject();
            if (this.stackTrace != null) {
                jSONObject.put(STACKTRACE, this.stackTrace);
            }
            if (this.message != null) {
                jSONObject.put(MESSAGE, this.message);
            }
            if (this.strMessage != null) {
                jSONObject.put(STR_MESSAGE, this.strMessage);
            }
            if (this.stackTraceFileName != null) {
                jSONObject.put(ST_FILE_NAME, this.stackTraceFileName);
            }
            if (this.stackTraceLineNumber != null) {
                jSONObject.put(ST_LINE_NUMBER, this.stackTraceLineNumber);
            }
            if (this.stackTraceMethodName != null) {
                jSONObject.put(ST_METHOD_NAME, this.stackTraceMethodName);
            }
            if (this.className != null) {
                jSONObject.put(CLASSNAME, this.className);
            }
            return jSONObject;
        }

        public static Debug createInstance(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            Debug debug = new Debug();
            debug.stackTrace = AK.m3376(jSONObject, STACKTRACE, (String) null);
            debug.message = AK.m3380(jSONObject, MESSAGE, (JSONObject) null);
            debug.strMessage = AK.m3376(jSONObject, STR_MESSAGE, (String) null);
            debug.stackTraceFileName = AK.m3376(jSONObject, ST_FILE_NAME, (String) null);
            debug.stackTraceLineNumber = AK.m3374(jSONObject, ST_LINE_NUMBER, (Integer) null);
            debug.stackTraceMethodName = AK.m3376(jSONObject, ST_METHOD_NAME, (String) null);
            debug.className = AK.m3376(jSONObject, CLASSNAME, (String) null);
            return debug;
        }

        public void setMessage(String str) {
            this.strMessage = str;
        }

        public void setStackTraceFileName(String str) {
            this.stackTraceFileName = str;
        }

        public void setStackTraceLineNumber(int i) {
            this.stackTraceLineNumber = Integer.valueOf(i);
        }

        public void setStackTraceMethodName(String str) {
            this.stackTraceMethodName = str;
        }

        public void setClassName(String str) {
            this.className = str;
        }
    }
}
