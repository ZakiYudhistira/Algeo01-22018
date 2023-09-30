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
        Matrix_scan.scan_matriks_keyboard(baru, "SPL");
        baru.display();
        System.out.print("\n");
        baru.p_reduksi_eselon(true);
        baru.p_reduksi_eselon(false);
        // baru.p_reduksi_eselon(false);
        // String tes = Matrix.MatrixtoString(baru);
        // System.out.println(tes);
        baru.display();
        // double[] ini1= {1,2,3};
        // double[] ini2= {4,5,6};
        // Matrix.kurang_array(ini1,ini2);
        // int i;
        // for(i=0;i<ini1.length;i++){
        //     System.out.println(ini1[i]);
        // }
    }
}