package o;

import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.os.Handler;
import android.text.TextUtils;
import android.view.Surface;
import android.view.TextureView;
import com.netflix.mediaclient.api.res.AssetType;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
public class qJ implements TextureView.SurfaceTextureListener, MediaPlayer.OnErrorListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnVideoSizeChangedListener, MediaPlayer.OnInfoListener {

    /* renamed from: ʻ  reason: contains not printable characters */
    protected boolean f9469 = false;

    /* renamed from: ʻॱ  reason: contains not printable characters */
    private Runnable f9470;

    /* renamed from: ʼ  reason: contains not printable characters */
    protected long f9471;

    /* renamed from: ʽ  reason: contains not printable characters */
    private iF f9472;

    /* renamed from: ˊ  reason: contains not printable characters */
    boolean f9473;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private int f9474;

    /* renamed from: ˋ  reason: contains not printable characters */
    protected TextureView f9475;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private float f9476 = 0.0f;

    /* renamed from: ˎ  reason: contains not printable characters */
    protected AssetType f9477;

    /* renamed from: ˏ  reason: contains not printable characters */
    protected String f9478;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private int f9479;

    /* renamed from: ͺ  reason: contains not printable characters */
    private int f9480;

    /* renamed from: ॱ  reason: contains not printable characters */
    protected Surface f9481;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private MediaPlayer f9482;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private int f9483;

    /* renamed from: ᐝ  reason: contains not printable characters */
    protected long f9484;

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private Handler f9485;

    public interface iF {
        /* renamed from: ˊ */
        void mo2132();

        /* renamed from: ˎ */
        void mo2133();

        /* renamed from: ˏ */
        void mo2134();

        /* renamed from: ˏ */
        void mo2135(int i, int i2);
    }

    public qJ(TextureView textureView, boolean z, int i, float f, AssetType assetType, iF iFVar) {
        this.f9477 = assetType;
        this.f9472 = iFVar;
        if (textureView != null) {
            this.f9475 = textureView;
            this.f9475.setSurfaceTextureListener(this);
        } else {
            this.f9469 = true;
        }
        this.f9473 = z;
        this.f9483 = i;
        this.f9476 = f;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m9915(String str, long j, long j2) {
        this.f9478 = str;
        this.f9471 = j;
        this.f9484 = j2;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m9914() {
        if (this.f9469) {
            try {
                if (this.f9482 == null) {
                    this.f9482 = new MediaPlayer();
                    this.f9479 = 0;
                    this.f9482.setOnErrorListener(this);
                    this.f9482.setAudioStreamType(3);
                    this.f9482.setScreenOnWhilePlaying(false);
                    this.f9482.setOnInfoListener(this);
                    this.f9482.setOnPreparedListener(this);
                    this.f9482.setOnVideoSizeChangedListener(this);
                    m9907();
                }
                if (this.f9481 != null) {
                    this.f9482.setSurface(this.f9481);
                }
                if (this.f9479 == 6 || this.f9479 == 2) {
                    m9903();
                } else if ((this.f9479 == 0 || this.f9479 == 5) && !TextUtils.isEmpty(this.f9478)) {
                    File file = new File(this.f9478);
                    if (file.exists()) {
                        FileInputStream fileInputStream = new FileInputStream(file);
                        this.f9482.setDataSource(fileInputStream.getFD(), this.f9471, this.f9484);
                        fileInputStream.close();
                        this.f9479 = 1;
                        this.f9482.prepareAsync();
                        this.f9479 = 3;
                        return;
                    }
                    m9918();
                }
            } catch (IOException | RuntimeException e) {
                m9918();
            }
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public boolean m9911() {
        if (!this.f9469) {
            return false;
        }
        m9903();
        return true;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m9909() {
        if (this.f9482 != null && this.f9482.isPlaying()) {
            this.f9474 = this.f9482.getCurrentPosition();
            this.f9482.pause();
            this.f9479 = 6;
        }
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    private void m9902() {
        if (this.f9482 != null && this.f9479 != 0 && this.f9479 != 1 && this.f9479 != 9) {
            this.f9474 = this.f9482.getCurrentPosition();
            this.f9482.stop();
            this.f9479 = 5;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ʽ  reason: contains not printable characters */
    private void m9903() {
        if (this.f9482 != null) {
            boolean isPlaying = this.f9482.isPlaying();
            if (this.f9469 && !isPlaying) {
                if (this.f9479 == 2 || this.f9479 == 6 || this.f9479 == 7) {
                    if (this.f9479 != 6) {
                        this.f9482.seekTo(this.f9474);
                    }
                    this.f9482.start();
                    this.f9479 = 4;
                    this.f9482.setOnCompletionListener(this);
                }
            }
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public boolean m9916() {
        return this.f9476 <= 0.0f;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m9912() {
        this.f9476 = 1.0f - this.f9476;
        m9907();
    }

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private void m9907() {
        if (this.f9482 != null) {
            this.f9482.setVolume(this.f9476, this.f9476);
        }
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public boolean m9917() {
        if (this.f9483 == -1) {
            return false;
        }
        return this.f9480 >= (this.f9473 ? this.f9483 : 0);
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        this.f9479 = 2;
        m9903();
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        if (i != 3) {
            return false;
        }
        if (this.f9472 == null) {
            return true;
        }
        this.f9472.mo2132();
        return true;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        this.f9479 = 7;
        this.f9480++;
        this.f9474 = 0;
        if (m9917()) {
            if (this.f9472 != null) {
                this.f9472.mo2133();
            }
            m9918();
            return;
        }
        if (this.f9482 != null && this.f9482.isPlaying()) {
            m9910(100);
        } else {
            m9903();
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m9910(int i) {
        if (this.f9485 == null) {
            this.f9485 = new Handler();
        }
        if (this.f9470 == null) {
            this.f9470 = new Runnable() { // from class: o.qJ.2
                @Override // java.lang.Runnable
                public void run() {
                    qJ.this.m9903();
                }
            };
        }
        this.f9485.postDelayed(this.f9470, (long) i);
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        this.f9479 = 9;
        if (this.f9472 != null) {
            this.f9472.mo2135(i, i2);
        }
        m9918();
        return true;
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        if (i > 0 && i2 > 0) {
            m9903();
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        this.f9481 = new Surface(surfaceTexture);
        this.f9469 = true;
        m9914();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        m9905(surfaceTexture);
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    public void m9918() {
        m9913(false);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m9913(boolean z) {
        m9905(z ? this.f9475.getSurfaceTexture() : null);
        if (this.f9485 != null && this.f9470 != null) {
            this.f9485.removeCallbacks(this.f9470);
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m9905(SurfaceTexture surfaceTexture) {
        m9908();
        m9904(surfaceTexture);
        if (this.f9472 != null) {
            this.f9472.mo2134();
        }
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public void m9908() {
        if (this.f9482 != null) {
            if (this.f9482.isPlaying()) {
                m9902();
            }
            this.f9482.reset();
            this.f9479 = 0;
            this.f9482.release();
            this.f9479 = 8;
            this.f9482 = null;
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m9904(SurfaceTexture surfaceTexture) {
        this.f9469 = false;
        if (this.f9481 != null) {
            this.f9481.release();
            this.f9481 = null;
        }
        if (surfaceTexture != null) {
            surfaceTexture.release();
        }
    }
}
