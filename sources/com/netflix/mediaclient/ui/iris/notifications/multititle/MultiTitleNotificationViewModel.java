package com.netflix.mediaclient.ui.iris.notifications.multititle;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import com.netflix.model.leafs.social.multititle.NotificationCtaButton;
import com.netflix.model.leafs.social.multititle.NotificationGridModule;
import com.netflix.model.leafs.social.multititle.NotificationGridTitleAction;
import com.netflix.model.leafs.social.multititle.NotificationHeroModule;
import com.netflix.model.leafs.social.multititle.NotificationLandingPage;
import com.netflix.model.leafs.social.multititle.NotificationModule;
import com.netflix.model.leafs.social.multititle.NotificationTemplate;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import io.reactivex.rxkotlin.SubscribersKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.TypeCastException;
import o.C1456Fq;
import o.C1457Fr;
import o.EI;
import o.sL;
import o.sM;
import o.sN;
import o.sO;
import o.sP;
import o.sW;
public final class MultiTitleNotificationViewModel extends AndroidViewModel {

    /* renamed from: ˋ  reason: contains not printable characters */
    public static final C0037 f3160 = new C0037(null);

    /* renamed from: ˊ  reason: contains not printable characters */
    private final MutableLiveData<List<sW>> f3161 = new MutableLiveData<>();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MultiTitleNotificationViewModel(Application application) {
        super(application);
        C1457Fr.m5025(application, "application");
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public final MutableLiveData<List<sW>> m1970() {
        return this.f3161;
    }

    /* renamed from: com.netflix.mediaclient.ui.iris.notifications.multititle.MultiTitleNotificationViewModel$ˋ  reason: contains not printable characters */
    public static final class C0037 {
        private C0037() {
        }

        public /* synthetic */ C0037(C1456Fq fq) {
            this();
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public final void m1969(NotificationLandingPage notificationLandingPage) {
        String str;
        String str2;
        CharSequence charSequence;
        String str3;
        NotificationCtaButton ctaButton;
        NotificationCtaButton ctaButton2;
        NotificationCtaButton ctaButton3;
        C1457Fr.m5025(notificationLandingPage, "landingPage");
        this.f3161.setValue(new ArrayList());
        NotificationTemplate template = notificationLandingPage.getTemplate();
        ArrayList arrayList = new ArrayList();
        if (template == null || (str = template.getHeadlineText()) == null) {
            str = "";
        }
        if (template == null || (str2 = template.getBodyText()) == null) {
            str2 = "";
        }
        arrayList.add(new sN(0, str, str2, 1, null));
        m1968(template != null ? template.getModules() : null, arrayList);
        if (template == null || (ctaButton3 = template.getCtaButton()) == null || (charSequence = ctaButton3.getButtonText()) == null) {
        }
        if (template == null || (ctaButton2 = template.getCtaButton()) == null || (str3 = ctaButton2.getAction()) == null) {
            str3 = "";
        }
        arrayList.add(new sM(0, charSequence, str3, (template == null || (ctaButton = template.getCtaButton()) == null) ? null : ctaButton.getTrackingInfo(), 1, null));
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (((sW) obj) instanceof sP) {
                arrayList2.add(obj);
            }
        }
        ArrayList<sW> arrayList3 = arrayList2;
        ArrayList arrayList4 = new ArrayList(EI.m4812((Iterable) arrayList3, 10));
        for (sW sWVar : arrayList3) {
            if (sWVar == null) {
                throw new TypeCastException("null cannot be cast to non-null type com.netflix.mediaclient.ui.iris.notifications.multititle.HeroTitle");
            }
            arrayList4.add((sP) sWVar);
        }
        m1971(arrayList4, arrayList);
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private final void m1968(List<? extends NotificationModule> list, List<sW> list2) {
        if (list != null) {
            for (T t : list) {
                if (t instanceof NotificationHeroModule) {
                    list2.add(new sP(0, t, false, 5, null));
                } else if (t instanceof NotificationGridModule) {
                    String headlineText = t.getHeadlineText();
                    C1457Fr.m5016((Object) headlineText, "it.headlineText");
                    list2.add(new sO(0, headlineText, 1, null));
                    boolean z = true;
                    List<NotificationGridTitleAction> actions = t.getActions();
                    C1457Fr.m5016((Object) actions, "it.actions");
                    for (T t2 : actions) {
                        C1457Fr.m5016((Object) t2, "action");
                        list2.add(new sL(0, t2, z, 1, null));
                        z = !z;
                    }
                }
            }
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public final void m1971(List<sP> list, List<sW> list2) {
        C1457Fr.m5025(list, "heroRows");
        C1457Fr.m5025(list2, "newRows");
        List<sP> list3 = list;
        ArrayList arrayList = new ArrayList(EI.m4812((Iterable) list3, 10));
        Iterator<T> it = list3.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().m10637());
        }
        Observable zip = Observable.zip(arrayList, If.f3162);
        C1457Fr.m5016((Object) zip, "Observable\n            .…TitleObservables, { it })");
        SubscribersKt.subscribeBy(zip, MultiTitleNotificationViewModel$updateRows$3.f3164, new MultiTitleNotificationViewModel$updateRows$4(this, list2), new MultiTitleNotificationViewModel$updateRows$2(list2));
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            it2.next().m10631();
        }
    }

    /* access modifiers changed from: package-private */
    public static final class If<T, R> implements Function<Object[], R> {

        /* renamed from: ॱ  reason: contains not printable characters */
        public static final If f3162 = new If();

        If() {
        }

        /* renamed from: ˋ  reason: contains not printable characters */
        public final Object[] apply(Object[] objArr) {
            C1457Fr.m5025(objArr, "it");
            return objArr;
        }
    }
}
