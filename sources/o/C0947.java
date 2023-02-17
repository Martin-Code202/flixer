package o;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.getkeepsafe.relinker.MissingLibraryException;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import o.C1064;
/* renamed from: o.ᴊ  reason: contains not printable characters */
public class C0947 implements C1064.Cif {
    @Override // o.C1064.Cif
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo15763(Context context, String[] strArr, String str, File file, C1182 r20) {
        ZipFile zipFile = null;
        try {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            int i = 0;
            while (true) {
                i++;
                if (i >= 5) {
                    break;
                }
                try {
                    zipFile = new ZipFile(new File(applicationInfo.sourceDir), 1);
                    break;
                } catch (IOException e) {
                }
            }
            if (zipFile == null) {
                r20.m16438("FATAL! Couldn't find application APK!");
            } else {
                int i2 = 0;
                while (true) {
                    i2++;
                    if (i2 < 5) {
                        String str2 = null;
                        ZipEntry zipEntry = null;
                        int length = strArr.length;
                        for (int i3 = 0; i3 < length; i3++) {
                            str2 = "lib" + File.separatorChar + strArr[i3] + File.separatorChar + str;
                            zipEntry = zipFile.getEntry(str2);
                            if (zipEntry != null) {
                                break;
                            }
                        }
                        if (str2 != null) {
                            r20.m16440("Looking for %s in APK...", str2);
                        }
                        if (zipEntry != null) {
                            r20.m16440("Found %s! Extracting...", str2);
                            try {
                                if (file.exists() || file.createNewFile()) {
                                    InputStream inputStream = null;
                                    FileOutputStream fileOutputStream = null;
                                    try {
                                        inputStream = zipFile.getInputStream(zipEntry);
                                        fileOutputStream = new FileOutputStream(file);
                                        long r10 = m15762(inputStream, fileOutputStream);
                                        fileOutputStream.getFD().sync();
                                        if (r10 == file.length()) {
                                            m15761(inputStream);
                                            m15761(fileOutputStream);
                                            file.setReadable(true, false);
                                            file.setExecutable(true, false);
                                            file.setWritable(true);
                                            if (zipFile != null) {
                                                try {
                                                    zipFile.close();
                                                    return;
                                                } catch (IOException e2) {
                                                    return;
                                                }
                                            } else {
                                                return;
                                            }
                                        }
                                    } catch (FileNotFoundException e3) {
                                    } catch (IOException e4) {
                                    } finally {
                                        m15761(inputStream);
                                        m15761(fileOutputStream);
                                    }
                                }
                            } catch (IOException e5) {
                            }
                        } else if (str2 != null) {
                            throw new MissingLibraryException(str2);
                        } else {
                            throw new MissingLibraryException(str);
                        }
                    } else {
                        r20.m16438("FATAL! Couldn't extract the library from the APK!");
                        if (zipFile != null) {
                            try {
                                zipFile.close();
                                return;
                            } catch (IOException e6) {
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                }
            }
        } finally {
            if (zipFile != null) {
                try {
                    zipFile.close();
                } catch (IOException e7) {
                }
            }
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private long m15762(InputStream inputStream, OutputStream outputStream) {
        long j = 0;
        byte[] bArr = new byte[4096];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                outputStream.flush();
                return j;
            }
            outputStream.write(bArr, 0, read);
            j += (long) read;
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m15761(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }
}
