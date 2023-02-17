package com.netflix.mediaclient.service.logging.uiview.model;

import com.netflix.mediaclient.service.logging.client.model.Device;
import com.netflix.mediaclient.service.logging.client.model.DeviceUniqueId;
import com.netflix.mediaclient.service.logging.client.model.Event;
import com.netflix.mediaclient.servicemgr.UIViewLogging;
import o.AbstractC1735ev;
import o.C1349Bv;
import org.json.JSONObject;
public class CommandEndedEvent extends AbstractC1735ev {

    /* renamed from: ˋ  reason: contains not printable characters */
    private static final Integer f1279 = 1;

    /* renamed from: ʻ  reason: contains not printable characters */
    private JSONObject f1280;

    /* renamed from: ˊ  reason: contains not printable characters */
    private String f1281;

    /* renamed from: ˎ  reason: contains not printable characters */
    private InputMethod f1282;

    /* renamed from: ˏ  reason: contains not printable characters */
    private UIViewLogging.UIViewCommandName f1283;

    /* renamed from: ॱ  reason: contains not printable characters */
    private InputValue f1284;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private JSONObject f1285;

    public enum InputMethod {
        key,
        voice,
        gesture,
        pointer,
        url
    }

    public enum InputValue {
        swipe,
        touch,
        tap,
        doubleTap
    }

    public CommandEndedEvent(DeviceUniqueId deviceUniqueId, long j, UIViewLogging.UIViewCommandName uIViewCommandName, String str) {
        super("command", deviceUniqueId, j);
        this.f1283 = uIViewCommandName;
        this.f1281 = str;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m678(JSONObject jSONObject) {
        this.f1280 = jSONObject;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m677(JSONObject jSONObject) {
        this.f1285 = jSONObject;
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.service.logging.client.model.Event
    public JSONObject getData() {
        JSONObject data = super.getData();
        if (data == null) {
            data = new JSONObject();
        }
        if (this.f1285 != null) {
            data.put(Event.DATA, this.f1285);
        }
        if (this.f1283 != null) {
            data.put("name", this.f1283.name());
            if (C1349Bv.m4107(this.f1281)) {
                data.put("inputMethod", InputMethod.url.name());
                data.put("inputValue", this.f1281);
            } else {
                if (this.f1282 == null) {
                    this.f1282 = InputMethod.gesture;
                }
                data.put("inputMethod", this.f1282.name());
                if (this.f1284 == null) {
                    this.f1284 = InputValue.tap;
                }
                data.put("inputValue", this.f1284.name());
            }
            data.put("isHotKey", "false");
            data.put("confidence", f1279);
            if (this.f1280 != null) {
                data.put(Device.MODEL, this.f1280);
            }
        }
        return data;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m675(InputMethod inputMethod) {
        this.f1282 = inputMethod;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m676(InputValue inputValue) {
        this.f1284 = inputValue;
    }
}
