package com.netflix.mediaclient.service.player.bladerunnerclient.volley;

import android.content.Context;
import com.netflix.mediaclient.StatusCode;
import com.netflix.mediaclient.android.app.BaseStatus;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.service.logging.client.model.Error;
import com.netflix.mediaclient.service.logging.client.model.ExceptionClEvent;
import o.AbstractC2101qu;
import o.C0510;
import o.C1281;
import o.C1283;
import o.C1332Be;
import o.C1349Bv;
import o.iT;
import org.json.JSONException;
import org.json.JSONObject;
public class BladerunnerErrorStatus extends BaseStatus {

    /* renamed from: ˏ  reason: contains not printable characters */
    private static final String f1684 = iT.f7647;

    /* renamed from: ʻ  reason: contains not printable characters */
    private String f1685;

    /* renamed from: ʼ  reason: contains not printable characters */
    private JSONObject f1686 = new JSONObject();

    /* renamed from: ʽ  reason: contains not printable characters */
    private String f1687;

    /* renamed from: ˊ  reason: contains not printable characters */
    private String f1688;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private BrRequestType f1689;

    /* renamed from: ˎ  reason: contains not printable characters */
    private String f1690;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private int f1691 = -1;

    /* renamed from: ͺ  reason: contains not printable characters */
    private Context f1692;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private JSONObject f1693 = new JSONObject();

    /* renamed from: ᐝ  reason: contains not printable characters */
    private int f1694 = -1;

    public BladerunnerErrorStatus(Context context, JSONObject jSONObject, BrRequestType brRequestType) {
        this.f1692 = context;
        this.f1689 = brRequestType;
        if (!m955(jSONObject)) {
            this.f849 = StatusCode.OK;
            return;
        }
        this.f849 = StatusCode.BLADERUNNER_FAILURE;
        if (DeviceCommandHandler.m974(jSONObject)) {
            C1283.m16850(f1684, "DeviceCommand from server... fatal !!!");
            DeviceCommandHandler.m975(context, jSONObject);
            return;
        }
        m960(jSONObject);
    }

    @Override // com.netflix.mediaclient.android.app.BaseStatus, com.netflix.mediaclient.android.app.Status
    /* renamed from: ʽ */
    public Status.ErrorGroup mo295() {
        return Status.ErrorGroup.BladerunnerError;
    }

    /* renamed from: ˋॱ  reason: contains not printable characters */
    public String m962() {
        return "BR" + this.f1689.m970() + "." + this.f1688;
    }

    /* renamed from: ͺ  reason: contains not printable characters */
    public String m964() {
        return this.f1693.toString();
    }

    /* renamed from: ˏॱ  reason: contains not printable characters */
    public String m963() {
        return this.f1688;
    }

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    public String m968() {
        return this.f1685;
    }

    /* renamed from: ॱˎ  reason: contains not printable characters */
    public String m966() {
        return this.f1687;
    }

    /* renamed from: ॱˋ  reason: contains not printable characters */
    public int m965() {
        return this.f1691;
    }

    @Override // com.netflix.mediaclient.android.app.BaseStatus
    /* renamed from: ʼ */
    public C0510 mo294() {
        return null;
    }

    @Override // com.netflix.mediaclient.android.app.BaseStatus
    /* renamed from: ʻ */
    public Error mo293() {
        return null;
    }

    @Override // com.netflix.mediaclient.android.app.Status
    /* renamed from: ॱˊ */
    public String mo307() {
        StringBuilder sb = new StringBuilder();
        String str = this.f1690;
        if (C1349Bv.m4113(str)) {
            str = this.f1692.getString(((AbstractC2101qu) C1281.m16832(AbstractC2101qu.class)).mo10115(BrRequestType.m969(this.f1689)));
        }
        sb.append(str);
        if (this.f1694 != -1) {
            sb.append(" (").append(m962()).append(")");
        }
        return sb.toString();
    }

    @Override // com.netflix.mediaclient.android.app.Status
    /* renamed from: ˊॱ */
    public boolean mo306() {
        return C1349Bv.m4107(this.f1690);
    }

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    public JSONObject m967() {
        return this.f1686;
    }

    /* renamed from: ʻॱ  reason: contains not printable characters */
    public String m961() {
        return this.f1690;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m960(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject(ExceptionClEvent.CATEGORY_VALUE)) != null && optJSONObject.has("bladeRunnerCode")) {
            this.f1688 = optJSONObject.optString("bladeRunnerCode", null);
            this.f1685 = optJSONObject.optString("bladeRunnerExceptionType", null);
            this.f1687 = optJSONObject.optString("errorNccpCode", null);
            this.f1694 = C1332Be.m4015(this.f1688, -1).intValue();
            if (this.f1694 == -1) {
                this.f849 = StatusCode.BLADERUNNER_FAILURE;
                this.f1694 = StatusCode.BLADERUNNER_FAILURE.m271();
            } else {
                StatusCode r7 = ClientActionFromLase.m971(optJSONObject.optInt("clientAction", ClientActionFromLase.NO_ACTION.m972())).m973();
                this.f849 = r7.m268() ? r7 : m954(this.f1694);
            }
            this.f1690 = optJSONObject.optString("errorDisplayMessage");
            this.f1691 = optJSONObject.optInt("errorActionId");
            if (optJSONObject.optJSONObject("extraInfo") != null) {
                this.f1686 = optJSONObject.optJSONObject("extraInfo");
            }
            C1283.m16844(f1684, "mStatusCode: %s, mUserDisplayErrorMessage:%s, actionId:%d", this.f849, this.f1690, Integer.valueOf(this.f1691));
            m957(optJSONObject);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private static StatusCode m954(int i) {
        C1283.m16863(f1684, "mapBladeRunnerErrorCodeToStatusCode bladeRunnerErrorCode=%d", Integer.valueOf(i));
        StatusCode r5 = m959(i);
        if (r5 == StatusCode.BLADERUNNER_FAILURE) {
            return m956(i);
        }
        return r5;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private static StatusCode m959(int i) {
        StatusCode statusCode = StatusCode.BLADERUNNER_FAILURE;
        switch (LaseOfflineError.m995(i)) {
            case Undefined:
            case AggregateError:
            case EventStoreError:
            case RequestTypeError:
            case MembershipError:
            case LicenseAggregateError:
            case TotalLicensesPerAccountReached:
            case TitleNotAvailableForOffline:
            case viewingWindowExpired:
            case LicenseNotMarkedPlayable:
            case LicenseIdMismatch:
            case LicenseReleasedError:
            case LicenseTooOld:
            case DataMissError:
            case DataWriteError:
            case DeviceNotActiveError:
            case ViewableNotAvailableInRegion:
            case PackageRevokedError:
            case DeviceAggregateError:
            case ServerError:
            case IOError:
            case DependencyCommandError:
            case ClientUsageError:
            case PlayableAggregateError:
            case LicenseNotActive:
            case NOT_KNOWN_TO_CLIENT:
            default:
                return statusCode;
            case TotalLicensesPerDeviceReached:
                return StatusCode.DL_TOTAL_LICENSE_PER_DEVICE_LIMIT;
            case StudioOfflineTitleLimitReached:
                return StatusCode.DL_LIMIT_TOO_MANY_DOWNLOADED_DELETE_SOME;
            case YearlyStudioDownloadLimitReached:
            case YearlyStudioLicenseLimitReached:
                return StatusCode.DL_LIMIT_CANT_DOWNLOAD_TILL_DATE;
            case OfflineDeviceLimitReached:
                return StatusCode.DL_LIMIT_TOO_MANY_DEVICES_PLAN_OPTION;
            case BlacklistedDevice:
                return StatusCode.DL_BLACKLISTED_DEVICE;
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private static StatusCode m956(int i) {
        StatusCode statusCode = StatusCode.BLADERUNNER_FAILURE;
        switch (EdgeApiError.m983(i)) {
            case HystrixTimeout:
                return StatusCode.BLADERUNNER_RETRY;
            case NOT_KNOWN_TO_CLIENT:
            default:
                return statusCode;
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static boolean m955(JSONObject jSONObject) {
        return jSONObject == null || jSONObject.has(ExceptionClEvent.CATEGORY_VALUE) || jSONObject.has("innerErrors") || jSONObject.has("deviceCommand");
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static boolean m958(JSONObject jSONObject) {
        return jSONObject != null && jSONObject.has("links");
    }

    @Override // java.lang.Object
    public String toString() {
        return "BladerunnerErrorStatus, " + this.f849;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m957(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                this.f1693.putOpt("errorNccpCode", this.f1687);
                this.f1693.putOpt("bladeRunnerCode", this.f1688);
                this.f1693.putOpt("bladeRunnerExceptionType", this.f1685);
                this.f1693.putOpt("errorDisplayMessage", this.f1690);
                this.f1693.putOpt("errorActionId", Integer.valueOf(this.f1691));
                this.f1693.putOpt("apkStatusCode", this.f849.toString());
                String optString = jSONObject.optString("bladeRunnerMessage");
                if (C1349Bv.m4107(optString)) {
                    if (optString.length() > 200) {
                        optString = optString.substring(0, 199);
                    }
                    this.f1693.putOpt("bladeRunnerMessage", optString);
                }
            } catch (JSONException e) {
                C1283.m16850(f1684, "error creating logging blob");
            }
        }
    }

    public enum BrRequestType {
        StreamingLicense("SL"),
        OfflineLicense("L"),
        OfflineLicenseRefresh("LR"),
        OfflineLicenseDelete("LD"),
        OfflineManifest("M"),
        OfflineManifestRefresh("MR"),
        OfflineDownloadComplete("DC"),
        Link("I"),
        SyncLicense("SN"),
        StreamingManifest("SM"),
        other("O");
        

        /* renamed from: ͺ  reason: contains not printable characters */
        private String f1709;

        private BrRequestType(String str) {
            this.f1709 = str;
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        public String m970() {
            return this.f1709;
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public static boolean m969(BrRequestType brRequestType) {
            return OfflineLicense == brRequestType || OfflineLicenseRefresh == brRequestType || OfflineLicenseDelete == brRequestType || OfflineManifest == brRequestType || OfflineManifestRefresh == brRequestType || OfflineDownloadComplete == brRequestType;
        }
    }
}
