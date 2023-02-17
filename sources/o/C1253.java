package o;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.netflix.mediaclient.service.webclient.model.leafs.EogAlert;
/* renamed from: o.ｴ  reason: contains not printable characters */
public final class C1253 extends AbstractC1237 {
    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        Class<? super T> rawType = typeToken.getRawType();
        if (AbstractC2033oi.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) AbstractC2033oi.m9653(gson);
        }
        if (EogAlert.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) EogAlert.typeAdapter(gson);
        }
        return null;
    }
}
