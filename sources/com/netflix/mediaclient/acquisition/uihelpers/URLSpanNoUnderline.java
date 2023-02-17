package com.netflix.mediaclient.acquisition.uihelpers;

import android.text.TextPaint;
import android.text.style.URLSpan;
import o.C1457Fr;
public class URLSpanNoUnderline extends URLSpan {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public URLSpanNoUnderline(String str) {
        super(str);
        C1457Fr.m5025(str, "url");
    }

    @Override // android.text.style.CharacterStyle, android.text.style.ClickableSpan
    public void updateDrawState(TextPaint textPaint) {
        C1457Fr.m5025(textPaint, "ds");
        super.updateDrawState(textPaint);
        textPaint.setUnderlineText(false);
    }
}
