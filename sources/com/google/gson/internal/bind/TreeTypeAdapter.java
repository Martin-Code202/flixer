package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.C$Gson$Preconditions;
import com.google.gson.internal.Streams;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
public final class TreeTypeAdapter<T> extends TypeAdapter<T> {
    private final TreeTypeAdapter<T>.GsonContextImpl context = new GsonContextImpl();
    private TypeAdapter<T> delegate;
    private final JsonDeserializer<T> deserializer;
    private final Gson gson;
    private final JsonSerializer<T> serializer;
    private final TypeAdapterFactory skipPast;
    private final TypeToken<T> typeToken;

    public TreeTypeAdapter(JsonSerializer<T> jsonSerializer, JsonDeserializer<T> jsonDeserializer, Gson gson2, TypeToken<T> typeToken2, TypeAdapterFactory typeAdapterFactory) {
        this.serializer = jsonSerializer;
        this.deserializer = jsonDeserializer;
        this.gson = gson2;
        this.typeToken = typeToken2;
        this.skipPast = typeAdapterFactory;
    }

    @Override // com.google.gson.TypeAdapter
    public T read(JsonReader jsonReader) {
        if (this.deserializer == null) {
            return delegate().read(jsonReader);
        }
        JsonElement parse = Streams.parse(jsonReader);
        if (parse.isJsonNull()) {
            return null;
        }
        return this.deserializer.deserialize(parse, this.typeToken.getType(), this.context);
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, T t) {
        if (this.serializer == null) {
            delegate().write(jsonWriter, t);
        } else if (t == null) {
            jsonWriter.nullValue();
        } else {
            Streams.write(this.serializer.serialize(t, this.typeToken.getType(), this.context), jsonWriter);
        }
    }

    private TypeAdapter<T> delegate() {
        TypeAdapter<T> typeAdapter = this.delegate;
        if (typeAdapter != null) {
            return typeAdapter;
        }
        TypeAdapter<T> delegateAdapter = this.gson.getDelegateAdapter(this.skipPast, this.typeToken);
        this.delegate = delegateAdapter;
        return delegateAdapter;
    }

    public static TypeAdapterFactory newFactory(TypeToken<?> typeToken2, Object obj) {
        return new SingleTypeFactory(obj, typeToken2, false, null);
    }

    static final class SingleTypeFactory implements TypeAdapterFactory {
        private final JsonDeserializer<?> deserializer;
        private final TypeToken<?> exactType;
        private final Class<?> hierarchyType;
        private final boolean matchRawType;
        private final JsonSerializer<?> serializer;

        SingleTypeFactory(Object obj, TypeToken<?> typeToken, boolean z, Class<?> cls) {
            this.serializer = obj instanceof JsonSerializer ? (JsonSerializer) obj : null;
            this.deserializer = obj instanceof JsonDeserializer ? (JsonDeserializer) obj : null;
            C$Gson$Preconditions.checkArgument((this.serializer == null && this.deserializer == null) ? false : true);
            this.exactType = typeToken;
            this.matchRawType = z;
            this.hierarchyType = cls;
        }

        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            boolean z;
            if (this.exactType != null) {
                z = this.exactType.equals(typeToken) || (this.matchRawType && this.exactType.getType() == typeToken.getRawType());
            } else {
                z = this.hierarchyType.isAssignableFrom(typeToken.getRawType());
            }
            if (z) {
                return new TreeTypeAdapter(this.serializer, this.deserializer, gson, typeToken, this);
            }
            return null;
        }
    }

    final class GsonContextImpl implements JsonSerializationContext, JsonDeserializationContext {
        private GsonContextImpl() {
        }
    }
}
