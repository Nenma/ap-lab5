package optional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ro.uaic.info.pa.Catalog;
import ro.uaic.info.pa.InvalidCatalogException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;

/**
 * Offers mainly the same utilities as CatalogUtils, with the notable difference
 * that the catalog is being saved and loaded using a plain text representaion,
 * in this case in JSON format
 */
public class OptionalCatalogUtils {

    private static ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Creates a JSON file representing the Catalog object specified
     * @param catalog Catalog object that gets transformed into a JSON-formatted String and then used
     *                to create an actual JSON file
     */
    public static void save(Catalog catalog) {
        try {
            String catalogJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(catalog);
            Files.write(Paths.get(catalog.getPath()), Collections.singleton(catalogJson));
        } catch (JsonProcessingException jpe) {
            System.err.println("Unexpected error processing JSON!");
        } catch (IOException ioe) {
            System.err.println("Unexpected error writing to file!");
        }
    }

    /**
     * Opens the JSON file specified by the path and returns the Catalog object equivalent to it by casting its
     * contents to the Catalog class
     * @param path the location of the JSON file
     * @return the Catalog object equivalent of the JSON file
     * @throws InvalidCatalogException
     */
    public static Catalog load(String path) throws InvalidCatalogException {
        Catalog catalog = new Catalog();
        try {
            catalog = objectMapper.readValue(new File(path), Catalog.class);
        } catch (IOException ioe) {
            System.out.println("[shell]" + ioe.getMessage());
            throw new InvalidCatalogException(ioe);
        }
        return catalog;
    }
}
