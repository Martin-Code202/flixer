package o;
/* renamed from: o.kd  reason: case insensitive filesystem */
public interface AbstractC1933kd extends AbstractC1894iv {
    /* renamed from: ˋ */
    void mo7496(String str);

    @Deprecated
    /* renamed from: ˎ */
    void mo7498(int i);

    /* renamed from: ˏ */
    void mo7502(long j, iF iFVar);

    /* renamed from: ˏ */
    void mo7503(AbstractC0542 v);

    /* renamed from: o.kd$iF */
    public static class iF {

        /* renamed from: ˋ  reason: contains not printable characters */
        public final long f8379;

        /* renamed from: ˎ  reason: contains not printable characters */
        public final String f8380;

        public iF(String str, long j) {
            this.f8380 = str;
            this.f8379 = j;
        }

        public String toString() {
            return "Format{id='" + this.f8380 + "', bitrateInBps=" + this.f8379 + '}';
        }
    }
}
