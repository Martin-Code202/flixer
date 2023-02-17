package o;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import o.C0602;
/* access modifiers changed from: package-private */
/* renamed from: o.ܪ  reason: contains not printable characters */
public class C0643 {

    /* renamed from: ʻ  reason: contains not printable characters */
    final int f13962;

    /* renamed from: ʼ  reason: contains not printable characters */
    final boolean f13963;

    /* renamed from: ʽ  reason: contains not printable characters */
    final CharSequence f13964;

    /* renamed from: ˊ  reason: contains not printable characters */
    final ColorStateList f13965;

    /* renamed from: ˋ  reason: contains not printable characters */
    final ColorStateList f13966;

    /* renamed from: ˎ  reason: contains not printable characters */
    final ColorStateList f13967;

    /* renamed from: ˏ  reason: contains not printable characters */
    final int f13968;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    final int f13969;

    /* renamed from: ॱ  reason: contains not printable characters */
    final int f13970;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    final boolean f13971;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    final int f13972;

    /* renamed from: ᐝ  reason: contains not printable characters */
    final ColorStateList f13973;

    C0643(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0602.aux.NetflixButton);
        this.f13967 = m14778(obtainStyledAttributes, C0602.aux.NetflixButton_nb_strokeColor);
        this.f13965 = m14778(obtainStyledAttributes, C0602.aux.NetflixButton_nb_buttonColor);
        this.f13966 = m14778(obtainStyledAttributes, C0602.aux.NetflixButton_nb_textColor);
        this.f13973 = m14779(obtainStyledAttributes, C0602.aux.NetflixButton_nb_iconColor, this.f13966);
        this.f13963 = obtainStyledAttributes.getBoolean(C0602.aux.NetflixButton_nb_iconCentered, false);
        this.f13970 = obtainStyledAttributes.getColor(C0602.aux.NetflixButton_nb_rippleColor, this.f13965.getColorForState(new int[]{16842919}, 0));
        this.f13968 = obtainStyledAttributes.getDimensionPixelSize(C0602.aux.NetflixButton_nb_cornerRadius, 0);
        this.f13962 = obtainStyledAttributes.getDimensionPixelSize(C0602.aux.NetflixButton_nb_strokeWidth, 0);
        this.f13972 = obtainStyledAttributes.getDimensionPixelSize(C0602.aux.NetflixButton_nb_iconSize, 0);
        this.f13964 = obtainStyledAttributes.getString(C0602.aux.NetflixButton_nb_text);
        this.f13969 = obtainStyledAttributes.getDimensionPixelSize(C0602.aux.NetflixButton_nb_initialWidth, 0);
        this.f13971 = obtainStyledAttributes.getBoolean(C0602.aux.NetflixButton_nb_borderlessRipple, false);
        obtainStyledAttributes.recycle();
    }

    C0643(Context context, int i) {
        TypedArray obtainStyledAttributes = new ContextThemeWrapper(context, i).obtainStyledAttributes(new int[]{C0602.C2399If.nb_strokeColor, C0602.C2399If.nb_buttonColor, C0602.C2399If.nb_textColor, C0602.C2399If.nb_rippleColor, C0602.C2399If.nb_cornerRadius, C0602.C2399If.nb_strokeWidth, C0602.C2399If.nb_iconSize, C0602.C2399If.nb_iconColor, C0602.C2399If.nb_iconCentered, C0602.C2399If.nb_text, C0602.C2399If.nb_initialWidth, C0602.C2399If.nb_borderlessRipple});
        try {
            this.f13967 = m14778(obtainStyledAttributes, 0);
            this.f13965 = m14778(obtainStyledAttributes, 1);
            this.f13966 = m14778(obtainStyledAttributes, 2);
            this.f13970 = obtainStyledAttributes.getColor(3, this.f13965.getColorForState(new int[]{16842919}, 0));
            this.f13968 = obtainStyledAttributes.getDimensionPixelSize(4, 0);
            this.f13962 = obtainStyledAttributes.getDimensionPixelSize(5, 0);
            this.f13972 = obtainStyledAttributes.getDimensionPixelSize(6, 0);
            this.f13973 = m14778(obtainStyledAttributes, 7);
            this.f13963 = obtainStyledAttributes.getBoolean(8, false);
            this.f13964 = obtainStyledAttributes.getString(9);
            this.f13969 = obtainStyledAttributes.getDimensionPixelSize(10, 0);
            this.f13971 = obtainStyledAttributes.getBoolean(11, false);
        } finally {
            if (obtainStyledAttributes != null) {
                obtainStyledAttributes.recycle();
            }
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private static ColorStateList m14778(TypedArray typedArray, int i) {
        return m14779(typedArray, i, ColorStateList.valueOf(0));
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static ColorStateList m14779(TypedArray typedArray, int i, ColorStateList colorStateList) {
        ColorStateList colorStateList2 = typedArray.getColorStateList(i);
        return colorStateList2 == null ? colorStateList : colorStateList2;
    }
}
