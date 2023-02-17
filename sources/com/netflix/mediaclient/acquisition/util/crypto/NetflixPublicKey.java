package com.netflix.mediaclient.acquisition.util.crypto;

import o.C1457Fr;
public final class NetflixPublicKey {
    private final int aid;
    private final String exponent;
    private final long kid;
    private final String modulus;

    public static /* synthetic */ NetflixPublicKey copy$default(NetflixPublicKey netflixPublicKey, long j, int i, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = netflixPublicKey.kid;
        }
        if ((i2 & 2) != 0) {
            i = netflixPublicKey.aid;
        }
        if ((i2 & 4) != 0) {
            str = netflixPublicKey.modulus;
        }
        if ((i2 & 8) != 0) {
            str2 = netflixPublicKey.exponent;
        }
        return netflixPublicKey.copy(j, i, str, str2);
    }

    public final long component1() {
        return this.kid;
    }

    public final int component2() {
        return this.aid;
    }

    public final String component3() {
        return this.modulus;
    }

    public final String component4() {
        return this.exponent;
    }

    public final NetflixPublicKey copy(long j, int i, String str, String str2) {
        C1457Fr.m5025(str, "modulus");
        C1457Fr.m5025(str2, "exponent");
        return new NetflixPublicKey(j, i, str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NetflixPublicKey)) {
            return false;
        }
        NetflixPublicKey netflixPublicKey = (NetflixPublicKey) obj;
        if (!(this.kid == netflixPublicKey.kid)) {
            return false;
        }
        return (this.aid == netflixPublicKey.aid) && C1457Fr.m5018(this.modulus, netflixPublicKey.modulus) && C1457Fr.m5018(this.exponent, netflixPublicKey.exponent);
    }

    public int hashCode() {
        long j = this.kid;
        int i = ((((int) (j ^ (j >>> 32))) * 31) + this.aid) * 31;
        String str = this.modulus;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.exponent;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "NetflixPublicKey(kid=" + this.kid + ", aid=" + this.aid + ", modulus=" + this.modulus + ", exponent=" + this.exponent + ")";
    }

    public NetflixPublicKey(long j, int i, String str, String str2) {
        C1457Fr.m5025(str, "modulus");
        C1457Fr.m5025(str2, "exponent");
        this.kid = j;
        this.aid = i;
        this.modulus = str;
        this.exponent = str2;
    }

    public final int getAid() {
        return this.aid;
    }

    public final String getExponent() {
        return this.exponent;
    }

    public final long getKid() {
        return this.kid;
    }

    public final String getModulus() {
        return this.modulus;
    }
}
