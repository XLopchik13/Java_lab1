public class Matrix {
    private final Complex[][] matrix_main;
    private final int row;
    private final int col;

    public Matrix(double[][] arr) {
        row = arr.length;
        col = arr[0].length / 2;
        matrix_main = new Complex[row][col];
        for (int i = 0; i < arr.length; i++) {
            int ind = 0;
            for (int j = 0; j < arr[i].length; j += 2) {
                Complex new_num = new Complex(arr[i][j], arr[i][j + 1]);
                matrix_main[i][ind] = new_num;
                ind += 1;
            }
        }
    }

    public Matrix(int new_row, int new_col) {
        row = new_row;
        col = new_col;
        matrix_main = new Complex[row][col];
    }

    public void mat_print() {
        for (int i = 0; i < this.row; i++) {
            System.out.print("|");
            for (int j = 0; j < this.col; j++) {
                this.matrix_main[i][j].com_print();
                if (j != this.col - 1) {
                    System.out.print("  |  ");
                }
            }
            System.out.println("|");
        }
    }

    public Matrix plus(Matrix b)  {
        Matrix a = this;
        if(a.row == b.row && a.col == b.col){
            Matrix tmp = new Matrix(this.row, this.col);
            for (int i = 0; i < tmp.row; i++) {
                for(int j = 0; j < tmp.col; j++){
                    tmp.matrix_main[i][j] = a.matrix_main[i][j].plus(b.matrix_main[i][j]);
                }
            }
            return tmp;
        }
        else{
            System.out.println("error, matrices must be the same size");
            return null;
        }
    }

    public Matrix minus(Matrix b) {
        Matrix a = this;
        if(a.row == b.row && a.col == b.col){
            Matrix tmp = new Matrix(this.row, this.col);
            for (int i = 0; i < tmp.row; i++) {
                for(int j = 0; j < tmp.col; j++){
                    tmp.matrix_main[i][j] = a.matrix_main[i][j].minus(b.matrix_main[i][j]);
                }
            }
            return tmp;
        }
        else{
            System.out.println("error, matrices must be the same size");
            return null;
        }
    }

    public Matrix times(Matrix b) {
        Matrix a = this;
        if(a.col == b.row){
            Matrix tmp = new Matrix(this.row, this.col);
            for (int i = 0; i < a.row; i++) {
                Complex elem = new Complex(0, 0);
                for(int j = 0; j < b.col; j++){
                    for(int k = 0; k < b.row; k++){
                        elem = elem.plus(a.matrix_main[i][k].times(b.matrix_main[k][j]));
                    }
                    tmp.matrix_main[i][j] = elem;
                }
            }
            return tmp;
        }
        else{
            System.out.println("error, matrices must be the same size");
            return null;
        }
    }

    public Complex determinant(int dim) {
        Matrix a = this;
        if (a.row != a.col) {
            System.out.println("error, row should equal col");
            return null;
        }
        if (dim == 1) {
            return a.matrix_main[0][0];
        } else if (dim == 2) {
            return (matrix_main[0][0].times(matrix_main[1][1])).minus(matrix_main[1][0].times(matrix_main[0][1]));
        }

        Complex answer = new Complex(0, 0);
        int sign = 1;
        for (int i = 0; i < dim; i++) {
            Matrix sub_matrix = new Matrix(dim - 1, dim - 1);
            for (int j = 1; j < dim; j++) {
                int col_index = 0;
                for (int k = 0; k < dim; k++) {
                    if (k != i) {
                        sub_matrix.matrix_main[j - 1][col_index] = matrix_main[j][k];
                        col_index++;
                    }
                }
            }
            Complex degree = new Complex(sign, 0);
            answer = answer.plus((degree.times(matrix_main[0][i])).times(sub_matrix.determinant(dim - 1)));
            sign *= -1;
        }
        return answer;
    }
}
