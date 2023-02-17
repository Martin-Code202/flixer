package o;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.netflix.model.leafs.blades.CreditMarks;
import com.netflix.model.leafs.blades.PrePlayItem;
import com.netflix.model.leafs.blades.PreplayItemAction;
import com.netflix.model.leafs.originals.BillboardAvailabilityDates;
import com.netflix.model.leafs.originals.BillboardPhase;
import com.netflix.model.leafs.originals.BillboardVideo;
import com.netflix.model.leafs.originals.VideoAssets;
import com.netflix.model.leafs.originals.interactive.CharacterMotion;
import com.netflix.model.leafs.originals.interactive.InteractiveFeatures;
import com.netflix.model.leafs.originals.interactive.MotionBoxart;
/* renamed from: o.ᓷ  reason: contains not printable characters */
public final class C0846 extends AbstractC0845 {
    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        Class<? super T> rawType = typeToken.getRawType();
        if (BillboardAvailabilityDates.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) BillboardAvailabilityDates.typeAdapter(gson);
        }
        if (VideoAssets.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) VideoAssets.typeAdapter(gson);
        }
        if (InteractiveFeatures.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) InteractiveFeatures.typeAdapter(gson);
        }
        if (MotionBoxart.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) MotionBoxart.typeAdapter(gson);
        }
        if (CharacterMotion.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) CharacterMotion.typeAdapter(gson);
        }
        if (BillboardPhase.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) BillboardPhase.typeAdapter(gson);
        }
        if (BillboardVideo.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) BillboardVideo.typeAdapter(gson);
        }
        if (CreditMarks.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) CreditMarks.typeAdapter(gson);
        }
        if (PrePlayItem.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) PrePlayItem.typeAdapter(gson);
        }
        if (PreplayItemAction.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) PreplayItemAction.typeAdapter(gson);
        }
        return null;
    }
}
