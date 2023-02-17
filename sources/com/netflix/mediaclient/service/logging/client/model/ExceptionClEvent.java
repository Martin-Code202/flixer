package com.netflix.mediaclient.service.logging.client.model;

import org.json.JSONObject;
public class ExceptionClEvent extends Event {
    public static final String CATEGORY_VALUE = "error";
    public static final String NAME_VALUE = "ExceptionLogCl";
    private Error mError = null;

    public ExceptionClEvent(Error error) {
        this.mError = error;
        this.name = NAME_VALUE;
        this.category = CATEGORY_VALUE;
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.service.logging.client.model.Event
    public JSONObject getData() {
        JSONObject data = super.getData();
        if (data == null) {
            data = new JSONObject();
        }
        if (this.mError != null) {
            data.put("errorObj", this.mError.toJSONObject());
        }
        return data;
    }
}
