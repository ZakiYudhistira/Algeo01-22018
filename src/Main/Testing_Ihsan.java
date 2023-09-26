package Main;
import Functions.*;
import Matrix.*;
import java.util.*;

public class Testing_Ihsan {
    public static Scanner scan;

    public static void main(String[] args) {
        Matrix m1 = new Matrix(null, 0, 0);
        Matrix_scan.scan_matriks_keyboard(m1, "SPL", false);
        m1.display();
        boolean x = Inverse.isInversable(m1);
        System.out.println(x);
    }
}
