package o;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.netflix.mediaclient.service.net.NetworkType;
import com.netflix.mediaclient.service.player.StreamProfileType;
import com.netflix.mediaclient.util.ConnectivityUtils;
import java.util.HashMap;
import java.util.Map;
/* renamed from: o.ki  reason: case insensitive filesystem */
public class C1938ki extends BroadcastReceiver implements AbstractC1949kt {

    /* renamed from: ʻ  reason: contains not printable characters */
    private final AbstractC0661 f8388;

    /* renamed from: ʼ  reason: contains not printable characters */
    private final kB f8389;

    /* renamed from: ˊ$781c85fd  reason: contains not printable characters */
    private final Object f8390$781c85fd;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final int f8391;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final Gson f8392;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final Context f8393;

    /* renamed from: ॱ  reason: contains not printable characters */
    private C1947kr f8394;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final Map<StreamProfileType, Integer> f8395 = new HashMap();

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final int f8396;

    public C1938ki(Context context, AbstractC1221 r12, AbstractC0661 r13) {
        this.f8393 = context;
        this.f8391 = r12.mo16516();
        this.f8396 = 2621440;
        m8382(context);
        this.f8393.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setVersion(1.0d);
        this.f8392 = gsonBuilder.create();
        this.f8390$781c85fd = m8381$3bf1fa44();
        this.f8389 = new kB(this.f8392, C1339Bl.m4045(this.f8393, "streamingConfig", (String) null));
        this.f8388 = r13;
        StreamProfileType[] values = StreamProfileType.values();
        for (StreamProfileType streamProfileType : values) {
            int r9 = C0577.m14685(context, r12.mo16540(streamProfileType));
            if (r9 > 0) {
                this.f8395.put(streamProfileType, Integer.valueOf(r9));
            }
        }
    }

    @Override // o.AbstractC1949kt
    /* renamed from: ॱ$3bf1fa44  reason: contains not printable characters */
    public Object mo8391$3bf1fa44() {
        return this.f8390$781c85fd;
    }

    /* renamed from: ʽ$3bf1fa44  reason: contains not printable characters */
    private Object m8381$3bf1fa44() {
        String r4 = C1339Bl.m4045(this.f8393, "ase_persistent_data", (String) null);
        C1283.m16863("AsePlatformContext", "restore ASE persisted data %s .", r4);
        if (C1349Bv.m4107(r4)) {
            try {
                return this.f8392.fromJson(r4, (Class<Object>) ((Class) C1235.m16591(11, 4, 30636)));
            } catch (JsonSyntaxException e) {
                C1283.m16855("AsePlatformContext", "has JsonSyntaxException %s .", e);
            }
        }
        try {
            return ((Class) C1235.m16591(11, 4, 30636)).getDeclaredConstructor(null).newInstance(null);
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m8389() {
        synchronized (this.f8390$781c85fd) {
            String json = this.f8392.toJson(this.f8390$781c85fd);
            C1339Bl.m4039(this.f8393, "ase_persistent_data", json);
            C1283.m16863("AsePlatformContext", "save ASE persisted data %s .", json);
        }
    }

    @Override // o.AbstractC1949kt
    /* renamed from: ˎ$5e5740c4  reason: contains not printable characters */
    public Object mo8388$5e5740c4(StreamProfileType streamProfileType, String str) {
        C1283.m16863("AsePlatformContext", "get streaming config for flavor %s, uiLabel %s .", streamProfileType.name(), str);
        return this.f8389.m8182$59fb67b1(streamProfileType.m934(), str);
    }

    @Override // o.AbstractC1949kt
    /* renamed from: ˊ  reason: contains not printable characters */
    public C1947kr mo8384() {
        return this.f8394;
    }

    @Override // o.AbstractC1949kt
    /* renamed from: ˎ  reason: contains not printable characters */
    public int mo8386() {
        return this.f8391;
    }

    @Override // o.AbstractC1949kt
    /* renamed from: ˋ  reason: contains not printable characters */
    public int mo8385() {
        return this.f8396;
    }

    @Override // o.AbstractC1949kt
    /* renamed from: ʻ  reason: contains not printable characters */
    public int mo8383() {
        return this.f8388.mo14821();
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public int m8387(StreamProfileType streamProfileType) {
        if (this.f8395.get(streamProfileType) != null) {
            return this.f8395.get(streamProfileType).intValue();
        }
        return Integer.MAX_VALUE;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public boolean m8390(StreamProfileType streamProfileType, String str, int i, int i2) {
        Object r12 = mo8388$5e5740c4(streamProfileType, str);
        int i3 = i / 1000;
        int r2 = mo8386() + mo8385();
        double d = ((Class) C1235.m16591(3, 4, 51741)).getField("mediaRate").getDouble(r12);
        int i4 = ((Class) C1235.m16591(3, 4, 51741)).getField("minInitVideoBitrate").getInt(r12);
        int i5 = ((Class) C1235.m16591(3, 4, 51741)).getField("minAcceptableVideoBitrate").getInt(r12);
        int i6 = ((Class) C1235.m16591(3, 4, 51741)).getField("maxInitVideoBitrate").getInt(r12);
        int i7 = ((Class) C1235.m16591(3, 4, 51741)).getField("minRequiredBuffer").getInt(r12);
        int i8 = ((Class) C1235.m16591(3, 4, 51741)).getField("minPrebufSize").getInt(r12);
        try {
            Object[] objArr = new Object[10];
            objArr[9] = Integer.valueOf(((Class) C1235.m16591(3, 4, 51741)).getField("maxBufferingTime").getInt(r12));
            objArr[8] = Integer.valueOf(i8);
            objArr[7] = Integer.valueOf(i7);
            objArr[6] = Integer.valueOf(i6);
            objArr[5] = Integer.valueOf(i5);
            objArr[4] = Integer.valueOf(i4);
            objArr[3] = Double.valueOf(d);
            objArr[2] = Integer.valueOf(r2);
            objArr[1] = Integer.valueOf(i2);
            objArr[0] = Integer.valueOf(i3);
            return ((Boolean) ((Class) C1235.m16591(7, 4, 6398)).getMethod("ˏ", Integer.TYPE, Integer.TYPE, Integer.TYPE, Double.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE).invoke(null, objArr)).booleanValue();
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    public void m8392() {
        m8389();
        this.f8393.unregisterReceiver(this);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m8382(Context context) {
        NetworkInfo r6 = ConnectivityUtils.m2967(context);
        if (r6 != null) {
            int type = r6.getType();
            String typeName = r6.getTypeName();
            C1283.m16863("AsePlatformContext", "has active network  %s .", typeName);
            boolean isConnectedOrConnecting = r6.isConnectedOrConnecting();
            String r10 = ConnectivityUtils.m2966(context);
            if (C1947kr.m8433(type)) {
                this.f8394 = new kx(typeName, type, isConnectedOrConnecting, r10, NetworkType.m814(r6.getSubtype()));
            } else if (C1947kr.m8434(type)) {
                int i = -1;
                WifiManager r12 = ConnectivityUtils.m2961(context);
                if (r12 != null) {
                    WifiInfo connectionInfo = r12.getConnectionInfo();
                    if (connectionInfo != null) {
                        i = connectionInfo.getNetworkId();
                    }
                    this.f8394 = new kE(typeName, type, isConnectedOrConnecting, r10, i);
                }
            } else {
                this.f8394 = new C1947kr(typeName, type, isConnectedOrConnecting, r10);
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        m8382(context);
    }
}
