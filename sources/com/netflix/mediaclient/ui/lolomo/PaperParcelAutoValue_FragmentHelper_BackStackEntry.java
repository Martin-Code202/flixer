package com.netflix.mediaclient.ui.lolomo;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.netflix.cl.model.AppView;
import o.Gn;
import o.Gp;
import o.Gr;
import o.Gs;
import o.Gt;
/* access modifiers changed from: package-private */
public final class PaperParcelAutoValue_FragmentHelper_BackStackEntry {

    /* renamed from: ˊ  reason: contains not printable characters */
    static final Gr<Intent> f3227 = new Gn(null);

    /* renamed from: ˎ  reason: contains not printable characters */
    static final Parcelable.Creator<AutoValue_FragmentHelper_BackStackEntry> f3228 = new Parcelable.Creator<AutoValue_FragmentHelper_BackStackEntry>() { // from class: com.netflix.mediaclient.ui.lolomo.PaperParcelAutoValue_FragmentHelper_BackStackEntry.1
        /* renamed from: ˏ  reason: contains not printable characters */
        public AutoValue_FragmentHelper_BackStackEntry createFromParcel(Parcel parcel) {
            return new AutoValue_FragmentHelper_BackStackEntry(Gs.f5712.mo5072(parcel), PaperParcelAutoValue_FragmentHelper_BackStackEntry.f3227.mo5072(parcel), (AppView) Gt.m5154(parcel, PaperParcelAutoValue_FragmentHelper_BackStackEntry.f3230), PaperParcelAutoValue_FragmentHelper_BackStackEntry.f3229.mo5072(parcel));
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        public AutoValue_FragmentHelper_BackStackEntry[] newArray(int i) {
            return new AutoValue_FragmentHelper_BackStackEntry[i];
        }
    };

    /* renamed from: ˏ  reason: contains not printable characters */
    static final Gr<Parcelable> f3229 = new Gn(null);

    /* renamed from: ॱ  reason: contains not printable characters */
    static final Gr<AppView> f3230 = new Gp(AppView.class);

    private PaperParcelAutoValue_FragmentHelper_BackStackEntry() {
    }

    static void writeToParcel(AutoValue_FragmentHelper_BackStackEntry autoValue_FragmentHelper_BackStackEntry, Parcel parcel, int i) {
        Gs.f5712.mo5071(autoValue_FragmentHelper_BackStackEntry.mo10887(), parcel, i);
        f3227.mo5071(autoValue_FragmentHelper_BackStackEntry.mo10885(), parcel, i);
        Gt.m5155(autoValue_FragmentHelper_BackStackEntry.mo10888(), parcel, i, f3230);
        f3229.mo5071(autoValue_FragmentHelper_BackStackEntry.mo10886(), parcel, i);
    }
}
