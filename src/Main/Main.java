package Main;
import Functions.*;
import Matrix.*;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;


public class Main {
    public static Scanner scan = new Scanner(System.in);

    
    public static void main(String[] args){
        //----------------------------INISIASI---------------------------------//
        Date thisDate = new Date();
        SimpleDateFormat dateForm = new SimpleDateFormat("MM-dd-YY");
        String date = dateForm.format(thisDate);
        String dir = "test\\Save_files\\"+date+"\\";
        String[] to_be_written = new String[100];
        int k;
        for(k=0;k<100;k++){
            to_be_written[k] ="";
        }
        Matrix mainMatrix = new Matrix(null, 0, 0);
        int navigate;
        int usage = 0;
        String nama_sesi;
        printBiggerWeapon("biggerWeapons.txt");
        System.out.println("\n| Selamat datang di program BiggerWeapons !");
        delay(200);
        System.out.print("| Silahkan masukkan nama sesi : ");
        nama_sesi = scan.nextLine();
        System.out.print("Initializing ");
        delay(400);
        System.out.print("- ");
        delay(400);
        System.out.print("- ");
        delay(400);
        System.out.print("-");
        delay(400);
        System.out.print("\n");
        //----------------------------INISIASI---------------------------------//
        while(usage < 100){
            printMainMenu(100,nama_sesi,date);
            navigate = scan.nextInt();
            if(navigate == 1){
                System.out.println("==Pilih metode perhitungan SPL==");
                System.out.println("--> 1. Eliminasi Gauss");
                System.out.println("--> 2. Eliminasi Gauss Jordan");
                System.out.println("--> 3. Metode matriks balikan");
                System.out.println("--> 4. Aturan Crammer");
                System.out.println("Masukkan tujuan Anda :");
                navigate = scan.nextInt();
                if(navigate == 1){ // Eliminasi Gauss
                    printJenisMasukan();
                    navigate = scan.nextInt();
                    if(navigate == 1){
                        Matrix_scan.scan_matriks_keyboard(mainMatrix, "SPL");
                        if(mainMatrix.row < mainMatrix.collumns){
                            SPL.Gauss(mainMatrix, to_be_written,usage);
                            usage++;
                            pressAnyKeytoContinue();
                        }
                        else{
                            System.out.println("Kalkulasi matrix gagal, progress tidak disimpan.");
                            pressAnyKeytoContinue();
                        }
                    }
                    else if(navigate == 2){ 
                        
                    }
                }
                else if(navigate == 2){ // Eliminasi Gauss Jordan
                    printJenisMasukan();
                    navigate = scan.nextInt();
                    if(navigate == 1){
                        if(mainMatrix.row < mainMatrix.collumns){
                            Matrix_scan.scan_matriks_keyboard(mainMatrix, "SPL");
                            SPL.Gauss_Jordan(mainMatrix, to_be_written,usage);
                            usage++;
                        }
                        else{
                            System.out.println("Kalkulasi matrix gagal, progress tidak disimpan.");
                            pressAnyKeytoContinue();
                        }
                    }
                    else if(navigate == 2){
                        
                    }
                    else{
                        System.out.println("Masukan tidak dikenali.");
                        pressAnyKeytoContinue();
                    }
                }
                else{
                    System.out.println("Masukan tidak dikenali.");
                    pressAnyKeytoContinue();
                }
            }
            else if(navigate == 2){
                System.out.println("==Pilih metode perhitungan Determinan==");
                System.out.println("--> 1. Ekspansi Kofaktor");
                System.out.println("--> 2. Reduksi baris Matriks");
                navigate = scan.nextInt();
                if(navigate == 1){
                    printJenisMasukan();
                    navigate = scan.nextInt();
                    if(navigate == 1){
                        
                    }
                    else if(navigate == 2){
                        
                    }
                    else{
                        System.out.println("Masukan tidak dikenali.");
                        pressAnyKeytoContinue();
                    }
                }
                else if(navigate == 2){ // Perhitungan determinan dengan reduksi baris matriks
                    printJenisMasukan();
                    navigate = scan.nextInt();
                    if(navigate == 1){
                        Matrix_scan.scan_matriks_keyboard(mainMatrix, "DETERMINAN");
                        System.out.println("Mencari determinan matriks dengan reduksi baris : ");
                        to_be_written[usage] += "Mencari determinan matriks dengan reduksi baris :";
                        to_be_written[usage] += Matrix.MatrixtoString(mainMatrix);
                        mainMatrix.display();
                        System.out.println("Determinan : "+Matrix.getDeterminanReduksi(mainMatrix));
                        to_be_written[usage] += "Determinan : "+Matrix.getDeterminanReduksi(mainMatrix) +"\n";
                        usage++;
                    }
                    else if(navigate == 2){

                    }
                    else{
                        System.out.println("Masukan tidak dikenali.");
                        pressAnyKeytoContinue();
                    }
                    
                }
                else if(navigate == 3){
                    printJenisMasukan();
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
                System.out.println("==Pilih metode balikan matriks==");
                System.out.println("--> 1. Invers reduksi");
                System.out.println("--> 2. Invers determinan kofaktor");
                navigate = scan.nextInt();
                if(navigate == 1){ // Invers matriks dengan metode reduksi
                    printJenisMasukan();
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
                    printJenisMasukan();
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
                printJenisMasukan();
                navigate = scan.nextInt();
                if (navigate == 1){
                    Matrix_scan.scan_matriks_keyboard(mainMatrix, "Polinom");
                    System.out.println("Masukan nilai x yang ingin ditaksir : ");
                    double x = scan.nextDouble();
                    Interpolasi.Interpolasi_Polinom(mainMatrix, x);
                    System.out.println(" ");
                }
            }
            else if(navigate == 5){
                
            }
            else if(navigate == 6) { // Regresi ganda
                printJenisMasukan();
                navigate = scan.nextInt();
                if (navigate == 1) {
                    Matrix_scan.scan_matriks_keyboard(mainMatrix, "REGRESI");
                    Matrix mTaksir = new Matrix(null, mainMatrix.collumns-1, 1);
                    Matrix_scan.scan_matriks_keyboard(mTaksir, "TAKSIRAN");
                    regresi.solusiRegresi(mainMatrix, mTaksir);
                    usage++;
                } else if(navigate == 2) {
                    
                }
            }
            else if(navigate == 7){ // Keluar dari program
                System.out.print("Apakah Anda mau menyimpan progress (Y/N) ? : ");
                String yOrn; 
                scan.nextLine(); 
                yOrn = scan.nextLine();
                yOrn.toUpperCase();
                while(!yOrn.equals("Y") && !yOrn.equals("N")){
                    System.out.print("Masukkan input yang besar (Y/N) ! :");
                    yOrn = scan.nextLine();
                    yOrn.toUpperCase();
                }
                if(yOrn == "Y"){
                    Matrix_save.saveFile(to_be_written, dir, nama_sesi, usage);
                    System.out.println("Terimakasih telah menggunakan program BiggerWeapons!");
                    System.exit(0);
                } else {
                    System.out.println("Terimakasih telah menggunakan program BiggerWeapons!");
                    System.exit(0);
                }
                
            }
            else{
                System.out.println("input tidak dikenali.");
                pressAnyKeytoContinue();
            }
        }
    }
    public static void delay(long milisecond){
        try{
            Thread.sleep(milisecond);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
    
    public static void pressAnyKeytoContinue(){
        try{
            System.out.println("<Tekan ENTER untuk melanjutkan>");
            System.in.read();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public static void printMainMenu(long delay_length, String sesi, String date){
        System.out.println("Sesi : "+sesi+" "+date);
        delay(delay_length);
        System.out.println("==========MENU UTAMA==========");
        delay(delay_length);
        System.out.println("1. Sistem Persamaan Linier");
        delay(delay_length);
        System.out.println("2. Determinan");
        delay(delay_length);
        System.out.println("3. Matriks balikan");
        delay(delay_length);
        System.out.println("4. Interpolasi Polinom");
        delay(delay_length);
        System.out.println("5. Interpolasi Bicubic Spline");
        delay(delay_length);
        System.out.println("6. Regresi Linier Berganda");
        delay(delay_length);
        System.out.println("7. Keluar");
        delay(delay_length);
        System.out.println("Masukkan tujuan Anda :");
    }
    
    public static void printJenisMasukan(){
        System.out.println("Pilih jenis masukan");
        System.out.println("---> 1. Masukan dari keyboard");
        System.out.println("---> 2. Masukan dari file");
        System.out.println("Masukkan tujuan Anda :");
    }

    public static void printBiggerWeapon(String file_name){
        try{
            File file = new File("Misc\\"+file_name);
            Scanner scan_file = new Scanner(file);
            while(scan_file.hasNextLine()){
                System.out.println(scan_file.nextLine());
                delay(100);
            }
            scan_file.close();
        } catch(FileNotFoundException e){
            System.out.println("");
        }
    }
}