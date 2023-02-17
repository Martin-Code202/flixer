package o;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.AttributeSet;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.api.res.AssetType;
import com.netflix.mediaclient.util.gfx.ImageLoader;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.subjects.SingleSubject;
public final class tY extends C0522 {

    /* renamed from: ˏ  reason: contains not printable characters */
    public static final iF f10464 = new iF(null);

    public tY(Context context) {
        this(context, null, 0, 6, null);
    }

    public tY(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public tY(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        C1457Fr.m5025(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ tY(Context context, AttributeSet attributeSet, int i, int i2, C1456Fq fq) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* renamed from: o.tY$ˊ  reason: contains not printable characters */
    public static abstract class AbstractC0219 {

        /* renamed from: o.tY$ˊ$if  reason: invalid class name */
        public static final class Cif extends AbstractC0219 {

            /* renamed from: ˊ  reason: contains not printable characters */
            private final Bitmap f10468;

            public boolean equals(Object obj) {
                if (this != obj) {
                    return (obj instanceof Cif) && C1457Fr.m5018(this.f10468, ((Cif) obj).f10468);
                }
                return true;
            }

            public int hashCode() {
                Bitmap bitmap = this.f10468;
                if (bitmap != null) {
                    return bitmap.hashCode();
                }
                return 0;
            }

            public String toString() {
                return "Success(image=" + this.f10468 + ")";
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Cif(Bitmap bitmap) {
                super(null);
                C1457Fr.m5025(bitmap, "image");
                this.f10468 = bitmap;
            }

            /* renamed from: ˏ  reason: contains not printable characters */
            public final Bitmap m11054() {
                return this.f10468;
            }
        }

        private AbstractC0219() {
        }

        public /* synthetic */ AbstractC0219(C1456Fq fq) {
            this();
        }

        /* renamed from: o.tY$ˊ$If */
        public static final class If extends AbstractC0219 {

            /* renamed from: ˊ  reason: contains not printable characters */
            private final Throwable f10467;

            public boolean equals(Object obj) {
                if (this != obj) {
                    return (obj instanceof If) && C1457Fr.m5018(this.f10467, ((If) obj).f10467);
                }
                return true;
            }

            public int hashCode() {
                Throwable th = this.f10467;
                if (th != null) {
                    return th.hashCode();
                }
                return 0;
            }

            public String toString() {
                return "Error(throwable=" + this.f10467 + ")";
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public If(Throwable th) {
                super(null);
                C1457Fr.m5025(th, "throwable");
                this.f10467 = th;
            }

            /* renamed from: ॱ  reason: contains not printable characters */
            public final Throwable m11053() {
                return this.f10467;
            }
        }
    }

    public static final class iF {
        private iF() {
        }

        public /* synthetic */ iF(C1456Fq fq) {
            this();
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public final void m11051(C2202ub ubVar) {
        C1457Fr.m5025(ubVar, "uiModel");
        m11050(ubVar);
    }

    /* access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        C1457Fr.m5025(canvas, "canvas");
        if (getDrawable() != null) {
            getDrawable().draw(canvas);
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private final void m11050(C2202ub ubVar) {
        SingleSubject create = SingleSubject.create();
        C1457Fr.m5016((Object) create, "SingleSubject.create<ImageFetchResult>()");
        C0220 r7 = new C0220(create);
        ImageLoader imageLoader = NetflixActivity.getImageLoader(getContext());
        if (imageLoader != null) {
            imageLoader.mo3059(ubVar.m11689(), AssetType.boxArt, 0, 0, r7);
        }
        create.subscribe(new Cif(this, ubVar));
    }

    /* renamed from: o.tY$ˋ  reason: contains not printable characters */
    public static final class C0220 implements AbstractC0957 {

        /* renamed from: ˏ  reason: contains not printable characters */
        final /* synthetic */ SingleSubject f10469;

        C0220(SingleSubject singleSubject) {
            this.f10469 = singleSubject;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: o.tY$ˋ$iF */
        public static final class iF<T, R> implements Function<Throwable, AbstractC0219> {

            /* renamed from: ˎ  reason: contains not printable characters */
            final /* synthetic */ String f10470;

            iF(String str) {
                this.f10470 = str;
            }

            /* renamed from: ˎ  reason: contains not printable characters */
            public final AbstractC0219.If apply(Throwable th) {
                C1457Fr.m5025(th, "it");
                StringBuilder append = new StringBuilder().append("PreviewsBoxArtView ");
                String str = this.f10470;
                if (str == null) {
                    str = "";
                }
                return new AbstractC0219.If(new Resources.NotFoundException(append.append(str).append(" - Failed to render Previews boxart").toString()));
            }
        }

        @Override // o.AbstractC0957
        public void onErrorResponse(String str) {
            this.f10469.onErrorReturn(new iF(str));
        }

        @Override // o.AbstractC0957
        public void onResponse(Bitmap bitmap, String str) {
            if (bitmap != null) {
                this.f10469.onSuccess(new AbstractC0219.Cif(bitmap));
            } else {
                onErrorResponse("Null bitmap for Previews boxart");
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.tY$if  reason: invalid class name */
    public static final class Cif<T> implements Consumer<AbstractC0219> {

        /* renamed from: ˋ  reason: contains not printable characters */
        final /* synthetic */ tY f10465;

        /* renamed from: ˎ  reason: contains not printable characters */
        final /* synthetic */ C2202ub f10466;

        Cif(tY tYVar, C2202ub ubVar) {
            this.f10465 = tYVar;
            this.f10466 = ubVar;
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        public final void accept(AbstractC0219 r5) {
            C1457Fr.m5025(r5, "boxArtResult");
            if (r5 instanceof AbstractC0219.Cif) {
                this.f10465.m11048(((AbstractC0219.Cif) r5).m11054(), this.f10466);
            } else if (r5 instanceof AbstractC0219.If) {
                C1276.m16820().mo5730(((AbstractC0219.If) r5).m11053());
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˊ  reason: contains not printable characters */
    private final void m11048(Bitmap bitmap, C2202ub ubVar) {
        tZ tZVar;
        int r6 = ubVar.m11687() ? -7829368 : ubVar.m11693();
        if (ubVar.m11690()) {
            Context context = getContext();
            C1457Fr.m5016((Object) context, "context");
            tZVar = new C2205ue(context, getWidth(), bitmap, ubVar.m11686(), r6);
        } else {
            Context context2 = getContext();
            C1457Fr.m5016((Object) context2, "context");
            tZVar = new tZ(context2, getWidth(), bitmap, ubVar.m11686(), r6);
        }
        setImageDrawable(tZVar);
    }
}
