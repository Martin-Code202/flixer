package com.netflix.mediaclient.service.pservice.logging;

import android.annotation.TargetApi;
import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.os.Bundle;
import com.netflix.mediaclient.service.logging.client.model.UIError;
import com.netflix.mediaclient.service.pservice.logging.PreAppWidgetLogActionData;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.UserActionLogging;
import o.BW;
import o.C1283;
import o.C1339Bl;
import o.C1362Ch;
@TargetApi(16)
public final class PServiceLogging {
    private static final Object PServiceLoggingLock = new Object();
    private static final String TAG = "nf_widget_log";

    private PServiceLogging() {
    }

    public static void storeLogEvent(Context context, PreAppWidgetLogActionData.PreAppWidgetActionName preAppWidgetActionName) {
        storeLogEvent(context, preAppWidgetActionName, new PreAppWidgetSize(0, 0, 0, 0));
    }

    public static void storeLogEvent(Context context, PreAppWidgetLogActionData.PreAppWidgetActionName preAppWidgetActionName, int i) {
        storeLogEvent(context, preAppWidgetActionName, getWidgetSize(context, i));
    }

    public static PreAppWidgetSize getWidgetSize(Context context, int i) {
        Bundle appWidgetOptions = AppWidgetManager.getInstance(context.getApplicationContext()).getAppWidgetOptions(i);
        return new PreAppWidgetSize(appWidgetOptions.getInt("appWidgetMinWidth"), appWidgetOptions.getInt("appWidgetMaxWidth"), appWidgetOptions.getInt("appWidgetMinHeight"), appWidgetOptions.getInt("appWidgetMaxHeight"));
    }

    private static void storeLogEvent(Context context, PreAppWidgetLogActionData.PreAppWidgetActionName preAppWidgetActionName, PreAppWidgetSize preAppWidgetSize) {
        PServiceWidgetLogEvent pServiceWidgetLogEvent = new PServiceWidgetLogEvent(preAppWidgetActionName, preAppWidgetSize);
        synchronized (PServiceLoggingLock) {
            PServiceLogEvents createFromJsonString = PServiceLogEvents.createFromJsonString(getStoredLogEventsString(context));
            createFromJsonString.addWidgetEvent(pServiceWidgetLogEvent);
            putLogEvents(context, createFromJsonString.toJsonString());
        }
    }

    private static String readAndClearStoredLog(Context context) {
        String storedLogEventsString;
        synchronized (PServiceLoggingLock) {
            storedLogEventsString = getStoredLogEventsString(context);
            putLogEvents(context, null);
        }
        return storedLogEventsString;
    }

    public static void reportStoredLogEvents(Context context, boolean z) {
        PServiceLogEvents createFromJsonString = PServiceLogEvents.createFromJsonString(readAndClearStoredLog(context));
        if (createFromJsonString == null || createFromJsonString.getWidgetEvents() == null || createFromJsonString.getWidgetEvents().size() == 0) {
            C1283.m16854(TAG, "no widget logs on disk. ");
            return;
        }
        for (PServiceWidgetLogEvent pServiceWidgetLogEvent : createFromJsonString.getWidgetEvents()) {
            switch (pServiceWidgetLogEvent.action) {
                case INSTALL:
                    C1283.m16854(TAG, "Found install event on disk, sending to sever");
                    BW.m3943(PreAppWidgetLogData.createInstance(context, pServiceWidgetLogEvent.widgetSize, z).toJsonString(), pServiceWidgetLogEvent.timeInMs);
                    break;
                case DELETE:
                    C1283.m16854(TAG, "Found delete event on disk, sending to sever");
                    BW.m3930(PreAppWidgetLogData.createInstance(context, pServiceWidgetLogEvent.widgetSize, z).toJsonString(), pServiceWidgetLogEvent.timeInMs);
                    break;
                default:
                    C1283.m16851(TAG, "Found %s event on disk, sending to sever", pServiceWidgetLogEvent.action);
                    C1362Ch.m4403(UserActionLogging.CommandName.androidWidgetCommand, PreAppWidgetLogData.createInstance(context, pServiceWidgetLogEvent.widgetSize, z), new PreAppWidgetLogActionData(pServiceWidgetLogEvent.action));
                    C1362Ch.m4383(IClientLogging.CompletionReason.success, (UIError) null);
                    break;
            }
        }
    }

    private static String getStoredLogEventsString(Context context) {
        return C1339Bl.m4045(context, "pservice_actions_to_log", (String) null);
    }

    private static void putLogEvents(Context context, String str) {
        C1339Bl.m4039(context, "pservice_actions_to_log", str);
    }
}
