package o;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.netflix.mediaclient.NetflixApplication;
import com.netflix.mediaclient.android.activity.NetflixActivity;
import com.netflix.mediaclient.service.configuration.persistent.Config_Ab8274;
import com.netflix.mediaclient.ui.search.SearchUtils;
import java.util.List;
/* renamed from: o.zm  reason: case insensitive filesystem */
public class C2379zm extends ContentProvider {

    /* renamed from: ॱ  reason: contains not printable characters */
    private iF f12896;

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        this.f12896 = new iF(getContext(), 1);
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: ॱ  reason: contains not printable characters */
    public static boolean m13715() {
        return Config_Ab8274.m508(NetflixApplication.getInstance());
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        if (!m13715()) {
            return null;
        }
        String r3 = ((NetflixActivity) NetflixApplication.m217()).getServiceManager().m9835();
        if (TextUtils.isEmpty(r3)) {
            return null;
        }
        SQLiteDatabase readableDatabase = this.f12896.getReadableDatabase();
        StringBuilder append = new StringBuilder("select * from suggestions where ").append("profileId").append(" = '").append(r3).append("'");
        if (!TextUtils.isEmpty(strArr2[0])) {
            append.append(" AND ").append("suggest_text_1").append(" LIKE '%").append(strArr2[0]).append("%'");
        }
        append.append(" ORDER BY _id DESC");
        return readableDatabase.rawQuery(append.toString(), null);
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        if (!m13715()) {
            return null;
        }
        this.f12896.getReadableDatabase().insert("suggestions", null, contentValues);
        return uri;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        if (!m13715()) {
            return 0;
        }
        return this.f12896.getReadableDatabase().delete("suggestions", "falkorId = \"" + str + "\" AND profileId = '" + ((NetflixActivity) NetflixApplication.m217()).getServiceManager().m9835() + "'", null);
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new UnsupportedOperationException();
    }

    /* renamed from: o.zm$iF */
    public static class iF extends SQLiteOpenHelper {
        public iF(Context context, int i) {
            super(context, "NetflixSuggestions.db", (SQLiteDatabase.CursorFactory) null, i);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            if (C2379zm.m13715()) {
                m13716(sQLiteDatabase);
                m13717(sQLiteDatabase);
            }
        }

        /* renamed from: ˎ  reason: contains not printable characters */
        private void m13716(SQLiteDatabase sQLiteDatabase) {
            StringBuilder sb = new StringBuilder();
            sb.append("CREATE TABLE ").append("suggestions").append("( _id INTEGER PRIMARY KEY, ").append("suggest_text_1").append(" TEXT UNIQUE ON CONFLICT REPLACE, ").append("saveType").append(" TEXT, ").append("entityType").append(" TEXT, ").append("falkorId").append(" TEXT, ").append("entityId").append(" TEXT, ").append("suggestionType").append(" TEXT, ").append("profileId").append(" TEXT);");
            sQLiteDatabase.execSQL(sb.toString());
        }

        /* renamed from: ॱ  reason: contains not printable characters */
        private void m13717(SQLiteDatabase sQLiteDatabase) {
            new StringBuilder();
            sQLiteDatabase.execSQL("CREATE TRIGGER IF NOT EXISTS prune_trigger AFTER INSERT ON suggestions WHEN (SELECT COUNT(*) FROM suggestions) > 45  BEGIN delete from suggestions where _id not in(select _id from suggestions order by _id desc limit 40); END;");
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            if (C2379zm.m13715()) {
                Log.d("NetflixSearchSuggestionsContentProvider", "Upgrading database from version " + i + " to " + i2 + ", which will destroy all old data");
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS suggestions");
                onCreate(sQLiteDatabase);
            }
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    static SQLiteDatabase m13712(Context context) {
        return new iF(context, 1).getWritableDatabase();
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    static String m13713(NetflixActivity netflixActivity, List<SearchUtils.SuggestionType> list) {
        StringBuilder append = new StringBuilder("select * from ").append("suggestions").append(" where ").append("profileId").append(" = '").append(netflixActivity.getServiceManager().m9835()).append("'");
        if (list.size() > 0) {
            append.append(" AND (").append("suggestionType").append(" == '").append(list.get(0).name()).append("'");
            for (int i = 1; i < list.size(); i++) {
                append.append(" OR ").append("suggestionType").append(" == '").append(list.get(i).name()).append("'");
            }
            append.append(") ");
        }
        append.append(" ORDER BY _id DESC");
        return append.toString();
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    static String m13714(NetflixActivity netflixActivity, String str) {
        return "delete from suggestions where profileId = \"" + netflixActivity.getServiceManager().m9835() + "\" AND falkorId = \"" + str + "\"";
    }
}
