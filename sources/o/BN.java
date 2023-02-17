package o;

import java.io.File;
import o.BP;
public class BN implements BP.If {

    /* renamed from: ˋ  reason: contains not printable characters */
    private final String f4593;

    /* renamed from: ˎ  reason: contains not printable characters */
    private String f4594;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final long f4595;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final long f4596;

    BN(String str, File file) {
        this.f4593 = file.getName();
        this.f4595 = file.lastModified();
        this.f4596 = file.length();
        this.f4594 = str;
    }

    @Override // o.BP.If
    /* renamed from: ˋ  reason: contains not printable characters */
    public String mo3882() {
        return this.f4593;
    }

    @Override // o.BP.If
    /* renamed from: ˎ  reason: contains not printable characters */
    public long mo3883() {
        return this.f4595;
    }

    @Override // o.BP.If
    /* renamed from: ॱ  reason: contains not printable characters */
    public long mo3884() {
        return this.f4596;
    }

    @Override // o.BP.If
    /* renamed from: ˊ  reason: contains not printable characters */
    public String mo3881() {
        return this.f4594;
    }

    public String toString() {
        return "FileSystemEntryImpl{mFileName='" + this.f4593 + "', mTs=" + this.f4595 + ", mSizeInBytes=" + this.f4596 + ", mProfileId='" + this.f4594 + "'}";
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    static String m3879(String str, String str2) {
        if (str2 != null) {
            return str2;
        }
        int length = str.length() / 2;
        return (String.valueOf(str.substring(0, length).hashCode()) + String.valueOf(str.substring(length).hashCode())) + "_trailers";
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    static String m3880(File file, File file2) {
        File parentFile = file2.getParentFile();
        if (parentFile == null || file.getName().equals(parentFile.getName())) {
            return null;
        }
        String name = parentFile.getName();
        if (C1349Bv.m4107(name)) {
            return C1324Ax.m3821(name);
        }
        return null;
    }
}
