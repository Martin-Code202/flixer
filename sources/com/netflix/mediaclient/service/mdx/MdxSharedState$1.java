package com.netflix.mediaclient.service.mdx;

import com.netflix.mediaclient.servicemgr.IMdxSharedState;
import java.util.HashMap;
public class MdxSharedState$1 extends HashMap<IMdxSharedState.MdxPlaybackState, String> {
    public MdxSharedState$1() {
        put(IMdxSharedState.MdxPlaybackState.Playing, "Playing");
        put(IMdxSharedState.MdxPlaybackState.Paused, "Paused");
        put(IMdxSharedState.MdxPlaybackState.Stopped, "Stopped");
        put(IMdxSharedState.MdxPlaybackState.Loading, "Loading");
        put(IMdxSharedState.MdxPlaybackState.Transitioning, "Transitioning");
    }
}
