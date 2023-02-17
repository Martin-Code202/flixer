package io.realm;

import io.realm.internal.Collection;
import io.realm.internal.OsList;
import io.realm.internal.SortDescriptor;
import io.realm.internal.Table;
import io.realm.internal.TableQuery;
import io.realm.internal.fields.FieldDescriptor;
import java.util.Date;
public class RealmQuery<E> {
    private String className;
    private Class<E> clazz;
    private final boolean forValues;
    private final OsList osList;
    private final TableQuery query;
    private final BaseRealm realm;
    private final RealmObjectSchema schema;
    private final Table table;

    static <E extends RealmModel> RealmQuery<E> createQuery(Realm realm2, Class<E> cls) {
        return new RealmQuery<>(realm2, cls);
    }

    private static boolean isClassForRealmModel(Class<?> cls) {
        return RealmModel.class.isAssignableFrom(cls);
    }

    private RealmQuery(Realm realm2, Class<E> cls) {
        this.realm = realm2;
        this.clazz = cls;
        this.forValues = !isClassForRealmModel(cls);
        if (this.forValues) {
            this.schema = null;
            this.table = null;
            this.osList = null;
            this.query = null;
            return;
        }
        this.schema = realm2.getSchema().getSchemaForClass(cls);
        this.table = this.schema.getTable();
        this.osList = null;
        this.query = this.table.where();
    }

    public RealmQuery<E> equalTo(String str, String str2) {
        return equalTo(str, str2, Case.SENSITIVE);
    }

    public RealmQuery<E> equalTo(String str, String str2, Case r4) {
        this.realm.checkIfValid();
        return equalToWithoutThreadValidation(str, str2, r4);
    }

    private RealmQuery<E> equalToWithoutThreadValidation(String str, String str2, Case r8) {
        FieldDescriptor columnIndices = this.schema.getColumnIndices(str, RealmFieldType.STRING);
        this.query.equalTo(columnIndices.getColumnIndices(), columnIndices.getNativeTablePointers(), str2, r8);
        return this;
    }

    public RealmQuery<E> equalTo(String str, Integer num) {
        this.realm.checkIfValid();
        return equalToWithoutThreadValidation(str, num);
    }

    private RealmQuery<E> equalToWithoutThreadValidation(String str, Integer num) {
        FieldDescriptor columnIndices = this.schema.getColumnIndices(str, RealmFieldType.INTEGER);
        if (num == null) {
            this.query.isNull(columnIndices.getColumnIndices(), columnIndices.getNativeTablePointers());
        } else {
            this.query.equalTo(columnIndices.getColumnIndices(), columnIndices.getNativeTablePointers(), (long) num.intValue());
        }
        return this;
    }

    public RealmQuery<E> notEqualTo(String str, Integer num) {
        this.realm.checkIfValid();
        FieldDescriptor columnIndices = this.schema.getColumnIndices(str, RealmFieldType.INTEGER);
        if (num == null) {
            this.query.isNotNull(columnIndices.getColumnIndices(), columnIndices.getNativeTablePointers());
        } else {
            this.query.notEqualTo(columnIndices.getColumnIndices(), columnIndices.getNativeTablePointers(), (long) num.intValue());
        }
        return this;
    }

    public RealmQuery<E> greaterThan(String str, Date date) {
        this.realm.checkIfValid();
        FieldDescriptor columnIndices = this.schema.getColumnIndices(str, RealmFieldType.DATE);
        this.query.greaterThan(columnIndices.getColumnIndices(), columnIndices.getNativeTablePointers(), date);
        return this;
    }

    public RealmQuery<E> lessThan(String str, Date date) {
        this.realm.checkIfValid();
        FieldDescriptor columnIndices = this.schema.getColumnIndices(str, RealmFieldType.DATE);
        this.query.lessThan(columnIndices.getColumnIndices(), columnIndices.getNativeTablePointers(), date);
        return this;
    }

    public RealmQuery<E> beginsWith(String str, String str2) {
        return beginsWith(str, str2, Case.SENSITIVE);
    }

    public RealmQuery<E> beginsWith(String str, String str2, Case r8) {
        this.realm.checkIfValid();
        FieldDescriptor columnIndices = this.schema.getColumnIndices(str, RealmFieldType.STRING);
        this.query.beginsWith(columnIndices.getColumnIndices(), columnIndices.getNativeTablePointers(), str2, r8);
        return this;
    }

    public long count() {
        this.realm.checkIfValid();
        return this.query.count();
    }

    public RealmResults<E> findAll() {
        this.realm.checkIfValid();
        return createRealmResults(this.query, null, null, true);
    }

    public RealmResults<E> findAllSorted(String[] strArr, Sort[] sortArr) {
        this.realm.checkIfValid();
        return createRealmResults(this.query, SortDescriptor.getInstanceForSort(getSchemaConnector(), this.query.getTable(), strArr, sortArr), null, true);
    }

    private boolean isDynamicQuery() {
        return this.className != null;
    }

    public RealmResults<E> findAllSorted(String str, Sort sort, String str2, Sort sort2) {
        return findAllSorted(new String[]{str, str2}, new Sort[]{sort, sort2});
    }

    public E findFirst() {
        this.realm.checkIfValid();
        if (this.forValues) {
            return null;
        }
        long sourceRowIndexForFirstObject = getSourceRowIndexForFirstObject();
        if (sourceRowIndexForFirstObject < 0) {
            return null;
        }
        return (E) this.realm.get(this.clazz, this.className, sourceRowIndexForFirstObject);
    }

    private RealmResults<E> createRealmResults(TableQuery tableQuery, SortDescriptor sortDescriptor, SortDescriptor sortDescriptor2, boolean z) {
        RealmResults<E> realmResults;
        Collection collection = new Collection(this.realm.sharedRealm, tableQuery, sortDescriptor, sortDescriptor2);
        if (isDynamicQuery()) {
            realmResults = new RealmResults<>(this.realm, collection, this.className);
        } else {
            realmResults = new RealmResults<>(this.realm, collection, this.clazz);
        }
        if (z) {
            realmResults.load();
        }
        return realmResults;
    }

    private long getSourceRowIndexForFirstObject() {
        return this.query.find();
    }

    private SchemaConnector getSchemaConnector() {
        return new SchemaConnector(this.realm.getSchema());
    }
}
