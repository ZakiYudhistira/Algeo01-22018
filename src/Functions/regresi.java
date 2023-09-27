package Functions;
import Matrix.Matrix;
import Functions.SPL;

public class regresi {
    public static Matrix solusi_regresi;

    public void solusiRegresi(Matrix m, Matrix b) {
        SPL.Gauss(m, b);
    }

}
