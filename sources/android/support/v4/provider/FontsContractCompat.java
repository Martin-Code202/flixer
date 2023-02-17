package android.support.v4.provider;

import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import android.support.v4.content.res.FontResourcesParserCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.graphics.TypefaceCompat;
import android.support.v4.graphics.TypefaceCompatUtil;
import android.support.v4.provider.SelfDestructiveThread;
import android.support.v4.util.LruCache;
import android.support.v4.util.Preconditions;
import android.support.v4.util.SimpleArrayMap;
import com.netflix.mediaclient.service.webclient.model.leafs.SubtitleDownloadRetryPolicy;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
public class FontsContractCompat {
    private static final SelfDestructiveThread sBackgroundThread = new SelfDestructiveThread("fonts", 10, SubtitleDownloadRetryPolicy.DEFAULT_INITIAL_INTERVAL_MS);
    private static final Comparator<byte[]> sByteArrayComparator = new Comparator<byte[]>() { // from class: android.support.v4.provider.FontsContractCompat.5
        public int compare(byte[] bArr, byte[] bArr2) {
            if (bArr.length != bArr2.length) {
                return bArr.length - bArr2.length;
            }
            for (int i = 0; i < bArr.length; i++) {
                if (bArr[i] != bArr2[i]) {
                    return bArr[i] - bArr2[i];
                }
            }
            return 0;
        }
    };
    private static final Object sLock = new Object();
    private static final SimpleArrayMap<String, ArrayList<SelfDestructiveThread.ReplyCallback<TypefaceResult>>> sPendingReplies = new SimpleArrayMap<>();
    private static final LruCache<String, Typeface> sTypefaceCache = new LruCache<>(16);

    /* access modifiers changed from: private */
    public static TypefaceResult getFontInternal(Context context, FontRequest fontRequest, int i) {
        try {
            FontFamilyResult fetchFonts = fetchFonts(context, null, fontRequest);
            if (fetchFonts.getStatusCode() == 0) {
                Typeface createFromFontInfo = TypefaceCompat.createFromFontInfo(context, null, fetchFonts.getFonts(), i);
                return new TypefaceResult(createFromFontInfo, createFromFontInfo != null ? 0 : -3);
            }
            return new TypefaceResult(null, fetchFonts.getStatusCode() == 1 ? -2 : -3);
        } catch (PackageManager.NameNotFoundException e) {
            return new TypefaceResult(null, -1);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class TypefaceResult {
        final int mResult;
        final Typeface mTypeface;

        TypefaceResult(Typeface typeface, int i) {
            this.mTypeface = typeface;
            this.mResult = i;
        }
    }

    public static Typeface getFontSync(final Context context, final FontRequest fontRequest, final ResourcesCompat.FontCallback fontCallback, final Handler handler, boolean z, int i, final int i2) {
        final String str = fontRequest.getIdentifier() + "-" + i2;
        Typeface typeface = sTypefaceCache.get(str);
        if (typeface != null) {
            if (fontCallback != null) {
                fontCallback.onFontRetrieved(typeface);
            }
            return typeface;
        } else if (!z || i != -1) {
            AnonymousClass1 r4 = new Callable<TypefaceResult>() { // from class: android.support.v4.provider.FontsContractCompat.1
                @Override // java.util.concurrent.Callable
                public TypefaceResult call() {
                    TypefaceResult fontInternal = FontsContractCompat.getFontInternal(context, fontRequest, i2);
                    if (fontInternal.mTypeface != null) {
                        FontsContractCompat.sTypefaceCache.put(str, fontInternal.mTypeface);
                    }
                    return fontInternal;
                }
            };
            if (z) {
                try {
                    return ((TypefaceResult) sBackgroundThread.postAndWait(r4, i)).mTypeface;
                } catch (InterruptedException e) {
                    return null;
                }
            } else {
                AnonymousClass2 r5 = fontCallback == null ? null : new SelfDestructiveThread.ReplyCallback<TypefaceResult>() { // from class: android.support.v4.provider.FontsContractCompat.2
                    public void onReply(TypefaceResult typefaceResult) {
                        if (typefaceResult == null) {
                            fontCallback.callbackFailAsync(1, handler);
                        } else if (typefaceResult.mResult == 0) {
                            fontCallback.callbackSuccessAsync(typefaceResult.mTypeface, handler);
                        } else {
                            fontCallback.callbackFailAsync(typefaceResult.mResult, handler);
                        }
                    }
                };
                synchronized (sLock) {
                    if (sPendingReplies.containsKey(str)) {
                        if (r5 != null) {
                            sPendingReplies.get(str).add(r5);
                        }
                        return null;
                    }
                    if (r5 != null) {
                        ArrayList<SelfDestructiveThread.ReplyCallback<TypefaceResult>> arrayList = new ArrayList<>();
                        arrayList.add(r5);
                        sPendingReplies.put(str, arrayList);
                    }
                    sBackgroundThread.postAndReply(r4, new SelfDestructiveThread.ReplyCallback<TypefaceResult>() { // from class: android.support.v4.provider.FontsContractCompat.3
                        public void onReply(TypefaceResult typefaceResult) {
                            ArrayList arrayList2;
                            synchronized (FontsContractCompat.sLock) {
                                arrayList2 = (ArrayList) FontsContractCompat.sPendingReplies.get(str);
                                if (arrayList2 != null) {
                                    FontsContractCompat.sPendingReplies.remove(str);
                                } else {
                                    return;
                                }
                            }
                            for (int i3 = 0; i3 < arrayList2.size(); i3++) {
                                ((SelfDestructiveThread.ReplyCallback) arrayList2.get(i3)).onReply(typefaceResult);
                            }
                        }
                    });
                    return null;
                }
            }
        } else {
            TypefaceResult fontInternal = getFontInternal(context, fontRequest, i2);
            if (fontCallback != null) {
                if (fontInternal.mResult == 0) {
                    fontCallback.callbackSuccessAsync(fontInternal.mTypeface, handler);
                } else {
                    fontCallback.callbackFailAsync(fontInternal.mResult, handler);
                }
            }
            return fontInternal.mTypeface;
        }
    }

    public static class FontInfo {
        private final boolean mItalic;
        private final int mResultCode;
        private final int mTtcIndex;
        private final Uri mUri;
        private final int mWeight;

        public FontInfo(Uri uri, int i, int i2, boolean z, int i3) {
            this.mUri = (Uri) Preconditions.checkNotNull(uri);
            this.mTtcIndex = i;
            this.mWeight = i2;
            this.mItalic = z;
            this.mResultCode = i3;
        }

        public Uri getUri() {
            return this.mUri;
        }

        public int getTtcIndex() {
            return this.mTtcIndex;
        }

        public int getWeight() {
            return this.mWeight;
        }

        public boolean isItalic() {
            return this.mItalic;
        }

        public int getResultCode() {
            return this.mResultCode;
        }
    }

    public static class FontFamilyResult {
        private final FontInfo[] mFonts;
        private final int mStatusCode;

        public FontFamilyResult(int i, FontInfo[] fontInfoArr) {
            this.mStatusCode = i;
            this.mFonts = fontInfoArr;
        }

        public int getStatusCode() {
            return this.mStatusCode;
        }

        public FontInfo[] getFonts() {
            return this.mFonts;
        }
    }

    public static Map<Uri, ByteBuffer> prepareFontData(Context context, FontInfo[] fontInfoArr, CancellationSignal cancellationSignal) {
        HashMap hashMap = new HashMap();
        for (FontInfo fontInfo : fontInfoArr) {
            if (fontInfo.getResultCode() == 0) {
                Uri uri = fontInfo.getUri();
                if (!hashMap.containsKey(uri)) {
                    hashMap.put(uri, TypefaceCompatUtil.mmap(context, cancellationSignal, uri));
                }
            }
        }
        return Collections.unmodifiableMap(hashMap);
    }

    public static FontFamilyResult fetchFonts(Context context, CancellationSignal cancellationSignal, FontRequest fontRequest) {
        ProviderInfo provider = getProvider(context.getPackageManager(), fontRequest, context.getResources());
        if (provider == null) {
            return new FontFamilyResult(1, null);
        }
        return new FontFamilyResult(0, getFontFromProvider(context, fontRequest, provider.authority, cancellationSignal));
    }

    public static ProviderInfo getProvider(PackageManager packageManager, FontRequest fontRequest, Resources resources) {
        String providerAuthority = fontRequest.getProviderAuthority();
        ProviderInfo resolveContentProvider = packageManager.resolveContentProvider(providerAuthority, 0);
        if (resolveContentProvider == null) {
            throw new PackageManager.NameNotFoundException("No package found for authority: " + providerAuthority);
        } else if (!resolveContentProvider.packageName.equals(fontRequest.getProviderPackage())) {
            throw new PackageManager.NameNotFoundException("Found content provider " + providerAuthority + ", but package was not " + fontRequest.getProviderPackage());
        } else {
            List<byte[]> convertToByteArrayList = convertToByteArrayList(packageManager.getPackageInfo(resolveContentProvider.packageName, 64).signatures);
            Collections.sort(convertToByteArrayList, sByteArrayComparator);
            List<List<byte[]>> certificates = getCertificates(fontRequest, resources);
            for (int i = 0; i < certificates.size(); i++) {
                ArrayList arrayList = new ArrayList(certificates.get(i));
                Collections.sort(arrayList, sByteArrayComparator);
                if (equalsByteArrayList(convertToByteArrayList, arrayList)) {
                    return resolveContentProvider;
                }
            }
            return null;
        }
    }

    private static List<List<byte[]>> getCertificates(FontRequest fontRequest, Resources resources) {
        if (fontRequest.getCertificates() != null) {
            return fontRequest.getCertificates();
        }
        return FontResourcesParserCompat.readCerts(resources, fontRequest.getCertificatesArrayResId());
    }

    private static boolean equalsByteArrayList(List<byte[]> list, List<byte[]> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (!Arrays.equals(list.get(i), list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    private static List<byte[]> convertToByteArrayList(Signature[] signatureArr) {
        ArrayList arrayList = new ArrayList();
        for (Signature signature : signatureArr) {
            arrayList.add(signature.toByteArray());
        }
        return arrayList;
    }

    static FontInfo[] getFontFromProvider(Context context, FontRequest fontRequest, String str, CancellationSignal cancellationSignal) {
        Uri uri;
        Cursor query;
        ArrayList arrayList = new ArrayList();
        Uri build = new Uri.Builder().scheme("content").authority(str).build();
        Uri build2 = new Uri.Builder().scheme("content").authority(str).appendPath("file").build();
        Cursor cursor = null;
        try {
            if (Build.VERSION.SDK_INT > 16) {
                query = context.getContentResolver().query(build, new String[]{"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"}, "query = ?", new String[]{fontRequest.getQuery()}, null, cancellationSignal);
            } else {
                query = context.getContentResolver().query(build, new String[]{"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"}, "query = ?", new String[]{fontRequest.getQuery()}, null);
            }
            if (cursor != null && cursor.getCount() > 0) {
                int columnIndex = cursor.getColumnIndex("result_code");
                arrayList = new ArrayList();
                int columnIndex2 = cursor.getColumnIndex("_id");
                int columnIndex3 = cursor.getColumnIndex("file_id");
                int columnIndex4 = cursor.getColumnIndex("font_ttc_index");
                int columnIndex5 = cursor.getColumnIndex("font_weight");
                int columnIndex6 = cursor.getColumnIndex("font_italic");
                while (cursor.moveToNext()) {
                    int i = columnIndex != -1 ? cursor.getInt(columnIndex) : 0;
                    int i2 = columnIndex4 != -1 ? cursor.getInt(columnIndex4) : 0;
                    if (columnIndex3 == -1) {
                        uri = ContentUris.withAppendedId(build, cursor.getLong(columnIndex2));
                    } else {
                        uri = ContentUris.withAppendedId(build2, cursor.getLong(columnIndex3));
                    }
                    arrayList.add(new FontInfo(uri, i2, columnIndex5 != -1 ? cursor.getInt(columnIndex5) : 400, columnIndex6 != -1 && cursor.getInt(columnIndex6) == 1, i));
                }
            }
            return (FontInfo[]) arrayList.toArray(new FontInfo[0]);
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }
}
