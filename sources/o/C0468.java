package o;

import com.netflix.mediaclient.service.configuration.crypto.CryptoProvider;
import o.AbstractC0472;
/* renamed from: o.ϙ  reason: contains not printable characters */
public class C0468 implements AbstractC0472 {

    /* renamed from: ˋ  reason: contains not printable characters */
    private CryptoProvider f13520;

    public C0468(CryptoProvider cryptoProvider) {
        if (cryptoProvider == null) {
            throw new IllegalArgumentException("Crypto provider can not be null");
        }
        this.f13520 = cryptoProvider;
    }

    @Override // o.AbstractC0472
    /* renamed from: ˎ  reason: contains not printable characters */
    public CryptoProvider mo14358() {
        return this.f13520;
    }

    @Override // o.AbstractC0472
    /* renamed from: ˊ  reason: contains not printable characters */
    public void mo14355() {
    }

    @Override // o.AbstractC0472
    /* renamed from: ˏ  reason: contains not printable characters */
    public byte[] mo14362(AbstractC0472.C0474 r3, AbstractC0472.Cif ifVar, byte[] bArr) {
        throw new IllegalStateException("CachedCryptoManager, sign should not be called yet!");
    }

    @Override // o.AbstractC0472
    /* renamed from: ॱ  reason: contains not printable characters */
    public boolean mo14363(AbstractC0472.C0474 r3, AbstractC0472.Cif ifVar, byte[] bArr, byte[] bArr2) {
        throw new IllegalStateException("CachedCryptoManager, verify should not be called yet!");
    }

    @Override // o.AbstractC0472
    /* renamed from: ˎ  reason: contains not printable characters */
    public byte[] mo14361(AbstractC0472.C0474 r3, AbstractC0472.Cif ifVar, byte[] bArr, byte[] bArr2) {
        throw new IllegalStateException("CachedCryptoManager, decrypt should not be called yet!");
    }

    @Override // o.AbstractC0472
    /* renamed from: ˊ  reason: contains not printable characters */
    public byte[] mo14357(AbstractC0472.C0474 r3, AbstractC0472.Cif ifVar, byte[] bArr, byte[] bArr2) {
        throw new IllegalStateException("CachedCryptoManager, decrypt should not be called yet!");
    }

    @Override // o.AbstractC0472
    /* renamed from: ʻ  reason: contains not printable characters */
    public DF mo14354() {
        throw new IllegalStateException("CachedCryptoManager, getKeyRequestData should not be called yet!");
    }

    @Override // o.AbstractC0472
    /* renamed from: ˎ  reason: contains not printable characters */
    public AbstractC0472.C0474 mo14359(DF df, byte[] bArr, AbstractC0472.Cif ifVar, AbstractC0472.Cif ifVar2) {
        throw new IllegalStateException("CachedCryptoManager, updateKeyResponse should not be called yet!");
    }

    @Override // o.AbstractC0472
    /* renamed from: ˎ  reason: contains not printable characters */
    public AbstractC0472.C0474 mo14360(AbstractC0472.Cif ifVar) {
        AbstractC0472.C0474 r0 = new AbstractC0472.C0474();
        r0.f13524 = ifVar;
        return r0;
    }

    @Override // o.AbstractC0472
    /* renamed from: ˊ  reason: contains not printable characters */
    public void mo14356(AbstractC0472.C0474 r3) {
        throw new IllegalStateException("CachedCryptoManager, releaseCryptoSession should not be called yet!");
    }
}
