package o;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import java.nio.ByteBuffer;
public interface iQ {
    /* renamed from: ˎ */
    ByteBuffer mo7538(int i);

    /* renamed from: ˎ */
    void mo7539();

    public static class iF {
        /* renamed from: ˋ  reason: contains not printable characters */
        public static void m7541(ByteBuffer byteBuffer, ImageView imageView) {
            if (imageView == null) {
                C1283.m16865("BifManager", "View is null");
            } else if (byteBuffer == null) {
                C1283.m16846("BifManager", "ByteBuffer is null");
            } else {
                if (imageView.getVisibility() != 0) {
                    imageView.setVisibility(0);
                }
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(byteBuffer.array(), byteBuffer.position(), byteBuffer.limit());
                if (decodeByteArray != null) {
                    imageView.setImageBitmap(decodeByteArray);
                } else {
                    C1283.m16865("BifManager", "decoded bif bitmap is null");
                }
            }
        }
    }
}
