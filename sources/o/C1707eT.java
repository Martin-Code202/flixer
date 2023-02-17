package o;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
/* renamed from: o.eT  reason: case insensitive filesystem */
public class C1707eT {

    /* renamed from: ˋ  reason: contains not printable characters */
    private iF f6599;

    /* renamed from: ˎ  reason: contains not printable characters */
    private Context f6600;

    /* renamed from: ˏ  reason: contains not printable characters */
    private String f6601;

    /* renamed from: ॱ  reason: contains not printable characters */
    private Handler f6602 = new Handler() { // from class: o.eT.1
        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            AY ay = new AY(C1707eT.this.f6600);
            switch (message.what) {
                case 1:
                    C1283.m16854("nf_mdxTargetSelector", "TargetSelector: target stickiness expired");
                    ay.m3499("mdx_target_lastactive", System.currentTimeMillis());
                    ay.m3497("mdx_target_uuid", new String());
                    ay.m3494();
                    C1707eT.this.f6599.mo6179();
                    return;
                case 2:
                    ay.m3499("mdx_target_lastactive", System.currentTimeMillis());
                    ay.m3494();
                    break;
                case 3:
                    ay.m3499("mdx_target_lastactive", System.currentTimeMillis());
                    ay.m3494();
                    return;
                case 4:
                    break;
                default:
                    C1283.m16850("nf_mdxTargetSelector", "TargetSelector: unknown message");
                    return;
            }
            ay.m3497("mdx_target_uuid", C1707eT.this.f6601);
            ay.m3494();
        }
    };

    /* renamed from: o.eT$iF */
    public interface iF {
        /* renamed from: ˋ */
        void mo6170(String str);

        /* renamed from: ˎˏ */
        void mo6179();
    }

    public C1707eT(Context context, iF iFVar) {
        this.f6600 = context;
        this.f6599 = iFVar;
        long currentTimeMillis = System.currentTimeMillis() - C1339Bl.m4044(this.f6600, "mdx_target_lastactive", 0);
        if (currentTimeMillis > 12600000) {
            this.f6601 = new String();
        } else {
            this.f6601 = C1339Bl.m4045(this.f6600, "mdx_target_uuid", new String());
            m6264(12600000 - currentTimeMillis);
        }
        this.f6599.mo6170(this.f6601);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m6268(String str) {
        this.f6601 = str;
        this.f6602.sendEmptyMessage(2);
        if (C1349Bv.m4113(str)) {
            this.f6602.removeMessages(1);
        } else {
            m6264(12600000);
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m6269(String str) {
        this.f6602.sendEmptyMessage(3);
        this.f6602.removeMessages(1);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m6270(String str) {
        this.f6602.sendEmptyMessage(3);
        m6264(12600000);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m6264(long j) {
        C1283.m16854("nf_mdxTargetSelector", "TargetSelector: startCountDown " + j);
        this.f6602.removeMessages(1);
        this.f6602.sendEmptyMessageDelayed(1, j);
    }
}
