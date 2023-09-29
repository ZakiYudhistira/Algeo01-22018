package Functions;
import Matrix.Matrix;
import Functions.SPL;

public class regresi {
    public static double[] solusi_regresi;

    public static Matrix normalEstEq(Matrix m) {
        double[][] data_hasil = new double[m.collumns][m.collumns+1];
        Matrix mnew = new Matrix(data_hasil, m.row+1, m.collumns+1);

        int i, j;
        for (i=0; i<mnew.row; i++) {
            for (j=0; j<mnew.collumns; j++) {
                if (i==0 && j==0) {
                    mnew.setELMT(i, j, (double) m.row);
                } else if (i==0 && j!= 0) {
                    mnew.setELMT(i, j, Matrix.sumColumnWithoutOP(m, j));
                } else if (i!=0 && j==0) {
                    mnew.setELMT(i, j, Matrix.sumColumnWithoutOP(m, j));
                } else {
                    mnew.setELMT(i, j, Matrix.sumColumnWithOp(m, i, j));
                }
            }
        }

        return mnew;
    }

    public static void solusiRegresi(Matrix m, double x) {
        
    }

}
