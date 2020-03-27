package optional;

import ro.uaic.info.pa.*;

import java.io.File;
import java.util.Scanner;

/**
 * Main class running the basic functionalities specified in the Optional tasks
 */
public class OptionalLab5 {

    private static Scanner input = new Scanner(System.in);
    private static Catalog catalog;

    public static void main(String[] args) {
        System.out.println("Welcome to the Catalog Shell! Enter 'start' to begin...");

        testCreateSave();
        String command = startingLoop();
        boolean catalogLoaded = false;

        while (!command.equals("exit")) {
            System.out.print("[shell] ");
            command = input.nextLine();

            if (command.equals("load")) {
                LoadCommand loadCommand = new LoadCommand();
                loadCommand.execute();
                catalog = loadCommand.getCatalog();
                catalogLoaded = true;
            }
            else if (command.equals("unload")) {
                catalogLoaded = false;
            }
            else if (command.equals("list") && catalogLoaded) {
                ListCommand listCommand = new ListCommand(catalog);
                listCommand.execute();
            }
            else if (command.equals("view") && catalogLoaded) {
                ViewCommand viewCommand = new ViewCommand(catalog);
                viewCommand.execute();
            }
            else if (command.equals("report") && catalogLoaded) {
                ReportCommand reportCommand = new ReportCommand(catalog);
                reportCommand.execute();
            }
            else if ((command.equals("list") || command.equals("view") || command.equals("report")) && !catalogLoaded) {
                System.out.println("[shell] You need to load a catalog first!");
            }
            else if (command.equals("help")) {
                printHelpCommands();
            }
            else if (command.equals("exit")) {
                catalogLoaded = false;
                System.out.println("[shell] Exiting...");
            }
            else {
                System.out.println("[shell] Not a valid command! Refer to 'help' for available commands.");
            }
        }
    }

    private static String startingLoop() {
        String command = "";
        boolean started = false;
        while (!started) {
            command = input.nextLine();
            if (command.equals("start")) {
                started = true;
            } else {
                System.out.println("You can only enter 'start' in order to begin!");
            }
        }
        return command;
    }

    private static void printHelpCommands() {
        System.out.println("[shell] The available commands are:");
        System.out.println("\t-load : load one of the available catalogs");
        System.out.println("\t-unload : unload currently selected catalog");
        System.out.println("\t-list : print details about all the documents in a loaded catalog");
        System.out.println("\t-view : open a loaded catalog's specified document");
        System.out.println("\t-report : creates a HTML report representing the content of the loaded catalog");
        System.out.println("\t-exit : exit the shell");
    }

    /**
     * Creates a dummy Catalog to be used for testing in the Main class
     */
    private static void testCreateSave() {
        Catalog catalog = new Catalog("Java Resources", ".\\catalog.json");
        Document doc1 = new Document("java1", "Java Course 1", DocumentType.ONLINE_RESOURCE, "https://profs.info.uaic.ro/~acf/java/slides/en/intro_slide_en.pdf");
        doc1.addTag("type", "Slides");
        File text1 = new File(".\\test.txt");
        Document doc2 = new Document("text1", "Test Text File", DocumentType.LOCAL_RESOURCE, ".\\test.txt");
        doc2.addTag("type", "Text");
        catalog.add(doc1);
        catalog.add(doc2);
        OptionalCatalogUtils.save(catalog);
    }
}
