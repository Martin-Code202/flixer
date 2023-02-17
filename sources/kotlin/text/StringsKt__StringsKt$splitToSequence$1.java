package kotlin.text;

import kotlin.jvm.internal.Lambda;
import o.AbstractC1450Fk;
import o.C1457Fr;
import o.FE;
import o.Ge;
public final class StringsKt__StringsKt$splitToSequence$1 extends Lambda implements AbstractC1450Fk<FE, String> {

    /* renamed from: ˋ  reason: contains not printable characters */
    final /* synthetic */ CharSequence f4264;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StringsKt__StringsKt$splitToSequence$1(CharSequence charSequence) {
        super(1);
        this.f4264 = charSequence;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public final String invoke(FE fe) {
        C1457Fr.m5025(fe, "it");
        return Ge.m5079(this.f4264, fe);
    }
}
