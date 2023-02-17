package com.crittercism.internal;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executor;
public final class d {
    final av<at> a;
    final av<b> b;
    final ap c;
    private final List<String> d;
    private final List<String> e;
    private final Executor f;

    public static class a {
        public Executor a;
        public List<String> b = new LinkedList();
        public List<String> c = new LinkedList();
        public av<b> d = new bd();
        public av<at> e = new bd();
        public ap f;
    }

    public /* synthetic */ d(Executor executor, List list, List list2, av avVar, av avVar2, ap apVar, byte b2) {
        this(executor, list, list2, avVar, avVar2, apVar);
    }

    private d(Executor executor, List<String> list, List<String> list2, av<b> avVar, av<at> avVar2, ap apVar) {
        this.f = executor;
        this.b = avVar;
        this.a = avVar2;
        this.d = new LinkedList(list);
        this.d.remove((Object) null);
        this.e = new LinkedList(list2);
        this.e.remove((Object) null);
        this.c = apVar;
    }
}
