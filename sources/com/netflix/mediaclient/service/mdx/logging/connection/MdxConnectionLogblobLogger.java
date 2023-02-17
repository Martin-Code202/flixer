package com.netflix.mediaclient.service.mdx.logging.connection;

import com.netflix.mediaclient.service.mdx.logging.MdxErrorCode;
import com.netflix.mediaclient.service.mdx.logging.MdxTargetType;
import com.netflix.mediaclient.service.mdx.logging.connection.ConnectLogblob;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import o.AbstractC1221;
import o.C1283;
import o.C1768fb;
import o.C1770fd;
import o.C1774fg;
import o.C1776fi;
import o.C1777fj;
import o.oQ;
public class MdxConnectionLogblobLogger {

    /* renamed from: ˊ  reason: contains not printable characters */
    private static final String f1326 = MdxConnectionLogblobLogger.class.getSimpleName();

    /* renamed from: ˏ  reason: contains not printable characters */
    private static long f1327 = 0;

    /* renamed from: ॱ  reason: contains not printable characters */
    private static ConnectionState f1328 = ConnectionState.NotStarted;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final AbstractC1221 f1329;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final oQ f1330;

    /* access modifiers changed from: package-private */
    public enum ConnectionState {
        NotStarted,
        Starting,
        NotConnected,
        Connecting,
        Connected,
        Reconnecting,
        Disconnecting;
        

        /* renamed from: ʽ  reason: contains not printable characters */
        private static final Map<ConnectionState, List<ConnectionState>> f1332 = new HashMap();

        static {
            f1332.put(NotStarted, Arrays.asList(Starting));
            f1332.put(Starting, Arrays.asList(NotStarted, NotConnected));
            f1332.put(NotConnected, Arrays.asList(Connecting));
            f1332.put(Connecting, Arrays.asList(NotConnected, Connected));
            f1332.put(Connected, Arrays.asList(Reconnecting, Disconnecting));
            f1332.put(Reconnecting, Arrays.asList(Connected));
            f1332.put(Disconnecting, Arrays.asList(Connected, NotConnected));
        }

        /* access modifiers changed from: package-private */
        /* renamed from: ˋ  reason: contains not printable characters */
        public boolean m704(ConnectionState connectionState) {
            return f1332.containsKey(this) && f1332.get(this).contains(connectionState);
        }
    }

    public MdxConnectionLogblobLogger(oQ oQVar, AbstractC1221 r2) {
        this.f1330 = oQVar;
        this.f1329 = r2;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static void m690() {
        m687(ConnectionState.Starting);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static void m694() {
        m687(ConnectionState.Connecting);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static void m685() {
        m687(ConnectionState.Reconnecting);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static void m691() {
        m687(ConnectionState.Disconnecting);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static boolean m688() {
        return ConnectionState.Reconnecting.equals(f1328);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static void m687(ConnectionState connectionState) {
        if (f1328.m704(connectionState)) {
            C1283.m16863(f1326, "State changed from %s to %s", f1328, connectionState);
            f1328 = connectionState;
            f1327 = System.currentTimeMillis();
        }
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public void m697() {
        if (m686(ConnectionState.NotConnected, "MDX Init")) {
            long r5 = m696();
            this.f1330.mo5226(m689(r5));
            m687(ConnectionState.NotConnected);
            C1283.m16863(f1326, "onMdxInit - delay: %s", Long.valueOf(r5));
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m698(MdxErrorCode mdxErrorCode, String str, String str2, String str3, String str4) {
        if (m686(ConnectionState.NotStarted, "MDX Init Error")) {
            long r6 = m696();
            C1774fg r8 = m689(r6);
            r8.m6379(new C1768fb(mdxErrorCode, str, str2, str3, str4));
            this.f1330.mo5226(r8);
            m687(ConnectionState.NotStarted);
            C1283.m16863(f1326, "onMdxInitError - delay %s, code: %s, subCode: %s, extCode: %s, details: %s, timeout: %s", Long.valueOf(r6), mdxErrorCode, str, str2, str3, str4);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m699(ConnectLogblob.LaunchOrigin launchOrigin, MdxTargetType mdxTargetType, String str, String str2, boolean z) {
        if (m686(ConnectionState.Connected, "Connect")) {
            long r9 = m696();
            this.f1330.mo5226(m684(r9, launchOrigin, mdxTargetType, str, str2, z));
            m687(ConnectionState.Connected);
            C1283.m16863(f1326, "onConnect - delay: %s, origin: %s, targetType: %s, deviceId: %s, deviceName: %s, userMismatch: %b", Long.valueOf(r9), launchOrigin, mdxTargetType.m682(), str, str2, Boolean.valueOf(z));
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m700(ConnectLogblob.LaunchOrigin launchOrigin, MdxTargetType mdxTargetType, String str, String str2, boolean z, MdxErrorCode mdxErrorCode, String str3, String str4, String str5, String str6) {
        if (m686(ConnectionState.NotConnected, "Connect Error")) {
            long r8 = m696();
            ConnectLogblob r10 = m684(r8, launchOrigin, mdxTargetType, str, str2, z);
            r10.m6379(new C1768fb(mdxErrorCode, str3, str4, str5, str6));
            this.f1330.mo5226(r10);
            m687(ConnectionState.NotConnected);
            C1283.m16863(f1326, "onConnectError - delay: %s, origin: %s, targetType: %s, deviceId: %s, deviceName: %s, userMismatch: %b, code: %s, subCode: %s, extCode: %s, details: %s, timeout: %s", Long.valueOf(r8), launchOrigin, mdxTargetType.m682(), str, str2, Boolean.valueOf(z), mdxErrorCode, str3, str4, str5, str6);
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m702(MdxTargetType mdxTargetType, String str, String str2, boolean z) {
        if (m686(ConnectionState.Connected, "Reconnect")) {
            long r8 = m696();
            this.f1330.mo5226(m692(r8, mdxTargetType, str, str2, z));
            m687(ConnectionState.Connected);
            C1283.m16863(f1326, "onReconnect - delay: %s, targetType: %s, deviceId: %s, deviceName: %s, userMismatch: %b", Long.valueOf(r8), mdxTargetType.m682(), str, str2, Boolean.valueOf(z));
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m703(MdxTargetType mdxTargetType, String str, String str2, boolean z, MdxErrorCode mdxErrorCode, String str3, String str4, String str5, String str6) {
        if (m686(ConnectionState.Connected, "Reconnect Error")) {
            long r7 = m696();
            C1776fi r9 = m692(r7, mdxTargetType, str, str2, z);
            r9.m6379(new C1768fb(mdxErrorCode, str3, str4, str5, str6));
            this.f1330.mo5226(r9);
            m687(ConnectionState.Connected);
            C1283.m16863(f1326, "onReconnectError - delay: %s, targetType: %s, deviceId: %s, deviceName: %s, userMismatch: %b, code: %s, subCode: %s, extCode: %s, details: %s, timeout: %s", Long.valueOf(r7), mdxTargetType.m682(), str, str2, Boolean.valueOf(z), mdxErrorCode, str3, str4, str5, str6);
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m701(MdxTargetType mdxTargetType, String str, String str2) {
        if (m686(ConnectionState.NotConnected, "Disconnect")) {
            long r7 = m696();
            this.f1330.mo5226(m693(r7, mdxTargetType, str, str2));
            m687(ConnectionState.NotConnected);
            C1283.m16863(f1326, "onDisconnect - delay: %s, targetType: %s, deviceId: %s, deviceName: %s", Long.valueOf(r7), mdxTargetType.m682(), str, str2);
        }
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    private long m696() {
        return System.currentTimeMillis() - f1327;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private boolean m686(ConnectionState connectionState, String str) {
        if (!f1328.m704(connectionState)) {
            return false;
        }
        if (this.f1330 != null) {
            return true;
        }
        C1283.m16844(f1326, "MdxConnectionLogblobLogger can't log %s, since internal logger is null", str);
        return false;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private C1774fg m689(long j) {
        return new C1774fg(m695(), j);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private ConnectLogblob m684(long j, ConnectLogblob.LaunchOrigin launchOrigin, MdxTargetType mdxTargetType, String str, String str2, boolean z) {
        return new ConnectLogblob(m695(), j, launchOrigin, mdxTargetType, str, str2, z);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private C1776fi m692(long j, MdxTargetType mdxTargetType, String str, String str2, boolean z) {
        return new C1776fi(m695(), j, mdxTargetType, str, str2, z);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private C1777fj m693(long j, MdxTargetType mdxTargetType, String str, String str2) {
        return new C1777fj(m695(), j, mdxTargetType, str, str2);
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private String m695() {
        if (this.f1329 != null) {
            return C1770fd.m6380(this.f1329.mo16505());
        }
        return null;
    }
}
