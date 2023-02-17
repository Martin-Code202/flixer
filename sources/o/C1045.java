package o;

import android.content.Context;
import android.util.AttributeSet;
/* renamed from: o.⁀  reason: contains not printable characters */
public class C1045 extends C1044 {
    public C1045(Context context) {
        this(context, null, 0);
    }

    public C1045(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public C1045(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // o.C1044
    /* renamed from: ˎ */
    public void mo16051() {
        m16048(". onViewAttachedToWindow");
    }

    @Override // o.C1044
    /* renamed from: ˏ */
    public void mo16052() {
        m16048(". onViewDetachedFromWindow");
    }

    @Override // o.C1044
    /* renamed from: ॱ */
    public void mo16053() {
        m16048(". onViewRecycled");
    }

    @Override // o.C1044
    /* renamed from: ˋ */
    public void mo16050(int i) {
        m16048(". onBindViewHolder(" + i + ")");
    }

    @Override // o.C1044
    /* renamed from: ˋ */
    public void mo16049() {
        m16048(". onFailedToRecycleView");
    }

    @Override // o.C1044
    /* renamed from: ˊ */
    public void mo16047() {
        m16048(". onLayoutCoverView");
    }

    /* access modifiers changed from: protected */
    @Override // o.C1044
    /* renamed from: ʼ */
    public String mo16046() {
        return "ViewHolder";
    }
}
