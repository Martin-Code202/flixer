package android.support.v4.os;
public class OperationCanceledException extends RuntimeException {
    public OperationCanceledException() {
        this(null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OperationCanceledException(String str) {
        super(str != null ? str : "The operation has been canceled.");
    }
}
