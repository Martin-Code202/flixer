package o;

import com.netflix.mediaclient.service.player.subtitles.text.CharacterEdgeTypeMapping;
import com.netflix.mediaclient.service.player.subtitles.text.ColorMapping;
public final class mO {

    /* renamed from: ˊ  reason: contains not printable characters */
    private static Integer f8731 = 0;

    /* renamed from: ˋ  reason: contains not printable characters */
    private static Integer f8732 = 1;

    /* renamed from: ˏ  reason: contains not printable characters */
    private static String f8733 = "000000";

    /* renamed from: ʼ  reason: contains not printable characters */
    private Integer f8734;

    /* renamed from: ʽ  reason: contains not printable characters */
    private Integer f8735;

    /* renamed from: ˎ  reason: contains not printable characters */
    private String f8736;

    /* renamed from: ॱ  reason: contains not printable characters */
    private CharacterEdgeTypeMapping f8737 = CharacterEdgeTypeMapping.NONE;

    private mO() {
    }

    public mO(CharacterEdgeTypeMapping characterEdgeTypeMapping, String str, Integer num, Integer num2) {
        this.f8737 = characterEdgeTypeMapping;
        this.f8736 = str;
        this.f8735 = num;
        this.f8734 = num2;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    static mO m8852(String str) {
        if (C1349Bv.m4113(str)) {
            return null;
        }
        mO mOVar = new mO();
        if (CharacterEdgeTypeMapping.NONE.m1156().equalsIgnoreCase(str)) {
            mOVar.f8737 = CharacterEdgeTypeMapping.NONE;
            return mOVar;
        }
        String[] r3 = C1349Bv.m4118(str, " ");
        int i = 0;
        if (C1349Bv.m4125(str)) {
            if (r3.length < 1) {
                return null;
            }
        } else if (r3.length < 2) {
            return null;
        } else {
            i = 1;
            mOVar.f8736 = ColorMapping.m1159(r3[0]);
        }
        mOVar.f8735 = C1334Bg.m4020(r3[i]);
        int i2 = i + 1;
        if (i2 < r3.length) {
            mOVar.f8734 = C1334Bg.m4020(r3[i2]);
        }
        if (mOVar.f8734 != null) {
            mOVar.f8737 = CharacterEdgeTypeMapping.DROP_SHADOW;
        } else {
            mOVar.f8737 = CharacterEdgeTypeMapping.UNIFORM;
        }
        return mOVar;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m8859(CharacterEdgeTypeMapping characterEdgeTypeMapping) {
        this.f8737 = characterEdgeTypeMapping;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public String m8855() {
        return this.f8736;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m8857(String str) {
        this.f8736 = str;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public Integer m8854() {
        return this.f8735;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public boolean m8860() {
        return CharacterEdgeTypeMapping.UNIFORM.equals(this.f8737);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public boolean m8858() {
        return !CharacterEdgeTypeMapping.NONE.equals(this.f8737) && this.f8737 != null;
    }

    public String toString() {
        return "Outline [mEdgeType=" + this.f8737 + ", mEdgeColor=" + this.f8736 + ", mOutlineWidth=" + this.f8735 + ", mOutlineBlur=" + this.f8734 + "]";
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public C0148 m8856() {
        if (this.f8737 == null) {
            return null;
        }
        return this.f8737.m1157();
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    public static mO m8853() {
        return new mO(CharacterEdgeTypeMapping.UNIFORM, f8733, f8732, f8731);
    }

    /* renamed from: o.mO$ˋ  reason: contains not printable characters */
    public static class C0148 {

        /* renamed from: ˋ  reason: contains not printable characters */
        public static final C0148 f8738 = new C0148(1.0f, 2, 2);

        /* renamed from: ˎ  reason: contains not printable characters */
        public static final C0148 f8739 = new C0148(1.0f, 0, -2);

        /* renamed from: ˏ  reason: contains not printable characters */
        public static final C0148 f8740 = new C0148(0.0f, 0, 0);

        /* renamed from: ॱ  reason: contains not printable characters */
        public static final C0148 f8741 = new C0148(1.0f, 0, 2);

        /* renamed from: ʼ  reason: contains not printable characters */
        public final int f8742;

        /* renamed from: ˊ  reason: contains not printable characters */
        public final float f8743;

        /* renamed from: ᐝ  reason: contains not printable characters */
        public final int f8744;

        private C0148(float f, int i, int i2) {
            this.f8743 = f;
            this.f8742 = i;
            this.f8744 = i2;
        }
    }
}
