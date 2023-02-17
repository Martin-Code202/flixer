package android.support.v4.util;

import android.os.Build;
import java.util.Objects;
public class ObjectsCompat {
    public static boolean equals(Object obj, Object obj2) {
        if (Build.VERSION.SDK_INT >= 19) {
            return Objects.equals(obj, obj2);
        }
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }
}
