package o;

import android.content.Context;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.os.Handler;
import android.provider.Settings;
/* access modifiers changed from: package-private */
public class lQ extends ContentObserver {

    /* renamed from: ˋ  reason: contains not printable characters */
    private final AbstractC0144 f8552;

    /* renamed from: ˎ  reason: contains not printable characters */
    private int f8553 = m8658();

    /* renamed from: ॱ  reason: contains not printable characters */
    private final Context f8554;

    /* renamed from: o.lQ$ˋ  reason: contains not printable characters */
    public interface AbstractC0144 {
        /* renamed from: ॱ */
        void mo8611(int i, int i2);
    }

    public lQ(Context context, Handler handler, AbstractC0144 r6) {
        super(handler);
        this.f8552 = r6;
        this.f8554 = context;
        this.f8554.getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public int m8658() {
        AudioManager audioManager = (AudioManager) this.f8554.getSystemService("audio");
        if (audioManager == null) {
            return 0;
        }
        int streamVolume = audioManager.getStreamVolume(3);
        int streamMaxVolume = audioManager.getStreamMaxVolume(3);
        if (streamMaxVolume > 0) {
            return (1000000 * streamVolume) / streamMaxVolume;
        }
        return 0;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        int r2 = m8658();
        if (r2 != this.f8553) {
            this.f8552.mo8611(this.f8553, r2);
            this.f8553 = r2;
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m8659() {
        this.f8554.getContentResolver().unregisterContentObserver(this);
    }
}
