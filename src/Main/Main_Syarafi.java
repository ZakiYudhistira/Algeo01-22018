package Main;
import Functions.*;
import Matrix.*;
import java.util.*;

public class Main_Syarafi {
    public static Scanner scan;
    public static void main(String[] args){
        Matrix m = new Matrix(null, 0, 0);
        Matrix m2 = new Matrix(null, 0, 0);
        Matrix_scan.scan_matriks_keyboard(m, "SPL");
        Matrix_scan.scan_matriks_keyboard(m2, "SPL");
        // m2 = m;
        // m2.display();
        // Interpolasi.Interpolasi_Polinom(m, 9.2);
        // m.self_transpose();
        // Inverse.adjoint(m).display();;
       Interpolasi_bcb_spline.Interpolasi_bcb(m, m2);
    }
}
