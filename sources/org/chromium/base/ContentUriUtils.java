package org.chromium.base;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.provider.DocumentsContract;
import android.util.Log;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.chromium.base.annotations.CalledByNative;
public abstract class ContentUriUtils {
    private static final Object sLock = new Object();

    private ContentUriUtils() {
    }

    @CalledByNative
    public static int openContentUriForRead(String str) {
        AssetFileDescriptor assetFileDescriptor = getAssetFileDescriptor(str);
        if (assetFileDescriptor != null) {
            return assetFileDescriptor.getParcelFileDescriptor().detachFd();
        }
        return -1;
    }

    @CalledByNative
    public static boolean contentUriExists(String str) {
        AssetFileDescriptor assetFileDescriptor = null;
        try {
            assetFileDescriptor = getAssetFileDescriptor(str);
            return assetFileDescriptor != null;
        } finally {
            if (assetFileDescriptor != null) {
                try {
                    assetFileDescriptor.close();
                } catch (IOException e) {
                }
            }
        }
    }

    @CalledByNative
    public static String getMimeType(String str) {
        ContentResolver contentResolver = ContextUtils.getApplicationContext().getContentResolver();
        Uri parse = Uri.parse(str);
        if (!isVirtualDocument(parse)) {
            return contentResolver.getType(parse);
        }
        String[] streamTypes = contentResolver.getStreamTypes(parse, "*/*");
        if (streamTypes == null || streamTypes.length <= 0) {
            return null;
        }
        return streamTypes[0];
    }

    private static AssetFileDescriptor getAssetFileDescriptor(String str) {
        ContentResolver contentResolver = ContextUtils.getApplicationContext().getContentResolver();
        Uri parse = Uri.parse(str);
        try {
            if (isVirtualDocument(parse)) {
                String[] streamTypes = contentResolver.getStreamTypes(parse, "*/*");
                if (streamTypes == null || streamTypes.length <= 0) {
                    return null;
                }
                AssetFileDescriptor openTypedAssetFileDescriptor = contentResolver.openTypedAssetFileDescriptor(parse, streamTypes[0], null);
                if (openTypedAssetFileDescriptor == null || openTypedAssetFileDescriptor.getStartOffset() == 0) {
                    return openTypedAssetFileDescriptor;
                }
                try {
                    openTypedAssetFileDescriptor.close();
                } catch (IOException e) {
                }
                throw new SecurityException("Cannot open files with non-zero offset type.");
            }
            ParcelFileDescriptor openFileDescriptor = contentResolver.openFileDescriptor(parse, "r");
            if (openFileDescriptor != null) {
                return new AssetFileDescriptor(openFileDescriptor, 0, -1);
            }
            return null;
        } catch (FileNotFoundException e2) {
            Log.w("ContentUriUtils", "Cannot find content uri: " + str, e2);
            return null;
        } catch (SecurityException e3) {
            Log.w("ContentUriUtils", "Cannot open content uri: " + str, e3);
            return null;
        } catch (Exception e4) {
            Log.w("ContentUriUtils", "Unknown content uri: " + str, e4);
            return null;
        }
    }

    private static boolean isVirtualDocument(Uri uri) {
        if (Build.VERSION.SDK_INT < 19 || uri == null || !DocumentsContract.isDocumentUri(ContextUtils.getApplicationContext(), uri)) {
            return false;
        }
        Closeable closeable = null;
        try {
            closeable = ContextUtils.getApplicationContext().getContentResolver().query(uri, null, null, null, null);
            if (closeable == null || closeable.getCount() < 1) {
                StreamUtil.closeQuietly(closeable);
                return false;
            }
            closeable.moveToFirst();
            return hasVirtualFlag(closeable);
        } catch (NullPointerException e) {
            return false;
        } finally {
            StreamUtil.closeQuietly(closeable);
        }
    }

    private static boolean hasVirtualFlag(Cursor cursor) {
        int columnIndex;
        return Build.VERSION.SDK_INT >= 24 && (columnIndex = cursor.getColumnIndex("flags")) > -1 && (cursor.getLong(columnIndex) & 512) != 0;
    }
}
