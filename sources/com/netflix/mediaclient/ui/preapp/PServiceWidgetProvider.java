package com.netflix.mediaclient.ui.preapp;

import android.annotation.TargetApi;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.netflix.mediaclient.service.pservice.logging.PServiceLogging;
import com.netflix.mediaclient.service.pservice.logging.PreAppWidgetLogActionData;
import o.C1283;
import o.ServiceC0966;
@TargetApi(16)
public class PServiceWidgetProvider extends AppWidgetProvider {
    @Override // android.appwidget.AppWidgetProvider
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] iArr) {
        C1283.m16851("nf_widget_provider", "onUpdate appWidgetIds.length= %d", Integer.valueOf(iArr.length));
        int intValue = PAppWidgetReceiver.f3807.intValue();
        if (iArr.length == 1) {
            intValue = iArr[0];
        }
        PServiceLogging.storeLogEvent(context, PreAppWidgetLogActionData.PreAppWidgetActionName.INSTALL, intValue);
        PAppWidgetReceiver.m2748(context, m2752(context, "com.netflix.mediaclient.intent.action.INSTALLED_FROM_PREAPP_WIDGET", intValue), goAsync());
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onEnabled(Context context) {
        C1283.m16854("nf_widget_provider", "onEnabled");
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onDisabled(Context context) {
        C1283.m16854("nf_widget_provider", "onDisabled");
        PServiceLogging.storeLogEvent(context, PreAppWidgetLogActionData.PreAppWidgetActionName.DELETE);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private static Intent m2752(Context context, String str, int i) {
        C1283.m16851("nf_widget_provider", "Sending command to NetflixService to start...action:%s", str);
        Intent intent = new Intent(str);
        intent.setClass(context, ServiceC0966.class);
        intent.addCategory("com.netflix.mediaclient.intent.category.CATEGORY_FROM_PREAPP_WIDGET");
        intent.putExtra("widgetId", i);
        return intent;
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onAppWidgetOptionsChanged(Context context, AppWidgetManager appWidgetManager, int i, Bundle bundle) {
        PAppWidgetReceiver.m2748(context, m2752(context, "com.netflix.mediaclient.intent.action.ACTION_RESIZED_FROM_PREAPP_WIDGET", i), goAsync());
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static void m2753(Context context) {
        C1283.m16854("nf_widget_provider", "onConfigurationChange");
        int[] appWidgetIds = AppWidgetManager.getInstance(context).getAppWidgetIds(new ComponentName(context, PServiceWidgetProvider.class));
        PAppWidgetReceiver.m2748(context, m2752(context, "com.netflix.mediaclient.intent.action.ACTION_RESIZED_FROM_PREAPP_WIDGET", appWidgetIds.length > 0 ? appWidgetIds[0] : 0), (BroadcastReceiver.PendingResult) null);
    }
}
