package o;

import android.content.Context;
import android.graphics.Canvas;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.WeakHashMap;
/* renamed from: o.‿  reason: contains not printable characters */
public class C1044 extends FrameLayout {

    /* renamed from: ˊ  reason: contains not printable characters */
    private static final WeakHashMap<Context, Integer> f15159 = new WeakHashMap<>();

    /* renamed from: ˋ  reason: contains not printable characters */
    private int f15160;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final int f15161;

    /* renamed from: ˏ  reason: contains not printable characters */
    private LinkedList<String> f15162;

    /* renamed from: ॱ  reason: contains not printable characters */
    private TextPaint f15163;

    public C1044(Context context) {
        this(context, null, 0);
    }

    public C1044(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public C1044(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f15162 = new LinkedList<>();
        this.f15163 = new TextPaint();
        this.f15160 = 0;
        Integer num = f15159.get(context);
        Integer valueOf = Integer.valueOf((num == null ? 0 : num).intValue() + 1);
        this.f15161 = valueOf.intValue();
        f15159.put(context, valueOf);
        this.f15163.density = context.getResources().getDisplayMetrics().density;
        this.f15163.setColor(-1);
        this.f15163.setStrokeWidth(6.0f);
        this.f15163.setTextSize(30.0f);
        this.f15163.setShadowLayer(this.f15163.density * 4.0f, 0.0f, 0.0f, -16777216);
        setWillNotDraw(false);
        this.f15162.push(this.f15160 + ". created");
        this.f15160++;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo16051() {
        this.f15162.push(this.f15160 + ". onViewAttachedToWindow");
        m16045();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo16052() {
        this.f15162.push(this.f15160 + ". onViewDetachedFromWindow");
        m16045();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void mo16053() {
        this.f15162.addFirst(this.f15160 + ". onViewRecycled");
        m16045();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo16050(int i) {
        this.f15162.addFirst(this.f15160 + ". onBindViewHolder(" + i + ")");
        m16045();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo16049() {
        this.f15162.addFirst(this.f15160 + ". onFailedToRecycleView");
        m16045();
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void mo16047() {
        this.f15162.addFirst(this.f15160 + ". onLayoutCoverView");
        m16045();
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m16048(String str) {
        this.f15162.addFirst(this.f15160 + ". " + str);
        m16045();
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public final String m16054() {
        return mo16046() + " #" + this.f15161;
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    private void m16045() {
        while (this.f15162.size() > 15) {
            this.f15162.removeLast();
        }
        invalidate();
        this.f15160++;
    }

    @Override // android.view.View
    public void onDrawForeground(Canvas canvas) {
        super.onDrawForeground(canvas);
        canvas.drawText(m16054(), 10.0f, 40.0f, this.f15163);
        int i = 40 + 40;
        Iterator<String> it = this.f15162.iterator();
        while (it.hasNext()) {
            canvas.drawText(it.next(), 10.0f, (float) i, this.f15163);
            i += 40;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ʼ  reason: contains not printable characters */
    public String mo16046() {
        return getClass().getSimpleName();
    }
}
