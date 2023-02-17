package com.netflix.mediaclient.ui.player;

import android.os.Parcel;
import android.os.Parcelable;
import o.C1456Fq;
import o.C1457Fr;
import paperparcel.PaperParcel;
@PaperParcel
public final class PlanChoice implements Parcelable {
    public static final Parcelable.Creator<PlanChoice> CREATOR = PaperParcelPlanChoice.f3458;

    /* renamed from: ॱ  reason: contains not printable characters */
    public static final If f3470 = new If(null);

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private static final PlanChoice f3471 = new PlanChoice(0, 0, null, null, 0.0f, null, null, null, null, null, null, null, null, null, 16383, null);

    /* renamed from: ʻ  reason: contains not printable characters */
    private final float f3472;

    /* renamed from: ʼ  reason: contains not printable characters */
    private final String f3473;

    /* renamed from: ʽ  reason: contains not printable characters */
    private final String f3474;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final int f3475;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private final String f3476;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final int f3477;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private final Float f3478;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final String f3479;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final String f3480;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private final String f3481;

    /* renamed from: ͺ  reason: contains not printable characters */
    private final Long f3482;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private final String f3483;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final String f3484;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final String f3485;

    public PlanChoice() {
        this(0, 0, null, null, 0.0f, null, null, null, null, null, null, null, null, null, 16383, null);
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlanChoice)) {
            return false;
        }
        PlanChoice planChoice = (PlanChoice) obj;
        if (!(this.f3475 == planChoice.f3475)) {
            return false;
        }
        return (this.f3477 == planChoice.f3477) && C1457Fr.m5018(this.f3480, planChoice.f3480) && C1457Fr.m5018(this.f3479, planChoice.f3479) && Float.compare(this.f3472, planChoice.f3472) == 0 && C1457Fr.m5018(this.f3474, planChoice.f3474) && C1457Fr.m5018(this.f3473, planChoice.f3473) && C1457Fr.m5018(this.f3485, planChoice.f3485) && C1457Fr.m5018(this.f3484, planChoice.f3484) && C1457Fr.m5018(this.f3482, planChoice.f3482) && C1457Fr.m5018(this.f3481, planChoice.f3481) && C1457Fr.m5018(this.f3476, planChoice.f3476) && C1457Fr.m5018(this.f3478, planChoice.f3478) && C1457Fr.m5018(this.f3483, planChoice.f3483);
    }

    @Override // java.lang.Object
    public int hashCode() {
        int i = ((this.f3475 * 31) + this.f3477) * 31;
        String str = this.f3480;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f3479;
        int hashCode2 = (((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + Float.floatToIntBits(this.f3472)) * 31;
        String str3 = this.f3474;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f3473;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.f3485;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.f3484;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        Long l = this.f3482;
        int hashCode7 = (hashCode6 + (l != null ? l.hashCode() : 0)) * 31;
        String str7 = this.f3481;
        int hashCode8 = (hashCode7 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.f3476;
        int hashCode9 = (hashCode8 + (str8 != null ? str8.hashCode() : 0)) * 31;
        Float f = this.f3478;
        int hashCode10 = (hashCode9 + (f != null ? f.hashCode() : 0)) * 31;
        String str9 = this.f3483;
        return hashCode10 + (str9 != null ? str9.hashCode() : 0);
    }

    @Override // java.lang.Object
    public String toString() {
        return "PlanChoice(planID=" + this.f3475 + ", maxStreams=" + this.f3477 + ", country=" + this.f3480 + ", currency=" + this.f3479 + ", price=" + this.f3472 + ", priceFormatted=" + this.f3474 + ", priceTier=" + this.f3473 + ", quality=" + this.f3485 + ", grandfatheredState=" + this.f3484 + ", planChangeEffectiveDate=" + this.f3482 + ", planStatus=" + this.f3481 + ", planChangeType=" + this.f3476 + ", additionalAmountOverCurrent=" + this.f3478 + ", additionalAmountOverCurrentFormatted=" + this.f3483 + ")";
    }

    public PlanChoice(int i, int i2, String str, String str2, float f, String str3, String str4, String str5, String str6, Long l, String str7, String str8, Float f2, String str9) {
        this.f3475 = i;
        this.f3477 = i2;
        this.f3480 = str;
        this.f3479 = str2;
        this.f3472 = f;
        this.f3474 = str3;
        this.f3473 = str4;
        this.f3485 = str5;
        this.f3484 = str6;
        this.f3482 = l;
        this.f3481 = str7;
        this.f3476 = str8;
        this.f3478 = f2;
        this.f3483 = str9;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PlanChoice(int i, int i2, String str, String str2, float f, String str3, String str4, String str5, String str6, Long l, String str7, String str8, Float f2, String str9, int i3, C1456Fq fq) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2, (i3 & 4) != 0 ? "" : str, (i3 & 8) != 0 ? "" : str2, (i3 & 16) != 0 ? 0.0f : f, (i3 & 32) != 0 ? "" : str3, (i3 & 64) != 0 ? "" : str4, (i3 & 128) != 0 ? "" : str5, (i3 & 256) != 0 ? "" : str6, (i3 & 512) != 0 ? 0L : l, (i3 & 1024) != 0 ? "" : str7, (i3 & 2048) != 0 ? "" : str8, (i3 & 4096) != 0 ? Float.valueOf(0.0f) : f2, (i3 & 8192) != 0 ? "" : str9);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public final int m2381() {
        return this.f3475;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public final int m2383() {
        return this.f3477;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public final String m2378() {
        return this.f3480;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public final String m2376() {
        return this.f3479;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public final float m2380() {
        return this.f3472;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public final String m2373() {
        return this.f3474;
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public final String m2385() {
        return this.f3473;
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    public final String m2386() {
        return this.f3485;
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public final String m2375() {
        return this.f3484;
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public final Long m2374() {
        return this.f3482;
    }

    /* renamed from: ॱˊ  reason: contains not printable characters */
    public final String m2384() {
        return this.f3481;
    }

    /* renamed from: ͺ  reason: contains not printable characters */
    public final String m2382() {
        return this.f3476;
    }

    /* renamed from: ˋॱ  reason: contains not printable characters */
    public final Float m2379() {
        return this.f3478;
    }

    /* renamed from: ˊॱ  reason: contains not printable characters */
    public final String m2377() {
        return this.f3483;
    }

    public static final class If {
        private If() {
        }

        public /* synthetic */ If(C1456Fq fq) {
            this();
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        public final PlanChoice m2387() {
            return PlanChoice.f3471;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        C1457Fr.m5025(parcel, "dest");
        PaperParcelPlanChoice.writeToParcel(this, parcel, i);
    }
}
