package kotlin.jvm.internal;

import java.io.Serializable;
public class Ref {

    public static final class ObjectRef<T> implements Serializable {

        /* renamed from: ˎ  reason: contains not printable characters */
        public T f4254;

        @Override // java.lang.Object
        public String toString() {
            return String.valueOf(this.f4254);
        }
    }

    public static final class FloatRef implements Serializable {

        /* renamed from: ˋ  reason: contains not printable characters */
        public float f4253;

        @Override // java.lang.Object
        public String toString() {
            return String.valueOf(this.f4253);
        }
    }
}
