package android.support.v4.media;

import android.media.Rating;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
public final class RatingCompat implements Parcelable {
    public static final Parcelable.Creator<RatingCompat> CREATOR = new Parcelable.Creator<RatingCompat>() { // from class: android.support.v4.media.RatingCompat.1
        @Override // android.os.Parcelable.Creator
        public RatingCompat createFromParcel(Parcel parcel) {
            return new RatingCompat(parcel.readInt(), parcel.readFloat());
        }

        @Override // android.os.Parcelable.Creator
        public RatingCompat[] newArray(int i) {
            return new RatingCompat[i];
        }
    };
    private Object mRatingObj;
    private final int mRatingStyle;
    private final float mRatingValue;

    RatingCompat(int i, float f) {
        this.mRatingStyle = i;
        this.mRatingValue = f;
    }

    @Override // java.lang.Object
    public String toString() {
        String str;
        StringBuilder append = new StringBuilder().append("Rating:style=").append(this.mRatingStyle).append(" rating=");
        if (this.mRatingValue < 0.0f) {
            str = "unrated";
        } else {
            str = String.valueOf(this.mRatingValue);
        }
        return append.append(str).toString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return this.mRatingStyle;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mRatingStyle);
        parcel.writeFloat(this.mRatingValue);
    }

    public static RatingCompat newUnratedRating(int i) {
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                return new RatingCompat(i, -1.0f);
            default:
                return null;
        }
    }

    public static RatingCompat newHeartRating(boolean z) {
        return new RatingCompat(1, z ? 1.0f : 0.0f);
    }

    public static RatingCompat newThumbRating(boolean z) {
        return new RatingCompat(2, z ? 1.0f : 0.0f);
    }

    public static RatingCompat newStarRating(int i, float f) {
        float f2;
        switch (i) {
            case 3:
                f2 = 3.0f;
                break;
            case 4:
                f2 = 4.0f;
                break;
            case 5:
                f2 = 5.0f;
                break;
            default:
                Log.e("Rating", "Invalid rating style (" + i + ") for a star rating");
                return null;
        }
        if (f >= 0.0f && f <= f2) {
            return new RatingCompat(i, f);
        }
        Log.e("Rating", "Trying to set out of range star-based rating");
        return null;
    }

    public static RatingCompat newPercentageRating(float f) {
        if (f >= 0.0f && f <= 100.0f) {
            return new RatingCompat(6, f);
        }
        Log.e("Rating", "Invalid percentage-based rating value");
        return null;
    }

    public static RatingCompat fromRating(Object obj) {
        RatingCompat ratingCompat;
        if (obj == null || Build.VERSION.SDK_INT < 19) {
            return null;
        }
        int ratingStyle = ((Rating) obj).getRatingStyle();
        if (((Rating) obj).isRated()) {
            switch (ratingStyle) {
                case 1:
                    ratingCompat = newHeartRating(((Rating) obj).hasHeart());
                    break;
                case 2:
                    ratingCompat = newThumbRating(((Rating) obj).isThumbUp());
                    break;
                case 3:
                case 4:
                case 5:
                    ratingCompat = newStarRating(ratingStyle, ((Rating) obj).getStarRating());
                    break;
                case 6:
                    ratingCompat = newPercentageRating(((Rating) obj).getPercentRating());
                    break;
                default:
                    return null;
            }
        } else {
            ratingCompat = newUnratedRating(ratingStyle);
        }
        ratingCompat.mRatingObj = obj;
        return ratingCompat;
    }
}
