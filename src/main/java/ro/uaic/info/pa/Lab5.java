package ro.uaic.info.pa;

import optional.NonExistentDocumentException;

public class Lab5 {
    public static void main(String[] args) {
        testCreateSave();
        testLoadView();
    }

    private static void testCreateSave() {
        Catalog catalog = new Catalog("Java Resources", ".\\catalog.ser");
        Document doc1 = new Document("java1", "Java Course 1", DocumentType.ONLINE_RESOURCE, "https://profs.info.uaic.ro/~acf/java/slides/en/intro_slide_en.pdf");
        doc1.addTag("type", "Slides");
        Document doc2 = new Document("text1", "Test Text File", DocumentType.LOCAL_RESOURCE, ".\\test.txt");
        doc2.addTag("type", "Text");
        catalog.add(doc1);
        catalog.add(doc2);
        CatalogUtils.save(catalog);
    }

    private static void testLoadView() {
        Catalog catalog = new Catalog();
        try {
            catalog = CatalogUtils.load(".\\catalog.ser");
            Document doc1 = catalog.findById("java1");
            CatalogUtils.view(doc1);
            Document doc2 = catalog.findById("text1");
            CatalogUtils.view(doc2);
        } catch (InvalidCatalogException | NonExistentDocumentException e) {
            e.printStackTrace();
        }
    }
}
