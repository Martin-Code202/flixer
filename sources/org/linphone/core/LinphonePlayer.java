package org.linphone.core;
public interface LinphonePlayer {
    void close();

    int getCurrentPosition();

    int getDuration();

    State getState();

    int open(String str);

    int pause();

    int seek(int i);

    int start();

    public enum State {
        closed,
        paused,
        playing;

        public static State fromValue(int i) {
            if (i == 0) {
                return closed;
            }
            if (i == 1) {
                return paused;
            }
            if (i == 2) {
                return playing;
            }
            return null;
        }
    }
}
