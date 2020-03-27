package optional;

import ro.uaic.info.pa.Catalog;

import java.util.Scanner;

/**
 * Abstract class modeling future Command subclasses that have their main
 * functionality exposed by the execute method
 */
public abstract class Command {
    public Scanner input = new Scanner(System.in);
    public Catalog catalog;

    public Command() {
        catalog = new Catalog();
    }

    public Command(Catalog catalog) {
        this.catalog = catalog;
    }

    abstract void execute();

    public Catalog getCatalog() {
        return catalog;
    }
}
