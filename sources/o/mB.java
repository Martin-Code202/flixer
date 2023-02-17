package o;
public abstract class mB {

    /* renamed from: ˊ  reason: contains not printable characters */
    protected mA f8687;

    public mB(mA mAVar) {
        if (mAVar == null) {
            throw new IllegalArgumentException("Box header is null!");
        }
        this.f8687 = mAVar;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public mA m8800() {
        return this.f8687;
    }

    public String toString() {
        return "Box{boxHeader=" + this.f8687 + '}';
    }
}
