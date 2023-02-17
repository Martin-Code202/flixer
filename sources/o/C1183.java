package o;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.netflix.mediaclient.service.webclient.model.leafs.UmaAlert;
import com.netflix.mediaclient.service.webclient.model.leafs.UmaCta;
/* renamed from: o.ﺓ  reason: contains not printable characters */
public final class C1183 extends AbstractC1214 {
    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        Class<? super T> rawType = typeToken.getRawType();
        if (UmaCta.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) UmaCta.typeAdapter(gson);
        }
        if (UmaAlert.class.isAssignableFrom(rawType)) {
            return (TypeAdapter<T>) UmaAlert.typeAdapter(gson);
        }
        return null;
    }
}
