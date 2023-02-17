package com.netflix.mediaclient.service.mdx.logging.connection;

import com.netflix.mediaclient.service.mdx.logging.MdxTargetType;
import o.AbstractC1775fh;
import org.json.JSONException;
public class ConnectLogblob extends AbstractC1775fh {

    public enum LaunchOrigin {
        Launch("launch");
        

        /* renamed from: ॱ  reason: contains not printable characters */
        private String f1325;

        private LaunchOrigin(String str) {
            this.f1325 = str;
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        public String m683() {
            return this.f1325;
        }
    }

    public ConnectLogblob(String str, long j, LaunchOrigin launchOrigin, MdxTargetType mdxTargetType, String str2, String str3, boolean z) {
        super(str, j);
        try {
            this.f6134.put("mdxver", "2014.1");
            this.f6134.put("uilaunchorigin", launchOrigin != null ? launchOrigin.m683() : "");
            this.f6134.put("targettype", mdxTargetType.m682());
            this.f6134.put("deviceid", str2 != null ? str2 : "");
            this.f6134.put("devicename", str3 != null ? str3 : "");
            this.f6134.put("usermismatch", String.valueOf(z));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override // com.netflix.mediaclient.servicemgr.Logblob
    /* renamed from: ˋ */
    public String mo680() {
        return "connect";
    }
}
