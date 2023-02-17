package o;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import com.netflix.cl.model.AppView;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.media.AudioSource;
import com.netflix.mediaclient.media.Language;
import com.netflix.mediaclient.media.Subtitle;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.util.ViewUtils;
import org.json.JSONException;
public abstract class qI {

    /* renamed from: ˊ  reason: contains not printable characters */
    protected Language f9446;

    /* renamed from: ˋ  reason: contains not printable characters */
    protected ListView f9447;

    /* renamed from: ˎ  reason: contains not printable characters */
    protected final NetflixActivity f9448;

    /* renamed from: ˏ  reason: contains not printable characters */
    protected final AbstractC0168 f9449;

    /* renamed from: ॱ  reason: contains not printable characters */
    protected ListView f9450;

    /* renamed from: o.qI$ˊ  reason: contains not printable characters */
    public interface AbstractC0168 {
        /* renamed from: ˊ */
        void mo2532();

        /* renamed from: ˏ */
        void mo2533(Dialog dialog);

        /* renamed from: ˏ */
        void mo2534(Language language, boolean z);

        /* renamed from: ॱ */
        boolean mo2535();
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ */
    public abstract int mo9877();

    /* access modifiers changed from: protected */
    /* renamed from: ॱ */
    public abstract int mo9879();

    qI(NetflixActivity netflixActivity, AbstractC0168 r2) {
        this.f9448 = netflixActivity;
        this.f9449 = r2;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public synchronized void m9898(Language language) {
        if (language == null) {
            C1283.m16854("nf_language_selector", "Language data is null!");
            return;
        }
        try {
            this.f9446 = Language.restoreLanguage(language.toJsonString());
            View inflate = LayoutInflater.from(this.f9448).inflate(mo9879(), (ViewGroup) null);
            this.f9446.setSelectedAudio(this.f9446.getCurrentAudioSource());
            this.f9446.setSelectedSubtitle(this.f9446.getCurrentSubtitle());
            mo9878(inflate, this.f9446);
            m9897(inflate);
        } catch (JSONException e) {
            C1283.m16852("nf_language_selector", e);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˎ  reason: contains not printable characters */
    public void m9896(View view, final Language language) {
        this.f9447 = (ListView) view.findViewById(R.id.audios);
        this.f9447.setChoiceMode(1);
        final Cif ifVar = new Cif(language, this.f9448);
        this.f9447.setAdapter((ListAdapter) ifVar);
        this.f9450 = (ListView) view.findViewById(R.id.subtitles);
        this.f9450.setChoiceMode(1);
        final If r3 = new If(language, this.f9448);
        this.f9450.setAdapter((ListAdapter) r3);
        this.f9447.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: o.qI.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                C1364Cj.m4447(IClientLogging.ModalView.audioSelector, null);
                C1300Ac.m3531(new C1080(AppView.audioSelector, null), new C0550(), false);
                AudioSource r32 = ifVar.getItem(i);
                if (language.getSelectedAudio() != r32) {
                    C1283.m16846("nf_language_selector", "Audio is changed, refresh both views");
                    language.setSelectedAudio(r32);
                    ifVar.notifyDataSetChanged();
                    r3.notifyDataSetChanged();
                    return;
                }
                C1283.m16846("nf_language_selector", "Audio is not changed, do not refresh");
            }
        });
        this.f9450.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: o.qI.5
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                C1364Cj.m4447(IClientLogging.ModalView.subtitlesSelector, null);
                C1300Ac.m3531(new C1080(AppView.audioSubtitlesSelector, null), new C0550(), false);
                Subtitle r32 = r3.getItem(i);
                if (language.getSelectedSubtitle() != r32) {
                    C1283.m16846("nf_language_selector", "Subtitle is changed, refresh subtitle list view");
                    language.setSelectedSubtitle(r32);
                    r3.notifyDataSetChanged();
                    return;
                }
                C1283.m16846("nf_language_selector", "Subtitle is not changed, do not refresh");
            }
        });
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ */
    public void mo9878(View view, Language language) {
        m9896(view, language);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˏ  reason: contains not printable characters */
    public void m9897(View view) {
        final DialogC0169 r3 = new DialogC0169(this.f9448);
        final boolean r4 = this.f9449.mo2535();
        r3.setButton(-1, this.f9448.getString(R.string.label_ok), new DialogInterface.OnClickListener() { // from class: o.qI.4
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                C1283.m16854("nf_language_selector", "Languages::apply");
                qI.this.f9449.mo2534(qI.this.f9446, r4);
                r3.dismiss();
            }
        });
        r3.setView(view);
        r3.setCancelable(true);
        r3.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: o.qI.3
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                C1283.m16854("nf_language_selector", "Languages::cancel");
                qI.this.f9449.mo2532();
            }
        });
        int r5 = mo9877();
        if (r5 >= 0) {
            C1283.m16854("nf_language_selector", "Sets view height.");
            ViewGroup.LayoutParams layoutParams = this.f9447.getLayoutParams();
            layoutParams.height = r5;
            layoutParams.width = -2;
            this.f9447.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.f9450.getLayoutParams();
            layoutParams2.height = r5;
            layoutParams2.width = -2;
            this.f9450.setLayoutParams(layoutParams2);
        } else {
            C1283.m16854("nf_language_selector", "Do NOT set view height.");
        }
        C1283.m16854("nf_language_selector", "Languages::open dialog");
        this.f9449.mo2533(r3);
        if (r3 != null) {
            this.f9448.displayDialog(r3);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˊ  reason: contains not printable characters */
    public Language m9895() {
        return this.f9446;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static qI m9894(NetflixActivity netflixActivity, boolean z, AbstractC0168 r3) {
        if (z) {
            return new qF(netflixActivity, r3);
        }
        return new qE(netflixActivity, r3);
    }

    /* renamed from: o.qI$if  reason: invalid class name */
    public static class Cif extends BaseAdapter {

        /* renamed from: ˏ  reason: contains not printable characters */
        private final Activity f9466;

        /* renamed from: ॱ  reason: contains not printable characters */
        private final Language f9467;

        public Cif(Language language, Activity activity) {
            this.f9467 = language;
            this.f9466 = activity;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.f9467.getAltAudios().length;
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        public AudioSource getItem(int i) {
            return this.f9467.getAltAudios()[i];
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return (long) i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                C1283.m16854("nf_language_selector", "Audio create row " + i);
                view = this.f9466.getLayoutInflater().inflate(R.layout.language_selector_list_row, viewGroup, false);
                view.setTag(new C2079iF(view));
            }
            C2079iF iFVar = (C2079iF) view.getTag();
            AudioSource r4 = getItem(i);
            boolean equals = r4.equals(this.f9467.getSelectedAudio());
            iFVar.f9464.setText(r4.getLanguageDescriptionDisplayLabel());
            iFVar.f9465.setChecked(equals);
            if (equals) {
                ViewUtils.m3030(iFVar.f9464);
            } else {
                ViewUtils.m3038(iFVar.f9464);
            }
            return view;
        }
    }

    public static class If extends BaseAdapter {

        /* renamed from: ˊ  reason: contains not printable characters */
        private final Activity f9462;

        /* renamed from: ˋ  reason: contains not printable characters */
        private final Language f9463;

        public If(Language language, Activity activity) {
            this.f9463 = language;
            this.f9462 = activity;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.f9463.getUsedSubtitles().size();
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public Subtitle getItem(int i) {
            return this.f9463.getUsedSubtitles().get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return (long) i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            boolean z;
            String str;
            if (view == null) {
                C1283.m16854("nf_language_selector", "Subtitle create row " + i);
                view = this.f9462.getLayoutInflater().inflate(R.layout.language_selector_list_row, viewGroup, false);
                view.setTag(new C2079iF(view));
            }
            C2079iF iFVar = (C2079iF) view.getTag();
            Subtitle r4 = getItem(i);
            Subtitle selectedSubtitle = this.f9463.getSelectedSubtitle();
            if (m9899(this.f9463, i, r4)) {
                C1283.m16854("nf_language_selector", "Previously selected subtitle is not allowed anymore, reset to first on list, reload seleted subtitle");
                selectedSubtitle = this.f9463.getSelectedSubtitle();
            }
            if (r4 != null) {
                StringBuilder sb = new StringBuilder(r4.getLanguageDescription());
                if (r4.isCC()) {
                    C1283.m16854("nf_language_selector", "Add CC");
                    sb.append(' ');
                    sb.append(this.f9462.getText(R.string.label_cc));
                }
                str = sb.toString();
                z = selectedSubtitle != null ? r4.equals(selectedSubtitle) : r4.isForcedNarrativeOrNone();
            } else {
                str = this.f9462.getString(R.string.label_none);
                z = selectedSubtitle == null;
            }
            iFVar.f9464.setText(str);
            iFVar.f9465.setChecked(z);
            if (z) {
                ViewUtils.m3030(iFVar.f9464);
            } else {
                ViewUtils.m3038(iFVar.f9464);
            }
            return view;
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        private boolean m9899(Language language, int i, Subtitle subtitle) {
            if (i != 0) {
                return false;
            }
            Subtitle selectedSubtitle = language.getSelectedSubtitle();
            AudioSource selectedAudio = language.getSelectedAudio();
            if (selectedAudio == null || !selectedAudio.isAllowedSubtitle(selectedSubtitle)) {
                language.setSelectedSubtitle(subtitle);
                return true;
            }
            C1283.m16854("nf_language_selector", "Selected subtitle is allowed");
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.qI$ˋ  reason: contains not printable characters */
    public class DialogC0169 extends AlertDialog {
        private DialogC0169(Context context) {
            super(context);
        }
    }

    /* renamed from: o.qI$iF  reason: case insensitive filesystem */
    static class C2079iF {

        /* renamed from: ˊ  reason: contains not printable characters */
        TextView f9464;

        /* renamed from: ˋ  reason: contains not printable characters */
        RadioButton f9465;

        C2079iF(View view) {
            this.f9464 = (TextView) view.findViewById(R.id.language_selector_list_row_name);
            this.f9465 = (RadioButton) view.findViewById(R.id.language_selector_list_row_choice);
        }
    }
}
