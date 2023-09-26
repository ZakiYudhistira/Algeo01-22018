package Main;
import Functions.*;
import Matrix.*;
import java.util.*;

public class Main_Zaki {
    public static Scanner scan;
    public static void main(String[] args){
        boolean error;
        error = false;
        Matrix baru = new Matrix(null, 0, 0);
        // Matrix baru2 = new Matrix(null, 0, 0);
        Matrix_scan.scan_matriks_keyboard(baru, "SPL", error);
        baru.display();
        System.out.print("\n");
        Inverse.Inverse_matrix_reduksi(baru);
        baru.display();
    }
}