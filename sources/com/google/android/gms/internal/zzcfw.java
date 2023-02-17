package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzbp;
import com.google.android.gms.common.util.zzd;
import com.google.android.gms.measurement.AppMeasurement;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import javax.security.auth.x500.X500Principal;
public final class zzcfw extends zzcdu {
    private static String[] zzixd = {"firebase_"};
    private SecureRandom zzixe;
    private final AtomicLong zzixf = new AtomicLong(0);
    private int zzixg;

    zzcfw(zzccw zzccw) {
        super(zzccw);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x003b A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zza(java.lang.String r13, java.lang.Object r14, boolean r15) {
        /*
            r12 = this;
            if (r15 == 0) goto L_0x003e
            java.lang.String r8 = "param"
            com.google.android.gms.internal.zzcax.zzavt()
            r10 = r14
            r9 = r13
            r7 = r12
            boolean r0 = r10 instanceof android.os.Parcelable[]
            if (r0 == 0) goto L_0x0013
            r0 = r10
            android.os.Parcelable[] r0 = (android.os.Parcelable[]) r0
            int r11 = r0.length
            goto L_0x0021
        L_0x0013:
            boolean r0 = r10 instanceof java.util.ArrayList
            if (r0 == 0) goto L_0x001f
            r0 = r10
            java.util.ArrayList r0 = (java.util.ArrayList) r0
            int r11 = r0.size()
            goto L_0x0021
        L_0x001f:
            r0 = 1
            goto L_0x0039
        L_0x0021:
            r0 = 1000(0x3e8, float:1.401E-42)
            if (r11 <= r0) goto L_0x0038
            com.google.android.gms.internal.zzcbw r0 = r7.zzaum()
            com.google.android.gms.internal.zzcby r0 = r0.zzayg()
            java.lang.String r1 = "Parameter array is too long; discarded. Value kind, name, array length"
            java.lang.Integer r2 = java.lang.Integer.valueOf(r11)
            r0.zzd(r1, r8, r9, r2)
            r0 = 0
            goto L_0x0039
        L_0x0038:
            r0 = 1
        L_0x0039:
            if (r0 != 0) goto L_0x003e
            r0 = 17
            return r0
        L_0x003e:
            boolean r0 = zzkd(r13)
            if (r0 == 0) goto L_0x0053
            r0 = r12
            java.lang.String r1 = "param"
            r2 = r13
            int r3 = com.google.android.gms.internal.zzcax.zzavs()
            r4 = r14
            r5 = r15
            boolean r6 = r0.zza(r1, r2, r3, r4, r5)
            goto L_0x0061
        L_0x0053:
            r0 = r12
            java.lang.String r1 = "param"
            r2 = r13
            int r3 = com.google.android.gms.internal.zzcax.zzavr()
            r4 = r14
            r5 = r15
            boolean r6 = r0.zza(r1, r2, r3, r4, r5)
        L_0x0061:
            if (r6 == 0) goto L_0x0065
            r0 = 0
            return r0
        L_0x0065:
            r0 = 4
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcfw.zza(java.lang.String, java.lang.Object, boolean):int");
    }

    private static Object zza(int i, Object obj, boolean z) {
        if (obj == null) {
            return null;
        }
        if ((obj instanceof Long) || (obj instanceof Double)) {
            return obj;
        }
        if (obj instanceof Integer) {
            return Long.valueOf((long) ((Integer) obj).intValue());
        }
        if (obj instanceof Byte) {
            return Long.valueOf((long) ((Byte) obj).byteValue());
        }
        if (obj instanceof Short) {
            return Long.valueOf((long) ((Short) obj).shortValue());
        }
        if (obj instanceof Boolean) {
            return Long.valueOf(((Boolean) obj).booleanValue() ? 1 : 0);
        } else if (obj instanceof Float) {
            return Double.valueOf(((Float) obj).doubleValue());
        } else {
            if ((obj instanceof String) || (obj instanceof Character) || (obj instanceof CharSequence)) {
                return zza(String.valueOf(obj), i, z);
            }
            return null;
        }
    }

    public static String zza(String str, int i, boolean z) {
        if (str.codePointCount(0, str.length()) <= i) {
            return str;
        }
        if (z) {
            return String.valueOf(str.substring(0, str.offsetByCodePoints(0, i))).concat("...");
        }
        return null;
    }

    public static String zza(String str, String[] strArr, String[] strArr2) {
        zzbp.zzu(strArr);
        zzbp.zzu(strArr2);
        int min = Math.min(strArr.length, strArr2.length);
        for (int i = 0; i < min; i++) {
            if (zzas(str, strArr[i])) {
                return strArr2[i];
            }
        }
        return null;
    }

    public static boolean zza(Context context, String str, boolean z) {
        ActivityInfo receiverInfo;
        try {
            PackageManager packageManager = context.getPackageManager();
            return (packageManager == null || (receiverInfo = packageManager.getReceiverInfo(new ComponentName(context, str), 2)) == null || !receiverInfo.enabled) ? false : true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    private final boolean zza(String str, String str2, int i, Object obj, boolean z) {
        if (obj == null || (obj instanceof Long) || (obj instanceof Float) || (obj instanceof Integer) || (obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Boolean) || (obj instanceof Double)) {
            return true;
        }
        if ((obj instanceof String) || (obj instanceof Character) || (obj instanceof CharSequence)) {
            String valueOf = String.valueOf(obj);
            if (valueOf.codePointCount(0, valueOf.length()) <= i) {
                return true;
            }
            zzaum().zzayg().zzd("Value is too long; discarded. Value kind, name, value length", str, str2, Integer.valueOf(valueOf.length()));
            return false;
        } else if ((obj instanceof Bundle) && z) {
            return true;
        } else {
            if ((obj instanceof Parcelable[]) && z) {
                Parcelable[] parcelableArr = (Parcelable[]) obj;
                for (Parcelable parcelable : parcelableArr) {
                    if (!(parcelable instanceof Bundle)) {
                        zzaum().zzayg().zze("All Parcelable[] elements must be of type Bundle. Value type, name", parcelable.getClass(), str2);
                        return false;
                    }
                }
                return true;
            } else if (!(obj instanceof ArrayList) || !z) {
                return false;
            } else {
                ArrayList arrayList = (ArrayList) obj;
                int size = arrayList.size();
                int i2 = 0;
                while (i2 < size) {
                    Object obj2 = arrayList.get(i2);
                    i2++;
                    if (!(obj2 instanceof Bundle)) {
                        zzaum().zzayg().zze("All ArrayList elements must be of type Bundle. Value type, name", obj2.getClass(), str2);
                        return false;
                    }
                }
                return true;
            }
        }
    }

    private final boolean zza(String str, String[] strArr, String str2) {
        boolean z;
        boolean z2;
        if (str2 == null) {
            zzaum().zzaye().zzj("Name is required and can't be null. Type", str);
            return false;
        }
        zzbp.zzu(str2);
        int i = 0;
        while (true) {
            if (i >= zzixd.length) {
                z = false;
                break;
            } else if (str2.startsWith(zzixd[i])) {
                z = true;
                break;
            } else {
                i++;
            }
        }
        if (z) {
            zzaum().zzaye().zze("Name starts with reserved prefix. Type, name", str, str2);
            return false;
        } else if (strArr == null) {
            return true;
        } else {
            zzbp.zzu(strArr);
            int i2 = 0;
            while (true) {
                if (i2 >= strArr.length) {
                    z2 = false;
                    break;
                } else if (zzas(str2, strArr[i2])) {
                    z2 = true;
                    break;
                } else {
                    i2++;
                }
            }
            if (!z2) {
                return true;
            }
            zzaum().zzaye().zze("Name is reserved. Type, name", str, str2);
            return false;
        }
    }

    public static boolean zza(long[] jArr, int i) {
        return i < (jArr.length << 6) && (jArr[i / 64] & (1 << (i % 64))) != 0;
    }

    static byte[] zza(Parcelable parcelable) {
        if (parcelable == null) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        try {
            parcelable.writeToParcel(obtain, 0);
            return obtain.marshall();
        } finally {
            obtain.recycle();
        }
    }

    public static long[] zza(BitSet bitSet) {
        int length = (bitSet.length() + 63) / 64;
        long[] jArr = new long[length];
        int i = 0;
        while (i < length) {
            jArr[i] = 0;
            int i2 = 0;
            while (i2 < 64 && (i << 6) + i2 < bitSet.length()) {
                if (bitSet.get((i << 6) + i2)) {
                    jArr[i] = jArr[i] | (1 << i2);
                }
                i2++;
            }
            i++;
        }
        return jArr;
    }

    public static Bundle[] zzac(Object obj) {
        if (obj instanceof Bundle) {
            return new Bundle[]{(Bundle) obj};
        }
        if (obj instanceof Parcelable[]) {
            return (Bundle[]) Arrays.copyOf((Parcelable[]) obj, ((Parcelable[]) obj).length, Bundle[].class);
        }
        if (!(obj instanceof ArrayList)) {
            return null;
        }
        ArrayList arrayList = (ArrayList) obj;
        return (Bundle[]) arrayList.toArray(new Bundle[arrayList.size()]);
    }

    public static Object zzad(Object obj) {
        if (obj == null) {
            return null;
        }
        ObjectOutputStream objectOutputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream = objectOutputStream2;
            objectOutputStream2.writeObject(obj);
            objectOutputStream.flush();
            ObjectInputStream objectInputStream2 = new ObjectInputStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
            objectInputStream = objectInputStream2;
            Object readObject = objectInputStream2.readObject();
            objectOutputStream.close();
            objectInputStream.close();
            return readObject;
        } catch (IOException | ClassNotFoundException unused) {
            return null;
        } catch (Throwable th) {
            if (objectOutputStream != null) {
                objectOutputStream.close();
            }
            if (objectInputStream != null) {
                objectInputStream.close();
            }
            throw th;
        }
    }

    private final boolean zzai(Context context, String str) {
        X500Principal x500Principal = new X500Principal("CN=Android Debug,O=Android,C=US");
        try {
            PackageInfo packageInfo = zzbed.zzcr(context).getPackageInfo(str, 64);
            if (packageInfo == null || packageInfo.signatures == null || packageInfo.signatures.length <= 0) {
                return true;
            }
            return ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(packageInfo.signatures[0].toByteArray()))).getSubjectX500Principal().equals(x500Principal);
        } catch (CertificateException e) {
            zzaum().zzaye().zzj("Error obtaining certificate", e);
            return true;
        } catch (PackageManager.NameNotFoundException e2) {
            zzaum().zzaye().zzj("Package name not found", e2);
            return true;
        }
    }

    private final boolean zzaq(String str, String str2) {
        if (str2 == null) {
            zzaum().zzaye().zzj("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.length() == 0) {
            zzaum().zzaye().zzj("Name is required and can't be empty. Type", str);
            return false;
        } else {
            int codePointAt = str2.codePointAt(0);
            if (!Character.isLetter(codePointAt)) {
                zzaum().zzaye().zze("Name must start with a letter. Type, name", str, str2);
                return false;
            }
            int length = str2.length();
            int charCount = Character.charCount(codePointAt);
            while (charCount < length) {
                int codePointAt2 = str2.codePointAt(charCount);
                if (codePointAt2 == 95 || Character.isLetterOrDigit(codePointAt2)) {
                    charCount += Character.charCount(codePointAt2);
                } else {
                    zzaum().zzaye().zze("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                    return false;
                }
            }
            return true;
        }
    }

    private final boolean zzar(String str, String str2) {
        if (str2 == null) {
            zzaum().zzaye().zzj("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.length() == 0) {
            zzaum().zzaye().zzj("Name is required and can't be empty. Type", str);
            return false;
        } else {
            int codePointAt = str2.codePointAt(0);
            if (Character.isLetter(codePointAt) || codePointAt == 95) {
                int length = str2.length();
                int charCount = Character.charCount(codePointAt);
                while (charCount < length) {
                    int codePointAt2 = str2.codePointAt(charCount);
                    if (codePointAt2 == 95 || Character.isLetterOrDigit(codePointAt2)) {
                        charCount += Character.charCount(codePointAt2);
                    } else {
                        zzaum().zzaye().zze("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                        return false;
                    }
                }
                return true;
            }
            zzaum().zzaye().zze("Name must start with a letter or _ (underscore). Type, name", str, str2);
            return false;
        }
    }

    public static boolean zzas(String str, String str2) {
        if (str == null && str2 == null) {
            return true;
        }
        if (str == null) {
            return false;
        }
        return str.equals(str2);
    }

    private static void zzb(Bundle bundle, Object obj) {
        zzbp.zzu(bundle);
        if (obj == null) {
            return;
        }
        if ((obj instanceof String) || (obj instanceof CharSequence)) {
            bundle.putLong("_el", (long) String.valueOf(obj).length());
        }
    }

    private final boolean zzb(String str, int i, String str2) {
        if (str2 == null) {
            zzaum().zzaye().zzj("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.codePointCount(0, str2.length()) <= i) {
            return true;
        } else {
            zzaum().zzaye().zzd("Name is too long. Type, maximum supported length, name", str, Integer.valueOf(i), str2);
            return false;
        }
    }

    private static boolean zzd(Bundle bundle, int i) {
        if (bundle.getLong("_err") != 0) {
            return false;
        }
        bundle.putLong("_err", (long) i);
        return true;
    }

    static boolean zzd(zzcbk zzcbk, zzcas zzcas) {
        zzbp.zzu(zzcbk);
        zzbp.zzu(zzcas);
        if (!TextUtils.isEmpty(zzcas.zzilt)) {
            return true;
        }
        zzcax.zzawl();
        return false;
    }

    static MessageDigest zzec(String str) {
        for (int i = 0; i < 2; i++) {
            try {
                MessageDigest instance = MessageDigest.getInstance(str);
                if (instance != null) {
                    return instance;
                }
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        return null;
    }

    static boolean zzju(String str) {
        zzbp.zzgg(str);
        return str.charAt(0) != '_' || str.equals("_ep");
    }

    private final int zzjz(String str) {
        if (!zzaq("event param", str)) {
            return 3;
        }
        if (!zza("event param", (String[]) null, str)) {
            return 14;
        }
        return !zzb("event param", zzcax.zzavq(), str) ? 3 : 0;
    }

    private final int zzka(String str) {
        if (!zzar("event param", str)) {
            return 3;
        }
        if (!zza("event param", (String[]) null, str)) {
            return 14;
        }
        return !zzb("event param", zzcax.zzavq(), str) ? 3 : 0;
    }

    private static int zzkc(String str) {
        return "_ldl".equals(str) ? zzcax.zzavv() : zzcax.zzavu();
    }

    public static boolean zzkd(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("_");
    }

    static boolean zzkf(String str) {
        return str != null && str.matches("(\\+|-)?([0-9]+\\.?[0-9]*|[0-9]*\\.?[0-9]+)") && str.length() <= 310;
    }

    static boolean zzki(String str) {
        zzbp.zzgg(str);
        char c = 65535;
        switch (str.hashCode()) {
            case 94660:
                if (str.equals("_in")) {
                    c = 0;
                    break;
                }
                break;
            case 95025:
                if (str.equals("_ug")) {
                    c = 2;
                    break;
                }
                break;
            case 95027:
                if (str.equals("_ui")) {
                    c = 1;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 1:
            case 2:
                return true;
            default:
                return false;
        }
    }

    public static boolean zzl(Intent intent) {
        String stringExtra = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
        return "android-app://com.google.android.googlequicksearchbox/https/www.google.com".equals(stringExtra) || "https://www.google.com".equals(stringExtra) || "android-app://com.google.appcrawler".equals(stringExtra);
    }

    static long zzq(byte[] bArr) {
        zzbp.zzu(bArr);
        zzbp.zzbg(bArr.length > 0);
        long j = 0;
        int i = 0;
        int length = bArr.length - 1;
        while (length >= 0 && length >= bArr.length - 8) {
            j += (((long) bArr[length]) & 255) << i;
            i += 8;
            length--;
        }
        return j;
    }

    public static boolean zzv(Context context, String str) {
        ServiceInfo serviceInfo;
        try {
            PackageManager packageManager = context.getPackageManager();
            return (packageManager == null || (serviceInfo = packageManager.getServiceInfo(new ComponentName(context, str), 4)) == null || !serviceInfo.enabled) ? false : true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    public final Bundle zza(String str, Bundle bundle, List<String> list, boolean z, boolean z2) {
        Bundle bundle2 = null;
        if (bundle != null) {
            bundle2 = new Bundle(bundle);
            int i = 0;
            zzcax.zzavn();
            for (String str2 : bundle.keySet()) {
                int i2 = 0;
                if (list == null || !list.contains(str2)) {
                    if (z) {
                        i2 = zzjz(str2);
                    }
                    if (i2 == 0) {
                        i2 = zzka(str2);
                    }
                }
                if (i2 != 0) {
                    if (zzd(bundle2, i2)) {
                        bundle2.putString("_ev", zza(str2, zzcax.zzavq(), true));
                        if (i2 == 3) {
                            zzb(bundle2, str2);
                        }
                    }
                    bundle2.remove(str2);
                } else {
                    int zza = zza(str2, bundle.get(str2), z2);
                    if (zza != 0 && !"_ev".equals(str2)) {
                        if (zzd(bundle2, zza)) {
                            bundle2.putString("_ev", zza(str2, zzcax.zzavq(), true));
                            zzb(bundle2, bundle.get(str2));
                        }
                        bundle2.remove(str2);
                    } else if (zzju(str2) && (i = i + 1) > 25) {
                        zzaum().zzaye().zze(new StringBuilder(48).append("Event can't contain more then 25 params").toString(), zzauh().zzjc(str), zzauh().zzx(bundle));
                        zzd(bundle2, 5);
                        bundle2.remove(str2);
                    }
                }
            }
        }
        return bundle2;
    }

    /* access modifiers changed from: package-private */
    public final zzcbk zza(String str, Bundle bundle, String str2, long j, boolean z, boolean z2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (zzjw(str) != 0) {
            zzaum().zzaye().zzj("Invalid conditional property event name", zzauh().zzje(str));
            throw new IllegalArgumentException();
        }
        Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
        bundle2.putString("_o", str2);
        return new zzcbk(str, new zzcbh(zzy(zza(str, bundle2, Collections.singletonList("_o"), false, false))), str2, j);
    }

    public final void zza(int i, String str, String str2, int i2) {
        zza((String) null, i, str, str2, i2);
    }

    public final void zza(Bundle bundle, String str, Object obj) {
        if (bundle != null) {
            if (obj instanceof Long) {
                bundle.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof String) {
                bundle.putString(str, String.valueOf(obj));
            } else if (obj instanceof Double) {
                bundle.putDouble(str, ((Double) obj).doubleValue());
            } else if (str != null) {
                zzaum().zzayh().zze("Not putting event parameter. Invalid value type. name, type", zzauh().zzjd(str), obj != null ? obj.getClass().getSimpleName() : null);
            }
        }
    }

    public final void zza(zzcgi zzcgi, Object obj) {
        zzbp.zzu(obj);
        zzcgi.zzfwn = null;
        zzcgi.zziza = null;
        zzcgi.zzixb = null;
        if (obj instanceof String) {
            zzcgi.zzfwn = (String) obj;
        } else if (obj instanceof Long) {
            zzcgi.zziza = (Long) obj;
        } else if (obj instanceof Double) {
            zzcgi.zzixb = (Double) obj;
        } else {
            zzaum().zzaye().zzj("Ignoring invalid (type) event param value", obj);
        }
    }

    public final void zza(zzcgm zzcgm, Object obj) {
        zzbp.zzu(obj);
        zzcgm.zzfwn = null;
        zzcgm.zziza = null;
        zzcgm.zzixb = null;
        if (obj instanceof String) {
            zzcgm.zzfwn = (String) obj;
        } else if (obj instanceof Long) {
            zzcgm.zziza = (Long) obj;
        } else if (obj instanceof Double) {
            zzcgm.zzixb = (Double) obj;
        } else {
            zzaum().zzaye().zzj("Ignoring invalid (type) user attribute value", obj);
        }
    }

    public final void zza(String str, int i, String str2, String str3, int i2) {
        Bundle bundle = new Bundle();
        zzd(bundle, i);
        if (!TextUtils.isEmpty(str2)) {
            bundle.putString(str2, str3);
        }
        if (i == 6 || i == 7 || i == 2) {
            bundle.putLong("_el", (long) i2);
        }
        zzcax.zzawl();
        this.zzikh.zzaua().zzc("auto", "_err", bundle);
    }

    /* access modifiers changed from: package-private */
    public final long zzah(Context context, String str) {
        zzuj();
        zzbp.zzu(context);
        zzbp.zzgg(str);
        PackageManager packageManager = context.getPackageManager();
        MessageDigest zzec = zzec("MD5");
        if (zzec == null) {
            zzaum().zzaye().log("Could not get MD5 instance");
            return -1;
        } else if (packageManager == null) {
            return 0;
        } else {
            try {
                if (zzai(context, str)) {
                    return 0;
                }
                PackageInfo packageInfo = zzbed.zzcr(context).getPackageInfo(getContext().getPackageName(), 64);
                if (packageInfo.signatures != null && packageInfo.signatures.length > 0) {
                    return zzq(zzec.digest(packageInfo.signatures[0].toByteArray()));
                }
                zzaum().zzayg().log("Could not get signatures");
                return -1;
            } catch (PackageManager.NameNotFoundException e) {
                zzaum().zzaye().zzj("Package name not found", e);
                return 0;
            }
        }
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ void zzatv() {
        super.zzatv();
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ void zzatw() {
        super.zzatw();
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ void zzatx() {
        super.zzatx();
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ zzcan zzaty() {
        return super.zzaty();
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ zzcau zzatz() {
        return super.zzatz();
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ zzcdw zzaua() {
        return super.zzaua();
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ zzcbr zzaub() {
        return super.zzaub();
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ zzcbe zzauc() {
        return super.zzauc();
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ zzceo zzaud() {
        return super.zzaud();
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ zzcek zzaue() {
        return super.zzaue();
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ zzcbs zzauf() {
        return super.zzauf();
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ zzcay zzaug() {
        return super.zzaug();
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ zzcbu zzauh() {
        return super.zzauh();
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ zzcfw zzaui() {
        return super.zzaui();
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ zzccq zzauj() {
        return super.zzauj();
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ zzcfl zzauk() {
        return super.zzauk();
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ zzccr zzaul() {
        return super.zzaul();
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ zzcbw zzaum() {
        return super.zzaum();
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ zzcch zzaun() {
        return super.zzaun();
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ zzcax zzauo() {
        return super.zzauo();
    }

    public final long zzazy() {
        long andIncrement;
        long j;
        if (this.zzixf.get() == 0) {
            synchronized (this.zzixf) {
                long nextLong = new Random(System.nanoTime() ^ zzvx().currentTimeMillis()).nextLong();
                int i = this.zzixg + 1;
                this.zzixg = i;
                j = nextLong + ((long) i);
            }
            return j;
        }
        synchronized (this.zzixf) {
            this.zzixf.compareAndSet(-1, 1);
            andIncrement = this.zzixf.getAndIncrement();
        }
        return andIncrement;
    }

    /* access modifiers changed from: package-private */
    public final SecureRandom zzazz() {
        zzuj();
        if (this.zzixe == null) {
            this.zzixe = new SecureRandom();
        }
        return this.zzixe;
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: package-private */
    public final <T extends Parcelable> T zzb(byte[] bArr, Parcelable.Creator<T> creator) {
        if (bArr == null) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        try {
            obtain.unmarshall(bArr, 0, bArr.length);
            obtain.setDataPosition(0);
            T createFromParcel = creator.createFromParcel(obtain);
            obtain.recycle();
            return createFromParcel;
        } catch (zzbcm unused) {
            zzaum().zzaye().log("Failed to load parcelable from buffer");
            obtain.recycle();
            return null;
        } catch (Throwable th) {
            obtain.recycle();
            throw th;
        }
    }

    public final byte[] zzb(zzcgj zzcgj) {
        try {
            byte[] bArr = new byte[zzcgj.zzhi()];
            zzegy zzi = zzegy.zzi(bArr, 0, bArr.length);
            zzcgj.zza(zzi);
            zzi.zzccm();
            return bArr;
        } catch (IOException e) {
            zzaum().zzaye().zzj("Data loss. Failed to serialize batch", e);
            return null;
        }
    }

    public final boolean zzdt(String str) {
        zzuj();
        if (zzbed.zzcr(getContext()).checkCallingOrSelfPermission(str) == 0) {
            return true;
        }
        zzaum().zzayj().zzj("Permission not granted", str);
        return false;
    }

    public final boolean zzf(long j, long j2) {
        return j == 0 || j2 <= 0 || Math.abs(zzvx().currentTimeMillis() - j) > j2;
    }

    public final int zzjw(String str) {
        if (!zzar("event", str)) {
            return 2;
        }
        if (!zza("event", AppMeasurement.Event.zziki, str)) {
            return 13;
        }
        return !zzb("event", zzcax.zzavo(), str) ? 2 : 0;
    }

    public final int zzjy(String str) {
        if (!zzar("user property", str)) {
            return 6;
        }
        if (!zza("user property", AppMeasurement.UserProperty.zzikp, str)) {
            return 15;
        }
        return !zzb("user property", zzcax.zzavp(), str) ? 6 : 0;
    }

    public final Object zzk(String str, Object obj) {
        if ("_ev".equals(str)) {
            return zza(zzcax.zzavs(), obj, true);
        }
        return zza(zzkd(str) ? zzcax.zzavs() : zzcax.zzavr(), obj, false);
    }

    public final boolean zzkb(String str) {
        if (TextUtils.isEmpty(str)) {
            zzaum().zzaye().log("Missing google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI");
            return false;
        }
        zzbp.zzu(str);
        if (str.matches("^1:\\d+:android:[a-f0-9]+$")) {
            return true;
        }
        zzaum().zzaye().zzj("Invalid google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI. provided id", str);
        return false;
    }

    public final boolean zzke(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String zzaxh = zzauo().zzaxh();
        zzcax.zzawl();
        return zzaxh.equals(str);
    }

    /* access modifiers changed from: package-private */
    public final boolean zzkg(String str) {
        return "1".equals(zzauj().zzan(str, "measurement.upload.blacklist_internal"));
    }

    /* access modifiers changed from: package-private */
    public final boolean zzkh(String str) {
        return "1".equals(zzauj().zzan(str, "measurement.upload.blacklist_public"));
    }

    public final int zzl(String str, Object obj) {
        return "_ldl".equals(str) ? zza("user property referrer", str, zzkc(str), obj, false) : zza("user property", str, zzkc(str), obj, false) ? 0 : 7;
    }

    public final Object zzm(String str, Object obj) {
        return "_ldl".equals(str) ? zza(zzkc(str), obj, true) : zza(zzkc(str), obj, false);
    }

    public final byte[] zzo(byte[] bArr) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            zzaum().zzaye().zzj("Failed to gzip content", e);
            throw e;
        }
    }

    public final Bundle zzp(Uri uri) {
        if (uri == null) {
            return null;
        }
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        try {
            if (uri.isHierarchical()) {
                str = uri.getQueryParameter("utm_campaign");
                str2 = uri.getQueryParameter("utm_source");
                str3 = uri.getQueryParameter("utm_medium");
                str4 = uri.getQueryParameter("gclid");
            }
            if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3) && TextUtils.isEmpty(str4)) {
                return null;
            }
            Bundle bundle = new Bundle();
            if (!TextUtils.isEmpty(str)) {
                bundle.putString("campaign", str);
            }
            if (!TextUtils.isEmpty(str2)) {
                bundle.putString(NetflixActivity.EXTRA_SOURCE, str2);
            }
            if (!TextUtils.isEmpty(str3)) {
                bundle.putString("medium", str3);
            }
            if (!TextUtils.isEmpty(str4)) {
                bundle.putString("gclid", str4);
            }
            String queryParameter = uri.getQueryParameter("utm_term");
            if (!TextUtils.isEmpty(queryParameter)) {
                bundle.putString("term", queryParameter);
            }
            String queryParameter2 = uri.getQueryParameter("utm_content");
            if (!TextUtils.isEmpty(queryParameter2)) {
                bundle.putString("content", queryParameter2);
            }
            String queryParameter3 = uri.getQueryParameter("aclid");
            if (!TextUtils.isEmpty(queryParameter3)) {
                bundle.putString("aclid", queryParameter3);
            }
            String queryParameter4 = uri.getQueryParameter("cp1");
            if (!TextUtils.isEmpty(queryParameter4)) {
                bundle.putString("cp1", queryParameter4);
            }
            String queryParameter5 = uri.getQueryParameter("anid");
            if (!TextUtils.isEmpty(queryParameter5)) {
                bundle.putString("anid", queryParameter5);
            }
            return bundle;
        } catch (UnsupportedOperationException e) {
            zzaum().zzayg().zzj("Install referrer url isn't a hierarchical URI", e);
            return null;
        }
    }

    public final byte[] zzp(byte[] bArr) {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr2 = new byte[1024];
            while (true) {
                int read = gZIPInputStream.read(bArr2);
                if (read > 0) {
                    byteArrayOutputStream.write(bArr2, 0, read);
                } else {
                    gZIPInputStream.close();
                    byteArrayInputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (IOException e) {
            zzaum().zzaye().zzj("Failed to ungzip content", e);
            throw e;
        }
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ void zzuj() {
        super.zzuj();
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzcdu
    public final void zzuk() {
        SecureRandom secureRandom = new SecureRandom();
        long nextLong = secureRandom.nextLong();
        long j = nextLong;
        if (nextLong == 0) {
            long nextLong2 = secureRandom.nextLong();
            j = nextLong2;
            if (nextLong2 == 0) {
                zzaum().zzayg().log("Utils falling back to Random for random id");
            }
        }
        this.zzixf.set(j);
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ zzd zzvx() {
        return super.zzvx();
    }

    /* access modifiers changed from: package-private */
    public final Bundle zzy(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                Object zzk = zzk(str, bundle.get(str));
                if (zzk == null) {
                    zzaum().zzayg().zzj("Param value can't be null", zzauh().zzjd(str));
                } else {
                    zza(bundle2, str, zzk);
                }
            }
        }
        return bundle2;
    }
}
