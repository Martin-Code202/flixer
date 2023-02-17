package android.support.v4.widget;

import android.support.v4.os.BuildCompat;
public interface AutoSizeableTextView {
    public static final boolean PLATFORM_SUPPORTS_AUTOSIZE = BuildCompat.isAtLeastOMR1();

    @Override // android.support.v4.widget.AutoSizeableTextView
    int getAutoSizeMinTextSize();

    @Override // android.support.v4.widget.AutoSizeableTextView
    int getAutoSizeTextType();

    @Override // android.support.v4.widget.AutoSizeableTextView
    void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i);
}
