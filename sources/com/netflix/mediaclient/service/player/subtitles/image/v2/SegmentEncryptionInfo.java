package com.netflix.mediaclient.service.player.subtitles.image.v2;

import java.io.DataInputStream;
import java.util.Arrays;
import o.AbstractC1994my;
import o.C1283;
import o.mA;
import o.mK;
public class SegmentEncryptionInfo extends AbstractC1994my {

    /* renamed from: ˋ  reason: contains not printable characters */
    private int f2010;

    /* renamed from: ˎ  reason: contains not printable characters */
    private byte f2011;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private C0022[] f2012;

    public enum EncryptionMode {
        NONE,
        AES_CTR,
        AES_CBC,
        RESERVED
    }

    public SegmentEncryptionInfo(mA mAVar, DataInputStream dataInputStream) {
        super(mAVar, dataInputStream);
        if (!m8800().m8798("com.netflix.senc")) {
            throw new IllegalStateException("SegmentIndex does not have expected user type value!");
        }
        this.f2010 = dataInputStream.readInt();
        this.f2011 = dataInputStream.readByte();
        this.f2012 = new C0022[this.f2010];
        for (int i = 0; i < this.f2010; i++) {
            this.f2012[i] = new C0022(dataInputStream, this.f2011);
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public C0022[] m1151() {
        return this.f2012;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static boolean m1150(mA mAVar) {
        if (mAVar != null) {
            return "com.netflix.senc".equals(mAVar.m8796());
        }
        throw new IllegalStateException("Header is null!");
    }

    /* renamed from: com.netflix.mediaclient.service.player.subtitles.image.v2.SegmentEncryptionInfo$ˊ  reason: contains not printable characters */
    public static class C0022 {

        /* renamed from: ˊ  reason: contains not printable characters */
        private static final byte[] f2018 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        /* renamed from: ˋ  reason: contains not printable characters */
        private byte f2019;

        /* renamed from: ˎ  reason: contains not printable characters */
        private byte[] f2020;

        /* renamed from: ˏ  reason: contains not printable characters */
        private byte f2021;

        /* renamed from: ॱ  reason: contains not printable characters */
        private EncryptionMode f2022;

        private C0022(DataInputStream dataInputStream, byte b) {
            int readUnsignedByte = dataInputStream.readUnsignedByte();
            this.f2021 = (byte) (readUnsignedByte & 63);
            this.f2019 = (byte) (readUnsignedByte >>> 6);
            m1152();
            if (m1153(b)) {
                this.f2020 = mK.m8845(dataInputStream, this.f2021);
            } else {
                C1283.m16854("nf_subtitles_imv2", "IV size is 0, use 0 as IV, set to empty array...");
            }
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        private boolean m1153(byte b) {
            boolean z = true;
            if (this.f2021 == 0 && this.f2022 != EncryptionMode.NONE) {
                this.f2021 = b;
            }
            if (this.f2021 != 0 && this.f2021 != 8 && this.f2021 != 16) {
                throw new IllegalStateException("Invalid IV size, must be 0, 8 or 16 and NOT " + ((int) this.f2021));
            } else if (this.f2021 == 0 && this.f2022 == EncryptionMode.AES_CTR && b == 0) {
                throw new IllegalStateException("Invalid IV size for AES-CTR, must be 8 or 16 and NOT " + ((int) this.f2021));
            } else {
                if (this.f2021 == 0 && this.f2022 == EncryptionMode.AES_CBC && b == 0) {
                    this.f2021 = 16;
                    this.f2020 = f2018;
                    z = false;
                }
                if (this.f2021 == 0) {
                    return false;
                }
                return z;
            }
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        private void m1152() {
            switch (this.f2019) {
                case 0:
                    this.f2022 = EncryptionMode.NONE;
                    return;
                case 1:
                    this.f2022 = EncryptionMode.AES_CTR;
                    return;
                case 2:
                    this.f2022 = EncryptionMode.AES_CBC;
                    return;
                case 3:
                    this.f2022 = EncryptionMode.RESERVED;
                    return;
                default:
                    this.f2022 = EncryptionMode.NONE;
                    C1283.m16850("nf_subtitles_imv2", "ImageEncryptionInfo:: Not recognized encryption mode. We should never be here! " + ((int) this.f2019));
                    return;
            }
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public byte[] m1155() {
            return this.f2020;
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        public EncryptionMode m1154() {
            return this.f2022;
        }

        public String toString() {
            return "ImageEncryptionInfo{encryptionModeRaw=" + ((int) this.f2019) + ", ivSize=" + ((int) this.f2021) + ", encryptionMode=" + this.f2022 + '}';
        }
    }

    @Override // o.AbstractC1994my, o.mB
    public String toString() {
        return "SegmentEncryptionInfo{sampleCount=" + this.f2010 + ", defaultIVSize=" + ((int) this.f2011) + ", mImageEncryptions=" + Arrays.toString(this.f2012) + "} " + super.toString();
    }
}
