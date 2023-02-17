package o;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import o.C0602;
/* renamed from: o.ﺋ  reason: contains not printable characters */
public class C1177 extends FrameLayout {

    /* renamed from: ʻ  reason: contains not printable characters */
    private TextView f15469;

    /* renamed from: ʻॱ  reason: contains not printable characters */
    private CharSequence f15470;

    /* renamed from: ʼ  reason: contains not printable characters */
    protected CharSequence f15471;

    /* renamed from: ʼॱ  reason: contains not printable characters */
    private CharSequence f15472;

    /* renamed from: ʽ  reason: contains not printable characters */
    protected CharSequence f15473;

    /* renamed from: ʽॱ  reason: contains not printable characters */
    private CharSequence f15474;

    /* renamed from: ʾ  reason: contains not printable characters */
    private CharSequence f15475;

    /* renamed from: ˈ  reason: contains not printable characters */
    private boolean f15476 = true;

    /* renamed from: ˊ  reason: contains not printable characters */
    protected CharSequence f15477;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private Drawable f15478;

    /* renamed from: ˋ  reason: contains not printable characters */
    protected AbstractC1178 f15479;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private ColorStateList f15480;

    /* renamed from: ˎ  reason: contains not printable characters */
    protected CharSequence f15481;

    /* renamed from: ˏ  reason: contains not printable characters */
    protected CharSequence f15482;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private boolean f15483 = true;

    /* renamed from: ͺ  reason: contains not printable characters */
    private Drawable f15484;

    /* renamed from: ॱ  reason: contains not printable characters */
    protected ImageView f15485;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private final Runnable f15486 = new Runnable() { // from class: o.ﺋ.1
        @Override // java.lang.Runnable
        public void run() {
            C1177.this.m16402();
        }
    };

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private Drawable f15487;

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private int f15488 = 0;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private Drawable f15489;

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private CharSequence f15490;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private C0362 f15491;

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private CharSequence f15492;

    /* renamed from: o.ﺋ$ˊ  reason: contains not printable characters */
    public interface AbstractC1178 {
        /* renamed from: ˊ */
        void mo1702(C1177 v);

        /* renamed from: ˊ */
        void mo1703(C1177 v, int i);

        /* renamed from: ˎ */
        void mo1704(float f);

        /* renamed from: ˎ */
        void mo1705(C1177 v, boolean z);
    }

    public C1177(Context context) {
        super(context);
        m16401(null);
    }

    public C1177(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m16401(attributeSet);
    }

    public C1177(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m16401(attributeSet);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m16401(AttributeSet attributeSet) {
        inflate(getContext(), C0602.C0606.user_rating_button, this);
        this.f15485 = (ImageView) findViewById(C0602.IF.user_rating_button_icon);
        this.f15469 = (TextView) findViewById(C0602.IF.user_rating_button_label);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C0602.aux.UserRatingButton);
        this.f15492 = obtainStyledAttributes.getText(C0602.aux.UserRatingButton_urb_thumb_up_label);
        this.f15470 = obtainStyledAttributes.getText(C0602.aux.UserRatingButton_urb_thumb_down_label);
        this.f15490 = obtainStyledAttributes.getText(C0602.aux.UserRatingButton_urb_unrated_label);
        this.f15472 = obtainStyledAttributes.getText(C0602.aux.UserRatingButton_urb_accessibility_thumb_up_description);
        this.f15474 = obtainStyledAttributes.getText(C0602.aux.UserRatingButton_urb_accessibility_thumb_down_description);
        this.f15475 = obtainStyledAttributes.getText(C0602.aux.UserRatingButton_urb_accessibility_unrated_description);
        this.f15477 = obtainStyledAttributes.getText(C0602.aux.UserRatingButton_urb_accessibility_overlay_thumbs_up_button_description);
        this.f15482 = obtainStyledAttributes.getText(C0602.aux.UserRatingButton_urb_accessibility_overlay_thumbs_down_button_description);
        this.f15471 = obtainStyledAttributes.getText(C0602.aux.UserRatingButton_urb_accessibility_overlay_thumbs_close_button_description);
        this.f15481 = obtainStyledAttributes.getText(C0602.aux.UserRatingButton_urb_accessibility_overlay_feedback_video_rated);
        this.f15473 = obtainStyledAttributes.getText(C0602.aux.UserRatingButton_urb_accessibility_overlay_feedback_cancelled_rating);
        this.f15484 = DrawableCompat.wrap(ContextCompat.getDrawable(getContext(), C0602.C0604.ic_thumbs_up).mutate());
        this.f15478 = DrawableCompat.wrap(ContextCompat.getDrawable(getContext(), C0602.C0604.ic_thumbs_down).mutate());
        this.f15487 = DrawableCompat.wrap(ContextCompat.getDrawable(getContext(), C0602.C0604.ic_thumbs_up_outline).mutate());
        ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(C0602.aux.UserRatingButton_urb_text_color);
        if (colorStateList != null) {
            this.f15480 = colorStateList;
        } else {
            this.f15480 = ContextCompat.getColorStateList(getContext(), C0602.Cif.thumb_button_dark_foreground);
        }
        if (obtainStyledAttributes.hasValue(C0602.aux.UserRatingButton_urb_text_size)) {
            this.f15469.setTextSize(0, obtainStyledAttributes.getDimension(C0602.aux.UserRatingButton_urb_text_size, this.f15469.getTextSize()));
        }
        setDark(obtainStyledAttributes.getBoolean(C0602.aux.UserRatingButton_urb_dark, true));
        obtainStyledAttributes.recycle();
        m16399(0);
    }

    public void setRespectLayoutDirection(boolean z) {
        this.f15476 = z;
    }

    public void setDark(boolean z) {
        this.f15483 = z;
        this.f15469.setTextColor(this.f15483 ? this.f15480 : ContextCompat.getColorStateList(getContext(), C0602.Cif.thumb_button_light_foreground));
        setIconColor(ContextCompat.getColor(getContext(), this.f15483 ? C0602.Cif.thumb_button_dark_foreground : C0602.Cif.thumb_button_light_foreground));
    }

    public void setIconColor(int i) {
        ColorStateList valueOf = ColorStateList.valueOf(i);
        DrawableCompat.setTintList(this.f15484, valueOf);
        DrawableCompat.setTintList(this.f15478, valueOf);
        DrawableCompat.setTintList(this.f15487, valueOf);
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        this.f15489 = drawable;
        if (this.f15485 != null) {
            m16402();
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m16392(long j) {
        if (j > 0) {
            removeCallbacks(this.f15486);
            postDelayed(this.f15486, j);
            return;
        }
        m16402();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱ  reason: contains not printable characters */
    private void m16402() {
        if (this.f15488 != 0) {
            this.f15485.setBackground(this.f15489);
        } else {
            this.f15485.setBackground(null);
        }
    }

    public void setRating(int i) {
        m16396(i, 0);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m16396(int i, long j) {
        if (this.f15488 != i) {
            this.f15488 = i;
            m16399(j);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public int m16403() {
        return this.f15488;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m16399(long j) {
        int imageAlpha = this.f15485.getImageAlpha();
        Drawable drawable = null;
        CharSequence charSequence = null;
        CharSequence charSequence2 = null;
        switch (this.f15488) {
            case 0:
                drawable = this.f15487;
                charSequence = this.f15490;
                charSequence2 = this.f15475;
                break;
            case 1:
                drawable = this.f15478;
                charSequence = this.f15470;
                charSequence2 = this.f15474;
                break;
            case 2:
                drawable = this.f15484;
                charSequence = this.f15492;
                charSequence2 = this.f15472;
                break;
        }
        this.f15485.setImageDrawable(drawable);
        this.f15485.setImageAlpha(imageAlpha);
        this.f15469.setText(charSequence);
        setContentDescription(charSequence2);
        m16392(j);
    }

    public void setOnRateListener(final CoordinatorLayout coordinatorLayout, AbstractC1178 r4, boolean z, final int i) {
        if (!isClickable()) {
            setClickable(true);
        }
        this.f15479 = m16404(r4);
        this.f15485.setOnClickListener(new View.OnClickListener() { // from class: o.ﺋ.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                C1177.this.m16400(coordinatorLayout, i, false);
            }
        });
        if (z) {
            this.f15485.setOnLongClickListener(new View.OnLongClickListener() { // from class: o.ﺋ.5
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    C1177.this.m16400(coordinatorLayout, i, true);
                    return true;
                }
            });
            this.f15485.setOnTouchListener(new View.OnTouchListener() { // from class: o.ﺋ.3
                @Override // android.view.View.OnTouchListener
                @SuppressLint({"ClickableViewAccessibility"})
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (C1177.this.f15491 == null || !C1177.this.f15491.m14032()) {
                        return false;
                    }
                    C1177.this.f15491.m14033(motionEvent);
                    return false;
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˎ  reason: contains not printable characters */
    private void m16400(CoordinatorLayout coordinatorLayout, int i, boolean z) {
        if (this.f15488 == 0) {
            m16397(coordinatorLayout, i, z);
        } else {
            m16395();
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m16395() {
        if (this.f15479 != null) {
            this.f15479.mo1703(this, 0);
            m16396(0, 1080);
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m16397(CoordinatorLayout coordinatorLayout, int i, boolean z) {
        if (this.f15479 == null) {
            throw new IllegalStateException("openOverlay called before user set a OnRateListener");
        }
        if (this.f15491 == null) {
            this.f15491 = new C0362(getContext(), this.f15479, this.f15477, this.f15482, this.f15471, this.f15481, this.f15473, this.f15483, this.f15476, getLayoutDirection());
        }
        getParent().requestDisallowInterceptTouchEvent(true);
        this.f15491.m14031(coordinatorLayout, this, i);
        this.f15479.mo1705(this, z);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊ  reason: contains not printable characters */
    public AbstractC1178 m16404(final AbstractC1178 r2) {
        return new AbstractC1178() { // from class: o.ﺋ.2
            @Override // o.C1177.AbstractC1178
            /* renamed from: ˎ */
            public void mo1705(C1177 r22, boolean z) {
                r2.mo1705(r22, z);
            }

            @Override // o.C1177.AbstractC1178
            /* renamed from: ˊ */
            public void mo1703(C1177 r22, int i) {
                r2.mo1703(r22, i);
            }

            @Override // o.C1177.AbstractC1178
            /* renamed from: ˊ */
            public void mo1702(C1177 r3) {
                C1177.this.getParent().requestDisallowInterceptTouchEvent(false);
                r2.mo1702(r3);
            }

            @Override // o.C1177.AbstractC1178
            /* renamed from: ˎ */
            public void mo1704(float f) {
                r2.mo1704(f);
            }
        };
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        throw new UnsupportedOperationException("Don't call to setOnClickListener, instead call setOnRateListener");
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public ImageView m16405() {
        return this.f15485;
    }
}
