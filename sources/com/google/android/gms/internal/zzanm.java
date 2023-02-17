package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.common.internal.zzbp;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
public final class zzanm extends zzams {
    private volatile String zzdmw;
    private Future<String> zzdqg;

    protected zzanm(zzamu zzamu) {
        super(zzamu);
    }

    private final String zzbh(Context context) {
        zzbp.zzgh("ClientId should be loaded from worker thread");
        FileInputStream fileInputStream = null;
        try {
            FileInputStream openFileInput = context.openFileInput("gaClientId");
            byte[] bArr = new byte[36];
            int read = openFileInput.read(bArr, 0, 36);
            if (openFileInput.available() > 0) {
                zzdp("clientId file seems corrupted, deleting it.");
                openFileInput.close();
                context.deleteFile("gaClientId");
                if (openFileInput == null) {
                    return null;
                }
                try {
                    openFileInput.close();
                    return null;
                } catch (IOException e) {
                    zze("Failed to close client id reading stream", e);
                    return null;
                }
            } else if (read < 14) {
                zzdp("clientId file is empty, deleting it.");
                openFileInput.close();
                context.deleteFile("gaClientId");
                if (openFileInput == null) {
                    return null;
                }
                try {
                    openFileInput.close();
                    return null;
                } catch (IOException e2) {
                    zze("Failed to close client id reading stream", e2);
                    return null;
                }
            } else {
                openFileInput.close();
                String str = new String(bArr, 0, read);
                zza("Read client id from disk", str);
                if (openFileInput != null) {
                    try {
                        openFileInput.close();
                    } catch (IOException e3) {
                        zze("Failed to close client id reading stream", e3);
                    }
                }
                return str;
            }
        } catch (FileNotFoundException unused) {
            if (0 == 0) {
                return null;
            }
            try {
                fileInputStream.close();
                return null;
            } catch (IOException e4) {
                zze("Failed to close client id reading stream", e4);
                return null;
            }
        } catch (IOException e5) {
            zze("Error reading client id file, deleting it", e5);
            context.deleteFile("gaClientId");
            if (0 == 0) {
                return null;
            }
            try {
                fileInputStream.close();
                return null;
            } catch (IOException e6) {
                zze("Failed to close client id reading stream", e6);
                return null;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    fileInputStream.close();
                } catch (IOException e7) {
                    zze("Failed to close client id reading stream", e7);
                }
            }
            throw th;
        }
    }

    private final boolean zzu(Context context, String str) {
        zzbp.zzgg(str);
        zzbp.zzgh("ClientId should be saved from worker thread");
        FileOutputStream fileOutputStream = null;
        try {
            zza("Storing clientId", str);
            FileOutputStream openFileOutput = context.openFileOutput("gaClientId", 0);
            fileOutputStream = openFileOutput;
            openFileOutput.write(str.getBytes());
            if (fileOutputStream == null) {
                return true;
            }
            try {
                fileOutputStream.close();
                return true;
            } catch (IOException e) {
                zze("Failed to close clientId writing stream", e);
                return true;
            }
        } catch (FileNotFoundException e2) {
            zze("Error creating clientId file", e2);
            if (fileOutputStream == null) {
                return false;
            }
            try {
                fileOutputStream.close();
                return false;
            } catch (IOException e3) {
                zze("Failed to close clientId writing stream", e3);
                return false;
            }
        } catch (IOException e4) {
            zze("Error writing to clientId file", e4);
            if (fileOutputStream == null) {
                return false;
            }
            try {
                fileOutputStream.close();
                return false;
            } catch (IOException e5) {
                zze("Failed to close clientId writing stream", e5);
                return false;
            }
        } catch (Throwable th) {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e6) {
                    zze("Failed to close clientId writing stream", e6);
                }
            }
            throw th;
        }
    }

    /* access modifiers changed from: private */
    public final String zzxs() {
        String lowerCase = UUID.randomUUID().toString().toLowerCase();
        try {
            return !zzu(zzwa().getContext(), lowerCase) ? "0" : lowerCase;
        } catch (Exception e) {
            zze("Error saving clientId file", e);
            return "0";
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzams
    public final void zzuk() {
    }

    public final String zzxp() {
        String str;
        zzwk();
        synchronized (this) {
            if (this.zzdmw == null) {
                this.zzdqg = zzwa().zzc(new zzann(this));
            }
            if (this.zzdqg != null) {
                try {
                    this.zzdmw = this.zzdqg.get();
                } catch (InterruptedException e) {
                    zzd("ClientId loading or generation was interrupted", e);
                    this.zzdmw = "0";
                } catch (ExecutionException e2) {
                    zze("Failed to load or generate client id", e2);
                    this.zzdmw = "0";
                }
                if (this.zzdmw == null) {
                    this.zzdmw = "0";
                }
                zza("Loaded clientId", this.zzdmw);
                this.zzdqg = null;
            }
            str = this.zzdmw;
        }
        return str;
    }

    /* access modifiers changed from: package-private */
    public final String zzxq() {
        synchronized (this) {
            this.zzdmw = null;
            this.zzdqg = zzwa().zzc(new zzano(this));
        }
        return zzxp();
    }

    /* access modifiers changed from: package-private */
    public final String zzxr() {
        String zzbh = zzbh(zzwa().getContext());
        return zzbh == null ? zzxs() : zzbh;
    }
}
