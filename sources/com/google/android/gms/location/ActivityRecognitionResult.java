package com.google.android.gms.location;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.zzbf;
import com.google.android.gms.common.internal.zzbp;
import com.google.android.gms.internal.zzbck;
import com.google.android.gms.internal.zzbcn;
import com.google.android.gms.internal.zzbcp;
import java.util.Arrays;
import java.util.List;
public class ActivityRecognitionResult extends zzbck implements ReflectedParcelable {
    public static final Parcelable.Creator<ActivityRecognitionResult> CREATOR = new zzb();
    private Bundle extras;
    private List<DetectedActivity> zzhwt;
    private long zzhwu;
    private long zzhwv;
    private int zzhww;

    public ActivityRecognitionResult(List<DetectedActivity> list, long j, long j2, int i, Bundle bundle) {
        zzbp.zzb(list != null && list.size() > 0, "Must have at least 1 detected activity");
        zzbp.zzb(j > 0 && j2 > 0, "Must set times");
        this.zzhwt = list;
        this.zzhwu = j;
        this.zzhwv = j2;
        this.zzhww = i;
        this.extras = bundle;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x002d A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x002e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.location.ActivityRecognitionResult extractResult(android.content.Intent r6) {
        /*
            r4 = r6
            boolean r0 = hasResult(r6)
            if (r0 == 0) goto L_0x002a
            android.os.Bundle r0 = r4.getExtras()
            java.lang.String r1 = "com.google.android.location.internal.EXTRA_ACTIVITY_RESULT"
            java.lang.Object r5 = r0.get(r1)
            boolean r0 = r5 instanceof byte[]
            if (r0 == 0) goto L_0x0022
            r0 = r5
            byte[] r0 = (byte[]) r0
            android.os.Parcelable$Creator<com.google.android.gms.location.ActivityRecognitionResult> r1 = com.google.android.gms.location.ActivityRecognitionResult.CREATOR
            com.google.android.gms.internal.zzbco r0 = com.google.android.gms.internal.zzbcp.zza(r0, r1)
            r2 = r0
            com.google.android.gms.location.ActivityRecognitionResult r2 = (com.google.android.gms.location.ActivityRecognitionResult) r2
            goto L_0x002b
        L_0x0022:
            boolean r0 = r5 instanceof com.google.android.gms.location.ActivityRecognitionResult
            if (r0 == 0) goto L_0x002a
            r2 = r5
            com.google.android.gms.location.ActivityRecognitionResult r2 = (com.google.android.gms.location.ActivityRecognitionResult) r2
            goto L_0x002b
        L_0x002a:
            r2 = 0
        L_0x002b:
            if (r2 == 0) goto L_0x002e
            return r2
        L_0x002e:
            java.util.List r3 = zzj(r6)
            if (r3 == 0) goto L_0x003a
            boolean r0 = r3.isEmpty()
            if (r0 == 0) goto L_0x003c
        L_0x003a:
            r0 = 0
            return r0
        L_0x003c:
            int r0 = r3.size()
            int r0 = r0 + -1
            java.lang.Object r0 = r3.get(r0)
            com.google.android.gms.location.ActivityRecognitionResult r0 = (com.google.android.gms.location.ActivityRecognitionResult) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.location.ActivityRecognitionResult.extractResult(android.content.Intent):com.google.android.gms.location.ActivityRecognitionResult");
    }

    public static boolean hasResult(Intent intent) {
        if (intent == null) {
            return false;
        }
        if (intent == null ? false : intent.hasExtra("com.google.android.location.internal.EXTRA_ACTIVITY_RESULT")) {
            return true;
        }
        List<ActivityRecognitionResult> zzj = zzj(intent);
        return zzj != null && !zzj.isEmpty();
    }

    private static boolean zzc(Bundle bundle, Bundle bundle2) {
        if (bundle == null && bundle2 == null) {
            return true;
        }
        if (bundle == null && bundle2 != null) {
            return false;
        }
        if ((bundle != null && bundle2 == null) || bundle.size() != bundle2.size()) {
            return false;
        }
        for (String str : bundle.keySet()) {
            if (!bundle2.containsKey(str)) {
                return false;
            }
            if (bundle.get(str) == null) {
                if (bundle2.get(str) != null) {
                    return false;
                }
            } else if (bundle.get(str) instanceof Bundle) {
                if (!zzc(bundle.getBundle(str), bundle2.getBundle(str))) {
                    return false;
                }
            } else if (!bundle.get(str).equals(bundle2.get(str))) {
                return false;
            }
        }
        return true;
    }

    private static List<ActivityRecognitionResult> zzj(Intent intent) {
        if (!(intent == null ? false : intent.hasExtra("com.google.android.location.internal.EXTRA_ACTIVITY_RESULT_LIST"))) {
            return null;
        }
        return zzbcp.zzb(intent, "com.google.android.location.internal.EXTRA_ACTIVITY_RESULT_LIST", CREATOR);
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ActivityRecognitionResult activityRecognitionResult = (ActivityRecognitionResult) obj;
        return this.zzhwu == activityRecognitionResult.zzhwu && this.zzhwv == activityRecognitionResult.zzhwv && this.zzhww == activityRecognitionResult.zzhww && zzbf.equal(this.zzhwt, activityRecognitionResult.zzhwt) && zzc(this.extras, activityRecognitionResult.extras);
    }

    public List<DetectedActivity> getProbableActivities() {
        return this.zzhwt;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.zzhwu), Long.valueOf(this.zzhwv), Integer.valueOf(this.zzhww), this.zzhwt, this.extras});
    }

    @Override // java.lang.Object
    public String toString() {
        String valueOf = String.valueOf(this.zzhwt);
        long j = this.zzhwu;
        return new StringBuilder(String.valueOf(valueOf).length() + 124).append("ActivityRecognitionResult [probableActivities=").append(valueOf).append(", timeMillis=").append(j).append(", elapsedRealtimeMillis=").append(this.zzhwv).append("]").toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int zze = zzbcn.zze(parcel);
        zzbcn.zzc(parcel, 1, this.zzhwt, false);
        zzbcn.zza(parcel, 2, this.zzhwu);
        zzbcn.zza(parcel, 3, this.zzhwv);
        zzbcn.zzc(parcel, 4, this.zzhww);
        zzbcn.zza(parcel, 5, this.extras, false);
        zzbcn.zzai(parcel, zze);
    }
}
