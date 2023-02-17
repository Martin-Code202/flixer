package o;

import android.content.Context;
import android.util.Log;
import com.getkeepsafe.relinker.MissingLibraryException;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import o.C1064;
/* renamed from: o.ﺒ  reason: contains not printable characters */
public class C1182 {

    /* renamed from: ʼ  reason: contains not printable characters */
    protected C1064.AbstractC2409iF f15531;

    /* renamed from: ˊ  reason: contains not printable characters */
    protected final C1064.Cif f15532;

    /* renamed from: ˋ  reason: contains not printable characters */
    protected boolean f15533;

    /* renamed from: ˎ  reason: contains not printable characters */
    protected final Set<String> f15534;

    /* renamed from: ˏ  reason: contains not printable characters */
    protected boolean f15535;

    /* renamed from: ॱ  reason: contains not printable characters */
    protected final C1064.If f15536;

    protected C1182() {
        this(new C1117(), new C0947());
    }

    protected C1182(C1064.If r3, C1064.Cif ifVar) {
        this.f15534 = new HashSet();
        if (r3 == null) {
            throw new IllegalArgumentException("Cannot pass null library loader");
        } else if (ifVar == null) {
            throw new IllegalArgumentException("Cannot pass null library installer");
        } else {
            this.f15536 = r3;
            this.f15532 = ifVar;
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m16436(Context context, String str) {
        m16437(context, str, null, null);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m16437(final Context context, final String str, final String str2, final C1064.AbstractC1065 r11) {
        if (context == null) {
            throw new IllegalArgumentException("Given context is null");
        } else if (C1190.m16452(str)) {
            throw new IllegalArgumentException("Given library is either null or empty");
        } else {
            m16440("Beginning load of %s...", str);
            if (r11 == null) {
                m16432(context, str, str2);
            } else {
                new Thread(new Runnable() { // from class: o.ﺒ.4
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            C1182.this.m16432(context, str, str2);
                            r11.m16123();
                        } catch (UnsatisfiedLinkError e) {
                            r11.m16124(e);
                        } catch (MissingLibraryException e2) {
                            r11.m16124(e2);
                        }
                    }
                }).start();
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˊ  reason: contains not printable characters */
    private void m16432(Context context, String str, String str2) {
        if (!this.f15534.contains(str) || this.f15535) {
            try {
                this.f15536.mo16119(str);
                this.f15534.add(str);
                m16440("%s (%s) was loaded normally!", str, str2);
            } catch (UnsatisfiedLinkError e) {
                m16440("Loading the library normally failed: %s", Log.getStackTraceString(e));
                m16440("%s (%s) was not loaded normally, re-linking...", str, str2);
                File r6 = m16434(context, str, str2);
                if (!r6.exists() || this.f15535) {
                    if (this.f15535) {
                        m16440("Forcing a re-link of %s (%s)...", str, str2);
                    }
                    m16439(context, str, str2);
                    this.f15532.mo15763(context, this.f15536.mo16120(), this.f15536.mo16118(str), r6, this);
                }
                try {
                    if (this.f15533) {
                        for (String str3 : new C1242(r6).m16604()) {
                            m16436(context, this.f15536.mo16121(str3));
                        }
                    }
                } catch (IOException e2) {
                }
                this.f15536.mo16117(r6.getAbsolutePath());
                this.f15534.add(str);
                m16440("%s (%s) was re-linked!", str, str2);
            }
        } else {
            m16440("%s already loaded previously!", str);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˎ  reason: contains not printable characters */
    public File m16435(Context context) {
        return context.getDir("lib", 0);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ˋ  reason: contains not printable characters */
    public File m16434(Context context, String str, String str2) {
        String r4 = this.f15536.mo16118(str);
        if (C1190.m16452(str2)) {
            return new File(m16435(context), r4);
        }
        return new File(m16435(context), r4 + "." + str2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱ  reason: contains not printable characters */
    public void m16439(Context context, String str, String str2) {
        File r2 = m16435(context);
        File r3 = m16434(context, str, str2);
        final String r4 = this.f15536.mo16118(str);
        File[] listFiles = r2.listFiles(new FilenameFilter() { // from class: o.ﺒ.1
            @Override // java.io.FilenameFilter
            public boolean accept(File file, String str3) {
                return str3.startsWith(r4);
            }
        });
        if (listFiles != null) {
            for (File file : listFiles) {
                if (this.f15535 || !file.getAbsolutePath().equals(r3.getAbsolutePath())) {
                    file.delete();
                }
            }
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m16440(String str, Object... objArr) {
        m16438(String.format(Locale.US, str, objArr));
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m16438(String str) {
        if (this.f15531 != null) {
            this.f15531.m16122(str);
        }
    }
}
