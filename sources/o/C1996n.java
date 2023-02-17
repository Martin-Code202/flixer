package o;

import com.netflix.mediaclient.service.logging.logblob.LogBlobType;
import org.json.JSONException;
/* renamed from: o.n  reason: case insensitive filesystem */
class C1996n extends AbstractC1542bQ {
    @Override // com.netflix.mediaclient.servicemgr.Logblob
    /* renamed from: ˋ */
    public String mo680() {
        return LogBlobType.MAINTENANCE_JOB.m602();
    }

    private C1996n(String str) {
        this.f6134.put("errormsg", str);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    static void m9110(oQ oQVar) {
        if (oQVar != null) {
            try {
                oQVar.mo5226(new C1996n("startJob"));
            } catch (JSONException e) {
                C1283.m16863("maintenanceJobLogblob", "JSONException:", e);
            } catch (Exception e2) {
                C1283.m16863("maintenanceJobLogblob", "Exception:", e2);
            }
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    static void m9109(oQ oQVar) {
        if (oQVar != null) {
            try {
                oQVar.mo5226(new C1996n("stopJob"));
            } catch (JSONException e) {
                C1283.m16863("maintenanceJobLogblob", "JSONException:", e);
            } catch (Exception e2) {
                C1283.m16863("maintenanceJobLogblob", "Exception:", e2);
            }
        }
    }
}
