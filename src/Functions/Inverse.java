package Functions;
import Matrix.Matrix;

public class Inverse {
    public static void Inverse_matrix_reduksi(Matrix m){
        boolean inversable = true;
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
                temp.divideBaris();
                for(i=0;i<temp.row;i++){
                    if(temp.isRowZero(i, m.row-1)){
                        System.out.println("Matriks tidak memiliki inverse.");
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
                }
                break;
            }
            else{
                System.out.println("Matriks tidak memiliki inverse.");
                break;
            }
        }
    }

    public static boolean isInversable(Matrix m) {
        boolean inversable = true;
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
                temp.divideBaris();
                for(i=0;i<temp.row;i++){
                    if(temp.isRowZero(i, m.row-1)){
                        inversable = false;
                        break;
                    }
                }
                break;
            }
            else{
                inversable = false;
                break;
            }
        }

        return inversable;
    }
}