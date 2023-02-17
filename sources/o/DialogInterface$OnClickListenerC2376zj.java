package o;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import com.netflix.cl.Logger;
import com.netflix.cl.util.NamedLogSessionLookup;
import com.netflix.mediaclient.NetflixApplication;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.StatusCode;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.app.NetflixStatus;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.android.widget.StaticImgConfig;
import com.netflix.mediaclient.api.res.AssetType;
import com.netflix.mediaclient.service.logging.client.model.ActionOnUIError;
import com.netflix.mediaclient.service.logging.client.model.UIError;
import com.netflix.mediaclient.service.webclient.model.leafs.AvatarInfo;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.UserActionLogging;
import com.netflix.mediaclient.util.log.UIScreen;
import java.util.Iterator;
import java.util.List;
import o.C0567;
/* renamed from: o.zj  reason: case insensitive filesystem */
public class DialogInterface$OnClickListenerC2376zj extends NetflixActivity implements DialogInterface.OnClickListener {

    /* renamed from: ʻ  reason: contains not printable characters */
    private EditText f12861;

    /* renamed from: ʻॱ  reason: contains not printable characters */
    private View f12862;

    /* renamed from: ʼ  reason: contains not printable characters */
    private View f12863;

    /* renamed from: ʽ  reason: contains not printable characters */
    private View f12864;

    /* renamed from: ʽॱ  reason: contains not printable characters */
    private boolean f12865;

    /* renamed from: ʾ  reason: contains not printable characters */
    private final oU f12866 = new AbstractC2061pj() { // from class: o.zj.1
        @Override // o.AbstractC2061pj, o.oU
        public void onProfileListUpdateStatus(Status status) {
            if (status.mo298()) {
                C1283.m16846("ProfileDetailsActivity", "Operation successful!");
                if (DialogInterface$OnClickListenerC2376zj.this.f12867) {
                    if (DialogInterface$OnClickListenerC2376zj.this.f12872 != null) {
                        String profileGuid = DialogInterface$OnClickListenerC2376zj.this.f12872.getProfileGuid();
                        C1362Ch.m4409(IClientLogging.CompletionReason.success, IClientLogging.ModalView.profilesGate, (UIError) null);
                        C0590.m14714("DeleteProfile" + profileGuid);
                        return;
                    }
                    C1276.m16820().mo5725("Input profile was null on delete action. This should NOT happen!");
                } else if (DialogInterface$OnClickListenerC2376zj.this.f12875) {
                    C1362Ch.m4402(IClientLogging.CompletionReason.success, IClientLogging.ModalView.profilesGate, null, DialogInterface$OnClickListenerC2376zj.this.m13696());
                    Logger.INSTANCE.m133("AddProfile");
                } else {
                    C1362Ch.m4387(IClientLogging.CompletionReason.success, IClientLogging.ModalView.profilesGate, (UIError) null, DialogInterface$OnClickListenerC2376zj.this.m13696());
                    Logger.INSTANCE.m133("EditProfile");
                }
            } else {
                UIError r5 = AbstractC1358Cd.m4353(status, DialogInterface$OnClickListenerC2376zj.this.handleUserAgentErrors(status), ActionOnUIError.displayedError);
                if (DialogInterface$OnClickListenerC2376zj.this.f12867) {
                    C1362Ch.m4409(IClientLogging.CompletionReason.failed, IClientLogging.ModalView.profilesGate, r5);
                    DialogInterface$OnClickListenerC2376zj.this.m13675("DeleteProfile", status);
                } else if (DialogInterface$OnClickListenerC2376zj.this.f12875) {
                    C1362Ch.m4402(IClientLogging.CompletionReason.failed, IClientLogging.ModalView.profilesGate, r5, DialogInterface$OnClickListenerC2376zj.this.m13696());
                    Logger.INSTANCE.m134("AddProfile", C1300Ac.m3532(status));
                } else {
                    C1362Ch.m4387(IClientLogging.CompletionReason.failed, IClientLogging.ModalView.profilesGate, r5, DialogInterface$OnClickListenerC2376zj.this.m13696());
                    Logger.INSTANCE.m134("EditProfile", C1300Ac.m3532(status));
                }
            }
        }
    };

    /* renamed from: ʿ  reason: contains not printable characters */
    private boolean f12867;

    /* renamed from: ˈ  reason: contains not printable characters */
    private final C0567.Cif f12868 = new C0567.Cif() { // from class: o.zj.5
        @Override // o.C0567.Cif
        public void N_() {
        }
    };

    /* renamed from: ˊ  reason: contains not printable characters */
    private C0616 f12869;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private View f12870;

    /* renamed from: ˋ  reason: contains not printable characters */
    private C2059ph f12871;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private AbstractC2089qj f12872;

    /* renamed from: ˎ  reason: contains not printable characters */
    private View f12873;

    /* renamed from: ˏ  reason: contains not printable characters */
    private View f12874;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private boolean f12875;

    /* renamed from: ͺ  reason: contains not printable characters */
    private String f12876;

    /* renamed from: ॱ  reason: contains not printable characters */
    private View f12877;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private boolean f12878;

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private AvatarInfo f12879;

    /* renamed from: ॱˎ  reason: contains not printable characters */
    private C0522 f12880;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private CheckBox f12881;

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private AvatarInfo f12882;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private TextView f12883;

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private View f12884;

    /* renamed from: ˏ  reason: contains not printable characters */
    public static Intent m13690(Context context, String str) {
        Intent intent = new Intent(context, m13691());
        if (str != null) {
            intent.putExtra("extra_profile_id", str);
        }
        return intent;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static Class<?> m13691() {
        return NetflixApplication.getInstance().m254() ? ActivityC2374zh.class : DialogInterface$OnClickListenerC2376zj.class;
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent == null || !intent.hasExtra("extra_profile_id")) {
            this.f12875 = true;
            setTitle(R.string.accessibility_create_profile_title);
        } else {
            this.f12876 = intent.getStringExtra("extra_profile_id");
            setTitle(R.string.profile_edit_top_bar_text);
        }
        m13687();
        if (bundle != null && bundle.containsKey("bundle_name") && bundle.containsKey("bundle_kids") && bundle.containsKey("bundle_default_avatar") && bundle.containsKey("bundle_current_avatar")) {
            this.f12861.setText(bundle.getString("bundle_name"));
            this.f12881.setChecked(bundle.getBoolean("bundle_kids"));
            this.f12882 = (AvatarInfo) bundle.getParcelable("bundle_default_avatar");
            this.f12879 = (AvatarInfo) bundle.getParcelable("bundle_current_avatar");
            if (!(this.f12879 == null || this.f12882 == null)) {
                this.f12878 = true;
            }
        }
        m13682();
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public oV createManagerStatusListener() {
        return new oV() { // from class: o.zj.2
            @Override // o.oV
            public void onManagerReady(C2059ph phVar, Status status) {
                C1283.m16854("ProfileDetailsActivity", "Manager is here!");
                DialogInterface$OnClickListenerC2376zj.this.f12871 = phVar;
                DialogInterface$OnClickListenerC2376zj.this.m13674();
                if (!DialogInterface$OnClickListenerC2376zj.this.f12878) {
                    if (DialogInterface$OnClickListenerC2376zj.this.f12875) {
                        DialogInterface$OnClickListenerC2376zj.this.f12871.m9819((oU) new Cif());
                    } else {
                        DialogInterface$OnClickListenerC2376zj.this.f12882 = new AvatarInfo(DialogInterface$OnClickListenerC2376zj.this.f12872.getProfileName(), DialogInterface$OnClickListenerC2376zj.this.f12872.getAvatarUrl(), true);
                        DialogInterface$OnClickListenerC2376zj.this.f12879 = DialogInterface$OnClickListenerC2376zj.this.f12882;
                    }
                }
                DialogInterface$OnClickListenerC2376zj.this.m13682();
            }

            @Override // o.oV
            public void onManagerUnavailable(C2059ph phVar, Status status) {
                C1283.m16850("ProfileDetailsActivity", "Manager isn't available!");
                DialogInterface$OnClickListenerC2376zj.this.f12871 = null;
                DialogInterface$OnClickListenerC2376zj.this.m13682();
            }
        };
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("bundle_name", this.f12861.getText().toString());
        bundle.putBoolean("bundle_kids", this.f12881.isChecked());
        bundle.putParcelable("bundle_default_avatar", this.f12882);
        bundle.putParcelable("bundle_current_avatar", this.f12879);
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public void handleProfilesListUpdated() {
        C1283.m16854("ProfileDetailsActivity", "handleProfilesListUpdated");
        finish();
    }

    @Override // o.AbstractC0459
    public boolean isLoadingData() {
        return false;
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public UIScreen getUiScreen() {
        return UIScreen.profileDetails;
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public boolean handleBackPressed() {
        m13669();
        return true;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˊ  reason: contains not printable characters */
    private void m13675(String str, Status status) {
        C0510 r2 = C1300Ac.m3532(status);
        Long r5 = NamedLogSessionLookup.INSTANCE.m151(str + this.f12872.getProfileGuid());
        if (r5 != null) {
            Logger.INSTANCE.m147(AbstractC0470.m14366(r5, r2));
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m13693(String str) {
        Long r4 = NamedLogSessionLookup.INSTANCE.m151(str + this.f12872.getProfileGuid());
        if (r4 != null) {
            Logger.INSTANCE.m147(AbstractC1274.m16814(r4));
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m13687() {
        setContentView(R.layout.profile_details_activity);
        getSupportActionBar().hide();
        this.f12877 = findViewById(R.id.profile_details_content);
        this.f12869 = new C0616(findViewById(R.id.profile_details_parent), this.f12868);
        this.f12873 = findViewById(R.id.profile_cancel_button);
        this.f12873.setOnClickListener(new View.OnClickListener() { // from class: o.zj.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DialogInterface$OnClickListenerC2376zj.this.m13669();
            }
        });
        this.f12870 = findViewById(R.id.profile_delete_section);
        this.f12862 = findViewById(R.id.profile_delete_button);
        this.f12862.setOnClickListener(new View.OnClickListener() { // from class: o.zj.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (DialogInterface$OnClickListenerC2376zj.this.f12872 == null) {
                    C1362Ch.m4387(IClientLogging.CompletionReason.failed, DialogInterface$OnClickListenerC2376zj.this.getUiScreen().f4084, AbstractC1358Cd.m4353(AbstractC0367.f13241, "", ActionOnUIError.handledSilently), DialogInterface$OnClickListenerC2376zj.this.m13696());
                    Logger.INSTANCE.m134("EditProfile", C1300Ac.m3532(AbstractC0367.f13241));
                    C1283.m16850("ProfileDetailsActivity", "Weird use case: profile edit was started, but input profile is null");
                    DialogInterface$OnClickListenerC2376zj.this.finish();
                } else if (DialogInterface$OnClickListenerC2376zj.this.f12871.m9826() == null || !DialogInterface$OnClickListenerC2376zj.this.f12872.getProfileGuid().equals(DialogInterface$OnClickListenerC2376zj.this.f12871.m9826().getProfileGuid())) {
                    C1362Ch.m4387(IClientLogging.CompletionReason.canceled, DialogInterface$OnClickListenerC2376zj.this.getUiScreen().f4084, (UIError) null, DialogInterface$OnClickListenerC2376zj.this.m13696());
                    C1362Ch.m4412((UserActionLogging.CommandName) null, DialogInterface$OnClickListenerC2376zj.this.getUiScreen().f4084, DialogInterface$OnClickListenerC2376zj.this.f12872.getProfileGuid());
                    Logger.INSTANCE.m146("EditProfile");
                    C0590.m14710("DeleteProfile" + DialogInterface$OnClickListenerC2376zj.this.f12872.getProfileGuid(), new C0657(DialogInterface$OnClickListenerC2376zj.this.f12872.getProfileGuid()));
                    DialogInterface$OnClickListenerC2376zj.this.m13707();
                    DialogInterface$OnClickListenerC2376zj.this.showDialog(C2378zl.m13710(DialogInterface$OnClickListenerC2376zj.this, DialogInterface$OnClickListenerC2376zj.this.f12872.getAvatarUrl(), DialogInterface$OnClickListenerC2376zj.this.f12872.getProfileName()));
                } else {
                    DialogInterface$OnClickListenerC2376zj.this.displayDialog(C0505.m14491(DialogInterface$OnClickListenerC2376zj.this, DialogInterface$OnClickListenerC2376zj.this.handler, new C1278(null, DialogInterface$OnClickListenerC2376zj.this.getString(R.string.profile_delete_current_error), DialogInterface$OnClickListenerC2376zj.this.getString(R.string.label_ok), null)));
                }
            }
        });
        this.f12863 = findViewById(R.id.profile_kids_section);
        this.f12883 = (TextView) findViewById(R.id.profile_kids_section_text);
        this.f12881 = (CheckBox) findViewById(R.id.kids_checkBox);
        this.f12881.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: o.zj.7
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (DialogInterface$OnClickListenerC2376zj.this.f12872 != null && DialogInterface$OnClickListenerC2376zj.this.f12872.isKidsProfile() && !z) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(DialogInterface$OnClickListenerC2376zj.this);
                    builder.setMessage(R.string.profile_kids_change_to_adult_warning_message);
                    builder.setPositiveButton(R.string.label_ok, (DialogInterface.OnClickListener) null);
                    builder.create().show();
                }
            }
        });
        this.f12874 = findViewById(R.id.profile_save_button);
        this.f12874.setOnClickListener(new View.OnClickListener() { // from class: o.zj.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                C1283.m16854("ProfileDetailsActivity", "Save button was triggered");
                if (DialogInterface$OnClickListenerC2376zj.this.m13672()) {
                    UIError r6 = AbstractC1358Cd.m4353(AbstractC0367.f13241, "", ActionOnUIError.displayedError);
                    if (DialogInterface$OnClickListenerC2376zj.this.f12875) {
                        Logger.INSTANCE.m134("AddProfile", C1300Ac.m3532(AbstractC0367.f13241));
                        Logger.INSTANCE.m142(new C0547(DialogInterface$OnClickListenerC2376zj.this.m13680()));
                        C1362Ch.m4402(IClientLogging.CompletionReason.failed, DialogInterface$OnClickListenerC2376zj.this.getUiScreen().f4084, r6, DialogInterface$OnClickListenerC2376zj.this.m13696());
                        C1362Ch.m4421(null, DialogInterface$OnClickListenerC2376zj.this.getUiScreen().f4084);
                        return;
                    }
                    Logger.INSTANCE.m134("EditProfile", C1300Ac.m3532(AbstractC0367.f13241));
                    Logger.INSTANCE.m142(new C0630(DialogInterface$OnClickListenerC2376zj.this.f12872.getProfileGuid(), DialogInterface$OnClickListenerC2376zj.this.m13680()));
                    C1362Ch.m4387(IClientLogging.CompletionReason.failed, DialogInterface$OnClickListenerC2376zj.this.getUiScreen().f4084, r6, DialogInterface$OnClickListenerC2376zj.this.m13696());
                    C1362Ch.m4414(null, DialogInterface$OnClickListenerC2376zj.this.getUiScreen().f4084);
                    return;
                }
                DialogInterface$OnClickListenerC2376zj.this.m13707();
                String r62 = C1349Bv.m4101(DialogInterface$OnClickListenerC2376zj.this.f12861.getText().toString());
                if (DialogInterface$OnClickListenerC2376zj.this.f12875) {
                    DialogInterface$OnClickListenerC2376zj.this.f12871.m9804(r62, DialogInterface$OnClickListenerC2376zj.this.f12881.isChecked(), DialogInterface$OnClickListenerC2376zj.this.f12879.getName(), DialogInterface$OnClickListenerC2376zj.this.f12866);
                    DialogInterface$OnClickListenerC2376zj.this.f12865 = true;
                } else if (DialogInterface$OnClickListenerC2376zj.this.f12872 != null) {
                    if (TextUtils.equals(DialogInterface$OnClickListenerC2376zj.this.f12872.getAvatarUrl(), DialogInterface$OnClickListenerC2376zj.this.f12879.getUrl())) {
                        str = null;
                    } else {
                        str = DialogInterface$OnClickListenerC2376zj.this.f12879.getName();
                    }
                    DialogInterface$OnClickListenerC2376zj.this.f12871.m9768(DialogInterface$OnClickListenerC2376zj.this.f12872.getProfileGuid(), r62, DialogInterface$OnClickListenerC2376zj.this.f12881.isChecked() || DialogInterface$OnClickListenerC2376zj.this.f12872.isDefaultKidsProfile(), str, DialogInterface$OnClickListenerC2376zj.this.f12866);
                    DialogInterface$OnClickListenerC2376zj.this.f12865 = true;
                } else {
                    C1283.m16850("ProfileDetailsActivity", "Weird use case: profile edit was started, but input profile is null");
                    UIError r7 = AbstractC1358Cd.m4353(AbstractC0367.f13241, "", ActionOnUIError.displayedError);
                    if (DialogInterface$OnClickListenerC2376zj.this.f12875) {
                        C1362Ch.m4402(IClientLogging.CompletionReason.failed, DialogInterface$OnClickListenerC2376zj.this.getUiScreen().f4084, r7, DialogInterface$OnClickListenerC2376zj.this.m13696());
                        Logger.INSTANCE.m133("AddProfile");
                    } else {
                        C1362Ch.m4387(IClientLogging.CompletionReason.failed, DialogInterface$OnClickListenerC2376zj.this.getUiScreen().f4084, r7, DialogInterface$OnClickListenerC2376zj.this.m13696());
                        Logger.INSTANCE.m133("EditProfile");
                    }
                    DialogInterface$OnClickListenerC2376zj.this.finish();
                }
                DialogInterface$OnClickListenerC2376zj.this.m13678(true, true);
            }
        });
        this.f12861 = (EditText) findViewById(R.id.profile_name_edittext);
        this.f12861.addTextChangedListener(new TextWatcher() { // from class: o.zj.6
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                DialogInterface$OnClickListenerC2376zj.this.f12861.setError(null);
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                DialogInterface$OnClickListenerC2376zj.this.m13700(true);
            }
        });
        this.f12880 = (C0522) findViewById(R.id.profile_avatar_img);
        AnonymousClass9 r3 = new View.OnClickListener() { // from class: o.zj.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!DialogInterface$OnClickListenerC2376zj.this.m13705()) {
                    C1283.m16850("ProfileDetailsActivity", "Profile avatar was touched when current avatar data is not ready...ignoring...");
                    return;
                }
                DialogInterface$OnClickListenerC2376zj.this.startActivityForResult(ActivityC2373zg.m13653(DialogInterface$OnClickListenerC2376zj.this, DialogInterface$OnClickListenerC2376zj.this.f12882, DialogInterface$OnClickListenerC2376zj.this.f12879), 1);
            }
        };
        this.f12880.setOnClickListener(r3);
        this.f12884 = findViewById(R.id.profile_picture_section);
        this.f12884.setOnClickListener(r3);
        this.f12864 = findViewById(R.id.picture_selector_hint);
        if (this.f12875) {
            this.f12861.requestFocus();
        }
        TextView textView = (TextView) findViewById(R.id.top_profile_title_text);
        if (textView != null) {
            textView.setText(this.f12875 ? R.string.profile_add_button : R.string.profile_edit_top_bar_text);
        }
    }

    /* renamed from: o.zj$if  reason: invalid class name */
    class Cif extends AbstractC2061pj {
        private Cif() {
        }

        @Override // o.AbstractC2061pj, o.oU
        public void onAvailableAvatarsListFetched(List<AvatarInfo> list, Status status) {
            if (!status.mo298() || list == null) {
                UIError r4 = AbstractC1358Cd.m4353(status, DialogInterface$OnClickListenerC2376zj.this.handleUserAgentErrors(status), ActionOnUIError.displayedError);
                if (DialogInterface$OnClickListenerC2376zj.this.f12867) {
                    C1362Ch.m4409(IClientLogging.CompletionReason.failed, IClientLogging.ModalView.profilesGate, r4);
                    DialogInterface$OnClickListenerC2376zj.this.m13675("DeleteProfile" + DialogInterface$OnClickListenerC2376zj.this.f12872.getProfileGuid(), status);
                } else if (DialogInterface$OnClickListenerC2376zj.this.f12875) {
                    Logger.INSTANCE.m134("AddProfile", C1300Ac.m3532(status));
                    C1362Ch.m4402(IClientLogging.CompletionReason.failed, IClientLogging.ModalView.profilesGate, r4, DialogInterface$OnClickListenerC2376zj.this.m13696());
                } else {
                    Logger.INSTANCE.m134("EditProfile", C1300Ac.m3532(status));
                    C1362Ch.m4387(IClientLogging.CompletionReason.failed, IClientLogging.ModalView.profilesGate, r4, DialogInterface$OnClickListenerC2376zj.this.m13696());
                }
            } else {
                if (!DialogInterface$OnClickListenerC2376zj.this.f12878 || !list.contains(DialogInterface$OnClickListenerC2376zj.this.f12879)) {
                    DialogInterface$OnClickListenerC2376zj.this.f12882 = null;
                    Iterator<AvatarInfo> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        AvatarInfo next = it.next();
                        if (next.isInDefaultSet()) {
                            DialogInterface$OnClickListenerC2376zj.this.f12882 = next;
                            break;
                        }
                    }
                    if (DialogInterface$OnClickListenerC2376zj.this.f12882 == null) {
                        DialogInterface$OnClickListenerC2376zj.this.f12882 = list.get(list.size() - 1);
                    }
                    DialogInterface$OnClickListenerC2376zj.this.f12879 = DialogInterface$OnClickListenerC2376zj.this.f12882;
                }
                DialogInterface$OnClickListenerC2376zj.this.m13682();
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1 && i2 == -1) {
            this.f12879 = (AvatarInfo) intent.getParcelableExtra("avatar_name");
            C1283.m16850("ProfileDetailsActivity", "Got url: " + this.f12879);
            m13682();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˊ  reason: contains not printable characters */
    private void m13674() {
        this.f12872 = null;
        if (this.f12876 != null) {
            Iterator<? extends AbstractC2089qj> it = this.f12871.m9833().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                AbstractC2089qj qjVar = (AbstractC2089qj) it.next();
                if (qjVar.getProfileGuid().equals(this.f12876)) {
                    this.f12872 = qjVar;
                    break;
                }
            }
            if (this.f12872 == null) {
                this.f12876 = null;
                this.f12875 = true;
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˋ  reason: contains not printable characters */
    private void m13682() {
        m13692(this.f12870, (this.f12876 == null || this.f12872 == null || this.f12872.isPrimaryProfile()) ? false : true);
        m13692(this.f12863, this.f12876 == null || (this.f12872 != null && !this.f12872.isPrimaryProfile()));
        if ((this.f12876 == null || this.f12872 == null || !this.f12872.isDefaultKidsProfile()) ? false : true) {
            this.f12881.setVisibility(8);
            this.f12883.setText(getString(R.string.profile_kids_no_checkbox_default_kids_profile));
        } else {
            this.f12863.setOnClickListener(new View.OnClickListener() { // from class: o.zj.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    DialogInterface$OnClickListenerC2376zj.this.f12881.setChecked(!DialogInterface$OnClickListenerC2376zj.this.f12881.isChecked());
                }
            });
        }
        if (!this.f12875 && this.f12872 != null && !this.f12878) {
            this.f12861.setText(this.f12872.getProfileName());
            this.f12881.setChecked(this.f12872.isKidsProfile());
            this.f12878 = true;
        }
        if (!(this.f12871 != null)) {
            m13678(true, false);
            return;
        }
        m13678(false, true);
        if (m13705()) {
            NetflixActivity.getImageLoader(this).mo3057(this.f12880, this.f12879.getUrl(), AssetType.profileAvatar, this.f12879.getName(), StaticImgConfig.DARK, true);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˊ  reason: contains not printable characters */
    private void m13678(boolean z, boolean z2) {
        if (z) {
            this.f12869.mo14570(true);
        } else {
            this.f12869.mo14663(true);
        }
        this.f12877.setEnabled(!z);
        this.f12861.setEnabled(!z);
        m13700(!z);
        this.f12873.setEnabled(!z);
        this.f12873.setAlpha(z ? 0.4f : 1.0f);
        this.f12862.setEnabled(!z);
        this.f12881.setEnabled(!z);
        this.f12863.setEnabled(!z);
        boolean z3 = m13705() && !z;
        this.f12880.setEnabled(z3);
        this.f12884.setEnabled(z3);
        if (z2) {
            this.f12877.animate().alpha(z ? 0.4f : 1.0f).setDuration(400).start();
        } else {
            this.f12877.setAlpha(z ? 0.4f : 1.0f);
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private boolean m13701() {
        return this.f12861.getText().length() > 0;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m13692(View view, boolean z) {
        view.setVisibility(z ? 0 : 8);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱ  reason: contains not printable characters */
    private void m13700(boolean z) {
        this.f12874.setEnabled(m13667() && z);
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    private boolean m13667() {
        return (!m13701() || this.f12871 == null || this.f12879 == null) ? false : true;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱॱ  reason: contains not printable characters */
    private boolean m13705() {
        return this.f12879 != null && C1349Bv.m4107(this.f12879.getUrl()) && C1349Bv.m4107(this.f12879.getName());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ʼ  reason: contains not printable characters */
    private void m13669() {
        if (this.f12875) {
            C1362Ch.m4402(IClientLogging.CompletionReason.canceled, IClientLogging.ModalView.profilesGate, null, m13696());
            Logger.INSTANCE.m146("AddProfile");
        } else {
            C1362Ch.m4387(IClientLogging.CompletionReason.canceled, IClientLogging.ModalView.profilesGate, (UIError) null, m13696());
            Logger.INSTANCE.m146("EditProfile");
        }
        if (!this.f12865) {
            C1004.m15958(this, this.f12875 ? R.string.profile_add_cancel_toast : R.string.profile_edit_cancel_toast, 1);
        }
        finish();
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == -1) {
            if (this.f12872 != null) {
                m13678(true, true);
                this.f12871.m9817(this.f12872.getProfileGuid(), this.f12866);
                this.f12865 = true;
                this.f12867 = true;
                return;
            }
            C1283.m16850("ProfileDetailsActivity", "Weird use case: profile deletion needs to be started, but input profile is null");
            NetflixStatus netflixStatus = new NetflixStatus(StatusCode.NETWORK_ERROR);
            String handleUserAgentErrors = handleUserAgentErrors(netflixStatus);
            ActionOnUIError actionOnUIError = ActionOnUIError.displayedError;
            if (handleUserAgentErrors == null) {
                actionOnUIError = ActionOnUIError.handledSilently;
            }
            C1362Ch.m4409(IClientLogging.CompletionReason.failed, IClientLogging.ModalView.profilesGate, AbstractC1358Cd.m4353(netflixStatus, handleUserAgentErrors, actionOnUIError));
            m13675("DeleteProfile", netflixStatus);
        } else if (i == -2) {
            C1283.m16862("ProfileDetailsActivity", "Negative dialog button was clicked");
            m13693("DeleteProfile");
            Logger.INSTANCE.m142(new C0630(this.f12872.getProfileGuid(), m13680()));
            C1362Ch.m4409(IClientLogging.CompletionReason.canceled, getUiScreen().f4084, (UIError) null);
            C1362Ch.m4414(null, getUiScreen().f4084);
        } else {
            C1283.m16850("ProfileDetailsActivity", "Unhandled dialog button was clicked");
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ʽ  reason: contains not printable characters */
    private boolean m13672() {
        this.f12861.setError(null);
        if (this.f12871 == null) {
            C1283.m16850("ProfileDetailsActivity", "Manager isn't available!");
            return true;
        } else if (this.f12879 == null) {
            C1283.m16850("ProfileDetailsActivity", "Current avatar isn't ready yet, but Save button was clicked!");
            return true;
        } else {
            String obj = this.f12861.getText().toString();
            if (obj.contains("\"") || obj.contains("<") || obj.contains(">")) {
                this.f12861.setError(getString(R.string.profile_wrong_symbol_in_name_error));
                return true;
            } else if (TextUtils.isEmpty(obj.trim())) {
                this.f12861.setError(getString(R.string.profile_wrong_symbol_in_name_error2));
                return true;
            } else {
                for (AbstractC2089qj qjVar : this.f12871.m9833()) {
                    if (obj.equalsIgnoreCase(qjVar.getProfileName()) && !qjVar.getProfileGuid().equals(this.f12876)) {
                        this.f12861.setError(getString(R.string.profile_duplicate_name_error));
                        return true;
                    }
                }
                return false;
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ᐝ  reason: contains not printable characters */
    private void m13707() {
        this.f12861.clearFocus();
        AD.m3310(this, this.f12861);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ͺ  reason: contains not printable characters */
    private UserActionLogging.C0029 m13696() {
        return new UserActionLogging.C0029(this.f12876, this.f12861.getText().toString(), null, this.f12881.isChecked());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˊॱ  reason: contains not printable characters */
    private C0557 m13680() {
        String str = null;
        if (this.f12872 != null) {
            str = this.f12872.getLanguagesInCsv();
        }
        return new C0557(this.f12861.getText().toString(), this.f12879.getName(), this.f12881.isChecked(), str, null);
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public boolean showNoNetworkOverlayIfNeeded() {
        return false;
    }
}
