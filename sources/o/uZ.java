package o;

import android.util.Pair;
public final class uZ {

    /* renamed from: ˋ  reason: contains not printable characters */
    private String f10965;

    /* renamed from: ˏ  reason: contains not printable characters */
    private boolean f10966;

    /* renamed from: ॱ  reason: contains not printable characters */
    private String f10967;

    private uZ(String str, String str2, boolean z) {
        this.f10965 = str;
        this.f10967 = str2;
        this.f10966 = z;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public String m11680() {
        return this.f10965;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public String m11678() {
        return this.f10967;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public boolean m11679() {
        return this.f10966;
    }

    public String toString() {
        return "MdxTarget [TAG=nf_mdx, mUUID=" + this.f10965 + ", friendlyName=" + this.f10967 + ", local=" + this.f10966 + "]";
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static uZ m11676() {
        return new uZ(null, null, true);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static uZ m11677(Pair<String, String> pair) {
        return new uZ((String) pair.first, (String) pair.second, false);
    }
}
