import javax.swing.*;
import java.awt.*;
/**
 * Write a description of class ff here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class test
{
    private JFrame f;
    private JPanel p;
    private JButton b1;
    private JLabel lab;
    public void practice()
    {
        f = new JFrame("Steph Curry");
        f.setVisible(true);
        f.setSize(600,400);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        p = new JPanel();
        p.setBackground(Color.YELLOW);
        
        b1 = new JButton("Test");
        
        lab = new JLabel("This is a test");
        
        p.add(b1);
        p.add(lab);
        
        f.add(p);
    }
    public static void main(String args[])
    {
        new test();
    }
}
