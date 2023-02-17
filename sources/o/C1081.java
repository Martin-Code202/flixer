package o;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.SeekBar;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.ui.player.PlayerFragment;
import o.yD;
/* renamed from: o.イ  reason: contains not printable characters */
public class C1081 extends C0751 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private SeekBar.OnSeekBarChangeListener f15256;

    public C1081(Context context) {
        super(context);
    }

    public C1081(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public C1081(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.view.View
    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        return onTrackballEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTrackballEvent(MotionEvent motionEvent) {
        return true;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m16171(boolean z) {
        if (Build.VERSION.SDK_INT >= 16) {
            getThumb().setAlpha(z ? 0 : 255);
        } else {
            setThumb(z ? getResources().getDrawable(R.color.transparent) : getResources().getDrawable(R.drawable.player_seekbar_handle));
        }
    }

    @Override // android.widget.SeekBar
    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.f15256 = onSeekBarChangeListener;
        super.setOnSeekBarChangeListener(onSeekBarChangeListener);
    }

    @Override // android.widget.AbsSeekBar, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return false;
        }
        int r1 = m16170(motionEvent);
        if ((this.f15256 instanceof PlayerFragment.C0040) && ((PlayerFragment.C0040) this.f15256).m2543(this, motionEvent, r1)) {
            return true;
        }
        if (!(this.f15256 instanceof yD.C0298) || !((yD.C0298) this.f15256).m13121(this, motionEvent, r1)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private int m16170(MotionEvent motionEvent) {
        float f;
        int width = getWidth();
        int paddingLeft = (width - getPaddingLeft()) - getPaddingRight();
        int x = (int) motionEvent.getX();
        if (x < getPaddingLeft()) {
            f = 0.0f;
        } else if (x > width - getPaddingRight()) {
            f = 1.0f;
        } else {
            f = ((float) (x - getPaddingLeft())) / ((float) paddingLeft);
        }
        return (int) (0.0f + (((float) getMax()) * f));
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public float m16172(long j) {
        return ((float) (((long) ((getWidth() - getPaddingLeft()) - getPaddingRight())) * j)) / ((float) getMax());
    }
}
