public class SqrtPrimeComputeAlgorithm implements ComputePrimeAlgorithm {
    
    private boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;

        int limit = (int) Math.sqrt(n);
        
        for (int i = 3; i <= limit; i += 2) {
            if (n % i == 0) return false;
        }

        return true;
    }

    @Override
    public String computeNPrimes(int n) {
        if (n <= 0) return "[]";

        StringBuilder out = new StringBuilder("[");
        int count = 0;
        int i = 2;

        while (count < n) {
            if (isPrime(i)) {
                if (out.length() > 1) out.append(",");
                out.append(i);
                count++;
            }
            i++;
        }

        out.append("]");
        return out.toString();
    }
}
