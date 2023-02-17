package com.google.android.gms.cast.framework.internal.featurehighlight;

import android.content.Context;
import android.support.annotation.Keep;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.R;
import com.google.android.gms.internal.zzdfm;
@Keep
public class HelpTextView extends LinearLayout {
    private TextView zzerh;
    private TextView zzeri;

    @Keep
    public HelpTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private static void zza(TextView textView, CharSequence charSequence) {
        textView.setText(charSequence);
        textView.setVisibility(TextUtils.isEmpty(charSequence) ? 8 : 0);
    }

    @Keep
    public View asView() {
        return this;
    }

    /* access modifiers changed from: protected */
    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.zzerh = (TextView) zzdfm.zzu((TextView) findViewById(R.id.cast_featurehighlight_help_text_header_view));
        this.zzeri = (TextView) zzdfm.zzu((TextView) findViewById(R.id.cast_featurehighlight_help_text_body_view));
    }

    @Keep
    public void setText(CharSequence charSequence, CharSequence charSequence2) {
        zza(this.zzerh, charSequence);
        zza(this.zzeri, charSequence2);
    }
}
