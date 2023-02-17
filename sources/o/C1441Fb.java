package o;
/* renamed from: o.Fb  reason: case insensitive filesystem */
public class C1441Fb extends C1444Fe {
    @Override // o.C1444Fe
    /* renamed from: ˋ  reason: contains not printable characters */
    public void mo4999(Throwable th, Throwable th2) {
        C1457Fr.m5025(th, "cause");
        C1457Fr.m5025(th2, "exception");
        th.addSuppressed(th2);
    }
}
