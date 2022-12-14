public class Polynomial {
    private Complex[] coeffs;
  
    /**
     * Construct a Polynomial object with the given coefficients.
     *
     * @param _coeffs The coefficients of the polynomial.
     */
    public Polynomial(Complex[] _coeffs) {
      int size = _coeffs.length;
      coeffs = new Complex[size];
      for (int i = 0; i < size; i++) {
        coeffs[i] = _coeffs[i];
      }
    }
    
    /**
     * Get the coefficients of this polynomial.
     *
     * @return The coefficients of this polynomial.
     */
    public Complex[] getCoeffs() {
      return coeffs;
    }
  
    /**
     * Multiply this polynomial by another.
     *
     * @param other The polynomial to multiply by.
     * @return The result of multiplying this polynomial by the other polynomial.
     */
    public Polynomial mult(Polynomial other) {
      int size = coeffs.length + other.coeffs.length - 1;
      Complex[] result = new Complex[size];
      for (int i = 0; i < size; i++) {
        result[i] = new Complex(0, 0);
      }
  
      for (int i = 0; i < coeffs.length; i++) {
        for (int j = 0; j < other.coeffs.length; j++) {
          result[i + j] = result[i + j].add(coeffs[i].mult(other.coeffs[j]));
          // System.out.println("coeffs[i].mult(other.coeffs[j])=" +
          // coeffs[i].mult(other.coeffs[j]) + " i=" + i + " j=" + j + " result[i+j]=" +
          // result[i+j] + " coeffs[i]=" + coeffs[i] + " other.coeffs[j]=" +
          // other.coeffs[j] + "");
        }
      }
  
      return new Polynomial(result);
    }

    /**
     * Evaluate this polynomial at a given complex value.
     * 
     * @param x The complex value to evaluate at.
     * @return The value of this polynomial at the given complex value.
     */
    public Complex evaluate(Complex x) {
      Complex out = new Complex(0, 0);
      for (int i = 0; i < coeffs.length; i++) {
        out = out.add(coeffs[i].mult(x.exp(i)));
      }
      return out;
    }
  
    /**
     * Evaluate if this polynomial is equal to another.
     * 
     * @param other The other polynomial to compare to.
     * @return True if the two polynomials are equal, false otherwise.
     */
    public boolean equals(Polynomial other) {
      if (coeffs.length != other.coeffs.length) {
        return false;
      }
  
      for (int i = 0; i < coeffs.length; i++) {
        if (coeffs[i].real != other.coeffs[i].real || coeffs[i].imag != other.coeffs[i].imag) {
          return false;
        }
      }
  
      return true;
    }
  
    /**
     * Evaluate this polynomial at all of the complex values in the given array.
     * 
     * @param v The array of complex values to evaluate at.
     * @return The array of values of this polynomial at the given complex values.
     */
    public Complex[] evaluateAll(Complex[] v) {
      Complex[] out = new Complex[v.length];
      for (int i = 0; i < v.length; i++) {
        out[i] = evaluate(v[i]);
      }
      return out;
    }
  
    public String toString() {
      String out = "";
      for (int i = 0; i < coeffs.length; i++) {
        out += "(" + coeffs[i] + ")" + "x^" + i + " + ";
      }
      return out;
    }
  }
  