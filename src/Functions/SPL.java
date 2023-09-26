package Functions;
import Matrix.Matrix;

public class SPL {
    private double[] solusi_spl = new double[100];
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
        if (!Inverse.isInversable(m)) {
            solusiUnik = true;
            for (int i=0; i<m.collumns; i++) {
                solusi_spl[i] = 0;
            }
        } else {

        }
    }

    // Metode Cramer
    public void Cramer(Matrix m) {

    }
}
