package designpattern.behavioral.template;

// World of Warcraft Game Load specific behavior
public class WorldOfWarcraftLoader extends BaseGameLoader {
    @Override
    byte[] loadLocalData() {
        System.out.println("Loading local WoW files...");
        // Some warcraft code...
        return new byte[0];
    }

    @Override
    void createObjects(byte[] data) {
        System.out.println("Creating WoW objects...");
        // Some warcraft code...
    }

    @Override
    void downloadAdditionalFiles() {
        System.out.println("Downloading WoW additional files...");
        // Some warcra
    }

    @Override
    void initializeProfiles() {

    }
}
