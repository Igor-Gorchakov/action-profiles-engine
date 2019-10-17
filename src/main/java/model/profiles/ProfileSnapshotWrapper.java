package model.profiles;

import java.util.ArrayList;
import java.util.List;

public class ProfileSnapshotWrapper {
    private String id;
    private ProfileType type;
    private List<ProfileSnapshotWrapper> children = new ArrayList<>();

    public String getId() {
        return id;
    }

    public ProfileSnapshotWrapper withId(String id) {
        this.id = id;
        return this;
    }

    public ProfileType getType() {
        return type;
    }

    public ProfileSnapshotWrapper withType(ProfileType type) {
        this.type = type;
        return this;
    }

    public List<ProfileSnapshotWrapper> getChildren() {
        return children;
    }

    public ProfileSnapshotWrapper withChildProfile(ProfileSnapshotWrapper child) {
        this.children.add(child);
        return this;
    }
}
