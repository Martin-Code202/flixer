package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Locale;
public final class zzami extends zzams {
    private static boolean zzdno;
    private AdvertisingIdClient.Info zzdnp;
    private final zzaoz zzdnq;
    private String zzdnr;
    private boolean zzdns = false;
    private final Object zzdnt = new Object();

    zzami(zzamu zzamu) {
        super(zzamu);
        this.zzdnq = new zzaoz(zzamu.zzvx());
    }

    private final boolean zza(AdvertisingIdClient.Info info, AdvertisingIdClient.Info info2) {
        String id = info2 == null ? null : info2.getId();
        if (TextUtils.isEmpty(id)) {
            return true;
        }
        String zzxp = zzwg().zzxp();
        synchronized (this.zzdnt) {
            if (!this.zzdns) {
                this.zzdnr = zzvq();
                this.zzdns = true;
            } else if (TextUtils.isEmpty(this.zzdnr)) {
                String id2 = info == null ? null : info.getId();
                if (id2 == null) {
                    String valueOf = String.valueOf(id);
                    String valueOf2 = String.valueOf(zzxp);
                    return zzdl(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
                }
                String valueOf3 = String.valueOf(id2);
                String valueOf4 = String.valueOf(zzxp);
                this.zzdnr = zzdk(valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3));
            }
            String valueOf5 = String.valueOf(id);
            String valueOf6 = String.valueOf(zzxp);
            String zzdk = zzdk(valueOf6.length() != 0 ? valueOf5.concat(valueOf6) : new String(valueOf5));
            if (TextUtils.isEmpty(zzdk)) {
                return false;
            }
            if (zzdk.equals(this.zzdnr)) {
                return true;
            }
            if (!TextUtils.isEmpty(this.zzdnr)) {
                zzdm("Resetting the client id because Advertising Id changed.");
                zzxp = zzwg().zzxq();
                zza("New client Id", zzxp);
            }
            String valueOf7 = String.valueOf(id);
            String valueOf8 = String.valueOf(zzxp);
            return zzdl(valueOf8.length() != 0 ? valueOf7.concat(valueOf8) : new String(valueOf7));
        }
    }

    private static String zzdk(String str) {
        MessageDigest zzec = zzapd.zzec("MD5");
        if (zzec == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new BigInteger(1, zzec.digest(str.getBytes())));
    }

    private final boolean zzdl(String str) {
        try {
            String zzdk = zzdk(str);
            zzdm("Storing hashed adid.");
            FileOutputStream openFileOutput = getContext().openFileOutput("gaClientIdData", 0);
            openFileOutput.write(zzdk.getBytes());
            openFileOutput.close();
            this.zzdnr = zzdk;
            return true;
        } catch (IOException e) {
            zze("Error creating hash file", e);
            return false;
        }
    }

    private final synchronized AdvertisingIdClient.Info zzvo() {
        if (this.zzdnq.zzu(1000)) {
            this.zzdnq.start();
            AdvertisingIdClient.Info zzvp = zzvp();
            if (zza(this.zzdnp, zzvp)) {
                this.zzdnp = zzvp;
            } else {
                zzdq("Failed to reset client id on adid change. Not using adid");
                this.zzdnp = new AdvertisingIdClient.Info("", false);
            }
        }
        return this.zzdnp;
    }

    private final AdvertisingIdClient.Info zzvp() {
        try {
            return AdvertisingIdClient.getAdvertisingIdInfo(getContext());
        } catch (IllegalStateException unused) {
            zzdp("IllegalStateException getting Ad Id Info. If you would like to see Audience reports, please ensure that you have added '<meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />' to your application manifest file. See http://goo.gl/naFqQk for details.");
            return null;
        } catch (Throwable th) {
            if (zzdno) {
                return null;
            }
            zzdno = true;
            zzd("Error getting advertiser id", th);
            return null;
        }
    }

    private final String zzvq() {
        try {
            FileInputStream openFileInput = getContext().openFileInput("gaClientIdData");
            byte[] bArr = new byte[128];
            int read = openFileInput.read(bArr, 0, 128);
            if (openFileInput.available() > 0) {
                zzdp("Hash file seems corrupted, deleting it.");
                openFileInput.close();
                getContext().deleteFile("gaClientIdData");
                return null;
            } else if (read <= 0) {
                zzdm("Hash file is empty.");
                openFileInput.close();
                return null;
            } else {
                String str = new String(bArr, 0, read);
                openFileInput.close();
                return str;
            }
        } catch (FileNotFoundException unused) {
            return null;
        } catch (IOException e) {
            zzd("Error reading Hash file, deleting it", e);
            getContext().deleteFile("gaClientIdData");
            return null;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzams
    public final void zzuk() {
    }

    public final boolean zzvg() {
        zzwk();
        AdvertisingIdClient.Info zzvo = zzvo();
        return zzvo != null && !zzvo.isLimitAdTrackingEnabled();
    }

    public final String zzvn() {
        zzwk();
        AdvertisingIdClient.Info zzvo = zzvo();
        String str = null;
        if (zzvo != null) {
            str = zzvo.getId();
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str;
    }
}
