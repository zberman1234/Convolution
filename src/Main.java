import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Test input and kernel arrays
        Complex[] input = {new Complex(1,0), new Complex(4,0), new Complex(2,0), new Complex(5,0)};
        Complex[] kernel = {new Complex(3, 0), new Complex(4, 0), new Complex(1,0)};

        // Perform convolution
        Complex[] convolution = convolve1D(input, kernel);
        Polynomial in = new Polynomial(input);
        Polynomial ker = new Polynomial(kernel);
        Polynomial polyMult = in.mult(ker);
        
        System.out.println("Convolution Result: \n" + Arrays.toString(convolution));
        System.out.println("Polynomial Multiplication Result: \n" + Arrays.toString(polyMult.getCoeffs()));
        
    }
    /**
     * Perform 1D convolution on two arrays.
     * 
     * @param input The input array.
     * @param kernel The kernel array.
     * @return The result of the convolution.
     */
    public static Complex[] convolve1D(Complex[] input, Complex[] kernel) {
        int inputLength = input.length;
        int kernelLength = kernel.length;

        Complex[] output = new Complex[inputLength + kernelLength - 1];

        for (int i = 0; i < inputLength + kernelLength - 1; i++) {
            output[i] = new Complex(0, 0);

            for (int j = 0; j < kernelLength; j++) {
                if (i - j >= 0 && i - j < inputLength) {
                    output[i] = output[i].add(input[i - j].mult(kernel[j]));
                }
            }
        }

        return output;
    }
}
