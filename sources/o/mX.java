package o;

import android.content.Context;
import com.netflix.mediaclient.service.pservice.PDiskData;
import java.io.File;
import o.BP;
public final class mX {

    /* renamed from: ˊ  reason: contains not printable characters */
    private static final Object f8858 = new Object();

    /* renamed from: ˏ  reason: contains not printable characters */
    public static final Boolean f8859 = false;

    /* renamed from: o.mX$iF  reason: case insensitive filesystem */
    public static class C1969iF {
        /* renamed from: ˏ */
        public void mo2751(PDiskData pDiskData) {
            if (mX.f8859.booleanValue()) {
                C1283.m16854("nf_preapp_dataRepo", "onDataLoaded - diskData.print");
                pDiskData.print();
            }
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static void m8972(Context context, final C1969iF iFVar) {
        C1283.m16854("nf_preapp_dataRepo", "starting load from Disk");
        BP r2 = m8976(context);
        AnonymousClass5 r3 = new If(r2, iFVar) { // from class: o.mX.5
            @Override // o.BP.AbstractC1327iF
            /* renamed from: ॱ */
            public void mo3905(BP.If[] ifArr) {
                if (ifArr == null || ifArr.length <= 0) {
                    C1283.m16854("nf_preapp_dataRepo", "No saved preAppData found.");
                    m8978().mo2751(null);
                    return;
                }
                mX.m8975(m8979(), ifArr, iFVar);
            }
        };
        synchronized (f8858) {
            r2.mo3900(r3);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: ˎ  reason: contains not printable characters */
    public static void m8975(BP bp, BP.If[] ifArr, C1969iF iFVar) {
        if (ifArr == null || ifArr.length < 1) {
            C1283.m16854("nf_preapp_dataRepo", "No saved data found");
            iFVar.mo2751(null);
            return;
        }
        bp.mo3899(ifArr[0].mo3882(), new AbstractC0150(iFVar) { // from class: o.mX.2
            @Override // o.BP.AbstractC0068
            /* renamed from: ˎ */
            public void mo3907(String str, String str2, byte[] bArr, long j) {
                PDiskData pDiskData = null;
                if (bArr == null || bArr.length < 1) {
                    C1283.m16850("nf_preapp_dataRepo", "We failed to retrieve payload.");
                } else {
                    try {
                        pDiskData = PDiskData.fromJsonString(new String(bArr, "utf-8"));
                        if (mX.f8859.booleanValue()) {
                            C1283.m16854("nf_preapp_dataRepo", "onDataLoaded - diskData.print");
                            pDiskData.print();
                        }
                    } catch (Throwable th) {
                        C1283.m16847("nf_preapp_dataRepo", "Failed to build object from stored data.", th);
                    }
                }
                m8980().mo2751(pDiskData);
            }
        });
    }

    static abstract class If implements BP.AbstractC1327iF {

        /* renamed from: ˊ  reason: contains not printable characters */
        private final BP f8861;

        /* renamed from: ˏ  reason: contains not printable characters */
        private final C1969iF f8862;

        public If(BP bp, C1969iF iFVar) {
            this.f8862 = iFVar;
            this.f8861 = bp;
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        public C1969iF m8978() {
            return this.f8862;
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        public BP m8979() {
            return this.f8861;
        }
    }

    /* renamed from: o.mX$ˊ  reason: contains not printable characters */
    static abstract class AbstractC0150 implements BP.AbstractC0068 {

        /* renamed from: ˊ  reason: contains not printable characters */
        private final C1969iF f8863;

        public AbstractC0150(C1969iF iFVar) {
            this.f8863 = iFVar;
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public C1969iF m8980() {
            return this.f8863;
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private static BP m8976(Context context) {
        File file = new File(context.getFilesDir(), PDiskData.REPOSITORY_DIR);
        if (!file.isDirectory()) {
            file.mkdirs();
        }
        return new BO(file);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static void m8977(Context context, String str, BP.Cif ifVar) {
        BP r3 = m8976(context);
        try {
            C1283.m16854("nf_preapp_dataRepo", "saving payload to file: REPOSITORY_FILE_NAME");
            f8859.booleanValue();
            synchronized (f8858) {
                r3.mo3902(PDiskData.REPOSITORY_FILE_NAME, str.getBytes("utf-8"), null, ifVar);
            }
        } catch (Throwable th) {
            C1283.m16847("nf_preapp_dataRepo", "Failed to save payload to repository", th);
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static void m8974(Context context) {
        if (f8859.booleanValue()) {
            C1283.m16854("nf_preapp_dataRepo", String.format("clearDiskData", new Object[0]));
        }
        BP r3 = m8976(context);
        synchronized (f8858) {
            r3.mo3896();
        }
    }
}
