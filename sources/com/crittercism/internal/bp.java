package com.crittercism.internal;

import android.app.Activity;
import android.app.Application;
import com.crittercism.internal.at;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;
public final class bp extends bn {
    private ExecutorService b;
    private av<at> c;
    private ap d;

    public bp(Application application, ExecutorService executorService, av<at> avVar, ap apVar) {
        super(application);
        this.b = executorService;
        this.c = avVar;
        this.d = apVar;
        a();
    }

    @Override // com.crittercism.internal.bn
    public final void b() {
        this.b.submit(new Runnable() { // from class: com.crittercism.internal.bp.1
            @Override // java.lang.Runnable
            public final void run() {
                if (((Boolean) bp.this.d.a(ap.C)).booleanValue()) {
                    av avVar = bp.this.c;
                    HashMap hashMap = new HashMap();
                    hashMap.put("event", "foregrounded");
                    avVar.a((av) new at(at.b.d, new JSONObject(hashMap)));
                }
            }
        });
    }

    @Override // com.crittercism.internal.bn
    public final void c() {
        this.b.submit(new Runnable() { // from class: com.crittercism.internal.bp.2
            @Override // java.lang.Runnable
            public final void run() {
                if (((Boolean) bp.this.d.a(ap.C)).booleanValue()) {
                    av avVar = bp.this.c;
                    HashMap hashMap = new HashMap();
                    hashMap.put("event", "backgrounded");
                    avVar.a((av) new at(at.b.d, new JSONObject(hashMap)));
                }
            }
        });
    }

    @Override // com.crittercism.internal.bn
    public final void a(final Activity activity) {
        this.b.submit(new Runnable() { // from class: com.crittercism.internal.bp.3
            @Override // java.lang.Runnable
            public final void run() {
                if (((Boolean) bp.this.d.a(ap.D)).booleanValue()) {
                    String name = activity.getClass().getName();
                    int i = at.d.a;
                    HashMap hashMap = new HashMap();
                    hashMap.put("event", Integer.valueOf(i - 1));
                    hashMap.put("viewName", name);
                    bp.this.c.a((av) new at(at.b.f, new JSONObject(hashMap)));
                }
            }
        });
    }
}
