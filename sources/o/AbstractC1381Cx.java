package o;

import java.util.Date;
/* renamed from: o.Cx  reason: case insensitive filesystem */
public abstract class AbstractC1381Cx implements AbstractC0730, AbstractC0989, AbstractC0851 {
    private Date expires;
    protected final AbstractC0929<? extends AbstractC0730> proxy;
    private C0855<C1049> references;

    protected AbstractC1381Cx(AbstractC0929<? extends AbstractC0730> r1) {
        this.proxy = r1;
    }

    public AbstractC0929<? extends AbstractC0730> getModelProxy() {
        return this.proxy;
    }

    @Override // o.AbstractC0989
    public C0855<C1049> getReferences() {
        return this.references;
    }

    @Override // o.AbstractC0989
    public void setReferences(C0855<C1049> r1) {
        this.references = r1;
    }

    public Date getExpires() {
        return this.expires;
    }

    public void setExpires(Date date) {
        this.expires = date;
    }
}
