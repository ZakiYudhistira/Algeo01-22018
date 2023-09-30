package Functions;
import Matrix.Matrix;
import Functions.Inverse;

public class SPL {
    public static Matrix solusi_spl;
    private static boolean tanpaSolusi;
    private static boolean banyakSolusi;
    private static boolean solusiUnik;
    
    //--------------------------------TEMPLATE PROSEDUR PENYELESAIAN SPL----------------------------------//
    // Metode Gauss
    public static void Gauss(Matrix m, String[] array_solusi, int idx_array) {
        System.out.println("Menghitung SPL dengan metode GAUSS.");
        array_solusi[idx_array] += "Menghitung SPL dengan metode GAUSS.\n";
        array_solusi[idx_array] += Matrix.MatrixtoString(m);
        m.display();
        m.removeZeroCollumn();
        m.normalize();
        m.p_reduksi_eselon(true);
        if(m.isRowZero(m.row-1, m.collumns-2) && m.getELMT(m.row-1, m.collumns-1) != 0){
            System.out.println("SPL tidak memiliki solusi.");
            array_solusi[idx_array] += "SPL tidak memiliki solusi.\n";
        }
        else if(m.isRowZero(m.row-1,m.collumns-1)){
            System.out.println("SPL tidak memiliki solusi tunggal.");
            array_solusi[idx_array] += "SPL tidak memiliki solusi tunggal.\n";
            String[] alphabet = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
            int count_var = 0;
            int i,j;
            for(i=0;i<m.row;i++){
                if(m.isRowZero(i,m.collumns-1)){
                    count_var++;
                }
            }
            double[][] array_jawaban = new double[m.row][count_var+1];
            for(i=0;i<m.row;i++){
                for(j=0;j<count_var+1;j++){
                    array_jawaban[i][j] = 0;
                }
            }
            for(i=0;i<m.row;i++){
                if(!m.isRowZero(i, m.collumns-1)){
                    array_jawaban[i][0] = m.getELMT(i, m.collumns-1);
                }
            }
            count_var = 1;
            // perhitungan
            for(i=m.row-1;i>=0;i--){
                if(m.isRowZero(i, m.collumns-1)){
                    array_jawaban[i][count_var] = 1;
                    count_var++;
                }
                else{
                    for(j=i+1;j<m.collumns-1;j++){
                        Matrix.kurang_array(array_jawaban[i], Matrix.kali_array(array_jawaban[j], m.getELMT(i,j)));
                    }
                }
            }
            for(i=0;i<array_jawaban.length;i++){
                for(j=0;j<array_jawaban[0].length;j++){
                    if(j==0){
                        if(array_jawaban[i][j] == 0){
                            System.out.print("x"+i+" = ");
                            array_solusi[idx_array] += "x"+i+" = ";
                        }
                        else{
                            System.out.print("x"+i+" = " + array_jawaban[i][j]);
                            array_solusi[idx_array] += "x"+i+" = " + array_jawaban[i][j];
                        }
                    }
                    else{
                        if(array_jawaban[i][j] > 0){
                            System.out.print("+"+array_jawaban[i][j]+alphabet[j-1]);
                            array_solusi[idx_array] += "+"+array_jawaban[i][j]+alphabet[j-1]; 
                        }
                        else if(array_jawaban[i][j]<0){
                            System.out.print(array_jawaban[i][j]+alphabet[j-1]);
                            array_solusi[idx_array] += array_jawaban[i][j]+alphabet[j-1];
                        }
                    }
                }
                System.out.println("");
                array_solusi[idx_array] += "\n";
            }
        }
        else{
            m.divideByPivot();
            double[] solusi = new double[m.row];
            int i;
            for(i=m.row-1;i>=0;i--){
                solusi[i] = m.getELMT(i, m.collumns-1);
            }
            for(i=m.row-1;i>=0;i--){
                if(i==m.row-1){
                    solusi[i] = m.getELMT(i, m.collumns-1);
                }
                else{
                    double sum = 0.0;
                    for (int j = i+1; j < m.collumns-1; j++) 
                        sum += m.getELMT(i, j) * solusi[j];
                        solusi[i] = solusi[i]-sum;
                }
            }
            System.out.println("Berikut solusi dari SPL :");
            array_solusi[idx_array] += "Berikut solusi dari SPL :\n";
            for(i=0;i<m.row;i++){
                System.out.println("x" + i + " = " + String.format("%.4f",solusi[i]));
                array_solusi[idx_array] += "x" + i + " = " + String.format("%.4f",solusi[i])+"\n";
            }
        }
    }

    // Metode Gauss-Jordan
    public static void Gauss_Jordan(Matrix m, String[] array_solusi, int idx_array) {
        System.out.println("Menghitung SPL dengan metode GAUSS JORDAN.");
        array_solusi[idx_array] += "Menghitung SPL dengan metode GAUSS JORDAN.\n";
        array_solusi[idx_array] += Matrix.MatrixtoString(m);
        m.removeZeroCollumn();
        m.normalize();
        m.p_reduksi_eselon(true);

        // Tidak punya solusi
        if(m.isRowZero(m.row-1, m.collumns-2) && m.getELMT(m.row-1, m.collumns-1) != 0){
            System.out.println("SPL tidak memiliki solusi.");
            array_solusi[idx_array] += "SPL tidak memiliki solusi.\n";
        }

        // Solusi banyak (parametrik)
        else if(m.isRowZero(m.row-1,m.collumns-1)){
            System.out.println("SPL tidak memiliki solusi tunggal.");
            array_solusi[idx_array] += "SPL tidak memiliki solusi tunggal.\n";
            String[] alphabet = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
            int count_var = 0;
            int i,j;
            for(i=0;i<m.row;i++){
                if(m.isRowZero(i,m.collumns-1)){
                    count_var++;
                }
            }
            double[][] array_jawaban = new double[m.row][count_var+1];
            for(i=0;i<m.row;i++){
                for(j=0;j<count_var+1;j++){
                    array_jawaban[i][j] = 0;
                }
            }
            for(i=0;i<m.row;i++){
                if(!m.isRowZero(i, m.collumns-1)){
                    array_jawaban[i][0] = m.getELMT(i, m.collumns-1);
                }
            }
            count_var = 1;
            // perhitungan
            for(i=m.row-1;i>=0;i--){
                if(m.isRowZero(i, m.collumns-1)){
                    array_jawaban[i][count_var] = 1;
                    count_var++;
                }
                else{
                    for(j=i+1;j<m.collumns-1;j++){
                        Matrix.kurang_array(array_jawaban[i], Matrix.kali_array(array_jawaban[j], m.getELMT(i,j)));
                    }
                }
            }
            for(i=0;i<array_jawaban.length;i++){
                for(j=0;j<array_jawaban[0].length;j++){
                    if(j==0){
                        if(array_jawaban[i][j] == 0){
                            System.out.print("x"+i+" = ");
                            array_solusi[idx_array] += "x"+i+" = ";
                        }
                        else{
                            System.out.print("x"+i+" = " + array_jawaban[i][j]);
                            array_solusi[idx_array] += "x"+i+" = " + array_jawaban[i][j];
                        }
                    }
                    else{
                        if(array_jawaban[i][j] > 0){
                            System.out.print("+"+array_jawaban[i][j]+alphabet[j-1]);
                            array_solusi[idx_array] += "+"+array_jawaban[i][j]+alphabet[j-1]; 
                        }
                        else if(array_jawaban[i][j]<0){
                            System.out.print(array_jawaban[i][j]+alphabet[j-1]);
                            array_solusi[idx_array] += array_jawaban[i][j]+alphabet[j-1];
                        }
                    }
                }
                System.out.println("");
                array_solusi[idx_array] += "\n";
            }

        }

        // Solusi unik
        else{
            double[] solusi = new double[m.row];
            m.p_reduksi_eselon(false);
            m.divideByPivot();
            int i;
            for(i=m.row-1;i>=0;i--){
                solusi[i] = m.getELMT(i, m.collumns-1);
            }
            System.out.println("Berikut solusi dari SPL :");
            array_solusi[idx_array] += "Berikut solusi dari SPL :\n";
            for(i=0;i<m.row;i++){
                System.out.println("x" + i + " = " + String.format("%.4f",solusi[i]));
                array_solusi[idx_array] += "x" + i + " = " + solusi[i]+"\n";
            }
        }
    }

    // fungsi
    public static double[] HitungSPL(Matrix m){
        double[] solusi = new double[m.row];
        m.removeZeroCollumn();
        m.normalize();
        m.p_reduksi_eselon(true);
        m.p_reduksi_eselon(false);
        m.divideByPivot();
        int i;
            for(i=m.row-1;i>=0;i--){
                solusi[i] = m.getELMT(i, m.collumns-1);
            }
        return solusi;
    }

    // Metode Inverse Matriks
    public static void Inverse(Matrix m) {
        double[][] mSPL_data = new double[m.row][m.collumns-1];
        Matrix mSPL = new Matrix(mSPL_data, m.row, m.collumns-1);

        double[][] mJwb_data = new double[m.row][1];
        Matrix mJwb = new Matrix(mJwb_data, m.row, 1);

        Matrix.splitAugmentMtx(m, mSPL, mJwb);

        double[][] solusi = new double[mSPL.row][1];
        solusi_spl = new Matrix(solusi, mSPL.row, 1);
        String[] pp = new String[1];

        if (Inverse.isInversible(mSPL)) {
            if (Matrix.isMatrixZero(mJwb)) {
                for (int i=0; i<mSPL.collumns; i++) {
                    solusi_spl.setELMT(i, 0, 0);;
                }
            } else {
                Inverse.Inverse_matrix_reduksi(mSPL,pp,0);
                solusi_spl = Matrix.multiplyMatrix(mSPL, mJwb);
            }
        } else {
            System.out.println("SPL tidak dapat diselesaikan menggunakan metode inverse");
        }
    }

    // Metode Cramer
    public static void Cramer(Matrix m) {
        double[][] mSPL_data = new double[m.row][m.collumns-1];
        Matrix mSPL = new Matrix(mSPL_data, m.row, m.collumns-1);

        double[][] mJwb_data = new double[m.row][1];
        Matrix mJwb = new Matrix(mJwb_data, m.row, 1);

        Matrix.splitAugmentMtx(m, mSPL, mJwb);

        double[][] solusi = new double[m.row][1];
        solusi_spl = new Matrix(solusi, m.row, 1);

        Matrix mtemp = mSPL.copyMatrix();

        double detUtama = Matrix.getDeterminanReduksi(mSPL);
        if (detUtama != 0) {
            int i;
            for (i=0; i<mSPL.collumns; i++) {
                mtemp = Matrix.gantiKolom(mSPL, mJwb, i);
                double detTemp = Matrix.getDeterminanReduksi(mtemp);
                solusi_spl.setELMT(i, 0, (detTemp/detUtama));
            }
            solusi_spl.display();
        } else {
            System.out.println("SPL tidak dapat diselesaikan menggunakan metode Cramer");
        }
    }
}
    //----------------------------PENYELESAIAN PARAMETRIK----------------------------------//