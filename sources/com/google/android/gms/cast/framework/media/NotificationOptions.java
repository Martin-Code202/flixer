package com.google.android.gms.cast.framework.media;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.R;
import com.google.android.gms.internal.zzbck;
import com.google.android.gms.internal.zzbcn;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class NotificationOptions extends zzbck {
    public static final Parcelable.Creator<NotificationOptions> CREATOR = new zzm();
    private static final List<String> zzesp = Arrays.asList("com.google.android.gms.cast.framework.action.TOGGLE_PLAYBACK", "com.google.android.gms.cast.framework.action.STOP_CASTING");
    private static final int[] zzesq = {0, 1};
    private final List<String> zzesr;
    private final int[] zzess;
    private final long zzest;
    private final String zzesu;
    private final int zzesv;
    private final int zzesw;
    private final int zzesx;
    private final int zzesy;
    private final int zzesz;
    private final int zzeta;
    private final int zzetb;
    private final int zzetc;
    private final int zzetd;
    private final int zzete;
    private final int zzetf;
    private final int zzetg;
    private final int zzeth;
    private final int zzeti;
    private final int zzetj;
    private final int zzetk;
    private final int zzetl;
    private final int zzetm;
    private final int zzetn;
    private final int zzeto;
    private final int zzetp;
    private final int zzetq;
    private final int zzetr;
    private final int zzets;
    private final int zzett;
    private final int zzetu;
    private final int zzetv;
    private final zzf zzetw;

    public static final class Builder {
        private List<String> zzesr = NotificationOptions.zzesp;
        private int[] zzess = NotificationOptions.zzesq;
        private long zzest = 10000;
        private String zzesu;
        private int zzesv = R.drawable.cast_ic_notification_small_icon;
        private int zzesw = R.drawable.cast_ic_notification_stop_live_stream;
        private int zzesx = R.drawable.cast_ic_notification_pause;
        private int zzesy = R.drawable.cast_ic_notification_play;
        private int zzesz = R.drawable.cast_ic_notification_skip_next;
        private int zzeta = R.drawable.cast_ic_notification_skip_prev;
        private int zzetb = R.drawable.cast_ic_notification_forward;
        private int zzetc = R.drawable.cast_ic_notification_forward10;
        private int zzetd = R.drawable.cast_ic_notification_forward30;
        private int zzete = R.drawable.cast_ic_notification_rewind;
        private int zzetf = R.drawable.cast_ic_notification_rewind10;
        private int zzetg = R.drawable.cast_ic_notification_rewind30;
        private int zzeth = R.drawable.cast_ic_notification_disconnect;
        private NotificationActionsProvider zzetx;

        public final NotificationOptions build() {
            return new NotificationOptions(this.zzesr, this.zzess, this.zzest, this.zzesu, this.zzesv, this.zzesw, this.zzesx, this.zzesy, this.zzesz, this.zzeta, this.zzetb, this.zzetc, this.zzetd, this.zzete, this.zzetf, this.zzetg, this.zzeth, R.dimen.cast_notification_image_size, R.string.cast_casting_to_device, R.string.cast_stop_live_stream, R.string.cast_pause, R.string.cast_play, R.string.cast_skip_next, R.string.cast_skip_prev, R.string.cast_forward, R.string.cast_forward_10, R.string.cast_forward_30, R.string.cast_rewind, R.string.cast_rewind_10, R.string.cast_rewind_30, R.string.cast_disconnect, this.zzetx == null ? null : this.zzetx.zzada().asBinder());
        }
    }

    public NotificationOptions(List<String> list, int[] iArr, long j, String str, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i20, int i21, int i22, int i23, int i24, int i25, int i26, int i27, IBinder iBinder) {
        zzf zzf;
        if (list != null) {
            this.zzesr = new ArrayList(list);
        } else {
            this.zzesr = null;
        }
        if (iArr != null) {
            this.zzess = Arrays.copyOf(iArr, iArr.length);
        } else {
            this.zzess = null;
        }
        this.zzest = j;
        this.zzesu = str;
        this.zzesv = i;
        this.zzesw = i2;
        this.zzesx = i3;
        this.zzesy = i4;
        this.zzesz = i5;
        this.zzeta = i6;
        this.zzetb = i7;
        this.zzetc = i8;
        this.zzetd = i9;
        this.zzete = i10;
        this.zzetf = i11;
        this.zzetg = i12;
        this.zzeth = i13;
        this.zzeti = i14;
        this.zzetj = i15;
        this.zzetk = i16;
        this.zzetl = i17;
        this.zzetm = i18;
        this.zzetn = i19;
        this.zzeto = i20;
        this.zzetp = i21;
        this.zzetq = i22;
        this.zzetr = i23;
        this.zzets = i24;
        this.zzett = i25;
        this.zzetu = i26;
        this.zzetv = i27;
        if (iBinder == null) {
            zzf = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.cast.framework.media.INotificationActionsProvider");
            zzf = queryLocalInterface instanceof zzf ? (zzf) queryLocalInterface : new zzh(iBinder);
        }
        this.zzetw = zzf;
    }

    public List<String> getActions() {
        return this.zzesr;
    }

    public int getCastingToDeviceStringResId() {
        return this.zzetj;
    }

    public int[] getCompatActionIndices() {
        return Arrays.copyOf(this.zzess, this.zzess.length);
    }

    public int getDisconnectDrawableResId() {
        return this.zzeth;
    }

    public int getForward10DrawableResId() {
        return this.zzetc;
    }

    public int getForward30DrawableResId() {
        return this.zzetd;
    }

    public int getForwardDrawableResId() {
        return this.zzetb;
    }

    public int getPauseDrawableResId() {
        return this.zzesx;
    }

    public int getPlayDrawableResId() {
        return this.zzesy;
    }

    public int getRewind10DrawableResId() {
        return this.zzetf;
    }

    public int getRewind30DrawableResId() {
        return this.zzetg;
    }

    public int getRewindDrawableResId() {
        return this.zzete;
    }

    public int getSkipNextDrawableResId() {
        return this.zzesz;
    }

    public int getSkipPrevDrawableResId() {
        return this.zzeta;
    }

    public long getSkipStepMs() {
        return this.zzest;
    }

    public int getSmallIconDrawableResId() {
        return this.zzesv;
    }

    public int getStopLiveStreamDrawableResId() {
        return this.zzesw;
    }

    public int getStopLiveStreamTitleResId() {
        return this.zzetk;
    }

    public String getTargetActivityClassName() {
        return this.zzesu;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int zze = zzbcn.zze(parcel);
        zzbcn.zzb(parcel, 2, getActions(), false);
        zzbcn.zza(parcel, 3, getCompatActionIndices(), false);
        zzbcn.zza(parcel, 4, getSkipStepMs());
        zzbcn.zza(parcel, 5, getTargetActivityClassName(), false);
        zzbcn.zzc(parcel, 6, getSmallIconDrawableResId());
        zzbcn.zzc(parcel, 7, getStopLiveStreamDrawableResId());
        zzbcn.zzc(parcel, 8, getPauseDrawableResId());
        zzbcn.zzc(parcel, 9, getPlayDrawableResId());
        zzbcn.zzc(parcel, 10, getSkipNextDrawableResId());
        zzbcn.zzc(parcel, 11, getSkipPrevDrawableResId());
        zzbcn.zzc(parcel, 12, getForwardDrawableResId());
        zzbcn.zzc(parcel, 13, getForward10DrawableResId());
        zzbcn.zzc(parcel, 14, getForward30DrawableResId());
        zzbcn.zzc(parcel, 15, getRewindDrawableResId());
        zzbcn.zzc(parcel, 16, getRewind10DrawableResId());
        zzbcn.zzc(parcel, 17, getRewind30DrawableResId());
        zzbcn.zzc(parcel, 18, getDisconnectDrawableResId());
        zzbcn.zzc(parcel, 19, this.zzeti);
        zzbcn.zzc(parcel, 20, getCastingToDeviceStringResId());
        zzbcn.zzc(parcel, 21, getStopLiveStreamTitleResId());
        zzbcn.zzc(parcel, 22, this.zzetl);
        zzbcn.zzc(parcel, 23, this.zzetm);
        zzbcn.zzc(parcel, 24, this.zzetn);
        zzbcn.zzc(parcel, 25, this.zzeto);
        zzbcn.zzc(parcel, 26, this.zzetp);
        zzbcn.zzc(parcel, 27, this.zzetq);
        zzbcn.zzc(parcel, 28, this.zzetr);
        zzbcn.zzc(parcel, 29, this.zzets);
        zzbcn.zzc(parcel, 30, this.zzett);
        zzbcn.zzc(parcel, 31, this.zzetu);
        zzbcn.zzc(parcel, 32, this.zzetv);
        zzbcn.zza(parcel, 33, this.zzetw == null ? null : this.zzetw.asBinder(), false);
        zzbcn.zzai(parcel, zze);
    }
}
