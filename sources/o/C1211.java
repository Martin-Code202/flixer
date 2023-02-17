package o;

import android.os.Handler;
import com.netflix.mediaclient.android.app.Status;
import com.netflix.mediaclient.servicemgr.interface_.genre.GenreList;
import com.netflix.model.leafs.FlatGenreListOfVideosSummary;
import com.netflix.model.leafs.LoLoMoSummary;
import com.netflix.model.leafs.PrePlayExperiences;
import com.netflix.model.leafs.TrailersFeedItemSummary;
import com.netflix.model.leafs.Video;
import com.netflix.model.leafs.advisory.Advisory;
import java.util.List;
import java.util.Map;
/* renamed from: o.ﻢ  reason: contains not printable characters */
public class C1211 implements AbstractC1203 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private final Handler f15612;

    /* renamed from: ˏ  reason: contains not printable characters */
    private final AbstractC1203 f15613;

    public C1211(Handler handler, AbstractC1203 r2) {
        this.f15612 = handler;
        this.f15613 = r2;
    }

    @Override // o.AbstractC1203
    /* renamed from: ˎ */
    public void mo7402(final LoLoMoSummary loLoMoSummary, final Status status) {
        this.f15612.post(new Runnable() { // from class: o.ﻢ.5
            @Override // java.lang.Runnable
            public void run() {
                C1348Bu.m4093();
                C1211.this.f15613.mo7402(loLoMoSummary, status);
            }
        });
    }

    @Override // o.AbstractC1203
    /* renamed from: ˏ */
    public void mo8528(final LoLoMoSummary loLoMoSummary, final Status status) {
        this.f15612.post(new Runnable() { // from class: o.ﻢ.12
            @Override // java.lang.Runnable
            public void run() {
                C1348Bu.m4093();
                C1211.this.f15613.mo8528(loLoMoSummary, status);
            }
        });
    }

    @Override // o.AbstractC1203
    /* renamed from: ˎ */
    public void mo7393(final List<pC> list, final Status status) {
        this.f15612.post(new Runnable() { // from class: o.ﻢ.17
            @Override // java.lang.Runnable
            public void run() {
                C1348Bu.m4093();
                C1211.this.f15613.mo7393(list, status);
            }
        });
    }

    @Override // o.AbstractC1203
    /* renamed from: ˊ */
    public void mo7395(final List<AbstractC2074pw> list, final Status status) {
        this.f15612.post(new Runnable() { // from class: o.ﻢ.26
            @Override // java.lang.Runnable
            public void run() {
                C1348Bu.m4093();
                C1211.this.f15613.mo7395(list, status);
            }
        });
    }

    @Override // o.AbstractC1203
    /* renamed from: ॱ */
    public void mo8539(final List<Object> list, final Status status) {
        this.f15612.post(new Runnable() { // from class: o.ﻢ.37
            @Override // java.lang.Runnable
            public void run() {
                C1348Bu.m4093();
                C1211.this.f15613.mo8539(list, status);
            }
        });
    }

    @Override // o.AbstractC1203
    /* renamed from: ˏ */
    public void mo8530(final List<pD> list, final Status status) {
        this.f15612.post(new Runnable() { // from class: o.ﻢ.38
            @Override // java.lang.Runnable
            public void run() {
                C1348Bu.m4093();
                C1211.this.f15613.mo8530(list, status);
            }
        });
    }

    @Override // o.AbstractC1203
    /* renamed from: ˋ */
    public void mo7396(final List<AbstractC2077pz> list, final Status status) {
        this.f15612.post(new Runnable() { // from class: o.ﻢ.40
            @Override // java.lang.Runnable
            public void run() {
                C1348Bu.m4093();
                C1211.this.f15613.mo7396(list, status);
            }
        });
    }

    @Override // o.AbstractC1203
    /* renamed from: ʼ */
    public void mo7394(final List<pK> list, final Status status) {
        this.f15612.post(new Runnable() { // from class: o.ﻢ.39
            @Override // java.lang.Runnable
            public void run() {
                C1348Bu.m4093();
                C1211.this.f15613.mo7394(list, status);
            }
        });
    }

    @Override // o.AbstractC1203
    /* renamed from: ʽ */
    public void mo8519(final List<CH> list, final Status status) {
        this.f15612.post(new Runnable() { // from class: o.ﻢ.41
            @Override // java.lang.Runnable
            public void run() {
                C1348Bu.m4093();
                C1211.this.f15613.mo8519(list, status);
            }
        });
    }

    @Override // o.AbstractC1203
    /* renamed from: ॱॱ */
    public void mo7398(final List<pJ> list, final Status status) {
        this.f15612.post(new Runnable() { // from class: o.ﻢ.1
            @Override // java.lang.Runnable
            public void run() {
                C1348Bu.m4093();
                C1211.this.f15613.mo7398(list, status);
            }
        });
    }

    @Override // o.AbstractC1203
    /* renamed from: ॱ */
    public void mo8538(final FlatGenreListOfVideosSummary flatGenreListOfVideosSummary, final List<pJ> list, final Status status) {
        this.f15612.post(new Runnable() { // from class: o.ﻢ.4
            @Override // java.lang.Runnable
            public void run() {
                C1348Bu.m4093();
                C1211.this.f15613.mo8538(flatGenreListOfVideosSummary, list, status);
            }
        });
    }

    @Override // o.AbstractC1203
    /* renamed from: ᐝ */
    public void mo7347(final List<pI> list, final Status status) {
        this.f15612.post(new Runnable() { // from class: o.ﻢ.3
            @Override // java.lang.Runnable
            public void run() {
                C1211.this.f15613.mo7347(list, status);
            }
        });
    }

    @Override // o.AbstractC1203
    /* renamed from: ʻ */
    public void mo8518(final List<pS> list, final Status status) {
        this.f15612.post(new Runnable() { // from class: o.ﻢ.2
            @Override // java.lang.Runnable
            public void run() {
                C1211.this.f15613.mo8518(list, status);
            }
        });
    }

    @Override // o.AbstractC1203
    /* renamed from: ˏ */
    public void mo8531(final pA pAVar, final Status status) {
        this.f15612.post(new Runnable() { // from class: o.ﻢ.8
            @Override // java.lang.Runnable
            public void run() {
                C1348Bu.m4093();
                C1211.this.f15613.mo8531(pAVar, status);
            }
        });
    }

    @Override // o.AbstractC1203
    /* renamed from: ˎ */
    public void mo8525(final Video.Summary summary, final Status status) {
        this.f15612.post(new Runnable() { // from class: o.ﻢ.6
            @Override // java.lang.Runnable
            public void run() {
                C1348Bu.m4093();
                C1211.this.f15613.mo8525(summary, status);
            }
        });
    }

    @Override // o.AbstractC1203
    /* renamed from: ˊ */
    public void mo8177(final CH ch, final Status status) {
        this.f15612.post(new Runnable() { // from class: o.ﻢ.7
            @Override // java.lang.Runnable
            public void run() {
                C1348Bu.m4093();
                C1211.this.f15613.mo8177(ch, status);
            }
        });
    }

    @Override // o.AbstractC1203
    /* renamed from: ˏ */
    public void mo6200(final pP pPVar, final Status status) {
        this.f15612.post(new Runnable() { // from class: o.ﻢ.10
            @Override // java.lang.Runnable
            public void run() {
                C1348Bu.m4093();
                C1211.this.f15613.mo6200(pPVar, status);
            }
        });
    }

    @Override // o.AbstractC1203
    /* renamed from: ॱ */
    public void mo8536(final int i, final Status status) {
        this.f15612.post(new Runnable() { // from class: o.ﻢ.9
            @Override // java.lang.Runnable
            public void run() {
                C1348Bu.m4093();
                C1211.this.f15613.mo8536(i, status);
            }
        });
    }

    @Override // o.AbstractC1203
    /* renamed from: ˏ */
    public void mo8532(final pL pLVar, final Boolean bool, final Status status) {
        this.f15612.post(new Runnable() { // from class: o.ﻢ.13
            @Override // java.lang.Runnable
            public void run() {
                C1348Bu.m4093();
                C1211.this.f15613.mo8532(pLVar, bool, status);
            }
        });
    }

    @Override // o.AbstractC1203
    /* renamed from: ˎ */
    public void mo6203(final pI pIVar, final Status status) {
        this.f15612.post(new Runnable() { // from class: o.ﻢ.11
            @Override // java.lang.Runnable
            public void run() {
                C1211.this.f15613.mo6203(pIVar, status);
            }
        });
    }

    @Override // o.AbstractC1203
    /* renamed from: ˊ */
    public void mo8175(final pR pRVar, final Status status) {
        this.f15612.post(new Runnable() { // from class: o.ﻢ.15
            @Override // java.lang.Runnable
            public void run() {
                C1348Bu.m4093();
                C1211.this.f15613.mo8175(pRVar, status);
            }
        });
    }

    @Override // o.AbstractC1203
    /* renamed from: ˎ */
    public void mo7346(final pR pRVar, final List<pS> list, final Status status) {
        this.f15612.post(new Runnable() { // from class: o.ﻢ.14
            @Override // java.lang.Runnable
            public void run() {
                C1348Bu.m4093();
                C1211.this.f15613.mo7346(pRVar, list, status);
            }
        });
    }

    @Override // o.AbstractC1203
    /* renamed from: ˏॱ */
    public void mo8534(final List<GenreList> list, final Status status) {
        this.f15612.post(new Runnable() { // from class: o.ﻢ.20
            @Override // java.lang.Runnable
            public void run() {
                C1348Bu.m4093();
                C1211.this.f15613.mo8534(list, status);
            }
        });
    }

    @Override // o.AbstractC1203
    /* renamed from: ͺ */
    public void mo8535(final List<pW> list, final Status status) {
        this.f15612.post(new Runnable() { // from class: o.ﻢ.16
            @Override // java.lang.Runnable
            public void run() {
                C1348Bu.m4093();
                C1211.this.f15613.mo8535(list, status);
            }
        });
    }

    @Override // o.AbstractC1203
    /* renamed from: ॱ */
    public void mo8540(final pE pEVar, final Status status) {
        this.f15612.post(new Runnable() { // from class: o.ﻢ.19
            @Override // java.lang.Runnable
            public void run() {
                C1348Bu.m4093();
                C1211.this.f15613.mo8540(pEVar, status);
            }
        });
    }

    @Override // o.AbstractC1203
    /* renamed from: ॱ */
    public void mo8537(final Status status) {
        this.f15612.post(new Runnable() { // from class: o.ﻢ.18
            @Override // java.lang.Runnable
            public void run() {
                C1211.this.f15613.mo8537(status);
            }
        });
    }

    @Override // o.AbstractC1203
    /* renamed from: ˎ */
    public void mo8524(final Status status) {
        this.f15612.post(new Runnable() { // from class: o.ﻢ.21
            @Override // java.lang.Runnable
            public void run() {
                C1211.this.f15613.mo8524(status);
            }
        });
    }

    @Override // o.AbstractC1203
    /* renamed from: ˏ */
    public void mo8527(final Status status) {
        this.f15612.post(new Runnable() { // from class: o.ﻢ.23
            @Override // java.lang.Runnable
            public void run() {
                C1211.this.f15613.mo8527(status);
            }
        });
    }

    @Override // o.AbstractC1203
    /* renamed from: ˎ */
    public void mo8526(final AbstractC2080qa qaVar, final Status status) {
        this.f15612.post(new Runnable() { // from class: o.ﻢ.22
            @Override // java.lang.Runnable
            public void run() {
                C1211.this.f15613.mo8526(qaVar, status);
            }
        });
    }

    @Override // o.AbstractC1203
    /* renamed from: ˏ */
    public void mo6199(final pO pOVar, final Status status) {
        this.f15612.post(new Runnable() { // from class: o.ﻢ.25
            @Override // java.lang.Runnable
            public void run() {
                C1211.this.f15613.mo6199(pOVar, status);
            }
        });
    }

    @Override // o.AbstractC1203
    /* renamed from: ˏ */
    public void mo8529(final PrePlayExperiences prePlayExperiences, final Status status) {
        this.f15612.post(new Runnable() { // from class: o.ﻢ.24
            @Override // java.lang.Runnable
            public void run() {
                C1211.this.f15613.mo8529(prePlayExperiences, status);
            }
        });
    }

    @Override // o.AbstractC1203
    /* renamed from: ˊ */
    public void mo8521(final boolean z, final Status status) {
        this.f15612.post(new Runnable() { // from class: o.ﻢ.30
            @Override // java.lang.Runnable
            public void run() {
                C1211.this.f15613.mo8521(z, status);
            }
        });
    }

    @Override // o.AbstractC1203
    /* renamed from: ˏ */
    public void mo8533(final boolean z, final Status status) {
        this.f15612.post(new Runnable() { // from class: o.ﻢ.27
            @Override // java.lang.Runnable
            public void run() {
                C1211.this.f15613.mo8533(z, status);
            }
        });
    }

    @Override // o.AbstractC1203
    /* renamed from: ˏ */
    public void mo8174(final AbstractC2082qc qcVar, final Status status) {
        this.f15612.post(new Runnable() { // from class: o.ﻢ.28
            @Override // java.lang.Runnable
            public void run() {
                C1211.this.f15613.mo8174(qcVar, status);
            }
        });
    }

    @Override // o.AbstractC1203
    /* renamed from: ˊ */
    public void mo8173(final Status status) {
        this.f15612.post(new Runnable() { // from class: o.ﻢ.29
            @Override // java.lang.Runnable
            public void run() {
                C1211.this.f15613.mo8173(status);
            }
        });
    }

    @Override // o.AbstractC1203
    /* renamed from: ˊॱ */
    public void mo8522(final List<Advisory> list, final Status status) {
        this.f15612.post(new Runnable() { // from class: o.ﻢ.33
            @Override // java.lang.Runnable
            public void run() {
                C1211.this.f15613.mo8522(list, status);
            }
        });
    }

    @Override // o.AbstractC1203
    /* renamed from: ˎ */
    public void mo7348(final Map<String, Boolean> map, final Status status) {
        this.f15612.post(new Runnable() { // from class: o.ﻢ.35
            @Override // java.lang.Runnable
            public void run() {
                C1211.this.f15613.mo7348(map, status);
            }
        });
    }

    @Override // o.AbstractC1203
    /* renamed from: ˋॱ */
    public void mo7397(final List<AbstractC2070ps> list, final Status status) {
        this.f15612.post(new Runnable() { // from class: o.ﻢ.34
            @Override // java.lang.Runnable
            public void run() {
                C1211.this.f15613.mo7397(list, status);
            }
        });
    }

    @Override // o.AbstractC1203
    /* renamed from: ˋ */
    public void mo8523(final boolean z, final Status status) {
        this.f15612.post(new Runnable() { // from class: o.ﻢ.31
            @Override // java.lang.Runnable
            public void run() {
                C1211.this.f15613.mo8523(z, status);
            }
        });
    }

    @Override // o.AbstractC1203
    /* renamed from: ॱˊ */
    public void mo8541(final List<CH> list, final Status status) {
        this.f15612.post(new Runnable() { // from class: o.ﻢ.32
            @Override // java.lang.Runnable
            public void run() {
                C1211.this.f15613.mo8541(list, status);
            }
        });
    }

    @Override // o.AbstractC1203
    /* renamed from: ˊ */
    public void mo8520(final TrailersFeedItemSummary trailersFeedItemSummary, final List<pH> list, final Status status) {
        this.f15612.post(new Runnable() { // from class: o.ﻢ.36
            @Override // java.lang.Runnable
            public void run() {
                C1211.this.f15613.mo8520(trailersFeedItemSummary, list, status);
            }
        });
    }
}
