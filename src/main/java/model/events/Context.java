package model.events;

import java.util.HashMap;
import java.util.Map;

public class Context {
    private Map<String, String> objects = new HashMap<>();

    public Context() {
    }

    public String get(String key) {
        return this.objects.get(key);
    }

    public void put(String key, String value) {
        this.objects.put(key, value);
    }

    public Map<String, String> getObjects() {
        return objects;
    }
}
