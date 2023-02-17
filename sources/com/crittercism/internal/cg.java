package com.crittercism.internal;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.util.Scanner;
public final class cg {
    public static void a(File file) {
        if (file.getAbsolutePath().contains("com.crittercism") && file.exists()) {
            if (file.isDirectory()) {
                for (File file2 : file.listFiles()) {
                    a(file2);
                }
            }
            file.delete();
        }
    }

    public static String b(File file) {
        Scanner scanner = new Scanner(file);
        try {
            return scanner.useDelimiter("\\A").next();
        } finally {
            scanner.close();
        }
    }

    public static byte[] a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[4096];
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 == read) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }
}
