package o;

import java.util.List;
import java.util.Map;
import kotlin.reflect.KVisibility;
public interface FL<R> extends FM {
    R call(Object... objArr);

    R callBy(Map<Object, ? extends Object> map);

    String getName();

    List<Object> getParameters();

    FT getReturnType();

    List<Object> getTypeParameters();

    KVisibility getVisibility();

    boolean isAbstract();

    boolean isFinal();

    boolean isOpen();
}
