# ap-lab5

## Optional

###### Basic functionalities of the Optional tasks have been implemented in [OptionalLab5.class](https://github.com/Nenma/ap-lab5/blob/master/src/main/java/optional/OptionalLab5.java).

The tasks were:
- Implement the *save* and *load* methods using a **plain text** representation of the catalog (instead of binary serialization).
- Create a *shell* that allows reading commands from the keyboard, together with their arguments and implement the commands *load*, *list*, *view*.
- Represent the commands using **classes instead of methods** (create the classes *LoadCommand*, *ListCommand*, etc.). Use an interface or an abstract class in order to desribe a generic command.
- Implement the command *report html*: create an HTML report representing the content of the catalog.
- The application will signal invalid data (duplicate names, invalid paths or URLs, etc.) or invalid commands using *custom exceptions*.
- The final form of the application will be an executable JAR archive. Identify the generated archive and launch the application from the console, using the JAR.

Tasks overview:
- Implemented new *save* and *load* methods that use the representation of a Catalog object in JSON format and a JSON file, respectively
- Created a simple *shells* that accepts the commands: load, unload, list, view, report, exit and help. Their usage is explained in the help dialogue like this:
  -load : load one of the available catalogs
  -unload : unload currently selected catalog
  -list : print details about all the documents in a loaded catalog
  -view : open a loaded catalog's specified document
  -report : creates a HTML report representing the content of the loaded catalog
  -exit : exit the shell
- The abstract class Command was created as a template for: LoadCommand, ListCommand, ViewCommand, ReportCommand. They mainly cover the functionalities mentioned above, but details are specified in their respective javadocs
- The *report* command was implemented such that it first checks for a loaded catalog and only then created a new HTML file named report.html using a template
- The only custom exceptions created are [InvalidCatalogException](https://github.com/Nenma/ap-lab5/blob/master/src/main/java/ro/uaic/info/pa/InvalidCatalogException.java) and [NonExistentDocumentException](https://github.com/Nenma/ap-lab5/blob/master/src/main/java/optional/NonExistentDocumentException.java). They are very simple classes and used quite sparringly...
- The JAR can successfully be created and run using `java -jar Lab5.jar`, but it is dependent on external project files and does not work right...

## Compulsory

###### Main functionalities of the Compulsory tasks have been implemented in [Lab5.class](https://github.com/Nenma/ap-lab5/blob/master/src/main/java/ro/uaic/info/pa/Lab5.java).

The tasks were:
- Create an object-oriented model of the problem. You should have at least the following classes: *Catalog*, *Document*. Consider creating a class responsible with external operations regarding a catalog.
- Implement the following methods:
  - *save*: saves the catalog to an external file, using *object serialization*;
  - *load*: loads the catalog from an external file.
  - *view*: opens a document using the native operating system application (see the Desktop class)
