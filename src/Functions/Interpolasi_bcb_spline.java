package Functions;
import Matrix.Matrix;

public class Interpolasi_bcb_spline {
    public static void Interpolasi_bcb(Matrix fxy, Matrix xy){
        double count = 0;
        double [][] X = {{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0},{1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,0},
        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},{0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,1,2,3,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0},{0,1,2,3,0,1,2,3,0,1,2,3,0,1,2,3,0},{0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},
    {0,0,0,0,1,1,1,1,0,0,0,0,0,0,0,0,0},{0,0,0,0,1,0,0,0,2,0,0,0,3,0,0,0,0},{0,0,0,0,1,1,1,1,2,2,2,2,3,3,3,3,0},
{0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,1,2,3,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,1,0,0,0,2,0,0,0,3,0,0,0},
{0,0,0,0,0,1,2,3,0,2,4,6,0,3,6,9,0}};
        Matrix Xmatrix = new Matrix(X, 16, 17);
        int k=0;
        for (int i=0; i<fxy.row; i++){
            for (int j=0; j<fxy.row; j++){
                Xmatrix.setELMT(k, Xmatrix.collumns-1, fxy.getELMT(i, j));
                k++;
            }
        }
        int h=0;
        for (int y=0; y<4; y++){ 
            for (int x=0; x<4; x++){
                count += SPL.HitungSPL(Xmatrix)[h]*PangkatN(xy.getELMT(0, 0), x)*PangkatN(xy.getELMT(0, 1), y);
            }
        }
        System.out.println("f("+xy.getELMT(0, 0)+","+xy.getELMT(0, 1)+") = "+count);
    }

    public static double PangkatN(double a, int b){
        double result = 1;
        for (int i=0; i<b; i++){
            result *= a;
        }
        return result;
    }
}