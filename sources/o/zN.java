package o;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.LocaleList;
import android.text.Html;
import android.text.Spanned;
import com.netflix.android.moneyball.FlowMode;
import com.netflix.android.moneyball.fields.ActionField;
import com.netflix.cl.Logger;
import com.netflix.cl.model.AppView;
import com.netflix.mediaclient.NetflixApplication;
import com.netflix.mediaclient.acquisition.SignupNativeActivity;
import com.netflix.mediaclient.acquisition.SignupNativeTabletActivity;
import com.netflix.mediaclient.acquisition.fragments.WelcomeFragment;
import com.netflix.mediaclient.acquisition.kotlinx.KeyPathEvaluationKt;
import com.netflix.mediaclient.acquisition.util.AUIMoneyballUtilities;
import com.netflix.mediaclient.acquisition.viewmodels.AbstractSignupViewModel;
import com.netflix.mediaclient.acquisition.viewmodels.SignupConstants;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.service.webclient.model.leafs.MoneyballData;
import com.netflix.mediaclient.service.webclient.model.leafs.NrmLanguagesData;
import com.netflix.mediaclient.service.webclient.model.leafs.SignInConfigData;
import com.netflix.mediaclient.servicemgr.AdvertiserIdLogging;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.TypeCastException;
import org.json.JSONObject;
public final class zN {

    /* renamed from: ˋ  reason: contains not printable characters */
    private static final String f12695 = f12695;

    /* renamed from: ˎ  reason: contains not printable characters */
    private static Long f12696 = null;

    /* renamed from: ॱ  reason: contains not printable characters */
    public static final Cif f12697 = new Cif(null);

    /* renamed from: o.zN$if  reason: invalid class name */
    public static final class Cif {
        private Cif() {
        }

        public /* synthetic */ Cif(C1456Fq fq) {
            this();
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        private final String m13515() {
            return zN.f12695;
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        private final void m13513(Long l) {
            zN.f12696 = l;
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        private final Long m13514() {
            return zN.f12696;
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        public final boolean m13528(Context context) {
            C1457Fr.m5025(context, "context");
            SignInConfigData r1 = new C0365(context).m14067();
            return (r1 != null && r1.isAndroidNative()) || C0696.f14200.m14988();
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        public final boolean m13526() {
            return AD.m3312(600);
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public final Intent m13529(Context context) {
            C1457Fr.m5025(context, "context");
            if (zN.f12697.m13523(context)) {
                Intent r0 = ActivityC2186tp.m11240(context);
                C1457Fr.m5016((Object) r0, "LoginActivity.createStartIntent(context)");
                return r0;
            } else if (!m13528(context)) {
                Intent r02 = zJ.m13442(context);
                C1457Fr.m5016((Object) r02, "SignupActivity.createShowIntent(context)");
                return r02;
            } else if (m13526()) {
                return SignupNativeTabletActivity.Companion.createStartIntent(context);
            } else {
                return SignupNativeActivity.Companion.createStartIntent(context);
            }
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public final Intent m13517(Context context) {
            C1457Fr.m5025(context, "context");
            Intent r2 = m13529(context);
            r2.putExtra("useDynecomCookies", true);
            return r2;
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        public final boolean m13523(Context context) {
            C1457Fr.m5025(context, "context");
            SignInConfigData r5 = new C0365(context).m14067();
            String str = Build.MANUFACTURER;
            C1457Fr.m5016((Object) str, "Build.MANUFACTURER");
            if (str == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            String lowerCase = str.toLowerCase();
            C1457Fr.m5016((Object) lowerCase, "(this as java.lang.String).toLowerCase()");
            boolean r6 = Ge.m5105(lowerCase, "amazon", false, 2, null);
            C1457Fr.m5016((Object) r5, "signInConfigData");
            return r6 || r5.isSignupBlocked();
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        public final void m13527(C2059ph phVar, String str) {
            C1457Fr.m5025(str, "eventType");
            if (phVar != null && phVar.mo9519()) {
                IClientLogging r2 = phVar.m9825();
                if (r2 == null) {
                    C1283.m16850(m13515(), "CL is not available!");
                    return;
                }
                AdvertiserIdLogging r3 = r2.mo1511();
                if (r3 == null) {
                    C1283.m16850(m13515(), "AD logger is not available!");
                } else {
                    r3.mo1482(str);
                }
            }
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        public final String m13522(FlowMode flowMode) {
            if (flowMode == null) {
                return null;
            }
            Object pathValue = KeyPathEvaluationKt.getPathValue((Object) flowMode.getData(), (List<String>) EI.m4804("fields", SignupConstants.Field.FREE_TRIAL_END_DATE));
            if (pathValue instanceof String) {
                return (String) pathValue;
            }
            if (!(pathValue instanceof Map)) {
                return null;
            }
            Object obj = ((Map) pathValue).get("value");
            if (!(obj instanceof String)) {
                obj = null;
            }
            return (String) obj;
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        public final Spanned m13520(String str) {
            C1457Fr.m5025(str, "html");
            if (Build.VERSION.SDK_INT >= 24) {
                Spanned fromHtml = Html.fromHtml(str, 0);
                C1457Fr.m5016((Object) fromHtml, "Html.fromHtml(html, Html.FROM_HTML_MODE_LEGACY)");
                return fromHtml;
            }
            Spanned fromHtml2 = Html.fromHtml(str);
            C1457Fr.m5016((Object) fromHtml2, "Html.fromHtml(html)");
            return fromHtml2;
        }

        /* renamed from: ᐝ  reason: contains not printable characters */
        private final String m13516(Context context) {
            return null;
        }

        /* renamed from: ʽ  reason: contains not printable characters */
        private final String m13512(Context context) {
            return null;
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        public final String m13521() {
            List list;
            List list2;
            String[] strArr;
            if (Build.VERSION.SDK_INT >= 24) {
                Resources system = Resources.getSystem();
                C1457Fr.m5016((Object) system, "Resources.getSystem()");
                Configuration configuration = system.getConfiguration();
                C1457Fr.m5016((Object) configuration, "Resources.getSystem().configuration");
                LocaleList locales = configuration.getLocales();
                ArrayList arrayList = new ArrayList();
                int size = locales.size();
                for (int i = 0; i < size; i++) {
                    Locale locale = locales.get(i);
                    C1457Fr.m5016((Object) locale, "localeList.get(i)");
                    String language = locale.getLanguage();
                    C1457Fr.m5016((Object) language, "localeString");
                    arrayList.add(m13524(language));
                }
                list = arrayList;
            } else {
                NetflixApplication instance = NetflixApplication.getInstance();
                C1457Fr.m5016((Object) instance, "NetflixApplication.getInstance()");
                Resources resources = instance.getResources();
                C1457Fr.m5016((Object) resources, "NetflixApplication.getInstance().resources");
                Locale locale2 = resources.getConfiguration().locale;
                C1457Fr.m5016((Object) locale2, "NetflixApplication.getIn…rces.configuration.locale");
                list = EI.m4806(locale2.getLanguage());
            }
            NrmLanguagesData nrmLanguagesData = new C1262(NetflixApplication.getInstance(), "").f15911;
            if (nrmLanguagesData == null || (strArr = nrmLanguagesData.tags) == null || (list2 = ED.m4795(strArr)) == null) {
                list2 = EI.m4805();
            }
            String str = (String) EI.m4825(EI.m4839((Iterable) list, (Iterable) list2));
            if (str != null) {
                return str;
            }
            if (!list2.isEmpty()) {
                return (String) EI.m4833((List<? extends Object>) list2);
            }
            return "en";
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        public final String m13524(String str) {
            C1457Fr.m5025(str, "languageCode");
            String lowerCase = str.toLowerCase();
            C1457Fr.m5016((Object) lowerCase, "(this as java.lang.String).toLowerCase()");
            switch (lowerCase.hashCode()) {
                case 3365:
                    if (lowerCase.equals("in")) {
                        return "id";
                    }
                    break;
                case 3374:
                    if (lowerCase.equals("iw")) {
                        return "he";
                    }
                    break;
                case 3391:
                    if (lowerCase.equals("ji")) {
                        return "yi";
                    }
                    break;
            }
            return str;
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        public final Locale m13525(Context context) {
            C1457Fr.m5025(context, "context");
            String r3 = zN.f12697.m13521();
            String r5 = zN.f12697.m13516(context);
            if (r5 == null) {
                r5 = r3;
            }
            Locale locale = Locale.getDefault();
            C1457Fr.m5016((Object) locale, "Locale.getDefault()");
            String country = locale.getCountry();
            String r8 = zN.f12697.m13512(context);
            if (r8 == null) {
                r8 = country;
            }
            if (r8 == null) {
                r8 = "US";
            }
            Locale locale2 = new Locale(r5, r8);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("AndroidSignupNativeLocale", "" + r5 + '-' + r8);
            Logger.INSTANCE.m131(new C0729(jSONObject));
            return locale2;
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public final void m13518(int i, List<? extends C0738> list, AbstractSignupViewModel abstractSignupViewModel, C2059ph phVar, AbstractC1451Fl<? super MoneyballData, ? super Status, EA> fl) {
            C1457Fr.m5025(abstractSignupViewModel, "fragmentViewModel");
            C1457Fr.m5025(phVar, "serviceManager");
            C1457Fr.m5025(fl, "completion");
            if (i == 0) {
                if ((list != null ? (C0738) EI.m4828((List<? extends Object>) list) : null) != null) {
                    C0738 r6 = (C0738) EI.m4833((List<? extends Object>) list);
                    String r7 = r6.m15117();
                    String r8 = r6.m15116();
                    String optString = new JSONObject(r6.m15115()).optString(WelcomeFragment.KEY_PLAY_BILLING_DEVELOPER_PAYLOAD);
                    AUIMoneyballUtilities aUIMoneyballUtilities = AUIMoneyballUtilities.INSTANCE;
                    C1457Fr.m5016((Object) r7, SignupConstants.Field.RECEIPT);
                    C1457Fr.m5016((Object) r8, SignupConstants.Field.PARTNER_RESPONSE_SIGNATURE);
                    C1457Fr.m5016((Object) optString, SignupConstants.Field.DEV_PAYLOAD);
                    aUIMoneyballUtilities.sendRestoreRequestToMoneyball(phVar, r7, r8, optString, fl);
                    return;
                }
            }
            ActionField nextAction = abstractSignupViewModel.getNextAction();
            if (nextAction != null) {
                abstractSignupViewModel.next(nextAction, phVar, fl);
            }
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public final void m13519(boolean z, AppView appView) {
            C1457Fr.m5025(appView, "appView");
            if (z) {
                m13513(Logger.INSTANCE.m142(new C1080(appView, null)));
            } else {
                Logger.INSTANCE.m140(m13514());
            }
        }
    }
}
