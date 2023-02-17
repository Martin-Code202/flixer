package o;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.netflix.mediaclient.R;
public final class uI extends uC {
    public uI(Context context) {
        this(context, null, 0, 6, null);
    }

    public uI(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public uI(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        C1457Fr.m5025(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ uI(Context context, AttributeSet attributeSet, int i, int i2, C1456Fq fq) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* access modifiers changed from: protected */
    @Override // o.uC
    /* renamed from: ˊ */
    public void mo11332() {
        TextView textView;
        this.f10685 = (TextView) findViewById(R.id.short_form_video_info);
        this.f10684 = (TextView) findViewById(R.id.short_form_view_title);
        this.f10682 = (C0522) findViewById(R.id.short_form_view_image);
        this.f10686 = (ProgressBar) findViewById(R.id.short_form_view_video_progress);
        if (!C0878.f14760.m15593() && (textView = this.f10685) != null) {
            textView.setVisibility(8);
        }
        if (AD.m3299()) {
            C0522 r0 = this.f10682;
            C1457Fr.m5016((Object) r0, "img");
            ViewGroup.LayoutParams layoutParams = r0.getLayoutParams();
            Context context = getContext();
            C1457Fr.m5016((Object) context, "context");
            layoutParams.height = (int) context.getResources().getDimension(R.dimen.short_form_image_height_tablet);
        }
    }

    /* access modifiers changed from: protected */
    @Override // o.uC
    /* renamed from: ˏ */
    public int mo11334() {
        return R.layout.short_form_view_ab9296;
    }

    @Override // o.uC
    /* renamed from: ˊ */
    public String mo11331(AbstractC2074pw pwVar) {
        if (pwVar != null) {
            return pwVar.createModifiedSmallStillUrl();
        }
        return null;
    }

    @Override // o.uC
    /* renamed from: ˎ */
    public void mo2123(AbstractC2074pw pwVar, AbstractC2087qh qhVar, int i, boolean z, boolean z2) {
        super.mo2123(pwVar, qhVar, i, z, z2);
        ProgressBar progressBar = this.f10686;
        C1457Fr.m5016((Object) progressBar, "progress");
        if (progressBar.getProgress() == 0) {
            ProgressBar progressBar2 = this.f10686;
            C1457Fr.m5016((Object) progressBar2, "progress");
            progressBar2.setVisibility(4);
            return;
        }
        ProgressBar progressBar3 = this.f10686;
        C1457Fr.m5016((Object) progressBar3, "progress");
        progressBar3.setVisibility(0);
    }
}
