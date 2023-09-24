package Matrix;
// Library matrix berisikan primitif-primitif matrix dan type matrix

import Functions.regresi;

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
                    if(getELMT(i, j) >=0){
                        System.out.print(" "+this.getELMT(i, j));
                    }
                    else{
                        System.out.print(this.getELMT(i, j));
                    }
                }
                else {
                    if(getELMT(i, j)>=0){
                        System.out.print("  "+this.getELMT(i, j));
                    }
                    else{
                        System.out.print(" "+this.getELMT(i, j));
                    }
                }
            }
            System.out.print("\n");
        }
    }
    //-----------------------------ERROR HANDLING (BOOLEAN)---------------------------------//
    public boolean isPersegi(){
        return this.row == this.collumns; // matriks.isPersegi() -> boolean
    }

    public boolean isValid(){
        return this.row == 0 || this.collumns == 0;
    }

    public static boolean isRowIndexValid(Matrix m, int row){
        return row<m.row && row >=0;
    }

    public static boolean isCollumnIndexValid(Matrix m, int collumn){
        return collumn<m.collumns && collumn >=0;
    }
    
    public static boolean isIndexValid(Matrix m, int row, int collumn){
        return isRowIndexValid(m, row) && isCollumnIndexValid(m, collumn);
    }

    public static boolean isRowZero(Matrix m, int row){
        int i;
        for(i=0;i<m.collumns;i++){
            if(m.getELMT(row, i)!=0){
                return false;
            }
        }
        return true;
    }

    public static boolean isIdentity(Matrix m){
        int i,j;
        for(i=0;i<m.row;i++){
            for(j=0;i<m.collumns;j++){
                if(i==j && m.getELMT(i, j) != 1){
                    return false;
                }
                else if(m.getELMT(i, j)!=0){
                    return false;
                }
            }
        }
        return true;
    }

    //--------------------------------MODIFIKASI MATRIKS------------------------------------//
    public static Matrix transpose(Matrix m){
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
    public void self_transpose(){
        Matrix temp = new Matrix(this.data, this.row, this.collumns);
        temp = transpose(temp);
        set_collumns(this, temp.collumns);
        set_row(this, temp.row);
        set_data(this, temp.data);
    }

    public void subtract_baris(int row1, int row2, double factor) // row1 - row2*factor
    {
        if(isRowIndexValid(this, row1) && isRowIndexValid(this, row2)){
            int i;
            for(i=0;i<this.collumns;i++){
                setELMT(row1, i, this.getELMT(row1, i) - this.getELMT(row2, i)*factor);
            }
        }
    }

    public void divide_baris(int row, double pembagi) // kalo mau ngali langsung aja pembagi nya pake pecahan
    {
        if(isRowIndexValid(this, row) & pembagi != 0){
            int i;
            for(i=0;i<this.collumns;i++){
                setELMT(row, i, this.getELMT(row, i)/pembagi);
            }
        }
    }

    //--------------------------------PERHITUNGAN REDUKSI ESELON------------------------------------//
    public Matrix reduksi_eselon(boolean btm) // ini ngereturn value
    {
        Matrix hasil = new Matrix(this.data, this.row, this.collumns);
        if(btm){
            int i,j,i_p=0,j_p=0;
            for(i=0;i<hasil.collumns;i++){
                for(j=i;j<hasil.row;j++){
                    if(i==j){
                        i_p = i;
                        j_p = j;
                    }
                    else{
                        hasil.subtract_baris(j, i, hasil.getELMT(j,i)/hasil.getELMT(j_p, i_p));
                    }
                }
            }
        }
        else{
            int i,j,i_p=0,j_p=0;
            int faktor_spl = hasil.collumns - hasil.row;
            for(i=hasil.collumns-1-faktor_spl;i>=0;i--){
                for(j=i;j>=0;j--){
                    if(i==j){
                        i_p = i;
                        j_p = j;
                    }
                    else{
                        hasil.subtract_baris(j, i, hasil.getELMT(j,i)/hasil.getELMT(j_p, i_p));
                        }
                    }   
                }
            }
        return hasil;
    }

    public void p_reduksi_eselon(boolean btm){ // ini kaga ngereturn value
        if(btm){
            int i,j,i_p=0,j_p=0;
            for(i=0;i<this.collumns;i++){
                for(j=i;j<this.row;j++){
                    if(i==j){
                        i_p = i;
                        j_p = j;
                    }
                    else{
                        this.subtract_baris(j, i, this.getELMT(j,i)/this.getELMT(j_p, i_p));
                    }
                    this.display();
                    System.out.print("\n");
                }
            }
        }
        else{
            int i,j,i_p=0,j_p=0;
            int faktor_spl = this.collumns - this.row;
            for(i=this.collumns-1-faktor_spl;i>=0;i--){
                for(j=i;j>=0;j--){
                    if(i==j){
                        i_p = i;
                        j_p = j;
                    }
                    else{
                        this.subtract_baris(j, i, this.getELMT(j,i)/this.getELMT(j_p, i_p));
                    }
                    this.display();
                    System.out.print("\n");
                }
            }   
        }
    }
    //--------------------------------PERHITUNGAN SPL------------------------------------//
    public static void hitungSPL(Matrix m, boolean Gauss){
        m.p_reduksi_eselon(true);
        boolean multiple_solutions = false;
        int i;
        for(i=0;i<m.row;i++){
            if(isRowZero(m, i)){
                multiple_solutions = true;
                break;
            }
        }
        if(m.getELMT(m.row-1,m.collumns-2)==0 && m.getELMT(m.row-1,m.collumns-1)!=0){
            System.out.println("SPL tidak memiliki solusi");
        }
        else if(multiple_solutions){
            System.out.println("SPL memiliki solusi banyak");
        }
        else{

        }
    }

    //--------------------------------PERHITUNGAN DETERMINAN------------------------------------//
    public static double getDeterminanReduksi(Matrix m){
        double determinan;
        determinan = 1;
        Matrix temp = new Matrix(null, 0, 0);
        temp = m;
        temp.p_reduksi_eselon(true);
        int i,j;
        for(i=0;i<temp.row;i++){
            for(j=0;j<temp.collumns;j++){
                if(i==j){
                    determinan = determinan * temp.getELMT(i,j);
                }
            }
        }
        return determinan;
    }

    public static double getDeterminanKofaktor(Matrix m){
        double determinan = 0;
        Matrix temp = new Matrix(null, 0, 0);
        temp = m;
        if (temp.collumns==2 && temp.row==2){ //basis
            return((double)((temp.getELMT(0, 0))*(temp.getELMT(1, 1)))-((temp.getELMT(0, 1))*(temp.getELMT(1, 0))));
        } else {
            for (int i=0; i<temp.row; i++){ //konversi bentuk kofaktor -> matriks kofaktor
                Matrix mr = new Matrix(null, 0, 0);
                for (int j=1; j<temp.collumns; j++){
                    int l=0;
                    for (int k=0; k<temp.row; k++){
                        mr = new Matrix(null, temp.row-1, temp.collumns-1);
                        if (k!=i){
                            mr.setELMT(j-1, l, mr.getELMT(j, k));
                            l++;
                        }
                    }
                }
                if (i%2!=0){ // rekurens
                    determinan += (-1) * mr.getELMT(0,i) * getDeterminanKofaktor(mr);
                } else {
                    determinan += mr.getELMT(0,i) * getDeterminanKofaktor(mr);
                }
            }
        }
        return determinan;
    }
}