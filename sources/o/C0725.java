package o;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.regex.Pattern;
/* renamed from: o.Ꮠ  reason: contains not printable characters */
public class C0725 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private HashSet<String> f14265;

    /* renamed from: ˋ  reason: contains not printable characters */
    private ArrayList<If> f14266 = new ArrayList<>();

    /* access modifiers changed from: package-private */
    /* renamed from: o.Ꮠ$If */
    public class If {

        /* renamed from: ˊ  reason: contains not printable characters */
        String f14267;

        /* renamed from: ˏ  reason: contains not printable characters */
        Pattern f14269;

        public If(String str, String str2) {
            this.f14269 = Pattern.compile(str);
            this.f14267 = str2;
        }
    }

    public C0725(String str) {
        C0719[] r4 = (C0719[]) new Gson().fromJson(str, (Class<Object>) C0719[].class);
        this.f14265 = new HashSet<>(r4.length > 0 ? r4.length : 16);
        for (C0719 r8 : r4) {
            if (!(r8 == null || r8.hostnamepatterns == null)) {
                this.f14265.add(r8.category);
                for (String str2 : r8.hostnamepatterns) {
                    this.f14266.add(new If(str2, r8.category));
                }
            }
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public String[] m15062() {
        return (String[]) this.f14265.toArray(new String[this.f14265.size()]);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public String m15063(String str) {
        Iterator<If> it = this.f14266.iterator();
        while (it.hasNext()) {
            If next = it.next();
            if (next.f14269.matcher(str).matches()) {
                return next.f14267;
            }
        }
        return "NOMATCH";
    }
}
