package Main;
import Functions.*;
import Matrix.*;
import java.util.*;

public class Testing_Ihsan {
    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        // Matrix m1 = new Matrix(null, 0, 0);
        // Matrix_scan.scan_matriks_keyboard(m1, "SPL", false);
        // m1.display();
        // Matrix m2 = new Matrix(null, 0, 0);
        // Matrix_scan.scan_matriks_keyboard(m2, "SPL", false);
        // Inverse.Inverse_matrix_reduksi(m1);
        Matrix m3 = new Matrix(null, 0, 0);
        // m3 = Matrix.multiplyMatrix(m1, m2);
        // m3.display();
        

        Matrix m = new Matrix(null, 0, 0);
        Matrix_scan.scan_matriks_keyboard(m, "SPL");
        Matrix b = new Matrix(null, 0, 0);
        Matrix_scan.scan_matriks_keyboard(b, "SPL");
        // m3 = Matrix.gantiKolom(m, b, 1);
        // m3.display();
        SPL.Cramer(m, b);
    }
}
