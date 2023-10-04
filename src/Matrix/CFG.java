// package Matrix;

// public class CFG {
//     public static void main(String args[]){
//         double[][] data1 =  {{1.0, 2.0, 3.0 ,4.0, 5.0 ,1.0},
//                                 {6.0, 7.0, 8.0, 9.0 ,1.0, 2.0},
//                                 {2.0, 3.0, 4.0, 5.0, 6.0, 3.0},
//                                 {7.0, 8.0, 9.0, 1.0, 2.0, 4.0},
//                                 {3.0, 4.0, 5.0, 6.0, 7.0, 5.0,}};
//         Matrix tes = new Matrix(data1, 1, 6);
//         tes.display();
//         tes.normalize();
//         System.out.println("");   
//         hitungSPL(tes);
//         tes.divideByPivot();
//         tes.display();
//         // System.out.println(getJawabanSPL2(tes));
//         // double[][] jawab = getJawabanSPL2(tes);
//         int i,j;
//         // System.out.println("");
//         // for(i=0;i<jawab.length;i++){
//         //     for(j=0;j<jawab[0].length;j++){
//         //         System.out.print(String.format("%.4f", jawab[i][j]) + " ");
//         //     }
//         //     System.out.println("");
//         }
//     }

//     // public static double[][] getJawabanSPL(Matrix m){
//     //     double[][] baris_ket = new double[m.row][m.collumns];
//     //     int i,j;
//     //     int jumlah_var = 1;
//     //     int leading_one = -1;
//     //     int pointer_parametrik = 1;
//     //     int pointer_array = m.collumns-1;

//     //     for(i=0;i<baris_ket.length;i++){
//     //         for(j=0;j<baris_ket[0].length;j++){
//     //             if(j==0){
//     //                 baris_ket[i][j] = m.getELMT(i, m.collumns-1);
//     //             }else{
//     //                 baris_ket[i][j] = 0;
//     //             }
//     //         }
//     //     }
//     //     for(i=m.row-1;i>=0;i--){
//     //         for(j=0;j<m.collumns;j++){
//     //             if(m.getELMT(i, j)==1){
//     //                 leading_one = j;
//     //                 break;
//     //             }
//     //         }
//     //         if(leading_one == -1){
//     //             continue;
//     //         }
//     //         System.out.println(leading_one + " Leading one");
//     //         if(m.collumns - leading_one -1 == jumlah_var){
//     //             System.out.println("if");
//     //             for(j=m.collumns-2;j>leading_one;j--){
//     //                 Matrix.kurang_array(baris_ket[i], Matrix.kali_array(baris_ket[j-1], m.getELMT(i, j)));
//     //                 System.out.println(i +" "+ j);
//     //             }
//     //             jumlah_var++;
//     //             continue;
//     //         }else if(m.collumns - leading_one - 1 > jumlah_var){
//     //             int selisih = m.collumns - leading_one - 1 - jumlah_var;
//     //             for(j=m.collumns-2;j>leading_one+selisih;j--){
//     //                 Matrix.kurang_array(baris_ket[i], Matrix.kali_array(baris_ket[j-1], m.getELMT(i, j)));
//     //                 System.out.println(i +" "+ j);
//     //             }
//     //             int k;
//     //             System.out.println(leading_one + " " + selisih +"ld");
//     //             boolean initiate = true;
//     //             for(k=leading_one+1;k<=leading_one+selisih;k++){
//     //                 if(initiate){
//     //                     baris_ket[pointer_array][i];
//     //                 }
//     //                 baris_ket[i][pointer_parametrik] = -m.getELMT(i, k);
//     //                 pointer_parametrik++;
//     //             }
//     //             continue;
//     //         }
//     //     }
//     //     return baris_ket;
//     // }

    

//     public static void hitungSPL(Matrix m){
//         int i=0,j=0,i_pivot=0,j_pivot=0, k;
//         while(i<m.collumns-1 && j<m.row){
//             i_pivot = i;
//             j_pivot = j;
//             k=1;
//             // System.out.println(m.getELMT(j_pivot, i_pivot));
//             while(m.getELMT(j_pivot, i_pivot)==0 && j_pivot + k < m.row){
//                 m.tukar_baris(j_pivot, j_pivot+k);
//                 // System.out.println("swap "+(j_pivot) +" "+(i_pivot));
//                 // m.display();
//                 // System.out.println("");
//                 k++;
//             }
//             if(m.getELMT(j_pivot, i_pivot)==0){
//                 // System.out.println("No pivot " +(j_pivot)+" "+(i_pivot));
//                 i++;
//             }
//             else{
//                 // System.out.println("VV pivot " +(j_pivot)+" "+(i_pivot) +" "+m.getELMT(j_pivot, i_pivot));
//                 int g;
//                 for(g=j_pivot+1;g<m.row;g++){
//                     m.subtract_baris(g, j_pivot, m.getELMT(g,i_pivot)/m.getELMT(j_pivot, i_pivot));
//                 }
//                 i++;
//                 j++;
//             }
//             // m.display();
//             // System.out.println("");    
//         }
//     }

//     // public static int getLeadingOne(Matrix m, int row){

//     // }
// }
