package com.netflix.mediaclient.ui.feeds;

import com.netflix.mediaclient.servicemgr.IPlayer;
import com.netflix.mediaclient.servicemgr.interface_.VideoType;
import kotlin.jvm.internal.Lambda;
import o.AbstractC1450Fk;
import o.AbstractC2055pd;
import o.C1283;
import o.EA;
import o.oX;
import o.oY;
import o.rV;
public final class TrailerVideoView$attachPlaybackSession$1 extends Lambda implements AbstractC1450Fk<IPlayer.aux, EA> {

    /* renamed from: ʻ  reason: contains not printable characters */
    final /* synthetic */ oX f3060;

    /* renamed from: ʼ  reason: contains not printable characters */
    final /* synthetic */ long f3061;

    /* renamed from: ˊ  reason: contains not printable characters */
    final /* synthetic */ long f3062;

    /* renamed from: ˋ  reason: contains not printable characters */
    final /* synthetic */ VideoType f3063;

    /* renamed from: ˎ  reason: contains not printable characters */
    final /* synthetic */ rV f3064;

    /* renamed from: ˏ  reason: contains not printable characters */
    final /* synthetic */ oY f3065;

    /* renamed from: ॱ  reason: contains not printable characters */
    final /* synthetic */ AbstractC2055pd f3066;

    /* renamed from: ॱॱ  reason: contains not printable characters */
    final /* synthetic */ boolean f3067;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TrailerVideoView$attachPlaybackSession$1(rV rVVar, long j, oY oYVar, VideoType videoType, AbstractC2055pd pdVar, oX oXVar, long j2, boolean z) {
        super(1);
        this.f3064 = rVVar;
        this.f3062 = j;
        this.f3065 = oYVar;
        this.f3063 = videoType;
        this.f3066 = pdVar;
        this.f3060 = oXVar;
        this.f3061 = j2;
        this.f3067 = z;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // o.AbstractC1450Fk
    public /* synthetic */ EA invoke(IPlayer.aux aux) {
        m1861(aux);
        return EA.f5503;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public final void m1861(IPlayer.aux aux) {
        rV.Cif ifVar;
        boolean z = this.f3064.f9699 < this.f3064.f9701 && (ifVar = this.f3064.f9697) != null && ifVar.mo10209(this.f3062);
        C1283.m16854("TrailerVideoView", "Can retry : " + z + " (" + this.f3064.f9699 + " / " + this.f3064.f9701 + ')');
        if (!z) {
            IPlayer.AbstractC0024 r11 = this.f3064.f9700;
            if (r11 != null) {
                r11.mo1530(aux);
                return;
            }
            return;
        }
        C1283.m16851("TrailerVideoView", "retryCount=%d attachPlaybackSession %d", Integer.valueOf(this.f3064.f9699), Long.valueOf(this.f3062));
        boolean unused = TrailerVideoView$attachPlaybackSession$1.super.mo2340(this.f3065, this.f3062, this.f3063, this.f3066, this.f3060, this.f3061, this.f3067);
        rV rVVar = this.f3064;
        rVVar.f9699 = rVVar.f9699 + 1;
    }
}
