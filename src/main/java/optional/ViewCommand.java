package optional;

import ro.uaic.info.pa.Catalog;
import ro.uaic.info.pa.CatalogUtils;

/**
 * Command subclass where the execute method does a simple search of the catalog
 * using the name entered by the user and opens an appropriate app to open the
 * found document
 */
public class ViewCommand extends Command{

    public ViewCommand() {
        super();
    }

    public ViewCommand(Catalog catalog) {
        super(catalog);
    }

    @Override
    public void execute() {
        System.out.print("[shell] Enter the name of the document you wish to view: ");
        String name = input.nextLine();
        try {
            CatalogUtils.view(catalog.findByName(name));
        } catch (NonExistentDocumentException nede) {
            System.out.println("[shell] " + nede.getMessage());
        }
    }
}
