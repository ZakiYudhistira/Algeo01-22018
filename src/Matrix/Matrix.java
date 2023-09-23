package Matrix;
// Library matrix berisikan primitif-primitif matrix dan type matrix

public class Matrix {
    double[][] data;
    int row;
    int collumns;
    
    public Matrix(double[][] matriks, int row_input, int collumn_input){ // konstruktor Matrix
        set_data(this, matriks);
        set_row(this, row_input);
        set_collumns(this, collumn_input);
    }

    public static void set_data(Matrix m, double[][] matriks){ //buat set matriks ke tipe data Matrix
        m.data = matriks;
    }
    
    public static void set_row(Matrix m, int row){ // buat set row
        m.row = row;
    }

    public static void set_collumns(Matrix m, int collumns){ // buat set collumn
        m.collumns = collumns;
    }

    public double getELMT(int i, int j){ // buat nyari elemen
        return this.data[i][j];
    } 

    public void print(){ // buat print matriks
        int i,j;
        for(i=0;i<this.row;i++)
        {
            for(j=0;j<this.collumns;j++)
            {
                if(j==0) {
                    System.out.print(this.data[i][j]);
                }
                else {
                    System.out.println(" "+this.data[i][j]);
                }
            }
            System.out.print("\n");
        }
    }
}
