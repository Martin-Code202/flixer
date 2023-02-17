package com.google.android.exoplayer2.upstream.cache;

import android.util.SparseArray;
import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.AtomicFile;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ReusableBufferedOutputStream;
import com.google.android.exoplayer2.util.Util;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import java.util.Set;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* access modifiers changed from: package-private */
public class CachedContentIndex {
    private final AtomicFile atomicFile;
    private ReusableBufferedOutputStream bufferedOutputStream;
    private boolean changed;
    private final Cipher cipher;
    private final boolean encrypt;
    private final SparseArray<String> idToKey;
    private final HashMap<String, CachedContent> keyToContent;
    private final SecretKeySpec secretKeySpec;

    public CachedContentIndex(File file, byte[] bArr, boolean z) {
        this.encrypt = z;
        if (bArr != null) {
            Assertions.checkArgument(bArr.length == 16);
            try {
                this.cipher = getCipher();
                this.secretKeySpec = new SecretKeySpec(bArr, "AES");
            } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
                throw new IllegalStateException(e);
            }
        } else {
            this.cipher = null;
            this.secretKeySpec = null;
        }
        this.keyToContent = new HashMap<>();
        this.idToKey = new SparseArray<>();
        this.atomicFile = new AtomicFile(new File(file, "cached_content_index.exi"));
    }

    public void load() {
        Assertions.checkState(!this.changed);
        if (!readFile()) {
            this.atomicFile.delete();
            this.keyToContent.clear();
            this.idToKey.clear();
        }
    }

    public void store() {
        if (this.changed) {
            writeFile();
            this.changed = false;
        }
    }

    public CachedContent add(String str) {
        CachedContent cachedContent = this.keyToContent.get(str);
        if (cachedContent == null) {
            return addNew(str, -1);
        }
        return cachedContent;
    }

    public CachedContent get(String str) {
        return this.keyToContent.get(str);
    }

    public Collection<CachedContent> getAll() {
        return this.keyToContent.values();
    }

    public int assignIdForKey(String str) {
        return add(str).id;
    }

    public String getKeyForId(int i) {
        return this.idToKey.get(i);
    }

    public void removeEmpty(String str) {
        CachedContent remove = this.keyToContent.remove(str);
        if (remove != null) {
            Assertions.checkState(remove.isEmpty());
            this.idToKey.remove(remove.id);
            this.changed = true;
        }
    }

    public void removeEmpty() {
        LinkedList linkedList = new LinkedList();
        for (CachedContent cachedContent : this.keyToContent.values()) {
            if (cachedContent.isEmpty()) {
                linkedList.add(cachedContent.key);
            }
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            removeEmpty((String) it.next());
        }
    }

    public Set<String> getKeys() {
        return this.keyToContent.keySet();
    }

    public void setContentLength(String str, long j) {
        CachedContent cachedContent = get(str);
        if (cachedContent == null) {
            addNew(str, j);
        } else if (cachedContent.getLength() != j) {
            cachedContent.setLength(j);
            this.changed = true;
        }
    }

    public long getContentLength(String str) {
        CachedContent cachedContent = get(str);
        if (cachedContent == null) {
            return -1;
        }
        return cachedContent.getLength();
    }

    private boolean readFile() {
        DataInputStream dataInputStream = null;
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(this.atomicFile.openRead());
            dataInputStream = new DataInputStream(bufferedInputStream);
            if (dataInputStream.readInt() != 1) {
                if (dataInputStream != null) {
                    Util.closeQuietly(dataInputStream);
                }
                return false;
            }
            if ((dataInputStream.readInt() & 1) != 0) {
                if (this.cipher == null) {
                    if (dataInputStream != null) {
                        Util.closeQuietly(dataInputStream);
                    }
                    return false;
                }
                byte[] bArr = new byte[16];
                dataInputStream.readFully(bArr);
                try {
                    this.cipher.init(2, this.secretKeySpec, new IvParameterSpec(bArr));
                    dataInputStream = new DataInputStream(new CipherInputStream(bufferedInputStream, this.cipher));
                } catch (InvalidAlgorithmParameterException | InvalidKeyException e) {
                    throw new IllegalStateException(e);
                }
            } else if (this.cipher != null) {
                this.changed = true;
            }
            int readInt = dataInputStream.readInt();
            int i = 0;
            for (int i2 = 0; i2 < readInt; i2++) {
                CachedContent cachedContent = new CachedContent(dataInputStream);
                add(cachedContent);
                i += cachedContent.headerHashCode();
            }
            if (dataInputStream.readInt() != i) {
                if (dataInputStream != null) {
                    Util.closeQuietly(dataInputStream);
                }
                return false;
            } else if (dataInputStream == null) {
                return true;
            } else {
                Util.closeQuietly(dataInputStream);
                return true;
            }
        } catch (FileNotFoundException e2) {
            if (dataInputStream != null) {
                Util.closeQuietly(dataInputStream);
            }
            return false;
        } catch (IOException e3) {
            Log.e("CachedContentIndex", "Error reading cache content index file.", e3);
            if (dataInputStream != null) {
                Util.closeQuietly(dataInputStream);
            }
            return false;
        } catch (Throwable th) {
            if (dataInputStream != null) {
                Util.closeQuietly(dataInputStream);
            }
            throw th;
        }
    }

    private void writeFile() {
        try {
            OutputStream startWrite = this.atomicFile.startWrite();
            if (this.bufferedOutputStream == null) {
                this.bufferedOutputStream = new ReusableBufferedOutputStream(startWrite);
            } else {
                this.bufferedOutputStream.reset(startWrite);
            }
            DataOutputStream dataOutputStream = new DataOutputStream(this.bufferedOutputStream);
            dataOutputStream.writeInt(1);
            boolean z = this.encrypt && this.cipher != null;
            dataOutputStream.writeInt(z ? 1 : 0);
            if (z) {
                byte[] bArr = new byte[16];
                new Random().nextBytes(bArr);
                dataOutputStream.write(bArr);
                try {
                    this.cipher.init(1, this.secretKeySpec, new IvParameterSpec(bArr));
                    dataOutputStream.flush();
                    dataOutputStream = new DataOutputStream(new CipherOutputStream(this.bufferedOutputStream, this.cipher));
                } catch (InvalidAlgorithmParameterException | InvalidKeyException e) {
                    throw new IllegalStateException(e);
                }
            }
            dataOutputStream.writeInt(this.keyToContent.size());
            int i = 0;
            for (CachedContent cachedContent : this.keyToContent.values()) {
                cachedContent.writeToStream(dataOutputStream);
                i += cachedContent.headerHashCode();
            }
            dataOutputStream.writeInt(i);
            this.atomicFile.endWrite(dataOutputStream);
            Util.closeQuietly((Closeable) null);
        } catch (IOException e2) {
            throw new Cache.CacheException(e2);
        } catch (Throwable th) {
            Util.closeQuietly((Closeable) null);
            throw th;
        }
    }

    private void add(CachedContent cachedContent) {
        this.keyToContent.put(cachedContent.key, cachedContent);
        this.idToKey.put(cachedContent.id, cachedContent.key);
    }

    /* access modifiers changed from: package-private */
    public void addNew(CachedContent cachedContent) {
        add(cachedContent);
        this.changed = true;
    }

    private CachedContent addNew(String str, long j) {
        CachedContent cachedContent = new CachedContent(getNewId(this.idToKey), str, j);
        addNew(cachedContent);
        return cachedContent;
    }

    private static Cipher getCipher() {
        if (Util.SDK_INT == 18) {
            try {
                return Cipher.getInstance("AES/CBC/PKCS5PADDING", "BC");
            } catch (Throwable th) {
            }
        }
        return Cipher.getInstance("AES/CBC/PKCS5PADDING");
    }

    public static int getNewId(SparseArray<String> sparseArray) {
        int size = sparseArray.size();
        int keyAt = size == 0 ? 0 : sparseArray.keyAt(size - 1) + 1;
        if (keyAt < 0) {
            keyAt = 0;
            while (keyAt < size && keyAt == sparseArray.keyAt(keyAt)) {
                keyAt++;
            }
        }
        return keyAt;
    }
}
