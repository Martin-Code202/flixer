package com.crittercism.app;

import android.os.Build;
import com.crittercism.internal.cf;
import java.util.LinkedList;
import java.util.List;
public class CrittercismConfig {
    private String a = null;
    private boolean b = false;
    private boolean c = false;
    private boolean d = true;
    private boolean e = true;
    private boolean f = false;
    private boolean g = a();
    private List<String> h = new LinkedList();
    private List<String> i = new LinkedList();

    public CrittercismConfig() {
    }

    public CrittercismConfig(CrittercismConfig crittercismConfig) {
        this.a = crittercismConfig.a;
        this.b = crittercismConfig.b;
        this.c = crittercismConfig.c;
        this.d = crittercismConfig.d;
        this.e = crittercismConfig.e;
        this.f = crittercismConfig.f;
        this.g = crittercismConfig.g;
        setURLBlacklistPatterns(crittercismConfig.h);
        setPreserveQueryStringPatterns(crittercismConfig.i);
    }

    public List<String> getURLBlacklistPatterns() {
        return new LinkedList(this.h);
    }

    public void setURLBlacklistPatterns(List<String> list) {
        this.h.clear();
        if (list != null) {
            this.h.addAll(list);
        }
    }

    public void setPreserveQueryStringPatterns(List<String> list) {
        this.i.clear();
        if (list != null) {
            this.i.addAll(list);
        }
    }

    public List<String> getPreserveQueryStringPatterns() {
        return new LinkedList(this.i);
    }

    public boolean equals(Object obj) {
        boolean z;
        if (!(obj instanceof CrittercismConfig)) {
            return false;
        }
        CrittercismConfig crittercismConfig = (CrittercismConfig) obj;
        if (this.b != crittercismConfig.b || this.f != crittercismConfig.f || this.d != crittercismConfig.d || this.e != crittercismConfig.e || isServiceMonitoringEnabled() != crittercismConfig.isServiceMonitoringEnabled() || isVersionCodeToBeIncludedInVersionString() != crittercismConfig.isVersionCodeToBeIncludedInVersionString()) {
            return false;
        }
        String str = this.a;
        String str2 = crittercismConfig.a;
        if (str == null) {
            z = str2 == null;
        } else {
            z = str.equals(str2);
        }
        return z && this.h.equals(crittercismConfig.h) && this.i.equals(crittercismConfig.i);
    }

    public int hashCode() {
        String str = this.a;
        int i2 = 0;
        if (str != null) {
            i2 = str.hashCode();
        }
        return ((((((i2 + 0) * 31) + this.h.hashCode()) * 31) + this.i.hashCode()) * 31) + Integer.valueOf((((((((((((this.b ? 1 : 0) + 0) << 1) + (this.f ? 1 : 0)) << 1) + (this.d ? 1 : 0)) << 1) + (this.e ? 1 : 0)) << 1) + (isServiceMonitoringEnabled() ? 1 : 0)) << 1) + (isVersionCodeToBeIncludedInVersionString() ? 1 : 0)).hashCode();
    }

    public final String getCustomVersionName() {
        return this.a;
    }

    public final void setCustomVersionName(String str) {
        this.a = str;
    }

    public final boolean delaySendingAppLoad() {
        return this.b;
    }

    public final boolean isVersionCodeToBeIncludedInVersionString() {
        return this.c;
    }

    public final void setVersionCodeToBeIncludedInVersionString(boolean z) {
        this.c = z;
    }

    public final boolean allowsCellularAccess() {
        return this.d;
    }

    public final boolean isLogcatReportingEnabled() {
        return this.f;
    }

    public final void setLogcatReportingEnabled(boolean z) {
        this.f = z;
    }

    private static boolean a() {
        return Build.VERSION.SDK_INT >= 10 && Build.VERSION.SDK_INT <= 23;
    }

    public final boolean isServiceMonitoringEnabled() {
        return this.g;
    }

    public final void setServiceMonitoringEnabled(boolean z) {
        if (a() || !z) {
            this.g = z;
        } else {
            cf.c("OPTMZ is currently only allowed for api levels 10 to 23.  APM will not be installed");
        }
    }
}
