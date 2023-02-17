package o;

import java.util.HashMap;
import java.util.Map;
/* renamed from: o.vn  reason: case insensitive filesystem */
public final class C2244vn {

    /* renamed from: ॱ  reason: contains not printable characters */
    private Map<String, AbstractC2245vo> f11353 = new HashMap();

    public C2244vn() {
        this.f11353.put("com.netflix.mediaclient.intent.action.MDX_ACTION_UPDATE_AUDIOSUB", new C2249vs());
        this.f11353.put("com.netflix.mediaclient.intent.action.MDX_ACTION_UPDATE_CAPABILITY", new C2247vq());
        this.f11353.put("com.netflix.mediaclient.intent.action.MDX_ACTION_UPDATE_STATE", new C2250vt());
        this.f11353.put("com.netflix.mediaclient.intent.action.MDX_ACTION_UPDATE_DIALOGCANCEL", new C2239vi());
        this.f11353.put("com.netflix.mediaclient.intent.action.MDX_ACTION_UPDATE_DIALOGSHOW", new C2236vf());
        this.f11353.put("com.netflix.mediaclient.intent.action.MDX_ACTION_UPDATE_ERROR", new C2243vm());
        this.f11353.put("com.netflix.mediaclient.intent.action.MDX_ACTION__NETWORK_CONNECTIVITY_CHANGE", new C2241vk());
        this.f11353.put("com.netflix.mediaclient.intent.action.MDX_ACTION_UPDATE_MOVIEMETADATA_AVAILABLE", new C2252vv());
        this.f11353.put("com.netflix.mediaclient.intent.action.MDXUPDATE_MOVIEMETADA", new C2251vu());
        this.f11353.put("com.netflix.mediaclient.intent.action.MDX_ACTION_UPDATE_NOTREADY", new C2246vp());
        this.f11353.put("com.netflix.mediaclient.intent.action.MDX_ACTION_UPDATE_READY", new C2248vr());
        this.f11353.put("com.netflix.mediaclient.intent.action.MDX_ACTION_UPDATE_TARGETLIST", new C2255vy());
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public AbstractC2245vo m12170(String str) {
        return this.f11353.get(str);
    }
}
