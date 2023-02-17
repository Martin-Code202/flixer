package o;
/* renamed from: o.wk  reason: case insensitive filesystem */
public class C2269wk {
    /* renamed from: ˋ  reason: contains not printable characters */
    public static void m12432(oX oXVar) {
        if (oXVar == null) {
            C1276.m16820().mo5725("PlayContext trackId should not be null !");
            return;
        }
        C1283.m16854("ContentValues", "TrackId Validation:" + oXVar.getTrackId());
        if (oXVar.getTrackId() <= -100) {
            C1276.m16820().mo5725("Empty playContext. trackID is invalid." + oXVar.getTrackId() + " " + oXVar.mo9593());
        }
    }
}
