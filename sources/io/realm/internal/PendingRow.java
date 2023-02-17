package io.realm.internal;

import io.realm.RealmChangeListener;
import io.realm.RealmFieldType;
import java.lang.ref.WeakReference;
import java.util.Date;
public class PendingRow implements Row {
    private WeakReference<FrontEnd> frontEndRef;
    private RealmChangeListener<PendingRow> listener;
    private Collection pendingCollection;
    private boolean returnCheckedRow;
    private SharedRealm sharedRealm;

    public interface FrontEnd {
        void onQueryFinished(Row row);
    }

    @Override // io.realm.internal.Row
    public long getColumnCount() {
        throw new IllegalStateException("The pending query has not been executed.");
    }

    @Override // io.realm.internal.Row
    public String getColumnName(long j) {
        throw new IllegalStateException("The pending query has not been executed.");
    }

    @Override // io.realm.internal.Row
    public long getColumnIndex(String str) {
        throw new IllegalStateException("The pending query has not been executed.");
    }

    @Override // io.realm.internal.Row
    public RealmFieldType getColumnType(long j) {
        throw new IllegalStateException("The pending query has not been executed.");
    }

    @Override // io.realm.internal.Row
    public Table getTable() {
        throw new IllegalStateException("The pending query has not been executed.");
    }

    @Override // io.realm.internal.Row
    public long getIndex() {
        throw new IllegalStateException("The pending query has not been executed.");
    }

    @Override // io.realm.internal.Row
    public long getLong(long j) {
        throw new IllegalStateException("The pending query has not been executed.");
    }

    @Override // io.realm.internal.Row
    public boolean getBoolean(long j) {
        throw new IllegalStateException("The pending query has not been executed.");
    }

    @Override // io.realm.internal.Row
    public float getFloat(long j) {
        throw new IllegalStateException("The pending query has not been executed.");
    }

    @Override // io.realm.internal.Row
    public double getDouble(long j) {
        throw new IllegalStateException("The pending query has not been executed.");
    }

    @Override // io.realm.internal.Row
    public Date getDate(long j) {
        throw new IllegalStateException("The pending query has not been executed.");
    }

    @Override // io.realm.internal.Row
    public String getString(long j) {
        throw new IllegalStateException("The pending query has not been executed.");
    }

    @Override // io.realm.internal.Row
    public byte[] getBinaryByteArray(long j) {
        throw new IllegalStateException("The pending query has not been executed.");
    }

    @Override // io.realm.internal.Row
    public long getLink(long j) {
        throw new IllegalStateException("The pending query has not been executed.");
    }

    @Override // io.realm.internal.Row
    public boolean isNullLink(long j) {
        throw new IllegalStateException("The pending query has not been executed.");
    }

    @Override // io.realm.internal.Row
    public OsList getModelList(long j) {
        throw new IllegalStateException("The pending query has not been executed.");
    }

    @Override // io.realm.internal.Row
    public OsList getValueList(long j, RealmFieldType realmFieldType) {
        throw new IllegalStateException("The pending query has not been executed.");
    }

    @Override // io.realm.internal.Row
    public void setLong(long j, long j2) {
        throw new IllegalStateException("The pending query has not been executed.");
    }

    @Override // io.realm.internal.Row
    public void setBoolean(long j, boolean z) {
        throw new IllegalStateException("The pending query has not been executed.");
    }

    @Override // io.realm.internal.Row
    public void setFloat(long j, float f) {
        throw new IllegalStateException("The pending query has not been executed.");
    }

    @Override // io.realm.internal.Row
    public void setDouble(long j, double d) {
        throw new IllegalStateException("The pending query has not been executed.");
    }

    @Override // io.realm.internal.Row
    public void setDate(long j, Date date) {
        throw new IllegalStateException("The pending query has not been executed.");
    }

    @Override // io.realm.internal.Row
    public void setString(long j, String str) {
        throw new IllegalStateException("The pending query has not been executed.");
    }

    @Override // io.realm.internal.Row
    public void setBinaryByteArray(long j, byte[] bArr) {
        throw new IllegalStateException("The pending query has not been executed.");
    }

    @Override // io.realm.internal.Row
    public void setLink(long j, long j2) {
        throw new IllegalStateException("The pending query has not been executed.");
    }

    @Override // io.realm.internal.Row
    public void nullifyLink(long j) {
        throw new IllegalStateException("The pending query has not been executed.");
    }

    @Override // io.realm.internal.Row
    public boolean isNull(long j) {
        throw new IllegalStateException("The pending query has not been executed.");
    }

    @Override // io.realm.internal.Row
    public void setNull(long j) {
        throw new IllegalStateException("The pending query has not been executed.");
    }

    @Override // io.realm.internal.Row
    public boolean isAttached() {
        return false;
    }

    @Override // io.realm.internal.Row
    public void checkIfAttached() {
        throw new IllegalStateException("The pending query has not been executed.");
    }

    @Override // io.realm.internal.Row
    public boolean hasColumn(String str) {
        throw new IllegalStateException("The pending query has not been executed.");
    }

    private void clearPendingCollection() {
        this.pendingCollection.removeListener((Collection) this, (RealmChangeListener<Collection>) this.listener);
        this.pendingCollection = null;
        this.listener = null;
        this.sharedRealm.removePendingRow(this);
    }

    private void notifyFrontEnd() {
        if (this.frontEndRef == null) {
            throw new IllegalStateException("The 'frontEnd' has not been set.");
        }
        FrontEnd frontEnd = this.frontEndRef.get();
        if (frontEnd == null) {
            clearPendingCollection();
        } else if (this.pendingCollection.isValid()) {
            UncheckedRow firstUncheckedRow = this.pendingCollection.firstUncheckedRow();
            clearPendingCollection();
            if (firstUncheckedRow != null) {
                frontEnd.onQueryFinished(this.returnCheckedRow ? CheckedRow.getFromRow(firstUncheckedRow) : firstUncheckedRow);
            } else {
                frontEnd.onQueryFinished(InvalidRow.INSTANCE);
            }
        } else {
            clearPendingCollection();
        }
    }

    public void executeQuery() {
        if (this.pendingCollection == null) {
            throw new IllegalStateException("The query has been executed. This 'PendingRow' is not valid anymore.");
        }
        notifyFrontEnd();
    }
}
