package o;

import android.content.Context;
import com.netflix.mediaclient.repository.SecurityRepository;
import com.netflix.mediaclient.service.user.UserAgentInterface;
import com.netflix.mediaclient.util.net.AuthorizationCredentials;
import com.netflix.msl.util.MslContext;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import o.oD;
/* renamed from: o.gE  reason: case insensitive filesystem */
public class C1799gE extends C1801gG {

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private MslContext f6879;

    public C1799gE(Context context, UserAgentInterface userAgentInterface, C1805gK gKVar) {
        super(context, userAgentInterface, gKVar);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public synchronized void m6536(MslContext mslContext, boolean z) {
        if (mslContext == null) {
            throw new IllegalArgumentException("MSL Context can not be null!");
        }
        this.f6879 = mslContext;
        if (z) {
            C1283.m16854("nf_msl_store_full", "init:: force clear MSL store started.");
            m6558();
            m6553();
            C1283.m16854("nf_msl_store_full", "init:: force clear MSL store done.");
        } else {
            C1283.m16854("nf_msl_store_full", "load:: started.");
            m6532();
            m6533();
            C1283.m16854("nf_msl_store_full", "load:: done.");
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public synchronized void m6535() {
        C1283.m16854("nf_msl_store_full", "init:: force clear cookies...");
        this.f6883.clear();
        m6553();
    }

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private void m6532() {
        String r7 = C1339Bl.m4045(this.f6886, "nf_msl_store_json", (String) null);
        if (C1349Bv.m4113(r7)) {
            C1283.m16854("nf_msl_store_full", "loadMslStore:: MSL store not found...");
            return;
        }
        try {
            C0355 r8 = new C0355(r7);
            C0572 r9 = r8.m13971("cryptoContexts");
            if (r9 != null) {
                C1283.m16851("nf_msl_store_full", "loadMslStore::Crypto contexts map found, size: %d", Integer.valueOf(r9.m14673()));
                for (int i = 0; i < r9.m14673(); i++) {
                    C0355 r11 = r9.m14667(i);
                    this.f6884.put(new DV(this.f6879, m6526(r11.m13980("masterToken"))), C1803gI.m6563(this.f6879, r11.m13977("cryptoContext")));
                }
            } else {
                C1283.m16854("nf_msl_store_full", "loadMslStore::Crypto contexts map not found!");
            }
            C0572 r10 = r8.m13971("userIdTokens");
            if (r10 != null) {
                C1283.m16851("nf_msl_store_full", "loadMslStore:: UserId tokens map found, size: %d", Integer.valueOf(r10.m14673()));
                for (int i2 = 0; i2 < r10.m14673(); i2++) {
                    C0355 r12 = r10.m14667(i2);
                    this.f6889.put(r12.m13976("userId", (String) null), new C1411Eb(this.f6879, m6526(r12.m13980("userIdToken")), m6531(r12.m13973("mtSerialNumber"))));
                }
            } else {
                C1283.m16854("nf_msl_store_full", "loadMslStore:: UserId tokens map not found!");
            }
            C0572 r112 = r8.m13971("nonReplayableIds");
            if (r112 != null) {
                C1283.m16851("nf_msl_store_full", "loadMslStore:: NonReplayableId map found, size: %d", Integer.valueOf(r112.m14673()));
                for (int i3 = 0; i3 < r112.m14673(); i3++) {
                    C0355 r13 = r112.m14667(i3);
                    this.f6885.put(Long.valueOf(r13.m13973("mtSerialNumber")), Long.valueOf(r13.m13973("nonReplayableId")));
                }
            } else {
                C1283.m16854("nf_msl_store_full", "loadMslStore:: NonReplayableId map not found!");
            }
            C0572 r122 = r8.m13971("unboundServiceTokens");
            if (r122 != null) {
                for (int i4 = 0; i4 < r122.m14673(); i4++) {
                    this.f6887.add(new DU(this.f6879, m6526(r122.m14669(i4)), (DV) null, (C1411Eb) null, (AbstractC1386Dc) null));
                }
            } else {
                C1283.m16854("nf_msl_store_full", "loadMslStore:: UnboundServiceTokens set not found!");
            }
            C0572 r132 = r8.m13971("mtServiceTokens");
            ArrayList arrayList = new ArrayList();
            if (r132 != null) {
                C1283.m16851("nf_msl_store_full", "loadMslStore:: MasterTokenServiceToken map found, size: %d", Integer.valueOf(r132.m14673()));
                for (int i5 = 0; i5 < r132.m14673(); i5++) {
                    C0355 r16 = r132.m14667(i5);
                    Long valueOf = Long.valueOf(r16.m13973("mtSerialNumber"));
                    C0572 r18 = r16.m13971("serviceTokenSet");
                    HashSet hashSet = new HashSet(r18.m14673());
                    this.f6882.put(valueOf, hashSet);
                    for (int i6 = 0; i6 < r18.m14673(); i6++) {
                        C0355 r21 = r18.m14667(i6);
                        DU du = new DU(this.f6879, m6526(r21.m13980("serviceToken")), m6531(valueOf.longValue()), m6528(r21.m13982("uitSerialNumber", -1)), (AbstractC1386Dc) null);
                        hashSet.add(du);
                        if (du.m4686() && du.m4681()) {
                            arrayList.add(du);
                        }
                    }
                }
            } else {
                C1283.m16854("nf_msl_store_full", "loadMslStore:: MasterTokenServiceToken map not found!");
            }
            C0572 r15 = r8.m13971("uitServiceTokens");
            if (r15 != null) {
                C1283.m16851("nf_msl_store_full", "loadMslStore:: UserIdsServiceToken map found, size: %d", Integer.valueOf(r15.m14673()));
                for (int i7 = 0; i7 < r15.m14673(); i7++) {
                    C0355 r17 = r15.m14667(i7);
                    Long valueOf2 = Long.valueOf(r17.m13973("uitSerialNumber"));
                    C0572 r19 = r17.m13971("serviceTokenSet");
                    HashSet hashSet2 = new HashSet(r19.m14673());
                    this.f6881.put(valueOf2, hashSet2);
                    for (int i8 = 0; i8 < r19.m14673(); i8++) {
                        DU r23 = m6530(arrayList, valueOf2.longValue(), r19.m14667(i8));
                        if (r23 != null) {
                            hashSet2.add(r23);
                        }
                    }
                }
            } else {
                C1283.m16854("nf_msl_store_full", "loadMslStore:: UserIdsServiceToken map not found!");
            }
            C1283.m16854("nf_msl_store_full", "loadMslStore:: loaded.");
            m6554();
        } catch (Throwable th) {
            C1283.m16856("nf_msl_store_full", th, "loadMslStore:: Failed to load MSL store: try restore...", new Object[0]);
            m6529(r7);
        }
    }

    /* renamed from: ͺ  reason: contains not printable characters */
    private void m6533() {
        String r5 = m6534();
        if (C1349Bv.m4113(r5)) {
            C1283.m16854("nf_msl_store_full", "loadCookies:: Cookies not found...");
            return;
        }
        try {
            C1283.m16851("nf_msl_store_full", "loadCookies:: MSL store found: %s", r5);
            C0572 r6 = new C0572(r5);
            if (r6 != null) {
                C1283.m16851("nf_msl_store_full", "loadCookies:: User authorization tokens map found, size: %d", Integer.valueOf(r6.m14673()));
                for (int i = 0; i < r6.m14673(); i++) {
                    C0355 r8 = r6.m14667(i);
                    if (r8 != null) {
                        m6527(r8.m13980("userId"), r8.m13980("netflixID"), r8.m13980("secureNetflixID"));
                    }
                }
                return;
            }
            C1283.m16854("nf_msl_store_full", "loadCookies:: User authorization tokens map not found!");
        } catch (Throwable th) {
            C1283.m16856("nf_msl_store_full", th, "loadCookies:: Failed to load cookies...", new Object[0]);
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m6527(String str, String str2, String str3) {
        C1283.m16851("nf_msl_store_full", "load:: UserId %s, netflixID %s, Secure Netflix ID: %s", str, str2, str3);
        if (C1349Bv.m4113(str)) {
            C1283.m16865("nf_msl_store_full", "UserID is empty! It should NOT happen!");
        } else if (C1349Bv.m4113(str2)) {
            C1283.m16865("nf_msl_store_full", "NetflixID is empty! It should NOT happen!");
        } else if (C1349Bv.m4113(str2)) {
            C1283.m16865("nf_msl_store_full", "NetflixID is empty! It should NOT happen!");
        } else {
            this.f6883.put(str, new AuthorizationCredentials(str, str2, str3));
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m6529(String str) {
        String r5 = C1339Bl.m4045(this.f6886, "useragent_current_profile_id", (String) null);
        if (C1349Bv.m4113(r5)) {
            C1283.m16854("nf_msl_store_full", "recoverLastProfileCredentialsOnMslStoreLoadFailure::No profile ID, user is not logged in, do NOT try to recover.");
            return;
        }
        C1283.m16851("nf_msl_store_full", "recoverLastProfileCredentialsOnMslStoreLoadFailure::Current profile ID: %s, user is logged in, try to recover", r5);
        DV dv = null;
        C1411Eb eb = null;
        try {
            C0355 r8 = new C0355(str);
            C0572 r9 = r8.m13971("cryptoContexts");
            if (r9 != null) {
                C1283.m16851("nf_msl_store_full", "recoverLastProfileCredentialsOnMslStoreLoadFailure::Crypto contexts map found, size: %d", Integer.valueOf(r9.m14673()));
                for (int i = 0; i < r9.m14673(); i++) {
                    DV dv2 = new DV(this.f6879, m6526(r9.m14667(i).m13980("masterToken")));
                    if (dv == null || dv2.m4694(dv)) {
                        dv = dv2;
                    }
                }
                if (dv == null) {
                    C1283.m16850("nf_msl_store_full", "recoverLastProfileCredentialsOnMslStoreLoadFailure::Master token NOT found, can not complete restore path! Log user out!");
                    return;
                }
                C0572 r10 = r8.m13971("userIdTokens");
                if (r10 != null) {
                    C1283.m16851("nf_msl_store_full", "recoverLastProfileCredentialsOnMslStoreLoadFailure:: UserId tokens map found, size: %d", Integer.valueOf(r10.m14673()));
                    int i2 = 0;
                    while (true) {
                        if (i2 >= r10.m14673()) {
                            break;
                        }
                        C0355 r12 = r10.m14667(i2);
                        String r13 = r12.m13980("userId");
                        C1405Dv r14 = m6526(r12.m13980("userIdToken"));
                        long r15 = r12.m13973("mtSerialNumber");
                        if (dv.m4698() != r15) {
                            C1283.m16851("nf_msl_store_full", "recoverLastProfileCredentialsOnMslStoreLoadFailure:: master token serial number %d != than one found in user id token! ", Long.valueOf(dv.m4698()), Long.valueOf(r15));
                        } else if (r5.equals(r13)) {
                            eb = new C1411Eb(this.f6879, r14, dv);
                            C1283.m16851("nf_msl_store_full", "recoverLastProfileCredentialsOnMslStoreLoadFailure:: user id token found for profile %s, we should be able to attempt recovery! ", r5);
                            break;
                        }
                        i2++;
                    }
                    if (!(dv == null || eb == null)) {
                        C1283.m16851("nf_msl_store_full", "recoverLastProfileCredentialsOnMslStoreLoadFailure:: recovery data found, we will attempt recoveryfor %s ", r5);
                        this.f6888 = new oD.If(r5, dv, eb);
                        return;
                    }
                    return;
                }
                C1283.m16854("nf_msl_store_full", "recoverLastProfileCredentialsOnMslStoreLoadFailure:: UserId tokens map not found! Unable to recover, log user out!");
                return;
            }
            C1283.m16854("nf_msl_store_full", "recoverLastProfileCredentialsOnMslStoreLoadFailure::Crypto contexts map not found, can not complete restore path! Log user out!");
        } catch (Throwable th) {
            C1283.m16856("nf_msl_store_full", th, "recoverLastProfileCredentialsOnMslStoreLoadFailure:: Failed to recover authorization data from MSL store: log user out!!!", new Object[0]);
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private DV m6531(long j) {
        for (DV dv : this.f6884.keySet()) {
            if (dv != null && dv.m4698() == j) {
                return dv;
            }
        }
        return null;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private C1411Eb m6528(long j) {
        for (C1411Eb eb : this.f6889.values()) {
            if (eb != null && eb.m4868() == j) {
                return eb;
            }
        }
        return null;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private DU m6530(List<DU> list, long j, C0355 r16) {
        long r6 = r16.m13982("mtSerialNumber", -1);
        C1283.m16851("nf_msl_store_full", "Check if service token exist for given userIdToken serial number: %d and master token serial number: %d", Long.valueOf(j), Long.valueOf(r6));
        DU du = new DU(this.f6879, m6526(r16.m13980("serviceToken")), m6531(r6), m6528(j), (AbstractC1386Dc) null);
        for (DU du2 : list) {
            if (du2.equals(du)) {
                C1283.m16865("nf_msl_store_full", "Double bound service token found, use it!");
                return du2;
            }
        }
        C1283.m16865("nf_msl_store_full", "Double bound service token not found, this should not happen! Use newly created service token!");
        return du;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private C1405Dv m6526(String str) {
        return this.f6890.mo3176(C1323Aw.m3800(str));
    }

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private String m6534() {
        try {
            return SecurityRepository.getSecureStore(this.f6886);
        } catch (Throwable th) {
            C1283.m16856("nf_msl_store_full", th, "Failed to load MSL store from secure store", new Object[0]);
            return null;
        }
    }
}
