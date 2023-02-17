package com.netflix.mediaclient.ui.profiles;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.RestrictionEntry;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.UserManager;
import com.netflix.mediaclient.R;
import java.util.ArrayList;
import o.C1283;
import o.C1317As;
@TargetApi(18)
public class RestrictedProfilesReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (C1317As.m3758() >= 18) {
            String action = intent.getAction();
            if (!"android.intent.action.GET_RESTRICTION_ENTRIES".equals(action)) {
                C1283.m16865("RestrictedProfilesReceiver", "Unknown action: " + action);
                return;
            }
            C1283.m16862("RestrictedProfilesReceiver", "Adding restriction to disable profile switching");
            RestrictionEntry restrictionEntry = new RestrictionEntry("key_disable_profile_switching", intent.getBundleExtra("android.intent.extra.restrictions_bundle").getBoolean("key_disable_profile_switching", false));
            restrictionEntry.setTitle(context.getString(R.string.label_restrict_profile_selection));
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            arrayList.add(restrictionEntry);
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("android.intent.extra.restrictions_list", arrayList);
            setResult(-1, null, bundle);
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static boolean m2764(Context context) {
        return ((UserManager) context.getSystemService("user")).getApplicationRestrictions(context.getPackageName()).getBoolean("key_disable_profile_switching");
    }
}
