package o;

import android.content.Context;
import com.netflix.mediaclient.service.logging.client.model.Device;
import com.netflix.mediaclient.service.logging.client.model.Event;
import com.netflix.mediaclient.service.user.UserAgentInterface;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: o.cx  reason: case insensitive filesystem */
public class C1632cx {

    /* renamed from: ॱ  reason: contains not printable characters */
    private static String f6399 = "nf_presentation";

    /* renamed from: ʻ  reason: contains not printable characters */
    private Context f6400;

    /* renamed from: ʽ  reason: contains not printable characters */
    private String f6401;

    /* renamed from: ˊ  reason: contains not printable characters */
    private String f6402;

    /* renamed from: ˋ  reason: contains not printable characters */
    private List<C1630cv> f6403 = new ArrayList();

    /* renamed from: ˎ  reason: contains not printable characters */
    private String f6404;

    /* renamed from: ˏ  reason: contains not printable characters */
    private String f6405;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private String f6406;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private String f6407;

    public C1632cx() {
    }

    public C1632cx(Context context, AbstractC1221 r3, UserAgentInterface userAgentInterface) {
        this.f6400 = context;
        this.f6405 = r3.d_().mo14449();
        this.f6404 = userAgentInterface.mo1374();
        this.f6402 = r3.d_().mo14452();
        this.f6401 = C1318At.m3776(context);
        this.f6406 = Integer.toString(C1317As.m3758());
        this.f6407 = m5987(r3);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m5994(List<C1630cv> list) {
        this.f6403.addAll(m5988(this.f6400, list));
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public JSONObject m5993() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(Device.ESN, this.f6405);
        if (C1349Bv.m4107(this.f6404)) {
            jSONObject.putOpt("country", this.f6404);
        }
        jSONObject.putOpt("device_type", this.f6402);
        jSONObject.putOpt("application_name", this.f6407);
        jSONObject.putOpt("application_v", this.f6401);
        jSONObject.putOpt("sw_version", this.f6406);
        if (this.f6403 != null) {
            JSONArray jSONArray = new JSONArray();
            jSONObject.put(Event.DATA, jSONArray);
            for (C1630cv cvVar : this.f6403) {
                JSONArray r6 = cvVar.m5983();
                for (int i = 0; i < r6.length(); i++) {
                    jSONArray.put(r6.getJSONObject(i));
                }
            }
        }
        return jSONObject;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m5992(String str) {
        if (C1349Bv.m4113(str)) {
            throw new IllegalArgumentException("Cant create PT request from empty string");
        }
        JSONObject jSONObject = new JSONObject(str);
        this.f6405 = AK.m3376(jSONObject, Device.ESN, (String) null);
        this.f6404 = AK.m3376(jSONObject, "country", (String) null);
        this.f6402 = AK.m3376(jSONObject, "device_type", (String) null);
        this.f6407 = AK.m3376(jSONObject, "application_name", (String) null);
        this.f6401 = AK.m3376(jSONObject, "application_v", (String) null);
        this.f6406 = AK.m3376(jSONObject, "sw_version", (String) null);
        JSONArray jSONArray = new JSONArray(AK.m3376(jSONObject, Event.DATA, (String) null));
        for (int i = 0; i < jSONArray.length(); i++) {
            C1630cv r5 = C1630cv.m5976(jSONArray.getJSONObject(i));
            if (r5 != null) {
                this.f6403.add(r5);
            }
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public Map<String, String> m5991() {
        HashMap hashMap = new HashMap();
        hashMap.put(Device.ESN, this.f6405);
        hashMap.put("country", this.f6404);
        hashMap.put("device_type", this.f6402);
        hashMap.put("application_name", this.f6407);
        hashMap.put("application_v", this.f6401);
        hashMap.put("sw_version", this.f6406);
        if (this.f6403 != null) {
            JSONArray jSONArray = new JSONArray();
            for (C1630cv cvVar : this.f6403) {
                C1283.m16854(f6399, String.format("t %d, row %d, rank %d, %s, %s - sending", Long.valueOf(cvVar.m5978()), Integer.valueOf(cvVar.m5980()), Integer.valueOf(cvVar.m5982()), cvVar.m5979(), cvVar.m5981()));
                try {
                    JSONArray r8 = cvVar.m5983();
                    for (int i = 0; i < r8.length(); i++) {
                        jSONArray.put(r8.getJSONObject(i));
                    }
                } catch (JSONException e) {
                    C1283.m16854(f6399, String.format("Error in event json exception %s", e));
                }
            }
            hashMap.put(Event.DATA, jSONArray.toString());
        }
        return hashMap;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private static List<C1630cv> m5988(Context context, List<C1630cv> list) {
        ArrayList arrayList = new ArrayList();
        LinkedList linkedList = new LinkedList();
        int r3 = m5986(context);
        for (C1630cv cvVar : list) {
            if (m5989(linkedList, cvVar, r3)) {
                arrayList.addAll(linkedList);
                linkedList.clear();
            }
            m5990(linkedList, cvVar, r3);
        }
        arrayList.addAll(linkedList);
        return arrayList;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private static boolean m5989(LinkedList<C1630cv> linkedList, C1630cv cvVar, int i) {
        if (linkedList.size() == 0) {
            return false;
        }
        C1630cv last = linkedList.getLast();
        if (last.m5980() == cvVar.m5980() || !C1349Bv.m4126(last.m5977(), cvVar.m5977()) || cvVar.m5978() - last.m5978() > 300) {
            return true;
        }
        return false;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private static void m5990(LinkedList<C1630cv> linkedList, C1630cv cvVar, int i) {
        if (linkedList.size() >= i) {
            C1630cv removeFirst = linkedList.removeFirst();
            C1283.m16854(f6399, String.format("t %d, row %d, rank %d,  %s, %s - !Drop", Long.valueOf(removeFirst.m5978()), Integer.valueOf(removeFirst.m5980()), Integer.valueOf(removeFirst.m5982()), removeFirst.m5979(), removeFirst.m5981()));
        }
        linkedList.add(cvVar);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private static int m5986(Context context) {
        if (!AD.m3306(context)) {
            return 2;
        }
        int i = 2 + 1;
        if (AD.m3299()) {
            return i + 1;
        }
        return i;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private String m5987(AbstractC1221 r2) {
        return "android";
    }
}
