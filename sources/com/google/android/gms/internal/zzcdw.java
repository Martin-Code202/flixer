package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzbp;
import com.google.android.gms.common.util.zzd;
import com.google.android.gms.measurement.AppMeasurement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicReference;
public final class zzcdw extends zzcdu {
    protected zzcej zzius;
    private AppMeasurement.EventInterceptor zziut;
    private final Set<AppMeasurement.OnEventListener> zziuu = new CopyOnWriteArraySet();
    private boolean zziuv;
    private final AtomicReference<String> zziuw = new AtomicReference<>();

    protected zzcdw(zzccw zzccw) {
        super(zzccw);
    }

    public static int getMaxUserProperties(String str) {
        zzbp.zzgg(str);
        return zzcax.zzawb();
    }

    private final void zza(AppMeasurement.ConditionalUserProperty conditionalUserProperty) {
        long currentTimeMillis = zzvx().currentTimeMillis();
        zzbp.zzu(conditionalUserProperty);
        zzbp.zzgg(conditionalUserProperty.mName);
        zzbp.zzgg(conditionalUserProperty.mOrigin);
        zzbp.zzu(conditionalUserProperty.mValue);
        conditionalUserProperty.mCreationTimestamp = currentTimeMillis;
        String str = conditionalUserProperty.mName;
        Object obj = conditionalUserProperty.mValue;
        if (zzaui().zzjy(str) != 0) {
            zzaum().zzaye().zzj("Invalid conditional user property name", zzauh().zzje(str));
        } else if (zzaui().zzl(str, obj) != 0) {
            zzaum().zzaye().zze("Invalid conditional user property value", zzauh().zzje(str), obj);
        } else {
            Object zzm = zzaui().zzm(str, obj);
            if (zzm == null) {
                zzaum().zzaye().zze("Unable to normalize conditional user property value", zzauh().zzje(str), obj);
                return;
            }
            conditionalUserProperty.mValue = zzm;
            long j = conditionalUserProperty.mTriggerTimeout;
            if (TextUtils.isEmpty(conditionalUserProperty.mTriggerEventName) || (j <= zzcax.zzawd() && j >= 1)) {
                long j2 = conditionalUserProperty.mTimeToLive;
                if (j2 > zzcax.zzawe() || j2 < 1) {
                    zzaum().zzaye().zze("Invalid conditional user property time to live", zzauh().zzje(str), Long.valueOf(j2));
                } else {
                    zzaul().zzg(new zzcdy(this, conditionalUserProperty));
                }
            } else {
                zzaum().zzaye().zze("Invalid conditional user property timeout", zzauh().zzje(str), Long.valueOf(j));
            }
        }
    }

    private final void zza(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        Bundle bundle2;
        if (bundle == null) {
            bundle2 = new Bundle();
        } else {
            Bundle bundle3 = new Bundle(bundle);
            for (String str4 : bundle3.keySet()) {
                Object obj = bundle3.get(str4);
                if (obj instanceof Bundle) {
                    bundle3.putBundle(str4, new Bundle((Bundle) obj));
                } else if (obj instanceof Parcelable[]) {
                    Parcelable[] parcelableArr = (Parcelable[]) obj;
                    for (int i = 0; i < parcelableArr.length; i++) {
                        if (parcelableArr[i] instanceof Bundle) {
                            parcelableArr[i] = new Bundle((Bundle) parcelableArr[i]);
                        }
                    }
                } else if (obj instanceof ArrayList) {
                    ArrayList arrayList = (ArrayList) obj;
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        Object obj2 = arrayList.get(i2);
                        if (obj2 instanceof Bundle) {
                            arrayList.set(i2, new Bundle((Bundle) obj2));
                        }
                    }
                }
            }
            bundle2 = bundle3;
        }
        zzaul().zzg(new zzcee(this, str, str2, j, bundle2, z, z2, z3, str3));
    }

    private final void zza(String str, String str2, long j, Object obj) {
        zzaul().zzg(new zzcef(this, str, str2, obj, j));
    }

    private final void zza(String str, String str2, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        zza(str, str2, zzvx().currentTimeMillis(), bundle, true, z2, z3, null);
    }

    /* access modifiers changed from: private */
    public final void zza(String str, String str2, Object obj, long j) {
        zzbp.zzgg(str);
        zzbp.zzgg(str2);
        zzuj();
        zzatw();
        zzwk();
        if (!this.zzikh.isEnabled()) {
            zzaum().zzayj().log("User property not set since app measurement is disabled");
        } else if (this.zzikh.zzayw()) {
            zzaum().zzayj().zze("Setting user property (FE)", zzauh().zzjc(str2), obj);
            zzaud().zzb(new zzcft(str2, j, obj, str));
        }
    }

    private final void zza(String str, String str2, String str3, Bundle bundle) {
        long currentTimeMillis = zzvx().currentTimeMillis();
        zzbp.zzgg(str2);
        AppMeasurement.ConditionalUserProperty conditionalUserProperty = new AppMeasurement.ConditionalUserProperty();
        conditionalUserProperty.mAppId = str;
        conditionalUserProperty.mName = str2;
        conditionalUserProperty.mCreationTimestamp = currentTimeMillis;
        if (str3 != null) {
            conditionalUserProperty.mExpiredEventName = str3;
            conditionalUserProperty.mExpiredEventParams = bundle;
        }
        zzaul().zzg(new zzcdz(this, conditionalUserProperty));
    }

    private final Map<String, Object> zzb(String str, String str2, String str3, boolean z) {
        if (zzaul().zzayt()) {
            zzaum().zzaye().log("Cannot get user properties from analytics worker thread");
            return Collections.emptyMap();
        }
        zzaul();
        if (zzccr.zzaq()) {
            zzaum().zzaye().log("Cannot get user properties from main thread");
            return Collections.emptyMap();
        }
        AtomicReference atomicReference = new AtomicReference();
        synchronized (atomicReference) {
            this.zzikh.zzaul().zzg(new zzceb(this, atomicReference, str, str2, str3, z));
            try {
                atomicReference.wait(5000);
            } catch (InterruptedException e) {
                zzaum().zzayg().zzj("Interrupted waiting for get user properties", e);
            }
        }
        List<zzcft> list = (List) atomicReference.get();
        if (list == null) {
            zzaum().zzayg().log("Timed out waiting for get user properties");
            return Collections.emptyMap();
        }
        ArrayMap arrayMap = new ArrayMap(list.size());
        for (zzcft zzcft : list) {
            arrayMap.put(zzcft.name, zzcft.getValue());
        }
        return arrayMap;
    }

    /* access modifiers changed from: private */
    public final void zzb(AppMeasurement.ConditionalUserProperty conditionalUserProperty) {
        zzuj();
        zzwk();
        zzbp.zzu(conditionalUserProperty);
        zzbp.zzgg(conditionalUserProperty.mName);
        zzbp.zzgg(conditionalUserProperty.mOrigin);
        zzbp.zzu(conditionalUserProperty.mValue);
        if (!this.zzikh.isEnabled()) {
            zzaum().zzayj().log("Conditional property not sent since Firebase Analytics is disabled");
            return;
        }
        zzcft zzcft = new zzcft(conditionalUserProperty.mName, conditionalUserProperty.mTriggeredTimestamp, conditionalUserProperty.mValue, conditionalUserProperty.mOrigin);
        try {
            zzcbk zza = zzaui().zza(conditionalUserProperty.mTriggeredEventName, conditionalUserProperty.mTriggeredEventParams, conditionalUserProperty.mOrigin, 0, true, false);
            zzaud().zzf(new zzcav(conditionalUserProperty.mAppId, conditionalUserProperty.mOrigin, zzcft, conditionalUserProperty.mCreationTimestamp, false, conditionalUserProperty.mTriggerEventName, zzaui().zza(conditionalUserProperty.mTimedOutEventName, conditionalUserProperty.mTimedOutEventParams, conditionalUserProperty.mOrigin, 0, true, false), conditionalUserProperty.mTriggerTimeout, zza, conditionalUserProperty.mTimeToLive, zzaui().zza(conditionalUserProperty.mExpiredEventName, conditionalUserProperty.mExpiredEventParams, conditionalUserProperty.mOrigin, 0, true, false)));
        } catch (IllegalArgumentException unused) {
        }
    }

    /* access modifiers changed from: private */
    public final void zzb(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        zzbp.zzgg(str);
        zzbp.zzgg(str2);
        zzbp.zzu(bundle);
        zzuj();
        zzwk();
        if (!this.zzikh.isEnabled()) {
            zzaum().zzayj().log("Event not sent since app measurement is disabled");
            return;
        }
        if (!this.zziuv) {
            this.zziuv = true;
            try {
                try {
                    Class.forName("com.google.android.gms.tagmanager.TagManagerService").getDeclaredMethod("initialize", Context.class).invoke(null, getContext());
                } catch (Exception e) {
                    zzaum().zzayg().zzj("Failed to invoke Tag Manager's initialize() method", e);
                }
            } catch (ClassNotFoundException unused) {
                zzaum().zzayi().log("Tag Manager is not found and thus will not be used");
            }
        }
        boolean equals = "am".equals(str);
        boolean zzkd = zzcfw.zzkd(str2);
        if (z && this.zziut != null && !zzkd && !equals) {
            zzaum().zzayj().zze("Passing event to registered event handler (FE)", zzauh().zzjc(str2), zzauh().zzx(bundle));
            this.zziut.interceptEvent(str, str2, bundle, j);
        } else if (this.zzikh.zzayw()) {
            int zzjw = zzaui().zzjw(str2);
            if (zzjw != 0) {
                zzaui();
                this.zzikh.zzaui().zza(str3, zzjw, "_ev", zzcfw.zza(str2, zzcax.zzavo(), true), str2 != null ? str2.length() : 0);
                return;
            }
            List<String> singletonList = Collections.singletonList("_o");
            Bundle zza = zzaui().zza(str2, bundle, singletonList, z3, true);
            ArrayList arrayList = new ArrayList();
            arrayList.add(zza);
            long nextLong = zzaui().zzazz().nextLong();
            int i = 0;
            String[] strArr = (String[]) zza.keySet().toArray(new String[bundle.size()]);
            Arrays.sort(strArr);
            int length = strArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                String str4 = strArr[i2];
                Object obj = zza.get(str4);
                zzaui();
                Bundle[] zzac = zzcfw.zzac(obj);
                if (zzac != null) {
                    zza.putInt(str4, zzac.length);
                    for (int i3 = 0; i3 < zzac.length; i3++) {
                        Bundle zza2 = zzaui().zza("_ep", zzac[i3], singletonList, z3, false);
                        zza2.putString("_en", str2);
                        zza2.putLong("_eid", nextLong);
                        zza2.putString("_gn", str4);
                        zza2.putInt("_ll", zzac.length);
                        zza2.putInt("_i", i3);
                        arrayList.add(zza2);
                    }
                    i += zzac.length;
                }
            }
            if (i != 0) {
                zza.putLong("_eid", nextLong);
                zza.putInt("_epc", i);
            }
            zzcax.zzawl();
            zzcen zzazo = zzaue().zzazo();
            if (zzazo != null && !zza.containsKey("_sc")) {
                zzazo.zzivw = true;
            }
            int i4 = 0;
            while (i4 < arrayList.size()) {
                Bundle bundle2 = (Bundle) arrayList.get(i4);
                String str5 = i4 != 0 ? "_ep" : str2;
                bundle2.putString("_o", str);
                if (!bundle2.containsKey("_sc")) {
                    zzcek.zza(zzazo, bundle2);
                }
                Bundle zzy = z2 ? zzaui().zzy(bundle2) : bundle2;
                zzaum().zzayj().zze("Logging event (FE)", zzauh().zzjc(str2), zzauh().zzx(zzy));
                zzaud().zzc(new zzcbk(str5, new zzcbh(zzy), str, j), str3);
                if (!equals) {
                    for (AppMeasurement.OnEventListener onEventListener : this.zziuu) {
                        onEventListener.onEvent(str, str2, new Bundle(zzy), j);
                    }
                }
                i4++;
            }
            zzcax.zzawl();
            if (zzaue().zzazo() != null && "_ae".equals(str2)) {
                zzauk().zzbs(true);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void zzbp(boolean z) {
        zzuj();
        zzatw();
        zzwk();
        zzaum().zzayj().zzj("Setting app measurement enabled (FE)", Boolean.valueOf(z));
        zzaun().setMeasurementEnabled(z);
        zzaud().zzazq();
    }

    /* access modifiers changed from: private */
    public final void zzc(AppMeasurement.ConditionalUserProperty conditionalUserProperty) {
        zzuj();
        zzwk();
        zzbp.zzu(conditionalUserProperty);
        zzbp.zzgg(conditionalUserProperty.mName);
        if (!this.zzikh.isEnabled()) {
            zzaum().zzayj().log("Conditional property not cleared since Firebase Analytics is disabled");
            return;
        }
        try {
            zzaud().zzf(new zzcav(conditionalUserProperty.mAppId, conditionalUserProperty.mOrigin, new zzcft(conditionalUserProperty.mName, 0, null, null), conditionalUserProperty.mCreationTimestamp, conditionalUserProperty.mActive, conditionalUserProperty.mTriggerEventName, null, conditionalUserProperty.mTriggerTimeout, null, conditionalUserProperty.mTimeToLive, zzaui().zza(conditionalUserProperty.mExpiredEventName, conditionalUserProperty.mExpiredEventParams, conditionalUserProperty.mOrigin, conditionalUserProperty.mCreationTimestamp, true, false)));
        } catch (IllegalArgumentException unused) {
        }
    }

    private final List<AppMeasurement.ConditionalUserProperty> zzk(String str, String str2, String str3) {
        if (zzaul().zzayt()) {
            zzaum().zzaye().log("Cannot get conditional user properties from analytics worker thread");
            return Collections.emptyList();
        }
        zzaul();
        if (zzccr.zzaq()) {
            zzaum().zzaye().log("Cannot get conditional user properties from main thread");
            return Collections.emptyList();
        }
        AtomicReference atomicReference = new AtomicReference();
        synchronized (atomicReference) {
            this.zzikh.zzaul().zzg(new zzcea(this, atomicReference, str, str2, str3));
            try {
                atomicReference.wait(5000);
            } catch (InterruptedException e) {
                zzaum().zzayg().zze("Interrupted waiting for get conditional user properties", str, e);
            }
        }
        List<zzcav> list = (List) atomicReference.get();
        if (list == null) {
            zzaum().zzayg().zzj("Timed out waiting for get conditional user properties", str);
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (zzcav zzcav : list) {
            AppMeasurement.ConditionalUserProperty conditionalUserProperty = new AppMeasurement.ConditionalUserProperty();
            conditionalUserProperty.mAppId = str;
            conditionalUserProperty.mOrigin = str2;
            conditionalUserProperty.mCreationTimestamp = zzcav.zzimh;
            conditionalUserProperty.mName = zzcav.zzimg.name;
            conditionalUserProperty.mValue = zzcav.zzimg.getValue();
            conditionalUserProperty.mActive = zzcav.zzimi;
            conditionalUserProperty.mTriggerEventName = zzcav.zzimj;
            if (zzcav.zzimk != null) {
                conditionalUserProperty.mTimedOutEventName = zzcav.zzimk.name;
                if (zzcav.zzimk.zzinq != null) {
                    conditionalUserProperty.mTimedOutEventParams = zzcav.zzimk.zzinq.zzaya();
                }
            }
            conditionalUserProperty.mTriggerTimeout = zzcav.zziml;
            if (zzcav.zzimm != null) {
                conditionalUserProperty.mTriggeredEventName = zzcav.zzimm.name;
                if (zzcav.zzimm.zzinq != null) {
                    conditionalUserProperty.mTriggeredEventParams = zzcav.zzimm.zzinq.zzaya();
                }
            }
            conditionalUserProperty.mTriggeredTimestamp = zzcav.zzimg.zziwy;
            conditionalUserProperty.mTimeToLive = zzcav.zzimn;
            if (zzcav.zzimo != null) {
                conditionalUserProperty.mExpiredEventName = zzcav.zzimo.name;
                if (zzcav.zzimo.zzinq != null) {
                    conditionalUserProperty.mExpiredEventParams = zzcav.zzimo.zzinq.zzaya();
                }
            }
            arrayList.add(conditionalUserProperty);
        }
        return arrayList;
    }

    public final void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        zzatw();
        zza((String) null, str, str2, bundle);
    }

    public final void clearConditionalUserPropertyAs(String str, String str2, String str3, Bundle bundle) {
        zzbp.zzgg(str);
        zzatv();
        zza(str, str2, str3, bundle);
    }

    public final List<AppMeasurement.ConditionalUserProperty> getConditionalUserProperties(String str, String str2) {
        zzatw();
        return zzk(null, str, str2);
    }

    public final List<AppMeasurement.ConditionalUserProperty> getConditionalUserPropertiesAs(String str, String str2, String str3) {
        zzbp.zzgg(str);
        zzatv();
        return zzk(str, str2, str3);
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    public final Map<String, Object> getUserProperties(String str, String str2, boolean z) {
        zzatw();
        return zzb(null, str, str2, z);
    }

    public final Map<String, Object> getUserPropertiesAs(String str, String str2, String str3, boolean z) {
        zzbp.zzgg(str);
        zzatv();
        return zzb(str, str2, str3, z);
    }

    public final void setConditionalUserProperty(AppMeasurement.ConditionalUserProperty conditionalUserProperty) {
        zzbp.zzu(conditionalUserProperty);
        zzatw();
        AppMeasurement.ConditionalUserProperty conditionalUserProperty2 = new AppMeasurement.ConditionalUserProperty(conditionalUserProperty);
        if (!TextUtils.isEmpty(conditionalUserProperty2.mAppId)) {
            zzaum().zzayg().log("Package name should be null when calling setConditionalUserProperty");
        }
        conditionalUserProperty2.mAppId = null;
        zza(conditionalUserProperty2);
    }

    public final void setConditionalUserPropertyAs(AppMeasurement.ConditionalUserProperty conditionalUserProperty) {
        zzbp.zzu(conditionalUserProperty);
        zzbp.zzgg(conditionalUserProperty.mAppId);
        zzatv();
        zza(new AppMeasurement.ConditionalUserProperty(conditionalUserProperty));
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

    public final String zzayo() {
        zzatw();
        return this.zziuw.get();
    }

    public final void zzb(String str, String str2, Object obj) {
        zzbp.zzgg(str);
        long currentTimeMillis = zzvx().currentTimeMillis();
        int zzjy = zzaui().zzjy(str2);
        if (zzjy != 0) {
            zzaui();
            this.zzikh.zzaui().zza(zzjy, "_ev", zzcfw.zza(str2, zzcax.zzavp(), true), str2 != null ? str2.length() : 0);
        } else if (obj != null) {
            int zzl = zzaui().zzl(str2, obj);
            if (zzl != 0) {
                zzaui();
                String zza = zzcfw.zza(str2, zzcax.zzavp(), true);
                int i = 0;
                if ((obj instanceof String) || (obj instanceof CharSequence)) {
                    i = String.valueOf(obj).length();
                }
                this.zzikh.zzaui().zza(zzl, "_ev", zza, i);
                return;
            }
            Object zzm = zzaui().zzm(str2, obj);
            if (zzm != null) {
                zza(str, str2, currentTimeMillis, zzm);
            }
        } else {
            zza(str, str2, currentTimeMillis, (Object) null);
        }
    }

    public final void zzc(String str, String str2, Bundle bundle) {
        zzatw();
        zza(str, str2, bundle, true, this.zziut == null || zzcfw.zzkd(str2), false, null);
    }

    /* access modifiers changed from: package-private */
    public final void zzjk(String str) {
        this.zziuw.set(str);
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ void zzuj() {
        super.zzuj();
    }

    /* access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzcdu
    public final void zzuk() {
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ zzd zzvx() {
        return super.zzvx();
    }
}
