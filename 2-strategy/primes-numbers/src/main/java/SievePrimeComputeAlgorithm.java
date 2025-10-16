import java.util.Arrays;

public class SievePrimeComputeAlgorithm implements ComputePrimeAlgorithm {
    
    @Override
    public String computeNPrimes(int n) {
        if (n <= 0) return "[]";

        int limit = (n < 6) ? 15 : (int)(n * (Math.log(n) + Math.log(Math.log(n))) * 2);

        boolean[] isPrime = new boolean[limit + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i <= limit; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= limit; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        
        return stringOut(isPrime, n);
    }

    private String stringOut(boolean[] isPrime, int n){
        StringBuilder out = new StringBuilder("[");
        int count = 0;

        for (int i = 2; count < n; i++) {
            if (isPrime[i]) {
                if(out.length() > 1) out.append(",");
                out.append(i);
                count++;
            }
        }   

        out.append("]");
        return out.toString();    
    }

}
