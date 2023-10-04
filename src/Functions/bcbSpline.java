package Functions;
import Matrix.Matrix;

public class bcbSpline {
    public static void Interpolasi_bcb(Matrix fxy, Matrix xy, String [] array_solusi, int idx_array){
        double count = 0;
        array_solusi[idx_array] += "Masukkan matriks 4x4 :\n";
        array_solusi[idx_array] += Matrix.MatrixtoString(fxy);
        array_solusi[idx_array] += "Masukkan nilai x,y yang ingin ditaksir\n";
        array_solusi[idx_array] += "x : "+xy.getELMT(0, 0)+"\n";
        array_solusi[idx_array] += "y : "+xy.getELMT(0, 1)+"\n";
        double [][] X = {{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0},{1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,0},
        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},{0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,1,2,3,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0},{0,1,2,3,0,1,2,3,0,1,2,3,0,1,2,3,0},{0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,1,1,1,1,0,0,0,0,0,0,0,0,0},{0,0,0,0,1,0,0,0,2,0,0,0,3,0,0,0,0},{0,0,0,0,1,1,1,1,2,2,2,2,3,3,3,3,0},
        {0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,1,2,3,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,1,0,0,0,2,0,0,0,3,0,0,0},
        {0,0,0,0,0,1,2,3,0,2,4,6,0,3,6,9,0}};
        Matrix Xmatrix = new Matrix(X, 16, 17);
        int k=0;
        for (int i=0; i<fxy.row; i++){// bentuk matrix y = Xa
            for (int j=0; j<fxy.row; j++){
                Xmatrix.setELMT(k, Xmatrix.collumns-1, fxy.getELMT(i, j));
                k++;
            }
        }
        // Matrix Dmatrix = new Matrix(null, 0, 0);
        // Dmatrix = Xmatrix;
        // Dmatrix.p_reduksi_eselon(true);
        // array_solusi[idx_array] += Matrix.MatrixtoString(Dmatrix);
        int h=0;
        for (int y=0; y<4; y++){ 
            for (int x=0; x<4; x++){
                count += SPL.HitungSPL(Xmatrix)[h]*PangkatN(xy.getELMT(0, 0), x)*PangkatN(xy.getELMT(0, 1), y);
                h++;
            }
        }
        System.out.println("f("+xy.getELMT(0, 0)+","+xy.getELMT(0, 1)+") = "+count);
        array_solusi[idx_array] += ("f("+xy.getELMT(0, 0)+","+xy.getELMT(0, 1)+") = "+count+"\n");
    }

    public static double PangkatN(double a, int b){
        double result = 1;
        for (int i=0; i<b; i++){
            result *= a;
        }
        return result;
    }
}
