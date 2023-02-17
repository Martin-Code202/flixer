package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.internal.zzbck;
import com.google.android.gms.internal.zzbcn;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;
public final class PasswordSpecification extends zzbck implements ReflectedParcelable {
    public static final Parcelable.Creator<PasswordSpecification> CREATOR = new zzi();
    public static final PasswordSpecification zzeaw = new zza().zzi(12, 16).zzek("abcdefghijkmnopqrstxyzABCDEFGHJKLMNPQRSTXY3456789").zze("abcdefghijkmnopqrstxyz", 1).zze("ABCDEFGHJKLMNPQRSTXY", 1).zze("3456789", 1).zzaaa();
    private static PasswordSpecification zzeax = new zza().zzi(12, 16).zzek("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890").zze("abcdefghijklmnopqrstuvwxyz", 1).zze("ABCDEFGHIJKLMNOPQRSTUVWXYZ", 1).zze("1234567890", 1).zzaaa();
    private final Random zzbdr;
    private String zzeay;
    private List<String> zzeaz;
    private List<Integer> zzeba;
    private int zzebb;
    private int zzebc;
    private final int[] zzebd;

    public static class zza {
        private final List<String> zzeaz = new ArrayList();
        private final List<Integer> zzeba = new ArrayList();
        private int zzebb = 12;
        private int zzebc = 16;
        private final TreeSet<Character> zzebe = new TreeSet<>();

        private static TreeSet<Character> zzo(String str, String str2) {
            if (TextUtils.isEmpty(str)) {
                throw new zzb(String.valueOf(str2).concat(" cannot be null or empty"));
            }
            TreeSet<Character> treeSet = new TreeSet<>();
            char[] charArray = str.toCharArray();
            for (char c : charArray) {
                if (PasswordSpecification.zzc(c, 32, 126)) {
                    throw new zzb(String.valueOf(str2).concat(" must only contain ASCII printable characters"));
                }
                treeSet.add(Character.valueOf(c));
            }
            return treeSet;
        }

        public final PasswordSpecification zzaaa() {
            if (this.zzebe.isEmpty()) {
                throw new zzb("no allowed characters specified");
            }
            int i = 0;
            for (Integer num : this.zzeba) {
                i += num.intValue();
            }
            if (i > this.zzebc) {
                throw new zzb("required character count cannot be greater than the max password size");
            }
            boolean[] zArr = new boolean[95];
            for (String str : this.zzeaz) {
                char[] charArray = str.toCharArray();
                int length = charArray.length;
                int i2 = 0;
                while (true) {
                    if (i2 < length) {
                        char c = charArray[i2];
                        if (zArr[c - ' ']) {
                            throw new zzb(new StringBuilder(58).append("character ").append(c).append(" occurs in more than one required character set").toString());
                        }
                        zArr[c - ' '] = true;
                        i2++;
                    }
                }
            }
            return new PasswordSpecification(PasswordSpecification.zzb(this.zzebe), this.zzeaz, this.zzeba, this.zzebb, this.zzebc);
        }

        public final zza zze(String str, int i) {
            this.zzeaz.add(PasswordSpecification.zzb(zzo(str, "requiredChars")));
            this.zzeba.add(1);
            return this;
        }

        public final zza zzek(String str) {
            this.zzebe.addAll(zzo(str, "allowedChars"));
            return this;
        }

        public final zza zzi(int i, int i2) {
            this.zzebb = 12;
            this.zzebc = 16;
            return this;
        }
    }

    public static class zzb extends Error {
        public zzb(String str) {
            super(str);
        }
    }

    PasswordSpecification(String str, List<String> list, List<Integer> list2, int i, int i2) {
        this.zzeay = str;
        this.zzeaz = Collections.unmodifiableList(list);
        this.zzeba = Collections.unmodifiableList(list2);
        this.zzebb = i;
        this.zzebc = i2;
        int[] iArr = new int[95];
        Arrays.fill(iArr, -1);
        int i3 = 0;
        for (String str2 : this.zzeaz) {
            char[] charArray = str2.toCharArray();
            int length = charArray.length;
            for (int i4 = 0; i4 < length; i4++) {
                iArr[charArray[i4] - ' '] = i3;
            }
            i3++;
        }
        this.zzebd = iArr;
        this.zzbdr = new SecureRandom();
    }

    /* access modifiers changed from: private */
    public static String zzb(Collection<Character> collection) {
        char[] cArr = new char[collection.size()];
        int i = 0;
        for (Character ch : collection) {
            i++;
            cArr[i] = ch.charValue();
        }
        return new String(cArr);
    }

    /* access modifiers changed from: private */
    public static boolean zzc(int i, int i2, int i3) {
        return i < 32 || i > 126;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbcn.zze(parcel);
        zzbcn.zza(parcel, 1, this.zzeay, false);
        zzbcn.zzb(parcel, 2, this.zzeaz, false);
        zzbcn.zza(parcel, 3, this.zzeba, false);
        zzbcn.zzc(parcel, 4, this.zzebb);
        zzbcn.zzc(parcel, 5, this.zzebc);
        zzbcn.zzai(parcel, zze);
    }
}
