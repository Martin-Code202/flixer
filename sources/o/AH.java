package o;

import android.os.Environment;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.util.LinkedList;
public final class AH {
    /* renamed from: ˋ  reason: contains not printable characters */
    public static boolean m3344(String str, String str2, String str3) {
        try {
            File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + str3);
            file.getParentFile().mkdirs();
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(str2);
            fileWriter.close();
            C1283.m16846(str, "*****************************************************************");
            C1283.m16846(str, "Wrote string to file: " + file);
            C1283.m16846(str, "Get file with command: adb pull /sdcard/" + str3);
            C1283.m16846(str, "*****************************************************************");
            return true;
        } catch (IOException e) {
            C1283.m16852(str, e);
            return false;
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static boolean m3341(String str, String str2, File file) {
        try {
            file.getParentFile().mkdirs();
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(str2);
            fileWriter.close();
            C1283.m16846(str, "*****************************************************************");
            C1283.m16846(str, "Wrote string to file: " + file);
            C1283.m16846(str, "*****************************************************************");
            return true;
        } catch (IOException e) {
            C1283.m16852(str, e);
            return false;
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static String m3351(String str, Charset charset) {
        File file = new File(str);
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bArr = new byte[((int) file.length())];
        fileInputStream.read(bArr);
        fileInputStream.close();
        return new String(bArr, charset);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static String m3350(String str) {
        return m3351(str, Charset.forName("UTF-8"));
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static boolean m3343(String str, String str2) {
        return new File(str).renameTo(new File(str2));
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static byte[] m3345(File file) {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = m3338(file);
            return m3354(fileInputStream);
        } finally {
            m3339(fileInputStream);
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static byte[] m3353(File file, int i, int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("We can not read less than 1 byte!");
        }
        byte[] bArr = new byte[i2];
        RandomAccessFile randomAccessFile = null;
        try {
            randomAccessFile = new RandomAccessFile(file, "r");
            randomAccessFile.skipBytes(i);
            randomAccessFile.readFully(bArr);
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (Throwable th) {
                }
            }
            return bArr;
        } catch (Throwable th2) {
        }
        throw th;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static FileInputStream m3338(File file) {
        if (!file.exists()) {
            throw new FileNotFoundException("File '" + file + "' does not exist");
        } else if (file.isDirectory()) {
            throw new IOException("File '" + file + "' exists but is a directory");
        } else if (file.canRead()) {
            return new FileInputStream(file);
        } else {
            throw new IOException("File '" + file + "' cannot be read");
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static void m3339(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static byte[] m3354(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        m3347(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static long m3347(InputStream inputStream, OutputStream outputStream) {
        long j = 0;
        byte[] bArr = new byte[4096];
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 == read) {
                return j;
            }
            outputStream.write(bArr, 0, read);
            j += (long) read;
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static boolean m3352(File file) {
        File[] listFiles;
        if (file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                m3352(file2);
            }
        }
        return file.delete();
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static boolean m3340(String str) {
        File file = new File(str);
        return file.isDirectory() || file.mkdirs();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static boolean m3349(String str, byte[] bArr) {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(str);
            fileOutputStream.write(bArr);
            if (fileOutputStream == null) {
                return false;
            }
            try {
                fileOutputStream.close();
                return true;
            } catch (IOException e) {
                C1283.m16847("FileUtils", "writeBytesToFile close IOException ", e);
                return false;
            }
        } catch (FileNotFoundException e2) {
            C1283.m16847("FileUtils", "writeBytesToFile file not found " + str, e2);
            if (fileOutputStream == null) {
                return false;
            }
            try {
                fileOutputStream.close();
                return false;
            } catch (IOException e3) {
                C1283.m16847("FileUtils", "writeBytesToFile close IOException ", e3);
                return false;
            }
        } catch (IOException e4) {
            C1283.m16847("FileUtils", "writeBytesToFile IOException " + str, e4);
            if (fileOutputStream == null) {
                return false;
            }
            try {
                fileOutputStream.close();
                return false;
            } catch (IOException e5) {
                C1283.m16847("FileUtils", "writeBytesToFile close IOException ", e5);
                return false;
            }
        } catch (Throwable th) {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e6) {
                    C1283.m16847("FileUtils", "writeBytesToFile close IOException ", e6);
                }
            }
            throw th;
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static long m3346(File file) {
        File[] listFiles;
        if (file == null || !file.exists()) {
            return 0;
        }
        if (!file.isDirectory()) {
            return file.length();
        }
        long j = 0;
        LinkedList linkedList = new LinkedList();
        linkedList.add(file);
        while (!linkedList.isEmpty()) {
            File file2 = (File) linkedList.remove();
            if (!(!file2.exists() || (listFiles = file2.listFiles()) == null || listFiles.length == 0)) {
                for (File file3 : listFiles) {
                    if (file3.isDirectory()) {
                        linkedList.add(file3);
                    } else {
                        j += file3.length();
                    }
                }
            }
        }
        return j;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static long m3342(File file) {
        if (file != null && file.exists() && file.isDirectory()) {
            return file.getUsableSpace();
        }
        C1283.m16850("FileUtils", "Not directory or does not exists " + file.exists());
        return 0;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static boolean m3348(String str) {
        File file = new File(str);
        return file.exists() && file.isDirectory();
    }
}
