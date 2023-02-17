package o;
public interface FP<R> extends FL<R> {
    boolean isExternal();

    boolean isInfix();

    boolean isInline();

    boolean isOperator();

    boolean isSuspend();
}
