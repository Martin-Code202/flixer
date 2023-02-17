package o;

import com.netflix.mediaclient.acquisition.viewmodels.SignupConstants;
import io.realm.DynamicRealm;
import io.realm.FieldAttribute;
import io.realm.RealmMigration;
import io.realm.RealmObjectSchema;
import io.realm.RealmSchema;
/* renamed from: o.qk  reason: case insensitive filesystem */
public class C2090qk implements RealmMigration {
    @Override // io.realm.RealmMigration
    public void migrate(DynamicRealm dynamicRealm, long j, long j2) {
        RealmSchema schema = dynamicRealm.getSchema();
        if (j == 1) {
            C1283.m16854("RealmOfflineMigration", "Migrating from " + j);
            C1283.m16854("RealmOfflineMigration", "Creating RealmIncompleteVideoDetails");
            schema.create("RealmIncompleteVideoDetails").addField("playableId", String.class, new FieldAttribute[0]).addPrimaryKey("playableId").addField("videoType", Integer.TYPE, new FieldAttribute[0]).addField("profileId", String.class, new FieldAttribute[0]);
            j++;
        }
        if (j == 2) {
            C1283.m16854("RealmOfflineMigration", "Migrating from " + j);
            C1283.m16854("RealmOfflineMigration", "updating season details");
            schema.get("RealmSeason").renameField(SignupConstants.Field.LABEL, "title");
            j++;
        }
        if (j == 3) {
            C1283.m16854("RealmOfflineMigration", "Migrating from " + j);
            schema.get("RealmPlayable").addField("isPreviewProtected", Boolean.TYPE, new FieldAttribute[0]);
            j++;
        }
        if (j == 4) {
            C1283.m16854("RealmOfflineMigration", "Migrating from " + j);
            schema.get("RealmVideoDetails").removeField("isVideo3D");
            j++;
        }
        if (j == 5) {
            C1283.m16851("RealmOfflineMigration", "Migrating from %s (removing star rating)", Long.valueOf(j));
            schema.get("RealmVideoDetails").removeField("userRating").removeField("predictedRating");
            j++;
        }
        if (j == 6) {
            C1283.m16851("RealmOfflineMigration", "Migrating from %s (adding preplay support)", Long.valueOf(j));
            schema.get("RealmPlayable").addField("supportsPrePlay", Boolean.TYPE, new FieldAttribute[0]);
            j++;
        }
        if (j == 7) {
            C1283.m16851("RealmOfflineMigration", "Migrating from %s (adding episodeNumberHidden flag)", Long.valueOf(j));
            schema.get("RealmPlayable").addField("episodeNumberHidden", Boolean.TYPE, new FieldAttribute[0]);
            j++;
        }
        if (j == 8) {
            C1283.m16851("RealmOfflineMigration", "Migrating from %s (adding realm watched support for smart downloads)", Long.valueOf(j));
            C1283.m16854("RealmOfflineMigration", "Creating RealmWatchedEpisode");
            RealmObjectSchema addField = schema.create("RealmWatchedEpisode").addField("episodeId", String.class, new FieldAttribute[0]).addPrimaryKey("episodeId").addField("showId", String.class, new FieldAttribute[0]).addField("seasonNumber", Integer.TYPE, new FieldAttribute[0]).addField("episodeNumber", Integer.TYPE, new FieldAttribute[0]);
            C1283.m16854("RealmOfflineMigration", "Creating RealmWatchedShow");
            schema.create("RealmWatchedShow").addField("showId", String.class, new FieldAttribute[0]).addPrimaryKey("showId").addRealmListField("watchedEpisodes", addField);
            j++;
        }
        if (j == 9) {
            C1283.m16851("RealmOfflineMigration", "Migrating from %s (adding RealmWatchedEpisode#episodeSmartDownloadedId String)", Long.valueOf(j));
            schema.get("RealmWatchedEpisode").addField("episodeSmartDownloadedId", String.class, new FieldAttribute[0]);
            j++;
        }
        if (j == 10) {
            C1283.m16851("RealmOfflineMigration", "Migrating from %s (adding RealmVideoDetails#nextEpisodeId String)", Long.valueOf(j));
            schema.get("RealmVideoDetails").addField("nextEpisodeId", String.class, new FieldAttribute[0]);
            j++;
        }
        if (j == 11) {
            C1283.m16851("RealmOfflineMigration", "Migrating from %s (removing RealmPlayable#isExemptFromLimit String)", Long.valueOf(j));
            schema.get("RealmPlayable").removeField("isExemptFromLimit");
            j++;
        }
        if (j != j2) {
            throw new RuntimeException("you missed a migration. oldVersion is " + j + " and should be " + j2);
        }
        C1283.m16854("RealmOfflineMigration", "Migrating to " + j);
    }
}
