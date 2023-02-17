package com.netflix.mediaclient.service.logging.client.model;

import com.google.gson.annotations.SerializedName;
import com.google.gson.annotations.Since;
import java.util.List;
import o.AK;
import org.json.JSONObject;
public class UIError extends Error {
    public static final String DISPLAYED_MESSAGE = "displayedMessage";
    public static final String UI_ACTION = "uiAction";
    @SerializedName(DISPLAYED_MESSAGE)
    @Since(1.0d)
    private String displayedMessage;
    @SerializedName(UI_ACTION)
    @Since(1.0d)
    private ActionOnUIError uiAction;

    public UIError() {
    }

    public UIError(JSONObject jSONObject) {
        super(jSONObject);
        this.displayedMessage = AK.m3376(jSONObject, DISPLAYED_MESSAGE, (String) null);
        String r2 = AK.m3376(jSONObject, UI_ACTION, (String) null);
        if (r2 != null) {
            this.uiAction = ActionOnUIError.valueOf(r2);
        }
    }

    public UIError(Error error, ActionOnUIError actionOnUIError, String str) {
        super(error.getRootCause(), error.getDeepError());
        this.displayedMessage = str;
        this.uiAction = actionOnUIError;
    }

    public UIError(RootCause rootCause, ActionOnUIError actionOnUIError, String str) {
        this.displayedMessage = str;
        this.uiAction = actionOnUIError;
        this.rootCause = rootCause;
    }

    public UIError(RootCause rootCause, ActionOnUIError actionOnUIError, String str, List<DeepErrorElement> list) {
        super(rootCause, list);
        this.displayedMessage = str;
        this.uiAction = actionOnUIError;
    }

    public ActionOnUIError getUiAction() {
        return this.uiAction;
    }

    public String getDisplayedMessage() {
        return this.displayedMessage;
    }

    @Override // com.netflix.mediaclient.service.logging.client.model.Error
    public String toString() {
        return "UIError [uiAction=" + this.uiAction + ", displayedMessage=" + this.displayedMessage + "]";
    }

    @Override // com.netflix.mediaclient.service.logging.client.model.Error
    public JSONObject toJSONObject() {
        JSONObject jSONObject = super.toJSONObject();
        if (this.uiAction != null) {
            jSONObject.put(UI_ACTION, this.uiAction.name());
        }
        if (this.displayedMessage != null) {
            jSONObject.put(DISPLAYED_MESSAGE, this.displayedMessage);
        }
        return jSONObject;
    }

    public static UIError createInstance(String str) {
        if (str == null) {
            return null;
        }
        return new UIError(new JSONObject(str));
    }

    public static UIError createInstance(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return new UIError(jSONObject);
    }
}
