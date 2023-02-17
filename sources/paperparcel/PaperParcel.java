package paperparcel;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Target({ElementType.TYPE})
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface PaperParcel {

    @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Options {
    }
}
