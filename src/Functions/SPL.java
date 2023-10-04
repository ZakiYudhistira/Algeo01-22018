package Functions;
import Matrix.Matrix;

public class SPL {
    public static Matrix solusi_spl;
    
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
        m.divideByPivot();
        if(m.isRowZero(m.row-1, m.collumns-2) && m.getELMT(m.row-1, m.collumns-1) != 0){
            System.out.println("SPL tidak memiliki solusi.");
            array_solusi[idx_array] += "SPL tidak memiliki solusi.\n";
        }
        else if(m.isRowZero(m.row-1,m.collumns-1)){
            System.out.println("SPL tidak memiliki solusi tunggal.");
            array_solusi[idx_array] += "SPL tidak memiliki solusi tunggal.\n";
            String[] alphabet = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
            int i,j;
            double[][] array_jawaban;
            array_jawaban = getJawabanSPL2(m);
            
            for(i=0;i<array_jawaban.length;i++){
                for(j=0;j<array_jawaban[0].length;j++){
                    if(j==0){
                        if(array_jawaban[i][j] == 0){
                            System.out.print("x"+i+" = ");
                            array_solusi[idx_array] += "x"+i+" = ";
                        }
                        else{
                            System.out.print("x"+i+" = " + String.format("%.4f",array_jawaban[i][j]));
                            array_solusi[idx_array] += "x"+i+" = " + String.format("%.4f",array_jawaban[i][j]);
                        }
                    }
                    else{
                        if(array_jawaban[i][j] > 0 && array_jawaban[i][0]==0){
                            System.out.print(String.format("%.4f",array_jawaban[i][j])+alphabet[j-1]);
                            array_solusi[idx_array] += String.format("%.4f",array_jawaban[i][j])+alphabet[j-1]; 
                        }
                        else if(array_jawaban[i][j] > 0){
                            System.out.print("+"+String.format("%.4f",array_jawaban[i][j])+alphabet[j-1]);
                            array_solusi[idx_array] += "+"+String.format("%.4f",array_jawaban[i][j])+alphabet[j-1]; 
                        }
                        else if(array_jawaban[i][j]<0){
                            System.out.print(String.format("%.4f",array_jawaban[i][j])+alphabet[j-1]);
                            array_solusi[idx_array] += String.format("%.4f",array_jawaban[i][j])+alphabet[j-1];
                        }
                    }
                }
                System.out.println("");
                array_solusi[idx_array] += "\n";
            }
        }
        else{
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
        m.display();
        m.removeZeroCollumn();
        m.normalize();
        m.p_reduksi_eselon(true);
        m.divideByPivot();

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
            int i,j;
            double[][] array_jawaban;
            array_jawaban = getJawabanSPL2(m);
            
            for(i=0;i<array_jawaban.length;i++){
                for(j=0;j<array_jawaban[0].length;j++){
                    if(j==0){
                        if(array_jawaban[i][j] == 0){
                            System.out.print("x"+i+" = ");
                            array_solusi[idx_array] += "x"+i+" = ";
                        }
                        else{
                            System.out.print("x"+i+" = " + String.format("%.4f",array_jawaban[i][j]));
                            array_solusi[idx_array] += "x"+i+" = " + String.format("%.4f",array_jawaban[i][j]);
                        }
                    }
                    else{
                        if(array_jawaban[i][j] > 0 && array_jawaban[i][0]==0){
                            System.out.print(String.format("%.4f",array_jawaban[i][j])+alphabet[j-1]);
                            array_solusi[idx_array] += String.format("%.4f",array_jawaban[i][j])+alphabet[j-1]; 
                        }
                        else if(array_jawaban[i][j] > 0){
                            System.out.print("+"+String.format("%.4f",array_jawaban[i][j])+alphabet[j-1]);
                            array_solusi[idx_array] += "+"+String.format("%.4f",array_jawaban[i][j])+alphabet[j-1]; 
                        }
                        else if(array_jawaban[i][j]<0){
                            System.out.print(String.format("%.4f",array_jawaban[i][j])+alphabet[j-1]);
                            array_solusi[idx_array] += String.format("%.4f",array_jawaban[i][j])+alphabet[j-1];
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
            int i;
            for(i=m.row-1;i>=0;i--){
                solusi[i] = m.getELMT(i, m.collumns-1);
            }
            System.out.println("Berikut solusi dari SPL :");
            array_solusi[idx_array] += "Berikut solusi dari SPL :\n";
            for(i=0;i<m.row;i++){
                System.out.println("x" + i + " = " + String.format("%.4f",solusi[i]));
                array_solusi[idx_array] += "x" + i + " = " + String.format("%.4f",solusi[i])+"\n";
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
    public static void Inverse(Matrix m, String[] array_solusi, int idx_array) {
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
                Inverse.Inverse_matrix_reduksi(mSPL, false, pp, 0);
                solusi_spl = Matrix.multiplyMatrix(mSPL, mJwb);
            }
        } else {
            System.out.println("SPL tidak dapat diselesaikan menggunakan metode inverse");
        }
    }

    // Metode Cramer
    public static void Cramer(Matrix m, String[] array_solusi, int idx_array) {
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
    public static double[][] getJawabanSPL2(Matrix m){
        double[][] baris_ket = new double[m.collumns-1][m.collumns];
        int i,j;
        int nullity = 0;
        int var = 2;
        int pointer_parametrik = 1;

        for(i=0;i<baris_ket.length;i++){
            for(j=0;j<baris_ket[0].length;j++){
                baris_ket[i][j] = 0;
            }
        }
        for(i=0;i<baris_ket.length;i++){
            for(j=0;j<baris_ket[0].length;j++){
                if(m.getELMT(i, j) == 1){
                    nullity++;
                    break;
                }
            }
        }

        nullity = m.row - nullity;
        for(i=m.row-1;i>=0;i--){
            int leading_one = -1;
            for(j=0;j<m.collumns-1;j++){
                if(m.getELMT(i, j) == 1){
                    leading_one = j;
                    break;
                }
            }
            if(leading_one == -1){
                continue;
            }
            else{
                if(m.collumns - leading_one == var){
                    var++;
                    continue;
                } else {
                    int k;
                    for(k=leading_one+1;k<=m.collumns-var;k++){
                        baris_ket[k][pointer_parametrik] = 1;
                        pointer_parametrik++;
                    }
                    var = m.collumns - leading_one + 1;
                }
            }
            i = 0;
            for(i=m.row-1;i>=0;i--){
                if(m.isRowZero(i, m.collumns-1)){
                    continue;
                }else{
                    for(j=0;j<m.collumns-1;j++){
                        if(m.getELMT(i, j)==1){
                            leading_one = j;
                            break;
                        }
                    }
                    baris_ket[leading_one][0] = m.getELMT(i, m.collumns-1);
                    continue;
                }
            }
            for(i=m.row-1;i>=0;i--){
                if(m.isRowZero(i, m.collumns-1)){
                    continue;
                }else{
                    for(j=0;j<m.collumns-1;j++){
                        if(m.getELMT(i, j)==1){
                            leading_one = j;
                            break;
                        }
                    }
                    for(j=leading_one+1;j<m.collumns-1;j++){
                        Matrix.kurang_array(baris_ket[leading_one], Matrix.kali_array(baris_ket[j],m.getELMT(i, j)));
                    }
                }
            }
        }
        return baris_ket;
    }
}
    //----------------------------PENYELESAIAN PARAMETRIK----------------------------------//