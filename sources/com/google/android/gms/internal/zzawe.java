package com.google.android.gms.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import com.google.android.gms.cast.framework.media.ImageHints;
public final class zzawe implements zzawi {
    private Bitmap mBitmap;
    private final Context zzeog;
    private final ImageHints zzeuw;
    private Uri zzeux;
    private zzawg zzeuy;
    private zzawj zzeuz;
    private boolean zzeva;
    private zzawf zzevb;

    public zzawe(Context context) {
        this(context, new ImageHints(-1, 0, 0));
    }

    public zzawe(Context context, ImageHints imageHints) {
        this.zzeog = context;
        this.zzeuw = imageHints;
        this.zzeuz = new zzawj();
        reset();
    }

    private final void reset() {
        if (this.zzeuy != null) {
            this.zzeuy.cancel(true);
            this.zzeuy = null;
        }
        this.zzeux = null;
        this.mBitmap = null;
        this.zzeva = false;
    }

    public final void clear() {
        reset();
        this.zzevb = null;
    }

    @Override // com.google.android.gms.internal.zzawi
    public final void onPostExecute(Bitmap bitmap) {
        this.mBitmap = bitmap;
        this.zzeva = true;
        if (this.zzevb != null) {
            this.zzevb.zzc(this.mBitmap);
        }
        this.zzeuy = null;
    }

    public final void zza(zzawf zzawf) {
        this.zzevb = zzawf;
    }

    public final boolean zzl(Uri uri) {
        if (uri == null) {
            reset();
            return true;
        } else if (uri.equals(this.zzeux)) {
            return this.zzeva;
        } else {
            reset();
            this.zzeux = uri;
            if (this.zzeuw.getWidthInPixels() == 0 || this.zzeuw.getHeightInPixels() == 0) {
                this.zzeuy = new zzawg(this.zzeog, this);
            } else {
                this.zzeuy = new zzawg(this.zzeog, this.zzeuw.getWidthInPixels(), this.zzeuw.getHeightInPixels(), false, this);
            }
            this.zzeuy.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, this.zzeux);
            return false;
        }
    }
}
