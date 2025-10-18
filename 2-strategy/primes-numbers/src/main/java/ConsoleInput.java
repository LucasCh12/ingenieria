import java.util.Scanner;

public class ConsoleInput implements Input {
    
    @SuppressWarnings("resource")
    @Override
    public String getInput(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese un numero: ");
        return scanner.nextLine();
    }
}
