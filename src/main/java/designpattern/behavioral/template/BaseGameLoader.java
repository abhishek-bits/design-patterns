package designpattern.behavioral.template;

public abstract class BaseGameLoader {

    public void load() {
        byte[] data = loadLocalData();
        createObjects(data);
        downloadAdditionalFiles();
        cleanTempFiles();
        initializeProfiles();
    }

    // We can either go with all abstract methods
    // and let base classes implement the required functionality.
    abstract byte[] loadLocalData();
    abstract void createObjects(byte[] data);
    abstract void downloadAdditionalFiles();
    abstract void initializeProfiles();

    // OR
    // We could either add a default implementation for some of our methods.
    // This will allow us to get rid of code duplication in our subclasses.
    protected void cleanTempFiles() {
        System.out.println("Cleaning temporary files...");
        // Some code...
    }
}
