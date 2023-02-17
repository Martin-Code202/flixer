package com.crittercism.app;

import android.app.Activity;
import android.app.Application;
import android.app.Service;
import android.content.Context;
import android.os.Build;
import com.crittercism.internal.am;
import com.crittercism.internal.ao;
import com.crittercism.internal.as;
import com.crittercism.internal.at;
import com.crittercism.internal.cf;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
public class Crittercism {
    private static volatile am a = null;
    private static final List<CrittercismCallback<CrashData>> b = new ArrayList();

    public enum LoggingLevel {
        Silent,
        Error,
        Warning,
        Info
    }

    private Crittercism() {
    }

    public static synchronized void initialize(Context context, String str, CrittercismConfig crittercismConfig) {
        Application application;
        synchronized (Crittercism.class) {
            try {
                cf.c("Initializing Crittercism 5.8.7 for App ID " + str);
                if (context == null) {
                    cf.b("Crittercism.initialize() given a null context parameter");
                    return;
                }
                if (context instanceof Application) {
                    application = (Application) context;
                } else if (context instanceof Activity) {
                    application = ((Activity) context).getApplication();
                } else if (context instanceof Service) {
                    application = ((Service) context).getApplication();
                } else if (context.getApplicationContext() instanceof Application) {
                    application = (Application) context.getApplicationContext();
                } else {
                    application = null;
                }
                if (application == null) {
                    cf.b("Crittercism.initialize() expects the input Context to be an instanceof Application. Received '" + context.getClass().getName() + "'. Crittercism will no be initialized.");
                    return;
                } else if (str == null) {
                    cf.b("Crittercism.initialize() given a null appID parameter");
                    return;
                } else if (crittercismConfig == null) {
                    cf.b("Crittercism.initialize() given a null CrittercismConfiguration. Crittercism will not be initialized");
                    return;
                } else if (Build.VERSION.SDK_INT < 14) {
                    cf.b("Crittercism is not supported for Android API less than 14 (ICS). Crittercism will not be enabled");
                    return;
                } else if (!ao.a(application, "android.permission.INTERNET")) {
                    cf.a("Crittercism requires INTERNET permission. Please add android.permission.INTERNET to your AndroidManifest.xml. Crittercism will not be initialized.");
                    return;
                } else if (crittercismConfig.allowsCellularAccess() || ao.a(application, "android.permission.ACCESS_NETWORK_STATE")) {
                    try {
                        new as(str);
                        synchronized (Crittercism.class) {
                            if (a != null) {
                                cf.b("Crittercism has already been initialized. Subsequent calls to initialize() are ignored.");
                                return;
                            }
                            long currentTimeMillis = System.currentTimeMillis();
                            a = new am(application, str, crittercismConfig);
                            cf.d("Crittercism initialized in " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
                        }
                    } catch (IllegalArgumentException e) {
                        cf.a("Crittercism.initialize() given an invalid app ID '" + str + "': " + e.getMessage());
                        return;
                    }
                } else {
                    cf.a("Crittercism requires adding android.permission.ACCESS_NETWORK_STATE to your AndroidManifest.xml when setting CrittercismConfig.setAllowsCellularAccess(false). Crittercism will not be initialized.");
                    return;
                }
            } catch (ThreadDeath e2) {
                throw e2;
            } catch (Throwable th) {
                cf.b(th);
                return;
            }
        }
        synchronized (b) {
            for (CrittercismCallback<CrashData> crittercismCallback : b) {
                a.a(crittercismCallback);
            }
            b.clear();
        }
    }

    public static void logHandledException(Throwable th) {
        if (a == null) {
            a("logHandledException");
        } else if (th == null) {
            cf.b("Invalid input to Crittercism.logHandledException(): null exception parameter");
        } else {
            try {
                a.a(th);
            } catch (ThreadDeath e) {
                throw e;
            } catch (Throwable th2) {
                cf.b(th2);
            }
        }
    }

    public static void setMetadata(JSONObject jSONObject) {
        if (a == null) {
            a("setMetadata");
        } else if (jSONObject == null) {
            cf.b("Invalid input to Crittercism.setMetadata(): null metadata parameter");
        } else {
            try {
                a.a(jSONObject);
            } catch (ThreadDeath e) {
                throw e;
            } catch (Throwable th) {
                cf.b(th);
            }
        }
    }

    public static void setUsername(String str) {
        if (a == null) {
            a("setUsername");
        } else if (str == null) {
            cf.b("Crittercism.setUsername() given invalid parameter: null");
        } else {
            try {
                a.a(new JSONObject().put("username", str));
            } catch (JSONException e) {
                cf.b("Crittercism.setUsername()", e);
            } catch (ThreadDeath e2) {
                throw e2;
            } catch (Throwable th) {
                cf.b(th);
            }
        }
    }

    public static void leaveBreadcrumb(String str) {
        if (a == null) {
            a("leaveBreadcrumb");
        } else if (str == null) {
            cf.b("Cannot leave null breadcrumb", new NullPointerException());
        } else {
            try {
                a.a(at.a(str));
            } catch (ThreadDeath e) {
                throw e;
            } catch (Throwable th) {
                cf.b(th);
            }
        }
    }

    public static void beginUserflow(String str) {
        if (a == null) {
            a("beginUserflow");
        } else if (str == null) {
            cf.b("Invalid input to beginUserflow(): null userflow name");
        } else {
            try {
                a.a(str);
            } catch (ThreadDeath e) {
                throw e;
            } catch (Throwable th) {
                cf.b(th);
            }
        }
    }

    public static void setLoggingLevel(LoggingLevel loggingLevel) {
        try {
            cf.a(loggingLevel);
        } catch (ThreadDeath e) {
            throw e;
        } catch (Throwable th) {
            cf.b(th);
        }
    }

    private static void a(String str) {
        cf.b("Must initialize Crittercism before calling " + Crittercism.class.getName() + "." + str + "(). Request is being ignored...", new IllegalStateException());
    }
}
