package o;

import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import android.view.Surface;
import android.view.TextureView;
import com.netflix.mediaclient.api.res.AssetType;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import o.qJ;
public class uG extends qJ {
    public uG(TextureView textureView, boolean z, int i, float f, AssetType assetType, qJ.iF iFVar) {
        super(textureView, z, i, f, assetType, iFVar);
    }

    @Override // o.qJ, android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        this.f9481 = new Surface(surfaceTexture);
        this.f9469 = true;
        if (!TextUtils.isEmpty(this.f9478)) {
            float f = 0.0f;
            float f2 = 0.0f;
            try {
                FileInputStream fileInputStream = new FileInputStream(new File(this.f9478));
                FileDescriptor fd = fileInputStream.getFD();
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(fd, this.f9471, this.f9484);
                f = Float.parseFloat(mediaMetadataRetriever.extractMetadata(19));
                f2 = Float.parseFloat(mediaMetadataRetriever.extractMetadata(18));
                fileInputStream.close();
            } catch (IOException | IllegalStateException e) {
                C1276.m16820().mo5727("SPY-9199 Failed to retrieve MediaMetadata");
                e.printStackTrace();
            }
            float f3 = 1.0f;
            if (i > i2) {
                f3 = (((float) i) / f2) / (((float) i2) / f);
            }
            Matrix matrix = new Matrix();
            matrix.setScale(1.0f, f3, (float) (i / 2), (float) ((int) (0.4f * f)));
            this.f9475.setTransform(matrix);
        }
        m9914();
    }
}
