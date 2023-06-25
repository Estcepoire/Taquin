import javax.swing.JFrame;
import javax.swing.JLabel;

public class Mafenetre extends JFrame {
    private JLabel label;
    public Mafenetre() {
        Menu menu = new Menu();
        setTitle("Taquin");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(menu);
        setVisible(true);
    }

    public static void main(String[] args) {
            Mafenetre fenetre = new Mafenetre();
    }
    
}
