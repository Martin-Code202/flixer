package com.ibm.icu.impl;

import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;
import java.util.Map;
public class ICUService extends ICUNotifier {
    private static final boolean DEBUG = ICUDebug.enabled("service");
    private Map<String, CacheEntry> cache;
    private int defaultSize;
    private LocaleRef dnref;
    private final List<Factory> factories;
    private final ICURWLock factoryLock;
    private Map<String, Factory> idcache;
    protected final String name;

    public interface Factory {
        Object create(Key key, ICUService iCUService);
    }

    /* access modifiers changed from: package-private */
    public static class LocaleRef {
    }

    public interface ServiceListener extends EventListener {
        void serviceChanged(ICUService iCUService);
    }

    public ICUService() {
        this.factoryLock = new ICURWLock();
        this.factories = new ArrayList();
        this.defaultSize = 0;
        this.name = "";
    }

    public ICUService(String str) {
        this.factoryLock = new ICURWLock();
        this.factories = new ArrayList();
        this.defaultSize = 0;
        this.name = str;
    }

    public static class Key {
        private final String id;

        public Key(String str) {
            this.id = str;
        }

        public String canonicalID() {
            return this.id;
        }

        public String currentID() {
            return canonicalID();
        }

        public String currentDescriptor() {
            return "/" + currentID();
        }

        public boolean fallback() {
            return false;
        }
    }

    public Object getKey(Key key) {
        return getKey(key, null);
    }

    public Object getKey(Key key, String[] strArr) {
        return getKey(key, strArr, null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:54:0x01e9, code lost:
        if (r6 != null) goto L_0x01f1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x01eb, code lost:
        r6 = new java.util.ArrayList(5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x01f1, code lost:
        r6.add(r5);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object getKey(com.ibm.icu.impl.ICUService.Key r17, java.lang.String[] r18, com.ibm.icu.impl.ICUService.Factory r19) {
        /*
        // Method dump skipped, instructions count: 762
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ibm.icu.impl.ICUService.getKey(com.ibm.icu.impl.ICUService$Key, java.lang.String[], com.ibm.icu.impl.ICUService$Factory):java.lang.Object");
    }

    /* access modifiers changed from: package-private */
    public static final class CacheEntry {
        final String actualDescriptor;
        final Object service;

        CacheEntry(String str, Object obj) {
            this.actualDescriptor = str;
            this.service = obj;
        }
    }

    public Object handleDefault(Key key, String[] strArr) {
        return null;
    }

    public final Factory registerFactory(Factory factory) {
        if (factory == null) {
            throw new NullPointerException();
        }
        try {
            this.factoryLock.acquireWrite();
            this.factories.add(0, factory);
            clearCaches();
            notifyChanged();
            return factory;
        } finally {
            this.factoryLock.releaseWrite();
        }
    }

    public boolean isDefault() {
        return this.factories.size() == this.defaultSize;
    }

    /* access modifiers changed from: protected */
    public void markDefault() {
        this.defaultSize = this.factories.size();
    }

    /* access modifiers changed from: protected */
    public void clearCaches() {
        this.cache = null;
        this.idcache = null;
        this.dnref = null;
    }

    /* access modifiers changed from: protected */
    public void clearServiceCache() {
        this.cache = null;
    }

    /* access modifiers changed from: protected */
    @Override // com.ibm.icu.impl.ICUNotifier
    public void notifyListener(EventListener eventListener) {
        ((ServiceListener) eventListener).serviceChanged(this);
    }

    public String toString() {
        return super.toString() + "{" + this.name + "}";
    }
}
