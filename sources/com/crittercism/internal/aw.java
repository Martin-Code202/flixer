package com.crittercism.internal;

import android.content.Context;
import com.crittercism.internal.av;
import com.crittercism.internal.bf;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
public final class aw<T extends bf> implements av<T> {
    private final a a;
    private b<T> b;
    private int c;
    private final List<av.a> d = new LinkedList();

    public interface b<T extends bf> {
        T a(File file);

        void a(T t, OutputStream outputStream);
    }

    public aw(Context context, String str, b<T> bVar, int i) {
        this.b = bVar;
        this.c = i;
        this.a = new a(context, str);
    }

    private boolean b(T t) {
        File file = new File(this.a.a(), t.f());
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
            try {
                this.b.a(t, bufferedOutputStream);
                try {
                    bufferedOutputStream.close();
                    return true;
                } catch (IOException e) {
                    file.delete();
                    cf.a("Unable to close " + file.getAbsolutePath(), e);
                    return false;
                }
            } catch (Exception e2) {
                file.delete();
                cf.a("Unable to write to " + file.getAbsolutePath(), e2);
                try {
                    bufferedOutputStream.close();
                    return false;
                } catch (IOException e3) {
                    file.delete();
                    cf.a("Unable to close " + file.getAbsolutePath(), e3);
                    return false;
                }
            } catch (Throwable th) {
                try {
                    bufferedOutputStream.close();
                    throw th;
                } catch (IOException e4) {
                    file.delete();
                    cf.a("Unable to close " + file.getAbsolutePath(), e4);
                    return false;
                }
            }
        } catch (FileNotFoundException e5) {
            cf.c("Could not open output stream to : " + file, e5);
            return false;
        }
    }

    private File[] d() {
        File[] e = e();
        Arrays.sort(e);
        return e;
    }

    private File[] e() {
        File[] listFiles = this.a.a().listFiles();
        if (listFiles == null) {
            return new File[0];
        }
        return listFiles;
    }

    @Override // com.crittercism.internal.av
    public final void a(String str) {
        File file = new File(this.a.a(), str);
        if (file.exists()) {
            file.delete();
        }
    }

    @Override // com.crittercism.internal.av
    public final JSONArray a() {
        List<T> b2 = b();
        JSONArray jSONArray = new JSONArray();
        for (T t : b2) {
            jSONArray.put(t.g());
        }
        return jSONArray;
    }

    @Override // com.crittercism.internal.av
    public final List<T> b() {
        ArrayList arrayList = new ArrayList();
        File[] d2 = d();
        for (File file : d2) {
            try {
                arrayList.add(this.b.a(file));
            } catch (ThreadDeath e) {
                throw e;
            } catch (Throwable unused) {
                a(file.getName());
            }
        }
        return arrayList;
    }

    @Override // com.crittercism.internal.av
    public final List<T> c() {
        return b();
    }

    @Override // com.crittercism.internal.av
    public final void a(List<T> list) {
        for (T t : list) {
            a(t.f());
        }
    }

    @Override // com.crittercism.internal.av
    public final void a(av.a aVar) {
        if (aVar != null) {
            synchronized (this.d) {
                this.d.add(aVar);
            }
        }
    }

    public static File a(Context context, String str) {
        return new File(context.getFilesDir() + "/com.crittercism/" + str);
    }

    /* access modifiers changed from: package-private */
    public static class a {
        private Context a;
        private String b;
        private File c;

        public a(Context context, String str) {
            this.a = context;
            this.b = str;
        }

        public final File a() {
            if (this.c != null) {
                return this.c;
            }
            this.c = aw.a(this.a, this.b);
            if (!this.c.isDirectory()) {
                this.c.mkdirs();
            }
            return this.c;
        }
    }

    @Override // com.crittercism.internal.av
    public final boolean a(T t) {
        if (e().length >= this.c) {
            File[] d2 = d();
            int length = (this.c - d2.length) + 1;
            int i = 0;
            int i2 = 0;
            while (i2 < length && i2 < d2.length) {
                if (d2[i2].delete()) {
                    i++;
                }
                i2++;
            }
            if (!(i == length)) {
                return false;
            }
        }
        boolean b2 = b(t);
        synchronized (this.d) {
            for (av.a aVar : this.d) {
                aVar.a();
            }
        }
        return b2;
    }
}
