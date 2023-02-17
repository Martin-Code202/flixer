package com.netflix.mediaclient.service.pservice;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import o.C1281;
import o.C1283;
import o.C1349Bv;
import o.mZ;
public class PDiskData {
    public static final Boolean ENABLE_VERBOSE_LOGGING = false;
    public static final String PARTNER_EXP_DEFAULT = "default";
    public static final String REPOSITORY_DIR = "preAppData";
    public static final String REPOSITORY_FILE_NAME = "preAppDiskDataFile";
    private static final String TAG = "nf_preapp_diskdata";
    public static final String WIDGET_EXP_DEFAULT = "default";
    @SerializedName("billboardList")
    public List<mZ> billboardList;
    @SerializedName("cwList")
    public List<mZ> cwList;
    @SerializedName("iqList")
    public List<mZ> iqList;
    @SerializedName("listInfo")
    public Map<String, String> lomoMap;
    @SerializedName("nonMemberList")
    public List<mZ> nonMemberList;
    @SerializedName("preAppPartnerExperience")
    public String preAppPartnerExperience;
    @SerializedName("preAppWidgetExperience")
    public String preAppWidgetExperience;
    @SerializedName("standardFirstList")
    public List<mZ> standardFirstList;
    @SerializedName("standardSecondList")
    public List<mZ> standardSecondList;
    @SerializedName("urlMap")
    public Map<String, String> urlMap;

    public PDiskData() {
        this.urlMap = new HashMap();
        this.lomoMap = new HashMap();
        this.billboardList = new ArrayList();
        this.cwList = new ArrayList();
        this.iqList = new ArrayList();
        this.standardFirstList = new ArrayList();
        this.standardSecondList = new ArrayList();
        this.nonMemberList = new ArrayList();
        this.preAppPartnerExperience = "default";
        this.preAppWidgetExperience = "default";
    }

    public PDiskData(PDiskData pDiskData) {
        this.preAppPartnerExperience = pDiskData.preAppPartnerExperience;
        this.preAppWidgetExperience = pDiskData.preAppWidgetExperience;
        this.urlMap = pDiskData.urlMap;
        this.billboardList = pDiskData.billboardList;
        this.cwList = pDiskData.cwList;
        this.iqList = pDiskData.iqList;
        this.nonMemberList = pDiskData.nonMemberList;
        this.standardFirstList = pDiskData.standardFirstList;
        this.standardSecondList = pDiskData.standardSecondList;
        this.lomoMap = pDiskData.lomoMap;
    }

    public String toJsonString() {
        return ((Gson) C1281.m16832(Gson.class)).toJson(this);
    }

    public static PDiskData fromJsonString(String str) {
        if (!C1349Bv.m4113(str)) {
            return (PDiskData) ((Gson) C1281.m16832(Gson.class)).fromJson(str, (Class<Object>) PDiskData.class);
        }
        C1283.m16865(TAG, "fromJsonString diskData is empty, retuning empty object");
        return new PDiskData();
    }

    public List<mZ> getVideoListByName(ListType listType) {
        switch (listType) {
            case BILLBOARD:
                return this.billboardList;
            case CW:
                return this.cwList;
            case IQ:
                return this.iqList;
            case STANDARD_FIRST:
                return this.standardFirstList;
            case STANDARD_SECOND:
                return this.standardSecondList;
            case NON_MEMBER:
                return this.nonMemberList;
            default:
                return null;
        }
    }

    public enum ImageType {
        HORIZONTAL_ART("horizontalArt"),
        TRICKPLAY("trickplay"),
        TITLE_CARD("titleCard"),
        UNKNOWN("");
        

        /* renamed from: ˎ  reason: contains not printable characters */
        private String f2116;

        private ImageType(String str) {
            this.f2116 = str;
        }
    }

    public enum ListType {
        BILLBOARD("Spotlight"),
        CW("ContinueWatching"),
        IQ("MyList"),
        STANDARD_FIRST("arFirst"),
        STANDARD_SECOND("arSecond"),
        NON_MEMBER("nonMember"),
        LOMO_INFO("lomoInfo"),
        UNKNOWN("");
        

        /* renamed from: ʽ  reason: contains not printable characters */
        private String f2126;

        private ListType(String str) {
            this.f2126 = str;
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        public String m1188() {
            return this.f2126;
        }
    }

    public static boolean isMemberDataAvailable(PDiskData pDiskData) {
        if (pDiskData == null) {
            return false;
        }
        return isListNotEmpty(pDiskData.billboardList) || isListNotEmpty(pDiskData.cwList) || isListNotEmpty(pDiskData.iqList) || isListNotEmpty(pDiskData.standardFirstList) || isListNotEmpty(pDiskData.standardSecondList);
    }

    public static boolean isNonMemberDataAvailable(PDiskData pDiskData) {
        return isListNotEmpty(pDiskData.nonMemberList);
    }

    public static boolean isListEmpty(List<mZ> list) {
        return list == null || list.size() <= 0;
    }

    public static boolean isListNotEmpty(List<mZ> list) {
        return !isListEmpty(list);
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x00b5: APUT  
      (r2v15 java.lang.Object[])
      (0 ??[int, short, byte, char])
      (wrap: java.lang.Integer : 0x00b0: INVOKE  (r3v15 java.lang.Integer) = (r3v14 int) type: STATIC call: java.lang.Integer.valueOf(int):java.lang.Integer)
     */
    public void print() {
        C1283.m16854(TAG, String.format("lomo: %s", this.lomoMap));
        C1283.m16854(TAG, String.format("nm: %s", printList(this.nonMemberList)));
        C1283.m16854(TAG, String.format("bb: %s", printList(this.billboardList)));
        C1283.m16854(TAG, String.format("cw: %s", printList(this.cwList)));
        C1283.m16854(TAG, String.format("iq: %s", printList(this.iqList)));
        C1283.m16854(TAG, String.format("s1: %s", printList(this.standardFirstList)));
        C1283.m16854(TAG, String.format("s2: %s", printList(this.standardSecondList)));
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(this.urlMap != null ? this.urlMap.size() : 0);
        C1283.m16854(TAG, String.format("urlMap count %d", objArr));
        if (ENABLE_VERBOSE_LOGGING.booleanValue()) {
            C1283.m16845(TAG, String.format("urlMap: %s", this.urlMap));
        }
    }

    private String printList(List<mZ> list) {
        if (list == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(list.size());
        Iterator<mZ> it = list.iterator();
        while (it.hasNext()) {
            sb.append(", " + it.next().id);
        }
        return sb.toString();
    }

    public void clearMemberlists() {
        this.lomoMap.clear();
        this.billboardList = null;
        this.cwList = null;
        this.iqList = null;
        this.standardFirstList = null;
        this.standardSecondList = null;
    }
}
