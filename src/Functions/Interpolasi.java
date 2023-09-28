package Functions;
import Matrix.Matrix;

public class Interpolasi {
    public static double Interpolasi_Polinom(Matrix m, double val){
        double [][] data = new double[m.row][m.row+1];
        Matrix mp = new Matrix(data, m.row, m.row+1);
        for (int i=0; i<m.row; i++){// ngisi bagian augmented
            mp.setELMT(i, m.row, m.getELMT(i, 1));
        }
        for (int j=0; j<m.row; j++){// ngisi kolom pertama dengan 1
            mp.setELMT(j, 0, 1);
        }
        for (int k=1; k<m.row; k++){
            for (int l=0; l<m.row; l++){
                mp.setELMT(l, k, PangkatN(m.getELMT(l, 0),k));
            }
        }
        mp.display();
        double result = 0;
        for(int y=0; y<m.row; y++){
            result += SPL.HitungSPL(mp)[y]*PangkatN(val, y);
        }
        return result;
    }

    public static double PangkatN(double a, int b){
    double result = 1;
    for (int i=0; i<b; i++){
        result *= a;
    }
    return result;
}
}
