package o;

import android.content.Context;
import android.content.Intent;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.api.res.AssetType;
import com.netflix.mediaclient.media.BookmarkStore;
import com.netflix.mediaclient.service.api.diagnostics.IDiagnosis;
import com.netflix.mediaclient.service.job.NetflixJob;
import com.netflix.mediaclient.service.user.UserAgentInterface;
import com.netflix.mediaclient.service.webclient.model.leafs.EogAlert;
import com.netflix.mediaclient.service.webclient.model.leafs.UmaAlert;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.IVoip;
import com.netflix.mediaclient.util.DeviceCategory;
import com.netflix.mediaclient.util.gfx.ImageLoader;
import com.netflix.model.leafs.OnRampEligibility;
import io.reactivex.Observable;
import io.reactivex.Single;
import java.util.List;
public interface oE extends oS, AbstractC1250 {
    @Override // android.content.ContextWrapper, o.oE
    Context getApplicationContext();

    /* renamed from: ʻ  reason: contains not printable characters */
    boolean mo9394();

    /* renamed from: ʻॱ  reason: contains not printable characters */
    boolean mo9395();

    /* renamed from: ʼ  reason: contains not printable characters */
    EogAlert mo9396();

    /* renamed from: ʼॱ  reason: contains not printable characters */
    void mo9397();

    /* renamed from: ʽ  reason: contains not printable characters */
    String mo9398();

    /* renamed from: ʽॱ  reason: contains not printable characters */
    boolean mo9399();

    /* renamed from: ʾ  reason: contains not printable characters */
    DeviceCategory mo9400();

    /* renamed from: ʿ  reason: contains not printable characters */
    String mo9401();

    /* renamed from: ˈ  reason: contains not printable characters */
    void mo9402();

    /* renamed from: ˉ  reason: contains not printable characters */
    AbstractC2060pi mo9403();

    /* renamed from: ˊ  reason: contains not printable characters */
    ImageLoader mo9404();

    /* renamed from: ˊ  reason: contains not printable characters */
    void mo9405(int i, int i2);

    /* renamed from: ˊ  reason: contains not printable characters */
    void mo9406(int i, String str, String str2, int i2, int i3);

    /* renamed from: ˊ  reason: contains not printable characters */
    void mo9407(OnRampEligibility.Action action, int i, int i2);

    /* renamed from: ˊ  reason: contains not printable characters */
    void mo9408(String str);

    /* renamed from: ˊ  reason: contains not printable characters */
    void mo9409(String str, String str2);

    /* renamed from: ˊˊ  reason: contains not printable characters */
    boolean mo9410();

    /* renamed from: ˊˋ  reason: contains not printable characters */
    oG mo9411();

    /* renamed from: ˊॱ  reason: contains not printable characters */
    void mo9412();

    /* renamed from: ˊᐝ  reason: contains not printable characters */
    IDiagnosis mo9413();

    /* renamed from: ˋ  reason: contains not printable characters */
    void mo9414(int i, int i2);

    /* renamed from: ˋ  reason: contains not printable characters */
    void mo9415(NetflixJob.NetflixJobId netflixJobId);

    /* renamed from: ˋ  reason: contains not printable characters */
    void mo9416(String str, int i, int i2);

    /* renamed from: ˋ  reason: contains not printable characters */
    void mo9417(String str, String str2, boolean z, String str3, int i, int i2);

    /* renamed from: ˋ  reason: contains not printable characters */
    void mo9418(oL oLVar);

    /* renamed from: ˋ  reason: contains not printable characters */
    void mo9419(C0614 v, int i, int i2);

    /* renamed from: ˋˊ  reason: contains not printable characters */
    boolean mo9420();

    /* renamed from: ˋˋ  reason: contains not printable characters */
    AbstractC1194 mo9421();

    /* renamed from: ˋॱ  reason: contains not printable characters */
    Observable<Status> mo9422();

    /* renamed from: ˋᐝ  reason: contains not printable characters */
    oI mo9423();

    /* renamed from: ˌ  reason: contains not printable characters */
    AbstractC1221 mo9424();

    /* renamed from: ˍ  reason: contains not printable characters */
    AbstractC0518 mo9425();

    /* renamed from: ˎ  reason: contains not printable characters */
    AbstractC0933 mo9426();

    /* renamed from: ˎ  reason: contains not printable characters */
    void mo9427(int i, int i2);

    /* renamed from: ˎ  reason: contains not printable characters */
    void mo9428(long j, int i, int i2);

    /* renamed from: ˎ  reason: contains not printable characters */
    void mo9429(String str);

    /* renamed from: ˎ  reason: contains not printable characters */
    void mo9430(String str, UserAgentInterface.PinType pinType, String str2, int i, int i2);

    /* renamed from: ˎˎ  reason: contains not printable characters */
    IClientLogging mo9431();

    /* renamed from: ˎˏ  reason: contains not printable characters */
    AbstractC2050oz mo9432();

    /* renamed from: ˏ  reason: contains not printable characters */
    void mo9433(int i, int i2);

    /* renamed from: ˏ  reason: contains not printable characters */
    void mo9434(String str, AssetType assetType, int i, int i2);

    /* renamed from: ˏ  reason: contains not printable characters */
    void mo9435(String str, String str2);

    /* renamed from: ˏ  reason: contains not printable characters */
    void mo9436(String str, boolean z, String str2, int i, int i2);

    /* renamed from: ˏˎ  reason: contains not printable characters */
    void mo9437();

    /* renamed from: ˏˏ  reason: contains not printable characters */
    AbstractC1853hl mo9438();

    /* renamed from: ˏॱ  reason: contains not printable characters */
    void mo9439();

    /* renamed from: ͺ  reason: contains not printable characters */
    UmaAlert mo9440();

    /* renamed from: ͺॱ  reason: contains not printable characters */
    oH mo9441();

    /* renamed from: ـ  reason: contains not printable characters */
    IVoip mo9442();

    /* renamed from: ॱ  reason: contains not printable characters */
    void mo9443(int i, int i2);

    /* renamed from: ॱ  reason: contains not printable characters */
    void mo9444(Intent intent);

    /* renamed from: ॱ  reason: contains not printable characters */
    void mo9445(NetflixJob.NetflixJobId netflixJobId);

    /* renamed from: ॱ  reason: contains not printable characters */
    void mo9446(String str);

    /* renamed from: ॱ  reason: contains not printable characters */
    void mo9447(String str, String str2, int i, int i2);

    /* renamed from: ॱ  reason: contains not printable characters */
    void mo9448(oL oLVar);

    /* renamed from: ॱ  reason: contains not printable characters */
    void mo9449(boolean z);

    /* renamed from: ॱʻ  reason: contains not printable characters */
    BookmarkStore mo9450();

    /* renamed from: ॱʽ  reason: contains not printable characters */
    AbstractC1156 mo9451();

    /* renamed from: ॱˊ  reason: contains not printable characters */
    Single<Status> mo9452();

    /* renamed from: ॱˋ  reason: contains not printable characters */
    AbstractC2089qj mo9453();

    /* renamed from: ॱˎ  reason: contains not printable characters */
    boolean mo9454();

    /* renamed from: ॱͺ  reason: contains not printable characters */
    C2003ng mo9455();

    /* renamed from: ॱॱ  reason: contains not printable characters */
    boolean mo9456();

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    boolean mo9457();

    /* renamed from: ᐝ  reason: contains not printable characters */
    String mo9458();

    /* renamed from: ᐝ  reason: contains not printable characters */
    void mo9459(int i, int i2);

    /* renamed from: ᐝˊ  reason: contains not printable characters */
    AbstractC2056pe mo9460();

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    List<? extends AbstractC2089qj> mo9461();

    /* renamed from: ᐝᐝ  reason: contains not printable characters */
    AbstractC2057pf mo9462();
}
