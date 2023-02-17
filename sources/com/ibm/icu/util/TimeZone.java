package com.ibm.icu.util;

import com.ibm.icu.impl.Grego;
import com.ibm.icu.impl.ICUConfig;
import com.ibm.icu.impl.JavaTimeZone;
import com.ibm.icu.impl.OlsonTimeZone;
import com.ibm.icu.impl.ZoneMeta;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import java.util.logging.Logger;
public abstract class TimeZone implements Serializable, Cloneable, Freezable<TimeZone> {
    static final /* synthetic */ boolean $assertionsDisabled = (!TimeZone.class.desiredAssertionStatus());
    public static final TimeZone GMT_ZONE = new ConstantZone(0, "Etc/GMT").freeze();
    private static final Logger LOGGER = Logger.getLogger("com.ibm.icu.util.TimeZone");
    private static int TZ_IMPL = 0;
    public static final TimeZone UNKNOWN_ZONE = new ConstantZone(0, "Etc/Unknown").freeze();
    private static volatile TimeZone defaultZone = null;
    private static final long serialVersionUID = -744942128318337471L;
    private String ID;

    public enum SystemTimeZoneType {
        ANY,
        CANONICAL,
        CANONICAL_LOCATION
    }

    public abstract int getOffset(int i, int i2, int i3, int i4, int i5, int i6);

    public abstract int getRawOffset();

    public abstract boolean inDaylightTime(Date date);

    public abstract boolean useDaylightTime();

    static {
        TZ_IMPL = 0;
        if (ICUConfig.get("com.ibm.icu.util.TimeZone.DefaultTimeZoneType", "ICU").equalsIgnoreCase("JDK")) {
            TZ_IMPL = 1;
        }
    }

    public TimeZone() {
    }

    @Deprecated
    protected TimeZone(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.ID = str;
    }

    public int getOffset(long j) {
        int[] iArr = new int[2];
        getOffset(j, false, iArr);
        return iArr[0] + iArr[1];
    }

    public void getOffset(long j, boolean z, int[] iArr) {
        iArr[0] = getRawOffset();
        if (!z) {
            j += (long) iArr[0];
        }
        int[] iArr2 = new int[6];
        int i = 0;
        while (true) {
            Grego.timeToFields(j, iArr2);
            iArr[1] = getOffset(1, iArr2[0], iArr2[1], iArr2[2], iArr2[3], iArr2[5]) - iArr[0];
            if (i == 0 && z && iArr[1] != 0) {
                j -= (long) iArr[1];
                i++;
            } else {
                return;
            }
        }
    }

    public String getID() {
        return this.ID;
    }

    public void setID(String str) {
        if (str == null) {
            throw new NullPointerException();
        } else if (isFrozen()) {
            throw new UnsupportedOperationException("Attempt to modify a frozen TimeZone instance.");
        } else {
            this.ID = str;
        }
    }

    public int getDSTSavings() {
        if (useDaylightTime()) {
            return 3600000;
        }
        return 0;
    }

    public static TimeZone getTimeZone(String str) {
        return getTimeZone(str, TZ_IMPL, false);
    }

    public static TimeZone getFrozenTimeZone(String str) {
        return getTimeZone(str, TZ_IMPL, true);
    }

    private static TimeZone getTimeZone(String str, int i, boolean z) {
        TimeZone timeZone;
        if (i == 1) {
            JavaTimeZone createTimeZone = JavaTimeZone.createTimeZone(str);
            if (createTimeZone != null) {
                return z ? createTimeZone.freeze() : createTimeZone;
            }
            timeZone = getFrozenICUTimeZone(str, false);
        } else {
            timeZone = getFrozenICUTimeZone(str, true);
        }
        if (timeZone == null) {
            LOGGER.fine("\"" + str + "\" is a bogus id so timezone is falling back to Etc/Unknown(GMT).");
            timeZone = UNKNOWN_ZONE;
        }
        return z ? timeZone : timeZone.cloneAsThawed();
    }

    static BasicTimeZone getFrozenICUTimeZone(String str, boolean z) {
        OlsonTimeZone olsonTimeZone = null;
        if (z) {
            olsonTimeZone = ZoneMeta.getSystemTimeZone(str);
        }
        if (olsonTimeZone == null) {
            return ZoneMeta.getCustomTimeZone(str);
        }
        return olsonTimeZone;
    }

    public static Set<String> getAvailableIDs(SystemTimeZoneType systemTimeZoneType, String str, Integer num) {
        return ZoneMeta.getAvailableIDs(systemTimeZoneType, str, num);
    }

    public static String[] getAvailableIDs() {
        return (String[]) getAvailableIDs(SystemTimeZoneType.ANY, null, null).toArray(new String[0]);
    }

    public static TimeZone getDefault() {
        TimeZone timeZone = defaultZone;
        if (timeZone == null) {
            synchronized (java.util.TimeZone.class) {
                synchronized (TimeZone.class) {
                    timeZone = defaultZone;
                    if (timeZone == null) {
                        if (TZ_IMPL == 1) {
                            timeZone = new JavaTimeZone();
                        } else {
                            timeZone = getFrozenTimeZone(java.util.TimeZone.getDefault().getID());
                        }
                        defaultZone = timeZone;
                    }
                }
            }
        }
        return timeZone.cloneAsThawed();
    }

    @Override // java.lang.Object
    public Object clone() {
        if (isFrozen()) {
            return this;
        }
        return cloneAsThawed();
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.ID.equals(((TimeZone) obj).ID);
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.ID.hashCode();
    }

    public static String getCanonicalID(String str) {
        return getCanonicalID(str, null);
    }

    public static String getCanonicalID(String str, boolean[] zArr) {
        String str2 = null;
        boolean z = false;
        if (!(str == null || str.length() == 0)) {
            if (str.equals("Etc/Unknown")) {
                str2 = "Etc/Unknown";
                z = false;
            } else {
                str2 = ZoneMeta.getCanonicalCLDRID(str);
                if (str2 != null) {
                    z = true;
                } else {
                    str2 = ZoneMeta.getCustomID(str);
                }
            }
        }
        if (zArr != null) {
            zArr[0] = z;
        }
        return str2;
    }

    public boolean isFrozen() {
        return false;
    }

    public TimeZone freeze() {
        throw new UnsupportedOperationException("Needs to be implemented by the subclass.");
    }

    public TimeZone cloneAsThawed() {
        try {
            return (TimeZone) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new ICUCloneNotSupportedException(e);
        }
    }

    static final class ConstantZone extends TimeZone {
        private static final long serialVersionUID = 1;
        private volatile transient boolean isFrozen;
        private int rawOffset;

        private ConstantZone(int i, String str) {
            super(str);
            this.isFrozen = false;
            this.rawOffset = i;
        }

        @Override // com.ibm.icu.util.TimeZone
        public int getOffset(int i, int i2, int i3, int i4, int i5, int i6) {
            return this.rawOffset;
        }

        @Override // com.ibm.icu.util.TimeZone
        public int getRawOffset() {
            return this.rawOffset;
        }

        @Override // com.ibm.icu.util.TimeZone
        public boolean useDaylightTime() {
            return false;
        }

        @Override // com.ibm.icu.util.TimeZone
        public boolean inDaylightTime(Date date) {
            return false;
        }

        @Override // com.ibm.icu.util.TimeZone
        public boolean isFrozen() {
            return this.isFrozen;
        }

        @Override // com.ibm.icu.util.TimeZone
        public TimeZone freeze() {
            this.isFrozen = true;
            return this;
        }

        @Override // com.ibm.icu.util.TimeZone
        public TimeZone cloneAsThawed() {
            ConstantZone constantZone = (ConstantZone) TimeZone.super.cloneAsThawed();
            constantZone.isFrozen = false;
            return constantZone;
        }
    }
}
