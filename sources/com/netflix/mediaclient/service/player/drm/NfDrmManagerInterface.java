package com.netflix.mediaclient.service.player.drm;

import o.AbstractC1924jy;
import o.AbstractC1925jz;
public interface NfDrmManagerInterface extends AbstractC1924jy, AbstractC1925jz {

    public enum LicenseType {
        LICENSE_TYPE_LDL(1, "LDL"),
        LICENSE_TYPE_STANDARD(2, "STANDARD"),
        LICENSE_TYPE_OFFLINE(3, "OFFLINE");
        

        /* renamed from: ˋ  reason: contains not printable characters */
        private int f1777;

        /* renamed from: ˎ  reason: contains not printable characters */
        private String f1778;

        private LicenseType(int i, String str) {
            this.f1777 = i;
            this.f1778 = str;
        }
    }
}
