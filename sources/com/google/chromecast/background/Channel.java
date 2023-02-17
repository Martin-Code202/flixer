package com.google.chromecast.background;

import android.util.Log;
import com.google.android.gms.cast.CastDevice;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import org.json.JSONException;
import org.json.JSONObject;
public class Channel {
    private static BlockingWebSocketClient backgroundWebSocket = null;
    private static final Object sendMessageLock = new Object();

    /* access modifiers changed from: private */
    public static void log(String str) {
        Log.i("Background", str);
    }

    /* access modifiers changed from: package-private */
    public static class BlockingWebSocketClient extends WebSocketClient {
        private CountDownLatch receiveSignal = null;
        private String response;

        BlockingWebSocketClient(URI uri) {
            super(uri);
        }

        private void clearWebSocketSingleton() {
            if (Channel.backgroundWebSocket != null) {
                Channel.backgroundWebSocket.close();
            }
            BlockingWebSocketClient unused = Channel.backgroundWebSocket = null;
        }

        @Override // org.java_websocket.client.WebSocketClient
        public void onOpen(ServerHandshake serverHandshake) {
            Channel.log("Channel opened");
        }

        @Override // org.java_websocket.client.WebSocketClient
        public void onMessage(String str) {
            this.response = str;
            this.receiveSignal.countDown();
        }

        @Override // org.java_websocket.client.WebSocketClient
        public void onClose(int i, String str, boolean z) {
            Channel.log("Channel closed " + str);
            clearWebSocketSingleton();
        }

        @Override // org.java_websocket.client.WebSocketClient
        public void onError(Exception exc) {
            Channel.log("Channel error " + exc.getMessage());
            clearWebSocketSingleton();
        }

        public int sendAndWaitAck(String str) {
            this.receiveSignal = new CountDownLatch(1);
            send(str);
            try {
                this.receiveSignal.await(3, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if ("ACK".equals(this.response)) {
                return 0;
            }
            if ("NACK".equals(this.response)) {
                Log.w("Background", "Receiver is running in foreground");
                return 2;
            }
            Log.w("Background", "Got no response from receiver for 3 sec");
            clearWebSocketSingleton();
            return 1;
        }
    }

    private static BlockingWebSocketClient connectWebSocket(String str) {
        log("Connect channel >>");
        try {
            BlockingWebSocketClient blockingWebSocketClient = new BlockingWebSocketClient(new URI(str));
            try {
                log("Waiting for connection te be established");
                blockingWebSocketClient.connectBlocking();
                log("Web socket connection is established");
                Log.i("Background", "Background channel is established");
                return blockingWebSocketClient;
            } catch (InterruptedException e) {
                e.printStackTrace();
                return null;
            }
        } catch (URISyntaxException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static BlockingWebSocketClient getWebSocket(String str) {
        String str2 = "http://" + str + ":8008/connection/CAST.BACKGROUND.CHANNEL";
        log("VERSION: 0.0.1");
        String str3 = null;
        try {
            str3 = getWebSocketUrl(str2);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (str3 != null) {
            return connectWebSocket(str3);
        }
        Log.e("Background", "Cannot get a connection");
        return null;
    }

    public static int sendMessage(CastDevice castDevice, String str) {
        return sendMessage(castDevice.getIpAddress().getHostAddress(), str);
    }

    public static int sendMessage(String str, String str2) {
        synchronized (sendMessageLock) {
            if (backgroundWebSocket == null) {
                backgroundWebSocket = getWebSocket(str);
                if (backgroundWebSocket == null) {
                    return 1;
                }
            }
            return backgroundWebSocket.sendAndWaitAck(str2);
        }
    }

    private static String getHttpResponse(String str) {
        log("get connection query response >>");
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setConnectTimeout(3000);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("Content-Type", "application/json");
        httpURLConnection.connect();
        JSONObject jSONObject = new JSONObject();
        DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
        dataOutputStream.write(jSONObject.toString().getBytes("UTF-8"));
        dataOutputStream.flush();
        dataOutputStream.close();
        int responseCode = httpURLConnection.getResponseCode();
        if (responseCode != 200) {
            Log.e("Background", "Failed http request with response code: " + responseCode);
            httpURLConnection.disconnect();
            return null;
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
        String str2 = "";
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                str2 = str2 + readLine;
            } else {
                httpURLConnection.disconnect();
                return str2;
            }
        }
    }

    private static String getWebSocketUrl(String str) {
        log("get connection url");
        String httpResponse = getHttpResponse(str);
        if (httpResponse == null) {
            Log.e("Background", "getHttpResponse() failed");
            return null;
        }
        try {
            return new JSONObject(httpResponse).getString("URL");
        } catch (JSONException e) {
            Log.e("Background", "JSON", e);
            return null;
        }
    }
}
