import java.util.Arrays;
import java.util.Scanner;

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
        
        p("Convolution of Input=\n" + Arrays.toString(input) + "\nAnd kernel=\n" + Arrays.toString(kernel) + "\n=\n" + Arrays.toString(convolution));
        p("Polynomial Multiplication Result of two polynomials with coefficients corresponding to those arrays: \n" + Arrays.toString(polyMult.getCoeffs()));

        p("Enter the size of the array to be convolved: ");
        Scanner sc = new Scanner(System.in);
        input = new Complex[sc.nextInt()];
        p("Enter the array values: ");
        for (int i = 0; i < input.length; i++) {
            p("Index " + i + " Real: ");
            int real = sc.nextInt();
            p("Index " + i + " Imaginary: ");
            int imag = sc.nextInt();
            input[i] = new Complex(real, imag);
        }

        p("Enter the size of the kernel: ");
        kernel = new Complex[sc.nextInt()];
        p("Enter the kernel values: ");
        for (int i = 0; i < kernel.length; i++) {
            p("Index " + i + " Real: ");
            int real = sc.nextInt();
            p("Index " + i + " Imaginary: ");
            int imag = sc.nextInt();
            kernel[i] = new Complex(real, imag);
        }

        // Perform convolution and print it out
        convolution = convolve1D(input, kernel);
        p("Convolution Result: \n" + Arrays.toString(convolution));

        
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

    public static void p(Object o) {
        System.out.println(o);
    }
}
