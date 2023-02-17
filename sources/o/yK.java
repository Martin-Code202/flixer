package o;

import android.annotation.TargetApi;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.widget.RemoteViews;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.service.preapp.PreAppAgentEventType;
import com.netflix.mediaclient.service.pservice.PDiskData;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import com.netflix.mediaclient.ui.preapp.PAppWidgetReceiver;
import com.netflix.mediaclient.ui.preapp.PServiceWidgetProvider;
import java.io.File;
import java.util.LinkedList;
import java.util.List;
import o.mY;
public final class yK {
    /* renamed from: ˏ  reason: contains not printable characters */
    public static void m13188(Context context, PreAppAgentEventType preAppAgentEventType, PDiskData pDiskData) {
        if (pDiskData == null) {
            C1283.m16865("nf_widget_helper", "mDiskData is null - ignoring request");
            return;
        }
        PDiskData.ListType r5 = m13200(preAppAgentEventType, pDiskData);
        int r6 = m13194(context);
        if (!m13170(r5, pDiskData, 0, r6)) {
            C1283.m16851("nf_widget_helper", "list:%s, not enough need:%d - going to next", r5, Integer.valueOf(r6));
            r5 = m13173(context, r5, pDiskData);
        }
        m13189(context, m13202(m13151(r5, pDiskData)), r5, pDiskData);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private static void m13189(Context context, mZ mZVar, PDiskData.ListType listType, PDiskData pDiskData) {
        if (mZVar == null) {
            C1283.m16865("nf_widget_helper", "video == null, unable to notify widget");
            return;
        }
        C1283.m16851("nf_widget_helper", "Sending video to widget. id:%s, type:%s, list:%s", mZVar.id, mZVar.videoType, listType);
        m13153(context, mZVar, listType, pDiskData);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* renamed from: ॱ  reason: contains not printable characters */
    private static PDiskData.ListType m13200(PreAppAgentEventType preAppAgentEventType, PDiskData pDiskData) {
        if (pDiskData == null) {
            return PDiskData.ListType.UNKNOWN;
        }
        if (PDiskData.isMemberDataAvailable(pDiskData)) {
            switch (preAppAgentEventType) {
                case ALL_MEMBER_UPDATED:
                case NON_MEMBER_UPDATED:
                    if (!PDiskData.isListEmpty(pDiskData.billboardList)) {
                        return PDiskData.ListType.BILLBOARD;
                    }
                    if (!PDiskData.isListEmpty(pDiskData.cwList)) {
                        return PDiskData.ListType.CW;
                    }
                    if (!PDiskData.isListEmpty(pDiskData.standardFirstList)) {
                        return PDiskData.ListType.STANDARD_FIRST;
                    }
                    if (!PDiskData.isListEmpty(pDiskData.standardSecondList)) {
                        return PDiskData.ListType.STANDARD_SECOND;
                    }
                    break;
                case CW_UPDATED:
                    return PDiskData.ListType.CW;
                case IQ_UPDATED:
                    return PDiskData.ListType.IQ;
                case ACCOUNT_DEACTIVATED:
                default:
                    return PDiskData.ListType.NON_MEMBER;
            }
        }
        return PDiskData.ListType.NON_MEMBER;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private static PDiskData.ListType m13174(PDiskData.ListType listType, PDiskData pDiskData) {
        switch (listType) {
            case BILLBOARD:
                if (pDiskData.cwList != null && pDiskData.cwList.size() > 0) {
                    return PDiskData.ListType.CW;
                }
                if (pDiskData.iqList != null && pDiskData.iqList.size() > 0) {
                    return PDiskData.ListType.IQ;
                }
                if (pDiskData.standardFirstList != null && pDiskData.standardFirstList.size() > 0) {
                    return PDiskData.ListType.STANDARD_FIRST;
                }
                if (pDiskData.standardSecondList != null && pDiskData.standardSecondList.size() > 0) {
                    return PDiskData.ListType.STANDARD_SECOND;
                }
                break;
            case CW:
                if (pDiskData.iqList != null && pDiskData.iqList.size() > 0) {
                    return PDiskData.ListType.IQ;
                }
                if (pDiskData.standardFirstList != null && pDiskData.standardFirstList.size() > 0) {
                    return PDiskData.ListType.STANDARD_FIRST;
                }
                if (pDiskData.standardSecondList != null && pDiskData.standardSecondList.size() > 0) {
                    return PDiskData.ListType.STANDARD_SECOND;
                }
                if (pDiskData.billboardList != null && pDiskData.billboardList.size() > 0) {
                    return PDiskData.ListType.BILLBOARD;
                }
                break;
            case IQ:
                if (pDiskData.standardFirstList != null && pDiskData.standardFirstList.size() > 0) {
                    return PDiskData.ListType.STANDARD_FIRST;
                }
                if (pDiskData.standardSecondList != null && pDiskData.standardSecondList.size() > 0) {
                    return PDiskData.ListType.STANDARD_SECOND;
                }
                if (pDiskData.billboardList != null && pDiskData.billboardList.size() > 0) {
                    return PDiskData.ListType.BILLBOARD;
                }
                if (pDiskData.cwList != null && pDiskData.cwList.size() > 0) {
                    return PDiskData.ListType.CW;
                }
                break;
            case STANDARD_FIRST:
                if (pDiskData.standardSecondList != null && pDiskData.standardSecondList.size() > 0) {
                    return PDiskData.ListType.STANDARD_SECOND;
                }
                if (pDiskData.billboardList != null && pDiskData.billboardList.size() > 0) {
                    return PDiskData.ListType.BILLBOARD;
                }
                if (pDiskData.cwList != null && pDiskData.cwList.size() > 0) {
                    return PDiskData.ListType.CW;
                }
                if (pDiskData.iqList != null && pDiskData.iqList.size() > 0) {
                    return PDiskData.ListType.IQ;
                }
                break;
            case STANDARD_SECOND:
                if (pDiskData.billboardList != null && pDiskData.billboardList.size() > 0) {
                    return PDiskData.ListType.BILLBOARD;
                }
                if (pDiskData.cwList != null && pDiskData.cwList.size() > 0) {
                    return PDiskData.ListType.CW;
                }
                if (pDiskData.iqList != null && pDiskData.iqList.size() > 0) {
                    return PDiskData.ListType.IQ;
                }
                if (pDiskData.standardFirstList != null && pDiskData.standardFirstList.size() > 0) {
                    return PDiskData.ListType.STANDARD_FIRST;
                }
                break;
            case NON_MEMBER:
                return PDiskData.ListType.NON_MEMBER;
        }
        return listType;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private static List<mZ> m13151(PDiskData.ListType listType, PDiskData pDiskData) {
        if (pDiskData == null || listType == null) {
            C1283.m16865("nf_widget_helper", "diskData is null - ignoring request");
            return null;
        }
        switch (listType) {
            case BILLBOARD:
                return pDiskData.billboardList;
            case CW:
                return pDiskData.cwList;
            case IQ:
                return pDiskData.iqList;
            case STANDARD_FIRST:
                return pDiskData.standardFirstList;
            case STANDARD_SECOND:
                return pDiskData.standardSecondList;
            case NON_MEMBER:
                return pDiskData.nonMemberList;
            default:
                return null;
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private static mZ m13202(List<mZ> list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        return list.get(0);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private static mZ m13185(Context context, PDiskData.ListType listType, mZ mZVar, PDiskData pDiskData) {
        if (pDiskData == null) {
            C1283.m16865("nf_widget_helper", "diskData is null - ignoring request");
            return null;
        }
        List<mZ> r5 = m13151(listType, pDiskData);
        if (r5 == null || mZVar == null) {
            C1283.m16855("nf_widget_helper", "(getNextVideo) listType: %s or currentVideo %s is null getting first video", listType, mZVar);
            PDiskData.ListType r10 = m13200(PreAppAgentEventType.ALL_MEMBER_UPDATED, pDiskData);
            if (!m13205(context, r10, pDiskData)) {
                C1283.m16851("nf_widget_helper", "list:%s, not enough - going to next", r10);
                r10 = m13173(context, r10, pDiskData);
            }
            return m13202(m13151(r10, pDiskData));
        }
        int indexOf = r5.indexOf(mZVar);
        int r8 = m13195(r5, listType, pDiskData);
        if (indexOf + 1 < r8) {
            return r5.get(indexOf + 1);
        }
        C1283.m16851("nf_widget_helper", "next null - videoId: %s, is last in listType: %s, index: %d, size: %d, upperBound:%d", mZVar.id, listType, Integer.valueOf(indexOf), Integer.valueOf(r5.size()), Integer.valueOf(r8));
        return null;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private static int m13195(List<mZ> list, PDiskData.ListType listType, PDiskData pDiskData) {
        if (list == null) {
            return 0;
        }
        return Math.min(list.size(), C1997na.m9265(listType, pDiskData));
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static mZ m13165(List<mZ> list, mZ mZVar, PDiskData.ListType listType, PDiskData pDiskData) {
        int indexOf = list.indexOf(mZVar) + 1;
        if (indexOf > 0 && indexOf < m13195(list, listType, pDiskData)) {
            return list.get(indexOf);
        }
        C1283.m16865("nf_widget_helper", "getNextVideoInList is null");
        return null;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private static boolean m13190(PDiskData.ListType listType, List<mZ> list, mZ mZVar, PDiskData pDiskData) {
        int indexOf = list.indexOf(mZVar);
        return indexOf >= 0 && indexOf + 1 < Math.min(list.size(), C1997na.m9265(listType, pDiskData));
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private static Bitmap m13196(String str) {
        if (C1349Bv.m4113(str)) {
            return null;
        }
        if (str.contains("file://")) {
            str = str.substring("file://".length() - 1);
        }
        File file = new File(str);
        if (file.exists()) {
            return BitmapFactory.decodeFile(file.getAbsolutePath());
        }
        C1283.m16855("nf_widget_helper", "%s does not exist", str);
        return null;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private static int[] m13192(Context context) {
        AppWidgetManager instance = AppWidgetManager.getInstance(context.getApplicationContext());
        int[] appWidgetIds = instance.getAppWidgetIds(new ComponentName(context.getApplicationContext(), PServiceWidgetProvider.class));
        int[] appWidgetIds2 = instance.getAppWidgetIds(new ComponentName(context.getApplicationContext(), com.netflix.mediaclient.service.pservice.PServiceWidgetProvider.class));
        int[] iArr = new int[(appWidgetIds.length + appWidgetIds2.length)];
        System.arraycopy(appWidgetIds, 0, iArr, 0, appWidgetIds.length);
        System.arraycopy(appWidgetIds2, 0, iArr, appWidgetIds.length, appWidgetIds2.length);
        return iArr;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private static void m13203(Context context, int i) {
        int[] r5 = m13192(context);
        for (int i2 : r5) {
            int r10 = m13209(context, i2);
            C1283.m16851("nf_widget_helper", "(%s), widgetId: %d, layoutId:%d", "static", Integer.valueOf(i2), Integer.valueOf(r10));
            m13166(context, r10, i2, m13161(context, i2, r10, i), i);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private static void m13153(Context context, mZ mZVar, PDiskData.ListType listType, PDiskData pDiskData) {
        int[] r8 = m13192(context);
        for (int i : r8) {
            int r13 = m13209(context, i);
            C1283.m16851("nf_widget_helper", "(%s), widgetId: %d, layoutId:%d", listType, Integer.valueOf(i), Integer.valueOf(r13));
            PDiskData.ImageType r14 = m13198(mZVar, listType, r13, 1);
            String r15 = m13201(pDiskData, mZVar, r14);
            if (C1349Bv.m4113(r15)) {
                C1283.m16844("nf_widget_helper", "pVideo.id %s in list %s, not present on disk - going to nm list", mZVar.id, listType);
                listType = PDiskData.ListType.NON_MEMBER;
                mZVar = m13202(pDiskData.nonMemberList);
                r14 = m13198(mZVar, listType, r13, 1);
                r15 = m13201(pDiskData, mZVar, r14);
            }
            if (C1349Bv.m4113(r15)) {
                C1283.m16850("nf_widget_helper", "cannot refresh, even nm list is bad");
                return;
            }
            LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            linkedList.add(r15);
            linkedList2.add(r14);
            m13186(context, i, m13163(context, mZVar, listType, linkedList, linkedList2, i, r13, pDiskData), mZVar.id, listType, linkedList, linkedList2);
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static void m13166(Context context, int i, int i2, RemoteViews remoteViews, int i3) {
        C1348Bu.m4094();
        int r5 = m13180(context, i, i2);
        for (int i4 = 1; i4 <= r5; i4++) {
            C1283.m16851("nf_widget_helper", "decodeBitmapsAndUpdateForStaticImages imagesToShow: %d, i: %d, startVideoIndex: %d, (i+ start): %d", Integer.valueOf(r5), Integer.valueOf(i4), Integer.valueOf(i3), Integer.valueOf(i4 + i3));
            remoteViews.setImageViewResource(m13146(i4), m13142(i4 + i3));
        }
        m13168(context, remoteViews, i2);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private static void m13186(Context context, int i, RemoteViews remoteViews, String str, PDiskData.ListType listType, List<String> list, List<PDiskData.ImageType> list2) {
        C1348Bu.m4094();
        int i2 = 0;
        for (String str2 : list) {
            C1283.m16851("nf_widget_helper", "decoding (%d), bitmap (%d), %s, %s, ", Integer.valueOf(i), Integer.valueOf(i2), list2.get(i2), str2);
            Bitmap r8 = m13197(str2, list2.get(i2));
            if (r8 == null) {
                C1283.m16850("nf_widget_helper", "use static images and start over ");
                mX.m8974(context);
                m13176(context, (mY.iF) null);
                return;
            }
            remoteViews.setImageViewBitmap(m13146(i2 + 1), r8);
            i2++;
        }
        m13168(context, remoteViews, i);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private static PDiskData.ListType m13173(Context context, PDiskData.ListType listType, PDiskData pDiskData) {
        int r5 = m13194(context);
        PDiskData.ListType r6 = m13174(listType, pDiskData);
        while (!m13170(r6, pDiskData, 0, r5)) {
            C1283.m16851("nf_widget_helper", "skip list:%s, currentList:%s, need:%d", r6, listType, Integer.valueOf(r5));
            r6 = m13174(r6, pDiskData);
            if (listType.equals(r6)) {
                break;
            }
        }
        C1283.m16851("nf_widget_helper", "using nextList:%s, currentList:%s, need:%s", r6, listType, Integer.valueOf(r5));
        return r6;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private static boolean m13205(Context context, PDiskData.ListType listType, PDiskData pDiskData) {
        return m13170(listType, pDiskData, 0, m13194(context));
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static boolean m13170(PDiskData.ListType listType, PDiskData pDiskData, int i, int i2) {
        if ((PDiskData.ListType.CW.equals(listType) || PDiskData.ListType.IQ.equals(listType)) && m13206(listType, pDiskData, i)) {
            return true;
        }
        return m13207(listType, pDiskData, i, i2);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private static boolean m13206(PDiskData.ListType listType, PDiskData pDiskData, int i) {
        return m13207(listType, pDiskData, i, 1);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private static boolean m13207(PDiskData.ListType listType, PDiskData pDiskData, int i, int i2) {
        List<mZ> r5 = m13151(listType, pDiskData);
        boolean z = r5 != null && m13195(r5, listType, pDiskData) >= i + i2;
        C1283.m16851("nf_widget_helper", "list:%s, size:%d, upperBound:%d, position:%d, need:%d, hasEnough:%b", listType, Integer.valueOf(r5.size()), Integer.valueOf(m13195(r5, listType, pDiskData)), Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z));
        return z;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private static int m13194(Context context) {
        int i = 0;
        int[] r8 = m13192(context);
        for (int i2 : r8) {
            int r6 = m13180(context, m13209(context, i2), i2);
            i = r6 > i ? r6 : i;
        }
        C1283.m16851("nf_widget_helper", "maxNumOfImages among all widgets %d", Integer.valueOf(i));
        return i;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private static boolean m13155(Context context, int i) {
        return m13156(m13179(context, i)) <= 1;
    }

    @TargetApi(16)
    /* renamed from: ˏ  reason: contains not printable characters */
    private static int m13179(Context context, int i) {
        Bundle appWidgetOptions = AppWidgetManager.getInstance(context.getApplicationContext()).getAppWidgetOptions(i);
        if (AD.m3307(context)) {
            return appWidgetOptions.getInt("appWidgetMinHeight");
        }
        return appWidgetOptions.getInt("appWidgetMaxHeight");
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static int m13157(Context context, int i) {
        Bundle appWidgetOptions = AppWidgetManager.getInstance(context.getApplicationContext()).getAppWidgetOptions(i);
        if (AD.m3307(context)) {
            return appWidgetOptions.getInt("appWidgetMaxWidth");
        }
        return appWidgetOptions.getInt("appWidgetMinWidth");
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static int m13156(int i) {
        return (i + 30) / 70;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private static int m13178(int i) {
        switch (i) {
            case 2:
                return R.id.preapp_image_group2;
            case 3:
                return R.id.preapp_image_group3;
            default:
                return R.id.preapp_image_group1;
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private static int m13146(int i) {
        switch (i) {
            case 2:
                return R.id.preapp_video_image2;
            case 3:
                return R.id.preapp_video_image3;
            default:
                return R.id.preapp_video_image1;
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private static int m13171(int i) {
        switch (i) {
            case 2:
                return R.id.preapp_play2;
            case 3:
                return R.id.preapp_play3;
            default:
                return R.id.preapp_play1;
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private static int m13193(int i) {
        switch (i) {
            case 2:
                return R.id.preapp_gradient2;
            case 3:
                return R.id.preapp_gradient3;
            default:
                return R.id.preapp_gradient1;
        }
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private static int m13208(int i) {
        switch (i) {
            case 2:
                return R.id.preapp_video_title2;
            case 3:
                return R.id.preapp_video_title3;
            default:
                return R.id.preapp_video_title1;
        }
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    private static int m13144(int i) {
        switch (i) {
            case 2:
                return R.id.preapp_video_progress2;
            case 3:
                return R.id.preapp_video_progress3;
            default:
                return R.id.preapp_video_progress1;
        }
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    private static int m13210(int i) {
        switch (i) {
            case 2:
                return R.id.preapp_progress_group2;
            case 3:
                return R.id.preapp_progress_group3;
            default:
                return R.id.preapp_progress_group1;
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private static int m13180(Context context, int i, int i2) {
        if (R.layout.preapp_widget_not_high == i || R.layout.preapp_small_width == i) {
            return 1;
        }
        if (R.layout.preapp_widget_1plus2 == i) {
            return 3;
        }
        if (R.layout.preapp_horz_adjustable != i) {
            return 1;
        }
        int r5 = m13179(context, i2);
        float r6 = (float) m13157(context, i2);
        float f = r6 / ((float) r5);
        C1283.m16851("nf_widget_helper", "w-h(%f-%d) %f ", Float.valueOf(r6), Integer.valueOf(r5), Float.valueOf(f));
        if (((double) f) < 1.8d) {
            C1283.m16854("nf_widget_helper", "1 image only");
            return 1;
        } else if (f < 3.0f) {
            C1283.m16854("nf_widget_helper", "2 image only");
            return 2;
        } else {
            C1283.m16854("nf_widget_helper", "3 images");
            return 3;
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private static void m13154(RemoteViews remoteViews) {
        remoteViews.setTextViewText(R.id.preapp_list_name, "");
        remoteViews.setViewVisibility(R.id.preapp_play1, 8);
        remoteViews.setViewVisibility(R.id.preapp_play2, 8);
        remoteViews.setViewVisibility(R.id.preapp_play3, 8);
        remoteViews.setViewVisibility(R.id.preapp_gradient1, 8);
        remoteViews.setViewVisibility(R.id.preapp_gradient2, 8);
        remoteViews.setViewVisibility(R.id.preapp_gradient3, 8);
        remoteViews.setViewVisibility(R.id.preapp_progress_group1, 8);
        remoteViews.setViewVisibility(R.id.preapp_progress_group2, 8);
        remoteViews.setViewVisibility(R.id.preapp_progress_group3, 8);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private static boolean m13177(Context context, int i) {
        return !m13155(context, i) && ((float) m13157(context, i)) > 200.0f;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private static PDiskData.ListType m13199(Intent intent) {
        if (intent.getExtras() != null) {
            String string = intent.getExtras().getString("listType");
            if (C1349Bv.m4107(string)) {
                return PDiskData.ListType.valueOf(string);
            }
        }
        return PDiskData.ListType.UNKNOWN;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private static mZ m13152(PDiskData.ListType listType, Intent intent, PDiskData pDiskData) {
        if (listType == null || PDiskData.ListType.UNKNOWN.equals(listType) || intent.getExtras() == null) {
            C1283.m16846("nf_widget_helper", "getVideoShownInWidget - listType / videoId  null");
            return null;
        }
        String string = intent.getExtras().getString("videoId");
        if (C1349Bv.m4113(string)) {
            C1283.m16854("nf_widget_helper", "extra_video_id is null");
            return null;
        }
        C1283.m16851("nf_widget_helper", "getVideoShownInWidget %s-%s", listType, string);
        List<mZ> r5 = m13151(listType, pDiskData);
        if (r5 == null) {
            return null;
        }
        for (mZ mZVar : r5) {
            if (C1349Bv.m4126(string, mZVar.id)) {
                return mZVar;
            }
        }
        return null;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static boolean m13191(PDiskData pDiskData) {
        return pDiskData == null || (!PDiskData.isMemberDataAvailable(pDiskData) && !PDiskData.isNonMemberDataAvailable(pDiskData));
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static void m13187(Context context, Intent intent, PDiskData pDiskData, mY.iF iFVar) {
        mZ mZVar;
        PDiskData.ListType r5 = m13199(intent);
        mZ r6 = m13152(r5, intent, pDiskData);
        if (r5 == null || PDiskData.ListType.UNKNOWN.equals(r5) || r6 == null) {
            C1283.m16865("nf_widget_helper", "listType or currentVideo is null getting first video");
            r5 = m13200(PreAppAgentEventType.ALL_MEMBER_UPDATED, pDiskData);
            if (!m13205(context, r5, pDiskData)) {
                C1283.m16851("nf_widget_helper", "list:%s, not enough - going to next", r5);
                r5 = m13173(context, r5, pDiskData);
            }
            mZVar = m13202(m13151(r5, pDiskData));
        } else {
            List<mZ> r7 = m13151(r5, pDiskData);
            int r8 = m13194(context);
            if (r7 == null || m13170(r5, pDiskData, r7.indexOf(r6) + 1, r8)) {
                C1283.m16851("nf_widget_helper", "list:%s, has enough pos:%d, need:%d, (%s-%s)", r5, Integer.valueOf(r7.indexOf(r6) + 1), Integer.valueOf(r8), r6.id, r6.title);
                mZVar = m13185(context, r5, r6, pDiskData);
            } else {
                C1283.m16851("nf_widget_helper", "list:%s, not enough videos  pos:%d, need:%d, (%s-%s)", r5, Integer.valueOf(r7.indexOf(r6) + 1), Integer.valueOf(r8), r6.id, r6.title);
                r5 = m13173(context, r5, pDiskData);
                mZVar = m13202(m13151(r5, pDiskData));
                C1283.m16851("nf_widget_helper", "jumped to list:%s", r5);
            }
        }
        if (mZVar == null) {
            r5 = m13174(r5, pDiskData);
            mZVar = m13202(m13151(r5, pDiskData));
            if (mZVar == null) {
                C1283.m16850("nf_widget_helper", "getNextList is not valid - ignoring refresh request");
                m13169(iFVar);
                return;
            }
        }
        m13153(context, mZVar, r5, pDiskData);
        m13169(iFVar);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static void m13176(Context context, mY.iF iFVar) {
        m13204(context, 0, iFVar);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static void m13204(Context context, int i, mY.iF iFVar) {
        m13203(context, i);
        m13175(context);
        m13169(iFVar);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private static void m13175(Context context) {
        Intent intent = new Intent("com.netflix.mediaclient.intent.action.REFRESH_DATA");
        intent.setClass(context, ServiceC0966.class);
        intent.addCategory("com.netflix.mediaclient.intent.category.CATEGORY_FROM_WIDGET_PROVIDER");
        if (C1317As.m3774()) {
            C1283.m16854("nf_widget_helper", "Android O, start foreground service...");
            intent.putExtra("start_foreground", true);
            intent.putExtra("start_requester", 2);
            m13167(context, intent);
            return;
        }
        C1283.m16854("nf_widget_helper", "Pre Android O, start service...");
        context.startService(intent);
    }

    @TargetApi(26)
    /* renamed from: ˋ  reason: contains not printable characters */
    private static void m13167(Context context, Intent intent) {
        context.startForegroundService(intent);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static void m13169(mY.iF iFVar) {
        if (iFVar != null) {
            iFVar.m8983();
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private static String m13201(PDiskData pDiskData, mZ mZVar, PDiskData.ImageType imageType) {
        if (mZVar == null || C1349Bv.m4113(mZ.m8985(mZVar, imageType))) {
            C1283.m16865("nf_widget_helper", "pVideo is not valid, ignore newRemoteView");
            return null;
        }
        String str = pDiskData.urlMap.get(mZ.m8984(mZ.m8985(mZVar, imageType)));
        if (!C1349Bv.m4113(str)) {
            return str;
        }
        C1283.m16865("nf_widget_helper", "resource not on disk, ignore widget update");
        return null;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private static Bitmap m13197(String str, PDiskData.ImageType imageType) {
        long nanoTime = System.nanoTime();
        Bitmap r7 = m13196(str);
        if (r7 == null) {
            C1283.m16865("nf_widget_helper", "bitmap does not exist");
            return null;
        }
        C1283.m16851("nf_widget_helper", "bitmap decode took (%s) %d ms", imageType, Long.valueOf(C1352By.m4139(nanoTime)));
        if (PDiskData.ImageType.TRICKPLAY.equals(imageType)) {
            long nanoTime2 = System.nanoTime();
            r7 = m13149(r7);
            C1283.m16851("nf_widget_helper", "bitmap resize (CW) took %d ms", Long.valueOf(C1352By.m4139(nanoTime2)));
        }
        if (!PDiskData.ImageType.TITLE_CARD.equals(imageType)) {
            return r7;
        }
        long nanoTime3 = System.nanoTime();
        Bitmap r72 = m13183(r7);
        C1283.m16851("nf_widget_helper", "bitmap resize (tvCard) took %d ms", Long.valueOf(C1352By.m4139(nanoTime3)));
        return r72;
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0083: APUT  
      (r2v5 java.lang.Object[])
      (4 ??[int, float, short, byte, char])
      (wrap: java.lang.Boolean : 0x007e: INVOKE  (r3v21 java.lang.Boolean) = (r3v20 boolean) type: STATIC call: java.lang.Boolean.valueOf(boolean):java.lang.Boolean)
     */
    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x00d2: APUT  
      (r2v3 java.lang.Object[])
      (4 ??[int, float, short, byte, char])
      (wrap: java.lang.Boolean : 0x00cd: INVOKE  (r3v12 java.lang.Boolean) = (r3v11 boolean) type: STATIC call: java.lang.Boolean.valueOf(boolean):java.lang.Boolean)
     */
    /* renamed from: ˊ  reason: contains not printable characters */
    private static Bitmap m13149(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float f = (float) (width / height);
        boolean z = f > 1.78f;
        C1283.m16851("nf_widget_helper", "getResizedBitmapForTrickplay -  w-h: %d-%d, aspectRatio:%f(%f), cropWidth:%b", Integer.valueOf(width), Integer.valueOf(height), Float.valueOf(f), Float.valueOf(1.78f), Boolean.valueOf(z));
        if (z) {
            int round = Math.round(((float) height) * 1.78f);
            int i = (width - round) / 2;
            Object[] objArr = new Object[5];
            objArr[0] = Integer.valueOf(width);
            objArr[1] = Integer.valueOf(height);
            objArr[2] = Integer.valueOf(round);
            objArr[3] = Integer.valueOf(i);
            objArr[4] = Boolean.valueOf(i + round < width);
            C1283.m16851("nf_widget_helper", "getResizedBitmapForTrickplay - w-h: %d-%d, aspectWidth:%d, x:%d, shouldCropWidth:%b", objArr);
            if (i + round >= width) {
                return bitmap;
            }
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, i, 0, round, height);
            bitmap.recycle();
            return createBitmap;
        }
        int round2 = Math.round(((float) width) / 1.78f);
        int i2 = (height - round2) / 2;
        Object[] objArr2 = new Object[5];
        objArr2[0] = Integer.valueOf(width);
        objArr2[1] = Integer.valueOf(height);
        objArr2[2] = Integer.valueOf(round2);
        objArr2[3] = Integer.valueOf(i2);
        objArr2[4] = Boolean.valueOf(i2 + round2 < height);
        C1283.m16851("nf_widget_helper", "getResizedBitmapForTrickplay - w-h: %d-%d, aspectHeight:%d, y:%d, shouldCropHeight:%b", objArr2);
        if (i2 + round2 >= height) {
            return bitmap;
        }
        Bitmap createBitmap2 = Bitmap.createBitmap(bitmap, 0, i2, width, round2);
        bitmap.recycle();
        return createBitmap2;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private static Bitmap m13183(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(3.0f, 3.0f);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false);
        bitmap.recycle();
        return createBitmap;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private static PDiskData.ImageType m13198(mZ mZVar, PDiskData.ListType listType, int i, int i2) {
        C1283.m16851("nf_widget_helper", "getImageType - getResizedBitmapForTrickplay%d, listType:%s, videoPos:%d", Integer.valueOf(i), listType, Integer.valueOf(i2));
        if (R.layout.preapp_widget_1plus2 == i && i2 > 1) {
            return PDiskData.ImageType.HORIZONTAL_ART;
        }
        if (R.layout.preapp_widget_not_high == i) {
            return PDiskData.ImageType.TITLE_CARD;
        }
        return (!PDiskData.ListType.CW.equals(listType) || !mZVar.isPlayable) ? PDiskData.ImageType.HORIZONTAL_ART : PDiskData.ImageType.TRICKPLAY;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    private static boolean m13141(Context context, int i) {
        int r5 = m13156(m13179(context, i) - 40);
        int r6 = m13156(m13157(context, i));
        boolean z = r5 > 1 && r6 > 2 && r6 <= r5 + 1;
        C1283.m16851("nf_widget_helper", "(%d, %d)(w,h), useMultipleTitles:%b", Integer.valueOf(r6), Integer.valueOf(r5), Boolean.valueOf(z));
        return z;
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    private static boolean m13143(Context context, int i) {
        int r5 = m13179(context, i) - 40;
        float r6 = (float) m13157(context, i);
        float f = r6 / ((float) r5);
        int r8 = m13156(r5);
        boolean z = r8 == 1 || f > 4.8f;
        C1283.m16851("nf_widget_helper", "w-h(%f-%d) %f, heightInCells: %d, alignByHeight: %b", Float.valueOf(r6), Integer.valueOf(r5), Float.valueOf(f), Integer.valueOf(r8), Boolean.valueOf(z));
        return z;
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private static int m13209(Context context, int i) {
        if (m13155(context, i)) {
            C1283.m16851("nf_widget_helper", "using preapp_widget_not_high %d", Integer.valueOf((int) R.layout.preapp_widget_not_high));
            return R.layout.preapp_widget_not_high;
        } else if (m13141(context, i)) {
            C1283.m16851("nf_widget_helper", "using preapp_widget_1plus2 %d", Integer.valueOf((int) R.layout.preapp_widget_1plus2));
            return R.layout.preapp_widget_1plus2;
        } else {
            int r5 = m13156(m13157(context, i));
            int i2 = m13143(context, i) ? R.layout.preapp_widget_not_high : r5 > 2 ? R.layout.preapp_horz_adjustable : R.layout.preapp_small_width;
            C1283.m16851("nf_widget_helper", "using %d, preapp_widget_not_high=%d, preapp_horz_adjustable:%d, (widthInCell:%d) preapp_small_width:%d", Integer.valueOf(i2), Integer.valueOf((int) R.layout.preapp_widget_not_high), Integer.valueOf((int) R.layout.preapp_horz_adjustable), Integer.valueOf(r5), Integer.valueOf((int) R.layout.preapp_small_width));
            return i2;
        }
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    private static String m13211(Context context, int i) {
        String str;
        switch (i % 3) {
            case 0:
                str = context.getString(R.string.preapp_ad1);
                break;
            case 1:
                str = context.getString(R.string.preapp_ad2);
                break;
            case 2:
            default:
                str = context.getString(R.string.preapp_ad3);
                break;
        }
        C1283.m16851("nf_widget_helper", "ad (%d) %s", Integer.valueOf(i), str);
        return str;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static RemoteViews m13161(Context context, int i, int i2, int i3) {
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), i2);
        int r7 = m13180(context, i2, i);
        if (r7 < 3) {
            for (int i4 = r7 + 1; i4 <= 3; i4++) {
                C1283.m16851("nf_widget_helper", "setting %d to gone", Integer.valueOf(i4));
                remoteViews.setViewVisibility(m13178(i4), 8);
            }
        }
        for (int i5 = 1; i5 <= r7; i5++) {
            C1283.m16851("nf_widget_helper", "for widgetId:%d, image:%d", Integer.valueOf(i), Integer.valueOf(i5));
            remoteViews.setViewVisibility(m13178(i5), 0);
            remoteViews = m13150(context, remoteViews, i, i5, i3);
            if (i5 == r7) {
                break;
            }
        }
        return m13172(context, remoteViews, i3, r7, i, i2);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static RemoteViews m13163(Context context, mZ mZVar, PDiskData.ListType listType, List<String> list, List<PDiskData.ImageType> list2, int i, int i2, PDiskData pDiskData) {
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), i2);
        m13154(remoteViews);
        List<mZ> r10 = m13151(listType, pDiskData);
        String str = pDiskData.lomoMap.get(listType.m1188());
        int r12 = m13180(context, i2, i);
        if (r12 < 3) {
            for (int i3 = r12 + 1; i3 <= 3; i3++) {
                C1283.m16851("nf_widget_helper", "setting %d to gone", Integer.valueOf(i3));
                remoteViews.setViewVisibility(m13178(i3), 8);
            }
        }
        for (int i4 = 1; i4 <= r12; i4++) {
            C1283.m16851("nf_widget_helper", "for widgetId:%d, image:%d, (%s), %s:%s", Integer.valueOf(i), Integer.valueOf(i4), listType, mZVar.id, mZVar.title);
            remoteViews.setViewVisibility(m13178(i4), 0);
            remoteViews = m13184(context, remoteViews, mZVar, i, listType, i4, i2);
            if (i4 == r12) {
                break;
            }
            if (m13190(listType, r10, mZVar, pDiskData)) {
                mZVar = m13165(r10, mZVar, listType, pDiskData);
            } else {
                listType = m13174(listType, pDiskData);
                r10 = m13151(listType, pDiskData);
                mZVar = m13202(r10);
                C1283.m16851("nf_widget_helper", "(%d)list at end, next video (%s) %s:%s ", Integer.valueOf(i4), listType, mZVar.id, mZVar.title);
            }
            PDiskData.ImageType r14 = m13198(mZVar, listType, i2, i4 + 1);
            String r15 = m13201(pDiskData, mZVar, r14);
            if (C1349Bv.m4107(r15)) {
                list.add(r15);
                list2.add(r14);
            } else {
                C1283.m16855("nf_widget_helper", "(%d) url null for video:%s in list %s", Integer.valueOf(i4), mZVar.title, listType);
            }
        }
        return m13162(context, remoteViews, r12, mZVar, listType, i, i2, str, r10);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private static RemoteViews m13172(Context context, RemoteViews remoteViews, int i, int i2, int i3, int i4) {
        remoteViews.setOnClickPendingIntent(R.id.preapp_app_logo, m13145(context, i3));
        if (R.layout.preapp_widget_not_high == i4) {
            remoteViews.setOnClickPendingIntent(R.id.preapp_refresh, m13181(context, i3, i, i2));
            remoteViews.setViewVisibility(R.id.preapp_list_name, 8);
            remoteViews.setViewVisibility(m13193(1), 0);
        } else {
            remoteViews.setOnClickPendingIntent(R.id.preapp_list_name, m13181(context, i3, i, i2));
            if (m13177(context, i3)) {
                remoteViews.setTextViewText(R.id.preapp_list_name, m13211(context, i > 0 ? (i % 3) / i2 : 0));
            }
        }
        return remoteViews;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static RemoteViews m13162(Context context, RemoteViews remoteViews, int i, mZ mZVar, PDiskData.ListType listType, int i2, int i3, String str, List<mZ> list) {
        remoteViews.setOnClickPendingIntent(R.id.preapp_app_logo, m13145(context, i2));
        if (R.layout.preapp_widget_not_high == i3) {
            remoteViews.setOnClickPendingIntent(R.id.preapp_refresh, m13182(context, mZVar, listType, i2));
            remoteViews.setViewVisibility(R.id.preapp_list_name, 8);
            remoteViews.setViewVisibility(m13193(1), 0);
        } else {
            remoteViews.setOnClickPendingIntent(R.id.preapp_list_name, m13182(context, mZVar, listType, i2));
            if (m13177(context, i2)) {
                if (PDiskData.ListType.NON_MEMBER.equals(listType)) {
                    int indexOf = list.indexOf(mZVar) / i;
                    remoteViews.setTextViewText(R.id.preapp_list_name, m13211(context, indexOf > 0 ? indexOf : 0));
                } else {
                    remoteViews.setTextViewText(R.id.preapp_list_name, str);
                }
            }
        }
        return remoteViews;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private static RemoteViews m13150(Context context, RemoteViews remoteViews, int i, int i2, int i3) {
        remoteViews.setOnClickPendingIntent(m13146(i2), m13147(context, i, i2, i3));
        return remoteViews;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private static RemoteViews m13184(Context context, RemoteViews remoteViews, mZ mZVar, int i, PDiskData.ListType listType, int i2, int i3) {
        int r3 = m13146(i2);
        remoteViews.setOnClickPendingIntent(r3, m13148(context, mZVar, listType, i, i2));
        if (PDiskData.ListType.CW.equals(listType)) {
            remoteViews.setProgressBar(m13144(i2), 100, mZVar.playableRuntime > 0 ? (mZVar.plyableBookmarkPos * 100) / mZVar.playableRuntime : 0, false);
            if (PDiskData.ImageType.TRICKPLAY.equals(m13198(mZVar, listType, i3, i2))) {
                remoteViews.setTextViewText(m13208(i2), m13164(context, listType, mZVar));
            }
            remoteViews.setViewVisibility(m13193(i2), 0);
            remoteViews.setViewVisibility(m13171(i2), 0);
            remoteViews.setViewVisibility(m13210(i2), 0);
            remoteViews.setOnClickPendingIntent(m13171(i2), m13160(context, mZVar, listType, i, i2));
            remoteViews.setOnClickPendingIntent(r3, m13160(context, mZVar, listType, i, i2));
        }
        return remoteViews;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static String m13164(Context context, PDiskData.ListType listType, mZ mZVar) {
        if (!PDiskData.ListType.CW.equals(listType) || !VideoType.SHOW.equals(mZVar.videoType)) {
            return mZVar.title;
        }
        return context.getString(R.string.label_preappShowTitle, mZVar.title, mZVar.playableSeasonNumAbbrLabel, Integer.valueOf(mZVar.playableEpisodeNumber));
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private static PendingIntent m13147(Context context, int i, int i2, int i3) {
        String str = "com.netflix.mediaclient.intent.action.DETAILS_1_FROM_PREAPP_WIDGET";
        if (i2 == 2) {
            str = "com.netflix.mediaclient.intent.action.DETAILS_2_FROM_PREAPP_WIDGET";
        }
        if (i2 == 3) {
            str = "com.netflix.mediaclient.intent.action.DETAILS_3_FROM_PREAPP_WIDGET";
        }
        return m13158(context, new Intent(str), i, i3 + i2);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private static PendingIntent m13148(Context context, mZ mZVar, PDiskData.ListType listType, int i, int i2) {
        String str = "com.netflix.mediaclient.intent.action.DETAILS_1_FROM_PREAPP_WIDGET";
        if (i2 == 2) {
            str = "com.netflix.mediaclient.intent.action.DETAILS_2_FROM_PREAPP_WIDGET";
        }
        if (i2 == 3) {
            str = "com.netflix.mediaclient.intent.action.DETAILS_3_FROM_PREAPP_WIDGET";
        }
        return m13159(context, new Intent(str), mZVar, listType, i);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static PendingIntent m13160(Context context, mZ mZVar, PDiskData.ListType listType, int i, int i2) {
        String str = "com.netflix.mediaclient.intent.action.PLAY_1_FROM_PREAPP_WIDGET";
        if (i2 == 2) {
            str = "com.netflix.mediaclient.intent.action.PLAY_2_FROM_PREAPP_WIDGET";
        }
        if (i2 == 3) {
            str = "com.netflix.mediaclient.intent.action.PLAY_3_FROM_PREAPP_WIDGET";
        }
        return m13159(context, new Intent(str), mZVar, listType, i);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private static PendingIntent m13181(Context context, int i, int i2, int i3) {
        Intent intent = new Intent("com.netflix.mediaclient.intent.action.REFRESH_FROM_PREAPP_WIDGET");
        C1283.m16851("nf_widget_helper", "refreshIntent startVideoIndex %d, imagesToShow %s, putting %d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf((i2 + i3) % 3));
        return m13158(context, intent, i, i2 + i3);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private static PendingIntent m13182(Context context, mZ mZVar, PDiskData.ListType listType, int i) {
        return m13159(context, new Intent("com.netflix.mediaclient.intent.action.REFRESH_FROM_PREAPP_WIDGET"), mZVar, listType, i);
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    private static PendingIntent m13145(Context context, int i) {
        return m13159(context, new Intent("com.netflix.mediaclient.intent.action.HOME_FROM_PREAPP_WIDGET"), (mZ) null, (PDiskData.ListType) null, i);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static PendingIntent m13158(Context context, Intent intent, int i, int i2) {
        intent.setClass(context, PAppWidgetReceiver.class).addCategory("com.netflix.mediaclient.intent.category.CATEGORY_FROM_PREAPP_WIDGET").putExtra("widgetId", i).putExtra("videoIndex", i2 % 3).putExtra("listType", PDiskData.ListType.UNKNOWN.toString());
        return PendingIntent.getBroadcast(context, 0, intent, 134217728);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static PendingIntent m13159(Context context, Intent intent, mZ mZVar, PDiskData.ListType listType, int i) {
        intent.setClass(context, PAppWidgetReceiver.class).addCategory("com.netflix.mediaclient.intent.category.CATEGORY_FROM_PREAPP_WIDGET").putExtra("widgetId", i);
        if (mZVar != null && C1349Bv.m4107(mZVar.id)) {
            intent.putExtra("videoId", mZVar.id);
            intent.putExtra("videoType", mZVar.videoType.getValue());
            intent.putExtra("playableId", mZVar.playableId);
        }
        if (listType != null && !PDiskData.ListType.UNKNOWN.equals(listType)) {
            intent.putExtra("listType", listType.toString());
        }
        return PendingIntent.getBroadcast(context, 0, intent, 134217728);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static void m13168(Context context, RemoteViews remoteViews, int i) {
        if (remoteViews == null) {
            C1283.m16865("nf_widget_helper", "RemoteViews is null, ignore refreshing widget");
        } else {
            AppWidgetManager.getInstance(context.getApplicationContext()).updateAppWidget(i, remoteViews);
        }
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    private static int m13142(int i) {
        switch (i) {
            case 1:
                return R.drawable.preapp_static1;
            case 2:
                return R.drawable.preapp_static2;
            case 3:
                return R.drawable.preapp_static3;
            default:
                return R.drawable.preapp_mobile_signin;
        }
    }
}
