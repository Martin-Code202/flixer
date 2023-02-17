package io.realm;

import android.annotation.TargetApi;
import android.util.JsonReader;
import android.util.JsonToken;
import com.netflix.mediaclient.servicemgr.offline.realm.RealmIncompleteVideoDetails;
import io.realm.BaseRealm;
import io.realm.exceptions.RealmException;
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
public class RealmIncompleteVideoDetailsRealmProxy extends RealmIncompleteVideoDetails implements RealmObjectProxy, RealmIncompleteVideoDetailsRealmProxyInterface {
    private static final List<String> FIELD_NAMES;
    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();
    private RealmIncompleteVideoDetailsColumnInfo columnInfo;
    private ProxyState<RealmIncompleteVideoDetails> proxyState;

    /* access modifiers changed from: package-private */
    public static final class RealmIncompleteVideoDetailsColumnInfo extends ColumnInfo {
        long playableIdIndex;
        long profileIdIndex;
        long videoTypeIndex;

        RealmIncompleteVideoDetailsColumnInfo(OsSchemaInfo osSchemaInfo) {
            super(3);
            OsObjectSchemaInfo objectSchemaInfo = osSchemaInfo.getObjectSchemaInfo("RealmIncompleteVideoDetails");
            this.playableIdIndex = addColumnDetails("playableId", objectSchemaInfo);
            this.videoTypeIndex = addColumnDetails("videoType", objectSchemaInfo);
            this.profileIdIndex = addColumnDetails("profileId", objectSchemaInfo);
        }

        /* access modifiers changed from: protected */
        @Override // io.realm.internal.ColumnInfo
        public final void copy(ColumnInfo columnInfo, ColumnInfo columnInfo2) {
            RealmIncompleteVideoDetailsColumnInfo realmIncompleteVideoDetailsColumnInfo = (RealmIncompleteVideoDetailsColumnInfo) columnInfo;
            RealmIncompleteVideoDetailsColumnInfo realmIncompleteVideoDetailsColumnInfo2 = (RealmIncompleteVideoDetailsColumnInfo) columnInfo2;
            realmIncompleteVideoDetailsColumnInfo2.playableIdIndex = realmIncompleteVideoDetailsColumnInfo.playableIdIndex;
            realmIncompleteVideoDetailsColumnInfo2.videoTypeIndex = realmIncompleteVideoDetailsColumnInfo.videoTypeIndex;
            realmIncompleteVideoDetailsColumnInfo2.profileIdIndex = realmIncompleteVideoDetailsColumnInfo.profileIdIndex;
        }
    }

    static {
        ArrayList arrayList = new ArrayList(3);
        arrayList.add("playableId");
        arrayList.add("videoType");
        arrayList.add("profileId");
        FIELD_NAMES = Collections.unmodifiableList(arrayList);
    }

    RealmIncompleteVideoDetailsRealmProxy() {
        this.proxyState.setConstructionFinished();
    }

    @Override // io.realm.internal.RealmObjectProxy
    public void realm$injectObjectContext() {
        if (this.proxyState == null) {
            BaseRealm.RealmObjectContext realmObjectContext = (BaseRealm.RealmObjectContext) BaseRealm.objectContext.get();
            this.columnInfo = (RealmIncompleteVideoDetailsColumnInfo) realmObjectContext.getColumnInfo();
            this.proxyState = new ProxyState<>(this);
            this.proxyState.setRealm$realm(realmObjectContext.getRealm());
            this.proxyState.setRow$realm(realmObjectContext.getRow());
            this.proxyState.setAcceptDefaultValue$realm(realmObjectContext.getAcceptDefaultValue());
            this.proxyState.setExcludeFields$realm(realmObjectContext.getExcludeFields());
        }
    }

    @Override // com.netflix.mediaclient.servicemgr.offline.realm.RealmIncompleteVideoDetails, io.realm.RealmIncompleteVideoDetailsRealmProxyInterface
    public String realmGet$playableId() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.playableIdIndex);
    }

    @Override // com.netflix.mediaclient.servicemgr.offline.realm.RealmIncompleteVideoDetails, io.realm.RealmIncompleteVideoDetailsRealmProxyInterface
    public void realmSet$playableId(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            throw new RealmException("Primary key field 'playableId' cannot be changed after object was created.");
        }
    }

    @Override // com.netflix.mediaclient.servicemgr.offline.realm.RealmIncompleteVideoDetails, io.realm.RealmIncompleteVideoDetailsRealmProxyInterface
    public int realmGet$videoType() {
        this.proxyState.getRealm$realm().checkIfValid();
        return (int) this.proxyState.getRow$realm().getLong(this.columnInfo.videoTypeIndex);
    }

    @Override // com.netflix.mediaclient.servicemgr.offline.realm.RealmIncompleteVideoDetails, io.realm.RealmIncompleteVideoDetailsRealmProxyInterface
    public void realmSet$videoType(int i) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            this.proxyState.getRow$realm().setLong(this.columnInfo.videoTypeIndex, (long) i);
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            row$realm.getTable().setLong(this.columnInfo.videoTypeIndex, row$realm.getIndex(), (long) i, true);
        }
    }

    @Override // com.netflix.mediaclient.servicemgr.offline.realm.RealmIncompleteVideoDetails, io.realm.RealmIncompleteVideoDetailsRealmProxyInterface
    public String realmGet$profileId() {
        this.proxyState.getRealm$realm().checkIfValid();
        return this.proxyState.getRow$realm().getString(this.columnInfo.profileIdIndex);
    }

    @Override // com.netflix.mediaclient.servicemgr.offline.realm.RealmIncompleteVideoDetails, io.realm.RealmIncompleteVideoDetailsRealmProxyInterface
    public void realmSet$profileId(String str) {
        if (!this.proxyState.isUnderConstruction()) {
            this.proxyState.getRealm$realm().checkIfValid();
            if (str == null) {
                this.proxyState.getRow$realm().setNull(this.columnInfo.profileIdIndex);
            } else {
                this.proxyState.getRow$realm().setString(this.columnInfo.profileIdIndex, str);
            }
        } else if (this.proxyState.getAcceptDefaultValue$realm()) {
            Row row$realm = this.proxyState.getRow$realm();
            if (str == null) {
                row$realm.getTable().setNull(this.columnInfo.profileIdIndex, row$realm.getIndex(), true);
            } else {
                row$realm.getTable().setString(this.columnInfo.profileIdIndex, row$realm.getIndex(), str, true);
            }
        }
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("RealmIncompleteVideoDetails", 3, 0);
        builder.addPersistedProperty("playableId", RealmFieldType.STRING, true, true, false);
        builder.addPersistedProperty("videoType", RealmFieldType.INTEGER, false, false, true);
        builder.addPersistedProperty("profileId", RealmFieldType.STRING, false, false, false);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static RealmIncompleteVideoDetailsColumnInfo createColumnInfo(OsSchemaInfo osSchemaInfo) {
        return new RealmIncompleteVideoDetailsColumnInfo(osSchemaInfo);
    }

    public static String getTableName() {
        return "class_RealmIncompleteVideoDetails";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    public static RealmIncompleteVideoDetails createOrUpdateUsingJsonObject(Realm realm, JSONObject jSONObject, boolean z) {
        long j;
        List<String> emptyList = Collections.emptyList();
        RealmIncompleteVideoDetailsRealmProxy realmIncompleteVideoDetailsRealmProxy = null;
        if (z) {
            Table table = realm.getTable(RealmIncompleteVideoDetails.class);
            long j2 = ((RealmIncompleteVideoDetailsColumnInfo) realm.getSchema().getColumnInfo(RealmIncompleteVideoDetails.class)).playableIdIndex;
            if (jSONObject.isNull("playableId")) {
                j = table.findFirstNull(j2);
            } else {
                j = table.findFirstString(j2, jSONObject.getString("playableId"));
            }
            if (j != -1) {
                BaseRealm.RealmObjectContext realmObjectContext = (BaseRealm.RealmObjectContext) BaseRealm.objectContext.get();
                try {
                    realmObjectContext.set(realm, table.getUncheckedRow(j), realm.getSchema().getColumnInfo(RealmIncompleteVideoDetails.class), false, Collections.emptyList());
                    realmIncompleteVideoDetailsRealmProxy = new RealmIncompleteVideoDetailsRealmProxy();
                } finally {
                    realmObjectContext.clear();
                }
            }
        }
        if (realmIncompleteVideoDetailsRealmProxy == null) {
            if (!jSONObject.has("playableId")) {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'playableId'.");
            } else if (jSONObject.isNull("playableId")) {
                realmIncompleteVideoDetailsRealmProxy = (RealmIncompleteVideoDetailsRealmProxy) realm.createObjectInternal(RealmIncompleteVideoDetails.class, null, true, emptyList);
            } else {
                realmIncompleteVideoDetailsRealmProxy = (RealmIncompleteVideoDetailsRealmProxy) realm.createObjectInternal(RealmIncompleteVideoDetails.class, jSONObject.getString("playableId"), true, emptyList);
            }
        }
        RealmIncompleteVideoDetailsRealmProxy realmIncompleteVideoDetailsRealmProxy2 = realmIncompleteVideoDetailsRealmProxy;
        if (jSONObject.has("videoType")) {
            if (jSONObject.isNull("videoType")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'videoType' to null.");
            }
            realmIncompleteVideoDetailsRealmProxy2.realmSet$videoType(jSONObject.getInt("videoType"));
        }
        if (jSONObject.has("profileId")) {
            if (jSONObject.isNull("profileId")) {
                realmIncompleteVideoDetailsRealmProxy2.realmSet$profileId(null);
            } else {
                realmIncompleteVideoDetailsRealmProxy2.realmSet$profileId(jSONObject.getString("profileId"));
            }
        }
        return realmIncompleteVideoDetailsRealmProxy;
    }

    @TargetApi(11)
    public static RealmIncompleteVideoDetails createUsingJsonStream(Realm realm, JsonReader jsonReader) {
        boolean z = false;
        RealmIncompleteVideoDetails realmIncompleteVideoDetails = new RealmIncompleteVideoDetails();
        RealmIncompleteVideoDetails realmIncompleteVideoDetails2 = realmIncompleteVideoDetails;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if (nextName.equals("playableId")) {
                if (jsonReader.peek() != JsonToken.NULL) {
                    realmIncompleteVideoDetails2.realmSet$playableId(jsonReader.nextString());
                } else {
                    jsonReader.skipValue();
                    realmIncompleteVideoDetails2.realmSet$playableId(null);
                }
                z = true;
            } else if (nextName.equals("videoType")) {
                if (jsonReader.peek() != JsonToken.NULL) {
                    realmIncompleteVideoDetails2.realmSet$videoType(jsonReader.nextInt());
                } else {
                    jsonReader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'videoType' to null.");
                }
            } else if (!nextName.equals("profileId")) {
                jsonReader.skipValue();
            } else if (jsonReader.peek() != JsonToken.NULL) {
                realmIncompleteVideoDetails2.realmSet$profileId(jsonReader.nextString());
            } else {
                jsonReader.skipValue();
                realmIncompleteVideoDetails2.realmSet$profileId(null);
            }
        }
        jsonReader.endObject();
        if (z) {
            return (RealmIncompleteVideoDetails) realm.copyToRealm(realmIncompleteVideoDetails);
        }
        throw new IllegalArgumentException("JSON object doesn't have the primary key field 'playableId'.");
    }

    public static RealmIncompleteVideoDetails copyOrUpdate(Realm realm, RealmIncompleteVideoDetails realmIncompleteVideoDetails, boolean z, Map<RealmModel, RealmObjectProxy> map) {
        long j;
        if ((realmIncompleteVideoDetails instanceof RealmObjectProxy) && ((RealmObjectProxy) realmIncompleteVideoDetails).realmGet$proxyState().getRealm$realm() != null) {
            BaseRealm realm$realm = ((RealmObjectProxy) realmIncompleteVideoDetails).realmGet$proxyState().getRealm$realm();
            if (realm$realm.threadId != realm.threadId) {
                throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
            } else if (realm$realm.getPath().equals(realm.getPath())) {
                return realmIncompleteVideoDetails;
            }
        }
        BaseRealm.RealmObjectContext realmObjectContext = (BaseRealm.RealmObjectContext) BaseRealm.objectContext.get();
        RealmObjectProxy realmObjectProxy = map.get(realmIncompleteVideoDetails);
        if (realmObjectProxy != null) {
            return (RealmIncompleteVideoDetails) realmObjectProxy;
        }
        RealmIncompleteVideoDetailsRealmProxy realmIncompleteVideoDetailsRealmProxy = null;
        boolean z2 = z;
        if (z2) {
            Table table = realm.getTable(RealmIncompleteVideoDetails.class);
            long j2 = ((RealmIncompleteVideoDetailsColumnInfo) realm.getSchema().getColumnInfo(RealmIncompleteVideoDetails.class)).playableIdIndex;
            String realmGet$playableId = realmIncompleteVideoDetails.realmGet$playableId();
            if (realmGet$playableId == null) {
                j = table.findFirstNull(j2);
            } else {
                j = table.findFirstString(j2, realmGet$playableId);
            }
            if (j == -1) {
                z2 = false;
            } else {
                try {
                    realmObjectContext.set(realm, table.getUncheckedRow(j), realm.getSchema().getColumnInfo(RealmIncompleteVideoDetails.class), false, Collections.emptyList());
                    realmIncompleteVideoDetailsRealmProxy = new RealmIncompleteVideoDetailsRealmProxy();
                    map.put(realmIncompleteVideoDetails, realmIncompleteVideoDetailsRealmProxy);
                } finally {
                    realmObjectContext.clear();
                }
            }
        }
        return z2 ? update(realm, realmIncompleteVideoDetailsRealmProxy, realmIncompleteVideoDetails, map) : copy(realm, realmIncompleteVideoDetails, z, map);
    }

    public static RealmIncompleteVideoDetails copy(Realm realm, RealmIncompleteVideoDetails realmIncompleteVideoDetails, boolean z, Map<RealmModel, RealmObjectProxy> map) {
        RealmObjectProxy realmObjectProxy = map.get(realmIncompleteVideoDetails);
        if (realmObjectProxy != null) {
            return (RealmIncompleteVideoDetails) realmObjectProxy;
        }
        RealmIncompleteVideoDetails realmIncompleteVideoDetails2 = (RealmIncompleteVideoDetails) realm.createObjectInternal(RealmIncompleteVideoDetails.class, realmIncompleteVideoDetails.realmGet$playableId(), false, Collections.emptyList());
        map.put(realmIncompleteVideoDetails, (RealmObjectProxy) realmIncompleteVideoDetails2);
        RealmIncompleteVideoDetails realmIncompleteVideoDetails3 = realmIncompleteVideoDetails;
        RealmIncompleteVideoDetails realmIncompleteVideoDetails4 = realmIncompleteVideoDetails2;
        realmIncompleteVideoDetails4.realmSet$videoType(realmIncompleteVideoDetails3.realmGet$videoType());
        realmIncompleteVideoDetails4.realmSet$profileId(realmIncompleteVideoDetails3.realmGet$profileId());
        return realmIncompleteVideoDetails2;
    }

    public static long insert(Realm realm, RealmIncompleteVideoDetails realmIncompleteVideoDetails, Map<RealmModel, Long> map) {
        long j;
        if ((realmIncompleteVideoDetails instanceof RealmObjectProxy) && ((RealmObjectProxy) realmIncompleteVideoDetails).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) realmIncompleteVideoDetails).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) realmIncompleteVideoDetails).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(RealmIncompleteVideoDetails.class);
        long nativePtr = table.getNativePtr();
        RealmIncompleteVideoDetailsColumnInfo realmIncompleteVideoDetailsColumnInfo = (RealmIncompleteVideoDetailsColumnInfo) realm.getSchema().getColumnInfo(RealmIncompleteVideoDetails.class);
        long j2 = realmIncompleteVideoDetailsColumnInfo.playableIdIndex;
        String realmGet$playableId = realmIncompleteVideoDetails.realmGet$playableId();
        if (realmGet$playableId == null) {
            j = Table.nativeFindFirstNull(nativePtr, j2);
        } else {
            j = Table.nativeFindFirstString(nativePtr, j2, realmGet$playableId);
        }
        if (j == -1) {
            j = OsObject.createRowWithPrimaryKey(table, j2, realmGet$playableId);
        } else {
            Table.throwDuplicatePrimaryKeyException(realmGet$playableId);
        }
        map.put(realmIncompleteVideoDetails, Long.valueOf(j));
        Table.nativeSetLong(nativePtr, realmIncompleteVideoDetailsColumnInfo.videoTypeIndex, j, (long) realmIncompleteVideoDetails.realmGet$videoType(), false);
        String realmGet$profileId = realmIncompleteVideoDetails.realmGet$profileId();
        if (realmGet$profileId != null) {
            Table.nativeSetString(nativePtr, realmIncompleteVideoDetailsColumnInfo.profileIdIndex, j, realmGet$profileId, false);
        }
        return j;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> it, Map<RealmModel, Long> map) {
        long j;
        Table table = realm.getTable(RealmIncompleteVideoDetails.class);
        long nativePtr = table.getNativePtr();
        RealmIncompleteVideoDetailsColumnInfo realmIncompleteVideoDetailsColumnInfo = (RealmIncompleteVideoDetailsColumnInfo) realm.getSchema().getColumnInfo(RealmIncompleteVideoDetails.class);
        long j2 = realmIncompleteVideoDetailsColumnInfo.playableIdIndex;
        while (it.hasNext()) {
            RealmIncompleteVideoDetails realmIncompleteVideoDetails = (RealmIncompleteVideoDetails) it.next();
            if (!map.containsKey(realmIncompleteVideoDetails)) {
                if (!(realmIncompleteVideoDetails instanceof RealmObjectProxy) || ((RealmObjectProxy) realmIncompleteVideoDetails).realmGet$proxyState().getRealm$realm() == null || !((RealmObjectProxy) realmIncompleteVideoDetails).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    String realmGet$playableId = realmIncompleteVideoDetails.realmGet$playableId();
                    if (realmGet$playableId == null) {
                        j = Table.nativeFindFirstNull(nativePtr, j2);
                    } else {
                        j = Table.nativeFindFirstString(nativePtr, j2, realmGet$playableId);
                    }
                    if (j == -1) {
                        j = OsObject.createRowWithPrimaryKey(table, j2, realmGet$playableId);
                    } else {
                        Table.throwDuplicatePrimaryKeyException(realmGet$playableId);
                    }
                    map.put(realmIncompleteVideoDetails, Long.valueOf(j));
                    Table.nativeSetLong(nativePtr, realmIncompleteVideoDetailsColumnInfo.videoTypeIndex, j, (long) realmIncompleteVideoDetails.realmGet$videoType(), false);
                    String realmGet$profileId = realmIncompleteVideoDetails.realmGet$profileId();
                    if (realmGet$profileId != null) {
                        Table.nativeSetString(nativePtr, realmIncompleteVideoDetailsColumnInfo.profileIdIndex, j, realmGet$profileId, false);
                    }
                } else {
                    map.put(realmIncompleteVideoDetails, Long.valueOf(((RealmObjectProxy) realmIncompleteVideoDetails).realmGet$proxyState().getRow$realm().getIndex()));
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, RealmIncompleteVideoDetails realmIncompleteVideoDetails, Map<RealmModel, Long> map) {
        long j;
        if ((realmIncompleteVideoDetails instanceof RealmObjectProxy) && ((RealmObjectProxy) realmIncompleteVideoDetails).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) realmIncompleteVideoDetails).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) realmIncompleteVideoDetails).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(RealmIncompleteVideoDetails.class);
        long nativePtr = table.getNativePtr();
        RealmIncompleteVideoDetailsColumnInfo realmIncompleteVideoDetailsColumnInfo = (RealmIncompleteVideoDetailsColumnInfo) realm.getSchema().getColumnInfo(RealmIncompleteVideoDetails.class);
        long j2 = realmIncompleteVideoDetailsColumnInfo.playableIdIndex;
        String realmGet$playableId = realmIncompleteVideoDetails.realmGet$playableId();
        if (realmGet$playableId == null) {
            j = Table.nativeFindFirstNull(nativePtr, j2);
        } else {
            j = Table.nativeFindFirstString(nativePtr, j2, realmGet$playableId);
        }
        if (j == -1) {
            j = OsObject.createRowWithPrimaryKey(table, j2, realmGet$playableId);
        }
        map.put(realmIncompleteVideoDetails, Long.valueOf(j));
        Table.nativeSetLong(nativePtr, realmIncompleteVideoDetailsColumnInfo.videoTypeIndex, j, (long) realmIncompleteVideoDetails.realmGet$videoType(), false);
        String realmGet$profileId = realmIncompleteVideoDetails.realmGet$profileId();
        if (realmGet$profileId != null) {
            Table.nativeSetString(nativePtr, realmIncompleteVideoDetailsColumnInfo.profileIdIndex, j, realmGet$profileId, false);
        } else {
            Table.nativeSetNull(nativePtr, realmIncompleteVideoDetailsColumnInfo.profileIdIndex, j, false);
        }
        return j;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> it, Map<RealmModel, Long> map) {
        long j;
        Table table = realm.getTable(RealmIncompleteVideoDetails.class);
        long nativePtr = table.getNativePtr();
        RealmIncompleteVideoDetailsColumnInfo realmIncompleteVideoDetailsColumnInfo = (RealmIncompleteVideoDetailsColumnInfo) realm.getSchema().getColumnInfo(RealmIncompleteVideoDetails.class);
        long j2 = realmIncompleteVideoDetailsColumnInfo.playableIdIndex;
        while (it.hasNext()) {
            RealmIncompleteVideoDetails realmIncompleteVideoDetails = (RealmIncompleteVideoDetails) it.next();
            if (!map.containsKey(realmIncompleteVideoDetails)) {
                if (!(realmIncompleteVideoDetails instanceof RealmObjectProxy) || ((RealmObjectProxy) realmIncompleteVideoDetails).realmGet$proxyState().getRealm$realm() == null || !((RealmObjectProxy) realmIncompleteVideoDetails).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    String realmGet$playableId = realmIncompleteVideoDetails.realmGet$playableId();
                    if (realmGet$playableId == null) {
                        j = Table.nativeFindFirstNull(nativePtr, j2);
                    } else {
                        j = Table.nativeFindFirstString(nativePtr, j2, realmGet$playableId);
                    }
                    if (j == -1) {
                        j = OsObject.createRowWithPrimaryKey(table, j2, realmGet$playableId);
                    }
                    map.put(realmIncompleteVideoDetails, Long.valueOf(j));
                    Table.nativeSetLong(nativePtr, realmIncompleteVideoDetailsColumnInfo.videoTypeIndex, j, (long) realmIncompleteVideoDetails.realmGet$videoType(), false);
                    String realmGet$profileId = realmIncompleteVideoDetails.realmGet$profileId();
                    if (realmGet$profileId != null) {
                        Table.nativeSetString(nativePtr, realmIncompleteVideoDetailsColumnInfo.profileIdIndex, j, realmGet$profileId, false);
                    } else {
                        Table.nativeSetNull(nativePtr, realmIncompleteVideoDetailsColumnInfo.profileIdIndex, j, false);
                    }
                } else {
                    map.put(realmIncompleteVideoDetails, Long.valueOf(((RealmObjectProxy) realmIncompleteVideoDetails).realmGet$proxyState().getRow$realm().getIndex()));
                }
            }
        }
    }

    public static RealmIncompleteVideoDetails createDetachedCopy(RealmIncompleteVideoDetails realmIncompleteVideoDetails, int i, int i2, Map<RealmModel, RealmObjectProxy.CacheData<RealmModel>> map) {
        RealmIncompleteVideoDetails realmIncompleteVideoDetails2;
        if (i > i2 || realmIncompleteVideoDetails == null) {
            return null;
        }
        RealmObjectProxy.CacheData<RealmModel> cacheData = map.get(realmIncompleteVideoDetails);
        if (cacheData == null) {
            realmIncompleteVideoDetails2 = new RealmIncompleteVideoDetails();
            map.put(realmIncompleteVideoDetails, new RealmObjectProxy.CacheData<>(i, realmIncompleteVideoDetails2));
        } else if (i >= cacheData.minDepth) {
            return (RealmIncompleteVideoDetails) cacheData.object;
        } else {
            realmIncompleteVideoDetails2 = (RealmIncompleteVideoDetails) cacheData.object;
            cacheData.minDepth = i;
        }
        RealmIncompleteVideoDetails realmIncompleteVideoDetails3 = realmIncompleteVideoDetails2;
        RealmIncompleteVideoDetails realmIncompleteVideoDetails4 = realmIncompleteVideoDetails;
        realmIncompleteVideoDetails3.realmSet$playableId(realmIncompleteVideoDetails4.realmGet$playableId());
        realmIncompleteVideoDetails3.realmSet$videoType(realmIncompleteVideoDetails4.realmGet$videoType());
        realmIncompleteVideoDetails3.realmSet$profileId(realmIncompleteVideoDetails4.realmGet$profileId());
        return realmIncompleteVideoDetails2;
    }

    static RealmIncompleteVideoDetails update(Realm realm, RealmIncompleteVideoDetails realmIncompleteVideoDetails, RealmIncompleteVideoDetails realmIncompleteVideoDetails2, Map<RealmModel, RealmObjectProxy> map) {
        RealmIncompleteVideoDetails realmIncompleteVideoDetails3 = realmIncompleteVideoDetails;
        RealmIncompleteVideoDetails realmIncompleteVideoDetails4 = realmIncompleteVideoDetails2;
        realmIncompleteVideoDetails3.realmSet$videoType(realmIncompleteVideoDetails4.realmGet$videoType());
        realmIncompleteVideoDetails3.realmSet$profileId(realmIncompleteVideoDetails4.realmGet$profileId());
        return realmIncompleteVideoDetails;
    }

    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder sb = new StringBuilder("RealmIncompleteVideoDetails = proxy[");
        sb.append("{playableId:");
        sb.append(realmGet$playableId() != null ? realmGet$playableId() : "null");
        sb.append("}");
        sb.append(",");
        sb.append("{videoType:");
        sb.append(realmGet$videoType());
        sb.append("}");
        sb.append(",");
        sb.append("{profileId:");
        sb.append(realmGet$profileId() != null ? realmGet$profileId() : "null");
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
        RealmIncompleteVideoDetailsRealmProxy realmIncompleteVideoDetailsRealmProxy = (RealmIncompleteVideoDetailsRealmProxy) obj;
        String path = this.proxyState.getRealm$realm().getPath();
        String path2 = realmIncompleteVideoDetailsRealmProxy.proxyState.getRealm$realm().getPath();
        if (path != null) {
            if (!path.equals(path2)) {
                return false;
            }
        } else if (path2 != null) {
            return false;
        }
        String name = this.proxyState.getRow$realm().getTable().getName();
        String name2 = realmIncompleteVideoDetailsRealmProxy.proxyState.getRow$realm().getTable().getName();
        if (name != null) {
            if (!name.equals(name2)) {
                return false;
            }
        } else if (name2 != null) {
            return false;
        }
        if (this.proxyState.getRow$realm().getIndex() != realmIncompleteVideoDetailsRealmProxy.proxyState.getRow$realm().getIndex()) {
            return false;
        }
        return true;
    }
}
