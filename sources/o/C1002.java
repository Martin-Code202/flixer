package o;

import android.widget.SearchView;
/* access modifiers changed from: package-private */
/* renamed from: o.ᵅ  reason: contains not printable characters */
public final class C1002 extends AbstractC1115 {

    /* renamed from: ˋ  reason: contains not printable characters */
    private final CharSequence f15081;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final boolean f15082;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final SearchView f15083;

    C1002(SearchView searchView, CharSequence charSequence, boolean z) {
        if (searchView == null) {
            throw new NullPointerException("Null view");
        }
        this.f15083 = searchView;
        if (charSequence == null) {
            throw new NullPointerException("Null queryText");
        }
        this.f15081 = charSequence;
        this.f15082 = z;
    }

    @Override // o.AbstractC1115
    /* renamed from: ˋ  reason: contains not printable characters */
    public SearchView mo15948() {
        return this.f15083;
    }

    @Override // o.AbstractC1115
    /* renamed from: ˏ  reason: contains not printable characters */
    public CharSequence mo15950() {
        return this.f15081;
    }

    @Override // o.AbstractC1115
    /* renamed from: ˎ  reason: contains not printable characters */
    public boolean mo15949() {
        return this.f15082;
    }

    public String toString() {
        return "SearchViewQueryTextEvent{view=" + this.f15083 + ", queryText=" + ((Object) this.f15081) + ", isSubmitted=" + this.f15082 + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC1115)) {
            return false;
        }
        AbstractC1115 r2 = (AbstractC1115) obj;
        return this.f15083.equals(r2.mo15948()) && this.f15081.equals(r2.mo15950()) && this.f15082 == r2.mo15949();
    }

    public int hashCode() {
        return ((((1000003 ^ this.f15083.hashCode()) * 1000003) ^ this.f15081.hashCode()) * 1000003) ^ (this.f15082 ? 1231 : 1237);
    }
}
