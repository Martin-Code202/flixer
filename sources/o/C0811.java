package o;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import com.netflix.mediaclient.service.logging.client.model.Event;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
/* renamed from: o.ᒻ  reason: contains not printable characters */
class C0811 {

    /* renamed from: ʻ  reason: contains not printable characters */
    private static final Object f14543 = new Object();

    /* renamed from: ʼ  reason: contains not printable characters */
    private static C0811 f14544;

    /* renamed from: ˊ  reason: contains not printable characters */
    private final Handler f14545;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final HashMap<BroadcastReceiver, ArrayList<IntentFilter>> f14546 = new HashMap<>();

    /* renamed from: ˎ  reason: contains not printable characters */
    private final ArrayList<iF> f14547 = new ArrayList<>();

    /* renamed from: ˏ  reason: contains not printable characters */
    private final HashMap<String, ArrayList<C0812>> f14548 = new HashMap<>();

    /* renamed from: ॱ  reason: contains not printable characters */
    private final Context f14549;

    /* access modifiers changed from: package-private */
    /* renamed from: o.ᒻ$ˋ  reason: contains not printable characters */
    public static class C0812 {

        /* renamed from: ˋ  reason: contains not printable characters */
        final BroadcastReceiver f14553;

        /* renamed from: ˎ  reason: contains not printable characters */
        final IntentFilter f14554;

        /* renamed from: ॱ  reason: contains not printable characters */
        boolean f14555;

        C0812(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
            this.f14554 = intentFilter;
            this.f14553 = broadcastReceiver;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(128);
            sb.append("Receiver{");
            sb.append(this.f14553);
            sb.append(" filter=");
            sb.append(this.f14554);
            sb.append("}");
            return sb.toString();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.ᒻ$iF */
    public static class iF {

        /* renamed from: ˊ  reason: contains not printable characters */
        final Intent f14551;

        /* renamed from: ˏ  reason: contains not printable characters */
        final ArrayList<C0812> f14552;

        iF(Intent intent, ArrayList<C0812> arrayList) {
            this.f14551 = intent;
            this.f14552 = arrayList;
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static C0811 m15374(Context context) {
        C0811 r0;
        synchronized (f14543) {
            if (f14544 == null) {
                f14544 = new C0811(context.getApplicationContext());
            }
            r0 = f14544;
        }
        return r0;
    }

    private C0811(Context context) {
        this.f14549 = context;
        this.f14545 = new Handler(context.getMainLooper()) { // from class: o.ᒻ.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        C0811.this.m15376();
                        return;
                    default:
                        super.handleMessage(message);
                        return;
                }
            }
        };
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m15378(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.f14546) {
            C0812 r2 = new C0812(intentFilter, broadcastReceiver);
            ArrayList<IntentFilter> arrayList = this.f14546.get(broadcastReceiver);
            if (arrayList == null) {
                arrayList = new ArrayList<>(1);
                this.f14546.put(broadcastReceiver, arrayList);
            }
            arrayList.add(intentFilter);
            for (int i = 0; i < intentFilter.countActions(); i++) {
                String action = intentFilter.getAction(i);
                ArrayList<C0812> arrayList2 = this.f14548.get(action);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList<>(1);
                    this.f14548.put(action, arrayList2);
                }
                arrayList2.add(r2);
            }
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public boolean m15377(Intent intent) {
        String str;
        synchronized (this.f14546) {
            String action = intent.getAction();
            String resolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.f14549.getContentResolver());
            Uri data = intent.getData();
            String scheme = intent.getScheme();
            Set<String> categories = intent.getCategories();
            boolean z = (intent.getFlags() & 8) != 0;
            if (z) {
                Log.v("LocalBroadcastManager", "Resolving type " + resolveTypeIfNeeded + " scheme " + scheme + " of intent " + intent);
            }
            ArrayList<C0812> arrayList = this.f14548.get(intent.getAction());
            if (arrayList != null) {
                if (z) {
                    Log.v("LocalBroadcastManager", "Action list: " + arrayList);
                }
                ArrayList arrayList2 = null;
                for (int i = 0; i < arrayList.size(); i++) {
                    C0812 r17 = arrayList.get(i);
                    if (z) {
                        Log.v("LocalBroadcastManager", "Matching against filter " + r17.f14554);
                    }
                    if (!r17.f14555) {
                        int match = r17.f14554.match(action, resolveTypeIfNeeded, scheme, data, categories, "LocalBroadcastManager");
                        if (match >= 0) {
                            if (z) {
                                Log.v("LocalBroadcastManager", "  Filter matched!  match=0x" + Integer.toHexString(match));
                            }
                            if (arrayList2 == null) {
                                arrayList2 = new ArrayList();
                            }
                            arrayList2.add(r17);
                            r17.f14555 = true;
                        } else if (z) {
                            switch (match) {
                                case -4:
                                    str = "category";
                                    break;
                                case -3:
                                    str = "action";
                                    break;
                                case PagerAdapter.POSITION_NONE /* -2 */:
                                    str = Event.DATA;
                                    break;
                                case -1:
                                    str = "type";
                                    break;
                                default:
                                    str = "unknown reason";
                                    break;
                            }
                            Log.v("LocalBroadcastManager", "  Filter did not match: " + str);
                        }
                    } else if (z) {
                        Log.v("LocalBroadcastManager", "  Filter's target already added");
                    }
                }
                if (arrayList2 != null) {
                    for (int i2 = 0; i2 < arrayList2.size(); i2++) {
                        ((C0812) arrayList2.get(i2)).f14555 = false;
                    }
                    this.f14547.add(new iF(intent, arrayList2));
                    if (!this.f14545.hasMessages(1)) {
                        this.f14545.sendEmptyMessage(1);
                    }
                    return true;
                }
            }
            return false;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˏ  reason: contains not printable characters */
    private void m15376() {
        iF[] iFVarArr;
        while (true) {
            synchronized (this.f14546) {
                int size = this.f14547.size();
                if (size > 0) {
                    iFVarArr = new iF[size];
                    this.f14547.toArray(iFVarArr);
                    this.f14547.clear();
                } else {
                    return;
                }
            }
            for (iF iFVar : iFVarArr) {
                for (int i = 0; i < iFVar.f14552.size(); i++) {
                    iFVar.f14552.get(i).f14553.onReceive(this.f14549, iFVar.f14551);
                }
            }
        }
    }
}
