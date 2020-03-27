package ro.uaic.info.pa;

import optional.NonExistentDocumentException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Catalog implements Serializable {

    private String name;
    private String path;
    private List<Document> documents;

    public Catalog() {
        name = "Default Catalog";
        path = ".\\default.ser";
        documents = new ArrayList<>();
    }

    public Catalog(String name, String path) {
        this.name = name;
        this.path = path;
        documents = new ArrayList<>();
    }

    public void add(Document doc) {
        documents.add(doc);
    }

    public Document findById(String id) throws NonExistentDocumentException{
        for (Document doc : documents) {
            if (doc.getName().equals(name)) {
                return doc;
            }
        }
        throw new NonExistentDocumentException();
    }

    public Document findByName(String name) throws NonExistentDocumentException{
        for (Document doc : documents) {
            if (doc.getName().equals(name)) {
                return doc;
            }
        }
        throw new NonExistentDocumentException();
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "name='" + name + '\'' +
                ", path='" + path + '\'' +
                ", documents=" + documents +
                '}';
    }
}
