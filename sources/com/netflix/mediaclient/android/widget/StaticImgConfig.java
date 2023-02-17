package com.netflix.mediaclient.android.widget;

import com.netflix.mediaclient.R;
import com.netflix.mediaclient.util.gfx.ImageLoader;
public enum StaticImgConfig implements ImageLoader.If {
    DARK_NO_PLACEHOLDER(0, R.drawable.dark_img_placeholder),
    LIGHT_NO_PLACEHOLDER(0, R.drawable.light_img_placeholder),
    DARK(R.drawable.dark_img_placeholder, R.drawable.dark_img_placeholder),
    LIGHT(R.drawable.light_img_placeholder, R.drawable.light_img_placeholder);
    

    /* renamed from: ʼ  reason: contains not printable characters */
    private final int f962;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final int f963;

    private StaticImgConfig(int i, int i2) {
        this.f963 = i;
        this.f962 = i2;
    }

    @Override // com.netflix.mediaclient.util.gfx.ImageLoader.If
    /* renamed from: ˊ  reason: contains not printable characters */
    public boolean mo450() {
        return this.f963 != 0;
    }

    @Override // com.netflix.mediaclient.util.gfx.ImageLoader.If
    /* renamed from: ˎ  reason: contains not printable characters */
    public int mo452() {
        return this.f963;
    }

    @Override // com.netflix.mediaclient.util.gfx.ImageLoader.If
    /* renamed from: ˋ  reason: contains not printable characters */
    public int mo451() {
        return this.f962;
    }
}
