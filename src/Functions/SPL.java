package Functions;
import Matrix.Matrix;
import Functions.Inverse;

public class SPL {
    private Matrix solusi_spl;
    private boolean tanpaSolusi;
    private boolean banyakSolusi;
    private boolean solusiUnik;
    
    //--------------------------------TEMPLATE PROSEDUR PENYELESAIAN SPL----------------------------------//
    // Metode Gauss
    public void Gauss(Matrix m) {

    }

    // Metode Gauss-Jordan
    public void Gauss_Jordan(Matrix m) {

    }

    // Metode Inverse Matriks
    public void Inverse(Matrix m, Matrix b) {
        if (Inverse.isInversible(m)) {
            solusiUnik = true;
            if (Matrix.isMatrixZero(b)) {
                for (int i=0; i<m.collumns; i++) {

                }
            } else {
                Inverse.Inverse_matrix_reduksi(m);
                solusi_spl = Matrix.multiplyMatrix(m, b);
            }
        } else {

        }
    }

    // Metode Cramer
    public void Cramer(Matrix m) {

    }
}
