package o;

import java.util.ArrayList;
import java.util.List;
public class oZ implements pY {

    /* renamed from: ˋ  reason: contains not printable characters */
    private final List<pZ> f9241 = new ArrayList();

    @Override // o.pY
    /* renamed from: ॱ  reason: contains not printable characters */
    public int mo9597() {
        int i = -1;
        for (pZ pZVar : this.f9241) {
            i++;
            if (pZVar.mo7014()) {
                break;
            }
        }
        return i;
    }

    @Override // o.pY
    /* renamed from: ॱ  reason: contains not printable characters */
    public boolean mo9598(int i) {
        if (i < 0 || i >= mo4074()) {
            return false;
        }
        return mo4075(i).mo7008();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m9596(List<? extends pZ> list) {
        this.f9241.clear();
        this.f9241.addAll(list);
    }

    @Override // o.AbstractC1345Br
    /* renamed from: ˋ */
    public int mo4074() {
        return this.f9241.size();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public pZ mo4075(int i) {
        return this.f9241.get(i);
    }
}
