package com.netflix.mediaclient.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import android.text.format.Formatter;
import com.netflix.mediaclient.service.net.LogMobileType;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import o.C1283;
import o.C1349Bv;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
public final class ConnectivityUtils {

    public enum NetType {
        wifi,
        mobile,
        wired
    }

    @SuppressLint({"netflix.GetWifiManager"})
    /* renamed from: ˎ  reason: contains not printable characters */
    public static WifiManager m2961(Context context) {
        if (context == null) {
            return null;
        }
        return (WifiManager) context.getApplicationContext().getSystemService("wifi");
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static boolean m2964(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null!");
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static LogMobileType m2956(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("Activity cannot be null!");
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return LogMobileType.UKNOWN;
        }
        return LogMobileType.m812(activeNetworkInfo);
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static NetworkInfo m2967(Context context) {
        ConnectivityManager connectivityManager;
        if (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null) {
            return null;
        }
        return connectivityManager.getActiveNetworkInfo();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static String m2959(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        if (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null || connectivityManager.getActiveNetworkInfo() == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
            return "";
        }
        C1283.m16854("nf_net", "networkInfo type: " + activeNetworkInfo.getType());
        switch (activeNetworkInfo.getType()) {
            case 1:
                return "wifi";
            case 2:
            case 3:
            case 4:
            case 5:
            case 8:
            default:
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager == null) {
                    return "mobile";
                }
                C1283.m16854("nf_net", "tm type: " + telephonyManager.getPhoneType());
                switch (telephonyManager.getPhoneType()) {
                    case 1:
                        return "gsm";
                    case 2:
                        return "cdma";
                    default:
                        return "mobile";
                }
            case 6:
                return "wimax";
            case 7:
                return "bluetooth";
            case 9:
                return "wired";
        }
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public static boolean m2952(Context context) {
        String r1 = m2959(context);
        if (r1.equals("mobile") || r1.equals("cdma") || r1.equals("gsm")) {
            return true;
        }
        return false;
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public static boolean m2969(Context context) {
        ConnectivityManager connectivityManager;
        TelephonyManager telephonyManager;
        if (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null || connectivityManager.getActiveNetworkInfo() == null || (telephonyManager = (TelephonyManager) context.getSystemService("phone")) == null) {
            return false;
        }
        int simState = telephonyManager.getSimState();
        if (simState == 5) {
            return true;
        }
        C1283.m16854("nf_net", "tm simState: " + simState);
        return false;
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public static boolean m2954(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        if (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
            return false;
        }
        return activeNetworkInfo.isConnected();
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    public static boolean m2970(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        if (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
            return false;
        }
        return activeNetworkInfo.isConnectedOrConnecting();
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public static boolean m2955(Context context) {
        if (context == null) {
            return false;
        }
        return LogMobileType.WIFI.equals(m2956(context));
    }

    /* renamed from: ˋॱ  reason: contains not printable characters */
    public static String m2960(Context context) {
        WifiInfo connectionInfo;
        WifiManager r1 = m2961(context);
        if (r1 == null || r1.getConnectionInfo() == null || (connectionInfo = r1.getConnectionInfo()) == null) {
            return null;
        }
        return Formatter.formatIpAddress(connectionInfo.getIpAddress());
    }

    /* renamed from: ˏॱ  reason: contains not printable characters */
    public static String m2965(Context context) {
        try {
            String r3 = m2960(context);
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            if (networkInterfaces == null) {
                return null;
            }
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface nextElement = networkInterfaces.nextElement();
                if (nextElement != null) {
                    if (!nextElement.isLoopback()) {
                        if (!nextElement.isVirtual()) {
                            if (nextElement.isUp()) {
                                if (nextElement.getInetAddresses() != null) {
                                    Enumeration<InetAddress> inetAddresses = nextElement.getInetAddresses();
                                    while (true) {
                                        if (!inetAddresses.hasMoreElements()) {
                                            continue;
                                            break;
                                        }
                                        InetAddress nextElement2 = inetAddresses.nextElement();
                                        C1283.m16854("nf_net", "" + nextElement2);
                                        if (!nextElement2.isLoopbackAddress() && (nextElement2 instanceof Inet4Address)) {
                                            String hostAddress = nextElement2.getHostAddress();
                                            if (r3 == null || !r3.equals(hostAddress)) {
                                                return hostAddress;
                                            }
                                            C1283.m16854("nf_net", "WiFi interface found in all network interfaces, skip!");
                                        }
                                    }
                                } else {
                                    continue;
                                }
                            } else {
                                C1283.m16854("nf_net", "NI is not up, skip");
                            }
                        } else {
                            C1283.m16854("nf_net", "NI is virtual, skip");
                        }
                    } else {
                        C1283.m16854("nf_net", "NI is loopback, skip");
                    }
                }
            }
            return null;
        } catch (Throwable th) {
            C1283.m16847("nf_net", "Failed to get IP address", th);
            return null;
        }
    }

    /* renamed from: ॱˊ  reason: contains not printable characters */
    public static List<String> m2968(Context context) {
        LinkProperties linkProperties;
        ArrayList arrayList = new ArrayList();
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        Network activeNetwork = connectivityManager.getActiveNetwork();
        if (!(activeNetwork == null || (linkProperties = connectivityManager.getLinkProperties(activeNetwork)) == null)) {
            for (InetAddress inetAddress : linkProperties.getDnsServers()) {
                arrayList.add(inetAddress.getHostAddress());
            }
        }
        return arrayList;
    }

    /* renamed from: ͺ  reason: contains not printable characters */
    public static String m2966(Context context) {
        if (context == null) {
            return null;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        NetworkInfo networkInfo = null;
        if (connectivityManager != null) {
            networkInfo = connectivityManager.getActiveNetworkInfo();
        }
        if (networkInfo == null || networkInfo.getTypeName() == null || !"WIFI".equals(networkInfo.getTypeName().toUpperCase())) {
            C1283.m16854("nf_net", "Local active network interface is Mobile (it also covers everything else).");
            return m2965(context);
        }
        C1283.m16854("nf_net", "Local active network interface is WiFi");
        return m2960(context);
    }

    /* renamed from: ˊॱ  reason: contains not printable characters */
    public static NetType m2958(Context context) {
        NetworkInfo r1 = m2967(context);
        if (r1 == null) {
            return null;
        }
        switch (r1.getType()) {
            case 1:
                return NetType.wifi;
            case 9:
                return NetType.wired;
            default:
                return NetType.mobile;
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static String m2962(WifiManager wifiManager) {
        WifiInfo connectionInfo;
        String ssid;
        return (wifiManager == null || (connectionInfo = wifiManager.getConnectionInfo()) == null || (ssid = connectionInfo.getSSID()) == null) ? "" : ssid;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static String m2963(TelephonyManager telephonyManager) {
        String networkOperatorName;
        if (telephonyManager == null || (networkOperatorName = telephonyManager.getNetworkOperatorName()) == null) {
            return "";
        }
        return networkOperatorName;
    }

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    public static int m2971(Context context) {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
            return -1;
        }
        return activeNetworkInfo.getType();
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static JSONObject m2957(JSONObject jSONObject, NetType netType) {
        try {
            if (NetType.mobile.equals(netType)) {
                jSONObject.put("nettype", "mobile");
            } else if (NetType.wifi.equals(netType)) {
                jSONObject.put("nettype", "wifi");
            } else if (NetType.wired.equals(netType)) {
                jSONObject.put("nettype", "wired");
            } else {
                jSONObject.put("nettype", "mobile");
            }
        } catch (JSONException e) {
            C1283.m16847("nf_net", "error adding nettype to json", e);
        }
        return jSONObject;
    }

    /* renamed from: ʻॱ  reason: contains not printable characters */
    public static JSONObject m2953(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            return null;
        }
        String simOperatorName = telephonyManager.getSimOperatorName();
        String simOperator = telephonyManager.getSimOperator();
        if (C1349Bv.m4113(simOperatorName) || C1349Bv.m4113(simOperator)) {
            return null;
        }
        String networkOperatorName = telephonyManager.getNetworkOperatorName();
        String networkOperator = telephonyManager.getNetworkOperator();
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject2.put("simindex", "1");
            jSONObject2.put("name", simOperatorName);
            jSONObject2.put("mcc_mnc", simOperator);
            jSONArray.put(jSONObject2);
            jSONObject3.put("name", networkOperatorName);
            jSONObject3.put("mcc_mnc", networkOperator);
            jSONObject.put("siminfo", jSONArray);
            jSONObject.put("currentoperator", jSONObject3);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
