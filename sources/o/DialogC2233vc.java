package o;

import android.app.Activity;
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
import android.widget.TextView;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.util.ViewUtils;
import java.util.ArrayList;
import java.util.List;
/* renamed from: o.vc  reason: case insensitive filesystem */
public class DialogC2233vc extends AlertDialog {
    private DialogC2233vc(Context context) {
        super(context);
    }

    /* renamed from: o.vc$ˋ  reason: contains not printable characters */
    public static class C0245 extends AlertDialog.Builder {

        /* renamed from: ˊ  reason: contains not printable characters */
        private final View f11313;

        /* renamed from: ˋ  reason: contains not printable characters */
        private final If f11314;

        /* renamed from: ˎ  reason: contains not printable characters */
        private final TextView f11315 = ((TextView) this.f11313.findViewById(R.id.mdx_dialog_title));

        /* renamed from: ˏ  reason: contains not printable characters */
        private final ListView f11316 = ((ListView) this.f11313.findViewById(R.id.mdx_dialog_list_view));

        /* renamed from: ॱ  reason: contains not printable characters */
        private final Activity f11317;

        /* renamed from: ᐝ  reason: contains not printable characters */
        private DialogInterface.OnCancelListener f11318;

        public C0245(Activity activity) {
            super(activity);
            this.f11317 = activity;
            LayoutInflater layoutInflater = activity.getLayoutInflater();
            this.f11313 = layoutInflater.inflate(R.layout.mdx_target_selection_dialog, (ViewGroup) null);
            this.f11314 = new If(layoutInflater);
            this.f11316.setAdapter((ListAdapter) this.f11314);
            setCancelable(true);
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public C0245 setTitle(int i) {
            this.f11315.setText(i);
            return this;
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public C0245 setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
            this.f11318 = onCancelListener;
            return this;
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        public void m12128(List<String> list) {
            this.f11314.m12124(list);
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        public void m12129(int i, String str) {
            this.f11314.m12122(i, str);
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        public void m12130(final AdapterView.OnItemClickListener onItemClickListener) {
            this.f11316.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: o.vc.ˋ.5
                @Override // android.widget.AdapterView.OnItemClickListener
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    C0245.this.f11314.notifyDataSetChanged();
                    onItemClickListener.onItemClick(adapterView, view, i, j);
                }
            });
        }

        @Override // android.support.v7.app.AlertDialog.Builder
        public AlertDialog create() {
            DialogC2233vc vcVar = new DialogC2233vc(this.f11317);
            vcVar.setView(this.f11313);
            vcVar.setCanceledOnTouchOutside(true);
            if (this.f11318 != null) {
                vcVar.setOnCancelListener(this.f11318);
            }
            return vcVar;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.vc$If */
    public static class If extends BaseAdapter {

        /* renamed from: ˊ  reason: contains not printable characters */
        private String f11307;

        /* renamed from: ˋ  reason: contains not printable characters */
        private final LayoutInflater f11308;

        /* renamed from: ˎ  reason: contains not printable characters */
        private int f11309;

        /* renamed from: ॱ  reason: contains not printable characters */
        private List<String> f11310 = new ArrayList();

        public If(LayoutInflater layoutInflater) {
            this.f11308 = layoutInflater;
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public void m12124(List<String> list) {
            this.f11310 = list;
            notifyDataSetChanged();
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public void m12122(int i, String str) {
            this.f11309 = i;
            this.f11307 = str;
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            Cif ifVar;
            if (view == null) {
                view = this.f11308.inflate(R.layout.mdx_dialog_list_item, (ViewGroup) null);
                ifVar = new Cif((TextView) view.findViewById(R.id.mdx_dialog_list_item_title), (TextView) view.findViewById(R.id.mdx_dialog_list_item_sub_title));
                view.setTag(ifVar);
            } else {
                ifVar = (Cif) view.getTag();
            }
            ifVar.f11311.setText(getItem(i));
            boolean z = i == this.f11309;
            ifVar.f11312.setText(z ? this.f11307 : "");
            if (z) {
                ifVar.f11312.setVisibility(C1349Bv.m4113(this.f11307) ? 8 : 0);
            } else {
                ifVar.f11312.setVisibility(8);
            }
            if (z) {
                ViewUtils.m3030(ifVar.f11311);
                ViewUtils.m3030(ifVar.f11312);
            } else {
                ViewUtils.m3038(ifVar.f11311);
                ViewUtils.m3038(ifVar.f11312);
            }
            return view;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return (long) i;
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        public String getItem(int i) {
            return this.f11310.get(i);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.f11310.size();
        }
    }

    /* renamed from: o.vc$if  reason: invalid class name */
    static class Cif {

        /* renamed from: ˊ  reason: contains not printable characters */
        TextView f11311;

        /* renamed from: ˏ  reason: contains not printable characters */
        TextView f11312;

        Cif(TextView textView, TextView textView2) {
            this.f11311 = textView;
            this.f11312 = textView2;
        }
    }
}
