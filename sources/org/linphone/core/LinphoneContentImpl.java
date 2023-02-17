package org.linphone.core;
public class LinphoneContentImpl implements LinphoneContent {
    private byte[] mData;
    private String mEncoding;
    private int mExpectedSize;
    private String mName;
    private String mSubtype;
    private String mType;

    public LinphoneContentImpl(String str, String str2, byte[] bArr, String str3) {
        this.mType = str;
        this.mSubtype = str2;
        this.mData = bArr;
        this.mEncoding = str3;
        this.mName = null;
        this.mExpectedSize = 0;
    }

    public LinphoneContentImpl(String str, String str2, String str3, byte[] bArr, String str4, int i) {
        this.mType = str2;
        this.mSubtype = str3;
        this.mData = bArr;
        this.mEncoding = str4;
        this.mName = str;
        this.mExpectedSize = i;
    }

    @Override // org.linphone.core.LinphoneContent
    public String getType() {
        return this.mType;
    }

    @Override // org.linphone.core.LinphoneContent
    public String getSubtype() {
        return this.mSubtype;
    }

    @Override // org.linphone.core.LinphoneContent
    public String getDataAsString() {
        if (this.mData != null) {
            return new String(this.mData);
        }
        return null;
    }

    @Override // org.linphone.core.LinphoneContent
    public void setExpectedSize(int i) {
        this.mExpectedSize = i;
    }

    @Override // org.linphone.core.LinphoneContent
    public int getExpectedSize() {
        return this.mExpectedSize;
    }

    @Override // org.linphone.core.LinphoneContent
    public int getRealSize() {
        if (this.mData != null) {
            return this.mData.length;
        }
        return 0;
    }

    @Override // org.linphone.core.LinphoneContent
    public void setType(String str) {
        this.mType = str;
    }

    @Override // org.linphone.core.LinphoneContent
    public void setSubtype(String str) {
        this.mSubtype = str;
    }

    @Override // org.linphone.core.LinphoneContent
    public void setStringData(String str) {
        if (str != null) {
            this.mData = str.getBytes();
        } else {
            this.mData = null;
        }
    }

    @Override // org.linphone.core.LinphoneContent
    public void setData(byte[] bArr) {
        this.mData = bArr;
    }

    @Override // org.linphone.core.LinphoneContent
    public String getEncoding() {
        return this.mEncoding;
    }

    @Override // org.linphone.core.LinphoneContent
    public byte[] getData() {
        return this.mData;
    }

    @Override // org.linphone.core.LinphoneContent
    public void setEncoding(String str) {
        this.mEncoding = str;
    }

    @Override // org.linphone.core.LinphoneContent
    public void setName(String str) {
        this.mName = str;
    }

    @Override // org.linphone.core.LinphoneContent
    public String getName() {
        return this.mName;
    }
}
