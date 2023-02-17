package com.netflix.mediaclient.media.manifest;

import java.util.ArrayList;
import java.util.List;
public class VideoTrack {
    public String new_track_id;
    public List<Stream> streams = new ArrayList();
    public String track_id;
    public int type;
}
