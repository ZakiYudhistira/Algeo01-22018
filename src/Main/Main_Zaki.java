package Main;
import Functions.*;
import Matrix.*;
import java.util.*;

public class Main_Zaki {
    public static Scanner scan;
    public static void main(String[] args)
    {
        Matrix baru = new Matrix(null, 0, 0);
        // Matrix baru2 = new Matrix(null, 0, 0);
        Matrix_scan.scan_matriks_keyboard(baru);
        baru.display();
        baru.divide_baris(0,2);
        baru.display();
        baru.substract_baris(0, 1, 1);
        baru.display();
    }
}