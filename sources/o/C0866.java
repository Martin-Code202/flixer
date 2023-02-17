package o;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import com.netflix.android.moneyball.BuildConfig;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import o.AbstractC1028;
import o.C0738;
import o.C0924;
import org.json.JSONException;
/* access modifiers changed from: package-private */
/* renamed from: o.ᔊ  reason: contains not printable characters */
public class C0866 extends AbstractC0446 {

    /* renamed from: ʻ  reason: contains not printable characters */
    private ServiceConnection f14718;

    /* renamed from: ʼ  reason: contains not printable characters */
    private ExecutorService f14719;

    /* renamed from: ʽ  reason: contains not printable characters */
    private boolean f14720;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final C0426 f14721;

    /* renamed from: ˊॱ  reason: contains not printable characters */
    private final BroadcastReceiver f14722 = new BroadcastReceiver() { // from class: o.ᔊ.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            AbstractC0888 r2 = C0866.this.f14721.m14234();
            if (r2 == null) {
                C0895.m15616("BillingClient", "PurchasesUpdatedListener is null - no way to return the response.");
            } else {
                r2.onPurchasesUpdated(intent.getIntExtra("response_code_key", 6), C0895.m15614(intent.getBundleExtra("response_bundle_key")));
            }
        }
    };

    /* renamed from: ˋ  reason: contains not printable characters */
    private final Context f14723;

    /* renamed from: ˎ  reason: contains not printable characters */
    private AbstractC1028 f14724;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final Handler f14725 = new Handler();

    /* renamed from: ॱ  reason: contains not printable characters */
    private int f14726 = 0;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private boolean f14727;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private boolean f14728;

    C0866(Context context, AbstractC0888 r4) {
        this.f14723 = context.getApplicationContext();
        this.f14721 = new C0426(this.f14723, r4);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public boolean m15571() {
        return (this.f14726 != 2 || this.f14724 == null || this.f14718 == null) ? false : true;
    }

    @Override // o.AbstractC0446
    /* renamed from: ˏ */
    public void mo14322(AbstractC0865 r13) {
        if (m15571()) {
            C0895.m15619("BillingClient", "Service connection is valid. No need to re-initialize.");
            r13.onBillingSetupFinished(0);
        } else if (this.f14726 == 1) {
            C0895.m15616("BillingClient", "Client is already in the process of connecting to billing service.");
            r13.onBillingSetupFinished(5);
        } else if (this.f14726 == 3) {
            C0895.m15616("BillingClient", "Client was already closed and can't be reused. Please create another instance.");
            r13.onBillingSetupFinished(5);
        } else {
            this.f14726 = 1;
            this.f14721.m14235();
            C0811.m15374(this.f14723).m15378(this.f14722, new IntentFilter("proxy_activity_response_intent_action"));
            C0895.m15619("BillingClient", "Starting in-app billing setup.");
            this.f14718 = new ServiceConnectionC0867(r13);
            Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
            intent.setPackage("com.android.vending");
            List<ResolveInfo> queryIntentServices = this.f14723.getPackageManager().queryIntentServices(intent, 0);
            if (queryIntentServices != null && !queryIntentServices.isEmpty()) {
                ResolveInfo resolveInfo = queryIntentServices.get(0);
                if (resolveInfo.serviceInfo != null) {
                    String str = resolveInfo.serviceInfo.packageName;
                    String str2 = resolveInfo.serviceInfo.name;
                    if (!"com.android.vending".equals(str) || str2 == null) {
                        C0895.m15616("BillingClient", "The device doesn't have valid Play Store.");
                    } else {
                        ComponentName componentName = new ComponentName(str, str2);
                        Intent intent2 = new Intent(intent);
                        intent2.setComponent(componentName);
                        intent2.putExtra("libraryVersion", BuildConfig.VERSION_NAME);
                        if (this.f14723.bindService(intent2, this.f14718, 1)) {
                            C0895.m15619("BillingClient", "Service was bonded successfully.");
                            return;
                        }
                        C0895.m15616("BillingClient", "Connection to Billing service is blocked.");
                    }
                }
            }
            this.f14726 = 0;
            C0895.m15619("BillingClient", "Billing service unavailable on device.");
            r13.onBillingSetupFinished(3);
        }
    }

    @Override // o.AbstractC0446
    /* renamed from: ˎ */
    public C0738.C0739 mo14321(String str) {
        if (!m15571()) {
            return new C0738.C0739(-1, null);
        }
        if (!TextUtils.isEmpty(str)) {
            return m15566(str, false);
        }
        C0895.m15616("BillingClient", "Please provide a valid SKU type.");
        return new C0738.C0739(5, null);
    }

    @Override // o.AbstractC0446
    /* renamed from: ॱ */
    public void mo14323(C0900 r5, final AbstractC0868 r6) {
        if (!m15571()) {
            r6.onSkuDetailsResponse(-1, null);
        }
        final String r2 = r5.m15629();
        final List<String> r3 = r5.m15630();
        if (TextUtils.isEmpty(r2)) {
            C0895.m15616("BillingClient", "Please fix the input params. SKU type can't be empty.");
            r6.onSkuDetailsResponse(5, null);
        } else if (r3 == null) {
            C0895.m15616("BillingClient", "Please fix the input params. The list of SKUs can't be empty.");
            r6.onSkuDetailsResponse(5, null);
        } else {
            m15562(new Runnable() { // from class: o.ᔊ.2
                @Override // java.lang.Runnable
                public void run() {
                    final C0924.C0925 r32 = C0866.this.m15572(r2, r3);
                    C0866.this.m15570(new Runnable() { // from class: o.ᔊ.2.3
                        @Override // java.lang.Runnable
                        public void run() {
                            r6.onSkuDetailsResponse(r32.m15732(), r32.m15731());
                        }
                    });
                }
            });
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m15562(Runnable runnable) {
        if (this.f14719 == null) {
            this.f14719 = Executors.newFixedThreadPool(C0895.f14769);
        }
        this.f14719.submit(runnable);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ॱ  reason: contains not printable characters */
    public C0924.C0925 m15572(String str, List<String> list) {
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        for (int i = 0; i < size; i += 20) {
            int i2 = i + 20;
            if (i2 > size) {
                i2 = size;
            }
            ArrayList<String> arrayList2 = new ArrayList<>(list.subList(i, i2));
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("ITEM_ID_LIST", arrayList2);
            bundle.putString("libraryVersion", BuildConfig.VERSION_NAME);
            try {
                Bundle r10 = this.f14724.mo16023(3, this.f14723.getPackageName(), str, bundle);
                if (r10 == null) {
                    C0895.m15616("BillingClient", "querySkuDetailsAsync got null sku details list");
                    return new C0924.C0925(4, null);
                } else if (!r10.containsKey("DETAILS_LIST")) {
                    int r11 = C0895.m15618(r10, "BillingClient");
                    if (r11 != 0) {
                        C0895.m15616("BillingClient", "getSkuDetails() failed. Response code: " + r11);
                        return new C0924.C0925(r11, arrayList);
                    }
                    C0895.m15616("BillingClient", "getSkuDetails() returned a bundle with neither an error nor a detail list.");
                    return new C0924.C0925(6, arrayList);
                } else {
                    ArrayList<String> stringArrayList = r10.getStringArrayList("DETAILS_LIST");
                    if (stringArrayList == null) {
                        C0895.m15616("BillingClient", "querySkuDetailsAsync got null response list");
                        return new C0924.C0925(4, null);
                    }
                    for (int i3 = 0; i3 < stringArrayList.size(); i3++) {
                        try {
                            C0924 r14 = new C0924(stringArrayList.get(i3));
                            C0895.m15619("BillingClient", "Got sku details: " + r14);
                            arrayList.add(r14);
                        } catch (JSONException e) {
                            C0895.m15616("BillingClient", "Got a JSON exception trying to decode SkuDetails");
                            return new C0924.C0925(6, null);
                        }
                    }
                }
            } catch (RemoteException e2) {
                C0895.m15616("BillingClient", "querySkuDetailsAsync got a remote exception (try to reconnect): " + e2);
                return new C0924.C0925(-1, null);
            }
        }
        return new C0924.C0925(0, arrayList);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private C0738.C0739 m15566(String str, boolean z) {
        Bundle bundle;
        C0895.m15619("BillingClient", "Querying owned items, item type: " + str + "; history: " + z);
        String str2 = null;
        ArrayList arrayList = new ArrayList();
        do {
            if (z) {
                try {
                    if (!this.f14728) {
                        C0895.m15616("BillingClient", "getPurchaseHistory is not supported on current device");
                        return new C0738.C0739(-2, null);
                    }
                    bundle = this.f14724.mo16020(6, this.f14723.getPackageName(), str, str2, (Bundle) null);
                } catch (RemoteException e) {
                    C0895.m15616("BillingClient", "Got exception trying to get purchases: " + e + "; try to reconnect");
                    return new C0738.C0739(-1, null);
                }
            } else {
                bundle = this.f14724.mo16025(3, this.f14723.getPackageName(), str, str2);
            }
            if (bundle == null) {
                C0895.m15616("BillingClient", "queryPurchases got null owned items list");
                return new C0738.C0739(6, null);
            }
            int r9 = C0895.m15618(bundle, "BillingClient");
            if (r9 != 0) {
                C0895.m15616("BillingClient", "getPurchases() failed. Response code: " + r9);
                return new C0738.C0739(r9, null);
            } else if (!bundle.containsKey("INAPP_PURCHASE_ITEM_LIST") || !bundle.containsKey("INAPP_PURCHASE_DATA_LIST") || !bundle.containsKey("INAPP_DATA_SIGNATURE_LIST")) {
                C0895.m15616("BillingClient", "Bundle returned from getPurchases() doesn't contain required fields.");
                return new C0738.C0739(6, null);
            } else {
                ArrayList<String> stringArrayList = bundle.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
                ArrayList<String> stringArrayList2 = bundle.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                ArrayList<String> stringArrayList3 = bundle.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
                if (stringArrayList == null) {
                    C0895.m15616("BillingClient", "Bundle returned from getPurchases() contains null SKUs list.");
                    return new C0738.C0739(6, null);
                } else if (stringArrayList2 == null) {
                    C0895.m15616("BillingClient", "Bundle returned from getPurchases() contains null purchases list.");
                    return new C0738.C0739(6, null);
                } else if (stringArrayList3 == null) {
                    C0895.m15616("BillingClient", "Bundle returned from getPurchases() contains null signatures list.");
                    return new C0738.C0739(6, null);
                } else {
                    for (int i = 0; i < stringArrayList2.size(); i++) {
                        String str3 = stringArrayList2.get(i);
                        String str4 = stringArrayList3.get(i);
                        C0895.m15619("BillingClient", "Sku is owned: " + stringArrayList.get(i));
                        try {
                            C0738 r0 = new C0738(str3, str4);
                            if (TextUtils.isEmpty(r0.m15117())) {
                                C0895.m15616("BillingClient", "BUG: empty/null token!");
                            }
                            arrayList.add(r0);
                        } catch (JSONException e2) {
                            C0895.m15616("BillingClient", "Got an exception trying to decode the purchase: " + e2);
                            return new C0738.C0739(6, null);
                        }
                    }
                    str2 = bundle.getString("INAPP_CONTINUATION_TOKEN");
                    C0895.m15619("BillingClient", "Continuation token: " + str2);
                }
            }
        } while (!TextUtils.isEmpty(str2));
        return new C0738.C0739(0, arrayList);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱ  reason: contains not printable characters */
    private void m15570(Runnable runnable) {
        this.f14725.post(runnable);
    }

    /* renamed from: o.ᔊ$ˊ  reason: contains not printable characters */
    final class ServiceConnectionC0867 implements ServiceConnection {

        /* renamed from: ˋ  reason: contains not printable characters */
        private final AbstractC0865 f14736;

        private ServiceConnectionC0867(AbstractC0865 r4) {
            if (r4 == null) {
                throw new RuntimeException("Please specify a listener to know when init is done.");
            }
            this.f14736 = r4;
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            C0895.m15616("BillingClient", "Billing service disconnected.");
            C0866.this.f14724 = null;
            C0866.this.f14726 = 0;
            this.f14736.onBillingServiceDisconnected();
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            C0895.m15619("BillingClient", "Billing service connected.");
            C0866.this.f14724 = AbstractC1028.AbstractBinderC1029.m16028(iBinder);
            String packageName = C0866.this.f14723.getPackageName();
            C0866.this.f14727 = false;
            C0866.this.f14720 = false;
            C0866.this.f14728 = false;
            try {
                int r4 = C0866.this.f14724.mo16022(6, packageName, "subs");
                if (r4 == 0) {
                    C0895.m15619("BillingClient", "In-app billing API version 6 with subs is supported.");
                    C0866.this.f14728 = true;
                    C0866.this.f14727 = true;
                    C0866.this.f14720 = true;
                } else {
                    if (C0866.this.f14724.mo16022(6, packageName, "inapp") == 0) {
                        C0895.m15619("BillingClient", "In-app billing API without subs version 6 supported.");
                        C0866.this.f14728 = true;
                    }
                    r4 = C0866.this.f14724.mo16022(5, packageName, "subs");
                    if (r4 == 0) {
                        C0895.m15619("BillingClient", "In-app billing API version 5 supported.");
                        C0866.this.f14720 = true;
                        C0866.this.f14727 = true;
                    } else {
                        r4 = C0866.this.f14724.mo16022(3, packageName, "subs");
                        if (r4 == 0) {
                            C0895.m15619("BillingClient", "In-app billing API version 3 with subscriptions is supported.");
                            C0866.this.f14727 = true;
                        } else if (C0866.this.f14728) {
                            r4 = 0;
                        } else {
                            r4 = C0866.this.f14724.mo16022(3, packageName, "inapp");
                            if (r4 == 0) {
                                C0895.m15619("BillingClient", "In-app billing API version 3 with in-app items is supported.");
                            } else {
                                C0895.m15616("BillingClient", "Even billing API version 3 is not supported on this device.");
                            }
                        }
                    }
                }
                if (r4 == 0) {
                    C0866.this.f14726 = 2;
                } else {
                    C0866.this.f14726 = 0;
                    C0866.this.f14724 = null;
                }
                this.f14736.onBillingSetupFinished(r4);
            } catch (RemoteException e) {
                C0895.m15616("BillingClient", "RemoteException while setting up in-app billing" + e);
                C0866.this.f14726 = 0;
                C0866.this.f14724 = null;
                this.f14736.onBillingSetupFinished(-1);
            }
        }
    }
}
