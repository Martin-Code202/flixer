package com.crittercism.internal;

import android.util.Log;
import com.crittercism.app.Crittercism;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
public final class cf {
    public static int a = a.a;
    private static b b = b.Info;
    private static cf c = new cf();

    /* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
    public static final class a extends Enum<a> {
        public static final int a = 1;
        public static final int b = 2;
        public static final int c = 3;
        private static final /* synthetic */ int[] d = {a, b, c};
    }

    public enum b {
        Silent(0),
        Error(100),
        Warning(200),
        Info(300),
        Debug(400),
        Verbose(500);
        
        private int g;

        private b(int i) {
            this.g = i;
        }

        public final boolean a(b bVar) {
            return this.g >= bVar.g;
        }

        public static b a(Crittercism.LoggingLevel loggingLevel) {
            switch (loggingLevel) {
                case Silent:
                    return Silent;
                case Error:
                    return Error;
                case Warning:
                    return Warning;
                case Info:
                    return Info;
                default:
                    return Warning;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.crittercism.internal.cf$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[b.values().length];

        static {
            b = new int[Crittercism.LoggingLevel.values().length];
            try {
                b[Crittercism.LoggingLevel.Silent.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[Crittercism.LoggingLevel.Error.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[Crittercism.LoggingLevel.Warning.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[Crittercism.LoggingLevel.Info.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[b.Silent.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[b.Error.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[b.Warning.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static void a(Crittercism.LoggingLevel loggingLevel) {
        b = b.a(loggingLevel);
    }

    public static void a(String str) {
        if (b.a(b.Error)) {
            Log.e("Crittercism", str);
        }
    }

    public static void a(String str, Throwable th) {
        if (b.a(b.Error)) {
            Log.e("Crittercism", str, th);
        }
    }

    public static void b(String str) {
        if (b.a(b.Warning)) {
            Log.w("Crittercism", str);
        }
    }

    public static void b(String str, Throwable th) {
        if (b.a(b.Warning)) {
            Log.w("Crittercism", str, th);
        }
    }

    public static void c(String str) {
        if (b.a(b.Info)) {
            Log.i("Crittercism", str);
        }
    }

    public static void d(String str) {
        if (b.a(b.Debug)) {
            Log.d("Crittercism", str);
        }
    }

    public static void c(String str, Throwable th) {
        if (b.a(b.Debug)) {
            Log.d("Crittercism", str, th);
        }
    }

    public static void a(Throwable th) {
        if (b.a(b.Debug)) {
            Log.d("Crittercism", th.getMessage(), th);
        }
    }

    public static void a(bt btVar) {
        if (b.a(b.Debug)) {
            d(" ");
            d("----- BEGIN HTTP REQUEST ----- ");
            d(btVar.b + " " + btVar.a.toExternalForm() + " HTTP/1.1");
            String str = new String(btVar.c);
            try {
                Object nextValue = new JSONTokener(str).nextValue();
                if (nextValue instanceof JSONObject) {
                    d(((JSONObject) nextValue).toString(4));
                } else if (nextValue instanceof JSONArray) {
                    d(((JSONArray) nextValue).toString(4));
                } else {
                    d(str);
                }
            } catch (JSONException unused) {
                d(str);
            }
            d("-----  END HTTP REQUEST  ----- ");
            d(" ");
        }
    }

    public static void a(URL url, bv bvVar) {
        if (b.a(b.Debug)) {
            d(" ");
            d("----- BEGIN HTTP RESPONSE ----- ");
            d(bvVar.a + " " + url.toExternalForm());
            d(" ");
            if (bvVar.b != null) {
                String str = new String(bvVar.b);
                try {
                    Object nextValue = new JSONTokener(str).nextValue();
                    if (nextValue instanceof JSONObject) {
                        d("Response: " + ((JSONObject) nextValue).toString(4));
                    } else if (nextValue instanceof JSONArray) {
                        d("Response: " + ((JSONArray) nextValue).toString(4));
                    } else {
                        d("Response: " + str);
                    }
                } catch (JSONException unused) {
                    d("Response: " + str);
                }
            } else if (bvVar.c != null) {
                a(bvVar.c);
            } else {
                d("Response: null");
            }
            d("-----  END HTTP RESPONSE  ----- ");
            d(" ");
        }
    }

    public static void b(Throwable th) {
        try {
            a(th);
        } catch (ThreadDeath e) {
            throw e;
        } catch (Throwable unused) {
        }
    }
}
