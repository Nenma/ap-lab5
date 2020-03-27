package ro.uaic.info.pa;

import java.awt.*;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;

public class CatalogUtils {

    public static void save(Catalog catalog) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(catalog.getPath()))) {
            oos.writeObject(catalog);

        } catch (IOException ioe) {
            System.err.println("Unexpected error writing to file!");
        }
    }

    public static Catalog load(String path) throws InvalidCatalogException {
        Catalog catalog = new Catalog();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            catalog = (Catalog) ois.readObject();
        } catch (FileNotFoundException fnfe) {
            System.err.println("The file is missing!");
            throw new InvalidCatalogException(fnfe);
        } catch (IOException ioe) {
            System.err.println("Unexpected error reading from file!");
        } catch (ClassNotFoundException e) {
            System.err.println("Could not find specified class!");
        }
        return catalog;
    }

    // incomplete since it only handles the case of documents that can be viewed using the default browser or default text editor
    public static void view(Document doc) {
        Desktop desktop = Desktop.getDesktop();
        try {
            if (doc.getType() == DocumentType.ONLINE_RESOURCE) {
                URI uri = new URI(doc.getLocation());
                desktop.browse(uri);
            } else if (doc.getType() == DocumentType.LOCAL_RESOURCE) {
                desktop.open(new File(doc.getLocation()));
            }
        } catch (URISyntaxException use) {
            System.err.println("Syntax error in URI!");
        } catch (IOException ioe) {
            System.err.println("Unexpected error viewing URI!");
        }
    }
}
