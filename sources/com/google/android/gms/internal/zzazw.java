package com.google.android.gms.internal;

import com.google.android.gms.common.api.Api;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;
public final class zzazw {
    public static final Api.zzf<zzaze> zzfbx = new Api.zzf<>();
    public static final Api.zzf<Object> zzfby = new Api.zzf<>();
    public static final Api.zzf<Object> zzfbz = new Api.zzf<>();
    private static Api.zzf<Object> zzfca = new Api.zzf<>();
    private static Api.zzf<Object> zzfcb = new Api.zzf<>();
    private static Charset zzfcc;
    private static String zzfcd = zzazl.zzfh("com.google.cast.multizone");

    static {
        Charset charset = null;
        try {
            charset = Charset.forName("UTF-8");
        } catch (IllegalCharsetNameException unused) {
        } catch (UnsupportedCharsetException unused2) {
        }
        zzfcc = charset;
    }
}
