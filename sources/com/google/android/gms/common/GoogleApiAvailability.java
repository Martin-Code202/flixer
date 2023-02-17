package com.google.android.gms.common;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.util.TypedValue;
import android.widget.ProgressBar;
import com.google.android.gms.R;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.internal.zzby;
import com.google.android.gms.common.api.internal.zzbz;
import com.google.android.gms.common.api.internal.zzcg;
import com.google.android.gms.common.internal.zzbp;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.common.util.zzi;
import com.google.android.gms.common.util.zzp;
public class GoogleApiAvailability extends zze {
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = zze.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    private static final GoogleApiAvailability zzffh = new GoogleApiAvailability();

    /* access modifiers changed from: package-private */
    @SuppressLint({"HandlerLeak"})
    public class zza extends Handler {
        private final Context mApplicationContext;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public zza(Context context) {
            super(Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper());
            this.mApplicationContext = context.getApplicationContext();
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    int isGooglePlayServicesAvailable = GoogleApiAvailability.this.isGooglePlayServicesAvailable(this.mApplicationContext);
                    if (GoogleApiAvailability.this.isUserResolvableError(isGooglePlayServicesAvailable)) {
                        GoogleApiAvailability.this.showErrorNotification(this.mApplicationContext, isGooglePlayServicesAvailable);
                        return;
                    }
                    return;
                default:
                    Log.w("GoogleApiAvailability", new StringBuilder(50).append("Don't know how to handle this message: ").append(message.what).toString());
                    return;
            }
        }
    }

    GoogleApiAvailability() {
    }

    public static GoogleApiAvailability getInstance() {
        return zzffh;
    }

    public static Dialog zza(Activity activity, DialogInterface.OnCancelListener onCancelListener) {
        ProgressBar progressBar = new ProgressBar(activity, null, 16842874);
        progressBar.setIndeterminate(true);
        progressBar.setVisibility(0);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setView(progressBar);
        builder.setMessage(zzt.zzi(activity, 18));
        builder.setPositiveButton("", (DialogInterface.OnClickListener) null);
        AlertDialog create = builder.create();
        zza(activity, create, "GooglePlayServicesUpdatingDialog", onCancelListener);
        return create;
    }

    static Dialog zza(Context context, int i, zzu zzu, DialogInterface.OnCancelListener onCancelListener) {
        if (i == 0) {
            return null;
        }
        AlertDialog.Builder builder = null;
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(16843529, typedValue, true);
        if ("Theme.Dialog.Alert".equals(context.getResources().getResourceEntryName(typedValue.resourceId))) {
            builder = new AlertDialog.Builder(context, 5);
        }
        if (builder == null) {
            builder = new AlertDialog.Builder(context);
        }
        builder.setMessage(zzt.zzi(context, i));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        String zzk = zzt.zzk(context, i);
        if (zzk != null) {
            builder.setPositiveButton(zzk, zzu);
        }
        String zzg = zzt.zzg(context, i);
        if (zzg != null) {
            builder.setTitle(zzg);
        }
        return builder.create();
    }

    public static zzby zza(Context context, zzbz zzbz) {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        zzby zzby = new zzby(zzbz);
        context.registerReceiver(zzby, intentFilter);
        zzby.setContext(context);
        if (zzo.zzx(context, "com.google.android.gms")) {
            return zzby;
        }
        zzbz.zzage();
        zzby.unregister();
        return null;
    }

    static void zza(Activity activity, Dialog dialog, String str, DialogInterface.OnCancelListener onCancelListener) {
        if (activity instanceof FragmentActivity) {
            SupportErrorDialogFragment.newInstance(dialog, onCancelListener).show(((FragmentActivity) activity).getSupportFragmentManager(), str);
            return;
        }
        ErrorDialogFragment.newInstance(dialog, onCancelListener).show(activity.getFragmentManager(), str);
    }

    @TargetApi(20)
    private final void zza(Context context, int i, String str, PendingIntent pendingIntent) {
        Notification notification;
        int i2;
        if (i == 18) {
            zzbt(context);
        } else if (pendingIntent != null) {
            String zzh = zzt.zzh(context, i);
            String zzj = zzt.zzj(context, i);
            Resources resources = context.getResources();
            if (zzi.zzcj(context)) {
                zzbp.zzbg(zzp.zzalj());
                notification = new Notification.Builder(context).setSmallIcon(context.getApplicationInfo().icon).setPriority(2).setAutoCancel(true).setContentTitle(zzh).setStyle(new Notification.BigTextStyle().bigText(zzj)).addAction(R.drawable.common_full_open_on_phone, resources.getString(R.string.common_open_on_phone), pendingIntent).build();
            } else {
                notification = new NotificationCompat.Builder(context).setSmallIcon(17301642).setTicker(resources.getString(R.string.common_google_play_services_notification_ticker)).setWhen(System.currentTimeMillis()).setAutoCancel(true).setContentIntent(pendingIntent).setContentTitle(zzh).setContentText(zzj).setLocalOnly(true).setStyle(new NotificationCompat.BigTextStyle().bigText(zzj)).build();
            }
            switch (i) {
                case 1:
                case 2:
                case 3:
                    i2 = 10436;
                    zzo.zzffz.set(false);
                    break;
                default:
                    i2 = 39789;
                    break;
            }
            ((NotificationManager) context.getSystemService("notification")).notify(i2, notification);
        } else if (i == 6) {
            Log.w("GoogleApiAvailability", "Missing resolution for ConnectionResult.RESOLUTION_REQUIRED. Call GoogleApiAvailability#showErrorNotification(Context, ConnectionResult) instead.");
        }
    }

    public Dialog getErrorDialog(Activity activity, int i, int i2, DialogInterface.OnCancelListener onCancelListener) {
        return zza(activity, i, zzu.zza(activity, zze.zza(activity, i, "d"), i2), onCancelListener);
    }

    @Override // com.google.android.gms.common.zze
    public PendingIntent getErrorResolutionPendingIntent(Context context, int i, int i2) {
        return super.getErrorResolutionPendingIntent(context, i, i2);
    }

    public PendingIntent getErrorResolutionPendingIntent(Context context, ConnectionResult connectionResult) {
        return connectionResult.hasResolution() ? connectionResult.getResolution() : getErrorResolutionPendingIntent(context, connectionResult.getErrorCode(), 0);
    }

    @Override // com.google.android.gms.common.zze
    public final String getErrorString(int i) {
        return super.getErrorString(i);
    }

    @Override // com.google.android.gms.common.zze
    public int isGooglePlayServicesAvailable(Context context) {
        return super.isGooglePlayServicesAvailable(context);
    }

    @Override // com.google.android.gms.common.zze
    public final boolean isUserResolvableError(int i) {
        return super.isUserResolvableError(i);
    }

    public boolean showErrorDialogFragment(Activity activity, int i, int i2, DialogInterface.OnCancelListener onCancelListener) {
        Dialog errorDialog = getErrorDialog(activity, i, i2, onCancelListener);
        if (errorDialog == null) {
            return false;
        }
        zza(activity, errorDialog, "GooglePlayServicesErrorDialog", onCancelListener);
        return true;
    }

    public void showErrorNotification(Context context, int i) {
        zza(context, i, (String) null, zza(context, i, 0, "n"));
    }

    public final boolean zza(Activity activity, zzcg zzcg, int i, int i2, DialogInterface.OnCancelListener onCancelListener) {
        Dialog zza2 = zza(activity, i, zzu.zza(zzcg, zze.zza(activity, i, "d"), 2), onCancelListener);
        if (zza2 == null) {
            return false;
        }
        zza(activity, zza2, "GooglePlayServicesErrorDialog", onCancelListener);
        return true;
    }

    public final boolean zza(Context context, ConnectionResult connectionResult, int i) {
        PendingIntent errorResolutionPendingIntent = getErrorResolutionPendingIntent(context, connectionResult);
        if (errorResolutionPendingIntent == null) {
            return false;
        }
        zza(context, connectionResult.getErrorCode(), (String) null, GoogleApiActivity.zza(context, errorResolutionPendingIntent, i));
        return true;
    }

    /* access modifiers changed from: package-private */
    public final void zzbt(Context context) {
        new zza(context).sendEmptyMessageDelayed(1, 120000);
    }
}
