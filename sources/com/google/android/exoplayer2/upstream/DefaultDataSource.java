package com.google.android.exoplayer2.upstream;

import android.content.Context;
import android.net.Uri;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import java.lang.reflect.InvocationTargetException;
public final class DefaultDataSource implements DataSource {
    private DataSource assetDataSource;
    private final DataSource baseDataSource;
    private DataSource contentDataSource;
    private final Context context;
    private DataSource dataSource;
    private DataSource fileDataSource;
    private final TransferListener<? super DataSource> listener;
    private DataSource rtmpDataSource;

    public DefaultDataSource(Context context2, TransferListener<? super DataSource> transferListener, DataSource dataSource2) {
        this.context = context2.getApplicationContext();
        this.listener = transferListener;
        this.baseDataSource = (DataSource) Assertions.checkNotNull(dataSource2);
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public long open(DataSpec dataSpec) {
        Assertions.checkState(this.dataSource == null);
        String scheme = dataSpec.uri.getScheme();
        if (Util.isLocalFileUri(dataSpec.uri)) {
            if (dataSpec.uri.getPath().startsWith("/android_asset/")) {
                this.dataSource = getAssetDataSource();
            } else {
                this.dataSource = getFileDataSource();
            }
        } else if ("asset".equals(scheme)) {
            this.dataSource = getAssetDataSource();
        } else if ("content".equals(scheme)) {
            this.dataSource = getContentDataSource();
        } else if ("rtmp".equals(scheme)) {
            this.dataSource = getRtmpDataSource();
        } else {
            this.dataSource = this.baseDataSource;
        }
        return this.dataSource.open(dataSpec);
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public int read(byte[] bArr, int i, int i2) {
        return this.dataSource.read(bArr, i, i2);
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public Uri getUri() {
        if (this.dataSource == null) {
            return null;
        }
        return this.dataSource.getUri();
    }

    @Override // com.google.android.exoplayer2.upstream.DataSource
    public void close() {
        if (this.dataSource != null) {
            try {
                this.dataSource.close();
            } finally {
                this.dataSource = null;
            }
        }
    }

    private DataSource getFileDataSource() {
        if (this.fileDataSource == null) {
            this.fileDataSource = new FileDataSource(this.listener);
        }
        return this.fileDataSource;
    }

    private DataSource getAssetDataSource() {
        if (this.assetDataSource == null) {
            this.assetDataSource = new AssetDataSource(this.context, this.listener);
        }
        return this.assetDataSource;
    }

    private DataSource getContentDataSource() {
        if (this.contentDataSource == null) {
            this.contentDataSource = new ContentDataSource(this.context, this.listener);
        }
        return this.contentDataSource;
    }

    private DataSource getRtmpDataSource() {
        if (this.rtmpDataSource == null) {
            try {
                this.rtmpDataSource = (DataSource) Class.forName("com.google.android.exoplayer2.ext.rtmp.RtmpDataSource").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (ClassNotFoundException e) {
                Log.w("DefaultDataSource", "Attempting to play RTMP stream without depending on the RTMP extension");
            } catch (InstantiationException e2) {
                Log.e("DefaultDataSource", "Error instantiating RtmpDataSource", e2);
            } catch (IllegalAccessException e3) {
                Log.e("DefaultDataSource", "Error instantiating RtmpDataSource", e3);
            } catch (NoSuchMethodException e4) {
                Log.e("DefaultDataSource", "Error instantiating RtmpDataSource", e4);
            } catch (InvocationTargetException e5) {
                Log.e("DefaultDataSource", "Error instantiating RtmpDataSource", e5);
            }
            if (this.rtmpDataSource == null) {
                this.rtmpDataSource = this.baseDataSource;
            }
        }
        return this.rtmpDataSource;
    }
}
