package kotlin.text;

import java.util.Collection;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.Lambda;
import o.AbstractC1451Fl;
import o.C1438Ey;
import o.C1457Fr;
import o.Gq;
public final class StringsKt__StringsKt$rangesDelimitedBy$4 extends Lambda implements AbstractC1451Fl<CharSequence, Integer, Pair<? extends Integer, ? extends Integer>> {

    /* renamed from: ˊ  reason: contains not printable characters */
    final /* synthetic */ boolean f4262;

    /* renamed from: ˏ  reason: contains not printable characters */
    final /* synthetic */ List f4263;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StringsKt__StringsKt$rangesDelimitedBy$4(List list, boolean z) {
        super(2);
        this.f4263 = list;
        this.f4262 = z;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // o.AbstractC1451Fl
    public /* synthetic */ Pair<? extends Integer, ? extends Integer> invoke(CharSequence charSequence, Integer num) {
        return m3245(charSequence, num.intValue());
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public final Pair<Integer, Integer> m3245(CharSequence charSequence, int i) {
        C1457Fr.m5025(charSequence, "$receiver");
        Pair pair = Gq.m5080(charSequence, (Collection<String>) this.f4263, i, this.f4262, false);
        if (pair != null) {
            return C1438Ey.m4973(pair.m3221(), Integer.valueOf(((String) pair.m3223()).length()));
        }
        return null;
    }
}
