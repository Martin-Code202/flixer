package o;

import com.netflix.mediaclient.media.BookmarkStore;
import com.netflix.model.leafs.Video;
@Deprecated
/* renamed from: o.у  reason: contains not printable characters */
abstract class AbstractC0502 extends AbstractRunnableC0373 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final AbstractC0948 f13624;

    AbstractC0502(C0876<?> r1, AbstractC0948 r2, AbstractC1203 r3) {
        super(r1, r3);
        this.f13624 = r2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ᐝॱ  reason: contains not printable characters */
    public BookmarkStore m14485() {
        return this.f13624.mo8160();
    }

    /* access modifiers changed from: protected */
    /* renamed from: ॱˎ  reason: contains not printable characters */
    public AbstractC1899j m14484() {
        return this.f13624.m15764();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ʻॱ  reason: contains not printable characters */
    public String m14482() {
        return this.f13624.mo8126();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: ॱ  reason: contains not printable characters */
    public void m14483(String str, Video.Bookmark bookmark) {
        BookmarkStore r2 = m14485();
        if (r2 != null) {
            r2.updateBookmarkIfExists(str, bookmark, m14482());
        } else {
            C1283.m16854("CmpTaskWithServiceProvider", "service is null");
        }
    }
}
