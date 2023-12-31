package Functions;
import Matrix.Matrix;

public class Regresi {
    public static Matrix solusi_regresi;
    public static double hasil_taksir;

    public static Matrix normalEstEq(Matrix m) {
        double[][] data_hasil = new double[m.collumns][m.collumns+1];
        Matrix mnew = new Matrix(data_hasil, m.collumns, m.collumns+1);

        int i, j;
        for (i=0; i<mnew.row; i++) {
            for (j=0; j<mnew.collumns; j++) {
                if (i==0 && j==0) {
                    mnew.setELMT(i, j, (double) m.row);
                } else if (i==0 && j!= 0) {
                    mnew.setELMT(i, j, Matrix.sumColumnWithoutOP(m, j-1));
                } else if (i!=0 && j==0) {
                    mnew.setELMT(i, j, mnew.getELMT(j, i));
                } else {
                    mnew.setELMT(i, j, Matrix.sumColumnWithOp(m, i-1, j-1));
                }
            }
        }

        return mnew;
    }

    public static void solusiRegresi(Matrix mUtama, Matrix mTaksir, String [] array_solusi, int idx_array) {
        double[][] reg_data = new double[mUtama.collumns][mUtama.collumns+1];
        Matrix mReg = new Matrix(reg_data, mUtama.collumns, mUtama.collumns+1);

        mReg = normalEstEq(mUtama);
        SPL.Inverse(mReg, false, array_solusi, idx_array);
        solusi_regresi = SPL.solusi_spl;

        hasil_taksir = solusi_regresi.getELMT(0, 0);
        int i;
        for (i=1; i<solusi_regresi.row; i++) {
            hasil_taksir += solusi_regresi.getELMT(i, 0)*mTaksir.getELMT(i-1, 0);
        }
        printHasil(mTaksir, array_solusi, idx_array);
    }

    public static void printHasil(Matrix m, String [] array_solusi, int idx_array) {
        System.out.println("Berikut adalah hasil kalkulasi regresi linier berganda dari data yang diberikan:");
        array_solusi[idx_array] += "Berikut adalah hasil kalkulasi regresi linier berganda dari data yang diberikan:";
        System.out.print("f(x) = ");
        array_solusi[idx_array] += "f(x) = ";
        int i;
        for (i=0; i<solusi_regresi.row; i++) {
            if (i==0) {
                System.out.print(String.format("%.4f", solusi_regresi.getELMT(i, 0)));
                array_solusi[idx_array] += String.format("%.4f", solusi_regresi.getELMT(i, 0));
            } else {
                System.out.print(" + " + String.format("%.4f", solusi_regresi.getELMT(i, 0)) + "b" + (i-1));
                array_solusi[idx_array] += " + " + String.format("%.4f", solusi_regresi.getELMT(i, 0)) + "b" + (i-1);
            }
        }
        System.out.print("\n");
        System.out.println("Sedangkan hasil taksiran nilai yang dicari adalah :");
        System.out.print("f(");
        array_solusi[idx_array] += "\nSedangkan hasil taksiran nilai yang dicari adalah :\nf(";
        for (i=0; i<m.row; i++) {
            if (i==0) {
                System.out.print(m.getELMT(i, 0));
                array_solusi[idx_array] += m.getELMT(i, 0);
            } else {
                System.out.print(", " + m.getELMT(i, 0));
                array_solusi[idx_array] += ", " + m.getELMT(i, 0);
            }
        }
        System.out.println(") = " + hasil_taksir);
        array_solusi[idx_array] += ") = " + hasil_taksir;
    }
}
