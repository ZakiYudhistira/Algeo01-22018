package Matrix;
// Library matrix berisikan primitif-primitif matrix dan type matrix

public class Matrix {
    public double[][] data;
    public int row;
    public int collumns;
    
    //-----------------------------KONSTRUKTOR & SELEKTOR---------------------------------//
    public Matrix(double[][] matriks, int row_input, int collumn_input){ // konstruktor Matrix
        this.data = matriks;
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
                    System.out.print(String.format("%.4f",this.getELMT(i, j)));
                }
                else {
                    System.out.print(" "+ String.format("%.4f",this.getELMT(i, j)));       
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

    public void divideBaris(int row, double pembagi){
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

    public static Matrix addRow(Matrix m, boolean under) {
        double[][] data_temp = new double[m.row+1][m.collumns];
        Matrix mtemp = new Matrix(data_temp, m.row+1, m.collumns);
        int i, j;
        if (under) {
            for (i=0; i<m.row+1; i++) {
                for (j=0; j<m.collumns; j++) {
                    if (i<m.row) {
                        mtemp.setELMT(i, j, m.getELMT(i, j));
                    } else {
                        mtemp.setELMT(i, j, 0);
                    }
                }
            }
        } else {
            for (i=0; i<m.row+1; i++) {
                for (j=0; j<m.collumns; j++) {
                    if (i>0) {
                        mtemp.setELMT(i, j, m.getELMT(i, j));
                    } else {
                        mtemp.setELMT(i, j, 0);
                    }
                }
            }
        }
        return mtemp;
    }
    
    public static Matrix addCol(Matrix m, boolean right) {
        double[][] data_temp = new double[m.row][m.collumns+1];
        Matrix mtemp = new Matrix(data_temp, m.row, m.collumns+1);
        int i, j;
        if (right) {
            for (i=0; i<m.row; i++) {
                for (j=0; j<m.collumns+1; j++) {
                    if (i<m.collumns) {
                        mtemp.setELMT(i, j, m.getELMT(i, j));
                    } else {
                        mtemp.setELMT(i, j, 0);
                    }
                }
            }
        } else {
            for (i=0; i<m.row; i++) {
                for (j=0; j<m.collumns+1; j++) {
                    if (i>0) {
                        mtemp.setELMT(i, j, m.getELMT(i, j));
                    } else {
                        mtemp.setELMT(i, j, 0);
                    }
                }
            }
        }
        return mtemp;
    }
    
    public void divideByPivot(){
        int i,j;
        for(i=0;i<this.row;i++){
            for(j=0;j<this.collumns;j++){
                if(this.getELMT(i, j) > Math.pow(10,-6) || this.getELMT(i, j)< -Math.pow(10,-6)){
                    this.divideBaris(i, this.getELMT(i, j));
                    break;
                }
            }
        }
    }

    //--------------------------------PERHITUNGAN REDUKSI ESELON------------------------------------//
    
    public void p_reduksi_eselon(boolean btm){ // ini kaga ngereturn value
        if(btm){
            int i=0,j=0,i_pivot=0,j_pivot=0, k;
            while(i<this.collumns-1 && j<this.row){
                i_pivot = i;
                j_pivot = j;
                k=1;
                // System.out.println(this.getELMT(j_pivot, i_pivot));
                while(this.getELMT(j_pivot, i_pivot)==0 && j_pivot + k < this.row){
                    this.tukar_baris(j_pivot, j_pivot+k);
                    // System.out.println("swap "+(j_pivot) +" "+(i_pivot));
                    // m.display();
                    // System.out.println("");
                    k++;
                }
                if(this.getELMT(j_pivot, i_pivot)==0){
                    // System.out.println("No pivot " +(j_pivot)+" "+(i_pivot));
                    i++;
                }
                else{
                    // System.out.println("VV pivot " +(j_pivot)+" "+(i_pivot) +" "+m.getELMT(j_pivot, i_pivot));
                    int g;
                    for(g=j_pivot+1;g<this.row;g++){
                        this.subtract_baris(g, j_pivot, this.getELMT(g,i_pivot)/this.getELMT(j_pivot, i_pivot));
                    }
                    i++;
                    j++;
                }
                // m.display();
                // System.out.println("");    
            }
        }
        else{
            int i,j,i_p=0,j_p=0, k=1;
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
                    // this.display();
                    // System.out.print("\n");
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

    public static int countRowNotZero(Matrix m, int row){
        int i, count = 0;
        for(i=0;i<m.collumns;i++){
            if(m.getELMT(row, i) != 0){
                count++;
            }
        }
        return count;
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

    public static String MatrixtoString(Matrix m){
        String hasil = "";
        int i,j;
        for(i=0;i<m.row;i++){
            for(j=0;j<m.collumns;j++){
                if(j==0){
                    hasil += String.format("%.4f",m.getELMT(i, j));
                }
                else{
                    hasil += " "+String.format("%.4f",m.getELMT(i, j));
                }
            }
            hasil += "\n";
        }
        return hasil;
    }

    public static void splitAugmentMtx(Matrix mAug, Matrix mSPL, Matrix mJwb) {
        // mAug berukuran mxn, mSPL berukuran mxn-1, mJwb berukuran mx1
        int i, j;
        for (i=0; i<mAug.row; i++) {
            for (j=0; j<mAug.collumns; j++) {
                if (j == mAug.collumns-1) {
                    mJwb.setELMT(i, 0, mAug.getELMT(i, j));
                } else {
                    mSPL.setELMT(i, j, mAug.getELMT(i, j));
                }
            }
        }
    }

    public static void splitDataAndApprox(Matrix mAwal, Matrix mData, Matrix mApprox) {
        // mAwal berukuran mxn, mData berukuran m-1xn, mApprox berukuran n-1x1
        int i, j;
        for (i=0; i<mAwal.row; i++) {
            for (j=0; j<mAwal.collumns; j++) {
                if (i == mAwal.row-1) {
                    if (j != mAwal.collumns-1) {
                        mApprox.setELMT(j, 0, mAwal.getELMT(i, j));
                    }
                } else {
                    mData.setELMT(i, j, mAwal.getELMT(i, j));
                }
            }
        }
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
                }
            }
        }

        return m3;
    }

    public static double sumColumnWithOp(Matrix m, int col1, int col2) {
        double sum = 0;
        int i;
        for (i=0; i<m.row; i++) {
            sum += (m.getELMT(i, col1)*m.getELMT(i, col2));
        }

        return sum;
    }

    public static double sumColumnWithoutOP(Matrix m, int col) {
        double sum = 0;
        int i;
        for (i=0; i<m.row; i++) {
            sum += (m.getELMT(i, col));
        }

        return sum;
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