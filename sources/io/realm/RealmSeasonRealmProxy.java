package io.realm;

import android.annotation.TargetApi;
import android.util.JsonReader;
import android.util.JsonToken;
import com.netflix.mediaclient.servicemgr.offline.realm.RealmSeason;
import io.realm.BaseRealm;
import io.realm.internal.ColumnInfo;
import io.realm.internal.OsObject;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import io.realm.internal.Table;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
public class RealmSeasonRealmProxy extends RealmSeason implements RealmObjectProxy, RealmSeasonRealmProxyInterface {
    private static final List<String> FIELD_NAMES;
    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();
    private RealmSeasonColumnInfo columnInfo;
    private ProxyState<RealmSeason> proxyState;

    /* access modifiers changed from: package-private */
    public static final class RealmSeasonColumnInfo extends ColumnInfo {
        long numberIndex;
        long titleIndex;

        RealmSeasonColumnInfo(OsSchemaInfo osSchemaInfo) {
            super(2);
            OsObjectSchemaInfo objectSchemaInfo = osSchemaInfo.getObjectSchemaInfo("RealmSeason");
            this.numberIndex = addColumnDetails("number", objectSchemaInfo);
            this.titleIndex = addColumnDetails("title", objectSchemaInfo);
        }

        /* access modifiers changed from: protected */
        @Override // io.realm.internal.ColumnInfo
        public final void copy(ColumnInfo columnInfo, ColumnInfo columnInfo2) {
            RealmSeasonColumnInfo realmSeasonColumnInfo = (RealmSeasonColumnInfo) columnInfo;
            RealmSeasonColumnInfo realmSeasonColumnInfo2 = (RealmSeasonColumnInfo) columnInfo2;
            realmSeasonColumnInfo2.numberIndex = realmSeasonColumnInfo.numberIndex;
            realmSeasonColumnInfo2.titleIndex = realmSeasonColumnInfo.titleIndex;
        }
    }

    static {
        ArrayList arrayList = new ArrayList(2);
        arrayList.add("number");
        arrayList.add("title");
        FIELD_NAMES = Collections.unmodifiableList(arrayList);
    }

    RealmSeasonRealmProxy() {
        this.proxyState.setConstructionFinished();
    }

    @Override // io.realm.internal.RealmObjectProxy
    public void realm$injectObjectContext() {
        if (this.proxyState == null) {
            BaseRealm.RealmObjectContext realmObjectContext = (BaseRealm.RealmObjectContext) BaseRealm.objectContext.get();
            this.columnInfo = (RealmSeasonColumnInfo) realmObjectContext.getColumnInfo();
            this.proxyState = new ProxyState<>(this);
            this.proxyState.setRealm$realm(realmObjectContext.getRealm());
            this.proxyState.setRow$realm(realmObjectContext.getRow());
            this.proxyState.setAcceptDefaultValue$realm(realmObjectContext.getAcceptDefaultValue());
            this.proxyState.setExcludeFields$realm(realmObjectContext.getExcludeFields());
        }
    }

    @Override // com.netflix.mediaclient.servicemgr.offline.realm.RealmSeason, io.realm.RealmSeasonRealmProxyInterface
    public int realmGet$number() {
        this.proxyState.getRealm$realm().checkIfValid();
        return (int) this.proxyState.getRow$realm().getLong(this.columnInfo.numberIndex);
    }

    @Override // com.netflix.mediaclient.servicemgr.offline.realm.RealmSeason, io.realm.RealmSeasonRealmProxyInterface
    public void realmSet$number(int i) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setLong(this.columnInfo.numberIndex, (long) i);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            row$realm.getTable().setLong(this.columnInfo.numberIndex, row$realm.getIndex(), (long) i, true);
        }
    }

    @Override // com.netflix.mediaclient.servicemgr.offline.realm.RealmSeason, io.realm.RealmSeasonRealmProxyInterface
    public String realmGet$title() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.titleIndex);
    }

    @Override // com.netflix.mediaclient.servicemgr.offline.realm.RealmSeason, io.realm.RealmSeasonRealmProxyInterface
    public void realmSet$title(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.titleIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.titleIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.titleIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.titleIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("RealmSeason", 2, 0);
        builder.addPersistedProperty("number", RealmFieldType.INTEGER, false, false, true);
        builder.addPersistedProperty("title", RealmFieldType.STRING, false, false, false);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static RealmSeasonColumnInfo createColumnInfo(OsSchemaInfo osSchemaInfo) {
        return new RealmSeasonColumnInfo(osSchemaInfo);
    }

    public static String getTableName() {
        return "class_RealmSeason";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    public static RealmSeason createOrUpdateUsingJsonObject(Realm realm, JSONObject jSONObject, boolean z) {
        RealmSeason realmSeason = (RealmSeason) realm.createObjectInternal(RealmSeason.class, true, Collections.emptyList());
        RealmSeason realmSeason2 = realmSeason;
        if (jSONObject.has("number")) {
            if (jSONObject.isNull("number")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'number' to null.");
            }
            realmSeason2.realmSet$number(jSONObject.getInt("number"));
        }
        if (jSONObject.has("title")) {
            if (jSONObject.isNull("title")) {
                realmSeason2.realmSet$title(null);
            } else {
                realmSeason2.realmSet$title(jSONObject.getString("title"));
            }
        }
        return realmSeason;
    }

    @TargetApi(11)
    public static RealmSeason createUsingJsonStream(Realm realm, JsonReader jsonReader) {
        RealmSeason realmSeason = new RealmSeason();
        RealmSeason realmSeason2 = realmSeason;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if (nextName.equals("number")) {
                if (jsonReader.peek() != JsonToken.NULL) {
                    realmSeason2.realmSet$number(jsonReader.nextInt());
                } else {
                    jsonReader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'number' to null.");
                }
            } else if (!nextName.equals("title")) {
                jsonReader.skipValue();
            } else if (jsonReader.peek() != JsonToken.NULL) {
                realmSeason2.realmSet$title(jsonReader.nextString());
            } else {
                jsonReader.skipValue();
                realmSeason2.realmSet$title(null);
            }
        }
        jsonReader.endObject();
        return (RealmSeason) realm.copyToRealm(realmSeason);
    }

    public static RealmSeason copyOrUpdate(Realm realm, RealmSeason realmSeason, boolean z, Map<RealmModel, RealmObjectProxy> map) {
        if ((realmSeason instanceof RealmObjectProxy) && ((RealmObjectProxy) realmSeason).realmGet$proxyState().getRealm$realm() != null) {
            BaseRealm realm$realm = ((RealmObjectProxy) realmSeason).realmGet$proxyState().getRealm$realm();
            if (realm$realm.threadId != realm.threadId) {
                throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
            } else if (realm$realm.getPath().equals(realm.getPath())) {
                return realmSeason;
            }
        }
        BaseRealm.RealmObjectContext realmObjectContext = (BaseRealm.RealmObjectContext) BaseRealm.objectContext.get();
        RealmObjectProxy realmObjectProxy = map.get(realmSeason);
        if (realmObjectProxy != null) {
            return (RealmSeason) realmObjectProxy;
        }
        return copy(realm, realmSeason, z, map);
    }

    public static RealmSeason copy(Realm realm, RealmSeason realmSeason, boolean z, Map<RealmModel, RealmObjectProxy> map) {
        RealmObjectProxy realmObjectProxy = map.get(realmSeason);
        if (realmObjectProxy != null) {
            return (RealmSeason) realmObjectProxy;
        }
        RealmSeason realmSeason2 = (RealmSeason) realm.createObjectInternal(RealmSeason.class, false, Collections.emptyList());
        map.put(realmSeason, (RealmObjectProxy) realmSeason2);
        RealmSeason realmSeason3 = realmSeason;
        RealmSeason realmSeason4 = realmSeason2;
        realmSeason4.realmSet$number(realmSeason3.realmGet$number());
        realmSeason4.realmSet$title(realmSeason3.realmGet$title());
        return realmSeason2;
    }

    public static long insert(Realm realm, RealmSeason realmSeason, Map<RealmModel, Long> map) {
        if ((realmSeason instanceof RealmObjectProxy) && ((RealmObjectProxy) realmSeason).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) realmSeason).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) realmSeason).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(RealmSeason.class);
        long nativePtr = table.getNativePtr();
        RealmSeasonColumnInfo realmSeasonColumnInfo = (RealmSeasonColumnInfo) realm.getSchema().getColumnInfo(RealmSeason.class);
        long createRow = OsObject.createRow(table);
        map.put(realmSeason, Long.valueOf(createRow));
        Table.nativeSetLong(nativePtr, realmSeasonColumnInfo.numberIndex, createRow, (long) realmSeason.realmGet$number(), false);
        String realmGet$title = realmSeason.realmGet$title();
        if (realmGet$title != null) {
            Table.nativeSetString(nativePtr, realmSeasonColumnInfo.titleIndex, createRow, realmGet$title, false);
        }
        return createRow;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> it, Map<RealmModel, Long> map) {
        Table table = realm.getTable(RealmSeason.class);
        long nativePtr = table.getNativePtr();
        RealmSeasonColumnInfo realmSeasonColumnInfo = (RealmSeasonColumnInfo) realm.getSchema().getColumnInfo(RealmSeason.class);
        while (it.hasNext()) {
            RealmSeason realmSeason = (RealmSeason) it.next();
            if (!map.containsKey(realmSeason)) {
                if (!(realmSeason instanceof RealmObjectProxy) || ((RealmObjectProxy) realmSeason).realmGet$proxyState().getRealm$realm() == null || !((RealmObjectProxy) realmSeason).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    long createRow = OsObject.createRow(table);
                    map.put(realmSeason, Long.valueOf(createRow));
                    Table.nativeSetLong(nativePtr, realmSeasonColumnInfo.numberIndex, createRow, (long) realmSeason.realmGet$number(), false);
                    String realmGet$title = realmSeason.realmGet$title();
                    if (realmGet$title != null) {
                        Table.nativeSetString(nativePtr, realmSeasonColumnInfo.titleIndex, createRow, realmGet$title, false);
                    }
                } else {
                    map.put(realmSeason, Long.valueOf(((RealmObjectProxy) realmSeason).realmGet$proxyState().getRow$realm().getIndex()));
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, RealmSeason realmSeason, Map<RealmModel, Long> map) {
        if ((realmSeason instanceof RealmObjectProxy) && ((RealmObjectProxy) realmSeason).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) realmSeason).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) realmSeason).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(RealmSeason.class);
        long nativePtr = table.getNativePtr();
        RealmSeasonColumnInfo realmSeasonColumnInfo = (RealmSeasonColumnInfo) realm.getSchema().getColumnInfo(RealmSeason.class);
        long createRow = OsObject.createRow(table);
        map.put(realmSeason, Long.valueOf(createRow));
        Table.nativeSetLong(nativePtr, realmSeasonColumnInfo.numberIndex, createRow, (long) realmSeason.realmGet$number(), false);
        String realmGet$title = realmSeason.realmGet$title();
        if (realmGet$title != null) {
            Table.nativeSetString(nativePtr, realmSeasonColumnInfo.titleIndex, createRow, realmGet$title, false);
        } else {
            Table.nativeSetNull(nativePtr, realmSeasonColumnInfo.titleIndex, createRow, false);
        }
        return createRow;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> it, Map<RealmModel, Long> map) {
        Table table = realm.getTable(RealmSeason.class);
        long nativePtr = table.getNativePtr();
        RealmSeasonColumnInfo realmSeasonColumnInfo = (RealmSeasonColumnInfo) realm.getSchema().getColumnInfo(RealmSeason.class);
        while (it.hasNext()) {
            RealmSeason realmSeason = (RealmSeason) it.next();
            if (!map.containsKey(realmSeason)) {
                if (!(realmSeason instanceof RealmObjectProxy) || ((RealmObjectProxy) realmSeason).realmGet$proxyState().getRealm$realm() == null || !((RealmObjectProxy) realmSeason).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    long createRow = OsObject.createRow(table);
                    map.put(realmSeason, Long.valueOf(createRow));
                    Table.nativeSetLong(nativePtr, realmSeasonColumnInfo.numberIndex, createRow, (long) realmSeason.realmGet$number(), false);
                    String realmGet$title = realmSeason.realmGet$title();
                    if (realmGet$title != null) {
                        Table.nativeSetString(nativePtr, realmSeasonColumnInfo.titleIndex, createRow, realmGet$title, false);
                    } else {
                        Table.nativeSetNull(nativePtr, realmSeasonColumnInfo.titleIndex, createRow, false);
                    }
                } else {
                    map.put(realmSeason, Long.valueOf(((RealmObjectProxy) realmSeason).realmGet$proxyState().getRow$realm().getIndex()));
                }
            }
        }
    }

    public static RealmSeason createDetachedCopy(RealmSeason realmSeason, int i, int i2, Map<RealmModel, RealmObjectProxy.CacheData<RealmModel>> map) {
        RealmSeason realmSeason2;
        if (i > i2 || realmSeason == null) {
            return null;
        }
        RealmObjectProxy.CacheData<RealmModel> cacheData = map.get(realmSeason);
        if (cacheData == null) {
            realmSeason2 = new RealmSeason();
            map.put(realmSeason, new RealmObjectProxy.CacheData<>(i, realmSeason2));
        } else if (i >= cacheData.minDepth) {
            return (RealmSeason) cacheData.object;
        } else {
            realmSeason2 = (RealmSeason) cacheData.object;
            cacheData.minDepth = i;
        }
        RealmSeason realmSeason3 = realmSeason2;
        RealmSeason realmSeason4 = realmSeason;
        realmSeason3.realmSet$number(realmSeason4.realmGet$number());
        realmSeason3.realmSet$title(realmSeason4.realmGet$title());
        return realmSeason2;
    }

    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder sb = new StringBuilder("RealmSeason = proxy[");
        sb.append("{number:");
        sb.append(realmGet$number());
        sb.append("}");
        sb.append(",");
        sb.append("{title:");
        sb.append(realmGet$title() != null ? realmGet$title() : "null");
        sb.append("}");
        sb.append("]");
        return sb.toString();
    }

    @Override // io.realm.internal.RealmObjectProxy
    public ProxyState<?> realmGet$proxyState() {
        return this.proxyState;
    }

    public int hashCode() {
        String path = this.proxyState.getRealm$realm().getPath();
        String name = this.proxyState.getRow$realm().getTable().getName();
        long index = this.proxyState.getRow$realm().getIndex();
        return (((((path != null ? path.hashCode() : 0) + 527) * 31) + (name != null ? name.hashCode() : 0)) * 31) + ((int) ((index >>> 32) ^ index));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RealmSeasonRealmProxy realmSeasonRealmProxy = (RealmSeasonRealmProxy) obj;
        String path = this.proxyState.getRealm$realm().getPath();
        String path2 = realmSeasonRealmProxy.proxyState.getRealm$realm().getPath();
        if (path != null) {
            if (!path.equals(path2)) {
                return false;
            }
        } else if (path2 != null) {
            return false;
        }
        String name = this.proxyState.getRow$realm().getTable().getName();
        String name2 = realmSeasonRealmProxy.proxyState.getRow$realm().getTable().getName();
        if (name != null) {
            if (!name.equals(name2)) {
                return false;
            }
        } else if (name2 != null) {
            return false;
        }
        if (this.proxyState.getRow$realm().getIndex() != realmSeasonRealmProxy.proxyState.getRow$realm().getIndex()) {
            return false;
        }
        return true;
    }
}
