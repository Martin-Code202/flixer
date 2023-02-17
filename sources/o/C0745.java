package o;

import android.graphics.Path;
import com.airbnb.lottie.model.content.Mask;
import java.util.ArrayList;
import java.util.List;
/* renamed from: o.ᐧ  reason: contains not printable characters */
public class C0745 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final List<AbstractC1622coN<Integer, Integer>> f14357;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final List<AbstractC1622coN<C0445, Path>> f14358;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final List<Mask> f14359;

    public C0745(List<Mask> list) {
        this.f14359 = list;
        this.f14358 = new ArrayList(list.size());
        this.f14357 = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            this.f14358.add(list.get(i).m22().mo14241());
            this.f14357.add(list.get(i).m21().mo14241());
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public List<Mask> m15160() {
        return this.f14359;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public List<AbstractC1622coN<C0445, Path>> m15159() {
        return this.f14358;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public List<AbstractC1622coN<Integer, Integer>> m15161() {
        return this.f14357;
    }
}
