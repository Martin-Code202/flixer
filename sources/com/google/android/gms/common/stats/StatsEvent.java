package com.google.android.gms.common.stats;

import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.internal.zzbck;
public abstract class StatsEvent extends zzbck implements ReflectedParcelable {
    public abstract int getEventType();

    public abstract long getTimeMillis();

    @Override // java.lang.Object
    public String toString() {
        long timeMillis = getTimeMillis();
        int eventType = getEventType();
        long zzala = zzala();
        String zzalb = zzalb();
        return new StringBuilder(String.valueOf(zzalb).length() + String.valueOf("\t").length() + 51 + String.valueOf("\t").length()).append(timeMillis).append("\t").append(eventType).append("\t").append(zzala).append(zzalb).toString();
    }

    public abstract long zzala();

    public abstract String zzalb();
}
