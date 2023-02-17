package com.netflix.mediaclient.ui.offline;

import o.AbstractC1853hl;
import o.pV;
import o.pY;
import o.pZ;
import o.vO;
public class StorageSwitchHelper {

    public enum StorageSwitchOption {
        CAN_NOT_SWITCH,
        SWITCH_TO_INTERNAL_STORAGE,
        SWITCH_TO_SD_CARD
    }

    StorageSwitchHelper() {
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static StorageSwitchOption m2224(AbstractC1853hl hlVar, String str) {
        pY r4 = hlVar.mo7136();
        if (r4.mo4074() != 2) {
            return StorageSwitchOption.CAN_NOT_SWITCH;
        }
        if (vO.m12029(hlVar).mo11966() >= 2) {
            return StorageSwitchOption.CAN_NOT_SWITCH;
        }
        int r6 = r4.mo9597();
        int i = r6 == 0 ? 1 : 0;
        long r8 = ((pZ) r4.mo4075(r6)).mo7013() - ((pZ) r4.mo4075(r6)).mo7005();
        long r10 = ((pZ) r4.mo4075(i)).mo7013() - ((pZ) r4.mo4075(i)).mo7005();
        if (r10 <= r8) {
            return StorageSwitchOption.CAN_NOT_SWITCH;
        }
        long j = 1000000000;
        pV r15 = vO.m12029(hlVar).mo11976(str);
        if (r15 != null && r15.mo6887() > 0) {
            j = r15.mo6887();
        }
        if (r10 <= j) {
            return StorageSwitchOption.CAN_NOT_SWITCH;
        }
        return i == 0 ? StorageSwitchOption.SWITCH_TO_INTERNAL_STORAGE : StorageSwitchOption.SWITCH_TO_SD_CARD;
    }
}
