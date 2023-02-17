package o;

import com.netflix.model.leafs.social.IrisNotificationSummary;
/* renamed from: o.Cy  reason: case insensitive filesystem */
public class C1382Cy extends AbstractC1381Cx {

    /* renamed from: ˊ  reason: contains not printable characters */
    public C1049 f5240;

    /* renamed from: ˏ  reason: contains not printable characters */
    public IrisNotificationSummary f5241;

    public C1382Cy(AbstractC0929<? extends AbstractC0730> r1) {
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
            case -1580566960:
                if (str.equals("notificationVideo")) {
                    c = 1;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return this.f5241;
            case 1:
                return this.f5240;
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
            case -1580566960:
                if (str.equals("notificationVideo")) {
                    c = 1;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                IrisNotificationSummary irisNotificationSummary = new IrisNotificationSummary();
                this.f5241 = irisNotificationSummary;
                return irisNotificationSummary;
            case 1:
                C1049 r0 = new C1049();
                this.f5240 = r0;
                return r0;
            default:
                return null;
        }
    }

    @Override // o.AbstractC0730
    public void set(String str, Object obj) {
        if ("summary".equals(str)) {
            this.f5241 = (IrisNotificationSummary) obj;
        } else if ("notificationVideo".equals(str)) {
            this.f5240 = (C1049) obj;
        } else {
            throw new IllegalStateException("Can't set key: " + str);
        }
    }

    @Override // o.AbstractC0730
    public void remove(String str) {
        set(str, null);
    }
}
