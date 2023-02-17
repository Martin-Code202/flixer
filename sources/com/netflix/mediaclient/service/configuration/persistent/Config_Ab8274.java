package com.netflix.mediaclient.service.configuration.persistent;

import android.content.Context;
import com.netflix.mediaclient.service.webclient.model.leafs.ABTestConfig;
import o.AbstractC1067;
import o.C1272;
public class Config_Ab8274 extends AbstractC1067 {

    public enum ListType {
        NONE,
        POPULAR,
        TRENDING,
        SEARCH_HISTORY,
        BROWSE_HISTORY
    }

    @Override // o.AbstractC1067
    /* renamed from: ˏ  reason: contains not printable characters */
    public String mo511() {
        return "8274";
    }

    @Override // o.AbstractC1067
    /* renamed from: ˎ  reason: contains not printable characters */
    public String mo510() {
        return "persistent_ab8274";
    }

    @Override // o.AbstractC1067
    /* renamed from: ˊ  reason: contains not printable characters */
    public boolean mo509() {
        return true;
    }

    public static boolean a_(Context context) {
        return (context == null || C1272.m16797(Config_Ab8274.class, context) == ABTestConfig.Cell.CELL_1 || C1272.m16797(Config_Ab8274.class, context) == ABTestConfig.Cell.CELL_2) ? false : true;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static boolean m505(Context context) {
        switch (C1272.m16797(Config_Ab8274.class, context)) {
            case CELL_1:
            case CELL_2:
            case CELL_5:
            case CELL_6:
                return true;
            case CELL_3:
            case CELL_4:
            default:
                return false;
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static ListType m504(Context context) {
        switch (C1272.m16797(Config_Ab8274.class, context)) {
            case CELL_3:
            case CELL_4:
            case CELL_6:
            case CELL_7:
                return ListType.POPULAR;
            case CELL_5:
                return ListType.SEARCH_HISTORY;
            case CELL_8:
                return ListType.TRENDING;
            default:
                return ListType.NONE;
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static boolean m506(Context context) {
        switch (C1272.m16797(Config_Ab8274.class, context)) {
            case CELL_3:
            case CELL_7:
            case CELL_8:
                return true;
            default:
                return false;
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static boolean m507(Context context) {
        switch (C1272.m16797(Config_Ab8274.class, context)) {
            case CELL_7:
                return true;
            default:
                return false;
        }
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    public static boolean m508(Context context) {
        switch (C1272.m16797(Config_Ab8274.class, context)) {
            case CELL_3:
            case CELL_4:
            case CELL_5:
            case CELL_7:
            case CELL_8:
                return true;
            case CELL_6:
            default:
                return false;
        }
    }
}
