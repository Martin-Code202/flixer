package com.netflix.mediaclient.service.job;

import android.content.Context;
import com.google.gson.annotations.SerializedName;
import com.netflix.mediaclient.util.ConnectivityUtils;
import o.C1283;
public class NetflixJob {
    @SerializedName("minimumDelay")
    private long mMinimumDelay;
    @SerializedName("value")
    private final int mNetflixJobIdValue;
    @SerializedName("isRepeating")
    private final boolean mRepeating;
    @SerializedName("repeatingPeriodMs")
    private final long mRepeatingPeriodInMs;
    @SerializedName("requiresCharging")
    private final boolean mRequiresCharging;
    @SerializedName("requiresIdle")
    private final boolean mRequiresIdle;
    @SerializedName("requiresUnmeteredNetwork")
    private final boolean mRequiresUnmeteredConnection;

    /* renamed from: ˏ  reason: contains not printable characters */
    private transient NetflixJobId f1120;

    /* renamed from: ˊ  reason: contains not printable characters */
    public boolean m573() {
        return this.mRequiresIdle;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public boolean m576() {
        return this.mRequiresCharging;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public long m575() {
        return this.mMinimumDelay;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m572(long j) {
        if (this.mRepeating) {
            C1283.m16850("nf_netflix_job", "Error, setting minimum delay on a repeating job.");
        } else {
            this.mMinimumDelay = j;
        }
    }

    public enum NetflixJobId {
        UNKNOWN_JOB_ID(-1),
        DOWNLOAD_RESUME(1),
        NETFLIX_MAINTENANCE(2),
        INSOMNIA(3),
        INSTALL_TOKEN(4);
        

        /* renamed from: ॱॱ  reason: contains not printable characters */
        private final int f1127;

        private NetflixJobId(int i) {
            this.f1127 = i;
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        public int m582() {
            return this.f1127;
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        public static NetflixJobId m581(int i) {
            NetflixJobId[] values = values();
            for (NetflixJobId netflixJobId : values) {
                if (netflixJobId.m582() == i) {
                    return netflixJobId;
                }
            }
            return UNKNOWN_JOB_ID;
        }
    }

    private NetflixJob(NetflixJobId netflixJobId, boolean z, boolean z2, long j, boolean z3, boolean z4) {
        this.f1120 = netflixJobId;
        this.mRequiresUnmeteredConnection = z;
        this.mRepeating = z2;
        this.mRepeatingPeriodInMs = j;
        this.mNetflixJobIdValue = netflixJobId.m582();
        this.mRequiresCharging = z3;
        this.mRequiresIdle = z4;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static NetflixJob m570(long j) {
        return new NetflixJob(NetflixJobId.NETFLIX_MAINTENANCE, false, true, j, false, false);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static NetflixJob m569() {
        return new NetflixJob(NetflixJobId.INSTALL_TOKEN, false, false, 0, false, false);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static NetflixJob m568(boolean z) {
        return new NetflixJob(NetflixJobId.DOWNLOAD_RESUME, z, false, 0, false, false);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static NetflixJob m567(long j, boolean z) {
        return new NetflixJob(NetflixJobId.INSOMNIA, z, true, j, false, false);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public NetflixJobId m577() {
        if (this.f1120 == null) {
            this.f1120 = NetflixJobId.m581(this.mNetflixJobIdValue);
        }
        return this.f1120;
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public boolean m571() {
        return this.mRepeating;
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public long m579() {
        return this.mRepeatingPeriodInMs;
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    public boolean m580() {
        return this.mRequiresUnmeteredConnection;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public boolean m578(Context context) {
        return m574(context);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public boolean m574(Context context) {
        ConnectivityUtils.NetType r2;
        if (!ConnectivityUtils.m2970(context) || (r2 = ConnectivityUtils.m2958(context)) == null) {
            return false;
        }
        return !this.mRequiresUnmeteredConnection || r2 != ConnectivityUtils.NetType.mobile;
    }
}
