package org.linphone.mediastream.video.capture.hwconf;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.util.Size;
import java.util.ArrayList;
import org.linphone.mediastream.Log;
import org.linphone.mediastream.MediastreamerAndroidContext;
import org.linphone.mediastream.video.capture.hwconf.AndroidCameraConfiguration;
public class AndroidCameraConfigurationReader21 {
    @TargetApi(21)
    public static AndroidCameraConfiguration.AndroidCamera[] probeCameras() {
        Context context = MediastreamerAndroidContext.getContext();
        if (context != null) {
            CameraManager cameraManager = (CameraManager) context.getSystemService("camera");
            int i = 0;
            try {
                String[] cameraIdList = cameraManager.getCameraIdList();
                ArrayList arrayList = new ArrayList(cameraIdList.length);
                for (int i2 = 0; i2 < cameraIdList.length; i2++) {
                    CameraCharacteristics cameraCharacteristics = cameraManager.getCameraCharacteristics(cameraIdList[i2]);
                    boolean z = false;
                    if (((Integer) cameraCharacteristics.get(CameraCharacteristics.LENS_FACING)).intValue() == 0) {
                        z = true;
                    }
                    int intValue = ((Integer) cameraCharacteristics.get(CameraCharacteristics.SENSOR_ORIENTATION)).intValue();
                    Size[] outputSizes = ((StreamConfigurationMap) cameraCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP)).getOutputSizes(256);
                    ArrayList arrayList2 = new ArrayList(outputSizes.length);
                    for (int i3 = 0; i3 < outputSizes.length; i3++) {
                        Size size = outputSizes[i3];
                        arrayList2.add(new AndroidCameraConfiguration.AndroidCamera.Size(size.getWidth(), size.getHeight()));
                    }
                    arrayList.add(new AndroidCameraConfiguration.AndroidCamera(i2, z, arrayList2, intValue));
                    i++;
                }
                return (AndroidCameraConfiguration.AndroidCamera[]) arrayList.toArray(new AndroidCameraConfiguration.AndroidCamera[i]);
            } catch (CameraAccessException e) {
                Log.e(e);
            }
        }
        return new AndroidCameraConfiguration.AndroidCamera[0];
    }
}
