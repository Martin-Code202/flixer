package o;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
/* renamed from: o.ᔾ  reason: contains not printable characters */
public class C0885 {
    /* renamed from: ˊ  reason: contains not printable characters */
    public static String m15601(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine + "\n");
            } catch (IOException e) {
                C0509.m14519("Failed to read: ", e);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e2) {
                        C0509.m14522(e2, "failed to close inputStream", new Object[0]);
                    }
                }
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e3) {
                        C0509.m14522(e3, "failed to close inputStream", new Object[0]);
                    }
                }
                throw th;
            }
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e4) {
                C0509.m14522(e4, "failed to close inputStream", new Object[0]);
            }
        }
        return sb.toString();
    }
}
