import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SaveFileOutput implements Output {

    @Override
    @SuppressWarnings("CallToPrintStackTrace")
    public void showOutput(String primeNumbers){
        String folderPath = "output"; 
        File folder = new File(folderPath);

        if (!folder.exists()) {
            folder.mkdirs(); 
        }  
        
        String fileName = "primes_" + System.currentTimeMillis() + ".txt";
        String filePath = folderPath + "/" + fileName;

        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write("El resultado fue: " + primeNumbers);
            System.out.println("Archivo creado en: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
