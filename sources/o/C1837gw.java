package o;

import java.security.InvalidParameterException;
import o.BJ;
/* renamed from: o.gw  reason: case insensitive filesystem */
public class C1837gw {

    /* renamed from: ʻ  reason: contains not printable characters */
    private final AbstractC1700eM f7012;

    /* renamed from: ʼ  reason: contains not printable characters */
    private long f7013;

    /* renamed from: ʽ  reason: contains not printable characters */
    private boolean f7014 = true;

    /* renamed from: ˊ  reason: contains not printable characters */
    private int f7015 = -1;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private String f7016;

    /* renamed from: ˋ  reason: contains not printable characters */
    private String f7017;

    /* renamed from: ˋॱ  reason: contains not printable characters */
    private long f7018 = 0;

    /* renamed from: ˎ  reason: contains not printable characters */
    private boolean f7019 = false;

    /* renamed from: ˏ  reason: contains not printable characters */
    private String f7020;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private final String f7021;

    /* renamed from: ͺ  reason: contains not printable characters */
    private String f7022;

    /* renamed from: ॱ  reason: contains not printable characters */
    private int f7023 = -1;

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private String f7024;

    /* renamed from: ॱˋ  reason: contains not printable characters */
    private If f7025 = new If();

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private long f7026 = 0;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private int f7027;

    public C1837gw(AbstractC1700eM eMVar, String str) {
        C1283.m16862("MdxTargetPlayerState", "PlayerStateManager");
        this.f7012 = eMVar;
        this.f7021 = str;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m6752() {
        this.f7020 = null;
        this.f7023 = -1;
        this.f7015 = -1;
        this.f7019 = false;
        this.f7017 = null;
        this.f7025.m6760(null, null, -1);
        this.f7014 = true;
        this.f7026 = 0;
        this.f7024 = null;
        this.f7022 = null;
        this.f7018 = 0;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m6757(C1820gf gfVar) {
        if (null != gfVar) {
            String r7 = gfVar.m6658();
            if (!C1349Bv.m4113(r7)) {
                boolean z = this.f7019;
                C1283.m16851("MdxTargetPlayerState", "TargetContext: changeState %s", gfVar.m6658());
                m6748(this.f7021, gfVar);
                if ("PLAYING".equals(r7) && !"PAUSE".equals(this.f7020) && !"prepause".equals(this.f7020) && !"preseek".equals(this.f7020) && !"PLAYING".equals(this.f7020)) {
                    m6747(this.f7021);
                } else if ("STOP".equals(r7) || "END_PLAYBACK".equals(r7) || "FATAL_ERROR".equals(r7)) {
                    m6749(this.f7021, this.f7024);
                }
                if ("PLAYING".equals(r7) && !r7.equals(this.f7020)) {
                    this.f7012.mo6055(this.f7021, false, false, this.f7019, this.f7017, this.f7024);
                } else if ("PAUSE".equals(r7) && !r7.equals(this.f7020)) {
                    this.f7012.mo6055(this.f7021, true, false, this.f7019, this.f7017, this.f7024);
                } else if (z != this.f7019) {
                    this.f7012.mo6055(this.f7021, "PAUSE".equals(r7), false, this.f7019, this.f7017, this.f7024);
                }
                if ("PLAY".equals(r7)) {
                    this.f7012.mo6069(this.f7021, "preplay", this.f7023, this.f7015, this.f7019, this.f7017);
                }
                if ("PROGRESS".equals(r7) || "PLAY".equals(r7)) {
                    this.f7014 = true;
                    this.f7026 = System.currentTimeMillis();
                } else if (this.f7014) {
                    this.f7020 = r7;
                    m6746(this.f7021);
                }
                C1283.m16851("MdxTargetPlayerState", "TargetContext: PlayerStateManager state changed to %s", this.f7020);
            }
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m6756(C1820gf gfVar) {
        if (null != gfVar) {
            String r7 = gfVar.m6658();
            if (!C1349Bv.m4113(r7)) {
                boolean z = this.f7019;
                C1283.m16851("MdxTargetPlayerState", "TargetContext: updateState %s", gfVar.m6658());
                m6748(this.f7021, gfVar);
                if (!(System.currentTimeMillis() - this.f7026 >= 30000)) {
                    boolean z2 = "PLAYING".equals(r7) && this.f7014;
                    if ("preplay".equals(this.f7020) && !z2) {
                        C1283.m16854("MdxTargetPlayerState", "TargetContext: updateState, still in preplay");
                        return;
                    } else if ("prepause".equals(this.f7020) && "PAUSE".equals(r7)) {
                        C1283.m16854("MdxTargetPlayerState", "TargetContext: updateState, still in prepause");
                        return;
                    } else if ("preseek".equals(this.f7020) && !z2) {
                        C1283.m16854("MdxTargetPlayerState", "TargetContext: updateState, still in preseek");
                        return;
                    }
                }
                if ("PLAYING".equals(r7) && !r7.equals(this.f7020)) {
                    m6747(this.f7021);
                    this.f7012.mo6055(this.f7021, false, false, this.f7019, this.f7017, this.f7024);
                } else if ("PAUSE".equals(r7) && !r7.equals(this.f7020)) {
                    m6747(this.f7021);
                    this.f7012.mo6055(this.f7021, true, false, this.f7019, this.f7017, this.f7024);
                } else if (z != this.f7019) {
                    this.f7012.mo6055(this.f7021, "PAUSE".equals(r7), false, this.f7019, this.f7017, this.f7024);
                }
                this.f7020 = r7;
                m6746(this.f7021);
            }
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m6753(AbstractC1744fD fDVar) {
        String r7 = fDVar.m6349();
        if ("PLAYER_PLAY".equals(r7)) {
            this.f7014 = false;
            this.f7026 = System.currentTimeMillis();
            this.f7020 = "preplay";
            this.f7023 = -1;
            this.f7015 = -1;
            this.f7025.m6760(null, null, -1);
            this.f7012.mo6055(this.f7021, false, true, this.f7019, this.f7017, null);
        } else if ("PLAYER_RESUME".equals(r7)) {
            this.f7026 = System.currentTimeMillis();
            this.f7014 = false;
            this.f7020 = "preplay";
            this.f7012.mo6055(this.f7021, false, true, this.f7019, this.f7017, null);
        } else if ("PLAYER_PAUSE".endsWith(r7)) {
            this.f7026 = System.currentTimeMillis();
            this.f7014 = true;
            this.f7020 = "prepause";
            this.f7012.mo6055(this.f7021, true, true, this.f7019, this.f7017, null);
        } else if ("PLAYER_SKIP".equals(r7) || "PLAYER_SET_CURRENT_TIME".equals(r7)) {
            this.f7026 = System.currentTimeMillis();
            this.f7014 = false;
            this.f7020 = "preseek";
            this.f7012.mo6055(this.f7021, false, true, this.f7019, this.f7017, null);
        } else if ("PLAYER_GET_CURRENT_STATE".equals(r7)) {
            this.f7012.mo6069(this.f7021, this.f7020, this.f7023, this.f7015, this.f7019, this.f7017);
            this.f7012.mo6065(this.f7021, this.f7025.m6759(), this.f7025.m6759(), this.f7025.m6762());
        } else if ("PLAYER_SET_VOLUME".equals(r7)) {
            this.f7027 = ((C1758fR) fDVar).m6356();
            this.f7013 = System.currentTimeMillis();
            return;
        } else {
            return;
        }
        this.f7012.mo6069(this.f7021, this.f7020, this.f7023, this.f7015, this.f7019, this.f7017);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public BJ.C0067 m6754() {
        return this.f7025.m6761();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m6748(String str, C1820gf gfVar) {
        this.f7016 = gfVar.m6657();
        String r6 = gfVar.m6659();
        if (C1349Bv.m4107(r6) && !r6.equals(this.f7024)) {
            this.f7012.mo6072(str, r6);
        }
        this.f7024 = r6;
        this.f7019 = gfVar.m6652();
        this.f7017 = gfVar.m6651();
        this.f7023 = gfVar.m6655();
        if (System.currentTimeMillis() > this.f7013 + 3000) {
            this.f7015 = gfVar.m6653();
        } else {
            this.f7015 = this.f7027;
            C1283.m16854("MdxTargetPlayerState", "TargetContext: PlayerStateManager overide volume");
        }
        C1283.m16851("MdxTargetPlayerState", "TargetContext: processStateAndNotifyPostPlayIfNeeded %s", gfVar);
        if ("END_PLAYBACK".equals(gfVar.m6658())) {
            this.f7025.m6760(null, null, -1);
        } else if (!C1349Bv.m4126(this.f7025.m6759(), gfVar.m6656()) || !C1349Bv.m4126(this.f7025.m6763(), gfVar.m6654()) || this.f7025.m6762() != gfVar.m6660()) {
            this.f7025.m6760(gfVar.m6656(), gfVar.m6654(), gfVar.m6660());
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m6746(String str) {
        C1283.m16851("MdxTargetPlayerState", "TargetContext: PlayerStateManager notify state %s, volume = %d, , time = %d, skipIntroWindow = %b.", this.f7020, Integer.valueOf(this.f7015), Integer.valueOf(this.f7023), Boolean.valueOf(this.f7019));
        if (!"END_PLAYBACK".equals(this.f7020) && !"FATAL_ERROR".equals(this.f7020)) {
            this.f7012.mo6065(str, this.f7025.m6759(), this.f7025.m6763(), this.f7025.m6762());
        }
        this.f7012.mo6069(str, this.f7020, this.f7023, this.f7015, this.f7019, this.f7017);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m6747(String str) {
        C1283.m16854("MdxTargetPlayerState", "TargetContext: playbackStart");
        m6745();
        this.f7012.mo6056(str);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private void m6749(String str, String str2) {
        C1283.m16854("MdxTargetPlayerState", "TargetContext: playbackEnd");
        this.f7025.m6760(null, null, -1);
        this.f7012.mo6070(str, str2, false);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public String m6751() {
        return this.f7016;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m6755(String str) {
        this.f7022 = str;
        this.f7018 = System.currentTimeMillis();
        this.f7012.mo6054(this.f7021, this.f7022);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public boolean m6758() {
        if (C1349Bv.m4107(this.f7022)) {
            this.f7012.mo6054(this.f7021, this.f7022);
            if (System.currentTimeMillis() - this.f7018 < 2000) {
                return true;
            }
        }
        this.f7018 = System.currentTimeMillis();
        return false;
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    private void m6745() {
        this.f7022 = null;
        this.f7018 = 0;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public boolean m6750() {
        synchronized (this) {
            if (!C1349Bv.m4107(this.f7020) || "STOP".equals(this.f7020) || "FATAL_ERROR".equals(this.f7020) || "END_PLAYBACK".equals(this.f7020)) {
                return false;
            }
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.gw$If */
    public static class If {

        /* renamed from: ˊ  reason: contains not printable characters */
        private String f7028;

        /* renamed from: ˎ  reason: contains not printable characters */
        private int f7029;

        /* renamed from: ॱ  reason: contains not printable characters */
        private String f7030;

        private If() {
            this.f7029 = -1;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: ˊ  reason: contains not printable characters */
        public synchronized void m6760(String str, String str2, int i) {
            this.f7030 = str;
            this.f7028 = str2;
            this.f7029 = i;
            C1283.m16851("MdxTargetPlayerState", "reset VideoInfo %s, %s, %d", this.f7030, this.f7028, Integer.valueOf(this.f7029));
        }

        /* access modifiers changed from: package-private */
        /* renamed from: ˊ  reason: contains not printable characters */
        public String m6759() {
            return this.f7030;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: ˏ  reason: contains not printable characters */
        public String m6763() {
            return this.f7028;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: ˎ  reason: contains not printable characters */
        public int m6762() {
            return this.f7029;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: ˋ  reason: contains not printable characters */
        public synchronized BJ.C0067 m6761() {
            BJ.C0067 r5;
            C1283.m16851("MdxTargetPlayerState", "getVideoIds %s, %s", this.f7030, this.f7028);
            r5 = null;
            try {
                r5 = BJ.m3866(this.f7030, this.f7028);
            } catch (InvalidParameterException e) {
                C1283.m16865("MdxTargetPlayerState", "getVideoIds has exception.");
            }
            return r5;
        }
    }
}
