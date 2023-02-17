package o;

import com.netflix.mediaclient.servicemgr.LogArguments;
import com.netflix.mediaclient.servicemgr.Logblob;
public abstract class jN extends AbstractC1607ca {
    public jN(String str, String str2, String str3) {
        super(str2, str3);
        this.f6134.put("xid", str);
        this.f6134.put("playertype", "offline");
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m7966(LogArguments.LogLevel logLevel) {
        if (logLevel.m1554() > LogArguments.LogLevel.INFO.m1554()) {
            this.f6135 = Logblob.Severity.error;
        }
    }
}
