package org.linphone.tools;

import android.content.Context;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import org.apache.commons.compress.compressors.bzip2.BZip2CompressorInputStream;
import org.linphone.core.OpenH264DownloadHelperListener;
import org.linphone.mediastream.Log;
public class OpenH264DownloadHelper {
    private String fileDirection;
    private String licenseMessage = "OpenH264 Video Codec provided by Cisco Systems, Inc.";
    private String nameFileDownload = "libopenh264-1.5.0-android19.so.bz2";
    private String nameLib = "libopenh264.so";
    private OpenH264DownloadHelperListener openH264DownloadHelperListener;
    private String urlDownload = "http://ciscobinary.openh264.org/libopenh264-1.5.0-android19.so.bz2";
    private ArrayList<Object> userData = new ArrayList<>();

    public OpenH264DownloadHelper(Context context) {
        if (context.getFilesDir() != null) {
            this.fileDirection = context.getFilesDir().toString();
        }
    }

    public void setOpenH264HelperListener(OpenH264DownloadHelperListener openH264DownloadHelperListener2) {
        this.openH264DownloadHelperListener = openH264DownloadHelperListener2;
    }

    public OpenH264DownloadHelperListener getOpenH264DownloadHelperListener() {
        return this.openH264DownloadHelperListener;
    }

    public Object getUserData(int i) {
        if (i < 0 || i >= this.userData.size()) {
            return null;
        }
        return this.userData.get(i);
    }

    public int setUserData(Object obj) {
        this.userData.add(obj);
        return this.userData.indexOf(obj);
    }

    public void setUserData(int i, Object obj) {
        if (i >= 0 && i <= this.userData.size()) {
            this.userData.add(i, obj);
        }
    }

    public int getUserDataSize() {
        return this.userData.size();
    }

    public String getLicenseMessage() {
        return this.licenseMessage;
    }

    public void setNameLib(String str) {
        this.nameLib = str;
    }

    public String getNameLib() {
        return this.nameLib;
    }

    public String getFullPathLib() {
        return this.fileDirection + "/" + getNameLib();
    }

    public void setNameFileDownload(String str) {
        this.nameFileDownload = str;
    }

    public void setUrlDownload(String str) {
        this.urlDownload = str;
    }

    public boolean isCodecFound() {
        return new File(this.fileDirection + "/" + this.nameLib).exists();
    }

    public void downloadCodec() {
        new Thread(new Runnable() { // from class: org.linphone.tools.OpenH264DownloadHelper.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    String str = OpenH264DownloadHelper.this.fileDirection + "/" + OpenH264DownloadHelper.this.nameLib;
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(OpenH264DownloadHelper.this.urlDownload).openConnection();
                    httpURLConnection.connect();
                    Log.i("OpenH264Downloader", " ");
                    InputStream inputStream = httpURLConnection.getInputStream();
                    FileOutputStream fileOutputStream = new FileOutputStream(OpenH264DownloadHelper.this.fileDirection + "/" + OpenH264DownloadHelper.this.nameFileDownload);
                    int contentLength = httpURLConnection.getContentLength();
                    OpenH264DownloadHelper.this.openH264DownloadHelperListener.OnProgress(0, contentLength);
                    Log.i("OpenH264Downloader", " Download file:" + OpenH264DownloadHelper.this.nameFileDownload);
                    byte[] bArr = new byte[4096];
                    int i = 0;
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        i += read;
                        fileOutputStream.write(bArr, 0, read);
                        OpenH264DownloadHelper.this.openH264DownloadHelperListener.OnProgress(i, contentLength);
                    }
                    fileOutputStream.close();
                    inputStream.close();
                    Log.i("OpenH264Downloader", " Uncompress file:" + OpenH264DownloadHelper.this.nameFileDownload);
                    FileInputStream fileInputStream = new FileInputStream(OpenH264DownloadHelper.this.fileDirection + "/" + OpenH264DownloadHelper.this.nameFileDownload);
                    FileOutputStream fileOutputStream2 = new FileOutputStream(str);
                    BZip2CompressorInputStream bZip2CompressorInputStream = new BZip2CompressorInputStream(fileInputStream);
                    while (true) {
                        int read2 = bZip2CompressorInputStream.read(bArr);
                        if (read2 > 0) {
                            fileOutputStream2.write(bArr, 0, read2);
                        } else {
                            fileInputStream.close();
                            fileOutputStream2.close();
                            bZip2CompressorInputStream.close();
                            Log.i("OpenH264Downloader", " Remove file:" + OpenH264DownloadHelper.this.nameFileDownload);
                            new File(OpenH264DownloadHelper.this.fileDirection + "/" + OpenH264DownloadHelper.this.nameFileDownload).delete();
                            Log.i("OpenH264Downloader", " Loading plugin:" + str);
                            System.load(str);
                            OpenH264DownloadHelper.this.openH264DownloadHelperListener.OnProgress(2, 1);
                            return;
                        }
                    }
                } catch (FileNotFoundException e) {
                    OpenH264DownloadHelper.this.openH264DownloadHelperListener.OnError(e.getLocalizedMessage());
                } catch (IOException e2) {
                    OpenH264DownloadHelper.this.openH264DownloadHelperListener.OnError(e2.getLocalizedMessage());
                }
            }
        }).start();
    }
}
