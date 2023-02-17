package com.google.android.gms.dynamic;

import android.os.IBinder;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.lang.reflect.Field;
public final class zzn<T> extends IObjectWrapper.zza {
    private final T mWrappedObject;

    private zzn(T t) {
        this.mWrappedObject = t;
    }

    public static <T> IObjectWrapper zzw(T t) {
        return new zzn(t);
    }

    public static <T> T zzx(IObjectWrapper iObjectWrapper) {
        if (iObjectWrapper instanceof zzn) {
            return ((zzn) iObjectWrapper).mWrappedObject;
        }
        IBinder asBinder = iObjectWrapper.asBinder();
        Field[] declaredFields = asBinder.getClass().getDeclaredFields();
        Field field = null;
        int i = 0;
        for (Field field2 : declaredFields) {
            if (!field2.isSynthetic()) {
                field = field2;
                i++;
            }
        }
        if (i != 1) {
            throw new IllegalArgumentException(new StringBuilder(64).append("Unexpected number of IObjectWrapper declared fields: ").append(declaredFields.length).toString());
        } else if (!field.isAccessible()) {
            field.setAccessible(true);
            try {
                return (T) field.get(asBinder);
            } catch (NullPointerException e) {
                throw new IllegalArgumentException("Binder object is null.", e);
            } catch (IllegalAccessException e2) {
                throw new IllegalArgumentException("Could not access the field in remoteBinder.", e2);
            }
        } else {
            throw new IllegalArgumentException("IObjectWrapper declared field not private!");
        }
    }
}
