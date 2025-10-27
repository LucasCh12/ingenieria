package testing.partition.practico.ejercicio4;

public class Calculator {
    

    public static int calculator(int n1, int n2, char operation) {
        switch (operation) {
            case '+':
                return n1 + n2;
            case '-':
                return n1 - n2;
            case '*':
                return n1 * n2;
            case '/':
                if (n2 == 0) {
                    throw new IllegalArgumentException("The second number can't be zero in division");
                }
                return n1 / n2;
            default:
                throw new IllegalArgumentException("Invalid operation: " + operation);
        }
    }
}
