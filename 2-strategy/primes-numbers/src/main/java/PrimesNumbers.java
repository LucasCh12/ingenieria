
public class PrimesNumbers {
    
    ComputePrimeAlgorithm algorithm;

    Output output;

    Input input;

    public PrimesNumbers(ComputePrimeAlgorithm algorithm){this.algorithm = algorithm;}

    public void setAlgorithm(ComputePrimeAlgorithm algorithm) {this.algorithm = algorithm;}

    public void setOutput(Output output) {this.output = output;}

    public void setInput(Input input) {this.input = input;}

    public String performAlgorithm(int n) {return algorithm.computeNPrimes(n);}

    public String performInput() {return input.getInput();}

    public void performOutput(int n) {
        output.showOutput(algorithm.computeNPrimes(n));
    }

    public static void main(String[] args) {
        ComputePrimeAlgorithm alg = new BasicPrimeComputeAlgorithm();
        Output output1 = new ScreenDisplayOutput();
        Output output2 = new SaveFileOutput();
        PrimesNumbers prim = new PrimesNumbers(alg);
        prim.setOutput(output1);
        prim.performOutput(10);
        prim.setOutput(output2);
        prim.performOutput(10);
        prim.performOutput(15);
    }

}
