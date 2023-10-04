package Main;
import Functions.*;
import Matrix.*;
import java.util.*;

public class Main_Zaki {
    public static Scanner scan;
    public static void main(String[] args){
       Matrix anyar = new Matrix(null, 0, 0);
       Matrix_scan.scan_matriks_keyboard(anyar, "SPL");
       anyar.p_reduksi_eselon(true);
       anyar.display();
       anyar.divideByPivot();
       anyar.display();
    }
}