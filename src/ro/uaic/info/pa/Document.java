package ro.uaic.info.pa;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Document implements Serializable {

    private String id;
    private String name;
    private DocumentType type;
    private String location;
    private Map<String, Object> tags;

    public Document(String id, String name, DocumentType type, String location) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.location = location;
        tags = new HashMap<>();
    }

    public void addTag(String key, Object obj) {
        tags.put(key, obj);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public DocumentType getType() {
        return type;
    }

    public String getLocation() {
        return location;
    }

    public Map<String, Object> getTags() {
        return tags;
    }
}
