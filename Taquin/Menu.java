import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import javax.swing.JLabel;
import java.util.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;


/**
 * Menu
 */
public class Menu  extends JPanel{
    Matrix  Mymatrix;
    private Timer timer;
    boolean startmix=true;
    
    public Menu() {
        this.Mymatrix = this.matrix();
        // Creer les boutons

        // Bouton Melanger
        JButton button1 = new JButton("Melanger");
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mixMatrix();
            }
        });
        JButton button2 = new JButton("Resoudre");
        // Listener
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                solve();
            }
        });
        // 
        
        // Bouton Quitter
        JButton button3 = new JButton("Quitter");
        // Listener
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        // 
        // 
        
        this.add(button1);
        this.add(button2);
        this.add(button3);
    }

    public Vector<Matrix> solVectorM() {
        Mymatrix.print();
        Search s = new Search();
        Matrix vita = s.recherche(Mymatrix);
        Vector <Matrix> lalana = new Vector<Matrix>();
        while (vita !=null ) {
            lalana.add(vita);
            vita = vita.getPredecesseurMatrix();
        }
        Collections.reverse(lalana);
        // for (int index = 0; index < lalana.size(); index++) {
        //     lalana.get(index).print();
        //     System.out.println();
        // }
        return lalana;
    }

    // Listener solve
    private void solve() {
        // Mymatrix = matrix();
        Vector<Matrix> lalana = solVectorM();
        Mymatrix.print();
        String valinys =Arrays.deepToString(this.valiny);
        String m ="";
        ActionListener action = new ActionListener() {
            int count = 0;
            public void actionPerformed(ActionEvent e) {
                if ( count < lalana.size() && m.equals(valinys)==false) {
                    Mymatrix = lalana.elementAt(count);
                    repaint();
                    count++;
                    String m = Arrays.deepToString(Mymatrix.getMatrix());
                }
                else{
                    ((Timer) e.getSource()).stop();
                    startmix= false;
                }
            }
        };

        Timer timer = new Timer( 1000, action ); 
        timer.start(); 
    }
    //
    public void mixMatrix() {

        // this.Mymatrix = this.matrix();

        Random random = new Random();
        Vector<Matrix> child = new Vector<>();
        ActionListener action = new ActionListener() {
            int count = 10;
            public void actionPerformed(ActionEvent e) {
                if ( count > 0) {
                    Vector<Matrix> childs = Mymatrix.getChild();
                    int randomInRange = random.nextInt(childs.size());
                    Mymatrix = Mymatrix.getChild().elementAt(randomInRange);
                    repaint();
                    count--;
                }
                else{
                    ((Timer) e.getSource()).stop();
                }
            }
        };

        Timer timer = new Timer( 1000, action ); 
        timer.start();
    }
    // Matrix a resoudre
    public Matrix matrix() {
        int[][] mmatrix = {
            {1,2,3},
            {4,5,6},
            {7,8,0}
        };
        Matrix matrix = new Matrix(mmatrix,null);
        return matrix;
    }
    // 

    // resilu
    public int[][] valiny = {
        {1,2,3},
        {4,5,6},
        {7,8,0}
    };
    public String marina() {
        return Arrays.deepToString(this.valiny);
    }
    // 

    // dessin
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (startmix) {
            g.setColor(Color.BLACK);
            g.setFont(new Font("Arial", Font.BOLD, 20));
            g.drawString(String.valueOf(Mymatrix.getMatrix()[0][0]), 50,  100);
            g.drawString(String.valueOf(Mymatrix.getMatrix()[0][1]), 100, 100);
            g.drawString(String.valueOf(Mymatrix.getMatrix()[0][2]), 150, 100);

            g.drawString(String.valueOf(Mymatrix.getMatrix()[1][0]), 50,  150);
            g.drawString(String.valueOf(Mymatrix.getMatrix()[1][1]), 100, 150);
            g.drawString(String.valueOf(Mymatrix.getMatrix()[1][2]), 150, 150);

            g.drawString(String.valueOf(Mymatrix.getMatrix()[2][0]), 50,  200);
            g.drawString(String.valueOf(Mymatrix.getMatrix()[2][1]), 100, 200);
            g.drawString(String.valueOf(Mymatrix.getMatrix()[2][2]), 150, 200);
        }
    }
    // 
}