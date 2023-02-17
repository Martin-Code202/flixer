package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.zzbp;
import com.google.android.gms.common.util.zzd;
import com.google.android.gms.common.util.zzh;
import com.google.android.gms.internal.zzbck;
import com.google.android.gms.internal.zzbcn;
import com.netflix.mediaclient.acquisition.viewmodels.SignupConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
public class GoogleSignInAccount extends zzbck implements ReflectedParcelable {
    public static final Parcelable.Creator<GoogleSignInAccount> CREATOR = new zzb();
    private static zzd zzebu = zzh.zzald();
    private static Comparator<Scope> zzecb = new zza();
    private int versionCode;
    private String zzbsw;
    private List<Scope> zzdxw;
    private String zzeae;
    private String zzeaf;
    private String zzeav;
    private String zzebv;
    private String zzebw;
    private Uri zzebx;
    private String zzeby;
    private long zzebz;
    private String zzeca;

    GoogleSignInAccount(int i, String str, String str2, String str3, String str4, Uri uri, String str5, long j, String str6, List<Scope> list, String str7, String str8) {
        this.versionCode = i;
        this.zzbsw = str;
        this.zzeav = str2;
        this.zzebv = str3;
        this.zzebw = str4;
        this.zzebx = uri;
        this.zzeby = str5;
        this.zzebz = j;
        this.zzeca = str6;
        this.zzdxw = list;
        this.zzeae = str7;
        this.zzeaf = str8;
    }

    private final JSONObject toJsonObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (getId() != null) {
                jSONObject.put("id", getId());
            }
            if (getIdToken() != null) {
                jSONObject.put("tokenId", getIdToken());
            }
            if (getEmail() != null) {
                jSONObject.put(SignupConstants.Field.EMAIL, getEmail());
            }
            if (getDisplayName() != null) {
                jSONObject.put("displayName", getDisplayName());
            }
            if (getGivenName() != null) {
                jSONObject.put("givenName", getGivenName());
            }
            if (getFamilyName() != null) {
                jSONObject.put("familyName", getFamilyName());
            }
            if (getPhotoUrl() != null) {
                jSONObject.put("photoUrl", getPhotoUrl().toString());
            }
            if (getServerAuthCode() != null) {
                jSONObject.put("serverAuthCode", getServerAuthCode());
            }
            jSONObject.put("expirationTime", this.zzebz);
            jSONObject.put("obfuscatedIdentifier", this.zzeca);
            JSONArray jSONArray = new JSONArray();
            Collections.sort(this.zzdxw, zzecb);
            for (Scope scope : this.zzdxw) {
                jSONArray.put(scope.zzaft());
            }
            jSONObject.put("grantedScopes", jSONArray);
            return jSONObject;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public static GoogleSignInAccount zzem(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        Uri uri = null;
        String optString = jSONObject.optString("photoUrl", null);
        if (!TextUtils.isEmpty(optString)) {
            uri = Uri.parse(optString);
        }
        long parseLong = Long.parseLong(jSONObject.getString("expirationTime"));
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("grantedScopes");
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            hashSet.add(new Scope(jSONArray.getString(i)));
        }
        String optString2 = jSONObject.optString("id");
        String optString3 = jSONObject.optString("tokenId", null);
        String optString4 = jSONObject.optString(SignupConstants.Field.EMAIL, null);
        String optString5 = jSONObject.optString("displayName", null);
        String optString6 = jSONObject.optString("givenName", null);
        String optString7 = jSONObject.optString("familyName", null);
        Long valueOf = Long.valueOf(parseLong);
        String string = jSONObject.getString("obfuscatedIdentifier");
        if (valueOf == null) {
            valueOf = Long.valueOf(zzebu.currentTimeMillis() / 1000);
        }
        GoogleSignInAccount googleSignInAccount = new GoogleSignInAccount(3, optString2, optString3, optString4, optString5, uri, null, valueOf.longValue(), zzbp.zzgg(string), new ArrayList((Collection) zzbp.zzu(hashSet)), optString6, optString7);
        googleSignInAccount.zzeby = jSONObject.optString("serverAuthCode", null);
        return googleSignInAccount;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (!(obj instanceof GoogleSignInAccount)) {
            return false;
        }
        return ((GoogleSignInAccount) obj).toJsonObject().toString().equals(toJsonObject().toString());
    }

    public Account getAccount() {
        if (this.zzebv == null) {
            return null;
        }
        return new Account(this.zzebv, "com.google");
    }

    public String getDisplayName() {
        return this.zzebw;
    }

    public String getEmail() {
        return this.zzebv;
    }

    public String getFamilyName() {
        return this.zzeaf;
    }

    public String getGivenName() {
        return this.zzeae;
    }

    public Set<Scope> getGrantedScopes() {
        return new HashSet(this.zzdxw);
    }

    public String getId() {
        return this.zzbsw;
    }

    public String getIdToken() {
        return this.zzeav;
    }

    public Uri getPhotoUrl() {
        return this.zzebx;
    }

    public String getServerAuthCode() {
        return this.zzeby;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return toJsonObject().toString().hashCode();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int zze = zzbcn.zze(parcel);
        zzbcn.zzc(parcel, 1, this.versionCode);
        zzbcn.zza(parcel, 2, getId(), false);
        zzbcn.zza(parcel, 3, getIdToken(), false);
        zzbcn.zza(parcel, 4, getEmail(), false);
        zzbcn.zza(parcel, 5, getDisplayName(), false);
        zzbcn.zza(parcel, 6, (Parcelable) getPhotoUrl(), i, false);
        zzbcn.zza(parcel, 7, getServerAuthCode(), false);
        zzbcn.zza(parcel, 8, this.zzebz);
        zzbcn.zza(parcel, 9, this.zzeca, false);
        zzbcn.zzc(parcel, 10, this.zzdxw, false);
        zzbcn.zza(parcel, 11, getGivenName(), false);
        zzbcn.zza(parcel, 12, getFamilyName(), false);
        zzbcn.zzai(parcel, zze);
    }

    public final String zzaae() {
        return this.zzeca;
    }

    public final String zzaaf() {
        JSONObject jsonObject = toJsonObject();
        jsonObject.remove("serverAuthCode");
        return jsonObject.toString();
    }
}
