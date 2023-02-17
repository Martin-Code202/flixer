package com.netflix.android.kotlinx;

import kotlin.TypeCastException;
import kotlin.jvm.internal.Lambda;
import o.AbstractC1450Fk;
import org.json.JSONArray;
import org.json.JSONObject;
public final class JSONArrayKt$iterator$1 extends Lambda implements AbstractC1450Fk<Integer, JSONObject> {

    /* renamed from: ॱ  reason: contains not printable characters */
    final /* synthetic */ JSONArray f155;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JSONArrayKt$iterator$1(JSONArray jSONArray) {
        super(1);
        this.f155 = jSONArray;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // o.AbstractC1450Fk
    public /* synthetic */ JSONObject invoke(Integer num) {
        return m103(num.intValue());
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public final JSONObject m103(int i) {
        Object obj = this.f155.get(i);
        if (obj != null) {
            return (JSONObject) obj;
        }
        throw new TypeCastException("null cannot be cast to non-null type org.json.JSONObject");
    }
}
