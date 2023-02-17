package o;

import com.netflix.cl.model.AllocationMode;
import com.netflix.cl.model.ComputationMode;
import com.netflix.cl.model.InteractionMode;
import org.json.JSONObject;
/* renamed from: o.ڏ  reason: contains not printable characters */
public final class C0610 extends AbstractC0675 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private AllocationMode f13913;

    /* renamed from: ˋ  reason: contains not printable characters */
    private InteractionMode f13914;

    /* renamed from: ॱ  reason: contains not printable characters */
    private ComputationMode f13915;

    public C0610(AllocationMode allocationMode, ComputationMode computationMode, InteractionMode interactionMode) {
        m14630("ProcessState");
        this.f13913 = allocationMode;
        this.f13915 = computationMode;
        this.f13914 = interactionMode;
    }

    @Override // o.AbstractC0556, o.AbstractC0503
    public JSONObject toJSONObject() {
        JSONObject jSONObject = super.toJSONObject();
        if (this.f13913 == null) {
            this.f13913 = C0441.m14294();
        }
        if (this.f13915 == null) {
            this.f13915 = C0441.m14306();
        }
        if (this.f13914 == null) {
            this.f13914 = C0441.m14293();
        }
        m14628(jSONObject, "allocation", this.f13913);
        m14628(jSONObject, "computation", this.f13915);
        m14628(jSONObject, "interaction", this.f13914);
        return jSONObject;
    }

    public String toString() {
        return "ProcessState{memory=" + this.f13913 + ", comp=" + this.f13915 + ", interactionMode=" + this.f13914 + '}';
    }
}
