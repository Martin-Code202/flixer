package o;

import android.annotation.TargetApi;
import android.graphics.Path;
import android.os.Build;
import com.airbnb.lottie.model.content.MergePaths;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
@TargetApi(19)
/* renamed from: o.ˈ  reason: contains not printable characters */
public class C0430 implements AUX, AbstractC1372Con {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final Path f13427 = new Path();

    /* renamed from: ˋ  reason: contains not printable characters */
    private final Path f13428 = new Path();

    /* renamed from: ˎ  reason: contains not printable characters */
    private final String f13429;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final Path f13430 = new Path();

    /* renamed from: ॱ  reason: contains not printable characters */
    private final List<AUX> f13431 = new ArrayList();

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final MergePaths f13432;

    public C0430(MergePaths mergePaths) {
        if (Build.VERSION.SDK_INT < 19) {
            throw new IllegalStateException("Merge paths are not supported pre-KitKat.");
        }
        this.f13429 = mergePaths.m26();
        this.f13432 = mergePaths;
    }

    @Override // o.AbstractC1372Con
    /* renamed from: ˎ */
    public void mo4517(ListIterator<AbstractC0420> listIterator) {
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        while (listIterator.hasPrevious()) {
            AbstractC0420 previous = listIterator.previous();
            if (previous instanceof AUX) {
                this.f13431.add((AUX) previous);
                listIterator.remove();
            }
        }
    }

    @Override // o.AbstractC0420
    /* renamed from: ॱ */
    public void mo3790(List<AbstractC0420> list, List<AbstractC0420> list2) {
        for (int i = 0; i < this.f13431.size(); i++) {
            this.f13431.get(i).mo3790(list, list2);
        }
    }

    @Override // o.AUX
    /* renamed from: ˏ */
    public Path mo3438() {
        this.f13427.reset();
        switch (this.f13432.m25()) {
            case Merge:
                m14243();
                break;
            case Add:
                m14244(Path.Op.UNION);
                break;
            case Subtract:
                m14244(Path.Op.REVERSE_DIFFERENCE);
                break;
            case Intersect:
                m14244(Path.Op.INTERSECT);
                break;
            case ExcludeIntersections:
                m14244(Path.Op.XOR);
                break;
        }
        return this.f13427;
    }

    @Override // o.AbstractC0420
    /* renamed from: ˊ */
    public String mo3788() {
        return this.f13429;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m14243() {
        for (int i = 0; i < this.f13431.size(); i++) {
            this.f13427.addPath(this.f13431.get(i).mo3438());
        }
    }

    @TargetApi(19)
    /* renamed from: ॱ  reason: contains not printable characters */
    private void m14244(Path.Op op) {
        this.f13428.reset();
        this.f13430.reset();
        for (int size = this.f13431.size() - 1; size >= 1; size--) {
            AUX aux = this.f13431.get(size);
            if (aux instanceof C1517auX) {
                List<AUX> r5 = ((C1517auX) aux).m5646();
                for (int size2 = r5.size() - 1; size2 >= 0; size2--) {
                    Path r7 = r5.get(size2).mo3438();
                    r7.transform(((C1517auX) aux).m5649());
                    this.f13428.addPath(r7);
                }
            } else {
                this.f13428.addPath(aux.mo3438());
            }
        }
        AUX aux2 = this.f13431.get(0);
        if (aux2 instanceof C1517auX) {
            List<AUX> r4 = ((C1517auX) aux2).m5646();
            for (int i = 0; i < r4.size(); i++) {
                Path r6 = r4.get(i).mo3438();
                r6.transform(((C1517auX) aux2).m5649());
                this.f13430.addPath(r6);
            }
        } else {
            this.f13430.set(aux2.mo3438());
        }
        this.f13427.op(this.f13430, this.f13428, op);
    }
}
