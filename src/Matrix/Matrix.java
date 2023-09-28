package Matrix;
// Library matrix berisikan primitif-primitif matrix dan type matrix

public class Matrix {
    public double[][] data;
    public int row;
    public int collumns;
    
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

    public boolean isRowZero(int row,int batas_collumn){
        int i;
        for(i=0;i<=batas_collumn;i++){
            if(getELMT(row, i)!=0){
                return false;
            }
        }
        return true;
    }

    public boolean isCollumnZero(int collumn){
        int i;
        for(i=0;i<this.row;i++){
            if(this.getELMT(i, collumn)!=0){
                return false;
            }
        }
        return true;
    }

    public static boolean isMatrixZero(Matrix m) {
        boolean allZero = true;
        for (int i=0; i<m.row; i++) {
            if (m.getELMT(i, 0) != 0) {
                allZero = false;
            }
        }
        return allZero;
    }

    public boolean isAllRowNotZero(){
        int i;
        for(i=0;i<this.row;i++){
            if(this.isRowZero(i,this.collumns-1)){
                return false;
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

    public void multiplyByConst(double val){
        Matrix temp = new Matrix(this.data, this.row, this.collumns);
        for (int i=0; i<this.row; i++){
            for (int j=0; j<this.collumns; j++)
            temp.setELMT(i, j, val * temp.getELMT(i, j));
        }
        set_collumns(this, temp.collumns);
        set_row(this, temp.row);
        set_data(this, temp.data);
    }

    public void subtract_baris(int row1, int row2, double factor){
        if(isRowIndexValid(this, row1) && isRowIndexValid(this, row2)){
            int i;
            for(i=0;i<this.collumns;i++){
                setELMT(row1, i, this.getELMT(row1, i) - this.getELMT(row2, i)*factor);
            }
        }
    }

    public void divide_baris(int row, double pembagi){
        if(isRowIndexValid(this, row) & pembagi != 0){
            int i;
            for(i=0;i<this.collumns;i++){
                setELMT(row, i, this.getELMT(row, i)/pembagi);
            }
        }
    }

    public void tukar_baris(int row1, int row2){ //menukar row1 dan row2
        Matrix temp;
        temp = this.copyMatrix();
        int i,j;
        for(i=0;i<this.row;i++){
            for(j=0;j<this.collumns;j++){
                if(i == row1){
                    this.setELMT(i, j, temp.getELMT(row2, j));
                }
                else if(i == row2){
                    this.setELMT(i, j, temp.getELMT(row1, j));
                }
            }
        }
    }

    public void removeCollumn(int collumn){
        double[][] isi_baru = new double[this.row][this.collumns-1];
        if(this.collumns == 1 || collumn >= this.collumns || collumn<0){
            System.out.println("Tidak bisa menghapus row.");
        }
        else{
            int i,j;
            for(i=0;i<this.row;i++){
                for(j=0;j<this.collumns-1;j++){
                    if(j>=collumn){
                        isi_baru[i][j] = this.getELMT(i, j+1);
                    }
                    else{
                        isi_baru[i][j] = this.getELMT(i,j);
                    }
                }
            }
        }
        set_collumns(this, this.collumns-1);
        set_data(this, isi_baru);
    }

    public void removeZeroCollumn(){
        int i=0;
        while(i<this.collumns){
            if(this.isCollumnZero(i)){
                this.removeCollumn(i);
            }
            i++;
        }
    }

    public void normalize(){
        if(this.collumns != this.row+1){
            double[][] data_0 = new double[this.collumns-1][this.collumns];
            int i,j;
            for(i=0;i<this.collumns-1;i++){
                for(j=0;j<this.collumns;j++){
                    if(i<=this.row-1){
                        data_0[i][j] = this.getELMT(i, j);
                    }
                    else{
                        data_0[i][j] = 0;
                    } 
                }
            }
            set_data(this, data_0);
            set_row(this, this.collumns-1);
        }
    }


    //--------------------------------PERHITUNGAN REDUKSI ESELON------------------------------------//

    public void p_reduksi_eselon(boolean btm){ // ini kaga ngereturn value
        int k =1;
        this.removeZeroCollumn();
        if(btm){
            int i,j,i_p=0,j_p=0;
            for(i=0;i<this.collumns;i++){
                for(j=i;j<this.row;j++){
                    if(i==j){
                        i_p = i;
                        j_p = j;
                    }
                    else{
                        while(this.getELMT(i_p, j_p)==0 && i_p + k < this.row){
                            tukar_baris(j_p, j_p+1);
                            k++;
                        }
                        k=1;
                        if(this.getELMT(i_p, j_p)==0){
                            break;
                        }
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
                        while(this.getELMT(i_p, j_p)==0 && i_p + k < this.row){
                            tukar_baris(j_p, j_p+1);
                            k++;
                        }
                        k=1;
                        if(this.getELMT(i_p, j_p)==0){
                            break;
                        }
                        this.subtract_baris(j, i, this.getELMT(j,i)/this.getELMT(j_p, i_p));
                        if(this.isRowZero(j,this.collumns-1)){
                            break;
                        }
                        
                    }
                    this.display();
                    System.out.print("\n");
                }
            }   
        }
    }

    //--------------------------------PERHITUNGAN DETERMINAN------------------------------------//
    public static double getDeterminanReduksi(Matrix m){
        double determinan;
        determinan = 1;
        Matrix temp;
        temp = m.copyMatrix();
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
        if (m.collumns==2 && m.row==2){ //basis
            return((double)((m.getELMT(0, 0))*(m.getELMT(1, 1)))-((m.getELMT(0, 1))*(m.getELMT(1, 0))));
        } else {
            for (int i=0; i<m.row; i++){ //konversi bentuk kofaktor -> matriks kofaktor
                double[][] data = new double[m.collumns-1][m.row-1];
                Matrix mr = new Matrix(data, m.row-1, m.collumns-1);
                for (int j=1; j<m.collumns; j++){
                    int l=0;
                    for (int k=0; k<m.row; k++){
                        if (k!=i){
                            mr.setELMT(j-1, l, m.getELMT(j, k));
                            l++;
                        }
                    }
                }
                if (i% 2 != 0){ // rekurens
                    determinan += (-1) * m.getELMT(0,i) * getDeterminanKofaktor(mr);
                } else {
                    determinan += m.getELMT(0,i) * getDeterminanKofaktor(mr);
                }
            }
        }
        return determinan;
    }

    //--------------------------------LAIN - LAIN------------------------------------//
    public static Matrix createIdentity(int n){
        double[][] data = new double[n][n];
        Matrix hasil = new Matrix(data, n, n);
        int i,j;
        for(i=0;i<hasil.row;i++){
            for(j=0;j<hasil.collumns;j++){
                if(i==j){
                    hasil.setELMT(i, j, 1);
                }
                else{
                    hasil.setELMT(i, j, 0);
                }
            }
        }
        return hasil;
    }

    public void divideBaris(){
        int i;
        for(i=0;i<this.row;i++){
            divide_baris(i, this.getELMT(i, i));
        }
    }

    public Matrix copyMatrix(){
        double[][] data_hasil = new double[this.row][this.collumns];
        Matrix hasil = new Matrix(data_hasil, this.row, this.collumns);
        int i,j;
        for(i=0;i<hasil.row;i++){
            for(j=0;j<hasil.collumns;j++){
                hasil.setELMT(i, j, this.getELMT(i, j));
            }
        }
        return hasil;
    }

    //-----------------------------------OPERASI MATRIKS------------------------------------//
    public static Matrix multiplyMatrix(Matrix m1, Matrix m2) {
        double[][] data_hasil = new double[m1.row][m2.collumns];
        Matrix m3 = new Matrix(data_hasil, m1.row, m2.collumns);

        int i, j, k;
        for (i=0; i<m3.row; i++) {
            for (j=0; j<m3.collumns; j++) {
                m3.setELMT(i, j, 0);
            }
        }

        double val;
        for (i=0; i<m1.row; i++) {
            for (j=0; j<m2.collumns; j++) {
                for (k=0; k<m2.row; k++) {
                    val = m1.getELMT(i, k)*m2.getELMT(k, j);
                    m3.setELMT(i, j, m3.getELMT(i, j)+val);
                }
            }
        }

        return m3;
    }

    public static Matrix gantiKolom(Matrix m1, Matrix m2, int col) {
        // ukuran m1 = axb dan ukuran m2 = ax1, menggantikan nilai pada satu kolom col[0..b-1]
        double[][] data_hasil = new double[m1.row][m1.collumns];
        Matrix m3 = new Matrix(data_hasil, m1.row, m1.collumns);

        m3 = m1.copyMatrix();

        int i, j;
        for (i=0; i<m1.row; i++) {
            for (j=0; j<m1.collumns; j++) {
                if (j==col) {
                    m3.setELMT(i, j, m2.getELMT(i, 0));
                    m3.display();
                }
            }
        }

        return m3;
    }

    //-----------------------------------OPERASI ARRAY------------------------------------//
    public static double[] kali_array(double[] array, double faktor){
        int i;
        double array_baru[] = new double[array.length];
        for(i=0;i<array.length;i++){
            array_baru[i] = array[i]*faktor;
        }
        return array_baru;
    }

    public static void kurang_array(double[] array1, double[] array2){
        int i;
        for(i=0;i<array1.length;i++){
            array1[i] -= array2[i];
        }
    }
}