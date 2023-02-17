package o;

import com.netflix.mediaclient.service.logging.client.model.LoggingRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* renamed from: o.ל  reason: contains not printable characters */
public final class C0558 implements AbstractC0611 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private List<C0713> f13801 = new ArrayList();

    /* renamed from: ˏ  reason: contains not printable characters */
    private SortedMap<Long, AbstractC0556> f13802 = Collections.synchronizedSortedMap(new TreeMap());

    public C0558(Map<Long, AbstractC0556> map, List<C0713> list) {
        C0441.m14304().mo4533("Current state map size: " + map.size());
        this.f13802.putAll(map);
        C0441.m14304().mo4533("Snapshots: " + list.size());
        this.f13801.addAll(list);
    }

    @Override // o.AbstractC0503
    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", "CompactConsolidatedLoggingEnvelope");
        jSONObject.put(LoggingRequest.VERSION, 2);
        jSONObject.put("clientSendTime", C0441.m14299());
        JSONObject jSONObject2 = new JSONObject();
        jSONObject.put("currentState", jSONObject2);
        for (Long l : this.f13802.keySet()) {
            C0441.m14304().mo4533("Add to current state " + l);
            jSONObject2.put(l.toString(), this.f13802.get(l).toJSONObject());
        }
        JSONArray jSONArray = new JSONArray();
        jSONObject.put("reverseDeltas", jSONArray);
        for (C0713 r0 : this.f13801) {
            r0.m15038(jSONArray);
        }
        return jSONObject;
    }
}
