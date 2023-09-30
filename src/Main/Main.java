package Main;
import Functions.*;
import Matrix.*;
import java.util.*;


public class Main {
    public static Scanner scan = new Scanner(System.in);;
    public static void main(String[] args)
    {
        String[] to_be_written = new String[100];
        int k;
        for(k=0;k<to_be_written.length;k++){
            to_be_written[k] = "["+(k+1)+"]\n";
        }
        Matrix mainMatrix = new Matrix(null, 0, 0);
        int navigate;
        int usage = 0;
        String nama_sesi;
        System.out.print("Masukkan nama sesi : ");
        nama_sesi = scan.nextLine();
        while(usage < 100){
            System.out.println("MENU");
            System.out.println("1. Sistem Persamaan Linier");
            System.out.println("2. Determinan");
            System.out.println("3. Matriks balikan");
            System.out.println("4. Interpolasi Polinom");
            System.out.println("5. Interpolasi Bicubic Spline");
            System.out.println("6. Regresi Linier Berganda");
            System.out.println("7. Keluar");
            System.out.println("Masukkan tujuan Anda :");
            navigate = scan.nextInt();
            if(navigate == 1){
                System.out.println("Pilih metode perhitungan SPL");
                System.out.println("1. Eliminasi Gauss");
                System.out.println("2. Eliminasi Gauss Jordan");
                System.out.println("3. Metode matriks balikan");
                System.out.println("4. Aturan Crammer");
                navigate = scan.nextInt();
                if(navigate == 1){
                    System.out.println("Pilih jenis masukan");
                    System.out.println("1. Masukan dari keyboard");
                    System.out.println("2. Masukan dari file");
                    navigate = scan.nextInt();
                    if(navigate == 1){
                        Matrix_scan.scan_matriks_keyboard(mainMatrix, "SPL");
                        if(mainMatrix.row < mainMatrix.collumns){
                            SPL.Gauss(mainMatrix, to_be_written,usage);
                            usage++;
                        }
                        else{
                            System.out.println("Kalkulasi matrix gagal, progress tidak disimpan.");
                        }
                    }
                    else if(navigate == 2){

                    }
                }
                else if(navigate == 2){
                    System.out.println("Pilih jenis masukan");
                    System.out.println("1. Masukan dari keyboard");
                    System.out.println("2. Masukan dari file");
                    navigate = scan.nextInt();
                    if(navigate == 1){
                        if(mainMatrix.row < mainMatrix.collumns){
                            SPL.Gauss_Jordan(mainMatrix, to_be_written,usage);
                            usage++;
                        }
                        else{
                            System.out.println("Kalkulasi matrix gagal, progress tidak disimpan.");
                        }
                    }
                    else if(navigate == 2){

                    }
                    else{
                        System.out.println("Masukan tidak dikenali.");
                    }
                }
                else{
                    System.out.println("Masukan tidak dikenali.");
                }
            }
            else if(navigate == 2){
                System.out.println("Pilih metode perhitungan Determinan");
                System.out.println("1. Ekspansi Kofaktor");
                System.out.println("2. Eliminasi Gauss Jordan");
                System.out.println("3. Aturan Crammer");
                navigate = scan.nextInt();
                if(navigate == 1){
                    System.out.println("Pilih jenis masukan");
                    System.out.println("1. Masukan dari keyboard");
                    System.out.println("2. Masukan dari file");
                    navigate = scan.nextInt();
                    if(navigate == 1){
                        
                    }
                    else if(navigate == 2){

                    }
                    else{
                        System.out.println("Masukan tidak dikenali.");
                    }
                }
                else if(navigate == 2){
                    System.out.println("Pilih jenis masukan");
                    System.out.println("1. Masukan dari keyboard");
                    System.out.println("2. Masukan dari file");
                    navigate = scan.nextInt();
                    if(navigate == 1){
                        Matrix_scan.scan_matriks_keyboard(mainMatrix, "DETERMINAN");
                        System.out.println("Mencari determinan matriks dengan eliminasi GAUSS : ");
                        to_be_written[usage] = Matrix.MatrixtoString(mainMatrix);
                        mainMatrix.display();
                        System.out.println("Determinan : "+Matrix.getDeterminanReduksi(mainMatrix));
                        to_be_written[usage] += "Determinan : "+Matrix.getDeterminanReduksi(mainMatrix);
                        usage++;
                    }
                    else if(navigate == 2){

                    }
                    else{
                        System.out.println("Masukan tidak dikenali.");
                    }
                    
                }
                else if(navigate == 3){
                    System.out.println("Pilih jenis masukan");
                    System.out.println("1. Masukan dari keyboard");
                    System.out.println("2. Masukan dari file");
                    if(navigate == 1){
                        
                    }
                    else if(navigate == 2){

                    }
                    else{
                        System.out.println("Masukan tidak dikenali.");
                    }

                }
                else{
                    System.out.println("Masukan tidak dikenali.");
                }
            }
            else if(navigate == 3){
                System.out.println("Pilih metode balikan matriks.");
                System.out.println("1. Invers reduksi");
                System.out.println("2. Invers determinan kofaktor");
                navigate = scan.nextInt();
                if(navigate == 1){
                    System.out.println("Pilih jenis masukan");
                    System.out.println("1. Masukan dari keyboard");
                    System.out.println("2. Masukan dari file");
                    navigate = scan.nextInt();
                    if(navigate == 1){
                        Matrix_scan.scan_matriks_keyboard(mainMatrix, "DETERMINAN");
                        Inverse.Inverse_matrix_reduksi(mainMatrix, to_be_written, usage);
                        usage++;
                    }
                    else if(navigate == 2){

                    }
                }
                else if(navigate == 2){
                    System.out.println("Pilih jenis masukan");
                    System.out.println("1. Masukan dari keyboard");
                    System.out.println("2. Masukan dari file");
                    navigate = scan.nextInt();
                    if(navigate == 1){
                        
                    }
                    else if(navigate == 2){

                    }
                    else{
                        System.out.println("Masukan tidak dikenali.");
                    }
                }
                else{
                    System.out.println("Masukan tidak dikenali.");
                }

            }
            else if(navigate == 4){
                
            }
            else if(navigate == 5){
                
            }
            else if(navigate == 6){
                
            }
            else if(navigate == 7){
                System.exit(0);
            }
            else{
                System.out.println("input tidak dikenali.");
            }
        }
    }
}