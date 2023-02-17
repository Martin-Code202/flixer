package com.netflix.mediaclient.acquisition.view;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.text.Spannable;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CheckBox;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.acquisition.kotlinx.TextViewKt;
import io.reactivex.Observable;
import java.util.HashMap;
import kotlin.TypeCastException;
import o.AbstractC0744;
import o.C0716;
import o.C1090;
import o.C1456Fq;
import o.C1457Fr;
import o.zN;
public final class TermsOfUseView extends ConstraintLayout {
    private HashMap _$_findViewCache;
    private boolean shouldShowErrorState;

    public TermsOfUseView(Context context) {
        this(context, null, 0, 6, null);
    }

    public TermsOfUseView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public void _$_clearFindViewByIdCache() {
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TermsOfUseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        C1457Fr.m5025(context, "context");
        View.inflate(context, R.layout.terms_of_use_layout, this);
        if (!isInEditMode()) {
            ((C0716) _$_findCachedViewById(R.Cif.touText)).setOnClickListener(new View.OnClickListener(this) { // from class: com.netflix.mediaclient.acquisition.view.TermsOfUseView.1
                final /* synthetic */ TermsOfUseView this$0;

                {
                    this.this$0 = r1;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CheckBox checkBox = (CheckBox) this.this$0._$_findCachedViewById(R.Cif.touCheckbox);
                    C1457Fr.m5016((Object) checkBox, "touCheckbox");
                    CheckBox checkBox2 = (CheckBox) this.this$0._$_findCachedViewById(R.Cif.touCheckbox);
                    C1457Fr.m5016((Object) checkBox2, "touCheckbox");
                    checkBox.setChecked(!checkBox2.isChecked());
                }
            });
            C0716 r0 = (C0716) _$_findCachedViewById(R.Cif.touText);
            C1457Fr.m5016((Object) r0, "touText");
            r0.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TermsOfUseView(Context context, AttributeSet attributeSet, int i, int i2, C1456Fq fq) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final void setText(String str) {
        C1457Fr.m5025(str, "text");
        C0716 r0 = (C0716) _$_findCachedViewById(R.Cif.touText);
        C1457Fr.m5016((Object) r0, "touText");
        C0716 r02 = r0;
        Spanned r1 = zN.f12697.m13520(str);
        if (r1 == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.text.Spannable");
        }
        TextViewKt.setUnderlineStrippedText(r02, (Spannable) r1);
    }

    public final void setCheckboxVisible(boolean z) {
        CheckBox checkBox = (CheckBox) _$_findCachedViewById(R.Cif.touCheckbox);
        C1457Fr.m5016((Object) checkBox, "touCheckbox");
        checkBox.setVisibility(z ? 0 : 8);
    }

    public final boolean isCheckboxVisible() {
        CheckBox checkBox = (CheckBox) _$_findCachedViewById(R.Cif.touCheckbox);
        C1457Fr.m5016((Object) checkBox, "touCheckbox");
        return checkBox.getVisibility() == 0;
    }

    public final boolean hasAcceptedTermsOfUse() {
        CheckBox checkBox = (CheckBox) _$_findCachedViewById(R.Cif.touCheckbox);
        C1457Fr.m5016((Object) checkBox, "touCheckbox");
        return checkBox.isChecked() || !isCheckboxVisible();
    }

    public final void setErrorVisible(boolean z) {
        this.shouldShowErrorState = true;
        C0716 r0 = (C0716) _$_findCachedViewById(R.Cif.touErrorMessage);
        C1457Fr.m5016((Object) r0, "touErrorMessage");
        r0.setVisibility(z ? 0 : 8);
        CheckBox checkBox = (CheckBox) _$_findCachedViewById(R.Cif.touCheckbox);
        C1457Fr.m5016((Object) checkBox, "touCheckbox");
        checkBox.setActivated(z);
    }

    public final Observable<Boolean> checkedChanges() {
        CheckBox checkBox = (CheckBox) _$_findCachedViewById(R.Cif.touCheckbox);
        C1457Fr.m5016((Object) checkBox, "touCheckbox");
        AbstractC0744<Boolean> r0 = C1090.m16182(checkBox);
        C1457Fr.m5016((Object) r0, "RxCompoundButton.checkedChanges(this)");
        Observable<Boolean> doOnNext = r0.skip(1).doOnNext(new TermsOfUseView$checkedChanges$1(this));
        C1457Fr.m5016((Object) doOnNext, "touCheckbox.checkedChang…      }\n                }");
        return doOnNext;
    }
}
