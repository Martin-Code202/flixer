package o;

import io.realm.RealmModel;
/* renamed from: o.〱  reason: contains not printable characters */
public class C1069 implements AbstractC1261 {

    /* renamed from: ˋ  reason: contains not printable characters */
    public static final AbstractC1261 f15227 = new C1069();

    private C1069() {
    }

    @Override // o.AbstractC1261
    /* renamed from: ˎ  reason: contains not printable characters */
    public Class<? extends RealmModel> mo16141(String str, boolean z) {
        char c = 65535;
        switch (str.hashCode()) {
            case -1148592758:
                if (str.equals("flatGenre")) {
                    c = 1;
                    break;
                }
                break;
            case -1097180568:
                if (str.equals("lolomo")) {
                    c = 0;
                    break;
                }
                break;
            case -1068259517:
                if (str.equals("movies")) {
                    c = '\b';
                    break;
                }
                break;
            case -632946216:
                if (str.equals("episodes")) {
                    c = '\n';
                    break;
                }
                break;
            case -582369019:
                if (str.equals("topGenres")) {
                    c = 2;
                    break;
                }
                break;
            case 102982549:
                if (str.equals("lists")) {
                    c = 6;
                    break;
                }
                break;
            case 109413654:
                if (str.equals("shows")) {
                    c = '\t';
                    break;
                }
                break;
            case 347140875:
                if (str.equals("lolomos")) {
                    c = 5;
                    break;
                }
                break;
            case 479193064:
                if (str.equals("similars")) {
                    c = '\f';
                    break;
                }
                break;
            case 646493377:
                if (str.equals("genreList")) {
                    c = 3;
                    break;
                }
                break;
            case 960849002:
                if (str.equals("filteredGenreList")) {
                    c = 4;
                    break;
                }
                break;
            case 1245424234:
                if (str.equals("characters")) {
                    c = 7;
                    break;
                }
                break;
            case 1276055968:
                if (str.equals("trailers")) {
                    c = '\r';
                    break;
                }
                break;
            case 1968370160:
                if (str.equals("seasons")) {
                    c = 11;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                if (z) {
                    return C1145.class;
                }
                return null;
            case 1:
            case 2:
            case 3:
            case 4:
                return C1202.class;
            case 5:
            case 6:
                if (z) {
                    return C1202.class;
                }
                return null;
            case 7:
            case '\b':
            case '\t':
            case '\n':
            case 11:
            case '\f':
            case '\r':
                return C1147.class;
            default:
                return null;
        }
    }
}
