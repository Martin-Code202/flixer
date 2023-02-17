package o;

import com.google.android.exoplayer2.upstream.DataSource;
/* renamed from: o.lr  reason: case insensitive filesystem */
public class C1960lr implements DataSource.Factory {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final C1942km f8645;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final AbstractC1966ly f8646;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final kw f8647;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final C1962lu f8648;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final C1940kk f8649;

    public C1960lr(AbstractC1966ly lyVar, kw kwVar, C1940kk kkVar, C1962lu luVar, C1942km kmVar) {
        this.f8646 = lyVar;
        this.f8647 = kwVar;
        this.f8649 = kkVar;
        this.f8648 = luVar;
        this.f8645 = kmVar;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource.Factory
    public DataSource createDataSource() {
        return new C1961ls(this.f8647, m8752());
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private DataSource m8752() {
        return this.f8648.m8760(this.f8646, this.f8649, this.f8647, this.f8645);
    }
}
