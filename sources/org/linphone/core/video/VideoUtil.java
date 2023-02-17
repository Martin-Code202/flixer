package org.linphone.core.video;

import android.hardware.Camera;
import java.util.ArrayList;
import java.util.List;
import org.linphone.core.VideoSize;
final class VideoUtil {
    private VideoUtil() {
    }

    public static List<VideoSize> createList(List<Camera.Size> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (Camera.Size size : list) {
            arrayList.add(new VideoSize(size.width, size.height));
        }
        return arrayList;
    }
}
