package o;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.preference.ListPreference;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceCategory;
import android.support.v7.preference.PreferenceFragmentCompat;
import android.support.v7.preference.PreferenceGroup;
import android.support.v7.preference.PreferenceScreen;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.text.style.TextAppearanceSpan;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.app.NetworkErrorStatus;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.partner.PartnerInstallType;
import com.netflix.mediaclient.service.logging.uiview.model.CommandEndedEvent;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.UIViewLogging;
import com.netflix.mediaclient.servicemgr.interface_.offline.DownloadVideoQuality;
import com.netflix.mediaclient.ui.bandwidthsetting.BandwidthPreference;
import com.netflix.mediaclient.ui.bandwidthsetting.BandwidthPreferenceDialogFragment;
import com.netflix.mediaclient.ui.diagnosis.DiagnosisActivity;
import com.netflix.mediaclient.ui.offline.DownloadButton;
import com.netflix.mediaclient.ui.settings.NetflixSwitchPreference;
import com.netflix.mediaclient.util.l10n.BidiMarker;
import java.util.ArrayList;
public class zE extends PreferenceFragmentCompat implements oV, SharedPreferences.OnSharedPreferenceChangeListener {

    /* renamed from: ˊ  reason: contains not printable characters */
    private iF f12558;

    /* renamed from: ˋ  reason: contains not printable characters */
    private Dialog f12559;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final AbstractC2068pq f12560 = new AbstractC2068pq() { // from class: o.zE.3
        @Override // o.AbstractC2068pq, o.AbstractC1854hm
        /* renamed from: ˋ */
        public void mo1758(Status status) {
            AbstractC1853hl offlineAgentOrNull;
            NetflixActivity netflixActivity = (NetflixActivity) C1317As.m3755(zE.this.getActivity(), NetflixActivity.class);
            if (netflixActivity != null && (offlineAgentOrNull = NetflixActivity.getOfflineAgentOrNull(netflixActivity)) != null) {
                offlineAgentOrNull.mo7135(zE.this.f12560);
                zE.this.m13400();
            }
        }

        @Override // o.AbstractC1854hm
        public boolean aa_() {
            return C1317As.m3750((NetflixActivity) C1317As.m3755(zE.this.getActivity(), NetflixActivity.class));
        }
    };

    /* renamed from: ˏ  reason: contains not printable characters */
    private Activity f12561;

    /* renamed from: ॱ  reason: contains not printable characters */
    private C2059ph f12562;

    public interface iF {
        /* renamed from: ॱˊ */
        String mo13382();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static Fragment m13412() {
        return new zE();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˎ  reason: contains not printable characters */
    private void m13400() {
        zC zCVar = (zC) C1317As.m3755(getActivity(), zC.class);
        if (zCVar != null) {
            Preference findPreference = findPreference("pref.downloads.remove_all");
            PreferenceGroup preferenceGroup = (PreferenceGroup) findPreference("pref.downloads");
            if (!(preferenceGroup == null || findPreference == null)) {
                preferenceGroup.removePreference(findPreference);
            }
            AbstractC1853hl r5 = zCVar.getServiceManager().m9832();
            if (r5 != null) {
                r5.mo7139();
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof Activity) {
            try {
                this.f12558 = (iF) activity;
            } catch (ClassCastException e) {
                throw new ClassCastException(activity.toString() + " must implement ActivityCallbackListener");
            }
        }
    }

    @Override // android.support.v7.preference.PreferenceFragmentCompat, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f12561 = getActivity();
    }

    @Override // android.support.v7.preference.PreferenceFragmentCompat
    public void onCreatePreferences(Bundle bundle, String str) {
        getPreferenceManager().setSharedPreferencesMode(0);
        getPreferenceManager().setSharedPreferencesName("nfxpref");
        addPreferencesFromResource(R.xml.settings);
        Preference findPreference = findPreference("pref.downloads.video_quality");
        if (findPreference instanceof ListPreference) {
            m13388((ListPreference) findPreference);
        }
        m13386();
        m13398();
        m13419();
        m13408();
        Preference findPreference2 = findPreference("pref.qa.debugonly");
        Preference findPreference3 = findPreference("pref.screen");
        if ((findPreference3 instanceof PreferenceGroup) && findPreference2 != null) {
            ((PreferenceGroup) findPreference3).removePreference(findPreference2);
        }
        if (C1337Bj.m4033()) {
            m13395();
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m13395() {
        C1283.m16854("SettingsFragment", "removing qa.debugonly preferences for partner build");
        Preference findPreference = findPreference("pref.qa.debugonly");
        Preference findPreference2 = findPreference("ui.castAppId");
        if ((findPreference instanceof PreferenceGroup) && findPreference2 != null) {
            C1283.m16854("SettingsFragment", "removing ui.castAppId");
            ((PreferenceGroup) findPreference).removePreference(findPreference2);
        }
        Preference findPreference3 = findPreference("ui.bootParams");
        if ((findPreference instanceof PreferenceGroup) && findPreference3 != null) {
            C1283.m16854("SettingsFragment", "removing ui.bootParams");
            ((PreferenceGroup) findPreference).removePreference(findPreference3);
        }
        Preference findPreference4 = findPreference("ui.reset_license_sync_time");
        if ((findPreference instanceof PreferenceGroup) && findPreference4 != null) {
            C1283.m16854("SettingsFragment", "removing ui.reset_license_sync_time");
            ((PreferenceGroup) findPreference).removePreference(findPreference4);
        }
        Preference findPreference5 = findPreference("ui.reset_bootloader");
        if ((findPreference instanceof PreferenceGroup) && findPreference5 != null) {
            C1283.m16854("SettingsFragment", "removing ui.reset_bootloader");
            ((PreferenceGroup) findPreference).removePreference(findPreference5);
        }
        Preference findPreference6 = findPreference("ui.site");
        if ((findPreference instanceof PreferenceGroup) && findPreference6 != null) {
            C1283.m16854("SettingsFragment", "removing ui.site");
            ((PreferenceGroup) findPreference).removePreference(findPreference6);
        }
    }

    @Override // android.support.v7.preference.PreferenceFragmentCompat, android.support.v7.preference.PreferenceManager.OnDisplayPreferenceDialogListener
    public void onDisplayPreferenceDialog(Preference preference) {
        if (preference instanceof BandwidthPreference) {
            BandwidthPreferenceDialogFragment r2 = BandwidthPreferenceDialogFragment.m1588();
            r2.setTargetFragment(this, 0);
            r2.show(getFragmentManager(), "android.support.v7.preference.PreferenceFragment.DIALOG");
            return;
        }
        super.onDisplayPreferenceDialog(preference);
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if ("nf_play_no_wifi_warning".equals(str)) {
            C1339Bl.m4048((Context) getActivity(), "nf_play_no_wifi_warning", false);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m13387() {
        C0577.m14689(getActivity());
        m13418();
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m13401(final C2059ph phVar) {
        NetflixSwitchPreference netflixSwitchPreference;
        if (phVar.m9832() != null && (netflixSwitchPreference = (NetflixSwitchPreference) findPreference("pref.downloads.wifi_only")) != null) {
            netflixSwitchPreference.setChecked(phVar.m9832().mo7131());
            netflixSwitchPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: o.zE.13
                @Override // android.support.v7.preference.Preference.OnPreferenceChangeListener
                public boolean onPreferenceChange(Preference preference, Object obj) {
                    phVar.m9832().mo7130(((Boolean) obj).booleanValue());
                    if (!((Boolean) obj).booleanValue() && zE.this.getActivity().getIntent() != null && zE.this.getActivity().getIntent().hasExtra(NetflixActivity.EXTRA_DL_PLAYABLE_ID)) {
                        zE.this.getActivity().setResult(-1, zE.this.getActivity().getIntent());
                        zE.this.getActivity().finish();
                    }
                    zE.this.m13413((Boolean) obj);
                    return true;
                }
            });
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m13390(C2059ph phVar) {
        NetflixSwitchPreference netflixSwitchPreference;
        final AbstractC1849hh r1 = phVar.m9828();
        if (r1 != null && (netflixSwitchPreference = (NetflixSwitchPreference) findPreference("pref.downloads.smart")) != null) {
            if (!C0880.m15595()) {
                netflixSwitchPreference.setVisible(false);
                return;
            }
            if (phVar.m9832() != null) {
                m13413(Boolean.valueOf(phVar.m9832().mo7131()));
            }
            netflixSwitchPreference.setChecked(r1.mo7054());
            netflixSwitchPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: o.zE.15
                @Override // android.support.v7.preference.Preference.OnPreferenceChangeListener
                public boolean onPreferenceChange(Preference preference, Object obj) {
                    r1.mo7055(((Boolean) obj).booleanValue());
                    return true;
                }
            });
        }
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    private void m13386() {
        if (!C0577.m14679(getContext())) {
            m13416();
            return;
        }
        Preference findPreference = findPreference("nf.bw_save");
        if (findPreference == null) {
            m13416();
            return;
        }
        m13404(getContext(), findPreference);
        findPreference.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: o.zE.14
            @Override // android.support.v7.preference.Preference.OnPreferenceClickListener
            public boolean onPreferenceClick(Preference preference) {
                C1283.m16854("SettingsFragment", "Debug: player type. preference:" + preference);
                return true;
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱ  reason: contains not printable characters */
    private void m13413(Boolean bool) {
        NetflixSwitchPreference netflixSwitchPreference = (NetflixSwitchPreference) findPreference("pref.downloads.smart");
        if (netflixSwitchPreference != null) {
            if (bool.booleanValue()) {
                netflixSwitchPreference.setSummary(getString(R.string.label_pref_settings_smart_downloads_summary_wifi_only_enabled));
            } else {
                netflixSwitchPreference.setSummary(getString(R.string.label_pref_settings_smart_downloads_summary_wifi_only_disabled));
            }
        }
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private void m13416() {
        C1283.m16854("SettingsFragment", "removing bandwidth settings");
        Preference findPreference = findPreference("nf.bw_save");
        Preference findPreference2 = findPreference("video.playback");
        if ((findPreference2 instanceof PreferenceGroup) && findPreference != null) {
            ((PreferenceGroup) findPreference2).removePreference(findPreference);
        }
        ((PreferenceScreen) findPreference("pref.screen")).removePreference(findPreference2);
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    private void m13418() {
        C1283.m16854("SettingsFragment", "removing WiFiOnly settings");
        Preference findPreference = findPreference("nf_play_no_wifi_warning");
        Preference findPreference2 = findPreference("video.playback");
        if ((findPreference2 instanceof PreferenceGroup) && findPreference != null) {
            ((PreferenceGroup) findPreference2).removePreference(findPreference);
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m13406(final C2059ph phVar) {
        Preference findPreference = findPreference("pref.downloads.remove_all");
        if (phVar.m9832() != null && findPreference != null) {
            if (vO.m12029(phVar.m9832()).mo11972() < 1) {
                ((PreferenceGroup) findPreference("pref.downloads")).removePreference(findPreference);
            } else {
                findPreference.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: o.zE.11
                    @Override // android.support.v7.preference.Preference.OnPreferenceClickListener
                    public boolean onPreferenceClick(Preference preference) {
                        if (!(zE.this.getActivity() instanceof NetflixActivity)) {
                            return false;
                        }
                        String str = "";
                        if (zE.this.f12558 != null) {
                            str = zE.this.f12558.mo13382();
                        }
                        zE.this.f12559 = vD.m11887(zE.this.getActivity(), new DialogInterface.OnClickListener() { // from class: o.zE.11.3
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i) {
                                C1364Cj.m4434(UIViewLogging.UIViewCommandName.RemoveAllCachedVideosCommand, IClientLogging.ModalView.settings, CommandEndedEvent.InputMethod.gesture, CommandEndedEvent.InputValue.tap);
                                AbstractC1853hl r4 = phVar.m9832();
                                if (r4 != null) {
                                    r4.mo7124(zE.this.f12560);
                                    r4.mo7126();
                                    DownloadButton.m2156();
                                }
                                dialogInterface.dismiss();
                            }
                        }, str);
                        zE.this.f12559.show();
                        return true;
                    }
                });
            }
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m13396(final C2059ph phVar) {
        AbstractC1221 r2 = phVar.m9827();
        if (phVar.m9832() != null && r2 != null) {
            Preference findPreference = findPreference("pref.downloads");
            Preference findPreference2 = findPreference("pref.downloads.video_quality");
            if (findPreference == null || findPreference2 == null) {
                C1283.m16854("SettingsFragment", "downloads downloadCategoryPref or downloadQualityPref is null");
            } else if (!(findPreference instanceof PreferenceGroup)) {
                C1283.m16854("SettingsFragment", "downloadCategoryPref not a group pref");
            } else if (!(findPreference2 instanceof ListPreference)) {
                C1283.m16854("SettingsFragment", "downloads downloadQualityPref not a list pref");
            } else {
                final ListPreference listPreference = (ListPreference) findPreference2;
                if (listPreference != null) {
                    C1283.m16854("SettingsFragment", "Debug: downloads video quality");
                    listPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: o.zE.12
                        @Override // android.support.v7.preference.Preference.OnPreferenceChangeListener
                        public boolean onPreferenceChange(Preference preference, Object obj) {
                            if (obj instanceof String) {
                                String str = (String) obj;
                                char c = 65535;
                                switch (str.hashCode()) {
                                    case -2032180703:
                                        if (str.equals("DEFAULT")) {
                                            c = 1;
                                            break;
                                        }
                                        break;
                                    case 2035172:
                                        if (str.equals("BEST")) {
                                            c = 0;
                                            break;
                                        }
                                        break;
                                }
                                switch (c) {
                                    case 0:
                                        C1283.m16854("SettingsFragment", "Set downloads video quality to best");
                                        listPreference.setSummary(zE.this.getText(R.string.offline_message_quality_high));
                                        zE.this.m13389(DownloadVideoQuality.BEST, phVar);
                                        return true;
                                    case 1:
                                        C1283.m16854("SettingsFragment", "Set downloads video quality to default");
                                        listPreference.setSummary(zE.this.getText(R.string.offline_message_quality_standard));
                                        zE.this.m13389(DownloadVideoQuality.DEFAULT, phVar);
                                        return true;
                                    default:
                                        C1283.m16850("SettingsFragment", "Received unexpected value for downloads video quality " + str);
                                        return true;
                                }
                            } else {
                                C1283.m16850("SettingsFragment", "Received unexpected NON string value for downloads video quality " + obj);
                                return true;
                            }
                        }
                    });
                    if (listPreference instanceof ListPreference) {
                        m13405(listPreference);
                    } else {
                        C1283.m16850("SettingsFragment", "Preference downloads video quality type is NOT list preference!");
                    }
                } else {
                    C1283.m16865("SettingsFragment", "Debug: downloads video quality not found");
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˊ  reason: contains not printable characters */
    private void m13389(DownloadVideoQuality downloadVideoQuality, C2059ph phVar) {
        if (phVar.m9832() != null) {
            phVar.m9832().mo7132(downloadVideoQuality);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m13388(ListPreference listPreference) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList.add(BG.m3850(getContext(), getString(R.string.offline_message_quality_standard), getString(R.string.offline_message_quality_standard_description)));
        arrayList2.add(DownloadVideoQuality.DEFAULT.m1579());
        arrayList.add(BG.m3850(getContext(), getString(R.string.offline_message_quality_high), getString(R.string.offline_message_quality_high_description)));
        arrayList2.add(DownloadVideoQuality.BEST.m1579());
        listPreference.setEntries((CharSequence[]) arrayList.toArray(new CharSequence[arrayList.size()]));
        listPreference.setEntryValues((CharSequence[]) arrayList2.toArray(new CharSequence[arrayList2.size()]));
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m13405(ListPreference listPreference) {
        DownloadVideoQuality r2 = ((NetflixActivity) getActivity()).getServiceManager().m9832().mo7127();
        Preference findPreference = findPreference("pref.downloads.video_quality");
        switch (r2) {
            case BEST:
                listPreference.setValue(DownloadVideoQuality.BEST.m1579());
                findPreference.setSummary(getText(R.string.offline_message_quality_high));
                return;
            case DEFAULT:
            case UNKNOWN:
                listPreference.setValue(DownloadVideoQuality.DEFAULT.m1579());
                findPreference.setSummary(getText(R.string.offline_message_quality_standard));
                return;
            default:
                return;
        }
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    private boolean m13383() {
        try {
            C1283.m16854("SettingsFragment", "Verifies that the device supports GCM");
            return AD.m3321(this.f12561.getApplicationContext());
        } catch (Throwable th) {
            C1283.m16847("SettingsFragment", "Device does NOT supports GCM", th);
            return false;
        }
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    private boolean m13385() {
        return C0352.m13957(this.f12561);
    }

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private void m13392() {
        if (!m13383()) {
            C1283.m16854("SettingsFragment", "Notifications are NOT supported!");
            m13415();
            return;
        }
        C1283.m16854("SettingsFragment", "Enable notifications");
        boolean r2 = m13385();
        NetflixSwitchPreference netflixSwitchPreference = (NetflixSwitchPreference) findPreference("nf_notification_enable");
        if (netflixSwitchPreference != null) {
            netflixSwitchPreference.setChecked(r2);
            netflixSwitchPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: o.zE.5
                @Override // android.support.v7.preference.Preference.OnPreferenceChangeListener
                public boolean onPreferenceChange(Preference preference, Object obj) {
                    C1283.m16854("SettingsFragment", "Notification enabled clicked");
                    if (!(preference instanceof NetflixSwitchPreference)) {
                        C1283.m16850("SettingsFragment", "We did not received notification checkbox preference!");
                        return true;
                    } else if (!(obj instanceof Boolean)) {
                        C1276.m16820().mo5725("newValue -> " + obj + " in the onPreferenceChange is expected to be a Boolean object. But it is not!");
                        return false;
                    } else if (((Boolean) obj).booleanValue()) {
                        C1283.m16854("SettingsFragment", "Register for notifications");
                        Intent intent = new Intent("com.netflix.mediaclient.intent.action.PUSH_NOTIFICATION_OPTIN");
                        intent.putExtra(NetflixActivity.EXTRA_SOURCE, IClientLogging.ModalView.settings.name());
                        intent.addCategory("com.netflix.mediaclient.intent.category.PUSH");
                        LocalBroadcastManager.getInstance(zE.this.f12561).sendBroadcast(intent);
                        return true;
                    } else {
                        C1283.m16854("SettingsFragment", "Unregister from notifications");
                        Intent intent2 = new Intent("com.netflix.mediaclient.intent.action.PUSH_NOTIFICATION_OPTOUT");
                        intent2.addCategory("com.netflix.mediaclient.intent.category.PUSH");
                        intent2.putExtra(NetflixActivity.EXTRA_SOURCE, IClientLogging.ModalView.settings.name());
                        LocalBroadcastManager.getInstance(zE.this.f12561).sendBroadcast(intent2);
                        return true;
                    }
                }
            });
            return;
        }
        m13415();
    }

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private void m13415() {
        NetflixSwitchPreference netflixSwitchPreference = (NetflixSwitchPreference) findPreference("nf_notification_enable");
        PreferenceScreen preferenceScreen = getPreferenceScreen();
        PreferenceGroup preferenceGroup = (PreferenceGroup) findPreference("pref.notification");
        if (preferenceGroup != null) {
            if (netflixSwitchPreference != null) {
                preferenceGroup.removePreference(netflixSwitchPreference);
            }
            preferenceScreen.removePreference(preferenceGroup);
        }
    }

    @Override // o.oV
    public void onManagerReady(C2059ph phVar, Status status) {
        C1283.m16854("SettingsFragment", "onManagerReady");
        this.f12562 = phVar;
        m13392();
        m13387();
        m13414(phVar);
        m13398();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m13414(C2059ph phVar) {
        if (phVar.m9824()) {
            m13384(phVar);
            m13406(phVar);
            m13396(phVar);
            m13401(phVar);
            m13390(phVar);
            return;
        }
        Preference findPreference = findPreference("pref.downloads");
        if (findPreference != null) {
            getPreferenceScreen().removePreference(findPreference);
        }
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    private void m13384(C2059ph phVar) {
        C1283.m16854("SettingsFragment", "handleDownloadsStorageSelectorSetting");
        final AbstractC1853hl r5 = phVar.m9832();
        if (r5 == null) {
            C1283.m16854("SettingsFragment", "handleDownloadsStorageSelectorSetting offlineAgent is null");
            return;
        }
        final Preference findPreference = findPreference("pref.downloads.storage_selector");
        if (findPreference == null) {
            C1283.m16850("SettingsFragment", "handleDownloadsStorageSelectorSetting dl location pref is null");
            return;
        }
        boolean r7 = r5.mo7136().mo9598(r5.mo7136().mo9597());
        C1283.m16863("SettingsFragment", "currentStorageRemovable=%b", Boolean.valueOf(r7));
        findPreference.setSummary(r7 ? R.string.offline_message_removable_storage : R.string.offline_message_internal_storage);
        r5.mo7139();
        findPreference.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: o.zE.1
            @Override // android.support.v7.preference.Preference.OnPreferenceClickListener
            public boolean onPreferenceClick(Preference preference) {
                if (vO.m12029(r5).mo11977()) {
                    new AlertDialog.Builder(zE.this.f12561).setMessage(R.string.offline_message_storage_change_not_allowed).setPositiveButton(R.string.offline_action_my_downloads, new DialogInterface.OnClickListener() { // from class: o.zE.1.4
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            FragmentActivity activity = zE.this.getActivity();
                            if (!C1317As.m3750(activity)) {
                                activity.startActivity(vH.m11936(activity));
                            }
                            dialogInterface.dismiss();
                        }
                    }).setNegativeButton(R.string.label_cancel, new DialogInterface.OnClickListener() { // from class: o.zE.1.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    }).create().show();
                    return true;
                }
                pY r52 = r5.mo7136();
                if (r52.mo4074() <= 0) {
                    C1283.m16844("SettingsFragment", "osvList size=%d", Integer.valueOf(r52.mo4074()));
                    return true;
                }
                r5.mo7139();
                int r6 = r52.mo9597();
                C1283.m16863("SettingsFragment", "currentlySelected=%d", Integer.valueOf(r6));
                CharSequence[] charSequenceArr = new CharSequence[r52.mo4074()];
                for (int i = 0; i < r52.mo4074(); i++) {
                    pZ pZVar = (pZ) r52.mo4075(i);
                    charSequenceArr[i] = BG.m3850(zE.this.getContext(), zE.this.getString(pZVar.mo7008() ? R.string.offline_message_removable_storage : R.string.offline_message_internal_storage), zE.this.getString(R.string.offline_message_free_storage, BG.m3861(zE.this.getActivity(), pZVar.mo7013())));
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(zE.this.f12561);
                if (charSequenceArr.length == 1) {
                    CharSequence r11 = BG.m3856(zE.this.getContext(), zE.this.getString(R.string.downloads_no_external_storage), zE.this.getString(R.string.downloads_install_storage_prompt));
                    C0716 r12 = new C0716(zE.this.f12561);
                    int dimension = (int) zE.this.getResources().getDimension(R.dimen.profile_details_checkbox_padding_right);
                    r12.setPadding(dimension, dimension, dimension, (int) zE.this.getResources().getDimension(R.dimen.content_padding));
                    r12.setText(r11);
                    builder.setCustomTitle(r12);
                    builder.setPositiveButton(R.string.label_ok, (DialogInterface.OnClickListener) null);
                } else {
                    String string = zE.this.getString(R.string.offline_message_download_location);
                    SpannableString spannableString = new SpannableString(string);
                    spannableString.setSpan(new TextAppearanceSpan(zE.this.f12561, R.style.res_2131951979_primarytext_mediumlarge), 0, string.length(), 0);
                    spannableString.setSpan(new StyleSpan(1), 0, string.length(), 33);
                    builder.setTitle(spannableString);
                    builder.setPositiveButton(R.string.label_cancel, (DialogInterface.OnClickListener) null);
                }
                builder.setSingleChoiceItems(charSequenceArr, r6, new DialogInterface.OnClickListener() { // from class: o.zE.1.3
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i2) {
                        boolean r53 = r5.mo7136().mo9598(i2);
                        C1283.m16863("SettingsFragment", "selected=%d isRemovable=%b", Integer.valueOf(i2), Boolean.valueOf(r53));
                        findPreference.setSummary(r53 ? R.string.offline_message_removable_storage : R.string.offline_message_internal_storage);
                        findPreference.setIcon(r53 ? R.drawable.ic_sd_card_storage : R.drawable.ic_internal_storage);
                        r5.mo7119(i2);
                        dialogInterface.dismiss();
                        zC zCVar = (zC) C1317As.m3755(zE.this.getActivity(), zC.class);
                        if (zCVar != null) {
                            if (!(zE.this.getListView() == null || zE.this.getListView().getAdapter() == null)) {
                                zE.this.getListView().getAdapter().notifyDataSetChanged();
                            }
                            if (r53) {
                                zCVar.m14000();
                            }
                        }
                    }
                }).create().show();
                return true;
            }
        });
    }

    @Override // o.oV
    public void onManagerUnavailable(C2059ph phVar, Status status) {
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m13420(Context context) {
        Preference findPreference = findPreference("nf.bw_save");
        if (findPreference != null) {
            m13404(context, findPreference);
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m13404(Context context, Preference preference) {
        if (context != null && preference != null) {
            preference.setSummary(m13393(context));
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static int m13393(Context context) {
        if (Boolean.valueOf(C0577.m14681(context)).booleanValue()) {
            return R.string.label_bw_automatic_header;
        }
        return m13410(BandwidthPreferenceDialogFragment.ManualBwChoice.m1600(C0577.m14684(context)));
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private static int m13410(BandwidthPreferenceDialogFragment.ManualBwChoice manualBwChoice) {
        switch (manualBwChoice) {
            case OFF:
                return R.string.label_bw_off_header;
            case LOW:
                return R.string.label_bw_low_header;
            case UNLIMITED:
                return R.string.label_bw_unlimited_header;
            default:
                return R.string.label_bw_automatic_header;
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m13421() {
        AbstractC1853hl r2;
        if (this.f12562 != null && (r2 = this.f12562.m9832()) != null) {
            C1283.m16862("SettingsFragment", "onExternalStoragePermissionDenied reverting to internal storage");
            r2.mo7119(0);
            Preference findPreference = findPreference("pref.downloads.storage_selector");
            if (findPreference != null) {
                findPreference.setSummary(R.string.offline_message_internal_storage);
            }
        }
    }

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private void m13398() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            String r3 = C1318At.m3776(activity.getApplicationContext());
            String string = r3 == null ? getString(R.string.label_version_na) : r3;
            int r4 = C1318At.m3778(activity.getApplicationContext());
            StringBuilder sb = new StringBuilder();
            sb.append(getString(R.string.label_version)).append(": ").append(string);
            if (r4 > 0) {
                sb.append(" (");
                sb.append(getString(R.string.label_version_code)).append(" ").append(r4).append("), ");
            }
            sb.append(getString(R.string.label_os_api_number)).append(": ").append(C1317As.m3758());
            sb.append("\n");
            sb.append(getString(R.string.label_model)).append(": ").append(Build.MODEL);
            sb.append("\n");
            if (null != this.f12562) {
                sb.append(BX.m3956(getString(R.string.label_is_preloaded), BidiMarker.FORCED_RTL)).append(": ").append(PartnerInstallType.m482(this.f12562.m9827().mo16562()) ? 1 : 0);
                String r7 = this.f12562.m9827().mo16560();
                if (C1349Bv.m4107(r7)) {
                    sb.append(", ").append(getString(R.string.label_channelId)).append(": ").append(r7).append("\n");
                } else {
                    sb.append("\n");
                }
                String r8 = this.f12562.m9827().mo16504();
                if (C1349Bv.m4107(r8)) {
                    sb.append(BX.m3956(getString(R.string.label_certified_bsp_version), BidiMarker.FORCED_RTL)).append(": ").append(r8).append("\n");
                }
            }
            sb.append(BX.m3956(getString(R.string.label_build), BidiMarker.FORCED_RTL)).append(": ").append(Build.DISPLAY);
            if (null != this.f12562) {
                sb.append("\n");
                sb.append(BX.m3956(getString(R.string.label_esn), BidiMarker.FORCED_RTL)).append(": ");
                sb.append(this.f12562.m9777().mo14449());
            }
            Preference findPreference = findPreference("ui.about.device");
            findPreference.setSummary(sb.toString());
            findPreference.setIcon(AD.m3299() ? R.drawable.ic_device_android_tablet : R.drawable.ic_device_android_phone);
            if (this.f12562 != null) {
                StringBuilder append = new StringBuilder().append(getString(R.string.email)).append(": ").append(this.f12562.m9810());
                Preference findPreference2 = findPreference("ui.account");
                findPreference2.setSummary(append.toString());
                final NetflixActivity netflixActivity = (NetflixActivity) getActivity();
                findPreference2.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: o.zE.4
                    @Override // android.support.v7.preference.Preference.OnPreferenceClickListener
                    public boolean onPreferenceClick(Preference preference) {
                        C1283.m16854("SettingsFragment", "Get autologin token...");
                        if (!zE.this.f12562.mo9519()) {
                            C1283.m16850("SettingsFragment", "Service is not available!");
                            return false;
                        } else if (netflixActivity == null) {
                            C1283.m16850("SettingsFragment", "On Account clicked -> NetflixActivity is null");
                            return false;
                        } else {
                            final C2154sm smVar = new C2154sm(netflixActivity);
                            final NetworkErrorStatus networkErrorStatus = new NetworkErrorStatus(BK.f4581);
                            final AnonymousClass5 r5 = new Runnable() { // from class: o.zE.4.5
                                @Override // java.lang.Runnable
                                public void run() {
                                    smVar.m10804((String) null, networkErrorStatus);
                                }
                            };
                            netflixActivity.getHandler().postDelayed(r5, 10000);
                            netflixActivity.getServiceManager().m9784(3600000, new AbstractC2061pj() { // from class: o.zE.4.3
                                @Override // o.AbstractC2061pj, o.oU
                                public void onAutoLoginTokenCreated(String str, Status status) {
                                    netflixActivity.getHandler().removeCallbacks(r5);
                                    smVar.m10804(str, status);
                                }
                            });
                            return true;
                        }
                    }
                });
            }
            final zC zCVar = (zC) activity;
            Preference findPreference3 = findPreference("ui.diagnosis.download");
            if (!(this.f12562 == null || !this.f12562.mo9519() || findPreference3 == null)) {
                if (!this.f12562.m9824()) {
                    findPreference3.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: o.zE.2
                        @Override // android.support.v7.preference.Preference.OnPreferenceClickListener
                        public boolean onPreferenceClick(Preference preference) {
                            BW.m3942(IClientLogging.ModalView.customerService);
                            C2391zw.m13836(zCVar, zE.this.f12562);
                            return false;
                        }
                    });
                } else {
                    ((PreferenceCategory) findPreference("ui.diagnosis")).removePreference(findPreference3);
                }
            }
            m13409();
        }
    }

    /* renamed from: ͺ  reason: contains not printable characters */
    private void m13409() {
    }

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private void m13408() {
        Preference findPreference = findPreference(getString(R.string.settings_key_open_source_licenses));
        if (getActivity() != null) {
            findPreference.setIntent(zF.m13422(getActivity()));
        }
        Preference findPreference2 = findPreference("pref.privacy");
        findPreference2.setIntent(new Intent("android.intent.action.VIEW").setData(Uri.parse("http://www.netflix.com/privacy")));
        findPreference2.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: o.zE.6
            @Override // android.support.v7.preference.Preference.OnPreferenceClickListener
            public boolean onPreferenceClick(Preference preference) {
                BW.m3942(IClientLogging.ModalView.privacyPolicy);
                return false;
            }
        });
        Preference findPreference3 = findPreference("pref.privacy.cookies");
        findPreference3.setIntent(new Intent("android.intent.action.VIEW").setData(Uri.parse("http://www.netflix.com/privacy#cookies")));
        findPreference3.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: o.zE.10
            @Override // android.support.v7.preference.Preference.OnPreferenceClickListener
            public boolean onPreferenceClick(Preference preference) {
                BW.m3942(IClientLogging.ModalView.privacyPolicy);
                return false;
            }
        });
        Preference findPreference4 = findPreference("pref.terms");
        findPreference4.setIntent(new Intent("android.intent.action.VIEW").setData(Uri.parse("http://www.netflix.com/termsofuse")));
        findPreference4.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: o.zE.7
            @Override // android.support.v7.preference.Preference.OnPreferenceClickListener
            public boolean onPreferenceClick(Preference preference) {
                BW.m3942(IClientLogging.ModalView.legalTerms);
                return false;
            }
        });
    }

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private void m13419() {
        Preference findPreference = findPreference("ui.diagnosis.network");
        if (getActivity() != null) {
            findPreference.setIntent(DiagnosisActivity.m1731(getActivity()));
        }
        findPreference.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: o.zE.8
            @Override // android.support.v7.preference.Preference.OnPreferenceClickListener
            public boolean onPreferenceClick(Preference preference) {
                BW.m3942(IClientLogging.ModalView.customerService);
                return false;
            }
        });
        findPreference("ui.diagnosis.speed.test").setIntent(new Intent("android.intent.action.VIEW").setData(Uri.parse("https://fast.com/")));
    }
}
