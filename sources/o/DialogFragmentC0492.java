package o;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.dialogs.CountrySelectorDialogFragment$countrySelection$1;
import com.netflix.mediaclient.service.webclient.model.leafs.PhoneCode;
import com.netflix.mediaclient.service.webclient.model.leafs.PhoneCodesData;
import java.util.HashMap;
import java.util.List;
/* renamed from: o.к  reason: contains not printable characters */
public final class DialogFragmentC0492 extends DialogFragment {

    /* renamed from: ˏ  reason: contains not printable characters */
    public static final C0495 f13598 = new C0495(null);

    /* renamed from: ˊ  reason: contains not printable characters */
    private PhoneCodesData f13599;

    /* renamed from: ˋ  reason: contains not printable characters */
    private AbstractC1450Fk<? super String, EA> f13600 = CountrySelectorDialogFragment$countrySelection$1.f987;

    /* renamed from: ॱ  reason: contains not printable characters */
    private HashMap f13601;

    @Override // android.app.DialogFragment, android.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        m14462();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m14462() {
        if (this.f13601 != null) {
            this.f13601.clear();
        }
    }

    /* renamed from: o.к$ˋ  reason: contains not printable characters */
    public static final class C0495 {
        private C0495() {
        }

        public /* synthetic */ C0495(C1456Fq fq) {
            this();
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        public final DialogFragmentC0492 m14468(AbstractC1450Fk<? super String, EA> fk) {
            C1457Fr.m5025(fk, "countrySelection");
            DialogFragmentC0492 r1 = new DialogFragmentC0492();
            r1.f13600 = fk;
            return r1;
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public final PhoneCodesData m14461() {
        return this.f13599;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public final void m14463(PhoneCodesData phoneCodesData) {
        this.f13599 = phoneCodesData;
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, 0);
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        C1457Fr.m5025(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.dialog_country_code_selector, viewGroup, false);
        C1457Fr.m5016((Object) inflate, "v");
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.Cif.recyclerView);
        recyclerView.setHasFixedSize(true);
        C1457Fr.m5016((Object) recyclerView, "countriesList");
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        Activity activity = getActivity();
        C1457Fr.m5016((Object) activity, "activity");
        recyclerView.setAdapter(new C0493(this, activity, this.f13600));
        getDialog().setCanceledOnTouchOutside(true);
        return inflate;
    }

    /* renamed from: o.к$ˊ  reason: contains not printable characters */
    public final class C0493 extends RecyclerView.Adapter<If> {

        /* renamed from: ˋ  reason: contains not printable characters */
        private AbstractC1450Fk<? super String, EA> f13602;

        /* renamed from: ˏ  reason: contains not printable characters */
        private Context f13603;

        /* renamed from: ॱ  reason: contains not printable characters */
        final /* synthetic */ DialogFragmentC0492 f13604;

        public C0493(DialogFragmentC0492 r2, Context context, AbstractC1450Fk<? super String, EA> fk) {
            C1457Fr.m5025(context, "context");
            C1457Fr.m5025(fk, "countrySelection");
            this.f13604 = r2;
            this.f13603 = context;
            this.f13602 = fk;
        }

        /* renamed from: o.к$ˊ$If */
        public final class If extends RecyclerView.ViewHolder {

            /* renamed from: ˋ  reason: contains not printable characters */
            private final TextView f13605;

            /* renamed from: ˏ  reason: contains not printable characters */
            final /* synthetic */ C0493 f13606;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public If(C0493 r2, View view) {
                super(view);
                C1457Fr.m5025(view, "itemView");
                this.f13606 = r2;
                this.f13605 = (TextView) view.findViewById(R.Cif.text);
            }

            /* renamed from: ˏ  reason: contains not printable characters */
            public final TextView m14467() {
                return this.f13605;
            }
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public If onCreateViewHolder(ViewGroup viewGroup, int i) {
            C1457Fr.m5025(viewGroup, "parent");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_country, viewGroup, false);
            C1457Fr.m5016((Object) inflate, "view");
            return new If(this, inflate);
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public void onBindViewHolder(If r7, int i) {
            List<PhoneCode> phoneCodes;
            C1457Fr.m5025(r7, "viewHolder");
            PhoneCodesData r0 = this.f13604.m14461();
            PhoneCode phoneCode = (r0 == null || (phoneCodes = r0.getPhoneCodes()) == null) ? null : phoneCodes.get(i);
            if (phoneCode != null) {
                String name = phoneCode.getName();
                String code = phoneCode.getCode();
                TextView r02 = r7.m14467();
                C1457Fr.m5016((Object) r02, "viewHolder.textView");
                r02.setText("" + name + " +" + code);
                r7.m14467().setOnClickListener(new View$OnClickListenerC0494(this, phoneCode));
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: o.к$ˊ$ˋ  reason: contains not printable characters */
        public static final class View$OnClickListenerC0494 implements View.OnClickListener {

            /* renamed from: ˊ  reason: contains not printable characters */
            final /* synthetic */ PhoneCode f13607;

            /* renamed from: ॱ  reason: contains not printable characters */
            final /* synthetic */ C0493 f13608;

            View$OnClickListenerC0494(C0493 r1, PhoneCode phoneCode) {
                this.f13608 = r1;
                this.f13607 = phoneCode;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f13608.f13602.invoke(this.f13607.getId());
                this.f13608.f13604.dismiss();
            }
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemCount() {
            List<PhoneCode> phoneCodes;
            PhoneCodesData r0 = this.f13604.m14461();
            if (r0 == null || (phoneCodes = r0.getPhoneCodes()) == null) {
                return 0;
            }
            return phoneCodes.size();
        }
    }
}
