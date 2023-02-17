package com.netflix.mediaclient.servicemgr;

import com.netflix.model.leafs.PostPlayItem;
public enum PlayLocationType {
    STORY_ART("storyArt"),
    EPISODE(PostPlayItem.POST_PLAY_ITEM_EPISODE),
    DIRECT_PLAY("directPlay"),
    POST_PLAY("postPlay"),
    MDX("mdx"),
    UNKNOWN("");
    

    /* renamed from: ᐝ  reason: contains not printable characters */
    private final String f2647;

    private PlayLocationType(String str) {
        this.f2647 = str;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public String m1559() {
        return this.f2647;
    }
}
