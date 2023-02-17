package com.google.android.gms.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.RemoteException;
import com.netflix.mediaclient.service.webclient.model.leafs.SubtitleDownloadRetryPolicy;
public final class zzawg extends AsyncTask<Uri, Long, Bitmap> {
    private static final zzazx zzejc = new zzazx("FetchBitmapTask");
    private final zzawl zzevc;
    private final zzawi zzevd;

    private zzawg(Context context, int i, int i2, boolean z, long j, int i3, int i4, int i5, zzawi zzawi) {
        this.zzevc = zzavl.zza(context.getApplicationContext(), this, new zzawk(this), i, i2, z, 2097152, 5, 333, SubtitleDownloadRetryPolicy.DEFAULT_INITIAL_INTERVAL_MS);
        this.zzevd = zzawi;
    }

    public zzawg(Context context, int i, int i2, boolean z, zzawi zzawi) {
        this(context, i, i2, false, 2097152, 5, 333, SubtitleDownloadRetryPolicy.DEFAULT_INITIAL_INTERVAL_MS, zzawi);
    }

    public zzawg(Context context, zzawi zzawi) {
        this(context, 0, 0, false, 2097152, 5, 333, SubtitleDownloadRetryPolicy.DEFAULT_INITIAL_INTERVAL_MS, zzawi);
    }

    /* access modifiers changed from: private */
    public final Bitmap doInBackground(Uri... uriArr) {
        if (uriArr.length != 1 || uriArr[0] == null) {
            return null;
        }
        try {
            return this.zzevc.zzm(uriArr[0]);
        } catch (RemoteException e) {
            zzejc.zzb(e, "Unable to call %s on %s.", "doFetch", zzawl.class.getSimpleName());
            return null;
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public final /* synthetic */ void onPostExecute(Bitmap bitmap) {
        Bitmap bitmap2 = bitmap;
        if (this.zzevd != null) {
            this.zzevd.onPostExecute(bitmap2);
        }
    }
}
