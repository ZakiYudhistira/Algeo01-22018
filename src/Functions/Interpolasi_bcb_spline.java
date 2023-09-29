package Functions;
import Matrix.Matrix;

public class Interpolasi_bcb_spline {
    public static void Interpolasi_bcb(Matrix fxy, Matrix xy){
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
        SPL.Gauss(Xmatrix);
        // Xmatrix.display();
        // SPL.HitungSPL(Xmatrix);
        // for (int y=0; y<16; k++){
        //     System.out.print("["+SPL.HitungSPL(Xmatrix)[y]+"]");
        // }
    }
}