package model.events;

import model.profiles.ProfileSnapshotWrapper;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Context {
    private String eventType;
    private ProfileSnapshotWrapper profileSnapshot;
    private ProfileSnapshotWrapper currentNode;
    private List<String> currentNodePath;
    private List<String> eventChain = new LinkedList<>();
    private Map<String, String> objects;

    @Override
    public String toString() {
        return "Context{" +
                "eventType='" + eventType + '\'' +
                ", profileSnapshot=" + profileSnapshot +
                ", currentNode=" + currentNode +
                ", currentNodePath=" + currentNodePath +
                ", eventChain=" + eventChain +
                ", objects=" + objects +
                '}';
    }

    public Context() {
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public ProfileSnapshotWrapper getProfileSnapshot() {
        return profileSnapshot;
    }

    public void setProfileSnapshot(ProfileSnapshotWrapper profileSnapshot) {
        this.profileSnapshot = profileSnapshot;
    }

    public ProfileSnapshotWrapper getCurrentNode() {
        return currentNode;
    }

    public void setCurrentNode(ProfileSnapshotWrapper currentNode) {
        this.currentNode = currentNode;
    }

    public List<String> getCurrentNodePath() {
        return currentNodePath;
    }

    public void setCurrentNodePath(List<String> currentNodePath) {
        this.currentNodePath = currentNodePath;
    }

    public List<String> getEventChain() {
        return eventChain;
    }

    public void setEventChain(List<String> eventChain) {
        this.eventChain = eventChain;
    }
}
