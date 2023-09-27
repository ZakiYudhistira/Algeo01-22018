package Functions;
import Matrix.Matrix;
import Functions.Inverse;

public class SPL {
    public static Matrix solusi_spl;
    private static boolean tanpaSolusi;
    private static boolean banyakSolusi;
    private static boolean solusiUnik;
    
    //--------------------------------TEMPLATE PROSEDUR PENYELESAIAN SPL----------------------------------//
    // Metode Gauss
    public static void Gauss(Matrix m, Matrix b) {

    }

    // Metode Gauss-Jordan
    public static void Gauss_Jordan(Matrix m, Matrix b) {

    }

    // Metode Inverse Matriks
    public static void Inverse(Matrix m, Matrix b) {
        double[][] solusi = new double[1][m.collumns];
        solusi_spl = new Matrix(solusi, m.row, 1);

        if (Inverse.isInversible(m)) {
            solusiUnik = true;
            if (Matrix.isMatrixZero(b)) {
                for (int i=0; i<m.collumns; i++) {
                    solusi_spl.setELMT(i, 0, 0);;
                }
            } else {
                Inverse.Inverse_matrix_reduksi(m);
                solusi_spl = Matrix.multiplyMatrix(m, b);
            }
        } else {
            banyakSolusi = true;

        }
    }

    // Metode Cramer
    public static void Cramer(Matrix m, Matrix b) {
        double[][] solusi = new double[1][m.collumns];
        solusi_spl = new Matrix(solusi, m.row, 1);

        Matrix mtemp;

        double detUtama = Matrix.getDeterminanKofaktor(m);
        if (detUtama != 0) {
            int i;
            for (i=0; i<m.collumns; i++) {
                mtemp = Matrix.gantiKolom(m, b, i);
                double detTemp = Matrix.getDeterminanKofaktor(mtemp);
                solusi_spl.setELMT(i, 0, (detTemp/detUtama));
            }
        } else {

        }
    }
}
