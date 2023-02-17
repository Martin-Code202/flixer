package com.netflix.mediaclient.service.user;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Pair;
import com.netflix.cl.Logger;
import com.netflix.mediaclient.NetflixApplication;
import com.netflix.mediaclient.StatusCode;
import com.netflix.mediaclient.android.app.NetflixStatus;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.media.BookmarkStore;
import com.netflix.mediaclient.service.logging.client.model.Device;
import com.netflix.mediaclient.service.logging.client.model.Error;
import com.netflix.mediaclient.service.logging.client.model.RootCause;
import com.netflix.mediaclient.service.user.UserAgentInterface;
import com.netflix.mediaclient.service.webclient.model.leafs.AccountData;
import com.netflix.mediaclient.service.webclient.model.leafs.AvatarInfo;
import com.netflix.mediaclient.service.webclient.model.leafs.ConfigData;
import com.netflix.mediaclient.service.webclient.model.leafs.EogAlert;
import com.netflix.mediaclient.service.webclient.model.leafs.NonMemberData;
import com.netflix.mediaclient.service.webclient.model.leafs.SignInData;
import com.netflix.mediaclient.service.webclient.model.leafs.SubtitlePreference;
import com.netflix.mediaclient.service.webclient.model.leafs.UmaAlert;
import com.netflix.mediaclient.service.webclient.model.leafs.User;
import com.netflix.mediaclient.service.webclient.model.leafs.UserProfile;
import com.netflix.mediaclient.servicemgr.AdvertiserIdLogging;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.SignInLogging;
import com.netflix.mediaclient.util.ConnectivityUtils;
import com.netflix.mediaclient.util.net.AuthorizationCredentials;
import com.netflix.model.leafs.OnRampEligibility;
import com.netflix.msl.MslException;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import o.AY;
import o.AbstractApplicationC1258;
import o.AbstractC0367;
import o.AbstractC1052;
import o.AbstractC1221;
import o.AbstractC1250;
import o.AbstractC1412Ec;
import o.AbstractC2016nt;
import o.AbstractC2021ny;
import o.AbstractC2022nz;
import o.AbstractC2031og;
import o.AbstractC2089qj;
import o.BZ;
import o.C0452;
import o.C0614;
import o.C0962;
import o.C1005;
import o.C1061;
import o.C1198;
import o.C1223;
import o.C1272;
import o.C1279;
import o.C1283;
import o.C1338Bk;
import o.C1339Bl;
import o.C1343Bp;
import o.C1349Bv;
import o.C1363Ci;
import o.C1376Cs;
import o.C1413Ed;
import o.C2018nv;
import o.C2019nw;
import o.C2020nx;
import o.CL;
import o.DY;
import o.DZ;
import o.nD;
import o.nH;
import o.nJ;
import o.nW;
import o.oD;
import o.oR;
import org.json.JSONException;
public class UserAgent extends AbstractC1052 implements UserAgentInterface {

    /* renamed from: ʻ  reason: contains not printable characters */
    private List<UserProfile> f2196;

    /* renamed from: ʼ  reason: contains not printable characters */
    private boolean f2197;

    /* renamed from: ʽ  reason: contains not printable characters */
    private Status f2198 = AbstractC0367.f13235;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final BookmarkStore f2199;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private C0023 f2200 = new C0023();

    /* renamed from: ˋ  reason: contains not printable characters */
    private AbstractC2021ny f2201;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private nW f2202;

    /* renamed from: ˎ  reason: contains not printable characters */
    private C2020nx f2203;

    /* renamed from: ˏ  reason: contains not printable characters */
    private User f2204;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private boolean f2205;

    /* renamed from: ͺ  reason: contains not printable characters */
    private SubtitlePreference f2206;

    /* renamed from: ॱ  reason: contains not printable characters */
    private Context f2207;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private SubtitlePreference f2208;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private If f2209;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private UserProfile f2210;

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private final AbstractC2022nz f2211 = new AbstractC2016nt() { // from class: com.netflix.mediaclient.service.user.UserAgent.8
        @Override // o.AbstractC2016nt, o.AbstractC2022nz
        /* renamed from: ˋ  reason: contains not printable characters */
        public void mo1409(AccountData accountData, Status status) {
            if (!status.mo298() || accountData == null) {
                C1283.m16850("nf_service_useragent", "Updating user profiles failed with statusCode=" + status.mo302());
                return;
            }
            List<UserProfile> userProfiles = accountData.getUserProfiles();
            C1283.m16851("nf_service_useragent", "onUserProfilesUpdated got profiles: %d", Integer.valueOf(userProfiles.size()));
            UserAgent.this.m1306(userProfiles);
            if (UserAgent.this.f2210 != null) {
                for (UserProfile userProfile : userProfiles) {
                    if (C1349Bv.m4126(UserAgent.this.f2210.getProfileGuid(), userProfile.getProfileGuid())) {
                        UserAgent.this.m1270(userProfile);
                        UserAgent.this.f2210 = userProfile;
                    }
                }
            }
            C1061.m16114().mo14177(UserAgent.this.f2210);
            C2018nv.m9348(UserAgent.this.m16093());
        }
    };

    /* access modifiers changed from: package-private */
    public enum ProfileActivatedSource {
        login,
        switchProfile,
        restoreProfile
    }

    public UserAgent(Context context, BookmarkStore bookmarkStore) {
        this.f2207 = context;
        this.f2199 = bookmarkStore;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x005f  */
    @Override // o.AbstractC1052
    /* renamed from: ʽ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo1237() {
        /*
            r5 = this;
            r5.m1344()
            com.netflix.mediaclient.service.user.UserAgent$If r0 = new com.netflix.mediaclient.service.user.UserAgent$If
            r0.<init>()
            r5.f2209 = r0
            o.nW r0 = new o.nW
            android.content.Context r1 = r5.m16093()
            o.Ｆ r2 = r5.m16101()
            r0.<init>(r1, r2)
            r5.f2202 = r0
            o.nx r0 = new o.nx
            android.content.Context r1 = r5.m16093()
            r0.<init>(r1)
            r5.f2203 = r0
            android.content.Context r0 = r5.m16093()
            java.lang.String r4 = o.BZ.m3967(r0)
            java.lang.String r0 = "nf_service_useragent"
            java.lang.String r1 = "Current device locale as raw user locale: %s"
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            r2[r3] = r4
            o.C1283.m16851(r0, r1, r2)
            o.Ｆ r0 = r5.m16101()
            boolean r0 = r0.mo16529()
            if (r0 == 0) goto L_0x0052
            o.nx r0 = r5.f2203
            android.content.Context r0 = r5.m16093()
            boolean r0 = o.C2020nx.m9370(r0)
            if (r0 != 0) goto L_0x0052
            com.netflix.mediaclient.android.app.NetflixImmutableStatus r0 = o.AbstractC0367.f13220
            goto L_0x0054
        L_0x0052:
            com.netflix.mediaclient.android.app.NetflixImmutableStatus r0 = o.AbstractC0367.f13235
        L_0x0054:
            r5.f2198 = r0
            r5.m1256()
            boolean r0 = r5.m1322()
            if (r0 == 0) goto L_0x0064
            com.netflix.mediaclient.android.app.NetflixImmutableStatus r0 = o.AbstractC0367.f13235
            r5.m16090(r0)
        L_0x0064:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.netflix.mediaclient.service.user.UserAgent.mo1237():void");
    }

    /* renamed from: ᶥ  reason: contains not printable characters */
    private boolean m1322() {
        final String r4 = C1339Bl.m4045(m16093(), "useragent_current_profile_id", (String) null);
        if (C1349Bv.m4113(r4)) {
            C1283.m16854("nf_service_useragent", "No profile ID, user is not logged in. Check if we have old user data.");
            return m1323();
        }
        C1283.m16851("nf_service_useragent", "Current profile ID: %s, user is logged in.", r4);
        if (!m16087().mo6788(r4)) {
            C1283.m16854("nf_service_useragent", "User is NOT know to MSL, check if re-authorization data exist!");
            oD.If r5 = m16087().mo6787();
            if (r5 == null || !r4.equals(r5.f9223)) {
                C1283.m16855("nf_service_useragent", "Restore data not found for %s, try to log in using cookies", r4);
                AuthorizationCredentials r6 = m16094().mo6502(r4);
                if (r6 != null) {
                    C1283.m16851("nf_service_useragent", "Cookies found for %s, trying to log in using cookies...", r4);
                    m1283(r6);
                    return false;
                }
                C1283.m16855("nf_service_useragent", "Restore data not found for %s, leave user in logout state", r4);
                m1326();
                return true;
            }
            m1295(r5);
            return false;
        }
        C1283.m16854("nf_service_useragent", "User is known to MSL");
        this.f2200.m1417(r4);
        AuthorizationCredentials r52 = m16094().mo6502(r4);
        if (r52 != null) {
            C1283.m16851("nf_service_useragent", "Cookies found. all good for user, %s, %s", r4, r52);
            this.f2200.m1416(r52);
            m1259(r4);
            m1293(r52);
            return true;
        }
        C1283.m16844("nf_service_useragent", "Cookies NOT found for user %s, try to get them!", r4);
        m16092(this.f2202.m9187(r4, new AbstractC2016nt() { // from class: com.netflix.mediaclient.service.user.UserAgent.5
            @Override // o.AbstractC2016nt, o.AbstractC2022nz
            /* renamed from: ॱ */
            public void mo1402(AuthorizationCredentials authorizationCredentials, Status status) {
                if (!status.mo298() || authorizationCredentials == null || !C1349Bv.m4107(authorizationCredentials.netflixId)) {
                    C1283.m16865("nf_service_useragent", "Failed to refresh credentials!");
                    UserAgent.this.m16086().mo1515().mo5714("Bind failed at initLastKnownUser ");
                    UserAgent.this.m1359();
                } else {
                    UserAgent.this.f2200.mo1400(authorizationCredentials);
                    UserAgent.this.m1259(r4);
                    UserAgent.this.m1293(authorizationCredentials);
                }
                UserAgent.this.m16090(AbstractC0367.f13235);
            }
        }));
        return false;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˎ  reason: contains not printable characters */
    private void m1293(AuthorizationCredentials authorizationCredentials) {
        if (this.f2210 != null) {
            if (this.f2210.isKidsProfile()) {
                Logger.INSTANCE.m127(new C1005());
            }
            Logger.INSTANCE.m142(new C1223(this.f2210.getProfileGuid()));
            if (authorizationCredentials != null && authorizationCredentials.netflixId != null) {
                Logger.INSTANCE.m142(new C1198(authorizationCredentials.netflixId));
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ʻ  reason: contains not printable characters */
    private void m1253(AbstractC2021ny nyVar) {
        m16101().mo16534(null, null);
        m1338(nyVar);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m1338(final AbstractC2021ny nyVar) {
        m16092(this.f2202.m9205(new AbstractC2016nt() { // from class: com.netflix.mediaclient.service.user.UserAgent.9
            @Override // o.AbstractC2016nt, o.AbstractC2022nz
            /* renamed from: ˎ */
            public void mo1394(AccountData accountData, Status status) {
                if (status.mo298()) {
                    UserAgent.this.m1306(accountData.getUserProfiles());
                    UserAgent.this.m1305(accountData.getUser());
                    C2018nv.m9347(UserAgent.this.m16093());
                }
                if (nyVar != null) {
                    nyVar.mo9382(accountData, status);
                }
            }
        }));
    }

    /* renamed from: ꞌ  reason: contains not printable characters */
    private boolean m1323() {
        Pair<String, AuthorizationCredentials> r5 = C2019nw.m9361(m16093());
        if (r5 == null) {
            C1283.m16854("nf_service_useragent", "User was not logged in.");
            return true;
        }
        C1283.m16851("nf_service_useragent", "To migrate current profile ID: %s, user was logged in.", r5.first);
        if (!m16087().mo6788((String) r5.first)) {
            C1283.m16854("nf_service_useragent", "User is NOT known to MSL, all is how it should be!");
            m1277(r5);
            return false;
        }
        C1283.m16850("nf_service_useragent", "User is known to MSL, this is NOT expected!");
        this.f2200.m1417((String) r5.first);
        this.f2200.mo1400((AuthorizationCredentials) r5.second);
        m1259((String) r5.first);
        return true;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m1277(final Pair<String, AuthorizationCredentials> pair) {
        C1283.m16854("nf_service_useragent", "User data does exist, credentials found, migrate user to MSL");
        this.f2200.m1417((String) pair.first);
        nJ r3 = this.f2202.m9190((String) pair.first, new AbstractC2016nt() { // from class: com.netflix.mediaclient.service.user.UserAgent.20
            @Override // o.AbstractC2016nt, o.AbstractC2022nz
            /* renamed from: ˋ */
            public void mo1386(UserProfile userProfile, Status status) {
                if (status.mo298()) {
                    C1283.m16854("nf_service_useragent", "Able to migrate credentials!");
                    UserAgent.this.f2200.m1417((String) pair.first);
                    UserAgent.this.f2200.mo1400((AuthorizationCredentials) pair.second);
                    UserAgent.this.m1259((String) pair.first);
                } else {
                    C1283.m16865("nf_service_useragent", "Failed to migrate credentials!");
                    UserAgent.this.m1359();
                }
                UserAgent.this.m16090(AbstractC0367.f13235);
            }
        });
        r3.m6619(m1289((String) pair.first, new DZ(((AuthorizationCredentials) pair.second).netflixId, ((AuthorizationCredentials) pair.second).secureNetflixId)));
        m16092(r3);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m1295(oD.If r10) {
        C1283.m16854("nf_service_useragent", "recoverUserWithMslAuthData:: recover user state with msl auth data");
        C1413Ed ed = new C1413Ed(r10.f9225, r10.f9224);
        AuthorizationCredentials r6 = m16094().mo6502(r10.f9223);
        DZ dz = null;
        if (ed != null) {
            C1283.m16851("nf_service_useragent", "recoverUserWithMslAuthData:: cookies found for user %s, trying relogin with failback", r10.f9223);
            dz = new DZ(r6.netflixId, r6.secureNetflixId);
        } else {
            String str = "recoverUserWithMslAuthData:: cookies not found for user " + r10.f9223 + " no failback! This is NOT expected";
            C1283.m16865("nf_service_useragent", str);
            m16086().mo1515().mo5714(str);
        }
        m1274(r10.f9223, ed, dz);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m1283(AuthorizationCredentials authorizationCredentials) {
        C1283.m16854("nf_service_useragent", "recover user state with cookies");
        m1274(authorizationCredentials.userId, new DZ(authorizationCredentials.netflixId, authorizationCredentials.secureNetflixId), null);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˊ  reason: contains not printable characters */
    private void m1274(final String str, final AbstractC1412Ec ec, final AbstractC1412Ec ec2) {
        this.f2200.m1417(str);
        nH r2 = this.f2202.m9187(str, new AbstractC2016nt() { // from class: com.netflix.mediaclient.service.user.UserAgent.22
            @Override // o.AbstractC2016nt, o.AbstractC2022nz
            /* renamed from: ॱ  reason: contains not printable characters */
            public void mo1402(AuthorizationCredentials authorizationCredentials, Status status) {
                if (status.mo298()) {
                    C1283.m16854("nf_service_useragent", "Able to refresh credentials!");
                    UserAgent.this.f2200.m1417(str);
                    UserAgent.this.f2200.mo1400(authorizationCredentials);
                    UserAgent.this.m1259(str);
                    UserAgent.this.m1293(authorizationCredentials);
                    UserAgent.this.m16086().mo1515().mo5714("User recovery success using " + ec.getClass().getSimpleName());
                } else {
                    C1283.m16855("nf_service_useragent", "Failed to refresh credentials using %s!", ec.getClass().getSimpleName());
                    if (ec2 != null) {
                        C1283.m16855("nf_service_useragent", "Re trying to recover with failback using %s, if we fail, user will be logged out!", ec2.getClass().getSimpleName());
                        UserAgent.this.m16086().mo1515().mo5714("Failed to recover user on cold start using " + ec.getClass().getSimpleName() + " failing back to " + ec2.getClass().getSimpleName());
                        UserAgent.this.m1274(str, ec2, null);
                        return;
                    }
                    UserAgent.this.m16086().mo1515().mo5714("User recovery failed using " + ec.getClass().getSimpleName());
                    UserAgent.this.m1359();
                }
                UserAgent.this.m16090(AbstractC0367.f13235);
            }
        });
        r2.m6619(m1289(str, ec));
        m16092(r2);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ʼ  reason: contains not printable characters */
    private void m1259(String str) {
        String r4 = C1339Bl.m4045(m16093(), "useragent_userprofiles_data", (String) null);
        C1283.m16851("nf_service_useragent", "User profiles JSON: %s", r4);
        if (r4 != null) {
            AbstractApplicationC1258.getInstance().mo240();
            this.f2196 = nD.m9126(r4);
            m1271(str, ProfileActivatedSource.restoreProfile);
        } else {
            C1283.m16865("nf_service_useragent", "User profiles JSON not found!");
        }
        String r5 = C1339Bl.m4045(m16093(), "useragent_user_data", (String) null);
        C1283.m16851("nf_service_useragent", "User JSON: %s", r5);
        if (r5 != null) {
            this.f2204 = nD.m9128(r5);
            this.f2208 = this.f2204.getSubtitleDefaults();
            return;
        }
        C1283.m16865("nf_service_useragent", "User JSON not found!");
    }

    /* renamed from: ﾟ  reason: contains not printable characters */
    private void m1326() {
        m1324();
    }

    @Override // o.AbstractC1052
    /* renamed from: ʻ */
    public void mo1236() {
        this.f2203 = null;
        m1262();
        super.mo1236();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public boolean m1369() {
        return this.f2197;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m1344() {
        this.f2197 = C1061.m16114().mo14161(m16093());
        C1283.m16851("nf_service_useragent", "Is profile switching disabled: %b", Boolean.valueOf(this.f2197));
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public UserProfile mo1383() {
        return this.f2210;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public List<? extends AbstractC2089qj> m1334() {
        return this.f2196;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˏ  reason: contains not printable characters */
    private void m1308(String[] strArr) {
        this.f2203.m9373(C1349Bv.m4117(strArr));
    }

    @Override // com.netflix.mediaclient.service.user.UserAgentInterface
    /* renamed from: ˉ  reason: contains not printable characters */
    public BZ mo1328() {
        return this.f2203.m9375();
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m1330(String str) {
        if (this.f2203 != null) {
            this.f2203.m9374(new BZ(str));
        }
    }

    @Override // com.netflix.mediaclient.service.user.UserAgentInterface
    /* renamed from: ˊᐝ  reason: contains not printable characters */
    public boolean mo1333() {
        return this.f2210 != null;
    }

    /* renamed from: ˍ  reason: contains not printable characters */
    public String m1342() {
        if (null != this.f2204) {
            return this.f2204.getEmail();
        }
        return null;
    }

    @Override // com.netflix.mediaclient.service.user.UserAgentInterface
    /* renamed from: ˋˋ  reason: contains not printable characters */
    public String mo1339() {
        if (this.f2204 == null) {
            return null;
        }
        return this.f2204.getUserToken();
    }

    /* renamed from: ˌ  reason: contains not printable characters */
    public boolean m1341() {
        if (this.f2210 == null) {
            C1283.m16854("nf_service_useragent", "isCurrentProfileInstantQueueEnabled is null");
            return false;
        }
        C1283.m16851("nf_service_useragent", "isCurrentProfileInstantQueueEnabled %s called: %b ", this.f2210.getProfileName(), Boolean.valueOf(this.f2210.isIQEnabled()));
        return this.f2210.isIQEnabled();
    }

    @Override // com.netflix.mediaclient.service.user.UserAgentInterface
    /* renamed from: ˎˎ  reason: contains not printable characters */
    public String mo1353() {
        if (this.f2210 != null) {
            return this.f2210.getProfileToken();
        }
        C1283.m16854("nf_service_useragent", "currentProfile is null");
        return null;
    }

    @Override // com.netflix.mediaclient.service.user.UserAgentInterface
    /* renamed from: ˋᐝ  reason: contains not printable characters */
    public String mo1340() {
        C1283.m16854("nf_service_useragent", "getCurrentProfileGuid called");
        if (this.f2210 == null) {
            return null;
        }
        return this.f2210.getProfileGuid();
    }

    @Override // com.netflix.mediaclient.service.user.UserAgentInterface
    /* renamed from: ˑ  reason: contains not printable characters */
    public oR mo1361() {
        return this.f2200;
    }

    @Override // com.netflix.mediaclient.service.user.UserAgentInterface
    /* renamed from: ˎ  reason: contains not printable characters */
    public synchronized AbstractC2031og mo1343(String str) {
        final AuthorizationCredentials r4 = m16094().mo6502(str);
        if (r4 == null) {
            C1283.m16855("nf_service_useragent", "No cookies for profile %s", str);
            return null;
        }
        C1283.m16851("nf_service_useragent", "Cookies found for profile %s", str);
        return new AbstractC2031og() { // from class: com.netflix.mediaclient.service.user.UserAgent.21
            @Override // o.AbstractC2031og
            /* renamed from: ॱ  reason: contains not printable characters */
            public String mo1401() {
                return UserAgent.this.f2200.mo1401();
            }

            @Override // o.AbstractC2031og
            /* renamed from: ˎ  reason: contains not printable characters */
            public String mo1398() {
                return UserAgent.this.f2200.mo1398();
            }

            @Override // o.AbstractC2031og
            /* renamed from: ˏ  reason: contains not printable characters */
            public String mo1399() {
                return r4.netflixId;
            }

            @Override // o.AbstractC2031og
            /* renamed from: ˋ  reason: contains not printable characters */
            public String mo1397() {
                return r4.secureNetflixId;
            }

            @Override // o.AbstractC2031og
            /* renamed from: ˏ  reason: contains not printable characters */
            public boolean mo1400(AuthorizationCredentials authorizationCredentials) {
                return false;
            }

            @Override // o.AbstractC2031og
            /* renamed from: ˊ  reason: contains not printable characters */
            public String mo1396() {
                return r4.userId;
            }

            @Override // o.AbstractC2031og
            /* renamed from: ʻ  reason: contains not printable characters */
            public String mo1395() {
                return r4.userId;
            }
        };
    }

    @Override // com.netflix.mediaclient.service.user.UserAgentInterface
    /* renamed from: ॱ  reason: contains not printable characters */
    public oR mo1364(final String str) {
        if (C1349Bv.m4113(str)) {
            return null;
        }
        if (!m16087().mo6788(str)) {
            C1283.m16855("nf_service_useragent", "MSL store does not know for profile %s", str);
            return null;
        }
        C1283.m16851("nf_service_useragent", "MSL store know for profile %s", str);
        return new oR() { // from class: com.netflix.mediaclient.service.user.UserAgent.23
            @Override // o.oR
            /* renamed from: ˊ  reason: contains not printable characters */
            public String mo1403() {
                return str;
            }

            @Override // o.oR
            public AbstractC1412Ec L_() {
                return null;
            }
        };
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m1349(String str, String str2, AbstractC2021ny nyVar) {
        C1283.m16854("nf_service_useragent", "loginUser activateAccByEmailPassword");
        C1339Bl.m4049(this.f2207);
        if (mo1333()) {
            C1283.m16850("nf_service_useragent", "User is logged in! This should NOT happen!");
            m1346(C1343Bp.m4059(StatusCode.NRD_REGISTRATION_EXISTS, "UserAgent: activateAccByEmailPassword fails, NRD registration exist", false, RootCause.clientFailure), nyVar);
            Logger.INSTANCE.m134("SignIn", null);
            return;
        }
        m1284(str, str2, nyVar);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m1284(String str, String str2, final AbstractC2021ny nyVar) {
        C1283.m16854("nf_service_useragent", "Login via Dynecom");
        m16101().mo16518(str, str2, new C0452() { // from class: com.netflix.mediaclient.service.user.UserAgent.26
            @Override // o.C0452, o.AbstractC1254
            /* renamed from: ˎ  reason: contains not printable characters */
            public void mo1406(SignInData signInData, Status status) {
                if (status.mo301() || signInData == null || !signInData.isSignInSuccessful() || signInData.authorizationCredentials == null || !signInData.isValid()) {
                    C1283.m16850("nf_service_useragent", "Login via Dynecom was failure...");
                    if (status.mo304()) {
                        UserAgent.this.m1346(C1343Bp.m4059(status.mo302(), "UserAgent: activateLoginViaDynecom fails", true, RootCause.clientFailure), nyVar);
                        return;
                    }
                    StatusCode statusCode = StatusCode.USER_SIGNIN_RETRY;
                    if (signInData != null) {
                        if (signInData.shouldTrySignUp()) {
                            C1283.m16854("nf_service_useragent", "not currentMember,  need to go to sign-up page");
                            AbstractApplicationC1258.getInstance().mo232();
                            if (signInData.authorizationCredentials != null) {
                                UserAgent.this.m1272(signInData.authorizationCredentials.netflixId, signInData.authorizationCredentials.secureNetflixId);
                            }
                            statusCode = StatusCode.USER_SIGNIN_FAILURE_TRY_SIGNUP;
                        } else if (signInData.isThrottled()) {
                            statusCode = StatusCode.USER_SIGNIN_THROTTLED;
                        } else if (signInData.isPasswordIncorrect()) {
                            statusCode = StatusCode.ERROR_INCORRECT_PASSWORD;
                            C1283.m16850("nf_service_useragent", "Password is incorrect");
                        } else if (signInData.isEmailUnrecognised()) {
                            statusCode = StatusCode.ERROR_UNRECOGNIZED_EMAIL;
                            C1283.m16850("nf_service_useragent", "Email is incorrect");
                        } else if (signInData.isAccountWithNoPasswordSet()) {
                            statusCode = StatusCode.ERROR_ACCOUNT_PASSWORD_NOT_SET;
                            C1283.m16850("nf_service_useragent", "Account has no password set");
                        } else if (signInData.isConsumptionOnlyFormerMember()) {
                            statusCode = StatusCode.ERROR_FORMER_MEMBER_CONSUMPTION;
                            C1283.m16850("nf_service_useragent", "Account is a consumption-only former member");
                        } else if (signInData.isRedirectOnlyFormerMember()) {
                            statusCode = StatusCode.ERROR_FORMER_MEMBER_REDIRECT;
                            C1283.m16850("nf_service_useragent", "Account is a redirect-only former member");
                        } else if (signInData.isConsumptionOnlyNeverMember()) {
                            statusCode = StatusCode.ERROR_NEVER_MEMBER_CONSUMPTION;
                            C1283.m16850("nf_service_useragent", "Account is a consumption-only never member");
                        } else if (signInData.isRedirectOnlyNeverMember()) {
                            statusCode = StatusCode.ERROR_NEVER_MEMBER_REDIRECT;
                            C1283.m16850("nf_service_useragent", "Account is a redirect-only never member");
                        } else if (signInData.isRedirectOnlyDVDMember()) {
                            statusCode = StatusCode.ERROR_DVD_MEMBER_REDIRECT;
                            C1283.m16850("nf_service_useragent", "Account is a redirect-only DVD member");
                        } else if (signInData.isConsumptionOnlyUnrecognizedEmail()) {
                            statusCode = StatusCode.ERROR_UNRECOGNIZED_CONSUMPTION;
                            C1283.m16850("nf_service_useragent", "Email is incorrect, but login is consumption-only");
                        } else if (signInData.isRedirectOnlyUnrecognizedEmail()) {
                            statusCode = StatusCode.ERROR_UNRECOGNIZED_REDIRECT;
                            C1283.m16850("nf_service_useragent", "Email is incorrect, but login is redirect-only");
                        }
                    }
                    UserAgent.this.m1346(C1343Bp.m4059(statusCode, "UserAgent: activateLoginViaDynecom fails", true, RootCause.clientFailure), nyVar);
                    return;
                }
                C1283.m16854("nf_service_useragent", "Login via Dynecom was success...");
                try {
                    C0614 r5 = new C0614(signInData.authorizationCredentials.netflixId, signInData.authorizationCredentials.secureNetflixId);
                    UserAgent.this.f2200.m1416(signInData.authorizationCredentials);
                    UserAgent.this.m1307(r5, nyVar);
                } catch (JSONException e) {
                    C1283.m16856("nf_service_useragent", e, "error creating activationTokesn", new Object[0]);
                    UserAgent.this.m1346(C1343Bp.m4059(StatusCode.NRD_ERROR, "UserAgent: activateLoginViaDynecom fails", true, RootCause.clientFailure), nyVar);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˊ  reason: contains not printable characters */
    private void m1272(String str, String str2) {
        m16101().mo16517(m1310(str, str2));
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private NonMemberData m1310(String str, String str2) {
        NonMemberData r1 = m16101().mo16531();
        if (r1 == null || !r1.isValid()) {
            return new NonMemberData(str, str2);
        }
        if (!C1349Bv.m4126(str, r1.netflixId) || !C1349Bv.m4126(str2, r1.secureNetflixId)) {
            return new NonMemberData(str, str2);
        }
        return null;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m1317(final DZ dz, final AbstractC2021ny nyVar) {
        C1283.m16854("nf_service_useragent", "Activate: fetch account level config data");
        AnonymousClass28 r2 = new C0452() { // from class: com.netflix.mediaclient.service.user.UserAgent.28
            @Override // o.C0452, o.AbstractC1254
            /* renamed from: ˋ  reason: contains not printable characters */
            public void mo1407(ConfigData configData, Status status) {
                C1283.m16851("nf_service_useragent", "onConfigDataFetched res.isSuccess:%b, isAccountDataAvailable:%b", Boolean.valueOf(status.mo298()), Boolean.valueOf(UserAgent.this.m1251()));
                if (status.mo298()) {
                    C1283.m16854("nf_service_useragent", "pfetchUserData");
                    if (UserAgent.this.f2200.mo1403() != null) {
                        C1283.m16855("nf_service_useragent", "This should NOT happen, userID exist in MSL registry %s", UserAgent.this.f2200.mo1403());
                    }
                    UserAgent.this.f2200.m1417("TEMP_PROFILE_ID");
                    UserAgent.this.m16092(UserAgent.this.f2202.m9205(UserAgent.this.m1298(nyVar, new AuthorizationCredentials("TEMP_PROFILE_ID", dz.m4704(), dz.m4703()))));
                    return;
                }
                UserAgent.this.m1346(status, nyVar);
            }
        };
        oR r3 = m1289("TEMP_PROFILE_ID", dz);
        C1272.m16801(m16093());
        m16101().mo16534(r3, r2);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private oR m1289(final String str, final AbstractC1412Ec ec) {
        return new oR() { // from class: com.netflix.mediaclient.service.user.UserAgent.27
            @Override // o.oR
            /* renamed from: ˊ */
            public String mo1403() {
                return str;
            }

            @Override // o.oR
            public AbstractC1412Ec L_() {
                return ec;
            }

            public String toString() {
                return "UserAgent$MSLUserCredentialRegistry{userId='" + str + "', userAuthenticationData=" + (ec != null ? ec.getClass().getSimpleName() : "null") + '}';
            }
        };
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˏ  reason: contains not printable characters */
    private AbstractC2022nz m1298(final AbstractC2021ny nyVar, final AuthorizationCredentials authorizationCredentials) {
        return new AbstractC2016nt() { // from class: com.netflix.mediaclient.service.user.UserAgent.2
            @Override // o.AbstractC2016nt, o.AbstractC2022nz
            /* renamed from: ˎ  reason: contains not printable characters */
            public void mo1394(AccountData accountData, Status status) {
                if (status.mo298()) {
                    UserAgent.this.m1306(accountData.getUserProfiles());
                    UserAgent.this.m1305(accountData.getUser());
                    UserProfile primaryProfile = accountData.getPrimaryProfile();
                    if (primaryProfile == null) {
                        throw new IllegalStateException("Primary profile does NOT exist! This should NOT happen!");
                    }
                    try {
                        String r6 = UserAgent.this.mo1362().mo1396();
                        if (!C1349Bv.m4107(r6) || "TEMP_PROFILE_ID".equals(r6)) {
                            UserAgent.this.m16087().mo6792("TEMP_PROFILE_ID", primaryProfile.getProfileGuid());
                            UserAgent.this.f2200.m1417(primaryProfile.getProfileGuid());
                            authorizationCredentials.userId = primaryProfile.getProfileGuid();
                            UserAgent.this.f2200.mo1400(authorizationCredentials);
                            C1283.m16851("nf_service_useragent", "After:: MSLlUserCredentialRegistry getUserId: %s ", UserAgent.this.f2200.mo1403());
                            UserAgent.this.m1321(nyVar);
                            return;
                        }
                        C1283.m16855("nf_service_useragent", "We already have credentials %s. Double submission most likely!", r6);
                    } catch (MslException e) {
                        C1283.m16856("nf_service_useragent", e, "Unable to changeUser placeholder temp profile ID", new Object[0]);
                        UserAgent.this.m1346(C1343Bp.m4059(StatusCode.MSL_FAILED_TO_UPDATE_USER_ID, "UserAgent: activateAccByEmailPassword fails, failed to changeUser UserID in MSLStore", false, RootCause.clientFailure), nyVar);
                    }
                } else {
                    UserAgent.this.m1346(status, nyVar);
                }
            }
        };
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ᐝ  reason: contains not printable characters */
    private void m1321(final AbstractC2021ny nyVar) {
        m16092(this.f2202.m9187(this.f2200.mo1403(), new AbstractC2016nt() { // from class: com.netflix.mediaclient.service.user.UserAgent.3
            @Override // o.AbstractC2016nt, o.AbstractC2022nz
            /* renamed from: ॱ */
            public void mo1402(AuthorizationCredentials authorizationCredentials, Status status) {
                C1283.m16851("nf_service_useragent", "status: %s, MSL refreshed cookies %s", authorizationCredentials, status);
                if (status.mo298() && authorizationCredentials != null && C1349Bv.m4107(authorizationCredentials.netflixId)) {
                    UserAgent.this.f2200.mo1400(authorizationCredentials);
                }
                UserAgent.this.m1271(UserAgent.this.f2200.mo1403(), ProfileActivatedSource.login);
                C2018nv.m9347(UserAgent.this.m16093());
                UserAgent.this.m1264(nyVar);
            }
        }));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˏ  reason: contains not printable characters */
    private void m1306(List<UserProfile> list) {
        if (list == null) {
            C1283.m16850("nf_service_useragent", "new userProfiles data is null");
            return;
        }
        this.f2196 = list;
        nD.m9125(m16093(), this.f2196);
        this.f2199.updateValidProfiles(this.f2196);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˏ  reason: contains not printable characters */
    private void m1305(User user) {
        if (user == null) {
            C1283.m16850("nf_service_useragent", "new user data is null");
            return;
        }
        this.f2204 = user;
        this.f2208 = this.f2204.getSubtitleDefaults();
        nD.m9127(m16093(), this.f2204);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m1332(C0614 r5, AbstractC2021ny nyVar) {
        C1283.m16854("nf_service_useragent", "loginUserByTokens");
        C1339Bl.m4049(this.f2207);
        this.f2200.m1416(new AuthorizationCredentials(null, r5.f13920, r5.f13917));
        m1307(r5, nyVar);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m1358(AbstractC2021ny nyVar) {
        C1283.m16854("nf_service_useragent", "loginUserWithExistingTokens");
        m1317(new DZ(this.f2200.mo1399(), this.f2200.mo1397()), nyVar);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˏ  reason: contains not printable characters */
    private void m1307(C0614 r6, AbstractC2021ny nyVar) {
        C1283.m16854("nf_service_useragent", "loginUser tokenActivate");
        if (mo1333()) {
            C1283.m16850("nf_service_useragent", "User is logged in! This should NOT happen!");
            m1346(C1343Bp.m4059(StatusCode.NRD_REGISTRATION_EXISTS, "UserAgent: activateAccByToken fails, NRD registration exist", false, RootCause.clientFailure), nyVar);
            C1363Ci.m4425(r6.f13918 ? SignInLogging.SignInType.autologin : SignInLogging.SignInType.tokenActivate, IClientLogging.CompletionReason.failed, (Error) null);
            Logger.INSTANCE.m134("SignIn", null);
            return;
        }
        m1317(new DZ(r6.f13920, r6.f13917), nyVar);
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    private boolean m1254(String str) {
        if (this.f2196 == null || C1349Bv.m4113(str)) {
            return false;
        }
        for (UserProfile userProfile : this.f2196) {
            if (userProfile != null && str.equals(userProfile.getProfileGuid())) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m1357(final String str) {
        if (this.f2200.mo1403().equals(str)) {
            C1283.m16851("nf_service_useragent", "We are already on profile %s. Do nothing.", str);
            C2018nv.m9356(m16093(), StatusCode.OK.m271(), null);
            C2018nv.m9355(m16093());
        } else if (!m1254(str)) {
            C1283.m16844("nf_service_useragent", "Unknown profile for profile ID: %s", str);
            C2018nv.m9356(m16093(), StatusCode.SWITCH_PROFILE_UNKNOWN_ID.m271(), null);
        } else {
            C1283.m16851("nf_service_useragent", "selectProfile %s", str);
            m16086().mo1510();
            final DY r4 = m16087().mo6786(this.f2200.f2300, str);
            if (r4 == null) {
                C1283.m16850("nf_service_useragent", "switchWebUserProfile failed, userId token was not found for current user id. It should not happen!");
                C2018nv.m9356(m16093(), StatusCode.MSL_SWITCH_PROFILE_NO_AUTH_DATA.m271(), null);
                return;
            }
            nJ r6 = this.f2202.m9190(str, new AbstractC2016nt() { // from class: com.netflix.mediaclient.service.user.UserAgent.1
                @Override // o.AbstractC2016nt, o.AbstractC2022nz
                /* renamed from: ˋ  reason: contains not printable characters */
                public void mo1386(UserProfile userProfile, Status status) {
                    if (!status.mo298() || UserAgent.this.f2210 == null || C1349Bv.m4126(UserAgent.this.f2210.getProfileGuid(), userProfile.getProfileGuid())) {
                        C1283.m16844("nf_service_useragent", "(skipping userProfile changeUser) - msl failed to switch user - with statusCode=%s", status.mo302());
                        C2018nv.m9356(UserAgent.this.m16093(), StatusCode.MSL_SWITCH_PROFILE_FAILED.m271(), null);
                        return;
                    }
                    UserAgent.this.m1273(str, r4, userProfile, status);
                }
            });
            r6.m6619(m1289(str, r4));
            m16092(r6);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˊ  reason: contains not printable characters */
    private void m1273(final String str, AbstractC1412Ec ec, final UserProfile userProfile, Status status) {
        nH r2 = this.f2202.m9187(str, new AbstractC2016nt() { // from class: com.netflix.mediaclient.service.user.UserAgent.4
            @Override // o.AbstractC2016nt, o.AbstractC2022nz
            /* renamed from: ॱ */
            public void mo1402(AuthorizationCredentials authorizationCredentials, Status status2) {
                if (!status2.mo298() || authorizationCredentials == null || !C1349Bv.m4107(authorizationCredentials.netflixId)) {
                    C1283.m16865("nf_service_useragent", "MSL switched profile but can't get cookies. call failed. leave user in graceful state by going back to previous state.");
                    C2018nv.m9356(UserAgent.this.m16093(), StatusCode.MSL_SWITCH_PROFILE_BIND_FAIL.m271(), null);
                    return;
                }
                UserAgent.this.m1294(str, authorizationCredentials, userProfile, status2);
            }
        });
        r2.m6619(m1289(str, ec));
        m16092(r2);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˎ  reason: contains not printable characters */
    private void m1294(String str, AuthorizationCredentials authorizationCredentials, UserProfile userProfile, Status status) {
        this.f2200.m1417(str);
        C1283.m16854("nf_service_useragent", "doSelectedProfile new profile, update...");
        m1257();
        m1316(userProfile);
        if (this.f2210 == null || !C1349Bv.m4126(this.f2210.getLanguagesInCsv(), userProfile.getLanguagesInCsv())) {
            C1283.m16854("nf_service_useragent", "onProfileDataFetched language changed, changeUser ");
            m1308(userProfile.getLanguages());
        }
        this.f2206 = userProfile.getSubtitlePreference();
        if (this.f2210 != null) {
            if (this.f2210.isKidsProfile()) {
                Logger.INSTANCE.m128(C1005.class);
            }
            Logger.INSTANCE.m133("NetflixId");
        }
        this.f2210 = userProfile;
        if (this.f2210 != null && this.f2210.isKidsProfile()) {
            Logger.INSTANCE.m127(new C1005());
        }
        C1283.m16851("nf_service_useragent", "Set new profile %s", userProfile);
        if (authorizationCredentials != null) {
            C1283.m16851("nf_service_useragent", "User credentials found: %s ", authorizationCredentials);
            this.f2200.mo1400(authorizationCredentials);
            Logger.INSTANCE.m142(new C1198(authorizationCredentials.netflixId));
            Logger.INSTANCE.m142(new C1223(userProfile.getProfileGuid()));
        } else {
            C1283.m16850("nf_service_useragent", "User credentials not returned! Failure!");
        }
        m1271(str, ProfileActivatedSource.switchProfile);
        C2018nv.m9356(m16093(), status.mo302().m271(), null);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m1365(int i, String str, String str2, final AbstractC2021ny nyVar) {
        m16092(this.f2202.m9198(i, str, str2, new AbstractC2016nt() { // from class: com.netflix.mediaclient.service.user.UserAgent.7
            @Override // o.AbstractC2016nt, o.AbstractC2022nz
            /* renamed from: ˏ  reason: contains not printable characters */
            public void mo1408(final Status status) {
                if (nyVar != null) {
                    UserAgent.this.s_().post(new Runnable() { // from class: com.netflix.mediaclient.service.user.UserAgent.7.1
                        @Override // java.lang.Runnable
                        public void run() {
                            nyVar.mo9385(status);
                        }
                    });
                }
            }
        }));
    }

    /* renamed from: ˏˎ  reason: contains not printable characters */
    public void m1359() {
        mo1368(false);
    }

    @Override // com.netflix.mediaclient.service.user.UserAgentInterface
    /* renamed from: ॱ  reason: contains not printable characters */
    public void mo1368(boolean z) {
        C1283.m16851("nf_service_useragent", "Force logout %b!", Boolean.valueOf(z));
        boolean r5 = NetflixApplication.m16693();
        AbstractC1250 t_ = t_();
        boolean z2 = t_ != null && t_.mo15845();
        m16086().mo1515().mo5714("force logout");
        mo1360();
        if (z || !z2) {
            C1061.m16114().mo14166(m16093());
            if (z || r5) {
                C1283.m16851("nf_service_useragent", "forceLogoutUser:: Application is currently in foreground %b, - go to logout always %b", Boolean.valueOf(r5), Boolean.valueOf(z));
                C1061.m16114().mo14170(m16093());
                return;
            }
            C1283.m16854("nf_service_useragent", "forceLogoutUser:: UI is NOT visible, just kill all activities.");
            return;
        }
        C1283.m16854("nf_service_useragent", "User playback is in progress, leave to PlayerActivity to redirect to logout page on end of playback!");
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m1331(AbstractC2021ny nyVar) {
        if (!r_()) {
            C1283.m16865("nf_service_useragent", "Can't log user out because agent has not been initialized!");
            return;
        }
        this.f2201 = nyVar;
        AbstractC1221 r2 = m16101();
        if (r2 != null) {
            r2.mo16532();
            r2.mo16536();
        }
        m16086().mo1513();
        this.f2203.m9372();
        if (!mo1333()) {
            m1278(StatusCode.OK);
            return;
        }
        if (this.f2210 != null) {
            Intent intent = new Intent("com.netflix.mediaclient.intent.action.PUSH_ONLOGOUT");
            intent.addCategory("com.netflix.mediaclient.intent.category.PUSH");
            intent.putExtra("uid", mo1339());
            if (this.f2200.f2301 != null) {
                intent.putExtra("nid", this.f2200.mo1399());
            }
            if (this.f2200.f2302 != null) {
                intent.putExtra("sid", this.f2200.mo1397());
            }
            intent.putExtra(Device.ESN, m16101().d_().mo14449());
            intent.putExtra("device_cat", m16101().mo16541().m2972());
            intent.putExtra("uid", mo1353());
            LocalBroadcastManager.getInstance(m16093()).sendBroadcast(intent);
        }
        m1325();
    }

    @Override // com.netflix.mediaclient.service.user.UserAgentInterface
    /* renamed from: ͺॱ  reason: contains not printable characters */
    public AbstractC2031og mo1362() {
        return this.f2200;
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0067: APUT  (r2v1 java.lang.Object[]), (2 ??[int, float, short, byte, char]), (r3v3 java.lang.String) */
    @Override // com.netflix.mediaclient.service.user.UserAgentInterface
    /* renamed from: ˎˏ  reason: contains not printable characters */
    public String mo1354() {
        if (this.f2203 == null) {
            return null;
        }
        if (this.f2210 == null || this.f2210.getLanguagesList() == null || this.f2210.getLanguagesList().size() < 1) {
            return this.f2203.m9375().m3973();
        }
        BZ bz = new BZ(this.f2210.getLanguagesList().get(0));
        BZ r7 = this.f2203.m9375();
        Object[] objArr = new Object[3];
        objArr[0] = bz.m3973();
        objArr[1] = r7.m3973();
        objArr[2] = r7.m3974(bz) ? bz.m3973() : r7.m3973();
        C1283.m16851("nf_service_useragent", "nf_loc userPref:%s appLocaleRaw:%s - picking %s", objArr);
        return r7.m3974(bz) ? bz.m3973() : r7.m3973();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ʽ  reason: contains not printable characters */
    private void m1264(AbstractC2021ny nyVar) {
        C1283.m16854("nf_service_useragent", "doLoginComplete");
        C2018nv.m9351(m16093());
        C1363Ci.m4425((SignInLogging.SignInType) null, IClientLogging.CompletionReason.success, (Error) null);
        Logger.INSTANCE.m133("SignIn");
        C2018nv.m9350(m16093(), true);
        m1346(new NetflixStatus(StatusCode.OK), nyVar);
        AbstractApplicationC1258.getInstance().mo240();
        C1339Bl.m4048(m16093(), "nf_user_status_loggedin", true);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m1346(final Status status, final AbstractC2021ny nyVar) {
        s_().post(new Runnable() { // from class: com.netflix.mediaclient.service.user.UserAgent.6
            @Override // java.lang.Runnable
            public void run() {
                if (nyVar != null) {
                    nyVar.mo9381(status);
                }
            }
        });
    }

    /* renamed from: ﹳ  reason: contains not printable characters */
    private void m1324() {
        m16101().mo16526();
        AY ay = new AY(m16093());
        ay.m3495("useragent_userprofiles_data");
        ay.m3495("useragent_user_data");
        ay.m3495("useragent_current_profile_id");
        ay.m3498("nf_user_status_loggedin", false);
        ay.m3498("user_profile_was_selected", false);
        ay.m3494();
    }

    /* renamed from: ﾞ  reason: contains not printable characters */
    private void m1325() {
        C1283.m16854("nf_service_useragent", "Logout complete");
        C2018nv.m9349(m16093());
        m16087().mo6790();
        m16101().mo16509();
        this.f2200.m1420();
        m1278(StatusCode.OK);
        m16086().mo1504().mo5775("Logout complete");
        this.f2210 = null;
        this.f2196 = null;
        this.f2204 = null;
        this.f2206 = null;
        this.f2208 = null;
        m1324();
        PartnerReceiver.m1250(m16093(), false);
        m1257();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m1278(StatusCode statusCode) {
        s_().post(new Runnable() { // from class: com.netflix.mediaclient.service.user.UserAgent.10
            @Override // java.lang.Runnable
            public void run() {
                if (UserAgent.this.f2201 != null) {
                    UserAgent.this.f2201.mo9376(new NetflixStatus(StatusCode.OK));
                    C1283.m16854("nf_service_useragent", "Received deactivate complete and notified UI");
                    UserAgent.this.f2201 = null;
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˎ  reason: contains not printable characters */
    private boolean m1296(UserProfile userProfile) {
        return userProfile != null && C1349Bv.m4126(mo1340(), userProfile.getProfileGuid());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱ  reason: contains not printable characters */
    private void m1316(UserProfile userProfile) {
        boolean z = false;
        int i = 0;
        if (this.f2196 == null) {
            String r5 = C1339Bl.m4045(m16093(), "useragent_userprofiles_data", (String) null);
            if (C1349Bv.m4107(r5)) {
                this.f2196 = nD.m9126(r5);
            }
            if (this.f2196 == null) {
                this.f2196 = new ArrayList();
            }
        }
        Iterator<UserProfile> it = this.f2196.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (C1349Bv.m4126(it.next().getProfileGuid(), userProfile.getProfileGuid())) {
                z = true;
                break;
            } else {
                i++;
            }
        }
        if (z) {
            this.f2196.set(i, userProfile);
        } else {
            this.f2196.add(userProfile);
        }
        nD.m9125(m16093(), this.f2196);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˊ  reason: contains not printable characters */
    private void m1270(UserProfile userProfile) {
        if (!this.f2210.getProfileType().equals(userProfile.getProfileType())) {
            C1283.m16862("nf_service_useragent", "Current profile type changed - sending REFRESH_HOME intent");
            C2018nv.m9357(m16093());
            m16093().sendBroadcast(new Intent("com.netflix.mediaclient.intent.action.REFRESH_HOME_LOLOMO"));
            C1061.m16114().mo14166(m16093());
            if (NetflixApplication.m16693()) {
                C1283.m16862("nf_service_useragent", "Application is currently in foreground - restarting profiles gate");
                C1061.m16114().mo14175(m16093());
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.netflix.mediaclient.service.user.UserAgent$if  reason: invalid class name */
    public class Cif extends AbstractC2016nt {

        /* renamed from: ˏ  reason: contains not printable characters */
        AbstractC2021ny f2297;

        private Cif(AbstractC2021ny nyVar) {
            this.f2297 = nyVar;
        }

        @Override // o.AbstractC2016nt, o.AbstractC2022nz
        /* renamed from: ˋ */
        public void mo1409(AccountData accountData, Status status) {
            UserAgent.this.f2211.mo1409(accountData, status);
            this.f2297.mo9380(status);
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m1366(String str, boolean z, String str2, AbstractC2021ny nyVar) {
        C1283.m16854("nf_service_useragent", "addWebUserProfile");
        m16092(this.f2202.m9200(str, z, str2, new Cif(nyVar)));
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m1337(String str, String str2, boolean z, String str3, AbstractC2021ny nyVar) {
        C1283.m16854("nf_service_useragent", "editWebUserProfile");
        m16092(this.f2202.m9195(str, str2, z, str3, new Cif(nyVar)));
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m1350(String str, AbstractC2021ny nyVar) {
        C1283.m16854("nf_service_useragent", "removeWebUserProfile");
        m16092(this.f2202.m9204(str, new Cif(nyVar)));
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ʹ  reason: contains not printable characters */
    private boolean m1251() {
        return (this.f2196 == null || this.f2196.isEmpty() || this.f2204 == null) ? false : true;
    }

    @Override // com.netflix.mediaclient.service.user.UserAgentInterface
    /* renamed from: ˏˏ  reason: contains not printable characters */
    public void mo1360() {
        m1331((AbstractC2021ny) null);
    }

    @Override // com.netflix.mediaclient.service.user.UserAgentInterface
    /* renamed from: ॱͺ  reason: contains not printable characters */
    public String mo1374() {
        if (this.f2210 != null) {
            return this.f2210.getGeoCountry();
        }
        C1283.m16854("nf_service_useragent", "getGeoCountry is null");
        return null;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˊ  reason: contains not printable characters */
    private void m1271(String str, ProfileActivatedSource profileActivatedSource) {
        if (this.f2196 == null) {
            m1319("mListOfUserProfiles is null");
            return;
        }
        for (UserProfile userProfile : this.f2196) {
            if (userProfile.getProfileGuid().equals(str)) {
                this.f2210 = userProfile;
                C1061.m16114().mo14177(this.f2210);
                if (!(this.f2210 == null || this.f2210.getSubtitlePreference() == null)) {
                    this.f2206 = mo1383().getSubtitlePreference();
                }
                m1308(this.f2210.getLanguages());
                if (profileActivatedSource == ProfileActivatedSource.restoreProfile) {
                    C1283.m16854("nf_service_useragent", "Reinit existing user on cold start, send check in.");
                    m16086().mo1511().mo1482(AdvertiserIdLogging.EventType.check_in.name());
                    C2018nv.m9355(m16093());
                    return;
                }
                C1283.m16854("nf_service_useragent", "Login or switch profile, notify others...");
                m1260();
                return;
            }
        }
        m1319("Activated ProfileId not found in list of user profiles: ");
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private void m1319(String str) {
        this.f2210 = null;
        this.f2206 = null;
        C1283.m16850("nf_service_useragent", str);
        if (t_() != null) {
            C1283.m16850("nf_service_useragent", str);
            m16086().mo1515().mo5714(str);
        }
    }

    /* renamed from: ʼˊ  reason: contains not printable characters */
    private void m1260() {
        C2018nv.m9355(m16093());
        Intent intent = new Intent("com.netflix.mediaclient.intent.action.PUSH_ONLOGIN");
        intent.addCategory("com.netflix.mediaclient.intent.category.PUSH");
        LocalBroadcastManager.getInstance(m16093()).sendBroadcast(intent);
        m16086().mo1504().mo5775("Login complete");
        PartnerReceiver.m1250(m16093(), true);
    }

    /* renamed from: ʻᐝ  reason: contains not printable characters */
    private void m1257() {
        this.f2210 = null;
        this.f2206 = null;
        C2018nv.m9353(m16093());
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m1335(String str) {
        C1283.m16854("nf_service_useragent", "fetchProfileData");
        m16092(this.f2202.m9190(str, new AbstractC2016nt() { // from class: com.netflix.mediaclient.service.user.UserAgent.15
            @Override // o.AbstractC2016nt, o.AbstractC2022nz
            /* renamed from: ˋ */
            public void mo1386(UserProfile userProfile, Status status) {
                boolean r2 = UserAgent.this.m1296(userProfile);
                if (status.mo298() && r2) {
                    if (!C1349Bv.m4126(UserAgent.this.f2210.toString(), userProfile.toString())) {
                        UserAgent.this.m1316(userProfile);
                        if (!C1349Bv.m4126(UserAgent.this.f2210.getLanguagesInCsv(), userProfile.getLanguagesInCsv())) {
                            C1283.m16854("nf_service_useragent", "onProfileDataFetched language changed, changeUser ");
                            UserAgent.this.m1308(userProfile.getLanguages());
                        }
                        UserAgent.this.f2206 = userProfile.getSubtitlePreference();
                        UserAgent.this.f2210 = userProfile;
                        return;
                    }
                    C1283.m16854("nf_service_useragent", "onProfileDataFetched nothing changed ignore.. ");
                }
            }
        }));
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m1336(String str, String str2) {
        if (C1349Bv.m4107(str)) {
            C1283.m16851("nf_service_useragent", "record ums impression msgType: %s, impressionType:%s", str, str2);
            m16092(this.f2202.m9199(str, str2));
            return;
        }
        C1283.m16854("nf_service_useragent", "msgName or impressionType is null - skip reporting");
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    public void m1376(String str) {
        if (C1349Bv.m4107(str)) {
            C1283.m16851("nf_service_useragent", "sending umaAlertFeedback: %s", str);
            m16092(this.f2202.m9194(str));
            return;
        }
        C1283.m16854("nf_service_useragent", "umaAlertFeedback is empty - skip reporting");
    }

    /* renamed from: ॱʼ  reason: contains not printable characters */
    public Single<Status> m1372() {
        return Single.create(new SingleOnSubscribe<Status>() { // from class: com.netflix.mediaclient.service.user.UserAgent.13
            @Override // io.reactivex.SingleOnSubscribe
            public void subscribe(final SingleEmitter<Status> singleEmitter) {
                UserAgent.this.m16092(UserAgent.this.f2202.m9189(new AbstractC2016nt() { // from class: com.netflix.mediaclient.service.user.UserAgent.13.1
                    @Override // o.AbstractC2016nt, o.AbstractC2022nz
                    /* renamed from: ˎ  reason: contains not printable characters */
                    public void mo1389(Status status) {
                        singleEmitter.onSuccess(status);
                    }
                }));
            }
        }).subscribeOn(Schedulers.io());
    }

    /* renamed from: ॱʻ  reason: contains not printable characters */
    public Observable<Status> m1371() {
        return Observable.create(new ObservableOnSubscribe<Status>() { // from class: com.netflix.mediaclient.service.user.UserAgent.12
            @Override // io.reactivex.ObservableOnSubscribe
            public void subscribe(final ObservableEmitter<Status> observableEmitter) {
                UserAgent.this.m16092(UserAgent.this.f2202.m9185(new AbstractC2016nt() { // from class: com.netflix.mediaclient.service.user.UserAgent.12.1
                    @Override // o.AbstractC2016nt, o.AbstractC2022nz
                    /* renamed from: ॱ  reason: contains not printable characters */
                    public void mo1388(Status status) {
                        observableEmitter.onNext(status);
                    }
                }));
            }
        }).subscribeOn(Schedulers.io());
    }

    /* renamed from: ـ  reason: contains not printable characters */
    public void m1363() {
        User user = this.f2204;
        if (user != null) {
            C1283.m16854("nf_service_useragent", "UMA refreshing from server...");
            m16092(this.f2202.m9193(m16093(), user));
            return;
        }
        C1283.m16850("nf_service_useragent", "User is missing, unable to refresh user messages!");
    }

    /* renamed from: ॱʽ  reason: contains not printable characters */
    public EogAlert m1373() {
        if (null != this.f2204) {
            return this.f2204.eogAlert;
        }
        return null;
    }

    /* renamed from: ᐨ  reason: contains not printable characters */
    public UmaAlert m1381() {
        if (mo1383() == null || mo1383().isKidsProfile() || null == this.f2204) {
            return null;
        }
        return this.f2204.getUmaAlert();
    }

    /* renamed from: ᐝᐝ  reason: contains not printable characters */
    public void m1379() {
        UmaAlert r3;
        if (this.f2204 != null && (r3 = m1381()) != null) {
            r3.setConsumed(true);
            nD.m9127(m16093(), this.f2204);
            LocalBroadcastManager.getInstance(m16093()).sendBroadcast(new Intent("RefreshUserMessageRequest.ACTION_UMA_MESSAGE_CONSUMED"));
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m1348(String str, String str2) {
        if (!C1349Bv.m4107(str) || !C1349Bv.m4107(str2)) {
            C1283.m16854("nf_service_useragent", "planId or priceTier is null - skip reporting");
            return;
        }
        C1283.m16851("nf_service_useragent", "record ums planSelection plandId: %s, priceTier:%s", str, str2);
        m16092(this.f2202.m9188(str, str2));
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m1351(final AbstractC2021ny nyVar) {
        C1283.m16854("nf_service_useragent", "fetchAvailableAvatarsList");
        m16092(this.f2202.m9201(new AbstractC2016nt() { // from class: com.netflix.mediaclient.service.user.UserAgent.11
            @Override // o.AbstractC2016nt, o.AbstractC2022nz
            /* renamed from: ˋ  reason: contains not printable characters */
            public void mo1387(List<AvatarInfo> list, Status status) {
                if (nyVar != null) {
                    nyVar.mo9384(list, status);
                }
            }
        }));
    }

    @Override // com.netflix.mediaclient.service.user.UserAgentInterface
    /* renamed from: ᐝˊ  reason: contains not printable characters */
    public SubtitlePreference mo1377() {
        return this.f2206;
    }

    @Override // com.netflix.mediaclient.service.user.UserAgentInterface
    /* renamed from: ᐝˋ  reason: contains not printable characters */
    public SubtitlePreference mo1378() {
        return this.f2208;
    }

    public final class If extends BroadcastReceiver {
        public If() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                String action = intent.getAction();
                if ("com.netflix.mediaclient.intent.action.LOCAL_PLAYER_PLAY_STOP".equals(action)) {
                    if (UserAgent.this.mo1340() == null || UserAgent.this.f2210 == null) {
                        C1283.m16862("nf_service_useragent", "canDoDataFetches false - skipping fetchProfileData request");
                        return;
                    }
                    C1283.m16862("nf_service_useragent", "Starting userProfile fetch ");
                    UserAgent.this.m1335(UserAgent.this.mo1340());
                    UserAgent.this.m16086().mo1514();
                } else if ("com.netflix.mediaclient.intent.action.DELETED_PROFILE".equals(action)) {
                    UserAgent.this.f2210 = null;
                    UserAgent.this.m1355(context, StatusCode.DELETED_PROFILE);
                } else if ("com.netflix.mediaclient.intent.action.HOME_TTR_DONE".equals(action)) {
                    UserAgent.this.m1253((AbstractC2021ny) null);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ˏ  reason: contains not printable characters */
    public void m1355(Context context, StatusCode statusCode) {
        C1283.m16854("nf_service_useragent", "onAccountErrors statusCode: " + statusCode);
        if (!StatusCode.DELETED_PROFILE.equals(statusCode)) {
            return;
        }
        if (!m1255()) {
            mo1360();
        } else {
            C2018nv.m9358(context);
        }
    }

    /* renamed from: ʼˋ  reason: contains not printable characters */
    private UserProfile m1261() {
        if (this.f2196 == null) {
            return null;
        }
        for (UserProfile userProfile : this.f2196) {
            if (userProfile != null && userProfile.isPrimaryProfile()) {
                return userProfile;
            }
        }
        return null;
    }

    /* renamed from: ʻˊ  reason: contains not printable characters */
    private boolean m1255() {
        C1283.m16854("nf_service_useragent", "fallbackToPrimaryAccount");
        UserProfile r2 = m1261();
        if (r2 == null) {
            return false;
        }
        m1357(r2.getProfileGuid());
        return true;
    }

    /* renamed from: ʻˋ  reason: contains not printable characters */
    private void m1256() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.netflix.mediaclient.intent.action.DELETED_PROFILE");
        intentFilter.addAction("com.netflix.mediaclient.intent.action.LOCAL_PLAYER_PLAY_STOP");
        intentFilter.addAction("com.netflix.mediaclient.intent.action.HOME_TTR_DONE");
        LocalBroadcastManager.getInstance(m16093()).registerReceiver(this.f2209, intentFilter);
    }

    /* renamed from: ʼᐝ  reason: contains not printable characters */
    private void m1262() {
        try {
            LocalBroadcastManager.getInstance(m16093()).unregisterReceiver(this.f2209);
        } catch (Exception e) {
            C1283.m16862("nf_service_useragent", "unregisterUserAgentEventReceiver " + e);
        }
    }

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private boolean m1285(String str) {
        String r4 = m16101().mo16503();
        C1283.m16863("nf_service_useragent", "userEnteredPinMatchesStoredPin usrPin=%s", r4);
        return C1349Bv.m4113(r4) || str.equals(r4);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m1347(String str, UserAgentInterface.PinType pinType, String str2, final AbstractC2021ny nyVar) {
        AnonymousClass14 r2 = new AbstractC2016nt() { // from class: com.netflix.mediaclient.service.user.UserAgent.14
            @Override // o.AbstractC2016nt, o.AbstractC2022nz
            /* renamed from: ॱ  reason: contains not printable characters */
            public void mo1390(final boolean z, final Status status) {
                if (nyVar != null) {
                    UserAgent.this.s_().post(new Runnable() { // from class: com.netflix.mediaclient.service.user.UserAgent.14.4
                        @Override // java.lang.Runnable
                        public void run() {
                            nyVar.mo9378(z, status);
                        }
                    });
                }
            }
        };
        if (ConnectivityUtils.m2954(m16093())) {
            m16092(this.f2202.m9203(str, pinType, str2, r2));
        } else if (pinType == UserAgentInterface.PinType.PREVIEW_CONTENT_PIN) {
            r2.mo1390(false, (Status) AbstractC0367.f13238);
        } else {
            r2.mo1390(m1285(str), AbstractC0367.f13235);
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m1367(final AbstractC2021ny nyVar) {
        m16092(this.f2202.m9197(new AbstractC2016nt() { // from class: com.netflix.mediaclient.service.user.UserAgent.16
            @Override // o.AbstractC2016nt, o.AbstractC2022nz
            /* renamed from: ˋ  reason: contains not printable characters */
            public void mo1391(User user, final Status status) {
                if (status.mo298()) {
                    nD.m9127(UserAgent.this.m16093(), user);
                }
                if (nyVar != null) {
                    UserAgent.this.s_().post(new Runnable() { // from class: com.netflix.mediaclient.service.user.UserAgent.16.4
                        @Override // java.lang.Runnable
                        public void run() {
                            nyVar.mo9378(UserAgent.this.f2204.isAgeVerified(), status);
                        }
                    });
                }
            }
        }));
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public void m1375(final AbstractC2021ny nyVar) {
        m16092(this.f2202.m9186(new AbstractC2016nt() { // from class: com.netflix.mediaclient.service.user.UserAgent.18
            @Override // o.AbstractC2016nt, o.AbstractC2022nz
            /* renamed from: ˎ  reason: contains not printable characters */
            public void mo1392(final CL cl, final Status status) {
                if (nyVar != null) {
                    UserAgent.this.s_().post(new Runnable() { // from class: com.netflix.mediaclient.service.user.UserAgent.18.5
                        @Override // java.lang.Runnable
                        public void run() {
                            nyVar.mo9379(cl, status);
                        }
                    });
                }
            }
        }));
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m1356(OnRampEligibility.Action action, final AbstractC2021ny nyVar) {
        m16092(this.f2202.m9202(action, new AbstractC2016nt() { // from class: com.netflix.mediaclient.service.user.UserAgent.19
            @Override // o.AbstractC2016nt, o.AbstractC2022nz
            /* renamed from: ॱ  reason: contains not printable characters */
            public void mo1393(final OnRampEligibility onRampEligibility, final Status status) {
                UserAgent.this.s_().post(new Runnable() { // from class: com.netflix.mediaclient.service.user.UserAgent.19.2
                    @Override // java.lang.Runnable
                    public void run() {
                        nyVar.mo9383(onRampEligibility, status);
                    }
                });
            }
        }));
    }

    /* renamed from: ᐧ  reason: contains not printable characters */
    public void m1380() {
        m16092(this.f2202.m9191());
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public boolean m1370(Intent intent) {
        if (intent == null) {
            C1283.m16865("nf_service_useragent", "Intent is null");
            return false;
        }
        String action = intent.getAction();
        if ("com.netflix.mediaclient.intent.action.USER_AUTOLOGIN".equals(action)) {
            m1290(intent);
            return true;
        } else if ("com.netflix.mediaclient.intent.action.USER_CREATE_AUTOLOGIN_TOKEN".equals(action)) {
            m1276(intent);
            return true;
        } else {
            C1283.m16850("nf_service_useragent", "Uknown command!");
            return false;
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m1276(Intent intent) {
        C1283.m16850("nf_service_useragent", "You can not create auto login token in production!");
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m1290(Intent intent) {
        C1283.m16854("nf_service_useragent", "Handle autologin");
        C1339Bl.m4049(this.f2207);
        s_().post(new Runnable() { // from class: com.netflix.mediaclient.service.user.UserAgent.17
            @Override // java.lang.Runnable
            public void run() {
                UserAgent.this.m16096().mo9578(30, true);
            }
        });
        String stringExtra = intent.getStringExtra("token");
        if (C1349Bv.m4113(stringExtra)) {
            C1283.m16850("nf_service_useragent", "Token not found, autologin is not possible");
            return;
        }
        C1283.m16854("nf_service_useragent", "Execute autologin with token: " + stringExtra);
        if (this.f2204 != null) {
            C1283.m16850("nf_service_useragent", "User is already logged in, autologin is NOT possible!");
            return;
        }
        C1363Ci.m4428(SignInLogging.SignInType.autologin);
        final Long r4 = Logger.INSTANCE.m142(new C0962());
        m16092(this.f2202.m9196(stringExtra, new AbstractC2016nt() { // from class: com.netflix.mediaclient.service.user.UserAgent.24
            @Override // o.AbstractC2016nt, o.AbstractC2022nz
            /* renamed from: ˎ  reason: contains not printable characters */
            public void mo1404(C0614 r42, Status status) {
                if (!status.mo298() || r42 == null) {
                    C1363Ci.m4425(SignInLogging.SignInType.autologin, IClientLogging.CompletionReason.failed, C1343Bp.m4064(status));
                    Logger.INSTANCE.m145(r4, C1343Bp.m4068(status));
                } else {
                    C1283.m16854("nf_service_useragent", "Autologin success, go token activate");
                    r42.f13918 = true;
                    UserAgent.this.m1307(r42, (AbstractC2021ny) null);
                }
                UserAgent.this.s_().post(new Runnable() { // from class: com.netflix.mediaclient.service.user.UserAgent.24.4
                    @Override // java.lang.Runnable
                    public void run() {
                        UserAgent.this.m16096().mo9578(30, true);
                    }
                });
            }
        }));
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x003d: APUT  (r2v1 java.lang.Object[]), (0 ??[int, short, byte, char]), (r3v2 java.lang.String) */
    @Override // com.netflix.mediaclient.service.user.UserAgentInterface
    /* renamed from: ꜞ  reason: contains not printable characters */
    public String mo1384() {
        C1283.m16862("nf_service_useragent", "getPrimaryProfileGuid");
        if (this.f2196 == null) {
            return null;
        }
        for (UserProfile userProfile : this.f2196) {
            if (userProfile.isPrimaryProfile()) {
                Object[] objArr = new Object[2];
                objArr[0] = C1349Bv.m4107(userProfile.getProfileName()) ? userProfile.getProfileName() : "";
                objArr[1] = userProfile.getProfileGuid();
                C1283.m16851("nf_service_useragent", "primaryProfileName: %s, %s ", objArr);
                return userProfile.getProfileGuid();
            }
        }
        return null;
    }

    /* renamed from: ㆍ  reason: contains not printable characters */
    public boolean m1382() {
        if (this.f2204 != null) {
            return this.f2204.isAgeVerified();
        }
        return false;
    }

    @Override // com.netflix.mediaclient.service.user.UserAgentInterface
    /* renamed from: ʽ  reason: contains not printable characters */
    public boolean mo1327(String str) {
        if (C1338Bk.m4035(str, this.f2204)) {
            return true;
        }
        C1283.m16854("nf_service_useragent", "Privacy violatoon NOT found, value can be logged safely.");
        return false;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m1352(boolean z) {
        this.f2205 = z;
    }

    /* renamed from: ꜟ  reason: contains not printable characters */
    public boolean m1385() {
        return this.f2205;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m1345(long j, final AbstractC2021ny nyVar) {
        if (nyVar == null) {
            throw new IllegalStateException("Callback can not be null!");
        }
        C1283.m16854("nf_service_useragent", "Create auto login token");
        m16092(this.f2202.m9192(j, new AbstractC2016nt() { // from class: com.netflix.mediaclient.service.user.UserAgent.25
            @Override // o.AbstractC2016nt, o.AbstractC2022nz
            /* renamed from: ˊ  reason: contains not printable characters */
            public void mo1405(final String str, final Status status) {
                UserAgent.this.s_().post(new Runnable() { // from class: com.netflix.mediaclient.service.user.UserAgent.25.5
                    @Override // java.lang.Runnable
                    public void run() {
                        nyVar.mo9377(str, status);
                    }
                });
            }
        }));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.netflix.mediaclient.service.user.UserAgent$ˊ  reason: contains not printable characters */
    public class C0023 implements oR, AbstractC2031og {

        /* renamed from: ˊ  reason: contains not printable characters */
        private AbstractC1412Ec f2298;

        /* renamed from: ˎ  reason: contains not printable characters */
        private String f2300;

        /* renamed from: ˏ  reason: contains not printable characters */
        private String f2301;

        /* renamed from: ॱ  reason: contains not printable characters */
        private String f2302;

        private C0023() {
        }

        @Override // o.oR
        /* renamed from: ˊ */
        public synchronized String mo1403() {
            return this.f2300;
        }

        @Override // o.AbstractC2031og
        /* renamed from: ʻ */
        public synchronized String mo1395() {
            return this.f2300;
        }

        @Override // o.oR
        public synchronized AbstractC1412Ec L_() {
            if (UserAgent.this.m16101().mo16511()) {
                return this.f2298;
            }
            String r2 = mo1403();
            if (C1349Bv.m4113(r2)) {
                C1283.m16865("nf_service_useragent", "getMSLUserCredentialRegistry:: User profile is not known, regular workflow");
                return this.f2298;
            } else if (UserAgent.this.m16087().mo6788(r2)) {
                C1283.m16854("nf_service_useragent", "getMSLUserCredentialRegistry:: User profile is known to MSL, regular workflow.");
                return this.f2298;
            } else {
                return m1410();
            }
        }

        /* renamed from: ʽ  reason: contains not printable characters */
        private AbstractC1412Ec m1410() {
            C1283.m16854("nf_service_useragent", "getMSLUserCredentialRegistry:: User profile is NOT known to MSL, get cookies for UserAuthenticationData.");
            String r5 = mo1399();
            String r6 = mo1397();
            boolean z = false;
            if (C1349Bv.m4113(r5)) {
                C1283.m16844("nf_service_useragent", "getMSLUserCredentialRegistry:: Netflix ID is NOT known for profile %s even if it should be!", this.f2300);
                z = true;
            }
            if (C1349Bv.m4113(r6)) {
                C1283.m16844("nf_service_useragent", "getMSLUserCredentialRegistry:: Secure Netflix ID is NOT known for profile %s even if it should be!", this.f2300);
                z = true;
            }
            if (z) {
                return this.f2298;
            }
            C1283.m16851("nf_service_useragent", "getMSLUserCredentialRegistry:: Authorization cookies known for profile %s", this.f2300);
            return new DZ(r5, r6);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: ˎ  reason: contains not printable characters */
        public synchronized void m1417(String str) {
            boolean z = true;
            if (this.f2300 != null && this.f2300.equals(str)) {
                z = false;
            }
            this.f2300 = str;
            if (z) {
                m1418((AbstractC1412Ec) null);
                m1414(str);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: ˎ  reason: contains not printable characters */
        public synchronized void m1418(AbstractC1412Ec ec) {
            this.f2298 = ec;
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        private void m1414(String str) {
            if (str == null) {
                C1283.m16865("nf_service_useragent", "");
                C1339Bl.m4041(UserAgent.this.m16093(), "useragent_current_profile_id");
            } else if (!"TEMP_PROFILE_ID".equals(str)) {
                C1339Bl.m4039(UserAgent.this.m16093(), "useragent_current_profile_id", str);
            }
        }

        @Override // o.AbstractC2031og
        /* renamed from: ॱ */
        public String mo1401() {
            return C1376Cs.m4554(C1279.m16829(UserAgent.this.m16101().mo16547().mo1454()));
        }

        @Override // o.AbstractC2031og
        /* renamed from: ˎ */
        public String mo1398() {
            return C1376Cs.m4549(C1279.m16829(UserAgent.this.m16101().mo16547().mo1454()));
        }

        @Override // o.AbstractC2031og
        /* renamed from: ˏ */
        public synchronized String mo1399() {
            if (!UserAgent.this.mo1333()) {
                return (UserAgent.this.m16101() == null || UserAgent.this.m16101().mo16531() == null) ? null : UserAgent.this.m16101().mo16531().netflixId;
            }
            return this.f2301;
        }

        @Override // o.AbstractC2031og
        /* renamed from: ˋ */
        public synchronized String mo1397() {
            if (!UserAgent.this.mo1333()) {
                return (UserAgent.this.m16101() == null || UserAgent.this.m16101().mo16531() == null) ? null : UserAgent.this.m16101().mo16531().secureNetflixId;
            }
            return this.f2302;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        /* renamed from: ॱ  reason: contains not printable characters */
        private void m1416(AuthorizationCredentials authorizationCredentials) {
            C1283.m16851("nf_service_useragent", "Update user credentials: %s : %s, %s : %s", mo1401(), authorizationCredentials.netflixId, mo1398(), authorizationCredentials.secureNetflixId);
            this.f2301 = authorizationCredentials.netflixId;
            this.f2302 = authorizationCredentials.secureNetflixId;
        }

        @Override // o.AbstractC2031og
        /* renamed from: ˏ */
        public synchronized boolean mo1400(AuthorizationCredentials authorizationCredentials) {
            if (authorizationCredentials == null) {
                C1283.m16850("nf_service_useragent", "We did not received authorization credentials!");
                return false;
            } else if (C1349Bv.m4113(authorizationCredentials.userId)) {
                C1283.m16850("nf_service_useragent", "We did not received back userId!");
                return false;
            } else {
                String str = this.f2300;
                if (authorizationCredentials.userId.equals(str)) {
                    C1283.m16854("nf_service_useragent", "Same user, update cookies!");
                    m1416(authorizationCredentials);
                    UserAgent.this.m16094().mo6504(this.f2300, authorizationCredentials);
                    return true;
                }
                C1283.m16855("nf_service_useragent", "User in update %s differs than current user %s, profile is changed, DO NOT update cookies!", authorizationCredentials.userId, str);
                return false;
            }
        }

        /* renamed from: ॱॱ  reason: contains not printable characters */
        public synchronized void m1419() {
            this.f2301 = null;
            this.f2302 = null;
        }

        /* renamed from: ᐝ  reason: contains not printable characters */
        public synchronized void m1420() {
            m1419();
            m1417((String) null);
        }
    }
}
