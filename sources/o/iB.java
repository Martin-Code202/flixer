package o;

import android.content.Context;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
public class iB implements oJ {

    /* renamed from: ˋ  reason: contains not printable characters */
    private final Map<String, File> f7500 = new HashMap();

    /* renamed from: ˎ  reason: contains not printable characters */
    private File f7501;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final Context f7502;

    public iB(Context context) {
        this.f7502 = context;
        this.f7501 = this.f7502.getDir("player_cache", 0);
        C1283.m16854("nf_subtitles", "Remove cached data for player started... ");
        AH.m3352(this.f7501);
        this.f7501 = this.f7502.getDir("player_cache", 0);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private String m7409(String str, String str2) {
        if (!C1349Bv.m4113(str) && !C1349Bv.m4113(str2)) {
            return str + "_" + str2;
        }
        C1283.m16850("nf_subtitles", "Bad playable id and or language.");
        return null;
    }

    @Override // o.oJ
    /* renamed from: ॱ  reason: contains not printable characters */
    public String mo7411(String str, String str2) {
        String r2 = m7409(str, str2);
        if (C1349Bv.m4113(str)) {
            C1283.m16850("nf_subtitles", "Playable ID is empty, use temp directory!");
            r2 = String.valueOf(System.currentTimeMillis());
        }
        if (!(this.f7500.get(r2) != null)) {
            File file = new File(this.f7501, r2);
            if (!file.exists()) {
                file.mkdir();
            }
            this.f7500.put(r2, file);
        }
        return r2;
    }

    @Override // o.oJ
    /* renamed from: ॱ  reason: contains not printable characters */
    public String mo7412(String str, String str2, byte[] bArr) {
        boolean r5 = C1349Bv.m4113(str);
        boolean r6 = C1349Bv.m4113(str2);
        boolean z = bArr == null;
        if (r5 || r6 || z) {
            C1283.m16844("nf_subtitles", "Bad arguments! Key empty %b or name empty %b or bytes are null %b!", Boolean.valueOf(r5), Boolean.valueOf(r6), Boolean.valueOf(z));
            return null;
        }
        File file = this.f7500.get(str);
        if (file == null) {
            C1283.m16850("nf_subtitles", "Subtitle cache for " + str + " does not exist!");
            return null;
        }
        File file2 = new File(file, str2);
        try {
            file2.createNewFile();
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
            bufferedOutputStream.write(bArr);
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
        } catch (Throwable th) {
            C1283.m16847("nf_subtitles", "Failed to save file ", th);
            file2 = null;
        }
        if (file2 != null) {
            return file2.getAbsolutePath();
        }
        return null;
    }

    @Override // o.oJ
    /* renamed from: ˋ  reason: contains not printable characters */
    public File mo7410(String str, String str2) {
        if (C1349Bv.m4113(str) || C1349Bv.m4113(str2)) {
            C1283.m16865("nf_subtitles", "Bad arguments: key or name not found");
            return null;
        }
        File file = this.f7500.get(str);
        if (file == null) {
            return null;
        }
        File file2 = new File(file, str2);
        if (file2.exists()) {
            C1283.m16854("nf_subtitles", "File exist");
            return file2;
        }
        C1283.m16850("nf_subtitles", "File does NOT exist!");
        return null;
    }
}
