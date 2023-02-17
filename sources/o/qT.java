package o;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.netflix.mediaclient.R;
public class qT {

    /* renamed from: ˊ  reason: contains not printable characters */
    private pT f9546;

    /* renamed from: ˋ  reason: contains not printable characters */
    private TextView f9547;

    /* renamed from: ˎ  reason: contains not printable characters */
    private int f9548;

    /* renamed from: ˏ  reason: contains not printable characters */
    private boolean f9549;

    /* renamed from: ॱ  reason: contains not printable characters */
    private ViewGroup f9550;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final Context f9551;

    /* renamed from: ॱ  reason: contains not printable characters */
    public static qT m9959(pT pTVar, Context context) {
        ViewGroup viewGroup = (ViewGroup) ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.video_details_copyright, (ViewGroup) null);
        if (viewGroup != null) {
            return new qT(pTVar, context, viewGroup);
        }
        return null;
    }

    public qT(pT pTVar, Context context, ViewGroup viewGroup) {
        this.f9550 = viewGroup;
        this.f9546 = pTVar;
        this.f9551 = context;
        m9951();
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m9964() {
        this.f9549 = true;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m9951() {
        if (this.f9546 != null && this.f9550 != null) {
            this.f9547 = (TextView) this.f9550.findViewById(R.id.video_details_copyright);
            if (this.f9547 != null && this.f9546 != null) {
                this.f9547.setText(this.f9546.getCopyright());
                this.f9547.setVisibility(0);
                m9957();
                m9960();
            }
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m9957() {
        if (this.f9549) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f9547.getLayoutParams();
            layoutParams.addRule(13, -1);
            this.f9547.setLayoutParams(layoutParams);
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public View m9963() {
        return this.f9550;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m9960() {
        this.f9547.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: o.qT.2
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                qT.this.f9547.removeOnLayoutChangeListener(this);
                Layout layout = qT.this.f9547.getLayout();
                qT.this.f9548 = qT.this.f9550.getMeasuredHeight() * 3;
                if (layout != null && layout.getEllipsisCount(0) > 0) {
                    qT.this.f9547.setOnClickListener(new View.OnClickListener() { // from class: o.qT.2.4
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            qT.this.m9961(qT.this.f9546);
                        }
                    });
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱ  reason: contains not printable characters */
    private void m9961(pT pTVar) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.f9551);
        View inflate = ((LayoutInflater) this.f9551.getSystemService("layout_inflater")).inflate(R.layout.video_details_copyright_expanded, (ViewGroup) null);
        if (inflate != null) {
            m9962(pTVar, inflate);
            builder.setView(inflate);
            AlertDialog create = builder.create();
            m9952(create);
            create.show();
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m9962(pT pTVar, View view) {
        TextView textView = (TextView) view.findViewById(R.id.video_details_copyright_expanded);
        if (textView != null) {
            textView.setText(pTVar.getCopyright());
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m9952(AlertDialog alertDialog) {
        int[] iArr = new int[2];
        this.f9550.getLocationOnScreen(iArr);
        WindowManager.LayoutParams attributes = alertDialog.getWindow().getAttributes();
        attributes.gravity = (this.f9549 ? 17 : 8388611) | 48;
        attributes.x = iArr[0];
        attributes.y = iArr[1] - this.f9548;
    }
}
