package android.support.v4.widget;

import android.database.Cursor;
import android.widget.Filter;
class CursorFilter extends Filter {
    CursorFilterClient mClient;

    interface CursorFilterClient {
        void changeCursor(Cursor cursor);

        CharSequence convertToString(Cursor cursor);

        Cursor getCursor();

        Cursor runQueryOnBackgroundThread(CharSequence charSequence);
    }

    CursorFilter(CursorFilterClient cursorFilterClient) {
        this.mClient = cursorFilterClient;
    }

    @Override // android.widget.Filter
    public CharSequence convertResultToString(Object obj) {
        return this.mClient.convertToString((Cursor) obj);
    }

    /* access modifiers changed from: protected */
    @Override // android.widget.Filter
    public Filter.FilterResults performFiltering(CharSequence charSequence) {
        Cursor runQueryOnBackgroundThread = this.mClient.runQueryOnBackgroundThread(charSequence);
        Filter.FilterResults filterResults = new Filter.FilterResults();
        if (runQueryOnBackgroundThread != null) {
            filterResults.count = runQueryOnBackgroundThread.getCount();
            filterResults.values = runQueryOnBackgroundThread;
        } else {
            filterResults.count = 0;
            filterResults.values = null;
        }
        return filterResults;
    }

    /* access modifiers changed from: protected */
    @Override // android.widget.Filter
    public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
        Cursor cursor = this.mClient.getCursor();
        if (filterResults.values != null && filterResults.values != cursor) {
            this.mClient.changeCursor((Cursor) filterResults.values);
        }
    }
}
