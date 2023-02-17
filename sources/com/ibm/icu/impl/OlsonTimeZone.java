package com.ibm.icu.impl;

import com.ibm.icu.util.BasicTimeZone;
import com.ibm.icu.util.InitialTimeZoneRule;
import com.ibm.icu.util.SimpleTimeZone;
import com.ibm.icu.util.TimeArrayTimeZoneRule;
import com.ibm.icu.util.TimeZone;
import com.ibm.icu.util.TimeZoneRule;
import com.ibm.icu.util.TimeZoneTransition;
import com.ibm.icu.util.UResourceBundle;
import java.io.ObjectInputStream;
import java.util.Date;
import java.util.MissingResourceException;
public class OlsonTimeZone extends BasicTimeZone {
    static final /* synthetic */ boolean $assertionsDisabled = (!OlsonTimeZone.class.desiredAssertionStatus());
    private static final boolean DEBUG = ICUDebug.enabled("olson");
    static final long serialVersionUID = -6281977362477515376L;
    private volatile String canonicalID = null;
    private double finalStartMillis = Double.MAX_VALUE;
    private int finalStartYear = Integer.MAX_VALUE;
    private SimpleTimeZone finalZone = null;
    private transient SimpleTimeZone finalZoneWithStartYear;
    private transient TimeZoneTransition firstFinalTZTransition;
    private transient TimeZoneTransition firstTZTransition;
    private transient int firstTZTransitionIdx;
    private transient TimeArrayTimeZoneRule[] historicRules;
    private transient InitialTimeZoneRule initialRule;
    private volatile transient boolean isFrozen = false;
    private int serialVersionOnStream = 1;
    private int transitionCount;
    private transient boolean transitionRulesInitialized;
    private long[] transitionTimes64;
    private int typeCount;
    private byte[] typeMapData;
    private int[] typeOffsets;

    @Override // com.ibm.icu.util.TimeZone
    public int getOffset(int i, int i2, int i3, int i4, int i5, int i6) {
        if (i3 >= 0 && i3 <= 11) {
            return getOffset(i, i2, i3, i4, i5, i6, Grego.monthLength(i2, i3));
        }
        throw new IllegalArgumentException("Month is not in the legal range: " + i3);
    }

    public int getOffset(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        if ((i == 1 || i == 0) && i3 >= 0 && i3 <= 11 && i4 >= 1 && i4 <= i7 && i5 >= 1 && i5 <= 7 && i6 >= 0 && i6 < 86400000 && i7 >= 28 && i7 <= 31) {
            if (i == 0) {
                i2 = -i2;
            }
            if (this.finalZone != null && i2 >= this.finalStartYear) {
                return this.finalZone.getOffset(i, i2, i3, i4, i5, i6);
            }
            int[] iArr = new int[2];
            getHistoricalOffset((Grego.fieldsToDay(i2, i3, i4) * 86400000) + ((long) i6), true, 3, 1, iArr);
            return iArr[0] + iArr[1];
        }
        throw new IllegalArgumentException();
    }

    @Override // com.ibm.icu.util.TimeZone, java.lang.Object
    public Object clone() {
        if (isFrozen()) {
            return this;
        }
        return cloneAsThawed();
    }

    @Override // com.ibm.icu.util.TimeZone
    public void getOffset(long j, boolean z, int[] iArr) {
        if (this.finalZone == null || ((double) j) < this.finalStartMillis) {
            getHistoricalOffset(j, z, 4, 12, iArr);
        } else {
            this.finalZone.getOffset(j, z, iArr);
        }
    }

    @Override // com.ibm.icu.util.BasicTimeZone
    public void getOffsetFromLocal(long j, int i, int i2, int[] iArr) {
        if (this.finalZone == null || ((double) j) < this.finalStartMillis) {
            getHistoricalOffset(j, true, i, i2, iArr);
        } else {
            this.finalZone.getOffsetFromLocal(j, i, i2, iArr);
        }
    }

    @Override // com.ibm.icu.util.TimeZone
    public int getRawOffset() {
        int[] iArr = new int[2];
        getOffset(System.currentTimeMillis(), false, iArr);
        return iArr[0];
    }

    @Override // com.ibm.icu.util.TimeZone
    public boolean useDaylightTime() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.finalZone != null && ((double) currentTimeMillis) >= this.finalStartMillis) {
            return this.finalZone != null && this.finalZone.useDaylightTime();
        }
        int[] timeToFields = Grego.timeToFields(currentTimeMillis, null);
        long fieldsToDay = Grego.fieldsToDay(timeToFields[0], 0, 1) * 86400;
        long fieldsToDay2 = Grego.fieldsToDay(timeToFields[0] + 1, 0, 1) * 86400;
        int i = 0;
        while (i < this.transitionCount && this.transitionTimes64[i] < fieldsToDay2) {
            if (this.transitionTimes64[i] >= fieldsToDay && dstOffsetAt(i) != 0) {
                return true;
            }
            if (this.transitionTimes64[i] > fieldsToDay && i > 0 && dstOffsetAt(i - 1) != 0) {
                return true;
            }
            i++;
        }
        return false;
    }

    @Override // com.ibm.icu.util.TimeZone
    public int getDSTSavings() {
        if (this.finalZone != null) {
            return this.finalZone.getDSTSavings();
        }
        return super.getDSTSavings();
    }

    @Override // com.ibm.icu.util.TimeZone
    public boolean inDaylightTime(Date date) {
        int[] iArr = new int[2];
        getOffset(date.getTime(), false, iArr);
        return iArr[1] != 0;
    }

    public String getCanonicalID() {
        if (this.canonicalID == null) {
            synchronized (this) {
                if (this.canonicalID == null) {
                    this.canonicalID = getCanonicalID(getID());
                    if (!$assertionsDisabled && this.canonicalID == null) {
                        throw new AssertionError();
                    } else if (this.canonicalID == null) {
                        this.canonicalID = getID();
                    }
                }
            }
        }
        return this.canonicalID;
    }

    private void constructEmpty() {
        this.transitionCount = 0;
        this.transitionTimes64 = null;
        this.typeMapData = null;
        this.typeCount = 1;
        this.typeOffsets = new int[]{0, 0};
        this.finalZone = null;
        this.finalStartYear = Integer.MAX_VALUE;
        this.finalStartMillis = Double.MAX_VALUE;
        this.transitionRulesInitialized = false;
    }

    public OlsonTimeZone(UResourceBundle uResourceBundle, UResourceBundle uResourceBundle2, String str) {
        super(str);
        construct(uResourceBundle, uResourceBundle2);
    }

    private void construct(UResourceBundle uResourceBundle, UResourceBundle uResourceBundle2) {
        if (uResourceBundle == null || uResourceBundle2 == null) {
            throw new IllegalArgumentException();
        }
        if (DEBUG) {
            System.out.println("OlsonTimeZone(" + uResourceBundle2.getKey() + ")");
        }
        int[] iArr = null;
        int[] iArr2 = null;
        int[] iArr3 = null;
        this.transitionCount = 0;
        try {
            iArr3 = uResourceBundle2.get("transPre32").getIntVector();
            if (iArr3.length % 2 != 0) {
                throw new IllegalArgumentException("Invalid Format");
            }
            this.transitionCount += iArr3.length / 2;
            try {
                iArr2 = uResourceBundle2.get("trans").getIntVector();
                this.transitionCount += iArr2.length;
            } catch (MissingResourceException e) {
            }
            try {
                iArr = uResourceBundle2.get("transPost32").getIntVector();
                if (iArr.length % 2 != 0) {
                    throw new IllegalArgumentException("Invalid Format");
                }
                this.transitionCount += iArr.length / 2;
                if (this.transitionCount > 0) {
                    this.transitionTimes64 = new long[this.transitionCount];
                    int i = 0;
                    if (iArr3 != null) {
                        int i2 = 0;
                        while (i2 < iArr3.length / 2) {
                            this.transitionTimes64[i] = ((((long) iArr3[i2 * 2]) & 4294967295L) << 32) | (((long) iArr3[(i2 * 2) + 1]) & 4294967295L);
                            i2++;
                            i++;
                        }
                    }
                    if (iArr2 != null) {
                        int i3 = 0;
                        while (i3 < iArr2.length) {
                            this.transitionTimes64[i] = (long) iArr2[i3];
                            i3++;
                            i++;
                        }
                    }
                    if (iArr != null) {
                        int i4 = 0;
                        while (i4 < iArr.length / 2) {
                            this.transitionTimes64[i] = ((((long) iArr[i4 * 2]) & 4294967295L) << 32) | (((long) iArr[(i4 * 2) + 1]) & 4294967295L);
                            i4++;
                            i++;
                        }
                    }
                } else {
                    this.transitionTimes64 = null;
                }
                this.typeOffsets = uResourceBundle2.get("typeOffsets").getIntVector();
                if (this.typeOffsets.length < 2 || this.typeOffsets.length > 32766 || this.typeOffsets.length % 2 != 0) {
                    throw new IllegalArgumentException("Invalid Format");
                }
                this.typeCount = this.typeOffsets.length / 2;
                if (this.transitionCount > 0) {
                    this.typeMapData = uResourceBundle2.get("typeMap").getBinary(null);
                    if (this.typeMapData == null || this.typeMapData.length != this.transitionCount) {
                        throw new IllegalArgumentException("Invalid Format");
                    }
                } else {
                    this.typeMapData = null;
                }
                this.finalZone = null;
                this.finalStartYear = Integer.MAX_VALUE;
                this.finalStartMillis = Double.MAX_VALUE;
                try {
                    String string = uResourceBundle2.getString("finalRule");
                    int i5 = uResourceBundle2.get("finalRaw").getInt() * 1000;
                    int[] intVector = loadRule(uResourceBundle, string).getIntVector();
                    if (intVector == null || intVector.length != 11) {
                        throw new IllegalArgumentException("Invalid Format");
                    }
                    this.finalZone = new SimpleTimeZone(i5, "", intVector[0], intVector[1], intVector[2], intVector[3] * 1000, intVector[4], intVector[5], intVector[6], intVector[7], intVector[8] * 1000, intVector[9], intVector[10] * 1000);
                    this.finalStartYear = uResourceBundle2.get("finalYear").getInt();
                    this.finalStartMillis = (double) (Grego.fieldsToDay(this.finalStartYear, 0, 1) * 86400000);
                } catch (MissingResourceException e2) {
                    if (0 != 0) {
                        throw new IllegalArgumentException("Invalid Format");
                    }
                }
            } catch (MissingResourceException e3) {
            }
        } catch (MissingResourceException e4) {
        }
    }

    @Override // com.ibm.icu.util.TimeZone
    public void setID(String str) {
        if (isFrozen()) {
            throw new UnsupportedOperationException("Attempt to modify a frozen OlsonTimeZone instance.");
        }
        if (this.canonicalID == null) {
            this.canonicalID = getCanonicalID(getID());
            if (!$assertionsDisabled && this.canonicalID == null) {
                throw new AssertionError();
            } else if (this.canonicalID == null) {
                this.canonicalID = getID();
            }
        }
        if (this.finalZone != null) {
            this.finalZone.setID(str);
        }
        super.setID(str);
        this.transitionRulesInitialized = false;
    }

    private void getHistoricalOffset(long j, boolean z, int i, int i2, int[] iArr) {
        if (this.transitionCount != 0) {
            long floorDivide = Grego.floorDivide(j, 1000);
            if (z || floorDivide >= this.transitionTimes64[0]) {
                int i3 = this.transitionCount - 1;
                while (i3 >= 0) {
                    long j2 = this.transitionTimes64[i3];
                    if (z && floorDivide >= j2 - 86400) {
                        int zoneOffsetAt = zoneOffsetAt(i3 - 1);
                        boolean z2 = dstOffsetAt(i3 + -1) != 0;
                        int zoneOffsetAt2 = zoneOffsetAt(i3);
                        boolean z3 = dstOffsetAt(i3) != 0;
                        boolean z4 = z2 && !z3;
                        boolean z5 = !z2 && z3;
                        j2 = zoneOffsetAt2 - zoneOffsetAt >= 0 ? (((i & 3) != 1 || !z4) && ((i & 3) != 3 || !z5)) ? (((i & 3) != 1 || !z5) && ((i & 3) != 3 || !z4)) ? (i & 12) == 12 ? j2 + ((long) zoneOffsetAt) : j2 + ((long) zoneOffsetAt2) : j2 + ((long) zoneOffsetAt2) : j2 + ((long) zoneOffsetAt) : (((i2 & 3) != 1 || !z4) && ((i2 & 3) != 3 || !z5)) ? (((i2 & 3) != 1 || !z5) && ((i2 & 3) != 3 || !z4)) ? (i2 & 12) == 4 ? j2 + ((long) zoneOffsetAt) : j2 + ((long) zoneOffsetAt2) : j2 + ((long) zoneOffsetAt) : j2 + ((long) zoneOffsetAt2);
                    }
                    if (floorDivide >= j2) {
                        break;
                    }
                    i3--;
                }
                iArr[0] = rawOffsetAt(i3) * 1000;
                iArr[1] = dstOffsetAt(i3) * 1000;
                return;
            }
            iArr[0] = initialRawOffset() * 1000;
            iArr[1] = initialDstOffset() * 1000;
            return;
        }
        iArr[0] = initialRawOffset() * 1000;
        iArr[1] = initialDstOffset() * 1000;
    }

    private int getInt(byte b) {
        return b & 255;
    }

    private int zoneOffsetAt(int i) {
        int i2 = i >= 0 ? getInt(this.typeMapData[i]) * 2 : 0;
        return this.typeOffsets[i2] + this.typeOffsets[i2 + 1];
    }

    private int rawOffsetAt(int i) {
        return this.typeOffsets[i >= 0 ? getInt(this.typeMapData[i]) * 2 : 0];
    }

    private int dstOffsetAt(int i) {
        return this.typeOffsets[(i >= 0 ? getInt(this.typeMapData[i]) * 2 : 0) + 1];
    }

    private int initialRawOffset() {
        return this.typeOffsets[0];
    }

    private int initialDstOffset() {
        return this.typeOffsets[1];
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append('[');
        sb.append("transitionCount=" + this.transitionCount);
        sb.append(",typeCount=" + this.typeCount);
        sb.append(",transitionTimes=");
        if (this.transitionTimes64 != null) {
            sb.append('[');
            for (int i = 0; i < this.transitionTimes64.length; i++) {
                if (i > 0) {
                    sb.append(',');
                }
                sb.append(Long.toString(this.transitionTimes64[i]));
            }
            sb.append(']');
        } else {
            sb.append("null");
        }
        sb.append(",typeOffsets=");
        if (this.typeOffsets != null) {
            sb.append('[');
            for (int i2 = 0; i2 < this.typeOffsets.length; i2++) {
                if (i2 > 0) {
                    sb.append(',');
                }
                sb.append(Integer.toString(this.typeOffsets[i2]));
            }
            sb.append(']');
        } else {
            sb.append("null");
        }
        sb.append(",typeMapData=");
        if (this.typeMapData != null) {
            sb.append('[');
            for (int i3 = 0; i3 < this.typeMapData.length; i3++) {
                if (i3 > 0) {
                    sb.append(',');
                }
                sb.append(Byte.toString(this.typeMapData[i3]));
            }
        } else {
            sb.append("null");
        }
        sb.append(",finalStartYear=" + this.finalStartYear);
        sb.append(",finalStartMillis=" + this.finalStartMillis);
        sb.append(",finalZone=" + this.finalZone);
        sb.append(']');
        return sb.toString();
    }

    private static UResourceBundle loadRule(UResourceBundle uResourceBundle, String str) {
        return uResourceBundle.get("Rules").get(str);
    }

    @Override // com.ibm.icu.util.TimeZone, java.lang.Object
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        OlsonTimeZone olsonTimeZone = (OlsonTimeZone) obj;
        return Utility.arrayEquals(this.typeMapData, olsonTimeZone.typeMapData) || (this.finalStartYear == olsonTimeZone.finalStartYear && ((this.finalZone == null && olsonTimeZone.finalZone == null) || (this.finalZone != null && olsonTimeZone.finalZone != null && this.finalZone.equals(olsonTimeZone.finalZone) && this.transitionCount == olsonTimeZone.transitionCount && this.typeCount == olsonTimeZone.typeCount && Utility.arrayEquals(this.transitionTimes64, olsonTimeZone.transitionTimes64) && Utility.arrayEquals(this.typeOffsets, olsonTimeZone.typeOffsets) && Utility.arrayEquals(this.typeMapData, olsonTimeZone.typeMapData))));
    }

    @Override // com.ibm.icu.util.TimeZone, java.lang.Object
    public int hashCode() {
        int i;
        long j = (long) ((this.finalStartYear ^ ((this.finalStartYear >>> 4) + this.transitionCount)) ^ ((this.transitionCount >>> 6) + this.typeCount));
        long doubleToLongBits = ((long) (this.typeCount >>> 8)) + Double.doubleToLongBits(this.finalStartMillis);
        if (this.finalZone == null) {
            i = 0;
        } else {
            i = this.finalZone.hashCode();
        }
        int hashCode = (int) (j ^ ((doubleToLongBits + ((long) i)) + ((long) super.hashCode())));
        if (this.transitionTimes64 != null) {
            for (int i2 = 0; i2 < this.transitionTimes64.length; i2++) {
                hashCode = (int) (((long) hashCode) + (this.transitionTimes64[i2] ^ (this.transitionTimes64[i2] >>> 8)));
            }
        }
        for (int i3 = 0; i3 < this.typeOffsets.length; i3++) {
            hashCode += this.typeOffsets[i3] ^ (this.typeOffsets[i3] >>> 8);
        }
        if (this.typeMapData != null) {
            for (int i4 = 0; i4 < this.typeMapData.length; i4++) {
                hashCode += this.typeMapData[i4] & 255;
            }
        }
        return hashCode;
    }

    @Override // com.ibm.icu.util.BasicTimeZone
    public TimeZoneTransition getNextTransition(long j, boolean z) {
        initTransitionRules();
        if (this.finalZone != null) {
            if (z && j == this.firstFinalTZTransition.getTime()) {
                return this.firstFinalTZTransition;
            }
            if (j >= this.firstFinalTZTransition.getTime()) {
                if (this.finalZone.useDaylightTime()) {
                    return this.finalZoneWithStartYear.getNextTransition(j, z);
                }
                return null;
            }
        }
        if (this.historicRules == null) {
            return null;
        }
        int i = this.transitionCount - 1;
        while (i >= this.firstTZTransitionIdx) {
            long j2 = this.transitionTimes64[i] * 1000;
            if (j > j2 || (!z && j == j2)) {
                break;
            }
            i--;
        }
        if (i == this.transitionCount - 1) {
            return this.firstFinalTZTransition;
        }
        if (i < this.firstTZTransitionIdx) {
            return this.firstTZTransition;
        }
        TimeArrayTimeZoneRule timeArrayTimeZoneRule = this.historicRules[getInt(this.typeMapData[i + 1])];
        TimeArrayTimeZoneRule timeArrayTimeZoneRule2 = this.historicRules[getInt(this.typeMapData[i])];
        long j3 = this.transitionTimes64[i + 1] * 1000;
        if (timeArrayTimeZoneRule2.getName().equals(timeArrayTimeZoneRule.getName()) && timeArrayTimeZoneRule2.getRawOffset() == timeArrayTimeZoneRule.getRawOffset() && timeArrayTimeZoneRule2.getDSTSavings() == timeArrayTimeZoneRule.getDSTSavings()) {
            return getNextTransition(j3, false);
        }
        return new TimeZoneTransition(j3, timeArrayTimeZoneRule2, timeArrayTimeZoneRule);
    }

    @Override // com.ibm.icu.util.BasicTimeZone
    public TimeZoneTransition getPreviousTransition(long j, boolean z) {
        initTransitionRules();
        if (this.finalZone != null) {
            if (z && j == this.firstFinalTZTransition.getTime()) {
                return this.firstFinalTZTransition;
            }
            if (j > this.firstFinalTZTransition.getTime()) {
                if (this.finalZone.useDaylightTime()) {
                    return this.finalZoneWithStartYear.getPreviousTransition(j, z);
                }
                return this.firstFinalTZTransition;
            }
        }
        if (this.historicRules == null) {
            return null;
        }
        int i = this.transitionCount - 1;
        while (i >= this.firstTZTransitionIdx) {
            long j2 = this.transitionTimes64[i] * 1000;
            if (j > j2 || (z && j == j2)) {
                break;
            }
            i--;
        }
        if (i < this.firstTZTransitionIdx) {
            return null;
        }
        if (i == this.firstTZTransitionIdx) {
            return this.firstTZTransition;
        }
        TimeArrayTimeZoneRule timeArrayTimeZoneRule = this.historicRules[getInt(this.typeMapData[i])];
        TimeArrayTimeZoneRule timeArrayTimeZoneRule2 = this.historicRules[getInt(this.typeMapData[i - 1])];
        long j3 = this.transitionTimes64[i] * 1000;
        if (timeArrayTimeZoneRule2.getName().equals(timeArrayTimeZoneRule.getName()) && timeArrayTimeZoneRule2.getRawOffset() == timeArrayTimeZoneRule.getRawOffset() && timeArrayTimeZoneRule2.getDSTSavings() == timeArrayTimeZoneRule.getDSTSavings()) {
            return getPreviousTransition(j3, false);
        }
        return new TimeZoneTransition(j3, timeArrayTimeZoneRule2, timeArrayTimeZoneRule);
    }

    private synchronized void initTransitionRules() {
        TimeZoneRule timeZoneRule;
        if (!this.transitionRulesInitialized) {
            this.initialRule = null;
            this.firstTZTransition = null;
            this.firstFinalTZTransition = null;
            this.historicRules = null;
            this.firstTZTransitionIdx = 0;
            this.finalZoneWithStartYear = null;
            String str = getID() + "(STD)";
            String str2 = getID() + "(DST)";
            int initialRawOffset = initialRawOffset() * 1000;
            int initialDstOffset = initialDstOffset() * 1000;
            this.initialRule = new InitialTimeZoneRule(initialDstOffset == 0 ? str : str2, initialRawOffset, initialDstOffset);
            if (this.transitionCount > 0) {
                int i = 0;
                while (true) {
                    if (i >= this.transitionCount) {
                        break;
                    } else if (getInt(this.typeMapData[i]) != 0) {
                        break;
                    } else {
                        this.firstTZTransitionIdx++;
                        i++;
                    }
                }
                if (i != this.transitionCount) {
                    long[] jArr = new long[this.transitionCount];
                    for (int i2 = 0; i2 < this.typeCount; i2++) {
                        int i3 = 0;
                        for (int i4 = this.firstTZTransitionIdx; i4 < this.transitionCount; i4++) {
                            if (i2 == getInt(this.typeMapData[i4])) {
                                long j = this.transitionTimes64[i4] * 1000;
                                if (((double) j) < this.finalStartMillis) {
                                    i3++;
                                    jArr[i3] = j;
                                }
                            }
                        }
                        if (i3 > 0) {
                            long[] jArr2 = new long[i3];
                            System.arraycopy(jArr, 0, jArr2, 0, i3);
                            int i5 = this.typeOffsets[i2 * 2] * 1000;
                            int i6 = this.typeOffsets[(i2 * 2) + 1] * 1000;
                            if (this.historicRules == null) {
                                this.historicRules = new TimeArrayTimeZoneRule[this.typeCount];
                            }
                            this.historicRules[i2] = new TimeArrayTimeZoneRule(i6 == 0 ? str : str2, i5, i6, jArr2, 2);
                        }
                    }
                    this.firstTZTransition = new TimeZoneTransition(this.transitionTimes64[this.firstTZTransitionIdx] * 1000, this.initialRule, this.historicRules[getInt(this.typeMapData[this.firstTZTransitionIdx])]);
                }
            }
            if (this.finalZone != null) {
                long j2 = (long) this.finalStartMillis;
                if (this.finalZone.useDaylightTime()) {
                    this.finalZoneWithStartYear = (SimpleTimeZone) this.finalZone.clone();
                    this.finalZoneWithStartYear.setStartYear(this.finalStartYear);
                    TimeZoneTransition nextTransition = this.finalZoneWithStartYear.getNextTransition(j2, false);
                    timeZoneRule = nextTransition.getTo();
                    j2 = nextTransition.getTime();
                } else {
                    this.finalZoneWithStartYear = this.finalZone;
                    timeZoneRule = new TimeArrayTimeZoneRule(this.finalZone.getID(), this.finalZone.getRawOffset(), 0, new long[]{j2}, 2);
                }
                TimeZoneRule timeZoneRule2 = null;
                if (this.transitionCount > 0) {
                    timeZoneRule2 = this.historicRules[getInt(this.typeMapData[this.transitionCount - 1])];
                }
                if (timeZoneRule2 == null) {
                    timeZoneRule2 = this.initialRule;
                }
                this.firstFinalTZTransition = new TimeZoneTransition(j2, timeZoneRule2, timeZoneRule);
            }
            this.transitionRulesInitialized = true;
        }
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        if (this.serialVersionOnStream < 1) {
            boolean z = false;
            String id = getID();
            if (id != null) {
                try {
                    UResourceBundle bundleInstance = UResourceBundle.getBundleInstance("com/ibm/icu/impl/data/icudt59b", "zoneinfo64", ICUResourceBundle.ICU_DATA_CLASS_LOADER);
                    construct(bundleInstance, ZoneMeta.openOlsonResource(bundleInstance, id));
                    if (this.finalZone != null) {
                        this.finalZone.setID(id);
                    }
                    z = true;
                } catch (Exception e) {
                }
            }
            if (!z) {
                constructEmpty();
            }
        }
        this.transitionRulesInitialized = false;
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
        OlsonTimeZone olsonTimeZone = (OlsonTimeZone) super.cloneAsThawed();
        if (this.finalZone != null) {
            this.finalZone.setID(getID());
            olsonTimeZone.finalZone = (SimpleTimeZone) this.finalZone.clone();
        }
        olsonTimeZone.isFrozen = false;
        return olsonTimeZone;
    }
}
