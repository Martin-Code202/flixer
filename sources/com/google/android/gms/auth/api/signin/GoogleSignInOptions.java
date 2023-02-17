package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.internal.zzn;
import com.google.android.gms.auth.api.signin.internal.zzo;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.zzbp;
import com.google.android.gms.internal.zzbck;
import com.google.android.gms.internal.zzbcn;
import com.netflix.mediaclient.acquisition.viewmodels.SignupConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
public class GoogleSignInOptions extends zzbck implements Api.ApiOptions.Optional, ReflectedParcelable {
    public static final Parcelable.Creator<GoogleSignInOptions> CREATOR = new zzd();
    public static final GoogleSignInOptions DEFAULT_GAMES_SIGN_IN = new Builder().requestScopes(SCOPE_GAMES, new Scope[0]).build();
    public static final GoogleSignInOptions DEFAULT_SIGN_IN = new Builder().requestId().requestProfile().build();
    private static Scope SCOPE_GAMES = new Scope("https://www.googleapis.com/auth/games");
    private static Comparator<Scope> zzecb = new zzc();
    public static final Scope zzecc = new Scope("profile");
    public static final Scope zzecd = new Scope(SignupConstants.Field.EMAIL);
    public static final Scope zzece = new Scope("openid");
    private int versionCode;
    private Account zzduy;
    private boolean zzeao;
    private String zzeap;
    private final ArrayList<Scope> zzecf;
    private final boolean zzecg;
    private final boolean zzech;
    private String zzeci;
    private ArrayList<zzn> zzecj;
    private Map<Integer, zzn> zzeck;

    public static final class Builder {
        private Account zzduy;
        private boolean zzeao;
        private String zzeap;
        private boolean zzecg;
        private boolean zzech;
        private String zzeci;
        private Set<Scope> zzecl = new HashSet();
        private Map<Integer, zzn> zzecm = new HashMap();

        public Builder() {
        }

        public Builder(GoogleSignInOptions googleSignInOptions) {
            zzbp.zzu(googleSignInOptions);
            this.zzecl = new HashSet(googleSignInOptions.zzecf);
            this.zzecg = googleSignInOptions.zzecg;
            this.zzech = googleSignInOptions.zzech;
            this.zzeao = googleSignInOptions.zzeao;
            this.zzeap = googleSignInOptions.zzeap;
            this.zzduy = googleSignInOptions.zzduy;
            this.zzeci = googleSignInOptions.zzeci;
            this.zzecm = GoogleSignInOptions.zzu(googleSignInOptions.zzecj);
        }

        public final GoogleSignInOptions build() {
            if (this.zzeao && (this.zzduy == null || !this.zzecl.isEmpty())) {
                requestId();
            }
            return new GoogleSignInOptions(3, new ArrayList(this.zzecl), this.zzduy, this.zzeao, this.zzecg, this.zzech, this.zzeap, this.zzeci, this.zzecm, null);
        }

        public final Builder requestId() {
            this.zzecl.add(GoogleSignInOptions.zzece);
            return this;
        }

        public final Builder requestProfile() {
            this.zzecl.add(GoogleSignInOptions.zzecc);
            return this;
        }

        public final Builder requestScopes(Scope scope, Scope... scopeArr) {
            this.zzecl.add(scope);
            this.zzecl.addAll(Arrays.asList(scopeArr));
            return this;
        }
    }

    GoogleSignInOptions(int i, ArrayList<Scope> arrayList, Account account, boolean z, boolean z2, boolean z3, String str, String str2, ArrayList<zzn> arrayList2) {
        this(i, arrayList, account, z, z2, z3, str, str2, zzu(arrayList2));
    }

    private GoogleSignInOptions(int i, ArrayList<Scope> arrayList, Account account, boolean z, boolean z2, boolean z3, String str, String str2, Map<Integer, zzn> map) {
        this.versionCode = i;
        this.zzecf = arrayList;
        this.zzduy = account;
        this.zzeao = z;
        this.zzecg = z2;
        this.zzech = z3;
        this.zzeap = str;
        this.zzeci = str2;
        this.zzecj = new ArrayList<>(map.values());
        this.zzeck = map;
    }

    /* synthetic */ GoogleSignInOptions(int i, ArrayList arrayList, Account account, boolean z, boolean z2, boolean z3, String str, String str2, Map map, zzc zzc) {
        this(3, arrayList, account, z, z2, z3, str, str2, map);
    }

    private final JSONObject toJsonObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            Collections.sort(this.zzecf, zzecb);
            ArrayList<Scope> arrayList = this.zzecf;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Scope scope = arrayList.get(i);
                i++;
                jSONArray.put(scope.zzaft());
            }
            jSONObject.put("scopes", jSONArray);
            if (this.zzduy != null) {
                jSONObject.put("accountName", this.zzduy.name);
            }
            jSONObject.put("idTokenRequested", this.zzeao);
            jSONObject.put("forceCodeForRefreshToken", this.zzech);
            jSONObject.put("serverAuthRequested", this.zzecg);
            if (!TextUtils.isEmpty(this.zzeap)) {
                jSONObject.put("serverClientId", this.zzeap);
            }
            if (!TextUtils.isEmpty(this.zzeci)) {
                jSONObject.put("hostedDomain", this.zzeci);
            }
            return jSONObject;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public static GoogleSignInOptions zzen(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("scopes");
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            hashSet.add(new Scope(jSONArray.getString(i)));
        }
        Account account = null;
        String optString = jSONObject.optString("accountName", null);
        if (!TextUtils.isEmpty(optString)) {
            account = new Account(optString, "com.google");
        }
        return new GoogleSignInOptions(3, new ArrayList(hashSet), account, jSONObject.getBoolean("idTokenRequested"), jSONObject.getBoolean("serverAuthRequested"), jSONObject.getBoolean("forceCodeForRefreshToken"), jSONObject.optString("serverClientId", null), jSONObject.optString("hostedDomain", null), new HashMap());
    }

    /* access modifiers changed from: private */
    public static Map<Integer, zzn> zzu(List<zzn> list) {
        HashMap hashMap = new HashMap();
        if (list == null) {
            return hashMap;
        }
        for (zzn zzn : list) {
            hashMap.put(Integer.valueOf(zzn.getType()), zzn);
        }
        return hashMap;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            GoogleSignInOptions googleSignInOptions = (GoogleSignInOptions) obj;
            if (this.zzecj.size() > 0 || googleSignInOptions.zzecj.size() > 0 || this.zzecf.size() != googleSignInOptions.zzaag().size() || !this.zzecf.containsAll(googleSignInOptions.zzaag())) {
                return false;
            }
            if (this.zzduy == null) {
                if (googleSignInOptions.zzduy != null) {
                    return false;
                }
            } else if (!this.zzduy.equals(googleSignInOptions.zzduy)) {
                return false;
            }
            if (TextUtils.isEmpty(this.zzeap)) {
                if (!TextUtils.isEmpty(googleSignInOptions.zzeap)) {
                    return false;
                }
            } else if (!this.zzeap.equals(googleSignInOptions.zzeap)) {
                return false;
            }
            return this.zzech == googleSignInOptions.zzech && this.zzeao == googleSignInOptions.zzeao && this.zzecg == googleSignInOptions.zzecg;
        } catch (ClassCastException unused) {
            return false;
        }
    }

    @Override // java.lang.Object
    public int hashCode() {
        ArrayList arrayList = new ArrayList();
        ArrayList<Scope> arrayList2 = this.zzecf;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Scope scope = arrayList2.get(i);
            i++;
            arrayList.add(scope.zzaft());
        }
        Collections.sort(arrayList);
        return new zzo().zzo(arrayList).zzo(this.zzduy).zzo(this.zzeap).zzaq(this.zzech).zzaq(this.zzeao).zzaq(this.zzecg).zzaao();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int zze = zzbcn.zze(parcel);
        zzbcn.zzc(parcel, 1, this.versionCode);
        zzbcn.zzc(parcel, 2, zzaag(), false);
        zzbcn.zza(parcel, 3, (Parcelable) this.zzduy, i, false);
        zzbcn.zza(parcel, 4, this.zzeao);
        zzbcn.zza(parcel, 5, this.zzecg);
        zzbcn.zza(parcel, 6, this.zzech);
        zzbcn.zza(parcel, 7, this.zzeap, false);
        zzbcn.zza(parcel, 8, this.zzeci, false);
        zzbcn.zzc(parcel, 9, this.zzecj, false);
        zzbcn.zzai(parcel, zze);
    }

    public final ArrayList<Scope> zzaag() {
        return new ArrayList<>(this.zzecf);
    }

    public final String zzaai() {
        return toJsonObject().toString();
    }
}
