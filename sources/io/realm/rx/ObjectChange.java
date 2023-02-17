package io.realm.rx;

import io.realm.ObjectChangeSet;
import io.realm.RealmModel;
public class ObjectChange<E extends RealmModel> {
    private final ObjectChangeSet changeset;
    private final E object;

    public ObjectChange(E e, ObjectChangeSet objectChangeSet) {
        this.object = e;
        this.changeset = objectChangeSet;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ObjectChange objectChange = (ObjectChange) obj;
        if (!this.object.equals(objectChange.object)) {
            return false;
        }
        if (this.changeset != null) {
            return this.changeset.equals(objectChange.changeset);
        }
        return objectChange.changeset == null;
    }

    public int hashCode() {
        return (this.object.hashCode() * 31) + (this.changeset != null ? this.changeset.hashCode() : 0);
    }

    public String toString() {
        return "ObjectChange{object=" + this.object + ", changeset=" + this.changeset + '}';
    }
}
