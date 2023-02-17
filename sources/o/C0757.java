package o;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.os.SystemClock;
import com.airbnb.lottie.model.layer.Layer;
import com.netflix.mediaclient.android.widget.NetflixLottieHelper$loadCompositionFromAssetFile$1$1;
import com.netflix.mediaclient.android.widget.NetflixLottieHelper$loadCompositionFromAssetFile$1$2;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.rxkotlin.SubscribersKt;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@SuppressLint({"RestrictedApi"})
/* renamed from: o.ᐹ  reason: contains not printable characters */
public final class C0757 {

    /* renamed from: ॱ  reason: contains not printable characters */
    public static final C0757 f14372 = new C0757();

    private C0757() {
    }

    /* access modifiers changed from: private */
    /* renamed from: ˎ  reason: contains not printable characters */
    public final boolean m15177(C0433 r8) {
        for (Layer layer : r8.m14252()) {
            String layer2 = layer.toString();
            C1457Fr.m5016((Object) layer2, "layer.toString()");
            if (Ge.m5105(layer2, "nflx-", false, 2, null)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: o.ᐹ$ˊ  reason: contains not printable characters */
    public static final class C0758<T> implements SingleOnSubscribe<T> {

        /* renamed from: ˊ  reason: contains not printable characters */
        public final /* synthetic */ Context f14375;

        /* renamed from: ˏ  reason: contains not printable characters */
        final /* synthetic */ String f14376;

        C0758(String str, Context context) {
            this.f14376 = str;
            this.f14375 = context;
        }

        @Override // io.reactivex.SingleOnSubscribe
        public final void subscribe(SingleEmitter<C0676> singleEmitter) {
            C1457Fr.m5025(singleEmitter, "emitter");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("name", "LOTTIE_COMPOSITION_LOAD");
            jSONObject.put("fileName", this.f14376);
            long elapsedRealtime = SystemClock.elapsedRealtime();
            Single<T> observeOn = C0757.f14372.m15178(this.f14376, this.f14375).observeOn(Schedulers.io());
            C1457Fr.m5016((Object) observeOn, "jsonReadFromAssetFile(fi…bserveOn(Schedulers.io())");
            SubscribersKt.subscribeBy(observeOn, new NetflixLottieHelper$loadCompositionFromAssetFile$1$2(jSONObject, singleEmitter), new NetflixLottieHelper$loadCompositionFromAssetFile$1$1(this, jSONObject, singleEmitter, elapsedRealtime));
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public final Single<C0676> m15180(Context context, String str) {
        C1457Fr.m5025(context, "context");
        C1457Fr.m5025(str, "fileName");
        Single<C0676> create = Single.create(new C0758(str, context));
        C1457Fr.m5016((Object) create, "Single.create({ emitter …             )\n        })");
        return create;
    }

    /* access modifiers changed from: private */
    /* renamed from: ˏ  reason: contains not printable characters */
    public final List<C0926> m15179(JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("layers");
            int length = optJSONArray.length() - 1;
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject.has("nm")) {
                    String string = optJSONObject.getString("nm");
                    C1457Fr.m5016((Object) string, "layerTag");
                    if (Ge.m5067(string, "nflx-", false, 2, null)) {
                        ArrayList arrayList2 = new ArrayList();
                        List r14 = Ge.m5087((CharSequence) string, new String[]{"-"}, false, 0, 6, (Object) null);
                        for (String str : Ge.m5087((CharSequence) r14.get(r14.size() - 1), new String[]{"*"}, false, 0, 6, (Object) null)) {
                            arrayList2.add(Integer.valueOf(Integer.parseInt(str)));
                        }
                        JSONArray jSONArray = optJSONObject.optJSONArray("shapes").optJSONObject(0).optJSONArray("it").optJSONObject(0).optJSONObject("s").getJSONArray("k");
                        JSONArray jSONArray2 = optJSONObject.optJSONObject("ks").optJSONObject("p").getJSONArray("k");
                        JSONArray jSONArray3 = optJSONObject.optJSONObject("ks").optJSONObject("a").getJSONArray("k");
                        double optDouble = jSONArray3.length() >= 2 ? jSONArray3.optDouble(0) / 100.0d : 1.0d;
                        double optDouble2 = jSONArray3.length() >= 2 ? jSONArray3.optDouble(1) / 100.0d : 1.0d;
                        Rect rect = new Rect();
                        if (jSONArray.length() >= 2) {
                            int i2 = (int) (jSONArray.getDouble(0) * optDouble);
                            int i3 = (int) (jSONArray.getDouble(1) * optDouble2);
                            int i4 = (int) (jSONArray2.getDouble(0) - ((double) (i2 / 2)));
                            int i5 = (int) (jSONArray2.getDouble(1) - ((double) (i3 / 2)));
                            rect.set(i4, i5, i4 + i2, i5 + i3);
                        }
                        String str2 = (String) r14.get(0);
                        for (int i6 = 1; i6 < r14.size() - 1; i6++) {
                            str2 = str2 + "-" + ((String) r14.get(i6));
                        }
                        C0926 r0 = new C0926(str2, ((Number) arrayList2.get(0)).intValue(), ((Number) arrayList2.get(1)).intValue(), ((Number) arrayList2.get(2)).intValue(), arrayList2.size() < 4 ? -1 : ((Number) arrayList2.get(3)).intValue(), rect);
                        C1283.m16854("NetflixLottieHelper", "" + string + " = " + r0);
                        arrayList.add(r0);
                    }
                }
            }
        } catch (JSONException e) {
            C1276.m16820().mo5729("field parsing for nflx-* failed on the lottie json while creating tap list", e);
            arrayList.clear();
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o.ᐹ$If */
    public static final class If<T> implements SingleOnSubscribe<JSONObject> {

        /* renamed from: ˊ  reason: contains not printable characters */
        final /* synthetic */ String f14373;

        /* renamed from: ˏ  reason: contains not printable characters */
        final /* synthetic */ Context f14374;

        If(Context context, String str) {
            this.f14374 = context;
            this.f14373 = str;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:43:0x00a2, code lost:
            r5 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x00a3, code lost:
            o.C1445Ff.m5001(r3, r5);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x00a6, code lost:
            throw r5;
         */
        @Override // io.reactivex.SingleOnSubscribe
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void subscribe(io.reactivex.SingleEmitter<org.json.JSONObject> r15) {
            /*
                r14 = this;
                java.lang.String r0 = "emitter"
                o.C1457Fr.m5025(r15, r0)
                android.content.Context r0 = r14.f14374     // Catch:{ IOException -> 0x0012 }
                android.content.res.AssetManager r0 = r0.getAssets()     // Catch:{ IOException -> 0x0012 }
                java.lang.String r1 = r14.f14373     // Catch:{ IOException -> 0x0012 }
                java.io.InputStream r3 = r0.open(r1)     // Catch:{ IOException -> 0x0012 }
                goto L_0x001a
            L_0x0012:
                r4 = move-exception
                r0 = r4
                java.lang.Throwable r0 = (java.lang.Throwable) r0
                r15.onError(r0)
                r3 = 0
            L_0x001a:
                r2 = r3
                if (r2 == 0) goto L_0x0039
                r3 = r2
                java.nio.charset.Charset r4 = o.Gd.f5691
                r6 = r3
                java.io.InputStreamReader r0 = new java.io.InputStreamReader
                r0.<init>(r6, r4)
                r6 = r0
                java.io.Reader r6 = (java.io.Reader) r6
                r7 = 8192(0x2000, float:1.14794E-41)
                boolean r0 = r6 instanceof java.io.BufferedReader
                if (r0 == 0) goto L_0x0033
                r0 = r6
                java.io.BufferedReader r0 = (java.io.BufferedReader) r0
                goto L_0x0038
            L_0x0033:
                java.io.BufferedReader r0 = new java.io.BufferedReader
                r0.<init>(r6, r7)
            L_0x0038:
                goto L_0x003a
            L_0x0039:
                r0 = 0
            L_0x003a:
                r3 = r0
                java.io.Closeable r3 = (java.io.Closeable) r3
                r4 = 0
                r4 = 0
                r5 = r3
                java.io.BufferedReader r5 = (java.io.BufferedReader) r5     // Catch:{ Throwable -> 0x009f }
                r6 = r5
                if (r6 == 0) goto L_0x008f
                r0 = r6
                java.io.Reader r0 = (java.io.Reader) r0     // Catch:{ IOException -> 0x0091 }
                java.lang.String r6 = o.C1448Fi.m5009(r0)     // Catch:{ IOException -> 0x0091 }
                if (r6 == 0) goto L_0x008f
                r7 = r6
                org.json.JSONObject r10 = new org.json.JSONObject     // Catch:{ JSONException -> 0x007e }
                r8 = r7
                r9 = r10
                java.nio.charset.Charset r11 = o.Gd.f5691     // Catch:{ JSONException -> 0x007e }
                if (r8 != 0) goto L_0x005f
                kotlin.TypeCastException r0 = new kotlin.TypeCastException     // Catch:{ JSONException -> 0x007e }
                java.lang.String r1 = "null cannot be cast to non-null type java.lang.String"
                r0.<init>(r1)     // Catch:{ JSONException -> 0x007e }
                throw r0     // Catch:{ JSONException -> 0x007e }
            L_0x005f:
                byte[] r12 = r8.getBytes(r11)     // Catch:{ JSONException -> 0x007e }
                java.lang.String r0 = "(this as java.lang.String).getBytes(charset)"
                o.C1457Fr.m5016(r12, r0)     // Catch:{ JSONException -> 0x007e }
                r8 = r12
                java.lang.String r0 = "UTF-8"
                java.nio.charset.Charset r11 = java.nio.charset.Charset.forName(r0)     // Catch:{ JSONException -> 0x007e }
                java.lang.String r0 = "Charset.forName(\"UTF-8\")"
                o.C1457Fr.m5016(r11, r0)     // Catch:{ JSONException -> 0x007e }
                java.lang.String r12 = new java.lang.String     // Catch:{ JSONException -> 0x007e }
                r12.<init>(r8, r11)     // Catch:{ JSONException -> 0x007e }
                r9.<init>(r12)     // Catch:{ JSONException -> 0x007e }
                r8 = r10
                goto L_0x0086
            L_0x007e:
                r11 = move-exception
                r0 = r11
                java.lang.Throwable r0 = (java.lang.Throwable) r0
                r15.onError(r0)
                r8 = 0
            L_0x0086:
                r13 = r8
                if (r13 == 0) goto L_0x008c
                r15.onSuccess(r13)
            L_0x008c:
                o.EA r6 = o.EA.f5503
                goto L_0x0090
            L_0x008f:
                r6 = 0
            L_0x0090:
                goto L_0x009a
            L_0x0091:
                r7 = move-exception
                r0 = r7
                java.lang.Throwable r0 = (java.lang.Throwable) r0
                r15.onError(r0)
                o.EA r6 = o.EA.f5503
            L_0x009a:
                r5 = r6
                o.C1445Ff.m5001(r3, r4)
                goto L_0x00a7
            L_0x009f:
                r5 = move-exception
                r4 = r5
                throw r5     // Catch:{ all -> 0x00a2 }
            L_0x00a2:
                r5 = move-exception
                o.C1445Ff.m5001(r3, r4)
                throw r5
            L_0x00a7:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: o.C0757.If.subscribe(io.reactivex.SingleEmitter):void");
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˏ  reason: contains not printable characters */
    private final Single<JSONObject> m15178(String str, Context context) {
        Single<JSONObject> subscribeOn = Single.create(new If(context, str)).subscribeOn(Schedulers.io());
        C1457Fr.m5016((Object) subscribeOn, "Single.create(SingleOnSu…scribeOn(Schedulers.io())");
        return subscribeOn;
    }
}
