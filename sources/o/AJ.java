package o;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.LocalBroadcastManager;
import android.view.Menu;
import android.view.MenuItem;
import com.netflix.cl.Logger;
import com.netflix.mediaclient.NetflixApplication;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.service.logging.client.model.Error;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.UIViewLogging;
import com.netflix.mediaclient.servicemgr.UserActionLogging;
import com.netflix.mediaclient.ui.details.DetailsActivity;
import com.netflix.mediaclient.ui.experience.BrowseExperience;
import com.netflix.mediaclient.util.log.UIScreen;
import java.util.Set;
public class AJ {

    /* renamed from: ˋ  reason: contains not printable characters */
    private static long f4280;

    /* renamed from: ˎ  reason: contains not printable characters */
    public static C0062 f4281 = new C0062(0, 0);

    /* renamed from: o.AJ$ˋ  reason: contains not printable characters */
    public static class C0062 implements Parcelable {
        public static final Parcelable.Creator<C0062> CREATOR = new Parcelable.Creator<C0062>() { // from class: o.AJ.ˋ.2
            /* renamed from: ˋ  reason: contains not printable characters */
            public C0062 createFromParcel(Parcel parcel) {
                return new C0062(parcel);
            }

            /* renamed from: ॱ  reason: contains not printable characters */
            public C0062[] newArray(int i) {
                return new C0062[i];
            }
        };

        /* renamed from: ˋ  reason: contains not printable characters */
        private int f4282;

        /* renamed from: ॱ  reason: contains not printable characters */
        private int f4283;

        public C0062(int i, int i2) {
            this.f4282 = i;
            this.f4283 = i2;
        }

        protected C0062(Parcel parcel) {
            this.f4282 = parcel.readInt();
            this.f4283 = parcel.readInt();
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public int m3369() {
            return this.f4283;
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        public boolean m3371() {
            return this.f4282 + this.f4283 > 0;
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        public boolean m3370() {
            return this.f4283 > 0;
        }

        @Override // java.lang.Object
        public String toString() {
            return "NotificationStatus unread: " + this.f4283 + " read" + this.f4282;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f4282);
            parcel.writeInt(this.f4283);
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static void m3368(Menu menu, Activity activity) {
        boolean z = true;
        if (BrowseExperience.m1780()) {
            C1283.m16846("SocialUtils", "We have a kids profile - hide share icon");
            z = false;
        }
        if (C0881.m15597(activity)) {
            z = false;
        }
        if ((activity instanceof DetailsActivity) && z) {
            C1283.m16846("SocialUtils", "Adding share icon");
            menu.add(0, R.id.social_share_sheet_item, 0, R.string.share_button_name).setIcon(ContextCompat.getDrawable(activity, R.drawable.ic_menu_share)).setShowAsAction(2);
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static boolean m3366(MenuItem menuItem, Context context) {
        if (!(context instanceof DetailsActivity) || menuItem.getItemId() != R.id.social_share_sheet_item) {
            return false;
        }
        DetailsActivity detailsActivity = (DetailsActivity) context;
        String r3 = detailsActivity.m1634();
        Fragment r4 = detailsActivity.mo10792();
        String str = null;
        if (r4 instanceof qW) {
            str = ((qW) r4).m9988();
        }
        m3357(context, r3, str == null ? "" : str);
        return true;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static void m3358(C2059ph phVar) {
        if (phVar != null && phVar.m9764() != null) {
            if (System.currentTimeMillis() - f4280 > 900000) {
                phVar.m9764().mo9475(true);
                f4280 = System.currentTimeMillis();
                return;
            }
            phVar.m9764().mo9475(false);
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static void m3364(C0062 r2) {
        Intent intent = new Intent("com.netflix.mediaclient.intent.action.BA_IRIS_NOTIFICATION_LIST_UPDATED");
        intent.putExtra("notifications_list_status", r2);
        LocalBroadcastManager.getInstance(NetflixApplication.getInstance()).sendBroadcast(intent);
        if (!r2.m3370()) {
            m3362();
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static C0062 m3360(Intent intent, String str) {
        C1283.m16862(str, "Received social notifications list updated intent");
        if (intent == null) {
            C1283.m16865(str, "Received null intent");
            return f4281;
        } else if (!"com.netflix.mediaclient.intent.action.BA_IRIS_NOTIFICATION_LIST_UPDATED".equals(intent.getAction())) {
            return f4281;
        } else {
            C1283.m16862(str, "Updating menu icon");
            return (C0062) intent.getParcelableExtra("notifications_list_status");
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static void m3363(Context context, Intent intent, String str) {
        String stringExtra = intent.getStringExtra("swiped_notification_id");
        if (!C1349Bv.m4113(stringExtra)) {
            C1283.m16862(str, "saving swiped out notification id to preferences");
            C1339Bl.m4039(context, "notification_id_deleted_from_statusbar", stringExtra);
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static void m3362() {
        ((NotificationManager) NetflixApplication.getInstance().getSystemService("notification")).cancel(1000);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.util.Set<T> */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: ˏ  reason: contains not printable characters */
    public static <T> void m3365(Parcelable[] parcelableArr, Set<T> set) {
        for (Parcelable parcelable : parcelableArr) {
            set.add(parcelable);
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static void m3367(Activity activity, String str, String str2, UIScreen uIScreen) {
        Resources resources = activity.getResources();
        String r5 = m3359(str);
        C1364Cj.m4436(UIViewLogging.UIViewCommandName.shareSheet, uIScreen.f4084, (C1359Ce) null, (String) null);
        C1362Ch.m4405(r5, (UserActionLogging.CommandName) null, IClientLogging.ModalView.movieDetails);
        C1364Cj.m4432();
        Long r6 = Logger.INSTANCE.m142(new C0789());
        Logger.INSTANCE.m140(Logger.INSTANCE.m142(new C0394()));
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setFlags(268435456);
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.TEXT", m3361(resources, str2, r5));
        activity.startActivityForResult(Intent.createChooser(intent, resources.getString(R.string.share_dialog_title)), 8888);
        Logger.INSTANCE.m147(C0789.m15264(r6, new C0609[]{new C0609("default", r5)}));
        C1362Ch.m4382(IClientLogging.CompletionReason.success, (Error) null);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static void m3357(Context context, String str, String str2) {
        Resources resources = context.getResources();
        String r5 = m3359(str);
        Long r6 = Logger.INSTANCE.m142(new C0789());
        Logger.INSTANCE.m140(Logger.INSTANCE.m142(new C0394()));
        C1364Cj.m4436(UIViewLogging.UIViewCommandName.shareSheet, IClientLogging.ModalView.movieDetails, (C1359Ce) null, (String) null);
        C1362Ch.m4405(r5, (UserActionLogging.CommandName) null, IClientLogging.ModalView.movieDetails);
        C1364Cj.m4432();
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setFlags(268435456);
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.TEXT", m3361(resources, str2, r5));
        context.startActivity(Intent.createChooser(intent, resources.getString(R.string.share_dialog_title)));
        Logger.INSTANCE.m147(C0789.m15264(r6, new C0609[]{new C0609("default", r5)}));
        C1362Ch.m4382(IClientLogging.CompletionReason.success, (Error) null);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static String m3361(Resources resources, String str, String str2) {
        if (!C1349Bv.m4113(str)) {
            return resources.getString(R.string.share_dialog_body, str, str2);
        }
        C1276.m16820().mo5727("SPY-9064, SPY-13429 - Video title was not ready - showing no title share msg.");
        return resources.getString(R.string.share_dialog_no_title_body, str2);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static String m3359(String str) {
        return String.format("%s/%s/%s?%s", "www.netflix.com", "title", str, "source=android");
    }
}
