package com.netflix.mediaclient.acquisition.kotlinx;

import android.text.Spannable;
import android.text.style.URLSpan;
import android.widget.TextView;
import com.netflix.mediaclient.acquisition.uihelpers.URLSpanNoUnderline;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.concurrent.TimeUnit;
import o.AbstractC0744;
import o.C0965;
import o.C1043;
import o.C1457Fr;
import o.Ge;
public final class TextViewKt {
    public static final long DEFAULT_CHANGE_DEBOUNCE_MILLIS = 300;

    public static /* synthetic */ Observable textChangesSignUpFormValidation$default(TextView textView, Consumer consumer, boolean z, Consumer consumer2, Function function, int i, Object obj) {
        if ((i & 4) != 0) {
            consumer2 = TextViewKt$textChangesSignUpFormValidation$1.INSTANCE;
        }
        return textChangesSignUpFormValidation(textView, consumer, z, consumer2, function);
    }

    public static final Observable<Boolean> textChangesSignUpFormValidation(TextView textView, Consumer<? super CharSequence> consumer, boolean z, Consumer<? super CharSequence> consumer2, Function<? super CharSequence, Boolean> function) {
        C1457Fr.m5025(textView, "$receiver");
        C1457Fr.m5025(consumer, "onImmediateTextChange");
        C1457Fr.m5025(consumer2, "onDebounceTextChange");
        C1457Fr.m5025(function, "isValidMap");
        AbstractC0744<CharSequence> r0 = C1043.m16044(textView);
        C1457Fr.m5016((Object) r0, "RxTextView.textChanges(this)");
        Observable<CharSequence> doOnNext = r0.filter(new TextViewKt$textChangesSignUpFormValidation$2()).doOnNext(consumer);
        C1457Fr.m5016((Object) doOnNext, "this.textChanges()\n     …xt(onImmediateTextChange)");
        Observable<Boolean> takeUntil = optionalDebounce(doOnNext, 300, TimeUnit.MILLISECONDS, z).observeOn(AndroidSchedulers.mainThread()).doOnNext(consumer2).map(function).distinctUntilChanged().takeUntil(C0965.m15784(textView));
        C1457Fr.m5016((Object) takeUntil, "this.textChanges()\n     …il(RxView.detaches(this))");
        return takeUntil;
    }

    public static final <T> Observable<T> optionalDebounce(Observable<T> observable, long j, TimeUnit timeUnit, boolean z) {
        C1457Fr.m5025(observable, "$receiver");
        C1457Fr.m5025(timeUnit, "unit");
        if (!z) {
            return observable;
        }
        Observable<T> debounce = observable.debounce(j, timeUnit);
        C1457Fr.m5016((Object) debounce, "debounce(timeout, unit)");
        return debounce;
    }

    public static final void setTextOrGone(TextView textView, String str) {
        C1457Fr.m5025(textView, "$receiver");
        textView.setText(str);
        CharSequence text = textView.getText();
        if (text == null || Ge.m5063(text)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }

    public static final void setUnderlineStrippedText(TextView textView, Spannable spannable) {
        C1457Fr.m5025(textView, "$receiver");
        C1457Fr.m5025(spannable, "link");
        URLSpan[] uRLSpanArr = (URLSpan[]) spannable.getSpans(0, spannable.length(), URLSpan.class);
        for (URLSpan uRLSpan : uRLSpanArr) {
            int spanStart = spannable.getSpanStart(uRLSpan);
            int spanEnd = spannable.getSpanEnd(uRLSpan);
            spannable.removeSpan(uRLSpan);
            C1457Fr.m5016((Object) uRLSpan, "span");
            String url = uRLSpan.getURL();
            C1457Fr.m5016((Object) url, "span.url");
            spannable.setSpan(new URLSpanNoUnderline(url), spanStart, spanEnd, 0);
        }
        textView.setText(spannable);
    }
}
