package o;

import android.content.Intent;
final class L implements I {

    /* renamed from: ˋ  reason: contains not printable characters */
    private C1528bD f5747;

    /* renamed from: ˎ  reason: contains not printable characters */
    private C1534bI f5748;

    /* renamed from: ˏ  reason: contains not printable characters */
    private C1527bC f5749;

    /* renamed from: ॱ  reason: contains not printable characters */
    private K f5750;

    L(K k) {
        this.f5750 = k;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m5176(String str) {
        C1283.m16846("nf_log_ftl", "starting FTL connection session");
        if (str != null) {
            if (this.f5747 != null) {
                C1283.m16865("nf_log_ftl", "FtlConnectionSession already exist! You can not start it!");
                return;
            }
            this.f5747 = new C1528bD();
            this.f5750.mo4786(this.f5747);
            this.f5750.mo4783(this.f5747.m5717(str));
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m5178() {
        C1283.m16846("nf_log_ftl", "ending FTL connection session");
        if (this.f5747 == null) {
            C1283.m16865("nf_log_ftl", "FtlConnectionSession does NOT exist! This should NOT happen!");
            return;
        }
        this.f5750.mo4783(this.f5747.m5718());
        this.f5750.mo4785(this.f5747);
        this.f5747 = null;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m5174() {
        C1283.m16846("nf_log_ftl", "starting FTL eligible session");
        if (this.f5749 != null) {
            C1283.m16865("nf_log_ftl", "FtlEligibleSession already exist! You can not start it!");
            return;
        }
        this.f5749 = new C1527bC();
        this.f5750.mo4786(this.f5749);
        this.f5750.mo4783(this.f5749.m5716());
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m5173() {
        C1283.m16846("nf_log_ftl", "ending FTL connection session");
        if (this.f5749 == null) {
            C1283.m16865("nf_log_ftl", "FtlEligibleSession does NOT exist! This should NOT happen!");
            return;
        }
        this.f5750.mo4783(this.f5749.m5715());
        this.f5750.mo4785(this.f5749);
        this.f5749 = null;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m5172() {
        C1283.m16846("nf_log_ftl", "starting FTL fallback session");
        if (this.f5748 != null) {
            C1283.m16865("nf_log_ftl", "FtlFallbackModeSession already exist! You can not start it!");
            return;
        }
        this.f5748 = new C1534bI();
        this.f5750.mo4786(this.f5748);
        this.f5750.mo4783(this.f5748.m5750());
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m5175() {
        C1283.m16846("nf_log_ftl", "ending FTL connection session");
        if (this.f5748 == null) {
            C1283.m16865("nf_log_ftl", "FtlFallbackModeSession does NOT exist! This should NOT happen!");
            return;
        }
        this.f5750.mo4783(this.f5748.m5749());
        this.f5750.mo4785(this.f5748);
        this.f5748 = null;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public synchronized void m5171() {
        if (this.f5747 != null) {
            m5178();
        }
        if (this.f5749 != null) {
            m5173();
        }
        if (this.f5748 != null) {
            m5175();
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public boolean m5177(Intent intent) {
        String action = intent.getAction();
        char c = 65535;
        switch (action.hashCode()) {
            case -2128094936:
                if (action.equals("com.netflix.mediaclient.intent.action.LOG_FTL_FALLBACK_MODE_SESSION_ENDED")) {
                    c = 5;
                    break;
                }
                break;
            case -1787044294:
                if (action.equals("com.netflix.mediaclient.intent.action.LOG_FTL_ELIGIBLE_SESSION_STARTED")) {
                    c = 2;
                    break;
                }
                break;
            case -1319991629:
                if (action.equals("com.netflix.mediaclient.intent.action.LOG_FTL_ELIGIBLE_SESSION_ENDED")) {
                    c = 3;
                    break;
                }
                break;
            case -985241745:
                if (action.equals("com.netflix.mediaclient.intent.action.LOG_FTL_FALLBACK_MODE_SESSION_STARTED")) {
                    c = 4;
                    break;
                }
                break;
            case -20761350:
                if (action.equals("com.netflix.mediaclient.intent.action.LOG_FTL_CONNECTION_SESSION_ENDED")) {
                    c = 1;
                    break;
                }
                break;
            case 1232737985:
                if (action.equals("com.netflix.mediaclient.intent.action.LOG_FTL_CONNECTION_SESSION_STARTED")) {
                    c = 0;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                m5176(intent.getStringExtra("via"));
                return true;
            case 1:
                m5178();
                return true;
            case 2:
                m5174();
                return true;
            case 3:
                m5173();
                return true;
            case 4:
                m5172();
                return true;
            case 5:
                m5175();
                return true;
            default:
                return false;
        }
    }
}
