
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class StringCalculator {

    public StringCalculator(){

    }

    private int countingAdd;

    public int GetCalledCount(){
        return countingAdd;
    }

    public String delimiter(String numbers){
        if(numbers.startsWith("/")){
            String delimiter = "";
            if(numbers.contains("[")){
                int i = numbers.indexOf("[");
                int j = numbers.indexOf("]");
                delimiter = numbers.substring(i+1, j);
                return delimiter;
            }
            else{
                delimiter = numbers.charAt(2) + "";
                return delimiter;
            }   
        }
        else{
            return ",";
        } 
    }

   public Map<String, Integer> extractDelimiters(String numbers) {
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < numbers.length(); i++) {
            char aux = numbers.charAt(i);

            if (aux == '[') {
                String out = "";
                int j = i + 1; 
                while (numbers.charAt(j) != ']') {
                    out += numbers.charAt(j);
                    j++;
                }
                map.put(out, out.length()); 
                i = j;
            }
        }

        return map;
    }
    
    public int add(String numbers){

        countingAdd++;

        if(numbers.isEmpty()) return 0;
        
        if(numbers.length() == 1) return stringToInt(numbers);
        
        String delimiter = delimiter(numbers);

        int n = delimiter.length();

        if(numbers.startsWith("/")){
            numbers = noLinesDelimiter(numbers, delimiter, n);
        }
        else{
            numbers = noLines(numbers);
        }

        return add1(numbers,delimiter,n);

    }

    public int add1(String numbers, String delimiter, int n) {
        int result = 0;
        int i = 0;
        int j = 0;
        String negatives = "";

        while (j <= numbers.length() - n) {
            if (numbers.substring(j, j + n).equals(delimiter)) {
                String aux = numbers.substring(i, j);
                if (!aux.isEmpty()) {
                    int value = stringToInt(aux);
                    if (value < 0) {
                        negatives += value + " ";
                    } else if (value <= 1000) {
                        result += value;
                    }
                }
                i = j + n;
                j = i;     
            } else {
                j++;      
            }
        }
        if (i < numbers.length()) {
            String aux = numbers.substring(i);
            if (!aux.isEmpty()) {
                int value = stringToInt(aux);
                if (value < 0) {
                    negatives += value + " ";
                } else if (value <= 1000) {
                    result += value;
                }
            }
        }

        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("Negatives not allowed, the numbers were: " + negatives);
        }

        return result;
    }

    public int stringToInt(String aux) {
        return Integer.parseInt(aux);
    }

    public String noLines(String numbers){

        Stream<String> noLines = numbers.lines();
        Iterable<String> iterable = noLines::iterator;
        String b = "";

        for(String a: iterable){
            b += a; 
            b += ",";        
        }

        return b.substring(0,b.length()-1);
    }


    public String noLinesDelimiter(String numbers, String delimiter, int n){

        Stream<String> noLines = numbers.lines();
        Iterable<String> iterable = noLines::iterator;
        String b = "";
        boolean first = true;
        for (String a : iterable) {
            if (first) {
                first = false;
                continue; 
            }
            b += a;
            b += delimiter;
        }

        return b.substring(0,b.length()-n);
    }
}
