package Functions;
import Matrix.Matrix;

public class Inverse {
    public static void Inverse_matrix_reduksi(Matrix m, boolean utama, String[] array_solusi, int idx_array){
        boolean inversable = true;
        if (utama) {
            System.out.println("Menghitung inverse matriks dengan reduksi baris.");
            array_solusi[idx_array] += "Menghitung inverse matriks dengan reduksi baris.\n";
            array_solusi[idx_array] += Matrix.MatrixtoString(m);
        }
        while(true){
            if(m.isPersegi()){
                double[][] data_temp = new double[m.row][m.collumns*2];
                Matrix identity;
                Matrix temp = new Matrix(data_temp, m.row, m.collumns*2);
                identity = Matrix.createIdentity(m.row);
                int i,j;
                for(i=0;i<m.row;i++){
                    for(j=0;j<m.collumns;j++){
                        temp.setELMT(i, j, m.getELMT(i, j));
                        temp.setELMT(i, j+m.collumns, identity.getELMT(i, j));
                    }
                }
                temp.p_reduksi_eselon(true);
                temp.p_reduksi_eselon(false);
                temp.divideByPivot();
                for(i=0;i<temp.row;i++){
                    if(temp.isRowZero(i, m.row-1)){
                        if (utama) {
                            System.out.println("Matriks tidak memiliki inverse.");
                            array_solusi[idx_array] += "Matriks tidak memiliki inverse.\n";
                        }
                        inversable = false;
                        break;
                    }
                }
                if (inversable){
                    for(i=0;i<m.row;i++){
                        for(j=0;j<m.collumns;j++){
                            m.setELMT(i, j, temp.getELMT(i, j+m.collumns));
                        }
                    }
                    if (utama) {
                        System.out.println("Berikut hasil matriks balikan : ");
                        m.display();
                        array_solusi[idx_array] += "--------\n";
                        array_solusi[idx_array] += "Berikut hasil matriks balikan :\n";
                        array_solusi[idx_array] += Matrix.MatrixtoString(m);
                    }
                }
                break;
            }
            else{
                System.out.println("Matriks tidak memiliki inverse.");
                array_solusi[idx_array] += "Matriks tidak memiliki inverse.\n";
                break;
            }
        }
    }
    
    public static Matrix adjoint(Matrix m){
        double [][] data = new double[m.row][m.collumns];
        Matrix mtest = new Matrix(data, m.row, m.collumns);
        for (int i=0; i<m.row; i++){
            for (int j=0; j<m.collumns; j++){
                double [][] data2 = new double[m.row-1][m.collumns-1];
                Matrix mk = new Matrix(data2, m.row-1, m.collumns-1);
                int kp=0;
                for (int k=0; k<m.row; k++){
                    int lp=0;
                    for(int l=0; l<m.collumns; l++){
                        if (k!=i && l!=j){
                            mk.setELMT(kp, lp, m.getELMT(k, l));
                            lp++;
                        }
                    }
                    if(k!=i){
                        kp++;
                    }
                }
                if (i % 2 == 0 && j % 2 != 0){
                    mtest.setELMT(i, j, (-1) * Matrix.getDeterminanKofaktor(mk));
                } else if (i % 2 != 0 && j % 2 == 0){
                    mtest.setELMT(i, j, (-1) * Matrix.getDeterminanKofaktor(mk));
                } else {
                mtest.setELMT(i, j, Matrix.getDeterminanKofaktor(mk));
                }
            }
        }
        mtest.self_transpose();
        return mtest;
    }

    public static void Inverse_Kofaktor(Matrix m, String [] array_solusi, int idx_array){
        if (isInversible(m)){
            System.out.println("Menghitung inverse matriks dengan kofaktor.");
            array_solusi[idx_array] += "Menghitung inverse matriks dengan kofaktor.\n";
            array_solusi[idx_array] += Matrix.MatrixtoString(m);
            Matrix mI = new Matrix(null, 0, 0);
            mI = Inverse.adjoint(m);
            mI.multiplyByConst(1/Matrix.getDeterminanKofaktor(m));
            System.out.println("Berikut hasil matriks inverse balikan :");
            array_solusi[idx_array] += "Berikut hasil matriks inverse balikan :\n";
            array_solusi[idx_array] += Matrix.MatrixtoString(mI);
            mI.display();
        } else {
            System.out.println("Matriks tidak memiliki inverse.");
            array_solusi[idx_array] += "Matriks tidak memiliki inverse.\n";
        }
    }
    

    public static boolean isInversible(Matrix m) {
        return Matrix.getDeterminanReduksi(m) != 0;
    }
}