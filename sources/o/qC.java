package o;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.os.Process;
import android.text.TextUtils;
import android.view.View;
import com.netflix.falkor.cache.FalkorCache;
import com.netflix.mediaclient.NetflixApplication;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import io.reactivex.exceptions.CompositeException;
import io.realm.RealmConfiguration;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
public class qC {

    /* renamed from: ˋ  reason: contains not printable characters */
    private static long f9426 = 0;

    /* renamed from: ॱ  reason: contains not printable characters */
    public static void m9873(Context context, Throwable th, String str) {
        String str2 = null;
        String str3 = null;
        if (th != null) {
            str2 = th.toString();
            if (th instanceof CompositeException) {
                CompositeException compositeException = (CompositeException) th;
                if (compositeException.getExceptions().size() > 0) {
                    str3 = "";
                    String str4 = "";
                    for (Throwable th2 : compositeException.getExceptions()) {
                        str4 = str4 + th2.toString() + " ";
                        str3 = str3 + "{code}\n" + C1283.m16857(th2) + "{code}";
                    }
                    str2 = str4.trim();
                }
            } else {
                str2 = th.toString();
                str3 = "{code}\n" + C1283.m16857(th) + "{code}";
                if (!(th.getStackTrace() == null || th.getStackTrace().length <= 0 || th.getStackTrace()[0] == null)) {
                    String fileName = th.getStackTrace()[0].getFileName();
                    int lineNumber = th.getStackTrace()[0].getLineNumber();
                    if (!TextUtils.isEmpty(fileName) && lineNumber > 0) {
                        str2 = str2 + " at " + fileName + ":" + lineNumber;
                    }
                }
            }
        }
        m9869(context, str2, str3, str);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private static void m9869(Context context, String str, String str2, String str3) {
        File r10;
        try {
            File file = new File(context.getFilesDir(), "debug_data");
            if (file.exists() || (!file.exists() && file.mkdirs())) {
                C1283.m16862("ExportDebugData", "Preparing debug_data.zip in " + file.getAbsolutePath());
                File file2 = new File(file, "debug_data.zip");
                if (!file2.exists() || file2.delete()) {
                    ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(file2));
                    zipOutputStream.setLevel(9);
                    m9865(context, zipOutputStream);
                    m9868(context, C2093qn.f9604, zipOutputStream);
                    m9868(context, FalkorCache.f537, zipOutputStream);
                    m9864(context, zipOutputStream);
                    m9870(context, zipOutputStream, "nfxpref");
                    zipOutputStream.close();
                    ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
                    Activity activity = (Activity) C1317As.m3755(context, Activity.class);
                    if (!C1317As.m3750(context) && (r10 = m9871(activity, file)) != null) {
                        arrayList.add(Uri.parse("content://com.netflix.mediaclient.debugdata.fileprovider/debug_data/" + r10.getName()));
                    }
                    File r102 = m9867(context, file);
                    if (r102 != null) {
                        arrayList.add(Uri.parse("content://com.netflix.mediaclient.debugdata.fileprovider/debug_data/" + r102.getName()));
                    }
                    File r11 = m9863(context, file, str3);
                    if (r11 != null) {
                        arrayList.add(Uri.parse("content://com.netflix.mediaclient.debugdata.fileprovider/debug_data/" + r11.getName()));
                    }
                    if (file2.exists()) {
                        arrayList.add(Uri.parse("content://com.netflix.mediaclient.debugdata.fileprovider/debug_data/debug_data.zip"));
                        String str4 = "";
                        NetflixActivity netflixActivity = (NetflixActivity) C1317As.m3755(context, NetflixActivity.class);
                        if (!(netflixActivity == null || netflixActivity.getServiceManager() == null || !netflixActivity.getServiceManager().mo9519() || netflixActivity.getServiceManager().m9826() == null)) {
                            str4 = "user=" + netflixActivity.getServiceManager().m9826().getProfileName() + " (" + netflixActivity.getServiceManager().m9826().getLanguagesInCsv() + ")\n";
                        }
                        StringBuilder sb = new StringBuilder();
                        Map<String, String> r15 = NetflixApplication.getInstance().m253();
                        for (String str5 : r15.keySet()) {
                            sb.append(str5).append("=").append(r15.get(str5)).append("\n");
                        }
                        Intent intent = new Intent("android.intent.action.SEND_MULTIPLE");
                        intent.setType("text/plain");
                        intent.putExtra("android.intent.extra.EMAIL", new String[]{"spy-issues@netflix.com"});
                        intent.putExtra("android.intent.extra.SUBJECT", str == null ? "Enter_JIRA_summary_here" : str);
                        intent.putExtra("android.intent.extra.TEXT", "\n\nEnter_JIRA_description_here\n\n\n\n\npackage=com.netflix.mediaclient\nversion=6.1.0 build 27321\ncode=27321\nandroid=" + Build.VERSION.SDK_INT + "\nbrand=" + Build.BRAND + "\nmanufacturer=" + Build.MANUFACTURER + "\nmodel=" + Build.MODEL + "\ndevice=" + Build.DEVICE + "\ndevice.locale=" + Locale.getDefault().getCountry() + "_" + Locale.getDefault().getLanguage() + "\n" + str4 + ((Object) sb) + "\n" + (str2 == null ? "" : "\n" + str2));
                        Iterator<? extends Parcelable> it = arrayList.iterator();
                        while (it.hasNext()) {
                            m9872(context, intent, (Uri) it.next());
                        }
                        intent.putParcelableArrayListExtra("android.intent.extra.STREAM", arrayList);
                        intent.addFlags(1);
                        Intent createChooser = Intent.createChooser(intent, "Send email...");
                        createChooser.addFlags(268435456);
                        context.startActivity(createChooser);
                        return;
                    }
                    throw new IOException("Unable to create: " + file2.getAbsolutePath());
                }
                throw new IOException("Unable to write: " + file2.getAbsolutePath());
            }
            throw new IOException("Unable to create directories: " + file.getAbsolutePath());
        } catch (Throwable th) {
            C1283.m16847("ExportDebugData", "Oops, cannot createBugReport data", th);
            C1004.m15961(context, "Oops, cannot createBugReport data, see error in logs (" + th.toString() + ")", 1);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002c, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002d, code lost:
        if (r4 != null) goto L_0x002f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002f, code lost:
        if (r6 != null) goto L_0x0031;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0035, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0036, code lost:
        r6.addSuppressed(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003a, code lost:
        r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x003d, code lost:
        throw r7;
     */
    /* renamed from: ˊ  reason: contains not printable characters */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.io.File m9863(android.content.Context r9, java.io.File r10, java.lang.String r11) {
        /*
            if (r11 != 0) goto L_0x0006
            java.lang.String r11 = o.C1348Bu.m4095()     // Catch:{ Throwable -> 0x0063 }
        L_0x0006:
            java.io.File r3 = new java.io.File     // Catch:{ Throwable -> 0x0063 }
            java.lang.String r0 = "thread_dump.txt"
            r3.<init>(r10, r0)     // Catch:{ Throwable -> 0x0063 }
            boolean r0 = r3.exists()     // Catch:{ Throwable -> 0x0063 }
            if (r0 == 0) goto L_0x0019
            boolean r0 = r3.delete()     // Catch:{ Throwable -> 0x0063 }
            if (r0 == 0) goto L_0x003f
        L_0x0019:
            java.io.FileWriter r4 = new java.io.FileWriter     // Catch:{ Throwable -> 0x0063 }
            r4.<init>(r3)     // Catch:{ Throwable -> 0x0063 }
            r5 = 0
            r4.write(r11)     // Catch:{ Throwable -> 0x0029 }
            if (r4 == 0) goto L_0x003e
            r4.close()
            goto L_0x003e
        L_0x0029:
            r6 = move-exception
            r5 = r6
            throw r6     // Catch:{ all -> 0x002c }
        L_0x002c:
            r7 = move-exception
            if (r4 == 0) goto L_0x003d
            if (r5 == 0) goto L_0x003a
            r4.close()     // Catch:{ Throwable -> 0x0035 }
            goto L_0x003d
        L_0x0035:
            r8 = move-exception
            r5.addSuppressed(r8)
            goto L_0x003d
        L_0x003a:
            r4.close()
        L_0x003d:
            throw r7
        L_0x003e:
            return r3
        L_0x003f:
            java.lang.String r0 = "ExportDebugData"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Unable to get threadDump, "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r2 = r3.getAbsolutePath()
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r2 = " cannot be used"
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            o.C1283.m16850(r0, r1)
            r0 = 0
            return r0
        L_0x0063:
            r3 = move-exception
            java.lang.String r0 = "ExportDebugData"
            java.lang.String r1 = "Unable to get threadDump"
            o.C1283.m16847(r0, r1, r3)
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: o.qC.m9863(android.content.Context, java.io.File, java.lang.String):java.io.File");
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private static File m9867(Context context, File file) {
        try {
            File file2 = new File(file, "logcat.txt");
            if (!file2.exists() || file2.delete()) {
                int i = context.getSharedPreferences("ExportDebugData.PREFS_NAMES", 0).getInt("ExportDebugData.PREF_CRASHED_PID", 0);
                StringBuilder append = new StringBuilder("logcat -d | grep \"").append(Process.myPid());
                if (i != 0) {
                    append.append("\\|").append(i);
                }
                append.append("\"");
                C1283.m16850("ExportDebugData", "Capture logcat using $" + ((Object) append));
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(append.toString()).getInputStream()));
                FileWriter fileWriter = new FileWriter(file2);
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        fileWriter.append((CharSequence) readLine).append((CharSequence) "\n");
                    } else {
                        AM.m3393(bufferedReader);
                        AM.m3393(fileWriter);
                        return file2;
                    }
                }
            } else {
                C1283.m16850("ExportDebugData", "Unable to capture logcat, " + file2.getAbsolutePath() + " cannot be used");
                return null;
            }
        } catch (Throwable th) {
            C1283.m16847("ExportDebugData", "Unable to capture logcat", th);
            return null;
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private static File m9871(Activity activity, File file) {
        try {
            File file2 = new File(file, "screenshot.jpeg");
            if (!file2.exists() || file2.delete()) {
                View rootView = activity.getWindow().getDecorView().getRootView();
                rootView.setDrawingCacheEnabled(true);
                Bitmap createBitmap = Bitmap.createBitmap(rootView.getDrawingCache());
                rootView.setDrawingCacheEnabled(false);
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                createBitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                AM.m3393(fileOutputStream);
                return file2;
            }
            C1283.m16850("ExportDebugData", "Unable to capture screenshot, " + file2.getAbsolutePath() + " cannot be used");
            return null;
        } catch (Throwable th) {
            C1283.m16847("ExportDebugData", "Unable to capture screenshot", th);
            return null;
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static void m9865(Context context, ZipOutputStream zipOutputStream) {
        NetflixActivity netflixActivity = (NetflixActivity) C1317As.m3755(context, NetflixActivity.class);
        if (netflixActivity != null) {
            C2059ph serviceManager = netflixActivity.getServiceManager();
            if (serviceManager == null || !serviceManager.mo9519()) {
                C1283.m16862("ExportDebugData", "Unable to export falkor mem cache, ServiceManager not available");
                return;
            }
            File file = new File(netflixActivity.getFilesDir() + "/cache.txt");
            serviceManager.m9764().mo9465(file);
            if (file.exists()) {
                C1283.m16862("ExportDebugData", "Adding " + file.getAbsolutePath());
                zipOutputStream.putNextEntry(new ZipEntry(file.getName()));
                m9866(new FileInputStream(file), zipOutputStream);
                zipOutputStream.closeEntry();
                return;
            }
            C1283.m16862("ExportDebugData", "Expected file not found " + file.getAbsolutePath());
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private static void m9864(Context context, ZipOutputStream zipOutputStream) {
        File file = new File(C1317As.m3773(context).getAbsolutePath() + "/.of");
        final ArrayList<File> arrayList = new ArrayList();
        file.list(new FilenameFilter() { // from class: o.qC.5
            @Override // java.io.FilenameFilter
            public boolean accept(File file2, String str) {
                File file3 = new File(file2, str);
                if (!file3.isFile() || file3.length() >= 5242880) {
                    return false;
                }
                arrayList.add(file3);
                return false;
            }
        });
        for (File file2 : arrayList) {
            C1283.m16862("ExportDebugData", "Adding " + file2.getAbsolutePath());
            zipOutputStream.putNextEntry(new ZipEntry(file2.getName()));
            m9866(new FileInputStream(file2), zipOutputStream);
            zipOutputStream.closeEntry();
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private static void m9870(Context context, ZipOutputStream zipOutputStream, String str) {
        Map<String, ?> all = context.getSharedPreferences(str, 0).getAll();
        Properties properties = new Properties();
        for (String str2 : all.keySet()) {
            if (all.get(str2) != null) {
                properties.put("." + str2, String.valueOf(all.get(str2)));
            } else {
                properties.put("Default." + str2, "<null value>");
            }
        }
        zipOutputStream.putNextEntry(new ZipEntry("preferences.xml"));
        properties.storeToXML(new PrintStream(zipOutputStream), "Export of " + str);
        zipOutputStream.closeEntry();
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private static void m9868(Context context, RealmConfiguration realmConfiguration, ZipOutputStream zipOutputStream) {
        File file = new File(context.getFilesDir(), realmConfiguration.getRealmFileName());
        if (file.exists()) {
            C1283.m16862("ExportDebugData", "Adding " + file.getAbsolutePath());
            zipOutputStream.putNextEntry(new ZipEntry(file.getName()));
            m9866(new FileInputStream(file), zipOutputStream);
            zipOutputStream.closeEntry();
            File file2 = new File(context.getFilesDir(), realmConfiguration.getRealmFileName() + ".lru_backup/journal");
            if (file2.exists()) {
                C1283.m16862("ExportDebugData", "Adding " + file2.getAbsolutePath());
                zipOutputStream.putNextEntry(new ZipEntry(file.getName() + ".lru_backup/journal.txt"));
                m9866(new FileInputStream(file2), zipOutputStream);
                zipOutputStream.closeEntry();
                return;
            }
            return;
        }
        C1283.m16862("ExportDebugData", "Unable to export realm. Unable to find " + file.getAbsolutePath());
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static void m9866(InputStream inputStream, OutputStream outputStream) {
        int i = 0;
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read <= 0) {
                    break;
                }
                outputStream.write(bArr, 0, read);
                i += read;
            }
            C1283.m16862("ExportDebugData", "Wrote " + i);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                }
            }
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private static void m9872(Context context, Intent intent, Uri uri) {
        for (ResolveInfo resolveInfo : context.getPackageManager().queryIntentActivities(intent, 65536)) {
            context.grantUriPermission(resolveInfo.activityInfo.packageName, uri, 1);
        }
    }
}
