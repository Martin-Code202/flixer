package o;

import com.netflix.mediaclient.service.mdx.protocol.target.SessionMdxTarget;
import java.util.ArrayList;
import java.util.Iterator;
/* renamed from: o.fl  reason: case insensitive filesystem */
public abstract class AbstractC1779fl {

    /* renamed from: ˏ  reason: contains not printable characters */
    protected final ArrayList<AbstractC1823gi> f6762 = new ArrayList<>();

    /* renamed from: ˊ */
    public abstract AbstractC1823gi mo741(String str);

    /* renamed from: ˎ  reason: contains not printable characters */
    public AbstractC1823gi[] m6409() {
        AbstractC1823gi[] giVarArr;
        synchronized (this.f6762) {
            giVarArr = (AbstractC1823gi[]) this.f6762.toArray(new AbstractC1823gi[0]);
        }
        return giVarArr;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ  reason: contains not printable characters */
    public SessionMdxTarget m6410(String str) {
        AbstractC1823gi r1 = mo741(str);
        if (r1 != null) {
            return r1.mo791();
        }
        return null;
    }

    /* renamed from: ʽ */
    public void mo740() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: ʼ  reason: contains not printable characters */
    public void m6407() {
        synchronized (this.f6762) {
            Iterator<AbstractC1823gi> it = this.f6762.iterator();
            while (it.hasNext()) {
                SessionMdxTarget r8 = it.next().mo791();
                if (r8 != null) {
                    C1283.m16863("MdxController", "clearAndReset, %s %s", r8.m6671(), r8.m6669());
                    r8.m773();
                }
            }
            this.f6762.clear();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public void m6408(String str) {
        synchronized (this.f6762) {
            Iterator<AbstractC1823gi> it = this.f6762.iterator();
            while (it.hasNext()) {
                AbstractC1823gi next = it.next();
                if (next.mo6670(str)) {
                    C1283.m16863("MdxController", "resetAllDeviceStateExcept, except %s %s", next.m6671(), next.m6669());
                } else {
                    SessionMdxTarget r8 = next.mo791();
                    if (r8 != null) {
                        C1283.m16863("MdxController", "resetAllDeviceState, %s %s", r8.m6671(), r8.m6669());
                        r8.m773();
                    }
                }
            }
        }
    }
}
