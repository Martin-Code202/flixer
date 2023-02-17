package kotlin.text;

import kotlin.Pair;
import kotlin.jvm.internal.Lambda;
import o.AbstractC1451Fl;
import o.C1438Ey;
import o.C1457Fr;
import o.Gq;
public final class StringsKt__StringsKt$rangesDelimitedBy$2 extends Lambda implements AbstractC1451Fl<CharSequence, Integer, Pair<? extends Integer, ? extends Integer>> {

    /* renamed from: ˊ  reason: contains not printable characters */
    final /* synthetic */ char[] f4260;

    /* renamed from: ˎ  reason: contains not printable characters */
    final /* synthetic */ boolean f4261;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StringsKt__StringsKt$rangesDelimitedBy$2(char[] cArr, boolean z) {
        super(2);
        this.f4260 = cArr;
        this.f4261 = z;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // o.AbstractC1451Fl
    public /* synthetic */ Pair<? extends Integer, ? extends Integer> invoke(CharSequence charSequence, Integer num) {
        return m3244(charSequence, num.intValue());
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public final Pair<Integer, Integer> m3244(CharSequence charSequence, int i) {
        C1457Fr.m5025(charSequence, "$receiver");
        Pair pair = Gq.m5088(charSequence, this.f4260, i, this.f4261, false);
        if (pair != null) {
            return C1438Ey.m4973(pair.m3221(), 1);
        }
        return null;
    }
}
