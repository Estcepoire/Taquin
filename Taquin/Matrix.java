
import java.util.Random;
import java.util.Vector;

public class Matrix {
    int[][] matrix;
    Matrix predecesseurMatrix;
    int ligne;
    int colonne;
    String moov;

    public int[][] getMatrix() {
        return matrix;
    }
    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public Matrix getPredecesseurMatrix() {
        return predecesseurMatrix;
    }
    public void setPredecesseurMatrix(Matrix predecesseurMatrix) {
        this.predecesseurMatrix = predecesseurMatrix;
    }

    public Matrix(int[][] matrix,Matrix predeceMatrix) {
        this.setMatrix(matrix);
        this.setPredecesseurMatrix(predeceMatrix);

    }
    public String getMoov() {
        return moov;
    }
    public void setMoov(String moov) {
        this.moov = moov;
    }
    
    
    
    public void noneIndex() {
        for (int i = 0; i < this.getMatrix().length; i++) {
            for (int j = 0; j < this.getMatrix()[i].length; j++) {
                if (this.getMatrix()[i][j] == 0) {
                    this.ligne=i;
                    this.colonne=j;
                    break;
                }
            }
        }
    }
    public static int[][] copy(int[][] matrix) {
        int[][] copy = new int[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                copy[i][j]=matrix[i][j];
            }
        }
        return copy;
    }
    public Matrix position(int i1,int j1) {
        int[][] position = Matrix.copy(this.getMatrix());
        int vali = position[this.ligne][this.colonne];
        position[this.ligne][this.colonne]=position[i1][j1];
        position[i1][j1]=vali;
        Matrix c = new Matrix(position,this);
        return c;
    }
    public Vector<Matrix> childvector() {
        Vector<Matrix> Child = new Vector<Matrix>();
        int i1 = ligne+1; 
        int i2 = ligne-1; 
        int j1 = colonne+1; 
        int j2 = colonne-1; 
        if (i1 < matrix.length ) {
            Matrix temp1 = this.position(i1, colonne);
            temp1.setMoov("midina");
            Child.add(temp1);
        }if (i2 >= 0) {
            Matrix temp2 = this.position(i2, colonne);
            temp2.setMoov("miakatra");
            Child.add(temp2);
        }if (j1 < matrix[0].length) {
            Matrix temp3 = this.position(ligne, j1);
            temp3.setMoov("droite");
            Child.add(temp3);
        }if (j2 >= 0) {
            Matrix temp4 = this.position( ligne, j2);
            temp4.setMoov("gauche");
            Child.add(temp4);
        }
        return Child;
    }

    public Vector<Matrix> getChild() {
        Vector<Matrix> childVector = new Vector<Matrix>();
        this.noneIndex();
        childVector = this.childvector();
        return childVector;
    }

    public void print() {
        for (int[] is : this.matrix) {
            for (int i : is) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}