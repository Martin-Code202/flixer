package o;

import android.content.Context;
import android.os.Handler;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.google.android.exoplayer2.Renderer;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.FrameworkMediaCrypto;
import com.google.android.exoplayer2.mediacodec.MediaCodecSelector;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import java.util.ArrayList;
/* renamed from: o.jw  reason: case insensitive filesystem */
public class C1922jw extends DefaultRenderersFactory {
    public C1922jw(Context context, DrmSessionManager<FrameworkMediaCrypto> drmSessionManager, int i) {
        super(context, drmSessionManager, i);
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.DefaultRenderersFactory
    public void buildVideoRenderers(Context context, DrmSessionManager<FrameworkMediaCrypto> drmSessionManager, long j, Handler handler, VideoRendererEventListener videoRendererEventListener, int i, ArrayList<Renderer> arrayList) {
        arrayList.add(new C1920ju(context, MediaCodecSelector.DEFAULT, j, drmSessionManager, false, handler, videoRendererEventListener, 50));
        if (i != 0) {
            Assertions.checkArgument(i == 0);
        }
    }
}
