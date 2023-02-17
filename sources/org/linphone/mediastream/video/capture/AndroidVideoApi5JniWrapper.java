package org.linphone.mediastream.video.capture;

import android.hardware.Camera;
import android.view.SurfaceView;
import java.util.Iterator;
import java.util.List;
import org.linphone.mediastream.Log;
import org.linphone.mediastream.Version;
import org.linphone.mediastream.video.capture.hwconf.AndroidCameraConfiguration;
public class AndroidVideoApi5JniWrapper {
    public static boolean isRecording = false;

    public static native void putImage(long j, byte[] bArr);

    public static int detectCameras(int[] iArr, int[] iArr2, int[] iArr3) {
        Log.d("detectCameras\n");
        AndroidCameraConfiguration.AndroidCamera[] retrieveCameras = AndroidCameraConfiguration.retrieveCameras();
        int i = 0;
        int length = retrieveCameras.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                break;
            }
            AndroidCameraConfiguration.AndroidCamera androidCamera = retrieveCameras[i2];
            if (i == 2) {
                Log.w("Returning only the 2 first cameras (increase buffer size to retrieve all)");
                break;
            }
            iArr[i] = androidCamera.id;
            iArr2[i] = androidCamera.frontFacing ? 1 : 0;
            iArr3[i] = androidCamera.orientation;
            i++;
            i2++;
        }
        return i;
    }

    public static int[] selectNearestResolutionAvailable(int i, int i2, int i3) {
        Log.d("mediastreamer", "selectNearestResolutionAvailable: " + i + ", " + i2 + "x" + i3);
        return selectNearestResolutionAvailableForCamera(i, i2, i3);
    }

    public static void activateAutoFocus(Object obj) {
        Log.d("mediastreamer", "Turning on autofocus on camera " + obj);
        Camera camera = (Camera) obj;
        if (camera == null) {
            return;
        }
        if (camera.getParameters().getFocusMode() == "auto" || camera.getParameters().getFocusMode() == "macro") {
            camera.autoFocus(null);
        }
    }

    public static Object startRecording(int i, int i2, int i3, int i4, int i5, final long j) {
        Log.d("mediastreamer", "startRecording(" + i + ", " + i2 + ", " + i3 + ", " + i4 + ", " + i5 + ", " + j + ")");
        Camera open = Camera.open();
        applyCameraParameters(open, i2, i3, i4);
        open.setPreviewCallback(new Camera.PreviewCallback() { // from class: org.linphone.mediastream.video.capture.AndroidVideoApi5JniWrapper.1
            @Override // android.hardware.Camera.PreviewCallback
            public void onPreviewFrame(byte[] bArr, Camera camera) {
                if (AndroidVideoApi5JniWrapper.isRecording) {
                    AndroidVideoApi5JniWrapper.putImage(j, bArr);
                }
            }
        });
        open.startPreview();
        isRecording = true;
        Log.d("mediastreamer", "Returning camera object: " + open);
        return open;
    }

    public static void stopRecording(Object obj) {
        isRecording = false;
        Log.d("mediastreamer", "stopRecording(" + obj + ")");
        Camera camera = (Camera) obj;
        if (camera != null) {
            camera.setPreviewCallback(null);
            camera.stopPreview();
            camera.release();
            return;
        }
        Log.i("mediastreamer", "Cannot stop recording ('camera' is null)");
    }

    public static void setPreviewDisplaySurface(Object obj, Object obj2) {
        Log.d("mediastreamer", "setPreviewDisplaySurface(" + obj + ", " + obj2 + ")");
        try {
            ((Camera) obj).setPreviewDisplay(((SurfaceView) obj2).getHolder());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected static int[] selectNearestResolutionAvailableForCamera(int i, int i2, int i3) {
        if (i3 > i2) {
            i3 = i2;
            i2 = i3;
        }
        AndroidCameraConfiguration.AndroidCamera[] retrieveCameras = AndroidCameraConfiguration.retrieveCameras();
        List<AndroidCameraConfiguration.AndroidCamera.Size> list = null;
        for (AndroidCameraConfiguration.AndroidCamera androidCamera : retrieveCameras) {
            if (androidCamera.id == i) {
                list = androidCamera.resolutions;
            }
        }
        if (list == null) {
            Log.e("mediastreamer", "Failed to retrieve supported resolutions.");
            return null;
        }
        Log.i("mediastreamer", list.size() + " supported resolutions :");
        for (AndroidCameraConfiguration.AndroidCamera.Size size : list) {
            Log.i("mediastreamer", "\t" + size.width + "x" + size.height);
        }
        int max = Math.max(i2, i3);
        int min = Math.min(i2, i3);
        try {
            AndroidCameraConfiguration.AndroidCamera.Size size2 = list.get(0);
            int i4 = max * min;
            int i5 = Integer.MAX_VALUE;
            int i6 = 0;
            Iterator<AndroidCameraConfiguration.AndroidCamera.Size> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                AndroidCameraConfiguration.AndroidCamera.Size next = it.next();
                int i7 = (i4 - (next.width * next.height)) * -1;
                if (((next.width >= max && next.height >= min) || (next.width >= min && next.height >= max)) && i7 < i5) {
                    i5 = i7;
                    size2 = next;
                    i6 = 0;
                }
                int i8 = (i4 - ((next.width * next.height) / 4)) * -1;
                if (((next.width / 2 >= max && next.height / 2 >= min) || (next.width / 2 >= min && next.height / 2 >= max)) && i8 < i5) {
                    if (Version.hasFastCpuWithAsmOptim()) {
                        i5 = i8;
                        size2 = next;
                        i6 = 1;
                    } else {
                        size2 = next;
                        i6 = 0;
                    }
                }
                if (next.width == max && next.height == min) {
                    size2 = next;
                    i6 = 0;
                    break;
                }
            }
            int[] iArr = {size2.width, size2.height, i6};
            Log.i("mediastreamer", "resolution selection done (" + iArr[0] + ", " + iArr[1] + ", " + iArr[2] + ")");
            return iArr;
        } catch (Exception e) {
            Log.e(e, "mediastreamer", " resolution selection failed");
            return null;
        }
    }

    protected static void applyCameraParameters(Camera camera, int i, int i2, int i3) {
        Camera.Parameters parameters = camera.getParameters();
        parameters.setPreviewSize(i, i2);
        List<Integer> supportedPreviewFrameRates = parameters.getSupportedPreviewFrameRates();
        if (supportedPreviewFrameRates != null) {
            int i4 = Integer.MAX_VALUE;
            for (Integer num : supportedPreviewFrameRates) {
                int abs = Math.abs(num.intValue() - i3);
                if (abs < i4) {
                    i4 = abs;
                    parameters.setPreviewFrameRate(num.intValue());
                }
            }
            Log.d("mediastreamer", "Preview framerate set:" + parameters.getPreviewFrameRate());
        }
        camera.setParameters(parameters);
    }
}
