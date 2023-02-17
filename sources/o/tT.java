package o;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.netflix.mediaclient.servicemgr.UiLocation;
import com.netflix.mediaclient.ui.lolomo.LolomoRecyclerViewAdapter;
import o.AbstractC0837;
import o.AbstractC0837.AbstractC0838;
import o.pJ;
import org.json.JSONObject;
public abstract class tT<T extends AbstractC0837.AbstractC0838, O extends pJ> extends AbstractC2195ty<T, O> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public tT(Context context, pC pCVar, LolomoRecyclerViewAdapter lolomoRecyclerViewAdapter, AbstractC0954 r5, int i) {
        super(context, pCVar, lolomoRecyclerViewAdapter, r5, i);
        C1457Fr.m5025(context, "context");
        C1457Fr.m5025(pCVar, "lomo");
        C1457Fr.m5025(lolomoRecyclerViewAdapter, "parentAdapter");
        C1457Fr.m5025(r5, "config");
    }

    /* renamed from: o.tT$ˊ  reason: contains not printable characters */
    public static abstract class AbstractC0216 extends AbstractC0837.AbstractC0838 {

        /* renamed from: ˋ  reason: contains not printable characters */
        private final yQ f10444;

        /* renamed from: ˏ  reason: contains not printable characters */
        private tU f10445;

        /* renamed from: ॱ  reason: contains not printable characters */
        private AbstractC2072pu f10446;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public AbstractC0216(ViewGroup viewGroup, View view, AbstractC0954 r4, int i) {
            super(viewGroup, view, r4, i);
            C1457Fr.m5025(viewGroup, "parent");
            C1457Fr.m5025(view, "itemView");
            C1457Fr.m5025(r4, "config");
            this.f10444 = new Cif(this, view);
        }

        /* renamed from: ʽ  reason: contains not printable characters */
        public final AbstractC2072pu m11024() {
            return this.f10446;
        }

        /* renamed from: ॱॱ  reason: contains not printable characters */
        public final tU m11026() {
            return this.f10445;
        }

        /* renamed from: o.tT$ˊ$if  reason: invalid class name */
        public static final class Cif extends yQ {

            /* renamed from: ˊ  reason: contains not printable characters */
            final /* synthetic */ AbstractC0216 f10447;

            /* renamed from: ˎ  reason: contains not printable characters */
            final /* synthetic */ View f10448;

            Cif(AbstractC0216 r1, View view) {
                this.f10447 = r1;
                this.f10448 = view;
            }

            @Override // o.yQ
            /* renamed from: ॱ  reason: contains not printable characters */
            public View mo11032() {
                return this.f10448;
            }

            @Override // o.yQ
            /* renamed from: ˎ  reason: contains not printable characters */
            public AbstractC2072pu mo11030() {
                return this.f10447.m11024();
            }

            @Override // o.yQ
            /* renamed from: ˋ  reason: contains not printable characters */
            public Integer mo11029() {
                if (this.f10447.getAdapterPosition() == -1) {
                    return null;
                }
                return Integer.valueOf(this.f10447.getAdapterPosition());
            }

            @Override // o.yQ
            /* renamed from: ˏ  reason: contains not printable characters */
            public Integer mo11031() {
                tU r0 = this.f10447.m11026();
                if (r0 != null) {
                    return Integer.valueOf(r0.mo10875());
                }
                return null;
            }

            /* renamed from: ॱॱ  reason: contains not printable characters */
            public pC mo11028() {
                tU r0 = this.f10447.m11026();
                if (r0 != null) {
                    return r0.mo10878();
                }
                return null;
            }

            @Override // o.yQ
            /* renamed from: ʻ  reason: contains not printable characters */
            public JSONObject mo11027() {
                return this.f10447.mo10914(this.f10447.m11024(), this.f10447.m11026());
            }

            @Override // o.yQ
            /* renamed from: ᐝ  reason: contains not printable characters */
            public UiLocation mo11034() {
                tU r0 = this.f10447.m11026();
                if (r0 != null) {
                    return r0.mo10874();
                }
                return null;
            }
        }

        @Override // o.AbstractC0837.AbstractC0838
        /* renamed from: ˏ  reason: contains not printable characters */
        public void mo11025() {
            this.f10444.m13244(false);
            super.mo11025();
            mo11023();
        }

        /* renamed from: ˊ */
        public void mo10906(tU tUVar, AbstractC2072pu puVar, int i, boolean z) {
            C1457Fr.m5025(tUVar, "lomoContext");
            this.f10444.m13244(false);
            this.f10445 = tUVar;
            this.f10446 = puVar;
        }

        @Override // o.AbstractC0837.AbstractC0838
        public void X_() {
            this.f10446 = null;
            this.f10445 = null;
            yO.m13229(this.f10444);
            super.X_();
        }

        /* renamed from: ʻ  reason: contains not printable characters */
        public void mo11023() {
            yO.m13231(this.f10444);
        }

        /* renamed from: ॱ */
        public JSONObject mo10914(AbstractC2072pu puVar, tU tUVar) {
            return null;
        }
    }
}
