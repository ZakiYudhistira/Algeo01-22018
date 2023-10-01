package Matrix;
import java.util.*;

import Functions.regresi;

import java.io.File;
import java.io.FileNotFoundException;
// Library berisi fungsi untuk membaca matrix
import java.io.IOException;

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
                System.out.print("Masukkan jumlah kolom : ");
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
            } else if (jenis == "LAINNYA") { // Untuk regresi dan interpolasi
                int row, collumn, i, j;
                System.out.print("Masukkan jumlah baris : ");
                row = scan.nextInt();
                while (row <= 0){
                    System.out.print("Masukan tidak valid, tolong masukkan nilai yang valid : ");
                    row = scan.nextInt();
                }
                System.out.print("Masukkan jumlah kolom : ");
                collumn = scan.nextInt();
                while (collumn <= 0) {
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
        }
    }
    public static Matrix scan_file(String file_name, int batas_awal, int batas_akhir){
        double[][] data_temp = new double[100][100];
        String current_line;
        int column=0, row=0,max_column=0;
        int line=1;
        try{
        File file = new File("test\\"+file_name);
        Scanner scan_file = new Scanner(file);
        while(scan_file.hasNextLine() && line<=batas_akhir){
            String[] numbers = (scan_file.nextLine()).split("\\s+");
            if (line >= batas_awal){
                for(column=0;column<numbers.length;column++){
                    data_temp[row][column] = Double.parseDouble(numbers[column]);
                }
                max_column = numbers.length;
                row++;
            }
            line++;
        }
        scan_file.close();
        double[][] data_matriks = new double[row+1][max_column];
        int i,j;
        for(i=0;i<data_matriks.length;i++){
            for(j=0;j<data_matriks[0].length;j++){
                data_matriks[i][j] = data_temp[i][j];
            }
        }
        Matrix hasil = new Matrix(data_matriks, row, max_column);
        return hasil;
        }catch(FileNotFoundException e){
            Matrix hasil = new Matrix(null, 0, 0);
            System.out.println("File tidak ditemukan, pastikan input nama file sudah benar :D");
            return hasil;
        }
    }
    public static void main(String args[]){
        Matrix baru = scan_file("tes.txt",2, 4);
        baru.display();
        Matrix baru2 = scan_file("tes.txt", 5, 5);
        baru2.display();
    }
}