package Functions;
import Matrix.Matrix;
import Functions.SPL;

public class regresi {
    public static Matrix solusi_regresi;

    public static Matrix normalEstEq(Matrix m) {
        double[][] data_hasil = new double[m.collumns][m.collumns+1];
        Matrix mnew = new Matrix(data_hasil, m.collumns, m.collumns+1);

        int i, j;
        for (i=0; i<mnew.row; i++) {
            for (j=0; j<mnew.collumns; j++) {
                if (i==0 && j==0) {
                    mnew.setELMT(i, j, (double) m.row);
                } else if (i==0 && j!= 0) {
                    mnew.setELMT(i, j, Matrix.sumColumnWithoutOP(m, j-1));
                } else if (i!=0 && j==0) {
                    mnew.setELMT(i, j, mnew.getELMT(j, i));
                } else {
                    mnew.setELMT(i, j, Matrix.sumColumnWithOp(m, i-1, j-1));
                }
            }
        }

        return mnew;
    }

    public static void solusiRegresi(Matrix m) {
        double[][] reg_data = new double[m.collumns][m.collumns+1];
        Matrix mReg = new Matrix(reg_data, m.collumns, m.collumns+1);

        mReg = normalEstEq(m);
        SPL.Inverse(mReg);
        solusi_regresi = SPL.solusi_spl;
        solusi_regresi.display();
    }

}
