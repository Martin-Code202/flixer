package com.netflix.mediaclient.util.gfx;

import android.graphics.Bitmap;
import com.netflix.mediaclient.api.res.AssetType;
import o.AbstractC0957;
import o.AbstractC1188;
import o.BT;
import o.C0524;
import o.oN;
public interface ImageLoader {

    public interface If {
        /* renamed from: ˊ */
        boolean mo450();

        /* renamed from: ˋ */
        int mo451();

        /* renamed from: ˎ */
        int mo452();
    }

    /* renamed from: com.netflix.mediaclient.util.gfx.ImageLoader$ˊ  reason: contains not printable characters */
    public interface AbstractC0050 extends C0524.AbstractC2398iF {
        /* renamed from: ˋ  reason: contains not printable characters */
        String mo3066();

        /* renamed from: ˋ  reason: contains not printable characters */
        void mo3067(BT bt, AssetLocationType assetLocationType);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    oN mo3055(String str);

    /* renamed from: ˊ  reason: contains not printable characters */
    void mo3056(AbstractC1188 v, AssetType assetType);

    /* renamed from: ˋ  reason: contains not printable characters */
    void mo3057(AbstractC1188 v, String str, AssetType assetType, String str2, If v2, boolean z);

    /* renamed from: ˎ  reason: contains not printable characters */
    void mo3058();

    /* renamed from: ˎ  reason: contains not printable characters */
    void mo3059(String str, AssetType assetType, int i, int i2, AbstractC0957 v);

    /* renamed from: ˎ  reason: contains not printable characters */
    void mo3060(String str, AssetType assetType, int i, int i2, AbstractC0957 v, boolean z);

    /* renamed from: ˎ  reason: contains not printable characters */
    void mo3061(oN oNVar);

    /* renamed from: ˎ  reason: contains not printable characters */
    void mo3062(AbstractC1188 v);

    /* renamed from: ˏ  reason: contains not printable characters */
    void mo3063(AbstractC1188 v, String str, AssetType assetType, String str2, If v2, boolean z, int i);

    /* renamed from: ॱ  reason: contains not printable characters */
    void mo3064(AbstractC1188 v, String str, AssetType assetType, String str2, If v2, boolean z, int i, Bitmap.Config config);

    public enum AssetLocationType {
        DISKCACHE,
        NETWORK,
        MEMCACHE,
        PLACEHOLDER;

        /* renamed from: ˋ  reason: contains not printable characters */
        public boolean m3065() {
            return this != NETWORK;
        }
    }
}
