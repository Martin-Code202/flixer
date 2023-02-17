package o;

import com.netflix.mediaclient.servicemgr.interface_.user.ProfileType;
/* renamed from: o.qj  reason: case insensitive filesystem */
public interface AbstractC2089qj {
    String getAvatarUrl();

    String getGeoCountry();

    String[] getLanguages();

    String getLanguagesInCsv();

    String getProfileGuid();

    String getProfileName();

    ProfileType getProfileType();

    boolean isAutoPlayEnabled();

    boolean isDefaultKidsProfile();

    boolean isKidsProfile();

    boolean isPrimaryProfile();
}
