package Functions;
import Matrix.Matrix;
import Functions.SPL;

public class regresi {
    public static Matrix solusi_regresi;

    public static void solusiRegresi(Matrix m, Matrix b, double x) {
        SPL.Gauss(m);
        solusi_regresi = SPL.solusi_spl;
        solusi_regresi.display();
    }

}
