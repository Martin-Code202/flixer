package com.netflix.mediaclient.ui.lolomo.ab9031;

import com.netflix.mediaclient.servicemgr.interface_.genre.GenreList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Lambda;
import o.AbstractC1450Fk;
import o.C0975;
import o.C1457Fr;
import o.C2221uu;
import o.EA;
public final class GenresActionBarPresenter$update$2 extends Lambda implements AbstractC1450Fk<List<? extends GenreList>, EA> {

    /* renamed from: ॱ  reason: contains not printable characters */
    final /* synthetic */ C2221uu f3244;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GenresActionBarPresenter$update$2(C2221uu uuVar) {
        super(1);
        this.f3244 = uuVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // o.AbstractC1450Fk
    public /* synthetic */ EA invoke(List<? extends GenreList> list) {
        m2084(list);
        return EA.f5503;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public final void m2084(List<? extends GenreList> list) {
        C0975 r3 = this.f3244.f11037;
        if (r3 != null && (this.f3244.m11759()) && !list.isEmpty()) {
            GenreList genreList = (GenreList) list.get(0);
            Iterator<? extends GenreList> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                GenreList genreList2 = (GenreList) it.next();
                if (C1457Fr.m5018((Object) genreList2.getId(), (Object) this.f3244.f11031)) {
                    genreList = genreList2;
                    break;
                }
            }
            String title = genreList.getTitle();
            C1457Fr.m5016((Object) title, "currentGenre.title");
            String id = genreList.getId();
            C1457Fr.m5016((Object) id, "currentGenre.id");
            r3.setSubCategoryLabel(title, id);
        }
    }
}
