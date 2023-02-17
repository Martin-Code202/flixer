package o;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.widget.ImageView;
import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.netflix.mediaclient.StatusCode;
import com.netflix.mediaclient.api.res.AssetType;
import com.netflix.mediaclient.service.webclient.model.leafs.UmaAlert;
import com.netflix.mediaclient.util.gfx.ImageLoader;
import java.util.HashMap;
import java.util.Iterator;
import o.C0524;
/* renamed from: o.no  reason: case insensitive filesystem */
public class C2011no implements ImageLoader {

    /* renamed from: ʻ  reason: contains not printable characters */
    private final Handler f9172;

    /* renamed from: ʼ  reason: contains not printable characters */
    private final HashMap<String, BR> f9173;

    /* renamed from: ʽ  reason: contains not printable characters */
    private long f9174;

    /* renamed from: ˊ  reason: contains not printable characters */
    private int f9175;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final int f9176;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final Object f9177;

    /* renamed from: ˏ  reason: contains not printable characters */
    HashMap<String, oN> f9178;

    /* renamed from: ˏॱ  reason: contains not printable characters */
    private Runnable f9179;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final C0482 f9180;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    private final HashMap<String, BR> f9181;

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final AbstractC0156 f9182;

    /* renamed from: o.no$ˊ  reason: contains not printable characters */
    public interface AbstractC0156 {
        /* renamed from: ˊ  reason: contains not printable characters */
        Bitmap m9343(String str);

        /* renamed from: ˊ  reason: contains not printable characters */
        void m9344(String str, Bitmap bitmap);
    }

    public C2011no(C0482 r1, AbstractC0156 r2, int i, long j) {
        this(r1, r2, i);
        this.f9174 = j;
    }

    private C2011no(C0482 r1, AbstractC0156 r2, int i) {
        this(r1, r2);
        this.f9175 = i;
    }

    private C2011no(C0482 r3, AbstractC0156 r4) {
        this.f9177 = "IMAGE";
        this.f9175 = -1;
        this.f9176 = 100;
        this.f9174 = -1;
        this.f9173 = new HashMap<>();
        this.f9181 = new HashMap<>();
        this.f9172 = new Handler(Looper.getMainLooper());
        this.f9178 = new HashMap<>();
        this.f9180 = r3;
        this.f9182 = r4;
    }

    @Override // com.netflix.mediaclient.util.gfx.ImageLoader
    /* renamed from: ˎ */
    public void mo3061(oN oNVar) {
        C1283.m16846("ImageLoader", "setInteractiveTracker -> " + oNVar.mo9577());
        if (this.f9178.containsKey(oNVar.mo9577())) {
            this.f9178.get(oNVar.mo9577()).mo9575(null);
        }
        this.f9178.put(oNVar.mo9577(), oNVar);
    }

    @Override // com.netflix.mediaclient.util.gfx.ImageLoader
    /* renamed from: ˊ */
    public oN mo3055(String str) {
        return this.f9178.get(str);
    }

    @Override // com.netflix.mediaclient.util.gfx.ImageLoader
    /* renamed from: ˎ */
    public void mo3058() {
        C1283.m16862("ImageLoader", "Cancelling all ImageLoader requests!");
        if (this.f9180 != null) {
            this.f9180.m14411(this.f9177);
        }
        if (this.f9173 != null) {
            this.f9173.clear();
        }
        for (oN oNVar : this.f9178.values()) {
            oNVar.mo9571();
        }
    }

    @Override // com.netflix.mediaclient.util.gfx.ImageLoader
    /* renamed from: ˎ */
    public void mo3059(String str, AssetType assetType, int i, int i2, AbstractC0957 r12) {
        mo3060(str, assetType, i, i2, r12, true);
    }

    @Override // com.netflix.mediaclient.util.gfx.ImageLoader
    /* renamed from: ˎ */
    public void mo3060(String str, AssetType assetType, int i, int i2, AbstractC0957 r14, boolean z) {
        m9335(str, assetType, m9321(r14), i, i2, Request.Priority.LOW, Bitmap.Config.RGB_565, z);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private ImageLoader.AbstractC0050 m9321(final AbstractC0957 r2) {
        return new ImageLoader.AbstractC0050() { // from class: o.no.2
            @Override // o.C0524.AbstractC2398iF
            public void onErrorResponse(VolleyError volleyError) {
                r2.onErrorResponse(volleyError == null ? null : volleyError.getMessage());
            }

            @Override // com.netflix.mediaclient.util.gfx.ImageLoader.AbstractC0050
            /* renamed from: ˋ */
            public void mo3067(BT bt, ImageLoader.AssetLocationType assetLocationType) {
                if (bt == null) {
                    r2.onResponse(null, null);
                } else {
                    r2.onResponse(bt.m3923(), bt.m3922());
                }
            }

            @Override // com.netflix.mediaclient.util.gfx.ImageLoader.AbstractC0050
            /* renamed from: ˋ */
            public String mo3066() {
                return null;
            }
        };
    }

    @Override // com.netflix.mediaclient.util.gfx.ImageLoader
    /* renamed from: ˊ */
    public void mo3056(AbstractC1188 r11, AssetType assetType) {
        C1283.m16846("ImageLoader", "refreshImgIfNecessary: " + r11);
        if (r11 == null) {
            C1283.m16846("ImageLoader", "refreshImgIfNecessary: null imageView");
            return;
        }
        C0638 r8 = r11.mo14544();
        if (r8 == null) {
            C1283.m16846("ImageLoader", "refreshImgIfNecessary: null image loader info object");
            return;
        }
        String str = r8.f13958;
        if (C1349Bv.m4113(str)) {
            C1283.m16846("ImageLoader", "refreshImgIfNecessary: empty url");
        } else {
            m9325(r11, str, assetType, r8.m14777(), false, 1, r8.f13956);
        }
    }

    @Override // com.netflix.mediaclient.util.gfx.ImageLoader
    /* renamed from: ˋ */
    public void mo3057(AbstractC1188 r10, String str, AssetType assetType, String str2, ImageLoader.If r14, boolean z) {
        mo3064(r10, str, assetType, str2, r14, z, 0, Bitmap.Config.RGB_565);
    }

    @Override // com.netflix.mediaclient.util.gfx.ImageLoader
    /* renamed from: ˏ */
    public void mo3063(AbstractC1188 r10, String str, AssetType assetType, String str2, ImageLoader.If r14, boolean z, int i) {
        mo3064(r10, str, assetType, str2, r14, z, i, Bitmap.Config.RGB_565);
    }

    @Override // com.netflix.mediaclient.util.gfx.ImageLoader
    /* renamed from: ॱ */
    public void mo3064(AbstractC1188 r11, String str, AssetType assetType, String str2, ImageLoader.If r15, boolean z, int i, Bitmap.Config config) {
        if (str2 != null) {
            r11.setContentDescription(str2);
        }
        C0638 r8 = r11.mo14544();
        String str3 = r8 == null ? null : r8.f13958;
        r11.setImageLoaderInfo(new C0638(str, r15, config, assetType));
        if (r8 != null && r8.f13957 && TextUtils.equals(r8.f13958, str)) {
            r11.mo14544().m14776(true);
        }
        if (str == null) {
            m9322(r11);
        } else if (!str.equals(str3)) {
            m9325(r11, str, assetType, r15, z, i, config);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m9325(AbstractC1188 r11, String str, AssetType assetType, ImageLoader.If r14, boolean z, int i, Bitmap.Config config) {
        m9335(str, assetType, (r14 == null || !r14.mo450()) ? z ? new If(r11, str, r14, config) : new Cif(r11, str, r14, config) : new C0157(r11, str, r14, config), 0, 0, i > 0 ? Request.Priority.NORMAL : Request.Priority.LOW, config, true);
    }

    @Override // com.netflix.mediaclient.util.gfx.ImageLoader
    /* renamed from: ˎ */
    public void mo3062(AbstractC1188 r2) {
        r2.setContentDescription(null);
        r2.setImageLoaderInfo(null);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.no$if  reason: invalid class name */
    public class Cif extends BS {

        /* renamed from: ˋ  reason: contains not printable characters */
        protected final ImageLoader.If f9196;

        /* renamed from: ॱ  reason: contains not printable characters */
        protected final Bitmap.Config f9198;

        public Cif(AbstractC1188 r3, String str, ImageLoader.If r5, Bitmap.Config config) {
            super(r3, str, C2011no.this.f9178);
            this.f9196 = r5;
            this.f9198 = config;
        }

        @Override // o.BS, o.C0524.AbstractC2398iF
        public void onErrorResponse(VolleyError volleyError) {
            super.onErrorResponse(volleyError);
            if (!m9342()) {
                C1283.m16865("ImageLoader", "Error loading bitmap for url: " + this.f4619);
                C2011no.this.m9323(this.f4618, this.f9196.mo451());
            }
        }

        @Override // o.BS, com.netflix.mediaclient.util.gfx.ImageLoader.AbstractC0050
        /* renamed from: ˋ */
        public void mo3067(BT bt, ImageLoader.AssetLocationType assetLocationType) {
            super.mo3067(bt, assetLocationType);
            if (!m9342()) {
                Bitmap r2 = bt.m3923();
                if (r2 != null) {
                    if (this.f4618.mo14544() != null) {
                        this.f4618.mo14544().m14776(true);
                    }
                    if (assetLocationType.m3065()) {
                        C2011no.this.m9329(this.f4618, r2);
                    } else {
                        mo9341(this.f4618, r2);
                    }
                } else {
                    mo9341(this.f4618, r2);
                }
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: ˏ */
        public void mo9341(ImageView imageView, Bitmap bitmap) {
            if (bitmap == null) {
                C2011no.this.m9322(imageView);
            } else {
                C2011no.this.m9329(imageView, bitmap);
            }
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        private boolean m9342() {
            C0638 r1 = this.f4618.mo14544();
            return !C1349Bv.m4126(r1 == null ? null : r1.f13958, this.f4619);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.no$If */
    public class If extends Cif {
        public If(AbstractC1188 r2, String str, ImageLoader.If r4, Bitmap.Config config) {
            super(r2, str, r4, config);
        }

        /* access modifiers changed from: protected */
        @Override // o.C2011no.Cif
        /* renamed from: ˏ  reason: contains not printable characters */
        public void mo9341(ImageView imageView, Bitmap bitmap) {
            if (bitmap == null) {
                C2011no.this.m9322(imageView);
            } else {
                BQ.m3915(imageView, null, bitmap);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.no$ˋ  reason: contains not printable characters */
    public class C0157 extends Cif {
        public C0157(AbstractC1188 r2, String str, ImageLoader.If r4, Bitmap.Config config) {
            super(r2, str, r4, config);
        }

        /* access modifiers changed from: protected */
        @Override // o.C2011no.Cif
        /* renamed from: ˏ */
        public void mo9341(ImageView imageView, Bitmap bitmap) {
            if (bitmap == null) {
                C2011no.this.m9323(imageView, this.f9196.mo452());
            } else {
                BQ.m3915(imageView, ContextCompat.getDrawable(imageView.getContext(), this.f9196.mo452()), bitmap);
            }
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    private BT m9335(final String str, AssetType assetType, ImageLoader.AbstractC0050 r19, int i, int i2, Request.Priority priority, Bitmap.Config config, final boolean z) {
        m9332();
        if (!BE.m3841(str) || this.f9180 == null) {
            String str2 = this.f9180 == null ? "Request queue is null - can't get bitmap" : "Request URL is NOT valid, unable to load " + str;
            C1283.m16846("ImageLoader", str2);
            BT bt = new BT(null, str, UmaAlert.TYPE_ERROR, r19, this.f9173, this.f9181);
            if (r19 != null) {
                r19.onErrorResponse(new VolleyError(str2));
            } else {
                C1283.m16850("ImageLoader", "Unable to report an error, missing listener");
            }
            return bt;
        }
        if (r19 instanceof BS) {
            ((BS) r19).m3921();
        }
        final String r11 = m9327(str);
        Bitmap r12 = this.f9182.m9343(r11);
        if (r12 != null) {
            BT bt2 = new BT(r12, str, null, null, this.f9173, this.f9181);
            r19.mo3067(bt2, ImageLoader.AssetLocationType.MEMCACHE);
            BW.m3944(str, assetType, ImageLoader.AssetLocationType.PLACEHOLDER.toString());
            BW.m3938(str, StatusCode.OK, ImageLoader.AssetLocationType.MEMCACHE.toString());
            return bt2;
        }
        BT bt3 = new BT(null, str, r11, r19, this.f9173, this.f9181);
        r19.mo3067(bt3, ImageLoader.AssetLocationType.PLACEHOLDER);
        BR br = this.f9173.get(r11);
        if (br != null) {
            br.m3918(bt3);
            return bt3;
        }
        C2017nu nuVar = new C2017nu(str, new C0524.If<Bitmap>() { // from class: o.no.4
            /* renamed from: ॱ  reason: contains not printable characters */
            public void onResponse(Bitmap bitmap) {
                BR br2 = (BR) C2011no.this.f9173.get(r11);
                String assetLocationType = ImageLoader.AssetLocationType.PLACEHOLDER.toString();
                if (br2 != null) {
                    switch (br2.m3920()) {
                        case NETWORK:
                            assetLocationType = ImageLoader.AssetLocationType.NETWORK.toString();
                            break;
                        case CACHE:
                            assetLocationType = ImageLoader.AssetLocationType.DISKCACHE.toString();
                            break;
                    }
                }
                BW.m3938(str, StatusCode.OK, assetLocationType);
                C2011no.this.m9330(r11, bitmap, z);
            }
        }, i, i2, config, new C0524.AbstractC2398iF() { // from class: o.no.1
            @Override // o.C0524.AbstractC2398iF
            public void onErrorResponse(VolleyError volleyError) {
                BW.m3937(str, volleyError);
                C2011no.this.m9333(r11, volleyError);
            }
        }, priority, this.f9175, this.f9174);
        nuVar.setTag(this.f9177);
        BW.m3944(str, assetType, ImageLoader.AssetLocationType.PLACEHOLDER.toString());
        this.f9180.m14415(nuVar);
        this.f9173.put(r11, new BR(nuVar, bt3));
        return bt3;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˎ  reason: contains not printable characters */
    private void m9330(String str, Bitmap bitmap, boolean z) {
        m9332();
        if (z) {
            this.f9182.m9344(str, bitmap);
        }
        BR remove = this.f9173.remove(str);
        if (remove != null) {
            remove.f4615 = bitmap;
            m9324(str, remove);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˏ  reason: contains not printable characters */
    private void m9333(String str, VolleyError volleyError) {
        m9332();
        BR remove = this.f9173.remove(str);
        remove.m3919(volleyError);
        m9324(str, remove);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m9324(String str, final BR br) {
        this.f9181.put(str, br);
        if (this.f9179 == null) {
            this.f9179 = new Runnable() { // from class: o.no.5
                @Override // java.lang.Runnable
                public void run() {
                    for (BR br2 : C2011no.this.f9181.values()) {
                        Iterator<BT> it = br2.f4617.iterator();
                        while (it.hasNext()) {
                            BT next = it.next();
                            if (next.f4625 != null) {
                                if (br2.m3917() == null) {
                                    next.f4624 = br2.f4615;
                                    if (br.m3920() == Request.ResourceLocationType.CACHE) {
                                        next.f4625.mo3067(next, ImageLoader.AssetLocationType.DISKCACHE);
                                    } else {
                                        next.f4625.mo3067(next, ImageLoader.AssetLocationType.NETWORK);
                                    }
                                } else {
                                    next.f4625.onErrorResponse(br2.m3917());
                                }
                            }
                        }
                    }
                    C2011no.this.f9181.clear();
                    C2011no.this.f9179 = null;
                }
            };
            this.f9172.postDelayed(this.f9179, 100);
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m9332() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("ImageLoader must be invoked from the main thread.");
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    static String m9327(String str) {
        String r1 = BG.m3859(str);
        String r2 = BG.m3855(str);
        if (r2 == null) {
            return r1;
        }
        return r1 + r2;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˊ  reason: contains not printable characters */
    private void m9322(ImageView imageView) {
        imageView.setImageDrawable(null);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˊ  reason: contains not printable characters */
    private void m9323(ImageView imageView, int i) {
        imageView.setImageResource(i);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˎ  reason: contains not printable characters */
    private void m9329(ImageView imageView, Bitmap bitmap) {
        imageView.setImageBitmap(bitmap);
    }
}
