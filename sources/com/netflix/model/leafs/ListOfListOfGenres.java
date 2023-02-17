package com.netflix.model.leafs;

import com.google.gson.JsonElement;
import com.netflix.mediaclient.servicemgr.interface_.genre.GenreList;
import java.util.ArrayList;
import java.util.Iterator;
import o.AbstractC0852;
import o.AbstractC0871;
public class ListOfListOfGenres extends ArrayList<GenreList> implements AbstractC0852, AbstractC0871 {
    @Override // o.AbstractC0852
    public void populate(JsonElement jsonElement) {
        clear();
        Iterator<JsonElement> it = jsonElement.getAsJsonObject().get("value").getAsJsonArray().iterator();
        while (it.hasNext()) {
            ListOfGenreSummary listOfGenreSummary = new ListOfGenreSummary();
            listOfGenreSummary.populate(it.next());
            add(listOfGenreSummary);
        }
    }
}
