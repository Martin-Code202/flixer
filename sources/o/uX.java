package o;

import android.view.KeyEvent;
import com.netflix.mediaclient.android.app.BackgroundTask;
public class uX {

    /* renamed from: ˏ  reason: contains not printable characters */
    private final AO f10954 = new AO();

    /* renamed from: ॱ  reason: contains not printable characters */
    private final Cif f10955;

    /* renamed from: o.uX$if  reason: invalid class name */
    public interface Cif {
        /* renamed from: ˏ */
        int mo11500();

        /* renamed from: ˏ */
        void mo11501(int i);
    }

    public uX(Cif ifVar) {
        this.f10955 = ifVar;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public boolean m11668(KeyEvent keyEvent, C2059ph phVar, final C2240vj vjVar) {
        if (vjVar == null) {
            return false;
        }
        if (!AU.m3423(phVar)) {
            C1283.m16854("nf_key", "Current mdx target is not available - not handling key event");
            return false;
        } else if (keyEvent.getAction() != 0) {
            return false;
        } else {
            switch (keyEvent.getKeyCode()) {
                case 24:
                    if (!m11667(vjVar)) {
                        C1283.m16854("nf_key", "Volume key up is pressed, pass it");
                        return false;
                    } else if (this.f10954.m3396(keyEvent)) {
                        C1283.m16854("nf_key", "Volume key up is pressed, ignored");
                        return true;
                    } else {
                        C1283.m16854("nf_key", "Volume key up is pressed, sending...");
                        new BackgroundTask().m285(new Runnable() { // from class: o.uX.2
                            @Override // java.lang.Runnable
                            public void run() {
                                vjVar.m12164(uX.this.f10955.mo11500() + 10);
                                uX.this.f10955.mo11501(vjVar.m12150());
                            }
                        });
                        return true;
                    }
                case 25:
                    if (!m11667(vjVar)) {
                        C1283.m16854("nf_key", "Volume key down is pressed, pass it");
                        return false;
                    } else if (this.f10954.m3396(keyEvent)) {
                        C1283.m16854("nf_key", "Volume key down is pressed, ignored");
                        return true;
                    } else {
                        C1283.m16854("nf_key", "Volume key down is pressed, sending...");
                        new BackgroundTask().m285(new Runnable() { // from class: o.uX.3
                            @Override // java.lang.Runnable
                            public void run() {
                                vjVar.m12164(uX.this.f10955.mo11500() - 10);
                                uX.this.f10955.mo11501(vjVar.m12150());
                            }
                        });
                        return true;
                    }
                default:
                    return false;
            }
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private boolean m11667(C2240vj vjVar) {
        C1283.m16846("nf_key", vjVar == null ? "null player" : String.valueOf(vjVar.m12151()));
        return (vjVar == null || vjVar.m12151() == null || !vjVar.m12151().m6249()) ? false : true;
    }
}
