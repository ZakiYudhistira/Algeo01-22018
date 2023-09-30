package Matrix;
import java.util.*;
// Library berisi fungsi untuk membaca matrix

public class Matrix_scan {
    public static Scanner scan = new Scanner(System.in);

    public static void scan_matriks_keyboard(Matrix m, String  jenis)
    {
        while(true)
        {
            if(jenis == "SPL"){
                int row, collumn, i, j;
                System.out.print("Masukkan jumlah baris : ");
                row = scan.nextInt();
                while(row <= 0){
                    System.out.print("Masukan tidak valid, tolong masukkan nilai yang valid : ");
                    row = scan.nextInt();
                }
                System.out.print("Masukkan jumlah kolom : ");
                collumn = scan.nextInt();
                while(collumn <= 0 || row > collumn){
                    System.out.print("Masukan tidak valid, tolong masukkan nilai yang valid : ");
                    collumn = scan.nextInt();
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
                break;
            }
            else if(jenis == "DETERMINAN"){
                int row;
                System.out.print("Masukkan jumlah baris : ");
                row = scan.nextInt();
                while(row <= 0){
                    System.out.print("Masukan tidak valid, tolong masukkan nilai yang valid : ");
                    row = scan.nextInt();
                }
                System.out.println("Masukkan matrix :");
                double[][] data_isi = new double[row][row];
                int i,j;
                for(i=0;i<row;i++)
                {
                    for(j=0;j<row;j++)
                    {
                        data_isi[i][j] = scan.nextDouble();
                    }
                }
                Matrix.set_data(m, data_isi);
                Matrix.set_collumns(m, row);
                Matrix.set_row(m, row);
                break;
            }
        }
    }
    public static void scan_file(String jenis, String path){
        
    }
}