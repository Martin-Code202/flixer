package o;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.util.Linkify;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.netflix.mediaclient.NetflixApplication;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.util.ViewUtils;
import com.netflix.mediaclient.util.log.UIScreen;
import java.util.ArrayList;
import java.util.List;
public class zF extends NetflixActivity {

    /* renamed from: ˊ  reason: contains not printable characters */
    private static final List<Cif> f12598 = new ArrayList();

    /* renamed from: ˊ  reason: contains not printable characters */
    public static Intent m13422(Context context) {
        return new Intent(context, m13426());
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static Class<?> m13426() {
        return NetflixApplication.getInstance().m254() ? zB.class : zF.class;
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m13425();
        ListView listView = new ListView(this);
        listView.setDividerHeight(0);
        ViewUtils.m3037(listView);
        listView.setAdapter((ListAdapter) new If());
        setContentView(listView);
    }

    /* access modifiers changed from: protected */
    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public boolean canApplyBrowseExperience() {
        return true;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m13425() {
        f12598.clear();
        f12598.add(new Cif(m13423("RoundedImageView"), "Copyright (c) 2013, Vincent Mi\n\nLicensed under the Apache License, Version 2.0 (the \"License\"); you may not use this file except in compliance with the License.  You may obtain a copy of the License at:\n\n    http://www.apache.org/licenses/LICENSE-2.0\n\nUnless required by applicable law or agreed to in writing, software distributed under the License is distributed on an \"AS IS\" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the License for the specific language governing permissions and limitations under the License."));
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public boolean showSettingsInMenu() {
        return false;
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public boolean showSignOutInMenu() {
        return false;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private String m13423(String str) {
        return String.format(getString(R.string.label_osl_info_header), str);
    }

    class If extends BaseAdapter {
        private If() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return zF.f12598.size();
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        public Cif getItem(int i) {
            return (Cif) zF.f12598.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return (long) i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = zF.this.getLayoutInflater().inflate(R.layout.open_source_license_info_row, (ViewGroup) null);
                view.setTag(new C0314((TextView) view.findViewById(R.id.open_source_license_info_row_title), (TextView) view.findViewById(R.id.open_source_license_info_row_license)));
            }
            C0314 r3 = (C0314) view.getTag();
            Cif r4 = getItem(i);
            r3.f12602.setText(r4.f12601);
            r3.f12603.setText(r4.f12600);
            Linkify.addLinks(r3.f12603, 1);
            return view;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.zF$if  reason: invalid class name */
    public static class Cif {

        /* renamed from: ˊ  reason: contains not printable characters */
        final String f12600;

        /* renamed from: ॱ  reason: contains not printable characters */
        final String f12601;

        public Cif(String str, String str2) {
            this.f12601 = str;
            this.f12600 = str2;
        }
    }

    /* renamed from: o.zF$ˊ  reason: contains not printable characters */
    static class C0314 {

        /* renamed from: ˋ  reason: contains not printable characters */
        final TextView f12602;

        /* renamed from: ˏ  reason: contains not printable characters */
        final TextView f12603;

        public C0314(TextView textView, TextView textView2) {
            this.f12602 = textView;
            this.f12603 = textView2;
        }
    }

    @Override // o.AbstractC0459
    public boolean isLoadingData() {
        return false;
    }

    @Override // com.netflix.mediaclient.android.activity.NetflixActivity
    public UIScreen getUiScreen() {
        return UIScreen.openSourceLicenses;
    }
}
