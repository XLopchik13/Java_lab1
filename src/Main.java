public class Main {
    public static void main(String[] args)
    {
        Complex COMPLEX1 = new Complex(7, 4);
        Complex COMPLEX2 = new Complex(13, 3);

        Complex com_sum = COMPLEX1.plus(COMPLEX2);
        System.out.print("complex1 + complex2 = ");
        com_sum.com_print();
        System.out.println(" ");

        Complex com_dif = COMPLEX1.minus(COMPLEX2);
        System.out.print("complex1 - complex2 = ");
        com_dif.com_print();
        System.out.println(" ");

        Complex com_mul = COMPLEX1.times(COMPLEX2);
        System.out.print("complex1 * complex2 = ");
        com_mul.com_print();
        System.out.println(" ");

        Complex com_div = COMPLEX1.divide(COMPLEX2);
        System.out.print("complex1 / complex2 = ");
        com_div.com_print();
        System.out.println("\n");


        double[][] MATRIX_ARR1 = {
                {8, 18, 1, 12, 3, 18},
                {19, -16, 14, 14, -10, 10},
                {5, 4, 2, 5, 9, 18} };
        double[][] MATRIX_ARR2 = {
                {6, -3, -11, 17, 14, 4},
                {-5, -9, 7, -18, 20, 4},
                {11, 7, -20, 10, -9, 1}};

        Matrix MATRIX1 = new Matrix(MATRIX_ARR1);
        Matrix MATRIX2 = new Matrix(MATRIX_ARR2);

        System.out.println("matrix1: ");
        MATRIX1.mat_print();
        System.out.println("\nmatrix2: ");
        MATRIX2.mat_print();


        Matrix matrix_sum =  MATRIX1.plus(MATRIX2);
        System.out.println("\nmatrices sum: ");
        if (matrix_sum != null) {
            matrix_sum.mat_print();
        }
        System.out.println(" ");

        Matrix matrix_dif =  MATRIX1.minus(MATRIX2);
        System.out.println("matrices dif: ");
        if (matrix_dif != null) {
            matrix_dif.mat_print();
        }
        System.out.println(" ");

        Matrix matrix_mul =  MATRIX1.times(MATRIX2);
        System.out.println("matrices mul: ");
        if (matrix_mul != null) {
            matrix_mul.mat_print();
        }
        System.out.println(" ");

        Complex matrix_det =  MATRIX1.determinant(3);
        System.out.println("MATRIX1 det: ");
        if (matrix_det != null) {
            matrix_det.com_print();
        }
    }
}
