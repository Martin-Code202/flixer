package o;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.os.ParcelableCompat;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;
import android.support.v4.view.AbsSavedState;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.netflix.android.widgetry.widget.TrackedRecyclerView;
/* renamed from: o.ᓴ  reason: contains not printable characters */
public class C0843 extends TrackedRecyclerView {

    /* renamed from: ʼ  reason: contains not printable characters */
    private Drawable f14673;

    /* renamed from: ʽ  reason: contains not printable characters */
    private int f14674;

    /* renamed from: ˊ  reason: contains not printable characters */
    private float f14675;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final PointF f14676;

    /* renamed from: ˎ  reason: contains not printable characters */
    private boolean f14677;

    /* renamed from: ˏ  reason: contains not printable characters */
    private boolean f14678;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final int f14679;

    public C0843(Context context) {
        this(context, null);
    }

    public C0843(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public C0843(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f14675 = 0.8f;
        this.f14676 = new PointF();
        this.f14677 = false;
        this.f14678 = false;
        this.f14673 = null;
        this.f14674 = 0;
        this.f14679 = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        setWillNotDraw(false);
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.android.widgetry.widget.TrackedRecyclerView
    /* renamed from: ˎ */
    public String mo110() {
        return "LolomoRecyclerView";
    }

    public void setLolomoAdapter(AbstractC0835 r1) {
        super.setAdapter(r1);
    }

    @Override // android.support.v7.widget.RecyclerView
    public void onScrolled(int i, int i2) {
        if (i2 != 0) {
            this.f14674 += i2;
            if (this.f14673 != null) {
                invalidate();
            }
        }
    }

    @Override // android.support.v7.widget.RecyclerView, android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (!this.f14677 && this.f14678) {
            super.requestDisallowInterceptTouchEvent(z);
        }
    }

    public void setScrollableBackground(Drawable drawable) {
        this.f14673 = drawable;
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f14676.x = motionEvent.getX();
            this.f14676.y = motionEvent.getY();
            this.f14677 = false;
            this.f14678 = false;
        } else if (motionEvent.getAction() == 2 && !this.f14678 && !this.f14677) {
            float abs = Math.abs(this.f14676.y - motionEvent.getY());
            float abs2 = Math.abs(this.f14676.x - motionEvent.getX());
            this.f14677 = abs > ((float) this.f14679);
            this.f14678 = abs2 > ((float) this.f14679) && abs2 > abs;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.support.v7.widget.RecyclerView, android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
    }

    @Override // android.support.v7.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return !m15499(motionEvent) && super.onInterceptTouchEvent(motionEvent);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private boolean m15499(MotionEvent motionEvent) {
        return motionEvent.getAction() == 2 && this.f14678;
    }

    @Override // android.support.v7.widget.RecyclerView
    @Deprecated
    public void setAdapter(RecyclerView.Adapter adapter) {
        setLolomoAdapter((AbstractC0835) adapter);
    }

    public void setFlingSpeedScale(float f) {
        this.f14675 = f;
    }

    @Override // android.support.v7.widget.RecyclerView
    public boolean fling(int i, int i2) {
        return super.fling(i, (int) (((float) i2) * this.f14675));
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v7.widget.RecyclerView, android.view.View
    public Parcelable onSaveInstanceState() {
        iF iFVar = new iF(super.onSaveInstanceState());
        if (getAdapter() instanceof AbstractC0835) {
            iFVar.f14680 = ((AbstractC0835) getAdapter()).m15463(this);
        } else {
            iFVar.f14680 = null;
        }
        return iFVar;
    }

    @Override // android.support.v7.widget.RecyclerView, android.view.View
    public void draw(Canvas canvas) {
        if (this.f14673 != null) {
            canvas.save();
            canvas.translate(0.0f, (float) (this.f14674 * -1));
            this.f14673.draw(canvas);
            canvas.restore();
        }
        super.draw(canvas);
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v7.widget.RecyclerView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof iF)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        super.onRestoreInstanceState(((iF) parcelable).getSuperState());
        if (getAdapter() instanceof AbstractC0835) {
            ((AbstractC0835) getAdapter()).m15456(((iF) parcelable).f14680);
        }
    }

    /* renamed from: o.ᓴ$iF */
    public static class iF extends AbsSavedState {
        public static final Parcelable.Creator<iF> CREATOR = ParcelableCompat.newCreator(new ParcelableCompatCreatorCallbacks<iF>() { // from class: o.ᓴ.iF.3
            /* renamed from: ˏ  reason: contains not printable characters */
            public iF createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new iF(parcel, classLoader);
            }

            /* renamed from: ˎ  reason: contains not printable characters */
            public iF[] newArray(int i) {
                return new iF[i];
            }
        });

        /* renamed from: ˊ  reason: contains not printable characters */
        Parcelable f14680;

        iF(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f14680 = parcel.readParcelable(classLoader != null ? classLoader : RecyclerView.LayoutManager.class.getClassLoader());
        }

        iF(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.support.v4.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeParcelable(this.f14680, 0);
        }
    }
}
