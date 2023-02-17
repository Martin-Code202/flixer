package com.netflix.mediaclient.ui.player;

import android.os.Parcel;
import android.os.Parcelable;
import o.Gs;
import o.Gt;
final class PaperParcelPlanChoice {

    /* renamed from: ˋ  reason: contains not printable characters */
    static final Parcelable.Creator<PlanChoice> f3458 = new Parcelable.Creator<PlanChoice>() { // from class: com.netflix.mediaclient.ui.player.PaperParcelPlanChoice.1
        /* renamed from: ˊ  reason: contains not printable characters */
        public PlanChoice createFromParcel(Parcel parcel) {
            return new PlanChoice(parcel.readInt(), parcel.readInt(), Gs.f5712.mo5072(parcel), Gs.f5712.mo5072(parcel), parcel.readFloat(), Gs.f5712.mo5072(parcel), Gs.f5712.mo5072(parcel), Gs.f5712.mo5072(parcel), Gs.f5712.mo5072(parcel), (Long) Gt.m5154(parcel, Gs.f5715), Gs.f5712.mo5072(parcel), Gs.f5712.mo5072(parcel), (Float) Gt.m5154(parcel, Gs.f5717), Gs.f5712.mo5072(parcel));
        }

        /* renamed from: ˏ  reason: contains not printable characters */
        public PlanChoice[] newArray(int i) {
            return new PlanChoice[i];
        }
    };

    private PaperParcelPlanChoice() {
    }

    static void writeToParcel(PlanChoice planChoice, Parcel parcel, int i) {
        parcel.writeInt(planChoice.m2381());
        parcel.writeInt(planChoice.m2383());
        Gs.f5712.mo5071(planChoice.m2378(), parcel, i);
        Gs.f5712.mo5071(planChoice.m2376(), parcel, i);
        parcel.writeFloat(planChoice.m2380());
        Gs.f5712.mo5071(planChoice.m2373(), parcel, i);
        Gs.f5712.mo5071(planChoice.m2385(), parcel, i);
        Gs.f5712.mo5071(planChoice.m2386(), parcel, i);
        Gs.f5712.mo5071(planChoice.m2375(), parcel, i);
        Gt.m5155(planChoice.m2374(), parcel, i, Gs.f5715);
        Gs.f5712.mo5071(planChoice.m2384(), parcel, i);
        Gs.f5712.mo5071(planChoice.m2382(), parcel, i);
        Gt.m5155(planChoice.m2379(), parcel, i, Gs.f5717);
        Gs.f5712.mo5071(planChoice.m2377(), parcel, i);
    }
}
