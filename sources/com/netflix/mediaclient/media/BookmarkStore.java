package com.netflix.mediaclient.media;

import android.content.Context;
import com.google.gson.annotations.SerializedName;
import com.netflix.mediaclient.android.app.BackgroundTask;
import com.netflix.mediaclient.service.webclient.model.leafs.UserProfile;
import com.netflix.model.leafs.Video;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import o.AE;
import o.AH;
import o.AbstractC2074pw;
import o.C1283;
import o.C1349Bv;
import o.C2052pa;
import o.CH;
import o.pF;
import o.pT;
public class BookmarkStore {
    private static final int MAX_BOOKMARKS_PER_PROFILE = 100;
    private static final String TAG = "nf_BookmarkStore";
    private BookmarkData mBookmarkData = new BookmarkData();
    private File mBookmarkStoreFile;
    private Context mContext;

    public BookmarkStore(Context context) {
        init(context);
    }

    private void init(final Context context) {
        this.mBookmarkStoreFile = new File(context.getFilesDir() + "/bookmarkStore.json");
        new BackgroundTask().m285(new Runnable() { // from class: com.netflix.mediaclient.media.BookmarkStore.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (BookmarkStore.class) {
                    try {
                        if (BookmarkStore.this.mBookmarkStoreFile.exists()) {
                            String r5 = C1349Bv.m4111(AH.m3345(BookmarkStore.this.mBookmarkStoreFile), "utf-8");
                            BookmarkStore.this.mBookmarkData = (BookmarkData) AE.m3322().fromJson(r5, (Class<Object>) BookmarkData.class);
                        }
                    } catch (IOException e) {
                        C1283.m16856(BookmarkStore.TAG, e, "init error", new Object[0]);
                    }
                    if (BookmarkStore.this.mBookmarkData == null || BookmarkStore.this.mBookmarkData.mBookmarkMap == null) {
                        BookmarkStore.this.mBookmarkData = new BookmarkData();
                        BookmarkStore.this.mBookmarkData.mBookmarkMap = new HashMap();
                    }
                    BookmarkStore.this.mContext = context;
                }
            }
        });
    }

    public synchronized void updateValidProfiles(List<UserProfile> list) {
        if (list != null) {
            if (!(list.size() <= 0 || this.mBookmarkData == null || this.mBookmarkData.mBookmarkMap == null)) {
                ArrayList<String> arrayList = new ArrayList();
                for (Map.Entry<String, Map<String, C2052pa>> entry : this.mBookmarkData.mBookmarkMap.entrySet()) {
                    if (!isProfileStillValid(entry.getKey(), list)) {
                        arrayList.add(entry.getKey());
                    }
                }
                for (String str : arrayList) {
                    this.mBookmarkData.mBookmarkMap.remove(str);
                }
                if (arrayList.size() > 0) {
                    persistBookmarkData();
                }
            }
        }
    }

    public synchronized void setBookmark(String str, C2052pa paVar) {
        if (this.mContext != null) {
            if (str == null || paVar == null) {
                C1283.m16850(TAG, "setBookmark not valid data");
                return;
            }
            setBookmarkNoPersist(str, paVar);
            persistBookmarkData();
        }
    }

    public synchronized C2052pa getBookmark(String str, String str2) {
        if (this.mContext == null) {
            return null;
        }
        Map<String, C2052pa> map = this.mBookmarkData.mBookmarkMap.get(str);
        if (map == null) {
            return null;
        }
        return map.get(str2);
    }

    private void persistBookmarkData() {
        new BackgroundTask().m285(new Runnable() { // from class: com.netflix.mediaclient.media.BookmarkStore.2
            @Override // java.lang.Runnable
            public void run() {
                BookmarkStore.this.saveBookmarkToFile();
            }
        });
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private synchronized void saveBookmarkToFile() {
        String json = AE.m3322().toJson(this.mBookmarkData);
        C1283.m16863(TAG, "setBookmark saving to file result=%b data=%s", Boolean.valueOf(AH.m3349(this.mBookmarkStoreFile.getAbsolutePath(), json.getBytes())), json);
    }

    private void setBookmarkNoPersist(String str, C2052pa paVar) {
        if (paVar == null || paVar.mVideoId == null) {
            C1283.m16850(TAG, "Bookmark or its video ID is null");
            return;
        }
        C1283.m16863(TAG, "setBookmark videoId=%s, bookmarkTimeInSeconds=%d", paVar.mVideoId, Integer.valueOf(paVar.mBookmarkInSecond));
        if (this.mBookmarkData.mBookmarkMap.get(str) == null) {
            this.mBookmarkData.mBookmarkMap.put(str, new HashMap());
        }
        Map<String, C2052pa> map = this.mBookmarkData.mBookmarkMap.get(str);
        trimSizeIfNeeded(map);
        map.put(paVar.mVideoId, paVar);
    }

    private void trimSizeIfNeeded(Map<String, C2052pa> map) {
        String str = null;
        long j = 2147483647L;
        if (map.size() > 100) {
            for (String str2 : map.keySet()) {
                if (map.get(str2).mBookmarkUpdateTimeInUTCMs < j) {
                    str = str2;
                    j = map.get(str2).mBookmarkUpdateTimeInUTCMs;
                }
            }
        }
        if (str != null) {
            map.remove(str);
        }
    }

    private boolean isProfileStillValid(String str, List<UserProfile> list) {
        for (UserProfile userProfile : list) {
            if (C1349Bv.m4123(userProfile.getProfileGuid(), str)) {
                return true;
            }
        }
        return false;
    }

    public synchronized void onCWVideosFetched(List<AbstractC2074pw> list, String str) {
        if (!(this.mContext == null || list == null || str == null)) {
            boolean z = false;
            for (AbstractC2074pw pwVar : list) {
                C2052pa bookmark = getBookmark(str, pwVar.getPlayableId());
                boolean z2 = false;
                if (bookmark == null) {
                    z2 = true;
                    C1283.m16862(TAG, "got a new bookmark");
                } else {
                    long seconds = TimeUnit.MILLISECONDS.toSeconds(bookmark.mBookmarkUpdateTimeInUTCMs - pwVar.getPlayableBookmarkUpdateTime());
                    C1283.m16862(TAG, "bookMarkStoreTimeIsNewBySeconds=" + seconds);
                    if (seconds < 0) {
                        z2 = true;
                    }
                }
                if (z2) {
                    setBookmarkNoPersist(str, new C2052pa(pwVar.getPlayableBookmarkPosition(), pwVar.getPlayableBookmarkUpdateTime(), pwVar.getPlayableId()));
                    z = true;
                }
            }
            if (z) {
                persistBookmarkData();
            }
        }
    }

    public void createOrUpdateBookmark(pT pTVar, String str) {
        pF playable;
        if (pTVar != null && (playable = pTVar.getPlayable()) != null) {
            CH ch = null;
            if (playable instanceof CH) {
                ch = (CH) playable;
            }
            int bookmarkPosition = ch != null ? ch.getBookmark().getBookmarkPosition() : playable.getPlayableBookmarkPosition();
            long playableBookmarkUpdateTime = playable.getPlayableBookmarkUpdateTime();
            boolean z = false;
            C2052pa bookmark = getBookmark(str, playable.getPlayableId());
            if (bookmark == null) {
                C1283.m16862(TAG, "createOrUpdateBookmark bookmarkStore has no bookmark");
                z = true;
            } else if (bookmark.mBookmarkUpdateTimeInUTCMs < playableBookmarkUpdateTime) {
                C1283.m16862(TAG, "createOrUpdateBookmark bookmarkStore is older");
                z = true;
            } else {
                C1283.m16862(TAG, "createOrUpdateBookmark bookmarkStore is newer");
            }
            if (z) {
                C1283.m16863(TAG, "createOrUpdateBookmark calling BookmarkStore.setBookmark time=%d", Integer.valueOf(bookmarkPosition));
                setBookmark(str, new C2052pa(bookmarkPosition, playableBookmarkUpdateTime, playable.getPlayableId()));
            }
        }
    }

    public void updateBookmarkIfExists(String str, Video.Bookmark bookmark, String str2) {
        if (str != null && bookmark != null) {
            int bookmarkPosition = bookmark.getBookmarkPosition();
            long lastModified = bookmark.getLastModified();
            C2052pa bookmark2 = getBookmark(str2, str);
            if (bookmark2 != null) {
                C1283.m16863(TAG, "updateBookmarkIfExists playableId=%s falkorBookmarkPosition=%d falkorBookmarkUpdateTime=%d", str, Integer.valueOf(bookmarkPosition), Long.valueOf(lastModified));
                if (bookmark2.mBookmarkUpdateTimeInUTCMs < lastModified) {
                    C1283.m16862(TAG, "updateBookmarkIfExists updating");
                    setBookmark(str2, new C2052pa(bookmarkPosition, lastModified, str));
                    return;
                }
                C1283.m16863(TAG, "updateBookmarkIfExists storeTime=%d falkorBookmarkUpdateTime=%d", Long.valueOf(bookmark2.mBookmarkUpdateTimeInUTCMs), Long.valueOf(lastModified));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public class BookmarkData {
        @SerializedName("bookmarks")
        public Map<String, Map<String, C2052pa>> mBookmarkMap;

        private BookmarkData() {
            this.mBookmarkMap = new HashMap();
        }
    }
}
