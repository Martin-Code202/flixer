package com.crittercism.internal;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Iterator;
import java.util.LinkedList;
public final class ap {
    public static final d A = new d("reporter.userflow.frequency", 20000L);
    public static final b B = new b("data.userflow.rate", Float.valueOf(1.0f));
    public static final a C = new a("data.breadcrumb.foreground.enabled", true);
    public static final a D = new a("data.breadcrumb.activity.enabled", true);
    public static final a E = new a("data.breadcrumb.networkstate.enabled", true);
    public static final a F = new a("data.breadcrumb.networkstats.enabled", true);
    public static final a G = new a("data.breadcrumb.exception.enabled", true);
    public static final d H = new d("userflow.defaultTimeoutMs", 3600000L);
    public static final a a = new a("data.apm.enabled", true);
    public static final a b = new a("reporter.apm.enabled", false);
    public static final d c = new d("reporter.apm.frequency", 20000L);
    public static final b d = new b("data.apm.rate", Float.valueOf(1.0f));
    public static final a e = new a("data.crash.enabled", true);
    public static final a f = new a("reporter.crash.enabled", true);
    public static final d g = new d("reporter.crash.frequency", 0L);
    public static final b h = new b("data.crash.rate", Float.valueOf(1.0f));
    public static final a i = new a("data.he.enabled", true);
    public static final a j = new a("reporter.he.enabled", true);
    public static final d k = new d("reporter.he.frequency", 60000L);
    public static final b l = new b("data.he.rate", Float.valueOf(1.0f));
    public static final a m = new a("data.ndk.enabled", true);
    public static final a n = new a("reporter.ndk.enabled", true);

    /* renamed from: o  reason: collision with root package name */
    public static final d f16012o = new d("reporter.ndk.frequency", 10000L);
    public static final b p = new b("data.ndk.rate", Float.valueOf(1.0f));
    public static final a q = new a("data.metadata.enabled", true);
    public static final a r = new a("reporter.metadata.enabled", true);
    public static final d s = new d("reporter.metadata.frequency", 10000L);
    public static final b t = new b("data.metadata.rate", Float.valueOf(1.0f));
    public static final a u = new a("data.appload.enabled", true);
    public static final a v = new a("reporter.appload.enabled", true);
    public static final d w = new d("reporter.appload.frequency", 10000L);
    public static final b x = new b("data.appload.rate", Float.valueOf(1.0f));
    public static final a y = new a("data.userflow.enabled", true);
    public static final a z = new a("reporter.userflow.enabled", false);
    public final LinkedList<c> I = new LinkedList<>();
    private String J;
    private Context K;
    private SharedPreferences L;

    public interface c {
        void a(ap apVar, String str);
    }

    public static d a(String str, long j2) {
        return new d("userflow.timeouts." + str, Long.valueOf(j2));
    }

    public ap(Context context, String str) {
        this.J = str;
        this.K = context;
    }

    private SharedPreferences a() {
        if (this.L == null) {
            this.L = this.K.getSharedPreferences("com.crittercism.settings." + this.J, 0);
        }
        return this.L;
    }

    public final <T> T a(e<T> eVar) {
        return eVar.a(a());
    }

    public final <T> void a(e<T> eVar, T t2) {
        eVar.a(a(), t2);
        Iterator<c> it = this.I.iterator();
        while (it.hasNext()) {
            it.next().a(this, eVar.a);
        }
    }

    public final void b(String str, long j2) {
        a((e<d>) a(str, j2), (d) Long.valueOf(j2));
    }

    public static abstract class e<T> {
        protected String a;
        protected T b;

        public abstract T a(SharedPreferences sharedPreferences);

        public abstract void a(SharedPreferences sharedPreferences, T t);

        public e(String str, T t) {
            this.a = str;
            this.b = t;
        }

        public final String a() {
            return this.a;
        }

        public final T b() {
            return this.b;
        }
    }

    public static class a extends e<Boolean> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.crittercism.internal.ap.e
        public final /* synthetic */ Boolean a(SharedPreferences sharedPreferences) {
            return Boolean.valueOf(sharedPreferences.getBoolean(this.a, ((Boolean) this.b).booleanValue()));
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.SharedPreferences, java.lang.Object] */
        @Override // com.crittercism.internal.ap.e
        public final /* synthetic */ void a(SharedPreferences sharedPreferences, Boolean bool) {
            sharedPreferences.edit().putBoolean(this.a, bool.booleanValue()).commit();
        }

        public a(String str, Boolean bool) {
            super(str, bool);
        }
    }

    public static class d extends e<Long> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.crittercism.internal.ap.e
        public final /* synthetic */ Long a(SharedPreferences sharedPreferences) {
            return Long.valueOf(sharedPreferences.getLong(this.a, ((Long) this.b).longValue()));
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.SharedPreferences, java.lang.Object] */
        @Override // com.crittercism.internal.ap.e
        public final /* synthetic */ void a(SharedPreferences sharedPreferences, Long l) {
            sharedPreferences.edit().putLong(this.a, l.longValue()).commit();
        }

        public d(String str, Long l) {
            super(str, l);
        }
    }

    public static class b extends e<Float> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.crittercism.internal.ap.e
        public final /* synthetic */ Float a(SharedPreferences sharedPreferences) {
            return Float.valueOf(sharedPreferences.getFloat(this.a, ((Float) this.b).floatValue()));
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.SharedPreferences, java.lang.Object] */
        @Override // com.crittercism.internal.ap.e
        public final /* synthetic */ void a(SharedPreferences sharedPreferences, Float f) {
            sharedPreferences.edit().putFloat(this.a, f.floatValue()).commit();
        }

        public b(String str, Float f) {
            super(str, f);
        }
    }
}
