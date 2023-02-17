package com.netflix.android.moneyball.fields;

import java.util.List;
import o.C1456Fq;
import o.C1457Fr;
public final class ActionExecutionResult {
    private final ActionField action;
    private final List<Field> fields;
    private final String flow;
    private final String mode;

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.netflix.android.moneyball.fields.ActionExecutionResult */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ActionExecutionResult copy$default(ActionExecutionResult actionExecutionResult, ActionField actionField, List list, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            actionField = actionExecutionResult.action;
        }
        if ((i & 2) != 0) {
            list = actionExecutionResult.fields;
        }
        if ((i & 4) != 0) {
            str = actionExecutionResult.flow;
        }
        if ((i & 8) != 0) {
            str2 = actionExecutionResult.mode;
        }
        return actionExecutionResult.copy(actionField, list, str, str2);
    }

    public final ActionField component1() {
        return this.action;
    }

    public final List<Field> component2() {
        return this.fields;
    }

    public final String component3() {
        return this.flow;
    }

    public final String component4() {
        return this.mode;
    }

    public final ActionExecutionResult copy(ActionField actionField, List<? extends Field> list, String str, String str2) {
        C1457Fr.m5025(actionField, "action");
        C1457Fr.m5025(list, "fields");
        C1457Fr.m5025(str, "flow");
        C1457Fr.m5025(str2, "mode");
        return new ActionExecutionResult(actionField, list, str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActionExecutionResult)) {
            return false;
        }
        ActionExecutionResult actionExecutionResult = (ActionExecutionResult) obj;
        return C1457Fr.m5018(this.action, actionExecutionResult.action) && C1457Fr.m5018(this.fields, actionExecutionResult.fields) && C1457Fr.m5018(this.flow, actionExecutionResult.flow) && C1457Fr.m5018(this.mode, actionExecutionResult.mode);
    }

    public int hashCode() {
        ActionField actionField = this.action;
        int hashCode = (actionField != null ? actionField.hashCode() : 0) * 31;
        List<Field> list = this.fields;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
        String str = this.flow;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.mode;
        return hashCode3 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "ActionExecutionResult(action=" + this.action + ", fields=" + this.fields + ", flow=" + this.flow + ", mode=" + this.mode + ")";
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.List<? extends com.netflix.android.moneyball.fields.Field> */
    /* JADX WARN: Multi-variable type inference failed */
    public ActionExecutionResult(ActionField actionField, List<? extends Field> list, String str, String str2) {
        C1457Fr.m5025(actionField, "action");
        C1457Fr.m5025(list, "fields");
        C1457Fr.m5025(str, "flow");
        C1457Fr.m5025(str2, "mode");
        this.action = actionField;
        this.fields = list;
        this.flow = str;
        this.mode = str2;
    }

    public final ActionField getAction() {
        return this.action;
    }

    public final List<Field> getFields() {
        return this.fields;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ActionExecutionResult(ActionField actionField, List list, String str, String str2, int i, C1456Fq fq) {
        this(actionField, list, (i & 4) != 0 ? actionField.getFlowMode().getFlowId() : str, (i & 8) != 0 ? actionField.getFlowMode().getId() : str2);
    }

    public final String getFlow() {
        return this.flow;
    }

    public final String getMode() {
        return this.mode;
    }
}
