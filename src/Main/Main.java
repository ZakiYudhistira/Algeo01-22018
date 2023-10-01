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
            printMainMenu(100,nama_sesi,date,usage);
            navigate = scan.nextInt();
            if(navigate == 1){ // Sistem Persamaan Linear
                System.out.println("==Pilih metode perhitungan SPL==");
                System.out.println("--> 1. Eliminasi Gauss");
                System.out.println("--> 2. Eliminasi Gauss Jordan");
                System.out.println("--> 3. Metode matriks balikan");
                System.out.println("--> 4. Aturan Crammer");
                System.out.print("Masukkan tujuan Anda : ");
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
                        }else{
                            System.out.println("Kalkulasi matrix gagal, progress tidak disimpan.");
                            pressAnyKeytoContinue();
                        }
                    }else if(navigate == 2){ 
                        System.out.print("Masukkan nama file : ");
                        scan.nextLine();
                        String fileName = scan.nextLine();
                        mainMatrix = Matrix_scan.scan_file(fileName);
                        if(mainMatrix.row < mainMatrix.collumns){
                            SPL.Gauss(mainMatrix, to_be_written,usage);
                            usage++;
                            pressAnyKeytoContinue();
                        }else{
                            System.out.println("Kalkulasi matrix gagal, progress tidak disimpan.");
                            pressAnyKeytoContinue();
                        }
                    }else{
                        System.out.println("Masukan tidak dikenali.");
                        pressAnyKeytoContinue();
                    }
                }else if(navigate == 2){ // Eliminasi Gauss Jordan
                    printJenisMasukan();
                    navigate = scan.nextInt();
                    if(navigate == 1){
                        if(mainMatrix.row < mainMatrix.collumns){
                            Matrix_scan.scan_matriks_keyboard(mainMatrix, "SPL");
                            SPL.Gauss_Jordan(mainMatrix, to_be_written,usage);
                            usage++;
                            pressAnyKeytoContinue();
                        }
                        else{
                            System.out.println("Kalkulasi matrix gagal, progress tidak disimpan.");
                            pressAnyKeytoContinue();
                        }
                    }
                    else if(navigate == 2){
                        System.out.print("Masukkan nama file : ");
                        scan.nextLine();
                        String fileName = scan.nextLine();
                        mainMatrix = Matrix_scan.scan_file(fileName);
                        if(mainMatrix.row < mainMatrix.collumns){
                            SPL.Gauss_Jordan(mainMatrix, to_be_written,usage);
                            usage++;
                            pressAnyKeytoContinue();
                        }
                        else{
                            System.out.println("Kalkulasi matrix gagal, progress tidak disimpan.");
                            pressAnyKeytoContinue();
                        }
                        
                    }else{
                        System.out.println("Masukan tidak dikenali.");
                        pressAnyKeytoContinue();
                    }
                }else if(navigate == 3){

                }else if(navigate == 4){

                }else{
                    System.out.println("Masukan tidak dikenali.");
                    pressAnyKeytoContinue();
                }
            }
            else if(navigate == 2){ // Perhitungan determinan
                System.out.println("==Pilih metode perhitungan Determinan==");
                System.out.println("--> 1. Ekspansi Kofaktor");
                System.out.println("--> 2. Reduksi baris Matriks");
                System.out.print("Masukkan tujuan Anda : ");
                navigate = scan.nextInt();
                if(navigate == 1){ // Ekspansi kofaktor
                    printJenisMasukan();
                    navigate = scan.nextInt();
                    if(navigate == 1){
                        Matrix_scan.scan_matriks_keyboard(mainMatrix, "DETERMINAN");
                        if(mainMatrix.isPersegi()){
                            System.out.println("Mencari determinan matriks dengan kofaktor.");
                            to_be_written[usage] += "Mencari determinan matriks dengan kofaktor.\n";
                            to_be_written[usage] += Matrix.MatrixtoString(mainMatrix);
                            mainMatrix.display();
                            System.out.println("Determinan : "+String.format("%.4f",Matrix.getDeterminanKofaktor(mainMatrix)));
                            to_be_written[usage] += "Determinan : "+String.format("%.4f",Matrix.getDeterminanKofaktor(mainMatrix)) +"\n";
                            usage++;
                        } else {
                            System.out.println("Matriks tidak memiliki determinan.");
                            pressAnyKeytoContinue();
                        }
                        pressAnyKeytoContinue();
                    }else if(navigate == 2){
                        System.out.print("Masukkan nama file : ");
                        scan.nextLine();
                        String fileName = scan.nextLine();
                        mainMatrix = Matrix_scan.scan_file(fileName);
                        if(mainMatrix.isPersegi()){
                            System.out.println("Mencari determinan matriks dengan kofaktor.");
                            mainMatrix.display();
                            to_be_written[usage] += "Mencari determinan matriks dengan kofaktor.\n";
                            to_be_written[usage] += Matrix.MatrixtoString(mainMatrix);
                            System.out.println("Determinan : "+String.format("%.4f",Matrix.getDeterminanKofaktor(mainMatrix)));
                            to_be_written[usage] += "Determinan : "+String.format("%.4f",Matrix.getDeterminanKofaktor(mainMatrix)) +"\n";
                            usage++;
                            pressAnyKeytoContinue();
                        }else{
                            System.out.println("Matriks tidak memiliki determinan.");
                            pressAnyKeytoContinue();
                        }
                    }else{
                        System.out.println("Masukan tidak dikenali.");
                        pressAnyKeytoContinue();
                    }
                }else if(navigate == 2){ // Perhitungan determinan dengan reduksi baris matriks
                    printJenisMasukan();
                    navigate = scan.nextInt();
                    if(navigate == 1){
                        Matrix_scan.scan_matriks_keyboard(mainMatrix, "DETERMINAN");
                        if(mainMatrix.isPersegi()){
                            System.out.println("Mencari determinan matriks dengan reduksi baris.");
                            to_be_written[usage] += "Mencari determinan matriks dengan reduksi baris.\n";
                            to_be_written[usage] += Matrix.MatrixtoString(mainMatrix);
                            mainMatrix.display();
                            System.out.println("Determinan : "+String.format("%.4f",Matrix.getDeterminanReduksi(mainMatrix)));
                            to_be_written[usage] += "Determinan : "+String.format("%.4f",Matrix.getDeterminanReduksi(mainMatrix)) +"\n";
                            usage++;
                            pressAnyKeytoContinue();
                        }else{
                            System.out.println("Matriks tidak memiliki determinan.");
                            pressAnyKeytoContinue();
                        }
                    }else if(navigate == 2){
                        System.out.print("Masukkan nama file : ");
                        scan.nextLine();
                        String fileName = scan.nextLine();
                        mainMatrix = Matrix_scan.scan_file(fileName);
                        if(mainMatrix.isPersegi()){
                            System.out.println("Mencari determinan matriks dengan reduksi baris.");
                            mainMatrix.display();
                            to_be_written[usage] += "Mencari determinan matriks dengan reduksi baris.\n";
                            to_be_written[usage] += Matrix.MatrixtoString(mainMatrix);
                            System.out.println("Determinan : "+String.format("%.4f",Matrix.getDeterminanReduksi(mainMatrix)));
                            to_be_written[usage] += "Determinan : "+String.format("%.4f",Matrix.getDeterminanReduksi(mainMatrix)) +"\n";
                            usage++;
                            pressAnyKeytoContinue();
                        }else{
                            System.out.println("Matriks tidak memiliki determinan.");
                            pressAnyKeytoContinue();
                        }
                    }else{
                        System.out.println("Masukan tidak dikenali.");
                        pressAnyKeytoContinue();
                    }   
                }else{
                    System.out.println("Masukan tidak dikenali.");
                }
            }else if(navigate == 3){ // perhitungan invers matrix
                System.out.println("==Pilih metode balikan matriks==");
                System.out.println("--> 1. Invers reduksi");
                System.out.println("--> 2. Invers determinan kofaktor");
                System.out.print("Masukkan tujuan Anda : ");
                navigate = scan.nextInt();
                if(navigate == 1){ // Invers matriks dengan metode reduksi
                    printJenisMasukan();
                    navigate = scan.nextInt();
                    if(navigate == 1){
                        Matrix_scan.scan_matriks_keyboard(mainMatrix, "DETERMINAN");
                        Inverse.Inverse_matrix_reduksi(mainMatrix, to_be_written, usage);
                        usage++;
                        pressAnyKeytoContinue();
                    }else if(navigate == 2){
                        System.out.print("Masukkan nama file : ");
                        scan.nextLine();
                        String fileName = scan.nextLine();
                        mainMatrix = Matrix_scan.scan_file(fileName);
                        Inverse.Inverse_matrix_reduksi(mainMatrix, to_be_written, usage);
                        usage++;
                        pressAnyKeytoContinue();
                    }
                    else{
                        System.out.println("Masukan tidak dikenali.");
                        pressAnyKeytoContinue();
                    }
                }else if(navigate == 2){
                    printJenisMasukan();
                    navigate = scan.nextInt();
                    if(navigate == 1){
                        Matrix_scan.scan_matriks_keyboard(mainMatrix, "DETERMINAN");
                        Inverse.Inverse_Kofaktor(mainMatrix, to_be_written, usage);
                        usage++;
                        pressAnyKeytoContinue();
                    }else if(navigate == 2){
                        System.out.print("Masukkan nama file : ");
                        scan.nextLine();
                        String fileName = scan.nextLine();
                        mainMatrix = Matrix_scan.scan_file(fileName);
                        Inverse.Inverse_Kofaktor(mainMatrix, to_be_written, usage);
                        usage++;
                        pressAnyKeytoContinue();
                    }else{
                        System.out.println("Masukan tidak dikenali.");
                    }
                }else{
                    System.out.println("Masukan tidak dikenali.");
                }
                
            }
            else if(navigate == 4){
                printJenisMasukan();
                navigate = scan.nextInt();
                if (navigate == 1){
                    Matrix_scan.scan_matriks_keyboard(mainMatrix, "POLINOM");
                    System.out.println("Masukan nilai x yang ingin ditaksir : ");
                    double x = scan.nextDouble();
                    Interpolasi.Interpolasi_Polinom(mainMatrix, x, to_be_written, usage);
                    usage++;
                    pressAnyKeytoContinue();
                } else if(navigate==2){
                    System.out.print("Masukkan nama file : ");
                    scan.nextLine();
                    String fileName = scan.nextLine();
                    mainMatrix = Matrix_scan.scan_file(fileName);
                    System.out.println("Masukan nilai x yang ingin ditaksir : ");
                    double x = scan.nextDouble();
                    Interpolasi.Interpolasi_Polinom(mainMatrix, x, to_be_written, usage);
                    usage++;
                    pressAnyKeytoContinue();
                } else {
                    System.out.println("Masukan tidak dikenali.");
                }
            }
            else if(navigate == 5){
                printJenisMasukan();
                navigate = scan.nextInt();
                if (navigate == 1){
                    double [][] data_temp = new double[1][2];
                    Matrix xy = new Matrix(data_temp, 1, 2);
                    Matrix_scan.scan_matriks_keyboard(mainMatrix, "BCB");
                    System.out.println("Masukan nilai x,y yang ingin ditaksir");
                    System.out.print("x :");
                    double x = scan.nextDouble();
                    xy.setELMT(0, 0, x);
                    System.out.print("y :");
                    double y = scan.nextDouble();
                    xy.setELMT(0, 1, y);
                    Interpolasi_bcb_spline.Interpolasi_bcb(mainMatrix, xy, to_be_written, usage);
                    usage++;
                    pressAnyKeytoContinue();
                } else if (navigate==2){
                    System.out.print("Masukkan nama file : ");
                    scan.nextLine();
                    String fileName = scan.nextLine();
                    mainMatrix = Matrix_scan.scan_file(fileName);
                    double [][] data1 = new double[4][4];
                    Matrix fxy = new Matrix(data1, 4, 4);
                    for (int i=0; i<fxy.row; i++){
                        for (int j=0; j<fxy.collumns; j++){
                            fxy.setELMT(i, j, mainMatrix.getELMT(i, j));
                        }
                    }
                    double [][] data2 = new double[1][2];
                    Matrix xy = new Matrix(data2, 1, 2);
                    xy.setELMT(0, 0, mainMatrix.getELMT(4, 0));
                    xy.setELMT(0, 1, mainMatrix.getELMT(4, 1));
                    Interpolasi_bcb_spline.Interpolasi_bcb(fxy, xy, to_be_written, usage);
                    usage++;
                    pressAnyKeytoContinue();
                } else {
                    System.out.println("Masukan tidak dikenali.");
                }
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
                if(yOrn.equals("Y")){
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
    
    public static void printMainMenu(long delay_length, String sesi, String date, int usage){
        System.out.println("Sesi : "+sesi+" "+date+" "+"["+usage+"]");
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
        System.out.print("Masukkan tujuan Anda : ");
    }
    
    public static void printJenisMasukan(){
        System.out.println("Pilih jenis masukan");
        System.out.println("---> 1. Masukan dari keyboard");
        System.out.println("---> 2. Masukan dari file");
        System.out.print("Masukkan tujuan Anda : ");
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