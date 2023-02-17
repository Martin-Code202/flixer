package o;

import com.google.gson.annotations.SerializedName;
/* access modifiers changed from: package-private */
public class lM {
    @SerializedName("activityDenominator")
    protected Integer activityDenominator;
    @SerializedName("aseReportDenominator")
    protected Integer aseReportDenominator;
    @SerializedName("enableDlreportErrorLogs")
    protected boolean enableDlReportErrorLogs;
    @SerializedName("exoDlReportDenominator")
    protected Integer exoDlReportDenominator;
    @SerializedName("groupName")
    protected String groupName;

    /* renamed from: ˋ  reason: contains not printable characters */
    private transient boolean f8548;

    /* renamed from: ˏ  reason: contains not printable characters */
    private transient boolean f8549;

    /* renamed from: ॱ  reason: contains not printable characters */
    private transient boolean f8550;

    protected lM() {
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m8648() {
        int random = (int) (Math.random() * 2.147483647E9d);
        if (this.exoDlReportDenominator != null && this.exoDlReportDenominator.intValue() > 0) {
            this.f8550 = random % this.exoDlReportDenominator.intValue() == 0;
        }
        if (this.aseReportDenominator != null && this.aseReportDenominator.intValue() > 0) {
            this.f8549 = random % this.aseReportDenominator.intValue() == 0;
        }
        if (this.activityDenominator != null && this.activityDenominator.intValue() > 0) {
            this.f8548 = random % this.activityDenominator.intValue() == 0;
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public String m8651() {
        return this.groupName == null ? "control" : this.groupName;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public boolean m8649() {
        return this.f8550;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱ  reason: contains not printable characters */
    public boolean m8652() {
        return this.f8549;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˎ  reason: contains not printable characters */
    public boolean m8650() {
        return this.enableDlReportErrorLogs;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ʽ  reason: contains not printable characters */
    public boolean m8647() {
        return this.f8548;
    }
}
