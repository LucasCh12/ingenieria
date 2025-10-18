public class FizzBuzz {

    private static int MAX = 100;

    public FizzBuzz(){

    }

    public boolean isFizz(int x) {
        return x % 3 == 0;
    }

    public boolean isBuzz(int x) {
        return x % 5 == 0;
    }

    public boolean contains3(int x){
        return Integer.toString(x).contains("3");
    }

    public boolean contains5(int x){
        return Integer.toString(x).contains("5");
    }

    public boolean isNumber(int x){
        return x % 5 != 0 && x % 3 != 0;
    }

    public String fizzBuzzOutputI(int x) {

        String aux = "";

        if(contains3(x) && x != 3) aux += "Fizz";

        if(contains5(x) && x != 5) aux += "Buzz";

        if(isFizz(x)) aux += "Fizz";

        if(isBuzz(x)) aux += "Buzz";

        if(aux.length() == 0) return Integer.toString(x);

        return aux;
        

    }

    public static void main(String[] args) {
        FizzBuzz f = new FizzBuzz();
        int i = 1;
        while(i < FizzBuzz.MAX) {
            System.out.println(f.fizzBuzzOutputI(i));
            i = i+1;
        }
    }
}