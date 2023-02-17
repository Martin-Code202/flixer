package o;

import android.os.Build;
import android.os.Environment;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.service.job.NetflixJob;
import com.netflix.mediaclient.service.logging.logblob.LogBlobType;
import com.netflix.mediaclient.service.offline.agent.OfflineUnavailableReason;
import com.netflix.mediaclient.servicemgr.LogArguments;
import com.netflix.mediaclient.servicemgr.Logblob;
import com.netflix.mediaclient.servicemgr.interface_.offline.StopReason;
import java.io.File;
import org.json.JSONException;
public final class hW extends AbstractC1607ca {

    /* renamed from: ˎ  reason: contains not printable characters */
    private final boolean f7184;

    private hW(Logblob.Severity severity, String str, String str2, String str3, String str4, String str5, boolean z) {
        super(str2, str3);
        this.f6135 = severity;
        this.f6134.put("level", LogArguments.LogLevel.ERROR.m1554());
        if (C1349Bv.m4107(str)) {
            this.f6134.put("mid", str);
        }
        if (C1349Bv.m4107(str5)) {
            this.f6134.put("errormsg", str5);
        }
        if (C1349Bv.m4107(str4)) {
            this.f6134.put("errorcode", str4);
        }
        this.f7184 = z;
    }

    @Override // o.AbstractC1542bQ, com.netflix.mediaclient.servicemgr.Logblob
    /* renamed from: ˏ */
    public boolean mo1556() {
        return this.f7184;
    }

    @Override // com.netflix.mediaclient.servicemgr.Logblob
    /* renamed from: ˋ */
    public String mo680() {
        return LogBlobType.OFFLINE_LOGBLOB_TYPE.m602();
    }

    @Override // o.AbstractC1542bQ
    /* renamed from: ˊ */
    public Logblob.Severity mo5755() {
        return this.f6135;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m6993(String str) {
        if (C1349Bv.m4107(str)) {
            try {
                this.f6134.put("dbgmsg", str);
            } catch (JSONException e) {
                C1283.m16863("offlineErrorLogBlob", "JSONException:", e);
            }
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m6987(long j) {
        try {
            this.f6134.put("freespace", j);
        } catch (JSONException e) {
            C1283.m16863("offlineErrorLogBlob", "JSONException:", e);
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static void m6997(oQ oQVar, String str, String str2, String str3, Status status) {
        if (oQVar != null) {
            try {
                hW hWVar = new hW(Logblob.Severity.error, str, str2, str3, AR.m3405(status), AR.m3407(status), true);
                hWVar.m6993(status.mo305());
                oQVar.mo5226(hWVar);
            } catch (JSONException e) {
                C1283.m16863("offlineErrorLogBlob", "JSONException:", e);
            } catch (Exception e2) {
                C1283.m16863("offlineErrorLogBlob", "Exception:", e2);
            }
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static void m6989(oQ oQVar, String str, String str2, String str3, StopReason stopReason, String str4) {
        if (oQVar != null) {
            try {
                Logblob.Severity severity = Logblob.Severity.error;
                boolean z = false;
                switch (stopReason) {
                    case Unknown:
                    case WaitingToBeStarted:
                    case NetworkError:
                        break;
                    case ManifestError:
                        z = true;
                        severity = Logblob.Severity.error;
                        break;
                    case NoNetworkConnectivity:
                    case StoppedFromAgentAPI:
                    case NotAllowedOnCurrentNetwork:
                        break;
                    case StorageError:
                        z = true;
                        severity = Logblob.Severity.error;
                        break;
                    case NotEnoughSpace:
                        z = true;
                        severity = Logblob.Severity.warn;
                        break;
                    case PlayerStreaming:
                        z = true;
                        severity = Logblob.Severity.info;
                        break;
                    case AccountInActive:
                        z = true;
                        severity = Logblob.Severity.error;
                        break;
                    case EncodesAreNotAvailableAnyMore:
                        z = true;
                        severity = Logblob.Severity.error;
                        break;
                    case GeoCheckError:
                        z = true;
                        severity = Logblob.Severity.error;
                        break;
                    case DownloadLimitRequiresManualResume:
                        z = true;
                        severity = Logblob.Severity.info;
                        break;
                    case EncodesRevoked:
                        z = true;
                        severity = Logblob.Severity.info;
                        break;
                    default:
                        C1283.m16851("offlineErrorLogBlob", " onDownloadStopped stopReason: %s, no-op", stopReason);
                        break;
                }
                if (z) {
                    hW hWVar = new hW(severity, str, str2, str3, BF.m3846(stopReason), "downloadStopError", true);
                    hWVar.m6993(str4);
                    oQVar.mo5226(hWVar);
                }
            } catch (JSONException e) {
                C1283.m16863("offlineErrorLogBlob", "JSONException:", e);
            } catch (Exception e2) {
                C1283.m16863("offlineErrorLogBlob", "Exception:", e2);
            }
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static void m6988(oQ oQVar, String str, String str2, String str3, Status status) {
        if (oQVar != null) {
            try {
                hW hWVar = new hW(Logblob.Severity.warn, str, str2, str3, AR.m3405(status), AR.m3407(status), false);
                hWVar.m6993(status.mo305());
                oQVar.mo5226(hWVar);
            } catch (JSONException e) {
                C1283.m16863("offlineErrorLogBlob", "JSONException:", e);
            } catch (Exception e2) {
                C1283.m16863("offlineErrorLogBlob", "Exception:", e2);
            }
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static void m6995(oQ oQVar, NetflixJob.NetflixJobId netflixJobId) {
        if (oQVar != null) {
            try {
                oQVar.mo5226(new hW(Logblob.Severity.info, "-1", "-1", "-1", "" + netflixJobId.m582(), "NetflixStartJob", false));
            } catch (JSONException e) {
                C1283.m16863("offlineErrorLogBlob", "JSONException:", e);
            } catch (Exception e2) {
                C1283.m16863("offlineErrorLogBlob", "Exception:", e2);
            }
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static void m6996(oQ oQVar, String str, String str2, String str3, long j, String str4, String str5) {
        if (oQVar != null) {
            boolean z = false;
            try {
                if (Build.VERSION.SDK_INT >= 21) {
                    z = Environment.isExternalStorageRemovable(new File(str4));
                }
            } catch (Exception e) {
            }
            try {
                hW hWVar = new hW(Logblob.Severity.info, str, str2, str3, "", "DlRequestStorageInfo removable=" + z, false);
                hWVar.m6987(j);
                hWVar.m6993(str5);
                oQVar.mo5226(hWVar);
            } catch (JSONException e2) {
                C1283.m16863("offlineErrorLogBlob", "JSONException:", e2);
            } catch (Exception e3) {
                C1283.m16863("offlineErrorLogBlob", "Exception:", e3);
            }
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static void m6991(oQ oQVar, OfflineUnavailableReason offlineUnavailableReason) {
        if (oQVar != null) {
            try {
                oQVar.mo5226(new hW(Logblob.Severity.info, "-1", "-1", "-1", "" + offlineUnavailableReason.m822(), "offline feature n/a", false));
            } catch (JSONException e) {
                C1283.m16863("offlineErrorLogBlob", "JSONException:", e);
            } catch (Exception e2) {
                C1283.m16863("offlineErrorLogBlob", "Exception:", e2);
            }
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static void m6992(oQ oQVar, String str, String str2, String str3, String str4) {
        if (oQVar != null) {
            try {
                hW hWVar = new hW(Logblob.Severity.info, str, str2, str3, "manifestSaved", "", false);
                hWVar.m6993(str4);
                oQVar.mo5226(hWVar);
            } catch (JSONException e) {
                C1283.m16863("offlineErrorLogBlob", "JSONException:", e);
            } catch (Exception e2) {
                C1283.m16863("offlineErrorLogBlob", "Exception:", e2);
            }
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static void m6990(oQ oQVar, String str, String str2, String str3, String str4) {
        if (oQVar != null) {
            try {
                hW hWVar = new hW(Logblob.Severity.info, str, str2, str3, "manifestNotFound", "", false);
                hWVar.m6993(str4);
                oQVar.mo5226(hWVar);
            } catch (JSONException e) {
                C1283.m16863("offlineErrorLogBlob", "JSONException:", e);
            } catch (Exception e2) {
                C1283.m16863("offlineErrorLogBlob", "Exception:", e2);
            }
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static void m6994(oQ oQVar, int i) {
        if (oQVar != null) {
            try {
                oQVar.mo5226(new hW(Logblob.Severity.info, "-1", "-1", "-1", "storageAddedOrRemoved", "volumeCount=" + i, false));
            } catch (JSONException e) {
                C1283.m16863("offlineErrorLogBlob", "JSONException:", e);
            } catch (Exception e2) {
                C1283.m16863("offlineErrorLogBlob", "Exception:", e2);
            }
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static void m6998(oQ oQVar, String str, String str2, String str3, String str4) {
        if (oQVar != null) {
            try {
                hW hWVar = new hW(Logblob.Severity.info, str, str2, str3, "", "log", false);
                hWVar.m6993(str4);
                oQVar.mo5226(hWVar);
            } catch (JSONException e) {
                C1283.m16863("offlineErrorLogBlob", "JSONException:", e);
            } catch (Exception e2) {
                C1283.m16863("offlineErrorLogBlob", "Exception:", e2);
            }
        }
    }
}
