package designpattern.behavioral.template;

// Diablo Game Load specific behavior
public class DiabloLoader extends BaseGameLoader {
    @Override
    byte[] loadLocalData() {
        return new byte[0];
    }

    @Override
    void createObjects(byte[] data) {

    }

    @Override
    void downloadAdditionalFiles() {

    }

    @Override
    void initializeProfiles() {

    }
}
