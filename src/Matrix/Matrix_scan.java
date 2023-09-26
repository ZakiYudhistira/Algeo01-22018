package Matrix;
import java.util.*;
// Library berisi fungsi untuk membaca matrix

public class Matrix_scan {
    public static Scanner scan = new Scanner(System.in);

    public static void scan_matriks_keyboard(Matrix m, String  jenis, boolean error)
    {
        error = false;
        while(true)
        {
            if(jenis == "SPL"){
                int row, collumn, i, j;
                System.out.println("Masukkan jumlah baris :");
                row = scan.nextInt();
                if(row <= 0){
                    System.out.println("Masukan tidak valid.");
                    error = true;
                    break;
                }
                System.out.println("Masukkan jumlah kolom :");
                collumn = scan.nextInt();
                if(collumn <= 0){
                    System.out.println("Masukan tidak valid.");
                    error = true;
                    break;
                }
                System.out.println("Masukkan matrix :");
                double[][] data_isi = new double[row][collumn];
                for(i=0;i<row;i++)
                {
                    for(j=0;j<collumn;j++)
                    {
                        data_isi[i][j] = scan.nextDouble();
                    }
                }
                Matrix.set_data(m, data_isi);
                Matrix.set_collumns(m, collumn);
                Matrix.set_row(m, row);
                System.out.print("\n");
                break;
            }
        }
    }
    public static void scan_file(){
    }
}