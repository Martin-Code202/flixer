package com.google.gson.internal.bind;

import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.internal.Primitives;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
public final class ReflectiveTypeAdapterFactory implements TypeAdapterFactory {
    private final ConstructorConstructor constructorConstructor;
    private final Excluder excluder;
    private final FieldNamingStrategy fieldNamingPolicy;
    private final JsonAdapterAnnotationTypeAdapterFactory jsonAdapterFactory;

    public ReflectiveTypeAdapterFactory(ConstructorConstructor constructorConstructor2, FieldNamingStrategy fieldNamingStrategy, Excluder excluder2, JsonAdapterAnnotationTypeAdapterFactory jsonAdapterAnnotationTypeAdapterFactory) {
        this.constructorConstructor = constructorConstructor2;
        this.fieldNamingPolicy = fieldNamingStrategy;
        this.excluder = excluder2;
        this.jsonAdapterFactory = jsonAdapterAnnotationTypeAdapterFactory;
    }

    public boolean excludeField(Field field, boolean z) {
        return excludeField(field, z, this.excluder);
    }

    static boolean excludeField(Field field, boolean z, Excluder excluder2) {
        return !excluder2.excludeClass(field.getType(), z) && !excluder2.excludeField(field, z);
    }

    private List<String> getFieldNames(Field field) {
        SerializedName serializedName = (SerializedName) field.getAnnotation(SerializedName.class);
        if (serializedName == null) {
            return Collections.singletonList(this.fieldNamingPolicy.translateName(field));
        }
        String value = serializedName.value();
        String[] alternate = serializedName.alternate();
        if (alternate.length == 0) {
            return Collections.singletonList(value);
        }
        ArrayList arrayList = new ArrayList(alternate.length + 1);
        arrayList.add(value);
        for (String str : alternate) {
            arrayList.add(str);
        }
        return arrayList;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        Class<? super T> rawType = typeToken.getRawType();
        if (!Object.class.isAssignableFrom(rawType)) {
            return null;
        }
        return new Adapter(this.constructorConstructor.get(typeToken), getBoundFields(gson, typeToken, rawType));
    }

    private BoundField createBoundField(final Gson gson, final Field field, String str, final TypeToken<?> typeToken, boolean z, boolean z2) {
        final boolean isPrimitive = Primitives.isPrimitive(typeToken.getRawType());
        JsonAdapter jsonAdapter = (JsonAdapter) field.getAnnotation(JsonAdapter.class);
        final TypeAdapter<?> typeAdapter = null;
        if (jsonAdapter != null) {
            typeAdapter = this.jsonAdapterFactory.getTypeAdapter(this.constructorConstructor, gson, typeToken, jsonAdapter);
        }
        final boolean z3 = typeAdapter != null;
        if (typeAdapter == null) {
            typeAdapter = gson.getAdapter(typeToken);
        }
        return new BoundField(str, z, z2) { // from class: com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.1
            /* access modifiers changed from: package-private */
            @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField
            public void write(JsonWriter jsonWriter, Object obj) {
                TypeAdapter typeAdapter2;
                Object obj2 = field.get(obj);
                if (z3) {
                    typeAdapter2 = typeAdapter;
                } else {
                    typeAdapter2 = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter, typeToken.getType());
                }
                typeAdapter2.write(jsonWriter, obj2);
            }

            /* access modifiers changed from: package-private */
            @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField
            public void read(JsonReader jsonReader, Object obj) {
                Object read = typeAdapter.read(jsonReader);
                if (read != null || !isPrimitive) {
                    field.set(obj, read);
                }
            }

            @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField
            public boolean writeField(Object obj) {
                return this.serialized && field.get(obj) != obj;
            }
        };
    }

    private Map<String, BoundField> getBoundFields(Gson gson, TypeToken<?> typeToken, Class<?> cls) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (cls.isInterface()) {
            return linkedHashMap;
        }
        Type type = typeToken.getType();
        while (cls != Object.class) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                boolean excludeField = excludeField(field, true);
                boolean excludeField2 = excludeField(field, false);
                if (excludeField || excludeField2) {
                    field.setAccessible(true);
                    Type resolve = C$Gson$Types.resolve(typeToken.getType(), cls, field.getGenericType());
                    List<String> fieldNames = getFieldNames(field);
                    BoundField boundField = null;
                    for (int i = 0; i < fieldNames.size(); i++) {
                        String str = fieldNames.get(i);
                        if (i != 0) {
                            excludeField = false;
                        }
                        BoundField boundField2 = (BoundField) linkedHashMap.put(str, createBoundField(gson, field, str, TypeToken.get(resolve), excludeField, excludeField2));
                        if (boundField == null) {
                            boundField = boundField2;
                        }
                    }
                    if (boundField != null) {
                        throw new IllegalArgumentException(type + " declares multiple JSON fields named " + boundField.name);
                    }
                }
            }
            typeToken = TypeToken.get(C$Gson$Types.resolve(typeToken.getType(), cls, cls.getGenericSuperclass()));
            cls = typeToken.getRawType();
        }
        return linkedHashMap;
    }

    /* access modifiers changed from: package-private */
    public static abstract class BoundField {
        final boolean deserialized;
        final String name;
        final boolean serialized;

        /* access modifiers changed from: package-private */
        public abstract void read(JsonReader jsonReader, Object obj);

        /* access modifiers changed from: package-private */
        public abstract void write(JsonWriter jsonWriter, Object obj);

        /* access modifiers changed from: package-private */
        public abstract boolean writeField(Object obj);

        protected BoundField(String str, boolean z, boolean z2) {
            this.name = str;
            this.serialized = z;
            this.deserialized = z2;
        }
    }

    public static final class Adapter<T> extends TypeAdapter<T> {
        private final Map<String, BoundField> boundFields;
        private final ObjectConstructor<T> constructor;

        Adapter(ObjectConstructor<T> objectConstructor, Map<String, BoundField> map) {
            this.constructor = objectConstructor;
            this.boundFields = map;
        }

        @Override // com.google.gson.TypeAdapter
        public T read(JsonReader jsonReader) {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            T construct = this.constructor.construct();
            try {
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    BoundField boundField = this.boundFields.get(jsonReader.nextName());
                    if (boundField == null || !boundField.deserialized) {
                        jsonReader.skipValue();
                    } else {
                        boundField.read(jsonReader, construct);
                    }
                }
                jsonReader.endObject();
                return construct;
            } catch (IllegalStateException e) {
                throw new JsonSyntaxException(e);
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            }
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, T t) {
            if (t == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            try {
                for (BoundField boundField : this.boundFields.values()) {
                    if (boundField.writeField(t)) {
                        jsonWriter.name(boundField.name);
                        boundField.write(jsonWriter, t);
                    }
                }
                jsonWriter.endObject();
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            }
        }
    }
}
