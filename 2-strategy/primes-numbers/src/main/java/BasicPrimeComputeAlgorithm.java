
public class BasicPrimeComputeAlgorithm implements ComputePrimeAlgorithm {
    
    private boolean isPrim(int n){
        int i = 2;
        while(i < n){
            if(n % i == 0){
                return false;
            }
            i++;
        }
        return true;
    }

    @Override
    public String computeNPrimes(int n){

        if(n == 0) return "[]";  

        if(n == 1) return "[2]";

        StringBuilder out = new StringBuilder("[");
        int i = 2;  
        int count = 0;
        while(count < n){
            if(isPrim(i)){
                out.append(i);
                if(count < n-1) out.append(",");
                count++;
            }
            i++;
        }
        out.append("]");
        return out.toString();
    }

}
