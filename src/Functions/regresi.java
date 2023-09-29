package Functions;
import Matrix.Matrix;
import Functions.SPL;

public class regresi {
    public static double[] solusi_regresi;

    public static void normalEstEq(Matrix m) {
        int i, j;
        for (i=0; i<m.row; i++) {
            for (j=0; j<m.collumns; j++) {
                m.setELMT(i, j, Matrix.sumColumnWithOp(m, i, j));
            }
        }
        m = Matrix.addCol(m, false);
        m = Matrix.addRow(m, false);
    }

    public static void solusiRegresi(Matrix m, double x) {
        
    }

}
