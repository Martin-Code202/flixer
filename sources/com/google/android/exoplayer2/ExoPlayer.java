package com.google.android.exoplayer2;

import com.google.android.exoplayer2.source.MediaSource;
public interface ExoPlayer extends Player {

    public interface ExoPlayerComponent {
        void handleMessage(int i, Object obj);
    }

    void blockingSendMessages(ExoPlayerMessage... exoPlayerMessageArr);

    void prepare(MediaSource mediaSource);

    void sendMessages(ExoPlayerMessage... exoPlayerMessageArr);

    public static final class ExoPlayerMessage {
        public final Object message;
        public final int messageType;
        public final ExoPlayerComponent target;

        public ExoPlayerMessage(ExoPlayerComponent exoPlayerComponent, int i, Object obj) {
            this.target = exoPlayerComponent;
            this.messageType = i;
            this.message = obj;
        }
    }
}
