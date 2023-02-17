package o;

import com.netflix.mediaclient.service.mdx.logging.MdxLogblob;
import com.netflix.mediaclient.service.mdx.logging.MdxTargetType;
import com.netflix.mediaclient.service.mdx.logging.connection.MdxConnectionLogblobLogger;
import com.netflix.mediaclient.service.mdx.protocol.target.TargetSessionMessageType;
import com.netflix.mediaclient.servicemgr.Logblob;
/* renamed from: o.fa  reason: case insensitive filesystem */
public class C1767fa {

    /* renamed from: ˋ  reason: contains not printable characters */
    private final MdxConnectionLogblobLogger f6737;

    /* renamed from: ˎ  reason: contains not printable characters */
    private final oQ f6738;

    /* renamed from: ॱ  reason: contains not printable characters */
    private final AbstractC1221 f6739;

    public C1767fa(oQ oQVar, AbstractC1221 r3) {
        this.f6738 = oQVar;
        this.f6739 = r3;
        this.f6737 = new MdxConnectionLogblobLogger(oQVar, r3);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m6371(String str) {
        this.f6738.mo5226(new MdxLogblob(MdxLogblob.LogBlobEvent.APPLICATION_STOPPED, str, Logblob.Severity.info));
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public void m6374(String str) {
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m6368(String str) {
        this.f6738.mo5226(new MdxLogblob(MdxLogblob.LogBlobEvent.FAIL_TO_LAUNCH, str, Logblob.Severity.error));
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public void m6372(String str) {
        this.f6738.mo5226(new MdxLogblob(MdxLogblob.LogBlobEvent.FAIL_TO_SEND_MESSAGE, str, Logblob.Severity.error));
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public void m6370() {
        this.f6738.mo5226(new MdxLogblob(MdxLogblob.LogBlobEvent.STOP_MDX));
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m6366() {
        this.f6738.mo5226(new MdxLogblob(MdxLogblob.LogBlobEvent.START_MDX));
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m6365(String str) {
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public void m6362(String str) {
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public void m6375(String str) {
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    public void m6376(String str) {
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public void m6363(String str) {
        this.f6738.mo5226(new MdxLogblob(MdxLogblob.LogBlobEvent.CAST_DEVICE_LOST, str, Logblob.Severity.error));
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public void m6361(String str) {
        this.f6738.mo5226(new MdxLogblob(MdxLogblob.LogBlobEvent.PAIRING_FAILED, str, Logblob.Severity.error));
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public void m6364(TargetSessionMessageType targetSessionMessageType) {
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m6369(String str, String str2, int i, int i2, boolean z) {
        this.f6738.mo5226(new MdxLogblob(MdxLogblob.LogBlobEvent.ERROR_DISPLAYED, "errorString=" + str + " uuid=" + str2 + " network_changes=" + i + " network_changes_dialog=" + i2 + " gpsOld=" + z, Logblob.Severity.error));
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public void m6367(MdxTargetType mdxTargetType, String str, String str2) {
        this.f6738.mo5226(new C1773ff(C1770fd.m6380(this.f6739.mo16505()), mdxTargetType, str, str2));
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public MdxConnectionLogblobLogger m6373() {
        return this.f6737;
    }
}
