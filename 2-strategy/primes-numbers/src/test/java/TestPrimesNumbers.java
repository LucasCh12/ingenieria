
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.ArgumentCaptor;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TestPrimesNumbers {
    
    @SuppressWarnings("unused")
    static Stream<Arguments> provideNAndExpectedPrimes() {
        return Stream.of(
            Arguments.of(5, "[2,3,5,7,11]"),
            Arguments.of(10, "[2,3,5,7,11,13,17,19,23,29]"),
            Arguments.of(1, "[2]"),
            Arguments.of(0, "[]")
        );
    }

    @ParameterizedTest
    @MethodSource("provideNAndExpectedPrimes")
    public void testBasicPrimeAlgorithmWithDifferentN(int n, String expected) {
        ComputePrimeAlgorithm alg = new BasicPrimeComputeAlgorithm();
        PrimesNumbers prim = new PrimesNumbers(alg);

        assertEquals(expected, prim.performAlgorithm(n));
    }

    @ParameterizedTest
    @MethodSource("provideNAndExpectedPrimes")
    public void testSievePrimeAlgorithmWithDifferentN(int n, String expected) {
        ComputePrimeAlgorithm alg = new SievePrimeComputeAlgorithm();
        PrimesNumbers prim = new PrimesNumbers(alg);

        assertEquals(expected, prim.performAlgorithm(n));
    }

    @ParameterizedTest
    @MethodSource("provideNAndExpectedPrimes")
    public void testSqrtPrimeAlgorithmWithDifferentN(int n, String expected) {
        ComputePrimeAlgorithm alg = new SqrtPrimeComputeAlgorithm();
        PrimesNumbers prim = new PrimesNumbers(alg);

        assertEquals(expected, prim.performAlgorithm(n));
    }

    @SuppressWarnings("unused")
    static Stream<Arguments> providePrimeAlgorithms() {
        return Stream.of(
            Arguments.of(new BasicPrimeComputeAlgorithm(), "[2,3,5,7,11,13,17,19,23,29]"),
            Arguments.of(new SievePrimeComputeAlgorithm(), "[2,3,5,7,11,13,17,19,23,29]"),
            Arguments.of(new SqrtPrimeComputeAlgorithm(), "[2,3,5,7,11,13,17,19,23,29]")
        );
    }

    @ParameterizedTest
    @MethodSource("providePrimeAlgorithms")
    public void testPrimeAlgorithms(ComputePrimeAlgorithm alg, String expected) {
        PrimesNumbers prim = new PrimesNumbers(alg);
        assertEquals(expected, prim.performAlgorithm(10));
    }

    @Test
    public void testScreenDisplayOutput(){
        ComputePrimeAlgorithm alg = new BasicPrimeComputeAlgorithm();
        Output output = new ScreenDisplayOutput();
        PrimesNumbers prim = new PrimesNumbers(alg);
        prim.setOutput(output);
        prim.performOutput(10);
    }

    @Test
    public void testSaveFileOutput(){
        ComputePrimeAlgorithm alg = new BasicPrimeComputeAlgorithm();
        Output output = new SaveFileOutput();
        PrimesNumbers prim = new PrimesNumbers(alg);
        prim.setOutput(output);
        prim.performOutput(10);
    }

    /**
    public void testConsoleInput(){
        ComputePrimeAlgorithm alg = new BasicPrimeComputeAlgorithm();
        Output output = new ScreenDisplayOutput();
        Input console = new ConsoleInput();
        PrimesNumbers prim = new PrimesNumbers(alg);
        prim.setOutput(output);
        prim.setInput(console);
        String inputValue = prim.performInput();
        int n = Integer.parseInt(inputValue);
        assertEquals("[2,3,5,7,11]", prim.performAlgorithm(n));
    }
    */
    
    @Test
    public void testFileInput(){
        ComputePrimeAlgorithm alg = new BasicPrimeComputeAlgorithm();
        Output output = new ScreenDisplayOutput();
        String filePath = "input/input.txt";
        Input file = new FileInput(filePath);
        PrimesNumbers prim = new PrimesNumbers(alg);
        prim.setOutput(output);
        prim.setInput(file);
        String inputValue = prim.performInput();
        int n = Integer.parseInt(inputValue);
        assertEquals("[2,3,5,7,11]", prim.performAlgorithm(n));
    }
    
    @Test
    public void testPerformOutputWithMock() {
 
        Output mockOutput = mock(Output.class);

        ComputePrimeAlgorithm alg = new BasicPrimeComputeAlgorithm();
        PrimesNumbers prim = new PrimesNumbers(alg);

        prim.setOutput(mockOutput);

        prim.performOutput(5);

        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mockOutput).showOutput(captor.capture());

        assertEquals("[2,3,5,7,11]", captor.getValue());
    }

    @Test
    public void testPerformAlgorithmWithMockInput() {
        Input mockInput = mock(Input.class);

        when(mockInput.getInput()).thenReturn("5");

        ComputePrimeAlgorithm alg = new BasicPrimeComputeAlgorithm();
        PrimesNumbers prim = new PrimesNumbers(alg);

        int n = Integer.parseInt(mockInput.getInput());
        String result = prim.performAlgorithm(n);

        assertEquals("[2,3,5,7,11]", result);

        verify(mockInput, times(1)).getInput();
    }


}
