package o;

import android.annotation.SuppressLint;
import android.net.Uri;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.netflix.mediaclient.service.player.streamingplayback.exosessionplayer.netflixdatasource.NetflixDataSourceUtil;
/* renamed from: o.ls  reason: case insensitive filesystem */
public class C1961ls implements DataSource {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final kw f8650;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final C0147 f8651 = new C0147();

    /* renamed from: ˏ  reason: contains not printable characters */
    private final DataSource f8652;

    C1961ls(kw kwVar, DataSource dataSource) {
        this.f8650 = kwVar;
        this.f8652 = dataSource;
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    @SuppressLint({"WrongConstant"})
    public long open(DataSpec dataSpec) {
        this.f8651.m8756(dataSpec);
        if (this.f8651.m8754().equals(NetflixDataSourceUtil.DataSourceRequestType.Header)) {
            dataSpec = new DataSpec(dataSpec.uri, dataSpec.postBody, dataSpec.absoluteStreamPosition, dataSpec.position, dataSpec.length, dataSpec.key, dataSpec.flags | 65536);
        }
        return m8753(dataSpec);
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public int read(byte[] bArr, int i, int i2) {
        return this.f8652.read(bArr, i, i2);
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public Uri getUri() {
        return this.f8652.getUri();
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void close() {
        this.f8652.close();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private long m8753(DataSpec dataSpec) {
        String r11 = this.f8651.m8755();
        kD r12 = this.f8650.mo8455(r11);
        if (r12 == null) {
            C1283.m16844("NetflixDataSource", "location not available for stream id %s", r11);
        } else if (!r12.m8191().equals(dataSpec.uri.toString())) {
            dataSpec = new DataSpec(Uri.parse(r12.m8191()), dataSpec.postBody, dataSpec.absoluteStreamPosition, dataSpec.position, dataSpec.length, dataSpec.key, dataSpec.flags);
        }
        return this.f8652.open(dataSpec);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.ls$ˊ  reason: contains not printable characters */
    public static class C0147 {

        /* renamed from: ˊ  reason: contains not printable characters */
        private NetflixDataSourceUtil.DataSourceRequestType f8653;

        /* renamed from: ˏ  reason: contains not printable characters */
        private String f8654;

        private C0147() {
            this.f8653 = NetflixDataSourceUtil.DataSourceRequestType.RequestUnknown;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: ˏ  reason: contains not printable characters */
        public void m8756(DataSpec dataSpec) {
            this.f8653 = NetflixDataSourceUtil.m1023(dataSpec);
            this.f8654 = NetflixDataSourceUtil.m1026(dataSpec);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: ˎ  reason: contains not printable characters */
        public String m8755() {
            return this.f8654;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: ˊ  reason: contains not printable characters */
        public NetflixDataSourceUtil.DataSourceRequestType m8754() {
            return this.f8653;
        }
    }
}
