package o;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;
public class iP extends iS {

    /* renamed from: ˊ  reason: contains not printable characters */
    private Thread f7631;

    /* renamed from: ˏ  reason: contains not printable characters */
    private AtomicBoolean f7632 = new AtomicBoolean(false);

    /* renamed from: ॱ  reason: contains not printable characters */
    private RandomAccessFile f7633;

    @Override // o.iS, o.iQ
    /* renamed from: ˎ  reason: contains not printable characters */
    public /* bridge */ /* synthetic */ ByteBuffer mo7538(int i) {
        return super.mo7538(i);
    }

    public iP(final String str) {
        this.f7631 = new Thread(new Runnable() { // from class: o.iP.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (iP.this.m7554(new FileInputStream(str))) {
                        iP.this.f7633 = new RandomAccessFile(str, "r");
                        iP.this.f7632.set(true);
                    }
                } catch (FileNotFoundException e) {
                }
            }
        }, "OfflineBifManagerThread");
        this.f7631.start();
    }

    /* access modifiers changed from: protected */
    @Override // o.iS
    /* renamed from: ˊ  reason: contains not printable characters */
    public boolean mo7537() {
        return this.f7632.get();
    }

    /* access modifiers changed from: protected */
    @Override // o.iS
    /* renamed from: ˏ  reason: contains not printable characters */
    public RandomAccessFile mo7540() {
        return this.f7633;
    }

    @Override // o.iQ
    /* renamed from: ˎ  reason: contains not printable characters */
    public void mo7539() {
        this.f7631.interrupt();
        try {
            this.f7631.join();
        } catch (InterruptedException e) {
            C1283.m16856("OfflineBifManager", e, "release " + e, new Object[0]);
        }
        if (this.f7633 != null) {
            try {
                this.f7633.close();
            } catch (IOException e2) {
                C1283.m16856("OfflineBifManager", e2, "close file " + e2, new Object[0]);
            }
        }
        C1283.m16854("OfflineBifManager", "released");
    }
}
