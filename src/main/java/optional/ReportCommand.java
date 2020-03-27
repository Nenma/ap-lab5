package optional;

import org.apache.commons.io.FileUtils;
import ro.uaic.info.pa.Catalog;
import ro.uaic.info.pa.Document;

import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * Command subclass where the execute method creates a new HTML file using the
 * template.html file by replacing the placeholders denoted by '$' with
 * information about the documents of the catalog
 */
public class ReportCommand extends Command{

    public ReportCommand() {
        super();
    }

    public ReportCommand(Catalog catalog) {
        super(catalog);
    }

    @Override
    void execute() {
        File htmlTemplateFile = new File("src/main/java/optional/templates/template.html");
        String htmlString = "";
        try {
            htmlString = FileUtils.readFileToString(htmlTemplateFile, "UTF-8");
            htmlString = htmlString.replace("$catalog", catalog.getName());
            htmlString = htmlString.replace("$body", parseCatalogDocuments(catalog));
            File newHtmlFile = new File(".\\report.html");
            FileUtils.writeStringToFile(newHtmlFile, htmlString, "UTF-8");
            System.out.println("[shell] Report HTML file created!");
        } catch (IOException ioe) {
            System.out.println("[shell] " + ioe.getMessage());
        }
    }

    /**
     * Creates a HTML-formatted String containing information about the documents inside the specified Catalog object
     * @param catalog Catalog object that is being walked through in order to find details about its documents
     * @return the HTML-formatted String containing document details
     */
    private String parseCatalogDocuments(Catalog catalog) {
        StringBuilder body = new StringBuilder();
        for (Document doc : catalog.getDocuments()) {
            body.append("<h4>").append(doc.getName()).append("</h4>");
            body.append("<ul>");
            body.append("<li>").append("<strong>ID</strong>: ").append(doc.getId()).append("</li>");
            body.append("<li>").append("<strong>Type</strong>: ").append(doc.getType()).append("</li>");
            body.append("<li>").append("<strong>Location</strong>: ").append(doc.getLocation()).append("</li>");
            body.append("<ul>");
            for (Map.Entry<String, Object> tag : doc.getTags().entrySet()) {
                body.append("<li>").append("<strong>").append(tag.getKey()).append("</strong>: ").append(tag.getValue()).append("</li>");
            }
            body.append("</ul>");
            body.append("</ul>");
        }
        return body.toString();
    }
}
