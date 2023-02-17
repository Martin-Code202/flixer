package o;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.util.gfx.ImageLoader;
/* renamed from: o.ҷ  reason: contains not printable characters */
public class C0522 extends AbstractC1188 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private Drawable f13657;

    /* renamed from: ˋ  reason: contains not printable characters */
    private int f13658 = R.drawable.selectable_item_foreground;

    /* renamed from: ˏ  reason: contains not printable characters */
    private boolean f13659;

    public C0522(Context context) {
        super(context);
        m14541(null);
    }

    public C0522(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m14541(attributeSet);
    }

    public C0522(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m14541(attributeSet);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m14541(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.C0006.AdvancedImageView);
        Drawable drawable = obtainStyledAttributes.getDrawable(0);
        if (drawable != null) {
            setForeground(drawable);
        } else {
            setForeground(getResources().getDrawable(this.f13658));
        }
        this.f13659 = obtainStyledAttributes.getBoolean(1, false);
        obtainStyledAttributes.recycle();
    }

    @Override // o.AbstractC1188
    public void setImageLoaderInfo(C0638 r2) {
        setTag(R.id.image_loader_info_tag, r2);
    }

    @Override // o.AbstractC1188
    /* renamed from: ˏ  reason: contains not printable characters */
    public C0638 mo14544() {
        return (C0638) getTag(R.id.image_loader_info_tag);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m14542() {
        ImageLoader imageLoader = NetflixActivity.getImageLoader(getContext());
        C0638 r3 = mo14544();
        if (imageLoader != null && r3 != null) {
            imageLoader.mo3056(this, r3.f13960);
        }
    }

    public void setForegroundResource(int i) {
        setForeground(getContext().getResources().getDrawable(i));
    }

    @Override // android.view.View
    public void setForeground(Drawable drawable) {
        if (this.f13657 != drawable) {
            if (this.f13657 != null) {
                this.f13657.setCallback(null);
                unscheduleDrawable(this.f13657);
            }
            this.f13657 = drawable;
            if (drawable != null) {
                drawable.setCallback(this);
                if (drawable.isStateful()) {
                    drawable.setState(getDrawableState());
                }
            }
            requestLayout();
            invalidate();
        }
    }

    /* access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f13657;
    }

    @Override // android.widget.ImageView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if (this.f13657 != null) {
            this.f13657.jumpToCurrentState();
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC1188, android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f13657 != null && this.f13657.isStateful()) {
            this.f13657.setState(getDrawableState());
        }
    }

    /* access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f13659) {
            setMeasuredDimension(getMeasuredWidth(), getMeasuredWidth());
        }
        if (this.f13657 != null) {
            this.f13657.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            invalidate();
        }
    }

    /* access modifiers changed from: protected */
    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.f13657 != null) {
            this.f13657.setBounds(0, 0, i, i2);
            invalidate();
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f13657 != null) {
            this.f13657.draw(canvas);
        }
    }

    @Override // android.view.View
    @TargetApi(21)
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if ((C1317As.m3758() >= 21) && (this.f13657 != null)) {
            this.f13657.setHotspot(motionEvent.getX(), motionEvent.getY());
        }
        return super.onTouchEvent(motionEvent);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public boolean m14545() {
        return mo14544() != null && mo14544().f13957;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo14543() {
        ImageLoader imageLoader = NetflixActivity.getImageLoader(getContext());
        if (imageLoader != null) {
            imageLoader.mo3062(this);
        }
        BQ.m3913(this);
    }
}
