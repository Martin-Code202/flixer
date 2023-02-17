package com.google.android.gms.analytics;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.analytics.ecommerce.Product;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.android.gms.common.internal.zzbp;
import com.google.android.gms.internal.zzalv;
import com.google.android.gms.internal.zzalw;
import com.google.android.gms.internal.zzalx;
import com.google.android.gms.internal.zzaly;
import com.google.android.gms.internal.zzalz;
import com.google.android.gms.internal.zzama;
import com.google.android.gms.internal.zzamb;
import com.google.android.gms.internal.zzamc;
import com.google.android.gms.internal.zzamd;
import com.google.android.gms.internal.zzame;
import com.google.android.gms.internal.zzamf;
import com.google.android.gms.internal.zzamg;
import com.google.android.gms.internal.zzamh;
import com.google.android.gms.internal.zzamr;
import com.google.android.gms.internal.zzamt;
import com.google.android.gms.internal.zzamu;
import com.google.android.gms.internal.zzamx;
import com.google.android.gms.internal.zzaoi;
import com.google.android.gms.internal.zzapd;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public final class zzb extends zzamr implements zzm {
    private static DecimalFormat zzdjm;
    private final zzamu zzdji;
    private final String zzdjn;
    private final Uri zzdjo;

    public zzb(zzamu zzamu, String str) {
        this(zzamu, str, true, false);
    }

    private zzb(zzamu zzamu, String str, boolean z, boolean z2) {
        super(zzamu);
        zzbp.zzgg(str);
        this.zzdji = zzamu;
        this.zzdjn = str;
        this.zzdjo = zzcx(this.zzdjn);
    }

    private static void zza(Map<String, String> map, String str, double d) {
        if (d != 0.0d) {
            map.put(str, zzb(d));
        }
    }

    private static void zza(Map<String, String> map, String str, int i, int i2) {
        if (i > 0 && i2 > 0) {
            map.put(str, new StringBuilder(23).append(i).append("x").append(i2).toString());
        }
    }

    private static void zza(Map<String, String> map, String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            map.put(str, str2);
        }
    }

    private static String zzb(double d) {
        if (zzdjm == null) {
            zzdjm = new DecimalFormat("0.######");
        }
        return zzdjm.format(d);
    }

    private static void zzb(Map<String, String> map, String str, boolean z) {
        if (z) {
            map.put(str, "1");
        }
    }

    private static Map<String, String> zzc(zzg zzg) {
        String str;
        HashMap hashMap = new HashMap();
        zzalz zzalz = (zzalz) zzg.zza(zzalz.class);
        if (zzalz != null) {
            for (Map.Entry<String, Object> entry : zzalz.zzuy().entrySet()) {
                Object value = entry.getValue();
                if (value == null) {
                    str = null;
                } else if (value instanceof String) {
                    String str2 = (String) value;
                    str = !TextUtils.isEmpty(str2) ? str2 : null;
                } else if (value instanceof Double) {
                    Double d = (Double) value;
                    str = d.doubleValue() != 0.0d ? zzb(d.doubleValue()) : null;
                } else {
                    str = value instanceof Boolean ? value != Boolean.FALSE ? "1" : null : String.valueOf(value);
                }
                if (str != null) {
                    hashMap.put(entry.getKey(), str);
                }
            }
        }
        zzame zzame = (zzame) zzg.zza(zzame.class);
        if (zzame != null) {
            zza(hashMap, "t", zzame.zzvd());
            zza(hashMap, "cid", zzame.zzve());
            zza(hashMap, "uid", zzame.getUserId());
            zza(hashMap, "sc", zzame.zzvh());
            zza(hashMap, "sf", zzame.zzvj());
            zzb(hashMap, "ni", zzame.zzvi());
            zza(hashMap, "adid", zzame.zzvf());
            zzb(hashMap, "ate", zzame.zzvg());
        }
        zzamf zzamf = (zzamf) zzg.zza(zzamf.class);
        if (zzamf != null) {
            zza(hashMap, "cd", zzamf.zzvk());
            zza(hashMap, "a", (double) zzamf.zzvl());
            zza(hashMap, "dr", zzamf.zzvm());
        }
        zzamc zzamc = (zzamc) zzg.zza(zzamc.class);
        if (zzamc != null) {
            zza(hashMap, "ec", zzamc.getCategory());
            zza(hashMap, "ea", zzamc.getAction());
            zza(hashMap, "el", zzamc.getLabel());
            zza(hashMap, "ev", (double) zzamc.getValue());
        }
        zzalw zzalw = (zzalw) zzg.zza(zzalw.class);
        if (zzalw != null) {
            zza(hashMap, "cn", zzalw.getName());
            zza(hashMap, "cs", zzalw.getSource());
            zza(hashMap, "cm", zzalw.zzuq());
            zza(hashMap, "ck", zzalw.zzur());
            zza(hashMap, "cc", zzalw.getContent());
            zza(hashMap, "ci", zzalw.getId());
            zza(hashMap, "anid", zzalw.zzus());
            zza(hashMap, "gclid", zzalw.zzut());
            zza(hashMap, "dclid", zzalw.zzuu());
            zza(hashMap, "aclid", zzalw.zzuv());
        }
        zzamd zzamd = (zzamd) zzg.zza(zzamd.class);
        if (zzamd != null) {
            zza(hashMap, "exd", zzamd.zzdmt);
            zzb(hashMap, "exf", zzamd.zzdmu);
        }
        zzamg zzamg = (zzamg) zzg.zza(zzamg.class);
        if (zzamg != null) {
            zza(hashMap, "sn", zzamg.zzdnj);
            zza(hashMap, "sa", zzamg.zzdmq);
            zza(hashMap, "st", zzamg.zzdnk);
        }
        zzamh zzamh = (zzamh) zzg.zza(zzamh.class);
        if (zzamh != null) {
            zza(hashMap, "utv", zzamh.zzdnl);
            zza(hashMap, "utt", (double) zzamh.zzdnm);
            zza(hashMap, "utc", zzamh.mCategory);
            zza(hashMap, "utl", zzamh.zzdmr);
        }
        zzalx zzalx = (zzalx) zzg.zza(zzalx.class);
        if (zzalx != null) {
            for (Map.Entry<Integer, String> entry2 : zzalx.zzuw().entrySet()) {
                String zzah = zzd.zzah(entry2.getKey().intValue());
                if (!TextUtils.isEmpty(zzah)) {
                    hashMap.put(zzah, entry2.getValue());
                }
            }
        }
        zzaly zzaly = (zzaly) zzg.zza(zzaly.class);
        if (zzaly != null) {
            for (Map.Entry<Integer, Double> entry3 : zzaly.zzux().entrySet()) {
                String zzaj = zzd.zzaj(entry3.getKey().intValue());
                if (!TextUtils.isEmpty(zzaj)) {
                    hashMap.put(zzaj, zzb(entry3.getValue().doubleValue()));
                }
            }
        }
        zzamb zzamb = (zzamb) zzg.zza(zzamb.class);
        if (zzamb != null) {
            ProductAction zzuz = zzamb.zzuz();
            if (zzuz != null) {
                for (Map.Entry<String, String> entry4 : zzuz.build().entrySet()) {
                    if (entry4.getKey().startsWith("&")) {
                        hashMap.put(entry4.getKey().substring(1), entry4.getValue());
                    } else {
                        hashMap.put(entry4.getKey(), entry4.getValue());
                    }
                }
            }
            int i = 1;
            for (Promotion promotion : zzamb.zzvc()) {
                hashMap.putAll(promotion.zzdj(zzd.zzan(i)));
                i++;
            }
            int i2 = 1;
            for (Product product : zzamb.zzva()) {
                hashMap.putAll(product.zzdj(zzd.zzal(i2)));
                i2++;
            }
            int i3 = 1;
            for (Map.Entry<String, List<Product>> entry5 : zzamb.zzvb().entrySet()) {
                String zzaq = zzd.zzaq(i3);
                int i4 = 1;
                for (Product product2 : entry5.getValue()) {
                    String valueOf = String.valueOf(zzaq);
                    String valueOf2 = String.valueOf(zzd.zzao(i4));
                    hashMap.putAll(product2.zzdj(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf)));
                    i4++;
                }
                if (!TextUtils.isEmpty(entry5.getKey())) {
                    String valueOf3 = String.valueOf(zzaq);
                    String valueOf4 = String.valueOf("nm");
                    hashMap.put(valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3), entry5.getKey());
                }
                i3++;
            }
        }
        zzama zzama = (zzama) zzg.zza(zzama.class);
        if (zzama != null) {
            zza(hashMap, "ul", zzama.getLanguage());
            zza(hashMap, "sd", (double) zzama.zzdmn);
            zza(hashMap, "sr", zzama.zzcet, zzama.zzceu);
            zza(hashMap, "vp", zzama.zzdmo, zzama.zzdmp);
        }
        zzalv zzalv = (zzalv) zzg.zza(zzalv.class);
        if (zzalv != null) {
            zza(hashMap, "an", zzalv.zzun());
            zza(hashMap, "aid", zzalv.getAppId());
            zza(hashMap, "aiid", zzalv.zzup());
            zza(hashMap, "av", zzalv.zzuo());
        }
        return hashMap;
    }

    static Uri zzcx(String str) {
        zzbp.zzgg(str);
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("uri");
        builder.authority("google-analytics.com");
        builder.path(str);
        return builder.build();
    }

    @Override // com.google.android.gms.analytics.zzm
    public final void zzb(zzg zzg) {
        zzbp.zzu(zzg);
        zzbp.zzb(zzg.zzub(), "Can't deliver not submitted measurement");
        zzbp.zzgh("deliver should be called on worker thread");
        zzg zztx = zzg.zztx();
        zzame zzame = (zzame) zztx.zzb(zzame.class);
        if (TextUtils.isEmpty(zzame.zzvd())) {
            zzvy().zze(zzc(zztx), "Ignoring measurement without type");
        } else if (TextUtils.isEmpty(zzame.zzve())) {
            zzvy().zze(zzc(zztx), "Ignoring measurement without client id");
        } else if (!this.zzdji.zzwn().getAppOptOut()) {
            double zzvj = zzame.zzvj();
            if (zzapd.zza(zzvj, zzame.zzve())) {
                zzb("Sampling enabled. Hit sampled out. sampling rate", Double.valueOf(zzvj));
                return;
            }
            Map<String, String> zzc = zzc(zztx);
            zzc.put("v", "1");
            zzc.put("_v", zzamt.zzdoe);
            zzc.put("tid", this.zzdjn);
            if (this.zzdji.zzwn().isDryRunEnabled()) {
                StringBuilder sb = new StringBuilder();
                for (Map.Entry<String, String> entry : zzc.entrySet()) {
                    if (sb.length() != 0) {
                        sb.append(", ");
                    }
                    sb.append(entry.getKey());
                    sb.append("=");
                    sb.append(entry.getValue());
                }
                zzc("Dry run is enabled. GoogleAnalytics would have sent", sb.toString());
                return;
            }
            HashMap hashMap = new HashMap();
            zzapd.zzb(hashMap, "uid", zzame.getUserId());
            zzalv zzalv = (zzalv) zzg.zza(zzalv.class);
            if (zzalv != null) {
                zzapd.zzb(hashMap, "an", zzalv.zzun());
                zzapd.zzb(hashMap, "aid", zzalv.getAppId());
                zzapd.zzb(hashMap, "av", zzalv.zzuo());
                zzapd.zzb(hashMap, "aiid", zzalv.zzup());
            }
            zzc.put("_s", String.valueOf(zzwc().zza(new zzamx(0, zzame.zzve(), this.zzdjn, !TextUtils.isEmpty(zzame.zzvf()), 0, hashMap))));
            zzwc().zza(new zzaoi(zzvy(), zzc, zzg.zztz(), true));
        }
    }

    @Override // com.google.android.gms.analytics.zzm
    public final Uri zztu() {
        return this.zzdjo;
    }
}
