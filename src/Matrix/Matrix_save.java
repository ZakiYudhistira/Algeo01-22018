package Matrix;
// Library untuk melakukan save_file
import java.io.*;
public class Matrix_save {
    public static void saveFile(String[] array_solusi, String directory, String Nama_file, int count){
        try{
            File fileDate = new File(directory);
            fileDate.mkdir();
            File file = new File(directory+Nama_file+".txt");
            FileWriter fw = new FileWriter(file);
            PrintWriter pw = new PrintWriter(fw);
            int i;
            for(i=0;i<count;i++){
                pw.println("["+(i+1)+"]");
                pw.print(array_solusi[i]);
            }
            pw.close();
        }catch(IOException e){
            System.out.println("Error, saveFile failed.");
        }
    }
}
