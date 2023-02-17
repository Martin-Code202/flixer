package o;

import com.netflix.mediaclient.service.offline.registry.MetaRegistry;
import com.netflix.mediaclient.service.offline.registry.RegistryData;
import java.io.File;
public class hZ implements pZ {

    /* renamed from: ˋ  reason: contains not printable characters */
    public final C1876ic f7186;

    /* renamed from: ˎ  reason: contains not printable characters */
    public final RegistryData f7187;

    /* renamed from: ˏ  reason: contains not printable characters */
    private long f7188 = 0;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final MetaRegistry f7189;

    /* renamed from: ˋ  reason: contains not printable characters */
    public File m7009() {
        return this.f7186.m7664();
    }

    @Override // o.pZ
    /* renamed from: ˊ  reason: contains not printable characters */
    public boolean mo7008() {
        return this.f7186.m7660();
    }

    @Override // o.pZ
    /* renamed from: ˎ  reason: contains not printable characters */
    public long mo7011() {
        return this.f7186.m7663();
    }

    @Override // o.pZ
    /* renamed from: ॱ  reason: contains not printable characters */
    public long mo7013() {
        return this.f7186.m7661();
    }

    @Override // o.pZ
    /* renamed from: ˏ  reason: contains not printable characters */
    public long mo7012() {
        return this.f7186.m7659();
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public int m7006() {
        return this.f7187.mRegId;
    }

    @Override // o.pZ
    /* renamed from: ॱॱ  reason: contains not printable characters */
    public boolean mo7014() {
        return this.f7189.isCurrentlySelected(this.f7187);
    }

    public hZ(MetaRegistry metaRegistry, RegistryData registryData, C1876ic icVar) {
        this.f7187 = registryData;
        this.f7186 = icVar;
        this.f7189 = metaRegistry;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m7007(long j) {
        this.f7188 = j;
    }

    @Override // o.pZ
    /* renamed from: ʻ  reason: contains not printable characters */
    public long mo7005() {
        return this.f7188;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m7010(long j) {
        this.f7188 += j;
    }
}
