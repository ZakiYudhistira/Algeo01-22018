package Matrix;
import Matrix.Matrix;

public class CFG {
    public static void main(String args[]){
        double[][] data1 =  {{1.0, 2.0, 3.0 ,4.0, 5.0 ,1.0},
                                {6.0, 7.0, 8.0, 9.0 ,1.0, 2.0},
                                {2.0, 3.0, 4.0, 5.0, 6.0, 3.0},
                                {7.0, 8.0, 9.0, 1.0, 2.0, 4.0},
                                {3.0, 4.0, 5.0, 6.0, 7.0, 5.0,}};
        Matrix tes = new Matrix(data1, 5, 6);
        tes.display();
        System.out.println("");   
        hitungSPL(tes);
        tes.display();
    }

    public static void hitungSPL(Matrix m){
        int i=0,j=0,i_pivot=0,j_pivot=0, k;
        while(i<m.collumns-1 && j<m.row){
            i_pivot = i;
            j_pivot = j;
            k=1;
            // System.out.println(m.getELMT(j_pivot, i_pivot));
            while(m.getELMT(j_pivot, i_pivot)==0 && j_pivot + k < m.row){
                m.tukar_baris(j_pivot, j_pivot+k);
                // System.out.println("swap "+(j_pivot) +" "+(i_pivot));
                // m.display();
                // System.out.println("");
                k++;
            }
            if(m.getELMT(j_pivot, i_pivot)==0){
                // System.out.println("No pivot " +(j_pivot)+" "+(i_pivot));
                i++;
            }
            else{
                // System.out.println("VV pivot " +(j_pivot)+" "+(i_pivot) +" "+m.getELMT(j_pivot, i_pivot));
                int g;
                for(g=j_pivot+1;g<m.row;g++){
                    m.subtract_baris(g, j_pivot, m.getELMT(g,i_pivot)/m.getELMT(j_pivot, i_pivot));
                }
                i++;
                j++;
            }
            // m.display();
            // System.out.println("");    
        }
    }
}
