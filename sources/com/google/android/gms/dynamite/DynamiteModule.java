package com.google.android.gms.dynamite;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.zzbp;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.common.zze;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.zzn;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
public final class DynamiteModule {
    private static Boolean zzgph;
    private static zzk zzgpi;
    private static zzm zzgpj;
    private static String zzgpk;
    private static final ThreadLocal<zza> zzgpl = new ThreadLocal<>();
    private static final zzi zzgpm = new zza();
    public static final zzd zzgpn = new zzb();
    private static zzd zzgpo = new zzc();
    public static final zzd zzgpp = new zzd();
    public static final zzd zzgpq = new zze();
    public static final zzd zzgpr = new zzf();
    public static final zzd zzgps = new zzg();
    private final Context zzgpt;

    @DynamiteApi
    public static class DynamiteLoaderClassLoader {
        public static ClassLoader sClassLoader;
    }

    /* access modifiers changed from: package-private */
    public static class zza {
        public Cursor zzgpu;

        private zza() {
        }

        /* synthetic */ zza(zza zza) {
            this();
        }
    }

    /* access modifiers changed from: package-private */
    public static class zzb implements zzi {
        private final int zzgpv;
        private final int zzgpw = 0;

        public zzb(int i, int i2) {
            this.zzgpv = i;
        }

        @Override // com.google.android.gms.dynamite.zzi
        public final int zzad(Context context, String str) {
            return this.zzgpv;
        }

        @Override // com.google.android.gms.dynamite.zzi
        public final int zzb(Context context, String str, boolean z) {
            return 0;
        }
    }

    public static class zzc extends Exception {
        private zzc(String str) {
            super(str);
        }

        /* synthetic */ zzc(String str, zza zza) {
            this(str);
        }

        private zzc(String str, Throwable th) {
            super(str, th);
        }

        /* synthetic */ zzc(String str, Throwable th, zza zza) {
            this(str, th);
        }
    }

    public interface zzd {
        zzj zza(Context context, String str, zzi zzi);
    }

    private DynamiteModule(Context context) {
        this.zzgpt = (Context) zzbp.zzu(context);
    }

    private static Context zza(Context context, String str, int i, Cursor cursor, zzm zzm) {
        try {
            return (Context) zzn.zzx(zzm.zza(zzn.zzw(context), str, i, zzn.zzw(cursor)));
        } catch (Exception e) {
            String valueOf = String.valueOf(e.toString());
            Log.e("DynamiteModule", valueOf.length() != 0 ? "Failed to load DynamiteLoader: ".concat(valueOf) : new String("Failed to load DynamiteLoader: "));
            return null;
        }
    }

    public static DynamiteModule zza(Context context, zzd zzd2, String str) {
        zza zza2 = zzgpl.get();
        zza zza3 = new zza(null);
        zzgpl.set(zza3);
        try {
            zzj zza4 = zzd2.zza(context, str, zzgpm);
            Log.i("DynamiteModule", new StringBuilder(String.valueOf(str).length() + String.valueOf(str).length() + 68).append("Considering local module ").append(str).append(":").append(zza4.zzgpx).append(" and remote module ").append(str).append(":").append(zza4.zzgpy).toString());
            if (zza4.zzgpz == 0 || ((zza4.zzgpz == -1 && zza4.zzgpx == 0) || (zza4.zzgpz == 1 && zza4.zzgpy == 0))) {
                throw new zzc(new StringBuilder(91).append("No acceptable module found. Local version is ").append(zza4.zzgpx).append(" and remote version is ").append(zza4.zzgpy).append(".").toString(), (zza) null);
            } else if (zza4.zzgpz == -1) {
                return zzaf(context, str);
            } else {
                if (zza4.zzgpz == 1) {
                    try {
                        DynamiteModule zza5 = zza(context, str, zza4.zzgpy);
                        if (zza3.zzgpu != null) {
                            zza3.zzgpu.close();
                        }
                        zzgpl.set(zza2);
                        return zza5;
                    } catch (zzc e) {
                        String valueOf = String.valueOf(e.getMessage());
                        Log.w("DynamiteModule", valueOf.length() != 0 ? "Failed to load remote module: ".concat(valueOf) : new String("Failed to load remote module: "));
                        if (zza4.zzgpx == 0 || zzd2.zza(context, str, new zzb(zza4.zzgpx, 0)).zzgpz != -1) {
                            throw new zzc("Remote load failed. No local fallback found.", e, null);
                        }
                        DynamiteModule zzaf = zzaf(context, str);
                        if (zza3.zzgpu != null) {
                            zza3.zzgpu.close();
                        }
                        zzgpl.set(zza2);
                        return zzaf;
                    }
                } else {
                    throw new zzc(new StringBuilder(47).append("VersionPolicy returned invalid code:").append(zza4.zzgpz).toString(), (zza) null);
                }
            }
        } finally {
            if (zza3.zzgpu != null) {
                zza3.zzgpu.close();
            }
            zzgpl.set(zza2);
        }
    }

    private static DynamiteModule zza(Context context, String str, int i) {
        Boolean bool;
        synchronized (DynamiteModule.class) {
            bool = zzgph;
        }
        if (bool != null) {
            return bool.booleanValue() ? zzc(context, str, i) : zzb(context, str, i);
        }
        throw new zzc("Failed to determine which loading route to use.", (zza) null);
    }

    private static void zza(ClassLoader classLoader) {
        zzm zzm;
        try {
            IBinder iBinder = (IBinder) classLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(new Class[0]).newInstance(new Object[0]);
            if (iBinder == null) {
                zzm = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
                zzm = queryLocalInterface instanceof zzm ? (zzm) queryLocalInterface : new zzn(iBinder);
            }
            zzgpj = zzm;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            throw new zzc("Failed to instantiate dynamite loader", e, null);
        }
    }

    public static int zzad(Context context, String str) {
        try {
            Class<?> loadClass = context.getApplicationContext().getClassLoader().loadClass(new StringBuilder(String.valueOf("ModuleDescriptor").length() + String.valueOf("com.google.android.gms.dynamite.descriptors.").length() + 1 + String.valueOf(str).length()).append("com.google.android.gms.dynamite.descriptors.").append(str).append(".").append("ModuleDescriptor").toString());
            Field declaredField = loadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = loadClass.getDeclaredField("MODULE_VERSION");
            if (declaredField.get(null).equals(str)) {
                return declaredField2.getInt(null);
            }
            String valueOf = String.valueOf(declaredField.get(null));
            Log.e("DynamiteModule", new StringBuilder(String.valueOf(str).length() + String.valueOf(valueOf).length() + 51).append("Module descriptor id '").append(valueOf).append("' didn't match expected id '").append(str).append("'").toString());
            return 0;
        } catch (ClassNotFoundException unused) {
            Log.w("DynamiteModule", new StringBuilder(String.valueOf(str).length() + 45).append("Local module descriptor class for ").append(str).append(" not found.").toString());
            return 0;
        } catch (Exception e) {
            String valueOf2 = String.valueOf(e.getMessage());
            Log.e("DynamiteModule", valueOf2.length() != 0 ? "Failed to load module descriptor class: ".concat(valueOf2) : new String("Failed to load module descriptor class: "));
            return 0;
        }
    }

    private static DynamiteModule zzaf(Context context, String str) {
        String valueOf = String.valueOf(str);
        Log.i("DynamiteModule", valueOf.length() != 0 ? "Selected local version of ".concat(valueOf) : new String("Selected local version of "));
        return new DynamiteModule(context.getApplicationContext());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0094, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0095, code lost:
        r7 = java.lang.String.valueOf(r6);
        android.util.Log.w("DynamiteModule", new java.lang.StringBuilder(java.lang.String.valueOf(r7).length() + 30).append("Failed to load module via V2: ").append(r7).toString());
        r4 = java.lang.Boolean.FALSE;
     */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0094 A[ExcHandler: ClassNotFoundException | IllegalAccessException | NoSuchFieldException (r6v0 'e' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:39:0x0093] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int zzb(android.content.Context r14, java.lang.String r15, boolean r16) {
        /*
        // Method dump skipped, instructions count: 250
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.zzb(android.content.Context, java.lang.String, boolean):int");
    }

    private static DynamiteModule zzb(Context context, String str, int i) {
        Log.i("DynamiteModule", new StringBuilder(String.valueOf(str).length() + 51).append("Selected remote version of ").append(str).append(", version >= ").append(i).toString());
        zzk zzcv = zzcv(context);
        if (zzcv == null) {
            throw new zzc("Failed to create IDynamiteLoader.", (zza) null);
        }
        try {
            IObjectWrapper zza2 = zzcv.zza(zzn.zzw(context), str, i);
            if (zzn.zzx(zza2) != null) {
                return new DynamiteModule((Context) zzn.zzx(zza2));
            }
            throw new zzc("Failed to load remote module.", (zza) null);
        } catch (RemoteException e) {
            throw new zzc("Failed to load remote module.", e, null);
        }
    }

    private static int zzc(Context context, String str, boolean z) {
        zzk zzcv = zzcv(context);
        if (zzcv == null) {
            return 0;
        }
        try {
            return zzcv.zza(zzn.zzw(context), str, z);
        } catch (RemoteException e) {
            String valueOf = String.valueOf(e.getMessage());
            Log.w("DynamiteModule", valueOf.length() != 0 ? "Failed to retrieve remote module version: ".concat(valueOf) : new String("Failed to retrieve remote module version: "));
            return 0;
        }
    }

    private static DynamiteModule zzc(Context context, String str, int i) {
        zzm zzm;
        Log.i("DynamiteModule", new StringBuilder(String.valueOf(str).length() + 51).append("Selected remote version of ").append(str).append(", version >= ").append(i).toString());
        synchronized (DynamiteModule.class) {
            zzm = zzgpj;
        }
        if (zzm == null) {
            throw new zzc("DynamiteLoaderV2 was not cached.", (zza) null);
        }
        zza zza2 = zzgpl.get();
        if (zza2 == null || zza2.zzgpu == null) {
            throw new zzc("No result cursor", (zza) null);
        }
        Context zza3 = zza(context.getApplicationContext(), str, i, zza2.zzgpu, zzm);
        if (zza3 != null) {
            return new DynamiteModule(zza3);
        }
        throw new zzc("Failed to get module context", (zza) null);
    }

    private static zzk zzcv(Context context) {
        zzk zzk;
        synchronized (DynamiteModule.class) {
            if (zzgpi != null) {
                return zzgpi;
            } else if (zze.zzaex().isGooglePlayServicesAvailable(context) != 0) {
                return null;
            } else {
                try {
                    IBinder iBinder = (IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance();
                    if (iBinder == null) {
                        zzk = null;
                    } else {
                        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");
                        zzk = queryLocalInterface instanceof zzk ? (zzk) queryLocalInterface : new zzl(iBinder);
                    }
                    if (zzk != null) {
                        zzgpi = zzk;
                        return zzk;
                    }
                } catch (Exception e) {
                    String valueOf = String.valueOf(e.getMessage());
                    Log.e("DynamiteModule", valueOf.length() != 0 ? "Failed to load IDynamiteLoader from GmsCore: ".concat(valueOf) : new String("Failed to load IDynamiteLoader from GmsCore: "));
                }
                return null;
            }
        }
    }

    private static int zzd(Context context, String str, boolean z) {
        Cursor cursor = null;
        String str2 = z ? "api_force_staging" : "api";
        try {
            Cursor query = context.getContentResolver().query(Uri.parse(new StringBuilder(String.valueOf(str).length() + String.valueOf("content://com.google.android.gms.chimera/").length() + 1 + String.valueOf(str2).length()).append("content://com.google.android.gms.chimera/").append(str2).append("/").append(str).toString()), null, null, null, null);
            Cursor cursor2 = query;
            if (query == null || !cursor2.moveToFirst()) {
                Log.w("DynamiteModule", "Failed to retrieve remote module version.");
                throw new zzc("Failed to connect to dynamite module ContentResolver.", (zza) null);
            }
            int i = cursor2.getInt(0);
            if (i > 0) {
                synchronized (DynamiteModule.class) {
                    zzgpk = cursor2.getString(2);
                }
                zza zza2 = zzgpl.get();
                if (zza2 != null && zza2.zzgpu == null) {
                    zza2.zzgpu = cursor2;
                    cursor2 = null;
                }
            }
            if (cursor2 != null) {
                cursor2.close();
            }
            return i;
        } catch (Exception e) {
            if (e instanceof zzc) {
                throw e;
            }
            throw new zzc("V2 version check failed", e, null);
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    public final IBinder zzgv(String str) {
        try {
            return (IBinder) this.zzgpt.getClassLoader().loadClass(str).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            String valueOf = String.valueOf(str);
            throw new zzc(valueOf.length() != 0 ? "Failed to instantiate module class: ".concat(valueOf) : new String("Failed to instantiate module class: "), e, null);
        }
    }
}
