package o;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.servicemgr.ISubtitleDef;
import com.netflix.mediaclient.util.ViewUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* renamed from: o.xx  reason: case insensitive filesystem */
public class C2330xx extends AbstractC2329xw {

    /* renamed from: ʻॱ  reason: contains not printable characters */
    private Map<String, ImageView> f12297 = new HashMap();

    /* renamed from: ॱˎ  reason: contains not printable characters */
    protected C2328xv f12298;

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    private boolean f12299;

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    private RelativeLayout f12300;

    @Override // o.AbstractC2329xw, o.AbstractC1978mi
    /* renamed from: ˎ */
    public /* bridge */ /* synthetic */ void mo9032(oM oMVar) {
        super.mo9032(oMVar);
    }

    @Override // o.AbstractC2329xw
    /* renamed from: ॱ */
    public /* bridge */ /* synthetic */ NetflixActivity mo13028() {
        return super.mo13028();
    }

    C2330xx(View view) {
        super(view);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f12283.getLayoutParams();
        marginLayoutParams.setMargins(0, 0, 0, 0);
        this.f12283.setLayoutParams(marginLayoutParams);
        this.f12283.removeAllViews();
        this.f12300 = new RelativeLayout(mo13028());
        this.f12283.addView(this.f12300, new RelativeLayout.LayoutParams(-1, -1));
    }

    @Override // o.AbstractC1978mi
    /* renamed from: ˎ */
    public void mo9031() {
        C1283.m16854("nf_subtitles_render", "Remove all subtitles.");
        m13043(true);
    }

    @Override // o.AbstractC1978mi
    /* renamed from: ˎ */
    public void mo9033(final boolean z) {
        this.f12286 = z;
        this.f12285.post(new Runnable() { // from class: o.xx.3
            @Override // java.lang.Runnable
            public void run() {
                C2330xx.this.m13042(z);
            }
        });
    }

    @Override // o.AbstractC1978mi
    /* renamed from: ˊ */
    public void mo9027() {
        C1283.m16854("nf_subtitles_render", "Clear.");
        this.f12285.post(new Runnable() { // from class: o.xx.5
            @Override // java.lang.Runnable
            public void run() {
                C2330xx.this.m13043(true);
                if (C2330xx.this.f12300 != null && C2330xx.this.f12283 != null) {
                    C2330xx.this.f12283.removeView(C2330xx.this.f12300);
                }
            }
        });
    }

    @Override // o.AbstractC1978mi
    /* renamed from: ˏ */
    public void mo9034() {
        C1283.m16854("nf_subtitles_render", "Clear pending updates:: NOOP.");
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC2329xw
    /* renamed from: ˋ */
    public synchronized void mo13026(boolean z) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            C1276.m16820().mo5725("removeVisibleSubtitleBlocks called on non UI thread");
        }
        this.f12300.removeAllViews();
        for (ImageView imageView : this.f12297.values()) {
            C1283.m16854("nf_subtitles_render", "removeVisibleSubtitleBlocks:: Removing image ");
            if (imageView != null) {
                imageView.setVisibility(4);
            }
        }
        this.f12297.clear();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱ  reason: contains not printable characters */
    private void m13043(boolean z) {
        mo13026(z);
    }

    @Override // o.AbstractC1978mi
    /* renamed from: ˏ */
    public void mo9035(C1987mr mrVar, Point point) {
        C1283.m16854("nf_subtitles_render", "ImageBasedSubtitleManager:: update subtitle data");
        if (mrVar == null) {
            C1283.m16850("nf_subtitles_render", "Subtitle data is null. This should never happen!");
        } else if (mrVar.m9065() == null) {
            C1283.m16850("nf_subtitles_render", "Subtitle parser is null. This should never happen!");
        } else if (mrVar.m9065() instanceof AbstractC1971mb) {
            C1283.m16854("nf_subtitles_render", "Parser is as expected...");
            this.f12282 = mrVar.m9065();
            m13043(false);
            int hashCode = mrVar.m9065().hashCode();
            if (this.f12284 == null || this.f12284.intValue() != hashCode) {
                this.f12284 = Integer.valueOf(hashCode);
                this.f12298 = null;
            }
            AbstractC1971mb mbVar = (AbstractC1971mb) this.f12282;
            if (this.f12298 == null) {
                this.f12298 = C2328xv.m13014(mbVar.mo8991(), mbVar.mo8992(), this.f12287);
            }
            m13038(mrVar.m9066());
            m13024(mrVar.m9064(), true);
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private void m13038(List<AbstractC1976mg> list) {
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<AbstractC1976mg> it = list.iterator();
            while (it.hasNext()) {
                m13039((C1988ms) it.next(), arrayList);
            }
            if (arrayList.size() > 1) {
                m13023(arrayList);
            } else {
                C1283.m16854("nf_subtitles_render", "No need to move blocks");
            }
            m13030(arrayList);
            this.f12283.forceLayout();
            this.f12283.requestLayout();
            this.f12283.invalidate();
            C1283.m16854("nf_subtitles_render", "Add displayed block to pending queue to be removed at end time");
            m13024(list, false);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˏ  reason: contains not printable characters */
    private void m13042(boolean z) {
        C1283.m16854("nf_subtitles_render", "All images invisible");
        for (ImageView imageView : this.f12297.values()) {
            imageView.setVisibility(z ? 0 : 4);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˎ  reason: contains not printable characters */
    private void m13039(C1988ms msVar, List<ViewUtils.C0049> list) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            C1276.m16820().mo5725("showSubtitleBlock called on non UI thread");
        }
        if (msVar == null || msVar.m9068() == null || C1349Bv.m4113(msVar.m9068().mo9069())) {
            C1283.m16850("nf_subtitles_render", "No image! Can not show!");
            return;
        }
        msVar.m9067();
        float r3 = m13044();
        boolean z = true;
        AbstractC1992mw r5 = msVar.m9068();
        int r6 = (int) (((float) r5.mo9072()) * r3);
        int r7 = (int) (((float) r5.mo9085()) * r3);
        int i = 0;
        int i2 = 0;
        if (r3 < 1.0f && this.f12298.m13018() < 480) {
            z = false;
            i2 = (r5.mo9085() - r7) / 2;
            i = (r5.mo9072() - r6) / 2;
            r6 = r5.mo9072();
            r7 = r5.mo9085();
        }
        if (r5.mo9085() == r7 && r5.mo9072() == r6) {
            z = false;
            C1283.m16854("nf_subtitles_render", "Source and target resolutions are the same, do not scale!");
        }
        int r10 = (m13032() + ((int) (((float) r5.mo9076()) * r3))) - i;
        int width = (this.f12283.getWidth() - r10) - r6;
        int r12 = ((int) (((float) r5.mo9077()) * r3)) + m13045() + i2;
        int height = (this.f12283.getHeight() - r12) - r7;
        if (this.f12299) {
            if (r12 > this.f12283.getHeight() / 2) {
                int r14 = m13031() - height;
                if (r14 > 0) {
                    r12 -= r14;
                    height += r14;
                }
            } else {
                int r142 = m13021() - r12;
                if (r142 > 0) {
                    r12 += r142;
                    height -= r142;
                }
            }
        }
        if (r12 < 0) {
            C1283.m16854("nf_subtitles_render", "Top was negative!");
            height -= r12;
            r12 = 0;
        }
        if (height < 0) {
            C1283.m16854("nf_subtitles_render", "Bottom was negative!");
            r12 += height;
            height = 0;
        }
        if (r10 < 0) {
            C1283.m16854("nf_subtitles_render", "Left was negative!");
            width -= r10;
            r10 = 0;
        }
        if (width < 0) {
            C1283.m16854("nf_subtitles_render", "Right was negative!");
            r10 += width;
            width = 0;
        }
        ImageView r143 = m13040(r5.mo9069(), r6, r7, z);
        if (r143 == null) {
            C1283.m16850("nf_subtitles_render", "showSubtitleBlock:: NULL image for desc.getLocalImagePath()!");
            return;
        }
        C1283.m16854("nf_subtitles_render", "showSubtitleBlock:: Image for " + r5.mo9069() + " exist and it is visible " + (r143.getVisibility() == 0) + ", w/h: " + r143.getMeasuredWidth() + "/" + r143.getMeasuredHeight());
        if (list != null) {
            list.add(new ViewUtils.C0049(r143));
        }
        this.f12297.put(r5.mo9086(), r143);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(r6, r7);
        layoutParams.setMargins(r10, r12, width, height);
        r143.setLayoutParams(layoutParams);
        this.f12300.addView(r143);
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    private int m13032() {
        if (this.f12298 == null) {
            return 0;
        }
        return this.f12298.m13017();
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    private int m13045() {
        if (this.f12298 == null) {
            return 0;
        }
        return this.f12298.m13019();
    }

    /* renamed from: ॱˊ  reason: contains not printable characters */
    private float m13044() {
        if (this.f12298 == null) {
            return 1.0f;
        }
        return this.f12298.m13016();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private ImageView m13040(String str, int i, int i2, boolean z) {
        Bitmap bitmap;
        Bitmap decodeFile = BitmapFactory.decodeFile(str);
        if (decodeFile == null) {
            C1283.m16865("nf_subtitles_render", "==> Unable to decode file on path " + str);
            return null;
        }
        if (z) {
            bitmap = Bitmap.createScaledBitmap(decodeFile, i, i2, true);
        } else {
            C1283.m16854("nf_subtitles_render", "Do not scale, use image original width");
            bitmap = Bitmap.createScaledBitmap(decodeFile, i, i2, true);
        }
        ImageView imageView = new ImageView(mo13028());
        imageView.setVisibility(0);
        imageView.setImageBitmap(bitmap);
        return imageView;
    }

    /* access modifiers changed from: protected */
    @Override // o.AbstractC2329xw
    /* renamed from: ॱ */
    public Runnable mo13029(AbstractC1976mg mgVar, final boolean z) {
        final C1988ms msVar = (C1988ms) mgVar;
        AnonymousClass1 r2 = new Runnable() { // from class: o.xx.1
            @Override // java.lang.Runnable
            public void run() {
                C2330xx.this.f12289.remove(this);
                synchronized (C2330xx.this) {
                    if (z) {
                        C1283.m16854("nf_subtitles_render", "===> showSubtitleBlock was called from pending queue!!");
                        C2330xx.this.m13039(msVar, null);
                    } else {
                        C1283.m16854("nf_subtitles_render", "===> removeSubtitleBlock was called from pending queue!!");
                        C2330xx.this.m13034(msVar);
                    }
                }
            }
        };
        this.f12289.add(r2);
        return r2;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˋ  reason: contains not printable characters */
    private void m13034(C1988ms msVar) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            C1276.m16820().mo5725("removeSubtitleBlock called on non UI thread");
        }
        if (msVar == null || msVar.m9068() == null || C1349Bv.m4113(msVar.m9068().mo9086())) {
            C1283.m16850("nf_subtitles_render", "Subtitle block can not be null!");
            return;
        }
        ImageView remove = this.f12297.remove(msVar.m9068().mo9086());
        if (remove != null) {
            remove.setVisibility(4);
            this.f12300.removeView(remove);
        }
    }

    @Override // o.AbstractC1978mi
    /* renamed from: ˊ */
    public synchronized void mo9028(boolean z) {
        this.f12299 = z;
        if (this.f12283 != null) {
            mo13026(true);
        } else {
            C1283.m16865("nf_subtitles_render", "Display area is null, unable to set margins!");
        }
    }

    @Override // o.AbstractC1978mi
    /* renamed from: ˋ */
    public ISubtitleDef.SubtitleProfile mo9030() {
        return ISubtitleDef.SubtitleProfile.IMAGE;
    }

    @Override // o.AbstractC1978mi
    /* renamed from: ˊ */
    public boolean mo9029(ISubtitleDef.SubtitleProfile subtitleProfile) {
        if (subtitleProfile == null) {
            return false;
        }
        if (subtitleProfile == ISubtitleDef.SubtitleProfile.IMAGE || subtitleProfile == ISubtitleDef.SubtitleProfile.IMAGE_ENC) {
            return true;
        }
        return false;
    }
}
