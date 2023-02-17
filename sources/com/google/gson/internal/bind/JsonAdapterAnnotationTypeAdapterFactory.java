package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonSerializer;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.reflect.TypeToken;
public final class JsonAdapterAnnotationTypeAdapterFactory implements TypeAdapterFactory {
    private final ConstructorConstructor constructorConstructor;

    public JsonAdapterAnnotationTypeAdapterFactory(ConstructorConstructor constructorConstructor2) {
        this.constructorConstructor = constructorConstructor2;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        JsonAdapter jsonAdapter = (JsonAdapter) typeToken.getRawType().getAnnotation(JsonAdapter.class);
        if (jsonAdapter == null) {
            return null;
        }
        return (TypeAdapter<T>) getTypeAdapter(this.constructorConstructor, gson, typeToken, jsonAdapter);
    }

    /* access modifiers changed from: package-private */
    public TypeAdapter<?> getTypeAdapter(ConstructorConstructor constructorConstructor2, Gson gson, TypeToken<?> typeToken, JsonAdapter jsonAdapter) {
        TypeAdapter<?> typeAdapter;
        Object construct = constructorConstructor2.get(TypeToken.get((Class) jsonAdapter.value())).construct();
        if (construct instanceof TypeAdapter) {
            typeAdapter = (TypeAdapter) construct;
        } else if (construct instanceof TypeAdapterFactory) {
            typeAdapter = ((TypeAdapterFactory) construct).create(gson, typeToken);
        } else if ((construct instanceof JsonSerializer) || (construct instanceof JsonDeserializer)) {
            typeAdapter = new TreeTypeAdapter(construct instanceof JsonSerializer ? (JsonSerializer) construct : null, construct instanceof JsonDeserializer ? (JsonDeserializer) construct : null, gson, typeToken, null);
        } else {
            throw new IllegalArgumentException("@JsonAdapter value must be TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer reference.");
        }
        if (typeAdapter == null || !jsonAdapter.nullSafe()) {
            return typeAdapter;
        }
        return typeAdapter.nullSafe();
    }
}
