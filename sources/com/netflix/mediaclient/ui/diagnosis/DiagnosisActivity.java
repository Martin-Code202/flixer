package com.netflix.mediaclient.ui.diagnosis;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.netflix.mediaclient.NetflixApplication;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.service.api.diagnostics.IDiagnosis;
import com.netflix.mediaclient.util.log.UIScreen;
import java.util.Iterator;
import java.util.List;
import o.AD;
import o.ActivityC2135rx;
import o.C1072;
import o.C1283;
import o.C2059ph;
import o.oV;
public class DiagnosisActivity extends NetflixActivity implements IDiagnosis.AbstractC0014 {

    /* renamed from: ʼ  reason: contains not printable characters */
    private TextView f2961;

    /* renamed from: ʽ  reason: contains not printable characters */
    private Button f2962;

    /* renamed from: ˊ  reason: contains not printable characters */
    private iF f2963;

    /* renamed from: ˋ  reason: contains not printable characters */
    private IDiagnosis f2964;

    /* renamed from: ˎ  reason: contains not printable characters */
    private TextView f2965;

    /* renamed from: ˏ  reason: contains not printable characters */
    private ListView f2966;

    /* renamed from: ॱ  reason: contains not printable characters */
    private List<C1072> f2967;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private ImageView f2968;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private ProgressBar f2969;

    public enum InfoGroupState {
        INITIAL,
        TEST_ONGOING,
        FAILED,
        SUCCESS
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static Intent m1731(Context context) {
        return new Intent(context, m1716());
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private static Class<?> m1716() {
        return NetflixApplication.getInstance().m254() ? ActivityC2135rx.class : DiagnosisActivity.class;
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (AD.m3299()) {
            setRequestedOrientation(6);
            setContentView(R.layout.diagnosis_landscape);
        } else {
            setRequestedOrientation(7);
            setContentView(R.layout.diagnosis_potrait);
        }
        C1283.m16854("DiagnosisActivity", "onCreate");
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public boolean canApplyBrowseExperience() {
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.f2964 != null) {
            this.f2964.mo500();
            this.f2964.mo496();
            this.f2964 = null;
            this.f2967 = null;
        }
        C1283.m16854("DiagnosisActivity", "onDestroy");
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public boolean showMdxInMenu() {
        return false;
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public boolean showSettingsInMenu() {
        return false;
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public boolean showSignOutInMenu() {
        return false;
    }

    @Override // o.AbstractC0459
    public boolean isLoadingData() {
        return false;
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public UIScreen getUiScreen() {
        return UIScreen.customerService;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˋ  reason: contains not printable characters */
    private void m1721() {
        C1283.m16854("DiagnosisActivity", "Diagnosis being attempted");
        this.f2964.mo498();
        m1734(InfoGroupState.TEST_ONGOING);
        this.f2963.notifyDataSetChanged();
    }

    @Override // com.netflix.mediaclient.service.api.diagnostics.IDiagnosis.AbstractC0014
    /* renamed from: ˏ */
    public void mo501() {
        runOnUiThread(new Runnable() { // from class: com.netflix.mediaclient.ui.diagnosis.DiagnosisActivity.3
            @Override // java.lang.Runnable
            public void run() {
                C1283.m16854("DiagnosisActivity", "DiagnosisListUpdated");
                DiagnosisActivity.this.f2963.notifyDataSetChanged();
            }
        });
    }

    @Override // com.netflix.mediaclient.service.api.diagnostics.IDiagnosis.AbstractC0014
    /* renamed from: ॱ */
    public void mo502() {
        runOnUiThread(new Runnable() { // from class: com.netflix.mediaclient.ui.diagnosis.DiagnosisActivity.5
            @Override // java.lang.Runnable
            public void run() {
                C1283.m16854("DiagnosisActivity", "DiagnosisUpdated ");
                boolean z = true;
                Iterator it = DiagnosisActivity.this.f2967.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (!((C1072) it.next()).m16147()) {
                            z = false;
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (z) {
                    DiagnosisActivity.this.m1734(InfoGroupState.SUCCESS);
                } else {
                    DiagnosisActivity.this.m1734(InfoGroupState.FAILED);
                }
                DiagnosisActivity.this.f2963.notifyDataSetChanged();
            }
        });
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private String m1727() {
        boolean z = false;
        boolean z2 = false;
        for (int i = 0; i < this.f2967.size(); i++) {
            C1072 r4 = this.f2967.get(i);
            if (!r4.m16147()) {
                if (r4.m16152()) {
                    z = true;
                } else {
                    z2 = true;
                }
            }
        }
        if (z && z2) {
            return getString(R.string.lablel_internetConnection_trouble);
        }
        if (z2) {
            return getString(R.string.label_connectivity_issue);
        }
        if (z) {
            return getString(R.string.label_netflixNotReachable);
        }
        return getString(R.string.label_networkCheckSuccessful);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱ  reason: contains not printable characters */
    private void m1734(InfoGroupState infoGroupState) {
        switch (infoGroupState) {
            case INITIAL:
                this.f2965.setText(R.string.label_checkNetwork);
                this.f2961.setText(R.string.label_testInfo);
                this.f2962.setText(R.string.label_startTest);
                this.f2962.setVisibility(0);
                this.f2969.setVisibility(4);
                return;
            case FAILED:
                this.f2965.setText(R.string.label_networkError);
                this.f2961.setVisibility(0);
                this.f2961.setText(m1727());
                this.f2962.setVisibility(0);
                this.f2962.setText(R.string.label_testAgain);
                this.f2969.setVisibility(4);
                return;
            case SUCCESS:
                this.f2965.setText(R.string.label_networkCheckSuccessful);
                this.f2962.setVisibility(0);
                this.f2962.setText(R.string.label_testAgain);
                this.f2969.setVisibility(4);
                return;
            case TEST_ONGOING:
                this.f2968.setVisibility(8);
                this.f2966.setVisibility(0);
                this.f2962.setVisibility(4);
                this.f2969.setVisibility(0);
                this.f2965.setText(R.string.label_checkingNetwork);
                this.f2961.setVisibility(4);
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public oV createManagerStatusListener() {
        return new oV() { // from class: com.netflix.mediaclient.ui.diagnosis.DiagnosisActivity.4
            @Override // o.oV
            public void onManagerReady(C2059ph phVar, Status status) {
                DiagnosisActivity.this.f2964 = DiagnosisActivity.this.getServiceManager().m9830();
                DiagnosisActivity.this.f2964.mo499(DiagnosisActivity.this);
                DiagnosisActivity.this.f2967 = DiagnosisActivity.this.f2964.mo497();
                DiagnosisActivity.this.f2966 = (ListView) DiagnosisActivity.this.findViewById(R.id.listview_diagnosis);
                DiagnosisActivity.this.f2963 = new iF(DiagnosisActivity.this);
                DiagnosisActivity.this.f2966.setAdapter((ListAdapter) DiagnosisActivity.this.f2963);
                DiagnosisActivity.this.f2965 = (TextView) DiagnosisActivity.this.findViewById(R.id.diagnosis_network_status);
                DiagnosisActivity.this.f2961 = (TextView) DiagnosisActivity.this.findViewById(R.id.diagnosis_testInfo);
                DiagnosisActivity.this.f2962 = (Button) DiagnosisActivity.this.findViewById(R.id.diagnosis_startTest);
                DiagnosisActivity.this.f2968 = (ImageView) DiagnosisActivity.this.findViewById(R.id.diagnosis_background_icon);
                DiagnosisActivity.this.f2969 = (ProgressBar) DiagnosisActivity.this.findViewById(R.id.diagnosis_loading_view);
                DiagnosisActivity.this.m1734(InfoGroupState.INITIAL);
                DiagnosisActivity.this.findViewById(R.id.diagnosis_startTest).setOnClickListener(new View.OnClickListener() { // from class: com.netflix.mediaclient.ui.diagnosis.DiagnosisActivity.4.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        DiagnosisActivity.this.m1721();
                    }
                });
            }

            @Override // o.oV
            public void onManagerUnavailable(C2059ph phVar, Status status) {
            }
        };
    }

    @SuppressLint({"ViewHolder"})
    public class iF extends ArrayAdapter<String> {

        /* renamed from: ˊ  reason: contains not printable characters */
        final Context f2980;

        public iF(Context context) {
            super(context, (int) R.layout.diagnosis_row, (int) R.id.listview_diagnosis);
            this.f2980 = context;
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        public void m1736(TextView textView, String str, int i) {
            if (str == null || !str.contains("netflix")) {
                textView.setText(R.string.label_internetConnection);
                return;
            }
            int i2 = i + 1;
            textView.setText(this.f2980.getString(R.string.label_netflixAndroidServer));
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            View inflate = ((LayoutInflater) this.f2980.getSystemService("layout_inflater")).inflate(R.layout.diagnosis_row, viewGroup, false);
            TextView textView = (TextView) inflate.findViewById(R.id.diagnosis_firstLine);
            TextView textView2 = (TextView) inflate.findViewById(R.id.diagnosis_secondLine);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.diagnosis_row_icon);
            imageView.setImageResource(R.drawable.ic_test_pass);
            C1072 r7 = (C1072) DiagnosisActivity.this.f2967.get(i);
            m1736(textView, r7.m16150(), i);
            if (r7.m16143().equals(IDiagnosis.UrlStatus.COMPLETED)) {
                if (r7.m16147()) {
                    imageView.setImageResource(R.drawable.ic_test_pass);
                    textView2.setVisibility(4);
                } else {
                    textView2.setText("nw-" + r7.m16142() + "-" + r7.m16148());
                    imageView.setImageResource(R.drawable.ic_test_fail);
                }
            } else if (r7.m16143().equals(IDiagnosis.UrlStatus.TEST_ONGOING)) {
                imageView.setVisibility(4);
                textView2.setVisibility(4);
            } else if (r7.m16143().equals(IDiagnosis.UrlStatus.NOT_TESTED)) {
                imageView.setVisibility(4);
                textView2.setVisibility(4);
                textView.setVisibility(4);
            }
            return inflate;
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public int getCount() {
            if (DiagnosisActivity.this.f2967 != null) {
                return DiagnosisActivity.this.f2967.size();
            }
            C1283.m16854("DiagnosisActivity", "urlList is null");
            return 0;
        }

        @Override // android.widget.BaseAdapter, android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            return false;
        }
    }
}
