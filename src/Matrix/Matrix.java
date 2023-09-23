package Matrix;
// Library matrix berisikan primitif-primitif matrix dan type matrix

public class Matrix {
    double[][] data;
    int row;
    int collumns;
    
    //-----------------------------KONSTRUKTOR & SELEKTOR---------------------------------//
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
    
    public void setELMT(int i, int j, double val){
        this.data[i][j] = val;
    }

    //-----------------------------FUNGSI DISPLAY---------------------------------//
    public void display(){ // buat print matriks pakenya matriks.print()
        int i,j;
        for(i=0;i<this.row;i++){
            for(j=0;j<this.collumns;j++){
                if(j==0) {
                    System.out.print(this.data[i][j]);
                }
                else {
                    System.out.print(" "+this.data[i][j]);
                }
            }
            System.out.print("\n");
        }
    }
    //-----------------------------ERROR HANDLING (BOOLEAN)---------------------------------//
    public boolean isPersegi()
    {
        return this.row == this.collumns; // matriks.isPersegi() -> boolean
    }

    public boolean isValid()
    {
        return this.row == 0 || this.collumns == 0;
    }

    //--------------------------------MODIFIKASI MATRIKS------------------------------------//
    public static Matrix transpose(Matrix m)
    {
        double[][] hasil_data = new double[m.collumns][m.row];
        Matrix hasil = new Matrix(hasil_data, m.collumns, m.row);
        int i,j;
        for(i=0;i<m.row;i++){
            for(j=0;j<m.collumns;j++){
                hasil.setELMT(j, i, m.getELMT(i, j));
            }
        }
        return hasil;
    }
}
