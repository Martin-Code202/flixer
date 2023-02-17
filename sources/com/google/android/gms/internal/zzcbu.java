package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.zzbp;
import com.google.android.gms.common.util.zzd;
import com.google.android.gms.measurement.AppMeasurement;
public final class zzcbu extends zzcdu {
    private static String[] zzipn = new String[AppMeasurement.Event.zziki.length];
    private static String[] zzipo = new String[AppMeasurement.Param.zzikk.length];
    private static String[] zzipp = new String[AppMeasurement.UserProperty.zzikp.length];

    zzcbu(zzccw zzccw) {
        super(zzccw);
    }

    private static String zza(String str, String[] strArr, String[] strArr2, String[] strArr3) {
        String str2;
        zzbp.zzu(strArr);
        zzbp.zzu(strArr2);
        zzbp.zzu(strArr3);
        zzbp.zzbh(strArr.length == strArr2.length);
        zzbp.zzbh(strArr.length == strArr3.length);
        for (int i = 0; i < strArr.length; i++) {
            if (zzcfw.zzas(str, strArr[i])) {
                synchronized (strArr3) {
                    if (strArr3[i] == null) {
                        strArr3[i] = strArr2[i] + "(" + strArr[i] + ")";
                    }
                    str2 = strArr3[i];
                }
                return str2;
            }
        }
        return str;
    }

    private static void zza(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            sb.append("  ");
        }
    }

    private final void zza(StringBuilder sb, int i, zzcfz zzcfz) {
        if (zzcfz != null) {
            zza(sb, i);
            sb.append("filter {\n");
            zza(sb, i, "complement", zzcfz.zzixu);
            zza(sb, i, "param_name", zzjd(zzcfz.zzixv));
            int i2 = i + 1;
            zzcgc zzcgc = zzcfz.zzixs;
            if (zzcgc != null) {
                zza(sb, i2);
                sb.append("string_filter");
                sb.append(" {\n");
                if (zzcgc.zziye != null) {
                    String str = "UNKNOWN_MATCH_TYPE";
                    switch (zzcgc.zziye.intValue()) {
                        case 1:
                            str = "REGEXP";
                            break;
                        case 2:
                            str = "BEGINS_WITH";
                            break;
                        case 3:
                            str = "ENDS_WITH";
                            break;
                        case 4:
                            str = "PARTIAL";
                            break;
                        case 5:
                            str = "EXACT";
                            break;
                        case 6:
                            str = "IN_LIST";
                            break;
                    }
                    zza(sb, i2, "match_type", str);
                }
                zza(sb, i2, "expression", zzcgc.zziyf);
                zza(sb, i2, "case_sensitive", zzcgc.zziyg);
                if (zzcgc.zziyh.length > 0) {
                    zza(sb, i2 + 1);
                    sb.append("expression_list {\n");
                    String[] strArr = zzcgc.zziyh;
                    for (String str2 : strArr) {
                        zza(sb, i2 + 2);
                        sb.append(str2);
                        sb.append("\n");
                    }
                    sb.append("}\n");
                }
                zza(sb, i2);
                sb.append("}\n");
            }
            zza(sb, i + 1, "number_filter", zzcfz.zzixt);
            zza(sb, i);
            sb.append("}\n");
        }
    }

    private final void zza(StringBuilder sb, int i, String str, zzcga zzcga) {
        if (zzcga != null) {
            zza(sb, i);
            sb.append(str);
            sb.append(" {\n");
            if (zzcga.zzixw != null) {
                String str2 = "UNKNOWN_COMPARISON_TYPE";
                switch (zzcga.zzixw.intValue()) {
                    case 1:
                        str2 = "LESS_THAN";
                        break;
                    case 2:
                        str2 = "GREATER_THAN";
                        break;
                    case 3:
                        str2 = "EQUAL";
                        break;
                    case 4:
                        str2 = "BETWEEN";
                        break;
                }
                zza(sb, i, "comparison_type", str2);
            }
            zza(sb, i, "match_as_float", zzcga.zzixx);
            zza(sb, i, "comparison_value", zzcga.zzixy);
            zza(sb, i, "min_comparison_value", zzcga.zzixz);
            zza(sb, i, "max_comparison_value", zzcga.zziya);
            zza(sb, i);
            sb.append("}\n");
        }
    }

    private static void zza(StringBuilder sb, int i, String str, zzcgl zzcgl) {
        if (zzcgl != null) {
            int i2 = i + 1;
            zza(sb, i2);
            sb.append(str);
            sb.append(" {\n");
            if (zzcgl.zzjag != null) {
                zza(sb, i2 + 1);
                sb.append("results: ");
                int i3 = 0;
                for (long j : zzcgl.zzjag) {
                    Long valueOf = Long.valueOf(j);
                    i3++;
                    if (i3 != 0) {
                        sb.append(", ");
                    }
                    sb.append(valueOf);
                }
                sb.append('\n');
            }
            if (zzcgl.zzjaf != null) {
                zza(sb, i2 + 1);
                sb.append("status: ");
                int i4 = 0;
                for (long j2 : zzcgl.zzjaf) {
                    Long valueOf2 = Long.valueOf(j2);
                    i4++;
                    if (i4 != 0) {
                        sb.append(", ");
                    }
                    sb.append(valueOf2);
                }
                sb.append('\n');
            }
            zza(sb, i2);
            sb.append("}\n");
        }
    }

    private static void zza(StringBuilder sb, int i, String str, Object obj) {
        if (obj != null) {
            zza(sb, i + 1);
            sb.append(str);
            sb.append(": ");
            sb.append(obj);
            sb.append('\n');
        }
    }

    private final void zza(StringBuilder sb, int i, zzcgg[] zzcggArr) {
        if (zzcggArr != null) {
            for (zzcgg zzcgg : zzcggArr) {
                if (zzcgg != null) {
                    zza(sb, 2);
                    sb.append("audience_membership {\n");
                    zza(sb, 2, "audience_id", zzcgg.zzixi);
                    zza(sb, 2, "new_audience", zzcgg.zziyu);
                    zza(sb, 2, "current_data", zzcgg.zziys);
                    zza(sb, 2, "previous_data", zzcgg.zziyt);
                    zza(sb, 2);
                    sb.append("}\n");
                }
            }
        }
    }

    private final void zza(StringBuilder sb, int i, zzcgh[] zzcghArr) {
        if (zzcghArr != null) {
            for (zzcgh zzcgh : zzcghArr) {
                if (zzcgh != null) {
                    zza(sb, 2);
                    sb.append("event {\n");
                    zza(sb, 2, "name", zzjc(zzcgh.name));
                    zza(sb, 2, "timestamp_millis", zzcgh.zziyx);
                    zza(sb, 2, "previous_timestamp_millis", zzcgh.zziyy);
                    zza(sb, 2, "count", zzcgh.count);
                    zzcgi[] zzcgiArr = zzcgh.zziyw;
                    if (zzcgiArr != null) {
                        for (zzcgi zzcgi : zzcgiArr) {
                            if (zzcgi != null) {
                                zza(sb, 3);
                                sb.append("param {\n");
                                zza(sb, 3, "name", zzjd(zzcgi.name));
                                zza(sb, 3, "string_value", zzcgi.zzfwn);
                                zza(sb, 3, "int_value", zzcgi.zziza);
                                zza(sb, 3, "double_value", zzcgi.zzixb);
                                zza(sb, 3);
                                sb.append("}\n");
                            }
                        }
                    }
                    zza(sb, 2);
                    sb.append("}\n");
                }
            }
        }
    }

    private final void zza(StringBuilder sb, int i, zzcgm[] zzcgmArr) {
        if (zzcgmArr != null) {
            for (zzcgm zzcgm : zzcgmArr) {
                if (zzcgm != null) {
                    zza(sb, 2);
                    sb.append("user_property {\n");
                    zza(sb, 2, "set_timestamp_millis", zzcgm.zzjai);
                    zza(sb, 2, "name", zzje(zzcgm.name));
                    zza(sb, 2, "string_value", zzcgm.zzfwn);
                    zza(sb, 2, "int_value", zzcgm.zziza);
                    zza(sb, 2, "double_value", zzcgm.zzixb);
                    zza(sb, 2);
                    sb.append("}\n");
                }
            }
        }
    }

    private final boolean zzayd() {
        return this.zzikh.zzaum().zzad(3);
    }

    private final String zzb(zzcbh zzcbh) {
        if (zzcbh == null) {
            return null;
        }
        return !zzayd() ? zzcbh.toString() : zzx(zzcbh.zzaya());
    }

    @Override // com.google.android.gms.internal.zzcdt
    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    /* access modifiers changed from: protected */
    public final String zza(zzcbf zzcbf) {
        if (zzcbf == null) {
            return null;
        }
        if (!zzayd()) {
            return zzcbf.toString();
        }
        return "Event{appId='" + zzcbf.mAppId + "', name='" + zzjc(zzcbf.mName) + "', params=" + zzb(zzcbf.zzinj) + "}";
    }

    /* access modifiers changed from: protected */
    public final String zza(zzcfy zzcfy) {
        if (zzcfy == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nevent_filter {\n");
        zza(sb, 0, "filter_id", zzcfy.zzixm);
        zza(sb, 0, "event_name", zzjc(zzcfy.zzixn));
        zza(sb, 1, "event_count_filter", zzcfy.zzixq);
        sb.append("  filters {\n");
        for (zzcfz zzcfz : zzcfy.zzixo) {
            zza(sb, 2, zzcfz);
        }
        zza(sb, 1);
        sb.append("}\n}\n");
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public final String zza(zzcgb zzcgb) {
        if (zzcgb == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nproperty_filter {\n");
        zza(sb, 0, "filter_id", zzcgb.zzixm);
        zza(sb, 0, "property_name", zzje(zzcgb.zziyc));
        zza(sb, 1, zzcgb.zziyd);
        sb.append("}\n");
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public final String zza(zzcgj zzcgj) {
        StringBuilder sb = new StringBuilder();
        sb.append("\nbatch {\n");
        if (zzcgj.zzizb != null) {
            zzcgk[] zzcgkArr = zzcgj.zzizb;
            for (zzcgk zzcgk : zzcgkArr) {
                if (!(zzcgk == null || zzcgk == null)) {
                    zza(sb, 1);
                    sb.append("bundle {\n");
                    zza(sb, 1, "protocol_version", zzcgk.zzizd);
                    zza(sb, 1, "platform", zzcgk.zzizl);
                    zza(sb, 1, "gmp_version", zzcgk.zzizp);
                    zza(sb, 1, "uploading_gmp_version", zzcgk.zzizq);
                    zza(sb, 1, "config_version", zzcgk.zzjac);
                    zza(sb, 1, "gmp_app_id", zzcgk.zzilt);
                    zza(sb, 1, "app_id", zzcgk.zzch);
                    zza(sb, 1, "app_version", zzcgk.zzhts);
                    zza(sb, 1, "app_version_major", zzcgk.zzizy);
                    zza(sb, 1, "firebase_instance_id", zzcgk.zzimb);
                    zza(sb, 1, "dev_cert_hash", zzcgk.zzizu);
                    zza(sb, 1, "app_store", zzcgk.zzilu);
                    zza(sb, 1, "upload_timestamp_millis", zzcgk.zzizg);
                    zza(sb, 1, "start_timestamp_millis", zzcgk.zzizh);
                    zza(sb, 1, "end_timestamp_millis", zzcgk.zzizi);
                    zza(sb, 1, "previous_bundle_start_timestamp_millis", zzcgk.zzizj);
                    zza(sb, 1, "previous_bundle_end_timestamp_millis", zzcgk.zzizk);
                    zza(sb, 1, "app_instance_id", zzcgk.zzizt);
                    zza(sb, 1, "resettable_device_id", zzcgk.zzizr);
                    zza(sb, 1, "device_id", zzcgk.zzjab);
                    zza(sb, 1, "limited_ad_tracking", zzcgk.zzizs);
                    zza(sb, 1, "os_version", zzcgk.zzcv);
                    zza(sb, 1, "device_model", zzcgk.zzizm);
                    zza(sb, 1, "user_default_language", zzcgk.zzizn);
                    zza(sb, 1, "time_zone_offset_minutes", zzcgk.zzizo);
                    zza(sb, 1, "bundle_sequential_index", zzcgk.zzizv);
                    zza(sb, 1, "service_upload", zzcgk.zzizw);
                    zza(sb, 1, "health_monitor", zzcgk.zzilx);
                    if (zzcgk.zzjad.longValue() != 0) {
                        zza(sb, 1, "android_id", zzcgk.zzjad);
                    }
                    zza(sb, 1, zzcgk.zzizf);
                    zza(sb, 1, zzcgk.zzizx);
                    zza(sb, 1, zzcgk.zzize);
                    zza(sb, 1);
                    sb.append("}\n");
                }
            }
        }
        sb.append("}\n");
        return sb.toString();
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

    /* access modifiers changed from: protected */
    public final String zzb(zzcbk zzcbk) {
        if (zzcbk == null) {
            return null;
        }
        if (!zzayd()) {
            return zzcbk.toString();
        }
        return "origin=" + zzcbk.zzimf + ",name=" + zzjc(zzcbk.name) + ",params=" + zzb(zzcbk.zzinq);
    }

    /* access modifiers changed from: protected */
    public final String zzjc(String str) {
        if (str == null) {
            return null;
        }
        return !zzayd() ? str : zza(str, AppMeasurement.Event.zzikj, AppMeasurement.Event.zziki, zzipn);
    }

    /* access modifiers changed from: protected */
    public final String zzjd(String str) {
        if (str == null) {
            return null;
        }
        return !zzayd() ? str : zza(str, AppMeasurement.Param.zzikl, AppMeasurement.Param.zzikk, zzipo);
    }

    /* access modifiers changed from: protected */
    public final String zzje(String str) {
        if (str == null) {
            return null;
        }
        if (!zzayd()) {
            return str;
        }
        if (!str.startsWith("_exp_")) {
            return zza(str, AppMeasurement.UserProperty.zzikq, AppMeasurement.UserProperty.zzikp, zzipp);
        }
        return "experiment_id(" + str + ")";
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

    /* access modifiers changed from: protected */
    public final String zzx(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        if (!zzayd()) {
            return bundle.toString();
        }
        StringBuilder sb = new StringBuilder();
        for (String str : bundle.keySet()) {
            if (sb.length() != 0) {
                sb.append(", ");
            } else {
                sb.append("Bundle[{");
            }
            sb.append(zzjd(str));
            sb.append("=");
            sb.append(bundle.get(str));
        }
        sb.append("}]");
        return sb.toString();
    }
}
