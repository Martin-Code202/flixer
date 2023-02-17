package o;

import com.google.gson.JsonElement;
import java.util.Map;
/* renamed from: o.Cw  reason: case insensitive filesystem */
public class C1380Cw extends AbstractC1381Cx {

    /* renamed from: ˏ  reason: contains not printable characters */
    public C0082 f5232;

    public C1380Cw(AbstractC0929<? extends AbstractC0730> r1) {
        super(r1);
    }

    @Override // o.AbstractC0730
    public Object get(String str) {
        char c = 65535;
        switch (str.hashCode()) {
            case -1857640538:
                if (str.equals("summary")) {
                    c = 0;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return this.f5232;
            default:
                return null;
        }
    }

    @Override // o.AbstractC0730
    public Object getOrCreate(String str) {
        Object obj = get(str);
        if (obj != null) {
            return obj;
        }
        char c = 65535;
        switch (str.hashCode()) {
            case -1857640538:
                if (str.equals("summary")) {
                    c = 0;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                C0082 r0 = new C0082();
                this.f5232 = r0;
                return r0;
            default:
                return null;
        }
    }

    @Override // o.AbstractC0730
    public void set(String str, Object obj) {
        if ("summary".equals(str)) {
            this.f5232 = (C0082) obj;
            return;
        }
        throw new IllegalStateException("Can't set key: " + str);
    }

    @Override // o.AbstractC0730
    public void remove(String str) {
        set(str, null);
    }

    /* renamed from: o.Cw$ˊ  reason: contains not printable characters */
    public static class C0082 implements AbstractC0852 {

        /* renamed from: ʻ  reason: contains not printable characters */
        public String f5233;

        /* renamed from: ˊ  reason: contains not printable characters */
        public String f5234;

        /* renamed from: ˋ  reason: contains not printable characters */
        public float f5235;

        /* renamed from: ˎ  reason: contains not printable characters */
        public float f5236;

        /* renamed from: ˏ  reason: contains not printable characters */
        public String f5237;

        /* renamed from: ॱ  reason: contains not printable characters */
        public String f5238;

        /* renamed from: ॱॱ  reason: contains not printable characters */
        public String f5239;

        @Override // o.AbstractC0852
        public void populate(JsonElement jsonElement) {
            for (Map.Entry<String, JsonElement> entry : jsonElement.getAsJsonObject().entrySet()) {
                JsonElement value = entry.getValue();
                String key = entry.getKey();
                char c = 65535;
                switch (key.hashCode()) {
                    case -1181220621:
                        if (key.equals("stillImageWidth")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 443163472:
                        if (key.equals("personId")) {
                            c = 6;
                            break;
                        }
                        break;
                    case 452782838:
                        if (key.equals("videoId")) {
                            c = 5;
                            break;
                        }
                        break;
                    case 530612188:
                        if (key.equals("stillImageUrl")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 1603871642:
                        if (key.equals("stillImageHeight")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 2033484211:
                        if (key.equals("stillImageXFocus")) {
                            c = 3;
                            break;
                        }
                        break;
                    case 2062113362:
                        if (key.equals("stillImageYFocus")) {
                            c = 4;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        this.f5234 = value.getAsString();
                        break;
                    case 1:
                        this.f5238 = value.getAsString();
                        break;
                    case 2:
                        this.f5237 = value.getAsString();
                        break;
                    case 3:
                        this.f5235 = value.getAsFloat();
                        break;
                    case 4:
                        this.f5236 = value.getAsFloat();
                        break;
                    case 5:
                        this.f5239 = value.getAsString();
                        break;
                    case 6:
                        this.f5233 = value.getAsString();
                        break;
                }
            }
        }
    }
}
