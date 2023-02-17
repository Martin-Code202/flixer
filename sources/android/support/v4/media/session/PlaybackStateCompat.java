package android.support.v4.media.session;

import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.v4.media.session.PlaybackStateCompatApi21;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
public final class PlaybackStateCompat implements Parcelable {
    public static final Parcelable.Creator<PlaybackStateCompat> CREATOR = new Parcelable.Creator<PlaybackStateCompat>() { // from class: android.support.v4.media.session.PlaybackStateCompat.1
        @Override // android.os.Parcelable.Creator
        public PlaybackStateCompat createFromParcel(Parcel parcel) {
            return new PlaybackStateCompat(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public PlaybackStateCompat[] newArray(int i) {
            return new PlaybackStateCompat[i];
        }
    };
    final long mActions;
    final long mActiveItemId;
    final long mBufferedPosition;
    List<CustomAction> mCustomActions;
    final int mErrorCode;
    final CharSequence mErrorMessage;
    final Bundle mExtras;
    final long mPosition;
    final float mSpeed;
    final int mState;
    private Object mStateObj;
    final long mUpdateTime;

    PlaybackStateCompat(int i, long j, long j2, float f, long j3, int i2, CharSequence charSequence, long j4, List<CustomAction> list, long j5, Bundle bundle) {
        this.mState = i;
        this.mPosition = j;
        this.mBufferedPosition = j2;
        this.mSpeed = f;
        this.mActions = j3;
        this.mErrorCode = i2;
        this.mErrorMessage = charSequence;
        this.mUpdateTime = j4;
        this.mCustomActions = new ArrayList(list);
        this.mActiveItemId = j5;
        this.mExtras = bundle;
    }

    PlaybackStateCompat(Parcel parcel) {
        this.mState = parcel.readInt();
        this.mPosition = parcel.readLong();
        this.mSpeed = parcel.readFloat();
        this.mUpdateTime = parcel.readLong();
        this.mBufferedPosition = parcel.readLong();
        this.mActions = parcel.readLong();
        this.mErrorMessage = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.mCustomActions = parcel.createTypedArrayList(CustomAction.CREATOR);
        this.mActiveItemId = parcel.readLong();
        this.mExtras = parcel.readBundle();
        this.mErrorCode = parcel.readInt();
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder sb = new StringBuilder("PlaybackState {");
        sb.append("state=").append(this.mState);
        sb.append(", position=").append(this.mPosition);
        sb.append(", buffered position=").append(this.mBufferedPosition);
        sb.append(", speed=").append(this.mSpeed);
        sb.append(", updated=").append(this.mUpdateTime);
        sb.append(", actions=").append(this.mActions);
        sb.append(", error code=").append(this.mErrorCode);
        sb.append(", error message=").append(this.mErrorMessage);
        sb.append(", custom actions=").append(this.mCustomActions);
        sb.append(", active item id=").append(this.mActiveItemId);
        sb.append("}");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mState);
        parcel.writeLong(this.mPosition);
        parcel.writeFloat(this.mSpeed);
        parcel.writeLong(this.mUpdateTime);
        parcel.writeLong(this.mBufferedPosition);
        parcel.writeLong(this.mActions);
        TextUtils.writeToParcel(this.mErrorMessage, parcel, i);
        parcel.writeTypedList(this.mCustomActions);
        parcel.writeLong(this.mActiveItemId);
        parcel.writeBundle(this.mExtras);
        parcel.writeInt(this.mErrorCode);
    }

    public int getState() {
        return this.mState;
    }

    public long getPosition() {
        return this.mPosition;
    }

    public float getPlaybackSpeed() {
        return this.mSpeed;
    }

    public long getActions() {
        return this.mActions;
    }

    public long getLastPositionUpdateTime() {
        return this.mUpdateTime;
    }

    public static PlaybackStateCompat fromPlaybackState(Object obj) {
        Bundle bundle;
        if (obj == null || Build.VERSION.SDK_INT < 21) {
            return null;
        }
        List<Object> customActions = PlaybackStateCompatApi21.getCustomActions(obj);
        ArrayList arrayList = null;
        if (customActions != null) {
            arrayList = new ArrayList(customActions.size());
            for (Object obj2 : customActions) {
                arrayList.add(CustomAction.fromCustomAction(obj2));
            }
        }
        if (Build.VERSION.SDK_INT >= 22) {
            bundle = PlaybackStateCompatApi22.getExtras(obj);
        } else {
            bundle = null;
        }
        PlaybackStateCompat playbackStateCompat = new PlaybackStateCompat(PlaybackStateCompatApi21.getState(obj), PlaybackStateCompatApi21.getPosition(obj), PlaybackStateCompatApi21.getBufferedPosition(obj), PlaybackStateCompatApi21.getPlaybackSpeed(obj), PlaybackStateCompatApi21.getActions(obj), 0, PlaybackStateCompatApi21.getErrorMessage(obj), PlaybackStateCompatApi21.getLastPositionUpdateTime(obj), arrayList, PlaybackStateCompatApi21.getActiveQueueItemId(obj), bundle);
        playbackStateCompat.mStateObj = obj;
        return playbackStateCompat;
    }

    public Object getPlaybackState() {
        if (this.mStateObj == null && Build.VERSION.SDK_INT >= 21) {
            ArrayList arrayList = null;
            if (this.mCustomActions != null) {
                arrayList = new ArrayList(this.mCustomActions.size());
                for (CustomAction customAction : this.mCustomActions) {
                    arrayList.add(customAction.getCustomAction());
                }
            }
            if (Build.VERSION.SDK_INT >= 22) {
                this.mStateObj = PlaybackStateCompatApi22.newInstance(this.mState, this.mPosition, this.mBufferedPosition, this.mSpeed, this.mActions, this.mErrorMessage, this.mUpdateTime, arrayList, this.mActiveItemId, this.mExtras);
            } else {
                this.mStateObj = PlaybackStateCompatApi21.newInstance(this.mState, this.mPosition, this.mBufferedPosition, this.mSpeed, this.mActions, this.mErrorMessage, this.mUpdateTime, arrayList, this.mActiveItemId);
            }
        }
        return this.mStateObj;
    }

    public static final class CustomAction implements Parcelable {
        public static final Parcelable.Creator<CustomAction> CREATOR = new Parcelable.Creator<CustomAction>() { // from class: android.support.v4.media.session.PlaybackStateCompat.CustomAction.1
            @Override // android.os.Parcelable.Creator
            public CustomAction createFromParcel(Parcel parcel) {
                return new CustomAction(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public CustomAction[] newArray(int i) {
                return new CustomAction[i];
            }
        };
        private final String mAction;
        private Object mCustomActionObj;
        private final Bundle mExtras;
        private final int mIcon;
        private final CharSequence mName;

        CustomAction(String str, CharSequence charSequence, int i, Bundle bundle) {
            this.mAction = str;
            this.mName = charSequence;
            this.mIcon = i;
            this.mExtras = bundle;
        }

        CustomAction(Parcel parcel) {
            this.mAction = parcel.readString();
            this.mName = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.mIcon = parcel.readInt();
            this.mExtras = parcel.readBundle();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.mAction);
            TextUtils.writeToParcel(this.mName, parcel, i);
            parcel.writeInt(this.mIcon);
            parcel.writeBundle(this.mExtras);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public static CustomAction fromCustomAction(Object obj) {
            if (obj == null || Build.VERSION.SDK_INT < 21) {
                return null;
            }
            CustomAction customAction = new CustomAction(PlaybackStateCompatApi21.CustomAction.getAction(obj), PlaybackStateCompatApi21.CustomAction.getName(obj), PlaybackStateCompatApi21.CustomAction.getIcon(obj), PlaybackStateCompatApi21.CustomAction.getExtras(obj));
            customAction.mCustomActionObj = obj;
            return customAction;
        }

        public Object getCustomAction() {
            if (this.mCustomActionObj != null || Build.VERSION.SDK_INT < 21) {
                return this.mCustomActionObj;
            }
            this.mCustomActionObj = PlaybackStateCompatApi21.CustomAction.newInstance(this.mAction, this.mName, this.mIcon, this.mExtras);
            return this.mCustomActionObj;
        }

        @Override // java.lang.Object
        public String toString() {
            return "Action:mName='" + ((Object) this.mName) + ", mIcon=" + this.mIcon + ", mExtras=" + this.mExtras;
        }
    }

    public static final class Builder {
        private long mActions;
        private long mActiveItemId = -1;
        private long mBufferedPosition;
        private final List<CustomAction> mCustomActions = new ArrayList();
        private int mErrorCode;
        private CharSequence mErrorMessage;
        private Bundle mExtras;
        private long mPosition;
        private float mRate;
        private int mState;
        private long mUpdateTime;

        public Builder() {
        }

        public Builder(PlaybackStateCompat playbackStateCompat) {
            this.mState = playbackStateCompat.mState;
            this.mPosition = playbackStateCompat.mPosition;
            this.mRate = playbackStateCompat.mSpeed;
            this.mUpdateTime = playbackStateCompat.mUpdateTime;
            this.mBufferedPosition = playbackStateCompat.mBufferedPosition;
            this.mActions = playbackStateCompat.mActions;
            this.mErrorCode = playbackStateCompat.mErrorCode;
            this.mErrorMessage = playbackStateCompat.mErrorMessage;
            if (playbackStateCompat.mCustomActions != null) {
                this.mCustomActions.addAll(playbackStateCompat.mCustomActions);
            }
            this.mActiveItemId = playbackStateCompat.mActiveItemId;
            this.mExtras = playbackStateCompat.mExtras;
        }

        public Builder setState(int i, long j, float f) {
            return setState(i, j, f, SystemClock.elapsedRealtime());
        }

        public Builder setState(int i, long j, float f, long j2) {
            this.mState = i;
            this.mPosition = j;
            this.mUpdateTime = j2;
            this.mRate = f;
            return this;
        }

        public Builder setActions(long j) {
            this.mActions = j;
            return this;
        }

        public PlaybackStateCompat build() {
            return new PlaybackStateCompat(this.mState, this.mPosition, this.mBufferedPosition, this.mRate, this.mActions, this.mErrorCode, this.mErrorMessage, this.mUpdateTime, this.mCustomActions, this.mActiveItemId, this.mExtras);
        }
    }
}
