import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileInput implements Input {

    private final String filePath;

    public FileInput(String filePath) {
        this.filePath = filePath;
    }

    @Override
    @SuppressWarnings("CallToPrintStackTrace")
    public String getInput() {
        try {
            return new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}

