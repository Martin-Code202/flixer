package o;

import com.netflix.mediaclient.service.webclient.model.leafs.ConsolidatedLoggingSessionSpecification;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
/* access modifiers changed from: package-private */
public class J {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final Map<String, Boolean> f5744 = new HashMap();

    /* renamed from: ˋ  reason: contains not printable characters */
    private final AbstractC1221 f5745;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final Map<String, Random> f5746 = new HashMap();

    J(AbstractC1221 r3) {
        if (r3 == null) {
            throw new IllegalStateException("Config can not be null!");
        }
        this.f5745 = r3;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public boolean m5169(String str) {
        return m5167(str) && !m5168(str);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private boolean m5167(String str) {
        Boolean bool = this.f5744.get(str);
        if (bool != null) {
            C1283.m16851("nf_log_cl", "CL session specification override exist and status enabled %b: ", bool);
            return bool.booleanValue();
        }
        C1283.m16854("nf_log_cl", "CL session cached status not found, check if override exist");
        ConsolidatedLoggingSessionSpecification r6 = this.f5745.mo16523(str);
        if (r6 == null) {
            C1283.m16851("nf_log_cl", "CL session specification override not found. Session is enabled for %s", str);
            return true;
        } else if (r6.getDisableChancePercentagePerUserSession() <= 0) {
            C1283.m16854("nf_log_cl", "CL session is enabled without restrictions");
            return true;
        } else if (r6.getDisableChancePercentagePerUserSession() >= 100) {
            C1283.m16854("nf_log_cl", "CL session is disabled");
            return false;
        } else {
            C1283.m16851("nf_log_cl", "CL session is enabled with restriction that %d of user sessions will not be logged.", Integer.valueOf(r6.getDisableChancePercentagePerUserSession()));
            int nextInt = new Random().nextInt(100);
            boolean z = nextInt >= r6.getDisableChancePercentagePerUserSession();
            C1283.m16851("nf_log_cl", "Rnd value %d, session is enabled %b", Integer.valueOf(nextInt), Boolean.valueOf(z));
            this.f5744.put(str, Boolean.valueOf(z));
            return z;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊ  reason: contains not printable characters */
    public boolean m5168(String str) {
        ConsolidatedLoggingSessionSpecification r5 = this.f5745.mo16523(str);
        if (r5 == null) {
            C1283.m16851("nf_log_cl", "CL session specification override not found. Event can be sent for %s", str);
            return false;
        } else if (r5.getSuppressPercentagePerEvent() <= 0) {
            C1283.m16854("nf_log_cl", "Event should NOT be suppressed.");
            return false;
        } else if (r5.getSuppressPercentagePerEvent() >= 100) {
            C1283.m16854("nf_log_cl", "Event is fully suppressed.");
            return true;
        } else {
            C1283.m16851("nf_log_cl", "Event is suppressed with restriction that %d of created events will not be logged.", Integer.valueOf(r5.getSuppressPercentagePerEvent()));
            Random random = this.f5746.get(str);
            if (random == null) {
                random = new Random();
                this.f5746.put(str, random);
            }
            return !(random.nextInt(100) >= r5.getSuppressPercentagePerEvent());
        }
    }
}
