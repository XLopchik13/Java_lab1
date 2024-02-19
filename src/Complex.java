public class Complex {
    private final double re;
    private final double im;

    public Complex(double real, double imaginary) {
        re = real;
        im = imaginary;
    }

    public void com_print() {
        if (this.im >= 0) {
            System.out.printf("%.1f + %.1f * i", re, im);
        }
        else {
            System.out.printf("%.1f - %.1f * i", re, (-1) * im);
        }
    }

    public Complex plus(Complex b) {
        Complex a = this;
        double real = a.re + b.re;
        double imaginary = a.im + b.im;
        return new Complex(real, imaginary);
    }

    public Complex minus(Complex b) {
        Complex a = this;
        double real = a.re - b.re;
        double imaginary = a.im - b.im;
        return new Complex(real, imaginary);
    }


    public Complex times(Complex b) {
        Complex a = this;
        double real = a.re * b.re - a.im * b.im;
        double imaginary = a.re * b.im + a.im * b.re;
        return new Complex(real, imaginary);
    }

    public Complex reciprocal() {
        double scale = re * re + im * im;
        return new Complex(re / scale, -im / scale);
    }

    public Complex divide(Complex b) {
        Complex a = this;
        return a.times(b.reciprocal());
    }
}