package com.netflix.msl.msg;

import com.netflix.msl.MslConstants;
import java.util.Map;
import java.util.Set;
import o.AbstractC1386Dc;
import o.AbstractC1408Dy;
import o.AbstractC1412Ec;
import o.DK;
import o.DO;
import o.DR;
import o.DW;
public interface MessageContext {
    /* renamed from: ʻ  reason: contains not printable characters */
    boolean mo3122();

    /* renamed from: ʼ  reason: contains not printable characters */
    boolean mo3123();

    /* renamed from: ʽ  reason: contains not printable characters */
    String mo3124();

    /* renamed from: ˊ  reason: contains not printable characters */
    String mo3125();

    /* renamed from: ˊ  reason: contains not printable characters */
    void mo3126(DO v);

    /* renamed from: ˊ  reason: contains not printable characters */
    void mo3127(DR dr, boolean z);

    /* renamed from: ˋ  reason: contains not printable characters */
    DK mo3128();

    /* renamed from: ˎ  reason: contains not printable characters */
    DW mo3129();

    /* renamed from: ˏ  reason: contains not printable characters */
    Map<String, AbstractC1386Dc> mo3130();

    /* renamed from: ˏ  reason: contains not printable characters */
    AbstractC1412Ec mo3131(ReauthCode reauthCode, boolean z, boolean z2);

    /* renamed from: ॱ  reason: contains not printable characters */
    Set<AbstractC1408Dy> mo3132();

    /* renamed from: ॱॱ  reason: contains not printable characters */
    boolean mo3133();

    /* renamed from: ᐝ  reason: contains not printable characters */
    boolean mo3134();

    public enum ReauthCode {
        USERDATA_REAUTH(MslConstants.ResponseCode.USERDATA_REAUTH),
        SSOTOKEN_REJECTED(MslConstants.ResponseCode.SSOTOKEN_REJECTED);
        

        /* renamed from: ˏ  reason: contains not printable characters */
        private final MslConstants.ResponseCode f4157;

        /* renamed from: ॱ  reason: contains not printable characters */
        public static ReauthCode m3135(MslConstants.ResponseCode responseCode) {
            ReauthCode[] values = values();
            for (ReauthCode reauthCode : values) {
                if (reauthCode.f4157 == responseCode) {
                    return reauthCode;
                }
            }
            throw new IllegalArgumentException("Unknown reauthentication code value " + responseCode + ".");
        }

        private ReauthCode(MslConstants.ResponseCode responseCode) {
            this.f4157 = responseCode;
        }
    }
}
