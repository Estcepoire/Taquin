// package algo;

import java.util.Arrays;
import java.util.*;
import java.util.Set;
import java.util.Vector;


public class Search {
    public int[][] valiny = {
        {1,2,3},
        {4,5,6},
        {7,8,0}
    };
    public String marina() {
        return Arrays.deepToString(this.valiny);
    }

    // public static int[] noneIndex(int[][] matrix) {
    //     int[] noneIndex = new int[2];
    //     for (int i = 0; i < matrix.length; i++) {
    //         for (int j = 0; j < matrix[i].length; j++) {
    //             if (matrix[i][j] == 0) {
    //                 noneIndex[0]=i;
    //                 noneIndex[1]=j;
    //                 break;
    //             }
    //         }
    //     }
    //     return noneIndex;
    // }
    // public static int[][] copy(int[][] matrix) {
    //     int[][] copy = new int[matrix.length][matrix.length];
    //     for (int i = 0; i < matrix.length; i++) {
    //         for (int j = 0; j < matrix[i].length; j++) {
    //             copy[i][j]=matrix[i][j];
    //         }
    //     }
    //     return copy;
    // }
    // public int[][] position(int[][]matrix,int i,int j,int i1,int j1) {
    //     int[][] position = Search.copy(matrix);
    //     int vali = position[i][j];
    //     position[i][j]=position[i1][j1];
    //     position[i1][j1]=vali;
    //     return position;
    // }
    // public Vector<int [][]> childvector(int[][]matrix,int i,int j) {
    //     Vector<int [][]> Child = new Vector<int [][]>();
    //     int i1 = i+1; 
    //     int i2 = i-1; 
    //     int j1 = j+1; 
    //     int j2 = j-1; 
    //     if (i1 < matrix.length ) {
    //         int [][] temp1 = this.position(matrix, i, j, i1, j);
    //         Child.add(temp1);
    //     }if (i2 >= 0) {
    //         int [][] temp2 = this.position(matrix, i, j, i2, j);
    //         Child.add(temp2);
    //     }if (j1 < matrix[0].length) {
    //         int [][] temp3 = this.position(matrix, i, j, i, j1);
    //         Child.add(temp3);
    //     }if (j2 >= 0) {
    //         int [][] temp4 = this.position(matrix, i, j, i, j2);
    //         Child.add(temp4);
    //     }
    //     return Child;
    // }

    // public Vector<int[][]> getChild(int[][] matrix) {
    //     Vector<int[][]> childVector = new Vector<>();
    //     int[] ij = Search.noneIndex(matrix);
    //     int i = ij[0];
    //     int j = ij[1];
    //     childVector = this.childvector(matrix, i, j);
    //     return childVector;
    // }
    
    // recherche par largeur
    // public int[][] recherche(int[][] matrix) {
    //     Vector<int[][]> pasEncoreVector = new Vector<>();
    //     Set<String> dejaVector = new HashSet<>();
    //     pasEncoreVector.add(matrix);

    //     while (pasEncoreVector.isEmpty()==false) {

    //         int[][] zao = pasEncoreVector.elementAt(0);
    //         pasEncoreVector.removeElement(zao);
    //         String zaoString=Arrays.deepToString(zao);
    //         if (zaoString.equals(this.marina())){
    //             System.out.println(zaoString);
    //             return zao;
    //         }
    //         if(dejaVector.contains(zaoString)) continue;
    //         Vector<int[][]> child = this.getChild(zao);

    //         dejaVector.add(zaoString);
    //         for (int index = 0; index < child.size(); index++) {
    //             String deja = Arrays.deepToString(child.elementAt(index));
    //             if(dejaVector.contains(deja) == false){
    //                 pasEncoreVector.add(child.elementAt(index));
    //             }
    //         }
    //     }
    //     System.out.println("fin");

    //     return null;
    // }
    public Matrix recherche(Matrix matrix) {
        Vector<Matrix> pasEncoreVector = new Vector<>();
        Set<String> dejaVector = new HashSet<>();
        pasEncoreVector.add(matrix);

        while (pasEncoreVector.isEmpty()==false) {

            Matrix zao = pasEncoreVector.elementAt(0);
            pasEncoreVector.removeElement(zao);
            String zaoString=Arrays.deepToString(zao.getMatrix());
            if (zaoString.equals(this.marina())){
                System.out.println(zaoString);
                System.out.println();
                return zao;
            }
            if(dejaVector.contains(zaoString)) continue;
            Vector<Matrix> child = zao.getChild();
            dejaVector.add(zaoString);
            for (int index = 0; index < child.size(); index++) {
                String deja = Arrays.deepToString(child.elementAt(index).getMatrix());
                if(dejaVector.contains(deja) == false){
                    pasEncoreVector.add(child.elementAt(index));
                }
            }
        }
        System.out.println("fin");

        return null;
    }
    public static void mixMatrix(Matrix matrix,int n) {
        Random random = new Random();
        Vector<Matrix> child = new Vector<>();
        for (int index = 0; index <= n; index++) {
            child = matrix.getChild();
            int randomInRange = random.nextInt(child.size());
            matrix.print();
            System.out.println(); 
            matrix=matrix.getChild().elementAt(randomInRange);
        }
    }
    public static void main(String[] args) {
        int[][] valiny = {
                {1,2,3},
                {4,5,6},
                {7,8,0}
        };
        Matrix matrix = new Matrix(valiny,null);
        Search.mixMatrix(matrix,10);
    }
    
}