package o;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import com.netflix.mediaclient.api.res.AssetType;
/* renamed from: o.eI  reason: case insensitive filesystem */
public final class C1696eI {

    /* renamed from: ˊ  reason: contains not printable characters */
    private Bitmap f6470;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final C2003ng f6471;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final If f6472;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final Handler f6473;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final Context f6474;

    /* renamed from: o.eI$If */
    public interface If {
        /* renamed from: ˏ  reason: contains not printable characters */
        void mo6086(Bitmap bitmap);
    }

    public C1696eI(Context context, C2003ng ngVar, If r3, Handler handler) {
        this.f6474 = context;
        this.f6471 = ngVar;
        this.f6472 = r3;
        this.f6473 = handler;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m6085(String str) {
        m6084(str);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m6084(String str) {
        if (C1349Bv.m4113(str)) {
            C1283.m16850("nf_mdxImageLoader", "Loader url empty");
            return;
        }
        C2011no r6 = this.f6471.m9305(this.f6474);
        if (null != r6) {
            r6.mo3059(str, AssetType.boxArt, 0, 0, new AbstractC0957() { // from class: o.eI.2
                @Override // o.AbstractC0957
                public void onResponse(Bitmap bitmap, String str2) {
                    if (null == bitmap || bitmap.isRecycled()) {
                        C1283.m16850("nf_mdxImageLoader", "bitmap is not valid " + bitmap);
                    } else {
                        C1696eI.this.f6470 = bitmap.copy(bitmap.getConfig(), bitmap.isMutable());
                    }
                    C1696eI.this.f6472.mo6086(C1696eI.this.f6470);
                }

                @Override // o.AbstractC0957
                public void onErrorResponse(String str2) {
                    C1283.m16850("nf_mdxImageLoader", "failed to downlod " + str2);
                }
            });
        } else {
            C1283.m16850("nf_mdxImageLoader", "ImageLoader is null!");
        }
    }
}
