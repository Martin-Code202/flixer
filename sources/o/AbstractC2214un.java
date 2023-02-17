package o;

import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.ui.experience.BrowseExperience;
import java.util.Locale;
import o.AbstractC0835;
/* renamed from: o.un  reason: case insensitive filesystem */
public abstract class AbstractC2214un extends AbstractC0835.Cif<pC> {

    /* renamed from: ˊ  reason: contains not printable characters */
    private View f11000;

    /* renamed from: ˎ  reason: contains not printable characters */
    private View f11001;

    /* renamed from: ॱ  reason: contains not printable characters */
    private ViewStub f11002;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final Cif f11003;

    /* renamed from: o.un$if  reason: invalid class name */
    public interface Cif {
        /* renamed from: ˎ */
        void mo2064(View view, int i);
    }

    AbstractC2214un(View view, AbstractC0954 r4, int i, Cif ifVar) {
        super(view, r4, i);
        this.f11002 = (ViewStub) view.findViewById(R.id.error_stub);
        this.f11001 = view.findViewById(i);
        this.f11003 = ifVar;
        this.f14654.addOnScrollListener(yO.m13227());
    }

    /* renamed from: ˋ */
    public void mo11706(pC pCVar) {
        this.f14654.setTrackingName(String.format(Locale.US, "Lolomo.Lomo[%s]", pCVar.getType()));
        m15478(String.format(Locale.US, "Lolomo.Lomo[%s]", pCVar.getType()));
    }

    @Override // o.AbstractC0835.AbstractC2404iF
    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo11717(boolean z) {
        if (z) {
            m11716();
        } else {
            m11718();
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m11716() {
        if (this.f11002 != null) {
            if (this.f11000 == null) {
                this.f11000 = this.f11002.inflate();
                C0754 r2 = (C0754) this.f11000.findViewById(R.id.retry_button);
                TextView textView = (TextView) this.f11000.findViewById(R.id.text_message);
                if (r2 == null || textView == null) {
                    C1276.m16820().mo5725("row error ui should have a retry button");
                } else {
                    r2.setOnClickListener(new View.OnClickListener() { // from class: o.un.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            int adapterPosition = AbstractC2214un.this.getAdapterPosition();
                            if (adapterPosition != -1) {
                                AbstractC2214un.this.f11003.mo2064(view, adapterPosition);
                            }
                        }
                    });
                    if (BrowseExperience.m1780()) {
                        r2.m15172(R.style.res_2131951856_netflixbutton_flat_light);
                        textView.setTextColor(textView.getContext().getResources().getColorStateList(R.color.flat_light_button_text));
                    }
                }
            }
            if (this.f11000 != null && this.f11001 != null) {
                this.f11000.setVisibility(0);
                this.f11001.setVisibility(4);
            }
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m11718() {
        if (this.f11000 != null && this.f11001 != null) {
            this.f11000.setVisibility(8);
            this.f11001.setVisibility(0);
        }
    }
}
