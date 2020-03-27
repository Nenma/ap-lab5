package optional;

import ro.uaic.info.pa.Catalog;

public class ListCommand extends Command{

    public ListCommand() {
        super();
    }

    public ListCommand(Catalog catalog) {
        super(catalog);
    }

    @Override
    public void execute() {
        System.out.println("[shell] These are the documents in this catalog:");
        catalog.getDocuments().forEach(doc -> System.out.println("\t" + doc));
    }
}
