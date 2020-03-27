package optional;

import ro.uaic.info.pa.Catalog;
import ro.uaic.info.pa.InvalidCatalogException;

public class LoadCommand extends Command{

    public LoadCommand() {
        super();
    }

    public LoadCommand(Catalog catalog) {
       super(catalog);
    }

    @Override
    public void execute() {
        System.out.print("[shell] Enter the location of the catalog you want to load: ");
        String path = input.nextLine();
        try {
            catalog = OptionalCatalogUtils.load(path);
        } catch (InvalidCatalogException ice) {
            System.out.println("[shell] " + ice.getMessage());
        }
    }
}
