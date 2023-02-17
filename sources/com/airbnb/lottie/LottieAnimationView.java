package com.airbnb.lottie;

import android.animation.Animator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.widget.AppCompatImageView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import o.AbstractC0432;
import o.AbstractC0437;
import o.AbstractC1871iF;
import o.C0433;
import o.C0731;
import o.C1026;
import o.C1321Aux;
import o.C1490aUx;
import o.C1518aux;
import org.json.JSONObject;
public class LottieAnimationView extends AppCompatImageView {

    /* renamed from: ˋ  reason: contains not printable characters */
    private static final Map<String, C0433> f0 = new HashMap();

    /* renamed from: ˎ  reason: contains not printable characters */
    private static final Map<String, WeakReference<C0433>> f1 = new HashMap();

    /* renamed from: ˏ  reason: contains not printable characters */
    private static final String f2 = LottieAnimationView.class.getSimpleName();

    /* renamed from: ʻ  reason: contains not printable characters */
    private boolean f3 = false;

    /* renamed from: ʼ  reason: contains not printable characters */
    private String f4;

    /* renamed from: ʽ  reason: contains not printable characters */
    private boolean f5 = false;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final C1518aux f6 = new C1518aux();

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private AbstractC0432 f7;

    /* renamed from: ͺ  reason: contains not printable characters */
    private C0433 f8;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final AbstractC0437 f9 = new AbstractC0437() { // from class: com.airbnb.lottie.LottieAnimationView.2
        @Override // o.AbstractC0437
        /* renamed from: ॱ  reason: contains not printable characters */
        public void mo18(C0433 r3) {
            if (r3 != null) {
                LottieAnimationView.this.setComposition(r3);
            }
            LottieAnimationView.this.f7 = null;
        }
    };

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private boolean f10 = false;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private CacheStrategy f11;

    public enum CacheStrategy {
        None,
        Weak,
        Strong
    }

    public LottieAnimationView(Context context) {
        super(context);
        m4((AttributeSet) null);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m4(attributeSet);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m4(attributeSet);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m4(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C0731.C0732.LottieAnimationView);
        this.f11 = CacheStrategy.values()[obtainStyledAttributes.getInt(C0731.C0732.LottieAnimationView_lottie_cacheStrategy, CacheStrategy.Weak.ordinal())];
        String string = obtainStyledAttributes.getString(C0731.C0732.LottieAnimationView_lottie_fileName);
        if (!isInEditMode() && string != null) {
            setAnimation(string);
        }
        if (obtainStyledAttributes.getBoolean(C0731.C0732.LottieAnimationView_lottie_autoPlay, false)) {
            this.f6.m5699();
            this.f5 = true;
        }
        this.f6.m5686(obtainStyledAttributes.getBoolean(C0731.C0732.LottieAnimationView_lottie_loop, false));
        setImageAssetsFolder(obtainStyledAttributes.getString(C0731.C0732.LottieAnimationView_lottie_imageAssetsFolder));
        setProgress(obtainStyledAttributes.getFloat(C0731.C0732.LottieAnimationView_lottie_progress, 0.0f));
        m11(obtainStyledAttributes.getBoolean(C0731.C0732.LottieAnimationView_lottie_enableMergePathsForKitKatAndAbove, false));
        if (obtainStyledAttributes.hasValue(C0731.C0732.LottieAnimationView_lottie_colorFilter)) {
            m16(new C1321Aux(obtainStyledAttributes.getColor(C0731.C0732.LottieAnimationView_lottie_colorFilter, 0)));
        }
        if (obtainStyledAttributes.hasValue(C0731.C0732.LottieAnimationView_lottie_scale)) {
            this.f6.m5669(obtainStyledAttributes.getFloat(C0731.C0732.LottieAnimationView_lottie_scale, 1.0f));
        }
        obtainStyledAttributes.recycle();
        if (C1026.m16015(getContext()) == 0.0f) {
            this.f6.m5679();
        }
        m0();
    }

    @Override // android.support.v7.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i) {
        m10();
        m5();
        super.setImageResource(i);
    }

    @Override // android.support.v7.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        if (drawable != this.f6) {
            m10();
        }
        m5();
        super.setImageDrawable(drawable);
    }

    @Override // android.support.v7.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        m10();
        m5();
        super.setImageBitmap(bitmap);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m16(ColorFilter colorFilter) {
        this.f6.m5683(colorFilter);
    }

    @Override // android.widget.ImageView, android.graphics.drawable.Drawable.Callback, android.view.View
    public void invalidateDrawable(Drawable drawable) {
        if (getDrawable() == this.f6) {
            super.invalidateDrawable(this.f6);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    /* access modifiers changed from: protected */
    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Cif ifVar = new Cif(super.onSaveInstanceState());
        ifVar.f24 = this.f4;
        ifVar.f23 = this.f6.m5700();
        ifVar.f20 = this.f6.m5665();
        ifVar.f22 = this.f6.m5678();
        ifVar.f21 = this.f6.m5668();
        return ifVar;
    }

    /* access modifiers changed from: protected */
    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof Cif)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        Cif ifVar = (Cif) parcelable;
        super.onRestoreInstanceState(ifVar.getSuperState());
        this.f4 = ifVar.f24;
        if (!TextUtils.isEmpty(this.f4)) {
            setAnimation(this.f4);
        }
        setProgress(ifVar.f23);
        m8(ifVar.f22);
        if (ifVar.f20) {
            m9();
        }
        this.f6.m5684(ifVar.f21);
    }

    /* access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f5 && this.f3) {
            m9();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        if (m13()) {
            m6();
            this.f3 = true;
        }
        m10();
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˎ  reason: contains not printable characters */
    public void m10() {
        if (this.f6 != null) {
            this.f6.m5694();
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m11(boolean z) {
        this.f6.m5690(z);
    }

    public void setAnimation(String str) {
        setAnimation(str, this.f11);
    }

    public void setAnimation(final String str, final CacheStrategy cacheStrategy) {
        this.f4 = str;
        if (f1.containsKey(str)) {
            C0433 r3 = f1.get(str).get();
            if (r3 != null) {
                setComposition(r3);
                return;
            }
        } else if (f0.containsKey(str)) {
            setComposition(f0.get(str));
            return;
        }
        this.f4 = str;
        this.f6.m5693();
        m5();
        this.f7 = C0433.iF.m14275(getContext(), str, new AbstractC0437() { // from class: com.airbnb.lottie.LottieAnimationView.3
            @Override // o.AbstractC0437
            /* renamed from: ॱ */
            public void mo18(C0433 r4) {
                if (cacheStrategy == CacheStrategy.Strong) {
                    LottieAnimationView.f0.put(str, r4);
                } else if (cacheStrategy == CacheStrategy.Weak) {
                    LottieAnimationView.f1.put(str, new WeakReference(r4));
                }
                LottieAnimationView.this.setComposition(r4);
            }
        });
    }

    public void setAnimation(JSONObject jSONObject) {
        m5();
        this.f7 = C0433.iF.m14272(getResources(), jSONObject, this.f9);
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    private void m5() {
        if (this.f7 != null) {
            this.f7.mo14245();
            this.f7 = null;
        }
    }

    public void setComposition(C0433 r3) {
        this.f6.setCallback(this);
        boolean r1 = this.f6.m5692(r3);
        m0();
        if (r1) {
            setImageDrawable(null);
            setImageDrawable(this.f6);
            this.f8 = r3;
            requestLayout();
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m12(Animator.AnimatorListener animatorListener) {
        this.f6.m5677(animatorListener);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m15(Animator.AnimatorListener animatorListener) {
        this.f6.m5682(animatorListener);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m8(boolean z) {
        this.f6.m5686(z);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public boolean m13() {
        return this.f6.m5665();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m9() {
        this.f6.m5699();
        m0();
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m7(int i, int i2) {
        this.f6.m5672(i, i2);
    }

    public void setMinFrame(int i) {
        this.f6.m5671(i);
    }

    public void setMinProgress(float f) {
        this.f6.m5676(f);
    }

    public void setMaxFrame(int i) {
        this.f6.m5681(i);
    }

    public void setMaxProgress(float f) {
        this.f6.m5695(f);
    }

    public void setMinAndMaxFrame(int i, int i2) {
        this.f6.m5696(i, i2);
    }

    public void setMinAndMaxProgress(float f, float f12) {
        this.f6.m5670(f, f12);
    }

    public void setSpeed(float f) {
        this.f6.m5680(f);
    }

    public void setImageAssetsFolder(String str) {
        this.f6.m5684(str);
    }

    public void setImageAssetDelegate(AbstractC1871iF iFVar) {
        this.f6.m5697(iFVar);
    }

    public void setFontAssetDelegate(o.Cif ifVar) {
        this.f6.m5685(ifVar);
    }

    public void setTextDelegate(C1490aUx aux) {
        this.f6.m5689(aux);
    }

    public void setScale(float f) {
        this.f6.m5669(f);
        if (getDrawable() == this.f6) {
            setImageDrawable(null);
            setImageDrawable(this.f6);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m6() {
        this.f6.m5693();
        m0();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m14() {
        float r1 = m17();
        this.f6.m5693();
        setProgress(r1);
        m0();
    }

    public void setProgress(float f) {
        this.f6.m5687(f);
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public float m17() {
        return this.f6.m5700();
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.f6.m5673(z);
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    private void m0() {
        setLayerType(this.f10 && this.f6.m5665() ? 2 : 1, null);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.airbnb.lottie.LottieAnimationView$if  reason: invalid class name */
    public static class Cif extends View.BaseSavedState {
        public static final Parcelable.Creator<Cif> CREATOR = new Parcelable.Creator<Cif>() { // from class: com.airbnb.lottie.LottieAnimationView.if.4
            /* renamed from: ˊ  reason: contains not printable characters */
            public Cif createFromParcel(Parcel parcel) {
                return new Cif(parcel);
            }

            /* renamed from: ˊ  reason: contains not printable characters */
            public Cif[] newArray(int i) {
                return new Cif[i];
            }
        };

        /* renamed from: ˊ  reason: contains not printable characters */
        boolean f20;

        /* renamed from: ˋ  reason: contains not printable characters */
        String f21;

        /* renamed from: ˎ  reason: contains not printable characters */
        boolean f22;

        /* renamed from: ˏ  reason: contains not printable characters */
        float f23;

        /* renamed from: ॱ  reason: contains not printable characters */
        String f24;

        Cif(Parcelable parcelable) {
            super(parcelable);
        }

        private Cif(Parcel parcel) {
            super(parcel);
            this.f24 = parcel.readString();
            this.f23 = parcel.readFloat();
            this.f20 = parcel.readInt() == 1;
            this.f22 = parcel.readInt() == 1;
            this.f21 = parcel.readString();
        }

        @Override // android.view.View.BaseSavedState, android.os.Parcelable, android.view.AbsSavedState
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.f24);
            parcel.writeFloat(this.f23);
            parcel.writeInt(this.f20 ? 1 : 0);
            parcel.writeInt(this.f22 ? 1 : 0);
            parcel.writeString(this.f21);
        }
    }
}
