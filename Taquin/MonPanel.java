import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Graphics;
import algo.Search;
import java.util.*;
import taquin.Matrix;

public class MonPanel extends JPanel {

    public Matrix matrix() {
        int[][] matrixMarina = {
            {1,2,3},
            {4,5,6},
            {7,8,0}
        };
        Matrix matrix = new Matrix(matrixMarina,null);
        return matrix;
    }
    public MonPanel(){
    }

    // public void print() {
    //     try {
    //         Thread.sleep(1000);
    //     } catch (Exception ce) {
    //         ce.printStackTrace();
    //     }
    //     int i= this.lalana.size()-1;
    //     if (i >= 0) {
    //         this.a  = lalana.get(i).getMatrix()[0][0];
    //         this.b  = lalana.get(i).getMatrix()[0][1];
    //         this.c  = lalana.get(i).getMatrix()[0][2];
    
    //         this.d  = lalana.get(i).getMatrix()[1][0];
    //         this.e  = lalana.get(i).getMatrix()[1][1];
    //         this.f  = lalana.get(i).getMatrix()[1][2];
            
    //         this.gg = lalana.get(i).getMatrix()[2][0];
    //         this.h  = lalana.get(i).getMatrix()[2][1];
    //         this.ic = lalana.get(i).getMatrix()[2][2];
            
    //         i-=1;
    //         lalana.get(i).print();
    //         System.out.println();
    //         System.out.println(i);
    //     }
    //     repaint();
    // }


        // public void paint(Graphics g) {
        //     super.paint(g);
        //     this.print();
        //     Font font = new Font("Arial", Font.BOLD, 24);
        //     g.setFont(font);
        //     g.drawString(" "+this.a, 50, 100);
        //     g.drawString(" "+this.b, 80, 100);
        //     g.drawString(" "+this.c, 110, 100);
        //     g.drawString(" "+this.d, 50, 150);
        //     g.drawString(" "+this.e, 80, 150);
        //     g.drawString(" "+this.f, 110, 150);
        //     g.drawString(" "+this.gg, 50, 200);
        //     g.drawString(" "+this.h, 80, 200);
        //     g.drawString(" "+this.ic, 110, 200);
        //     repaint();

        // }
    
}

