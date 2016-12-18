/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xampp;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 *
 * @author Adithyaanirudhha
 */
public class Xampp implements ActionListener{
JTextField jt = new JTextField();
    
Xampp()
{
	int windowheight = 400;
	int windowwidth = 400;
JFrame.setDefaultLookAndFeelDecorated(true);
JFrame frame = new JFrame("XAMPP");
JButton b = new JButton("Submit");
b.setBounds(100,100,50,50);
frame.setBounds(0,0,400,400);
JPanel panel = new  JPanel();
frame.setLayout(new GridLayout(2,1));
frame.add(panel);
panel.setLayout(new GridLayout(2,2));
panel.add(new JLabel("User_name:"));
panel.add(jt);
panel.add(new JLabel("password:"));
panel.add(new JTextField());
frame.add(b);
b.addActionListener( this);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setVisible(true);
//frame.pack();
}  /**
     * @param args the command line arguments
     */
public void actionPerformed(ActionEvent ae)
    {
        //jt.setText("Hello");
        Pg2 view = new Pg2();
    }
    public static void main(String[] args)
    {
        // TODO code application logic here
        Xampp view = new Xampp();
    }
}
