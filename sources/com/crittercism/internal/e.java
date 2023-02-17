package com.crittercism.internal;

import java.lang.reflect.Field;
public final class e {
    public static <C, F> F a(Field field, C c) {
        if (field == null || field == null) {
            return null;
        }
        field.setAccessible(true);
        try {
            return (F) field.get(c);
        } catch (ThreadDeath e) {
            throw e;
        } catch (Throwable th) {
            throw new bh("Unable to get value of field", th);
        }
    }

    public static Field a(Class<?> cls, Class<?> cls2, boolean z) {
        Field[] declaredFields = cls.getDeclaredFields();
        Field field = null;
        for (int i = 0; i < declaredFields.length; i++) {
            if (cls2.isAssignableFrom(declaredFields[i].getType())) {
                if (field != null) {
                    throw new bh("Field is ambiguous: " + field.getName() + ", " + declaredFields[i].getName());
                }
                field = declaredFields[i];
            }
        }
        if (field != null) {
            field.setAccessible(true);
        } else if (z) {
            throw new bh("Could not find field matching type: " + cls2.getName());
        }
        return field;
    }
}
