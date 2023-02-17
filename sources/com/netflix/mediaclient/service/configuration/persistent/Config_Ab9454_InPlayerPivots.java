package com.netflix.mediaclient.service.configuration.persistent;

import com.netflix.mediaclient.service.webclient.model.leafs.ABTestConfig;
import o.AD;
import o.AbstractC1067;
import o.C0884;
import o.C1272;
import o.C1456Fq;
import o.C1457Fr;
public final class Config_Ab9454_InPlayerPivots extends AbstractC1067 {

    /* renamed from: ˏ  reason: contains not printable characters */
    public static final Companion f1097 = new Companion(null);

    /* renamed from: ʻ  reason: contains not printable characters */
    public static final boolean m512() {
        return f1097.m542();
    }

    /* renamed from: ʻॱ  reason: contains not printable characters */
    public static final boolean m513() {
        return f1097.m533();
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public static final boolean m514() {
        return f1097.m530();
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public static final boolean m515() {
        return f1097.m544();
    }

    /* renamed from: ˊॱ  reason: contains not printable characters */
    public static final boolean m516() {
        return f1097.m541();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static final boolean m517() {
        return f1097.m540();
    }

    /* renamed from: ˋॱ  reason: contains not printable characters */
    public static final boolean m518() {
        return f1097.m538();
    }

    /* renamed from: ˏॱ  reason: contains not printable characters */
    public static final boolean m519() {
        return f1097.m528();
    }

    /* renamed from: ͺ  reason: contains not printable characters */
    public static final boolean m520() {
        return f1097.m535();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static final boolean m521() {
        return f1097.m532();
    }

    /* renamed from: ॱˊ  reason: contains not printable characters */
    public static final boolean m522() {
        return f1097.m539();
    }

    /* renamed from: ॱˎ  reason: contains not printable characters */
    public static final boolean m523() {
        return f1097.m545();
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public static final boolean m524() {
        return f1097.m531();
    }

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    public static final boolean m525() {
        return f1097.m543();
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    public static final boolean m526() {
        return f1097.m536();
    }

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    public static final boolean m527() {
        return f1097.m529();
    }

    @Override // o.AbstractC1067
    /* renamed from: ˎ */
    public String mo510() {
        return "persistent_9454";
    }

    @Override // o.AbstractC1067
    /* renamed from: ˏ */
    public String mo511() {
        return "9454";
    }

    public static final class Companion {

        public enum InitialDisplayExperience {
            UP_NEXT_BUTTON,
            EXPANDED,
            COLLAPSED
        }

        public enum RowType {
            CONTINUE_WATCHING,
            SIMILARS,
            EMPTY
        }

        private Companion() {
        }

        public /* synthetic */ Companion(C1456Fq fq) {
            this();
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        public final boolean m540() {
            return (C1457Fr.m5018(C1272.m16803(Config_Ab9454_InPlayerPivots.class), ABTestConfig.Cell.CELL_1) ^ true) && !AD.m3287();
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        public final RowType m537() {
            ABTestConfig.Cell r1 = C1272.m16803(Config_Ab9454_InPlayerPivots.class);
            if (r1 != null) {
                switch (C0884.f14762[r1.ordinal()]) {
                    case 1:
                        return RowType.CONTINUE_WATCHING;
                    case 2:
                        return RowType.CONTINUE_WATCHING;
                    case 3:
                        return RowType.CONTINUE_WATCHING;
                    case 4:
                        return RowType.SIMILARS;
                    case 5:
                        return RowType.SIMILARS;
                    case 6:
                        return RowType.SIMILARS;
                    case 7:
                        return RowType.CONTINUE_WATCHING;
                }
            }
            return RowType.EMPTY;
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        public final InitialDisplayExperience m534() {
            ABTestConfig.Cell r1 = C1272.m16803(Config_Ab9454_InPlayerPivots.class);
            if (r1 != null) {
                switch (C0884.f14763[r1.ordinal()]) {
                    case 1:
                        return InitialDisplayExperience.UP_NEXT_BUTTON;
                    case 2:
                        return InitialDisplayExperience.EXPANDED;
                    case 3:
                        return InitialDisplayExperience.COLLAPSED;
                    case 4:
                        return InitialDisplayExperience.UP_NEXT_BUTTON;
                    case 5:
                        return InitialDisplayExperience.UP_NEXT_BUTTON;
                    case 6:
                        return InitialDisplayExperience.UP_NEXT_BUTTON;
                }
            }
            return InitialDisplayExperience.UP_NEXT_BUTTON;
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public final boolean m532() {
            ABTestConfig.Cell r1 = C1272.m16803(Config_Ab9454_InPlayerPivots.class);
            if (r1 != null) {
                switch (C0884.f14764[r1.ordinal()]) {
                    case 1:
                        return false;
                }
            }
            return m540();
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        public final boolean m536() {
            return m540();
        }

        /* renamed from: ʼ  reason: contains not printable characters */
        public final boolean m530() {
            return m540();
        }

        /* renamed from: ʽ  reason: contains not printable characters */
        public final boolean m531() {
            return m540();
        }

        /* renamed from: ॱॱ  reason: contains not printable characters */
        public final boolean m542() {
            return m540() && m545();
        }

        /* renamed from: ᐝ  reason: contains not printable characters */
        public final boolean m544() {
            return false;
        }

        /* renamed from: ʻ  reason: contains not printable characters */
        public final boolean m528() {
            return false;
        }

        /* renamed from: ॱˊ  reason: contains not printable characters */
        public final boolean m541() {
            return false;
        }

        /* renamed from: ͺ  reason: contains not printable characters */
        public final boolean m539() {
            return false;
        }

        /* renamed from: ˋॱ  reason: contains not printable characters */
        public final boolean m535() {
            return true;
        }

        /* renamed from: ˏॱ  reason: contains not printable characters */
        public final boolean m538() {
            return m540();
        }

        /* renamed from: ˊॱ  reason: contains not printable characters */
        public final boolean m533() {
            return m540();
        }

        /* renamed from: ॱᐝ  reason: contains not printable characters */
        public final boolean m543() {
            return m540();
        }

        /* renamed from: ᐝॱ  reason: contains not printable characters */
        public final boolean m545() {
            return false;
        }

        /* renamed from: ʻॱ  reason: contains not printable characters */
        public final boolean m529() {
            return false;
        }
    }
}
