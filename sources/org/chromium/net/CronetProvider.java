package org.chromium.net;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import org.chromium.net.CronetEngine;
public abstract class CronetProvider {
    private static final String TAG = CronetProvider.class.getSimpleName();
    protected final Context mContext;

    public abstract CronetEngine.Builder createBuilder();

    public abstract String getName();

    public abstract String getVersion();

    public abstract boolean isEnabled();

    protected CronetProvider(Context context) {
        this.mContext = context;
    }

    public String toString() {
        return "[class=" + getClass().getName() + ", name=" + getName() + ", version=" + getVersion() + ", enabled=" + isEnabled() + "]";
    }

    public static List<CronetProvider> getAllProviders(Context context) {
        ArrayList arrayList = new ArrayList();
        addCronetProviderFromResourceFile(context, arrayList);
        addCronetProviderImplByClassName(context, "org.chromium.net.impl.NativeCronetProvider", arrayList, false);
        addCronetProviderImplByClassName(context, "org.chromium.net.impl.JavaCronetProvider", arrayList, false);
        return arrayList;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: java.util.List<org.chromium.net.CronetProvider> */
    /* JADX WARN: Multi-variable type inference failed */
    private static boolean addCronetProviderImplByClassName(Context context, String str, List<CronetProvider> list, boolean z) {
        try {
            list.add(context.getClassLoader().loadClass(str).asSubclass(CronetProvider.class).getConstructor(Context.class).newInstance(context));
            return true;
        } catch (InstantiationException e) {
            logReflectiveOperationException(str, z, e);
            return false;
        } catch (InvocationTargetException e2) {
            logReflectiveOperationException(str, z, e2);
            return false;
        } catch (NoSuchMethodException e3) {
            logReflectiveOperationException(str, z, e3);
            return false;
        } catch (IllegalAccessException e4) {
            logReflectiveOperationException(str, z, e4);
            return false;
        } catch (ClassNotFoundException e5) {
            logReflectiveOperationException(str, z, e5);
            return false;
        }
    }

    private static void logReflectiveOperationException(String str, boolean z, Exception exc) {
        if (z) {
            Log.e(TAG, "Unable to load provider class: " + str, exc);
        } else {
            Log.d(TAG, "Tried to load " + str + " provider class but it wasn't included in the app classpath");
        }
    }

    private static boolean addCronetProviderFromResourceFile(Context context, List<CronetProvider> list) {
        int identifier = context.getResources().getIdentifier("CronetProviderClassName", "string", context.getPackageName());
        if (identifier == 0) {
            return false;
        }
        String string = context.getResources().getString(identifier);
        if (addCronetProviderImplByClassName(context, string, list, true)) {
            return true;
        }
        throw new RuntimeException("Unable to instantiate Cronet implementation class " + string + " that is listed as in the app string resource file under CronetProviderClassName key");
    }
}
