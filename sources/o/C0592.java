package o;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
/* renamed from: o.ٵ  reason: contains not printable characters */
public class C0592 extends TextView {

    /* renamed from: ˎ  reason: contains not printable characters */
    private static final Pattern f13868 = Pattern.compile("[\\.,…;\\:\\s]*$", 32);

    /* renamed from: ʻ  reason: contains not printable characters */
    private int f13869;

    /* renamed from: ʼ  reason: contains not printable characters */
    private float f13870;

    /* renamed from: ʽ  reason: contains not printable characters */
    private float f13871;

    /* renamed from: ˊ  reason: contains not printable characters */
    private boolean f13872;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final List<Cif> f13873;

    /* renamed from: ˏ  reason: contains not printable characters */
    private boolean f13874;

    /* renamed from: ॱ  reason: contains not printable characters */
    private boolean f13875;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private String f13876;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private Pattern f13877;

    /* renamed from: o.ٵ$if  reason: invalid class name */
    public interface Cif {
        /* renamed from: ॱ  reason: contains not printable characters */
        void m14722(boolean z);
    }

    public C0592(Context context) {
        this(context, null);
    }

    public C0592(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public C0592(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f13873 = new ArrayList();
        this.f13870 = 1.0f;
        this.f13871 = 0.0f;
        super.setEllipsize(null);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16843091});
        setMaxLines(obtainStyledAttributes.getInt(0, Integer.MAX_VALUE));
        obtainStyledAttributes.recycle();
        setEndPunctuationPattern(f13868);
    }

    public void setEndPunctuationPattern(Pattern pattern) {
        this.f13877 = pattern;
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i) {
        super.setMaxLines(i);
        this.f13869 = i;
        this.f13872 = true;
    }

    @Override // android.widget.TextView
    @SuppressLint({"Override"})
    public int getMaxLines() {
        return this.f13869;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public boolean m14721() {
        return this.f13869 == Integer.MAX_VALUE;
    }

    @Override // android.widget.TextView
    public void setLineSpacing(float f, float f2) {
        this.f13871 = f;
        this.f13870 = f2;
        super.setLineSpacing(f, f2);
    }

    /* access modifiers changed from: protected */
    @Override // android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        if (!this.f13875) {
            this.f13876 = charSequence.toString();
            this.f13872 = true;
        }
    }

    /* access modifiers changed from: protected */
    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (m14721()) {
            this.f13872 = true;
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
        super.setPadding(i, i2, i3, i4);
        if (m14721()) {
            this.f13872 = true;
        }
    }

    /* access modifiers changed from: protected */
    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.f13872) {
            m14719();
        }
        super.onDraw(canvas);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m14719() {
        int lastIndexOf;
        String str = this.f13876;
        boolean z = false;
        Layout r5 = m14718(str);
        int r6 = m14717();
        if (r5.getLineCount() > r6) {
            String trim = this.f13876.substring(0, r5.getLineEnd(r6 - 1)).trim();
            while (m14718(trim + "…").getLineCount() > r6 && (lastIndexOf = trim.lastIndexOf(32)) != -1) {
                trim = trim.substring(0, lastIndexOf);
            }
            str = this.f13877.matcher(trim).replaceFirst("") + "…";
            z = true;
        }
        if (!str.equals(getText())) {
            this.f13875 = true;
            try {
                setText(str);
            } finally {
                this.f13875 = false;
            }
        }
        this.f13872 = false;
        if (z != this.f13874) {
            this.f13874 = z;
            for (Cif ifVar : this.f13873) {
                ifVar.m14722(z);
            }
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private int m14717() {
        if (!m14721()) {
            return this.f13869;
        }
        int r1 = m14720();
        if (r1 == -1) {
            return 1;
        }
        return r1;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private int m14720() {
        return ((getHeight() - getPaddingTop()) - getPaddingBottom()) / m14718("").getLineBottom(0);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private Layout m14718(String str) {
        return new StaticLayout(str, getPaint(), (getWidth() - getPaddingLeft()) - getPaddingRight(), Layout.Alignment.ALIGN_NORMAL, this.f13870, this.f13871, false);
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
    }
}
