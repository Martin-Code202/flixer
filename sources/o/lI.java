package o;

import com.netflix.mediaclient.service.player.streamingplayback.exosessionplayer.reporter.EndPlayJson;
class lI extends EndPlayJson {
    public lI(String str) {
        super("midplay", str);
        this.endReason = EndPlayJson.EndReason.PLAYING;
    }
}
