package o;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;
import com.netflix.mediaclient.servicemgr.interface_.IconFontGlyph;
/* renamed from: o.ۊ  reason: contains not printable characters */
public class C0628 extends TextView {

    /* renamed from: ˎ  reason: contains not printable characters */
    private static Typeface f13939;

    public C0628(Context context) {
        super(context);
        m14757();
    }

    public C0628(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m14757();
    }

    public C0628(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m14757();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m14757() {
        if (f13939 == null) {
            f13939 = Typeface.createFromAsset(getContext().getAssets(), "nf-icon.otf");
        }
        setTypeface(f13939);
    }

    public void setToIcon(IconFontGlyph iconFontGlyph, int i) {
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(i);
        setText(String.valueOf(iconFontGlyph.m1571()));
        setTextSize((float) dimensionPixelOffset);
    }
}
