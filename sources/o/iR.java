package o;

import android.content.Context;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.api.res.AssetType;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
public class iR extends iS {

    /* renamed from: ʼ  reason: contains not printable characters */
    private final ArrayList<String> f7636;

    /* renamed from: ˊ  reason: contains not printable characters */
    private AtomicBoolean f7637;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final String f7638;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final Context f7639;

    /* renamed from: ˏ  reason: contains not printable characters */
    private AtomicBoolean f7640;

    /* renamed from: ॱ  reason: contains not printable characters */
    private RandomAccessFile f7641;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private C2003ng f7642;

    @Override // o.iS, o.iQ
    /* renamed from: ˎ */
    public /* bridge */ /* synthetic */ ByteBuffer mo7538(int i) {
        return super.mo7538(i);
    }

    public iR(Context context, C2003ng ngVar, jM[] jMVarArr) {
        String[] r7;
        this.f7640 = new AtomicBoolean(false);
        this.f7637 = new AtomicBoolean(false);
        this.f7636 = new ArrayList<>(4);
        this.f7638 = "bif.tmp";
        this.f7639 = context;
        this.f7642 = ngVar;
        int i = -1;
        int i2 = 0;
        while (true) {
            if (i2 >= jMVarArr.length) {
                break;
            }
            String[] r72 = jMVarArr[i2].m7965();
            if (jMVarArr[i2].m7962() == 1.0f) {
                for (int i3 = 0; i3 < r72.length; i3++) {
                    C1283.m16851("BifManager", "preferred url%d == %s", Integer.valueOf(i3), r72[i3]);
                    this.f7636.add(r72[i3]);
                }
                i = i2;
            } else {
                i2++;
            }
        }
        for (int i4 = 0; i4 < jMVarArr.length; i4++) {
            if (i != i4) {
                for (String str : jMVarArr[i4].m7965()) {
                    this.f7636.add(str);
                }
            }
        }
        C1283.m16851("BifManager", "%d TrickplayUrls entities with %d urls", Integer.valueOf(jMVarArr.length), Integer.valueOf(this.f7636.size()));
        m7550();
    }

    public iR(Context context, C2003ng ngVar, String str) {
        this.f7640 = new AtomicBoolean(false);
        this.f7637 = new AtomicBoolean(false);
        this.f7636 = new ArrayList<>(4);
        this.f7638 = "mdxbif.tmp";
        this.f7639 = context;
        this.f7642 = ngVar;
        this.f7636.add(str);
        m7550();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m7550() {
        if (this.f7636.size() > 0) {
            m7551(this.f7636.get(0), 1);
        } else {
            C1283.m16850("BifManager", "Unable to download Bif, no URLs!");
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱ  reason: contains not printable characters */
    private void m7551(String str, final int i) {
        this.f7642.mo9310(str, AssetType.bif, new C2005ni() { // from class: o.iR.2
            /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x009e: APUT  
              (r2v1 java.lang.Object[])
              (1 ??[boolean, int, float, short, byte, char])
              (wrap: java.lang.Integer : 0x0099: INVOKE  (r3v2 java.lang.Integer) = (r3v1 int) type: STATIC call: java.lang.Integer.valueOf(int):java.lang.Integer)
             */
            @Override // o.C2005ni, o.AbstractC2006nj
            /* renamed from: ˎ  reason: contains not printable characters */
            public void mo7553(String str2, byte[] bArr, Status status) {
                if (!iR.this.f7637.get()) {
                    if (status.mo301()) {
                        C1283.m16855("BifManager", "Resource %s could not be fetched or retrieved from cache, status %d", str2, Integer.valueOf(status.mo302().m271()));
                        if (i < iR.this.f7636.size()) {
                            String str3 = (String) iR.this.f7636.get(i);
                            if (iR.this.f7637.get()) {
                                C1283.m16854("BifManager", "Fetch was canceled, stop");
                                return;
                            }
                            C1283.m16851("BifManager", "Try to fetch %d URL %s", Integer.valueOf(i), str3);
                            iR.this.m7551(str3, i + 1);
                            return;
                        }
                        C1283.m16850("BifManager", "We fail to download bif completely, all URLs failed");
                        return;
                    }
                    Object[] objArr = new Object[3];
                    objArr[0] = str2;
                    objArr[1] = Integer.valueOf(bArr != null ? bArr.length : -1);
                    objArr[2] = Integer.valueOf(status.mo302().m271());
                    C1283.m16851("BifManager", "Resource %s fetched, size %d, status %d", objArr);
                    FileInputStream fileInputStream = null;
                    FileOutputStream fileOutputStream = null;
                    try {
                        String str4 = iR.this.f7639.getFilesDir() + "/" + iR.this.f7638;
                        FileOutputStream openFileOutput = iR.this.f7639.openFileOutput(iR.this.f7638, 0);
                        openFileOutput.write(bArr);
                        FileInputStream openFileInput = iR.this.f7639.openFileInput(iR.this.f7638);
                        if (iR.this.m7554(openFileInput)) {
                            iR.this.f7641 = new RandomAccessFile(str4, "r");
                            iR.this.f7640.set(true);
                        }
                        synchronized (iR.this) {
                            if (iR.this.f7637.get()) {
                                iR.this.m7545();
                            }
                        }
                        if (openFileOutput != null) {
                            try {
                                openFileOutput.close();
                            } catch (Exception e) {
                                return;
                            }
                        }
                        if (openFileInput != null) {
                            openFileInput.close();
                        }
                    } catch (IOException e2) {
                        C1283.m16856("BifManager", e2, "loadBifIndexAsync has exception", new Object[0]);
                        if (0 != 0) {
                            try {
                                fileOutputStream.close();
                            } catch (Exception e3) {
                                return;
                            }
                        }
                        if (0 != 0) {
                            fileInputStream.close();
                        }
                    } catch (Throwable th) {
                        if (0 != 0) {
                            try {
                                fileOutputStream.close();
                            } catch (Exception e4) {
                                throw th;
                            }
                        }
                        if (0 != 0) {
                            fileInputStream.close();
                        }
                        throw th;
                    }
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    @Override // o.iS
    /* renamed from: ˊ */
    public boolean mo7537() {
        return this.f7640.get();
    }

    /* access modifiers changed from: protected */
    @Override // o.iS
    /* renamed from: ˏ */
    public RandomAccessFile mo7540() {
        return this.f7641;
    }

    @Override // o.iQ
    /* renamed from: ˎ */
    public synchronized void mo7539() {
        this.f7637.set(true);
        m7545();
        C1283.m16854("BifManager", "released");
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˋ  reason: contains not printable characters */
    private void m7545() {
        if (this.f7641 != null) {
            try {
                this.f7641.close();
            } catch (IOException e) {
                C1283.m16856("BifManager", e, "close file " + e, new Object[0]);
            }
        }
        this.f7639.deleteFile(this.f7638);
    }
}
