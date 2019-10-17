package model.profiles;

import static model.profiles.ProfileType.ACTION;
import static model.profiles.ProfileType.JOB;
import static model.profiles.ProfileType.MAPPING;
import static model.profiles.ProfileType.MATCH;

public class ProfileSnapshotBuilder {
    public static ProfileSnapshotWrapper build() {
        return new ProfileSnapshotWrapper().withType(JOB).withId("70b7115f-c8e4-444a-9b24-ad290e1eaf12")
                .withChildProfile(new ProfileSnapshotWrapper().withType(MATCH).withId("d6ad7fe5-8103-4c8b-bbd4-f808d845b78b"))
                .withChildProfile(new ProfileSnapshotWrapper().withType(MATCH).withId("905b85cb-4fbc-4a45-8d2f-f1322eaf0629")
                        .withChildProfile(new ProfileSnapshotWrapper().withType(ACTION).withId("6121feb7-59e9-4844-b89a-d3f144aa5fa5")
                                .withChildProfile(new ProfileSnapshotWrapper().withType(MAPPING).withId("435a3472-a17c-44f8-8046-1266d5878379"))))
                .withChildProfile(new ProfileSnapshotWrapper().withType(MATCH).withId("4adf2a46-6939-4095-82a0-f1926ed75609"));
    }
}
