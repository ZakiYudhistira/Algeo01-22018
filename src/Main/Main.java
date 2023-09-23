package Main;
import Functions.*;
import Matrix.*;
import java.util.*;


public class Main {
    public static Scanner scan;
    public static void main(String[] args)
    {
        int navigate;
        while(true)
        {
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
            }
            else if(navigate == 2){
                System.out.println("Pilih metode perhitungan Determinan");
                System.out.println("1. Ekspansi Kofaktor");
                System.out.println("2. Eliminasi Gauss Jordan");
                System.out.println("3. Aturan Crammer");
            }
            else if(navigate == 3){
                
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