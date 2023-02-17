package android.support.v4.graphics;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.support.v4.content.res.FontResourcesParserCompat;
import android.util.Log;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
public class TypefaceCompatApi26Impl extends TypefaceCompatApi21Impl {
    private static final Method sAbortCreation;
    private static final Method sAddFontFromAssetManager;
    private static final Method sAddFontFromBuffer;
    private static final Method sCreateFromFamiliesWithDefault;
    private static final Class sFontFamily;
    private static final Constructor sFontFamilyCtor;
    private static final Method sFreeze;

    static {
        Method method;
        Method method2;
        Method method3;
        Method method4;
        Method method5;
        Constructor<?> constructor;
        Class<?> cls;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            constructor = cls.getConstructor(new Class[0]);
            method5 = cls.getMethod("addFontFromAssetManager", AssetManager.class, String.class, Integer.TYPE, Boolean.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, FontVariationAxis[].class);
            method4 = cls.getMethod("addFontFromBuffer", ByteBuffer.class, Integer.TYPE, FontVariationAxis[].class, Integer.TYPE, Integer.TYPE);
            method3 = cls.getMethod("freeze", new Class[0]);
            method2 = cls.getMethod("abortCreation", new Class[0]);
            method = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass(), Integer.TYPE, Integer.TYPE);
            method.setAccessible(true);
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            Log.e("TypefaceCompatApi26Impl", "Unable to collect necessary methods for class " + e.getClass().getName(), e);
            cls = null;
            constructor = null;
            method5 = null;
            method4 = null;
            method3 = null;
            method2 = null;
            method = null;
        }
        sFontFamilyCtor = constructor;
        sFontFamily = cls;
        sAddFontFromAssetManager = method5;
        sAddFontFromBuffer = method4;
        sFreeze = method3;
        sAbortCreation = method2;
        sCreateFromFamiliesWithDefault = method;
    }

    private static boolean isFontFamilyPrivateAPIAvailable() {
        if (sAddFontFromAssetManager == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        return sAddFontFromAssetManager != null;
    }

    private static Object newFamily() {
        try {
            return sFontFamilyCtor.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean addFontFromAssetManager(Context context, Object obj, String str, int i, int i2, int i3) {
        try {
            return ((Boolean) sAddFontFromAssetManager.invoke(obj, context.getAssets(), str, 0, false, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), null)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean addFontFromBuffer(Object obj, ByteBuffer byteBuffer, int i, int i2, int i3) {
        try {
            return ((Boolean) sAddFontFromBuffer.invoke(obj, byteBuffer, Integer.valueOf(i), null, Integer.valueOf(i2), Integer.valueOf(i3))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private static Typeface createFromFamiliesWithDefault(Object obj) {
        try {
            Object newInstance = Array.newInstance(sFontFamily, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) sCreateFromFamiliesWithDefault.invoke(null, newInstance, -1, -1);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean freeze(Object obj) {
        try {
            return ((Boolean) sFreeze.invoke(obj, new Object[0])).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private static void abortCreation(Object obj) {
        try {
            sAbortCreation.invoke(obj, new Object[0]);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // android.support.v4.graphics.TypefaceCompatBaseImpl, android.support.v4.graphics.TypefaceCompat.TypefaceCompatImpl
    public Typeface createFromFontFamilyFilesResourceEntry(Context context, FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, Resources resources, int i) {
        if (!isFontFamilyPrivateAPIAvailable()) {
            return super.createFromFontFamilyFilesResourceEntry(context, fontFamilyFilesResourceEntry, resources, i);
        }
        Object newFamily = newFamily();
        FontResourcesParserCompat.FontFileResourceEntry[] entries = fontFamilyFilesResourceEntry.getEntries();
        for (FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry : entries) {
            if (!addFontFromAssetManager(context, newFamily, fontFileResourceEntry.getFileName(), 0, fontFileResourceEntry.getWeight(), fontFileResourceEntry.isItalic() ? 1 : 0)) {
                abortCreation(newFamily);
                return null;
            }
        }
        if (!freeze(newFamily)) {
            return null;
        }
        return createFromFamiliesWithDefault(newFamily);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0052, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0053, code lost:
        if (r5 != null) goto L_0x0055;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0055, code lost:
        if (r7 != null) goto L_0x0057;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x005b, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x005c, code lost:
        r7.addSuppressed(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0060, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0063, code lost:
        throw r9;
     */
    @Override // android.support.v4.graphics.TypefaceCompatApi21Impl, android.support.v4.graphics.TypefaceCompatBaseImpl, android.support.v4.graphics.TypefaceCompat.TypefaceCompatImpl
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.graphics.Typeface createFromFontInfo(android.content.Context r13, android.os.CancellationSignal r14, android.support.v4.provider.FontsContractCompat.FontInfo[] r15, int r16) {
        /*
            r12 = this;
            int r0 = r15.length
            r1 = 1
            if (r0 >= r1) goto L_0x0006
            r0 = 0
            return r0
        L_0x0006:
            boolean r0 = isFontFamilyPrivateAPIAvailable()
            if (r0 != 0) goto L_0x0067
            r0 = r16
            android.support.v4.provider.FontsContractCompat$FontInfo r3 = r12.findBestInfo(r15, r0)
            android.content.ContentResolver r4 = r13.getContentResolver()
            android.net.Uri r0 = r3.getUri()     // Catch:{ IOException -> 0x0064 }
            java.lang.String r1 = "r"
            android.os.ParcelFileDescriptor r5 = r4.openFileDescriptor(r0, r1, r14)     // Catch:{ IOException -> 0x0064 }
            r6 = 0
            if (r5 != 0) goto L_0x002b
            r7 = 0
            if (r5 == 0) goto L_0x002a
            r5.close()
        L_0x002a:
            return r7
        L_0x002b:
            android.graphics.Typeface$Builder r0 = new android.graphics.Typeface$Builder     // Catch:{ Throwable -> 0x004f }
            java.io.FileDescriptor r1 = r5.getFileDescriptor()     // Catch:{ Throwable -> 0x004f }
            r0.<init>(r1)     // Catch:{ Throwable -> 0x004f }
            int r1 = r3.getWeight()     // Catch:{ Throwable -> 0x004f }
            android.graphics.Typeface$Builder r0 = r0.setWeight(r1)     // Catch:{ Throwable -> 0x004f }
            boolean r1 = r3.isItalic()     // Catch:{ Throwable -> 0x004f }
            android.graphics.Typeface$Builder r0 = r0.setItalic(r1)     // Catch:{ Throwable -> 0x004f }
            android.graphics.Typeface r7 = r0.build()     // Catch:{ Throwable -> 0x004f }
            if (r5 == 0) goto L_0x004e
            r5.close()
        L_0x004e:
            return r7
        L_0x004f:
            r7 = move-exception
            r6 = r7
            throw r7     // Catch:{ all -> 0x0052 }
        L_0x0052:
            r9 = move-exception
            if (r5 == 0) goto L_0x0063
            if (r6 == 0) goto L_0x0060
            r5.close()     // Catch:{ Throwable -> 0x005b }
            goto L_0x0063
        L_0x005b:
            r10 = move-exception
            r6.addSuppressed(r10)
            goto L_0x0063
        L_0x0060:
            r5.close()
        L_0x0063:
            throw r9
        L_0x0064:
            r5 = move-exception
            r0 = 0
            return r0
        L_0x0067:
            java.util.Map r3 = android.support.v4.provider.FontsContractCompat.prepareFontData(r13, r15, r14)
            java.lang.Object r4 = newFamily()
            r5 = 0
            r6 = r15
            int r7 = r6.length
            r8 = 0
        L_0x0073:
            if (r8 >= r7) goto L_0x00a5
            r9 = r6[r8]
            android.net.Uri r0 = r9.getUri()
            java.lang.Object r0 = r3.get(r0)
            r10 = r0
            java.nio.ByteBuffer r10 = (java.nio.ByteBuffer) r10
            if (r10 != 0) goto L_0x0085
            goto L_0x00a2
        L_0x0085:
            int r0 = r9.getTtcIndex()
            int r1 = r9.getWeight()
            boolean r2 = r9.isItalic()
            if (r2 == 0) goto L_0x0095
            r2 = 1
            goto L_0x0096
        L_0x0095:
            r2 = 0
        L_0x0096:
            boolean r11 = addFontFromBuffer(r4, r10, r0, r1, r2)
            if (r11 != 0) goto L_0x00a1
            abortCreation(r4)
            r0 = 0
            return r0
        L_0x00a1:
            r5 = 1
        L_0x00a2:
            int r8 = r8 + 1
            goto L_0x0073
        L_0x00a5:
            if (r5 != 0) goto L_0x00ac
            abortCreation(r4)
            r0 = 0
            return r0
        L_0x00ac:
            boolean r0 = freeze(r4)
            if (r0 != 0) goto L_0x00b4
            r0 = 0
            return r0
        L_0x00b4:
            android.graphics.Typeface r6 = createFromFamiliesWithDefault(r4)
            r0 = r16
            android.graphics.Typeface r0 = android.graphics.Typeface.create(r6, r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.graphics.TypefaceCompatApi26Impl.createFromFontInfo(android.content.Context, android.os.CancellationSignal, android.support.v4.provider.FontsContractCompat$FontInfo[], int):android.graphics.Typeface");
    }

    @Override // android.support.v4.graphics.TypefaceCompatBaseImpl, android.support.v4.graphics.TypefaceCompat.TypefaceCompatImpl
    public Typeface createFromResourcesFontFile(Context context, Resources resources, int i, String str, int i2) {
        if (!isFontFamilyPrivateAPIAvailable()) {
            return super.createFromResourcesFontFile(context, resources, i, str, i2);
        }
        Object newFamily = newFamily();
        if (!addFontFromAssetManager(context, newFamily, str, 0, -1, -1)) {
            abortCreation(newFamily);
            return null;
        } else if (!freeze(newFamily)) {
            return null;
        } else {
            return createFromFamiliesWithDefault(newFamily);
        }
    }
}
