package o;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.service.webclient.model.leafs.ABTestConfig;
public class vR {

    /* renamed from: ʼ  reason: contains not printable characters */
    private Context f11233;

    /* renamed from: ˊ  reason: contains not printable characters */
    private String f11234;

    /* renamed from: ˋ  reason: contains not printable characters */
    private String f11235;

    /* renamed from: ˎ  reason: contains not printable characters */
    private String f11236;

    /* renamed from: ˏ  reason: contains not printable characters */
    private String f11237;

    /* renamed from: ॱ  reason: contains not printable characters */
    private String f11238;

    public vR(Context context) {
        ABTestConfig.Cell r2 = C1272.m16797(C1059.class, context);
        this.f11233 = context;
        this.f11234 = context.getString(R.string.offline_tooltip_title);
        this.f11235 = context.getString(R.string.label_ok);
        this.f11237 = context.getString(R.string.offline_action_something_to_download);
        switch (r2) {
            case CELL_1:
            case CELL_5:
                this.f11236 = context.getString(R.string.offline_tooltip_fullscreen_cell1_title);
                this.f11238 = context.getString(R.string.offline_tooltip_fullscreen_description);
                return;
            case CELL_3:
                this.f11236 = context.getString(R.string.offline_tooltip_fullscreen_cell3_title);
                this.f11238 = context.getString(R.string.offline_tooltip_fullscreen_description);
                return;
            default:
                return;
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public View m12034(ViewGroup viewGroup, final vP vPVar) {
        View inflate = LayoutInflater.from(this.f11233).inflate(R.layout.offline_tutorial, viewGroup, true);
        ((TextView) inflate.findViewById(R.id.header_text)).setText(this.f11234);
        ((TextView) inflate.findViewById(R.id.title_text)).setText(this.f11236);
        ((TextView) inflate.findViewById(R.id.body_text)).setText(this.f11238);
        ((TextView) inflate.findViewById(R.id.next_button)).setText(this.f11237);
        ((TextView) inflate.findViewById(R.id.close_button)).setText(this.f11235);
        inflate.findViewById(R.id.next_button_container).setOnClickListener(new View.OnClickListener() { // from class: o.vR.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                vPVar.m12030();
                vPVar.dismiss();
            }
        });
        inflate.findViewById(R.id.close_button).setOnClickListener(new View.OnClickListener() { // from class: o.vR.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                vPVar.dismiss();
            }
        });
        return inflate;
    }
}
