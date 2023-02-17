package o;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import com.amazon.drm.AmazonLicenseVerificationCallback;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
/* renamed from: o.Ay  reason: case insensitive filesystem */
public final class C1325Ay {

    /* renamed from: ˏ  reason: contains not printable characters */
    private static final List<String> f4564 = Arrays.asList("com.ironsource", "com.aura", "com.sec.android.app.samsungapps", "com.tmobile.pr.adapt", "com.sprint.ce.updater", "com.orange.aura.oobe", "com.orange.update", "com.warranteer.helper.blu");

    /* renamed from: ˊ  reason: contains not printable characters */
    public static final Intent m3824(Context context) {
        if (m3826()) {
            Intent r2 = m3830();
            if (C1317As.m3747(context, r2) != null) {
                C1283.m16854("nf_appstorehelper", "App Update Source is Amazon App Store");
                return r2;
            }
        }
        Intent r22 = m3828();
        if (C1317As.m3747(context, r22) != null) {
            C1283.m16854("nf_appstorehelper", "App Update Source is Google Play Store");
            return r22;
        }
        C1283.m16854("nf_appstorehelper", "Google Play Store is not installed or was not setup.");
        Intent r23 = m3823();
        if (C1317As.m3747(context, r23) != null) {
            C1283.m16854("nf_appstorehelper", "App Update Source is Nook App Store");
            return r23;
        }
        Intent r24 = m3830();
        if (C1317As.m3747(context, r24) == null) {
            return null;
        }
        C1283.m16854("nf_appstorehelper", "App Update Source is Amazon App Store");
        return r24;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static final Intent m3828() {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("market://details?id=com.netflix.mediaclient"));
        return intent;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static final Intent m3830() {
        Intent intent = new Intent();
        intent.setData(Uri.parse("amzn://apps/android?p=com.netflix.mediaclient"));
        return intent;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static final Intent m3823() {
        Intent intent = new Intent();
        intent.setAction("com.bn.sdk.shop.details");
        intent.putExtra("product_details_ean", "2940043872739");
        return intent;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static final boolean m3826() {
        if (!AmazonLicenseVerificationCallback.isCalled()) {
            return false;
        }
        C1283.m16854("nf_appstorehelper", "Installation source is Amazon App Store.");
        return true;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static final boolean m3831(String str) {
        if (!str.startsWith("com.android.") && !str.startsWith("com.google.")) {
            return false;
        }
        C1283.m16854("nf_appstorehelper", "Installation source is Google Play Store.");
        return true;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private static boolean m3827(String str) {
        if (C1349Bv.m4113(str)) {
            return false;
        }
        ListIterator<String> listIterator = f4564.listIterator();
        while (listIterator.hasNext()) {
            if (str.startsWith(listIterator.next())) {
                C1283.m16854("nf_appstorehelper", "Installation source is ironSource");
                return true;
            }
        }
        return false;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static String m3825(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return null;
        }
        return packageManager.getInstallerPackageName(C1318At.m3780());
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static String m3829(Context context) {
        if (m3826()) {
            return "amazon";
        }
        String str = null;
        PackageManager packageManager = context.getPackageManager();
        if (!(packageManager == null || (str = packageManager.getInstallerPackageName(C1318At.m3780())) == null)) {
            str = str.toLowerCase();
        }
        if (C1349Bv.m4113(str)) {
            return "sideload";
        }
        if (m3831(str)) {
            return "google";
        }
        if (m3827(str)) {
            return "ironsource";
        }
        return str;
    }
}
